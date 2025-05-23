package com.tencent.mobileqq.filemanager.util;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/filemanager/util/FilePreviewDataReporter;", "", "", "filePath", "c", "", "e", WadlProxyConsts.PARAM_FILENAME, "", TagName.FILE_TYPE, "", "fileSize", "", "f", "d", "Ljava/util/Random;", "b", "Ljava/util/Random;", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "Lkotlin/Lazy;", "()Z", "shouldReport", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FilePreviewDataReporter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FilePreviewDataReporter f209177a = new FilePreviewDataReporter();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Random random = new Random();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy shouldReport;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.filemanager.util.FilePreviewDataReporter$shouldReport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean e16;
                e16 = FilePreviewDataReporter.f209177a.e();
                return Boolean.valueOf(e16);
            }
        });
        shouldReport = lazy;
    }

    FilePreviewDataReporter() {
    }

    private final boolean b() {
        return ((Boolean) shouldReport.getValue()).booleanValue();
    }

    private final String c(String filePath) {
        if (com.tencent.mobileqq.tbstool.gray.b.f291450a.g(filePath)) {
            return "1";
        }
        return "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e() {
        if (random.nextInt(10) == 0) {
            return true;
        }
        return false;
    }

    public final void d(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (!b()) {
            return;
        }
        int o06 = ah.o0(filePath);
        if (o06 != 0 && o06 != 2) {
            HashMap hashMap = new HashMap();
            hashMap.put("preview_file_size", String.valueOf(q.m(filePath)));
            hashMap.put("preview_file_path", filePath);
            hashMap.put("preview_file_type", String.valueOf(o06));
            hashMap.put("preview_file_new_tbs_tool", c(filePath));
            hashMap.put("preview_file_success", "1");
            QLog.d("FileTransferDataReporter", 1, "previewFileSuccess params: " + hashMap);
            com.tencent.mobileqq.inject.v.c(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "FileTransfer", hashMap);
            return;
        }
        QLog.d("FileTransferDataReporter", 1, "enterFilePreViewPage media type, not report. filePath: " + filePath);
    }

    public final void f(@NotNull String fileName, int fileType, long fileSize) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        if (!b()) {
            return;
        }
        if (fileType != 0 && fileType != 2) {
            HashMap hashMap = new HashMap();
            hashMap.put("preview_file_size", String.valueOf(fileSize));
            hashMap.put("preview_file_path", fileName);
            hashMap.put("preview_file_type", String.valueOf(fileType));
            hashMap.put("preview_file_new_tbs_tool", c(fileName));
            hashMap.put("preview_file_start", "1");
            QLog.d("FileTransferDataReporter", 1, "enterFilePreViewPage params: " + hashMap);
            com.tencent.mobileqq.inject.v.c(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "FileTransfer", hashMap);
            return;
        }
        QLog.d("FileTransferDataReporter", 1, "enterFilePreViewPage media type, not report. fileName: " + fileName);
    }
}

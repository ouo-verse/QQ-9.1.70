package com.tencent.mobileqq.config.avatar.download;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.avatar.download.ResDownloadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0001\u0010B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u000f\u001a\u00020\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/config/avatar/download/c;", "", "", "url", "filePath", "zipPath", "zipMd5", "Lcom/tencent/mobileqq/config/avatar/download/a;", "callback", "", "c", "targetMd5", "", "b", "d", "e", "a", "Ljava/lang/String;", "Lcom/tencent/mobileqq/config/avatar/download/a;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/config/avatar/download/a;)V", "f", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String filePath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String zipPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String zipMd5;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a callback;

    public c(@NotNull String url, @NotNull String filePath, @NotNull String zipPath, @NotNull String zipMd5, @NotNull a callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(zipMd5, "zipMd5");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.url = url;
        this.filePath = filePath;
        this.zipPath = zipPath;
        this.zipMd5 = zipMd5;
        this.callback = callback;
    }

    private final boolean b(String filePath, String targetMd5) {
        boolean equals;
        String bytes2HexStr = HexUtil.bytes2HexStr(MD5.getFileMd5(filePath));
        equals = StringsKt__StringsJVMKt.equals(bytes2HexStr, targetMd5, true);
        if (!equals) {
            QLog.e("ResDownloadTask", 1, "checkMd5 fail, md5 is " + bytes2HexStr);
        }
        return equals;
    }

    private final void c(String url, String filePath, String zipPath, String zipMd5, a callback) {
        if (new File(filePath).exists()) {
            QLog.i("ResDownloadTask", 1, "filePath exist");
            callback.a(new ResFile(filePath, zipMd5));
            return;
        }
        ResDownloadManager.Companion companion = ResDownloadManager.INSTANCE;
        if (companion.a().b(url, callback)) {
            QLog.i("ResDownloadTask", 1, "url already have downloadTask, and add callback");
            return;
        }
        QLog.i("ResDownloadTask", 1, "startDownload");
        File file = new File(zipPath);
        if (!HttpDownloadUtil.download(MobileQQ.sMobileQQ.peekAppRuntime(), url, file)) {
            companion.a().c(url, null);
            new File(zipPath).delete();
            QLog.e("ResDownloadTask", 1, "download failed\uff0curl is " + url);
            return;
        }
        if (!b(zipPath, zipMd5)) {
            companion.a().c(url, null);
            new File(zipPath).delete();
            return;
        }
        String str = filePath + "_tmp";
        if (!d(zipPath, str)) {
            companion.a().c(url, null);
            QLog.e("ResDownloadTask", 1, "extract fail");
        } else {
            if (!FileUtils.rename(str, filePath)) {
                companion.a().c(url, null);
                QLog.e("ResDownloadTask", 1, "rename fail");
                return;
            }
            QLog.i("ResDownloadTask", 1, "download success");
            companion.a().c(url, new ResFile(filePath, zipMd5));
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private final boolean d(String zipPath, String filePath) {
        try {
            FileUtils.uncompressZip(zipPath, filePath, false);
        } catch (Exception e16) {
            QLog.e("ResDownloadTask", 1, "extractFile exception " + e16);
            return false;
        } catch (OutOfMemoryError unused) {
            QLog.e("ResDownloadTask", 1, "extractFile err");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c(this$0.url, this$0.filePath, this$0.zipPath, this$0.zipMd5, this$0.callback);
    }

    public final void e() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.avatar.download.b
            @Override // java.lang.Runnable
            public final void run() {
                c.f(c.this);
            }
        }, 128, null, true);
    }
}

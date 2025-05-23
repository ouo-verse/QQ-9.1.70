package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.filemanager.api.IFileDataReporter;
import com.tencent.mobileqq.filemanager.util.MultiPicReporter;
import com.tencent.mobileqq.inject.v;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/filemanager/api/impl/FileDataReporterImpl;", "Lcom/tencent/mobileqq/filemanager/api/IFileDataReporter;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "", "reportMultiPicTransferResult", "", "result", "reportZipPreviewListResult", "<init>", "()V", "Companion", "a", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FileDataReporterImpl implements IFileDataReporter {

    @NotNull
    private static final a Companion = new a(null);

    @Deprecated
    @NotNull
    private static final String EVENT_CODE = "FileTransfer";

    @Deprecated
    @NotNull
    private static final String TAG = "FileDataReporterImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/filemanager/api/impl/FileDataReporterImpl$a;", "", "", "EVENT_CODE", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileDataReporter
    public void reportMultiPicTransferResult(@Nullable FileTransNotifyInfo notifyInfo) {
        if (notifyInfo == null) {
            return;
        }
        MultiPicReporter.f209186a.d(notifyInfo);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileDataReporter
    public void reportZipPreviewListResult(boolean result) {
        String str;
        HashMap hashMap = new HashMap();
        if (result) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("preview_zip_inner_list_result", str);
        v.c(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), EVENT_CODE, hashMap);
    }
}

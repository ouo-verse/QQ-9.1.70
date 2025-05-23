package com.tencent.qqnt.kernel.api;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.qqnt.kernel.nativeinterface.BdhUploadReq;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBdhUploadCompleteCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/kernel/api/l;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernel/nativeinterface/BdhUploadReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBdhUploadCompleteCallback;", "cb", "", "uploadFile", "(Lcom/tencent/qqnt/kernel/nativeinterface/BdhUploadReq;Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBdhUploadCompleteCallback;)Ljava/lang/Long;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "cancelUpload", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface l extends j {
    void cancelUpload(long taskId);

    @Nullable
    Long uploadFile(@NotNull BdhUploadReq req, @Nullable IKernelBdhUploadCompleteCallback cb5);
}

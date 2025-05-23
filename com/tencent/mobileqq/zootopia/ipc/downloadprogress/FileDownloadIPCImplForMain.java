package com.tencent.mobileqq.zootopia.ipc.downloadprogress;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.zootopia.download.file.b;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import gc3.a;
import gc3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/downloadprogress/FileDownloadIPCImplForMain;", "Lgc3/a;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "errorCode", "", "onFinalCallback", "", "progress", "", "receivedBytes", "totalBytes", "onProgress", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class FileDownloadIPCImplForMain implements a {
    @Override // gc3.c
    public void onFinalCallback(String taskId, int downloadStatus, int errorCode) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        c e16 = b.f328050a.e();
        if (e16 != null) {
            e16.onFinalCallback(taskId, downloadStatus, errorCode);
        }
    }

    @Override // gc3.c
    public void onProgress(String taskId, float progress, long receivedBytes, long totalBytes) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        c e16 = b.f328050a.e();
        if (e16 != null) {
            e16.onProgress(taskId, progress, receivedBytes, totalBytes);
        }
    }
}

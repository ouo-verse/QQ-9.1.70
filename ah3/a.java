package ah3;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.zootopia.download.ah;
import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.mobileqq.zplan.download.impl.manager.ZPlanDownloadManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg3.ZPlanDownloadParam;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lah3/a;", "Lyg3/b;", "", "Lzg3/b;", "downloadParamList", "", "O0", "Lcom/tencent/mobileqq/zootopia/download/x;", "a", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "cancel", "Lcom/tencent/mobileqq/zootopia/download/ah;", "downloadListener", "h0", "G", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a implements yg3.b {
    @Override // yg3.b
    public void G(ah downloadListener) {
        Intrinsics.checkNotNullParameter(downloadListener, "downloadListener");
        ZPlanDownloadManager.f332806a.l(downloadListener);
    }

    @Override // yg3.b
    public void O0(List<ZPlanDownloadParam> downloadParamList) {
        Intrinsics.checkNotNullParameter(downloadParamList, "downloadParamList");
        ZPlanDownloadManager.o(ZPlanDownloadManager.f332806a, downloadParamList, 0L, 2, null);
    }

    @Override // yg3.b
    public List<x> a() {
        return ZPlanDownloadManager.f332806a.k();
    }

    @Override // yg3.b
    public void cancel(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        ZPlanDownloadManager.f332806a.f(taskId);
    }

    @Override // yg3.b
    public void h0(ah downloadListener) {
        Intrinsics.checkNotNullParameter(downloadListener, "downloadListener");
        ZPlanDownloadManager.f332806a.c(downloadListener);
    }
}

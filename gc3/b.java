package gc3;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.zootopia.ipc.downloadprogress.FileDownloadIPCImplForZplan;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\n"}, d2 = {"Lgc3/b;", "", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "needProgressCallback", "Lgc3/c;", "callback", "", "bindFileDownloadProgress", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = FileDownloadIPCImplForZplan.class)
/* loaded from: classes38.dex */
public interface b {
    void bindFileDownloadProgress(String taskId, boolean needProgressCallback, c callback);
}

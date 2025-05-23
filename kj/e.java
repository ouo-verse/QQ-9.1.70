package kj;

import com.tencent.biz.richframework.queue.DownloadState;
import com.tencent.biz.richframework.queue.RFWDownloadTaskLocalStorageDelegate;
import com.tencent.biz.richframework.queue.RFWDownloadTaskStateData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\r\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0014"}, d2 = {"Lkj/e;", "Lcom/tencent/biz/richframework/queue/RFWDownloadTaskLocalStorageDelegate;", "", "businessKey", "url", "Lcom/tencent/biz/richframework/queue/RFWDownloadTaskLocalStorageDelegate$OnQueryTaskListCallback;", "callback", "", "a", "Lcom/tencent/biz/richframework/queue/RFWDownloadTaskStateData;", "taskStateData", "updateTaskEntry", "deleteTaskEntry", "queryTaskEntryList", "Lcom/tencent/biz/richframework/queue/DownloadState;", "state", "", "supportClearByTaskState", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e implements RFWDownloadTaskLocalStorageDelegate {
    private final void a(String businessKey, String url, RFWDownloadTaskLocalStorageDelegate.OnQueryTaskListCallback callback) {
        List<RFWDownloadTaskStateData> a16 = f.f412545a.a(c.c().h(businessKey, url));
        if (callback != null) {
            callback.onResult(a16);
        }
    }

    @Override // com.tencent.biz.richframework.queue.RFWDownloadTaskLocalStorageDelegate
    public void deleteTaskEntry(RFWDownloadTaskStateData taskStateData) {
        c.c().b(f.f412545a.c(taskStateData));
    }

    @Override // com.tencent.biz.richframework.queue.RFWTaskClearStrategy
    public boolean supportClearByTaskState(DownloadState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return state == DownloadState.STATE_SUCCESS || state == DownloadState.STATE_CANCEL;
    }

    @Override // com.tencent.biz.richframework.queue.RFWDownloadTaskLocalStorageDelegate
    public void updateTaskEntry(RFWDownloadTaskStateData taskStateData) {
        c.c().i(f.f412545a.c(taskStateData));
    }

    @Override // com.tencent.biz.richframework.queue.RFWDownloadTaskLocalStorageDelegate
    public void queryTaskEntryList(String businessKey, RFWDownloadTaskLocalStorageDelegate.OnQueryTaskListCallback callback) {
        a(businessKey, null, callback);
    }
}

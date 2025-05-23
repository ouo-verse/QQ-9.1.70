package a9;

import android.os.Message;
import com.qzone.common.event.EventCenter;
import com.qzone.publish.business.publishqueue.common.CommonPublishQueue;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.util.j;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\u000eB\u001f\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"La9/c;", "Lcom/qzone/publish/business/publishqueue/common/CommonPublishQueue;", "", HippyTKDListViewAdapter.X, "Landroid/os/Message;", "msg", "", "G", "caseId", "Lcom/qzone/publish/business/publishqueue/common/f;", "taskManager", "businessReportFlag", "<init>", "(Ljava/lang/String;Lcom/qzone/publish/business/publishqueue/common/f;Ljava/lang/String;)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c extends CommonPublishQueue {
    private static final a G = new a(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"La9/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String caseId, com.qzone.publish.business.publishqueue.common.f taskManager, String businessReportFlag) {
        super(caseId, taskManager, businessReportFlag);
        Intrinsics.checkNotNullParameter(caseId, "caseId");
        Intrinsics.checkNotNullParameter(taskManager, "taskManager");
        Intrinsics.checkNotNullParameter(businessReportFlag, "businessReportFlag");
    }

    @Override // com.qzone.publish.business.publishqueue.common.CommonPublishQueue
    public void G(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        super.G(msg2);
        Object obj = msg2.obj;
        IQueueTask iQueueTask = obj instanceof IQueueTask ? (IQueueTask) obj : null;
        if (iQueueTask == null) {
            RFWLog.w("QZPublishX_QZPublishXQueue", RFWLog.USR, "onRemoveTask, task is null ");
            return;
        }
        if (iQueueTask.isVideoTask()) {
            j.b().e(iQueueTask.getCommentUniKey());
        }
        if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
            le.b.f414397d.e(iQueueTask.getClientKey());
        } else {
            EventCenter.getInstance().post("WriteOperation", 13, iQueueTask);
        }
    }

    @Override // com.qzone.publish.business.publishqueue.common.CommonPublishQueue
    public String x() {
        return "QZPublishX_QZPublishXQueue";
    }
}

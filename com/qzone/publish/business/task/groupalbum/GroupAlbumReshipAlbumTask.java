package com.qzone.publish.business.task.groupalbum;

import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qqnt.kernel.nativeinterface.QuoteStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/publish/business/task/groupalbum/GroupAlbumReshipAlbumTask;", "Lcom/qzone/publish/business/task/groupalbum/GroupAlbumReshipBaseTask;", "", "getLogTag", "", "onRemove", "", "status", "getDetail", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;", "params", "<init>", "(Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public class GroupAlbumReshipAlbumTask extends GroupAlbumReshipBaseTask {
    private static final String TAG = "GroupAlbumReshipAlbumTask";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumReshipAlbumTask(GroupAlbumUploadAlbumParams params) {
        super(params);
        Intrinsics.checkNotNullParameter(params, "params");
    }

    public final String getDetail(int status) {
        if (status == QuoteStatus.KQUOTESTATUSPROCESSING.ordinal()) {
            return "\u8f6c\u8f7d\u4e2d";
        }
        if (status == QuoteStatus.KQUOTESTATUSSUCCESS.ordinal()) {
            return "\u5df2\u5b8c\u6210";
        }
        return "\u5931\u8d25";
    }

    @Override // com.qzone.publish.business.task.groupalbum.GroupAlbumReshipBaseTask, com.qzone.publish.business.task.groupalbum.GroupAlbumUploadBaseTask
    public String getLogTag() {
        return TAG;
    }

    @Override // com.qzone.publish.business.task.groupalbum.GroupAlbumUploadBaseTask, com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void onRemove() {
        super.onRemove();
        RFWLog.i(getLogTag(), RFWLog.USR, "onRemove, batchId:" + this.params.getBatchId() + ", taskId:" + getTaskId());
    }
}

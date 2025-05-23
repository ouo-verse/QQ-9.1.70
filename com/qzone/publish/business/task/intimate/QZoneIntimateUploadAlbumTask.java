package com.qzone.publish.business.task.intimate;

import com.qzone.common.account.LoginData;
import com.qzone.publish.business.model.intimate.IntimateUploadAlbumParams;
import com.qzone.publish.business.model.intimate.IntimateUploadTaskBatchInfo;
import com.qzone.publish.business.publishqueue.intimate.PublishFeedUtil;
import com.qzone.publish.business.publishqueue.intimate.b;
import com.qzone.publish.business.publishqueue.intimate.c;
import com.qzone.publish.business.publishqueue.intimate.d;
import com.qzone.publish.ui.model.MediaWrapper;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StMedia;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J0\u0010\n\u001a\u00020\t2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0004H\u0014J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0014\u0010\u000f\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/publish/business/task/intimate/QZoneIntimateUploadAlbumTask;", "Lcom/qzone/publish/business/task/intimate/QZoneIntimateUploadBaseTask;", "", "getLogTag", "", "Lqzone/QZoneBaseMeta$StMedia;", "uploadResult", "", "uploadResultBool", "", "onUploadFinish", "onRemove", "Lcom/qzone/publish/business/publishqueue/intimate/c;", "getBatchUtil", "()Lcom/qzone/publish/business/publishqueue/intimate/c;", "batchUtil", "Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumParams;", "params", "<init>", "(Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumParams;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public class QZoneIntimateUploadAlbumTask extends QZoneIntimateUploadBaseTask {
    private static final String TAG = "QZoneIntimateUploadAlbumTask";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneIntimateUploadAlbumTask(IntimateUploadAlbumParams params) {
        super(params);
        Intrinsics.checkNotNullParameter(params, "params");
    }

    private final c getBatchUtil() {
        d dVar = d.f51164a;
        String uid = LoginData.getInstance().getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "getInstance().uid");
        return dVar.a(uid);
    }

    @Override // com.qzone.publish.business.task.intimate.QZoneIntimateUploadBaseTask
    public String getLogTag() {
        return TAG;
    }

    @Override // com.qzone.publish.business.task.intimate.QZoneIntimateUploadBaseTask, com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void onRemove() {
        int collectionSizeOrDefault;
        super.onRemove();
        RFWLog.i(getLogTag(), RFWLog.USR, "onRemove, batchId:" + this.params.getBatchId() + ", taskId:" + getTaskId());
        c batchUtil = getBatchUtil();
        long batchId = this.params.getBatchId();
        ArrayList<MediaWrapper> mediaWrapperList = this.params.getMediaWrapperList();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(mediaWrapperList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = mediaWrapperList.iterator();
        while (it.hasNext()) {
            arrayList.add(b.b((MediaWrapper) it.next()));
        }
        IntimateUploadTaskBatchInfo e16 = batchUtil.e(batchId, arrayList);
        if (e16 != null) {
            PublishFeedUtil.f51147e.f(e16);
        }
    }

    @Override // com.qzone.publish.business.task.intimate.QZoneIntimateUploadBaseTask
    protected void onUploadFinish(Map<String, QZoneBaseMeta$StMedia> uploadResult, Map<String, Boolean> uploadResultBool) {
        Intrinsics.checkNotNullParameter(uploadResult, "uploadResult");
        Intrinsics.checkNotNullParameter(uploadResultBool, "uploadResultBool");
        super.onUploadFinish(uploadResult, uploadResultBool);
        IntimateUploadTaskBatchInfo b16 = getBatchUtil().b(this.params.getBatchId(), uploadResultBool, uploadResult);
        if (b16 != null) {
            PublishFeedUtil.f51147e.f(b16);
        }
    }
}

package com.qzone.publish.business.task.groupalbum;

import com.qzone.common.account.LoginData;
import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams;
import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadTaskBatchInfo;
import com.qzone.publish.ui.model.MediaWrapper;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import cooperation.qzone.QzoneIPCModule;
import fj.n;
import fo.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StMedia;
import z8.d;
import z8.e;
import z8.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J8\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\n\u001a\u00020\tH\u0014J\u001e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u0010\u001a\u00020\u000bH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/publish/business/task/groupalbum/GroupAlbumUploadAlbumTask;", "Lcom/qzone/publish/business/task/groupalbum/GroupAlbumUploadBaseTask;", "", "getLogTag", "", "Lqzone/QZoneBaseMeta$StMedia;", "uploadResult", "", "uploadResultBool", "", QzoneIPCModule.RESULT_CODE, "", "onUploadFinish", "mediaType", "isSuccess", "doReportAlbumEvent", "onRemove", "Lz8/e;", "getBatchUtil", "()Lz8/e;", "batchUtil", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;", "params", "<init>", "(Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public class GroupAlbumUploadAlbumTask extends GroupAlbumUploadBaseTask {
    private static final String TAG = "GroupAlbumUploadAlbumTask";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumUploadAlbumTask(GroupAlbumUploadAlbumParams params) {
        super(params);
        Intrinsics.checkNotNullParameter(params, "params");
    }

    private final e getBatchUtil() {
        f fVar = f.f452141a;
        String uid = LoginData.getInstance().getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "getInstance().uid");
        return fVar.a(uid);
    }

    public final void doReportAlbumEvent(int mediaType, boolean isSuccess, int resultCode) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("media_upload_success", Integer.valueOf(isSuccess ? 1 : 0));
        linkedHashMap.put("media_type", Integer.valueOf(mediaType));
        linkedHashMap.put("fail_error_code", Integer.valueOf(resultCode));
        c.c("ev_qun_album_on_media_upload", linkedHashMap);
    }

    @Override // com.qzone.publish.business.task.groupalbum.GroupAlbumUploadBaseTask
    public String getLogTag() {
        return TAG;
    }

    @Override // com.qzone.publish.business.task.groupalbum.GroupAlbumUploadBaseTask, com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void onRemove() {
        int collectionSizeOrDefault;
        super.onRemove();
        RFWLog.i(getLogTag(), RFWLog.USR, "onRemove, batchId:" + this.params.getBatchId() + ", taskId:" + getTaskId());
        e batchUtil = getBatchUtil();
        long batchId = this.params.getBatchId();
        ArrayList<MediaWrapper> mediaWrapperList = this.params.getMediaWrapperList();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(mediaWrapperList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = mediaWrapperList.iterator();
        while (it.hasNext()) {
            arrayList.add(d.a((MediaWrapper) it.next()));
        }
        GroupAlbumUploadTaskBatchInfo f16 = batchUtil.f(batchId, arrayList);
        if (f16 != null) {
            getBatchUtil().c(f16);
        }
        n.f399459a.A(this.params.getGroupId(), this.params.getClientKey());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.publish.business.task.groupalbum.GroupAlbumUploadBaseTask
    public void onUploadFinish(Map<String, QZoneBaseMeta$StMedia> uploadResult, Map<String, Boolean> uploadResultBool, int resultCode) {
        Intrinsics.checkNotNullParameter(uploadResult, "uploadResult");
        Intrinsics.checkNotNullParameter(uploadResultBool, "uploadResultBool");
        super.onUploadFinish(uploadResult, uploadResultBool, resultCode);
        GroupAlbumUploadTaskBatchInfo b16 = getBatchUtil().b(this.params.getBatchId(), uploadResultBool, uploadResult);
        if (b16 != null) {
            getBatchUtil().c(b16);
        }
    }
}

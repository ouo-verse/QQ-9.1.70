package com.qzone.publish.business.publishqueue.intimate;

import com.qzone.publish.business.model.intimate.IntimateUploadTaskBatchInfo;
import com.qzone.publish.business.model.intimate.PublishStage;
import com.qzone.publish.business.publishqueue.intimate.PublishFeedUtil;
import com.qzone.reborn.intimate.event.QZoneIntimateUploadAlbumEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import qzone.QZIntimateSpaceReader$GetFeedDetailRsp;
import qzone.QZIntimateSpaceReader$StClientFeed;
import qzone.QZoneBaseCommon$StCommonExt;
import qzone.QZoneBaseMeta$StFeed;
import qzone.QZoneBaseMeta$StFeedCellCommon;
import qzone.QZoneBaseMeta$StMedia;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.qzone.publish.business.publishqueue.intimate.PublishFeedUtil$checkPublishAlbumFeed$1", f = "PublishFeedUtil.kt", i = {0}, l = {89, 103}, m = "invokeSuspend", n = {"allSucceed"}, s = {"I$0"})
/* loaded from: classes39.dex */
public final class PublishFeedUtil$checkPublishAlbumFeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IntimateUploadTaskBatchInfo $batchInfo;
    int I$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishFeedUtil$checkPublishAlbumFeed$1(IntimateUploadTaskBatchInfo intimateUploadTaskBatchInfo, Continuation<? super PublishFeedUtil$checkPublishAlbumFeed$1> continuation) {
        super(2, continuation);
        this.$batchInfo = intimateUploadTaskBatchInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PublishFeedUtil$checkPublishAlbumFeed$1(this.$batchInfo, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0247  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int i3;
        c i16;
        c i17;
        c i18;
        c i19;
        PublishStage publishStage;
        c i26;
        QZIntimateSpaceReader$GetFeedDetailRsp qZIntimateSpaceReader$GetFeedDetailRsp;
        QZIntimateSpaceReader$StClientFeed qZIntimateSpaceReader$StClientFeed;
        QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed;
        QZoneBaseMeta$StFeedCellCommon qZoneBaseMeta$StFeedCellCommon;
        PBStringField pBStringField;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i27 = this.label;
        if (i27 == 0) {
            ResultKt.throwOnFailure(obj);
            RFWLog.i("PublishFeedUtil", RFWLog.USR, "checkPublishAlbumFeed, batchInfo:" + this.$batchInfo);
            int size = this.$batchInfo.getUploadParams().getLocalMediaList().size();
            ConcurrentHashMap<String, Boolean> uploadResultBoolMap = this.$batchInfo.getUploadResultBoolMap();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, Boolean> entry : uploadResultBoolMap.entrySet()) {
                if (entry.getValue().booleanValue()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            int size2 = linkedHashMap.size();
            ConcurrentHashMap<String, Boolean> uploadResultBoolMap2 = this.$batchInfo.getUploadResultBoolMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry<String, Boolean> entry2 : uploadResultBoolMap2.entrySet()) {
                if (!entry2.getValue().booleanValue()) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            int size3 = linkedHashMap2.size();
            RFWLog.i("PublishFeedUtil", RFWLog.USR, "checkPublishAlbumFeed, batchId:" + this.$batchInfo.getUploadParams().getBatchId() + ", totalCount:" + size + ", succeedCount:" + size2 + ", failedCount:" + size3);
            if (size == 0) {
                sm.h.t(this.$batchInfo.getUploadParams().getSpaceId(), this.$batchInfo.getUploadParams().getClientKey());
                i18 = PublishFeedUtil.f51147e.i();
                i18.c(this.$batchInfo.getUploadParams().getBatchId());
                return Unit.INSTANCE;
            }
            i3 = size2 == size ? 1 : 0;
            if (i3 != 0) {
                SimpleEventBus.getInstance().dispatchEvent(new QZoneIntimateUploadAlbumEvent(this.$batchInfo.getUploadParams().getSpaceId(), this.$batchInfo.getUploadParams().getAlbumInfo().getAlbumId(), this.$batchInfo.getUploadParams().getBatchId(), size2));
            }
            if (i3 != 0 && this.$batchInfo.isPublishSucceed()) {
                i17 = PublishFeedUtil.f51147e.i();
                i17.c(this.$batchInfo.getUploadParams().getBatchId());
            }
            if (!this.$batchInfo.shouldPublish()) {
                return Unit.INSTANCE;
            }
            PublishFeedUtil publishFeedUtil = PublishFeedUtil.f51147e;
            List<QZoneBaseMeta$StMedia> k3 = PublishFeedUtil.k(publishFeedUtil, this.$batchInfo, 0, 0, 6, null);
            if (k3.size() >= 9 || i3 != 0) {
                i16 = publishFeedUtil.i();
                i16.g(this.$batchInfo.getUploadParams().getBatchId(), PublishStage.PUBLISHING);
                QZoneBaseMeta$StFeed stFeed = this.$batchInfo.getUploadParams().toStFeed(k3, size);
                this.I$0 = i3;
                this.label = 1;
                obj = publishFeedUtil.h(stFeed, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i27 != 1) {
            if (i27 == 2) {
                ResultKt.throwOnFailure(obj);
                qZIntimateSpaceReader$GetFeedDetailRsp = (QZIntimateSpaceReader$GetFeedDetailRsp) obj;
                RFWLog.i("PublishFeedUtil", RFWLog.USR, "checkPublishAlbumFeed, feedId:" + ((qZIntimateSpaceReader$GetFeedDetailRsp != null || (qZIntimateSpaceReader$StClientFeed = qZIntimateSpaceReader$GetFeedDetailRsp.feed) == null || (qZoneBaseMeta$StFeed = qZIntimateSpaceReader$StClientFeed.feed) == null || (qZoneBaseMeta$StFeedCellCommon = qZoneBaseMeta$StFeed.cell_common) == null || (pBStringField = qZoneBaseMeta$StFeedCellCommon.feed_id) == null) ? null : pBStringField.get()));
                if (qZIntimateSpaceReader$GetFeedDetailRsp != null) {
                    String spaceId = this.$batchInfo.getUploadParams().getSpaceId();
                    QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed2 = qZIntimateSpaceReader$GetFeedDetailRsp.feed.feed;
                    Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StFeed2, "getFeedRsp.feed.feed");
                    QZoneBaseCommon$StCommonExt qZoneBaseCommon$StCommonExt = qZIntimateSpaceReader$GetFeedDetailRsp.ext;
                    Intrinsics.checkNotNullExpressionValue(qZoneBaseCommon$StCommonExt, "getFeedRsp.ext");
                    sm.h.A(spaceId, qZoneBaseMeta$StFeed2, qZoneBaseCommon$StCommonExt);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i3 = this.I$0;
        ResultKt.throwOnFailure(obj);
        PublishFeedUtil.PublishResponse publishResponse = (PublishFeedUtil.PublishResponse) obj;
        PublishFeedUtil publishFeedUtil2 = PublishFeedUtil.f51147e;
        i19 = publishFeedUtil2.i();
        long batchId = this.$batchInfo.getUploadParams().getBatchId();
        if (publishResponse.c()) {
            publishStage = PublishStage.SUCCEED;
        } else {
            publishStage = PublishStage.FAILED;
        }
        i19.g(batchId, publishStage);
        if (!publishResponse.c()) {
            return Unit.INSTANCE;
        }
        if (i3 != 0) {
            i26 = publishFeedUtil2.i();
            i26.c(this.$batchInfo.getUploadParams().getBatchId());
        }
        this.label = 2;
        obj = publishFeedUtil2.g(publishResponse, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        qZIntimateSpaceReader$GetFeedDetailRsp = (QZIntimateSpaceReader$GetFeedDetailRsp) obj;
        if (qZIntimateSpaceReader$GetFeedDetailRsp != null) {
        }
        RFWLog.i("PublishFeedUtil", RFWLog.USR, "checkPublishAlbumFeed, feedId:" + ((qZIntimateSpaceReader$GetFeedDetailRsp != null || (qZIntimateSpaceReader$StClientFeed = qZIntimateSpaceReader$GetFeedDetailRsp.feed) == null || (qZoneBaseMeta$StFeed = qZIntimateSpaceReader$StClientFeed.feed) == null || (qZoneBaseMeta$StFeedCellCommon = qZoneBaseMeta$StFeed.cell_common) == null || (pBStringField = qZoneBaseMeta$StFeedCellCommon.feed_id) == null) ? null : pBStringField.get()));
        if (qZIntimateSpaceReader$GetFeedDetailRsp != null) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PublishFeedUtil$checkPublishAlbumFeed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

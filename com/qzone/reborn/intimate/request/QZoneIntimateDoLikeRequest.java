package com.qzone.reborn.intimate.request;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oj.a;
import qzone.QZIntimateSpaceWriter$StDoLikeReq;
import qzone.QZIntimateSpaceWriter$StDoLikeRsp;
import qzone.QZoneBaseMeta$StFeedCellCommon;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateDoLikeRequest;", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lqzone/QZIntimateSpaceWriter$StDoLikeReq;", "mDoLikeReq", "Lqzone/QZIntimateSpaceWriter$StDoLikeReq;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "spaceId", "", "actionType", "<init>", "(Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;Ljava/lang/String;I)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateDoLikeRequest extends QZoneIntimateBaseRequest {
    public static final int ACTION_TYPE_LIKE = 1;
    public static final int ACTION_TYPE_UNLIKE = 0;
    public static final int LIKE_STATUS_LIKED = 1;
    public static final int LIKE_STATUS_NOT_LIKE = 0;
    public static final String TAG = "QZoneIntimateDoLikeRequest";
    private QZIntimateSpaceWriter$StDoLikeReq mDoLikeReq;

    public QZoneIntimateDoLikeRequest(BusinessFeedData feedData, String spaceId, int i3) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        QZIntimateSpaceWriter$StDoLikeReq qZIntimateSpaceWriter$StDoLikeReq = new QZIntimateSpaceWriter$StDoLikeReq();
        this.mDoLikeReq = qZIntimateSpaceWriter$StDoLikeReq;
        qZIntimateSpaceWriter$StDoLikeReq.like_type.set(i3);
        this.mDoLikeReq.feed.setHasFlag(true);
        this.mDoLikeReq.feed.cell_common.setHasFlag(true);
        QZoneBaseMeta$StFeedCellCommon qZoneBaseMeta$StFeedCellCommon = this.mDoLikeReq.feed.cell_common;
        a aVar = a.f423008a;
        qZoneBaseMeta$StFeedCellCommon.set(aVar.k(feedData.getFeedCommInfo()));
        this.mDoLikeReq.feed.cell_space_info.setHasFlag(true);
        this.mDoLikeReq.feed.cell_space_info.space_id.set(spaceId);
        this.mDoLikeReq.feed.cell_user_info.setHasFlag(true);
        this.mDoLikeReq.feed.cell_user_info.user.set(aVar.n(feedData.getUser()));
        int i16 = i3 == 0 ? 0 : 1;
        this.mDoLikeReq.like.setHasFlag(true);
        this.mDoLikeReq.like.f430336id.set(feedData.getFeedCommInfo().feedsid);
        this.mDoLikeReq.like.status.set(i16);
        this.mDoLikeReq.like.owner_status.set(i16);
        this.mDoLikeReq.like.post_user.set(aVar.d());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qzone.QZIntimateSpaceWriter$StDoLikeRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZIntimateSpaceWriter$StDoLikeRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "IntimateSpace.trpc.qzone.intimate_space_commwriter.ComWriter.DoLike";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        byte[] byteArray = this.mDoLikeReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mDoLikeReq.toByteArray()");
        return byteArray;
    }
}

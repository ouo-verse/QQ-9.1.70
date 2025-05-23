package com.qzone.reborn.intimate.request;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceWriter$StPublishFeedReq;
import qzone.QZIntimateSpaceWriter$StPublishFeedRsp;
import qzone.QZoneBaseCommon$StCommonExt;
import qzone.QZoneBaseMeta$StFeed;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u001d\u0010\u000e\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimatePublishRequest;", "T", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "feed", "Lqzone/QZoneBaseMeta$StFeed;", "from", "", "needSyncFriendFeed", "", "extInfo", "Lqzone/QZoneBaseCommon$StCommonExt;", "(Lqzone/QZoneBaseMeta$StFeed;IZLqzone/QZoneBaseCommon$StCommonExt;)V", "mStPublishFeedReq", "Lqzone/QZIntimateSpaceWriter$StPublishFeedReq;", "decode", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimatePublishRequest<T> extends QZoneIntimateBaseRequest {
    private final QZIntimateSpaceWriter$StPublishFeedReq mStPublishFeedReq;

    public /* synthetic */ QZoneIntimatePublishRequest(QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed, int i3, boolean z16, QZoneBaseCommon$StCommonExt qZoneBaseCommon$StCommonExt, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(qZoneBaseMeta$StFeed, i3, (i16 & 4) != 0 ? false : z16, qZoneBaseCommon$StCommonExt);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QZIntimateSpaceWriter$StPublishFeedRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZIntimateSpaceWriter$StPublishFeedRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            RFWLog.e(QZoneIntimateBaseRequest.TAG, RFWLog.USR, "decode error:" + e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "IntimateSpace.trpc.qzone.intimate_space_commwriter.ComWriter.PublishFeed";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mStPublishFeedReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mStPublishFeedReq.toByteArray()");
        return byteArray;
    }

    public QZoneIntimatePublishRequest(QZoneBaseMeta$StFeed feed, int i3, boolean z16, QZoneBaseCommon$StCommonExt extInfo) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        QZIntimateSpaceWriter$StPublishFeedReq qZIntimateSpaceWriter$StPublishFeedReq = new QZIntimateSpaceWriter$StPublishFeedReq();
        this.mStPublishFeedReq = qZIntimateSpaceWriter$StPublishFeedReq;
        qZIntimateSpaceWriter$StPublishFeedReq.ext_info.set(extInfo);
        qZIntimateSpaceWriter$StPublishFeedReq.from.set(i3);
        qZIntimateSpaceWriter$StPublishFeedReq.feed.set(feed);
        qZIntimateSpaceWriter$StPublishFeedReq.sync_qzone.set(z16);
    }
}

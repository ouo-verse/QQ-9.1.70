package com.qzone.reborn.intimate.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceMedal$StGetMedalListByMainPageReq;
import qzone.QZIntimateSpaceMedal$StGetMedalListByMainPageRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateNewBadgeRequest;", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lqzone/QZIntimateSpaceMedal$StGetMedalListByMainPageReq;", "mMedalListReq", "Lqzone/QZIntimateSpaceMedal$StGetMedalListByMainPageReq;", "spaceId", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateNewBadgeRequest extends QZoneIntimateBaseRequest {
    public static final String TAG = "QZoneIntimateNewBadgeRequest";
    private QZIntimateSpaceMedal$StGetMedalListByMainPageReq mMedalListReq;

    public QZoneIntimateNewBadgeRequest(String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        QZIntimateSpaceMedal$StGetMedalListByMainPageReq qZIntimateSpaceMedal$StGetMedalListByMainPageReq = new QZIntimateSpaceMedal$StGetMedalListByMainPageReq();
        this.mMedalListReq = qZIntimateSpaceMedal$StGetMedalListByMainPageReq;
        qZIntimateSpaceMedal$StGetMedalListByMainPageReq.space_id.set(spaceId);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QZIntimateSpaceMedal$StGetMedalListByMainPageRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZIntimateSpaceMedal$StGetMedalListByMainPageRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "IntimateSpace.trpc.qzone.intimate_space_medal.Medal.GetMedalListByMainPage";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mMedalListReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mMedalListReq.toByteArray()");
        return byteArray;
    }
}

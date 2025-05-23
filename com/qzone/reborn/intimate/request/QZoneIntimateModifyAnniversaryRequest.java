package com.qzone.reborn.intimate.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateProfileReader$ClientModISpaceInfoReq;
import qzone.QZIntimateProfileReader$ClientModISpaceInfoRsp;
import qzone.QZoneBaseCommon$Entry;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateModifyAnniversaryRequest;", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lqzone/QZIntimateProfileReader$ClientModISpaceInfoReq;", "mSpaceReq", "Lqzone/QZIntimateProfileReader$ClientModISpaceInfoReq;", "spaceId", "", "timeStampInSecond", "<init>", "(Ljava/lang/String;J)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateModifyAnniversaryRequest extends QZoneIntimateBaseRequest {
    public static final String TAG = "QZoneIntimateModifyAnniversaryRequest";
    private QZIntimateProfileReader$ClientModISpaceInfoReq mSpaceReq;

    public QZoneIntimateModifyAnniversaryRequest(String spaceId, long j3) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        QZIntimateProfileReader$ClientModISpaceInfoReq qZIntimateProfileReader$ClientModISpaceInfoReq = new QZIntimateProfileReader$ClientModISpaceInfoReq();
        this.mSpaceReq = qZIntimateProfileReader$ClientModISpaceInfoReq;
        qZIntimateProfileReader$ClientModISpaceInfoReq.space_id.set(spaceId);
        QZoneBaseCommon$Entry qZoneBaseCommon$Entry = new QZoneBaseCommon$Entry();
        qZoneBaseCommon$Entry.key.set("2");
        qZoneBaseCommon$Entry.value.set(String.valueOf(j3));
        this.mSpaceReq.fields.add(qZoneBaseCommon$Entry);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QZIntimateProfileReader$ClientModISpaceInfoRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZIntimateProfileReader$ClientModISpaceInfoRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "IntimateSpace.trpc.qzone.intimate_space_profileaccess.SpaceprofileAccess.ClientModISpaceInfo";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mSpaceReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mSpaceReq.toByteArray()");
        return byteArray;
    }
}

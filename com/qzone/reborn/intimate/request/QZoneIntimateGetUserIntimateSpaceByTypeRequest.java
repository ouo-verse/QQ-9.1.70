package com.qzone.reborn.intimate.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateProfileReader$GetUserIntimateSpaceByTypeReq;
import qzone.QZIntimateProfileReader$GetUserIntimateSpaceByTypeRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001d\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\rH\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateGetUserIntimateSpaceByTypeRequest;", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "spaceType", "", "targetPage", "originScheme", "", "(IILjava/lang/String;)V", "getUserIntimateSpaceByTypeRequest", "Lqzone/QZIntimateProfileReader$GetUserIntimateSpaceByTypeReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateGetUserIntimateSpaceByTypeRequest extends QZoneIntimateBaseRequest {
    private QZIntimateProfileReader$GetUserIntimateSpaceByTypeReq getUserIntimateSpaceByTypeRequest;

    public QZoneIntimateGetUserIntimateSpaceByTypeRequest(int i3, int i16, String originScheme) {
        Intrinsics.checkNotNullParameter(originScheme, "originScheme");
        QZIntimateProfileReader$GetUserIntimateSpaceByTypeReq qZIntimateProfileReader$GetUserIntimateSpaceByTypeReq = new QZIntimateProfileReader$GetUserIntimateSpaceByTypeReq();
        this.getUserIntimateSpaceByTypeRequest = qZIntimateProfileReader$GetUserIntimateSpaceByTypeReq;
        qZIntimateProfileReader$GetUserIntimateSpaceByTypeReq.space_type.set(i3);
        this.getUserIntimateSpaceByTypeRequest.targetpage.set(i16);
        this.getUserIntimateSpaceByTypeRequest.origin_schema.set(originScheme);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qzone.QZIntimateProfileReader$GetUserIntimateSpaceByTypeRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZIntimateProfileReader$GetUserIntimateSpaceByTypeRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "IntimateSpace.trpc.qzone.intimate_space_profileaccess.SpaceprofileAccess.GetUserIntimateSpaceByType";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.getUserIntimateSpaceByTypeRequest.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "getUserIntimateSpaceByTypeRequest.toByteArray()");
        return byteArray;
    }
}

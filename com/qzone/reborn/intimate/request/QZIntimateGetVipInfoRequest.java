package com.qzone.reborn.intimate.request;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.qzoneUnifiedStore$GetMemberShipReq;
import qzone.qzoneUnifiedStore$GetMemberShipRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZIntimateGetVipInfoRequest;", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lqzone/qzoneUnifiedStore$GetMemberShipReq;", Const.BUNDLE_KEY_REQUEST, "Lqzone/qzoneUnifiedStore$GetMemberShipReq;", "spaceId", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateGetVipInfoRequest extends QZoneIntimateBaseRequest {
    private qzoneUnifiedStore$GetMemberShipReq request;

    public QZIntimateGetVipInfoRequest(String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        qzoneUnifiedStore$GetMemberShipReq qzoneunifiedstore_getmembershipreq = new qzoneUnifiedStore$GetMemberShipReq();
        this.request = qzoneunifiedstore_getmembershipreq;
        qzoneunifiedstore_getmembershipreq.space_id.set(spaceId);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.qzoneUnifiedStore$GetMemberShipRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new qzoneUnifiedStore$GetMemberShipRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (Exception e16) {
            QLog.e("QZIntimateGetVipInfoRequest", 1, "exception is " + e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "IntimateSpace.trpc.qzone.unified_store.UserPayment.GetMemberShip";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }
}

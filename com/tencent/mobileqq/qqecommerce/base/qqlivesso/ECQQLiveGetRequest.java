package com.tencent.mobileqq.qqecommerce.base.qqlivesso;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqecommerce.repo.pbfile.qqLiveRequest$GetReq;
import com.tencent.mobileqq.qqecommerce.repo.pbfile.qqLiveRequest$GetRsp;
import com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0014J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/qqlivesso/ECQQLiveGetRequest;", "T", "Lcom/tencent/mobileqq/qqlive/api/sso/LiveBaseRequest;", "service", "", "method", "reqData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "decode", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getMainCmd", "getMessageNano", "Lcom/google/protobuf/nano/MessageNano;", "getRequestByteData", "getSubCmd", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ECQQLiveGetRequest<T> extends LiveBaseRequest<T> {
    private final String method;
    private final String reqData;
    private final String service;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECQQLiveGetRequest(String service, String method, String str) {
        super(QQLiveBusinessConfig.QQLIVE_APP_ID);
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        this.service = service;
        this.method = method;
        this.reqData = str;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.mobileqq.pb.MessageMicro, T, com.tencent.mobileqq.qqecommerce.repo.pbfile.qqLiveRequest$GetRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        try {
            ?? r06 = (T) new qqLiveRequest$GetRsp();
            r06.mergeFrom(convertInputStreamtoByteArray);
            return r06;
        } catch (Exception e16) {
            QLog.e("ECQQLiveGetRequest", 1, "decode error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    /* renamed from: getMainCmd, reason: from getter */
    public String getService() {
        return this.service;
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    public MessageNano getMessageNano() {
        throw new RuntimeException("this request cannot use this method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest, com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    public byte[] get$pbReqBytes() {
        qqLiveRequest$GetReq qqliverequest_getreq = new qqLiveRequest$GetReq();
        qqliverequest_getreq.req_params.set(this.reqData);
        byte[] byteArray = qqliverequest_getreq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    /* renamed from: getSubCmd, reason: from getter */
    public String getMethod() {
        return this.method;
    }
}

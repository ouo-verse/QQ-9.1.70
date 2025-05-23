package com.tencent.mobileqq.wink.request;

import NS_COMM.COMM;
import NS_QWEB_PROTOCAL.PROTOCAL;
import com.qzone.reborn.intimate.request.QZoneIntimateBaseRequest;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.common.RFWCommonGlobalInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/request/WinkMsfBaseRequest;", "Lcom/tencent/biz/richframework/network/request/VSBaseRequest;", "()V", "getRequestWrapper", "", "requestBizData", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public abstract class WinkMsfBaseRequest extends VSBaseRequest {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    @Nullable
    public byte[] getRequestWrapper(@Nullable ByteStringMicro requestBizData) {
        PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
        try {
            stQWebReq.mergeFrom(super.getRequestWrapper(requestBizData));
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(BaseRequest.TAG, 1, "[getRequestWrapper]", e16);
        }
        COMM.Entry entry = new COMM.Entry();
        entry.key.set(QZoneIntimateBaseRequest.QZONE_INTIMATE_REQUEST_CLOUD_APP_ID_KEY);
        entry.value.set("92");
        stQWebReq.Extinfo.add(entry);
        COMM.Entry entry2 = new COMM.Entry();
        entry2.key.set("environment_id");
        entry2.value.set(RFWCommonGlobalInfo.getCurMsfServerId());
        stQWebReq.Extinfo.add(entry2);
        return stQWebReq.toByteArray();
    }
}

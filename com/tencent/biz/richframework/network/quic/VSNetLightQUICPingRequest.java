package com.tencent.biz.richframework.network.quic;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.quic.manager.VSNetLightQUICIPStrategyManager;
import com.tencent.biz.richframework.network.request.VSNetQUICEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.feedcloud.api_gateway_quic.api_gateway_quic.CompressType;
import com.tencent.trpcprotocol.feedcloud.api_gateway_quic.api_gateway_quic.QuicForwardReq;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import okio.ByteString;

/* loaded from: classes5.dex */
public class VSNetLightQUICPingRequest extends VSNetLightQUICBaseRequest {
    private static final String DEF_PING = "PING";
    private static final String RSP_SUCCESS_INFO_KEY = "trpc-trans-info";
    private static final String SERVICE_DEBUG = "https://quic.xsj.qq.com/PreEnv/QuicPing";
    private static final String SERVICE_RELEASE = "https://quic.xsj.qq.com/QuicPing";
    private static final String TAG = "QUIC-VSNetLightQUICPingRequest";
    private final AtomicReference<String> mCurrentReqIp = new AtomicReference<>();

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    public String getCmdName() {
        return DEF_PING;
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    public String getMethodName() {
        return DEF_PING;
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    protected String getRequestTag() {
        return TAG;
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    public String getServiceName() {
        return DEF_PING;
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    public String getTraceId() {
        return DEF_PING;
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    public String getURL() {
        if (isForceTestQUIC()) {
            return SERVICE_DEBUG;
        }
        return SERVICE_RELEASE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    public void notifyHandlerHeader(Map<String, String> map) {
        super.notifyHandlerHeader(map);
        if (map != null && !map.isEmpty()) {
            boolean containsKey = map.containsKey(RSP_SUCCESS_INFO_KEY);
            QLog.d(TAG, 1, "[notifyHandlerHeader] receiveHeader size: " + map.size() + " | isReqSuccess: " + containsKey);
            if (!containsKey) {
                VSNetLightQUICIPStrategyManager.instance().recordFailedIpToMap(getHost(), this.mCurrentReqIp.get(), VSNetLightQUICIPStrategyManager.FAIL_SCENE_PING);
            }
        }
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    protected byte[] obtainWrapBody() {
        String valueOf;
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            byte[] bArr = new byte[0];
            if (this.mIsGzipCompressed) {
                valueOf = String.valueOf(CompressType.COMPRESS_TYPE_GZIP.getValue());
            } else {
                valueOf = String.valueOf(CompressType.COMPRESS_TYPE_NOOP.getValue());
            }
            hashMap.put("req_compress_type", valueOf);
            initService(hashMap);
            return new QuicForwardReq.a().f(getServiceName()).d(getMethodName()).a(ByteString.of(bArr)).c(hashMap).e(0).build().encode();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[obtainWrapBody] ex:", th5);
            return null;
        }
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    protected void onDecodeForwardRspData(byte[] bArr, int i3, String str) {
        int length;
        String requestTag = getRequestTag();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[onDecodeForwardRspData] headerErrorCode: ");
        sb5.append(i3);
        sb5.append(" | headerErrorMsg: ");
        sb5.append(str);
        sb5.append(" | finalResult size: ");
        if (bArr == null) {
            length = 0;
        } else {
            length = bArr.length;
        }
        sb5.append(length);
        QLog.d(requestTag, 1, sb5.toString());
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    public void onQUICEvent(VSNetQUICEvent vSNetQUICEvent) {
        if (vSNetQUICEvent != null && TextUtils.equals(VSNetQUICEvent.EVENT_ID_DNS_SUCCESS, vSNetQUICEvent.getEventKey())) {
            this.mCurrentReqIp.set(vSNetQUICEvent.getDNSIP());
        }
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    protected void onRequestStats(String str) {
        QLog.d(TAG, 1, "[onRequestStats] stats: " + str);
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    protected void onRspParseFail(int i3) {
        QLog.d(TAG, 1, "[onRspParseFail] failCode: " + i3);
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    protected void onSsoFailInfo(int i3, String str) {
        QLog.d(getRequestTag(), 1, "[onSsoFailInfo] errCode: " + i3 + " | failMsg: " + str);
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    protected void retryToOtherPipelineReq() {
        VSNetLightQUICIPStrategyManager.instance().recordFailedIpToMap(getHost(), this.mCurrentReqIp.get(), VSNetLightQUICIPStrategyManager.FAIL_SCENE_PING);
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    protected void buildLbsInfo(StringBuilder sb5) {
    }
}

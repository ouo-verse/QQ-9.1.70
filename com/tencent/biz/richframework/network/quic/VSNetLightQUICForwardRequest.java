package com.tencent.biz.richframework.network.quic;

import NS_QWEB_PROTOCAL.PROTOCAL;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.github.luben.zstd.Zstd;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.quic.manager.VSNetLightQUICIPStrategyManager;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.RequestInterceptor;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.richframework.network.request.VSNetQUICEvent;
import com.tencent.biz.richframework.network.servlet.VSBaseServlet;
import com.tencent.biz.richframework.util.GzipUtil;
import com.tencent.lightquic.api.LightQUICRequest;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.trpcprotocol.feedcloud.api_gateway_quic.api_gateway_quic.CompressType;
import com.tencent.trpcprotocol.feedcloud.api_gateway_quic.api_gateway_quic.QuicForwardReq;
import com.tencent.trpcprotocol.feedcloud.api_gateway_quic.api_gateway_quic.QuicForwardRsp;
import com.tencent.util.AppSetting;
import java.util.HashMap;
import kotlin.text.Typography;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import okio.ByteString;
import uq3.o;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VSNetLightQUICForwardRequest extends VSNetLightQUICBaseRequest {
    private static final String SERVICE_DEBUG = "https://quic.xsj.qq.com/PreEnv/QuicForward";
    private static final String SERVICE_RELEASE = "https://quic.xsj.qq.com/QuicForward";
    private static final String TAG = "QUIC-VSNetLightQUICRequest";
    private final VSBaseRequest mVsRequest;

    public VSNetLightQUICForwardRequest(@NonNull VSBaseRequest vSBaseRequest) {
        this.mVsRequest = vSBaseRequest;
    }

    private boolean checkRequestVaild(BaseRequest baseRequest) {
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (baseRequest.getTraceId() != null && account != null && !baseRequest.getTraceId().startsWith(account)) {
            if (baseRequest instanceof VSBaseRequest) {
                return TextUtils.equals(account, ((VSBaseRequest) baseRequest).getRequestUin());
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyRspParseFail$0(int i3) {
        VSBaseRequest vSBaseRequest = this.mVsRequest;
        vSBaseRequest.proceedResponseInterceptor(vSBaseRequest, true, i3, VSNetLightQUICBaseRequest.NETWORK_ERROR_HINT, null);
        VSNetworkHelper.getDispatchObserver().sendCacheToTargetCallBack(this.mVsRequest, i3, VSNetLightQUICBaseRequest.NETWORK_ERROR_HINT, null);
        QLog.d(TAG, 1, "[notifyRspParseFail] error code: " + i3);
    }

    private void notifyRspParseFail(final int i3) {
        try {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.network.quic.b
                @Override // java.lang.Runnable
                public final void run() {
                    VSNetLightQUICForwardRequest.this.lambda$notifyRspParseFail$0(i3);
                }
            });
        } catch (Throwable th5) {
            QLog.w(TAG, 1, "[notifyRspParseFail] ex: " + th5);
        }
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    protected void buildLbsInfo(StringBuilder sb5) {
        SosoLbsInfo cachedLbsInfo;
        if (((!AppSetting.isGrayVersion() && !AppSetting.isPublicVersion()) || !o.h()) && (cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("qqcircle")) != null && cachedLbsInfo.mLocation != null) {
            sb5.append(Typography.amp);
            sb5.append("latitude=");
            sb5.append(this.mVsRequest.getLatitude(cachedLbsInfo));
            sb5.append(Typography.amp);
            sb5.append("longitude=");
            sb5.append(this.mVsRequest.getLongitude(cachedLbsInfo));
        }
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    public String getCmdName() {
        return this.mVsRequest.getCmd();
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    public String getMethodName() {
        return this.mVsRequest.getMethodName();
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    protected String getRequestTag() {
        return TAG;
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    public String getServiceName() {
        return this.mVsRequest.getServiceName();
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    public String getTraceId() {
        return this.mVsRequest.getTraceId();
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    public String getURL() {
        if (isForceTestQUIC()) {
            return SERVICE_DEBUG;
        }
        return SERVICE_RELEASE;
    }

    public VSBaseRequest getVSRequest() {
        return this.mVsRequest;
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    protected byte[] obtainWrapBody() {
        String valueOf;
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            byte[] lastSendByte = getLastSendByte(new PROTOCAL.StQWebReq().mergeFrom(this.mOriginEncodeBytes).busiBuff.get().toByteArray());
            if (this.mIsGzipCompressed) {
                valueOf = String.valueOf(CompressType.COMPRESS_TYPE_GZIP.getValue());
            } else {
                valueOf = String.valueOf(CompressType.COMPRESS_TYPE_NOOP.getValue());
            }
            hashMap.put("req_compress_type", valueOf);
            initService(hashMap);
            return new QuicForwardReq.a().f(getServiceName()).d(getMethodName()).a(ByteString.of(lastSendByte)).c(hashMap).e(0).build().encode();
        } catch (Exception unused) {
            retryToOtherPipelineReq();
            return null;
        }
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    protected void onDecodeForwardRspData(byte[] bArr, int i3, String str) {
        int length;
        long j3;
        int length2;
        VSBaseRequest vSBaseRequest = this.mVsRequest;
        if (!checkRequestVaild(vSBaseRequest)) {
            QLog.e(VSNetworkHelper.TAG, 1, "discard response because uin has changed! traceId =" + vSBaseRequest.getTraceId());
            notifyRspParseFail(VSNetLightQUICBaseRequest.UIN_VALID_ERROR_CODE);
            return;
        }
        vSBaseRequest.setTrpcRspRetCode(i3);
        vSBaseRequest.setTrpcFailMsg(str);
        long currentTimeMillis = System.currentTimeMillis() - vSBaseRequest.getSendTimeStamp();
        if (vSBaseRequest.getTimeout() <= -1) {
            vSBaseRequest.setNetworkTimeCost(Math.min(currentTimeMillis, 15000L));
        } else {
            vSBaseRequest.setNetworkTimeCost(Math.min(currentTimeMillis, vSBaseRequest.getTimeout()));
        }
        try {
            LightQUICRequest lightQUICRequest = this.mLightRequest;
            if (lightQUICRequest != null) {
                vSBaseRequest.setSsoSeq(lightQUICRequest.hashCode());
            }
            QuicForwardRsp decode = QuicForwardRsp.ADAPTER.decode(bArr);
            byte[] byteArray = decode.body.toByteArray();
            long length3 = bArr.length;
            long length4 = byteArray.length;
            long currentTimeMillis2 = System.currentTimeMillis();
            if (decode.compress_type == CompressType.COMPRESS_TYPE_GZIP.getValue()) {
                byteArray = GzipUtil.gzipDecompress(byteArray);
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[decodeForwardRspData] compress_type: ");
                sb5.append(decode.compress_type);
                sb5.append(" | protoRspSize: ");
                sb5.append(length3);
                sb5.append(" | bytes: ");
                if (byteArray == null) {
                    length2 = 0;
                } else {
                    length2 = byteArray.length;
                }
                sb5.append(length2);
                QLog.d(TAG, 1, sb5.toString());
                j3 = currentTimeMillis3;
            } else {
                if (decode.compress_type != CompressType.COMPRESS_TYPE_ZSTD.getValue() && decode.compress_type != CompressType.COMPRESS_TYPE_ZSTD_DICTIONARY.getValue()) {
                    QLog.d(TAG, 1, "[decodeForwardRspData] compress_type: " + decode.compress_type);
                    j3 = 0L;
                }
                int c16 = (int) Zstd.c(byteArray);
                byte[] bArr2 = new byte[c16];
                long b16 = Zstd.b(bArr2, 0, byteArray, 0, byteArray.length, this.mZstdDictionaryBytes);
                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis2;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("[decodeForwardRspData] compress_type:");
                sb6.append(decode.compress_type);
                sb6.append(" | protoRspSize: ");
                sb6.append(length3);
                sb6.append(" | originLength: ");
                length4 = length4;
                sb6.append(length4);
                sb6.append(" | decompressSize: ");
                sb6.append(b16);
                sb6.append(" | dict size: ");
                byte[] bArr3 = this.mZstdDictionaryBytes;
                if (bArr3 == null) {
                    length = 0;
                } else {
                    length = bArr3.length;
                }
                sb6.append(length);
                sb6.append(" | resultSize: ");
                sb6.append(c16);
                sb6.append(" | unZipCostTime: ");
                sb6.append(currentTimeMillis4);
                QLog.d(TAG, 1, sb6.toString());
                j3 = currentTimeMillis4;
                byteArray = bArr2;
            }
            if (byteArray.length == 0) {
                this.mVsRequest.onQUICEvent(new VSNetQUICEvent(VSNetQUICEvent.EVENT_ID_QUIC_DATA_PARSE_ERROR));
                retryToOtherPipelineReq();
                QLog.d(TAG, 1, "Gzip error try to msf:" + this.mVsRequest.getTraceId());
                return;
            }
            this.mVsRequest.onQUICEvent(new VSNetQUICEvent(VSNetQUICEvent.EVENT_ID_QUIC_DATA_UN_ZIP_SUCCESS).setRspUnZipData(length3, length4, byteArray.length, j3, decode.compress_type));
            PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
            stQWebRsp.busiBuff.set(ByteStringMicro.copyFrom(byteArray));
            byte[] b17 = fh.b(stQWebRsp.toByteArray());
            vSBaseRequest.onQUICEvent(new VSNetQUICEvent(VSNetQUICEvent.EVENT_ID_QUIC_SEND_SUCCESS));
            VSNetworkHelper.getDispatchObserver().onReceive(vSBaseRequest.getContextHashCode(), true, vSBaseRequest, b17);
        } catch (Throwable unused) {
            retryToOtherPipelineReq();
            QLog.d(TAG, 1, "decodeForwardRspData try to msf:" + this.mVsRequest.getTraceId());
        }
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    public void onQUICEvent(VSNetQUICEvent vSNetQUICEvent) {
        this.mVsRequest.onQUICEvent(vSNetQUICEvent);
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    protected void onRequestStats(String str) {
        this.mVsRequest.updateRequestStats(str);
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    protected void onRspParseFail(int i3) {
        notifyRspParseFail(i3);
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    protected void onSsoFailInfo(int i3, String str) {
        this.mVsRequest.setSsoResultCode(i3);
        this.mVsRequest.setSsoFailMsg(str);
    }

    @Override // com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest
    protected void retryToOtherPipelineReq() {
        this.mVsRequest.onQUICEvent(new VSNetQUICEvent(VSNetQUICEvent.EVENT_ID_QUIC_TO_MSF));
        NewIntent newIntent = new NewIntent(BaseApplication.getContext(), VSBaseServlet.class);
        newIntent.putExtra("key_request_data", this.mOriginEncodeBytes);
        newIntent.putExtra(VSBaseServlet.KEY_REQUEST, this.mVsRequest);
        this.mVsRequest.generateSendTimeStamp();
        this.mVsRequest.addRequestInterceptor(new RequestInterceptor() { // from class: com.tencent.biz.richframework.network.quic.VSNetLightQUICForwardRequest.1
            @Override // com.tencent.biz.richframework.network.request.RequestInterceptor
            public /* synthetic */ void interceptRequest(BaseRequest baseRequest) {
                com.tencent.biz.richframework.network.request.a.a(this, baseRequest);
            }

            @Override // com.tencent.biz.richframework.network.request.RequestInterceptor
            public void interceptResponse(Object[] objArr) {
                com.tencent.biz.richframework.network.request.a.b(this, objArr);
                if (VSNetLightQUICForwardRequest.this.mVsRequest == null) {
                    QLog.d(VSNetLightQUICForwardRequest.TAG, 1, "[interceptResponse] mVsRequest == null.");
                } else {
                    VSNetLightQUICIPStrategyManager.instance().recordFailedIpToMap(VSNetLightQUICForwardRequest.this.getHost(), VSNetLightQUICForwardRequest.this.mVsRequest.getQUICEvents(), VSNetLightQUICIPStrategyManager.FAIL_SCENE_PING);
                }
            }
        });
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "[sendRequest] app runtime should not be null.");
        } else {
            peekAppRuntime.startServlet(newIntent);
        }
    }
}

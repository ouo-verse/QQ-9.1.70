package com.tencent.biz.richframework.network.quic;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qzone.reborn.intimate.request.QZoneIntimateBaseRequest;
import com.tencent.biz.qqcircle.utils.cn;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.quic.decode.VSZstdDictionaryManager;
import com.tencent.biz.richframework.network.request.VSNetQUICEvent;
import com.tencent.biz.richframework.util.GzipUtil;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.lightquic.api.IRequestCallback;
import com.tencent.lightquic.api.LightQUICRequest;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qcircle.api.IQFSPlayerStrategyApi;
import com.tencent.mobileqq.qcircle.api.data.QCircleExposeDataBean;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qcircle.cooperation.config.debug.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IQQLiveHEVCAbility;
import com.tencent.richframework.common.RFWCommonGlobalInfo;
import com.tencent.util.AppSetting;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.text.Typography;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import okhttp3.internal.http2.Header;
import org.light.LightVersionInfo;
import org.light.device.OfflineConfig;
import uq3.k;
import uq3.o;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class VSNetLightQUICBaseRequest implements Serializable {
    protected static final long DEF_FAIL_TIME_OUT = 15000;
    private static final String ENABLED_FLAG = "1";
    private static final String FORBIDDEN_FLAG = "0";
    private static final String HOST_DEBUG = "quic.xsj.qq.com";
    private static final String HOST_RELEASE = "quic.xsj.qq.com";
    public static final String NETWORK_ERROR_HINT = "\u7f51\u7edc\u9519\u8bef";
    private static final String PSK_KEY_KEY = "xsj.qq.com";
    public static final String QQCIRCLE_DEBUG_SWITCH_CLOSE_QUIC = "qqcircle_debug_switch_close_quic";
    public static final int UIN_VALID_ERROR_CODE = 90310;
    private static final ThreadLocal<StringBuilder> sRequestStringBuilder = new ThreadLocal<StringBuilder>() { // from class: com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        @NonNull
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };
    private Map<String, String> mHead;
    private String mHost;
    protected boolean mIsGzipCompressed;
    protected LightQUICRequest mLightRequest;
    protected byte[] mOriginEncodeBytes;
    private IRequestCallback mReqCallBack;
    protected byte[] mZstdDictionaryBytes;

    private String buildMetaSdkInfo() {
        if (!TextUtils.isEmpty(LightVersionInfo.VERSION_NAME)) {
            String[] split = LightVersionInfo.VERSION_NAME.split("\\.");
            if (split.length <= 3) {
                return LightVersionInfo.VERSION_NAME;
            }
            return split[0] + "." + split[1] + "." + split[2];
        }
        return "2.0.0";
    }

    private String generateDeviceInfo() {
        Object obj;
        String deviceInfor = PlatformInfor.g().getDeviceInfor();
        StringBuilder sb5 = sRequestStringBuilder.get();
        if (deviceInfor != null && deviceInfor.length() > 0 && sb5 != null) {
            sb5.setLength(0);
            sb5.append(deviceInfor);
            sb5.append(Typography.amp);
            sb5.append("timezone=");
            sb5.append(TimeZone.getDefault().getID());
            sb5.append("&material_sdk_version=");
            sb5.append(buildMetaSdkInfo());
            buildLbsInfo(sb5);
            sb5.append(Typography.amp);
            sb5.append("vh265=");
            if ("".equals(QCircleExposeDataBean.sIsSupportHEVC)) {
                obj = 0;
            } else {
                obj = QCircleExposeDataBean.sIsSupportHEVC;
            }
            sb5.append(obj);
            sb5.append("&refreshrate=");
            sb5.append(getSystemMaxRefreshRate());
            sb5.append("&hwlevel=");
            sb5.append(QCircleVideoDeviceInfoUtils.getVideoDeviceLevel());
            sb5.append("&suphdr=");
            sb5.append(isSupportHDR());
            sb5.append("&is_teenager_mod=");
            sb5.append(((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() ? 1 : 0);
            int hevcDecodeSupportLevel = ((IQQLiveHEVCAbility) QRoute.api(IQQLiveHEVCAbility.class)).hevcDecodeSupportLevel();
            sb5.append("&liveH265=");
            sb5.append(hevcDecodeSupportLevel);
            int phonePerfLevel = OfflineConfig.getPhonePerfLevel(MobileQQ.sMobileQQ);
            sb5.append("&bmst=");
            sb5.append(phonePerfLevel);
            sb5.append("&AV1=");
            sb5.append(getAv1Flag());
            sb5.append("&devicetype=");
            sb5.append(PadUtil.a(RFWApplication.getApplication()));
            if (QLog.isColorLevel()) {
                QLog.d(getRequestTag(), 2, "[generateDeviceInfo] sIsSupportHEVC=", QCircleExposeDataBean.sIsSupportHEVC + " sIsSupportHDR=", ((int) cn.b()) + ", liveH265=", hevcDecodeSupportLevel + ", benchmarkStrategyLevel=", Integer.valueOf(phonePerfLevel));
            }
            return sb5.toString();
        }
        return deviceInfor;
    }

    private String getAv1Flag() {
        return String.valueOf(((IQFSPlayerStrategyApi) QRoute.api(IQFSPlayerStrategyApi.class)).getAV1Flag());
    }

    private int getSystemMaxRefreshRate() {
        try {
            return ScreenUtil.getMaxRefreshRate();
        } catch (Exception e16) {
            QLog.e(getRequestTag(), 1, "getMaxRefreshRateException:", e16);
            return 0;
        }
    }

    private void initCallback() {
        this.mReqCallBack = new IRequestCallback() { // from class: com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest.3
            private static final int QUIC_RECEIVE_TIMEOUT = 315;
            private int mHeaderErrorCode;
            private String mHeaderErrorMsg;
            private int mReceiveLength;
            private final List<byte[]> receivedDataList = new ArrayList();
            private final Map<String, String> mReceiveHeader = new HashMap();

            private boolean isQUICReceiveTimeout(int i3) {
                if (o.C1() && i3 == 315) {
                    return true;
                }
                return false;
            }

            @Override // com.tencent.lightquic.api.IRequestCallback
            public void onBodyReceived(@NonNull byte[] bArr) {
                this.receivedDataList.add(bArr);
                this.mReceiveLength += bArr.length;
            }

            @Override // com.tencent.lightquic.api.IRequestCallback
            public void onHeaderReceived(@NonNull String str) {
                QLog.d(VSNetLightQUICBaseRequest.this.getRequestTag(), 1, "[on QUIC receive header]:" + str + "cdm:" + VSNetLightQUICBaseRequest.this.getCmdName() + "\ntraceId:" + VSNetLightQUICBaseRequest.this.getTraceId());
                String[] split = str.split("\n");
                int length = split.length;
                for (int i3 = 0; i3 < length; i3++) {
                    String str2 = split[i3];
                    int indexOf = str2.indexOf(":");
                    if (indexOf != -1) {
                        String trim = str2.substring(0, indexOf).trim();
                        String trim2 = str2.substring(indexOf + 1).trim();
                        this.mReceiveHeader.put(trim, trim2);
                        if (!TextUtils.equals("trpc-func-ret", trim) && !TextUtils.equals("trpc-ret", trim)) {
                            if (TextUtils.equals("trpc-error-msg", trim) || TextUtils.equals("trpc-error-msg", trim)) {
                                this.mHeaderErrorMsg = trim2;
                            }
                        } else {
                            this.mHeaderErrorCode = Integer.parseInt(trim2);
                        }
                    }
                }
                VSNetLightQUICBaseRequest.this.notifyHandlerHeader(this.mReceiveHeader);
            }

            @Override // com.tencent.lightquic.api.IRequestCallback
            public void onRequestFinished(int i3, @Nullable String str) {
                String str2;
                String requestTag = VSNetLightQUICBaseRequest.this.getRequestTag();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[onRequestFinished] cmd:");
                sb5.append(VSNetLightQUICBaseRequest.this.getCmdName());
                sb5.append(" |traceId:");
                sb5.append(VSNetLightQUICBaseRequest.this.getTraceId());
                sb5.append(" |errorCode:");
                sb5.append(i3);
                sb5.append(" |errorMsg:");
                String str3 = "";
                if (TextUtils.isEmpty(str)) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                sb5.append(str2);
                sb5.append(" |trpc errorCode:");
                sb5.append(this.mHeaderErrorCode);
                sb5.append(" |trpc error msg:");
                if (!TextUtils.isEmpty(this.mHeaderErrorMsg)) {
                    str3 = this.mHeaderErrorMsg;
                }
                sb5.append(str3);
                sb5.append(" |service:");
                sb5.append(VSNetLightQUICBaseRequest.this.getServiceName());
                sb5.append(" |method:");
                sb5.append(VSNetLightQUICBaseRequest.this.getMethodName());
                sb5.append(" |receive length:");
                sb5.append(this.mReceiveLength);
                QLog.i(requestTag, 1, sb5.toString());
                if (i3 != 0) {
                    VSNetLightQUICBaseRequest.this.onQUICEvent(new VSNetQUICEvent(VSNetQUICEvent.EVENT_ID_QUIC_SEND_ERROR).setErrorCode(i3).setEventMsg(str));
                    VSNetLightQUICBaseRequest.this.onSsoFailInfo(i3, str);
                    if (isQUICReceiveTimeout(i3)) {
                        QLog.e(VSNetLightQUICBaseRequest.this.getRequestTag(), 1, "[onRequestFinished] traceId: " + VSNetLightQUICBaseRequest.this.getTraceId() + ", quic receive timeout(" + i3 + ").");
                        VSNetLightQUICBaseRequest.this.onRspParseFail(i3);
                        return;
                    }
                    VSNetLightQUICBaseRequest.this.retryToOtherPipelineReq();
                    QLog.d(VSNetLightQUICBaseRequest.this.getRequestTag(), 1, "[onRequestFinished] on QUIC failed try to msf:" + VSNetLightQUICBaseRequest.this.getTraceId());
                    return;
                }
                if (this.mHeaderErrorCode != 0) {
                    VSNetLightQUICBaseRequest.this.onQUICEvent(new VSNetQUICEvent(VSNetQUICEvent.EVENT_ID_QUIC_HEAD_ERROR).setErrorCode(this.mHeaderErrorCode).setEventMsg(this.mHeaderErrorMsg));
                    VSNetLightQUICBaseRequest.this.retryToOtherPipelineReq();
                    QLog.d(VSNetLightQUICBaseRequest.this.getRequestTag(), 1, "[onRequestFinished] on QUIC head failed try to msf:" + VSNetLightQUICBaseRequest.this.getTraceId());
                    return;
                }
                byte[] bArr = new byte[this.mReceiveLength];
                int i16 = 0;
                for (byte[] bArr2 : this.receivedDataList) {
                    System.arraycopy(bArr2, 0, bArr, i16, bArr2.length);
                    i16 += bArr2.length;
                }
                VSNetLightQUICBaseRequest.this.onDecodeForwardRspData(bArr, this.mHeaderErrorCode, this.mHeaderErrorMsg);
            }

            @Override // com.tencent.lightquic.api.IRequestCallback
            public void onRequestStats(@NonNull String str) {
                VSNetLightQUICBaseRequest.this.onRequestStats(str);
            }
        };
    }

    private void initRequestHeader(String str) {
        byte[] bArr;
        String accountId = RFWApplication.getAccountId();
        String qua3 = QUA.getQUA3();
        String c16 = com.tencent.mobileqq.statistics.o.c();
        String generateDeviceInfo = generateDeviceInfo();
        String traceId = getTraceId();
        HashMap hashMap = new HashMap();
        this.mHead = hashMap;
        hashMap.put(Header.TARGET_METHOD_UTF8, "POST");
        this.mHead.put("Content-Type", "application/protobuf");
        Map<String, String> map = this.mHead;
        if (accountId == null) {
            accountId = "";
        }
        map.put("x-qqvideo-uin", accountId);
        this.mHead.put("x-qqvideo-sigtype", "27");
        Map<String, String> map2 = this.mHead;
        if (str == null) {
            str = "";
        }
        map2.put("x-qqvideo-sig", str);
        this.mHead.put("x-qqvideo-appid", "797");
        Map<String, String> map3 = this.mHead;
        if (qua3 == null) {
            qua3 = "";
        }
        map3.put("x-qqvideo-qua", qua3);
        Map<String, String> map4 = this.mHead;
        if (c16 == null) {
            c16 = "";
        }
        map4.put("x-qqvideo-qimei", c16);
        Map<String, String> map5 = this.mHead;
        if (generateDeviceInfo == null) {
            generateDeviceInfo = "";
        }
        map5.put("x-qqvideo-device", generateDeviceInfo);
        Map<String, String> map6 = this.mHead;
        if (traceId == null) {
            traceId = "";
        }
        map6.put("x-qqvideo-traceid", traceId);
        if (o.G1() && (bArr = this.mZstdDictionaryBytes) != null && bArr.length > 0) {
            this.mHead.put("x-qqvideo-accept-encoding", "0,1,20,21");
        }
    }

    private void initZstdDictionary() {
        if (!o.G1()) {
            return;
        }
        byte[] bArr = this.mZstdDictionaryBytes;
        if (bArr != null && bArr.length > 0) {
            return;
        }
        VSZstdDictionaryManager.instance().loadZstdDictionary(new VSZstdDictionaryManager.OnVSZstdDictionaryCallback() { // from class: com.tencent.biz.richframework.network.quic.a
            @Override // com.tencent.biz.richframework.network.quic.decode.VSZstdDictionaryManager.OnVSZstdDictionaryCallback
            public final void onZstdDictionary(byte[] bArr2) {
                VSNetLightQUICBaseRequest.this.lambda$initZstdDictionary$0(bArr2);
            }
        });
    }

    private String isSupportHDR() {
        if (cn.e()) {
            return "0";
        }
        return String.valueOf((int) cn.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initZstdDictionary$0(byte[] bArr) {
        this.mZstdDictionaryBytes = bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPsKeySuccess(String str) {
        isForceTestQUIC();
        this.mHost = "quic.xsj.qq.com";
        initCallback();
        initZstdDictionary();
        initRequestHeader(str);
        byte[] obtainWrapBody = obtainWrapBody();
        if (obtainWrapBody != null && obtainWrapBody.length > 0) {
            this.mHead.put("Content-Length", String.valueOf(obtainWrapBody.length));
            sendToLightQUiC(obtainWrapBody);
        } else {
            QLog.w(getRequestTag(), 1, "[onPsKeySuccess] last body bytes should not is null.");
        }
    }

    private void sendToLightQUiC(byte[] bArr) {
        LightQUICRequest lightQUICRequest = this.mLightRequest;
        if (lightQUICRequest != null) {
            lightQUICRequest.cancelRequest();
        }
        this.mLightRequest = VSNetLightNewQUICEngin.g().startRequest(this, bArr);
    }

    protected abstract void buildLbsInfo(StringBuilder sb5);

    public IRequestCallback getCallBack() {
        return this.mReqCallBack;
    }

    public abstract String getCmdName();

    public Map<String, String> getHead() {
        return this.mHead;
    }

    public String getHost() {
        return this.mHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] getLastSendByte(byte[] bArr) {
        boolean z16 = true;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_quic_send_zip", true)) {
            return bArr;
        }
        int parseInt = Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_enanle_quic_zip_min_size", "2560"));
        int length = bArr.length;
        if (length < parseInt) {
            long j3 = length;
            onQUICEvent(new VSNetQUICEvent(VSNetQUICEvent.EVENT_ID_QUIC_REQ_ZIP).setReqZipData(j3, j3, 0L));
            return bArr;
        }
        long currentTimeMillis = System.currentTimeMillis();
        byte[] gzipCompress = GzipUtil.gzipCompress(bArr);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (gzipCompress.length >= length) {
            z16 = false;
        }
        this.mIsGzipCompressed = z16;
        onQUICEvent(new VSNetQUICEvent(VSNetQUICEvent.EVENT_ID_QUIC_REQ_ZIP).setReqZipData(length, gzipCompress.length, currentTimeMillis2));
        RFWLog.i(getRequestTag(), RFWLog.USR, "[zip encode success] ,CmdName:" + getCmdName() + " requestBizData length, beforeCompress:" + length + ", afterCompress:" + gzipCompress.length + ", costTime:" + currentTimeMillis2);
        if (!this.mIsGzipCompressed) {
            return bArr;
        }
        return gzipCompress;
    }

    public abstract String getMethodName();

    protected abstract String getRequestTag();

    public abstract String getServiceName();

    public abstract String getTraceId();

    public abstract String getURL();

    /* JADX INFO: Access modifiers changed from: protected */
    public void initService(HashMap<String, String> hashMap) {
        hashMap.put(QZoneIntimateBaseRequest.QZONE_INTIMATE_REQUEST_CLOUD_APP_ID_KEY, "92");
        if (!isForceTestQUIC()) {
            return;
        }
        if (!TextUtils.equals(RFWCommonGlobalInfo.getCurMsfServerId(), "production")) {
            hashMap.put("env_id", RFWCommonGlobalInfo.getCurMsfServerId());
        }
        QLog.d(getRequestTag(), 1, "set debug environment:" + RFWCommonGlobalInfo.getCurMsfServerId());
    }

    protected boolean isDebugEnvCloseQUIC() {
        if (AppSetting.isGrayVersion() || AppSetting.isPublicVersion() || AppSetting.isGooglePlayVersion() || !k.b().c(QQCIRCLE_DEBUG_SWITCH_CLOSE_QUIC, false)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isForceTestQUIC() {
        if (AppSetting.isGrayVersion() || AppSetting.isPublicVersion() || AppSetting.isGooglePlayVersion() || !c.h(QCircleDebugKey$SwitchStateKey.QQCIRCLE_DEBUG_FORCE_USE_TEST_QUIC_URL, 0)) {
            return false;
        }
        return true;
    }

    protected abstract byte[] obtainWrapBody();

    protected abstract void onDecodeForwardRspData(byte[] bArr, int i3, String str);

    public abstract void onQUICEvent(VSNetQUICEvent vSNetQUICEvent);

    protected abstract void onRequestStats(String str);

    protected abstract void onRspParseFail(int i3);

    protected abstract void onSsoFailInfo(int i3, String str);

    protected abstract void retryToOtherPipelineReq();

    public VSNetLightQUICBaseRequest setEncodeData(byte[] bArr) {
        this.mOriginEncodeBytes = bArr;
        return this;
    }

    public void startRequest() {
        onQUICEvent(new VSNetQUICEvent(VSNetQUICEvent.EVENT_ID_QUIC_START));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            onQUICEvent(new VSNetQUICEvent(VSNetQUICEvent.EVENT_ID_QUIC_PSKEY_ERROR).setPsKeyCost(0L));
            retryToOtherPipelineReq();
            QLog.e(getRequestTag(), 1, "[sendRequest] app runtime should not be null.");
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            if (!isForceTestQUIC() && isDebugEnvCloseQUIC()) {
                QLog.d(getRequestTag(), 1, "[startRequest] current env close quic, switch msf request.");
                retryToOtherPipelineReq();
            } else {
                ((IPskeyManager) peekAppRuntime.getRuntimeService(IPskeyManager.class, "all")).getPskey(new String[]{PSK_KEY_KEY}, new sd2.a() { // from class: com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest.2
                    @Override // sd2.a
                    public void onFail(@NonNull String str) {
                        VSNetLightQUICBaseRequest.this.onQUICEvent(new VSNetQUICEvent(VSNetQUICEvent.EVENT_ID_QUIC_PSKEY_ERROR).setPsKeyCost(System.currentTimeMillis() - currentTimeMillis));
                        VSNetLightQUICBaseRequest.this.retryToOtherPipelineReq();
                        QLog.e(VSNetLightQUICBaseRequest.this.getRequestTag(), 1, "[sendRequest] on pskey failed retry to msf:" + VSNetLightQUICBaseRequest.this.getTraceId());
                    }

                    @Override // sd2.a
                    public void onSuccess(@NonNull Map<String, String> map) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        QLog.d(VSNetLightQUICBaseRequest.this.getRequestTag(), 1, "[sendRequest] on pskey success: |cmd:" + VSNetLightQUICBaseRequest.this.getCmdName() + " |traceId:" + VSNetLightQUICBaseRequest.this.getTraceId() + "psk costTime:" + currentTimeMillis2);
                        VSNetLightQUICBaseRequest.this.onQUICEvent(new VSNetQUICEvent(VSNetQUICEvent.EVENT_ID_QUIC_PSKEY_SUCCESS).setPsKeyCost(currentTimeMillis2));
                        VSNetLightQUICBaseRequest.this.onPsKeySuccess(map.get(VSNetLightQUICBaseRequest.PSK_KEY_KEY));
                    }
                });
            }
        } catch (Exception e16) {
            onQUICEvent(new VSNetQUICEvent(VSNetQUICEvent.EVENT_ID_QUIC_PSKEY_ERROR).setPsKeyCost(System.currentTimeMillis() - currentTimeMillis));
            retryToOtherPipelineReq();
            QLog.e(getRequestTag(), 1, "[sendRequest] psk Manger expection:" + getTraceId(), e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyHandlerHeader(Map<String, String> map) {
    }
}

package com.tencent.biz.richframework.network.request;

import NS_QWEB_PROTOCAL.PROTOCAL;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.utils.cn;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.IQFSPlayerStrategyApi;
import com.tencent.mobileqq.qcircle.api.data.QCircleExposeDataBean;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IQQLiveHEVCAbility;
import com.tencent.util.AppSetting;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.util.Collections;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.text.Typography;
import mqq.app.MobileQQ;
import org.light.LightVersionInfo;
import org.light.device.OfflineConfig;
import uq3.o;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class VSBaseRequest extends BaseRequest {
    private static final String ENABLED_FLAG = "1";
    private static final String FORBIDDEN_FLAG = "0";
    protected static final ThreadLocal<StringBuilder> sRequestStringBuilder = new ThreadLocal<StringBuilder>() { // from class: com.tencent.biz.richframework.network.request.VSBaseRequest.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        @NonNull
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };
    private long mNetworkTimeCost;
    private String mRequestUin;
    private String mSsoFailMsg;
    private int mSsoResultCode;
    private int mSsoSeq;
    private PROTOCAL.StQWebRsp mStQWebRsp;
    private String trpcFailMsg;
    private int trpcRspFuncRetCode;
    private int trpcRspRetCode;
    private long mTimeout = -1;
    private final String mQUA3 = QUA.getQUA3();
    private final Map<String, VSNetQUICEvent> mQUICEvent = new ConcurrentHashMap();
    private final AtomicReference<String> mQUICRequestStats = new AtomicReference<>();

    private void buildLbsInfo(StringBuilder sb5) {
        SosoLbsInfo cachedLbsInfo;
        if (((!AppSetting.isGrayVersion() && !AppSetting.isPublicVersion()) || !o.h()) && (cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("qqcircle")) != null && cachedLbsInfo.mLocation != null) {
            sb5.append(Typography.amp);
            sb5.append("latitude=");
            sb5.append(getLatitude(cachedLbsInfo));
            sb5.append(Typography.amp);
            sb5.append("longitude=");
            sb5.append(getLongitude(cachedLbsInfo));
        }
    }

    private String getAv1Flag() {
        return String.valueOf(((IQFSPlayerStrategyApi) QRoute.api(IQFSPlayerStrategyApi.class)).getAV1Flag());
    }

    private static int getSystemMaxRefreshRate() {
        try {
            return ScreenUtil.getMaxRefreshRate();
        } catch (Exception e16) {
            QLog.e(BaseRequest.TAG, 1, "getMaxRefreshRateException:", e16);
            return 0;
        }
    }

    private String isSupportHDR() {
        if (cn.e()) {
            return "0";
        }
        return String.valueOf((int) cn.b());
    }

    protected String buildMetaSdkInfo() {
        if (!TextUtils.isEmpty(LightVersionInfo.VERSION_NAME)) {
            String[] split = LightVersionInfo.VERSION_NAME.split("\\.");
            if (split.length <= 3) {
                return LightVersionInfo.VERSION_NAME;
            }
            return split[0] + "." + split[1] + "." + split[2];
        }
        return "2.0.0";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String generateDeviceInfo() {
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
                QLog.d(BaseRequest.TAG, 2, "[generateDeviceInfo] sIsSupportHEVC=", QCircleExposeDataBean.sIsSupportHEVC + " sIsSupportHDR=", ((int) cn.b()) + ", liveH265=", hevcDecodeSupportLevel + ", benchmarkStrategyLevel=", Integer.valueOf(phonePerfLevel));
            }
            return sb5.toString();
        }
        return deviceInfor;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getFinalRequestData(byte[] bArr) {
        byte[] requestWrapper = getRequestWrapper(ByteStringMicro.copyFrom(bArr));
        if (requestWrapper != null) {
            return requestWrapper;
        }
        return new byte[0];
    }

    public String getLatitude(SosoLbsInfo sosoLbsInfo) {
        return String.valueOf(sosoLbsInfo.mLocation.mLat02);
    }

    public String getLongitude(SosoLbsInfo sosoLbsInfo) {
        return String.valueOf(sosoLbsInfo.mLocation.mLon02);
    }

    public String getMethodName() {
        return "";
    }

    public long getNetworkTimeCost() {
        return this.mNetworkTimeCost;
    }

    public Map<String, VSNetQUICEvent> getQUICEvents() {
        return this.mQUICEvent;
    }

    public String getQUICRequestStats() {
        return this.mQUICRequestStats.get();
    }

    public String getRequestUin() {
        return this.mRequestUin;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] getRequestWrapper(ByteStringMicro byteStringMicro) {
        PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
        stQWebReq.Seq.set(getCurrentSeq());
        stQWebReq.qua.set(this.mQUA3);
        stQWebReq.deviceInfo.set(generateDeviceInfo());
        stQWebReq.busiBuff.set(byteStringMicro);
        stQWebReq.traceid.set(this.mTraceId);
        return stQWebReq.toByteArray();
    }

    @NonNull
    public Map<String, Object> getSSOAttributes() {
        return Collections.emptyMap();
    }

    public String getServiceName() {
        return "";
    }

    public String getSsoFailMsg() {
        return this.mSsoFailMsg;
    }

    public int getSsoResultCode() {
        return this.mSsoResultCode;
    }

    public int getSsoSeq() {
        return this.mSsoSeq;
    }

    public long getTimeout() {
        return this.mTimeout;
    }

    public String getTrpcFailMsg() {
        return this.trpcFailMsg;
    }

    public int getTrpcRspFuncRetCode() {
        return this.trpcRspFuncRetCode;
    }

    public int getTrpcRspRetCode() {
        return this.trpcRspRetCode;
    }

    public Boolean isWithouLogin() {
        return Boolean.FALSE;
    }

    public void onQUICEvent(VSNetQUICEvent vSNetQUICEvent) {
        this.mQUICEvent.put(vSNetQUICEvent.getEventKey(), vSNetQUICEvent);
        VSNetQUICFailStat.instance().updateReqQUICInfo(this, vSNetQUICEvent);
        QLog.d(BaseRequest.TAG, 1, "onQUICEvent:" + vSNetQUICEvent + "| CDM" + getCmdName() + "| traceId " + getTraceId() + "| service:" + getServiceName() + "| method:" + getMethodName());
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public Object[] parseResponseHeadInfo(byte[] bArr) {
        Object[] objArr = new Object[3];
        PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
        try {
            stQWebRsp.mergeFrom(fh.a(bArr));
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        objArr[0] = Long.valueOf(stQWebRsp.retCode.get());
        objArr[1] = stQWebRsp.errMsg.get().toStringUtf8();
        objArr[2] = stQWebRsp.busiBuff.get().toByteArray();
        this.mStQWebRsp = stQWebRsp;
        return objArr;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public Object[] proceedResponseInterceptor(BaseRequest baseRequest, boolean z16, long j3, String str, @Nullable Object obj) {
        reportCmdSuccessRate(baseRequest, this.mStQWebRsp, obj);
        return super.proceedResponseInterceptor(baseRequest, z16, j3, str, obj);
    }

    public void setNetworkTimeCost(long j3) {
        this.mNetworkTimeCost = j3;
    }

    public void setRequestUin(String str) {
        this.mRequestUin = str;
    }

    public void setSsoFailMsg(String str) {
        this.mSsoFailMsg = str;
    }

    public void setSsoResultCode(int i3) {
        this.mSsoResultCode = i3;
    }

    public void setSsoSeq(int i3) {
        this.mSsoSeq = i3;
    }

    public void setTimeout(long j3) {
        this.mTimeout = j3;
    }

    public void setTrpcFailMsg(String str) {
        this.trpcFailMsg = str;
    }

    public void setTrpcRspFuncRetCode(int i3) {
        this.trpcRspFuncRetCode = i3;
    }

    public void setTrpcRspRetCode(int i3) {
        this.trpcRspRetCode = i3;
    }

    public void updateRequestStats(String str) {
        this.mQUICRequestStats.set(str);
    }

    public void reportCmdSuccessRate(BaseRequest baseRequest, PROTOCAL.StQWebRsp stQWebRsp, @Nullable Object obj) {
    }
}

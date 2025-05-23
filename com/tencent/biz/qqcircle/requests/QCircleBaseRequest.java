package com.tencent.biz.qqcircle.requests;

import NS_COMM.COMM;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.qzone.reborn.intimate.request.QZoneIntimateBaseRequest;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.richframework.network.request.VSNetQUICUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.common.RFWCommonGlobalInfo;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qqcircle.report.QCircleReporter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class QCircleBaseRequest extends VSBaseRequest {
    protected static final String KEY_REPORT_REQUEST_LOAD_MORE = "0";
    protected static final String KEY_REPORT_REQUEST_REFRESH = "1";

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static abstract class a<R extends QCircleBaseRequest> {

        /* renamed from: a, reason: collision with root package name */
        protected R f91858a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f91859b = false;

        public R a() {
            R b16 = b();
            this.f91858a = b16;
            b16.setEnableCache(this.f91859b);
            return this.f91858a;
        }

        protected abstract R b();

        /* JADX INFO: Access modifiers changed from: protected */
        public String c(String str) {
            if (str == null) {
                QLog.i(BaseRequest.TAG, 1, "[getSafeParam] -> param is null");
                return "";
            }
            return str;
        }

        public a<R> d() {
            this.f91859b = true;
            return this;
        }
    }

    private String getGwRpTransfer(PROTOCAL.StQWebRsp stQWebRsp) {
        if (stQWebRsp != null && !stQWebRsp.Extinfo.isEmpty()) {
            for (COMM.Entry entry : stQWebRsp.Extinfo.get()) {
                if (entry != null && "gwRPTransfer".equals(entry.key.get())) {
                    return entry.value.get();
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getAttachInfo() {
        return null;
    }

    public QCircleAlphaUserReportDataBuilder getCmdSuccessRateEventData(BaseRequest baseRequest, PROTOCAL.StQWebRsp stQWebRsp, @Nullable Object obj) {
        long ssoResultCode;
        String ssoFailMsg;
        if (getSsoResultCode() == 1000 && stQWebRsp != null) {
            ssoResultCode = stQWebRsp.retCode.get();
            ssoFailMsg = stQWebRsp.errMsg.get().toStringUtf8();
        } else {
            ssoResultCode = getSsoResultCode();
            ssoFailMsg = getSsoFailMsg();
        }
        return VSNetQUICUtils.wrapQUIC(baseRequest, new QCircleAlphaUserReportDataBuilder().setCmd(getCmdName()).setSvrRetCode(String.valueOf(ssoResultCode)).setRetCode(getRetCode()).setInfo(getInfo()).setMsg(ssoFailMsg).setTimeCost(getNetworkTimeCost()).setUrl(getUrl()).setRate(getRate()).setType(getType()).setRefer(getRefer()).setAttachInfo(getAttachInfo()).setExtraInfo(getTraceId()).setCount(getCount(obj)).setState(getState()).setFeedId(getFeedId()).setUser(getUser()).setExtras(getExtras()).setGwRpTransfer(getGwRpTransfer(stQWebRsp)).setExt1(getExt1()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getCount(@Nullable Object obj) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getExt1() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HashMap<String, String> getExtras() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getFeedId() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getInfo() {
        return null;
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getLatitude(SosoLbsInfo sosoLbsInfo) {
        if (QCircleApplication.isRDMVersion() && QCirclePluginGlobalInfo.j() != null && !TextUtils.isEmpty(QCirclePluginGlobalInfo.j().latitude)) {
            return QCirclePluginGlobalInfo.j().latitude;
        }
        return super.getLatitude(sosoLbsInfo);
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getLongitude(SosoLbsInfo sosoLbsInfo) {
        if (QCircleApplication.isRDMVersion() && QCirclePluginGlobalInfo.j() != null && !TextUtils.isEmpty(QCirclePluginGlobalInfo.j().longitude)) {
            return QCirclePluginGlobalInfo.j().longitude;
        }
        return super.getLongitude(sosoLbsInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public double getRate() {
        return 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getRefer() {
        return null;
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    protected byte[] getRequestWrapper(ByteStringMicro byteStringMicro) {
        PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
        try {
            stQWebReq.mergeFrom(super.getRequestWrapper(byteStringMicro));
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        COMM.Entry entry = new COMM.Entry();
        entry.key.set(QZoneIntimateBaseRequest.QZONE_INTIMATE_REQUEST_CLOUD_APP_ID_KEY);
        entry.value.set("92");
        stQWebReq.Extinfo.add(entry);
        COMM.Entry entry2 = new COMM.Entry();
        entry2.key.set("sw-plugin-qua");
        entry2.value.set(QCirclePluginGlobalInfo.v());
        stQWebReq.Extinfo.add(entry2);
        COMM.Entry entry3 = new COMM.Entry();
        entry3.key.set("environment_id");
        entry3.value.set(RFWCommonGlobalInfo.getCurMsfServerId());
        stQWebReq.Extinfo.add(entry3);
        return stQWebReq.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getRetCode() {
        return null;
    }

    public long[] getRetryRetCodes() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getState() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getType() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getUrl() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getUser() {
        return null;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public boolean isNeedRetry(long j3) {
        boolean z16;
        if (j3 == -2) {
            z16 = false;
        } else {
            z16 = true;
        }
        long[] retryRetCodes = getRetryRetCodes();
        if (retryRetCodes != null && retryRetCodes.length > 0) {
            int length = retryRetCodes.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    if (retryRetCodes[i3] == j3) {
                        z16 = true;
                        break;
                    }
                    i3++;
                } else {
                    z16 = false;
                    break;
                }
            }
        }
        QLog.d(BaseRequest.TAG, 1, "CmdName:", getCmdName(), ",retCode:", Long.valueOf(j3), "isNeedRetry:" + z16);
        return z16;
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public void reportCmdSuccessRate(final BaseRequest baseRequest, final PROTOCAL.StQWebRsp stQWebRsp, @Nullable final Object obj) {
        super.reportCmdSuccessRate(baseRequest, stQWebRsp, obj);
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.requests.QCircleBaseRequest.1
            @Override // java.lang.Runnable
            public void run() {
                QCircleAlphaUserReporter.reportCmdSuccessRateEvent(QCircleBaseRequest.this.getCmdSuccessRateEventData(baseRequest, stQWebRsp, obj));
            }
        });
    }
}

package com.tencent.biz.richframework.network.servlet;

import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.CallSuper;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.richframework.network.request.VSRequestStrategy;
import com.tencent.biz.richframework.network.resend.QCircleResendIntercept;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.fh;
import com.tencent.open.base.a;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.QCircleConfig;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VSBaseServlet extends MSFServlet {
    public static final String KEY_NETWORK_TIME_COST = "key_network_time_cost";
    public static final String KEY_REQUEST = "key_request";
    public static final String KEY_REQUEST_DATA = "key_request_data";
    public static final String KEY_RESPONSE_MSG = "key_response_msg";
    public static final String KEY_SEND_TIMESTAMP = "key_send_timestamp";
    public static final String SECONDARY_VS_TIME_OUT_TIME = "secondary_vs_time_out_time";
    public static final long TIMEOUT_TIME = QCircleConfig.getInstance().getConfigValue("qqcircle", SECONDARY_VS_TIME_OUT_TIME, (Integer) 20000).intValue();
    public static final int VS_TIME_OUT_TIME_DEFAULT_VALUE = 20000;
    private long mTimeoutPrint = 20000;
    private volatile long mLastCheckTimeStamp = 0;
    private final QCircleResendIntercept mQCircleResendIntercept = new QCircleResendIntercept();

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

    private void endTraceReport(String str, FromServiceMsg fromServiceMsg) {
        int resultCode;
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        try {
            String c16 = a.c(com.tencent.open.adapter.a.f().e());
            HashMap hashMap = new HashMap();
            hashMap.put("rfw_trace_id", str);
            int i3 = 0;
            if (fromServiceMsg.isSuccess()) {
                resultCode = 0;
            } else {
                resultCode = fromServiceMsg.getResultCode();
            }
            hashMap.put("result", String.valueOf(resultCode));
            hashMap.put("err_msg", fromServiceMsg.getBusinessFailMsg());
            hashMap.put("network", c16);
            IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class);
            hashMap.put("source", "gpro_cssender");
            iQQOpenTelemetryReportApi.setOpenTelemetryTaskAttributes(str, hashMap);
            if (!fromServiceMsg.isSuccess()) {
                i3 = fromServiceMsg.getResultCode();
            }
            iQQOpenTelemetryReportApi.setStatusCode(str, i3);
            iQQOpenTelemetryReportApi.endOpenTelemetryTask(str);
        } catch (Exception e16) {
            QLog.e(MSFServlet.TAG, 1, "endVSBaseServletReport:", e16);
        }
    }

    private void startTraceReport(BaseRequest baseRequest) {
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        try {
            IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class);
            iQQOpenTelemetryReportApi.setOpenTelemetryTaskAttributes(iQQOpenTelemetryReportApi.startOpenTelemetryTask(baseRequest.getCmd(), baseRequest.getTraceId()), new HashMap());
        } catch (Exception e16) {
            QLog.e(MSFServlet.TAG, 1, "startVSBaseServletReport:", e16);
        }
    }

    private void updateRequestStrategy() {
        if (!QCircleConfig.getWnsRequestStrategyEnable()) {
            return;
        }
        if (SystemClock.elapsedRealtime() - this.mLastCheckTimeStamp > QCircleConfig.getWnsRequestCheckInterval().longValue()) {
            RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.richframework.network.servlet.VSBaseServlet.1
                @Override // java.lang.Runnable
                public void run() {
                    VSNetworkHelper.getInstance().getVSRequestStrategy().updateConfigByTimeStamp(QCircleConfig.getWnsRequestStrategyConfig());
                    QLog.i(VSRequestStrategy.TAG, 1, "requestStrategy update success");
                }
            });
            this.mLastCheckTimeStamp = SystemClock.elapsedRealtime();
        } else {
            QLog.i(VSRequestStrategy.TAG, 1, "requestStrategy update frequency limit");
        }
    }

    @Override // mqq.app.MSFServlet
    @CallSuper
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        BaseRequest baseRequest = (BaseRequest) intent.getSerializableExtra(KEY_REQUEST);
        if (baseRequest == null) {
            QLog.e(VSNetworkHelper.TAG, 1, "onReceive. KEY_REQUEST_DATA is Null.");
            return;
        }
        if (this.mQCircleResendIntercept.isNeedFastResend(intent, fromServiceMsg)) {
            this.mQCircleResendIntercept.handlerFastResend(intent, fromServiceMsg);
            return;
        }
        if (!checkRequestVaild(baseRequest)) {
            QLog.e(VSNetworkHelper.TAG, 1, "discard response because uin has changed! traceId =" + baseRequest.getTraceId());
            return;
        }
        if (baseRequest instanceof VSBaseRequest) {
            VSBaseRequest vSBaseRequest = (VSBaseRequest) baseRequest;
            vSBaseRequest.setSsoResultCode(fromServiceMsg.getResultCode());
            vSBaseRequest.setSsoFailMsg(fromServiceMsg.getBusinessFailMsg());
            vSBaseRequest.setTrpcRspRetCode(fromServiceMsg.getTrpcRspRetCode());
            vSBaseRequest.setTrpcRspFuncRetCode(fromServiceMsg.getTrpcRspFuncRetCode());
            vSBaseRequest.setTrpcFailMsg(new String(fromServiceMsg.getTrpcRspErrorMsg()));
            long currentTimeMillis = System.currentTimeMillis() - baseRequest.getSendTimeStamp();
            if (vSBaseRequest.getTimeout() <= -1) {
                vSBaseRequest.setNetworkTimeCost(Math.min(currentTimeMillis, TIMEOUT_TIME));
            } else {
                vSBaseRequest.setNetworkTimeCost(Math.min(currentTimeMillis, vSBaseRequest.getTimeout()));
            }
            vSBaseRequest.setSsoSeq(fromServiceMsg.getRequestSsoSeq());
            if (currentTimeMillis > vSBaseRequest.getTimeout()) {
                QLog.i(VSNetworkHelper.TAG, 1, " cmd:" + vSBaseRequest.getCmd() + " resultCode:" + fromServiceMsg.getResultCode() + " traceId:" + vSBaseRequest.getTraceId() + " ssoReq:" + fromServiceMsg.getRequestSsoSeq() + ", netWorkTimeCost:" + currentTimeMillis + ", requestTimeOut:" + vSBaseRequest.getTimeout());
            } else {
                QLog.i(VSNetworkHelper.TAG, 1, " cmd:" + vSBaseRequest.getCmd() + " resultCode:" + fromServiceMsg.getResultCode() + " traceId:" + vSBaseRequest.getTraceId() + " ssoReq:" + fromServiceMsg.getRequestSsoSeq());
            }
        }
        VSNetworkHelper.getDispatchObserver().onReceive(baseRequest.getContextHashCode(), fromServiceMsg.isSuccess(), baseRequest, fromServiceMsg.getWupBuffer());
        if (baseRequest.isEnableTraceReport()) {
            endTraceReport(baseRequest.getTraceId(), fromServiceMsg);
        }
    }

    @Override // mqq.app.MSFServlet
    @CallSuper
    public void onSend(Intent intent, Packet packet) {
        long j3;
        Map<String, Object> map;
        updateRequestStrategy();
        BaseRequest baseRequest = (BaseRequest) intent.getSerializableExtra(KEY_REQUEST);
        byte[] bArr = (byte[]) intent.getSerializableExtra("key_request_data");
        if (bArr == null) {
            bArr = new byte[4];
        }
        intent.putExtra(KEY_SEND_TIMESTAMP, System.currentTimeMillis());
        packet.setSSOCommand(baseRequest.getCmd());
        packet.setTraceInfo(baseRequest.getTraceId());
        packet.putSendData(fh.b(bArr));
        boolean z16 = baseRequest instanceof VSBaseRequest;
        if (z16) {
            j3 = ((VSBaseRequest) baseRequest).getTimeout();
        } else {
            j3 = -1;
        }
        if (j3 <= 0) {
            j3 = TIMEOUT_TIME;
        }
        packet.setTimeout(j3);
        if (z16) {
            map = ((VSBaseRequest) baseRequest).getSSOAttributes();
        } else {
            map = null;
        }
        if (map != null) {
            HashMap<String, Object> attributes = packet.getAttributes();
            if (attributes == null) {
                attributes = new HashMap<>();
                packet.setAttributes(attributes);
            }
            attributes.putAll(map);
        }
        this.mQCircleResendIntercept.updateFastResendFlag(baseRequest, packet);
        if (this.mTimeoutPrint != j3) {
            QLog.d(MSFServlet.TAG, 1, "[onSend] timeout : " + j3 + " | cmd name: " + baseRequest.getCmd());
            this.mTimeoutPrint = j3;
        }
        if (baseRequest.isEnableTraceReport()) {
            startTraceReport(baseRequest);
        }
    }
}

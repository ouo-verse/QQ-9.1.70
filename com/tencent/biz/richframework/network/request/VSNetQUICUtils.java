package com.tencent.biz.richframework.network.request;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.qcircle.api.IQCircleQuicReqApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VSNetQUICUtils {
    public static final String NORMAL_CODE = "0";
    private static String REPORT_DATA_CMD = "FeedCloudSvr.trpc.circlereport.clientreport.ClientReport.DataReport";
    private static final String TAG = "VSNetQUICUtils";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class QUICReqStats {
        private long mConnectDurationMs;
        private int mFirstDataDurationMs;
        private int mReorderTimeoutCount;

        QUICReqStats() {
        }
    }

    private static String attachExp(String str, VSBaseRequest vSBaseRequest) {
        if (TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("S2", VSNetQUICExp.getExpName());
                return "exp=" + jSONObject;
            } catch (JSONException e16) {
                QLog.d(TAG, 1, e16, new Object[0]);
                return str;
            }
        }
        if (str.contains("exp=")) {
            StringBuilder sb5 = new StringBuilder();
            int i3 = 0;
            for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                if (str2.contains("exp=")) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2.split(ContainerUtils.KEY_VALUE_DELIMITER)[1]);
                        jSONObject2.put("S2", VSNetQUICExp.getExpName());
                        str2 = "exp=" + jSONObject2;
                    } catch (JSONException e17) {
                        QLog.d(TAG, 1, e17, new Object[0]);
                    }
                    if (i3 == 0) {
                        sb5.append(str2);
                    } else {
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                        sb5.append(str2);
                    }
                    i3++;
                }
            }
            return sb5.toString();
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("S2", VSNetQUICExp.getExpName());
            return str + ContainerUtils.FIELD_DELIMITER + ("exp=" + jSONObject3);
        } catch (JSONException e18) {
            QLog.d(TAG, 1, e18, new Object[0]);
            return str;
        }
    }

    private static String attachQUICInfo(String str, VSBaseRequest vSBaseRequest) {
        Object obj;
        if (!VSNetQUICExp.isEnabledQUICNetReq()) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String str2 = "1";
            if (fallBackToMSF(vSBaseRequest)) {
                obj = "1";
            } else {
                obj = "0";
            }
            jSONObject.put("fallback_msf", obj);
            if (!VSNetQUICFailStat.instance().isFailUpperLimit()) {
                str2 = "0";
            }
            jSONObject.put("beyond_max_fail_cnt", str2);
            jSONObject.put(IPrefRecorder.MILESTONE_AI_ELIMINATE_TOTAL_COST, getTotalCostTime(vSBaseRequest));
            jSONObject.put("recv_size", getProtoRspSize(vSBaseRequest));
            jSONObject.put("recv_zip_size", getRecvSize(vSBaseRequest));
            jSONObject.put("recv_unzip_size", getUnZipSize(vSBaseRequest));
            jSONObject.put("zip_type", getUnZipType(vSBaseRequest));
            jSONObject.put("un_zip_cost", getUzipCost(vSBaseRequest));
            jSONObject.put("send_size", getSendZipSize(vSBaseRequest));
            jSONObject.put("send_unzip_size", getSendSize(vSBaseRequest));
            jSONObject.put("zip_cost", getZipCost(vSBaseRequest));
            jSONObject.put("ret_code", getRetCode(vSBaseRequest));
            jSONObject.put("dns_ip", getDnsIp(vSBaseRequest));
            jSONObject.put("psk_time", getPskTime(vSBaseRequest));
            QUICReqStats reqStats = getReqStats(vSBaseRequest);
            if (reqStats != null) {
                jSONObject.put("conn_cost", reqStats.mConnectDurationMs);
                jSONObject.put("header_cost", reqStats.mFirstDataDurationMs);
                jSONObject.put("reorder_timeout_cnt", reqStats.mReorderTimeoutCount);
            }
            if (TextUtils.isEmpty(str)) {
                return "quic=" + jSONObject;
            }
            return str + "&quic=" + jSONObject;
        } catch (Exception unused) {
            QLog.d(TAG, 1, "ignore np");
            return str;
        }
    }

    public static boolean fallBackToMSF(VSBaseRequest vSBaseRequest) {
        if (vSBaseRequest == null) {
            return false;
        }
        return vSBaseRequest.getQUICEvents().containsKey(VSNetQUICEvent.EVENT_ID_QUIC_TO_MSF);
    }

    private static String getDnsIp(VSBaseRequest vSBaseRequest) {
        try {
            VSNetQUICEvent obtainQuicEvent = obtainQuicEvent(vSBaseRequest, VSNetQUICEvent.EVENT_ID_DNS_SUCCESS);
            if (obtainQuicEvent == null) {
                return "";
            }
            return String.valueOf(obtainQuicEvent.getDNSIP());
        } catch (Exception unused) {
            QLog.d(TAG, 1, "ignore np");
            return "";
        }
    }

    private static String getProtoRspSize(VSBaseRequest vSBaseRequest) {
        try {
            VSNetQUICEvent obtainQuicEvent = obtainQuicEvent(vSBaseRequest, VSNetQUICEvent.EVENT_ID_QUIC_DATA_UN_ZIP_SUCCESS);
            if (obtainQuicEvent == null) {
                return "0";
            }
            return String.valueOf(obtainQuicEvent.getProtoRspSize());
        } catch (Exception e16) {
            QLog.d(TAG, 1, "[ignore np] ex:", e16);
            return "0";
        }
    }

    private static String getPskTime(VSBaseRequest vSBaseRequest) {
        try {
            VSNetQUICEvent obtainQuicEvent = obtainQuicEvent(vSBaseRequest, VSNetQUICEvent.EVENT_ID_QUIC_PSKEY_ERROR);
            if (obtainQuicEvent == null) {
                return "0";
            }
            return String.valueOf(obtainQuicEvent.getPsKeyCost());
        } catch (Exception unused) {
            QLog.d(TAG, 1, "ignore np");
            return "0";
        }
    }

    private static String getRecvSize(VSBaseRequest vSBaseRequest) {
        try {
            VSNetQUICEvent obtainQuicEvent = obtainQuicEvent(vSBaseRequest, VSNetQUICEvent.EVENT_ID_QUIC_DATA_UN_ZIP_SUCCESS);
            if (obtainQuicEvent == null) {
                return "0";
            }
            return String.valueOf(obtainQuicEvent.getReceiveSize());
        } catch (Exception unused) {
            QLog.d(TAG, 1, "ignore np");
            return "0";
        }
    }

    private static QUICReqStats getReqStats(VSBaseRequest vSBaseRequest) {
        try {
            JSONObject jSONObject = new JSONObject(vSBaseRequest.getQUICRequestStats());
            QUICReqStats qUICReqStats = new QUICReqStats();
            qUICReqStats.mFirstDataDurationMs = jSONObject.getInt("first_data_duration_ms");
            qUICReqStats.mConnectDurationMs = jSONObject.getLong("connect_duration_ms");
            qUICReqStats.mReorderTimeoutCount = jSONObject.getInt("reorder_timeout_count");
            return qUICReqStats;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getRetCode(VSBaseRequest vSBaseRequest) {
        VSNetQUICEvent vSNetQUICEvent;
        try {
            Map<String, VSNetQUICEvent> qUICEvents = vSBaseRequest.getQUICEvents();
            if (qUICEvents.containsKey(VSNetQUICEvent.EVENT_ID_QUIC_SEND_ERROR)) {
                vSNetQUICEvent = qUICEvents.get(VSNetQUICEvent.EVENT_ID_QUIC_SEND_ERROR);
            } else if (qUICEvents.containsKey(VSNetQUICEvent.EVENT_ID_QUIC_DATA_PARSE_ERROR)) {
                vSNetQUICEvent = qUICEvents.get(VSNetQUICEvent.EVENT_ID_QUIC_DATA_PARSE_ERROR);
            } else if (qUICEvents.containsKey(VSNetQUICEvent.EVENT_ID_QUIC_HEAD_ERROR)) {
                vSNetQUICEvent = qUICEvents.get(VSNetQUICEvent.EVENT_ID_QUIC_HEAD_ERROR);
            } else if (qUICEvents.containsKey(VSNetQUICEvent.EVENT_ID_QUIC_DNS_ERROR)) {
                vSNetQUICEvent = qUICEvents.get(VSNetQUICEvent.EVENT_ID_QUIC_DNS_ERROR);
            } else if (qUICEvents.containsKey(VSNetQUICEvent.EVENT_ID_QUIC_PSKEY_ERROR)) {
                vSNetQUICEvent = qUICEvents.get(VSNetQUICEvent.EVENT_ID_QUIC_PSKEY_ERROR);
            } else {
                vSNetQUICEvent = null;
            }
            if (vSNetQUICEvent == null) {
                return "0";
            }
            return String.valueOf(vSNetQUICEvent.getErrorCode());
        } catch (Exception unused) {
            QLog.d(TAG, 1, "ignore np");
            return "0";
        }
    }

    private static String getSendSize(VSBaseRequest vSBaseRequest) {
        try {
            VSNetQUICEvent obtainQuicEvent = obtainQuicEvent(vSBaseRequest, VSNetQUICEvent.EVENT_ID_QUIC_REQ_ZIP);
            if (obtainQuicEvent == null) {
                return "0";
            }
            return String.valueOf(obtainQuicEvent.getReqLength());
        } catch (Exception unused) {
            QLog.d(TAG, 1, "ignore np");
            return "0";
        }
    }

    private static String getSendZipSize(VSBaseRequest vSBaseRequest) {
        try {
            VSNetQUICEvent obtainQuicEvent = obtainQuicEvent(vSBaseRequest, VSNetQUICEvent.EVENT_ID_QUIC_REQ_ZIP);
            if (obtainQuicEvent == null) {
                return "0";
            }
            return String.valueOf(obtainQuicEvent.getZipReqLength());
        } catch (Exception unused) {
            QLog.d(TAG, 1, "ignore np");
            return "0";
        }
    }

    private static String getTotalCostTime(VSBaseRequest vSBaseRequest) {
        try {
            if (fallBackToMSF(vSBaseRequest)) {
                return String.valueOf(vSBaseRequest.getQUICEvents().get(VSNetQUICEvent.EVENT_ID_QUIC_TO_MSF).getEventTime() - vSBaseRequest.getQUICEvents().get(VSNetQUICEvent.EVENT_ID_QUIC_START).getEventTime());
            }
            return String.valueOf(vSBaseRequest.getQUICEvents().get(VSNetQUICEvent.EVENT_ID_QUIC_SEND_SUCCESS).getEventTime() - vSBaseRequest.getQUICEvents().get(VSNetQUICEvent.EVENT_ID_QUIC_START).getEventTime());
        } catch (Exception unused) {
            QLog.d(TAG, 1, "ignore np");
            return "0";
        }
    }

    private static String getUnZipSize(VSBaseRequest vSBaseRequest) {
        try {
            VSNetQUICEvent obtainQuicEvent = obtainQuicEvent(vSBaseRequest, VSNetQUICEvent.EVENT_ID_QUIC_DATA_UN_ZIP_SUCCESS);
            if (obtainQuicEvent == null) {
                return "0";
            }
            return String.valueOf(obtainQuicEvent.getUnZipLength());
        } catch (Exception unused) {
            QLog.d(TAG, 1, "ignore np");
            return "0";
        }
    }

    private static String getUnZipType(VSBaseRequest vSBaseRequest) {
        try {
            VSNetQUICEvent obtainQuicEvent = obtainQuicEvent(vSBaseRequest, VSNetQUICEvent.EVENT_ID_QUIC_DATA_UN_ZIP_SUCCESS);
            if (obtainQuicEvent == null) {
                return "0";
            }
            return String.valueOf(obtainQuicEvent.getCompressType());
        } catch (Throwable unused) {
            return "0";
        }
    }

    private static String getUzipCost(VSBaseRequest vSBaseRequest) {
        try {
            VSNetQUICEvent obtainQuicEvent = obtainQuicEvent(vSBaseRequest, VSNetQUICEvent.EVENT_ID_QUIC_DATA_UN_ZIP_SUCCESS);
            if (obtainQuicEvent == null) {
                return "0";
            }
            return String.valueOf(obtainQuicEvent.getUnZipTimeCost());
        } catch (Exception unused) {
            QLog.d(TAG, 1, "ignore np");
            return "0";
        }
    }

    private static String getZipCost(VSBaseRequest vSBaseRequest) {
        try {
            VSNetQUICEvent obtainQuicEvent = obtainQuicEvent(vSBaseRequest, VSNetQUICEvent.EVENT_ID_QUIC_REQ_ZIP);
            if (obtainQuicEvent == null) {
                return "0";
            }
            return String.valueOf(obtainQuicEvent.getZipTimeCost());
        } catch (Exception unused) {
            QLog.d(TAG, 1, "ignore np");
            return "0";
        }
    }

    public static boolean isUseQUICReq(VSBaseRequest vSBaseRequest) {
        if (vSBaseRequest == null) {
            return false;
        }
        return !vSBaseRequest.getQUICEvents().isEmpty();
    }

    private static VSNetQUICEvent obtainQuicEvent(VSBaseRequest vSBaseRequest, String str) {
        try {
            Map<String, VSNetQUICEvent> qUICEvents = vSBaseRequest.getQUICEvents();
            if (qUICEvents == null) {
                return null;
            }
            return qUICEvents.get(str);
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "[obtainQuicEvent] ex:", th5);
            return null;
        }
    }

    public static void retryPingReq() {
        ((IQCircleQuicReqApi) QRoute.api(IQCircleQuicReqApi.class)).retryPingRequest();
    }

    public static QCircleAlphaUserReportDataBuilder wrapQUIC(BaseRequest baseRequest, QCircleAlphaUserReportDataBuilder qCircleAlphaUserReportDataBuilder) {
        String str;
        String str2;
        if (qCircleAlphaUserReportDataBuilder == null) {
            return qCircleAlphaUserReportDataBuilder;
        }
        if (!(baseRequest instanceof VSBaseRequest)) {
            return qCircleAlphaUserReportDataBuilder;
        }
        if (REPORT_DATA_CMD.equalsIgnoreCase(qCircleAlphaUserReportDataBuilder.cmd)) {
            return qCircleAlphaUserReportDataBuilder;
        }
        String str3 = "";
        if (!VSNetQUICExp.isEnabledQUICNetReq()) {
            str = "";
        } else {
            str = attachExp(qCircleAlphaUserReportDataBuilder.attachInfo, (VSBaseRequest) baseRequest);
            qCircleAlphaUserReportDataBuilder.setAttachInfo(str);
        }
        VSBaseRequest vSBaseRequest = (VSBaseRequest) baseRequest;
        if (!isUseQUICReq(vSBaseRequest)) {
            return qCircleAlphaUserReportDataBuilder;
        }
        if (fallBackToMSF(vSBaseRequest)) {
            str2 = "msf";
        } else {
            str2 = "quic";
        }
        qCircleAlphaUserReportDataBuilder.setExt2(str2);
        String attachQUICInfo = attachQUICInfo(str, vSBaseRequest);
        qCircleAlphaUserReportDataBuilder.setAttachInfo(attachQUICInfo);
        if (!RFWApplication.isPublicVersion()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[wrapQUIC] attachInfo: ");
            if (!TextUtils.isEmpty(attachQUICInfo)) {
                str3 = attachQUICInfo;
            }
            sb5.append(str3);
            QLog.d(TAG, 1, sb5.toString());
        }
        return qCircleAlphaUserReportDataBuilder;
    }
}

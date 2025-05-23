package com.tencent.mobileqq.transfile.quic.report;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.java_websocket.WebSocketImpl;
import org.json.JSONObject;
import tencent.im.andromeda.andromeda$NetInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class QuicNetReport {
    static IPatchRedirector $redirector_ = null;
    public static final int BUINESS_QUIC_SHORT_VIDEO_TYPE = 1;
    public static final int BUSINESS_QUIC_PIC_TYPE = 2;
    public static final String KEY_QUIC_CONN_COST = "param_quic_conn_cost";
    public static final String KEY_QUIC_CONTENT_LENGTH = "param_quic_content_length";
    public static final String KEY_QUIC_DOWNLOAD = "parameter_quic";
    public static final String KEY_QUIC_DOWNLOAD_STATUS = "parameter_quic_status";
    public static final String KEY_QUIC_ERR_CODE = "param_quic_err_code";
    public static final String KEY_QUIC_ERR_MESSAGE = "param_quic_err_message";
    public static final String KEY_QUIC_ESTIMATED_BANDWIDTH = "param_quic_estimated_bandwidth";
    public static final String KEY_QUIC_FAIL_REASON = "param_quic_fail_reason";
    public static final String KEY_QUIC_FIRST_PACKAGE_COST = "param_quic_first_package_cost";
    public static final String KEY_QUIC_HTTP_STATUS = "param_quic_http_status";
    public static final String KEY_QUIC_IN_QUEUE_COST = "param_quic_inQueueCost";
    public static final String KEY_QUIC_IS_IPV6 = "param_quic_is_ipv6";
    public static final String KEY_QUIC_LOST_RATE = "param_quic_lost_rate";
    public static final String KEY_QUIC_NET_TYPE = "param_quic_net_type";
    public static final String KEY_QUIC_REMOTE_ADDRESS = "param_quic_remote_address";
    public static final String KEY_QUIC_REMOTE_PORT = "param_quic_remote_port";
    public static final String KEY_QUIC_RTT_MEAN = "param_quic_rtt_mean";
    public static final String KEY_QUIC_SHORT_VIDEO = "param_quic_short_video";
    public static final String KEY_QUIC_SRTT_US = "param_quic_srtt_us";
    public static final String KEY_QUIC_TIME_OUT = "param_quic_time_out";
    public static final String KEY_QUIC_TOTAL_SIZE = "param_quic_total_size";
    public static final String KEY_QUIC_TOTAL_TIME = "param_quic_total_time";
    public static final String KEY_QUIC_TYPE_VIDEO = "param_quic_type_video";
    private static final int OFFSET_VERSION_REPORT = 2000000;
    public static final String QUIC = "quic";
    public static final int REASON_FAIL_CANCELED = 9;
    public static final int REASON_FAIL_CONTENT = 5;
    public static final int REASON_FAIL_DOWNLOADING = 8;
    public static final int REASON_FAIL_EXCEPTION = 4;
    public static final int REASON_FAIL_LOAD_SO = 7;
    public static final int REASON_FAIL_NETWORK = 3;
    public static final int REASON_FAIL_NETWORK_UNAVAILABLE = 6;
    private static final int REASON_FAIL_NONE = 0;
    public static final int REASON_FAIL_SO_LOAD_FAIL = 10;
    public static final int REASON_FAIL_STORAGE = 2;
    public static final int REASON_FAIL_UNKNOWN = 1;
    private static final String REPORT_TAG = "actShortVideoQuicDownload";
    public static final String RTT_HOST = "sns.cdn.qq.com";
    public int businessId;
    public String channel;
    public long contentLength;
    public String contentType;
    public long endTime;
    public int errCode;
    public String errMsg;
    public String extra;
    public int failReason;
    public long fileSize;
    public long firstPackageCost;
    public String header;
    public Map<String, String> headers;
    public int httpStatus;

    /* renamed from: id, reason: collision with root package name */
    public int f293472id;

    /* renamed from: ip, reason: collision with root package name */
    public String f293473ip;
    public boolean isHttpRetryed;
    public boolean isIpv6;
    public Stats lastStats;
    public int port;
    public String rttHost;
    public String savePath;
    public int slice;
    public byte[] srvMessage;
    public long startTime;
    public Stats stats;
    public boolean success;
    public long tConn;
    public String tempPath;
    public int timeOut;
    public long totaltime;
    public String url;
    public String uuid;
    public long waitCost;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class Stats {
        static IPatchRedirector $redirector_;
        public int mByteRecv;
        public int mEstimatedBandwidth;
        public int mLostRate;
        public int mRttMean;
        public int mSrttUs;
        public byte[] mSrvMessage;

        public Stats() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.mSrttUs = 0;
            this.mEstimatedBandwidth = 0;
            this.mRttMean = 0;
            this.mLostRate = 0;
            this.mByteRecv = 0;
        }

        public boolean isValid() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (this.mSrttUs == 0 && this.mEstimatedBandwidth == 0 && this.mRttMean == 0 && this.mLostRate == 0 && this.mByteRecv == 0) {
                return false;
            }
            return true;
        }

        public String toString() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Stats{mSrttUs=");
            sb5.append(this.mSrttUs);
            sb5.append(", mEstimatedBandwidth=");
            sb5.append(this.mEstimatedBandwidth);
            sb5.append(", mRttMean=");
            sb5.append(this.mRttMean);
            sb5.append(", mLostRate=");
            sb5.append(this.mLostRate);
            sb5.append(", mByteRecv=");
            sb5.append(this.mByteRecv);
            sb5.append(", mSrvMessage.length='");
            byte[] bArr = this.mSrvMessage;
            if (bArr != null) {
                i3 = bArr.length;
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            sb5.append('\'');
            sb5.append('}');
            return sb5.toString();
        }
    }

    public QuicNetReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f293472id = 0;
        this.channel = "quic";
        this.url = "";
        this.savePath = "";
        this.tempPath = "";
        this.headers = new LinkedHashMap();
        this.slice = 1;
        this.startTime = 0L;
        this.endTime = 0L;
        this.totaltime = 0L;
        this.fileSize = 0L;
        this.header = "";
        this.httpStatus = 0;
        this.errCode = 0;
        this.failReason = 0;
        this.contentType = "";
        this.contentLength = 0L;
        this.errMsg = "";
        this.port = WebSocketImpl.DEFAULT_WSS_PORT;
        this.uuid = "";
        this.waitCost = 0L;
        this.tConn = 0L;
        this.firstPackageCost = 0L;
    }

    public static Stats convertJsontoStats(String str) {
        if (str == null) {
            return null;
        }
        Stats stats = new Stats();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("srtt_us")) {
                stats.mSrttUs = jSONObject.optInt("srtt_us");
            }
            if (jSONObject.has("estimated_bandwidth")) {
                stats.mEstimatedBandwidth = jSONObject.optInt("estimated_bandwidth");
            }
            if (jSONObject.has("rtt_mean")) {
                stats.mRttMean = jSONObject.optInt("rtt_mean");
            }
            if (jSONObject.has("lost_rate")) {
                stats.mLostRate = jSONObject.optInt("lost_rate");
            }
            if (jSONObject.has("byte_recv")) {
                stats.mByteRecv = jSONObject.optInt("byte_recv");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return stats;
    }

    private int getNetType() {
        int networkType = NetworkUtil.getNetworkType(BaseApplication.getContext());
        if (networkType == 1) {
            return 1;
        }
        if (networkType == 2) {
            return 3;
        }
        if (networkType == 3) {
            return 4;
        }
        if (networkType != 4) {
            if (networkType != 6) {
                return 0;
            }
            return 7;
        }
        return 5;
    }

    public byte[] getReportMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        andromeda$NetInfo andromeda_netinfo = new andromeda$NetInfo();
        andromeda_netinfo.nettype.set(getNetType());
        Stats stats = this.lastStats;
        if (stats != null) {
            andromeda_netinfo.lastrtt.set(stats.mSrttUs);
            andromeda_netinfo.lastspeed.set(this.lastStats.mEstimatedBandwidth);
            andromeda_netinfo.lastrtt_mean.set(this.lastStats.mRttMean);
            andromeda_netinfo.lastlost_rate.set(this.lastStats.mLostRate);
            andromeda_netinfo.lastbyte_recv.set(this.lastStats.mByteRecv);
            byte[] bArr = this.lastStats.mSrvMessage;
            if (bArr != null && bArr.length > 0) {
                andromeda_netinfo.last_srvmessage.set(ByteStringMicro.copyFrom(bArr));
            }
        }
        andromeda_netinfo.bussinessid.set(this.businessId);
        try {
            andromeda_netinfo.clientversion.set(Integer.parseInt(AppSetting.f99551k.replace(".", "")) + 2000000);
        } catch (Exception e16) {
            QLog.e("quic", 2, e16, new Object[0]);
        }
        andromeda_netinfo.optype.set(1);
        return andromeda_netinfo.toByteArray();
    }

    protected void report(boolean z16, long j3, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Long.valueOf(j3), hashMap);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("quic", 4, "reportBeaconEvent result: " + z16 + " duration: " + j3);
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, REPORT_TAG, z16, j3, this.fileSize, hashMap, "");
    }

    public void reportBeaconEvent(boolean z16, boolean z17) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(KEY_QUIC_IN_QUEUE_COST, String.valueOf(this.waitCost));
        hashMap.put(KEY_QUIC_NET_TYPE, String.valueOf(getNetType()));
        hashMap.put(KEY_QUIC_TOTAL_TIME, String.valueOf(this.totaltime));
        hashMap.put(KEY_QUIC_TOTAL_SIZE, String.valueOf(this.fileSize));
        hashMap.put(KEY_QUIC_ERR_CODE, String.valueOf(this.errCode));
        hashMap.put(KEY_QUIC_FAIL_REASON, String.valueOf(this.failReason));
        hashMap.put(KEY_QUIC_CONTENT_LENGTH, String.valueOf(this.contentLength));
        hashMap.put(KEY_QUIC_REMOTE_ADDRESS, this.f293473ip);
        hashMap.put(KEY_QUIC_REMOTE_PORT, String.valueOf(this.port));
        hashMap.put(KEY_QUIC_FIRST_PACKAGE_COST, String.valueOf(this.firstPackageCost));
        hashMap.put(KEY_QUIC_ERR_MESSAGE, this.errMsg);
        hashMap.put(KEY_QUIC_TIME_OUT, String.valueOf(this.timeOut));
        hashMap.put(KEY_QUIC_HTTP_STATUS, String.valueOf(this.httpStatus));
        hashMap.put(KEY_QUIC_CONN_COST, String.valueOf(this.tConn));
        String str3 = "1";
        if (this.isIpv6) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put(KEY_QUIC_IS_IPV6, str);
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put(KEY_QUIC_SHORT_VIDEO, str2);
        if (!z17) {
            str3 = "0";
        }
        hashMap.put(KEY_QUIC_TYPE_VIDEO, str3);
        Stats stats = this.stats;
        if (stats != null) {
            hashMap.put(KEY_QUIC_ESTIMATED_BANDWIDTH, String.valueOf(stats.mEstimatedBandwidth));
            hashMap.put(KEY_QUIC_SRTT_US, String.valueOf(this.stats.mSrttUs));
            hashMap.put(KEY_QUIC_RTT_MEAN, String.valueOf(this.stats.mRttMean));
            hashMap.put(KEY_QUIC_LOST_RATE, String.valueOf(this.stats.mLostRate));
        }
        boolean z18 = this.success;
        long j3 = this.totaltime;
        if (j3 > 0) {
            j3 += this.waitCost;
        }
        report(z18, j3, hashMap);
    }
}

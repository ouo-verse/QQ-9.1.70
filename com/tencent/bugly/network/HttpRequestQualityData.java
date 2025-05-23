package com.tencent.bugly.network;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.utils.DeviceInfo;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import okhttp3.Connection;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
class HttpRequestQualityData {
    private static final int CODE_CALL_FAIL = -1;
    private static final int CODE_CONNECT_FAIL = -2;
    private static final int CODE_DEFAULT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "RMonitor_net_quality_event";
    private static final DeviceInfo deviceInfo = new DeviceInfo();
    String lastEvent;
    long lastEventTime;
    long requestRealTime;
    long requestTimeInMs;
    int resultCode = 0;
    String exceptionType = null;
    Exception exception = null;
    long totalCost = 0;
    boolean isSuccessful = false;
    int dnsCount = 0;
    long dnsTotalCost = 0;
    int connectCount = 0;
    int connectTotalCost = 0;
    String hostIP = null;
    int hostPort = 0;
    String localIP = null;
    int localPort = 0;
    int secureConnectCount = 0;
    long secureConnectTotalCost = 0;
    int connectionAcquiredCount = 0;
    boolean isCanceled = false;
    String originalUrl = null;
    String method = null;
    String host = null;
    String path = null;
    String queryString = null;
    String protocolString = null;
    boolean isHttps = false;
    long requestByteCount = 0;
    long sendRequestCost = 0;
    boolean isRedirect = false;
    long waitResponseCost = 0;
    long firstPkgCost = 0;
    int responseCode = 0;
    String message = null;
    long recResponseCost = 0;
    long responseByteCount = 0;
    private final HashMap<String, Long> eventTimStampMap = new HashMap<>();

    HttpRequestQualityData() {
        this.requestTimeInMs = 0L;
        this.requestRealTime = 0L;
        this.lastEventTime = 0L;
        this.lastEvent = null;
        this.requestTimeInMs = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.requestRealTime = elapsedRealtime;
        this.lastEventTime = elapsedRealtime;
        this.lastEvent = "callStart";
    }

    private String checkString(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private long computeCost(long j3, long j16) {
        if (j16 == 0) {
            return 0L;
        }
        return j3 / j16;
    }

    private Long getEventTimeStamp(String str) {
        return this.eventTimStampMap.get(str);
    }

    private String getIP(InetAddress inetAddress) {
        if (inetAddress != null) {
            return inetAddress.getHostAddress();
        }
        return "";
    }

    private boolean isReuseConnection() {
        if (this.dnsCount > 0 || this.connectCount > 0 || this.secureConnectCount > 0 || this.connectionAcquiredCount <= 0) {
            return false;
        }
        return true;
    }

    public static HttpRequestQualityData obtain() {
        return new HttpRequestQualityData();
    }

    public void addEvent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.lastEvent = str;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.lastEventTime = elapsedRealtime;
        this.eventTimStampMap.put(this.lastEvent, Long.valueOf(elapsedRealtime));
    }

    protected boolean isEventValid(Long l3, Long l16) {
        if (l16 != null && l3 != null && l3.longValue() >= l16.longValue()) {
            return true;
        }
        return false;
    }

    public boolean isSuspicious(long j3, @NonNull NetQualityPluginConfig netQualityPluginConfig) {
        long j16 = this.lastEventTime;
        if (j3 < j16) {
            j3 = SystemClock.elapsedRealtime();
            j16 = this.lastEventTime;
        }
        long j17 = j3 - j16;
        int i3 = this.responseCode;
        if (i3 == 0) {
            if (j17 >= netQualityPluginConfig.callEndDelayOther) {
                return true;
            }
        } else if (i3 >= 400) {
            if (j17 >= netQualityPluginConfig.callEndDelayWhenFail) {
                return true;
            }
        } else if (i3 == 204) {
            if (j17 >= netQualityPluginConfig.callEndDelayWhenFail) {
                return true;
            }
        } else if (i3 >= 200 && i3 < 300) {
            if (j17 >= netQualityPluginConfig.callEndDelayWhenSuccess) {
                return true;
            }
        } else if (j17 >= netQualityPluginConfig.callEndDelayOther) {
            return true;
        }
        return false;
    }

    public void onCallEnd(String str, IOException iOException) {
        Long eventTimeStamp;
        boolean z16;
        Long eventTimeStamp2 = getEventTimeStamp("callStart");
        if (!"callEnd".equals(str) && !"callFailed".equals(str)) {
            eventTimeStamp = Long.valueOf(this.lastEventTime);
        } else {
            eventTimeStamp = getEventTimeStamp(str);
        }
        if (isEventValid(eventTimeStamp, eventTimeStamp2)) {
            this.totalCost = eventTimeStamp.longValue() - eventTimeStamp2.longValue();
        }
        if ("callFailed".equals(str)) {
            this.isSuccessful = false;
            updateFailCode(-1, "callFailed", iOException);
            return;
        }
        int i3 = this.responseCode;
        if (i3 >= 200 && i3 < 300) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isSuccessful = z16;
        if (this.isCanceled) {
            updateFailCode(0, "cancel", iOException);
        }
    }

    public void onConnectEnd(boolean z16, InetSocketAddress inetSocketAddress, Protocol protocol2, IOException iOException) {
        String str;
        Long eventTimeStamp = getEventTimeStamp("connectStart");
        if (z16) {
            str = "connectFailed";
        } else {
            str = "connectEnd";
        }
        Long eventTimeStamp2 = getEventTimeStamp(str);
        if (isEventValid(eventTimeStamp2, eventTimeStamp)) {
            long longValue = eventTimeStamp2.longValue() - eventTimeStamp.longValue();
            this.connectCount++;
            this.connectTotalCost = (int) (this.connectTotalCost + longValue);
        }
        if (protocol2 != null) {
            this.protocolString = protocol2.getProtocol();
        }
        if (inetSocketAddress != null) {
            this.hostIP = getIP(inetSocketAddress.getAddress());
            this.hostPort = inetSocketAddress.getPort();
        }
        if (z16) {
            updateFailCode(-2, "connectFailed", iOException);
        }
    }

    public void onConnectionAcquired(Connection connection) {
        Socket socket;
        this.connectionAcquiredCount++;
        if (connection == null || (socket = connection.socket()) == null) {
            return;
        }
        this.hostIP = getIP(socket.getInetAddress());
        this.hostPort = socket.getPort();
        this.localIP = getIP(socket.getLocalAddress());
        this.localPort = socket.getLocalPort();
    }

    public void onDNSEnd(String str) {
        Long eventTimeStamp = getEventTimeStamp("dnsStart");
        Long eventTimeStamp2 = getEventTimeStamp("dnsEnd");
        if (isEventValid(eventTimeStamp2, eventTimeStamp)) {
            long longValue = eventTimeStamp2.longValue() - eventTimeStamp.longValue();
            this.dnsCount++;
            this.dnsTotalCost += longValue;
        }
        updateHost("dnsEnd", str);
    }

    public void onRequestBodyEnd(long j3) {
        Long eventTimeStamp = getEventTimeStamp("requestHeadersStart");
        Long eventTimeStamp2 = getEventTimeStamp("requestBodyEnd");
        if (isEventValid(eventTimeStamp2, eventTimeStamp)) {
            this.sendRequestCost = eventTimeStamp2.longValue() - eventTimeStamp.longValue();
        }
        this.requestByteCount += j3;
    }

    public void onResponseBodyEnd(long j3) {
        Long eventTimeStamp = getEventTimeStamp("responseHeadersStart");
        Long eventTimeStamp2 = getEventTimeStamp("responseBodyEnd");
        if (isEventValid(eventTimeStamp2, eventTimeStamp)) {
            this.recResponseCost = eventTimeStamp2.longValue() - eventTimeStamp.longValue();
        }
        this.responseByteCount = j3;
    }

    public void onResponseHeadersEnd(Response response) {
        if (response == null) {
            return;
        }
        this.responseCode = response.code();
        this.isSuccessful = response.isSuccessful();
        this.message = response.message();
        if (response.isRedirect()) {
            this.isRedirect = true;
        }
    }

    public void onResponseHeadersStart() {
        Long eventTimeStamp = getEventTimeStamp("responseHeadersStart");
        Long eventTimeStamp2 = getEventTimeStamp("requestBodyEnd");
        if (isEventValid(eventTimeStamp, eventTimeStamp2)) {
            this.waitResponseCost = eventTimeStamp.longValue() - eventTimeStamp2.longValue();
        }
        Long eventTimeStamp3 = getEventTimeStamp("callStart");
        if (isEventValid(eventTimeStamp, eventTimeStamp3)) {
            this.firstPkgCost = eventTimeStamp.longValue() - eventTimeStamp3.longValue();
        }
    }

    public void onSecureConnectEnd() {
        Long eventTimeStamp = getEventTimeStamp("secureConnectStart");
        Long eventTimeStamp2 = getEventTimeStamp("secureConnectEnd");
        if (isEventValid(eventTimeStamp2, eventTimeStamp)) {
            long longValue = eventTimeStamp2.longValue() - eventTimeStamp.longValue();
            this.secureConnectCount++;
            this.secureConnectTotalCost += longValue;
        }
    }

    public HttpReportMeta toMeta() {
        boolean z16;
        HttpReportMeta httpReportMeta = new HttpReportMeta();
        httpReportMeta.requestTime = this.requestTimeInMs;
        if (this.exception != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        httpReportMeta.hasStacks = z16;
        try {
            NetMonitorReportUtil.fillMeta(httpReportMeta);
            JSONObject jSONObject = new JSONObject();
            httpReportMeta.data = jSONObject;
            jSONObject.put("request_time_in_ms", httpReportMeta.requestTime);
            httpReportMeta.data.put(AudienceReportConst.PROTOCOL, checkString(this.protocolString));
            httpReportMeta.data.put("is_https", this.isHttps);
            httpReportMeta.data.put("host", checkString(this.host));
            httpReportMeta.data.put("path", checkString(this.path));
            httpReportMeta.data.put("query_string", checkString(this.queryString));
            httpReportMeta.data.put("original_url", this.originalUrl);
            httpReportMeta.data.put("method", checkString(this.method));
            httpReportMeta.data.put("stage", checkString(httpReportMeta.stage));
            httpReportMeta.data.put("is_reuse_connection", isReuseConnection());
            httpReportMeta.data.put("is_canceled", this.isCanceled);
            httpReportMeta.data.put("has_redirect", this.isRedirect);
            httpReportMeta.data.put("status_code", this.responseCode);
            httpReportMeta.data.put("result_code", this.resultCode);
            httpReportMeta.data.put("total_cost_in_ms", this.totalCost);
            httpReportMeta.data.put("dns_cost_in_ms", computeCost(this.dnsTotalCost, this.dnsCount));
            httpReportMeta.data.put("tcp_cost_in_ms", computeCost(this.connectTotalCost, this.connectCount));
            httpReportMeta.data.put("ssl_cost_in_ms", computeCost(this.secureConnectTotalCost, this.secureConnectCount));
            httpReportMeta.data.put("request_cost_in_ms", this.sendRequestCost);
            httpReportMeta.data.put("wait_cost_in_ms", this.waitResponseCost);
            httpReportMeta.data.put("response_cost_in_ms", this.recResponseCost);
            httpReportMeta.data.put("first_package_cost_in_ms", this.firstPkgCost);
            httpReportMeta.data.put("request_byte_count", this.requestByteCount);
            httpReportMeta.data.put("response_byte_count", this.responseByteCount);
            httpReportMeta.data.put("host_ip", checkString(this.hostIP));
            httpReportMeta.data.put("host_port", this.hostPort);
            httpReportMeta.data.put("client_ip", checkString(this.localIP));
            httpReportMeta.data.put("client_port", this.localPort);
            JSONObject jSONObject2 = httpReportMeta.data;
            DeviceInfo deviceInfo2 = deviceInfo;
            jSONObject2.put("client_operator", deviceInfo2.getOperatorName());
            httpReportMeta.data.put("client_operator_code", deviceInfo2.getOperator());
            httpReportMeta.data.put("client_country_code", deviceInfo2.getCountryCode());
            httpReportMeta.data.put("client_region_id", deviceInfo2.getRegionID());
            NetMonitorReportUtil.fillExceptionInfo(httpReportMeta.data, this.exceptionType, this.exception);
            httpReportMeta.data.put(ReportDataBuilder.KEY_USER_CUSTOM, NetMonitorReportUtil.getUserCustom());
        } catch (Throwable th5) {
            Logger.f365497g.e(TAG, "toMeta fail for " + th5);
        }
        return httpReportMeta;
    }

    public String toString() {
        return "{url: " + this.originalUrl + ", host: " + this.host + ", statusCode: " + this.responseCode + ", cost: " + this.totalCost + "}";
    }

    public void updateFailCode(int i3, String str, IOException iOException) {
        if (this.resultCode != 0) {
            return;
        }
        this.resultCode = i3;
        this.exception = iOException;
        if (iOException != null) {
            this.exceptionType = iOException.getMessage();
        } else {
            this.exceptionType = str;
        }
    }

    public void updateHost(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.equals(this.host, str2)) {
            this.host = str2;
        }
    }

    public void updateRequest(String str, Request request) {
        HttpUrl url;
        if (request == null || (url = request.url()) == null) {
            return;
        }
        try {
            this.method = request.method();
            this.isHttps = url.getIsHttps();
            this.host = url.host();
            this.path = url.encodedPath();
            this.queryString = url.encodedQuery();
            if ("callStart".equals(str)) {
                this.originalUrl = url.getUrl();
            }
        } catch (Throwable unused) {
        }
    }
}

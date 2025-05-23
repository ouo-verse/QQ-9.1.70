package com.tencent.bugly.traffic.custom;

import com.tencent.bugly.common.network.NetworkWatcher;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SocketInfo {
    private static final long READ_TIME_TOLERANCE = 20000;
    private static final String TAG = "SocketInfo";
    public boolean chunked;
    public long connEnd;
    public long connStart;
    public long contentLength;
    public long dnsEnd;
    public long dnsStart;
    public long dnsTime;
    public long duringTime;
    public long endTimeStamp;

    /* renamed from: fd, reason: collision with root package name */
    public String f98594fd;
    public long firstPacketPeriod;
    public int frontState;
    public boolean gzip;
    public String host;
    public int implHashCode;
    public boolean isEnd;
    public long lastWriteStamp;
    public int networkType;
    public String path;
    public int port;

    /* renamed from: protocol, reason: collision with root package name */
    public String f98596protocol;
    public long receivedBytes;
    public long redirectEnd;
    public long redirectStart;
    public long reqEnd;
    public long reqStart;
    public long respEnd;
    public long respStart;
    public long sendBytes;
    public boolean ssl;
    public long sslConnEnd;
    public long sslConnStart;
    public long sslTime;
    public long startTimeStamp;
    public long tcpTime;
    public long threadId;
    public long totalConnectPeriod;
    public String type;
    public String version;
    public boolean isProxy = false;
    public boolean isDnsCache = false;
    public String url = "";

    /* renamed from: ip, reason: collision with root package name */
    public String f98595ip = "";
    public String method = "";
    public String contentType = "";
    public int errorCode = 0;
    public int statusCode = 0;
    public String apnType = NetworkWatcher.INSTANCE.getNetworkState(true).getValue();
    public String pageId = "";
    public Exception exception = null;
    public boolean hasSaved = false;
    public Map<String, String> requestHeaders = new HashMap();
    public Map<String, String> responseHeaders = new HashMap();

    public static int getErrorCode(Exception exc) {
        if (exc instanceof IOException) {
            if (HttpErrorUtils.getInstance().isSocketECONNRESET(exc)) {
                return HttpErrorUtils.CONNECTION_RESET_EXCEPTION;
            }
            String message = exc.getMessage();
            if (message != null && message.contains("ftruncate failed: ENOENT (No such file or directory)")) {
                return HttpErrorUtils.NO_FILE_OR_DIRECTORY;
            }
        }
        if (exc instanceof UnknownHostException) {
            return 901;
        }
        return 903;
    }

    public SocketInfo cloneSocketInfo() {
        SocketInfo socketInfo = new SocketInfo();
        socketInfo.ssl = this.ssl;
        socketInfo.url = this.url;
        socketInfo.f98596protocol = this.f98596protocol;
        socketInfo.host = this.host;
        socketInfo.f98595ip = this.f98595ip;
        socketInfo.port = this.port;
        socketInfo.version = this.version;
        socketInfo.method = this.method;
        socketInfo.path = this.path;
        socketInfo.f98594fd = this.f98594fd;
        socketInfo.implHashCode = this.implHashCode;
        socketInfo.threadId = this.threadId;
        socketInfo.networkType = this.networkType;
        socketInfo.frontState = this.frontState;
        socketInfo.contentType = this.contentType;
        socketInfo.startTimeStamp = this.startTimeStamp;
        socketInfo.firstPacketPeriod = this.firstPacketPeriod;
        socketInfo.totalConnectPeriod = this.totalConnectPeriod;
        socketInfo.lastWriteStamp = this.lastWriteStamp;
        socketInfo.gzip = this.gzip;
        socketInfo.chunked = this.chunked;
        socketInfo.contentLength = this.contentLength;
        socketInfo.errorCode = this.errorCode;
        socketInfo.statusCode = this.statusCode;
        socketInfo.apnType = this.apnType;
        socketInfo.pageId = this.pageId;
        socketInfo.exception = this.exception;
        socketInfo.isEnd = this.isEnd;
        socketInfo.hasSaved = this.hasSaved;
        socketInfo.reqStart = this.reqStart;
        socketInfo.reqEnd = this.reqEnd;
        socketInfo.respStart = this.respStart;
        socketInfo.respEnd = this.respEnd;
        socketInfo.sslConnStart = this.sslConnStart;
        socketInfo.sslConnEnd = this.sslConnEnd;
        socketInfo.redirectStart = this.redirectStart;
        socketInfo.redirectEnd = this.redirectEnd;
        socketInfo.connStart = this.connStart;
        socketInfo.connEnd = this.connEnd;
        socketInfo.dnsStart = this.dnsStart;
        socketInfo.dnsEnd = this.dnsEnd;
        return socketInfo;
    }

    public void readStamp(long j3) {
        long j16 = this.lastWriteStamp;
        if (j3 <= j16) {
            Logger.f365497g.d(TAG, "get first package", ", firstReadTime:", String.valueOf(j3), ", lastWriteStamp:", String.valueOf(this.lastWriteStamp), ", hostName:", this.host);
            return;
        }
        if (j3 - j16 >= READ_TIME_TOLERANCE) {
            Logger.f365497g.d(TAG, "first package is too big", ", firstReadTime:", String.valueOf(j3), ", lastWriteStamp:", String.valueOf(this.lastWriteStamp), ", hostName:", this.host);
            return;
        }
        if (!this.isEnd) {
            this.isEnd = true;
            this.firstPacketPeriod = (int) (j3 - j16);
        }
        this.totalConnectPeriod = j3 - j16;
    }

    public void resetForInput() {
        this.gzip = false;
        this.chunked = false;
        this.contentLength = 0L;
    }

    public void resetForOutput() {
        this.gzip = false;
        this.chunked = false;
        this.contentLength = 0L;
    }

    public void writeStamp(long j3) {
        this.lastWriteStamp = j3;
        this.isEnd = false;
    }
}

package com.tencent.mobileqq.utils.httputils;

import com.tencent.mobileqq.transfile.TimeoutParam;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HttpMsg {
    public static final String ACCEPT = "Accept";
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    public static final String ACCEPT_TYPE = "text/vnd.wap.wml,image/*,audio/*,text/vnd.sun.j2me.app-descriptor,application/*";
    public static final String CACHE_CONTROL = "cache-control";
    public static final String CDN_LOG_UUID = "X-NWS-LOG-UUID";
    public static final String CHARSET = "charset";
    public static final String CONNECTION = "Connection";
    public static final String CONTENTENCODING = "Content-Encoding";
    public static final String CONTENTRANGE = "content-range";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String COOKIE = "Cookie";
    public static final String ERR_BIGPACHAGE = "the package is over max limit";
    public static final String ERR_CLOSE_OR_CANCEL = "HttpCommunicator closed or msg caceled!";
    public static final String ERR_HttpCommunicator_Closed = "httpcommunicator closed";
    public static final String ERR_PREEMPTED = "preempted by higher msg";
    public static final String ERR_User_Cancelled = "request cancelled";
    public static final String EXPIRES = "Expires";
    public static final String FILE_JAD = "jad";
    public static final String FILE_JAR = "jar";
    public static final String FILE_TEL = "wtai://wp/mc;";
    public static final String FILE_UNKNOWN = "unknown";
    public static final String HOST = "host";
    public static final String IF_MODIFIED_SINCE = "If-Modified-Since";
    public static final String LAST_MODIFIED = "last-modified";
    public static final String LOCATION = "Location";
    public static final String MAX_AGE = "max-age";
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    public static final String MTYPE = "mType";
    public static final String NO_CACHE = "no-cache";
    public static final int PACKAGE_BYTE = 2048;
    public static final String PRAGMA = "Pragma";
    public static String Param_Reason = "param_reason";
    public static final String QCOOKIE = "Q-Cookie";
    public static final String QQPROTOCOLVERSION = "2";
    public static final String RANGE = "Range";
    public static final String REFERER = "Referer";
    public static final String Report_HtTime = "X-httime";
    public static final String Report_PiccacheTime = "X-piccachetime";
    public static final String SET_COOKIE = "Set-Cookie";
    public static final String SET_QCOOKIE = "Set-Q-Cookie";
    public static final String TAG = "Q.richmedia.HttpMsg";
    public static final String TRANSFERENCODING = "Transfer-Encoding";
    public static final String TYPE_HTML = "text/html";
    public static final String TYPE_IMAGE = "image";
    public static final String TYPE_JAD = "text/vnd.sun.j2me.app-descriptor";
    public static final String TYPE_JAR = "application/java-archive";
    public static final String TYPE_MUL_PARTS = "multipart/form-data";
    public static final String TYPE_TEXT = "text/plain";
    public static final String TYPE_WBXML = "application/vnd.wap.wbxml";
    public static final String TYPE_XHTML = "application/vnd.wap.xhtml+xml";
    public static final String TYPE_XHTML2 = "application/xhtml+xml";
    public static final String USERRANGE = "User-Range";
    public static final String USERRETURNCODE = "User-ReturnCode";
    public static final String USER_AGENT = "User-Agent";
    public static final String UTF8 = "utf-8";
    public static final String XERROR = "X-ErrNo";
    public static final String XRANGE = "X-Range";
    public static final String XRetryFlag = "X-RtFlag";
    public static final String XUSERRETURNCODE = "X-User-ReturnCode";
    public static final String X_CACHE_LOOKUP = "X-Cache-Lookup";
    public static final String ZERO = "0";
    private boolean bDataSlice;
    private boolean bInstanceFollowRedirects;
    public boolean bReportRedirects;
    final boolean bVerifyPayment;
    public boolean bViaWhiteShark;
    public int busiType;
    private String connectString;
    public long cost;
    public int data_slice_type;
    public long detailErrcode;
    public int errCode;
    public String errString;
    public int fileType;
    public int flow;
    public AtomicBoolean hasFinished;
    public long inQueueCost;
    public long inQueueStartTime;
    public boolean isCmwapRetried;
    public boolean isRequestInCmwap;
    public Object lockForSyncSend;
    public boolean mCanPrintUrl;
    public int mCmwapConnectionType;
    public HttpURLConnection mConn;
    public boolean mHaveIpConnect;
    public AtomicBoolean mIsCancel;
    public boolean mIsHostIP;
    public boolean mIsHttps;
    public boolean mIsPreStructPic;
    public AtomicBoolean mIsPreempted;
    public boolean mIsSync;
    public boolean mNeedNotReferer;
    public String mReqHost;
    public boolean mUseByteArrayPool;
    public String msgId;
    public int netType;
    private final IHttpCommunicatorListener processor;
    public String rawReqHeader;
    public String rawRespHeader;
    private String realConnectString;
    private byte[] recvData;
    private String requestMethod;
    public HashMap<String, String> requestPropertys;
    public int responseCode;
    public HashMap<String, String> responsePropertys;
    private byte[] sendData;
    private int serial;
    public long startTime;
    public int threadPriority;
    public TimeoutParam timeoutParam;
    public long totalBlockLen;
    public long totalLen;
    public String[] whiteList_type;

    public HttpMsg(String str, byte[] bArr, IHttpCommunicatorListener iHttpCommunicatorListener) {
        this(str, bArr, iHttpCommunicatorListener, false);
    }

    public String getErrorString() {
        return this.errString;
    }

    public int getPriority() {
        return this.threadPriority;
    }

    public IHttpCommunicatorListener getProcessor() {
        return this.processor;
    }

    public String getRealUrl() {
        return this.realConnectString;
    }

    public byte[] getRecvData() {
        return this.recvData;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public HashMap<String, String> getRequestPropertys() {
        return this.requestPropertys;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String getResponseProperty(String str) {
        return this.responsePropertys.get(str);
    }

    public byte[] getSendData() {
        return this.sendData;
    }

    public int getSerial() {
        return this.serial;
    }

    public long getTotalLen() {
        return this.totalLen;
    }

    public String getUrl() {
        return this.connectString;
    }

    public String getUrlForLog() {
        String url = getUrl();
        if (!this.mCanPrintUrl) {
            return TransFileUtil.getIpOrDomainFromURL(url);
        }
        return url;
    }

    public boolean isDataSlice() {
        return this.bDataSlice;
    }

    public boolean isInstanceFollowRedirects() {
        return this.bInstanceFollowRedirects;
    }

    public boolean isViaWhiteShark() {
        return this.bViaWhiteShark;
    }

    public boolean permitRetry() {
        if (this.responsePropertys.containsKey(XRetryFlag) && "0".equals(this.responsePropertys.get(XRetryFlag))) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "permitRetry : X-RtFlag = 0");
            }
            return false;
        }
        int i3 = this.errCode;
        if (i3 == 9048 || i3 == 9057 || i3 == 9020 || i3 == 9022 || i3 == 9366 || i3 == 9058) {
            return false;
        }
        return true;
    }

    public void refresh() {
        resetTranFlag();
        this.errCode = 0;
        this.responseCode = 0;
        this.errString = null;
        this.recvData = null;
    }

    public void resetTranFlag() {
        this.mIsCancel.set(false);
        this.mIsPreempted.set(false);
        AtomicBoolean atomicBoolean = this.hasFinished;
        if (atomicBoolean != null) {
            atomicBoolean.set(false);
        }
        this.mConn = null;
    }

    public void setConnectString(String str) {
        this.connectString = str;
    }

    public void setDataSlice(boolean z16) {
        this.bDataSlice = z16;
    }

    public void setHttpErrorCode(int i3, int i16, String str) {
        this.errCode = i3;
        this.responseCode = i16;
        this.errString = str;
    }

    public void setInstanceFollowRedirects(boolean z16) {
        this.bInstanceFollowRedirects = z16;
    }

    public void setPriority(int i3) {
        if (i3 == 5) {
            this.threadPriority = 201;
            return;
        }
        if (i3 == 1) {
            this.threadPriority = 202;
        } else if (i3 == 10) {
            this.threadPriority = 200;
        } else {
            this.threadPriority = i3;
        }
    }

    public void setRealUrl(String str) {
        this.realConnectString = str;
    }

    public void setRecvData(byte[] bArr) {
        this.recvData = bArr;
    }

    public void setRequestMethod(String str) {
        this.requestMethod = str;
    }

    public void setRequestProperty(String str, String str2) {
        if (str != null && str2 != null) {
            this.requestPropertys.put(str, str2);
        }
    }

    public void setResponseCode(int i3) {
        this.responseCode = i3;
    }

    public void setResponseProperty(String str, String str2) {
        if (str != null && str2 != null) {
            this.responsePropertys.put(str, str2);
        }
    }

    public void setSendData(byte[] bArr) {
        this.sendData = bArr;
    }

    public void setSerial(int i3) {
        this.serial = i3;
    }

    public void setUrl(String str) {
        this.connectString = str;
        this.realConnectString = str.substring(0, str.length());
    }

    public void setViaWhiteShark(boolean z16) {
        this.bViaWhiteShark = z16;
    }

    public HttpMsg(String str, byte[] bArr, IHttpCommunicatorListener iHttpCommunicatorListener, boolean z16) {
        this.threadPriority = 201;
        this.requestMethod = "GET";
        this.serial = 0;
        this.requestPropertys = new HashMap<>();
        this.bDataSlice = false;
        this.bInstanceFollowRedirects = true;
        this.bReportRedirects = false;
        this.bViaWhiteShark = false;
        this.fileType = -1;
        this.busiType = -1;
        this.mIsCancel = new AtomicBoolean(false);
        this.mIsPreempted = new AtomicBoolean(false);
        this.lockForSyncSend = null;
        this.mConn = null;
        this.responseCode = -1;
        this.totalLen = 0L;
        this.totalBlockLen = 0L;
        this.errString = null;
        this.responsePropertys = new HashMap<>();
        this.startTime = 0L;
        this.cost = 0L;
        this.inQueueStartTime = 0L;
        this.inQueueCost = 0L;
        this.mCanPrintUrl = true;
        this.mUseByteArrayPool = false;
        this.mCmwapConnectionType = 0;
        this.isRequestInCmwap = false;
        this.isCmwapRetried = false;
        this.mHaveIpConnect = false;
        this.mNeedNotReferer = false;
        this.connectString = str;
        if (str != null) {
            this.realConnectString = str.substring(0, str.length());
        } else {
            this.realConnectString = null;
        }
        this.processor = iHttpCommunicatorListener;
        if (bArr == null) {
            this.sendData = null;
        } else {
            byte[] bArr2 = new byte[bArr.length];
            this.sendData = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        }
        this.bVerifyPayment = z16;
    }
}

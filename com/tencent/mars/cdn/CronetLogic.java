package com.tencent.mars.cdn;

import com.tencent.luggage.wxa.aa.h;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class CronetLogic {
    static IPatchRedirector $redirector_ = null;
    private static List<CronetTaskNetworkStateCallback> cronetTaskNetworkStateCallbackList = null;
    private static CronetDnsCallback simpleDnsCallback = null;
    private static boolean useHttpdns = false;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class ChunkedData {
        static IPatchRedirector $redirector_;
        public byte[] data;

        public ChunkedData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.data = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface CronetDnsCallback {
        String[] dns(String str);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class CronetDnsType {
        static IPatchRedirector $redirector_ = null;
        public static final int BACKUP_DNS = 4;
        public static final int CELLULAR_DNS = 5;
        public static final int DEFAULT = 0;
        public static final int HTTP_DNS = 3;
        public static final int NEW_DNS = 2;
        public static final int SIMPLE_DNS = 1;

        public CronetDnsType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class CronetDownloadProgress {
        static IPatchRedirector $redirector_;
        public long currentWriteByte;
        public long totalByte;

        public CronetDownloadProgress() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.totalByte = 0L;
                this.currentWriteByte = 0L;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class CronetHttpsCreateResult {
        static IPatchRedirector $redirector_;
        public int createRet;
        public String taskId;

        public CronetHttpsCreateResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.createRet = 0;
                this.taskId = "";
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class CronetRequestParams {
        static IPatchRedirector $redirector_;
        public byte[] bodyData;
        public DefaultHttpTaskParams defaultHttpTaskParams;
        public int dnsType;
        public boolean enableBrotli;
        public boolean followRedirect;
        public boolean forbidSocketReuse;
        public boolean forceBindMobileNetwork;
        public String header;
        public HeaderMap[] headers;
        public HostIPHint hostIPHint;
        public int maxRedirectCount;
        public int maxRetryCount;
        public String method;
        public boolean miniPrograms;
        public boolean needGenerateId;
        public boolean needWriteLocal;
        public boolean preferMobileBecauseWifiIsWeak;
        public String savePath;
        public String taskId;
        public int taskType;
        public UploadParams uploadParams;
        public String url;
        public boolean useHttp2;
        public boolean useMemoryCache;
        public boolean useQuic;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static class CronetTaskType {
            static IPatchRedirector $redirector_ = null;
            public static final int CUSTOM_FILE_DOWNLOAD = 9;
            public static final int DEFAULT_HTTP_REQUEST = 8;
            public static final int HTTP2_DOWNLOAD = 4;
            public static final int HTTP2_REQUEST = 3;
            public static final int HTTP_CHUNK_REQUEST = 10;
            public static final int HTTP_DOWNLOAD = 2;
            public static final int HTTP_REQUEST = 1;
            public static final int HTTP_UPLOAD = 7;
            public static final int NONE = 0;
            public static final int QUIC_DOWNLOAD = 6;
            public static final int QUIC_REQUEST = 5;

            public CronetTaskType() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        public CronetRequestParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.url = "";
            this.taskId = "";
            this.header = "";
            this.bodyData = null;
            this.method = "";
            this.savePath = "";
            this.needWriteLocal = false;
            this.followRedirect = false;
            this.maxRedirectCount = 2;
            this.taskType = 0;
            this.useMemoryCache = false;
            this.needGenerateId = true;
            this.defaultHttpTaskParams = null;
            this.headers = null;
            this.useHttp2 = false;
            this.useQuic = false;
            this.enableBrotli = false;
            this.hostIPHint = null;
            this.dnsType = 0;
            this.forbidSocketReuse = false;
            this.miniPrograms = false;
            this.forceBindMobileNetwork = false;
            this.preferMobileBecauseWifiIsWeak = false;
            this.uploadParams = null;
            this.maxRetryCount = 1;
        }

        public void makeRequestHeader(Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
                return;
            }
            if (map != null && map.isEmpty()) {
                return;
            }
            int size = map.size();
            this.headers = new HeaderMap[size];
            int i3 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                HeaderMap headerMap = new HeaderMap();
                headerMap.key = entry.getKey();
                headerMap.value = entry.getValue();
                this.headers[i3] = headerMap;
                i3++;
                if (i3 > size) {
                    return;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface CronetTaskCallback {
        void onCronetReceiveChunkedData(ChunkedData chunkedData, long j3);

        int onCronetReceiveHeader(ResponseHeader responseHeader, int i3, String str);

        void onCronetReceiveUploadProgress(long j3, long j16);

        void onCronetTaskCompleted(String str, CronetTaskResult cronetTaskResult, String str2);

        void onDownloadProgressChanged(String str, CronetDownloadProgress cronetDownloadProgress);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface CronetTaskNetworkStateCallback {
        void onNetWeakChange(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class CronetTaskResult {
        static IPatchRedirector $redirector_;
        public int cronetErrorCode;
        public byte[] data;
        public int dnsType;
        public int errorCode;
        public String errorMsg;
        public HeaderMap[] headers;
        public String newLocation;
        public String originTaskId;
        public int quicErrorCode;
        public String rawHeader;
        public int statusCode;
        public String statusText;
        public long totalReceiveByte;
        public long totalSendByte;
        public long totalWriteByte;
        public boolean useHttp2;
        public boolean useQuic;
        public WebPageProfile webPageProfile;

        public CronetTaskResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.data = null;
            this.statusCode = 0;
            this.rawHeader = "";
            this.newLocation = "";
            this.statusText = "";
            this.totalReceiveByte = 0L;
            this.totalWriteByte = 0L;
            this.originTaskId = "";
            this.errorMsg = "";
            this.errorCode = 0;
            this.quicErrorCode = 0;
            this.headers = null;
            this.cronetErrorCode = 0;
            this.totalSendByte = 0L;
            this.useQuic = false;
            this.useHttp2 = false;
            this.dnsType = 0;
        }

        public String getDataString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            try {
                return new String(this.data, "UTF-8");
            } catch (Exception unused) {
                return "";
            }
        }

        public Map<String, String> getHeaderMap() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            IdentityHashMap identityHashMap = new IdentityHashMap();
            HeaderMap[] headerMapArr = this.headers;
            if (headerMapArr != null) {
                for (HeaderMap headerMap : headerMapArr) {
                    if (headerMap != null && (str = headerMap.key) != null && headerMap.value != null) {
                        identityHashMap.put(new String(str), headerMap.value);
                    }
                }
            }
            return identityHashMap;
        }

        public Map<String, List<String>> getHeaderMapList() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : getHeaderMap().entrySet()) {
                String key = entry.getKey();
                if (key != null && !key.isEmpty()) {
                    String value = entry.getValue();
                    List list = (List) hashMap.get(key);
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(value);
                    hashMap.put(key, list);
                }
            }
            return hashMap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class DefaultHttpTaskParams {
        static IPatchRedirector $redirector_;
        public int reportId;

        public DefaultHttpTaskParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.reportId = 0;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class HeaderMap {
        static IPatchRedirector $redirector_;
        public String key;
        public String value;

        public HeaderMap() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.key = "";
                this.value = "";
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class HostIPHint {
        static IPatchRedirector $redirector_;
        public HostIpMap[] hostMap;

        public HostIPHint() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class HostIpMap {
        static IPatchRedirector $redirector_;
        public String host;

        /* renamed from: ip, reason: collision with root package name */
        public String f151360ip;
        public int port;

        public HostIpMap() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class QuicForceHost {
        static IPatchRedirector $redirector_;
        public String host;
        public int port;

        public QuicForceHost() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class QuicHostMap {
        static IPatchRedirector $redirector_;
        public String host;

        /* renamed from: ip, reason: collision with root package name */
        public String f151361ip;
        public int port;

        public QuicHostMap() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class QuicTaskParams {
        static IPatchRedirector $redirector_;
        public QuicForceHost[] quicForceHosts;
        public QuicHostMap[] quicHostMaps;

        public QuicTaskParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class ResponseHeader {
        static IPatchRedirector $redirector_;
        public HeaderMap[] headers;

        public ResponseHeader() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.headers = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class UploadParams {
        static IPatchRedirector $redirector_;
        public byte[] endData;
        public String filePath;
        public byte[] formData;
        public int reportId;
        public long uploadOffset;
        public long uploadRange;
        public boolean vfsPath;

        public UploadParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.uploadOffset = 0L;
            this.uploadRange = 0L;
            this.vfsPath = false;
            this.reportId = 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class WebPageProfile {
        static IPatchRedirector $redirector_;
        public long SSLconnectionEnd;
        public long SSLconnectionStart;
        public long connectEnd;
        public long connectStart;
        public long domainLookUpEnd;
        public long domainLookUpStart;
        public int downstreamThroughputKbpsEstimate;
        public long fetchStart;
        public int httpRttEstimate;
        public int networkTypeEstimate;
        public String peerIP;
        public int port;

        /* renamed from: protocol, reason: collision with root package name */
        public String f151362protocol;
        public long receivedBytedCount;
        public long redirectEnd;
        public long redirectStart;
        public long requestEnd;
        public long requestStart;
        public long responseEnd;
        public long responseStart;
        public int rtt;
        public long sendBytesCount;
        public boolean socketReused;
        public int statusCode;
        public int throughputKbps;
        public int transportRttEstimate;

        public WebPageProfile() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f151362protocol = "";
                this.peerIP = "";
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "WebPageProfile{redirectStart=" + this.redirectStart + ", redirectEnd=" + this.redirectEnd + ", fetchStart=" + this.fetchStart + ", domainLookUpStart=" + this.domainLookUpStart + ", domainLookUpEnd=" + this.domainLookUpEnd + ", connectStart=" + this.connectStart + ", connectEnd=" + this.connectEnd + ", SSLconnectionStart=" + this.SSLconnectionStart + ", SSLconnectionEnd=" + this.SSLconnectionEnd + ", requestStart=" + this.requestStart + ", requestEnd=" + this.requestEnd + ", responseStart=" + this.responseStart + ", responseEnd=" + this.responseEnd + ", protocol='" + this.f151362protocol + "', rtt=" + this.rtt + ", statusCode=" + this.statusCode + ", networkTypeEstimate=" + this.networkTypeEstimate + ", httpRttEstimate=" + this.httpRttEstimate + ", transportRttEstimate=" + this.transportRttEstimate + ", downstreamThroughputKbpsEstimate=" + this.downstreamThroughputKbpsEstimate + ", throughputKbps=" + this.throughputKbps + ", peerIP='" + this.peerIP + "', port=" + this.port + ", socketReused=" + this.socketReused + ", sendBytesCount=" + this.sendBytesCount + ", receivedBytedCount=" + this.receivedBytedCount + '}';
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58953);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            cronetTaskNetworkStateCallbackList = new ArrayList();
        }
    }

    public CronetLogic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void addCronetTaskNetworkStateCallback(CronetTaskNetworkStateCallback cronetTaskNetworkStateCallback) {
        cronetTaskNetworkStateCallbackList.add(cronetTaskNetworkStateCallback);
    }

    public static native void cancelCronetTask(String str);

    public static Map<String, List<String>> getHeaderList(ResponseHeader responseHeader) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : getHeaderMap(responseHeader).entrySet()) {
            String key = entry.getKey();
            if (key != null && !key.isEmpty()) {
                String value = entry.getValue();
                List list = (List) hashMap.get(key);
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(value);
                hashMap.put(key, list);
            }
        }
        return hashMap;
    }

    public static Map<String, String> getHeaderMap(ResponseHeader responseHeader) {
        HeaderMap[] headerMapArr;
        String str;
        IdentityHashMap identityHashMap = new IdentityHashMap();
        if (responseHeader != null && (headerMapArr = responseHeader.headers) != null) {
            for (HeaderMap headerMap : headerMapArr) {
                if (headerMap != null && (str = headerMap.key) != null && headerMap.value != null) {
                    identityHashMap.put(new String(str), headerMap.value);
                }
            }
        }
        return identityHashMap;
    }

    public static String getSystemProperty(String str) {
        String property = System.getProperty(str);
        w.a("cronet", "property " + str + " res " + property);
        return property;
    }

    public static boolean getUseHttpdns() {
        return useHttpdns;
    }

    public static void initializeNativeLib() {
        h.h("andromeda");
    }

    public static void notifyCronetWeaknet(boolean z16) {
        w.d("cronet", "receive weaknet notify " + (z16 ? 1 : 0));
        List<CronetTaskNetworkStateCallback> list = cronetTaskNetworkStateCallbackList;
        if (list != null && list.size() > 0) {
            Iterator<CronetTaskNetworkStateCallback> it = cronetTaskNetworkStateCallbackList.iterator();
            while (it.hasNext()) {
                it.next().onNetWeakChange(z16);
            }
        }
    }

    public static void removeCronetTaskNetworkStateCallback(CronetTaskNetworkStateCallback cronetTaskNetworkStateCallback) {
        cronetTaskNetworkStateCallbackList.remove(cronetTaskNetworkStateCallback);
    }

    public static native void removeUserCert();

    public static native void setGoodNetNotifyInterval(int i3);

    public static void setSimpleDnsCallback(CronetDnsCallback cronetDnsCallback) {
        simpleDnsCallback = cronetDnsCallback;
    }

    public static void setUseHttpdns(boolean z16) {
        w.d("cronet", "use httpdns " + z16);
        useHttpdns = z16;
    }

    public static native void setUserCertVerify(boolean z16);

    public static String[] simpleDns(String str) {
        return simpleDnsCallback.dns(str);
    }

    public static native CronetHttpsCreateResult startCronetDefaultHttpTask(CronetRequestParams cronetRequestParams, CronetTaskCallback cronetTaskCallback);

    public static native CronetHttpsCreateResult startCronetDownloadTask(CronetRequestParams cronetRequestParams, CronetTaskCallback cronetTaskCallback);

    public static native CronetHttpsCreateResult startCronetHttpTask(CronetRequestParams cronetRequestParams, CronetTaskCallback cronetTaskCallback);

    public static native CronetHttpsCreateResult startCronetTask(CronetRequestParams cronetRequestParams, CronetTaskCallback cronetTaskCallback);

    public static native CronetHttpsCreateResult startCronetUploadTask(CronetRequestParams cronetRequestParams, CronetTaskCallback cronetTaskCallback);
}

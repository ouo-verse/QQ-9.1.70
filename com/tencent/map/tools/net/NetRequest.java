package com.tencent.map.tools.net;

import android.text.TextUtils;
import com.tencent.map.tools.net.http.HttpCanceler;
import com.tencent.map.tools.net.http.HttpProxy;
import com.tencent.map.tools.net.http.HttpProxyRule;
import com.tencent.map.tools.net.processor.Processor;
import com.tencent.mapsdk.internal.hq;
import com.tencent.mapsdk.internal.md;
import com.tencent.mapsdk.internal.mf;
import com.tencent.mapsdk.internal.mg;
import com.tencent.mapsdk.internal.mh;
import com.tencent.mapsdk.internal.mj;
import com.tencent.mapsdk.internal.mk;
import com.tencent.tencentmap.mapsdk.maps.model.LocationRegion;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes9.dex */
public class NetRequest {
    public HttpCanceler canceler;
    private File mCacheFile;
    private boolean mIsLogEnable;
    private NetAdapter mNetAdapter;
    private HashSet<Class<? extends md>> mNetFlowProcessorClz;
    private HashMap<String, String> mNetFlowRules;
    public NetMethod mNetMethod;
    private List<HttpProxyRule> mProxyRules;
    private HashMap<String, Map<String, String>> mRegionHostList;
    private String mSecretKey;
    public byte[] postData;
    public HttpProxy proxy;
    public int retryMethod;
    public int timeout;
    public String url;
    public final long mRequestId = System.nanoTime();
    public final Map<String, String> mapHeaders = new HashMap();
    public final Set<String> respHeaders = new HashSet();
    public final List<Processor> processors = new ArrayList();
    private boolean mForceHttps = true;
    public LocationRegion.RegionName mRegionName = LocationRegion.RegionName.EARTH;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class NetRequestBuilder {
        private final NetRequest mNetRequest;

        /* JADX INFO: Access modifiers changed from: package-private */
        public NetRequestBuilder(NetAdapter netAdapter, String str, LocationRegion locationRegion) {
            this(netAdapter, str, locationRegion, null);
        }

        private NetResponse onRequestFinish(NetResponse netResponse) {
            if (netResponse != null) {
                File file = this.mNetRequest.mCacheFile;
                if (file != null) {
                    FileOutputStream fileOutputStream = null;
                    try {
                        try {
                            if (file.isFile()) {
                                if (file.exists()) {
                                    file.delete();
                                }
                                file.getParentFile().mkdirs();
                                file.createNewFile();
                            }
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            try {
                                NetUtil.writeBytesWithoutClose(netResponse.data, fileOutputStream2);
                                NetUtil.safeClose(fileOutputStream2);
                            } catch (Exception e16) {
                                e = e16;
                                fileOutputStream = fileOutputStream2;
                                NetUtil.safeClose(fileOutputStream);
                                netResponse.exception(e);
                                NetUtil.safeClose(fileOutputStream);
                                return netResponse;
                            } catch (Throwable th5) {
                                th = th5;
                                fileOutputStream = fileOutputStream2;
                                NetUtil.safeClose(fileOutputStream);
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    } catch (Exception e17) {
                        e = e17;
                    }
                }
                return netResponse;
            }
            NetResponse netResponse2 = new NetResponse(this.mNetRequest);
            netResponse2.errorCode = -100;
            netResponse2.errorData = "\u672a\u77e5".getBytes();
            return netResponse2;
        }

        private void onRequestStart(String str, NetRequestBuilder netRequestBuilder) {
            netRequestBuilder.addProcessor(new mh(this.mNetRequest.mIsLogEnable));
            netRequestBuilder.addProcessor(mf.a(this.mNetRequest.mForceHttps));
            netRequestBuilder.addProcessor(mg.a(this.mNetRequest.mProxyRules));
            netRequestBuilder.addProcessor(mk.a(this.mNetRequest.mSecretKey));
            netRequestBuilder.addProcessor(new mj(this.mNetRequest.mRegionHostList));
            if (this.mNetRequest.mProxyRules == null || this.mNetRequest.mProxyRules.size() <= 0) {
                Iterator it = this.mNetRequest.mNetFlowProcessorClz.iterator();
                while (it.hasNext()) {
                    try {
                        netRequestBuilder.addProcessor((md) hq.a((Class) it.next(), this.mNetRequest.mNetFlowRules));
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }

        public NetRequestBuilder addProcessor(Processor processor) {
            this.mNetRequest.addProcessor(processor);
            return this;
        }

        public NetRequestBuilder canceler(HttpCanceler httpCanceler) {
            this.mNetRequest.canceler = httpCanceler;
            return this;
        }

        public NetResponse doGet() {
            onRequestStart("doGet", this);
            return onRequestFinish(this.mNetRequest.doGet());
        }

        public NetResponse doPost() {
            onRequestStart("doPost", this);
            return onRequestFinish(this.mNetRequest.doPost());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public NetResponse doRequest() {
            onRequestStart("doRequest", this);
            return onRequestFinish(this.mNetRequest.doRequest());
        }

        public NetResponse doStream() {
            onRequestStart("doStream", this);
            return onRequestFinish(this.mNetRequest.doStream());
        }

        public NetResponse downloadTo(File file) {
            onRequestStart("downloadTo[" + file + "]", this);
            return file(file).doGet();
        }

        public NetRequestBuilder file(File file) {
            this.mNetRequest.mCacheFile = file;
            return this;
        }

        public NetRequestBuilder forceHttps(boolean z16) {
            this.mNetRequest.mForceHttps = z16;
            return this;
        }

        public NetRequest getNetRequest() {
            return this.mNetRequest;
        }

        public NetRequestBuilder gzip() {
            header("Accept-Encoding", "gzip");
            return this;
        }

        public NetRequestBuilder header(HashMap<String, String> hashMap) {
            this.mNetRequest.setMapHeaders(hashMap);
            return this;
        }

        public NetRequestBuilder nonce(String str) {
            this.mNetRequest.setNonce(str);
            return this;
        }

        public NetRequestBuilder postData(byte[] bArr) {
            this.mNetRequest.postData = bArr;
            return this;
        }

        public NetRequestBuilder proxy(HttpProxy httpProxy) {
            this.mNetRequest.proxy = httpProxy;
            return this;
        }

        public NetRequestBuilder region(LocationRegion.RegionName regionName) {
            this.mNetRequest.mRegionName = regionName;
            return this;
        }

        public NetRequestBuilder retryNum(int i3) {
            this.mNetRequest.retryMethod = i3;
            return this;
        }

        public NetRequestBuilder startTag(String str) {
            this.mNetRequest.setStart(str);
            return this;
        }

        public NetRequestBuilder timeOut(int i3) {
            this.mNetRequest.timeout = i3;
            return this;
        }

        public NetRequestBuilder timestamp(String str) {
            this.mNetRequest.setTimeStamp(str);
            return this;
        }

        public String toString() {
            return "NetRequestBuilder{, mRequestId=" + this.mNetRequest.mRequestId + ", mNetRequest=" + this.mNetRequest + '}';
        }

        public NetRequestBuilder token(String str) {
            this.mNetRequest.setToken(str);
            return this;
        }

        public NetRequestBuilder url(String str) {
            this.mNetRequest.url = str;
            return this;
        }

        public NetRequestBuilder userAgent(String str) {
            this.mNetRequest.setUserAgent(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public NetRequestBuilder(NetAdapter netAdapter, String str, LocationRegion locationRegion, NetRequest netRequest) {
            if (netRequest == null) {
                this.mNetRequest = new NetRequest().setTimeout(10000).setRetryMethod(1);
            } else {
                this.mNetRequest = netRequest;
            }
            this.mNetRequest.mNetAdapter = netAdapter;
            this.mNetRequest.mSecretKey = str;
            this.mNetRequest.mProxyRules = netAdapter.getProxyRuleList();
            this.mNetRequest.mIsLogEnable = netAdapter.isLogEnable();
            this.mNetRequest.mNetFlowProcessorClz = netAdapter.getNetFlowProcessor();
            this.mNetRequest.mNetFlowRules = netAdapter.getNetFlowRuleList();
            this.mNetRequest.mRegionHostList = netAdapter.getRegionHostList();
            if (locationRegion != null) {
                this.mNetRequest.mRegionName = locationRegion.regionName;
            }
        }

        public NetRequestBuilder header(String str, String str2) {
            this.mNetRequest.setMapHeaders(str, str2);
            return this;
        }
    }

    public NetRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NetResponse doGet() {
        setNetMethod(NetMethod.GET);
        return this.mNetAdapter.doRequest(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NetResponse doPost() {
        setNetMethod(NetMethod.POST);
        return this.mNetAdapter.doRequest(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NetResponse doRequest() {
        return this.mNetAdapter.doRequest(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NetResponse doStream() {
        setNetMethod(NetMethod.GET);
        return this.mNetAdapter.openStream(this);
    }

    public NetRequest addProcessor(Processor processor) {
        this.processors.add(processor);
        return this;
    }

    public NetRequest setCanceler(HttpCanceler httpCanceler) {
        this.canceler = httpCanceler;
        return this;
    }

    public NetRequest setMapHeaders(Map<String, String> map) {
        if (map == null) {
            return this;
        }
        this.mapHeaders.putAll(map);
        return this;
    }

    public NetRequest setNetMethod(NetMethod netMethod) {
        this.mNetMethod = netMethod;
        return this;
    }

    public NetRequest setNonce(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mapHeaders.put("nonce", str);
        }
        return this;
    }

    public NetRequest setPostData(byte[] bArr) {
        this.postData = bArr;
        return this;
    }

    public NetRequest setRespHeaders(String... strArr) {
        this.respHeaders.addAll(Arrays.asList((Object[]) strArr.clone()));
        return this;
    }

    public NetRequest setRetryMethod(int i3) {
        this.retryMethod = i3;
        return this;
    }

    public NetRequest setStart(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mapHeaders.put("Range", "bytes=" + str + "-");
        }
        return this;
    }

    public NetRequest setTimeStamp(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mapHeaders.put("timestamp", str);
        }
        return this;
    }

    public NetRequest setTimeout(int i3) {
        this.timeout = i3;
        return this;
    }

    public NetRequest setToken(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mapHeaders.put("Sign", str);
        }
        return this;
    }

    public NetRequest setUrl(String str) {
        this.url = str;
        return this;
    }

    public NetRequest setUserAgent(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mapHeaders.put("User-Agent", str);
        }
        return this;
    }

    public String toString() {
        return "NetRequest{mRequestId=" + this.mRequestId + ", mNetMethod=" + this.mNetMethod + ", url='" + this.url + "', postData=" + Arrays.toString(this.postData) + ", retryMethod=" + this.retryMethod + ", mapHeaders=" + this.mapHeaders + ", respHeaders=" + this.respHeaders + ", processorSet=" + this.processors + ", canceler=" + this.canceler + ", timeout=" + this.timeout + ", proxy=" + this.proxy + '}';
    }

    public NetRequest setMapHeaders(String str, String str2) {
        this.mapHeaders.put(str, str2);
        return this;
    }

    public NetRequest(NetMethod netMethod, String str) {
        this.mNetMethod = netMethod;
        this.url = str;
    }
}

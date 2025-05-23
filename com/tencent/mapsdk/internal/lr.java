package com.tencent.mapsdk.internal;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.map.tools.net.http.HttpCanceler;
import com.tencent.map.tools.net.http.HttpConnectionInputStream;
import com.tencent.map.tools.net.http.HttpProxy;
import com.tencent.map.tools.net.processor.Processor;
import com.tencent.map.tools.net.processor.RequestProcessor;
import com.tencent.map.tools.net.processor.ResponseProcessor;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class lr extends lq {

    /* renamed from: b, reason: collision with root package name */
    private static final String f149241b = "URLNetImpl";

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f149242c = false;

    /* renamed from: d, reason: collision with root package name */
    private HttpURLConnection f149243d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {

        /* renamed from: c, reason: collision with root package name */
        private static final int f149246c = 3;

        /* renamed from: a, reason: collision with root package name */
        int f149247a;

        /* renamed from: b, reason: collision with root package name */
        boolean f149248b = true;

        a(int i3) {
            this.f149247a = i3;
            if (i3 > 3) {
                this.f149247a = 3;
            }
            if (this.f149247a <= 0) {
                this.f149247a = 1;
            }
        }

        private boolean b() {
            if (this.f149248b && this.f149247a > 0) {
                return true;
            }
            return false;
        }

        private void c() {
            this.f149248b = false;
        }

        final void a() {
            this.f149247a--;
        }
    }

    static /* synthetic */ HttpURLConnection a(lr lrVar) {
        lrVar.f149243d = null;
        return null;
    }

    private static void b() {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private NetResponse c(NetRequest netRequest) {
        URL url;
        boolean z16;
        OutputStream outputStream;
        OutputStream outputStream2;
        lr lrVar = this;
        NetRequest netRequest2 = netRequest;
        try {
            for (Processor processor : netRequest2.processors) {
                if (processor instanceof RequestProcessor) {
                    ((RequestProcessor) processor).onRequest(netRequest2);
                }
            }
        } catch (Exception unused) {
        }
        NetResponse netResponse = new NetResponse(netRequest2);
        String str = netRequest2.url;
        int i3 = netRequest2.retryMethod;
        int i16 = netRequest2.timeout;
        byte[] bArr = netRequest2.postData;
        Map<String, String> map = netRequest2.mapHeaders;
        HttpCanceler httpCanceler = netRequest2.canceler;
        HttpProxy httpProxy = netRequest2.proxy;
        Set<String> set = netRequest2.respHeaders;
        try {
            url = new URL(str);
            try {
                URL proxyURL = HttpProxy.getProxyURL(httpProxy);
                if (proxyURL != null) {
                    url = proxyURL;
                }
            } catch (MalformedURLException e16) {
                e = e16;
                netResponse.exception(e);
                if (url != null) {
                }
                return netResponse;
            }
        } catch (MalformedURLException e17) {
            e = e17;
            url = null;
        }
        if (url != null) {
            final a aVar = new a(i3);
            while (true) {
                int i17 = 0;
                if (aVar.f149248b && aVar.f149247a > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    break;
                }
                try {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(HttpProxy.getForwardProxy(httpProxy));
                        httpURLConnection.setRequestMethod(netRequest2.mNetMethod.name());
                        httpURLConnection.setUseCaches(false);
                        if (i16 > 0) {
                            try {
                                httpURLConnection.setConnectTimeout(i16);
                                httpURLConnection.setReadTimeout(i16);
                            } catch (SocketTimeoutException e18) {
                                e = e18;
                                outputStream2 = null;
                                netResponse.exception(e);
                                netResponse.statusCode = i17;
                                aVar.a();
                                a(netResponse);
                                NetUtil.safeClose(outputStream2);
                                lrVar = this;
                                netRequest2 = netRequest;
                            } catch (IOException e19) {
                                e = e19;
                                outputStream2 = null;
                                netResponse.exception(e);
                                netResponse.statusCode = i17;
                                aVar.a();
                                a(netResponse);
                                NetUtil.safeClose(outputStream2);
                                lrVar = this;
                                netRequest2 = netRequest;
                            }
                        }
                        if (!map.isEmpty()) {
                            try {
                                for (Map.Entry<String, String> entry : map.entrySet()) {
                                    String key = entry.getKey();
                                    String value = entry.getValue();
                                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                                        httpURLConnection.addRequestProperty(key, value);
                                    }
                                }
                            } catch (SocketTimeoutException e26) {
                                e = e26;
                                outputStream2 = null;
                                i17 = 0;
                                netResponse.exception(e);
                                netResponse.statusCode = i17;
                                aVar.a();
                                a(netResponse);
                                NetUtil.safeClose(outputStream2);
                                lrVar = this;
                                netRequest2 = netRequest;
                            } catch (IOException e27) {
                                e = e27;
                                outputStream2 = null;
                                i17 = 0;
                                netResponse.exception(e);
                                netResponse.statusCode = i17;
                                aVar.a();
                                a(netResponse);
                                NetUtil.safeClose(outputStream2);
                                lrVar = this;
                                netRequest2 = netRequest;
                            }
                        }
                        if (httpCanceler != null) {
                            httpCanceler.setHttpAccessRequest(lrVar, new Callback<Boolean>() { // from class: com.tencent.mapsdk.internal.lr.1
                                private void a() {
                                    aVar.f149248b = false;
                                    lr.a(lr.this);
                                }

                                @Override // com.tencent.map.tools.Callback
                                public final /* synthetic */ void callback(Boolean bool) {
                                    aVar.f149248b = false;
                                    lr.a(lr.this);
                                }
                            });
                            lrVar.f149243d = httpURLConnection;
                        }
                        if (bArr != null && bArr.length > 0) {
                            httpURLConnection.setDoOutput(true);
                            outputStream2 = httpURLConnection.getOutputStream();
                            try {
                                try {
                                    NetUtil.writeBytesWithoutClose(bArr, outputStream2);
                                } catch (SocketTimeoutException e28) {
                                    e = e28;
                                    i17 = 0;
                                    netResponse.exception(e);
                                    netResponse.statusCode = i17;
                                    aVar.a();
                                    a(netResponse);
                                    NetUtil.safeClose(outputStream2);
                                    lrVar = this;
                                    netRequest2 = netRequest;
                                } catch (IOException e29) {
                                    e = e29;
                                    i17 = 0;
                                    netResponse.exception(e);
                                    netResponse.statusCode = i17;
                                    aVar.a();
                                    a(netResponse);
                                    NetUtil.safeClose(outputStream2);
                                    lrVar = this;
                                    netRequest2 = netRequest;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                outputStream = outputStream2;
                                try {
                                    a(netResponse);
                                } catch (Exception unused2) {
                                }
                                NetUtil.safeClose(outputStream);
                                throw th;
                            }
                        } else {
                            outputStream2 = null;
                        }
                        try {
                            httpURLConnection.connect();
                            int responseCode = httpURLConnection.getResponseCode();
                            try {
                                netResponse.statusCode = responseCode;
                                netResponse.charset = lq.a(httpURLConnection.getContentType());
                                if (!set.isEmpty()) {
                                    for (String str2 : set) {
                                        netResponse.respHeads.put(str2, httpURLConnection.getHeaderField(str2));
                                    }
                                }
                                if (responseCode == 200) {
                                    netResponse.errorCode = 0;
                                    netResponse.contentEncoding = httpURLConnection.getContentEncoding();
                                    netResponse.contentLength = httpURLConnection.getContentLength();
                                    netResponse.dataStream = new HttpConnectionInputStream(httpURLConnection);
                                    aVar.f149248b = false;
                                } else {
                                    netResponse.errorData = NetUtil.toBytesThrow(httpURLConnection.getErrorStream());
                                    aVar.a();
                                }
                            } catch (SocketTimeoutException e36) {
                                e = e36;
                                i17 = responseCode;
                                netResponse.exception(e);
                                netResponse.statusCode = i17;
                                aVar.a();
                                a(netResponse);
                                NetUtil.safeClose(outputStream2);
                                lrVar = this;
                                netRequest2 = netRequest;
                            } catch (IOException e37) {
                                e = e37;
                                i17 = responseCode;
                                netResponse.exception(e);
                                netResponse.statusCode = i17;
                                aVar.a();
                                a(netResponse);
                                NetUtil.safeClose(outputStream2);
                                lrVar = this;
                                netRequest2 = netRequest;
                            }
                        } catch (SocketTimeoutException e38) {
                            e = e38;
                            i17 = 0;
                        } catch (IOException e39) {
                            e = e39;
                            i17 = 0;
                        }
                    } catch (SocketTimeoutException e46) {
                        e = e46;
                    } catch (IOException e47) {
                        e = e47;
                    }
                    try {
                        a(netResponse);
                    } catch (Exception unused3) {
                    }
                    NetUtil.safeClose(outputStream2);
                    lrVar = this;
                    netRequest2 = netRequest;
                } catch (Throwable th6) {
                    th = th6;
                    outputStream = null;
                }
            }
        }
        return netResponse;
    }

    private static void d(NetRequest netRequest) throws Exception {
        for (Processor processor : netRequest.processors) {
            if (processor instanceof RequestProcessor) {
                ((RequestProcessor) processor).onRequest(netRequest);
            }
        }
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public final boolean cancel() {
        HttpURLConnection httpURLConnection = this.f149243d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            return true;
        }
        return false;
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public final NetResponse doRequest(NetRequest netRequest) {
        netRequest.addProcessor(new me());
        return c(netRequest);
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public final NetResponse openStream(NetRequest netRequest) {
        netRequest.addProcessor(new ml());
        return c(netRequest);
    }

    private static void a(NetResponse netResponse) throws Exception {
        List<Processor> processors = netResponse.getProcessors();
        Collections.reverse(processors);
        for (Processor processor : processors) {
            if (processor instanceof ResponseProcessor) {
                ((ResponseProcessor) processor).onResponse(netResponse);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.lq
    protected final NetResponse b(NetRequest netRequest) {
        netRequest.setNetMethod(NetMethod.POST);
        return doRequest(netRequest);
    }

    @Override // com.tencent.mapsdk.internal.lq
    protected final NetResponse a(NetRequest netRequest) {
        netRequest.setNetMethod(NetMethod.GET);
        return doRequest(netRequest);
    }

    @Override // com.tencent.mapsdk.internal.lq
    protected final void a() {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }
}

package com.tencent.mapsdk.internal;

import android.net.Uri;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.http.HttpProxy;
import com.tencent.map.tools.net.http.HttpProxyRule;
import com.tencent.map.tools.net.processor.RequestProcessor;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class mg implements RequestProcessor {

    /* renamed from: a, reason: collision with root package name */
    private final List<HttpProxyRule> f149306a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f149307b = false;

    mg(List<HttpProxyRule> list) {
        this.f149306a = list;
    }

    public static mg a(List<HttpProxyRule> list) {
        return new mg(list);
    }

    private static mg b(List<HttpProxyRule> list) {
        return a(list);
    }

    @Override // com.tencent.map.tools.net.processor.RequestProcessor
    public final void onRequest(NetRequest netRequest) {
        HttpProxy httpProxy;
        String str = netRequest.url;
        boolean z16 = this.f149307b;
        List<HttpProxyRule> list = this.f149306a;
        if (list != null && !list.isEmpty()) {
            String str2 = str;
            boolean z17 = false;
            for (int i3 = 0; i3 < this.f149306a.size(); i3++) {
                HttpProxyRule httpProxyRule = this.f149306a.get(i3);
                if (httpProxyRule.match(str)) {
                    str2 = httpProxyRule.replaceHost(str);
                    z17 = true;
                }
            }
            if (z17) {
                Uri parse = Uri.parse(str2);
                String host = parse.getHost();
                int port = parse.getPort();
                if (port < 0 || port > 65535) {
                    if ("https".equals(parse.getScheme())) {
                        port = WebSocketImpl.DEFAULT_WSS_PORT;
                    } else {
                        port = 80;
                    }
                }
                httpProxy = new HttpProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, port)), str2, z16);
                netRequest.proxy = httpProxy;
            }
        }
        httpProxy = null;
        netRequest.proxy = httpProxy;
    }

    private HttpProxy a(String str, boolean z16) {
        List<HttpProxyRule> list = this.f149306a;
        if (list != null && !list.isEmpty()) {
            String str2 = str;
            boolean z17 = false;
            for (int i3 = 0; i3 < this.f149306a.size(); i3++) {
                HttpProxyRule httpProxyRule = this.f149306a.get(i3);
                if (httpProxyRule.match(str)) {
                    str2 = httpProxyRule.replaceHost(str);
                    z17 = true;
                }
            }
            if (z17) {
                Uri parse = Uri.parse(str2);
                String host = parse.getHost();
                int port = parse.getPort();
                if (port < 0 || port > 65535) {
                    port = "https".equals(parse.getScheme()) ? WebSocketImpl.DEFAULT_WSS_PORT : 80;
                }
                return new HttpProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, port)), str2, z16);
            }
        }
        return null;
    }
}

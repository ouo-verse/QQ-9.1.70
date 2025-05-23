package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

@ProxyService(proxy = WebSocketProxy.class)
/* loaded from: classes34.dex */
public class WebSocketProxyImpl extends WebSocketProxy {

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<Integer, a> f347670a = new ConcurrentHashMap<>();

    /* loaded from: classes34.dex */
    private class a {

        /* renamed from: a, reason: collision with root package name */
        public int f347675a;

        /* renamed from: b, reason: collision with root package name */
        public String f347676b;

        /* renamed from: c, reason: collision with root package name */
        public WebSocketProxy.WebSocketListener f347677c;

        /* renamed from: d, reason: collision with root package name */
        private OkHttpClient f347678d;

        /* renamed from: e, reason: collision with root package name */
        public WebSocket f347679e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f347680f = false;

        /* renamed from: com.tencent.qqmini.proxyimpl.WebSocketProxyImpl$a$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        class C9404a extends WebSocketListener {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ WebSocketProxyImpl f347682b;

            C9404a(WebSocketProxyImpl webSocketProxyImpl) {
                this.f347682b = webSocketProxyImpl;
            }

            @Override // okhttp3.WebSocketListener
            public void onClosed(WebSocket webSocket, int i3, String str) {
                a aVar = a.this;
                aVar.f347680f = true;
                aVar.f347677c.onClose(aVar.f347675a, i3, str);
                a aVar2 = a.this;
                WebSocketProxyImpl.this.f347670a.remove(Integer.valueOf(aVar2.f347675a));
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, String str) {
                a aVar = a.this;
                aVar.f347677c.onMessage(aVar.f347675a, str);
            }

            @Override // okhttp3.WebSocketListener
            public void onOpen(WebSocket webSocket, Response response) {
                a aVar = a.this;
                aVar.f347679e = webSocket;
                aVar.f347677c.onOpen(aVar.f347675a, response.code(), response.headers().toMultimap());
            }

            @Override // okhttp3.WebSocketListener
            public void onFailure(WebSocket webSocket, Throwable th5, @Nullable Response response) {
                QLog.e("WebSocketProxyImpl", 1, "onFailure : ", th5);
                a aVar = a.this;
                aVar.f347677c.onError(aVar.f347675a, z.d(th5, -1), th5.getMessage());
                a aVar2 = a.this;
                WebSocketProxyImpl.this.f347670a.remove(Integer.valueOf(aVar2.f347675a));
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, ByteString byteString) {
                a aVar = a.this;
                aVar.f347677c.onMessage(aVar.f347675a, byteString.toByteArray());
            }
        }

        public a(int i3, String str, Map<String, String> map, int i16, WebSocketProxy.WebSocketListener webSocketListener) {
            this.f347675a = i3;
            this.f347676b = str;
            this.f347677c = webSocketListener;
            Request.Builder newBuilder = new Request.Builder().url(str).build().newBuilder();
            if (map != null) {
                for (String str2 : map.keySet()) {
                    newBuilder.addHeader(str2, map.get(str2));
                }
            }
            Request build = newBuilder.build();
            long j3 = (i16 / 1000) + 1;
            OkHttpClient.Builder newBuilder2 = new OkHttpClient().newBuilder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            OkHttpClient build2 = newBuilder2.connectTimeout(j3, timeUnit).writeTimeout(j3, timeUnit).readTimeout(0L, timeUnit).build();
            this.f347678d = build2;
            build2.newWebSocket(build, new C9404a(WebSocketProxyImpl.this));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy
    public boolean closeSocket(final int i3, final int i16, final String str) {
        WebSocket webSocket;
        final a aVar = this.f347670a.get(Integer.valueOf(i3));
        if (aVar != null && (webSocket = aVar.f347679e) != null) {
            try {
                webSocket.close(i16, str);
                ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.WebSocketProxyImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a aVar2 = aVar;
                        if (aVar2.f347680f) {
                            return;
                        }
                        aVar2.f347677c.onClose(i3, i16, str);
                    }
                }, 1000L);
            } catch (Exception e16) {
                QLog.e("WebSocketProxyImpl", 1, "closeSocket error:", e16);
            }
        }
        this.f347670a.remove(Integer.valueOf(i3));
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy
    public boolean connectSocket(int i3, String str, Map<String, String> map, String str2, int i16, WebSocketProxy.WebSocketListener webSocketListener) {
        this.f347670a.put(Integer.valueOf(i3), new a(i3, str, map, i16, webSocketListener));
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy
    public void release() {
        WebSocket webSocket;
        for (a aVar : this.f347670a.values()) {
            if (aVar != null && (webSocket = aVar.f347679e) != null) {
                try {
                    webSocket.cancel();
                } catch (Throwable th5) {
                    QLog.e("WebSocketProxyImpl", 1, "websocket cancel throw:", th5);
                }
            }
        }
        this.f347670a.clear();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy
    public boolean send(int i3, byte[] bArr) {
        WebSocket webSocket;
        a aVar = this.f347670a.get(Integer.valueOf(i3));
        if (aVar != null && (webSocket = aVar.f347679e) != null) {
            try {
                webSocket.send(ByteString.of(bArr));
                return true;
            } catch (Exception e16) {
                QLog.e("WebSocketProxyImpl", 1, "sendBinaryMessage error:", e16);
            }
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy
    public boolean send(int i3, String str) {
        a aVar = this.f347670a.get(Integer.valueOf(i3));
        if (aVar != null && aVar.f347679e != null) {
            try {
                MediaType.parse("application/vnd.okhttp.websocket+text; charset=utf-8");
                aVar.f347679e.send(str);
                return true;
            } catch (Exception e16) {
                QLog.e("WebSocketProxyImpl", 1, "sendStringMessage error:", e16);
            }
        }
        return false;
    }
}

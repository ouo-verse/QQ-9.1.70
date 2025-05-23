package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules;

import android.util.Log;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\u00020\u0001:\u0002\b)B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J@\u0010\u0013\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J \u0010\u001a\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0002H\u0002JI\u0010#\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\"\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001cj\u0004\u0018\u0001`!H\u0016J\b\u0010$\u001a\u00020 H\u0016R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/y;", "Li01/e;", "", "params", "Lorg/json/JSONObject;", "c", "", "d", "a", "", "socketId", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/y$b;", "taskMap", "protocols", "url", "Lcom/tencent/kuikly/core/render/android/a;", "context", "", "i", "Lokhttp3/WebSocket;", "j", "message", "l", "code", "reason", "g", "method", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "e", "b", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class y extends i01.e {

    /* renamed from: f, reason: collision with root package name */
    private static final AtomicInteger f263070f = new AtomicInteger();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<Integer, b> taskMap = new ConcurrentHashMap<>();

    private final boolean i(int socketId, ConcurrentHashMap<Integer, b> taskMap, String protocols, String url, com.tencent.kuikly.core.render.android.a context) {
        taskMap.put(Integer.valueOf(socketId), new b(socketId, taskMap, protocols, url, context));
        return true;
    }

    private final WebSocket j(int socketId) {
        b bVar = this.taskMap.get(Integer.valueOf(socketId));
        if (bVar == null) {
            QLog.e("QQKuiklyWebSocketModule", 1, "[checkWebSocketExist] error,not match task,socketId:" + socketId);
            return null;
        }
        WebSocket curWebSocket = bVar.getCurWebSocket();
        if (curWebSocket != null) {
            return curWebSocket;
        }
        QLog.e("QQKuiklyWebSocketModule", 1, "[checkWebSocketExist] error,webSocket is null,socketId:" + socketId);
        return null;
    }

    private final boolean l(int socketId, String message) {
        WebSocket j3 = j(socketId);
        if (j3 == null) {
            return false;
        }
        j3.send(message);
        return true;
    }

    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        try {
            if (QLog.isColorLevel()) {
                QLog.i("QQKuiklyWebSocketModule", 2, "[call] method:" + method + ",params:" + params);
            }
            int hashCode = method.hashCode();
            if (hashCode != 167939979) {
                if (hashCode != 691453791) {
                    if (hashCode == 1530724239 && method.equals("createSocket")) {
                        return c(params);
                    }
                } else if (method.equals("sendMessage")) {
                    return d(params);
                }
            } else if (method.equals("closeSocket")) {
                return a(params);
            }
            return super.call(method, params, callback);
        } catch (Throwable th5) {
            QLog.e("QQKuiklyWebSocketModule", 1, th5, new Object[0]);
            return super.call(method, params, callback);
        }
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.i("QQKuiklyWebSocketModule", 2, "[onDestroy]");
        }
        Iterator<Map.Entry<Integer, b>> it = this.taskMap.entrySet().iterator();
        while (it.hasNext()) {
            try {
                WebSocket curWebSocket = it.next().getValue().getCurWebSocket();
                if (curWebSocket != null) {
                    curWebSocket.close(1001, "close on Module Destroy");
                }
            } catch (Throwable th5) {
                QLog.e("QQKuiklyWebSocketModule", 1, th5, new Object[0]);
            }
        }
        this.taskMap.clear();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\u0011B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u001b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u001f\u0010 J*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\u00062\u0006\u0010\u0003\u001a\u00020\u0002J,\u0010\u000e\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000bJ\u0010\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u001a\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u0013\u0010\u0018\"\u0004\b\u0010\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/y$b;", "", "", "socketId", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "c", "Lcom/tencent/kuikly/core/render/android/a;", "renderContext", "event", "", "data", "", "d", "", "e", "b", "Lokhttp3/OkHttpClient;", "a", "Lokhttp3/OkHttpClient;", "mOkHttpClient", "Lokhttp3/WebSocket;", "Lokhttp3/WebSocket;", "()Lokhttp3/WebSocket;", "(Lokhttp3/WebSocket;)V", "curWebSocket", "Ljava/util/concurrent/ConcurrentHashMap;", "taskMap", "protocols", "url", "<init>", "(ILjava/util/concurrent/ConcurrentHashMap;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/kuikly/core/render/android/a;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private OkHttpClient mOkHttpClient;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private WebSocket curWebSocket;

        /* compiled from: P */
        @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000bH\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/y$b$a", "Lokhttp3/WebSocketListener;", "Lokhttp3/WebSocket;", "webSocket", "Lokhttp3/Response;", "response", "", "onOpen", "", "t", "onFailure", "", "text", "onMessage", "Lokio/ByteString;", "bytes", "", "code", "reason", "onClosed", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a extends WebSocketListener {

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.tencent.kuikly.core.render.android.a f263076c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f263077d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ConcurrentHashMap<Integer, b> f263078e;

            a(com.tencent.kuikly.core.render.android.a aVar, int i3, ConcurrentHashMap<Integer, b> concurrentHashMap) {
                this.f263076c = aVar;
                this.f263077d = i3;
                this.f263078e = concurrentHashMap;
            }

            @Override // okhttp3.WebSocketListener
            public void onClosed(WebSocket webSocket, int code, String reason) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(reason, "reason");
                b bVar = b.this;
                com.tencent.kuikly.core.render.android.a aVar = this.f263076c;
                HashMap<String, Object> c16 = bVar.c(this.f263077d);
                c16.put("code", Integer.valueOf(code));
                c16.put("reason", reason);
                Unit unit = Unit.INSTANCE;
                bVar.d(aVar, "socketOnClose", c16);
                this.f263078e.remove(Integer.valueOf(this.f263077d));
            }

            @Override // okhttp3.WebSocketListener
            public void onFailure(WebSocket webSocket, Throwable t16, Response response) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(t16, "t");
                b bVar = b.this;
                com.tencent.kuikly.core.render.android.a aVar = this.f263076c;
                HashMap<String, Object> c16 = bVar.c(this.f263077d);
                c16.put("code", Integer.valueOf(b.this.b(t16)));
                String message = t16.getMessage();
                if (message == null) {
                    message = "";
                }
                c16.put("reason", message);
                Unit unit = Unit.INSTANCE;
                bVar.d(aVar, "socketOnError", c16);
                this.f263078e.remove(Integer.valueOf(this.f263077d));
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, ByteString bytes) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(bytes, "bytes");
            }

            @Override // okhttp3.WebSocketListener
            public void onOpen(WebSocket webSocket, Response response) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(response, "response");
                b.this.e(webSocket);
                b bVar = b.this;
                bVar.d(this.f263076c, "socketOnOpen", bVar.c(this.f263077d));
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, String text) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(text, "text");
                b bVar = b.this;
                com.tencent.kuikly.core.render.android.a aVar = this.f263076c;
                HashMap<String, Object> c16 = bVar.c(this.f263077d);
                c16.put("message", text);
                Unit unit = Unit.INSTANCE;
                bVar.d(aVar, "socketOnMessage", c16);
            }
        }

        public b(int i3, ConcurrentHashMap<Integer, b> taskMap, String str, String url, com.tencent.kuikly.core.render.android.a aVar) {
            Intrinsics.checkNotNullParameter(taskMap, "taskMap");
            Intrinsics.checkNotNullParameter(url, "url");
            Request.Builder newBuilder = new Request.Builder().url(url).build().newBuilder();
            if (str != null) {
                if (str.length() > 0) {
                    newBuilder.addHeader("Sec-WebSocket-Protocol", str);
                }
            }
            Request build = newBuilder.build();
            OkHttpClient build2 = new OkHttpClient().newBuilder().build();
            this.mOkHttpClient = build2;
            build2.newWebSocket(build, new a(aVar, i3, taskMap));
        }

        /* renamed from: a, reason: from getter */
        public final WebSocket getCurWebSocket() {
            return this.curWebSocket;
        }

        public final HashMap<String, Object> c(int socketId) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("socketId", Integer.valueOf(socketId));
            return hashMap;
        }

        public final void d(com.tencent.kuikly.core.render.android.a renderContext, String event, Map<String, ? extends Object> data) {
            com.tencent.kuikly.core.render.android.d O0;
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                if (QLog.isColorLevel()) {
                    QLog.i("QQKuiklyWebSocketModule", 2, "[sendEvent] event:" + event + ",data:" + data);
                }
                if (renderContext == null || (O0 = renderContext.O0()) == null) {
                    return;
                }
                O0.d(event, data);
            } catch (Throwable th5) {
                QLog.e("QQKuiklyWebSocketModule", 1, th5, new Object[0]);
            }
        }

        public final void e(WebSocket webSocket) {
            this.curWebSocket = webSocket;
        }

        public final int b(Throwable e16) {
            boolean contains$default;
            boolean contains$default2;
            boolean contains$default3;
            boolean contains$default4;
            boolean contains$default5;
            if (e16 != null) {
                if (e16 instanceof SSLPeerUnverifiedException) {
                    return 12;
                }
                if (e16 instanceof UnknownHostException) {
                    return 9;
                }
                if (e16 instanceof SSLHandshakeException) {
                    return 15;
                }
                if (e16 instanceof IllegalStateException) {
                    String stackTraceString = Log.getStackTraceString(e16);
                    Intrinsics.checkNotNullExpressionValue(stackTraceString, "getStackTraceString(e)");
                    contains$default5 = StringsKt__StringsKt.contains$default((CharSequence) stackTraceString, (CharSequence) "Connection is not open", false, 2, (Object) null);
                    return contains$default5 ? 50007 : 5;
                }
                if (e16 instanceof SocketException) {
                    return 6;
                }
                if (e16 instanceof SocketTimeoutException) {
                    return 7;
                }
                if (e16 instanceof FileNotFoundException) {
                    return 1;
                }
                if (e16 instanceof IOException) {
                    String stackTraceString2 = Log.getStackTraceString(e16);
                    Intrinsics.checkNotNullExpressionValue(stackTraceString2, "getStackTraceString(e)");
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) stackTraceString2, (CharSequence) "No space left on device", false, 2, (Object) null);
                    if (contains$default) {
                        return 50003;
                    }
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) stackTraceString2, (CharSequence) "Network is unreachable", false, 2, (Object) null);
                    if (contains$default2) {
                        return 50004;
                    }
                    contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) stackTraceString2, (CharSequence) "No route to host", false, 2, (Object) null);
                    if (contains$default3) {
                        return 50005;
                    }
                    contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) stackTraceString2, (CharSequence) "Connection refused", false, 2, (Object) null);
                    return contains$default4 ? 50006 : 2;
                }
                if (e16 instanceof Exception) {
                    return 4;
                }
                if (e16 instanceof OutOfMemoryError) {
                    return 3;
                }
            }
            return -1;
        }
    }

    private final JSONObject c(String params) {
        JSONObject jSONObject = new JSONObject();
        if (params == null || params.length() == 0) {
            QLog.e("QQKuiklyWebSocketModule", 1, "[doCallCreateSocket] params is empty");
            jSONObject.put("socketId", 0);
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject(params);
        String url = jSONObject2.optString("url");
        if (url == null || url.length() == 0) {
            QLog.e("QQKuiklyWebSocketModule", 1, "[doCallCreateSocket] url is empty");
            jSONObject.put("socketId", 0);
            return jSONObject;
        }
        JSONArray optJSONArray = jSONObject2.optJSONArray("protocols");
        String str = null;
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String optString = optJSONArray.optString(i3);
                Intrinsics.checkNotNullExpressionValue(optString, "optString(i)");
                arrayList.add(optString);
            }
            if (!arrayList.isEmpty()) {
                str = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
            }
        }
        int incrementAndGet = f263070f.incrementAndGet();
        ConcurrentHashMap<Integer, b> concurrentHashMap = this.taskMap;
        Intrinsics.checkNotNullExpressionValue(url, "url");
        i(incrementAndGet, concurrentHashMap, str, url, get_kuiklyRenderContext());
        jSONObject.put("socketId", incrementAndGet);
        return jSONObject;
    }

    private final boolean g(int socketId, int code, String reason) {
        try {
            WebSocket j3 = j(socketId);
            if (j3 == null) {
                return false;
            }
            j3.close(code, reason);
            this.taskMap.remove(Integer.valueOf(socketId));
            return true;
        } catch (Exception e16) {
            QLog.e("QQKuiklyWebSocketModule", 1, "closeSocket error:", e16);
            return false;
        }
    }

    private final Object a(String params) {
        if (params == null || params.length() == 0) {
            QLog.e("QQKuiklyWebSocketModule", 1, "[callCloseSocket] params is empty");
            return null;
        }
        JSONObject jSONObject = new JSONObject(params);
        int optInt = jSONObject.optInt("socketId");
        if (optInt <= 0) {
            QLog.e("QQKuiklyWebSocketModule", 1, "[callCloseSocket] socketId is invalid:" + optInt);
            return null;
        }
        int optInt2 = jSONObject.optInt("code", -1);
        String reason = jSONObject.optString("reason", "");
        Intrinsics.checkNotNullExpressionValue(reason, "reason");
        g(optInt, optInt2, reason);
        return null;
    }

    private final Object d(String params) {
        if (params == null || params.length() == 0) {
            QLog.e("QQKuiklyWebSocketModule", 1, "[callSendMessage] params is empty");
            return null;
        }
        JSONObject jSONObject = new JSONObject(params);
        int optInt = jSONObject.optInt("socketId");
        if (optInt <= 0) {
            QLog.e("QQKuiklyWebSocketModule", 1, "[callSendMessage] socketId is invalid:" + optInt);
            return null;
        }
        String optString = jSONObject.optString("message");
        Intrinsics.checkNotNullExpressionValue(optString, "paramObj.optString(PARAM_KEY_MESSAGE)");
        l(optInt, optString);
        return null;
    }
}

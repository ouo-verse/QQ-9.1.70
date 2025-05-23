package com.tencent.mtt.hippy.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import com.tencent.mtt.hippy.d.b;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import okhttp3.internal.ws.WebSocketProtocol;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static TrustManager[] f337203a;

    /* renamed from: c, reason: collision with root package name */
    private final URI f337205c;

    /* renamed from: d, reason: collision with root package name */
    private final a f337206d;

    /* renamed from: e, reason: collision with root package name */
    private Socket f337207e;

    /* renamed from: f, reason: collision with root package name */
    private Thread f337208f;

    /* renamed from: g, reason: collision with root package name */
    private final HandlerThread f337209g;

    /* renamed from: h, reason: collision with root package name */
    private final Handler f337210h;

    /* renamed from: i, reason: collision with root package name */
    private final List<com.tencent.mtt.hippy.d.a> f337211i;

    /* renamed from: b, reason: collision with root package name */
    private final Object f337204b = new Object();

    /* renamed from: k, reason: collision with root package name */
    private AtomicBoolean f337213k = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    private final b f337212j = new b(this);

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(Exception exc);

        void a(byte[] bArr);

        void b();

        void b(int i3, String str);

        void b(String str);
    }

    public d(URI uri, a aVar, List<com.tencent.mtt.hippy.d.a> list) {
        this.f337205c = uri;
        this.f337206d = aVar;
        this.f337211i = list;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("websocket-thread");
        this.f337209g = baseHandlerThread;
        baseHandlerThread.start();
        this.f337210h = new Handler(baseHandlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.mtt.hippy.d.a c(String str) {
        int indexOf = str.indexOf(":");
        if (indexOf != -1) {
            return new com.tencent.mtt.hippy.d.a(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
        }
        throw new IllegalArgumentException("WebSocketClient Unexpected header: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        byte[] bArr = new byte[16];
        for (int i3 = 0; i3 < 16; i3++) {
            bArr[i3] = (byte) (Math.random() * 256.0d);
        }
        return Base64.encodeToString(bArr, 0).trim();
    }

    public a d() {
        return this.f337206d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(b.a aVar) throws IOException {
        int read = aVar.read();
        if (read == -1) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        while (read != 10) {
            if (read != 13) {
                sb5.append((char) read);
            }
            read = aVar.read();
            if (read == -1) {
                return null;
            }
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c b(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SSLSocketFactory f() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, f337203a, null);
        return sSLContext.getSocketFactory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        try {
            return Base64.encodeToString(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1).digest((str + WebSocketProtocol.ACCEPT_MAGIC).getBytes()), 0).trim();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public void b() {
        if (this.f337207e != null) {
            this.f337210h.post(new Runnable() { // from class: com.tencent.mtt.hippy.d.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.f337207e != null) {
                        try {
                            d.this.f337207e.close();
                        } catch (Throwable th5) {
                            Log.d("WebSocketClient", "Error while disconnecting", th5);
                            d.this.f337206d.a(new Exception(th5));
                        }
                        d.this.f337206d.b(0, AudioContext.State.CLOSED);
                        d.this.f337207e = null;
                    }
                    d.this.f337213k.set(false);
                }
            });
        }
    }

    public boolean c() {
        return this.f337213k.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final byte[] bArr) {
        this.f337210h.post(new Runnable() { // from class: com.tencent.mtt.hippy.d.d.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (d.this.f337204b) {
                        OutputStream outputStream = d.this.f337207e.getOutputStream();
                        outputStream.write(bArr);
                        outputStream.flush();
                    }
                } catch (Throwable th5) {
                    d.this.f337206d.a(new Exception(th5));
                }
            }
        });
    }

    public void a() {
        Thread thread = this.f337208f;
        if (thread == null || !thread.isAlive()) {
            BaseThread baseThread = new BaseThread(new Runnable() { // from class: com.tencent.mtt.hippy.d.d.1

                /* renamed from: a, reason: collision with root package name */
                static final /* synthetic */ boolean f337214a = true;

                /* JADX WARN: Code restructure failed: missing block: B:61:0x0278, code lost:
                
                    r12.f337215b.f337206d.b();
                    r12.f337215b.f337213k.set(true);
                    r12.f337215b.f337212j.a(r0);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:63:0x029d, code lost:
                
                    if (r12.f337215b.f337213k.get() != false) goto L117;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:65:0x02a5, code lost:
                
                    if (r12.f337215b.f337207e == null) goto L149;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:67:0x02a7, code lost:
                
                    r12.f337215b.f337207e.close();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:69:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:70:0x02b2, code lost:
                
                    r0 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:71:0x02b3, code lost:
                
                    android.util.Log.d("WebSocketClient", "Error while disconnecting", r0);
                    r1 = r12.f337215b.f337206d;
                    r2 = new java.lang.Exception(r0);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:74:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:75:0x0416, code lost:
                
                    return;
                 */
                /* JADX WARN: Removed duplicated region for block: B:24:0x01b0 A[Catch: all -> 0x02f0, ConnectException -> 0x0335, SSLException -> 0x0380, EOFException -> 0x03cb, TryCatch #7 {ConnectException -> 0x0335, blocks: (B:3:0x000a, B:6:0x001d, B:7:0x004e, B:10:0x006c, B:12:0x007c, B:13:0x009b, B:16:0x00b0, B:18:0x00e2, B:21:0x00f3, B:22:0x00fe, B:24:0x01b0, B:25:0x01ba, B:27:0x01c0, B:29:0x01e0, B:31:0x0201, B:33:0x0207, B:35:0x0213, B:40:0x021a, B:41:0x021f, B:43:0x0220, B:46:0x0233, B:48:0x023b, B:54:0x024a, B:55:0x026e, B:57:0x026f, B:58:0x0277, B:61:0x0278, B:76:0x02c2, B:77:0x02e6, B:78:0x02e7, B:79:0x02ef, B:80:0x00f8, B:82:0x0062, B:83:0x0028, B:85:0x0038), top: B:2:0x000a, outer: #2 }] */
                /* JADX WARN: Removed duplicated region for block: B:31:0x0201 A[Catch: all -> 0x02f0, ConnectException -> 0x0335, SSLException -> 0x0380, EOFException -> 0x03cb, TryCatch #7 {ConnectException -> 0x0335, blocks: (B:3:0x000a, B:6:0x001d, B:7:0x004e, B:10:0x006c, B:12:0x007c, B:13:0x009b, B:16:0x00b0, B:18:0x00e2, B:21:0x00f3, B:22:0x00fe, B:24:0x01b0, B:25:0x01ba, B:27:0x01c0, B:29:0x01e0, B:31:0x0201, B:33:0x0207, B:35:0x0213, B:40:0x021a, B:41:0x021f, B:43:0x0220, B:46:0x0233, B:48:0x023b, B:54:0x024a, B:55:0x026e, B:57:0x026f, B:58:0x0277, B:61:0x0278, B:76:0x02c2, B:77:0x02e6, B:78:0x02e7, B:79:0x02ef, B:80:0x00f8, B:82:0x0062, B:83:0x0028, B:85:0x0038), top: B:2:0x000a, outer: #2 }] */
                /* JADX WARN: Removed duplicated region for block: B:78:0x02e7 A[Catch: all -> 0x02f0, ConnectException -> 0x0335, SSLException -> 0x0380, EOFException -> 0x03cb, TryCatch #7 {ConnectException -> 0x0335, blocks: (B:3:0x000a, B:6:0x001d, B:7:0x004e, B:10:0x006c, B:12:0x007c, B:13:0x009b, B:16:0x00b0, B:18:0x00e2, B:21:0x00f3, B:22:0x00fe, B:24:0x01b0, B:25:0x01ba, B:27:0x01c0, B:29:0x01e0, B:31:0x0201, B:33:0x0207, B:35:0x0213, B:40:0x021a, B:41:0x021f, B:43:0x0220, B:46:0x0233, B:48:0x023b, B:54:0x024a, B:55:0x026e, B:57:0x026f, B:58:0x0277, B:61:0x0278, B:76:0x02c2, B:77:0x02e6, B:78:0x02e7, B:79:0x02ef, B:80:0x00f8, B:82:0x0062, B:83:0x0028, B:85:0x0038), top: B:2:0x000a, outer: #2 }] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    a aVar;
                    Exception exc;
                    int i3;
                    String path;
                    String str;
                    SocketFactory f16;
                    c b16;
                    try {
                        try {
                            try {
                                try {
                                    if (d.this.f337205c.getPort() != -1) {
                                        i3 = d.this.f337205c.getPort();
                                    } else {
                                        if (!d.this.f337205c.getScheme().equals("wss") && !d.this.f337205c.getScheme().equals("https")) {
                                            i3 = 80;
                                        }
                                        i3 = WebSocketImpl.DEFAULT_WSS_PORT;
                                    }
                                    if (TextUtils.isEmpty(d.this.f337205c.getPath())) {
                                        path = "/";
                                    } else {
                                        path = d.this.f337205c.getPath();
                                    }
                                    if (!TextUtils.isEmpty(d.this.f337205c.getQuery())) {
                                        path = path + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + d.this.f337205c.getQuery();
                                    }
                                    if (d.this.f337205c.getScheme().equals("wss")) {
                                        str = "https";
                                    } else {
                                        str = "http";
                                    }
                                    URI uri = new URI(str, "//" + d.this.f337205c.getHost(), null);
                                    if (!d.this.f337205c.getScheme().equals("wss") && !d.this.f337205c.getScheme().equals("https")) {
                                        f16 = SocketFactory.getDefault();
                                        d dVar = d.this;
                                        dVar.f337207e = f16.createSocket(dVar.f337205c.getHost(), i3);
                                        PrintWriter printWriter = new PrintWriter(d.this.f337207e.getOutputStream());
                                        String e16 = d.this.e();
                                        printWriter.print("GET " + path + " HTTP/1.1\r\n");
                                        printWriter.print("Upgrade: websocket\r\n");
                                        printWriter.print("Connection: Upgrade\r\n");
                                        printWriter.print("Host: " + d.this.f337205c.getHost() + "\r\n");
                                        printWriter.print("Origin: " + uri.toString() + "\r\n");
                                        printWriter.print("Sec-WebSocket-Key: " + e16 + "\r\n");
                                        printWriter.print("Sec-WebSocket-Version: 13\r\n");
                                        if (d.this.f337211i != null) {
                                            for (com.tencent.mtt.hippy.d.a aVar2 : d.this.f337211i) {
                                                printWriter.print(String.format("%s: %s\r\n", aVar2.a(), aVar2.b()));
                                            }
                                        }
                                        printWriter.print("\r\n");
                                        printWriter.flush();
                                        b.a aVar3 = new b.a(d.this.f337207e.getInputStream());
                                        d dVar2 = d.this;
                                        b16 = dVar2.b(dVar2.a(aVar3));
                                        if (b16 == null) {
                                            if (b16.f337201a != 101) {
                                                throw new ConnectException("WebSocketClient connect error: code=" + b16.f337201a + ",message=" + b16.f337202b);
                                            }
                                            while (true) {
                                                String a16 = d.this.a(aVar3);
                                                if (TextUtils.isEmpty(a16)) {
                                                    break;
                                                }
                                                if (!f337214a && a16 == null) {
                                                    throw new AssertionError();
                                                }
                                                com.tencent.mtt.hippy.d.a c16 = d.this.c(a16);
                                                if (c16.a().equals("Sec-WebSocket-Accept")) {
                                                    String d16 = d.this.d(e16);
                                                    if (d16 != null) {
                                                        if (!d16.equals(c16.b().trim())) {
                                                            throw new ConnectException("Invalid Sec-WebSocket-Accept, expected: " + d16 + ", got: " + c16.b());
                                                        }
                                                    } else {
                                                        throw new ConnectException("SHA-1 algorithm not found");
                                                    }
                                                }
                                            }
                                        } else {
                                            throw new ConnectException("WebSocketClient received no reply from server.");
                                        }
                                    }
                                    f16 = d.this.f();
                                    d dVar3 = d.this;
                                    dVar3.f337207e = f16.createSocket(dVar3.f337205c.getHost(), i3);
                                    PrintWriter printWriter2 = new PrintWriter(d.this.f337207e.getOutputStream());
                                    String e162 = d.this.e();
                                    printWriter2.print("GET " + path + " HTTP/1.1\r\n");
                                    printWriter2.print("Upgrade: websocket\r\n");
                                    printWriter2.print("Connection: Upgrade\r\n");
                                    printWriter2.print("Host: " + d.this.f337205c.getHost() + "\r\n");
                                    printWriter2.print("Origin: " + uri.toString() + "\r\n");
                                    printWriter2.print("Sec-WebSocket-Key: " + e162 + "\r\n");
                                    printWriter2.print("Sec-WebSocket-Version: 13\r\n");
                                    if (d.this.f337211i != null) {
                                    }
                                    printWriter2.print("\r\n");
                                    printWriter2.flush();
                                    b.a aVar32 = new b.a(d.this.f337207e.getInputStream());
                                    d dVar22 = d.this;
                                    b16 = dVar22.b(dVar22.a(aVar32));
                                    if (b16 == null) {
                                    }
                                } catch (EOFException e17) {
                                    Log.d("WebSocketClient", "WebSocket EOF!", e17);
                                    d.this.f337206d.b(0, "EOF");
                                    d.this.f337213k.set(false);
                                    if (!d.this.f337213k.get() && d.this.f337207e != null) {
                                        try {
                                            d.this.f337207e.close();
                                        } catch (Throwable th5) {
                                            Log.d("WebSocketClient", "Error while disconnecting", th5);
                                            aVar = d.this.f337206d;
                                            exc = new Exception(th5);
                                            aVar.a(exc);
                                        }
                                    }
                                } catch (Throwable th6) {
                                    d.this.f337206d.a(new Exception(th6));
                                    if (!d.this.f337213k.get() && d.this.f337207e != null) {
                                        try {
                                            d.this.f337207e.close();
                                        } catch (Throwable th7) {
                                            Log.d("WebSocketClient", "Error while disconnecting", th7);
                                            aVar = d.this.f337206d;
                                            exc = new Exception(th7);
                                            aVar.a(exc);
                                        }
                                    }
                                }
                            } catch (SSLException e18) {
                                Log.d("WebSocketClient", "Websocket SSL error!", e18);
                                d.this.f337206d.b(0, "SSL");
                                d.this.f337213k.set(false);
                                if (!d.this.f337213k.get() && d.this.f337207e != null) {
                                    try {
                                        d.this.f337207e.close();
                                    } catch (Throwable th8) {
                                        Log.d("WebSocketClient", "Error while disconnecting", th8);
                                        aVar = d.this.f337206d;
                                        exc = new Exception(th8);
                                        aVar.a(exc);
                                    }
                                }
                            }
                        } catch (ConnectException e19) {
                            Log.d("WebSocketClient", "Websocket Connect error!", e19);
                            d.this.f337206d.b(0, "CONNECT");
                            d.this.f337213k.set(false);
                            if (!d.this.f337213k.get() && d.this.f337207e != null) {
                                try {
                                    d.this.f337207e.close();
                                } catch (Throwable th9) {
                                    Log.d("WebSocketClient", "Error while disconnecting", th9);
                                    aVar = d.this.f337206d;
                                    exc = new Exception(th9);
                                    aVar.a(exc);
                                }
                            }
                        }
                    } catch (Throwable th10) {
                        if (!d.this.f337213k.get() && d.this.f337207e != null) {
                            try {
                                d.this.f337207e.close();
                            } catch (Throwable th11) {
                                Log.d("WebSocketClient", "Error while disconnecting", th11);
                                d.this.f337206d.a(new Exception(th11));
                            }
                        }
                        throw th10;
                    }
                }
            });
            this.f337208f = baseThread;
            baseThread.start();
        }
    }

    public void a(int i3, String str) {
        this.f337212j.a(i3, str);
        b();
    }

    public void a(String str) {
        b(this.f337212j.a(str));
    }

    public void a(byte[] bArr) {
        b(bArr);
    }
}

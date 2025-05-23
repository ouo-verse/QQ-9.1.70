package com.tencent.luggage.wxa.kh;

import com.tencent.luggage.wxa.gl.f;
import com.tencent.luggage.wxa.gl.h;
import com.tencent.luggage.wxa.kh.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.yi.q;
import com.tencent.mars.comm.AndroidCertVerifyResult;
import com.tencent.mars.comm.X509Util;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.websocket.WcWss;
import com.tencent.websocket.WssConfig;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import javax.net.ssl.X509TrustManager;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements e {
    public X509TrustManager D;

    /* renamed from: a, reason: collision with root package name */
    public String f131995a;

    /* renamed from: b, reason: collision with root package name */
    public String f131996b;

    /* renamed from: c, reason: collision with root package name */
    public URI f131997c;

    /* renamed from: d, reason: collision with root package name */
    public Map f131998d;

    /* renamed from: g, reason: collision with root package name */
    public WssConfig f132001g;

    /* renamed from: h, reason: collision with root package name */
    public String f132002h;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f132005k;

    /* renamed from: l, reason: collision with root package name */
    public e.a f132006l;

    /* renamed from: m, reason: collision with root package name */
    public WcWss.a f132007m;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f131999e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f132000f = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public int f132003i = -1;

    /* renamed from: j, reason: collision with root package name */
    public Timer f132004j = null;
    public EnumC6386b C = EnumC6386b.NOT_YET_CONNECTED;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.kh.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public enum EnumC6386b {
        NOT_YET_CONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED
    }

    public b(String str, String str2, URI uri, Map map, WssConfig wssConfig, ArrayList arrayList, com.tencent.luggage.wxa.yi.a aVar) {
        this.f131995a = str;
        this.f131996b = str2;
        this.f131997c = uri;
        this.f131998d = map;
        this.f132001g = wssConfig;
        this.f132005k = arrayList;
        this.D = q.b(aVar);
        Map map2 = this.f131998d;
        if (map2 == null) {
            w.b("MicroMsg.AppBrandWcWssSocket", "header is null");
            return;
        }
        for (Map.Entry entry : map2.entrySet()) {
            this.f131999e.add(entry.getKey());
            this.f132000f.add(entry.getValue());
        }
    }

    @Override // com.tencent.luggage.wxa.kh.e
    public void a(Socket socket) {
    }

    @Override // com.tencent.luggage.wxa.kh.e
    public void b(boolean z16) {
    }

    @Override // com.tencent.luggage.wxa.kh.e
    public Socket c() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.kh.e
    public void close() {
        w.d("MicroMsg.AppBrandWcWssSocket", "close");
        a("default_close", 1000);
    }

    @Override // com.tencent.luggage.wxa.kh.e
    public Timer d() {
        return this.f132004j;
    }

    public final int e() {
        int port = this.f131997c.getPort();
        if (port == -1) {
            String scheme = this.f131997c.getScheme();
            if (scheme.equals("wss")) {
                return WebSocketImpl.DEFAULT_WSS_PORT;
            }
            if (scheme.equals("ws")) {
                return 80;
            }
            w.b("MicroMsg.AppBrandWcWssSocket", "getPort unkonow scheme:%s", scheme);
        }
        return port;
    }

    @Override // com.tencent.luggage.wxa.kh.e
    public boolean isOpen() {
        if (this.C == EnumC6386b.OPEN) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.kh.e
    public void send(String str) {
        w.d("MicroMsg.AppBrandWcWssSocket", "send text");
        if (this.f132003i < 0) {
            this.f132006l.b("error socket id");
            return;
        }
        try {
            ByteBuffer wrap = ByteBuffer.wrap(str.getBytes("UTF8"));
            byte[] bArr = new byte[wrap.remaining()];
            wrap.get(bArr);
            WcWss.sendBuffer(this.f131995a, this.f132003i, bArr, true);
        } catch (UnsupportedEncodingException e16) {
            w.a("MicroMsg.AppBrandWcWssSocket", e16, "unsupport encoding UnsupportedEncodingException", new Object[0]);
            this.f132006l.b("unsupport encoding");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements WcWss.a {
        public a() {
        }

        @Override // com.tencent.websocket.WcWss.a
        public void a(String str, int i3, String[] strArr, String[] strArr2) {
            w.d("MicroMsg.AppBrandWcWssSocket", "onHandShake group:%s, wssId:%s", str, Integer.valueOf(i3));
            b.this.f132006l.a((com.tencent.luggage.wxa.gl.a) b.this.a(1, strArr, strArr2));
        }

        @Override // com.tencent.websocket.WcWss.a
        public void a(String str, int i3, boolean z16, String[] strArr, String[] strArr2, int i16, String str2, String[] strArr3, String[] strArr4) {
            w.d("MicroMsg.AppBrandWcWssSocket", "onOpen group:%s,isSuc:%s, msg:%s, code:%s, wssId:%s", str, Boolean.valueOf(z16), str2, Integer.valueOf(i16), Integer.valueOf(i3));
            if (!z16) {
                b.this.f132006l.b("onOpen fail code:" + i16 + ", msg:" + str2);
                return;
            }
            b.this.C = EnumC6386b.OPEN;
            b.this.f132006l.a((h) b.this.a(2, strArr, strArr2), b.this.a(strArr3, strArr4));
        }

        @Override // com.tencent.websocket.WcWss.a
        public void a(String str, int i3, byte[] bArr, boolean z16) {
            w.a("MicroMsg.AppBrandWcWssSocket", "onMessage group:%s,wssId:%s,isText:%s", str, Integer.valueOf(i3), Boolean.valueOf(z16));
            if (z16) {
                try {
                    b.this.f132006l.a(new String(bArr, "utf-8"));
                    return;
                } catch (UnsupportedEncodingException e16) {
                    w.a("MicroMsg.AppBrandWcWssSocket", e16, "onmessage unsupport encoding UnsupportedEncodingException", new Object[0]);
                    return;
                }
            }
            b.this.f132006l.a(ByteBuffer.wrap(bArr));
        }

        @Override // com.tencent.websocket.WcWss.a
        public void a(String str, int i3, int i16, String str2) {
            w.d("MicroMsg.AppBrandWcWssSocket", "onClose group:%s,id:%s, reason:%s, code:%s", str, Integer.valueOf(i3), str2, Integer.valueOf(i16));
            b.this.C = EnumC6386b.CLOSED;
            b.this.f132006l.a(i16, str2);
        }

        @Override // com.tencent.websocket.WcWss.a
        public int a(String str, byte[][] bArr) {
            w.d("MicroMsg.AppBrandWcWssSocket", "certifivate verify for " + str);
            try {
                AndroidCertVerifyResult verifyServerCertificates = X509Util.verifyServerCertificates(bArr, "RSA", str, 1, b.this.D);
                w.d("MicroMsg.AppBrandWcWssSocket", "host %s rsa verify result %d, isknownroots %b, ishostmatched %b", str, Integer.valueOf(verifyServerCertificates.getStatus()), Boolean.valueOf(verifyServerCertificates.isIssuedByKnownRoot()), Boolean.valueOf(verifyServerCertificates.isIssuedByHostMatched()));
                if (verifyServerCertificates.getStatus() != 0) {
                    verifyServerCertificates = X509Util.verifyServerCertificates(bArr, "ECDSA", str, 1, b.this.D);
                    w.d("MicroMsg.AppBrandWcWssSocket", "host %s ecdsa verify result %d, isknownroots %b, ishostmatched %b", str, Integer.valueOf(verifyServerCertificates.getStatus()), Boolean.valueOf(verifyServerCertificates.isIssuedByKnownRoot()), Boolean.valueOf(verifyServerCertificates.isIssuedByHostMatched()));
                }
                if (verifyServerCertificates.getStatus() != 0) {
                    ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(972L, 7L, 1L, false);
                }
                if (verifyServerCertificates.getStatus() == 0 && !verifyServerCertificates.isIssuedByHostMatched()) {
                    ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(972L, 8L, 1L, false);
                }
                if (verifyServerCertificates.getStatus() == 0 && !verifyServerCertificates.isIssuedByKnownRoot()) {
                    ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(972L, 9L, 1L, false);
                }
                if (verifyServerCertificates.getStatus() == 0) {
                    return verifyServerCertificates.isIssuedByKnownRoot() ? 0 : -1;
                }
                return -1;
            } catch (Exception e16) {
                w.a("MicroMsg.AppBrandWcWssSocket", e16, "doCertificateVerify Exception", new Object[0]);
                return -1;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.kh.e
    public String b() {
        return this.f132002h;
    }

    @Override // com.tencent.luggage.wxa.kh.e
    public void a(e.a aVar) {
        w.d("MicroMsg.AppBrandWcWssSocket", "setCallBack");
        this.f132006l = aVar;
        this.f132007m = new a();
    }

    @Override // com.tencent.luggage.wxa.kh.e
    public void a(String str) {
        this.f132002h = str;
    }

    @Override // com.tencent.luggage.wxa.kh.e
    public void a(Timer timer) {
        this.f132004j = timer;
    }

    @Override // com.tencent.luggage.wxa.kh.e
    public void a(String str, int i3) {
        w.d("MicroMsg.AppBrandWcWssSocket", "close reason:%s,code:%s", str, Integer.valueOf(i3));
        int i16 = this.f132003i;
        if (i16 < 0) {
            this.f132006l.b("error socket id");
            return;
        }
        EnumC6386b enumC6386b = this.C;
        EnumC6386b enumC6386b2 = EnumC6386b.CLOSING;
        if (enumC6386b != enumC6386b2 && enumC6386b != EnumC6386b.CLOSED) {
            this.C = enumC6386b2;
        }
        WcWss.closeSocket(this.f131995a, i16, i3, str);
    }

    @Override // com.tencent.luggage.wxa.kh.e
    public void a(ByteBuffer byteBuffer) {
        w.d("MicroMsg.AppBrandWcWssSocket", "send bytes");
        if (this.f132003i < 0) {
            this.f132006l.b("error socket id");
            return;
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        WcWss.sendBuffer(this.f131995a, this.f132003i, bArr, false);
    }

    @Override // com.tencent.luggage.wxa.kh.e
    public void a() {
        w.d("MicroMsg.AppBrandWcWssSocket", UploadQualityReportBuilder.STATE_CONNECT);
        if (this.f131998d == null) {
            this.f132006l.b("header is null");
            return;
        }
        int b16 = WcWss.b(this.f132007m, this.f131995a, this.f131996b, this.f131999e.toArray(), this.f132000f.toArray(), null, this.f132001g, this.f132005k.toArray());
        this.f132003i = b16;
        if (b16 < 0) {
            this.f132006l.b("call connect fail code:" + this.f132003i);
        }
        w.d("MicroMsg.AppBrandWcWssSocket", "connect mWcWssId:%s", Integer.valueOf(this.f132003i));
    }

    public final Map a(String[] strArr, String[] strArr2) {
        HashMap hashMap = new HashMap();
        if (strArr != null && strArr2 != null) {
            if (strArr.length == strArr2.length) {
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    hashMap.put(strArr[i3], strArr2[i3]);
                }
            } else {
                w.h("MicroMsg.AppBrandWcWssSocket", "buildProfileMap profileKey != profileValue profileKey.length:%d,profileValue.length:%d", Integer.valueOf(strArr.length), Integer.valueOf(strArr2.length));
            }
        } else {
            w.f("MicroMsg.AppBrandWcWssSocket", "buildProfileMap profileKey args is null");
        }
        return hashMap;
    }

    public final f a(int i3, String[] strArr, String[] strArr2) {
        if (i3 != 1) {
            if (i3 != 2) {
                w.h("MicroMsg.AppBrandWcWssSocket", "buildHandshake unknow type:%s", Integer.valueOf(i3));
                return null;
            }
            com.tencent.luggage.wxa.gl.e eVar = new com.tencent.luggage.wxa.gl.e();
            if (strArr == null || strArr2 == null) {
                w.h("MicroMsg.AppBrandWcWssSocket", "buildHandshake header args is null type:%s", Integer.valueOf(i3));
            } else if (strArr.length == strArr2.length) {
                for (int i16 = 0; i16 < strArr.length; i16++) {
                    eVar.a(strArr[i16], strArr2[i16]);
                }
            } else {
                w.h("MicroMsg.AppBrandWcWssSocket", "buildHandshake headerKey != headerValue type:%s", Integer.valueOf(i3));
            }
            return eVar;
        }
        String path = this.f131997c.getPath();
        String query = this.f131997c.getQuery();
        if (path == null || path.length() == 0) {
            path = "/";
        }
        if (query != null) {
            path = path + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + query;
        }
        int e16 = e();
        String host = (e16 != -1 && e16 != 80) ? this.f131997c.getHost() + ":" + e16 : this.f131997c.getHost();
        com.tencent.luggage.wxa.gl.d dVar = new com.tencent.luggage.wxa.gl.d();
        dVar.b(path);
        dVar.a("Host", host);
        if (strArr != null && strArr2 != null) {
            if (strArr.length == strArr2.length) {
                for (int i17 = 0; i17 < strArr.length; i17++) {
                    dVar.a(strArr[i17], strArr2[i17]);
                }
                w.d("MicroMsg.AppBrandWcWssSocket", "buildHandshake headerKey.length:%s, type:%s", Integer.valueOf(strArr.length), Integer.valueOf(i3));
            } else {
                w.h("MicroMsg.AppBrandWcWssSocket", "buildHandshake headerKey != headerValue type:%s", Integer.valueOf(i3));
            }
        } else {
            w.d("MicroMsg.AppBrandWcWssSocket", "buildHandshake header args is null type:%s", Integer.valueOf(i3));
            Map map = this.f131998d;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    dVar.a((String) entry.getKey(), (String) entry.getValue());
                }
            } else {
                w.h("MicroMsg.AppBrandWcWssSocket", "buildHandshake mHeaders is null type:%s", Integer.valueOf(i3));
            }
        }
        return dVar;
    }
}

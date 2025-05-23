package com.tencent.luggage.wxa.nd;

import android.net.http.AndroidHttpClient;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ld.e;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l {

    /* renamed from: d, reason: collision with root package name */
    public static l f135704d;

    /* renamed from: a, reason: collision with root package name */
    public MulticastSocket f135705a;

    /* renamed from: b, reason: collision with root package name */
    public InetAddress f135706b;

    /* renamed from: c, reason: collision with root package name */
    public int f135707c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a extends HttpPost {

        /* renamed from: a, reason: collision with root package name */
        public e.a f135708a;

        public a(String str, e.a aVar) {
            super(str);
            this.f135708a = aVar;
        }

        @Override // org.apache.http.client.methods.HttpPost, org.apache.http.client.methods.HttpRequestBase, org.apache.http.client.methods.HttpUriRequest
        public String getMethod() {
            return this.f135708a.name();
        }
    }

    public l(boolean z16) {
        this.f135707c = -1;
        try {
            this.f135706b = InetAddress.getByName("239.255.255.250");
            if (z16) {
                MulticastSocket multicastSocket = new MulticastSocket();
                this.f135705a = multicastSocket;
                multicastSocket.setBroadcast(true);
                this.f135707c = this.f135705a.getLocalPort();
            }
        } catch (IOException e16) {
            com.tencent.luggage.wxa.kd.a.a("TransporterImpl", e16, "");
        }
    }

    public static l a() {
        if (f135704d == null) {
            synchronized (com.tencent.luggage.wxa.nd.a.class) {
                if (f135704d == null) {
                    f135704d = new l(true);
                }
            }
        }
        return f135704d;
    }

    public static l c() {
        return new l(false);
    }

    public final void b(com.tencent.luggage.wxa.ld.d dVar) {
        byte[] bytes = dVar.a().getBytes();
        this.f135705a.send(new DatagramPacket(bytes, bytes.length, this.f135706b, 1900));
    }

    public void finalize() {
        if (this == f135704d) {
            this.f135705a.close();
        }
        super.finalize();
    }

    public final void c(com.tencent.luggage.wxa.ld.d dVar) {
        if (this.f135705a == null) {
            MulticastSocket multicastSocket = new MulticastSocket();
            this.f135705a = multicastSocket;
            multicastSocket.setBroadcast(true);
            this.f135707c = this.f135705a.getLocalPort();
        }
        byte[] bytes = dVar.a().getBytes();
        this.f135705a.send(new DatagramPacket(bytes, bytes.length, this.f135706b, 1900));
        this.f135705a.close();
    }

    public int b() {
        return this.f135707c;
    }

    public com.tencent.luggage.wxa.pd.e a(com.tencent.luggage.wxa.ld.e eVar) {
        AndroidHttpClient androidHttpClient = null;
        try {
            androidHttpClient = AndroidHttpClient.newInstance("");
            a aVar = new a(eVar.e(), eVar.d());
            Map c16 = eVar.c();
            if (c16 != null && !c16.isEmpty()) {
                for (Map.Entry entry : c16.entrySet()) {
                    aVar.addHeader((String) entry.getKey(), (String) entry.getValue());
                }
            }
            String a16 = eVar.a();
            if (!TextUtils.isEmpty(a16)) {
                StringEntity stringEntity = new StringEntity(a16, "utf-8");
                stringEntity.setContentType("text/xml; charset=\"utf-8\"");
                aVar.setEntity(stringEntity);
            }
            HttpResponse execute = androidHttpClient.execute(aVar);
            androidHttpClient.close();
            com.tencent.luggage.wxa.pd.e eVar2 = new com.tencent.luggage.wxa.pd.e(false);
            eVar2.f137498a = new com.tencent.luggage.wxa.pd.b();
            for (Header header : execute.getAllHeaders()) {
                eVar2.f137498a.a(header.getName(), header.getValue());
            }
            eVar2.f137499b = m.a().a(EntityUtils.toString(execute.getEntity(), "utf-8").replaceAll("&(?!amp;)", "&amp;"));
            eVar2.f137497c = execute.getStatusLine().getStatusCode();
            return eVar2;
        } catch (IOException e16) {
            if (androidHttpClient != null) {
                androidHttpClient.close();
            }
            com.tencent.luggage.wxa.kd.a.a("TransporterImpl", e16.toString());
            throw e16;
        }
    }

    public void a(com.tencent.luggage.wxa.ld.d dVar) {
        if (this == f135704d) {
            b(dVar);
        } else {
            c(dVar);
        }
    }
}

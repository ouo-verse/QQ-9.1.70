package com.tencent.luggage.wxa.nd;

import android.util.Log;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g {

    /* renamed from: i, reason: collision with root package name */
    public static final String f135666i = "g";

    /* renamed from: a, reason: collision with root package name */
    public h f135667a;

    /* renamed from: b, reason: collision with root package name */
    public k f135668b;

    /* renamed from: c, reason: collision with root package name */
    public List f135669c;

    /* renamed from: d, reason: collision with root package name */
    public InetSocketAddress f135670d;

    /* renamed from: e, reason: collision with root package name */
    public MulticastSocket f135671e;

    /* renamed from: f, reason: collision with root package name */
    public MulticastSocket f135672f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f135673g = false;

    /* renamed from: h, reason: collision with root package name */
    public int f135674h;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                g.this.d();
            } catch (Exception e16) {
                if (e16.getCause() != null) {
                    com.tencent.luggage.wxa.kd.a.a(g.f135666i, e16.getCause().toString());
                }
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                g.this.e();
            } catch (Exception e16) {
                if (e16.getCause() != null) {
                    com.tencent.luggage.wxa.kd.a.a(g.f135666i, e16.getCause().toString());
                }
                e16.printStackTrace();
            }
        }
    }

    public g(h hVar, List list, k kVar, int i3) {
        this.f135667a = hVar;
        this.f135674h = i3;
        a(list, kVar);
    }

    public h c() {
        return this.f135667a;
    }

    public final void d() {
        com.tencent.luggage.wxa.kd.a.b(f135666i, "Entering blocking notify receiving loop, listening for UDP datagrams on port: " + this.f135672f.getLocalPort());
        m a16 = m.a();
        while (this.f135673g) {
            try {
                int c16 = c().c();
                DatagramPacket datagramPacket = new DatagramPacket(new byte[c16], c16);
                this.f135672f.receive(datagramPacket);
                String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength(), "utf-8");
                String str2 = f135666i;
                com.tencent.luggage.wxa.kd.a.b(str2, str);
                com.tencent.luggage.wxa.pd.b b16 = a16.b(str);
                if (b16 != null) {
                    this.f135668b.a(b16);
                } else {
                    com.tencent.luggage.wxa.kd.a.b(str2, "receive a not care notify message");
                }
            } catch (IOException e16) {
                com.tencent.luggage.wxa.kd.a.a(f135666i, "notify fail: " + Log.getStackTraceString(e16));
                this.f135673g = false;
                throw e16;
            }
        }
        com.tencent.luggage.wxa.kd.a.a(f135666i, "loop end");
    }

    public final void e() {
        com.tencent.luggage.wxa.kd.a.b(f135666i, "Entering blocking search receiving loop, listening for UDP datagrams on port: " + this.f135671e.getLocalPort());
        m a16 = m.a();
        while (this.f135673g) {
            try {
                int c16 = c().c();
                DatagramPacket datagramPacket = new DatagramPacket(new byte[c16], c16);
                this.f135671e.receive(datagramPacket);
                String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength(), "utf-8");
                String str2 = f135666i;
                com.tencent.luggage.wxa.kd.a.b(str2, "loopSearch: content = " + str);
                com.tencent.luggage.wxa.pd.b b16 = a16.b(str);
                if (b16 != null) {
                    this.f135668b.a(b16);
                } else {
                    com.tencent.luggage.wxa.kd.a.a(str2, "discard this message");
                }
            } catch (IOException e16) {
                com.tencent.luggage.wxa.kd.a.a(f135666i, "search fail: " + Log.getStackTraceString(e16));
                this.f135673g = false;
                throw e16;
            }
        }
        com.tencent.luggage.wxa.kd.a.a(f135666i, "loop end");
    }

    public synchronized void f() {
        if (this.f135673g) {
            return;
        }
        this.f135673g = true;
        new BaseThread(new c()).start();
        new BaseThread(new b()).start();
    }

    public synchronized void b() {
        this.f135673g = false;
        MulticastSocket multicastSocket = this.f135671e;
        if (multicastSocket != null && !multicastSocket.isClosed()) {
            this.f135671e.close();
        }
        MulticastSocket multicastSocket2 = this.f135672f;
        if (multicastSocket2 != null && !multicastSocket2.isClosed()) {
            try {
                com.tencent.luggage.wxa.kd.a.b(f135666i, "Leaving multicast group");
                Iterator it = this.f135669c.iterator();
                while (it.hasNext()) {
                    this.f135672f.leaveGroup(this.f135670d, (NetworkInterface) it.next());
                }
            } catch (Exception e16) {
                com.tencent.luggage.wxa.kd.a.b(f135666i, "Could not leave multicast group: " + e16);
            }
            this.f135672f.close();
        }
    }

    public void a(List list, k kVar) {
        this.f135668b = kVar;
        this.f135669c = list;
        try {
            MulticastSocket multicastSocket = new MulticastSocket(this.f135674h);
            this.f135671e = multicastSocket;
            multicastSocket.setReuseAddress(true);
            this.f135671e.setReceiveBufferSize(32768);
            com.tencent.luggage.wxa.kd.a.b(f135666i, "Creating wildcard socketNotify (for receiving multicast datagrams) on port: " + this.f135667a.b());
            this.f135670d = new InetSocketAddress(this.f135667a.a(), this.f135667a.b());
            MulticastSocket multicastSocket2 = new MulticastSocket(this.f135667a.b());
            this.f135672f = multicastSocket2;
            multicastSocket2.setReuseAddress(true);
            this.f135672f.setReceiveBufferSize(32768);
            for (NetworkInterface networkInterface : this.f135669c) {
                com.tencent.luggage.wxa.kd.a.b(f135666i, "Joining multicast group: " + this.f135670d + " on network interface: " + networkInterface.getDisplayName());
                this.f135672f.joinGroup(this.f135670d, networkInterface);
            }
        } catch (Exception e16) {
            throw new Exception("Could not initialize " + f135666i + MsgSummary.STR_COLON + e16);
        }
    }
}

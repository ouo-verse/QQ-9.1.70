package com.tencent.mobileqq.msf.core.net.u.c;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d implements Runnable {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: f, reason: collision with root package name */
    private static final String f249447f = "UdpCall";

    /* renamed from: g, reason: collision with root package name */
    public static final String f249448g = "FailedReason";

    /* renamed from: h, reason: collision with root package name */
    public static final String f249449h = "Endpoint";

    /* renamed from: a, reason: collision with root package name */
    private final f f249450a;

    /* renamed from: b, reason: collision with root package name */
    public final g f249451b;

    /* renamed from: c, reason: collision with root package name */
    private e f249452c;

    /* renamed from: d, reason: collision with root package name */
    private i f249453d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.msf.core.d f249454e;

    public d(f fVar, g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar, (Object) gVar);
        } else {
            this.f249450a = fVar;
            this.f249451b = gVar;
        }
    }

    public void a(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
        } else {
            this.f249452c = eVar;
            this.f249450a.f249458a.a(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0188  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Exception e16;
        h hVar;
        byte[] b16;
        DatagramPacket datagramPacket;
        byte[] data;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        TreeMap treeMap = new TreeMap();
        com.tencent.mobileqq.msf.core.d dVar = this.f249454e;
        Exception exc = null;
        boolean z16 = false;
        if (dVar == null) {
            QLog.e(f249447f, 1, "[AsyncCall] error: endpointKey is null.");
            e16 = new Exception("EndpointKey is null.");
        } else if (this.f249453d == null) {
            QLog.e(f249447f, 1, "[AsyncCall] error: cannot acquire socket. Endpoint info: ", dVar);
            e16 = new Exception("UdpSocket is null.");
        } else {
            DatagramPacket a16 = this.f249451b.a();
            if (a16 != null && a16.getLength() != 0) {
                try {
                    QLog.d(f249447f, 1, "[AsyncCall] send udp message. host: ", this.f249454e.b(), "packet length: ", Integer.valueOf(a16.getLength()), ", socket hash: ", Integer.valueOf(this.f249453d.hashCode()));
                    this.f249453d.send(a16);
                    QLog.d(f249447f, 1, "[AsyncCall] send udp message success. socket hash: ", Integer.valueOf(this.f249453d.hashCode()));
                    b16 = a.d().b();
                    datagramPacket = new DatagramPacket(b16, b16.length);
                } catch (SocketException e17) {
                    e16 = e17;
                    QLog.e(f249447f, 1, "[AsyncCall] SocketException: ", e16);
                } catch (UnknownHostException e18) {
                    e16 = e18;
                    QLog.e(f249447f, 1, "[AsyncCall] UnknownHostException: ", e16);
                    treeMap.put(f249449h, this.f249454e.n());
                } catch (IOException e19) {
                    e = e19;
                    QLog.e(f249447f, 1, "[AsyncCall] IOException: ", e);
                } catch (Exception e26) {
                    e16 = e26;
                    QLog.e(f249447f, 1, "[AsyncCall] uncaught exception: ", e16);
                }
                try {
                    this.f249453d.receive(datagramPacket);
                    data = datagramPacket.getData();
                } catch (PortUnreachableException e27) {
                    e16 = e27;
                    QLog.e(f249447f, 1, "[AsyncCall] PortUnreachableException: ", e16);
                } catch (SocketTimeoutException e28) {
                    e16 = e28;
                    QLog.e(f249447f, 1, "[AsyncCall] receive timeout", e16);
                } catch (IOException e29) {
                    e = e29;
                    QLog.e(f249447f, 1, "[AsyncCall] IOException: ", e);
                    hVar = null;
                    exc = e;
                    if (z16) {
                    }
                    this.f249450a.f249458a.b(this);
                }
                if (data != null && data.length != 0) {
                    if (datagramPacket.getLength() > b16.length) {
                        QLog.d(f249447f, 1, "[AsyncCall] buffer size not enough. data size: ", Integer.valueOf(datagramPacket.getLength()), ", buffer size: ", Integer.valueOf(b16.length));
                        e16 = new Exception("Message truncated");
                        a.d().c();
                    } else {
                        QLog.d(f249447f, 1, "[AsyncCall] response data, size:", Integer.valueOf(data.length));
                        hVar = new h(datagramPacket);
                        z16 = true;
                        if (z16) {
                            this.f249452c.a(this, hVar);
                        } else {
                            this.f249452c.a(this, exc);
                            treeMap.put(f249448g, exc.getMessage());
                            a(treeMap);
                        }
                        this.f249450a.f249458a.b(this);
                    }
                } else {
                    QLog.d(f249447f, 1, "[AsyncCall] receive 0.");
                    e16 = new Exception("Receive empty message.");
                }
            } else {
                QLog.e(f249447f, 1, "[AsyncCall] packet is null.");
                e16 = new Exception("Packet is null.");
            }
        }
        exc = e16;
        hVar = null;
        if (z16) {
        }
        this.f249450a.f249458a.b(this);
    }

    public com.tencent.mobileqq.msf.core.d a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f249454e : (com.tencent.mobileqq.msf.core.d) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    public void a(com.tencent.mobileqq.msf.core.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f249454e = dVar;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
        }
    }

    public void a(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f249453d = iVar;
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iVar);
        }
    }

    private void a(Map<String, String> map) {
        MsfCore.sCore.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.v3, true, 0L, 0L, map, false, false);
    }
}

package com.tencent.mobileqq.msf.core.net.r;

import android.content.Context;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d implements e {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    public static final String f249000b = "NormalSocketAdaptor";

    /* renamed from: c, reason: collision with root package name */
    private static OutputStream f249001c = null;

    /* renamed from: d, reason: collision with root package name */
    private static ConcurrentHashMap<Integer, Long> f249002d = null;

    /* renamed from: e, reason: collision with root package name */
    private static ConcurrentHashMap<Integer, Long> f249003e = null;

    /* renamed from: f, reason: collision with root package name */
    private static ConcurrentLinkedQueue<String> f249004f = null;

    /* renamed from: g, reason: collision with root package name */
    private static long f249005g = 0;

    /* renamed from: h, reason: collision with root package name */
    private static long f249006h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static final long f249007i = 600000;

    /* renamed from: j, reason: collision with root package name */
    private static int f249008j;

    /* renamed from: a, reason: collision with root package name */
    private Socket f249009a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23504);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f249002d = new ConcurrentHashMap<>();
        f249003e = new ConcurrentHashMap<>();
        f249004f = new ConcurrentLinkedQueue<>();
        f249005g = 0L;
        f249006h = 0L;
        f249008j = 0;
    }

    public d(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f249009a = null;
        QLog.d(f249000b, 1, "init normal socket adaptor");
        f249008j = 0;
    }

    @Override // com.tencent.mobileqq.msf.core.net.r.e
    public boolean a(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
    }

    @Override // com.tencent.mobileqq.msf.core.net.r.e
    public void b(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (f249002d.containsKey(Integer.valueOf(i3)) && NetConnInfoCenter.isMobileConn()) {
                f249002d.put(Integer.valueOf(i3), Long.valueOf(currentTimeMillis - f249002d.get(Integer.valueOf(i3)).longValue()));
                if (f249002d.size() > 300) {
                    a.n();
                }
            }
            if (!z16 && f249003e.containsKey(Integer.valueOf(i3)) && NetConnInfoCenter.isMobileConn()) {
                f249003e.put(Integer.valueOf(i3), Long.valueOf(currentTimeMillis - f249003e.get(Integer.valueOf(i3)).longValue()));
            }
        } catch (Exception e16) {
            QLog.d(f249000b, 1, "failed to recv in normal way ", e16);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.r.e
    public void a(byte[] bArr, Socket socket, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, bArr, socket, Integer.valueOf(i3));
            return;
        }
        QLog.d(f249000b, 1, "start to send in normal channel");
        try {
            if (this.f249009a != socket) {
                this.f249009a = socket;
                f249001c = socket.getOutputStream();
            }
            f249001c.write(bArr);
            f249001c.flush();
            f249002d.put(Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
            f249003e.put(Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
        } catch (IOException e16) {
            int i16 = f249008j + 1;
            f249008j = i16;
            if (i16 > com.tencent.mobileqq.msf.core.x.b.b()) {
                a.q();
            }
            QLog.d(f249000b, 1, "failed to send in normal way " + e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.r.e
    public void a(Socket socket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            f249005g = System.currentTimeMillis();
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) socket);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.r.e
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            f249006h = currentTimeMillis;
            long j3 = currentTimeMillis - f249005g;
            if (j3 > 600000) {
                f249004f.add("begin_" + f249005g + ":end_" + f249006h + ":last_" + j3 + ":net_" + NetConnInfoCenter.isWifiOrMobileConn());
            }
        } catch (Exception e16) {
            QLog.d(f249000b, 1, "failed to disconnect in normal way", e16);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.r.e
    public String a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        int i16 = 0;
        long j3 = 0;
        try {
            if (i3 == 513) {
                StringBuilder sb5 = new StringBuilder();
                long j16 = 0;
                for (Map.Entry<Integer, Long> entry : f249002d.entrySet()) {
                    if (entry.getValue().longValue() <= 600000 && entry.getValue().longValue() >= 0) {
                        sb5.append("seq_");
                        sb5.append(entry.getKey());
                        sb5.append(Marker.ANY_NON_NULL_MARKER);
                        sb5.append("consume_");
                        sb5.append(entry.getValue());
                        sb5.append("|");
                        j16 += entry.getValue().longValue();
                        i16++;
                    }
                }
                if (i16 > 0) {
                    sb5.append("count_");
                    sb5.append(i16);
                    sb5.append(Marker.ANY_NON_NULL_MARKER);
                    sb5.append("sumcount_");
                    sb5.append(j16);
                    sb5.append("+average_");
                    sb5.append(j16 / i16);
                }
                f249002d.clear();
                QLog.d(f249000b, 1, "report consume: " + sb5.toString());
                return sb5.toString();
            }
            if (i3 == 515) {
                StringBuilder sb6 = new StringBuilder();
                Iterator<String> it = f249004f.iterator();
                while (it.hasNext()) {
                    sb6.append(it.next());
                    sb6.append("#");
                }
                f249004f.clear();
                QLog.d(f249000b, 2, "report heartbeat: " + sb6.toString());
                return sb6.toString();
            }
            if (i3 != 516) {
                return null;
            }
            StringBuilder sb7 = new StringBuilder();
            long j17 = 0;
            for (Map.Entry<Integer, Long> entry2 : f249003e.entrySet()) {
                if (entry2.getValue().longValue() <= 45000 && entry2.getValue().longValue() >= j3) {
                    sb7.append("seq_");
                    sb7.append(entry2.getKey());
                    sb7.append(Marker.ANY_NON_NULL_MARKER);
                    sb7.append("consume_");
                    sb7.append(entry2.getValue());
                    sb7.append("|");
                    j17 += entry2.getValue().longValue();
                    i16++;
                }
                j3 = 0;
            }
            if (i16 > 0) {
                sb7.append("count_");
                sb7.append(i16);
                sb7.append(Marker.ANY_NON_NULL_MARKER);
                sb7.append("sumcount_");
                sb7.append(j17);
                sb7.append("+average_");
                sb7.append(j17 / i16);
            }
            f249003e.clear();
            QLog.d(f249000b, 1, "report consume exclude timeout: " + sb7.toString());
            return sb7.toString();
        } catch (Exception e16) {
            QLog.d(f249000b, 1, "failed to get config ", e16);
            return null;
        }
    }
}

package com.tencent.mobileqq.msf.core.net.r;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.bastet.HwBastet;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c implements e {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f248975a = "HwSocketAdaptor";

    /* renamed from: b, reason: collision with root package name */
    private static boolean f248976b = false;

    /* renamed from: c, reason: collision with root package name */
    public static Context f248977c = null;

    /* renamed from: d, reason: collision with root package name */
    private static HwBastet f248978d = null;

    /* renamed from: e, reason: collision with root package name */
    private static ConcurrentHashMap<Integer, Long> f248979e = null;

    /* renamed from: f, reason: collision with root package name */
    private static ConcurrentHashMap<Integer, Long> f248980f = null;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f248981g = false;

    /* renamed from: h, reason: collision with root package name */
    private static int f248982h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static int f248983i = 0;

    /* renamed from: j, reason: collision with root package name */
    private static int f248984j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static int f248985k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static long f248986l = 0;

    /* renamed from: m, reason: collision with root package name */
    private static long f248987m = 0;

    /* renamed from: n, reason: collision with root package name */
    private static ConcurrentLinkedQueue<String> f248988n = null;

    /* renamed from: o, reason: collision with root package name */
    private static final long f248989o = 600000;

    /* renamed from: p, reason: collision with root package name */
    private static final long f248990p = 240000;

    /* renamed from: q, reason: collision with root package name */
    private static int f248991q = 0;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f248992r = false;

    /* renamed from: s, reason: collision with root package name */
    private static boolean f248993s = false;

    /* renamed from: t, reason: collision with root package name */
    private static a f248994t = null;

    /* renamed from: u, reason: collision with root package name */
    public static Handler f248995u = null;

    /* renamed from: v, reason: collision with root package name */
    private static final int f248996v = 153;

    /* renamed from: w, reason: collision with root package name */
    private static final int f248997w = 154;

    /* renamed from: x, reason: collision with root package name */
    private static boolean f248998x;

    /* renamed from: y, reason: collision with root package name */
    private static int f248999y;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    static class a extends BaseHandlerThread implements Handler.Callback {
        static IPatchRedirector $redirector_;

        public a(String str) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            int i3 = message.what;
            try {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 5) {
                                if (i3 == 7) {
                                    boolean unused = c.f248998x = true;
                                    QLog.d(c.f248975a, 1, "bastet Heartbeat:  " + ((String) message.obj));
                                } else if (i3 != 153) {
                                    if (i3 == 154) {
                                        if (c.f248993s) {
                                            QLog.d(c.f248975a, 1, "reset mode in cycle, resume mode " + c.f248999y);
                                            boolean unused2 = c.f248993s = false;
                                            int unused3 = c.f248999y = c.f248999y + 1;
                                            com.tencent.mobileqq.msf.core.net.r.a.s();
                                        }
                                        if (c.f248999y <= com.tencent.mobileqq.msf.core.x.b.A0()) {
                                            c.f248995u.sendEmptyMessageDelayed(154, com.tencent.mobileqq.msf.core.x.b.M());
                                        }
                                    }
                                } else if (c.f248998x) {
                                    boolean unused4 = c.f248998x = false;
                                    c.f248995u.sendEmptyMessageDelayed(153, 2700000L);
                                } else {
                                    QLog.d(c.f248975a, 1, "Heartbeat Log has not been reported, pause heartbeat");
                                    com.tencent.mobileqq.msf.core.net.r.a.a("exception");
                                    c.f248991q++;
                                }
                            } else {
                                QLog.d(c.f248975a, 1, "basetet heartbeat is not available");
                                com.tencent.mobileqq.msf.core.net.r.a.a("exception");
                                c.f248995u.removeMessages(153);
                            }
                        } else {
                            QLog.d(c.f248975a, 1, "bastet detect net quality event, level:" + Integer.valueOf(message.arg1).intValue());
                        }
                    } else {
                        QLog.d(c.f248975a, 1, "bastet detect connection closed");
                    }
                } else {
                    QLog.d(c.f248975a, 1, "bastet detect connection established");
                }
            } catch (Exception e16) {
                QLog.d(c.f248975a, 1, "bastet handler process event " + i3 + "failed " + e16.toString(), e16);
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27423);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f248979e = new ConcurrentHashMap<>();
        f248980f = new ConcurrentHashMap<>();
        f248981g = false;
        f248982h = 0;
        f248983i = 0;
        f248984j = 0;
        f248985k = 0;
        f248986l = 0L;
        f248987m = 0L;
        f248988n = new ConcurrentLinkedQueue<>();
        f248991q = 0;
        f248992r = true;
        f248993s = false;
        f248994t = null;
        f248998x = false;
        f248999y = 0;
    }

    public c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        QLog.d(f248975a, 1, "init HwSocketAdaptor");
        f248977c = context;
        f();
        a aVar = new a("netHandlerThread");
        f248994t = aVar;
        aVar.start();
        Handler handler = new Handler(f248994t.getLooper(), f248994t);
        f248995u = handler;
        f248976b = false;
        handler.sendEmptyMessageDelayed(154, com.tencent.mobileqq.msf.core.x.b.M());
        f248999y = 0;
    }

    private static void f() {
        f248991q = 0;
        f248982h = 0;
        f248981g = false;
        f248983i = 0;
        f248986l = 0L;
        f248992r = true;
        f248998x = false;
        f248993s = false;
    }

    @Override // com.tencent.mobileqq.msf.core.net.r.e
    public void a(byte[] bArr, Socket socket, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, bArr, socket, Integer.valueOf(i3));
            return;
        }
        try {
            if (!f248976b) {
                f248978d = new HwBastet("", socket, f248995u, f248977c);
                f248976b = true;
            }
            f248978d.sendHrtData(bArr, socket);
            f248979e.put(Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
            f248980f.put(Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.d(f248975a, 1, "failed to send in huawei channel " + th5.toString());
            int i16 = f248983i + 1;
            f248983i = i16;
            f248976b = false;
            if (i16 > com.tencent.mobileqq.msf.core.x.b.b()) {
                com.tencent.mobileqq.msf.core.net.r.a.q();
                f248983i = 0;
                f248984j++;
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.r.e
    public void b(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (f248979e.containsKey(Integer.valueOf(i3)) && NetConnInfoCenter.isMobileConn()) {
            f248979e.put(Integer.valueOf(i3), Long.valueOf(currentTimeMillis - f248979e.get(Integer.valueOf(i3)).longValue()));
            if (f248979e.size() > 300) {
                com.tencent.mobileqq.msf.core.net.r.a.n();
            }
        }
        if (!z16 && f248980f.contains(Integer.valueOf(i3)) && NetConnInfoCenter.isMobileConn()) {
            f248980f.put(Integer.valueOf(i3), Long.valueOf(currentTimeMillis - f248980f.get(Integer.valueOf(i3)).longValue()));
        }
        if (z16) {
            if (f248978d.inquireNetworkQuality() == 0 || !NetConnInfoCenter.isWifiOrMobileConn()) {
                return;
            }
            if (!f248981g) {
                f248981g = true;
                f248982h = 0;
            }
            int i16 = f248982h + 1;
            f248982h = i16;
            if (i16 > com.tencent.mobileqq.msf.core.x.b.w1()) {
                f248993s = true;
                com.tencent.mobileqq.msf.core.net.r.a.q();
                f248982h = 0;
                return;
            }
            return;
        }
        if (f248981g) {
            f248981g = false;
            f248982h = 0;
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.r.e
    public void a(Socket socket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) socket);
            return;
        }
        try {
            if (!f248976b) {
                f248978d = new HwBastet("", socket, f248995u, f248977c);
                f248976b = true;
            }
            if (f248978d.inquireNetworkQuality() == 1) {
                QLog.d(f248975a, 1, "bastet detect network quality low");
            } else if (f248978d.inquireNetworkQuality() == 0) {
                QLog.d(f248975a, 1, "bastet detect network quality none");
            }
            com.tencent.mobileqq.msf.core.net.r.a.h();
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.d(f248975a, 1, "failed to construct HwBastet instance " + th5.toString());
            int i3 = f248983i + 1;
            f248983i = i3;
            f248976b = false;
            if (i3 > com.tencent.mobileqq.msf.core.x.b.b()) {
                com.tencent.mobileqq.msf.core.net.r.a.q();
                f248983i = 0;
                f248984j++;
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.r.e
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        f248976b = false;
        try {
            com.tencent.mobileqq.msf.core.net.r.a.i();
            if (b.f248972e) {
                QLog.d(f248975a, 1, "connection closed, proxy pause");
                b.f248972e = false;
                a(153, true);
                long j3 = f248987m - f248986l;
                QLog.d(f248975a, 1, "connection last:" + j3);
                if (600000 > j3 && f248990p < j3 && NetConnInfoCenter.isWifiOrMobileConn()) {
                    QLog.d(f248975a, 1, "heartbeatUnexpectCount:" + f248991q);
                    int i3 = f248991q + 1;
                    f248991q = i3;
                    if (i3 >= com.tencent.mobileqq.msf.core.x.b.a()) {
                        QLog.d(f248975a, 1, "close heartbeat proxy switch");
                        a(156, false);
                        f248991q = 0;
                    }
                } else if (j3 > 600000) {
                    f248988n.add("begin_" + f248986l + ":end_" + f248987m + ":last_" + (f248987m - f248986l) + ":quality_" + f248978d.inquireNetworkQuality() + ":net_" + NetConnInfoCenter.isWifiOrMobileConn() + ":");
                }
            }
            f248995u.removeMessages(153);
        } catch (Throwable th5) {
            QLog.d(f248975a, 1, "failed to disconnect " + th5.toString(), th5);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.r.e
    public String a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        try {
            if (i3 != 156) {
                int i16 = 0;
                long j3 = 0;
                switch (i3) {
                    case 513:
                        StringBuilder sb5 = new StringBuilder();
                        long j16 = 0;
                        for (Map.Entry<Integer, Long> entry : f248979e.entrySet()) {
                            if (entry.getValue().longValue() <= 60000 && entry.getValue().longValue() >= 0) {
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
                        f248979e.clear();
                        QLog.d(f248975a, 1, "report consume: " + sb5.toString());
                        return sb5.toString();
                    case 514:
                        if (f248984j == 0 && f248985k == 0) {
                            return null;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(f248975a, 2, "report hrt except: " + f248984j + ", hb except" + f248985k);
                        }
                        return "send_except:" + f248984j + Marker.ANY_NON_NULL_MARKER + "hb_except:" + f248985k;
                    case 515:
                        StringBuilder sb6 = new StringBuilder();
                        Iterator<String> it = f248988n.iterator();
                        while (it.hasNext()) {
                            sb6.append(it.next());
                            sb6.append("#");
                        }
                        f248988n.clear();
                        QLog.d(f248975a, 2, "report heartbeat: " + sb6.toString());
                        return sb6.toString();
                    case 516:
                        if (f248980f == null) {
                            QLog.d(f248975a, 1, "exclude timeout packet is null");
                            return null;
                        }
                        StringBuilder sb7 = new StringBuilder();
                        long j17 = 0;
                        for (Map.Entry<Integer, Long> entry2 : f248980f.entrySet()) {
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
                        f248980f.clear();
                        QLog.d(f248975a, 1, "report consume exclude timeout: " + sb7.toString());
                        return sb7.toString();
                    default:
                        return null;
                }
            }
            return String.valueOf(f248992r);
        } catch (Throwable th5) {
            QLog.d(f248975a, 1, "get config " + i3 + " failed " + th5.toString(), th5);
            return null;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0034. Please report as an issue. */
    @Override // com.tencent.mobileqq.msf.core.net.r.e
    public boolean a(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
        }
        try {
            if (i3 != 156) {
                switch (i3) {
                    case 151:
                        try {
                            if (!f248978d.isBastetAvailable()) {
                                QLog.d(f248975a, 1, "bastet is not available ");
                                return false;
                            }
                            if (b.f248969b != null && b.f248970c != null) {
                                f248978d.setAolHeartbeat(1, b.f248969b, b.f248970c);
                                f248986l = System.currentTimeMillis();
                                f248998x = false;
                                f248995u.sendEmptyMessageDelayed(153, 2700000L);
                                return true;
                            }
                            QLog.d(f248975a, 1, "request or response null");
                            return false;
                        } catch (Exception e16) {
                            f248985k++;
                            QLog.d(f248975a, 1, "failed to init heartbeat content " + e16.toString(), e16);
                            break;
                        }
                        break;
                    case 152:
                        try {
                            if (!f248978d.isBastetAvailable()) {
                                QLog.d(f248975a, 1, "bastet is not available for resume");
                                return false;
                            }
                            f248978d.resumeHeartbeat();
                            return true;
                        } catch (Exception e17) {
                            f248985k++;
                            QLog.d(f248975a, 1, "failed to resume heartbeat", e17);
                            break;
                        }
                    case 153:
                        try {
                            f248995u.removeMessages(153);
                            f248978d.pauseHeartbeat();
                            f248987m = System.currentTimeMillis();
                            return true;
                        } catch (Exception e18) {
                            f248985k++;
                            QLog.d(f248975a, 1, "failed to pause heartbeat", e18);
                            break;
                        }
                    default:
                        QLog.d(f248975a, 1, "unknown config " + i3);
                        break;
                }
            } else {
                f248992r = z16;
            }
        } catch (Throwable th5) {
            QLog.d(f248975a, 1, "set config " + i3 + " failed " + th5.toString(), th5);
        }
        return false;
    }
}

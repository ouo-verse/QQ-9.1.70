package com.tencent.mobileqq.msf.core.net.t;

import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.t.c;
import com.tencent.mobileqq.msf.core.net.t.d;
import com.tencent.mobileqq.msf.core.x.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    static final String f249393a = "MSF.C.QualityTestManager";

    /* renamed from: b, reason: collision with root package name */
    public static com.tencent.msf.service.protocol.push.h.d f249394b = null;

    /* renamed from: c, reason: collision with root package name */
    public static com.tencent.msf.service.protocol.push.h.b f249395c = null;

    /* renamed from: d, reason: collision with root package name */
    public static MsfCore f249396d = null;

    /* renamed from: e, reason: collision with root package name */
    public static String f249397e = "";

    /* renamed from: f, reason: collision with root package name */
    public static ArrayList<String> f249398f;

    /* renamed from: g, reason: collision with root package name */
    public static ArrayList<String> f249399g;

    /* renamed from: h, reason: collision with root package name */
    static int f249400h;

    /* renamed from: i, reason: collision with root package name */
    static int f249401i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29117);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f249398f = new ArrayList<>();
        f249399g = new ArrayList<>();
        f249400h = 1;
        f249401i = 0;
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a() {
        f249394b = null;
        f249395c = null;
    }

    private static String b(ArrayList<Long> arrayList) {
        String str = "";
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Long> it = arrayList.iterator();
            while (it.hasNext()) {
                Long next = it.next();
                if (next != null) {
                    str = str + next + ";";
                } else {
                    str = str + "-1;";
                }
            }
        }
        return str;
    }

    /* JADX WARN: Not initialized variable reg: 16, insn: 0x0580: MOVE (r1 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY]), block:B:208:0x0580 */
    public static void a(FromServiceMsg fromServiceMsg) {
        String str;
        String str2 = "QualityTest";
        try {
            try {
                if (fromServiceMsg.isSuccess()) {
                    if (f249394b == null) {
                        UniPacket uniPacket = new UniPacket(true);
                        uniPacket.decode(fromServiceMsg.getWupBuffer());
                        String funcName = uniPacket.getFuncName();
                        try {
                            if (funcName.equals("QualityTest")) {
                                f249394b = (com.tencent.msf.service.protocol.push.h.d) uniPacket.getByClass("QualityTest", new com.tencent.msf.service.protocol.push.h.d());
                                QLog.d(f249393a, 1, "Quality getted, start now " + ((int) f249394b.f336591a));
                                if (f249394b.f336616z == 1) {
                                    if (NetConnInfoCenter.isWifiConn() && NetConnInfoCenter.getWifiStrength() >= 10) {
                                        com.tencent.msf.service.protocol.push.h.d dVar = f249394b;
                                        if ((dVar.f336603m & 255) == 1) {
                                            f249397e = "WiFi";
                                            short s16 = dVar.f336591a;
                                            if (s16 == 5) {
                                                new BaseThread(new d(f249394b, f249395c, d.EnumC8091d.f249289e, f249400h, f249401i)).start();
                                                return;
                                            }
                                            if (s16 == 6) {
                                                new BaseThread(new d(f249394b, f249395c, d.EnumC8091d.f249288d, f249400h, f249401i)).start();
                                                return;
                                            }
                                            for (int i3 = 0; i3 < 2; i3++) {
                                                short s17 = f249394b.f336591a;
                                                if (s17 == 1) {
                                                    new BaseThread(new d(f249394b, f249395c, d.EnumC8091d.f249285a, 2, i3)).start();
                                                } else if (s17 == 2) {
                                                    new BaseThread(new d(f249394b, f249395c, d.EnumC8091d.f249286b, 2, i3)).start();
                                                } else if (s17 == 3) {
                                                    new BaseThread(new d(f249394b, f249395c, d.EnumC8091d.f249287c, 2, i3)).start();
                                                } else if (s17 == 8 && m.i()) {
                                                    new BaseThread(new d(f249394b, f249395c, d.EnumC8091d.f249290f, 2, i3)).start();
                                                } else {
                                                    a();
                                                    return;
                                                }
                                            }
                                            return;
                                        }
                                        f249397e = "WiFi";
                                        short s18 = dVar.f336591a;
                                        if (s18 == 1) {
                                            new BaseThread(new d(f249394b, f249395c, d.EnumC8091d.f249285a, f249400h, f249401i)).start();
                                            return;
                                        }
                                        if (s18 == 2) {
                                            new BaseThread(new d(f249394b, f249395c, d.EnumC8091d.f249286b, f249400h, f249401i)).start();
                                            return;
                                        }
                                        if (s18 == 3) {
                                            new BaseThread(new d(f249394b, f249395c, d.EnumC8091d.f249287c, f249400h, f249401i)).start();
                                            return;
                                        }
                                        if (s18 == 5) {
                                            new BaseThread(new d(f249394b, f249395c, d.EnumC8091d.f249289e, f249400h, f249401i)).start();
                                            return;
                                        }
                                        if (s18 == 6) {
                                            new BaseThread(new d(f249394b, f249395c, d.EnumC8091d.f249288d, f249400h, f249401i)).start();
                                            return;
                                        } else if (s18 == 8 && m.i()) {
                                            new BaseThread(new d(f249394b, f249395c, d.EnumC8091d.f249290f, f249400h, f249401i)).start();
                                            return;
                                        } else {
                                            a();
                                            return;
                                        }
                                    }
                                    f249397e = "NotWiFi";
                                    short s19 = f249394b.f336591a;
                                    if (s19 == 1) {
                                        new BaseThread(new d(f249394b, f249395c, d.EnumC8091d.f249285a, f249400h, f249401i)).start();
                                        return;
                                    }
                                    if (s19 == 2) {
                                        new BaseThread(new d(f249394b, f249395c, d.EnumC8091d.f249286b, f249400h, f249401i)).start();
                                        return;
                                    }
                                    if (s19 == 3) {
                                        new BaseThread(new d(f249394b, f249395c, d.EnumC8091d.f249287c, f249400h, f249401i)).start();
                                        return;
                                    }
                                    if (s19 == 5) {
                                        new BaseThread(new d(f249394b, f249395c, d.EnumC8091d.f249289e, f249400h, f249401i)).start();
                                        return;
                                    }
                                    if (s19 == 6) {
                                        new BaseThread(new d(f249394b, f249395c, d.EnumC8091d.f249288d, f249400h, f249401i)).start();
                                        return;
                                    } else if (s19 == 8 && m.i()) {
                                        new BaseThread(new d(f249394b, f249395c, d.EnumC8091d.f249290f, f249400h, f249401i)).start();
                                        return;
                                    } else {
                                        a();
                                        return;
                                    }
                                }
                                if (NetConnInfoCenter.isWifiConn() && NetConnInfoCenter.getWifiStrength() >= 10) {
                                    com.tencent.msf.service.protocol.push.h.d dVar2 = f249394b;
                                    if ((dVar2.f336603m & 255) == 1) {
                                        f249397e = "WiFi";
                                        short s26 = dVar2.f336591a;
                                        if (s26 == 5) {
                                            new BaseThread(new c(f249394b, f249395c, c.d.f249179e, f249400h, f249401i)).start();
                                            return;
                                        }
                                        if (s26 == 6) {
                                            new BaseThread(new c(f249394b, f249395c, c.d.f249178d, f249400h, f249401i)).start();
                                            return;
                                        }
                                        for (int i16 = 0; i16 < 2; i16++) {
                                            short s27 = f249394b.f336591a;
                                            if (s27 == 1) {
                                                new BaseThread(new c(f249394b, f249395c, c.d.f249175a, 2, i16)).start();
                                            } else if (s27 == 2) {
                                                new BaseThread(new c(f249394b, f249395c, c.d.f249176b, 2, i16)).start();
                                            } else if (s27 == 3) {
                                                new BaseThread(new c(f249394b, f249395c, c.d.f249177c, 2, i16)).start();
                                            } else if (s27 == 8 && m.i()) {
                                                new BaseThread(new c(f249394b, f249395c, c.d.f249180f, 2, i16)).start();
                                            } else {
                                                a();
                                                return;
                                            }
                                        }
                                        return;
                                    }
                                    f249397e = "WiFi";
                                    short s28 = dVar2.f336591a;
                                    if (s28 == 1) {
                                        new BaseThread(new c(f249394b, f249395c, c.d.f249175a, f249400h, f249401i)).start();
                                        return;
                                    }
                                    if (s28 == 2) {
                                        new BaseThread(new c(f249394b, f249395c, c.d.f249176b, f249400h, f249401i)).start();
                                        return;
                                    }
                                    if (s28 == 3) {
                                        new BaseThread(new c(f249394b, f249395c, c.d.f249177c, f249400h, f249401i)).start();
                                        return;
                                    }
                                    if (s28 == 5) {
                                        new BaseThread(new c(f249394b, f249395c, c.d.f249179e, f249400h, f249401i)).start();
                                        return;
                                    }
                                    if (s28 == 6) {
                                        new BaseThread(new c(f249394b, f249395c, c.d.f249178d, f249400h, f249401i)).start();
                                        return;
                                    } else if (s28 == 8 && m.i()) {
                                        new BaseThread(new c(f249394b, f249395c, c.d.f249180f, f249400h, f249401i)).start();
                                        return;
                                    } else {
                                        a();
                                        return;
                                    }
                                }
                                f249397e = "NotWiFi";
                                short s29 = f249394b.f336591a;
                                if (s29 == 1) {
                                    new BaseThread(new c(f249394b, f249395c, c.d.f249175a, f249400h, f249401i)).start();
                                    return;
                                }
                                if (s29 == 2) {
                                    new BaseThread(new c(f249394b, f249395c, c.d.f249176b, f249400h, f249401i)).start();
                                    return;
                                }
                                if (s29 == 3) {
                                    new BaseThread(new c(f249394b, f249395c, c.d.f249177c, f249400h, f249401i)).start();
                                    return;
                                }
                                if (s29 == 5) {
                                    new BaseThread(new c(f249394b, f249395c, c.d.f249179e, f249400h, f249401i)).start();
                                    return;
                                }
                                if (s29 == 6) {
                                    new BaseThread(new c(f249394b, f249395c, c.d.f249178d, f249400h, f249401i)).start();
                                    return;
                                } else if (s29 == 8 && m.i()) {
                                    new BaseThread(new c(f249394b, f249395c, c.d.f249180f, f249400h, f249401i)).start();
                                    return;
                                } else {
                                    a();
                                    return;
                                }
                            }
                            if (!funcName.equals("MtuTest")) {
                                return;
                            }
                            f249395c = (com.tencent.msf.service.protocol.push.h.b) uniPacket.getByClass("MtuTest", new com.tencent.msf.service.protocol.push.h.b());
                            str2 = f249393a;
                            QLog.d(str2, 1, "MtuTest getted, start now");
                            short s36 = f249395c.f336580a;
                            if (s36 == 1) {
                                new BaseThread(new c(f249394b, f249395c, c.d.f249175a, f249400h, f249401i)).start();
                            } else if (s36 == 2) {
                                new BaseThread(new c(f249394b, f249395c, c.d.f249176b, f249400h, f249401i)).start();
                            } else if (s36 == 3) {
                                new BaseThread(new c(f249394b, f249395c, c.d.f249177c, f249400h, f249401i)).start();
                            } else if (f249394b.f336591a == 8 && m.i()) {
                                new BaseThread(new c(f249394b, f249395c, c.d.f249180f, f249400h, f249401i)).start();
                            } else {
                                a();
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            str2 = str;
                            QLog.d(str2, 1, "QualityManager error, ", th);
                        }
                    } else {
                        str2 = f249393a;
                        QLog.d(str2, 1, "QualityManager getted too frequently drop now");
                    }
                } else {
                    str2 = f249393a;
                    QLog.d(str2, 1, "QualityManager getted, return fail do nothing");
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
            str2 = f249393a;
        }
    }

    public static void a(boolean z16, com.tencent.msf.service.protocol.push.h.d dVar, com.tencent.msf.service.protocol.push.h.b bVar, int i3, int i16, int i17) {
        if (f249396d.getStatReporter() != null) {
            HashMap hashMap = new HashMap();
            if (dVar != null) {
                hashMap.put("TestType", "QualityTest");
                hashMap.put("ProtoType", "" + ((int) dVar.f336591a));
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                ArrayList<com.tencent.msf.service.protocol.push.h.a> arrayList = dVar.f336592b;
                sb5.append(arrayList != null ? arrayList.size() : -1);
                hashMap.put("IpNum", sb5.toString());
                hashMap.put("PkgNum", "" + dVar.f336593c);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("");
                byte[] bArr = dVar.f336595e;
                sb6.append(bArr != null ? bArr.length : -1);
                hashMap.put("PkgDataSize", sb6.toString());
                hashMap.put("RepeatTimes", "" + dVar.f336596f);
                StringBuilder sb7 = new StringBuilder();
                sb7.append("");
                byte[] bArr2 = dVar.f336597g;
                sb7.append(bArr2 != null ? bArr2.length : -1);
                hashMap.put("HeadDataSize", sb7.toString());
                hashMap.put("testPacketRecved", "" + i3);
                hashMap.put("testPacketSend", "" + i16);
                hashMap.put("network_type", String.valueOf(i17));
            } else if (bVar != null) {
                hashMap.put("TestType", "MtuTest");
                hashMap.put("ProtoType", "" + ((int) bVar.f336580a));
                StringBuilder sb8 = new StringBuilder();
                sb8.append("");
                ArrayList<com.tencent.msf.service.protocol.push.h.a> arrayList2 = bVar.f336581b;
                sb8.append(arrayList2 != null ? arrayList2.size() : -1);
                hashMap.put("IpNum", sb8.toString());
                hashMap.put("PkgNum", "" + bVar.f336586g);
                hashMap.put("PkgDataSize", a(bVar.f336582c));
                hashMap.put("RepeatTimes", b(bVar.f336583d));
                hashMap.put("HeadDataSize", a(bVar.f336584e));
                hashMap.put("testPacketRecved", "" + i3);
                hashMap.put("testPacketSend", "" + i16);
                hashMap.put("network_type", String.valueOf(i17));
            }
            long j3 = i3 + i16;
            f249396d.getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.Y, z16, 0L, j3, (Map<String, String>) hashMap, false, false);
            f249396d.getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.Z, z16, 0L, j3, (Map<String, String>) hashMap, false, false);
        }
    }

    private static String a(ArrayList<byte[]> arrayList) {
        String str = "";
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<byte[]> it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] next = it.next();
                if (next != null) {
                    str = str + next.length + ";";
                } else {
                    str = str + "-1;";
                }
            }
        }
        return str;
    }
}

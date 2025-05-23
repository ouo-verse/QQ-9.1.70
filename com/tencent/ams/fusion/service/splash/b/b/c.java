package com.tencent.ams.fusion.service.splash.b.b;

import com.tencent.ams.fusion.a.i;
import com.tencent.ams.fusion.a.j;
import com.tencent.ams.fusion.service.splash.b.b.a.b;
import com.tencent.ams.fusion.service.splash.model.SplashOrder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.httpcore.HttpStatus;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c implements kt.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private nt.f f70370a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.ams.fusion.service.splash.data.a f70371b;

    /* renamed from: c, reason: collision with root package name */
    private int f70372c;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private long a(File[] fileArr) {
        if (j.d(fileArr)) {
            return -1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int q16 = com.tencent.ams.fusion.service.splash.a.a.d().q();
        long m3 = com.tencent.ams.fusion.a.b.m(com.tencent.ams.fusion.a.b.a());
        for (File file : fileArr) {
            if (file != null && file.exists()) {
                long lastModified = file.lastModified();
                if (lastModified > 0 && currentTimeMillis - lastModified > q16) {
                    try {
                        if (com.tencent.ams.fusion.a.b.t(file)) {
                            m3 -= file.length();
                        }
                    } catch (Throwable th5) {
                        com.tencent.ams.fusion.a.f.c("PreloadResCleanTask", "execute, catch error:", th5);
                    }
                    com.tencent.ams.fusion.a.f.b("PreloadResCleanTask", "execute, file expired, fileName: " + file.getName());
                }
                if (m3 <= this.f70372c) {
                    break;
                }
            }
        }
        return m3;
    }

    private void d(int i3, long j3, long j16) {
        nt.d.b(this.f70370a, i3, j3, System.currentTimeMillis() - j16, Integer.MIN_VALUE);
    }

    private void f(List<String> list, SplashOrder splashOrder) {
        File r16;
        if (list != null && splashOrder != null) {
            List<String> e16 = com.tencent.ams.fusion.a.b.e(i.f(splashOrder));
            if (!j.b(e16)) {
                list.addAll(e16);
            }
            List<com.tencent.ams.fusion.service.splash.b.a.a> aP = splashOrder.aP();
            if (!j.b(aP)) {
                for (com.tencent.ams.fusion.service.splash.b.a.a aVar : aP) {
                    if (aVar != null && (r16 = com.tencent.ams.fusion.a.b.r(3, aVar.a())) != null) {
                        com.tencent.ams.fusion.a.f.i("getAllResFileNameInOrder :" + r16.getAbsolutePath());
                        list.add(r16.getName());
                    }
                }
            }
        }
    }

    private File[] h() {
        File[] k3 = k();
        if (j.d(k3)) {
            return null;
        }
        List<String> j3 = j();
        ArrayList arrayList = new ArrayList();
        for (File file : k3) {
            if (file != null) {
                arrayList.add(file.getName());
            }
        }
        if (j.b(arrayList)) {
            return null;
        }
        if (!j.b(j3)) {
            arrayList.removeAll(j3);
        }
        int size = arrayList.size();
        File[] fileArr = new File[size];
        int i3 = 0;
        for (File file2 : k3) {
            if (i3 < size && file2 != null && arrayList.contains(file2.getName())) {
                fileArr[i3] = file2;
                i3++;
            }
        }
        return fileArr;
    }

    private void i(File[] fileArr) {
        if (j.d(fileArr)) {
            return;
        }
        long m3 = com.tencent.ams.fusion.a.b.m(com.tencent.ams.fusion.a.b.n());
        com.tencent.ams.fusion.a.f.b("PreloadResCleanTask", "deleteResourceFileOverSizeByModifyTime, cachedSize: " + m3 + " CleanupThresholdSize:" + this.f70372c);
        if (m3 > this.f70372c) {
            for (File file : fileArr) {
                if (file != null && file.exists()) {
                    try {
                        long length = file.length();
                        if (com.tencent.ams.fusion.a.b.t(file)) {
                            m3 -= length;
                            com.tencent.ams.fusion.a.f.g("cachedSize :" + m3);
                        }
                    } catch (Throwable th5) {
                        com.tencent.ams.fusion.a.f.c("PreloadResCleanTask", "execute, catch error:", th5);
                    }
                    if (m3 <= this.f70372c) {
                        return;
                    }
                }
            }
        }
    }

    private List<String> j() {
        com.tencent.ams.fusion.service.splash.data.a aVar;
        rt.a value;
        ArrayList arrayList = null;
        if (this.f70370a != null && (aVar = this.f70371b) != null) {
            Object a16 = aVar.a(b(false));
            if (!(a16 instanceof rt.c)) {
                return null;
            }
            Map<String, rt.a> a17 = ((rt.c) a16).a();
            if (!j.c(a17) && a17.entrySet() != null) {
                arrayList = new ArrayList();
                for (Map.Entry<String, rt.a> entry : a17.entrySet()) {
                    if (entry != null && (value = entry.getValue()) != null) {
                        f(arrayList, value.b());
                        f(arrayList, value.c());
                        List<SplashOrder> d16 = value.d();
                        if (!j.b(d16)) {
                            Iterator<SplashOrder> it = d16.iterator();
                            while (it.hasNext()) {
                                f(arrayList, it.next());
                            }
                        }
                        List<SplashOrder> e16 = value.e();
                        if (!j.b(e16)) {
                            Iterator<SplashOrder> it5 = e16.iterator();
                            while (it5.hasNext()) {
                                f(arrayList, it5.next());
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private File[] k() {
        File[] s16 = com.tencent.ams.fusion.a.b.s(com.tencent.ams.fusion.a.b.n());
        if (j.d(s16)) {
            return null;
        }
        for (File file : s16) {
            if (file != null) {
                com.tencent.ams.fusion.a.f.a("getAllResourceFile :" + file.getAbsolutePath() + ", last time :" + file.lastModified());
            }
        }
        return s16;
    }

    private boolean l() {
        long m3 = com.tencent.ams.fusion.a.b.m(com.tencent.ams.fusion.a.b.n());
        com.tencent.ams.fusion.a.f.b("PreloadResCleanTask", "isCachedFileOverSize, cachedSize: " + m3 + ", maxSize: " + this.f70372c);
        if (m3 > this.f70372c) {
            return true;
        }
        return false;
    }

    @Override // kt.b
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? "PreloadResCleanTask" : (String) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // kt.c
    public kt.e c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (kt.e) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        d(428, 0L, currentTimeMillis);
        this.f70372c = com.tencent.ams.fusion.service.splash.a.a.d().r();
        boolean l3 = l();
        if (l3) {
            File[] h16 = h();
            if (a(h16) > this.f70372c) {
                i(h16);
            }
        }
        d(HttpStatus.SC_TOO_MANY_REQUESTS, l3 ? 1L : 0L, currentTimeMillis);
        return c(currentTimeMillis);
    }

    public void e(com.tencent.ams.fusion.service.splash.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.f70371b = aVar;
        }
    }

    public void g(nt.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fVar);
        } else {
            this.f70370a = fVar;
        }
    }

    private String b(boolean z16) {
        StringBuilder sb5;
        String str;
        nt.f fVar = this.f70370a;
        if (fVar == null) {
            return "";
        }
        String b16 = fVar.b();
        if (this.f70370a.a()) {
            sb5 = new StringBuilder();
            sb5.append(b16);
            str = z16 ? "key_preload_request_hot" : "key_preload_parse_data_hot";
        } else {
            sb5 = new StringBuilder();
            sb5.append(b16);
            str = z16 ? "key_preload_request_cold" : "key_preload_parse_data_cold";
        }
        sb5.append(str);
        return sb5.toString();
    }

    private kt.e c(long j3) {
        b.e eVar = new b.e();
        eVar.a(System.currentTimeMillis() - j3);
        return eVar;
    }
}

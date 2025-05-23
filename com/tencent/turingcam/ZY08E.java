package com.tencent.turingcam;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ZY08E {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final String f382119d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f382120e;

    /* renamed from: f, reason: collision with root package name */
    public static final ZY08E f382121f;

    /* renamed from: a, reason: collision with root package name */
    public volatile SkEpO f382122a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f382123b;

    /* renamed from: c, reason: collision with root package name */
    public final ReentrantReadWriteLock f382124c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20324);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f382119d = LwgsO.a(LwgsO.f381886b1);
        f382120e = TimeUnit.HOURS.toMillis(32L);
        f382121f = new ZY08E();
    }

    public ZY08E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382122a = null;
        this.f382123b = new AtomicBoolean(false);
        this.f382124c = new ReentrantReadWriteLock();
    }

    public void a(SkEpO skEpO, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, skEpO, Boolean.valueOf(z16));
            return;
        }
        this.f382124c.writeLock().lock();
        if (z16) {
            try {
                Xjpd8 xjpd8 = new Xjpd8(128);
                skEpO.a(xjpd8);
                if (F2BEC.a(b("2"), VBlVU.b(Bp8QH.a(xjpd8.a()), VBlVU.a()), true)) {
                    File file = new File(b("1"));
                    if (file.exists()) {
                        file.delete();
                    }
                }
            } finally {
                this.f382122a = skEpO;
                this.f382124c.writeLock().unlock();
            }
        }
    }

    public final String b(String str) {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        synchronized (eh5ma.class) {
            context = eh5ma.f382207a;
        }
        File dir = context.getDir("turingfd", 0);
        if (dir == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(dir.getAbsolutePath());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("12");
        File file = new File(sb5.toString());
        if (!file.exists() && !file.mkdirs()) {
            return "";
        }
        return file.getAbsolutePath() + str2 + WT9z5.f382088a + "_mfa_" + str;
    }

    public Set<String> c() {
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Set) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (!d()) {
            a16 = LwgsO.a(LwgsO.f381907i1);
        } else {
            a16 = a("p_l_h_l");
        }
        if (TextUtils.isEmpty(a16)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, a16.split(","));
        return hashSet;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (b() != null) {
            return true;
        }
        return false;
    }

    public final SkEpO b(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SkEpO) iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16));
        }
        try {
            byte[] a16 = F2BEC.a(str, true);
            if (a16 == null) {
                return null;
            }
            if (z16 && ((a16 = Bp8QH.b(VBlVU.a(a16, VBlVU.a()))) == null || a16.length == 0)) {
                return null;
            }
            SkEpO skEpO = new SkEpO();
            skEpO.a(new YunKQ(a16));
            return skEpO;
        } catch (Throwable unused) {
            return null;
        }
    }

    public SkEpO b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SkEpO) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        this.f382124c.readLock().lock();
        try {
            if (this.f382123b.get()) {
                return this.f382122a;
            }
            synchronized (this.f382123b) {
                if (this.f382123b.get()) {
                    return this.f382122a;
                }
                SkEpO b16 = b(b("2"), true);
                if (b16 == null) {
                    b16 = b(b("1"), false);
                }
                this.f382122a = b16;
                this.f382123b.set(true);
                return this.f382122a;
            }
        } finally {
            this.f382124c.readLock().unlock();
        }
    }

    public final String a(String str) {
        SkEpO b16;
        Map<String, String> map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (str == null || (b16 = b()) == null || (map = b16.f382037g) == null) {
            return null;
        }
        return map.get(str);
    }

    public final boolean a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        String a16 = a(str);
        if (a16 == null) {
            return z16;
        }
        try {
            return Integer.parseInt(a16) > 0;
        } catch (NumberFormatException unused) {
            return z16;
        }
    }

    public String a() {
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (!d()) {
            a16 = LwgsO.a(LwgsO.f381904h1);
        } else {
            a16 = a("a_f_ok_c");
        }
        String a17 = a("a_f_ok_s");
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(a16)) {
            for (String str : a16.split(",")) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
        }
        if (!TextUtils.isEmpty(a17)) {
            V7ps4.f382068a.b().getClass();
            synchronized (fBfpd.class) {
            }
            if (d5HOq.a()) {
                for (String str2 : a17.split(",")) {
                    if (!TextUtils.isEmpty(str2)) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        if (hashSet.isEmpty()) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (sb5.length() > 0) {
                sb5.append(",");
            }
            sb5.append(str3);
        }
        return sb5.toString();
    }
}

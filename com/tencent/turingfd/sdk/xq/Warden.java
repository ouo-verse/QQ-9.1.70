package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
public class Warden {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final String f383202d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f383203e;

    /* renamed from: f, reason: collision with root package name */
    public static final Warden f383204f;

    /* renamed from: a, reason: collision with root package name */
    public volatile Cprotected f383205a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f383206b;

    /* renamed from: c, reason: collision with root package name */
    public final ReentrantReadWriteLock f383207c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13360);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f383202d = Ccontinue.a(Ccontinue.f383254b1);
        f383203e = TimeUnit.HOURS.toMillis(32L);
        f383204f = new Warden();
    }

    public Warden() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f383205a = null;
        this.f383206b = new AtomicBoolean(false);
        this.f383207c = new ReentrantReadWriteLock();
    }

    public void a(Cprotected cprotected, boolean z16) {
        BufferedOutputStream bufferedOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, cprotected, Boolean.valueOf(z16));
            return;
        }
        this.f383207c.writeLock().lock();
        if (z16) {
            try {
                Solar solar = new Solar(128);
                cprotected.a(solar);
                byte[] a16 = solar.a();
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(c()));
                    try {
                        bufferedOutputStream.write(a16);
                        bufferedOutputStream.flush();
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    bufferedOutputStream = null;
                }
                Csynchronized.a(bufferedOutputStream);
            } finally {
                this.f383205a = cprotected;
                this.f383207c.writeLock().unlock();
            }
        }
    }

    public final Cprotected b() {
        Cprotected cprotected;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Cprotected) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        this.f383207c.readLock().lock();
        try {
            if (this.f383206b.get()) {
                return this.f383205a;
            }
            synchronized (this.f383206b) {
                if (this.f383206b.get()) {
                    return this.f383205a;
                }
                try {
                    cprotected = new Cprotected();
                    cprotected.a(new Serpens(Csynchronized.b(c())));
                } catch (Throwable unused) {
                    cprotected = null;
                }
                this.f383205a = cprotected;
                this.f383206b.set(true);
                return this.f383205a;
            }
        } finally {
            this.f383207c.readLock().unlock();
        }
    }

    public String c() {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        synchronized (Celse.class) {
            context = Celse.f383328a;
        }
        File dir = context.getDir("turingfd", 0);
        if (dir == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(dir.getAbsolutePath());
        String str = File.separator;
        sb5.append(str);
        sb5.append("12");
        File file = new File(sb5.toString());
        if (!file.exists() && !file.mkdirs()) {
            return "";
        }
        return file.getAbsolutePath() + str + Nectarine.f382928a + "_xq_1";
    }

    public Set<String> d() {
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Set) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (!e()) {
            a16 = Ccontinue.a(Ccontinue.f383275i1);
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

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (b() != null) {
            return true;
        }
        return false;
    }

    public final String a(String str) {
        Cprotected b16;
        Map<String, String> map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (str == null || (b16 = b()) == null || (map = b16.f383426g) == null) {
            return null;
        }
        return map.get(str);
    }

    public final boolean a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16))).booleanValue();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (!e()) {
            a16 = Ccontinue.a(Ccontinue.f383272h1);
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
            a.f383219a.b().a();
            if (Bryony.a()) {
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

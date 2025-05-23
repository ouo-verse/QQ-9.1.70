package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Coconut {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final long f375543d;

    /* renamed from: e, reason: collision with root package name */
    public static final Coconut f375544e;

    /* renamed from: a, reason: collision with root package name */
    public volatile Cthrows f375545a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f375546b;

    /* renamed from: c, reason: collision with root package name */
    public final ReentrantReadWriteLock f375547c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62506);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f375543d = TimeUnit.HOURS.toMillis(32L);
            f375544e = new Coconut();
        }
    }

    public Coconut() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f375545a = null;
        this.f375546b = new AtomicBoolean(false);
        this.f375547c = new ReentrantReadWriteLock();
    }

    public final String a(Context context, String str) {
        Map<String, String> map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) str);
        }
        Cthrows b16 = b(context);
        if (b16 == null || (map = b16.f375852g) == null) {
            return null;
        }
        return map.get(str);
    }

    public final Cthrows b(Context context) {
        Cthrows cthrows;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Cthrows) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        this.f375547c.readLock().lock();
        try {
            if (this.f375546b.get()) {
                return this.f375545a;
            }
            synchronized (this.f375546b) {
                if (this.f375546b.get()) {
                    return this.f375545a;
                }
                try {
                    cthrows = new Cthrows();
                    cthrows.a(new Caelum(Cextends.b(c(context))));
                } catch (Throwable unused) {
                    cthrows = null;
                }
                this.f375545a = cthrows;
                this.f375546b.set(true);
                return this.f375545a;
            }
        } finally {
            this.f375547c.readLock().unlock();
        }
    }

    public final String c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
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
        return file.getAbsolutePath() + str + UrsaMinor.f375742a + "_wxa_1";
    }

    public final long a(Context context, String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, this, context, str, Long.valueOf(j3), Long.valueOf(j16))).longValue();
        }
        String a16 = a(context, str);
        if (a16 == null) {
            return j3;
        }
        try {
            return Long.parseLong(a16) * j16;
        } catch (NumberFormatException unused) {
            return j3;
        }
    }

    public final boolean a(Context context, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, context, str, Boolean.valueOf(z16))).booleanValue();
        }
        String a16 = a(context, str);
        if (a16 == null) {
            return z16;
        }
        try {
            return Integer.parseInt(a16) > 0;
        } catch (NumberFormatException unused) {
            return z16;
        }
    }

    public final String a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
        }
        String a16 = a(context, "a_f_ok_c");
        String a17 = a(context, "a_f_ok_s");
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(a16)) {
            for (String str : a16.split(",")) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
        }
        if (!TextUtils.isEmpty(a17) && Leo.a(context, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0) {
            for (String str2 : a17.split(",")) {
                if (!TextUtils.isEmpty(str2)) {
                    hashSet.add(str2);
                }
            }
        }
        if (hashSet.size() == 0) {
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

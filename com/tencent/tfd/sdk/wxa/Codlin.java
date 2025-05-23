package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Codlin {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static final Codlin f375548h;

    /* renamed from: i, reason: collision with root package name */
    public static final Map<Integer, Integer> f375549i;

    /* renamed from: a, reason: collision with root package name */
    public final Map<Integer, Integer> f375550a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Integer, Integer> f375551b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<Integer, Integer> f375552c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f375553d;

    /* renamed from: e, reason: collision with root package name */
    public Bryony f375554e;

    /* renamed from: f, reason: collision with root package name */
    public Chestnut f375555f;

    /* renamed from: g, reason: collision with root package name */
    public final Cdo f375556g;

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Codlin$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cdo {
        static IPatchRedirector $redirector_;

        public Cdo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62515);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f375548h = new Codlin();
        HashMap hashMap = new HashMap();
        f375549i = hashMap;
        hashMap.put(2, 0);
        hashMap.put(6, 0);
        hashMap.put(3, 0);
        hashMap.put(32, 0);
        hashMap.put(5, 0);
        hashMap.put(4, 0);
        hashMap.put(17, 1);
        hashMap.put(40, 0);
        hashMap.put(43, 0);
        hashMap.put(19, 0);
        hashMap.put(36, 0);
        hashMap.put(114, 0);
        hashMap.put(10001, 0);
        hashMap.put(45, 0);
        hashMap.put(136, 0);
        hashMap.put(139, 0);
        hashMap.put(10002, 0);
        hashMap.put(10003, 0);
        int i3 = UrsaMinor.f375742a;
        if (i3 == 105668) {
            hashMap.put(18, 0);
        } else if (i3 == 105928) {
            hashMap.put(18, 0);
        } else if (i3 == 108168) {
            hashMap.put(18, 0);
        }
    }

    public Codlin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f375550a = new ConcurrentHashMap();
        this.f375551b = new HashMap();
        this.f375552c = new HashMap();
        this.f375553d = new Object();
        this.f375556g = new Cdo();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
    
        if (r3 <= 0) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x015d A[Catch: all -> 0x01af, TRY_ENTER, TRY_LEAVE, TryCatch #5 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000e, B:11:0x0037, B:13:0x003f, B:15:0x004a, B:20:0x005c, B:23:0x009e, B:80:0x00a5, B:26:0x00a9, B:32:0x00ae, B:78:0x00c4, B:42:0x015d, B:50:0x0195, B:57:0x01a3, B:58:0x01ae, B:44:0x016b, B:49:0x018d, B:53:0x0192), top: B:2:0x0001, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean a(Context context, int i3, String str, long j3, String str2, String str3) {
        long j16;
        Cthrows cthrows;
        BufferedOutputStream bufferedOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, context, Integer.valueOf(i3), str, Long.valueOf(j3), str2, str3)).booleanValue();
        }
        Coconut coconut = Coconut.f375544e;
        Cthrows b16 = coconut.b(context);
        if (b16 != null) {
            j16 = b16.f375851f;
        }
        j16 = 57600;
        if (Math.abs(System.currentTimeMillis() - j3) <= j16 * 1000) {
            return false;
        }
        byte[] bArr = new byte[0];
        HashMap hashMap = new HashMap();
        StringBuilder a16 = Pyxis.a("");
        a16.append(UrsaMinor.f375742a);
        hashMap.put("1", a16.toString());
        hashMap.put("101", str);
        hashMap.put("2002", coconut.c(context));
        hashMap.put(ThemeReporter.FROM_SERVER_SET_THEME, str2);
        hashMap.put("264", str3);
        try {
            SparseArray<Object> e77 = TNative$aa.e77(new SparseArray(), context, hashMap, i3);
            if (Equuleus.b(e77) == 0) {
                bArr = Equuleus.a(e77);
            }
        } catch (Throwable unused) {
        }
        if (bArr.length != 0) {
            byte[] bArr2 = Cumquat.f375573b.a(bArr).f375604d;
            byte[] bArr3 = new byte[0];
            BufferedOutputStream bufferedOutputStream2 = null;
            if (i3 == 1) {
                try {
                    bArr2 = Equuleus.a(TNative$aa.f77(new SparseArray(), bArr2, i3));
                } catch (Throwable unused2) {
                }
            } else if (i3 != 0) {
                bArr2 = bArr3;
            }
            Triangulum triangulum = new Triangulum();
            triangulum.a(new Caelum(bArr2));
            int i16 = triangulum.f375707a;
            if (i16 < 0) {
                cthrows = null;
                if (cthrows != null) {
                    Coconut coconut2 = Coconut.f375544e;
                    coconut2.getClass();
                    coconut2.f375547c.writeLock().lock();
                    try {
                        Canesatici canesatici = new Canesatici(128);
                        cthrows.a(canesatici);
                        byte[] a17 = canesatici.a();
                        try {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(coconut2.c(context)));
                        } catch (Throwable unused3) {
                        }
                        try {
                            bufferedOutputStream.write(a17);
                            bufferedOutputStream.flush();
                            Cextends.a(bufferedOutputStream);
                        } catch (Throwable unused4) {
                            bufferedOutputStream2 = bufferedOutputStream;
                            Cextends.a(bufferedOutputStream2);
                            return z16;
                        }
                        return z16;
                    } finally {
                        coconut2.f375545a = cthrows;
                        coconut2.f375547c.writeLock().unlock();
                    }
                }
            } else {
                if (i16 == 1) {
                    cthrows = new Cthrows();
                } else {
                    cthrows = triangulum.f375708b;
                    if (cthrows == null) {
                        cthrows = new Cthrows();
                    } else {
                        Log.e("D" + UrsaMinor.f375742a, "s:" + cthrows.f375846a + ",v:" + cthrows.f375848c);
                        for (Map.Entry<Integer, Integer> entry : cthrows.f375850e.entrySet()) {
                        }
                        Map<String, String> map = cthrows.f375852g;
                        if (map != null) {
                            for (String str4 : map.keySet()) {
                            }
                        }
                    }
                }
                if (cthrows != null) {
                }
            }
        }
        z16 = false;
        return z16;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    public final synchronized void b(Context context) {
        Map<Integer, Integer> emptyMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        synchronized (this.f375553d) {
            this.f375550a.clear();
            this.f375550a.putAll(f375549i);
            Cthrows b16 = Coconut.f375544e.b(context);
            if (b16 == null || (emptyMap = b16.f375850e) == null) {
                emptyMap = Collections.emptyMap();
            }
            this.f375550a.putAll(emptyMap);
            b();
            c();
            if (a(17)) {
                this.f375550a.put(40, 0);
                this.f375550a.put(43, 0);
            }
        }
    }

    public final void c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
            return;
        }
        try {
            String a16 = Creturn.a();
            Cantaloupe a17 = Cherry.f375527h.a(context);
            Codlin codlin = f375548h;
            int i3 = Bullace.f375489f;
            Bryony bryony = this.f375554e;
            if (codlin.a(context, i3, TextUtils.isEmpty(bryony.f375474q) ? "" : bryony.f375474q, this.f375555f.a(context, "501"), a17.f375495a, a16)) {
                Chestnut chestnut = this.f375555f;
                chestnut.getClass();
                chestnut.a(context, "501", "" + System.currentTimeMillis(), true);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.HashMap] */
    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Iterator it = this.f375552c.keySet().iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (a(intValue)) {
                this.f375550a.put(Integer.valueOf(intValue), this.f375552c.get(Integer.valueOf(intValue)));
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.HashMap] */
    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Iterator it = this.f375551b.keySet().iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (a(intValue)) {
                this.f375550a.put(Integer.valueOf(intValue), this.f375551b.get(Integer.valueOf(intValue)));
            }
        }
    }

    public final long a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).longValue();
        }
        long j3 = 0;
        if (this.f375555f.a(context, "501") > 0) {
            return 0L;
        }
        synchronized (this) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                c(context);
                j3 = System.currentTimeMillis() - currentTimeMillis;
                b(context);
            } catch (Throwable unused) {
            }
        }
        return j3;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    public final boolean a(int i3) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
        }
        if (this.f375550a.containsKey(Integer.valueOf(i3)) && (obj = this.f375550a.get(Integer.valueOf(i3))) != null) {
            return ((Integer) obj).intValue() != 0;
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        HashSet hashSet = new HashSet();
        synchronized (this.f375553d) {
            for (Integer num : this.f375550a.keySet()) {
                if (((Integer) this.f375550a.get(num)).intValue() == 0) {
                    hashSet.add(num);
                }
            }
        }
        Iterator it = hashSet.iterator();
        StringBuilder sb5 = new StringBuilder();
        while (it.hasNext()) {
            sb5.append("" + ((Integer) it.next()).intValue());
            if (it.hasNext()) {
                sb5.append(",");
            }
        }
        return sb5.toString();
    }
}

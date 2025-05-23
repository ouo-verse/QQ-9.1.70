package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Watermelon {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public static final Watermelon f383208g;

    /* renamed from: h, reason: collision with root package name */
    public static final Set<Integer> f383209h;

    /* renamed from: a, reason: collision with root package name */
    public final Set<Integer> f383210a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<Integer> f383211b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f383212c;

    /* renamed from: d, reason: collision with root package name */
    public Strawberry f383213d;

    /* renamed from: e, reason: collision with root package name */
    public Walnut f383214e;

    /* renamed from: f, reason: collision with root package name */
    public final Lacerta f383215f;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Watermelon$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class Cdo implements Lacerta {
        static IPatchRedirector $redirector_;

        public Cdo(Watermelon watermelon) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) watermelon);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13373);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f383208g = new Watermelon();
        HashSet hashSet = new HashSet();
        hashSet.add(2);
        hashSet.add(6);
        hashSet.add(3);
        hashSet.add(32);
        hashSet.add(5);
        hashSet.add(4);
        hashSet.add(40);
        hashSet.add(43);
        hashSet.add(19);
        hashSet.add(36);
        hashSet.add(10001);
        hashSet.add(45);
        hashSet.add(136);
        hashSet.add(143);
        hashSet.add(144);
        hashSet.add(10002);
        hashSet.add(10003);
        int i3 = Nectarine.f382928a;
        if (i3 == 105668) {
            hashSet.add(18);
        } else if (i3 == 105928) {
            hashSet.add(18);
        } else if (i3 == 108168) {
            hashSet.add(18);
        }
        f383209h = Collections.unmodifiableSet(hashSet);
    }

    public Watermelon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f383210a = new HashSet();
        this.f383211b = new HashSet();
        this.f383212c = new Object();
        this.f383215f = new Cdo(this);
    }

    public long a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).longValue();
        }
        long j3 = 0;
        if (Warden.f383204f.e()) {
            return 0L;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            b(context);
            j3 = System.currentTimeMillis() - currentTimeMillis;
            b();
            return j3;
        } catch (Throwable unused) {
            return j3;
        }
    }

    public final void b() {
        Map<Integer, Integer> emptyMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        try {
            Cprotected b16 = Warden.f383204f.b();
            if (b16 == null || (emptyMap = b16.f383424e) == null) {
                emptyMap = Collections.emptyMap();
            }
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (Map.Entry<Integer, Integer> entry : emptyMap.entrySet()) {
                if (entry.getValue().intValue() == 0) {
                    hashSet.add(entry.getKey());
                } else {
                    hashSet2.add(entry.getKey());
                }
            }
            synchronized (this.f383211b) {
                this.f383211b.clear();
                this.f383211b.addAll(f383209h);
                this.f383211b.addAll(hashSet);
                this.f383211b.removeAll(hashSet2);
                synchronized (this.f383210a) {
                    this.f383211b.addAll(this.f383210a);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final byte[] a(Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (byte[]) iPatchRedirector.redirect((short) 8, this, context, Boolean.valueOf(z16));
        }
        byte[] bArr = new byte[0];
        HashMap hashMap = new HashMap();
        StringBuilder a16 = Flat.a("");
        a16.append(Nectarine.f382928a);
        hashMap.put("1", a16.toString());
        hashMap.put("101", this.f383213d.b());
        hashMap.put("2002", Warden.f383204f.c());
        hashMap.put(ThemeReporter.FROM_SERVER_SET_THEME, Vermillion.f383180l.a(context).f383113a);
        if (z16) {
            hashMap.put("264", Cprivate.a());
        } else {
            hashMap.put("264", "PPNA");
        }
        try {
            SparseArray<Object> e89_A931D6BEC30CD812 = TNative$aa.e89_A931D6BEC30CD812(new SparseArray(), context, hashMap, Sugarcane.f383111g);
            return Bagasse.b(e89_A931D6BEC30CD812) != 0 ? bArr : Bagasse.a(e89_A931D6BEC30CD812);
        } catch (Throwable unused) {
            return bArr;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        if (r4 <= 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(Context context) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
            return;
        }
        try {
            synchronized (this.f383212c) {
                long a16 = this.f383214e.a(context, "501");
                Warden warden = Warden.f383204f;
                Cprotected b16 = warden.b();
                if (b16 != null) {
                    j3 = b16.f383425f;
                }
                j3 = 57600;
                if (Math.abs(System.currentTimeMillis() - a16) <= j3 * 1000) {
                    return;
                }
                boolean userAgreement = this.f383213d.d().userAgreement();
                byte[] a17 = a(context, userAgreement);
                if (a17.length == 0) {
                    return;
                }
                Cprotected a18 = a(Wild.f383217b.a(4, a17, 8119, 18119, this.f383215f).f383236d);
                if (a18 == null) {
                    return;
                }
                warden.a(a18, userAgreement);
                if (userAgreement) {
                    Walnut walnut = this.f383214e;
                    walnut.getClass();
                    walnut.a(context, "501", "" + System.currentTimeMillis(), true);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final Cprotected a(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Cprotected) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bArr);
        }
        byte[] bArr2 = new byte[0];
        int i3 = Sugarcane.f383111g;
        if (i3 == 1) {
            try {
                bArr = Bagasse.a(TNative$aa.f89_A931D6BEC30CD812(new SparseArray(), bArr, i3));
            } catch (Throwable unused) {
                return null;
            }
        } else if (i3 != 0) {
            bArr = bArr2;
        }
        try {
            Longan longan = new Longan();
            longan.a(new Serpens(bArr));
            int i16 = longan.f382879a;
            if (i16 < 0) {
                return null;
            }
            if (i16 == 1) {
                return new Cprotected();
            }
            Cprotected cprotected = longan.f382880b;
            if (cprotected == null) {
                return new Cprotected();
            }
            Log.e("D" + Nectarine.f382928a, "s:" + cprotected.f383420a + ",v:" + cprotected.f383422c);
            for (Map.Entry<Integer, Integer> entry : cprotected.f383424e.entrySet()) {
            }
            Map<String, String> map = cprotected.f383426g;
            if (map != null) {
                for (String str : map.keySet()) {
                }
            }
            return cprotected;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public boolean a(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
        }
        synchronized (this.f383211b) {
            z16 = !this.f383211b.contains(Integer.valueOf(i3));
        }
        return z16;
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        synchronized (this.f383211b) {
            for (Integer num : this.f383211b) {
                if (sb5.length() > 0) {
                    sb5.append(",");
                }
                sb5.append(num);
            }
        }
        return sb5.toString();
    }
}

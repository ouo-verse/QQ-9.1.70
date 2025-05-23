package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.turingcam.CRchv;
import com.tencent.turingcam.Iioec;
import com.tencent.turingcam.JF943;
import com.tencent.turingcam.NbXuL;
import com.tencent.turingcam.SWw7W;
import com.tencent.turingcam.SkEpO;
import com.tencent.turingcam.T0QUa;
import com.tencent.turingcam.WT9z5;
import com.tencent.turingcam.XStYH;
import com.tencent.turingcam.YunKQ;
import com.tencent.turingcam.ZY08E;
import com.tencent.turingcam.fBfpd;
import com.tencent.turingcam.sh4jo;
import com.tencent.turingcam.tmnyR;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public static final b f382488g;

    /* renamed from: h, reason: collision with root package name */
    public static final Set<Integer> f382489h;

    /* renamed from: a, reason: collision with root package name */
    public final Set<Integer> f382490a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<Integer> f382491b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f382492c;

    /* renamed from: d, reason: collision with root package name */
    public fBfpd f382493d;

    /* renamed from: e, reason: collision with root package name */
    public XStYH f382494e;

    /* renamed from: f, reason: collision with root package name */
    public final NbXuL f382495f;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class a implements NbXuL {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.turingcam.NbXuL
        public boolean a(j jVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jVar)).booleanValue();
            }
            if (jVar.f382527a == -7) {
                return false;
            }
            return !jVar.a();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12366);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f382488g = new b();
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
        hashSet.add(45);
        hashSet.add(136);
        hashSet.add(143);
        hashSet.add(144);
        hashSet.add(10002);
        hashSet.add(10003);
        int i3 = WT9z5.f382088a;
        if (i3 == 105668) {
            hashSet.add(18);
        } else if (i3 == 105928) {
            hashSet.add(18);
        } else if (i3 == 108168) {
            hashSet.add(18);
        }
        f382489h = Collections.unmodifiableSet(hashSet);
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382490a = new HashSet();
        this.f382491b = new HashSet();
        this.f382492c = new Object();
        this.f382495f = new a();
    }

    public long a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).longValue();
        }
        long j3 = 0;
        if (ZY08E.f382121f.d()) {
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
            SkEpO b16 = ZY08E.f382121f.b();
            if (b16 == null || (emptyMap = b16.f382035e) == null) {
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
            synchronized (this.f382491b) {
                this.f382491b.clear();
                this.f382491b.addAll(f382489h);
                this.f382491b.addAll(hashSet);
                this.f382491b.removeAll(hashSet2);
                synchronized (this.f382490a) {
                    this.f382491b.addAll(this.f382490a);
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
        StringBuilder a16 = tmnyR.a("");
        a16.append(WT9z5.f382088a);
        hashMap.put("1", a16.toString());
        hashMap.put("101", this.f382493d.b());
        SkEpO b16 = ZY08E.f382121f.b();
        if (b16 != null) {
            hashMap.put("2026", String.valueOf(b16.f382031a));
            hashMap.put("2027", String.valueOf(b16.f382033c));
        }
        hashMap.put(ThemeReporter.FROM_SERVER_SET_THEME, T0QUa.f382050l.a(context).f382267a);
        if (z16) {
            hashMap.put("264", sh4jo.a());
        } else {
            hashMap.put("264", "PPNA");
        }
        try {
            SparseArray sparseArray = new SparseArray();
            String str = CRchv.f381744a;
            SparseArray<Object> e91_FC6D5B0A7013DB60 = TNative$aa.e91_FC6D5B0A7013DB60(sparseArray, context, hashMap, 0);
            return SWw7W.b(e91_FC6D5B0A7013DB60) != 0 ? bArr : SWw7W.a(e91_FC6D5B0A7013DB60);
        } catch (Throwable unused) {
            return bArr;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
    
        if (r4 <= 0) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(Context context) {
        Iioec iioec;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
            return;
        }
        try {
            synchronized (this.f382492c) {
                ZY08E zy08e = ZY08E.f382121f;
                if (zy08e.d()) {
                    long a16 = this.f382494e.a(context, "501");
                    SkEpO b16 = zy08e.b();
                    if (b16 != null) {
                        j3 = b16.f382036f;
                    }
                    j3 = 57600;
                    if (Math.abs(System.currentTimeMillis() - a16) <= j3 * 1000) {
                        return;
                    }
                }
                boolean a17 = this.f382493d.d().a();
                byte[] a18 = a(context, a17);
                if (a18.length == 0) {
                    return;
                }
                j a19 = com.tencent.turingface.sdk.mfa.a.a().a(8119, 18119, 4, a18, 200000L, this.f382495f);
                int i3 = a19.f382527a;
                if (i3 != 0) {
                    iioec = new Iioec(i3 - 40000, Iioec.f381858e, a19.f382528b, a19.f382529c);
                } else {
                    iioec = new Iioec(0, a19.f382530d, 0, 0);
                }
                SkEpO a26 = a(iioec.f381862d);
                if (a26 == null) {
                    return;
                }
                zy08e.a(a26, a17);
                if (a17) {
                    XStYH xStYH = this.f382494e;
                    xStYH.getClass();
                    xStYH.a(context, "501", "" + System.currentTimeMillis(), true);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final SkEpO a(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SkEpO) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bArr);
        }
        String str = CRchv.f381744a;
        try {
            JF943 jf943 = new JF943();
            jf943.a(new YunKQ(bArr));
            int i3 = jf943.f381872a;
            if (i3 < 0) {
                return null;
            }
            if (i3 == 1) {
                return new SkEpO();
            }
            SkEpO skEpO = jf943.f381873b;
            if (skEpO == null) {
                return new SkEpO();
            }
            Log.e("D" + WT9z5.f382088a, "s:" + skEpO.f382031a + ",v:" + skEpO.f382033c);
            for (Map.Entry<Integer, Integer> entry : skEpO.f382035e.entrySet()) {
            }
            Map<String, String> map = skEpO.f382037g;
            if (map != null) {
                for (String str2 : map.keySet()) {
                }
            }
            return skEpO;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean a(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
        }
        synchronized (this.f382491b) {
            z16 = !this.f382491b.contains(Integer.valueOf(i3));
        }
        return z16;
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        synchronized (this.f382491b) {
            for (Integer num : this.f382491b) {
                if (sb5.length() > 0) {
                    sb5.append(",");
                }
                sb5.append(num);
            }
        }
        return sb5.toString();
    }
}

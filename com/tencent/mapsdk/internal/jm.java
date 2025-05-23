package com.tencent.mapsdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mapsdk.internal.ix;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public class jm extends ix {

    /* renamed from: b, reason: collision with root package name */
    private static final long f148892b = 10;

    /* renamed from: c, reason: collision with root package name */
    static final int f148893c = 0;

    /* renamed from: d, reason: collision with root package name */
    static final int f148894d = 1;

    /* renamed from: e, reason: collision with root package name */
    static final int f148895e = 0;

    /* renamed from: f, reason: collision with root package name */
    static final int f148896f = 1;

    /* renamed from: g, reason: collision with root package name */
    static final int f148897g = 2;

    /* renamed from: n, reason: collision with root package name */
    public static final int f148898n = 1;

    /* renamed from: o, reason: collision with root package name */
    public static final int f148899o = 2;

    /* renamed from: p, reason: collision with root package name */
    public static final int f148900p = -1;
    private long B;

    /* renamed from: h, reason: collision with root package name */
    long f148908h;

    /* renamed from: k, reason: collision with root package name */
    ji[] f148911k;

    /* renamed from: l, reason: collision with root package name */
    HashMap<Integer, ji> f148912l;

    /* renamed from: m, reason: collision with root package name */
    protected iu f148913m;

    /* renamed from: q, reason: collision with root package name */
    private static ThreadLocal<a> f148901q = new ThreadLocal<>();

    /* renamed from: r, reason: collision with root package name */
    private static final ThreadLocal<ArrayList<jm>> f148902r = new ThreadLocal<ArrayList<jm>>() { // from class: com.tencent.mapsdk.internal.jm.1
        private static ArrayList<jm> a() {
            return new ArrayList<>();
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ ArrayList<jm> initialValue() {
            return new ArrayList<>();
        }
    };

    /* renamed from: s, reason: collision with root package name */
    private static final ThreadLocal<ArrayList<jm>> f148903s = new ThreadLocal<ArrayList<jm>>() { // from class: com.tencent.mapsdk.internal.jm.2
        private static ArrayList<jm> a() {
            return new ArrayList<>();
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ ArrayList<jm> initialValue() {
            return new ArrayList<>();
        }
    };

    /* renamed from: t, reason: collision with root package name */
    private static final ThreadLocal<ArrayList<jm>> f148904t = new ThreadLocal<ArrayList<jm>>() { // from class: com.tencent.mapsdk.internal.jm.3
        private static ArrayList<jm> a() {
            return new ArrayList<>();
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ ArrayList<jm> initialValue() {
            return new ArrayList<>();
        }
    };

    /* renamed from: u, reason: collision with root package name */
    private static final ThreadLocal<ArrayList<jm>> f148905u = new ThreadLocal<ArrayList<jm>>() { // from class: com.tencent.mapsdk.internal.jm.4
        private static ArrayList<jm> a() {
            return new ArrayList<>();
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ ArrayList<jm> initialValue() {
            return new ArrayList<>();
        }
    };

    /* renamed from: v, reason: collision with root package name */
    private static final ThreadLocal<ArrayList<jm>> f148906v = new ThreadLocal<ArrayList<jm>>() { // from class: com.tencent.mapsdk.internal.jm.5
        private static ArrayList<jm> a() {
            return new ArrayList<>();
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ ArrayList<jm> initialValue() {
            return new ArrayList<>();
        }
    };

    /* renamed from: w, reason: collision with root package name */
    private static final Interpolator f148907w = new LinearInterpolator();
    private static long G = 10;

    /* renamed from: i, reason: collision with root package name */
    long f148909i = -1;

    /* renamed from: x, reason: collision with root package name */
    private boolean f148914x = false;

    /* renamed from: y, reason: collision with root package name */
    private int f148915y = 0;

    /* renamed from: z, reason: collision with root package name */
    private float f148916z = 0.0f;
    private boolean A = false;

    /* renamed from: j, reason: collision with root package name */
    int f148910j = 0;
    private boolean C = false;
    private boolean D = false;
    private long E = 300;
    private long F = 0;
    private int H = 0;
    private int I = 1;
    private Interpolator J = f148907w;
    private ArrayList<b> K = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z16;
            ArrayList arrayList = (ArrayList) jm.f148902r.get();
            ArrayList arrayList2 = (ArrayList) jm.f148904t.get();
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 == 1) {
                    z16 = true;
                } else {
                    return;
                }
            } else {
                ArrayList arrayList3 = (ArrayList) jm.f148903s.get();
                if (arrayList.size() <= 0 && arrayList2.size() <= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                while (arrayList3.size() > 0) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i16 = 0; i16 < size; i16++) {
                        jm jmVar = (jm) arrayList4.get(i16);
                        if (jmVar.F == 0) {
                            jmVar.y();
                        } else {
                            arrayList2.add(jmVar);
                        }
                    }
                }
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            ArrayList arrayList5 = (ArrayList) jm.f148906v.get();
            ArrayList arrayList6 = (ArrayList) jm.f148905u.get();
            int size2 = arrayList2.size();
            for (int i17 = 0; i17 < size2; i17++) {
                jm jmVar2 = (jm) arrayList2.get(i17);
                if (jm.a(jmVar2, uptimeMillis)) {
                    arrayList5.add(jmVar2);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i18 = 0; i18 < size3; i18++) {
                    jm jmVar3 = (jm) arrayList5.get(i18);
                    jmVar3.y();
                    jm.c(jmVar3);
                    arrayList2.remove(jmVar3);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i19 = 0;
            while (i19 < size4) {
                jm jmVar4 = (jm) arrayList.get(i19);
                if (jmVar4.c(uptimeMillis)) {
                    arrayList6.add(jmVar4);
                }
                if (arrayList.size() == size4) {
                    i19++;
                } else {
                    size4--;
                    arrayList6.remove(jmVar4);
                }
            }
            if (arrayList6.size() > 0) {
                for (int i26 = 0; i26 < arrayList6.size(); i26++) {
                    ((jm) arrayList6.get(i26)).x();
                }
                arrayList6.clear();
            }
            if (z16) {
                if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
                    sendEmptyMessageDelayed(1, Math.max(0L, jm.G - (SystemClock.uptimeMillis() - uptimeMillis)));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a();
    }

    public jm(iu iuVar) {
        this.f148913m = iuVar;
    }

    private static int A() {
        return f148902r.get().size();
    }

    private static void B() {
        f148902r.get().clear();
        f148903s.get().clear();
        f148904t.get().clear();
    }

    static /* synthetic */ boolean c(jm jmVar) {
        jmVar.C = true;
        return true;
    }

    private ji[] o() {
        return this.f148911k;
    }

    private long p() {
        if (this.f148910j == 0) {
            return 0L;
        }
        return SystemClock.uptimeMillis() - this.f148908h;
    }

    private static long q() {
        return G;
    }

    private Object r() {
        ji[] jiVarArr = this.f148911k;
        if (jiVarArr != null && jiVarArr.length > 0) {
            return jiVarArr[0].b();
        }
        return null;
    }

    private int s() {
        return this.H;
    }

    private int t() {
        return this.I;
    }

    private void u() {
        ArrayList<b> arrayList = this.K;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
        this.K = null;
    }

    private Interpolator v() {
        return this.J;
    }

    private void w() {
        this.f148914x = !this.f148914x;
        if (this.f148910j == 1) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f148908h = uptimeMillis - (this.E - (uptimeMillis - this.f148908h));
            return;
        }
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        ArrayList<ix.a> arrayList;
        f148902r.get().remove(this);
        f148903s.get().remove(this);
        f148904t.get().remove(this);
        this.f148910j = 0;
        if (this.C && (arrayList = this.f148825a) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((ix.a) arrayList2.get(i3)).b(this);
            }
        }
        this.C = false;
        this.D = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        ArrayList<ix.a> arrayList;
        f148902r.get().add(this);
        if (this.F > 0 && (arrayList = this.f148825a) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((ix.a) arrayList2.get(i3)).a(this);
            }
        }
    }

    private float z() {
        return this.f148916z;
    }

    @Override // com.tencent.mapsdk.internal.ix
    public final long e() {
        return this.E;
    }

    @Override // com.tencent.mapsdk.internal.ix
    public final boolean f() {
        return this.f148910j == 1 || this.C;
    }

    @Override // com.tencent.mapsdk.internal.ix
    public final boolean g() {
        return this.D;
    }

    @Override // com.tencent.mapsdk.internal.ix
    /* renamed from: h */
    public ix clone() {
        jm jmVar = (jm) super.clone();
        ArrayList<b> arrayList = this.K;
        if (arrayList != null) {
            jmVar.K = new ArrayList<>();
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                jmVar.K.add(arrayList.get(i3));
            }
        }
        jmVar.f148909i = -1L;
        jmVar.f148914x = false;
        jmVar.f148915y = 0;
        jmVar.f148910j = 0;
        jmVar.A = false;
        ji[] jiVarArr = this.f148911k;
        if (jiVarArr != null) {
            int length = jiVarArr.length;
            jmVar.f148911k = new ji[length];
            jmVar.f148912l = new HashMap<>(length);
            for (int i16 = 0; i16 < length; i16++) {
                ji clone = jiVarArr[i16].clone();
                jmVar.f148911k[i16] = clone;
                jmVar.f148912l.put(Integer.valueOf(clone.f148881a), clone);
            }
        }
        return jmVar;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f148911k != null) {
            for (int i3 = 0; i3 < this.f148911k.length; i3++) {
                str = str + "\n    " + this.f148911k[i3].toString();
            }
        }
        return str;
    }

    private static jm a(iu iuVar, int... iArr) {
        jm jmVar = new jm(iuVar);
        jmVar.a(iArr);
        return jmVar;
    }

    public static jm b(double... dArr) {
        jm jmVar = new jm(null);
        jmVar.a(dArr);
        return jmVar;
    }

    private void c(int i3) {
        this.I = i3;
    }

    private void e(long j3) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f148910j != 1) {
            this.f148909i = j3;
            this.f148910j = 2;
        }
        this.f148908h = uptimeMillis - j3;
        c(uptimeMillis);
    }

    private boolean f(long j3) {
        if (!this.A) {
            this.A = true;
            this.B = j3;
            return false;
        }
        long j16 = j3 - this.B;
        long j17 = this.F;
        if (j16 <= j17) {
            return false;
        }
        this.f148908h = j3 - (j16 - j17);
        this.f148910j = 1;
        return true;
    }

    @Override // com.tencent.mapsdk.internal.ix
    public final long d() {
        return this.F;
    }

    public static void d(long j3) {
        G = j3;
    }

    @Override // com.tencent.mapsdk.internal.ix
    public final void c() {
        if (!f148902r.get().contains(this) && !f148903s.get().contains(this)) {
            this.A = false;
            y();
        }
        int i3 = this.H;
        if (i3 > 0 && (i3 & 1) == 1) {
            a(0.0f);
        } else {
            a(1.0f);
        }
        x();
    }

    private static jm a(iu iuVar, ji... jiVarArr) {
        jm jmVar = new jm(iuVar);
        jmVar.a(jiVarArr);
        return jmVar;
    }

    @Override // com.tencent.mapsdk.internal.ix
    public ix b(long j3) {
        if (j3 >= 0) {
            this.E = j3;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: ".concat(String.valueOf(j3)));
    }

    private static jm a(iu iuVar, jl<?> jlVar, Object[] objArr) {
        jm jmVar = new jm(iuVar);
        jmVar.a(objArr);
        jmVar.a(jlVar);
        return jmVar;
    }

    private void b(int i3) {
        this.H = i3;
    }

    private void b(b bVar) {
        ArrayList<b> arrayList = this.K;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(bVar);
        if (this.K.size() == 0) {
            this.K = null;
        }
    }

    public void a(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        ji[] jiVarArr = this.f148911k;
        if (jiVarArr != null && jiVarArr.length != 0) {
            jiVarArr[0].a(iArr);
        } else {
            a(ji.a(0, iArr));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean c(long j3) {
        boolean z16 = true;
        if (this.f148910j == 0) {
            this.f148910j = 1;
            long j16 = this.f148909i;
            if (j16 < 0) {
                this.f148908h = j3;
            } else {
                this.f148908h = j3 - j16;
                this.f148909i = -1L;
            }
        }
        int i3 = this.f148910j;
        if (i3 != 1 && i3 != 2) {
            return false;
        }
        long j17 = this.E;
        float f16 = j17 > 0 ? ((float) (j3 - this.f148908h)) / ((float) j17) : 1.0f;
        if (f16 >= 1.0f) {
            int i16 = this.f148915y;
            int i17 = this.H;
            if (i16 >= i17 && i17 != -1) {
                f16 = Math.min(f16, 1.0f);
                if (this.f148914x) {
                    f16 = 1.0f - f16;
                }
                a(f16);
                return z16;
            }
            ArrayList<ix.a> arrayList = this.f148825a;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i18 = 0; i18 < size; i18++) {
                    this.f148825a.get(i18);
                }
            }
            if (this.I == 2) {
                this.f148914x = !this.f148914x;
            }
            this.f148915y += (int) f16;
            f16 %= 1.0f;
            this.f148908h += this.E;
        }
        z16 = false;
        if (this.f148914x) {
        }
        a(f16);
        return z16;
    }

    @Override // com.tencent.mapsdk.internal.ix
    public final void b() {
        ArrayList<ix.a> arrayList;
        if (this.f148910j != 0 || f148903s.get().contains(this) || f148904t.get().contains(this)) {
            if (this.C && (arrayList = this.f148825a) != null) {
                Iterator it = ((ArrayList) arrayList.clone()).iterator();
                while (it.hasNext()) {
                    ((ix.a) it.next()).a();
                }
            }
            x();
        }
    }

    public void a(double... dArr) {
        if (dArr == null || dArr.length == 0) {
            return;
        }
        ji[] jiVarArr = this.f148911k;
        if (jiVarArr != null && jiVarArr.length != 0) {
            jiVarArr[0].a(dArr);
        } else {
            a(ji.a(0, dArr));
        }
    }

    public void a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        ji[] jiVarArr = this.f148911k;
        if (jiVarArr != null && jiVarArr.length != 0) {
            jiVarArr[0].a(objArr);
        } else {
            a(ji.a(0, objArr));
        }
    }

    private static void C() {
    }

    public final void a(ji... jiVarArr) {
        int length = jiVarArr.length;
        this.f148911k = jiVarArr;
        this.f148912l = new HashMap<>(length);
        for (ji jiVar : jiVarArr) {
            this.f148912l.put(Integer.valueOf(jiVar.f148881a), jiVar);
        }
    }

    @Override // com.tencent.mapsdk.internal.ix
    public final void a(long j3) {
        this.F = j3;
    }

    private Object a(int i3) {
        ji jiVar = this.f148912l.get(Integer.valueOf(i3));
        if (jiVar != null) {
            return jiVar.b();
        }
        return null;
    }

    private void a(b bVar) {
        if (this.K == null) {
            this.K = new ArrayList<>();
        }
        this.K.add(bVar);
    }

    @Override // com.tencent.mapsdk.internal.ix
    public final void a(Interpolator interpolator) {
        if (interpolator != null) {
            this.J = interpolator;
        } else {
            this.J = new LinearInterpolator();
        }
    }

    public final void a(jl<?> jlVar) {
        ji[] jiVarArr;
        if (jlVar == null || (jiVarArr = this.f148911k) == null || jiVarArr.length <= 0) {
            return;
        }
        jiVarArr[0].a(jlVar);
    }

    private void a(boolean z16) {
        this.f148914x = z16;
        this.f148915y = 0;
        this.f148910j = 0;
        this.D = true;
        this.A = false;
        f148903s.get().add(this);
        if (this.F == 0) {
            long uptimeMillis = this.f148910j != 0 ? SystemClock.uptimeMillis() - this.f148908h : 0L;
            long uptimeMillis2 = SystemClock.uptimeMillis();
            if (this.f148910j != 1) {
                this.f148909i = uptimeMillis;
                this.f148910j = 2;
            }
            this.f148908h = uptimeMillis2 - uptimeMillis;
            c(uptimeMillis2);
            this.f148910j = 0;
            this.C = true;
            ArrayList<ix.a> arrayList = this.f148825a;
            if (arrayList != null) {
                ArrayList arrayList2 = (ArrayList) arrayList.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((ix.a) arrayList2.get(i3)).a(this);
                }
            }
        }
        a aVar = f148901q.get();
        if (aVar == null) {
            aVar = new a(Looper.getMainLooper());
            f148901q.set(aVar);
        } else {
            aVar.removeMessages(0);
            aVar.removeMessages(1);
        }
        aVar.sendEmptyMessage(0);
    }

    @Override // com.tencent.mapsdk.internal.ix
    public final void a() {
        a(false);
    }

    protected void a(float f16) {
        float interpolation = this.J.getInterpolation(f16);
        this.f148916z = interpolation;
        int length = this.f148911k.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f148911k[i3].a(interpolation);
            iu iuVar = this.f148913m;
            if (iuVar != null) {
                ji jiVar = this.f148911k[i3];
                iuVar.a(jiVar.f148881a, jiVar.b());
            }
        }
        ArrayList<b> arrayList = this.K;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i16 = 0; i16 < size; i16++) {
                this.K.get(i16);
            }
        }
    }

    static /* synthetic */ boolean a(jm jmVar, long j3) {
        if (!jmVar.A) {
            jmVar.A = true;
            jmVar.B = j3;
            return false;
        }
        long j16 = j3 - jmVar.B;
        long j17 = jmVar.F;
        if (j16 <= j17) {
            return false;
        }
        jmVar.f148908h = j3 - (j16 - j17);
        jmVar.f148910j = 1;
        return true;
    }
}

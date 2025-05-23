package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.jf;
import com.tencent.mobileqq.activity.recent.MsgSummary;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ji implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private static final jl<Integer> f148879d = new jd();

    /* renamed from: e, reason: collision with root package name */
    private static final jl<Number> f148880e = new jb();

    /* renamed from: a, reason: collision with root package name */
    int f148881a;

    /* renamed from: b, reason: collision with root package name */
    Class<?> f148882b;

    /* renamed from: c, reason: collision with root package name */
    jg f148883c;

    /* renamed from: f, reason: collision with root package name */
    private jl f148884f;

    /* renamed from: g, reason: collision with root package name */
    private Object f148885g;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class a extends ji {

        /* renamed from: d, reason: collision with root package name */
        jc f148886d;

        /* renamed from: e, reason: collision with root package name */
        double f148887e;

        a(int i3, jc jcVar) {
            super(i3, (byte) 0);
            this.f148882b = Float.TYPE;
            this.f148883c = jcVar;
            this.f148886d = jcVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.tencent.mapsdk.internal.ji
        /* renamed from: c, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = (a) super.clone();
            aVar.f148886d = (jc) aVar.f148883c;
            return aVar;
        }

        @Override // com.tencent.mapsdk.internal.ji
        final Object b() {
            return Double.valueOf(this.f148887e);
        }

        @Override // com.tencent.mapsdk.internal.ji
        public final void a(double... dArr) {
            super.a(dArr);
            this.f148886d = (jc) this.f148883c;
        }

        @Override // com.tencent.mapsdk.internal.ji
        final void a(float f16) {
            this.f148887e = this.f148886d.b(f16);
        }

        public a(int i3, double... dArr) {
            super(i3, (byte) 0);
            a(dArr);
        }

        @Override // com.tencent.mapsdk.internal.ji
        final void a(iu iuVar) {
            if (iuVar != null) {
                iuVar.a(this.f148881a, Double.valueOf(this.f148887e));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class b extends ji {

        /* renamed from: d, reason: collision with root package name */
        je f148888d;

        /* renamed from: e, reason: collision with root package name */
        int f148889e;

        b(int i3, je jeVar) {
            super(i3, (byte) 0);
            this.f148882b = Integer.TYPE;
            this.f148883c = jeVar;
            this.f148888d = jeVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.tencent.mapsdk.internal.ji
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public b clone() {
            b bVar = (b) super.clone();
            bVar.f148888d = (je) bVar.f148883c;
            return bVar;
        }

        @Override // com.tencent.mapsdk.internal.ji
        final Object b() {
            return Integer.valueOf(this.f148889e);
        }

        @Override // com.tencent.mapsdk.internal.ji
        public final void a(int... iArr) {
            super.a(iArr);
            this.f148888d = (je) this.f148883c;
        }

        @Override // com.tencent.mapsdk.internal.ji
        final void a(float f16) {
            this.f148889e = this.f148888d.b(f16);
        }

        public b(int i3, int... iArr) {
            super(i3, (byte) 0);
            a(iArr);
        }

        @Override // com.tencent.mapsdk.internal.ji
        final void a(iu iuVar) {
            if (iuVar != null) {
                iuVar.a(this.f148881a, Integer.valueOf(this.f148889e));
            }
        }
    }

    /* synthetic */ ji(int i3, byte b16) {
        this(i3);
    }

    public static ji a(int i3, int... iArr) {
        return new b(i3, iArr);
    }

    private void c() {
        jl jlVar;
        if (this.f148884f == null) {
            Class<?> cls = this.f148882b;
            if (cls == Integer.class) {
                jlVar = f148879d;
            } else if (cls == Double.class) {
                jlVar = f148880e;
            } else {
                jlVar = null;
            }
            this.f148884f = jlVar;
        }
        jl jlVar2 = this.f148884f;
        if (jlVar2 != null) {
            this.f148883c.f148877f = jlVar2;
        }
    }

    private int d() {
        return this.f148881a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object b() {
        return this.f148885g;
    }

    public String toString() {
        return this.f148881a + MsgSummary.STR_COLON + this.f148883c.toString();
    }

    ji(int i3) {
        this.f148883c = null;
        this.f148881a = i3;
    }

    public static ji a(int i3, double... dArr) {
        return new a(i3, dArr);
    }

    public static ji a(int i3, Object... objArr) {
        ji jiVar = new ji(i3);
        jiVar.a(objArr);
        jiVar.a((jl) null);
        return jiVar;
    }

    public void a(int... iArr) {
        this.f148882b = Integer.TYPE;
        int length = iArr.length;
        jf.b[] bVarArr = new jf.b[Math.max(length, 2)];
        if (length == 1) {
            bVarArr[0] = new jf.b();
            bVarArr[1] = (jf.b) jf.a(1.0f, iArr[0]);
        } else {
            bVarArr[0] = (jf.b) jf.a(0.0f, iArr[0]);
            for (int i3 = 1; i3 < length; i3++) {
                bVarArr[i3] = (jf.b) jf.a(i3 / (length - 1), iArr[i3]);
            }
        }
        this.f148883c = new je(bVarArr);
    }

    public void a(double... dArr) {
        this.f148882b = Double.TYPE;
        int length = dArr.length;
        jf.a[] aVarArr = new jf.a[Math.max(length, 2)];
        if (length == 1) {
            aVarArr[0] = new jf.a();
            aVarArr[1] = (jf.a) jf.a(1.0f, dArr[0]);
        } else {
            aVarArr[0] = (jf.a) jf.a(0.0f, dArr[0]);
            for (int i3 = 1; i3 < length; i3++) {
                aVarArr[i3] = (jf.a) jf.a(i3 / (length - 1), dArr[i3]);
            }
        }
        this.f148883c = new jc(aVarArr);
    }

    private void a(jf... jfVarArr) {
        int length = jfVarArr.length;
        jf[] jfVarArr2 = new jf[Math.max(length, 2)];
        for (int i3 = 0; i3 < length; i3++) {
            jfVarArr2[i3] = jfVarArr[i3];
        }
        this.f148883c = new jg(jfVarArr2);
    }

    public final void a(Object... objArr) {
        this.f148882b = objArr[0].getClass();
        this.f148883c = jg.a(objArr);
    }

    @Override // 
    /* renamed from: a */
    public ji clone() {
        try {
            ji jiVar = (ji) super.clone();
            jiVar.f148881a = this.f148881a;
            jiVar.f148883c = this.f148883c.clone();
            jiVar.f148884f = this.f148884f;
            return jiVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    void a(iu iuVar) {
        if (iuVar != null) {
            iuVar.a(this.f148881a, b());
        }
    }

    public final void a(jl jlVar) {
        this.f148884f = jlVar;
        this.f148883c.f148877f = jlVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f16) {
        this.f148885g = this.f148883c.a(f16);
    }

    private void a(int i3) {
        this.f148881a = i3;
    }

    private static ji a(int i3, jf... jfVarArr) {
        jg jgVar;
        int length = jfVarArr.length;
        int i16 = 0;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        for (jf jfVar : jfVarArr) {
            if (jfVar instanceof jf.a) {
                z16 = true;
            } else if (jfVar instanceof jf.b) {
                z17 = true;
            } else {
                z18 = true;
            }
        }
        if (z16 && !z17 && !z18) {
            jf.a[] aVarArr = new jf.a[length];
            while (i16 < length) {
                aVarArr[i16] = (jf.a) jfVarArr[i16];
                i16++;
            }
            jgVar = new jc(aVarArr);
        } else if (z17 && !z16 && !z18) {
            jf.b[] bVarArr = new jf.b[length];
            while (i16 < length) {
                bVarArr[i16] = (jf.b) jfVarArr[i16];
                i16++;
            }
            jgVar = new je(bVarArr);
        } else {
            jgVar = new jg(jfVarArr);
        }
        ji jiVar = new ji(i3);
        jiVar.f148883c = jgVar;
        return jiVar;
    }
}

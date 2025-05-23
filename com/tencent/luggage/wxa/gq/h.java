package com.tencent.luggage.wxa.gq;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static com.tencent.luggage.wxa.hq.b f126817a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f126818a;

        static {
            int[] iArr = new int[b.values().length];
            f126818a = iArr;
            try {
                iArr[b.FS_POLICY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f126818a[b.CONST_POLICY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f126818a[b.LINEAR_POLICY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f126818a[b.THROW_POLICY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f126818a[b.BLOCK_INVOKER_POLICY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f126818a[b.DEFAULT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum b {
        FS_POLICY,
        LINEAR_POLICY,
        CONST_POLICY,
        THROW_POLICY,
        BLOCK_INVOKER_POLICY,
        DEFAULT
    }

    public static com.tencent.luggage.wxa.hq.b a(com.tencent.luggage.wxa.zp.a aVar) {
        com.tencent.luggage.wxa.hq.b bVar = aVar.f146782e;
        if (bVar != null) {
            return bVar;
        }
        int max = Math.max(1, aVar.f146778a / 2);
        int max2 = Math.max(1, max / 3);
        int i3 = a.f126818a[aVar.f146783f.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return new d();
                        }
                        return new com.tencent.luggage.wxa.gq.a(max2, max2);
                    }
                    return new i(max);
                }
                return new f(1000L, 500.0f, max, max2);
            }
            return new c(1000L, max, max2);
        }
        return new e(max, max2);
    }
}

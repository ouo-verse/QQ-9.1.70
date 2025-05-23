package com.bumptech.glide.load.resource.bitmap;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class DownsampleStrategy {

    /* renamed from: a, reason: collision with root package name */
    public static final DownsampleStrategy f31784a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final DownsampleStrategy f31785b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final DownsampleStrategy f31786c = new e();

    /* renamed from: d, reason: collision with root package name */
    public static final DownsampleStrategy f31787d = new c();

    /* renamed from: e, reason: collision with root package name */
    public static final DownsampleStrategy f31788e;

    /* renamed from: f, reason: collision with root package name */
    public static final DownsampleStrategy f31789f;

    /* renamed from: g, reason: collision with root package name */
    public static final DownsampleStrategy f31790g;

    /* renamed from: h, reason: collision with root package name */
    public static final com.bumptech.glide.load.d<DownsampleStrategy> f31791h;

    /* renamed from: i, reason: collision with root package name */
    static final boolean f31792i;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class a extends DownsampleStrategy {
        a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i3, int i16, int i17, int i18) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i3, int i16, int i17, int i18) {
            if (Math.min(i16 / i18, i3 / i17) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class b extends DownsampleStrategy {
        b() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i3, int i16, int i17, int i18) {
            return SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i3, int i16, int i17, int i18) {
            int ceil = (int) Math.ceil(Math.max(i16 / i18, i3 / i17));
            int i19 = 1;
            if (Math.max(1, Integer.highestOneBit(ceil)) >= ceil) {
                i19 = 0;
            }
            return 1.0f / (r2 << i19);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class c extends DownsampleStrategy {
        c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i3, int i16, int i17, int i18) {
            if (b(i3, i16, i17, i18) == 1.0f) {
                return SampleSizeRounding.QUALITY;
            }
            return DownsampleStrategy.f31786c.a(i3, i16, i17, i18);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i3, int i16, int i17, int i18) {
            return Math.min(1.0f, DownsampleStrategy.f31786c.b(i3, i16, i17, i18));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class d extends DownsampleStrategy {
        d() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i3, int i16, int i17, int i18) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i3, int i16, int i17, int i18) {
            return Math.max(i17 / i3, i18 / i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class e extends DownsampleStrategy {
        e() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i3, int i16, int i17, int i18) {
            if (DownsampleStrategy.f31792i) {
                return SampleSizeRounding.QUALITY;
            }
            return SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i3, int i16, int i17, int i18) {
            if (DownsampleStrategy.f31792i) {
                return Math.min(i17 / i3, i18 / i16);
            }
            if (Math.max(i16 / i18, i3 / i17) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class f extends DownsampleStrategy {
        f() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i3, int i16, int i17, int i18) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i3, int i16, int i17, int i18) {
            return 1.0f;
        }
    }

    static {
        d dVar = new d();
        f31788e = dVar;
        f31789f = new f();
        f31790g = dVar;
        f31791h = com.bumptech.glide.load.d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
        f31792i = true;
    }

    public abstract SampleSizeRounding a(int i3, int i16, int i17, int i18);

    public abstract float b(int i3, int i16, int i17, int i18);
}

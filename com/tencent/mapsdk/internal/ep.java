package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mapsdk.internal.en;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ep extends en {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "detail")
    public a f148258a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends en.a {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "styleTable")
        public C7036a f148259a;

        /* compiled from: P */
        /* renamed from: com.tencent.mapsdk.internal.ep$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static class C7036a extends en.c {

            /* renamed from: a, reason: collision with root package name */
            @Json(name = "theme")
            public b f148260a;

            /* renamed from: b, reason: collision with root package name */
            @Json(name = "control")
            public C7037a f148261b;

            /* compiled from: P */
            /* renamed from: com.tencent.mapsdk.internal.ep$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public static final class C7037a extends en.c.a {

                /* renamed from: a, reason: collision with root package name */
                @Json(name = "maxIntensity")
                public double f148262a;

                /* renamed from: b, reason: collision with root package name */
                @Json(name = "minIntensity")
                public double f148263b;

                /* renamed from: c, reason: collision with root package name */
                @Json(name = "enable3D")
                public boolean f148264c;

                /* renamed from: d, reason: collision with root package name */
                @Json(name = "heightRange")
                public List<Double> f148265d;

                /* renamed from: e, reason: collision with root package name */
                @Json(name = "animated")
                public boolean f148266e;

                @Override // com.tencent.mapsdk.internal.en.c.a
                public final boolean a() {
                    List<Double> list;
                    if (super.a() && (list = this.f148265d) != null && list.size() > 0) {
                        return true;
                    }
                    return false;
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mapsdk.internal.ep$a$a$b */
            /* loaded from: classes9.dex */
            public static class b extends JsonComposer {

                /* renamed from: a, reason: collision with root package name */
                @Json(name = KuiklyLaunchParams.SPLIT_MODE_LAUNCH_MODE_STANDARD)
                public C7039b f148267a;

                /* compiled from: P */
                /* renamed from: com.tencent.mapsdk.internal.ep$a$a$b$a, reason: collision with other inner class name */
                /* loaded from: classes9.dex */
                public static final class C7038a extends en.c.AbstractC7031c {

                    /* renamed from: a, reason: collision with root package name */
                    @Json(name = "radius")
                    public int f148268a;

                    /* renamed from: b, reason: collision with root package name */
                    @Json(name = "gradient")
                    public en.c.e f148269b;

                    /* renamed from: c, reason: collision with root package name */
                    @Json(name = "animation")
                    public en.c.d f148270c;

                    private boolean a() {
                        en.c.e eVar;
                        boolean z16;
                        en.c.d dVar;
                        boolean z17;
                        List<Integer> list;
                        if (this.f148268a > 0 && (eVar = this.f148269b) != null) {
                            List<Double> list2 = eVar.f148241a;
                            if (list2 != null && list2.size() > 0 && (list = eVar.f148242b) != null && list.size() > 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16 && (dVar = this.f148270c) != null) {
                                if (dVar.f148240c >= 0.0d) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                if (z17) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                }

                /* compiled from: P */
                /* renamed from: com.tencent.mapsdk.internal.ep$a$a$b$b, reason: collision with other inner class name */
                /* loaded from: classes9.dex */
                public static class C7039b extends JsonComposer {

                    /* renamed from: a, reason: collision with root package name */
                    @Json(name = "defaultStyle")
                    public C7038a f148271a;

                    /* JADX WARN: Removed duplicated region for block: B:25:0x003d A[RETURN] */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    private boolean a() {
                        boolean z16;
                        en.c.e eVar;
                        boolean z17;
                        en.c.d dVar;
                        boolean z18;
                        List<Integer> list;
                        C7038a c7038a = this.f148271a;
                        if (c7038a != null) {
                            if (c7038a.f148268a > 0 && (eVar = c7038a.f148269b) != null) {
                                List<Double> list2 = eVar.f148241a;
                                if (list2 != null && list2.size() > 0 && (list = eVar.f148242b) != null && list.size() > 0) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                if (z17 && (dVar = c7038a.f148270c) != null) {
                                    if (dVar.f148240c >= 0.0d) {
                                        z18 = true;
                                    } else {
                                        z18 = false;
                                    }
                                    if (z18) {
                                        z16 = true;
                                        if (!z16) {
                                            return true;
                                        }
                                    }
                                }
                            }
                            z16 = false;
                            if (!z16) {
                            }
                        }
                        return false;
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:27:0x0041  */
                /* JADX WARN: Removed duplicated region for block: B:29:0x0046 A[RETURN] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                private boolean a() {
                    boolean z16;
                    boolean z17;
                    en.c.e eVar;
                    boolean z18;
                    en.c.d dVar;
                    boolean z19;
                    List<Integer> list;
                    C7039b c7039b = this.f148267a;
                    if (c7039b != null) {
                        C7038a c7038a = c7039b.f148271a;
                        if (c7038a != null) {
                            if (c7038a.f148268a > 0 && (eVar = c7038a.f148269b) != null) {
                                List<Double> list2 = eVar.f148241a;
                                if (list2 != null && list2.size() > 0 && (list = eVar.f148242b) != null && list.size() > 0) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                if (z18 && (dVar = c7038a.f148270c) != null) {
                                    if (dVar.f148240c >= 0.0d) {
                                        z19 = true;
                                    } else {
                                        z19 = false;
                                    }
                                    if (z19) {
                                        z17 = true;
                                        if (z17) {
                                            z16 = true;
                                            if (!z16) {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                            z17 = false;
                            if (z17) {
                            }
                        }
                        z16 = false;
                        if (!z16) {
                        }
                    }
                    return false;
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:31:0x004b  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x0050  */
            @Override // com.tencent.mapsdk.internal.en.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final boolean a() {
                b bVar;
                boolean z16;
                C7037a c7037a;
                boolean z17;
                boolean z18;
                en.c.e eVar;
                boolean z19;
                en.c.d dVar;
                boolean z26;
                List<Integer> list;
                if (super.a() && (bVar = this.f148260a) != null) {
                    b.C7039b c7039b = bVar.f148267a;
                    if (c7039b != null) {
                        b.C7038a c7038a = c7039b.f148271a;
                        if (c7038a != null) {
                            if (c7038a.f148268a > 0 && (eVar = c7038a.f148269b) != null) {
                                List<Double> list2 = eVar.f148241a;
                                if (list2 != null && list2.size() > 0 && (list = eVar.f148242b) != null && list.size() > 0) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                if (z19 && (dVar = c7038a.f148270c) != null) {
                                    if (dVar.f148240c >= 0.0d) {
                                        z26 = true;
                                    } else {
                                        z26 = false;
                                    }
                                    if (z26) {
                                        z18 = true;
                                        if (z18) {
                                            z17 = true;
                                            if (z17) {
                                                z16 = true;
                                                if (!z16 && (c7037a = this.f148261b) != null && c7037a.a()) {
                                                    return true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            z18 = false;
                            if (z18) {
                            }
                        }
                        z17 = false;
                        if (z17) {
                        }
                    }
                    z16 = false;
                    if (!z16) {
                    }
                }
                return false;
            }
        }

        @Override // com.tencent.mapsdk.internal.en.a
        public final boolean a() {
            C7036a c7036a;
            if (super.a() && eh.Gradient.a(this.f148209b) && (c7036a = this.f148259a) != null && c7036a.a()) {
                return true;
            }
            return false;
        }
    }

    @Override // com.tencent.mapsdk.internal.en
    public final int a() {
        if (c()) {
            return this.f148258a.f148210c.f148211a;
        }
        return 0;
    }

    @Override // com.tencent.mapsdk.internal.en
    public final int b() {
        if (c()) {
            return this.f148258a.f148259a.f148229c;
        }
        return 0;
    }

    @Override // com.tencent.mapsdk.internal.en
    public final boolean c() {
        a aVar;
        if (super.c() && (aVar = this.f148258a) != null && aVar.a()) {
            return true;
        }
        return false;
    }
}

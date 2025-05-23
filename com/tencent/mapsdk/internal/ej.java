package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mapsdk.internal.en;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ej extends en {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "detail")
    public a f148179a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends en.a {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "styleTable")
        public C7023a f148180a;

        /* compiled from: P */
        /* renamed from: com.tencent.mapsdk.internal.ej$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static class C7023a extends en.c {

            /* renamed from: a, reason: collision with root package name */
            @Json(name = "theme")
            public b f148181a;

            /* renamed from: b, reason: collision with root package name */
            @Json(name = "control")
            public C7024a f148182b;

            /* compiled from: P */
            /* renamed from: com.tencent.mapsdk.internal.ej$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public static final class C7024a extends en.c.a {

                /* renamed from: a, reason: collision with root package name */
                @Json(name = "enable3D")
                public boolean f148183a;

                /* renamed from: b, reason: collision with root package name */
                @Json(name = "animated")
                public boolean f148184b;

                /* renamed from: c, reason: collision with root package name */
                @Json(name = "animation")
                public C7025a f148185c;

                /* compiled from: P */
                /* renamed from: com.tencent.mapsdk.internal.ej$a$a$a$a, reason: collision with other inner class name */
                /* loaded from: classes9.dex */
                public static class C7025a extends JsonComposer {

                    /* renamed from: a, reason: collision with root package name */
                    @Json(name = "highlightDuration")
                    public double f148186a;

                    /* renamed from: b, reason: collision with root package name */
                    @Json(name = "highlightColor")
                    public int f148187b;

                    /* renamed from: c, reason: collision with root package name */
                    @Json(name = "duration")
                    public double f148188c;
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mapsdk.internal.ej$a$a$b */
            /* loaded from: classes9.dex */
            public static class b extends JsonComposer {

                /* renamed from: a, reason: collision with root package name */
                @Json(name = KuiklyLaunchParams.SPLIT_MODE_LAUNCH_MODE_STANDARD)
                public C7028b f148189a;

                /* compiled from: P */
                /* renamed from: com.tencent.mapsdk.internal.ej$a$a$b$a, reason: collision with other inner class name */
                /* loaded from: classes9.dex */
                public static final class C7026a extends en.c.AbstractC7031c {

                    /* renamed from: a, reason: collision with root package name */
                    @Json(name = "width")
                    public int f148190a;

                    /* renamed from: b, reason: collision with root package name */
                    @Json(name = "radian")
                    public double f148191b;

                    /* renamed from: c, reason: collision with root package name */
                    @Json(name = "gradient")
                    public en.c.e f148192c;

                    /* renamed from: d, reason: collision with root package name */
                    @Json(name = "animation")
                    public C7027a f148193d;

                    /* compiled from: P */
                    /* renamed from: com.tencent.mapsdk.internal.ej$a$a$b$a$a, reason: collision with other inner class name */
                    /* loaded from: classes9.dex */
                    public static final class C7027a extends en.c.d {

                        /* renamed from: a, reason: collision with root package name */
                        @Json(name = "highlightDuration")
                        public double f148194a;

                        /* renamed from: b, reason: collision with root package name */
                        @Json(name = "highlightColor")
                        public int f148195b;
                    }
                }

                /* compiled from: P */
                /* renamed from: com.tencent.mapsdk.internal.ej$a$a$b$b, reason: collision with other inner class name */
                /* loaded from: classes9.dex */
                public static class C7028b extends JsonComposer {

                    /* renamed from: a, reason: collision with root package name */
                    @Json(name = "defaultStyle")
                    public C7026a f148196a;
                }
            }
        }

        @Override // com.tencent.mapsdk.internal.en.a
        public final boolean a() {
            C7023a c7023a;
            if (super.a() && eh.ArcLine.a(this.f148209b) && (c7023a = this.f148180a) != null && c7023a.a()) {
                return true;
            }
            return false;
        }
    }

    @Override // com.tencent.mapsdk.internal.en
    public final int a() {
        if (c()) {
            return this.f148179a.f148210c.f148211a;
        }
        return 0;
    }

    @Override // com.tencent.mapsdk.internal.en
    public final int b() {
        if (c()) {
            return this.f148179a.f148180a.f148229c;
        }
        return 0;
    }

    @Override // com.tencent.mapsdk.internal.en
    public final boolean c() {
        a aVar;
        if (super.c() && (aVar = this.f148179a) != null && aVar.a()) {
            return true;
        }
        return false;
    }
}

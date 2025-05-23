package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mapsdk.internal.en;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ei extends en {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "detail")
    public a f148163a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends en.a {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "styleTable")
        public C7019a f148164a;

        /* compiled from: P */
        /* renamed from: com.tencent.mapsdk.internal.ei$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static class C7019a extends en.c {

            /* renamed from: a, reason: collision with root package name */
            @Json(name = "theme")
            public b f148165a;

            /* renamed from: b, reason: collision with root package name */
            @Json(name = "control")
            public C7020a f148166b;

            /* compiled from: P */
            /* renamed from: com.tencent.mapsdk.internal.ei$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public static final class C7020a extends en.c.a {

                /* renamed from: a, reason: collision with root package name */
                @Json(name = "maxIntensity")
                public double f148167a;

                /* renamed from: b, reason: collision with root package name */
                @Json(name = "minIntensity")
                public double f148168b;

                /* renamed from: c, reason: collision with root package name */
                @Json(name = "enable3D")
                public boolean f148169c;

                /* renamed from: d, reason: collision with root package name */
                @Json(name = "heightRange")
                public List<Double> f148170d;

                /* renamed from: e, reason: collision with root package name */
                @Json(name = "animated")
                public boolean f148171e;

                @Override // com.tencent.mapsdk.internal.en.c.a
                public final boolean a() {
                    List<Double> list;
                    if (super.a() && (list = this.f148170d) != null && list.size() > 0) {
                        return true;
                    }
                    return false;
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mapsdk.internal.ei$a$a$b */
            /* loaded from: classes9.dex */
            public static class b extends JsonComposer {

                /* renamed from: a, reason: collision with root package name */
                @Json(name = KuiklyLaunchParams.SPLIT_MODE_LAUNCH_MODE_STANDARD)
                public C7022b f148172a;

                /* compiled from: P */
                /* renamed from: com.tencent.mapsdk.internal.ei$a$a$b$a, reason: collision with other inner class name */
                /* loaded from: classes9.dex */
                public static final class C7021a extends en.c.AbstractC7031c {

                    /* renamed from: a, reason: collision with root package name */
                    @Json(name = "gap")
                    public int f148173a;

                    /* renamed from: b, reason: collision with root package name */
                    @Json(name = "radius")
                    public int f148174b;

                    /* renamed from: c, reason: collision with root package name */
                    @Json(name = "shapeType")
                    public String f148175c;

                    /* renamed from: d, reason: collision with root package name */
                    @Json(name = "gradient")
                    public en.c.e f148176d;

                    /* renamed from: e, reason: collision with root package name */
                    @Json(name = "animation")
                    public en.c.d f148177e;
                }

                /* compiled from: P */
                /* renamed from: com.tencent.mapsdk.internal.ei$a$a$b$b, reason: collision with other inner class name */
                /* loaded from: classes9.dex */
                public static class C7022b extends JsonComposer {

                    /* renamed from: a, reason: collision with root package name */
                    @Json(name = "defaultStyle")
                    public C7021a f148178a;
                }
            }

            @Override // com.tencent.mapsdk.internal.en.c
            public final boolean a() {
                if (super.a() && this.f148165a != null && this.f148166b != null) {
                    return true;
                }
                return false;
            }
        }

        @Override // com.tencent.mapsdk.internal.en.a
        public final boolean a() {
            C7019a c7019a;
            if (super.a() && eh.Aggregation.a(this.f148209b) && (c7019a = this.f148164a) != null && c7019a.a()) {
                return true;
            }
            return false;
        }
    }

    @Override // com.tencent.mapsdk.internal.en
    public final int a() {
        if (c()) {
            return this.f148163a.f148210c.f148211a;
        }
        return 0;
    }

    @Override // com.tencent.mapsdk.internal.en
    public final int b() {
        if (c()) {
            return this.f148163a.f148164a.f148229c;
        }
        return 0;
    }

    @Override // com.tencent.mapsdk.internal.en
    public final boolean c() {
        a aVar;
        if (super.c() && (aVar = this.f148163a) != null && aVar.a()) {
            return true;
        }
        return false;
    }
}

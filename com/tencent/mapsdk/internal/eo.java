package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mapsdk.internal.en;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngDeserializer;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngListDeserializer;
import cooperation.qzone.report.QZonePushReporter;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class eo extends en {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "detail")
    public a f148244a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends en.a {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "styleTable")
        public C7032a f148245a;

        /* compiled from: P */
        /* renamed from: com.tencent.mapsdk.internal.eo$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static class C7032a extends en.c {

            /* renamed from: a, reason: collision with root package name */
            @Json(name = "theme")
            public b f148246a;

            /* renamed from: b, reason: collision with root package name */
            @Json(name = "control")
            public C7033a f148247b;

            /* compiled from: P */
            /* renamed from: com.tencent.mapsdk.internal.eo$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public static final class C7033a extends en.c.a {
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mapsdk.internal.eo$a$a$b */
            /* loaded from: classes9.dex */
            public static class b extends JsonComposer {

                /* renamed from: a, reason: collision with root package name */
                @Json(name = KuiklyLaunchParams.SPLIT_MODE_LAUNCH_MODE_STANDARD)
                public C7035b f148248a;

                /* compiled from: P */
                /* renamed from: com.tencent.mapsdk.internal.eo$a$a$b$a, reason: collision with other inner class name */
                /* loaded from: classes9.dex */
                public static final class C7034a extends en.c.AbstractC7031c {

                    /* renamed from: a, reason: collision with root package name */
                    @Json(deserializer = LatLngDeserializer.class, name = "position")
                    public LatLng f148249a;

                    /* renamed from: b, reason: collision with root package name */
                    @Json(name = CanvasView.ACTION_ROTATE)
                    public List<Double> f148250b;

                    /* renamed from: c, reason: collision with root package name */
                    @Json(name = "scale")
                    public double f148251c;

                    /* renamed from: d, reason: collision with root package name */
                    @Json(name = "autoScale")
                    public boolean f148252d;

                    /* renamed from: e, reason: collision with root package name */
                    @Json(name = "pixelBound")
                    public List<Integer> f148253e;

                    /* renamed from: f, reason: collision with root package name */
                    @Json(deserializer = LatLngListDeserializer.class, name = "pedestal")
                    public List<LatLng> f148254f;

                    /* renamed from: g, reason: collision with root package name */
                    @Json(name = "animation")
                    public en.c.f f148255g;

                    /* renamed from: h, reason: collision with root package name */
                    @Json(name = QZonePushReporter.EVENT_CODE_TYPE2_PUSH_EXPOSURE)
                    public double f148256h;
                }

                /* compiled from: P */
                /* renamed from: com.tencent.mapsdk.internal.eo$a$a$b$b, reason: collision with other inner class name */
                /* loaded from: classes9.dex */
                public static class C7035b extends JsonComposer {

                    /* renamed from: a, reason: collision with root package name */
                    @Json(name = "defaultStyle")
                    public C7034a f148257a;
                }
            }

            @Override // com.tencent.mapsdk.internal.en.c
            public final boolean a() {
                if (super.a() && this.f148246a != null && this.f148247b != null) {
                    return true;
                }
                return false;
            }
        }

        @Override // com.tencent.mapsdk.internal.en.a
        public final boolean a() {
            C7032a c7032a;
            if (super.a() && eh.GLModel.a(this.f148209b) && (c7032a = this.f148245a) != null && c7032a.a()) {
                return true;
            }
            return false;
        }
    }

    @Override // com.tencent.mapsdk.internal.en
    public final int a() {
        if (c()) {
            return this.f148244a.f148210c.f148211a;
        }
        return 0;
    }

    @Override // com.tencent.mapsdk.internal.en
    public final int b() {
        if (c()) {
            return this.f148244a.f148245a.f148229c;
        }
        return 0;
    }

    @Override // com.tencent.mapsdk.internal.en
    public final boolean c() {
        a aVar;
        if (super.c() && (aVar = this.f148244a) != null && aVar.a()) {
            return true;
        }
        return false;
    }
}

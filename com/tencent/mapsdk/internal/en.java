package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.map.tools.json.annotation.JsonType;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngDeserializer;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngListDeserializer;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class en extends JsonComposer {

    /* renamed from: b, reason: collision with root package name */
    @Json(name = "info")
    public b f148208b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends JsonComposer {

        /* renamed from: b, reason: collision with root package name */
        @Json(name = "layerType")
        public String f148209b;

        /* renamed from: c, reason: collision with root package name */
        @Json(name = "data")
        public C7029a f148210c;

        /* compiled from: P */
        /* renamed from: com.tencent.mapsdk.internal.en$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static class C7029a extends JsonComposer {

            /* renamed from: a, reason: collision with root package name */
            @Json(name = "version")
            public int f148211a;

            /* renamed from: b, reason: collision with root package name */
            @Json(name = "default")
            public List<AbstractC7030a> f148212b;

            /* compiled from: P */
            @JsonType(deserializer = ek.class)
            /* renamed from: com.tencent.mapsdk.internal.en$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public static abstract class AbstractC7030a extends JsonComposer {

                /* renamed from: a, reason: collision with root package name */
                @Json(name = "type")
                public String f148213a;

                /* renamed from: b, reason: collision with root package name */
                public String f148214b;
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mapsdk.internal.en$a$a$b */
            /* loaded from: classes9.dex */
            public static class b extends AbstractC7030a {

                /* renamed from: c, reason: collision with root package name */
                @Json(deserializer = LatLngListDeserializer.class, name = "coordinates")
                public List<LatLng> f148215c;

                /* renamed from: d, reason: collision with root package name */
                @Json(name = "weight")
                public int f148216d;
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mapsdk.internal.en$a$a$c */
            /* loaded from: classes9.dex */
            public static class c extends AbstractC7030a {

                /* renamed from: c, reason: collision with root package name */
                @Json(name = "url")
                public String f148217c;

                /* renamed from: d, reason: collision with root package name */
                @Json(name = "astcUrl")
                public String f148218d;

                /* renamed from: e, reason: collision with root package name */
                @Json(name = "ktx2Url")
                public String f148219e;

                /* renamed from: f, reason: collision with root package name */
                @Json(name = "format")
                public String f148220f;

                /* renamed from: g, reason: collision with root package name */
                @Json(name = "name")
                public String f148221g;

                /* renamed from: h, reason: collision with root package name */
                @Json(name = "targetName")
                public String f148222h;

                /* renamed from: i, reason: collision with root package name */
                @Json(name = "id")
                public String f148223i;
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mapsdk.internal.en$a$a$d */
            /* loaded from: classes9.dex */
            public static class d extends AbstractC7030a {

                /* renamed from: c, reason: collision with root package name */
                @Json(deserializer = LatLngDeserializer.class, name = "coordinates")
                public LatLng f148224c;

                /* renamed from: d, reason: collision with root package name */
                @Json(name = "weight")
                public int f148225d;
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mapsdk.internal.en$a$a$e */
            /* loaded from: classes9.dex */
            public static class e extends AbstractC7030a {

                /* renamed from: c, reason: collision with root package name */
                @Json(deserializer = eq.class, name = "coordinates")
                public List<WeightedLatLng> f148226c;
            }

            private boolean a() {
                List<AbstractC7030a> list = this.f148212b;
                if (list != null && list.size() > 0) {
                    return true;
                }
                return false;
            }
        }

        public boolean a() {
            boolean z16;
            C7029a c7029a = this.f148210c;
            if (c7029a != null) {
                List<C7029a.AbstractC7030a> list = c7029a.f148212b;
                if (list != null && list.size() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b extends JsonComposer {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "error")
        public int f148227a;

        /* renamed from: b, reason: collision with root package name */
        @Json(name = "msg")
        public String f148228b;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class c extends JsonComposer {

        /* renamed from: c, reason: collision with root package name */
        @Json(name = "version")
        public int f148229c;

        /* renamed from: d, reason: collision with root package name */
        @Json(name = "mapping")
        public b f148230d;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static abstract class a extends JsonComposer {

            /* renamed from: f, reason: collision with root package name */
            @Json(name = "displayLevel")
            public int f148231f;

            /* renamed from: g, reason: collision with root package name */
            @Json(name = NodeProps.Z_INDEX)
            public int f148232g;

            /* renamed from: h, reason: collision with root package name */
            @Json(name = "hidden")
            public boolean f148233h;

            /* renamed from: i, reason: collision with root package name */
            @Json(name = "opacity")
            public double f148234i;

            /* renamed from: j, reason: collision with root package name */
            @Json(name = "maxZoom")
            public int f148235j;

            /* renamed from: k, reason: collision with root package name */
            @Json(name = "minZoom")
            public int f148236k;

            /* renamed from: l, reason: collision with root package name */
            @Json(name = "themeName")
            public String f148237l;

            public boolean a() {
                return true;
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static class b extends JsonComposer {

            /* renamed from: a, reason: collision with root package name */
            @Json(name = TransferConfig.ExtendParamFloats.KEY_RULE)
            public a f148238a;

            /* compiled from: P */
            /* loaded from: classes9.dex */
            public static class a extends JsonComposer {

                /* renamed from: a, reason: collision with root package name */
                @Json(name = "default")
                public String f148239a;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mapsdk.internal.en$c$c, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static abstract class AbstractC7031c extends JsonComposer {
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static class d extends JsonComposer {

            /* renamed from: c, reason: collision with root package name */
            @Json(name = "duration")
            public double f148240c;

            private boolean a() {
                if (this.f148240c >= 0.0d) {
                    return true;
                }
                return false;
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static class e extends JsonComposer {

            /* renamed from: a, reason: collision with root package name */
            @Json(name = "points")
            public List<Double> f148241a;

            /* renamed from: b, reason: collision with root package name */
            @Json(name = NodeProps.COLORS)
            public List<Integer> f148242b;

            private boolean a() {
                List<Integer> list;
                List<Double> list2 = this.f148241a;
                if (list2 != null && list2.size() > 0 && (list = this.f148242b) != null && list.size() > 0) {
                    return true;
                }
                return false;
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static class f extends JsonComposer {

            /* renamed from: a, reason: collision with root package name */
            @Json(name = "type")
            public int f148243a;

            private static boolean a() {
                return true;
            }
        }

        public boolean a() {
            return true;
        }
    }

    public abstract int a();

    public abstract int b();

    public boolean c() {
        b bVar = this.f148208b;
        if (bVar != null && bVar.f148227a == 0) {
            return true;
        }
        return false;
    }
}

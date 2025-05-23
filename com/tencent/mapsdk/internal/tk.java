package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.map.lib.callbacks.TileOverlayCallback;
import com.tencent.map.lib.models.AggregationOverlayInfo;
import com.tencent.map.lib.models.AnnocationText;
import com.tencent.map.lib.models.AnnocationTextResult;
import com.tencent.map.lib.models.ArcLineOverlayInfo;
import com.tencent.map.lib.models.CircleInfo;
import com.tencent.map.lib.models.CityTrafficInfo;
import com.tencent.map.lib.models.DataSource;
import com.tencent.map.lib.models.GLModelInfo;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.GroundOverlayInfo;
import com.tencent.map.lib.models.HeatmapInfo;
import com.tencent.map.lib.models.IndoorCellInfo;
import com.tencent.map.lib.models.IntersectionOverlayInfo;
import com.tencent.map.lib.models.MapTileID;
import com.tencent.map.lib.models.MarkerInfo;
import com.tencent.map.lib.models.MaskLayer;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.map.lib.models.ScatterPlotInfo;
import com.tencent.map.lib.models.TrailOverlayInfo;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.engine.jni.JNI;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.mapsdk.internal.lb;
import com.tencent.mapsdk.internal.ne;
import com.tencent.mapsdk.internal.qv;
import com.tencent.mapsdk.internal.v;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.LightColor;
import com.tencent.tencentmap.mapsdk.maps.model.LightDirection;
import com.tencent.tencentmap.mapsdk.maps.model.LightType;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficStyle;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatAggregationUnit;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class tk implements bs, bu, os, ot, ox, oz, pb, pc, pd, pe {

    /* renamed from: a, reason: collision with root package name */
    public static final int f150501a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f150502b = -1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f150503c = -9;

    /* renamed from: n, reason: collision with root package name */
    private static final int f150504n = 256;

    /* renamed from: o, reason: collision with root package name */
    private static final int f150505o = -14803236;

    /* renamed from: p, reason: collision with root package name */
    private static final int f150506p = -13752731;

    /* renamed from: q, reason: collision with root package name */
    private static final int f150507q = -15611905;

    /* renamed from: r, reason: collision with root package name */
    private static final int f150508r = -14650226;

    /* renamed from: s, reason: collision with root package name */
    private static final int f150509s = -11088785;

    /* renamed from: t, reason: collision with root package name */
    private static final int f150510t = -9906011;

    /* renamed from: u, reason: collision with root package name */
    private static final int f150511u = -11635864;

    /* renamed from: v, reason: collision with root package name */
    private static final int f150512v = -16777063;

    /* renamed from: w, reason: collision with root package name */
    private static final int f150513w = -16777063;

    /* renamed from: d, reason: collision with root package name */
    public JNI f150514d;

    /* renamed from: e, reason: collision with root package name */
    public volatile long f150515e;

    /* renamed from: f, reason: collision with root package name */
    public op f150516f;

    /* renamed from: g, reason: collision with root package name */
    public lw f150517g;

    /* renamed from: h, reason: collision with root package name */
    public final lv f150518h;

    /* renamed from: i, reason: collision with root package name */
    public ox f150519i;

    /* renamed from: j, reason: collision with root package name */
    public ne f150520j;

    /* renamed from: k, reason: collision with root package name */
    long f150521k;

    /* renamed from: l, reason: collision with root package name */
    public long f150522l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f150523m;

    /* renamed from: x, reason: collision with root package name */
    private float f150524x;

    /* renamed from: y, reason: collision with root package name */
    private String f150525y;

    /* renamed from: z, reason: collision with root package name */
    private final ReentrantLock f150526z;

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$101, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass101 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PolygonInfo f150532a;

        public AnonymousClass101(PolygonInfo polygonInfo) {
            this.f150532a = polygonInfo;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            JNI jni = tkVar.f150514d;
            long j3 = tkVar.f150515e;
            PolygonInfo polygonInfo = this.f150532a;
            jni.nativeUpdatePolygon(j3, polygonInfo.polygonId, polygonInfo.borderLineId, polygonInfo);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$103, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass103 implements CallbackRunnable<Boolean> {
        public AnonymousClass103() {
        }

        private Boolean a() {
            tk tkVar = tk.this;
            return Boolean.valueOf(tkVar.f150514d.nativeDrawFrame(tkVar.f150515e));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Boolean run() {
            tk tkVar = tk.this;
            return Boolean.valueOf(tkVar.f150514d.nativeDrawFrame(tkVar.f150515e));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$104, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass104 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150537a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f150538b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f150539c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int[] f150540d;

        public AnonymousClass104(int i3, int i16, boolean z16, int[] iArr) {
            this.f150537a = i3;
            this.f150538b = i16;
            this.f150539c = z16;
            this.f150540d = iArr;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0 && this.f150537a >= 0) {
                tk tkVar = tk.this;
                if (tkVar.f150520j != null) {
                    tkVar.f150514d.nativeSetPolygonHidden(tkVar.f150515e, this.f150537a, this.f150538b, this.f150539c, this.f150540d);
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$105, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass105 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150542a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f150543b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int[] f150544c;

        public AnonymousClass105(int i3, int i16, int[] iArr) {
            this.f150542a = i3;
            this.f150543b = i16;
            this.f150544c = iArr;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0 && this.f150542a >= 0) {
                tk tkVar = tk.this;
                if (tkVar.f150520j != null) {
                    tkVar.f150514d.nativeDeletePolygon(tkVar.f150515e, this.f150542a, this.f150543b, this.f150544c);
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$106, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass106 implements CallbackRunnable<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaskLayer f150546a;

        public AnonymousClass106(MaskLayer maskLayer) {
            this.f150546a = maskLayer;
        }

        private Integer a() {
            if (tk.this.f150515e == 0) {
                return 0;
            }
            tk tkVar = tk.this;
            return Integer.valueOf(tkVar.f150514d.nativeAddMaskLayer(tkVar.f150515e, this.f150546a));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Integer run() {
            if (tk.this.f150515e == 0) {
                return 0;
            }
            tk tkVar = tk.this;
            return Integer.valueOf(tkVar.f150514d.nativeAddMaskLayer(tkVar.f150515e, this.f150546a));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$107, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass107 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150548a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f150549b;

        public AnonymousClass107(int i3, int i16) {
            this.f150548a = i3;
            this.f150549b = i16;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeUpdateMaskLayer(tkVar.f150515e, this.f150548a, this.f150549b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$108, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass108 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150551a;

        public AnonymousClass108(int i3) {
            this.f150551a = i3;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeRemoveMaskLayer(tkVar.f150515e, this.f150551a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$109, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass109 implements CallbackRunnable<GeoPoint> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f150553a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f150554b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f150555c;

        public AnonymousClass109(byte[] bArr, float f16, float f17) {
            this.f150553a = bArr;
            this.f150554b = f16;
            this.f150555c = f17;
        }

        private GeoPoint a() {
            if (tk.this.f150515e == 0) {
                return new GeoPoint();
            }
            double[] dArr = new double[2];
            tk tkVar = tk.this;
            tkVar.f150514d.nativeFromScreenLocation(tkVar.f150515e, this.f150553a, this.f150554b, this.f150555c, dArr);
            return new GeoPoint((int) (dArr[1] * 1000000.0d), (int) (dArr[0] * 1000000.0d));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ GeoPoint run() {
            if (tk.this.f150515e == 0) {
                return new GeoPoint();
            }
            double[] dArr = new double[2];
            tk tkVar = tk.this;
            tkVar.f150514d.nativeFromScreenLocation(tkVar.f150515e, this.f150553a, this.f150554b, this.f150555c, dArr);
            return new GeoPoint((int) (dArr[1] * 1000000.0d), (int) (dArr[0] * 1000000.0d));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$112, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass112 implements CallbackRunnable<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f150565a;

        public AnonymousClass112(String str) {
            this.f150565a = str;
        }

        private Boolean a() {
            if (tk.this.f150515e == 0) {
                return Boolean.FALSE;
            }
            tk tkVar = tk.this;
            return Boolean.valueOf(tkVar.f150514d.nativeHasStreetRoad(tkVar.f150515e, this.f150565a));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Boolean run() {
            if (tk.this.f150515e == 0) {
                return Boolean.FALSE;
            }
            tk tkVar = tk.this;
            return Boolean.valueOf(tkVar.f150514d.nativeHasStreetRoad(tkVar.f150515e, this.f150565a));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$117, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass117 implements ne.a {
        public AnonymousClass117() {
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeShowTraffic(tkVar.f150515e);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$118, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass118 implements ne.a {
        public AnonymousClass118() {
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeHideTraffic(tkVar.f150515e);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$12, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass12 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f150576a;

        public AnonymousClass12(float f16) {
            this.f150576a = f16;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (0 == tk.this.f150515e) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeSetRotate(tkVar.f150515e, this.f150576a, false);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$120, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass120 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f150578a;

        public AnonymousClass120(String str) {
            this.f150578a = str;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeUpdateMapResource(tkVar.f150515e, this.f150578a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$121, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass121 implements CallbackRunnable<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ qv f150580a;

        public AnonymousClass121(qv qvVar) {
            this.f150580a = qvVar;
        }

        private Integer a() {
            qv qvVar = this.f150580a;
            if (qvVar == null) {
                return -1;
            }
            int i3 = qvVar.f149943s;
            if (i3 != -1) {
                return Integer.valueOf(i3);
            }
            return Integer.valueOf(tk.a(tk.this, qvVar));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Integer run() {
            qv qvVar = this.f150580a;
            if (qvVar == null) {
                return -1;
            }
            int i3 = qvVar.f149943s;
            if (i3 != -1) {
                return Integer.valueOf(i3);
            }
            return Integer.valueOf(tk.a(tk.this, qvVar));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$122, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass122 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ qv f150582a;

        public AnonymousClass122(qv qvVar) {
            this.f150582a = qvVar;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            qv qvVar = this.f150582a;
            if (qvVar != null && qvVar.f149943s != -1) {
                tk.a(tk.this, qvVar);
                tk tkVar = tk.this;
                qv qvVar2 = this.f150582a;
                if (tkVar.f150515e != 0) {
                    tkVar.a(new AnonymousClass129(qvVar2));
                }
                tk tkVar2 = tk.this;
                tkVar2.a(new AnonymousClass128(this.f150582a));
                tk tkVar3 = tk.this;
                qv qvVar3 = this.f150582a;
                if (tkVar3.f150515e != 0) {
                    tkVar3.a(new AnonymousClass130(qvVar3));
                }
                qv qvVar4 = this.f150582a;
                if (qvVar4.f149938b.E) {
                    tk tkVar4 = tk.this;
                    if (tkVar4.f150515e != 0) {
                        tkVar4.a(new AnonymousClass134(qvVar4));
                    }
                } else {
                    tk tkVar5 = tk.this;
                    if (tkVar5.f150515e != 0) {
                        tkVar5.a(new AnonymousClass133(qvVar4));
                    }
                }
                tk tkVar6 = tk.this;
                qv qvVar5 = this.f150582a;
                if (tkVar6.f150515e != 0) {
                    tkVar6.a(new AnonymousClass132(qvVar5));
                }
                if (!hs.a(this.f150582a.f149938b.H)) {
                    tk tkVar7 = tk.this;
                    qv qvVar6 = this.f150582a;
                    if (tkVar7.f150515e != 0) {
                        tkVar7.a(new AnonymousClass131(qvVar6));
                    }
                }
                tk tkVar8 = tk.this;
                tkVar8.a(new AnonymousClass37(this.f150582a));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$123, reason: invalid class name */
    /* loaded from: classes9.dex */
    public final class AnonymousClass123 implements CallbackRunnable<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ qv f150584a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f150585b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f150586c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f150587d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int[] f150588e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int[] f150589f;

        AnonymousClass123(qv qvVar, int i3, boolean z16, boolean z17, int[] iArr, int[] iArr2) {
            this.f150584a = qvVar;
            this.f150585b = i3;
            this.f150586c = z16;
            this.f150587d = z17;
            this.f150588e = iArr;
            this.f150589f = iArr2;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0081  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private Integer a() {
            String str;
            ga gaVar;
            float f16;
            tk tkVar = tk.this;
            JNI jni = tkVar.f150514d;
            long j3 = tkVar.f150515e;
            qv qvVar = this.f150584a;
            int i3 = qvVar.f149943s;
            int[] iArr = qvVar.f149940p;
            int[] iArr2 = qvVar.f149939d;
            GeoPoint[] geoPointArr = (GeoPoint[]) qvVar.f149938b.f148431m.toArray(new GeoPoint[0]);
            qv qvVar2 = this.f150584a;
            ga gaVar2 = qvVar2.f149938b;
            int[] iArr3 = gaVar2.f148436r;
            if (iArr3 != null && iArr3.length > 0) {
                int i16 = iArr3[0];
                if (i16 == 33) {
                    str = ga.f148428j;
                } else if (i16 == 20) {
                    str = ga.f148429k;
                }
                String str2 = str;
                qv qvVar3 = this.f150584a;
                ga gaVar3 = qvVar3.f149938b;
                float f17 = gaVar3.f148442x;
                int i17 = this.f150585b;
                boolean z16 = this.f150586c;
                boolean z17 = this.f150587d;
                boolean z18 = gaVar3.B;
                boolean z19 = gaVar3.O;
                float zIndex = qvVar3.getZIndex();
                qv qvVar4 = this.f150584a;
                gaVar = qvVar4.f149938b;
                boolean z26 = gaVar.f148440v;
                int[] iArr4 = gaVar.f148437s;
                int[] iArr5 = this.f150588e;
                float f18 = gaVar.f148439u;
                int[] iArr6 = this.f150589f;
                if (gaVar != null) {
                    f16 = 1.0f;
                } else {
                    f16 = gaVar.A;
                }
                return Integer.valueOf(jni.nativeCreateOrUpdateLine(j3, i3, iArr, iArr2, geoPointArr, str2, f17, i17, z16, z17, z18, z19, zIndex, z26, iArr4, iArr5, f18, iArr6, f16, qvVar4.getLevel(), this.f150584a.isVisible()));
            }
            if (hs.a(gaVar2.f148443y)) {
                str = ga.f148427i;
            } else {
                str = qvVar2.f149938b.f148443y;
            }
            String str22 = str;
            qv qvVar32 = this.f150584a;
            ga gaVar32 = qvVar32.f149938b;
            float f172 = gaVar32.f148442x;
            int i172 = this.f150585b;
            boolean z162 = this.f150586c;
            boolean z172 = this.f150587d;
            boolean z182 = gaVar32.B;
            boolean z192 = gaVar32.O;
            float zIndex2 = qvVar32.getZIndex();
            qv qvVar42 = this.f150584a;
            gaVar = qvVar42.f149938b;
            boolean z262 = gaVar.f148440v;
            int[] iArr42 = gaVar.f148437s;
            int[] iArr52 = this.f150588e;
            float f182 = gaVar.f148439u;
            int[] iArr62 = this.f150589f;
            if (gaVar != null) {
            }
            return Integer.valueOf(jni.nativeCreateOrUpdateLine(j3, i3, iArr, iArr2, geoPointArr, str22, f172, i172, z162, z172, z182, z192, zIndex2, z262, iArr42, iArr52, f182, iArr62, f16, qvVar42.getLevel(), this.f150584a.isVisible()));
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0081  */
        @Override // com.tencent.map.tools.CallbackRunnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final /* synthetic */ Integer run() {
            String str;
            ga gaVar;
            float f16;
            tk tkVar = tk.this;
            JNI jni = tkVar.f150514d;
            long j3 = tkVar.f150515e;
            qv qvVar = this.f150584a;
            int i3 = qvVar.f149943s;
            int[] iArr = qvVar.f149940p;
            int[] iArr2 = qvVar.f149939d;
            GeoPoint[] geoPointArr = (GeoPoint[]) qvVar.f149938b.f148431m.toArray(new GeoPoint[0]);
            qv qvVar2 = this.f150584a;
            ga gaVar2 = qvVar2.f149938b;
            int[] iArr3 = gaVar2.f148436r;
            if (iArr3 != null && iArr3.length > 0) {
                int i16 = iArr3[0];
                if (i16 == 33) {
                    str = ga.f148428j;
                } else if (i16 == 20) {
                    str = ga.f148429k;
                }
                String str2 = str;
                qv qvVar3 = this.f150584a;
                ga gaVar3 = qvVar3.f149938b;
                float f17 = gaVar3.f148442x;
                int i17 = this.f150585b;
                boolean z16 = this.f150586c;
                boolean z17 = this.f150587d;
                boolean z18 = gaVar3.B;
                boolean z19 = gaVar3.O;
                float zIndex = qvVar3.getZIndex();
                qv qvVar4 = this.f150584a;
                gaVar = qvVar4.f149938b;
                boolean z26 = gaVar.f148440v;
                int[] iArr4 = gaVar.f148437s;
                int[] iArr5 = this.f150588e;
                float f18 = gaVar.f148439u;
                int[] iArr6 = this.f150589f;
                if (gaVar != null) {
                    f16 = 1.0f;
                } else {
                    f16 = gaVar.A;
                }
                return Integer.valueOf(jni.nativeCreateOrUpdateLine(j3, i3, iArr, iArr2, geoPointArr, str2, f17, i17, z16, z17, z18, z19, zIndex, z26, iArr4, iArr5, f18, iArr6, f16, qvVar4.getLevel(), this.f150584a.isVisible()));
            }
            if (hs.a(gaVar2.f148443y)) {
                str = ga.f148427i;
            } else {
                str = qvVar2.f149938b.f148443y;
            }
            String str22 = str;
            qv qvVar32 = this.f150584a;
            ga gaVar32 = qvVar32.f149938b;
            float f172 = gaVar32.f148442x;
            int i172 = this.f150585b;
            boolean z162 = this.f150586c;
            boolean z172 = this.f150587d;
            boolean z182 = gaVar32.B;
            boolean z192 = gaVar32.O;
            float zIndex2 = qvVar32.getZIndex();
            qv qvVar42 = this.f150584a;
            gaVar = qvVar42.f149938b;
            boolean z262 = gaVar.f148440v;
            int[] iArr42 = gaVar.f148437s;
            int[] iArr52 = this.f150588e;
            float f182 = gaVar.f148439u;
            int[] iArr62 = this.f150589f;
            if (gaVar != null) {
            }
            return Integer.valueOf(jni.nativeCreateOrUpdateLine(j3, i3, iArr, iArr2, geoPointArr, str22, f172, i172, z162, z172, z182, z192, zIndex2, z262, iArr42, iArr52, f182, iArr62, f16, qvVar42.getLevel(), this.f150584a.isVisible()));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$124, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass124 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ qv f150591a;

        public AnonymousClass124(qv qvVar) {
            this.f150591a = qvVar;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            int i3;
            if (tk.this.f150515e == 0 || (i3 = this.f150591a.f149943s) == -1) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeSetLineSelected(tkVar.f150515e, i3, this.f150591a.isSelected());
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$126, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass126 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150594a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f150595b;

        public AnonymousClass126(int i3, boolean z16) {
            this.f150594a = i3;
            this.f150595b = z16;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (this.f150594a == -1) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeDeleteLine(tkVar.f150515e, this.f150594a, this.f150595b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$128, reason: invalid class name */
    /* loaded from: classes9.dex */
    final class AnonymousClass128 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ qv f150601a;

        AnonymousClass128(qv qvVar) {
            this.f150601a = qvVar;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            qv.a aVar;
            qv qvVar = this.f150601a;
            int i3 = qvVar.f149943s;
            if (i3 == -1 || (aVar = qvVar.f149944t) == null) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeSetTurnArrow(tkVar.f150515e, i3, this.f150601a.f149938b.f148431m, aVar.f149951a, aVar.f149952b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$129, reason: invalid class name */
    /* loaded from: classes9.dex */
    final class AnonymousClass129 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ qv f150603a;

        AnonymousClass129(qv qvVar) {
            this.f150603a = qvVar;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            qv qvVar = this.f150603a;
            int i3 = qvVar.f149943s;
            if (i3 == -1) {
                return;
            }
            ga gaVar = qvVar.f149938b;
            int[] iArr = {gaVar.J, gaVar.K};
            tk tkVar = tk.this;
            tkVar.f150514d.nativeSetTurnArrowStyle(tkVar.f150515e, i3, iArr[0], iArr[1]);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$13, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass13 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150605a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f150606b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f150607c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f150608d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f150609e;

        public AnonymousClass13(int i3, int i16, int i17, int i18, int i19) {
            this.f150605a = i3;
            this.f150606b = i16;
            this.f150607c = i17;
            this.f150608d = i18;
            this.f150609e = i19;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeCheckTrafficBlockCache(tkVar.f150515e, this.f150605a, this.f150606b, this.f150607c, this.f150608d, this.f150609e);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$130, reason: invalid class name */
    /* loaded from: classes9.dex */
    final class AnonymousClass130 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ qv f150611a;

        AnonymousClass130(qv qvVar) {
            this.f150611a = qvVar;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            int i3 = this.f150611a.f149943s;
            if (i3 == -1) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeSetLineDrawArrow(tkVar.f150515e, i3, this.f150611a.f149938b.f148441w);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$131, reason: invalid class name */
    /* loaded from: classes9.dex */
    final class AnonymousClass131 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ qv f150613a;

        AnonymousClass131(qv qvVar) {
            this.f150613a = qvVar;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            int i3 = this.f150613a.f149943s;
            if (i3 == -1) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeSetLineDirectionArrowTextureName(tkVar.f150515e, i3, this.f150613a.f149938b.H);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$132, reason: invalid class name */
    /* loaded from: classes9.dex */
    final class AnonymousClass132 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ qv f150615a;

        AnonymousClass132(qv qvVar) {
            this.f150615a = qvVar;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            int i3 = this.f150615a.f149943s;
            if (i3 == -1) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeSetDrawCap(tkVar.f150515e, i3, this.f150615a.f149938b.f148444z);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$133, reason: invalid class name */
    /* loaded from: classes9.dex */
    final class AnonymousClass133 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ qv f150617a;

        AnonymousClass133(qv qvVar) {
            this.f150617a = qvVar;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            GeoPoint geoPoint;
            qv qvVar = this.f150617a;
            int i3 = qvVar.f149943s;
            if (i3 == -1 || (geoPoint = qvVar.f149942r) == null) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeLineInsertPoint(tkVar.f150515e, i3, geoPoint, this.f150617a.f149941q);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$134, reason: invalid class name */
    /* loaded from: classes9.dex */
    final class AnonymousClass134 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ qv f150619a;

        AnonymousClass134(qv qvVar) {
            this.f150619a = qvVar;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            GeoPoint geoPoint;
            qv qvVar = this.f150619a;
            int i3 = qvVar.f149943s;
            if (i3 == -1 || (geoPoint = qvVar.f149942r) == null) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeLineClearPoint(tkVar.f150515e, i3, geoPoint, this.f150619a.f149941q);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$138, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass138 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f150626a;

        public AnonymousClass138(boolean z16) {
            this.f150626a = z16;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (0 != tk.this.f150515e) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetBuilding3DEffect(tkVar.f150515e, this.f150626a);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$141, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass141 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f150637a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f150638b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f150639c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f150640d;

        public AnonymousClass141(boolean z16, boolean z17, boolean z18, boolean z19) {
            this.f150637a = z16;
            this.f150638b = z17;
            this.f150639c = z18;
            this.f150640d = z19;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetLocationFollow(tkVar.f150515e, this.f150637a, this.f150638b, this.f150639c, this.f150640d);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$143, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass143 implements ne.a {
        public AnonymousClass143() {
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeHideCompass(tkVar.f150515e);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$144, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass144 implements CallbackRunnable<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ pi f150645a;

        public AnonymousClass144(pi piVar) {
            this.f150645a = piVar;
        }

        private Integer a() {
            if (0 == tk.this.f150515e) {
                return 0;
            }
            tk tkVar = tk.this;
            JNI jni = tkVar.f150514d;
            long j3 = tkVar.f150515e;
            pi piVar = this.f150645a;
            String str = piVar.f149491f;
            String str2 = piVar.f149498m;
            double d16 = piVar.f149494i;
            double d17 = piVar.f149495j;
            float f16 = piVar.f149499n;
            float f17 = piVar.f149500o;
            float f18 = piVar.f149508w;
            float f19 = piVar.f149509x;
            float f26 = piVar.f149507v;
            float a16 = piVar.a();
            pi piVar2 = this.f150645a;
            return Integer.valueOf(jni.nativeAddMarker(j3, str, str2, d16, d17, f16, f17, f18, f19, f26, a16, piVar2.f149511z, piVar2.f149510y, piVar2.C, piVar2.D, piVar2.E, piVar2.G, piVar2.F));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Integer run() {
            if (0 == tk.this.f150515e) {
                return 0;
            }
            tk tkVar = tk.this;
            JNI jni = tkVar.f150514d;
            long j3 = tkVar.f150515e;
            pi piVar = this.f150645a;
            String str = piVar.f149491f;
            String str2 = piVar.f149498m;
            double d16 = piVar.f149494i;
            double d17 = piVar.f149495j;
            float f16 = piVar.f149499n;
            float f17 = piVar.f149500o;
            float f18 = piVar.f149508w;
            float f19 = piVar.f149509x;
            float f26 = piVar.f149507v;
            float a16 = piVar.a();
            pi piVar2 = this.f150645a;
            return Integer.valueOf(jni.nativeAddMarker(j3, str, str2, d16, d17, f16, f17, f18, f19, f26, a16, piVar2.f149511z, piVar2.f149510y, piVar2.C, piVar2.D, piVar2.E, piVar2.G, piVar2.F));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$145, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass145 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ pi f150647a;

        public AnonymousClass145(pi piVar) {
            this.f150647a = piVar;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                JNI jni = tkVar.f150514d;
                long j3 = tkVar.f150515e;
                int a16 = this.f150647a.I.a();
                pi piVar = this.f150647a;
                String str = piVar.f149491f;
                double d16 = piVar.f149494i;
                double d17 = piVar.f149495j;
                float f16 = piVar.f149499n;
                float f17 = piVar.f149500o;
                float f18 = piVar.f149508w;
                float f19 = piVar.f149509x;
                float f26 = piVar.f149507v;
                float a17 = piVar.a();
                pi piVar2 = this.f150647a;
                jni.nativeUpdateMarkerInfo(j3, a16, str, d16, d17, f16, f17, f18, f19, f26, a17, piVar2.f149511z, piVar2.f149510y, piVar2.C, piVar2.D, piVar2.E, piVar2.G, piVar2.F, piVar2.J);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$148, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass148 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f150653a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f150654b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f150655c;

        public AnonymousClass148(int[] iArr, int i3, boolean z16) {
            this.f150653a = iArr;
            this.f150654b = i3;
            this.f150655c = z16;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (0 == tk.this.f150515e) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeSetIconsHidden(tkVar.f150515e, this.f150653a, this.f150654b, this.f150655c);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$151, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass151 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f150666a;

        public AnonymousClass151(String str) {
            this.f150666a = str;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetCompassImage(tkVar.f150515e, this.f150666a);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$157, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass157 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150681a;

        public AnonymousClass157(int i3) {
            this.f150681a = i3;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeSetIndoorConfigType(tkVar.f150515e, this.f150681a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$158, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass158 implements CallbackRunnable<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f150683a;

        public AnonymousClass158(String str) {
            this.f150683a = str;
        }

        private Integer a() {
            if (tk.this.f150515e == 0) {
                return 0;
            }
            tk tkVar = tk.this;
            return Integer.valueOf(tkVar.f150514d.nativeIsCityHasTraffic(tkVar.f150515e, this.f150683a));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Integer run() {
            if (tk.this.f150515e == 0) {
                return 0;
            }
            tk tkVar = tk.this;
            return Integer.valueOf(tkVar.f150514d.nativeIsCityHasTraffic(tkVar.f150515e, this.f150683a));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$159, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass159 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150685a;

        public AnonymousClass159(int i3) {
            this.f150685a = i3;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (0 != tk.this.f150515e) {
                tk tkVar = tk.this;
                if (tkVar.f150520j != null) {
                    tkVar.f150514d.nativeSetIndoorFloor(tkVar.f150515e, this.f150685a);
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$161, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass161 implements CallbackRunnable<String[]> {
        public AnonymousClass161() {
        }

        private String[] a() {
            if (0 == tk.this.f150515e) {
                return null;
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeGetIndoorFloorNames(tkVar.f150515e);
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ String[] run() {
            if (0 == tk.this.f150515e) {
                return null;
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeGetIndoorFloorNames(tkVar.f150515e);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$162, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass162 implements CallbackRunnable<qr> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GeoPoint f150692a;

        public AnonymousClass162(GeoPoint geoPoint) {
            this.f150692a = geoPoint;
        }

        private qr a() {
            if (0 == tk.this.f150515e) {
                return null;
            }
            tk tkVar = tk.this;
            String nativeGetActiveIndoorBuildingGUID = tkVar.f150514d.nativeGetActiveIndoorBuildingGUID(tkVar.f150515e);
            tk tkVar2 = tk.this;
            String nativeGetCurIndoorName = tkVar2.f150514d.nativeGetCurIndoorName(tkVar2.f150515e, this.f150692a);
            tk tkVar3 = tk.this;
            int nativeGetIndoorCurrentFloorId = tkVar3.f150514d.nativeGetIndoorCurrentFloorId(tkVar3.f150515e);
            tk tkVar4 = tk.this;
            return new qr(nativeGetActiveIndoorBuildingGUID, nativeGetCurIndoorName, tkVar4.f150514d.nativeGetIndoorFloorNames(tkVar4.f150515e), nativeGetIndoorCurrentFloorId);
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ qr run() {
            if (0 == tk.this.f150515e) {
                return null;
            }
            tk tkVar = tk.this;
            String nativeGetActiveIndoorBuildingGUID = tkVar.f150514d.nativeGetActiveIndoorBuildingGUID(tkVar.f150515e);
            tk tkVar2 = tk.this;
            String nativeGetCurIndoorName = tkVar2.f150514d.nativeGetCurIndoorName(tkVar2.f150515e, this.f150692a);
            tk tkVar3 = tk.this;
            int nativeGetIndoorCurrentFloorId = tkVar3.f150514d.nativeGetIndoorCurrentFloorId(tkVar3.f150515e);
            tk tkVar4 = tk.this;
            return new qr(nativeGetActiveIndoorBuildingGUID, nativeGetCurIndoorName, tkVar4.f150514d.nativeGetIndoorFloorNames(tkVar4.f150515e), nativeGetIndoorCurrentFloorId);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$163, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass163 implements CallbackRunnable<Rect> {
        public AnonymousClass163() {
        }

        private Rect a() {
            if (0 == tk.this.f150515e) {
                return null;
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeGetIndoorBound(tkVar.f150515e);
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Rect run() {
            if (0 == tk.this.f150515e) {
                return null;
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeGetIndoorBound(tkVar.f150515e);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$164, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass164 implements CallbackRunnable<String> {
        public AnonymousClass164() {
        }

        private String a() {
            if (tk.this.f150515e == 0) {
                return null;
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeGetActiveIndoorBuildingGUID(tkVar.f150515e);
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ String run() {
            if (tk.this.f150515e == 0) {
                return null;
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeGetActiveIndoorBuildingGUID(tkVar.f150515e);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$165, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass165 implements CallbackRunnable<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GeoPoint f150696a;

        public AnonymousClass165(GeoPoint geoPoint) {
            this.f150696a = geoPoint;
        }

        private String a() {
            if (0 == tk.this.f150515e) {
                return null;
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeGetCurIndoorName(tkVar.f150515e, this.f150696a);
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ String run() {
            if (0 == tk.this.f150515e) {
                return null;
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeGetCurIndoorName(tkVar.f150515e, this.f150696a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$166, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass166 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150698a;

        public AnonymousClass166(int i3) {
            this.f150698a = i3;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetIndoorMaskColor(tkVar.f150515e, this.f150698a);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$167, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass167 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f150700a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f150701b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f150702c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f150703d;

        public AnonymousClass167(float f16, float f17, float f18, float f19) {
            this.f150700a = f16;
            this.f150701b = f17;
            this.f150702c = f18;
            this.f150703d = f19;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetIndoorActiveScreenArea(tkVar.f150515e, this.f150700a, this.f150701b, this.f150702c, this.f150703d);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$168, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass168 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f150705a;

        public AnonymousClass168(boolean z16) {
            this.f150705a = z16;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetIndoorBuildingPickEnabled(tkVar.f150515e, this.f150705a);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$169, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass169 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150707a;

        public AnonymousClass169(int i3) {
            this.f150707a = i3;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            int i3 = this.f150707a;
            if (i3 == 1) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetTrafficColor(tkVar.f150515e, tk.f150505o, tk.f150507q, tk.f150510t, -16777063);
            } else if (i3 == 2) {
                tk tkVar2 = tk.this;
                tkVar2.f150514d.nativeSetTrafficColor(tkVar2.f150515e, tk.f150506p, tk.f150508r, tk.f150511u, -16777063);
            } else {
                tk tkVar3 = tk.this;
                tkVar3.f150514d.nativeSetTrafficColor(tkVar3.f150515e, tk.f150505o, tk.f150507q, tk.f150509s, -16777063);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$170, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass170 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f150713a;

        public AnonymousClass170(String[] strArr) {
            this.f150713a = strArr;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetShowIndoorBuildingWhiteList(tkVar.f150515e, this.f150713a);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$172, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass172 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150719a;

        public AnonymousClass172(int i3) {
            this.f150719a = i3;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetLocationCircleColor(tkVar.f150515e, this.f150719a);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$173, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass173 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f150721a;

        public AnonymousClass173(boolean z16) {
            this.f150721a = z16;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetLocationCircleHidden(tkVar.f150515e, this.f150721a);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$180, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass180 implements CallbackRunnable<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f150743a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f150744b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f150745c = true;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f150746d = false;

        public AnonymousClass180(byte[] bArr, int i3) {
            this.f150743a = bArr;
            this.f150744b = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer run() {
            synchronized (tk.this.f150523m) {
                if (tk.this.f150515e == 0) {
                    return -1;
                }
                tk tkVar = tk.this;
                return Integer.valueOf(tkVar.f150514d.nativeRefreshTrafficData(tkVar.f150515e, this.f150743a, this.f150744b, this.f150745c, this.f150746d));
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$183, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass183 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GeoPoint f150755a;

        public AnonymousClass183(GeoPoint geoPoint) {
            this.f150755a = geoPoint;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (0 != tk.this.f150515e) {
                tk tkVar = tk.this;
                if (tkVar.f150520j != null) {
                    tkVar.f150514d.nativeSetCenter(tkVar.f150515e, this.f150755a, false);
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$186, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass186 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ double f150762a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f150763b = false;

        public AnonymousClass186(double d16) {
            this.f150762a = d16;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetScale(tkVar.f150515e, this.f150762a, this.f150763b);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$187, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass187 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150765a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f150766b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f150767c;

        public AnonymousClass187(int i3, int i16, int i17) {
            this.f150765a = i3;
            this.f150766b = i16;
            this.f150767c = i17;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetMarkerScaleLevelRange(tkVar.f150515e, this.f150765a, this.f150766b, this.f150767c);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$188, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass188 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ double f150769a;

        public AnonymousClass188(double d16) {
            this.f150769a = d16;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (0 != tk.this.f150515e) {
                tk tkVar = tk.this;
                if (tkVar.f150520j != null) {
                    tkVar.f150514d.nativeSetScale(tkVar.f150515e, this.f150769a, false);
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$189, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass189 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150771a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f150772b = true;

        public AnonymousClass189(int i3) {
            this.f150771a = i3;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetScaleLevel(tkVar.f150515e, this.f150771a, this.f150772b);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$2, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass2 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150779a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f150780b;

        public AnonymousClass2(int i3, int i16) {
            this.f150779a = i3;
            this.f150780b = i16;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetTrafficMode(tkVar.f150515e, this.f150779a, this.f150780b);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$23, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass23 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150787a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f150788b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f150789c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f150790d;

        public AnonymousClass23(int i3, int i16, int i17, int i18) {
            this.f150787a = i3;
            this.f150788b = i16;
            this.f150789c = i17;
            this.f150790d = i18;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeSetTrafficColor(tkVar.f150515e, this.f150787a, this.f150788b, this.f150789c, this.f150790d);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$25, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass25 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150798a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f150799b;

        public AnonymousClass25(int i3, int i16) {
            this.f150798a = i3;
            this.f150799b = i16;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeBringElementAbove(tkVar.f150515e, this.f150798a, this.f150799b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$26, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass26 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150801a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f150802b;

        public AnonymousClass26(int i3, int i16) {
            this.f150801a = i3;
            this.f150802b = i16;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeBringElementBelow(tkVar.f150515e, this.f150801a, this.f150802b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$3, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass3 implements ne.a {
        public AnonymousClass3() {
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeZoomOut(tkVar.f150515e);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$30, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass30 implements CallbackRunnable<AnnocationTextResult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AnnocationText f150812a;

        public AnonymousClass30(AnnocationText annocationText) {
            this.f150812a = annocationText;
        }

        private AnnocationTextResult a() {
            if (0 == tk.this.f150515e) {
                return null;
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeCreateAnnotationTextBitmap(tkVar.f150515e, this.f150812a);
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ AnnocationTextResult run() {
            if (0 == tk.this.f150515e) {
                return null;
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeCreateAnnotationTextBitmap(tkVar.f150515e, this.f150812a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$31, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass31 implements CallbackRunnable<List<Integer>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f150814a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f150815b;

        public AnonymousClass31(Rect rect, int i3) {
            this.f150814a = rect;
            this.f150815b = i3;
        }

        private List<Integer> a() {
            ArrayList arrayList = null;
            if (0 == tk.this.f150515e) {
                return null;
            }
            int[] iArr = new int[100];
            tk tkVar = tk.this;
            int nativeQueryCityCodeList = tkVar.f150514d.nativeQueryCityCodeList(tkVar.f150515e, this.f150814a, this.f150815b, iArr, 100);
            if (nativeQueryCityCodeList > 0) {
                arrayList = new ArrayList(nativeQueryCityCodeList);
                for (int i3 = 0; i3 < nativeQueryCityCodeList; i3++) {
                    arrayList.add(Integer.valueOf(iArr[i3]));
                }
            }
            return arrayList;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ List<Integer> run() {
            if (0 != tk.this.f150515e) {
                int[] iArr = new int[100];
                tk tkVar = tk.this;
                int nativeQueryCityCodeList = tkVar.f150514d.nativeQueryCityCodeList(tkVar.f150515e, this.f150814a, this.f150815b, iArr, 100);
                if (nativeQueryCityCodeList > 0) {
                    ArrayList arrayList = new ArrayList(nativeQueryCityCodeList);
                    for (int i3 = 0; i3 < nativeQueryCityCodeList; i3++) {
                        arrayList.add(Integer.valueOf(iArr[i3]));
                    }
                    return arrayList;
                }
                return null;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$32, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass32 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f150817a;

        public AnonymousClass32(String str) {
            this.f150817a = str;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeMapLoadKMLFile(tkVar.f150515e, this.f150817a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$33, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass33 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f150819a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f150820b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f150821c;

        public AnonymousClass33(String str, String str2, String str3) {
            this.f150819a = str;
            this.f150820b = str2;
            this.f150821c = str3;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeResetEnginePath(tkVar.f150515e, this.f150819a, this.f150820b, this.f150821c);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$34, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass34 implements ne.a {
        public AnonymousClass34() {
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeResumeRenderMsgQueue(tkVar.f150515e);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$35, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass35 implements CallbackRunnable<ru[]> {
        public AnonymousClass35() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ru[] run() {
            synchronized (tk.this.f150523m) {
                if (tk.this.f150515e == 0) {
                    return null;
                }
                tk tkVar = tk.this;
                int[] nativeFetchLackedTrafficBlocks = tkVar.f150514d.nativeFetchLackedTrafficBlocks(tkVar.f150515e);
                if (nativeFetchLackedTrafficBlocks == null || nativeFetchLackedTrafficBlocks.length == 0) {
                    return null;
                }
                ru[] ruVarArr = new ru[nativeFetchLackedTrafficBlocks.length / 9];
                for (int i3 = 0; i3 < nativeFetchLackedTrafficBlocks.length / 9; i3++) {
                    ru ruVar = new ru();
                    ruVarArr[i3] = ruVar;
                    int i16 = i3 * 9;
                    ruVar.f150129a = nativeFetchLackedTrafficBlocks[i16];
                    ruVar.f150130b = nativeFetchLackedTrafficBlocks[i16 + 1];
                    ruVar.f150132d = nativeFetchLackedTrafficBlocks[i16 + 2];
                    ruVar.f150131c = nativeFetchLackedTrafficBlocks[i16 + 3];
                    ruVar.f150134f = nativeFetchLackedTrafficBlocks[i16 + 4];
                    ruVar.f150133e = nativeFetchLackedTrafficBlocks[i16 + 5];
                    ruVar.f150135g = nativeFetchLackedTrafficBlocks[i16 + 6];
                    ruVar.f150136h = nativeFetchLackedTrafficBlocks[i16 + 7];
                    ruVar.f150137i = nativeFetchLackedTrafficBlocks[i16 + 8];
                }
                return ruVarArr;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$37, reason: invalid class name */
    /* loaded from: classes9.dex */
    final class AnonymousClass37 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ qv f150827a;

        AnonymousClass37(qv qvVar) {
            this.f150827a = qvVar;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            qv qvVar;
            int i3;
            if (tk.this.f150515e == 0 || (i3 = (qvVar = this.f150827a).f149943s) == -1) {
                return;
            }
            ga gaVar = qvVar.f149938b;
            if (gaVar.I < 0.0f) {
                return;
            }
            int i16 = gaVar.C;
            if (i16 != 3 && i16 != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetLineFootPrintSpacing(tkVar.f150515e, i3, this.f150827a.f149938b.I);
            } else {
                tk tkVar2 = tk.this;
                tkVar2.f150514d.nativeSetLineArrowSpacing(tkVar2.f150515e, i3, this.f150827a.f149938b.I);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$38, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass38 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f150829a;

        public AnonymousClass38(String str) {
            this.f150829a = str;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetServerHost(tkVar.f150515e, this.f150829a);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$39, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass39 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f150831a;

        public AnonymousClass39(String str) {
            this.f150831a = str;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeMapSetSatelliteServerFullUrl(tkVar.f150515e, this.f150831a);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$4, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass4 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RectF f150833a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GeoPoint f150834b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f150835c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f150836d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f150837e;

        public AnonymousClass4(RectF rectF, GeoPoint geoPoint, int i3, int i16, boolean z16) {
            this.f150833a = rectF;
            this.f150834b = geoPoint;
            this.f150835c = i3;
            this.f150836d = i16;
            this.f150837e = z16;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                tk tkVar = tk.this;
                JNI jni = tkVar.f150514d;
                long j3 = tkVar.f150515e;
                RectF rectF = this.f150833a;
                jni.nativeSetFlagOfZoomToSpanForLocation(j3, rectF.top, rectF.left, rectF.bottom, rectF.right);
                tk tkVar2 = tk.this;
                tkVar2.f150514d.nativeZoomToSpanForNavigation(tkVar2.f150515e, this.f150834b, this.f150835c, this.f150836d, this.f150837e);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$41, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass41 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f150841a;

        public AnonymousClass41(boolean z16) {
            this.f150841a = z16;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeEnableBaseMap(tkVar.f150515e, this.f150841a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$42, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass42 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f150843a;

        public AnonymousClass42(boolean z16) {
            this.f150843a = z16;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeEnableBuilding(tkVar.f150515e, this.f150843a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$43, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass43 implements CallbackRunnable<String> {
        public AnonymousClass43() {
        }

        private String a() {
            if (tk.this.f150515e == 0) {
                return "";
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeGetMapEngineVersion(tkVar.f150515e);
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ String run() {
            if (tk.this.f150515e == 0) {
                return "";
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeGetMapEngineVersion(tkVar.f150515e);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$44, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass44 implements CallbackRunnable<String> {
        public AnonymousClass44() {
        }

        private String a() {
            if (tk.this.f150515e == 0) {
                return "";
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeGetDataEngineVersion(tkVar.f150515e);
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ String run() {
            if (tk.this.f150515e == 0) {
                return "";
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeGetDataEngineVersion(tkVar.f150515e);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$47, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass47 implements CallbackRunnable<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f150852a;

        public AnonymousClass47(String str) {
            this.f150852a = str;
        }

        private Integer a() {
            if (tk.this.f150515e == 0) {
                return -1;
            }
            tk tkVar = tk.this;
            return Integer.valueOf(tkVar.f150514d.getIndoorOutlineZoom(tkVar.f150515e, this.f150852a));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Integer run() {
            if (tk.this.f150515e == 0) {
                return -1;
            }
            tk tkVar = tk.this;
            return Integer.valueOf(tkVar.f150514d.getIndoorOutlineZoom(tkVar.f150515e, this.f150852a));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$48, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass48 implements CallbackRunnable<String> {
        public AnonymousClass48() {
        }

        private String a() {
            if (tk.this.f150515e == 0) {
                return null;
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.getMapEngineRenderStatus(tkVar.f150515e);
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ String run() {
            if (tk.this.f150515e == 0) {
                return null;
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.getMapEngineRenderStatus(tkVar.f150515e);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$50, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass50 implements CallbackRunnable<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150860a;

        public AnonymousClass50(int i3) {
            this.f150860a = i3;
        }

        private Boolean a() {
            if (tk.this.f150515e == 0) {
                return Boolean.FALSE;
            }
            tk tkVar = tk.this;
            return Boolean.valueOf(tkVar.f150514d.checkMapLoadFinishedTask(tkVar.f150515e, this.f150860a));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Boolean run() {
            if (tk.this.f150515e == 0) {
                return Boolean.FALSE;
            }
            tk tkVar = tk.this;
            return Boolean.valueOf(tkVar.f150514d.checkMapLoadFinishedTask(tkVar.f150515e, this.f150860a));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$52, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass52 implements CallbackRunnable<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GeoPoint[] f150866a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PolylineOptions.Text f150867b;

        public AnonymousClass52(GeoPoint[] geoPointArr, PolylineOptions.Text text) {
            this.f150866a = geoPointArr;
            this.f150867b = text;
        }

        private Integer a() {
            if (tk.this.f150515e == 0) {
                return -1;
            }
            tk tkVar = tk.this;
            return Integer.valueOf(tkVar.f150514d.addLineText(tkVar.f150515e, this.f150866a, this.f150867b));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Integer run() {
            if (tk.this.f150515e == 0) {
                return -1;
            }
            tk tkVar = tk.this;
            return Integer.valueOf(tkVar.f150514d.addLineText(tkVar.f150515e, this.f150866a, this.f150867b));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$54, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass54 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150871a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PolylineOptions.Text f150872b;

        public AnonymousClass54(int i3, PolylineOptions.Text text) {
            this.f150871a = i3;
            this.f150872b = text;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.setLineTextStyle(tkVar.f150515e, this.f150871a, this.f150872b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$57, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass57 implements CallbackRunnable<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PolygonInfo f150877a;

        public AnonymousClass57(PolygonInfo polygonInfo) {
            this.f150877a = polygonInfo;
        }

        private Integer a() {
            if (tk.this.f150515e == 0) {
                return 0;
            }
            tk tkVar = tk.this;
            return Integer.valueOf(tkVar.f150514d.nativeAddPolygon(tkVar.f150515e, this.f150877a));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Integer run() {
            if (tk.this.f150515e == 0) {
                return 0;
            }
            tk tkVar = tk.this;
            return Integer.valueOf(tkVar.f150514d.nativeAddPolygon(tkVar.f150515e, this.f150877a));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$60, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass60 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150889a;

        public AnonymousClass60(int i3) {
            this.f150889a = i3;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeSetMapFontSize(tkVar.f150515e, this.f150889a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$62, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass62 implements CallbackRunnable<Long> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AggregationOverlayInfo f150893a;

        public AnonymousClass62(AggregationOverlayInfo aggregationOverlayInfo) {
            this.f150893a = aggregationOverlayInfo;
        }

        private Long a() {
            if (tk.this.f150515e == 0) {
                return 0L;
            }
            tk tkVar = tk.this;
            return Long.valueOf(tkVar.f150514d.nativeAddAggregatioinOverlay(tkVar.f150515e, this.f150893a));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Long run() {
            if (tk.this.f150515e == 0) {
                return 0L;
            }
            tk tkVar = tk.this;
            return Long.valueOf(tkVar.f150514d.nativeAddAggregatioinOverlay(tkVar.f150515e, this.f150893a));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$63, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass63 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f150895a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AggregationOverlayInfo f150896b;

        public AnonymousClass63(long j3, AggregationOverlayInfo aggregationOverlayInfo) {
            this.f150895a = j3;
            this.f150896b = aggregationOverlayInfo;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeUpdateAggregatioinOverlay(tkVar.f150515e, this.f150895a, this.f150896b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$64, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass64 implements CallbackRunnable<Long> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HeatmapInfo f150898a;

        public AnonymousClass64(HeatmapInfo heatmapInfo) {
            this.f150898a = heatmapInfo;
        }

        private Long a() {
            if (tk.this.f150515e == 0) {
                return 0L;
            }
            tk tkVar = tk.this;
            return Long.valueOf(tkVar.f150514d.nativeAddHeatmapOverlay(tkVar.f150515e, this.f150898a));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Long run() {
            if (tk.this.f150515e == 0) {
                return 0L;
            }
            tk tkVar = tk.this;
            return Long.valueOf(tkVar.f150514d.nativeAddHeatmapOverlay(tkVar.f150515e, this.f150898a));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$65, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass65 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f150900a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HeatmapInfo f150901b;

        public AnonymousClass65(long j3, HeatmapInfo heatmapInfo) {
            this.f150900a = j3;
            this.f150901b = heatmapInfo;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeUpdateHeatmapOverlay(tkVar.f150515e, this.f150900a, this.f150901b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$67, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass67 implements CallbackRunnable<VectorHeatAggregationUnit> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f150905a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LatLng f150906b;

        public AnonymousClass67(long j3, LatLng latLng) {
            this.f150905a = j3;
            this.f150906b = latLng;
        }

        private VectorHeatAggregationUnit a() {
            if (tk.this.f150515e == 0) {
                return null;
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.getAggregationUnit(tkVar.f150515e, this.f150905a, this.f150906b);
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ VectorHeatAggregationUnit run() {
            if (tk.this.f150515e == 0) {
                return null;
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.getAggregationUnit(tkVar.f150515e, this.f150905a, this.f150906b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$68, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass68 implements CallbackRunnable<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CircleInfo f150908a;

        public AnonymousClass68(CircleInfo circleInfo) {
            this.f150908a = circleInfo;
        }

        private Integer a() {
            if (tk.this.f150515e != 0 && this.f150908a != null) {
                tk tkVar = tk.this;
                return Integer.valueOf(tkVar.f150514d.nativeAddCircle(tkVar.f150515e, this.f150908a));
            }
            return -1;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Integer run() {
            if (tk.this.f150515e != 0 && this.f150908a != null) {
                tk tkVar = tk.this;
                return Integer.valueOf(tkVar.f150514d.nativeAddCircle(tkVar.f150515e, this.f150908a));
            }
            return -1;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$69, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass69 implements CallbackRunnable<Long> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArcLineOverlayInfo f150910a;

        public AnonymousClass69(ArcLineOverlayInfo arcLineOverlayInfo) {
            this.f150910a = arcLineOverlayInfo;
        }

        private Long a() {
            if (tk.this.f150515e == 0) {
                return 0L;
            }
            tk tkVar = tk.this;
            return Long.valueOf(tkVar.f150514d.nativeAddArcLineOverlay(tkVar.f150515e, this.f150910a));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Long run() {
            if (tk.this.f150515e == 0) {
                return 0L;
            }
            tk tkVar = tk.this;
            return Long.valueOf(tkVar.f150514d.nativeAddArcLineOverlay(tkVar.f150515e, this.f150910a));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$7, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass7 implements ne.a {
        public AnonymousClass7() {
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (0 == tk.this.f150515e) {
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            tk tkVar = tk.this;
            if (tkVar.f150521k == 0) {
                tkVar.f150514d.nativeUpdateFrame(tkVar.f150515e, 0.0d);
            } else {
                tkVar.f150514d.nativeUpdateFrame(tkVar.f150515e, elapsedRealtime - tk.this.f150521k);
            }
            tk.this.f150521k = elapsedRealtime;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$70, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass70 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f150913a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArcLineOverlayInfo f150914b;

        public AnonymousClass70(long j3, ArcLineOverlayInfo arcLineOverlayInfo) {
            this.f150913a = j3;
            this.f150914b = arcLineOverlayInfo;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeUpdateArcLineOverlay(tkVar.f150515e, this.f150913a, this.f150914b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$71, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass71 implements CallbackRunnable<Long> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScatterPlotInfo f150916a;

        public AnonymousClass71(ScatterPlotInfo scatterPlotInfo) {
            this.f150916a = scatterPlotInfo;
        }

        private Long a() {
            if (tk.this.f150515e == 0) {
                return 0L;
            }
            tk tkVar = tk.this;
            return Long.valueOf(tkVar.f150514d.nativeAddScatterOverlay(tkVar.f150515e, this.f150916a));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Long run() {
            if (tk.this.f150515e == 0) {
                return 0L;
            }
            tk tkVar = tk.this;
            return Long.valueOf(tkVar.f150514d.nativeAddScatterOverlay(tkVar.f150515e, this.f150916a));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$72, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass72 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f150918a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScatterPlotInfo f150919b;

        public AnonymousClass72(long j3, ScatterPlotInfo scatterPlotInfo) {
            this.f150918a = j3;
            this.f150919b = scatterPlotInfo;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeUpdateScatterPlotOverlay(tkVar.f150515e, this.f150918a, this.f150919b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$73, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass73 implements CallbackRunnable<Long> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TrailOverlayInfo f150921a;

        public AnonymousClass73(TrailOverlayInfo trailOverlayInfo) {
            this.f150921a = trailOverlayInfo;
        }

        private Long a() {
            if (tk.this.f150515e == 0) {
                return 0L;
            }
            tk tkVar = tk.this;
            return Long.valueOf(tkVar.f150514d.nativeAddTrailOverlay(tkVar.f150515e, this.f150921a));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Long run() {
            if (tk.this.f150515e == 0) {
                return 0L;
            }
            tk tkVar = tk.this;
            return Long.valueOf(tkVar.f150514d.nativeAddTrailOverlay(tkVar.f150515e, this.f150921a));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$74, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass74 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f150923a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TrailOverlayInfo f150924b;

        public AnonymousClass74(long j3, TrailOverlayInfo trailOverlayInfo) {
            this.f150923a = j3;
            this.f150924b = trailOverlayInfo;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeUpdateTrailOverlay(tkVar.f150515e, this.f150923a, this.f150924b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$76, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass76 implements CallbackRunnable<Long> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GroundOverlayInfo f150927a;

        public AnonymousClass76(GroundOverlayInfo groundOverlayInfo) {
            this.f150927a = groundOverlayInfo;
        }

        private Long a() {
            GroundOverlayInfo groundOverlayInfo;
            if (tk.this.f150515e != 0 && (groundOverlayInfo = this.f150927a) != null && groundOverlayInfo.checkValid()) {
                tk tkVar = tk.this;
                return Long.valueOf(tkVar.f150514d.nativeAddGroundOverlay(tkVar.f150515e, this.f150927a));
            }
            return 0L;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Long run() {
            GroundOverlayInfo groundOverlayInfo;
            if (tk.this.f150515e != 0 && (groundOverlayInfo = this.f150927a) != null && groundOverlayInfo.checkValid()) {
                tk tkVar = tk.this;
                return Long.valueOf(tkVar.f150514d.nativeAddGroundOverlay(tkVar.f150515e, this.f150927a));
            }
            return 0L;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$77, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass77 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f150929a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GroundOverlayInfo f150930b;

        public AnonymousClass77(long j3, GroundOverlayInfo groundOverlayInfo) {
            this.f150929a = j3;
            this.f150930b = groundOverlayInfo;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0 && this.f150929a != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeUpdateGroundOverlay(tkVar.f150515e, this.f150929a, this.f150930b);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$78, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass78 implements CallbackRunnable<Long> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IntersectionOverlayInfo f150932a;

        public AnonymousClass78(IntersectionOverlayInfo intersectionOverlayInfo) {
            this.f150932a = intersectionOverlayInfo;
        }

        private Long a() {
            if (tk.this.f150515e == 0) {
                return 0L;
            }
            tk tkVar = tk.this;
            return Long.valueOf(tkVar.f150514d.nativeAddIntersectionOverlay(tkVar.f150515e, this.f150932a));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Long run() {
            if (tk.this.f150515e == 0) {
                return 0L;
            }
            tk tkVar = tk.this;
            return Long.valueOf(tkVar.f150514d.nativeAddIntersectionOverlay(tkVar.f150515e, this.f150932a));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$79, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass79 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150934a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CircleInfo f150935b;

        public AnonymousClass79(int i3, CircleInfo circleInfo) {
            this.f150934a = i3;
            this.f150935b = circleInfo;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            tk tkVar = tk.this;
            tkVar.f150514d.nativeUpdateCircle(tkVar.f150515e, this.f150934a, this.f150935b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$8, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass8 implements CallbackRunnable<Boolean> {
        public AnonymousClass8() {
        }

        private Boolean a() {
            if (0 == tk.this.f150515e) {
                return Boolean.FALSE;
            }
            tk tkVar = tk.this;
            return Boolean.valueOf(tkVar.f150514d.nativeNeedDispaly(tkVar.f150515e));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Boolean run() {
            if (0 == tk.this.f150515e) {
                return Boolean.FALSE;
            }
            tk tkVar = tk.this;
            return Boolean.valueOf(tkVar.f150514d.nativeNeedDispaly(tkVar.f150515e));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$80, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass80 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f150938a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IntersectionOverlayInfo f150939b;

        public AnonymousClass80(long j3, IntersectionOverlayInfo intersectionOverlayInfo) {
            this.f150938a = j3;
            this.f150939b = intersectionOverlayInfo;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0) {
                long j3 = this.f150938a;
                if (j3 != 0) {
                    tk.this.f150514d.nativeUpdateIntersectionOverlay(j3, this.f150939b);
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$81, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass81 implements CallbackRunnable<Long> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GLModelInfo f150941a;

        public AnonymousClass81(GLModelInfo gLModelInfo) {
            this.f150941a = gLModelInfo;
        }

        private Long a() {
            if (tk.this.f150515e == 0) {
                return 0L;
            }
            tk tkVar = tk.this;
            return Long.valueOf(tkVar.f150514d.nativeAddGLModel(tkVar.f150515e, this.f150941a));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Long run() {
            if (tk.this.f150515e == 0) {
                return 0L;
            }
            tk tkVar = tk.this;
            return Long.valueOf(tkVar.f150514d.nativeAddGLModel(tkVar.f150515e, this.f150941a));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$82, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass82 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f150943a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GLModelInfo f150944b;

        public AnonymousClass82(long j3, GLModelInfo gLModelInfo) {
            this.f150943a = j3;
            this.f150944b = gLModelInfo;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0 && this.f150943a != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeUpdateGLModel(tkVar.f150515e, this.f150943a, this.f150944b);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$83, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass83 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f150946a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f150947b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f150948c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f150949d;

        public AnonymousClass83(long j3, int i3, float f16, boolean z16) {
            this.f150946a = j3;
            this.f150947b = i3;
            this.f150948c = f16;
            this.f150949d = z16;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0 && this.f150946a != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeStartGLModelSkeletonAnimation(tkVar.f150515e, this.f150946a, this.f150947b, this.f150948c, this.f150949d);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$84, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass84 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f150951a;

        public AnonymousClass84(long j3) {
            this.f150951a = j3;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0 && this.f150951a != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeStopGLModelSkeletonAnimation(tkVar.f150515e, this.f150951a);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$85, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass85 implements CallbackRunnable<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f150953a;

        public AnonymousClass85(long j3) {
            this.f150953a = j3;
        }

        private Integer a() {
            if (tk.this.f150515e == 0) {
                return 0;
            }
            tk tkVar = tk.this;
            return Integer.valueOf(tkVar.f150514d.nativeGetGLModelSkeletonAnimationCount(tkVar.f150515e, this.f150953a));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Integer run() {
            if (tk.this.f150515e == 0) {
                return 0;
            }
            tk tkVar = tk.this;
            return Integer.valueOf(tkVar.f150514d.nativeGetGLModelSkeletonAnimationCount(tkVar.f150515e, this.f150953a));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$86, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass86 implements CallbackRunnable<float[]> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f150955a;

        public AnonymousClass86(long j3) {
            this.f150955a = j3;
        }

        private float[] a() {
            if (tk.this.f150515e == 0) {
                return new float[0];
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeGetGLModelSkeletonAnimationDuration(tkVar.f150515e, this.f150955a);
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ float[] run() {
            if (tk.this.f150515e == 0) {
                return new float[0];
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeGetGLModelSkeletonAnimationDuration(tkVar.f150515e, this.f150955a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$87, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass87 implements CallbackRunnable<String[]> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f150957a;

        public AnonymousClass87(long j3) {
            this.f150957a = j3;
        }

        private String[] a() {
            if (tk.this.f150515e == 0) {
                return new String[0];
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeGetGLModelSkeletonAnimationName(tkVar.f150515e, this.f150957a);
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ String[] run() {
            if (tk.this.f150515e == 0) {
                return new String[0];
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeGetGLModelSkeletonAnimationName(tkVar.f150515e, this.f150957a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$88, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass88 implements CallbackRunnable<String[]> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f150959a;

        public AnonymousClass88(long j3) {
            this.f150959a = j3;
        }

        private String[] a() {
            if (tk.this.f150515e == 0) {
                return new String[0];
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeGetVariantNames(tkVar.f150515e, this.f150959a);
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ String[] run() {
            if (tk.this.f150515e == 0) {
                return new String[0];
            }
            tk tkVar = tk.this;
            return tkVar.f150514d.nativeGetVariantNames(tkVar.f150515e, this.f150959a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$89, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass89 implements CallbackRunnable<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f150961a;

        public AnonymousClass89(long j3) {
            this.f150961a = j3;
        }

        private Integer a() {
            if (tk.this.f150515e == 0) {
                return 0;
            }
            tk tkVar = tk.this;
            return Integer.valueOf(tkVar.f150514d.nativeGetCurrentMaterialVariant(tkVar.f150515e, this.f150961a));
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public final /* synthetic */ Integer run() {
            if (tk.this.f150515e == 0) {
                return 0;
            }
            tk tkVar = tk.this;
            return Integer.valueOf(tkVar.f150514d.nativeGetCurrentMaterialVariant(tkVar.f150515e, this.f150961a));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$90, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass90 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f150965a;

        public AnonymousClass90(int i3) {
            this.f150965a = i3;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            tk tkVar = tk.this;
            tkVar.f150514d.nativeDeleteCircle(tkVar.f150515e, this.f150965a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$91, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass91 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f150967a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f150968b;

        public AnonymousClass91(long j3, int i3) {
            this.f150967a = j3;
            this.f150968b = i3;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0 && this.f150967a != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetMaterialVariant(tkVar.f150515e, this.f150967a, this.f150968b);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$92, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass92 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f150970a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f150971b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f150972c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f150973d;

        public AnonymousClass92(long j3, float f16, float f17, float f18) {
            this.f150970a = j3;
            this.f150971b = f16;
            this.f150972c = f17;
            this.f150973d = f18;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0 && this.f150970a != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetMonoColor(tkVar.f150515e, this.f150970a, this.f150971b, this.f150972c, this.f150973d);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$93, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass93 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f150975a;

        public AnonymousClass93(long j3) {
            this.f150975a = j3;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e != 0 && this.f150975a != 0) {
                tk tkVar = tk.this;
                tkVar.f150514d.nativeResetMonoColor(tkVar.f150515e, this.f150975a);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$94, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass94 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LightColor f150977a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f150978b;

        public AnonymousClass94(LightColor lightColor, float f16) {
            this.f150977a = lightColor;
            this.f150978b = f16;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeSetAmbientLight(tkVar.f150515e, this.f150977a, this.f150978b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$95, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass95 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LightType f150980a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LightColor f150981b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ LightDirection f150982c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f150983d;

        public AnonymousClass95(LightType lightType, LightColor lightColor, LightDirection lightDirection, float f16) {
            this.f150980a = lightType;
            this.f150981b = lightColor;
            this.f150982c = lightDirection;
            this.f150983d = f16;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeSetSpotOrDirectionalLight(tkVar.f150515e, this.f150980a, this.f150981b, this.f150982c, this.f150983d);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$97, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass97 implements ne.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f150987a;

        public AnonymousClass97(List list) {
            this.f150987a = list;
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeSetIndoorCellInfo(tkVar.f150515e, this.f150987a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tk$98, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass98 implements ne.a {
        public AnonymousClass98() {
        }

        @Override // com.tencent.mapsdk.internal.ne.a
        public final void a(GL10 gl10) {
            if (tk.this.f150515e == 0) {
                return;
            }
            tk tkVar = tk.this;
            tkVar.f150514d.nativeResetIndoorCellInfo(tkVar.f150515e);
        }
    }

    public tk(Context context, ne neVar) {
        mb mbVar = new mb() { // from class: com.tencent.mapsdk.internal.tk.1
            @Override // com.tencent.mapsdk.internal.mb, com.tencent.mapsdk.internal.lv
            public final void a(String str, byte[] bArr) {
                synchronized (tk.this.f150523m) {
                    if (tk.this.f150515e != 0 && !TextUtils.isEmpty(str)) {
                        tk.this.a(str, bArr);
                    }
                }
            }

            @Override // com.tencent.mapsdk.internal.mb, com.tencent.mapsdk.internal.lv
            public final void a(String str, lx lxVar) {
                if (lxVar != lx.CANCEL && lxVar != lx.ERROR) {
                    LogUtil.c(lb.a.f149156c, "download url: " + str + ", status: " + lxVar.name());
                    return;
                }
                LogUtil.e(lb.a.f149156c, "download url: " + str + ", status: " + lxVar.name());
            }
        };
        this.f150518h = mbVar;
        this.f150521k = 0L;
        this.f150522l = 0L;
        this.f150524x = 1.0f;
        this.f150525y = null;
        this.f150523m = new Object();
        this.f150526z = new ReentrantLock();
        this.f150514d = new JNI();
        lw lwVar = new lw();
        this.f150517g = lwVar;
        lwVar.a(mbVar);
        this.f150520j = neVar;
        this.f150524x = context.getResources().getDisplayMetrics().density;
    }

    private Object B() {
        return this.f150523m;
    }

    private void C() {
        this.f150520j.f149412y = true;
    }

    private void D() {
        lw lwVar = this.f150517g;
        if (lwVar != null) {
            lwVar.b(this.f150518h);
            this.f150517g.a();
        }
        if (this.f150515e != 0) {
            long j3 = this.f150515e;
            synchronized (this.f150523m) {
                this.f150515e = 0L;
                this.f150514d.nativeDestroyEngine(j3);
            }
        }
        this.f150520j = null;
        this.f150514d.destory();
    }

    private int E() {
        ne neVar = this.f150520j;
        if (neVar != null) {
            return neVar.N;
        }
        return -1;
    }

    private boolean F() {
        if (this.f150515e == 0) {
            return false;
        }
        if (SystemClock.elapsedRealtime() - this.f150522l > 560) {
            this.f150514d.nativeClearDownloadURLCache(this.f150515e);
            this.f150522l = SystemClock.elapsedRealtime();
        }
        return this.f150514d.nativeGenerateTextures(this.f150515e);
    }

    private boolean G() {
        return ((Boolean) a((CallbackRunnable<AnonymousClass103>) new AnonymousClass103(), (AnonymousClass103) Boolean.FALSE)).booleanValue();
    }

    private ru[] H() {
        return (ru[]) a(new AnonymousClass35(), (AnonymousClass35) null);
    }

    private void I() {
        a(new AnonymousClass117());
    }

    private void J() {
        a(new AnonymousClass118());
    }

    private long K() {
        return this.f150515e;
    }

    private void L() {
        if (0 == this.f150515e) {
            return;
        }
        a(new AnonymousClass143());
    }

    private int M() {
        return ((Integer) a((CallbackRunnable<CallbackRunnable<Integer>>) new CallbackRunnable<Integer>() { // from class: com.tencent.mapsdk.internal.tk.160
            private Integer a() {
                if (0 == tk.this.f150515e) {
                    return -1;
                }
                tk tkVar = tk.this;
                return Integer.valueOf(tkVar.f150514d.nativeGetIndoorCurrentFloorId(tkVar.f150515e));
            }

            @Override // com.tencent.map.tools.CallbackRunnable
            public final /* synthetic */ Integer run() {
                if (0 == tk.this.f150515e) {
                    return -1;
                }
                tk tkVar = tk.this;
                return Integer.valueOf(tkVar.f150514d.nativeGetIndoorCurrentFloorId(tkVar.f150515e));
            }
        }, (CallbackRunnable<Integer>) (-1))).intValue();
    }

    private String[] N() {
        return (String[]) a(new AnonymousClass161(), (AnonymousClass161) null);
    }

    private Rect O() {
        return (Rect) a(new AnonymousClass163(), (AnonymousClass163) null);
    }

    private String P() {
        return (String) a(new AnonymousClass164(), (AnonymousClass164) null);
    }

    private void Q() {
        ne neVar;
        if (0 != this.f150515e && (neVar = this.f150520j) != null) {
            neVar.a(new AnonymousClass3());
        }
    }

    private void R() {
        a(new AnonymousClass7());
    }

    private boolean S() {
        return ((Boolean) a((CallbackRunnable<AnonymousClass8>) new AnonymousClass8(), (AnonymousClass8) Boolean.FALSE)).booleanValue();
    }

    private int T() {
        return this.f150514d.nativeGetLanguage(this.f150515e);
    }

    private void U() {
        if (this.f150515e == 0) {
            return;
        }
        b(new AnonymousClass34());
    }

    private String V() {
        return (String) a((CallbackRunnable<AnonymousClass43>) new AnonymousClass43(), (AnonymousClass43) "");
    }

    private String W() {
        return (String) a((CallbackRunnable<AnonymousClass44>) new AnonymousClass44(), (AnonymousClass44) "");
    }

    private String X() {
        return (String) a(new AnonymousClass48(), (AnonymousClass48) null);
    }

    private void Y() {
        a(new AnonymousClass98());
    }

    private float[] ac() {
        return this.f150514d.nativeGLProjectMatrix();
    }

    private int[] ad() {
        return this.f150514d.nativeGLViewport();
    }

    private float ae() {
        return this.f150514d.nativeGLViewScaleRatio();
    }

    private void g(int i3) {
        a(new AnonymousClass169(i3));
    }

    private void i(int i3) {
        a(new AnonymousClass108(i3));
    }

    private void j(qv qvVar) {
        if (this.f150515e == 0) {
            return;
        }
        a(new AnonymousClass133(qvVar));
    }

    private void k(qv qvVar) {
        if (this.f150515e == 0) {
            return;
        }
        a(new AnonymousClass134(qvVar));
    }

    private void o(boolean z16) {
        if (0 == this.f150515e) {
            return;
        }
        a(new AnonymousClass173(z16));
    }

    public final Context A() {
        ne neVar = this.f150520j;
        if (neVar == null) {
            return null;
        }
        return neVar.getContext();
    }

    @Deprecated
    public final boolean h() {
        return ((Boolean) a((CallbackRunnable<CallbackRunnable<Boolean>>) new CallbackRunnable<Boolean>() { // from class: com.tencent.mapsdk.internal.tk.147
            private Boolean a() {
                if (tk.this.f150515e == 0) {
                    return Boolean.TRUE;
                }
                tk tkVar = tk.this;
                return Boolean.valueOf(tkVar.f150514d.nativeIsMapDrawFinished(tkVar.f150515e));
            }

            @Override // com.tencent.map.tools.CallbackRunnable
            public final /* synthetic */ Boolean run() {
                if (tk.this.f150515e == 0) {
                    return Boolean.TRUE;
                }
                tk tkVar = tk.this;
                return Boolean.valueOf(tkVar.f150514d.nativeIsMapDrawFinished(tkVar.f150515e));
            }
        }, (CallbackRunnable<Boolean>) Boolean.TRUE)).booleanValue();
    }

    public final void l() {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.113
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e == 0) {
                    return;
                }
                tk tkVar = tk.this;
                tkVar.f150514d.nativeShowStreetRoad(tkVar.f150515e);
            }
        });
    }

    public final void m() {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.115
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeHideStreetRoad(tkVar.f150515e);
                }
            }
        });
    }

    public final boolean n() {
        return ((Boolean) a((CallbackRunnable<CallbackRunnable<Boolean>>) new CallbackRunnable<Boolean>() { // from class: com.tencent.mapsdk.internal.tk.137
            private Boolean a() {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    return Boolean.valueOf(tkVar.f150514d.nativeNeedRedraw(tkVar.f150515e));
                }
                return Boolean.FALSE;
            }

            @Override // com.tencent.map.tools.CallbackRunnable
            public final /* synthetic */ Boolean run() {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    return Boolean.valueOf(tkVar.f150514d.nativeNeedRedraw(tkVar.f150515e));
                }
                return Boolean.FALSE;
            }
        }, (CallbackRunnable<Boolean>) Boolean.FALSE)).booleanValue();
    }

    public final float p() {
        if (0 == this.f150515e) {
            return 1.0f;
        }
        return (float) this.f150514d.nativeGetScale(this.f150515e);
    }

    @Override // com.tencent.mapsdk.internal.pb
    public final void p_() {
        pb pbVar;
        ne neVar = this.f150520j;
        if (neVar != null && (pbVar = neVar.J) != null) {
            pbVar.p_();
        }
    }

    public final int q() {
        if (0 == this.f150515e) {
            return 20;
        }
        return this.f150514d.nativeGetScaleLevel(this.f150515e);
    }

    public final float r() {
        if (0 == this.f150515e) {
            return 0.0f;
        }
        return this.f150514d.nativeGetSkew(this.f150515e);
    }

    public final float s() {
        if (0 == this.f150515e) {
            return 0.0f;
        }
        return this.f150514d.nativeGetRotate(this.f150515e);
    }

    public final float t() {
        if (0 == this.f150515e) {
            return 0.0f;
        }
        return this.f150514d.nativeMapSightGetOnScreenHeight(this.f150515e);
    }

    public final int u() {
        if (0 == this.f150515e) {
            return 1;
        }
        return this.f150514d.nativeGetMapStyle(this.f150515e);
    }

    public final boolean v() {
        return ((Boolean) a((CallbackRunnable<CallbackRunnable<Boolean>>) new CallbackRunnable<Boolean>() { // from class: com.tencent.mapsdk.internal.tk.20
            private Boolean a() {
                if (tk.this.f150515e == 0) {
                    return Boolean.FALSE;
                }
                tk tkVar = tk.this;
                return Boolean.valueOf(tkVar.f150514d.nativeIsTileOverlayEnabled(tkVar.f150515e));
            }

            @Override // com.tencent.map.tools.CallbackRunnable
            public final /* synthetic */ Boolean run() {
                if (tk.this.f150515e == 0) {
                    return Boolean.FALSE;
                }
                tk tkVar = tk.this;
                return Boolean.valueOf(tkVar.f150514d.nativeIsTileOverlayEnabled(tkVar.f150515e));
            }
        }, (CallbackRunnable<Boolean>) Boolean.FALSE)).booleanValue();
    }

    public final void w() {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.29
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (0 == tk.this.f150515e) {
                    return;
                }
                tk tkVar = tk.this;
                tkVar.f150514d.nativeClearRouteNameSegments(tkVar.f150515e);
            }
        });
    }

    public final ArrayList<MapPoi> x() {
        return (ArrayList) a((CallbackRunnable<CallbackRunnable<ArrayList<MapPoi>>>) new CallbackRunnable<ArrayList<MapPoi>>() { // from class: com.tencent.mapsdk.internal.tk.49
            private ArrayList<MapPoi> a() {
                if (tk.this.f150515e == 0) {
                    return null;
                }
                tk tkVar = tk.this;
                return tkVar.f150514d.nativeGetPoisInScreen(tkVar.f150515e);
            }

            @Override // com.tencent.map.tools.CallbackRunnable
            public final /* synthetic */ ArrayList<MapPoi> run() {
                if (tk.this.f150515e == 0) {
                    return null;
                }
                tk tkVar = tk.this;
                return tkVar.f150514d.nativeGetPoisInScreen(tkVar.f150515e);
            }
        }, (CallbackRunnable<ArrayList<MapPoi>>) null);
    }

    public final boolean y() {
        return ((Boolean) a((CallbackRunnable<CallbackRunnable<Boolean>>) new CallbackRunnable<Boolean>() { // from class: com.tencent.mapsdk.internal.tk.75
            private Boolean a() {
                if (tk.this.f150515e == 0) {
                    return Boolean.FALSE;
                }
                tk tkVar = tk.this;
                return Boolean.valueOf(tkVar.f150514d.nativeGetAndResetDirty(tkVar.f150515e));
            }

            @Override // com.tencent.map.tools.CallbackRunnable
            public final /* synthetic */ Boolean run() {
                if (tk.this.f150515e == 0) {
                    return Boolean.FALSE;
                }
                tk tkVar = tk.this;
                return Boolean.valueOf(tkVar.f150514d.nativeGetAndResetDirty(tkVar.f150515e));
            }
        }, (CallbackRunnable<Boolean>) Boolean.FALSE)).booleanValue();
    }

    public final float[] z() {
        double[] nativeGLViewMatrix = this.f150514d.nativeGLViewMatrix();
        if (nativeGLViewMatrix != null && nativeGLViewMatrix.length != 0) {
            PointF a16 = this.f150520j.f149403p.a(ks.a(this.f150520j.f149396i.o()));
            a(nativeGLViewMatrix, a16.x, -a16.y);
            float[] fArr = new float[nativeGLViewMatrix.length];
            for (int i3 = 0; i3 < nativeGLViewMatrix.length; i3++) {
                fArr[i3] = new BigDecimal(nativeGLViewMatrix[i3]).floatValue();
            }
            return fArr;
        }
        return null;
    }

    private void b(final int i3, final int i16, final int i17, final int i18, final int i19) {
        b(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.24
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeCheckTrafficBlockCacheForReplay(tkVar.f150515e, i3, i16, i17, i18, i19);
                }
            }
        });
    }

    private void c(String str) {
        if (this.f150515e == 0 || this.f150520j == null) {
            return;
        }
        this.f150514d.nativeSetSkyBoxTexture(this.f150515e, str);
    }

    private void g(String str) {
        a(new AnonymousClass120(str));
    }

    private void h(int i3) {
        if (this.f150515e == 0 || i3 < 0 || this.f150520j == null) {
            return;
        }
        a(new AnonymousClass90(i3));
    }

    private void l(int i3) {
        if (0 == this.f150515e) {
            return;
        }
        a(new AnonymousClass166(i3));
    }

    private void m(boolean z16) {
        a(new AnonymousClass138(z16));
    }

    private void n(boolean z16) {
        if (this.f150515e == 0) {
            return;
        }
        a(new AnonymousClass168(z16));
    }

    @Override // com.tencent.mapsdk.internal.bu
    public final void d() {
        b(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.125
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e == 0) {
                    return;
                }
                tk tkVar = tk.this;
                tkVar.f150514d.nativeLockEngine(tkVar.f150515e);
            }
        });
    }

    @Override // com.tencent.mapsdk.internal.bu
    public final int e() {
        return ((Integer) a((CallbackRunnable<CallbackRunnable<Integer>>) new CallbackRunnable<Integer>() { // from class: com.tencent.mapsdk.internal.tk.114
            private Integer a() {
                if (tk.this.f150515e == 0) {
                    return -1;
                }
                tk tkVar = tk.this;
                return Integer.valueOf(tkVar.f150514d.nativeClearCache(tkVar.f150515e));
            }

            @Override // com.tencent.map.tools.CallbackRunnable
            public final /* synthetic */ Integer run() {
                if (tk.this.f150515e == 0) {
                    return -1;
                }
                tk tkVar = tk.this;
                return Integer.valueOf(tkVar.f150514d.nativeClearCache(tkVar.f150515e));
            }
        }, (CallbackRunnable<Integer>) (-1))).intValue();
    }

    @Override // com.tencent.mapsdk.internal.bu
    public final void f() {
        b(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.136
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e == 0) {
                    return;
                }
                tk tkVar = tk.this;
                tkVar.f150514d.nativeUnlockEngine(tkVar.f150515e);
            }
        });
    }

    public final GeoPoint[] i() {
        final GeoPoint[] geoPointArr = new GeoPoint[4];
        GeoPoint geoPoint = new GeoPoint(39984186, 116307503);
        for (int i3 = 0; i3 < 4; i3++) {
            geoPointArr[i3] = geoPoint;
        }
        return (GeoPoint[]) b((CallbackRunnable<CallbackRunnable<GeoPoint[]>>) new CallbackRunnable<GeoPoint[]>() { // from class: com.tencent.mapsdk.internal.tk.111
            private GeoPoint[] a() {
                if (tk.this.f150515e == 0) {
                    return geoPointArr;
                }
                double[] dArr = new double[8];
                tk tkVar = tk.this;
                tkVar.f150514d.nativeFromMapSight(tkVar.f150515e, dArr);
                return new GeoPoint[]{new GeoPoint((int) (dArr[1] * 1000000.0d), (int) (dArr[0] * 1000000.0d)), new GeoPoint((int) (dArr[3] * 1000000.0d), (int) (dArr[2] * 1000000.0d)), new GeoPoint((int) (dArr[5] * 1000000.0d), (int) (dArr[4] * 1000000.0d)), new GeoPoint((int) (dArr[7] * 1000000.0d), (int) (dArr[6] * 1000000.0d))};
            }

            @Override // com.tencent.map.tools.CallbackRunnable
            public final /* synthetic */ GeoPoint[] run() {
                if (tk.this.f150515e == 0) {
                    return geoPointArr;
                }
                double[] dArr = new double[8];
                tk tkVar = tk.this;
                tkVar.f150514d.nativeFromMapSight(tkVar.f150515e, dArr);
                return new GeoPoint[]{new GeoPoint((int) (dArr[1] * 1000000.0d), (int) (dArr[0] * 1000000.0d)), new GeoPoint((int) (dArr[3] * 1000000.0d), (int) (dArr[2] * 1000000.0d)), new GeoPoint((int) (dArr[5] * 1000000.0d), (int) (dArr[4] * 1000000.0d)), new GeoPoint((int) (dArr[7] * 1000000.0d), (int) (dArr[6] * 1000000.0d))};
            }
        }, (CallbackRunnable<GeoPoint[]>) geoPointArr);
    }

    private void a(op opVar) {
        this.f150516f = opVar;
    }

    private void b(PolygonInfo polygonInfo) {
        a(new AnonymousClass101(polygonInfo));
    }

    private int d(String str) {
        return ((Integer) a((CallbackRunnable<AnonymousClass158>) new AnonymousClass158(str), (AnonymousClass158) 0)).intValue();
    }

    private boolean f(String str) {
        return ((Boolean) a((CallbackRunnable<AnonymousClass112>) new AnonymousClass112(str), (AnonymousClass112) Boolean.FALSE)).booleanValue();
    }

    private void g(qv qvVar) {
        if (this.f150515e == 0) {
            return;
        }
        a(new AnonymousClass130(qvVar));
    }

    private void j(int i3) {
        a(new AnonymousClass157(i3));
    }

    private void k(int i3) {
        a(new AnonymousClass159(i3));
    }

    private void m(int i3) {
        if (0 == this.f150515e) {
            return;
        }
        a(new AnonymousClass172(i3));
    }

    private void p(boolean z16) {
        a(new AnonymousClass41(z16));
    }

    private void q(boolean z16) {
        a(new AnonymousClass42(z16));
    }

    public final GeoPoint o() {
        return (GeoPoint) a((CallbackRunnable<CallbackRunnable<GeoPoint>>) new CallbackRunnable<GeoPoint>() { // from class: com.tencent.mapsdk.internal.tk.185
            private GeoPoint a() {
                if (0 == tk.this.f150515e) {
                    return null;
                }
                GeoPoint geoPoint = new GeoPoint();
                tk tkVar = tk.this;
                tkVar.f150514d.nativeGetCenterMapPoint(tkVar.f150515e, geoPoint);
                return geoPoint;
            }

            @Override // com.tencent.map.tools.CallbackRunnable
            public final /* synthetic */ GeoPoint run() {
                if (0 == tk.this.f150515e) {
                    return null;
                }
                GeoPoint geoPoint = new GeoPoint();
                tk tkVar = tk.this;
                tkVar.f150514d.nativeGetCenterMapPoint(tkVar.f150515e, geoPoint);
                return geoPoint;
            }
        }, (CallbackRunnable<GeoPoint>) new GeoPoint());
    }

    private void a(ox oxVar) {
        this.f150519i = oxVar;
    }

    private void b(qv qvVar) {
        a(new AnonymousClass122(qvVar));
    }

    private void c(int i3, int i16) {
        b(new AnonymousClass2(i3, i16));
    }

    private void f(qv qvVar) {
        if (this.f150515e == 0) {
            return;
        }
        a(new AnonymousClass129(qvVar));
    }

    private void h(qv qvVar) {
        if (this.f150515e == 0) {
            return;
        }
        a(new AnonymousClass131(qvVar));
    }

    private void l(qv qvVar) {
        a(new AnonymousClass37(qvVar));
    }

    private void n(int i3) {
        ne neVar;
        if (0 == this.f150515e || (neVar = this.f150520j) == null) {
            return;
        }
        neVar.a(new AnonymousClass189(i3));
    }

    private void o(int i3) {
        if (this.f150515e == 0) {
            return;
        }
        this.f150514d.nativeSetLanguage(this.f150515e, i3);
    }

    private boolean p(int i3) {
        return ((Boolean) a((CallbackRunnable<AnonymousClass50>) new AnonymousClass50(i3), (AnonymousClass50) Boolean.FALSE)).booleanValue();
    }

    private void q(int i3) {
        a(new AnonymousClass60(i3));
    }

    public final void j(final boolean z16) {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.21
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e == 0) {
                    return;
                }
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetTileOverlayEnabled(tkVar.f150515e, z16);
            }
        });
    }

    public final void k(final boolean z16) {
        if (this.f150515e == 0) {
            return;
        }
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.36
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeSwitchEngineForeGround(tkVar.f150515e, z16);
                }
            }
        });
    }

    private CityTrafficInfo e(final String str) {
        return (CityTrafficInfo) a((CallbackRunnable<CallbackRunnable<CityTrafficInfo>>) new CallbackRunnable<CityTrafficInfo>() { // from class: com.tencent.mapsdk.internal.tk.46
            private CityTrafficInfo a() {
                if (tk.this.f150515e == 0) {
                    return null;
                }
                CityTrafficInfo cityTrafficInfo = new CityTrafficInfo();
                tk tkVar = tk.this;
                tkVar.f150514d.nativeGetTrafficCityInfo(tkVar.f150515e, str, cityTrafficInfo);
                return cityTrafficInfo;
            }

            @Override // com.tencent.map.tools.CallbackRunnable
            public final /* synthetic */ CityTrafficInfo run() {
                if (tk.this.f150515e == 0) {
                    return null;
                }
                CityTrafficInfo cityTrafficInfo = new CityTrafficInfo();
                tk tkVar = tk.this;
                tkVar.f150514d.nativeGetTrafficCityInfo(tkVar.f150515e, str, cityTrafficInfo);
                return cityTrafficInfo;
            }
        }, (CallbackRunnable<CityTrafficInfo>) null);
    }

    private void i(qv qvVar) {
        if (this.f150515e == 0) {
            return;
        }
        a(new AnonymousClass132(qvVar));
    }

    private void j(String str) {
        if (this.f150515e == 0) {
            return;
        }
        a(new AnonymousClass38(str));
    }

    public final boolean a(Context context, oo ooVar, w wVar, String str, String str2, String str3) {
        int[] iArr = new int[1];
        this.f150514d.initCallback(ooVar, wVar, this, this, this, this, this.f150520j.f149398k, this, this, this, this, this);
        this.f150515e = this.f150514d.nativeInitEngine(str, str2, str3, ht.a(context), 256, ht.a(context), iArr, false, Language.zh.ordinal());
        if (iArr[0] != 0) {
            LogUtil.b("init engine fail:" + iArr[0]);
            LogUtil.a(E()).e(lb.a.f149154a, "init engine fail: " + iArr[0]);
            this.f150515e = 0L;
            return false;
        }
        LogUtil.a(E()).c(lb.a.f149154a, "init engine success: " + iArr[0]);
        this.f150514d.nativeSetCenter(this.f150515e, new GeoPoint(39984186, 116307503), false);
        this.f150514d.registerCallback(this.f150515e);
        this.f150514d.nativeSetTrafficColor(this.f150515e, f150505o, f150507q, f150509s, -16777063);
        lc.a(ky.f149096b, E());
        return true;
    }

    @Override // com.tencent.mapsdk.internal.ot
    public final void b(String str, lt ltVar) {
        DataSource dataSource = DataSource.get(ltVar.f149263b);
        LogUtil.b(ky.B, "onRequestDownload DataSource:" + dataSource + " uri:" + str);
        if (dataSource == DataSource.TILE_OVERLAY) {
            MapTileID mapTileID = (MapTileID) ltVar.f149265d;
            int tileTag = mapTileID.getTileTag();
            LogUtil.b(ky.f149097c, "onRequestDownload tileOverlayId:".concat(String.valueOf(tileTag)));
            qz a16 = this.f150520j.K.a(tileTag);
            if (a16 != null) {
                LogUtil.c(ky.f149097c, "onRequestDownload found TileOverlay");
                a16.d().a(str, new rd(a16.f150000q), ltVar.f149264c);
                lc.e(ky.f149097c, "req-count", E());
                lc.e(ky.f149097c, "R/" + mapTileID.getX() + "-" + mapTileID.getY() + "-" + mapTileID.getZ(), E());
                return;
            }
        }
        this.f150517g.a(str, this.f150520j.f149411x.d());
        lc.e(ky.f149096b, "req-count", E());
    }

    public final void c(final boolean z16) {
        if (this.f150515e == 0 || this.f150520j == null) {
            return;
        }
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.154
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeLandMarkEnabled(tkVar.f150515e, z16);
                }
            }
        });
    }

    public final void g(final boolean z16) {
        if (0 == this.f150515e) {
            return;
        }
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.177
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeSetLocationCompassMarkerHidden(tkVar.f150515e, z16);
                }
            }
        });
    }

    public final void l(final boolean z16) {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.40
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e == 0) {
                    return;
                }
                tk tkVar = tk.this;
                tkVar.f150514d.nativeEnablePOI(tkVar.f150515e, z16);
            }
        });
    }

    private void d(int i3, int i16) {
        a(new AnonymousClass107(i3, i16));
    }

    private void e(qv qvVar) {
        a(new AnonymousClass128(qvVar));
    }

    private void h(String str) {
        if (0 == this.f150515e) {
            return;
        }
        a(new AnonymousClass151(str));
    }

    private void k(String str) {
        if (this.f150515e == 0) {
            return;
        }
        a(new AnonymousClass39(str));
    }

    private int l(String str) {
        return ((Integer) a((CallbackRunnable<AnonymousClass47>) new AnonymousClass47(str), (AnonymousClass47) (-1))).intValue();
    }

    public final void f(final boolean z16) {
        if (0 == this.f150515e) {
            return;
        }
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.174
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeSetLocationMarkerHidden(tkVar.f150515e, z16);
                }
            }
        });
    }

    private String c(GeoPoint geoPoint) {
        return (String) a(new AnonymousClass165(geoPoint), (AnonymousClass165) null);
    }

    private void d(qv qvVar) {
        a(new AnonymousClass124(qvVar));
    }

    private void j(long j3) {
        a(new AnonymousClass93(j3));
    }

    public final void e(final boolean z16) {
        if (0 == this.f150515e || this.f150520j == null) {
            return;
        }
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.156
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeSetIndoorBuildingStyle(tkVar.f150515e, z16 ? 1 : 0);
                }
            }
        });
    }

    @Override // com.tencent.mapsdk.internal.pd
    public final void g() {
        ne neVar = this.f150520j;
        if (neVar != null) {
            final v vVar = neVar.f149410w;
            a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.22
                @Override // com.tencent.mapsdk.internal.ne.a
                public final void a(GL10 gl10) {
                    v vVar2 = vVar;
                    if (vVar2 == null || vVar2.f151266o == null) {
                        return;
                    }
                    vVar2.f151264m = vVar2.f151267p.o();
                    int q16 = vVar2.f151267p.q();
                    float p16 = vVar2.f151267p.p();
                    v.a aVar = vVar2.f151253b;
                    if (q16 != aVar.f151291q) {
                        vVar2.f151266o.f149398k.c(gh.f148492c);
                    } else if (p16 != aVar.f151290p) {
                        vVar2.f151266o.f149398k.c(gh.f148491b);
                    }
                    if (vVar2.f151253b != null) {
                        float d16 = v.d(p16);
                        if (d16 < vVar2.a()) {
                            float f16 = v.f(d16);
                            if (vVar2.f151267p.r() > f16) {
                                vVar2.b(f16);
                            }
                        }
                        vVar2.f151253b.a(q16, p16);
                    }
                    vVar2.f151252a = vVar2.f151267p.u();
                }
            });
        }
    }

    public final void i(final boolean z16) {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.9
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (0 == tk.this.f150515e) {
                    return;
                }
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetNeedDisplay(tkVar.f150515e, z16);
            }
        });
    }

    private void f(int i3, int i16) {
        a(new AnonymousClass26(i3, i16));
    }

    private void i(String str) {
        a(new AnonymousClass32(str));
    }

    public final void c(final float f16, final float f17) {
        ne neVar;
        if (0 == this.f150515e || (neVar = this.f150520j) == null) {
            return;
        }
        neVar.a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.190
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeZoomIn(tkVar.f150515e, f16, f17);
                }
            }
        });
    }

    public final void d(final boolean z16) {
        if (this.f150515e == 0 || this.f150520j == null) {
            return;
        }
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.155
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeIndoorBuildingEnabled(tkVar.f150515e, z16);
                }
            }
        });
    }

    public final void h(final boolean z16) {
        if (0 == this.f150515e) {
            return;
        }
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.178
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeSetLocationRedLineHidden(tkVar.f150515e, z16);
                }
            }
        });
    }

    @Override // com.tencent.mapsdk.internal.oz
    public final void j() {
        List<oz> list;
        ne neVar = this.f150520j;
        if (neVar == null || (list = neVar.L) == null || list.isEmpty()) {
            return;
        }
        Iterator<oz> it = neVar.L.iterator();
        while (it.hasNext()) {
            it.next().j();
        }
    }

    @Override // com.tencent.mapsdk.internal.oz
    public final void k() {
        List<oz> list;
        ne neVar = this.f150520j;
        if (neVar == null || (list = neVar.L) == null || list.isEmpty()) {
            return;
        }
        Iterator<oz> it = neVar.L.iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    private int i(long j3) {
        return ((Integer) b((CallbackRunnable<AnonymousClass89>) new AnonymousClass89(j3), (AnonymousClass89) 0)).intValue();
    }

    public final void e(final int i3) {
        if (this.f150515e == 0 || this.f150520j == null) {
            return;
        }
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.19
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeReloadTileOverlay(tkVar.f150515e, i3);
                }
            }
        });
    }

    public final void f(final int i3) {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.53
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e == 0) {
                    return;
                }
                tk tkVar = tk.this;
                tkVar.f150514d.removeLineText(tkVar.f150515e, i3);
            }
        });
    }

    private void c(float f16) {
        a(new AnonymousClass12(f16));
    }

    private void d(GeoPoint geoPoint) {
        this.f150520j.a(new AnonymousClass183(geoPoint));
    }

    private float[] f(long j3) {
        return (float[]) b((CallbackRunnable<AnonymousClass86>) new AnonymousClass86(j3), (AnonymousClass86) new float[0]);
    }

    private String[] g(long j3) {
        return (String[]) b((CallbackRunnable<AnonymousClass87>) new AnonymousClass87(j3), (AnonymousClass87) new String[0]);
    }

    private String[] h(long j3) {
        return (String[]) b((CallbackRunnable<AnonymousClass88>) new AnonymousClass88(j3), (AnonymousClass88) new String[0]);
    }

    private void e(int i3, int i16) {
        a(new AnonymousClass25(i3, i16));
    }

    public final void c(int i3) {
        if (0 == this.f150515e) {
            return;
        }
        this.f150514d.nativeSetMapStyle(this.f150515e, i3, false);
    }

    public final void d(final int i3) {
        if (this.f150515e == 0 || this.f150520j == null) {
            return;
        }
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.18
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeRemoveTileOverlay(tkVar.f150515e, i3);
                }
            }
        });
    }

    private int e(long j3) {
        return ((Integer) b((CallbackRunnable<AnonymousClass85>) new AnonymousClass85(j3), (AnonymousClass85) 0)).intValue();
    }

    private void d(long j3) {
        a(new AnonymousClass84(j3));
    }

    @Override // com.tencent.mapsdk.internal.ox
    public final void c() {
        ox oxVar = this.f150519i;
        if (oxVar != null) {
            oxVar.c();
        }
    }

    private void d(float f16, float f17) {
        this.f150514d.scheduleClickOnNextRender(this.f150515e, f16, f17);
    }

    private <T> T d(CallbackRunnable<T> callbackRunnable, T t16) {
        if (callbackRunnable == null || this.f150520j == null || this.f150515e == 0) {
            return t16;
        }
        if (Thread.currentThread().getName().contains(ua.f151157a)) {
            return (T) b((CallbackRunnable<CallbackRunnable<T>>) callbackRunnable, (CallbackRunnable<T>) t16);
        }
        return (T) e((CallbackRunnable<CallbackRunnable<T>>) callbackRunnable, (CallbackRunnable<T>) t16);
    }

    private <T> T e(final CallbackRunnable<T> callbackRunnable, T t16) {
        if (callbackRunnable != null && this.f150520j != null && this.f150515e != 0) {
            this.f150520j.a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.102
                @Override // com.tencent.mapsdk.internal.ne.a
                public final void a(GL10 gl10) {
                    callbackRunnable.run();
                }
            });
        }
        return t16;
    }

    public final void c(final long j3) {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.66
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e == 0) {
                    return;
                }
                tk tkVar = tk.this;
                tkVar.f150514d.nativeRemoveGLVisualizationOverlay(tkVar.f150515e, j3);
            }
        });
    }

    private <T> T c(CallbackRunnable<T> callbackRunnable, T t16) {
        if (this.f150520j != null) {
            if (this.f150515e != 0) {
                try {
                    if (this.f150520j != null && this.f150515e != 0) {
                        if (Thread.currentThread().getName().contains(ua.f151157a)) {
                            return (T) b((CallbackRunnable<CallbackRunnable<T>>) callbackRunnable, (CallbackRunnable<T>) t16);
                        }
                        return (T) e((CallbackRunnable<CallbackRunnable<T>>) callbackRunnable, (CallbackRunnable<T>) t16);
                    }
                    return t16;
                } catch (Exception e16) {
                    LogUtil.c(ky.f149101g, "safeCallEngine", e16);
                    return t16;
                }
            }
        }
        return t16;
    }

    private int a(byte[] bArr, int i3) {
        return ((Integer) a((CallbackRunnable<AnonymousClass180>) new AnonymousClass180(bArr, i3), (AnonymousClass180) (-1))).intValue();
    }

    private void b(pi piVar) {
        if (0 == this.f150515e) {
            return;
        }
        a(new AnonymousClass145(piVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int c(qv qvVar) {
        boolean z16;
        int i3;
        boolean z17;
        List<Integer> list;
        int[] iArr;
        int[] iArr2;
        ga gaVar = qvVar.f149938b;
        int i16 = gaVar.C;
        int i17 = 0;
        if (i16 == 3) {
            z16 = true;
            i16 = 0;
        } else {
            z16 = false;
        }
        int i18 = qvVar.f149940p[0];
        if (i18 == 33) {
            i3 = 2;
        } else {
            i3 = i16;
            if (i18 == 20) {
                z17 = true;
                int[] iArr3 = new int[0];
                list = gaVar.L;
                if (list == null) {
                    int[] iArr4 = new int[list.size()];
                    for (int i19 = 0; i19 < qvVar.f149938b.L.size(); i19++) {
                        iArr4[i19] = qvVar.f149938b.L.get(i19).intValue();
                    }
                    iArr = iArr4;
                } else {
                    iArr = iArr3;
                }
                int[] iArr5 = new int[0];
                iArr2 = qvVar.f149938b.f148438t;
                if (iArr2 != null) {
                    iArr5 = new int[iArr2.length];
                    while (true) {
                        int[] iArr6 = qvVar.f149938b.f148438t;
                        if (i17 >= iArr6.length) {
                            break;
                        }
                        iArr5[i17] = iArr6[i17];
                        i17++;
                    }
                }
                return ((Integer) c((CallbackRunnable<AnonymousClass123>) new AnonymousClass123(qvVar, i3, z16, z17, iArr5, iArr), (AnonymousClass123) (-1))).intValue();
            }
        }
        z17 = false;
        int[] iArr32 = new int[0];
        list = gaVar.L;
        if (list == null) {
        }
        int[] iArr52 = new int[0];
        iArr2 = qvVar.f149938b.f148438t;
        if (iArr2 != null) {
        }
        return ((Integer) c((CallbackRunnable<AnonymousClass123>) new AnonymousClass123(qvVar, i3, z16, z17, iArr52, iArr), (AnonymousClass123) (-1))).intValue();
    }

    private void a(int i3, int i16, int i17, int i18, int i19) {
        b(new AnonymousClass13(i3, i16, i17, i18, i19));
    }

    private int a(PolygonInfo polygonInfo) {
        return ((Integer) a((CallbackRunnable<AnonymousClass57>) new AnonymousClass57(polygonInfo), (AnonymousClass57) 0)).intValue();
    }

    public final void b(final boolean z16) {
        if (0 == this.f150515e) {
            return;
        }
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.149
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeSetCompassVisible(tkVar.f150515e, z16);
                }
            }
        });
    }

    private static void Z() {
    }

    private static void aa() {
    }

    private qr b(GeoPoint geoPoint) {
        if (geoPoint == null) {
            geoPoint = new GeoPoint();
        }
        return (qr) a(new AnonymousClass162(geoPoint), (AnonymousClass162) null);
    }

    private int a(CircleInfo circleInfo) {
        return ((Integer) a((CallbackRunnable<AnonymousClass68>) new AnonymousClass68(circleInfo), (AnonymousClass68) (-1))).intValue();
    }

    public final void b(final String str) {
        if (0 == this.f150515e) {
            return;
        }
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.175
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeSetLocationCompassMarkerImage(tkVar.f150515e, str);
                }
            }
        });
    }

    private void a(int i3, CircleInfo circleInfo) {
        if (this.f150515e == 0 || circleInfo == null) {
            return;
        }
        a(new AnonymousClass79(i3, circleInfo));
    }

    public final void b(final float f16, final float f17) {
        ne neVar;
        if (0 == this.f150515e || (neVar = this.f150520j) == null) {
            return;
        }
        neVar.a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.181

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ boolean f150750c = false;

            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeMoveBy(tkVar.f150515e, f16, f17, this.f150750c);
                }
            }
        });
    }

    private void a(int i3, int i16, boolean z16, int[] iArr) {
        a(new AnonymousClass104(i3, i16, z16, iArr));
    }

    private void b(int i3, int i16, int i17) {
        if (0 == this.f150515e || this.f150520j == null) {
            return;
        }
        a(new AnonymousClass187(i3, i16, i17));
    }

    private void a(int i3, int i16, int[] iArr) {
        a(new AnonymousClass105(i3, i16, iArr));
    }

    private int a(MaskLayer maskLayer) {
        return ((Integer) a((CallbackRunnable<AnonymousClass106>) new AnonymousClass106(maskLayer), (AnonymousClass106) 0)).intValue();
    }

    private void b(double d16) {
        a(new AnonymousClass188(d16));
    }

    public final void b(final int i3) {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.11
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (0 == tk.this.f150515e) {
                    return;
                }
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetMinScaleLevel(tkVar.f150515e, i3);
            }
        });
    }

    public final void b(final float f16) {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.14
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (0 == tk.this.f150515e) {
                    return;
                }
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetSkew(tkVar.f150515e, f16, false);
            }
        });
    }

    private GeoPoint a(byte[] bArr, float f16, float f17) {
        return (GeoPoint) b((CallbackRunnable<AnonymousClass109>) new AnonymousClass109(bArr, f16, f17), (AnonymousClass109) new GeoPoint());
    }

    public final void b(final int i3, final int i16) {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.16
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e == 0) {
                    return;
                }
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetTileOverlayPriority(tkVar.f150515e, i3, i16);
            }
        });
    }

    private void b(int i3, int i16, int i17, int i18) {
        a(new AnonymousClass23(i16, i3, i17, i18));
    }

    public final PointF a(final double d16, final double d17) {
        return (PointF) b((CallbackRunnable<CallbackRunnable<PointF>>) new CallbackRunnable<PointF>() { // from class: com.tencent.mapsdk.internal.tk.110

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ byte[] f150559a = null;

            private PointF a() {
                if (tk.this.f150515e == 0) {
                    return new PointF();
                }
                float[] fArr = new float[2];
                tk tkVar = tk.this;
                tkVar.f150514d.nativeToScreenLocation(tkVar.f150515e, this.f150559a, d16, d17, fArr);
                return new PointF(fArr[0], fArr[1]);
            }

            @Override // com.tencent.map.tools.CallbackRunnable
            public final /* synthetic */ PointF run() {
                if (tk.this.f150515e == 0) {
                    return new PointF();
                }
                float[] fArr = new float[2];
                tk tkVar = tk.this;
                tkVar.f150514d.nativeToScreenLocation(tkVar.f150515e, this.f150559a, d16, d17, fArr);
                return new PointF(fArr[0], fArr[1]);
            }
        }, (CallbackRunnable<PointF>) new PointF());
    }

    public final void a(final boolean z16) {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.116
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e == 0) {
                    return;
                }
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetSatelliteEnabled(tkVar.f150515e, z16);
            }
        });
    }

    @Override // com.tencent.mapsdk.internal.bs
    public final String b() {
        return (String) a((CallbackRunnable<CallbackRunnable<String>>) new CallbackRunnable<String>() { // from class: com.tencent.mapsdk.internal.tk.55
            private String a() {
                if (tk.this.f150515e == 0) {
                    return "";
                }
                tk tkVar = tk.this;
                return tkVar.f150514d.nativeGetEngineLogInfo(tkVar.f150515e);
            }

            @Override // com.tencent.map.tools.CallbackRunnable
            public final /* synthetic */ String run() {
                if (tk.this.f150515e == 0) {
                    return "";
                }
                tk tkVar = tk.this;
                return tkVar.f150514d.nativeGetEngineLogInfo(tkVar.f150515e);
            }
        }, (CallbackRunnable<String>) "");
    }

    public final String a(final GeoPoint geoPoint) {
        return (String) a((CallbackRunnable<CallbackRunnable<String>>) new CallbackRunnable<String>() { // from class: com.tencent.mapsdk.internal.tk.119
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.tencent.map.tools.CallbackRunnable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String run() {
                if (tk.this.f150515e == 0) {
                    return "";
                }
                tk tkVar = tk.this;
                byte[] nativeGetCityName = tkVar.f150514d.nativeGetCityName(tkVar.f150515e, geoPoint);
                if (nativeGetCityName != null) {
                    try {
                        return new String(nativeGetCityName, "GBK").trim();
                    } catch (UnsupportedEncodingException e16) {
                        e16.printStackTrace();
                    }
                }
                return "";
            }
        }, (CallbackRunnable<String>) "");
    }

    public final void b(final long j3) {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.61
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e == 0) {
                    return;
                }
                tk.this.f150514d.nativeRemoveEngineOverlay(j3);
            }
        });
    }

    private int a(qv qvVar) {
        return ((Integer) a((CallbackRunnable<AnonymousClass121>) new AnonymousClass121(qvVar), (AnonymousClass121) (-1))).intValue();
    }

    private void b(List<IndoorCellInfo> list) {
        a(new AnonymousClass97(list));
    }

    public final void b(final ne.a aVar) {
        if (this.f150520j == null || this.f150515e == 0) {
            return;
        }
        a((CallbackRunnable<CallbackRunnable<Object>>) new CallbackRunnable<Object>() { // from class: com.tencent.mapsdk.internal.tk.100
            @Override // com.tencent.map.tools.CallbackRunnable
            public final Object run() {
                aVar.a(null);
                return null;
            }
        }, (CallbackRunnable<Object>) null);
    }

    private void a(int i3, boolean z16) {
        a(new AnonymousClass126(i3, z16));
    }

    public final <T> T b(CallbackRunnable<T> callbackRunnable, T t16) {
        return (callbackRunnable == null || this.f150520j == null || this.f150515e == 0) ? t16 : callbackRunnable.run();
    }

    private boolean a(final int i3, final float f16, final float f17) {
        if (i3 == -1) {
            return false;
        }
        return ((Boolean) a((CallbackRunnable<CallbackRunnable<Boolean>>) new CallbackRunnable<Boolean>() { // from class: com.tencent.mapsdk.internal.tk.127
            private Boolean a() {
                return Boolean.valueOf(tk.this.f150514d.nativeOnTapLine(i3, f16, f17));
            }

            @Override // com.tencent.map.tools.CallbackRunnable
            public final /* synthetic */ Boolean run() {
                return Boolean.valueOf(tk.this.f150514d.nativeOnTapLine(i3, f16, f17));
            }
        }, (CallbackRunnable<Boolean>) Boolean.FALSE)).booleanValue();
    }

    public final TappedElement a(final float f16, final float f17) {
        return (TappedElement) a((CallbackRunnable<CallbackRunnable<TappedElement>>) new CallbackRunnable<TappedElement>() { // from class: com.tencent.mapsdk.internal.tk.135
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.tencent.map.tools.CallbackRunnable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TappedElement run() {
                if (tk.this.f150515e == 0) {
                    return null;
                }
                tk tkVar = tk.this;
                byte[] nativeOnTap = tkVar.f150514d.nativeOnTap(tkVar.f150515e, f16, f17);
                if (nativeOnTap == null) {
                    return null;
                }
                try {
                    return TappedElement.fromBytes(nativeOnTap);
                } catch (Exception unused) {
                    return null;
                }
            }
        }, (CallbackRunnable<TappedElement>) null);
    }

    public final void a(final List<LatLngBounds> list) {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.139
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (0 != tk.this.f150515e) {
                    if (list == null) {
                        tk tkVar = tk.this;
                        tkVar.f150514d.nativeSetBuildingBlackList(tkVar.f150515e, null);
                    } else {
                        tk tkVar2 = tk.this;
                        tkVar2.f150514d.nativeSetBuildingBlackList(tkVar2.f150515e, (LatLngBounds[]) list.toArray(new LatLngBounds[0]));
                    }
                }
            }
        });
    }

    public final void a(final GeoPoint geoPoint, final float f16, final float f17, final boolean z16) {
        if (0 == this.f150515e || this.f150520j == null) {
            return;
        }
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.140
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeSetLocationInfo(tkVar.f150515e, geoPoint.getLatitudeE6() / 1000000.0d, geoPoint.getLongitudeE6() / 1000000.0d, f16, f17, z16);
                }
            }
        });
    }

    private void a(boolean z16, boolean z17, boolean z18, boolean z19) {
        if (0 == this.f150515e || this.f150520j == null) {
            return;
        }
        a(new AnonymousClass141(z16, z17, z18, z19));
    }

    public final void a(final float f16) {
        if (0 == this.f150515e || this.f150520j == null) {
            return;
        }
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.142
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeSetLocationHeading(tkVar.f150515e, f16);
                }
            }
        });
    }

    @Override // com.tencent.mapsdk.internal.os
    public final void a(String str, lt ltVar) {
        DataSource dataSource = DataSource.get(ltVar.f149263b);
        LogUtil.b(ky.B, "onCancelDownload DataSource:" + dataSource + " uri:" + str);
        if (dataSource == DataSource.TILE_OVERLAY) {
            MapTileID mapTileID = (MapTileID) ltVar.f149265d;
            int tileTag = mapTileID.getTileTag();
            LogUtil.b(ky.f149097c, "onCancelDownload tileOverlayId:".concat(String.valueOf(tileTag)));
            qz a16 = this.f150520j.K.a(tileTag);
            if (a16 != null) {
                LogUtil.c(ky.f149097c, "onCancelDownload found TileOverlay");
                a16.d().a(str);
                lc.e(ky.f149097c, "cancel-count", E());
                lc.e(ky.f149097c, "C/" + mapTileID.getX() + "-" + mapTileID.getY() + "-" + mapTileID.getZ(), E());
                return;
            }
        }
        this.f150517g.a(str);
        lc.e(ky.f149096b, "cancel-count", E());
    }

    private int a(pi piVar) {
        return ((Integer) a((CallbackRunnable<AnonymousClass144>) new AnonymousClass144(piVar), (AnonymousClass144) 0)).intValue();
    }

    public final void a(final int[] iArr, final int i3) {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.146
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (0 == tk.this.f150515e) {
                    return;
                }
                tk tkVar = tk.this;
                tkVar.f150514d.nativeDeleteIcons(tkVar.f150515e, iArr, i3);
            }
        });
    }

    private void a(int[] iArr, int i3, boolean z16) {
        a(new AnonymousClass148(iArr, i3, z16));
    }

    public final void a(final int i3, final int i16) {
        if (0 == this.f150515e) {
            return;
        }
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.150
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeSetCompassPosition(tkVar.f150515e, i3, i16);
                }
            }
        });
    }

    public final double a(final Rect rect, final Rect rect2) {
        return ((Double) a((CallbackRunnable<CallbackRunnable<Double>>) new CallbackRunnable<Double>() { // from class: com.tencent.mapsdk.internal.tk.152
            private Double a() {
                if (0 == tk.this.f150515e) {
                    return Double.valueOf(1.0d);
                }
                tk tkVar = tk.this;
                return Double.valueOf(tkVar.f150514d.nativeGetTargetScale(tkVar.f150515e, rect, rect2));
            }

            @Override // com.tencent.map.tools.CallbackRunnable
            public final /* synthetic */ Double run() {
                if (0 == tk.this.f150515e) {
                    return Double.valueOf(1.0d);
                }
                tk tkVar = tk.this;
                return Double.valueOf(tkVar.f150514d.nativeGetTargetScale(tkVar.f150515e, rect, rect2));
            }
        }, (CallbackRunnable<Double>) Double.valueOf(1.0d))).doubleValue();
    }

    public final void a(final Rect rect, final Rect rect2, final boolean z16) {
        if (0 == this.f150515e || this.f150520j == null) {
            return;
        }
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.153
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeZoomToSpan(tkVar.f150515e, rect, rect2, z16);
                }
            }
        });
    }

    private void a(float f16, float f17, float f18, float f19) {
        if (0 == this.f150515e) {
            return;
        }
        a(new AnonymousClass167(f16, f17, f18, f19));
    }

    private void a(String[] strArr) {
        if (this.f150515e == 0) {
            return;
        }
        a(new AnonymousClass170(strArr));
    }

    public final int a(final String str, final float f16, final float f17) {
        if (0 == this.f150515e) {
            return 0;
        }
        return ((Integer) a((CallbackRunnable<CallbackRunnable<Integer>>) new CallbackRunnable<Integer>() { // from class: com.tencent.mapsdk.internal.tk.171
            private Integer a() {
                if (0 == tk.this.f150515e) {
                    return 0;
                }
                tk tkVar = tk.this;
                return Integer.valueOf(tkVar.f150514d.nativeSetLocationMarkerImage(tkVar.f150515e, str, f16, f17));
            }

            @Override // com.tencent.map.tools.CallbackRunnable
            public final /* synthetic */ Integer run() {
                if (0 == tk.this.f150515e) {
                    return 0;
                }
                tk tkVar = tk.this;
                return Integer.valueOf(tkVar.f150514d.nativeSetLocationMarkerImage(tkVar.f150515e, str, f16, f17));
            }
        }, (CallbackRunnable<Integer>) 0)).intValue();
    }

    public final void a(final String str, final String str2, final String str3, final String str4, final String str5) {
        if (0 == this.f150515e) {
            return;
        }
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.176
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeSetLocationCompassGroupImages(tkVar.f150515e, str, str2, str3, str4, str5);
                }
            }
        });
    }

    public final void a(final float f16, final int i3, final LatLng latLng) {
        if (0 == this.f150515e) {
            return;
        }
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.179
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeSetLocationRedLineInfo(tkVar.f150515e, f16, i3, latLng);
                }
            }
        });
    }

    public final void a(final GeoPoint geoPoint, final boolean z16) {
        ne neVar;
        if (0 == this.f150515e || (neVar = this.f150520j) == null) {
            return;
        }
        neVar.a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.182
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeSetCenter(tkVar.f150515e, geoPoint, z16);
                }
            }
        });
    }

    public final void a(final GeoPoint geoPoint, final int i3) {
        ne neVar;
        if (0 == this.f150515e || (neVar = this.f150520j) == null) {
            return;
        }
        neVar.a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.184

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ boolean f150759c = true;

            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeSetCenterMapPointAndScaleLevel(tkVar.f150515e, geoPoint, i3, this.f150759c);
                }
            }
        });
    }

    private void a(double d16) {
        ne neVar;
        if (0 == this.f150515e || (neVar = this.f150520j) == null) {
            return;
        }
        neVar.a(new AnonymousClass186(d16));
    }

    private void a(GeoPoint geoPoint, RectF rectF, int i3, int i16, boolean z16) {
        ne neVar;
        if (0 == this.f150515e || (neVar = this.f150520j) == null) {
            return;
        }
        neVar.a(new AnonymousClass4(rectF, geoPoint, i3, i16, z16));
    }

    public final void a(final float f16, final float f17, final boolean z16) {
        if (0 == this.f150515e || this.f150520j == null) {
            return;
        }
        e((CallbackRunnable<CallbackRunnable<Boolean>>) new CallbackRunnable<Boolean>() { // from class: com.tencent.mapsdk.internal.tk.5
            private Boolean a() {
                if (tk.this.f150515e == 0) {
                    return Boolean.FALSE;
                }
                if (z16) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeSetScreenCenterOffset(tkVar.f150515e, f16, f17, true);
                } else {
                    tk tkVar2 = tk.this;
                    fa faVar = tkVar2.f150520j.f149403p;
                    fw a16 = faVar.a(tkVar2.o());
                    tk tkVar3 = tk.this;
                    tkVar3.f150514d.nativeSetScreenCenterOffset(tkVar3.f150515e, f16, f17, false);
                    fw a17 = faVar.a(tk.this.o());
                    double d16 = a17.f148383a;
                    double d17 = d16 - a16.f148383a;
                    double d18 = a17.f148384b;
                    GeoPoint a18 = faVar.a(new fw(d16 + d17, d18 + (d18 - a16.f148384b)));
                    tk tkVar4 = tk.this;
                    tkVar4.f150514d.nativeSetCenter(tkVar4.f150515e, a18, false);
                }
                return Boolean.TRUE;
            }

            @Override // com.tencent.map.tools.CallbackRunnable
            public final /* synthetic */ Boolean run() {
                if (tk.this.f150515e == 0) {
                    return Boolean.FALSE;
                }
                if (z16) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeSetScreenCenterOffset(tkVar.f150515e, f16, f17, true);
                } else {
                    tk tkVar2 = tk.this;
                    fa faVar = tkVar2.f150520j.f149403p;
                    fw a16 = faVar.a(tkVar2.o());
                    tk tkVar3 = tk.this;
                    tkVar3.f150514d.nativeSetScreenCenterOffset(tkVar3.f150515e, f16, f17, false);
                    fw a17 = faVar.a(tk.this.o());
                    double d16 = a17.f148383a;
                    double d17 = d16 - a16.f148383a;
                    double d18 = a17.f148384b;
                    GeoPoint a18 = faVar.a(new fw(d16 + d17, d18 + (d18 - a16.f148384b)));
                    tk tkVar4 = tk.this;
                    tkVar4.f150514d.nativeSetCenter(tkVar4.f150515e, a18, false);
                }
                return Boolean.TRUE;
            }
        }, (CallbackRunnable<Boolean>) Boolean.FALSE);
    }

    public final void a(final int i3, final int i16, final int i17, final int i18) {
        if (0 == this.f150515e || this.f150520j == null) {
            return;
        }
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.6
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeSetViewport(tkVar.f150515e, i3, i16, i17, i18);
                }
            }
        });
    }

    public final void a(final int i3) {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.10
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (0 == tk.this.f150515e) {
                    return;
                }
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetMaxScaleLevel(tkVar.f150515e, i3);
            }
        });
    }

    public final int a(final TileOverlayCallback tileOverlayCallback, final boolean z16, final boolean z17) {
        return ((Integer) a((CallbackRunnable<CallbackRunnable<Integer>>) new CallbackRunnable<Integer>() { // from class: com.tencent.mapsdk.internal.tk.15
            private Integer a() {
                if (tk.this.f150515e == 0) {
                    return -1;
                }
                tk tkVar = tk.this;
                return Integer.valueOf(tkVar.f150514d.nativeAddTileOverlay(tkVar.f150515e, tileOverlayCallback, z16, z17));
            }

            @Override // com.tencent.map.tools.CallbackRunnable
            public final /* synthetic */ Integer run() {
                if (tk.this.f150515e == 0) {
                    return -1;
                }
                tk tkVar = tk.this;
                return Integer.valueOf(tkVar.f150514d.nativeAddTileOverlay(tkVar.f150515e, tileOverlayCallback, z16, z17));
            }
        }, (CallbackRunnable<Integer>) (-1))).intValue();
    }

    public final void a(final int i3, final int i16, final int i17) {
        if (this.f150515e == 0 || this.f150520j == null) {
            return;
        }
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.17
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e != 0) {
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeSetTileOverlayDataLevelRange(tkVar.f150515e, i3, i16, i17);
                }
            }
        });
    }

    private void a(oy oyVar) {
        this.f150514d.setMapCallbackGetGLContext(oyVar);
    }

    public final void a(final int i3, final float f16) {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.27
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e == 0) {
                    return;
                }
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetPriority(tkVar.f150515e, i3, f16);
            }
        });
    }

    public final void a(final List<MapRouteSection> list, final List<GeoPoint> list2) {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.28
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                List list3;
                List list4;
                if (0 != tk.this.f150515e && (list3 = list) != null && !list3.isEmpty() && (list4 = list2) != null && !list4.isEmpty()) {
                    int size = list.size();
                    byte[][] bArr = new byte[size];
                    for (int i3 = 0; i3 < size; i3++) {
                        MapRouteSection mapRouteSection = (MapRouteSection) list.get(i3);
                        if (mapRouteSection != null) {
                            bArr[i3] = mapRouteSection.toBytes();
                        }
                    }
                    int size2 = list2.size();
                    tk tkVar = tk.this;
                    tkVar.f150514d.nativeAddRouteNameSegments(tkVar.f150515e, bArr, size, (GeoPoint[]) list2.toArray(new GeoPoint[size2]), size2);
                }
            }
        });
    }

    private AnnocationTextResult a(AnnocationText annocationText) {
        return (AnnocationTextResult) a(new AnonymousClass30(annocationText), (AnonymousClass30) null);
    }

    private List<Integer> a(Rect rect, int i3) {
        return (List) a(new AnonymousClass31(rect, i3), (AnonymousClass31) null);
    }

    private void a(String str, String str2, String str3) {
        a(new AnonymousClass33(str, str2, str3));
    }

    public final void a(final String str, final String str2) {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.45
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e == 0) {
                    return;
                }
                tk tkVar = tk.this;
                tkVar.f150514d.nativeSetBuildingToSpecificFloor(tkVar.f150515e, str, str2);
                ox oxVar = tk.this.f150519i;
                if (oxVar != null) {
                    oxVar.c();
                }
            }
        });
    }

    public final void a(final double[] dArr, final double[] dArr2, final int i3) {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.51
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e == 0) {
                    return;
                }
                tk tkVar = tk.this;
                tkVar.f150514d.setRestrictBounds(tkVar.f150515e, dArr, dArr2, i3);
            }
        });
    }

    private int a(GeoPoint[] geoPointArr, PolylineOptions.Text text) {
        return ((Integer) a((CallbackRunnable<AnonymousClass52>) new AnonymousClass52(geoPointArr, text), (AnonymousClass52) (-1))).intValue();
    }

    private void a(int i3, PolylineOptions.Text text) {
        a(new AnonymousClass54(i3, text));
    }

    public final long a(final MarkerInfo markerInfo) {
        return ((Long) a((CallbackRunnable<CallbackRunnable<Long>>) new CallbackRunnable<Long>() { // from class: com.tencent.mapsdk.internal.tk.56
            private Long a() {
                if (tk.this.f150515e == 0) {
                    return 0L;
                }
                tk tkVar = tk.this;
                return Long.valueOf(tkVar.f150514d.nativeAddMarker2(tkVar.f150515e, markerInfo));
            }

            @Override // com.tencent.map.tools.CallbackRunnable
            public final /* synthetic */ Long run() {
                if (tk.this.f150515e == 0) {
                    return 0L;
                }
                tk tkVar = tk.this;
                return Long.valueOf(tkVar.f150514d.nativeAddMarker2(tkVar.f150515e, markerInfo));
            }
        }, (CallbackRunnable<Long>) 0L)).longValue();
    }

    public final int a(final long j3) {
        return ((Integer) a((CallbackRunnable<CallbackRunnable<Integer>>) new CallbackRunnable<Integer>() { // from class: com.tencent.mapsdk.internal.tk.58
            private Integer a() {
                if (tk.this.f150515e == 0) {
                    return 0;
                }
                return Integer.valueOf(tk.this.f150514d.nativeGetEngineId(j3));
            }

            @Override // com.tencent.map.tools.CallbackRunnable
            public final /* synthetic */ Integer run() {
                if (tk.this.f150515e == 0) {
                    return 0;
                }
                return Integer.valueOf(tk.this.f150514d.nativeGetEngineId(j3));
            }
        }, (CallbackRunnable<Integer>) 0)).intValue();
    }

    public final void a(final long j3, final MarkerInfo markerInfo) {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.59
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e == 0) {
                    return;
                }
                tk.this.f150514d.nativeUpdateMarker(j3, markerInfo);
            }
        });
    }

    public final void a(int i3, int i16, boolean z16) {
        if (this.f150515e == 0) {
            return;
        }
        this.f150514d.nativeSetMarkerMainSubRelation(this.f150515e, i3, i16, z16);
    }

    private long a(AggregationOverlayInfo aggregationOverlayInfo) {
        return ((Long) a((CallbackRunnable<AnonymousClass62>) new AnonymousClass62(aggregationOverlayInfo), (AnonymousClass62) 0L)).longValue();
    }

    private void a(long j3, AggregationOverlayInfo aggregationOverlayInfo) {
        a(new AnonymousClass63(j3, aggregationOverlayInfo));
    }

    private long a(HeatmapInfo heatmapInfo) {
        return ((Long) a((CallbackRunnable<AnonymousClass64>) new AnonymousClass64(heatmapInfo), (AnonymousClass64) 0L)).longValue();
    }

    private void a(long j3, HeatmapInfo heatmapInfo) {
        a(new AnonymousClass65(j3, heatmapInfo));
    }

    private VectorHeatAggregationUnit a(long j3, LatLng latLng) {
        return (VectorHeatAggregationUnit) a(new AnonymousClass67(j3, latLng), (AnonymousClass67) null);
    }

    private long a(ArcLineOverlayInfo arcLineOverlayInfo) {
        return ((Long) a((CallbackRunnable<AnonymousClass69>) new AnonymousClass69(arcLineOverlayInfo), (AnonymousClass69) 0L)).longValue();
    }

    private void a(long j3, ArcLineOverlayInfo arcLineOverlayInfo) {
        a(new AnonymousClass70(j3, arcLineOverlayInfo));
    }

    private long a(ScatterPlotInfo scatterPlotInfo) {
        return ((Long) a((CallbackRunnable<AnonymousClass71>) new AnonymousClass71(scatterPlotInfo), (AnonymousClass71) 0L)).longValue();
    }

    private void a(long j3, ScatterPlotInfo scatterPlotInfo) {
        a(new AnonymousClass72(j3, scatterPlotInfo));
    }

    private long a(TrailOverlayInfo trailOverlayInfo) {
        return ((Long) a((CallbackRunnable<AnonymousClass73>) new AnonymousClass73(trailOverlayInfo), (AnonymousClass73) 0L)).longValue();
    }

    private void a(long j3, TrailOverlayInfo trailOverlayInfo) {
        a(new AnonymousClass74(j3, trailOverlayInfo));
    }

    private long a(GroundOverlayInfo groundOverlayInfo) {
        return ((Long) a((CallbackRunnable<AnonymousClass76>) new AnonymousClass76(groundOverlayInfo), (AnonymousClass76) 0L)).longValue();
    }

    private void a(long j3, GroundOverlayInfo groundOverlayInfo) {
        a(new AnonymousClass77(j3, groundOverlayInfo));
    }

    private long a(IntersectionOverlayInfo intersectionOverlayInfo) {
        return ((Long) a((CallbackRunnable<AnonymousClass78>) new AnonymousClass78(intersectionOverlayInfo), (AnonymousClass78) 0L)).longValue();
    }

    private void a(long j3, IntersectionOverlayInfo intersectionOverlayInfo) {
        a(new AnonymousClass80(j3, intersectionOverlayInfo));
    }

    private long a(GLModelInfo gLModelInfo) {
        return ((Long) a((CallbackRunnable<AnonymousClass81>) new AnonymousClass81(gLModelInfo), (AnonymousClass81) 0L)).longValue();
    }

    private void a(long j3, GLModelInfo gLModelInfo) {
        a(new AnonymousClass82(j3, gLModelInfo));
    }

    private void a(long j3, int i3, float f16, boolean z16) {
        a(new AnonymousClass83(j3, i3, f16, z16));
    }

    private void a(long j3, int i3) {
        a(new AnonymousClass91(j3, i3));
    }

    private void a(long j3, float f16, float f17, float f18) {
        a(new AnonymousClass92(j3, f16, f17, f18));
    }

    private void a(LightColor lightColor, float f16) {
        a(new AnonymousClass94(lightColor, f16));
    }

    private void a(LightType lightType, LightColor lightColor, LightDirection lightDirection, float f16) {
        a(new AnonymousClass95(lightType, lightColor, lightDirection, f16));
    }

    public final void a(final TrafficStyle trafficStyle) {
        a(new ne.a() { // from class: com.tencent.mapsdk.internal.tk.96
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (tk.this.f150515e == 0) {
                    return;
                }
                tk tkVar = tk.this;
                tkVar.f150514d.setTrafficStyle(tkVar.f150515e, trafficStyle);
            }
        });
    }

    public final void a(String str, byte[] bArr) {
        if (this.f150515e == 0) {
            return;
        }
        this.f150514d.nativeWriteMapDataBlock(this.f150515e, str, bArr);
    }

    @Override // com.tencent.mapsdk.internal.bs
    public final void a(String str) {
        this.f150525y = str;
    }

    @Override // com.tencent.mapsdk.internal.bs
    public final String a() {
        String str = this.f150525y;
        this.f150525y = null;
        return str;
    }

    @Override // com.tencent.mapsdk.internal.pe
    public final void a(float f16, float f17, long j3, String str, String str2) {
        Pair<VectorOverlay, TencentMap.IClickedObject> pair;
        TencentMap.OnVectorOverlayClickListener onVectorOverlayClickListener;
        ne neVar = this.f150520j;
        if (neVar != null) {
            if (j3 > 0) {
                LatLng fromScreenLocation = neVar.f149403p.fromScreenLocation(new Point((int) f16, (int) f17));
                nh<?> nhVar = neVar.f149400m.f147881e.get(nr.class);
                if (nhVar != null) {
                    pair = nhVar.a(fromScreenLocation, j3, str, str2);
                } else {
                    pair = new Pair<>(null, null);
                }
                Object obj = pair.first;
                if (obj != null && (onVectorOverlayClickListener = neVar.O) != null) {
                    onVectorOverlayClickListener.onClicked((VectorOverlay) obj, (TencentMap.IClickedObject) pair.second);
                }
            } else {
                neVar.P.b(f16, f17);
            }
            neVar.P = null;
        }
    }

    private static void a(double[] dArr, double d16, double d17) {
        for (int i3 = 0; i3 < 4; i3++) {
            int i16 = i3 + 0;
            int i17 = i16 + 12;
            dArr[i17] = dArr[i17] + (dArr[i16] * d16) + (dArr[i16 + 4] * d17) + (dArr[i16 + 8] * 0.0d);
        }
    }

    public final void a(final ne.a aVar) {
        if (this.f150520j == null || this.f150515e == 0) {
            return;
        }
        c((CallbackRunnable<CallbackRunnable<Object>>) new CallbackRunnable<Object>() { // from class: com.tencent.mapsdk.internal.tk.99
            @Override // com.tencent.map.tools.CallbackRunnable
            public final Object run() {
                aVar.a(null);
                return null;
            }
        }, (CallbackRunnable<Object>) null);
    }

    public final <T> T a(CallbackRunnable<T> callbackRunnable, T t16) {
        if (this.f150520j != null) {
            if (this.f150515e != 0) {
                try {
                    return (T) b((CallbackRunnable<CallbackRunnable<T>>) callbackRunnable, (CallbackRunnable<T>) t16);
                } catch (Exception e16) {
                    LogUtil.c(ky.f149101g, "safeCallSyncEngine", e16);
                    return t16;
                }
            }
        }
        return t16;
    }

    @Override // com.tencent.mapsdk.internal.pc
    public final void a(int[] iArr, int[] iArr2) {
        LogUtil.b("Marker", "dispatchMarkerCollisionChanged hidden = " + Arrays.toString(iArr) + " shown = " + Arrays.toString(iArr2));
        if (iArr == null && iArr2 == null) {
            return;
        }
        List<Marker> b16 = this.f150520j.M.b();
        ArrayList arrayList = new ArrayList();
        Iterator<Marker> it = b16.iterator();
        while (it.hasNext()) {
            ax axVar = (ax) it.next();
            if (!axVar.f147778b.n()) {
                arrayList.add(axVar.f147778b);
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ((ap) it5.next()).a(iArr, iArr2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ int a(tk tkVar, qv qvVar) {
        boolean z16;
        int i3;
        boolean z17;
        List<Integer> list;
        int[] iArr;
        int[] iArr2;
        ga gaVar = qvVar.f149938b;
        int i16 = gaVar.C;
        int i17 = 0;
        if (i16 == 3) {
            z16 = true;
            i16 = 0;
        } else {
            z16 = false;
        }
        int i18 = qvVar.f149940p[0];
        if (i18 == 33) {
            i3 = 2;
        } else {
            i3 = i16;
            if (i18 == 20) {
                z17 = true;
                int[] iArr3 = new int[0];
                list = gaVar.L;
                if (list == null) {
                    int[] iArr4 = new int[list.size()];
                    for (int i19 = 0; i19 < qvVar.f149938b.L.size(); i19++) {
                        iArr4[i19] = qvVar.f149938b.L.get(i19).intValue();
                    }
                    iArr = iArr4;
                } else {
                    iArr = iArr3;
                }
                int[] iArr5 = new int[0];
                iArr2 = qvVar.f149938b.f148438t;
                if (iArr2 != null) {
                    iArr5 = new int[iArr2.length];
                    while (true) {
                        int[] iArr6 = qvVar.f149938b.f148438t;
                        if (i17 >= iArr6.length) {
                            break;
                        }
                        iArr5[i17] = iArr6[i17];
                        i17++;
                    }
                }
                return ((Integer) tkVar.c((CallbackRunnable<AnonymousClass123>) new AnonymousClass123(qvVar, i3, z16, z17, iArr5, iArr), (AnonymousClass123) (-1))).intValue();
            }
        }
        z17 = false;
        int[] iArr32 = new int[0];
        list = gaVar.L;
        if (list == null) {
        }
        int[] iArr52 = new int[0];
        iArr2 = qvVar.f149938b.f148438t;
        if (iArr2 != null) {
        }
        return ((Integer) tkVar.c((CallbackRunnable<AnonymousClass123>) new AnonymousClass123(qvVar, i3, z16, z17, iArr52, iArr), (AnonymousClass123) (-1))).intValue();
    }
}

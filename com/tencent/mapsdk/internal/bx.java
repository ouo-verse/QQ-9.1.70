package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import com.tencent.map.sdk.utilities.heatmap.Gradient;
import com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.kp;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Tile;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class bx extends HeatMapTileProvider {

    /* renamed from: a, reason: collision with root package name */
    static final double f147944a = 1.0d;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f147945b = false;

    /* renamed from: c, reason: collision with root package name */
    private static final int f147946c = 256;

    /* renamed from: d, reason: collision with root package name */
    private static final int f147947d = 1280;

    /* renamed from: e, reason: collision with root package name */
    private static final int f147948e = 5;

    /* renamed from: f, reason: collision with root package name */
    private static final int f147949f = 11;

    /* renamed from: g, reason: collision with root package name */
    private static final int f147950g = 22;

    /* renamed from: h, reason: collision with root package name */
    private final HeatMapTileProvider.OnHeatMapReadyListener f147951h;

    /* renamed from: i, reason: collision with root package name */
    private HeatMapTileProvider.HeatTileGenerator f147952i;

    /* renamed from: j, reason: collision with root package name */
    private gf<by> f147953j;

    /* renamed from: k, reason: collision with root package name */
    private Collection<by> f147954k;

    /* renamed from: l, reason: collision with root package name */
    private fv f147955l;

    /* renamed from: m, reason: collision with root package name */
    private int f147956m;

    /* renamed from: n, reason: collision with root package name */
    private Gradient f147957n;

    /* renamed from: o, reason: collision with root package name */
    private int[] f147958o;

    /* renamed from: p, reason: collision with root package name */
    private double[] f147959p;

    /* renamed from: q, reason: collision with root package name */
    private double f147960q;

    /* renamed from: r, reason: collision with root package name */
    private double[] f147961r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f147962s;

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.bx$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    final class AnonymousClass1 extends kp.g<Boolean> {
        AnonymousClass1() {
        }

        private Boolean a() throws Exception {
            if (bx.this.f147962s) {
                return Boolean.FALSE;
            }
            if (bx.this.f147952i != null) {
                bx bxVar = bx.this;
                bxVar.f147959p = bxVar.f147952i.generateKernel(bx.this.f147956m);
            } else {
                bx bxVar2 = bx.this;
                bxVar2.f147959p = bx.a(bxVar2.f147956m, bx.this.f147956m / 3.0d);
            }
            bx bxVar3 = bx.this;
            bxVar3.setGradient(bxVar3.f147957n);
            bx bxVar4 = bx.this;
            bxVar4.a(bxVar4.f147954k);
            bx.f(bx.this);
            if (bx.this.f147951h != null) {
                bx.this.f147951h.onHeatMapReady();
            }
            return Boolean.TRUE;
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Object call() throws Exception {
            if (bx.this.f147962s) {
                return Boolean.FALSE;
            }
            if (bx.this.f147952i != null) {
                bx bxVar = bx.this;
                bxVar.f147959p = bxVar.f147952i.generateKernel(bx.this.f147956m);
            } else {
                bx bxVar2 = bx.this;
                bxVar2.f147959p = bx.a(bxVar2.f147956m, bx.this.f147956m / 3.0d);
            }
            bx bxVar3 = bx.this;
            bxVar3.setGradient(bxVar3.f147957n);
            bx bxVar4 = bx.this;
            bxVar4.a(bxVar4.f147954k);
            bx.f(bx.this);
            if (bx.this.f147951h != null) {
                bx.this.f147951h.onHeatMapReady();
            }
            return Boolean.TRUE;
        }
    }

    public bx(HeatMapTileProvider.Builder builder) {
        this.f147954k = d(builder.getData());
        this.f147956m = builder.getRadius();
        this.f147957n = builder.getGradient();
        this.f147960q = builder.getOpacity();
        this.f147951h = builder.getReadyListener();
        this.f147952i = builder.getHeatTileGenerator();
        if (this.f147954k != null) {
            kp.a((kp.g) new AnonymousClass1()).a((kp.b.a) Boolean.FALSE);
        }
    }

    static /* synthetic */ boolean f(bx bxVar) {
        bxVar.f147962s = true;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00de  */
    @Override // com.tencent.tencentmap.mapsdk.maps.model.TileProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Tile getTile(int i3, int i16, int i17) {
        double d16;
        fv fvVar;
        fv fvVar2;
        if (!this.f147962s) {
            LogUtil.d("TileOverlay", "\u70ed\u529b\u56fe\u672a\u521d\u59cb\u5316\u5b8c\u6210\uff0c\u8fd4\u56de\u7a7a\u74e6\u5757");
            return TileProvider.NO_TILE;
        }
        double pow = 1.0d / Math.pow(2.0d, i17);
        double d17 = (this.f147956m * pow) / 256.0d;
        double d18 = ((2.0d * d17) + pow) / ((r4 * 2) + 256);
        double d19 = (i3 * pow) - d17;
        double d26 = ((i3 + 1) * pow) + d17;
        double d27 = (i16 * pow) - d17;
        double d28 = ((i16 + 1) * pow) + d17;
        Collection<by> arrayList = new ArrayList<>();
        double d29 = 0.0d;
        if (d19 < 0.0d) {
            arrayList = this.f147953j.a(new fv(d19 + 1.0d, 1.0d, d27, d28));
            d29 = -1.0d;
        } else if (d26 > 1.0d) {
            arrayList = this.f147953j.a(new fv(0.0d, d26 - 1.0d, d27, d28));
            d16 = 1.0d;
            fvVar = new fv(d19, d26, d27, d28);
            fvVar2 = this.f147955l;
            if (fvVar.a(new fv(fvVar2.f148377a - d17, fvVar2.f148379c + d17, fvVar2.f148378b - d17, fvVar2.f148380d + d17))) {
                LogUtil.d("TileOverlay", "\u70ed\u529b\u56fe\u8d85\u51fa\u6709\u6548\u8fb9\u754c\uff0c\u8fd4\u56de\u7a7a\u74e6\u5757-" + i3 + ":" + i16 + ":" + i17);
                return TileProvider.NO_TILE;
            }
            Collection<by> a16 = this.f147953j.a(fvVar);
            if (a16.isEmpty()) {
                LogUtil.d("TileOverlay", "\u70ed\u529b\u56fe\u6ca1\u6709\u70ed\u529b\u6570\u636e\uff0c\u8fd4\u56de\u7a7a\u74e6\u5757-" + i3 + ":" + i16 + ":" + i17);
                return TileProvider.NO_TILE;
            }
            int i18 = this.f147956m;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, (i18 * 2) + 256, (i18 * 2) + 256);
            for (by byVar : a16) {
                fw fwVar = byVar.f147966b;
                int i19 = (int) ((fwVar.f148383a - d19) / d18);
                int i26 = (int) ((fwVar.f148384b - d27) / d18);
                double[] dArr2 = dArr[i19];
                dArr2[i26] = dArr2[i26] + byVar.f147967c;
            }
            for (by byVar2 : arrayList) {
                fw fwVar2 = byVar2.f147966b;
                int i27 = (int) (((fwVar2.f148383a + d16) - d19) / d18);
                int i28 = (int) ((fwVar2.f148384b - d27) / d18);
                double[] dArr3 = dArr[i27];
                dArr3[i28] = dArr3[i28] + byVar2.f147967c;
            }
            Bitmap a17 = a(a(dArr, this.f147959p), this.f147958o, this.f147961r[i17]);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            a17.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return new Tile(256, 256, byteArrayOutputStream.toByteArray());
        }
        d16 = d29;
        fvVar = new fv(d19, d26, d27, d28);
        fvVar2 = this.f147955l;
        if (fvVar.a(new fv(fvVar2.f148377a - d17, fvVar2.f148379c + d17, fvVar2.f148378b - d17, fvVar2.f148380d + d17))) {
        }
    }

    @Override // com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider
    public final void setData(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new by(it.next()));
        }
        a(arrayList);
    }

    @Override // com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider
    public final void setGradient(Gradient gradient) {
        this.f147957n = gradient;
        HeatMapTileProvider.HeatTileGenerator heatTileGenerator = this.f147952i;
        if (heatTileGenerator != null) {
            this.f147958o = heatTileGenerator.generateColorMap(this.f147960q);
        } else {
            this.f147958o = gradient.generateColorMap(this.f147960q);
        }
    }

    @Override // com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider
    public final void setHeatTileGenerator(HeatMapTileProvider.HeatTileGenerator heatTileGenerator) {
        this.f147952i = heatTileGenerator;
        if (heatTileGenerator != null) {
            this.f147959p = heatTileGenerator.generateKernel(this.f147956m);
            this.f147958o = this.f147952i.generateColorMap(this.f147960q);
        }
    }

    @Override // com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider
    public final void setOpacity(double d16) {
        this.f147960q = d16;
        setGradient(this.f147957n);
    }

    @Override // com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider
    public final void setRadius(int i3) {
        if (i3 <= 0) {
            return;
        }
        this.f147956m = i3;
        HeatMapTileProvider.HeatTileGenerator heatTileGenerator = this.f147952i;
        if (heatTileGenerator != null) {
            this.f147959p = heatTileGenerator.generateKernel(i3);
        } else {
            this.f147959p = a(i3, i3 / 3.0d);
        }
        this.f147961r = a(this.f147956m);
    }

    @Override // com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider
    public final <T extends WeightedLatLng> void setWeightedData(Collection<T> collection) {
        a(d(collection));
    }

    private static fv b(Collection<by> collection) {
        Iterator<by> it = collection.iterator();
        fw fwVar = it.next().f147966b;
        double d16 = fwVar.f148383a;
        double d17 = d16;
        double d18 = fwVar.f148384b;
        double d19 = d18;
        while (it.hasNext()) {
            fw fwVar2 = it.next().f147966b;
            double d26 = fwVar2.f148383a;
            double d27 = fwVar2.f148384b;
            if (d26 < d16) {
                d16 = d26;
            }
            if (d26 > d17) {
                d17 = d26;
            }
            if (d27 < d18) {
                d18 = d27;
            }
            if (d27 > d19) {
                d19 = d27;
            }
        }
        return new fv(d16, d17, d18, d19);
    }

    private static Collection<by> c(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new by(it.next()));
        }
        return arrayList;
    }

    private static <T extends WeightedLatLng> Collection<by> d(Collection<T> collection) {
        ArrayList arrayList = new ArrayList();
        for (T t16 : collection) {
            arrayList.add(new by(t16.getPoint(), t16.getIntensity()));
        }
        return arrayList;
    }

    private void a() {
        if (this.f147954k != null) {
            kp.a((kp.g) new AnonymousClass1()).a((kp.b.a) Boolean.FALSE);
        }
    }

    public final void a(Collection<by> collection) {
        this.f147954k = collection;
        if (!collection.isEmpty()) {
            fv b16 = b(this.f147954k);
            this.f147955l = b16;
            this.f147953j = new gf<>(b16);
            Iterator<by> it = this.f147954k.iterator();
            while (it.hasNext()) {
                this.f147953j.a((gf<by>) it.next());
            }
            this.f147961r = a(this.f147956m);
            return;
        }
        throw new IllegalArgumentException("No input points.");
    }

    private double[] a(int i3) {
        int i16;
        double[] dArr = new double[22];
        int i17 = 5;
        while (true) {
            if (i17 >= 11) {
                break;
            }
            dArr[i17] = a(this.f147954k, this.f147955l, i3, (int) (Math.pow(2.0d, i17 - 3) * 1280.0d));
            if (i17 == 5) {
                for (int i18 = 0; i18 < i17; i18++) {
                    dArr[i18] = dArr[i17];
                }
            }
            i17++;
        }
        for (i16 = 11; i16 < 22; i16++) {
            dArr[i16] = dArr[10];
        }
        return dArr;
    }

    private static Tile a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new Tile(256, 256, byteArrayOutputStream.toByteArray());
    }

    static double[] a(int i3, double d16) {
        double[] dArr = new double[(i3 * 2) + 1];
        for (int i16 = -i3; i16 <= i3; i16++) {
            dArr[i16 + i3] = Math.exp(((-i16) * i16) / ((2.0d * d16) * d16));
        }
        return dArr;
    }

    private static double[][] a(double[][] dArr, double[] dArr2) {
        int floor = (int) Math.floor(dArr2.length / 2.0d);
        int length = dArr.length;
        int i3 = length - (floor * 2);
        int i16 = 1;
        int i17 = (floor + i3) - 1;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length);
        int i18 = 0;
        while (true) {
            double d16 = 0.0d;
            if (i18 >= length) {
                break;
            }
            int i19 = 0;
            while (i19 < length) {
                double d17 = dArr[i18][i19];
                if (d17 != d16) {
                    int i26 = i18 + floor;
                    if (i17 < i26) {
                        i26 = i17;
                    }
                    int i27 = i26 + 1;
                    int i28 = i18 - floor;
                    for (int i29 = floor > i28 ? floor : i28; i29 < i27; i29++) {
                        double[] dArr4 = dArr3[i29];
                        dArr4[i19] = dArr4[i19] + (dArr2[i29 - i28] * d17);
                    }
                }
                i19++;
                d16 = 0.0d;
            }
            i18++;
        }
        double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i3, i3);
        int i36 = floor;
        while (i36 < i17 + 1) {
            int i37 = 0;
            while (i37 < length) {
                double d18 = dArr3[i36][i37];
                if (d18 != 0.0d) {
                    int i38 = i37 + floor;
                    if (i17 < i38) {
                        i38 = i17;
                    }
                    int i39 = i38 + i16;
                    int i46 = i37 - floor;
                    for (int i47 = floor > i46 ? floor : i46; i47 < i39; i47++) {
                        double[] dArr6 = dArr5[i36 - floor];
                        int i48 = i47 - floor;
                        dArr6[i48] = dArr6[i48] + (dArr2[i47 - i46] * d18);
                    }
                }
                i37++;
                i16 = 1;
            }
            i36++;
            i16 = 1;
        }
        return dArr5;
    }

    private static Bitmap a(double[][] dArr, int[] iArr, double d16) {
        int i3 = iArr[iArr.length - 1];
        double length = (iArr.length - 1) / d16;
        int length2 = dArr.length;
        int[] iArr2 = new int[length2 * length2];
        for (int i16 = 0; i16 < length2; i16++) {
            for (int i17 = 0; i17 < length2; i17++) {
                double d17 = dArr[i17][i16];
                int i18 = (i16 * length2) + i17;
                int i19 = (int) (d17 * length);
                if (d17 != 0.0d) {
                    if (i19 < iArr.length) {
                        iArr2[i18] = iArr[i19];
                    } else {
                        iArr2[i18] = i3;
                    }
                } else {
                    iArr2[i18] = 0;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }

    private static double a(Collection<by> collection, fv fvVar, int i3, int i16) {
        double d16 = fvVar.f148377a;
        double d17 = fvVar.f148379c;
        double d18 = fvVar.f148378b;
        double d19 = d17 - d16;
        double d26 = fvVar.f148380d - d18;
        if (d19 <= d26) {
            d19 = d26;
        }
        double d27 = ((int) ((i16 / (i3 * 2)) + 0.5d)) / d19;
        HashMap hashMap = new HashMap();
        double d28 = 0.0d;
        for (by byVar : collection) {
            fw fwVar = byVar.f147966b;
            double d29 = fwVar.f148383a;
            double d36 = fwVar.f148384b;
            int i17 = (int) ((d29 - d16) * d27);
            int i18 = (int) ((d36 - d18) * d27);
            Map map = (Map) hashMap.get(Integer.valueOf(i17));
            if (map == null) {
                map = new HashMap();
                hashMap.put(Integer.valueOf(i17), map);
            }
            Double d37 = (Double) map.get(Integer.valueOf(i18));
            if (d37 == null) {
                d37 = Double.valueOf(0.0d);
            }
            Double valueOf = Double.valueOf(d37.doubleValue() + byVar.f147967c);
            map.put(Integer.valueOf(i18), valueOf);
            if (valueOf.doubleValue() > d28) {
                d28 = valueOf.doubleValue();
            }
        }
        return d28;
    }
}

package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.Pair;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.map.lib.models.MarkerInfo;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.ce;
import com.tencent.mapsdk.internal.cg;
import com.tencent.mapsdk.internal.hr;
import com.tencent.mapsdk.internal.v;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class rj implements cg {

    /* renamed from: b, reason: collision with root package name */
    private static final String f150045b = "PromoteImageLayer";

    /* renamed from: a, reason: collision with root package name */
    final Map<ce, Long> f150046a = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private boolean f150047c;

    /* renamed from: d, reason: collision with root package name */
    private CameraPosition f150048d;

    /* renamed from: e, reason: collision with root package name */
    private final cf f150049e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public rj(cf cfVar) {
        this.f150049e = cfVar;
    }

    private long b(ce ceVar) {
        bf bfVar = (bf) this.f150049e.getMapContext();
        Long l3 = this.f150046a.get(ceVar);
        if (l3 == null || l3.longValue() == 0) {
            return 0L;
        }
        LatLng b16 = ceVar.b();
        BitmapDescriptor b17 = ceVar.b(this.f150047c);
        bfVar.g().a(l3.longValue(), new MarkerInfo(b16.latitude, b16.longitude, b17.getBDId()).displayLevel(2).iconWidth(b17.getWidth()).iconHeight(b17.getHeight()).minScaleLevel(ceVar.d().f148488b).maxScaleLevel(ceVar.d().f148489c).interactive(false).priority(ceVar.c()));
        return l3.longValue();
    }

    private void c(ce ceVar) {
        bf bfVar = (bf) this.f150049e.getMapContext();
        Long remove = this.f150046a.remove(ceVar);
        if (remove == null || remove.longValue() == 0) {
            return;
        }
        bfVar.g().b(remove.longValue());
    }

    @Override // com.tencent.mapsdk.internal.cg
    public final void a() {
        LogUtil.b(f150045b, "initLayer ");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mapsdk.internal.cg
    public final void a(CameraPosition cameraPosition, boolean z16) {
        this.f150047c = z16;
        this.f150048d = cameraPosition;
        bf bfVar = (bf) this.f150049e.getMapContext();
        hi hiVar = ((bp) bfVar).f147918e;
        VisibleRegion visibleRegion = bfVar.b().getMap().getProjection().getVisibleRegion();
        HashSet<v.b> hashSet = new HashSet();
        hashSet.add(y.c(visibleRegion.farLeft));
        hashSet.add(y.c(visibleRegion.farRight));
        hashSet.add(y.c(visibleRegion.nearRight));
        hashSet.add(y.c(visibleRegion.nearLeft));
        for (v.b bVar : hashSet) {
            List<ce> a16 = this.f150049e.d().a(bVar.f151292a, bVar.f151293b, bVar.f151294c);
            if (a16 != null) {
                for (ce ceVar : a16) {
                    ce.a g16 = ceVar.g();
                    ce.a aVar = ce.a.ADD;
                    if (g16 == aVar && ceVar.d().a((int) cameraPosition.zoom) && visibleRegion.latLngBounds.contains(ceVar.b())) {
                        hiVar.r().a(ceVar.a());
                        ceVar.a(ce.a.SHOWING);
                    } else if (ceVar.g() == ce.a.SHOWING && (!visibleRegion.latLngBounds.contains(ceVar.b()) || !ceVar.d().a((int) cameraPosition.zoom))) {
                        ceVar.a(aVar);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.cg
    public final void c() {
        LogUtil.b(f150045b, "destroyLayer ");
        bf bfVar = (bf) this.f150049e.getMapContext();
        for (Long l3 : this.f150046a.values()) {
            if (l3 != null && l3.longValue() != 0) {
                bfVar.g().b(l3.longValue());
            }
        }
        this.f150046a.clear();
    }

    @Override // com.tencent.mapsdk.internal.cg
    public final List<cg.b> b() {
        return hr.a((Iterable) this.f150046a.keySet(), (hr.h) new hr.h<ce, cg.b>() { // from class: com.tencent.mapsdk.internal.rj.1

            /* renamed from: b, reason: collision with root package name */
            int f150050b;

            @Override // com.tencent.mapsdk.internal.hr.h
            public final /* synthetic */ cg.b a(ce ceVar) {
                ce ceVar2 = ceVar;
                cg.b bVar = new cg.b();
                bVar.f148043c = ceVar2.g() == ce.a.SHOWING;
                bVar.f148042b = ceVar2.b();
                Long l3 = rj.this.f150046a.get(ceVar2);
                int i3 = this.f150050b;
                this.f150050b = i3 + 1;
                bVar.f148044d = i3;
                if (l3 == null) {
                    return null;
                }
                bVar.f148041a = l3.longValue();
                return bVar;
            }

            /* renamed from: a, reason: avoid collision after fix types in other method */
            private cg.b a2(ce ceVar) {
                cg.b bVar = new cg.b();
                bVar.f148043c = ceVar.g() == ce.a.SHOWING;
                bVar.f148042b = ceVar.b();
                Long l3 = rj.this.f150046a.get(ceVar);
                int i3 = this.f150050b;
                this.f150050b = i3 + 1;
                bVar.f148044d = i3;
                if (l3 == null) {
                    return null;
                }
                bVar.f148041a = l3.longValue();
                return bVar;
            }
        });
    }

    @Override // com.tencent.mapsdk.internal.cg
    public final BitmapDescriptor a(ce ceVar, byte[] bArr, boolean z16, boolean z17) {
        float o16 = ho.o() * 4.0f;
        float o17 = ho.o() * 1.5f;
        Pair<Integer, Integer> e16 = ceVar.e();
        float intValue = ((Integer) e16.first).intValue() * ho.o();
        float intValue2 = ((Integer) e16.second).intValue() * ho.o();
        float f16 = o16 * 2.0f;
        float f17 = intValue + f16;
        float f18 = f16 + intValue2;
        Bitmap createBitmap = Bitmap.createBitmap((int) f17, (int) f18, Bitmap.Config.ARGB_8888);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, new BitmapFactory.Options());
        float width = decodeByteArray.getWidth();
        float height = decodeByteArray.getHeight();
        float f19 = o17 + o16;
        RectF rectF = new RectF(f19, f19, (f17 - o17) - o16, (f18 - o17) - o16);
        Canvas canvas = new Canvas(createBitmap);
        float f26 = intValue / 4.0f;
        float f27 = intValue2 / 4.0f;
        Paint paint = new Paint(1);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(decodeByteArray, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, width, height), rectF, Matrix.ScaleToFit.CENTER);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(0);
        paint2.setShadowLayer(o16, 0.0f, 0.0f, ho.p());
        canvas.drawRoundRect(rectF, f26, f27, paint2);
        canvas.drawRoundRect(rectF, f26, f27, paint);
        Paint paint3 = new Paint(1);
        paint3.setColor(z16 ? HWColorFormat.COLOR_FormatVendorStartUnused : -1);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(o17);
        RectF rectF2 = new RectF(rectF);
        float f28 = o17 / 2.0f;
        rectF2.inset(f28, f28);
        canvas.drawRoundRect(rectF2, f26 - f28, f27 - f28, paint3);
        if (z17) {
            Paint paint4 = new Paint(1);
            paint4.setColor(1056964608);
            paint4.setStyle(Paint.Style.FILL);
            canvas.drawRoundRect(rectF, f26, f27, paint4);
        }
        return BitmapDescriptorFactory.fromBitmap(this.f150049e.getMapContext(), createBitmap);
    }

    private long a(ce ceVar) {
        bf bfVar = (bf) this.f150049e.getMapContext();
        LatLng b16 = ceVar.b();
        BitmapDescriptor b17 = ceVar.b(this.f150047c);
        long a16 = bfVar.g().a(new MarkerInfo(b16.latitude, b16.longitude, b17.getBDId()).displayLevel(2).iconWidth(b17.getWidth()).iconHeight(b17.getHeight()).minScaleLevel(ceVar.d().f148488b).maxScaleLevel(ceVar.d().f148489c).interactive(false).priority(ceVar.c()));
        this.f150046a.put(ceVar, Long.valueOf(a16));
        return a16;
    }

    @Override // com.tencent.mapsdk.internal.ci.a
    public final void a(Set<ce> set, Set<ce> set2, Set<ce> set3) {
        ce ceVar;
        long j3;
        long j16;
        LogUtil.b(f150045b, "onHandleSearch... add_ids:" + set + " update_ids:" + set2 + " remove_ids:" + set3);
        long j17 = 0;
        if (set3 != null && set3.size() > 0) {
            for (ce ceVar2 : set3) {
                if (ceVar2.g() == ce.a.WILL_REMOVE) {
                    bf bfVar = (bf) this.f150049e.getMapContext();
                    Long remove = this.f150046a.remove(ceVar2);
                    if (remove != null && remove.longValue() != 0) {
                        bfVar.g().b(remove.longValue());
                    }
                    ceVar2.a(ce.a.REMOVE);
                }
            }
        }
        if (set2 != null && set2.size() > 0) {
            for (ce ceVar3 : set2) {
                if (ceVar3.g() == ce.a.WILL_UPDATE) {
                    bf bfVar2 = (bf) this.f150049e.getMapContext();
                    Long l3 = this.f150046a.get(ceVar3);
                    if (l3 == null || l3.longValue() == j17) {
                        ceVar = ceVar3;
                        j3 = 0;
                        j16 = 0;
                    } else {
                        LatLng b16 = ceVar3.b();
                        BitmapDescriptor b17 = ceVar3.b(this.f150047c);
                        ceVar = ceVar3;
                        bfVar2.g().a(l3.longValue(), new MarkerInfo(b16.latitude, b16.longitude, b17.getBDId()).displayLevel(2).iconWidth(b17.getWidth()).iconHeight(b17.getHeight()).minScaleLevel(ceVar.d().f148488b).maxScaleLevel(ceVar.d().f148489c).interactive(false).priority(ceVar.c()));
                        j16 = l3.longValue();
                        j3 = 0;
                    }
                    if (j16 > j3) {
                        ceVar.a(ce.a.ADD);
                    }
                }
                j17 = 0;
            }
        }
        if (set != null && set.size() > 0) {
            for (ce ceVar4 : set) {
                if (ceVar4.g() == ce.a.WILL_ADD) {
                    bf bfVar3 = (bf) this.f150049e.getMapContext();
                    LatLng b18 = ceVar4.b();
                    BitmapDescriptor b19 = ceVar4.b(this.f150047c);
                    long a16 = bfVar3.g().a(new MarkerInfo(b18.latitude, b18.longitude, b19.getBDId()).displayLevel(2).iconWidth(b19.getWidth()).iconHeight(b19.getHeight()).minScaleLevel(ceVar4.d().f148488b).maxScaleLevel(ceVar4.d().f148489c).interactive(false).priority(ceVar4.c()));
                    this.f150046a.put(ceVar4, Long.valueOf(a16));
                    if (a16 > 0) {
                        ceVar4.a(ce.a.ADD);
                    }
                }
            }
        }
        a(this.f150048d, this.f150047c);
    }
}

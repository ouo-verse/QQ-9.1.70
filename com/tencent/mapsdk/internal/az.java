package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class az extends aw<as> implements Polyline {

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final int f147780b = 4;

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final int f147781c = 3;

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final int f147782d = 2;

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final int f147783e = 1;

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    public static final int f147784f = 6;

    /* renamed from: g, reason: collision with root package name */
    @Deprecated
    public static final int f147785g = 0;

    /* renamed from: h, reason: collision with root package name */
    @Deprecated
    public static final int f147786h = 33;

    /* renamed from: i, reason: collision with root package name */
    @Deprecated
    public static final int f147787i = 19;

    /* renamed from: j, reason: collision with root package name */
    public final as f147788j;

    public az(as asVar) {
        this.f147788j = asVar;
    }

    private void a(boolean z16) {
        this.f147788j.a(z16);
    }

    private as b() {
        return this.f147788j;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void addTurnArrow(int i3, int i16) {
        this.f147788j.addTurnArrow(i3, i16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void appendPoint(LatLng... latLngArr) {
        this.f147788j.appendPoint(latLngArr);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void appendPoints(List<LatLng> list) {
        this.f147788j.appendPoints(list);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void arrowSpacing(int i3) {
        this.f147788j.arrowSpacing(i3);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void cleanTurnArrow() {
        this.f147788j.cleanTurnArrow();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void eraseColor(int i3) {
        this.f147788j.eraseColor(i3);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void eraseTo(int i3, LatLng latLng) {
        this.f147788j.a(i3, latLng);
    }

    @Override // com.tencent.mapsdk.internal.aw
    public final /* bridge */ /* synthetic */ as f_() {
        return this.f147788j;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final int getColor() {
        return this.f147788j.getColor();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final int[][] getColors() {
        return this.f147788j.getColors();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final List<Integer> getPattern() {
        return this.f147788j.getPattern();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final List<LatLng> getPoints() {
        return this.f147788j.getPoints();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final PolylineOptions getPolylineOptions() {
        return this.f147788j.getPolylineOptions();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable
    public final Object getTag() {
        return this.f147788j.getTag();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final PolylineOptions.Text getText() {
        as asVar = this.f147788j;
        if (asVar == null) {
            return null;
        }
        return asVar.getText();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final Rect getVisibleRect() {
        return this.f147788j.getVisibleRect();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final float getWidth() {
        return this.f147788j.getWidth();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final boolean isAboveMaskLayer() {
        return this.f147788j.isAboveMaskLayer();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable
    public final boolean isClickable() {
        as asVar = this.f147788j;
        if (asVar != null) {
            return asVar.isClickable();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final boolean isGradientEnable() {
        return this.f147788j.isGradientEnable();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void pattern(List<Integer> list) {
        this.f147788j.pattern(list);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setAboveMaskLayer(boolean z16) {
        this.f147788j.setAboveMaskLayer(z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public final void setAnimation(Animation animation) {
        this.f147788j.setAnimation(animation);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setArrow(boolean z16) {
        this.f147788j.setArrow(z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setBorderColors(int[] iArr) {
        this.f147788j.setBorderColors(iArr);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable
    public final void setClickable(boolean z16) {
        this.f147788j.setClickable(z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setColor(int i3) {
        this.f147788j.setColor(i3);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setColorTexture(String str) {
        this.f147788j.setColorTexture(BitmapDescriptorFactory.fromAsset(str));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setColors(int[] iArr, int[] iArr2) {
        this.f147788j.setColors(iArr, iArr2);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setEraseable(boolean z16) {
        this.f147788j.setEraseable(z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setGradientEnable(boolean z16) {
        as asVar = this.f147788j;
        if (asVar == null) {
            return;
        }
        asVar.setGradientEnable(z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setPoints(List<LatLng> list) {
        this.f147788j.setPoints(list);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setPolylineOptions(PolylineOptions polylineOptions) {
        if (polylineOptions == null) {
            return;
        }
        this.f147788j.setPolylineOptions(polylineOptions);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable
    public final void setTag(Object obj) {
        this.f147788j.setTag(obj);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setText(PolylineOptions.Text text) {
        as asVar = this.f147788j;
        if (asVar == null) {
            return;
        }
        asVar.setText(text);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setWidth(float f16) {
        this.f147788j.setWidth(f16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public final boolean startAnimation() {
        as asVar = this.f147788j;
        if (asVar != null) {
            return asVar.startAnimation();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setColorTexture(BitmapDescriptor bitmapDescriptor) {
        this.f147788j.setColorTexture(bitmapDescriptor);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline, com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public final void startAnimation(Animation animation) {
        this.f147788j.startAnimation(animation);
    }
}

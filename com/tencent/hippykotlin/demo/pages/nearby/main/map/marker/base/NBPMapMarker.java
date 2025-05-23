package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base;

import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraPosition;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.a;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.q;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import defpackage.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPMapMarker {
    public NBPMapMarker collectionParentMarker;
    public Float collectionZoomLevel;
    public final Object data;
    public boolean isCoveredByFocusMarker;
    public boolean isVisibleOnMap;
    public final String key;
    public final IMarkerCollection markerCollection;
    public final INBPMapMarkerUpdate markerUpdate;
    public final Function1<ViewContainer<?, ?>, Unit> markerViewBuilder;
    public final w markerViewSize;
    public aa<v> opacityWrapperViewRef;
    public final NBPLatLng position;
    public float screenX;
    public float screenY;
    public NBPMarkerTransform viewPositionTransform;
    public aa<v> viewRef;
    public final double zIndex;

    /* JADX WARN: Multi-variable type inference failed */
    public NBPMapMarker(NBPLatLng nBPLatLng, Function1<? super ViewContainer<?, ?>, Unit> function1, Object obj, String str, double d16, w wVar, INBPMapMarkerUpdate iNBPMapMarkerUpdate, IMarkerCollection iMarkerCollection) {
        this.position = nBPLatLng;
        this.markerViewBuilder = function1;
        this.data = obj;
        this.key = str;
        this.zIndex = d16;
        this.markerViewSize = wVar;
        this.markerUpdate = iNBPMapMarkerUpdate;
        this.markerCollection = iMarkerCollection;
    }

    public final boolean clickInSide(float f16, float f17) {
        MarkerRect markerRectOnScreen = getMarkerRectOnScreen();
        Boolean clickInSide = this.markerUpdate.clickInSide(f16, f17, markerRectOnScreen);
        if (clickInSide != null) {
            return clickInSide.booleanValue();
        }
        if (f16 < markerRectOnScreen.left || f16 > markerRectOnScreen.right || f17 < markerRectOnScreen.top || f17 > markerRectOnScreen.bottom) {
            return false;
        }
        this.markerUpdate.onClickMarkerFromMap(f16, f17);
        return true;
    }

    public final MarkerRect getMarkerRectOnScreen() {
        MarkerRect markerRectOnScreen = this.markerUpdate.getMarkerRectOnScreen(this);
        if (markerRectOnScreen != null) {
            return markerRectOnScreen;
        }
        float width = this.screenX - (this.markerViewSize.getWidth() / 2.0f);
        float height = this.screenY - (this.markerViewSize.getHeight() / 2.0f);
        return new MarkerRect(width, height, this.markerViewSize.getWidth() + width, this.markerViewSize.getHeight() + height);
    }

    public final MarkerRect getMarkerRectOnScreenForCollection() {
        MarkerRect markerRectOnScreen = getMarkerRectOnScreen();
        return new MarkerRect(markerRectOnScreen.left - 2.0f, markerRectOnScreen.top - 2.0f, markerRectOnScreen.right + 2.0f, markerRectOnScreen.bottom + 2.0f);
    }

    public final void setCoveredByFocusMarker(final boolean z16) {
        aa<v> aaVar;
        v b16;
        if (this.isCoveredByFocusMarker == z16) {
            return;
        }
        this.isCoveredByFocusMarker = z16;
        if (k.a(c.f117352a)) {
            aaVar = this.opacityWrapperViewRef;
        } else {
            aaVar = this.viewRef;
        }
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return;
        }
        q.a.a(b16, b.Companion.l(b.INSTANCE, 0.5f, null, 2, null), null, new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMapMarker$setCoveredByFocusMarker$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Attr attr) {
                attr.m147opacity(z16 ? 0.4f : 1.0f);
                return Unit.INSTANCE;
            }
        }, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean updateByCameraPosition(CameraPosition cameraPosition) {
        NBPLatLng nBPLatLng;
        MarkerRect markerRectOnScreen;
        Float f16;
        c cVar = c.f117352a;
        float m3 = GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(cVar);
        float l3 = cVar.g().getPageData().l();
        double d16 = m3 * 1.0d;
        double d17 = cameraPosition.topRightPosition.longitude;
        NBPLatLng nBPLatLng2 = cameraPosition.topLeftPosition;
        double d18 = d16 / (d17 - nBPLatLng2.longitude);
        double d19 = (l3 * 1.0d) / (cameraPosition.bottomLeftPosition.latitude - nBPLatLng2.latitude);
        NBPMapMarker nBPMapMarker = this.collectionParentMarker;
        if ((nBPMapMarker != null ? nBPMapMarker.collectionParentMarker : null) != null) {
            this.collectionParentMarker = null;
            this.collectionZoomLevel = null;
        }
        if (this.collectionParentMarker != null) {
            float f17 = cameraPosition.zoomLevel;
            Float f18 = this.collectionZoomLevel;
            Intrinsics.checkNotNull(f18);
            if (f17 <= f18.floatValue()) {
                NBPMapMarker nBPMapMarker2 = this.collectionParentMarker;
                Intrinsics.checkNotNull(nBPMapMarker2);
                nBPLatLng = nBPMapMarker2.position;
                double d26 = nBPLatLng.longitude;
                NBPLatLng nBPLatLng3 = cameraPosition.topLeftPosition;
                this.screenX = (float) ((d26 - nBPLatLng3.longitude) * d18);
                this.screenY = (float) ((nBPLatLng.latitude - nBPLatLng3.latitude) * d19);
                float m16 = GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(cVar);
                float l16 = cVar.g().getPageData().l();
                markerRectOnScreen = this.markerUpdate.getMarkerRectOnScreen(this);
                if (markerRectOnScreen == null) {
                    float f19 = 2;
                    markerRectOnScreen = new MarkerRect(this.screenX - (this.markerViewSize.getWidth() / f19), this.screenY - (this.markerViewSize.getHeight() / f19), this.markerViewSize.getWidth() + (this.screenX - (this.markerViewSize.getWidth() / f19)), this.markerViewSize.getHeight() + (this.screenY - (this.markerViewSize.getHeight() / f19)));
                }
                float max = Math.max(0.0f, markerRectOnScreen.left);
                float max2 = Math.max(0.0f, markerRectOnScreen.top);
                float min = Math.min(m16, markerRectOnScreen.right);
                float min2 = Math.min(l16, markerRectOnScreen.bottom);
                MarkerRect markerRect = (min > max || min2 <= max2) ? null : new MarkerRect(max, max2, min, min2);
                boolean z16 = (markerRect != null ? 0.0d : ((double) (markerRect.width * markerRect.height)) / ((double) (markerRectOnScreen.width * markerRectOnScreen.height))) <= 0.0d;
                f16 = this.collectionZoomLevel;
                if (f16 != null) {
                    float f26 = cameraPosition.zoomLevel;
                    Intrinsics.checkNotNull(f16);
                    if (f26 > f16.floatValue()) {
                        this.collectionParentMarker = null;
                        this.collectionZoomLevel = null;
                    }
                }
                return z16;
            }
        }
        nBPLatLng = this.position;
        double d262 = nBPLatLng.longitude;
        NBPLatLng nBPLatLng32 = cameraPosition.topLeftPosition;
        this.screenX = (float) ((d262 - nBPLatLng32.longitude) * d18);
        this.screenY = (float) ((nBPLatLng.latitude - nBPLatLng32.latitude) * d19);
        float m162 = GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(cVar);
        float l162 = cVar.g().getPageData().l();
        markerRectOnScreen = this.markerUpdate.getMarkerRectOnScreen(this);
        if (markerRectOnScreen == null) {
        }
        float max3 = Math.max(0.0f, markerRectOnScreen.left);
        float max22 = Math.max(0.0f, markerRectOnScreen.top);
        float min3 = Math.min(m162, markerRectOnScreen.right);
        float min22 = Math.min(l162, markerRectOnScreen.bottom);
        if (min3 > max3) {
        }
        if ((markerRect != null ? 0.0d : ((double) (markerRect.width * markerRect.height)) / ((double) (markerRectOnScreen.width * markerRectOnScreen.height))) <= 0.0d) {
        }
        f16 = this.collectionZoomLevel;
        if (f16 != null) {
        }
        return z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateVisibleOnMap(boolean z16, CameraPosition cameraPosition, NBPMarkerUIScheduler nBPMarkerUIScheduler) {
        v b16;
        t tVar;
        y a16;
        u a17;
        a a18;
        v b17;
        t tVar2;
        if (this.isVisibleOnMap != z16) {
            this.isVisibleOnMap = z16;
            aa<v> aaVar = this.viewRef;
            if (aaVar != null && (b17 = aaVar.b()) != null && (tVar2 = (t) b17.getViewAttr()) != null) {
                tVar2.m152visibility(this.isVisibleOnMap);
            }
        }
        if (this.isVisibleOnMap) {
            NBPMarkerTransform markerViewTransformWhenMapChangedOnVisible = this.markerUpdate.getMarkerViewTransformWhenMapChangedOnVisible(cameraPosition.zoomLevel, this.screenX, this.screenY, nBPMarkerUIScheduler);
            if (markerViewTransformWhenMapChangedOnVisible == null) {
                markerViewTransformWhenMapChangedOnVisible = new NBPMarkerTransform(new y((this.screenX / this.markerViewSize.getWidth()) - 0.5f, (this.screenY / this.markerViewSize.getHeight()) - 0.5f, 0.0f, 0.0f, 12, null), u.INSTANCE.a());
            }
            this.viewPositionTransform = markerViewTransformWhenMapChangedOnVisible;
            aa<v> aaVar2 = this.viewRef;
            if (aaVar2 == null || (b16 = aaVar2.b()) == null || (tVar = (t) b16.getViewAttr()) == null) {
                return;
            }
            NBPMarkerTransform nBPMarkerTransform = this.viewPositionTransform;
            if (nBPMarkerTransform == null || (a16 = nBPMarkerTransform.translate) == null) {
                a16 = y.INSTANCE.a();
            }
            y yVar = a16;
            NBPMarkerTransform nBPMarkerTransform2 = this.viewPositionTransform;
            if (nBPMarkerTransform2 == null || (a17 = nBPMarkerTransform2.scale) == null) {
                a17 = u.INSTANCE.a();
            }
            u uVar = a17;
            NBPMarkerTransform nBPMarkerTransform3 = this.viewPositionTransform;
            if (nBPMarkerTransform3 == null || (a18 = nBPMarkerTransform3.anchor) == null) {
                a18 = a.INSTANCE.a();
            }
        }
    }
}

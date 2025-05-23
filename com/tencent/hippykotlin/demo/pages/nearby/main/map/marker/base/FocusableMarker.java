package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.a;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public class FocusableMarker {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(FocusableMarker.class, "status", "getStatus()Lcom/tencent/hippykotlin/demo/pages/nearby/main/map/marker/base/NBPMarkerStatus;", 0)};
    public final a anchor;
    public final float anchorX;
    public final float anchorY;
    public final float focusCenterX;
    public final float focusCenterY;
    public final float focusDistance;
    public final float focusedScale;
    public boolean readyToFocus;
    public final ReadWriteProperty status$delegate = c.a(NBPMarkerStatus.Normal);

    public FocusableMarker(float f16, float f17, float f18) {
        this.focusedScale = f16;
        this.anchorX = f17;
        this.anchorY = f18;
        this.anchor = new a(f17, f18);
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        float m3 = GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(cVar);
        float l3 = cVar.g().getPageData().l();
        this.focusCenterX = m3 * 0.5f;
        this.focusCenterY = 0.45f * l3;
        this.focusDistance = l3 * 0.14f;
    }

    public MarkerRect getFocusedMarkerRect(MarkerRect markerRect) {
        float f16 = this.focusedScale;
        return markerRect.scale(f16, f16, this.anchorX, this.anchorY);
    }

    public final NBPMarkerStatus getStatus() {
        return (NBPMarkerStatus) this.status$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final boolean isFocused() {
        return getStatus() == NBPMarkerStatus.Focused;
    }

    public final boolean updatedStatus(boolean z16) {
        NBPMarkerStatus nBPMarkerStatus;
        if (z16 == isFocused()) {
            return false;
        }
        if (z16) {
            nBPMarkerStatus = NBPMarkerStatus.Focused;
        } else {
            nBPMarkerStatus = NBPMarkerStatus.Normal;
        }
        this.status$delegate.setValue(this, $$delegatedProperties[0], nBPMarkerStatus);
        onStatusChanged(getStatus());
        return true;
    }

    public void onStatusChanged(NBPMarkerStatus nBPMarkerStatus) {
    }
}

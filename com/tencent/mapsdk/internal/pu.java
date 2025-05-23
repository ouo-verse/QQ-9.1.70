package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.map.lib.models.AccessibleTouchItem;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class pu extends AccessibleTouchItem {

    /* renamed from: a, reason: collision with root package name */
    private ap f149665a;

    /* renamed from: b, reason: collision with root package name */
    private tr f149666b;

    public pu(tr trVar, ap apVar) {
        this.f149666b = trVar;
        this.f149665a = apVar;
    }

    private static Rect a(Rect rect) {
        if (rect == null) {
            return null;
        }
        int i3 = rect.left;
        int i16 = rect.right;
        int i17 = rect.top;
        int i18 = rect.bottom;
        int i19 = (i16 + i3) / 2;
        int i26 = (i17 + i18) / 2;
        int i27 = i18 - i17;
        if (i16 - i3 < ho.o() * 40.0f) {
            float f16 = i19;
            int o16 = (int) (f16 - (ho.o() * 20.0f));
            i16 = (int) (f16 + (ho.o() * 20.0f));
            i3 = o16;
        }
        if (i27 < ho.o() * 40.0f) {
            float f17 = i26;
            i17 = (int) (f17 - (ho.o() * 20.0f));
            i18 = (int) (f17 + (ho.o() * 20.0f));
        }
        return new Rect(i3, i17, i16, i18);
    }

    @Override // com.tencent.map.lib.models.AccessibleTouchItem
    public final Rect getBounds() {
        Rect j3;
        ap apVar = this.f149665a;
        if (apVar == null || (j3 = apVar.j()) == null) {
            return null;
        }
        int i3 = j3.left;
        int i16 = j3.right;
        int i17 = j3.top;
        int i18 = j3.bottom;
        int i19 = (i16 + i3) / 2;
        int i26 = (i17 + i18) / 2;
        int i27 = i18 - i17;
        if (i16 - i3 < ho.o() * 40.0f) {
            float f16 = i19;
            int o16 = (int) (f16 - (ho.o() * 20.0f));
            i16 = (int) (f16 + (ho.o() * 20.0f));
            i3 = o16;
        }
        if (i27 < ho.o() * 40.0f) {
            float f17 = i26;
            i17 = (int) (f17 - (ho.o() * 20.0f));
            i18 = (int) (f17 + (ho.o() * 20.0f));
        }
        return new Rect(i3, i17, i16, i18);
    }

    @Override // com.tencent.map.lib.models.AccessibleTouchItem
    public final String getContentDescription() {
        ap apVar = this.f149665a;
        if (apVar == null) {
            return null;
        }
        return apVar.getContentDescription();
    }

    @Override // com.tencent.map.lib.models.AccessibleTouchItem
    public final void onClick() {
        tr trVar = this.f149666b;
        if (trVar != null) {
            TencentMap.OnMarkerClickListener T = trVar.T();
            ap apVar = this.f149665a;
            if (apVar != null && T != null) {
                T.onMarkerClick(apVar);
            }
        }
    }
}

package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.UiSettings;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ty implements UiSettings {

    /* renamed from: a, reason: collision with root package name */
    private af f151119a;

    public ty(af afVar) {
        this.f151119a = afVar;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final boolean isCompassEnabled() {
        am amVar;
        af afVar = this.f151119a;
        if (afVar == null || (amVar = afVar.f147771a) == null) {
            return false;
        }
        return amVar.b();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final boolean isIndoorLevelPickerEnabled() {
        am amVar;
        af afVar = this.f151119a;
        if (afVar == null || (amVar = afVar.f147771a) == null) {
            return false;
        }
        return amVar.h();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final boolean isMyLocationButtonEnabled() {
        am amVar;
        af afVar = this.f151119a;
        if (afVar == null || (amVar = afVar.f147771a) == null) {
            return false;
        }
        return amVar.c();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final boolean isRotateGesturesEnabled() {
        am amVar;
        af afVar = this.f151119a;
        if (afVar == null || (amVar = afVar.f147771a) == null) {
            return false;
        }
        return amVar.g();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final boolean isScaleViewEnabled() {
        am amVar;
        af afVar = this.f151119a;
        if (afVar == null || (amVar = afVar.f147771a) == null) {
            return false;
        }
        return amVar.i();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final boolean isScrollGesturesEnabled() {
        am amVar;
        af afVar = this.f151119a;
        if (afVar == null || (amVar = afVar.f147771a) == null) {
            return false;
        }
        return amVar.d();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final boolean isTiltGesturesEnabled() {
        am amVar;
        af afVar = this.f151119a;
        if (afVar == null || (amVar = afVar.f147771a) == null) {
            return false;
        }
        return amVar.f();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final boolean isZoomControlsEnabled() {
        am amVar;
        af afVar = this.f151119a;
        if (afVar == null || (amVar = afVar.f147771a) == null) {
            return false;
        }
        return amVar.a();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final boolean isZoomGesturesEnabled() {
        am amVar;
        af afVar = this.f151119a;
        if (afVar == null || (amVar = afVar.f147771a) == null) {
            return false;
        }
        return amVar.e();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setAllGesturesEnabled(boolean z16) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.i(z16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setCompassEnabled(boolean z16) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.b(z16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setCompassExtraPadding(int i3) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar == null || (amVar = afVar.f147771a) == null) {
            return;
        }
        amVar.f(i3);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setFlingGestureEnabled(boolean z16) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.e(z16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setGestureRotateByMapCenter(boolean z16) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.m(z16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setGestureScaleByMapCenter(boolean z16) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.l(z16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setIndoorLevelPickerEnabled(boolean z16) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.n(z16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setLogoPosition(int i3) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar == null || (amVar = afVar.f147771a) == null) {
            return;
        }
        amVar.b(i3);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setLogoPositionWithMargin(int i3, int i16, int i17, int i18, int i19) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.a(i3, i16, i17, i18, i19);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setLogoScale(float f16) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.a(f16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setLogoSize(int i3) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.g(i3);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setMyLocationButtonEnabled(boolean z16) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.c(z16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setRotateGesturesEnabled(boolean z16) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.h(z16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setScaleViewEnabled(boolean z16) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.j(z16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setScaleViewFadeEnable(boolean z16) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.o(z16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setScaleViewPosition(int i3) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.e(i3);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setScaleViewPositionWithMargin(int i3, int i16, int i17, int i18, int i19) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.b(i3, i16, i17, i18, i19);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setScrollGesturesEnabled(boolean z16) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.d(z16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setTiltGesturesEnabled(boolean z16) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.g(z16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setZoomControlsEnabled(boolean z16) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.a(z16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setZoomGesturesEnabled(boolean z16) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.f(z16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setZoomPosition(int i3) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar != null && (amVar = afVar.f147771a) != null) {
            amVar.h(i3);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setCompassExtraPadding(int i3, int i16) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar == null || (amVar = afVar.f147771a) == null) {
            return;
        }
        amVar.a(i3, i16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setLogoPosition(int i3, int[] iArr) {
        am amVar;
        af afVar = this.f151119a;
        if (afVar == null || (amVar = afVar.f147771a) == null) {
            return;
        }
        amVar.a(i3, iArr);
    }
}

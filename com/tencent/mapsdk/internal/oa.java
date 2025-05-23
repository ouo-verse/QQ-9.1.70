package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class oa extends ng<ob> implements nj, IntersectionOverlay {
    /* JADX INFO: Access modifiers changed from: package-private */
    public oa(nz nzVar, ob obVar) {
        super(nzVar, obVar);
    }

    @Override // com.tencent.mapsdk.internal.nj
    public final int a() {
        return ((nz) this.f149453c).a(this.f149452b);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay
    public final void setBounds(Rect rect) {
        ((ob) this.f149454d).setBounds(rect);
        a((oa) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay
    public final void setDarkMode(boolean z16) {
        ((ob) this.f149454d).enableDarkMode(z16);
        a((oa) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay
    public final void setData(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        ((ob) this.f149454d).setData(bArr);
        a((oa) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay
    public final void setDistance(int i3) {
        ((ob) this.f149454d).setDistance(i3);
        a((oa) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay
    public final void setRoundedCorner(boolean z16) {
        ((ob) this.f149454d).enableRoundedCorner(z16);
        a((oa) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay
    public final void setVisibility(boolean z16) {
        ((ob) this.f149454d).setVisibility(z16);
        a((oa) this.f149454d);
    }
}

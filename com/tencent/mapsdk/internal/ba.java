package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ba implements TileOverlay {

    /* renamed from: a, reason: collision with root package name */
    private final qz f147789a;

    public ba(qz qzVar) {
        this.f147789a = qzVar;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TileOverlay
    public final void clearTileCache() {
        qz qzVar = this.f147789a;
        if (qzVar == null) {
            return;
        }
        qzVar.f();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ba)) {
            return false;
        }
        return this.f147789a.equals(((ba) obj).f147789a);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TileOverlay, com.tencent.tencentmap.mapsdk.maps.model.IOverlay
    public final String getId() {
        qz qzVar = this.f147789a;
        if (qzVar == null) {
            return "";
        }
        return qzVar.y();
    }

    public final int hashCode() {
        qz qzVar = this.f147789a;
        if (qzVar == null) {
            return 0;
        }
        return qzVar.hashCode();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TileOverlay
    public final void reload() {
        qz qzVar = this.f147789a;
        if (qzVar == null) {
            return;
        }
        qzVar.e();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TileOverlay
    public final void remove() {
        qz qzVar = this.f147789a;
        if (qzVar == null) {
            return;
        }
        qzVar.remove();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TileOverlay
    public final void setDiskCacheDir(String str) {
        qz qzVar = this.f147789a;
        if (qzVar != null && qzVar.f150001r != null && !TextUtils.isEmpty(str)) {
            qzVar.f150001r.diskCacheDir(str);
            qzVar.f150002s = qzVar.g();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TileOverlay
    public final void setZindex(int i3) {
        qz qzVar = this.f147789a;
        if (qzVar == null) {
            return;
        }
        qzVar.a(i3);
    }
}

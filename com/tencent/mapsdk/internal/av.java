package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class av implements CustomLayer {

    /* renamed from: a, reason: collision with root package name */
    private final qz f147775a;

    /* renamed from: b, reason: collision with root package name */
    private int f147776b;

    public av(qz qzVar) {
        this.f147776b = -1;
        this.f147775a = qzVar;
        bb bbVar = qzVar.f149562n;
        if (bbVar != null && bbVar.b() != null) {
            this.f147776b = qzVar.f149562n.b().N;
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.CustomLayer
    public final void clearDiskCache() {
        qz qzVar = this.f147775a;
        if (qzVar == null) {
            return;
        }
        qzVar.f();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof av)) {
            return false;
        }
        return this.f147775a.equals(((av) obj).f147775a);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IOverlay
    public final String getId() {
        qz qzVar = this.f147775a;
        if (qzVar == null) {
            return "";
        }
        return qzVar.y();
    }

    public final int hashCode() {
        qz qzVar = this.f147775a;
        if (qzVar == null) {
            return 0;
        }
        return qzVar.hashCode();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public final boolean isRemoved() {
        qz qzVar = this.f147775a;
        if (qzVar != null) {
            return qzVar.isRemoved();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public final void releaseData() {
        qz qzVar = this.f147775a;
        if (qzVar != null) {
            qzVar.releaseData();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.CustomLayer
    public final void reload() {
        qz qzVar = this.f147775a;
        if (qzVar == null) {
            return;
        }
        qzVar.e();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public final void remove() {
        qz qzVar = this.f147775a;
        if (qzVar == null) {
            return;
        }
        qzVar.remove();
        lc.c(ky.f149095a, this.f147776b);
    }
}

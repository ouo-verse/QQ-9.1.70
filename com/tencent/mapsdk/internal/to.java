package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class to implements TencentMap.OnIndoorStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private tr f150995a;

    public to(tr trVar) {
        this.f150995a = trVar;
    }

    private boolean a() {
        if (this.f150995a == null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener
    public final boolean onIndoorBuildingDeactivated() {
        tr trVar = this.f150995a;
        if (trVar == null) {
            return false;
        }
        trVar.onIndoorBuildingDeactivated();
        TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener = this.f150995a.f151066w;
        if (onIndoorStateChangeListener != null) {
            onIndoorStateChangeListener.onIndoorBuildingDeactivated();
            return true;
        }
        return true;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener
    public final boolean onIndoorBuildingFocused() {
        tr trVar = this.f150995a;
        if (trVar == null) {
            return false;
        }
        trVar.onIndoorBuildingFocused();
        TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener = this.f150995a.f151066w;
        if (onIndoorStateChangeListener != null) {
            onIndoorStateChangeListener.onIndoorBuildingFocused();
            return true;
        }
        return true;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener
    public final boolean onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
        tr trVar = this.f150995a;
        if (trVar == null) {
            return false;
        }
        trVar.onIndoorLevelActivated(indoorBuilding);
        TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener = this.f150995a.f151066w;
        if (onIndoorStateChangeListener != null) {
            onIndoorStateChangeListener.onIndoorLevelActivated(indoorBuilding);
            return true;
        }
        return true;
    }
}

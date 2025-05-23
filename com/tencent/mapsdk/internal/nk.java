package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.CommandFunctionModelClass;
import com.tencent.map.lib.models.CommonParamsModelClass;
import com.tencent.map.lib.models.ReturnInfoModelClass;
import com.tencent.map.sdk.utilities.visualization.aggregation.AggregationOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatAggregationUnit;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay;

/* compiled from: P */
/* loaded from: classes9.dex */
public class nk extends ng<nl> implements AggregationOverlay, VectorHeatOverlay {
    /* JADX INFO: Access modifiers changed from: package-private */
    public nk(nm nmVar, nl nlVar) {
        super(nmVar, nlVar);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public ReturnInfoModelClass.ReturnStatus executeCommandFunction(CommandFunctionModelClass.BaseCommandFunction baseCommandFunction) {
        if (baseCommandFunction == null) {
            return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
        }
        String name = baseCommandFunction.getClass().getName();
        if (!name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetZoomLevelRangeCommand")) {
            if (!name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetVisibleCommand")) {
                if (!name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetVisibleCommand")) {
                    if (!name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetClickEnabledCommand")) {
                        if (!name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$EnableClickCommand")) {
                            if (!name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetTypeCommand")) {
                                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.unsupported);
                            }
                            return new ReturnInfoModelClass.BaseStringReturnInfo(getType());
                        }
                        CommonParamsModelClass.EnableClickParams enableClickParams = ((CommandFunctionModelClass.EnableClickCommand) baseCommandFunction).params;
                        if (enableClickParams == null) {
                            return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
                        }
                        enableClick(enableClickParams.enabled);
                        return new ReturnInfoModelClass.ReturnStatus();
                    }
                    return new ReturnInfoModelClass.BaseBooleanReturnInfo(isClickEnabled());
                }
                return new ReturnInfoModelClass.BaseBooleanReturnInfo(((nl) this.f149454d).isVisible());
            }
            CommonParamsModelClass.VisibleParams visibleParams = ((CommandFunctionModelClass.SetVisibleCommand) baseCommandFunction).params;
            if (visibleParams == null) {
                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
            }
            setVisibility(visibleParams.isVisible);
            return new ReturnInfoModelClass.ReturnStatus();
        }
        CommonParamsModelClass.ZoomLevelRangeParams zoomLevelRangeParams = ((CommandFunctionModelClass.SetZoomLevelRangeCommand) baseCommandFunction).params;
        if (zoomLevelRangeParams == null) {
            return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
        }
        ((nl) this.f149454d).setZoomLevelRange(zoomLevelRangeParams.minLevel, zoomLevelRangeParams.maxLevel);
        a((nk) this.f149454d);
        return new ReturnInfoModelClass.ReturnStatus();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public String getType() {
        return eh.Aggregation.f148161h;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.aggregation.AggregationOverlay, com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay
    public VectorHeatAggregationUnit getUnit(LatLng latLng) {
        Object obj = this.f149453c;
        if (obj != null) {
            long j3 = this.f149452b;
            if (j3 != 0) {
                return ((nm) obj).a(j3, latLng);
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public boolean isClickEnabled() {
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void setLevel(int i3) {
        T t16 = this.f149454d;
        if (((nl) t16).f149467a != null) {
            ((nl) t16).f149467a.displayLevel(i3);
        }
        ((nl) this.f149454d).setDisplayLevel(i3);
        a((nk) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay, com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay
    public void setOpacity(float f16) {
        T t16 = this.f149454d;
        if (((nl) t16).f149467a != null) {
            ((nl) t16).f149467a.opacity(f16);
        }
        ((nl) this.f149454d).setOpacity(f16);
        a((nk) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay, com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay
    public void setVisibility(boolean z16) {
        T t16 = this.f149454d;
        if (((nl) t16).f149467a != null) {
            ((nl) t16).f149467a.visibility(z16);
        }
        ((nl) this.f149454d).setVisibility(z16);
        a((nk) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void setZIndex(int i3) {
        T t16 = this.f149454d;
        if (((nl) t16).f149467a != null) {
            ((nl) t16).f149467a.zIndex(i3);
        }
        ((nl) this.f149454d).setZIndex(i3);
        a((nk) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void enableClick(boolean z16) {
    }
}

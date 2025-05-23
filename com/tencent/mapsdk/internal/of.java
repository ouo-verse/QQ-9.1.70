package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.CommandFunctionModelClass;
import com.tencent.map.lib.models.CommonParamsModelClass;
import com.tencent.map.lib.models.ReturnInfoModelClass;
import com.tencent.map.sdk.utilities.visualization.scatterplot.BitmapScatterPlotOverlay;
import com.tencent.map.sdk.utilities.visualization.scatterplot.DotScatterPlotOverlay;
import com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlay;

/* compiled from: P */
/* loaded from: classes9.dex */
public class of extends ng<oh> implements BitmapScatterPlotOverlay, DotScatterPlotOverlay, ScatterPlotOverlay {
    /* JADX INFO: Access modifiers changed from: package-private */
    public of(nh nhVar, oh ohVar) {
        super(nhVar, ohVar);
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
                return new ReturnInfoModelClass.BaseBooleanReturnInfo(((oh) this.f149454d).isVisible());
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
        ((oh) this.f149454d).setZoomLevelRange(zoomLevelRangeParams.minLevel, zoomLevelRangeParams.maxLevel);
        a((of) this.f149454d);
        return new ReturnInfoModelClass.ReturnStatus();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public String getType() {
        return eh.Scatter.f148161h;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public boolean isClickEnabled() {
        return false;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlay
    public void setActiveDataIndex(int i3) {
        ((oh) this.f149454d).setActiveIndex(i3);
        a((of) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void setLevel(int i3) {
        T t16 = this.f149454d;
        if (((oh) t16).f149477a != null) {
            ((oh) t16).f149477a.displayLevel(i3);
        }
        ((oh) this.f149454d).setLevel(i3);
        a((of) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay, com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay
    public void setOpacity(float f16) {
        T t16 = this.f149454d;
        if (((oh) t16).f149477a != null) {
            ((oh) t16).f149477a.opacity(f16);
        }
        ((oh) this.f149454d).setOpacity(f16);
        a((of) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay, com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay
    public void setVisibility(boolean z16) {
        T t16 = this.f149454d;
        if (((oh) t16).f149477a != null) {
            ((oh) t16).f149477a.visibility(z16);
        }
        ((oh) this.f149454d).setVisible(z16);
        a((of) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void setZIndex(int i3) {
        T t16 = this.f149454d;
        if (((oh) t16).f149477a != null) {
            ((oh) t16).f149477a.zIndex(i3);
        }
        ((oh) this.f149454d).setzIndex(i3);
        a((of) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void enableClick(boolean z16) {
    }
}

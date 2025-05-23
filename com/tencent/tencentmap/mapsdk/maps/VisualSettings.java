package com.tencent.tencentmap.mapsdk.maps;

import com.tencent.map.lib.models.CommandFunctionModelClass;
import com.tencent.map.lib.models.ReturnInfoModelClass;
import com.tencent.tencentmap.mapsdk.maps.model.LightColor;
import com.tencent.tencentmap.mapsdk.maps.model.LightDirection;
import com.tencent.tencentmap.mapsdk.maps.model.LightType;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface VisualSettings {
    ReturnInfoModelClass.ReturnStatus executeVisualLayerSettings(CommandFunctionModelClass.BaseCommandFunction baseCommandFunction);

    void setAmbientLight(LightColor lightColor, float f16);

    void setSpotOrDirectionalLight(LightType lightType, LightColor lightColor, LightDirection lightDirection, float f16);
}

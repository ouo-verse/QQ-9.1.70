package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.CommandFunctionModelClass;
import com.tencent.map.lib.models.CommonParamsModelClass;
import com.tencent.map.lib.models.ReturnInfoModelClass;
import com.tencent.mapsdk.internal.tk;
import com.tencent.tencentmap.mapsdk.maps.VisualSettings;
import com.tencent.tencentmap.mapsdk.maps.model.LightColor;
import com.tencent.tencentmap.mapsdk.maps.model.LightDirection;
import com.tencent.tencentmap.mapsdk.maps.model.LightType;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class z implements VisualSettings {

    /* renamed from: a, reason: collision with root package name */
    protected ne f151324a;

    /* renamed from: b, reason: collision with root package name */
    private tk f151325b;

    /* renamed from: e, reason: collision with root package name */
    private LightType f151328e;

    /* renamed from: c, reason: collision with root package name */
    private LightColor f151326c = new LightColor(1.0f, 1.0f, 1.0f);

    /* renamed from: d, reason: collision with root package name */
    private float f151327d = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private LightDirection f151329f = new LightDirection(1.0f, 0.0f, 0.0f);

    /* renamed from: g, reason: collision with root package name */
    private LightColor f151330g = new LightColor(1.0f, 1.0f, 1.0f);

    /* renamed from: h, reason: collision with root package name */
    private float f151331h = 2.5f;

    public z(bf bfVar) {
        this.f151325b = bfVar.g();
        this.f151324a = (ne) bfVar;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.VisualSettings
    public final ReturnInfoModelClass.ReturnStatus executeVisualLayerSettings(CommandFunctionModelClass.BaseCommandFunction baseCommandFunction) {
        if (baseCommandFunction == null) {
            return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
        }
        String name = baseCommandFunction.getClass().getName();
        if (!name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$ErrorCommandFunction")) {
            if (!name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetSpotOrDirectionalLightCommand")) {
                if (!name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetAmbientLightCommand")) {
                    return new ReturnInfoModelClass.ReturnStatus();
                }
                CommandFunctionModelClass.SetAmbientLightCommand setAmbientLightCommand = (CommandFunctionModelClass.SetAmbientLightCommand) baseCommandFunction;
                CommonParamsModelClass.MonoColorParams monoColorParams = setAmbientLightCommand.params.color;
                if (monoColorParams != null) {
                    this.f151326c = new LightColor(monoColorParams.f147587r, monoColorParams.f147586g, monoColorParams.f147585b);
                }
                float f16 = setAmbientLightCommand.params.intensity;
                this.f151327d = f16;
                setAmbientLight(this.f151326c, f16);
                return new ReturnInfoModelClass.ReturnStatus();
            }
            CommandFunctionModelClass.SetSpotOrDirectionalLightCommand setSpotOrDirectionalLightCommand = (CommandFunctionModelClass.SetSpotOrDirectionalLightCommand) baseCommandFunction;
            CommonParamsModelClass.SpotOrDirectionalLightParams spotOrDirectionalLightParams = setSpotOrDirectionalLightCommand.params;
            int i3 = spotOrDirectionalLightParams.type;
            if (i3 == 0) {
                this.f151328e = LightType.SPOTLIGHT;
            } else if (i3 == 1) {
                this.f151328e = LightType.DIRECTIONALLIGHT;
            } else {
                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.invalidparam.bindErrorMsg("type value must be 0 or 1"));
            }
            CommonParamsModelClass.MonoColorParams monoColorParams2 = spotOrDirectionalLightParams.color;
            if (monoColorParams2 != null) {
                this.f151330g = new LightColor(monoColorParams2.f147587r, monoColorParams2.f147586g, monoColorParams2.f147585b);
            }
            CommonParamsModelClass.DirectionalParams directionalParams = setSpotOrDirectionalLightCommand.params.direction;
            if (directionalParams != null) {
                this.f151329f = new LightDirection(directionalParams.f147582x, directionalParams.f147583y, directionalParams.f147584z);
            }
            float f17 = setSpotOrDirectionalLightCommand.params.intensity;
            this.f151331h = f17;
            setSpotOrDirectionalLight(this.f151328e, this.f151330g, this.f151329f, f17);
            return new ReturnInfoModelClass.ReturnStatus();
        }
        return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.unsupported);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.VisualSettings
    public final void setAmbientLight(LightColor lightColor, float f16) {
        tk tkVar = this.f151325b;
        tkVar.a(new tk.AnonymousClass94(lightColor, f16));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.VisualSettings
    public final void setSpotOrDirectionalLight(LightType lightType, LightColor lightColor, LightDirection lightDirection, float f16) {
        tk tkVar = this.f151325b;
        tkVar.a(new tk.AnonymousClass95(lightType, lightColor, lightDirection, f16));
    }
}

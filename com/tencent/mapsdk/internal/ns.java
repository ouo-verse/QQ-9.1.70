package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.CommandFunctionModelClass;
import com.tencent.map.lib.models.CommonParamsModelClass;
import com.tencent.map.lib.models.ReturnInfoModelClass;
import com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlay;
import com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlayProvider;
import com.tencent.mapsdk.internal.nh;
import com.tencent.tencentmap.mapsdk.maps.model.GeneralTranslateAnimator;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ns extends ng<nr> implements GLModelOverlay {

    /* renamed from: e, reason: collision with root package name */
    private GeneralTranslateAnimator f149471e;

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.ns$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    final class AnonymousClass1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ nh.a f149472a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AnonymousClass1(nh.a aVar) {
            this.f149472a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (((nr) ns.this.f149454d).getOutterVectorOverlayClickListener() != null) {
                ((nr) ns.this.f149454d).getOutterVectorOverlayClickListener().onClicked(this.f149472a.getPosition(), this.f149472a.getIdentifier(), this.f149472a.getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ns(nq nqVar, nr nrVar) {
        super(nqVar, nrVar);
    }

    public final void c() {
        if (this.f149471e != null) {
            if (((nr) this.f149454d).f149470a.getTransAnimatorEndListener() != null) {
                this.f149471e.removeAnimatorEndListener(((nr) this.f149454d).f149470a.getTransAnimatorEndListener());
            }
            this.f149471e.cancelAnimation();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void enableClick(boolean z16) {
        T t16 = this.f149454d;
        if (((nr) t16).f149470a != null) {
            ((nr) t16).f149470a.enableClick(z16);
        }
        ((nr) this.f149454d).enableClick(z16);
        a((ns) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public ReturnInfoModelClass.ReturnStatus executeCommandFunction(CommandFunctionModelClass.BaseCommandFunction baseCommandFunction) {
        if (baseCommandFunction == null) {
            return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
        }
        String name = baseCommandFunction.getClass().getName();
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetZoomLevelRangeCommand")) {
            CommonParamsModelClass.ZoomLevelRangeParams zoomLevelRangeParams = ((CommandFunctionModelClass.SetZoomLevelRangeCommand) baseCommandFunction).params;
            if (zoomLevelRangeParams == null) {
                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
            }
            ((nr) this.f149454d).setZoomLevelRange(zoomLevelRangeParams.minLevel, zoomLevelRangeParams.maxLevel);
            a((ns) this.f149454d);
            return new ReturnInfoModelClass.ReturnStatus();
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$StartTranslateAnimationCommand")) {
            CommandFunctionModelClass.StartTranslateAnimationCommand startTranslateAnimationCommand = (CommandFunctionModelClass.StartTranslateAnimationCommand) baseCommandFunction;
            CommonParamsModelClass.StartTranslateAnimationParams startTranslateAnimationParams = startTranslateAnimationCommand.params;
            if (startTranslateAnimationParams == null) {
                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
            }
            if (startTranslateAnimationParams.positions == null) {
                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
            }
            c();
            this.f149471e = new GeneralTranslateAnimator.Builder(this, r1.duration * 1000.0f, (LatLng[]) startTranslateAnimationCommand.params.positions.toArray(new LatLng[0])).rotateEnabled(startTranslateAnimationCommand.params.needRotate).modelType(GeneralTranslateAnimator.ModelType.MODEL_OVERLAY).initRotate(startTranslateAnimationCommand.params.initRotation).build();
            if (((nr) this.f149454d).f149470a.getTransAnimatorEndListener() != null) {
                this.f149471e.addAnimatorEndListener(((nr) this.f149454d).f149470a.getTransAnimatorEndListener());
            }
            this.f149471e.startAnimation();
            return new ReturnInfoModelClass.ReturnStatus();
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetRotationCommand")) {
            CommonParamsModelClass.RotationParams rotationParams = ((CommandFunctionModelClass.SetRotationCommand) baseCommandFunction).params;
            if (rotationParams == null) {
                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
            }
            float f16 = rotationParams.rotationX;
            float f17 = rotationParams.rotationY;
            float f18 = rotationParams.rotationZ;
            T t16 = this.f149454d;
            if (((nr) t16).f149470a != null) {
                ((nr) t16).f149470a.rotationX(f16).rotationY(f17).rotationZ(f18);
            }
            ((nr) this.f149454d).setRotationX(f16);
            ((nr) this.f149454d).setRotationY(f17);
            ((nr) this.f149454d).setRotationZ(f18);
            a((ns) this.f149454d);
            return new ReturnInfoModelClass.ReturnStatus();
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetExposureCommand")) {
            CommandFunctionModelClass.SetExposureCommand setExposureCommand = (CommandFunctionModelClass.SetExposureCommand) baseCommandFunction;
            CommonParamsModelClass.ExposureParams exposureParams = setExposureCommand.params;
            if (exposureParams == null) {
                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
            }
            T t17 = this.f149454d;
            if (((nr) t17).f149470a != null) {
                ((nr) t17).f149470a.setExposure(exposureParams.exposure);
            }
            ((nr) this.f149454d).setExposure(setExposureCommand.params.exposure);
            a((ns) this.f149454d);
            return new ReturnInfoModelClass.ReturnStatus();
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetVisibleCommand")) {
            CommonParamsModelClass.VisibleParams visibleParams = ((CommandFunctionModelClass.SetVisibleCommand) baseCommandFunction).params;
            if (visibleParams == null) {
                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
            }
            setVisibility(visibleParams.isVisible);
            return new ReturnInfoModelClass.ReturnStatus();
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetCurrentMaterialVariantCommand")) {
            return new ReturnInfoModelClass.BaseIntReturnInfo(getCurrentMaterialVariant());
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$ErrorCommandFunction")) {
            return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.unsupported);
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetMaterialVariantCommand")) {
            CommonParamsModelClass.MaterialVariantIndexParams materialVariantIndexParams = ((CommandFunctionModelClass.SetMaterialVariantCommand) baseCommandFunction).params;
            if (materialVariantIndexParams == null) {
                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
            }
            setMaterialVariant(materialVariantIndexParams.variantIndex);
            return new ReturnInfoModelClass.ReturnStatus();
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetVisibleCommand")) {
            return new ReturnInfoModelClass.BaseBooleanReturnInfo(((nr) this.f149454d).isVisible());
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$EnableUnlitCommand")) {
            setUnlit(((CommandFunctionModelClass.EnableUnlitCommand) baseCommandFunction).params.enabled);
            return new ReturnInfoModelClass.ReturnStatus();
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetMaterialVariantsCommand")) {
            return new ReturnInfoModelClass.MaterialVariantsReturnInfo(getMaterialVariants());
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetPixelBoundCommand")) {
            CommandFunctionModelClass.SetPixelBoundCommand setPixelBoundCommand = (CommandFunctionModelClass.SetPixelBoundCommand) baseCommandFunction;
            if (setPixelBoundCommand.params == null) {
                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
            }
            T t18 = this.f149454d;
            if (((nr) t18).f149470a != null) {
                ((nr) t18).f149470a.coordType(GLModelOverlayProvider.CoordType.PixelType);
                GLModelOverlayProvider gLModelOverlayProvider = ((nr) this.f149454d).f149470a;
                CommonParamsModelClass.PixelBoundParams pixelBoundParams = setPixelBoundCommand.params;
                gLModelOverlayProvider.pixelBounds(pixelBoundParams.width, pixelBoundParams.height);
            }
            ((nr) this.f149454d).setCoordType(GLModelOverlayProvider.CoordType.PixelType.ordinal());
            nr nrVar = (nr) this.f149454d;
            CommonParamsModelClass.PixelBoundParams pixelBoundParams2 = setPixelBoundCommand.params;
            nrVar.setPixelBound(pixelBoundParams2.width, pixelBoundParams2.height);
            a((ns) this.f149454d);
            return new ReturnInfoModelClass.ReturnStatus();
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetPositionCommand")) {
            return new ReturnInfoModelClass.PositionReturnInfo(((nr) this.f149454d).getPosition());
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetClickEnabledCommand")) {
            return new ReturnInfoModelClass.BaseBooleanReturnInfo(isClickEnabled());
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetScaleCommand")) {
            return new ReturnInfoModelClass.BaseFloatReturnInfo((float) ((nr) this.f149454d).getScale());
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$ResetColorCommand")) {
            resetMonoColor();
            return new ReturnInfoModelClass.ReturnStatus();
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetSkeletonAnimationInfoCommand")) {
            return new ReturnInfoModelClass.SkeletonAnimationReturnInfo(getSkeletonAnimationProperties());
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetPositionCommand")) {
            CommandFunctionModelClass.SetPositionCommand setPositionCommand = (CommandFunctionModelClass.SetPositionCommand) baseCommandFunction;
            if (setPositionCommand.params == null) {
                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
            }
            CommonParamsModelClass.PositionParams positionParams = setPositionCommand.params;
            LatLng latLng = new LatLng(positionParams.lat, positionParams.lng, positionParams.altitude);
            T t19 = this.f149454d;
            if (((nr) t19).f149470a != null) {
                ((nr) t19).f149470a.position(latLng);
            }
            ((nr) this.f149454d).setModelPosition(latLng);
            a((ns) this.f149454d);
            return new ReturnInfoModelClass.ReturnStatus();
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$EnableClickCommand")) {
            CommonParamsModelClass.EnableClickParams enableClickParams = ((CommandFunctionModelClass.EnableClickCommand) baseCommandFunction).params;
            if (enableClickParams == null) {
                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
            }
            enableClick(enableClickParams.enabled);
            return new ReturnInfoModelClass.ReturnStatus();
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetScaleCommand")) {
            CommonParamsModelClass.ScaleParams scaleParams = ((CommandFunctionModelClass.SetScaleCommand) baseCommandFunction).params;
            if (scaleParams == null) {
                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
            }
            float f19 = scaleParams.scale;
            T t26 = this.f149454d;
            if (((nr) t26).f149470a != null) {
                ((nr) t26).f149470a.coordType(GLModelOverlayProvider.CoordType.GeoGraphicType);
                ((nr) this.f149454d).f149470a.scale(f19);
            }
            ((nr) this.f149454d).setCoordType(GLModelOverlayProvider.CoordType.GeoGraphicType.ordinal());
            ((nr) this.f149454d).setScale(f19);
            a((ns) this.f149454d);
            return new ReturnInfoModelClass.ReturnStatus();
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetTypeCommand")) {
            return new ReturnInfoModelClass.BaseStringReturnInfo(getType());
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$PlaySkeletonAnimationCommand")) {
            CommonParamsModelClass.PlaySkeletonAnimationParams playSkeletonAnimationParams = ((CommandFunctionModelClass.PlaySkeletonAnimationCommand) baseCommandFunction).params;
            if (playSkeletonAnimationParams == null) {
                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
            }
            playSkeletonAnimation(playSkeletonAnimationParams.index, playSkeletonAnimationParams.speed, playSkeletonAnimationParams.repeat);
            return new ReturnInfoModelClass.ReturnStatus();
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetMonoColorCommand")) {
            CommonParamsModelClass.MonoColorParams monoColorParams = ((CommandFunctionModelClass.SetMonoColorCommand) baseCommandFunction).params;
            if (monoColorParams == null) {
                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
            }
            setMonoColor(monoColorParams);
            return new ReturnInfoModelClass.ReturnStatus();
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetUnlitEnabledCommand")) {
            return new ReturnInfoModelClass.BaseBooleanReturnInfo(getUnlit());
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetRotationCommand")) {
            return new ReturnInfoModelClass.RotationReturnInfo(((nr) this.f149454d).getRotationX(), ((nr) this.f149454d).getRotationY(), ((nr) this.f149454d).getRotationZ());
        }
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$StopSkeletonAnimationCommand")) {
            stopSkeletonAnimation();
            return new ReturnInfoModelClass.ReturnStatus();
        }
        if (!name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetExposureCommand")) {
            return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.unsupported);
        }
        return new ReturnInfoModelClass.BaseFloatReturnInfo(((nr) this.f149454d).getExposure());
    }

    @Override // com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlay
    public int getCurrentMaterialVariant() {
        Object obj = this.f149453c;
        if (!(obj instanceof nq)) {
            return 0;
        }
        return ((nq) obj).d(this.f149452b);
    }

    @Override // com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlay
    public List<CommonParamsModelClass.MaterialVariantInfo> getMaterialVariants() {
        Object obj = this.f149453c;
        if (!(obj instanceof nq)) {
            return null;
        }
        return ((nq) obj).c(this.f149452b);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IAnimatorModel
    public float getRotation() {
        return ((nr) this.f149454d).getRotationY();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlay
    public List<CommonParamsModelClass.AnimationInfo> getSkeletonAnimationProperties() {
        Object obj = this.f149453c;
        if (!(obj instanceof nq)) {
            return null;
        }
        return ((nq) obj).b(this.f149452b);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public String getType() {
        return eh.GLModel.f148161h;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlay
    public boolean getUnlit() {
        return ((nr) this.f149454d).getUnlit();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public boolean isClickEnabled() {
        return ((nr) this.f149454d).isClickEnabled();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlay
    public void playSkeletonAnimation(int i3, float f16, boolean z16) {
        ((nq) this.f149453c).a(this.f149452b, i3, f16, z16);
    }

    @Override // com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlay
    public void resetMonoColor() {
        Object obj = this.f149453c;
        if (!(obj instanceof nq)) {
            return;
        }
        ((nq) obj).e(this.f149452b);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void setLevel(int i3) {
        T t16 = this.f149454d;
        if (((nr) t16).f149470a != null) {
            ((nr) t16).f149470a.displayLevel(i3);
        }
        ((nr) this.f149454d).setLevel(i3);
        a((ns) this.f149454d);
    }

    @Override // com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlay
    public void setMaterialVariant(int i3) {
        Object obj = this.f149453c;
        if (!(obj instanceof nq)) {
            return;
        }
        ((nq) obj).a(this.f149452b, i3);
    }

    @Override // com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlay
    public void setMonoColor(CommonParamsModelClass.MonoColorParams monoColorParams) {
        Object obj = this.f149453c;
        if (!(obj instanceof nq) || monoColorParams == null) {
            return;
        }
        ((nq) obj).a(this.f149452b, monoColorParams.f147587r, monoColorParams.f147586g, monoColorParams.f147585b);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay, com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay
    public void setOpacity(float f16) {
        T t16 = this.f149454d;
        if (((nr) t16).f149470a != null) {
            ((nr) t16).f149470a.opacity(f16);
        }
        ((nr) this.f149454d).setOpacity(f16);
        a((ns) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IAnimatorModel
    public void setPosition(LatLng latLng) {
        T t16 = this.f149454d;
        if (((nr) t16).f149470a != null) {
            ((nr) t16).f149470a.position(latLng);
        }
        ((nr) this.f149454d).setModelPosition(latLng);
        a((ns) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IAnimatorModel
    public void setRotation(float f16) {
        T t16 = this.f149454d;
        if (((nr) t16).f149470a != null) {
            ((nr) t16).f149470a.rotationY(f16);
        }
        ((nr) this.f149454d).setRotationY(f16);
        a((ns) this.f149454d);
    }

    @Override // com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlay
    public void setUnlit(boolean z16) {
        T t16 = this.f149454d;
        if (((nr) t16).f149470a != null) {
            ((nr) t16).f149470a.unlit(z16);
        }
        ((nr) this.f149454d).setUnlit(z16);
        a((ns) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay, com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay
    public void setVisibility(boolean z16) {
        T t16 = this.f149454d;
        if (((nr) t16).f149470a != null) {
            ((nr) t16).f149470a.visibility(z16);
        }
        ((nr) this.f149454d).setVisible(z16);
        a((ns) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void setZIndex(int i3) {
        T t16 = this.f149454d;
        if (((nr) t16).f149470a != null) {
            ((nr) t16).f149470a.zIndex(i3);
        }
        ((nr) this.f149454d).setzIndex(i3);
        a((ns) this.f149454d);
    }

    @Override // com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlay
    public void stopSkeletonAnimation() {
        ((nq) this.f149453c).a(this.f149452b);
    }

    @Override // com.tencent.mapsdk.internal.ng
    public final void a(long j3) {
        this.f149452b = j3;
    }

    private void a(nh.a aVar) {
        kp.a(new AnonymousClass1(aVar));
    }
}

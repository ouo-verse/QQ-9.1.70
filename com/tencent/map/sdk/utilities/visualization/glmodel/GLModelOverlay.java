package com.tencent.map.sdk.utilities.visualization.glmodel;

import com.tencent.map.lib.models.CommonParamsModelClass;
import com.tencent.tencentmap.mapsdk.maps.model.IAnimatorModel;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface GLModelOverlay extends IAnimatorModel, VectorOverlay {
    int getCurrentMaterialVariant();

    List<CommonParamsModelClass.MaterialVariantInfo> getMaterialVariants();

    List<CommonParamsModelClass.AnimationInfo> getSkeletonAnimationProperties();

    boolean getUnlit();

    void playSkeletonAnimation(int i3, float f16, boolean z16);

    void resetMonoColor();

    void setMaterialVariant(int i3);

    void setMonoColor(CommonParamsModelClass.MonoColorParams monoColorParams);

    void setUnlit(boolean z16);

    void stopSkeletonAnimation();
}

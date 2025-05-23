package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.GLModelInfo;
import com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlayProvider;

/* compiled from: P */
/* loaded from: classes9.dex */
public class nr extends GLModelInfo implements ni {

    /* renamed from: a, reason: collision with root package name */
    GLModelOverlayProvider f149470a;

    public nr(GLModelOverlayProvider gLModelOverlayProvider) {
        this.f149470a = gLModelOverlayProvider;
        this.mModelFilePath = gLModelOverlayProvider.getModelFilePath();
        this.mPosition = gLModelOverlayProvider.getPosition();
        this.mCoordType = gLModelOverlayProvider.getCoordType().ordinal();
        if (gLModelOverlayProvider.getPosition() != null) {
            this.mAltitude = gLModelOverlayProvider.getPosition().getAltitude();
        }
        this.mScale = gLModelOverlayProvider.getScale();
        this.mRotationX = gLModelOverlayProvider.getRotationX();
        this.mRotationY = gLModelOverlayProvider.getRotationY();
        this.mRotationZ = gLModelOverlayProvider.getRotationZ();
        this.mLatLngBounds = gLModelOverlayProvider.getLatLngBounds();
        this.mAnimate = gLModelOverlayProvider.getAnimationType().ordinal();
        this.mMaxZoom = gLModelOverlayProvider.getMaxZoom();
        this.mMinZoom = gLModelOverlayProvider.getMinZoom();
        this.level = gLModelOverlayProvider.getDisplayLevel();
        this.exposure = gLModelOverlayProvider.getExposure();
        this.zIndex = gLModelOverlayProvider.getZIndex();
        this.opacity = gLModelOverlayProvider.getOpacity();
        this.visible = gLModelOverlayProvider.isVisibility();
        this.buildingHidden = gLModelOverlayProvider.isBuildingHidden();
        this.clickEnabled = gLModelOverlayProvider.isClickEnabled();
        this.mPixelWidth = gLModelOverlayProvider.getPixelWidth();
        this.mPixelHeight = gLModelOverlayProvider.getPixelHeight();
        this.outterVectorOverlayLoadListener = gLModelOverlayProvider.getVectorOverlayLoadedListener();
        this.outterVectorOverlayClickListener = gLModelOverlayProvider.getOnVectorOverlayClickListener();
        this.unlit = gLModelOverlayProvider.getUnlit();
    }

    private GLModelOverlayProvider a() {
        return this.f149470a;
    }
}

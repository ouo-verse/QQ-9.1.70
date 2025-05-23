package com.tencent.map.sdk.utilities.visualization.glmodel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.tencentmap.mapsdk.maps.model.IAnimatorModel;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import java.io.File;
import java.util.List;

/* loaded from: classes9.dex */
public final class GLModelOverlayProvider extends BaseOverlayProvider {
    private LatLngBounds mLatLngBounds;
    private String mModelFilePath;
    private int mPixelHeight;
    private int mPixelWidth;
    private LatLng mPosition;
    private float mRotationX;
    private float mRotationY;
    private float mRotationZ;
    private IAnimatorModel.IAnimatorEndListener transAnimatorEndListener;
    private CoordType mCoordType = CoordType.GeoGraphicType;
    private double mScale = 1.0d;
    private AnimationType mAnimated = AnimationType.None;
    private float mExposure = 1.0f;
    private boolean mBuildingHidden = true;
    private boolean mUnlit = false;

    /* loaded from: classes9.dex */
    public enum AnimationType {
        None,
        FlattenRise
    }

    /* loaded from: classes9.dex */
    public enum CoordType {
        PixelType,
        GeoGraphicType
    }

    public GLModelOverlayProvider(@NonNull String str, @NonNull LatLng latLng) {
        if (isModelFileValid(str)) {
            this.mModelFilePath = str;
        } else {
            this.mModelFilePath = "";
        }
        this.mPosition = latLng;
    }

    private boolean isModelFileValid(String str) {
        if ((str.endsWith(".gltf") || str.endsWith(".GLTF")) && new File(str).exists()) {
            return true;
        }
        return false;
    }

    public final GLModelOverlayProvider animateType(AnimationType animationType) {
        this.mAnimated = animationType;
        return this;
    }

    public final GLModelOverlayProvider coordType(CoordType coordType) {
        this.mCoordType = coordType;
        return this;
    }

    public final AnimationType getAnimationType() {
        return this.mAnimated;
    }

    public final CoordType getCoordType() {
        return this.mCoordType;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final int getDisplayLevel() {
        return super.getDisplayLevel();
    }

    public final float getExposure() {
        return this.mExposure;
    }

    public final LatLngBounds getLatLngBounds() {
        return this.mLatLngBounds;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final int getMaxZoom() {
        return super.getMaxZoom();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final int getMinZoom() {
        return super.getMinZoom();
    }

    public final String getModelFilePath() {
        return this.mModelFilePath;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final float getOpacity() {
        return super.getOpacity();
    }

    public final int getPixelHeight() {
        return this.mPixelHeight;
    }

    public final int getPixelWidth() {
        return this.mPixelWidth;
    }

    public final LatLng getPosition() {
        return this.mPosition;
    }

    public final float getRotationX() {
        return this.mRotationX;
    }

    public final float getRotationY() {
        return this.mRotationY;
    }

    public final float getRotationZ() {
        return this.mRotationZ;
    }

    public final double getScale() {
        return this.mScale;
    }

    public final IAnimatorModel.IAnimatorEndListener getTransAnimatorEndListener() {
        return this.transAnimatorEndListener;
    }

    public final boolean getUnlit() {
        return this.mUnlit;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final int getZIndex() {
        return super.getZIndex();
    }

    public final boolean isBuildingHidden() {
        return this.mBuildingHidden;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final boolean isClickEnabled() {
        return this.mClickEnabled;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final boolean isVisibility() {
        return super.isVisibility();
    }

    public final GLModelOverlayProvider latLngBounds(@Nullable List<LatLng> list) {
        if (list != null && list.size() >= 2) {
            this.mLatLngBounds = new LatLngBounds.Builder().include(list).build();
        } else {
            this.mLatLngBounds = null;
        }
        return this;
    }

    public final GLModelOverlayProvider modelFilePath(@NonNull String str) {
        if (isModelFileValid(str)) {
            this.mModelFilePath = str;
        }
        return this;
    }

    public final GLModelOverlayProvider pixelBounds(int i3, int i16) {
        this.mPixelWidth = i3;
        this.mPixelHeight = i16;
        return this;
    }

    public final GLModelOverlayProvider position(@NonNull LatLng latLng) {
        this.mPosition = latLng;
        return this;
    }

    public final GLModelOverlayProvider rotationX(float f16) {
        this.mRotationX = f16;
        return this;
    }

    public final GLModelOverlayProvider rotationY(float f16) {
        this.mRotationY = f16;
        return this;
    }

    public final GLModelOverlayProvider rotationZ(float f16) {
        this.mRotationZ = f16;
        return this;
    }

    public final GLModelOverlayProvider scale(double d16) {
        if (d16 > 0.0d) {
            this.mScale = d16;
        }
        return this;
    }

    public final GLModelOverlayProvider setBuildingHidden(boolean z16) {
        this.mBuildingHidden = z16;
        return this;
    }

    public final GLModelOverlayProvider setClickEnable(boolean z16) {
        super.enableClick(z16);
        return this;
    }

    public final GLModelOverlayProvider setExposure(float f16) {
        this.mExposure = f16;
        return this;
    }

    public final void setTransAnimatorEndListener(IAnimatorModel.IAnimatorEndListener iAnimatorEndListener) {
        this.transAnimatorEndListener = iAnimatorEndListener;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider
    public final String toString() {
        return "GLModelOverlayProvider{mOpacity=" + this.mOpacity + ", mVisibility=" + this.mVisibility + ", mMinZoom=" + this.mMinZoom + ", mMaxZoom=" + this.mMaxZoom + ", mDisplayLevel=" + this.mDisplayLevel + ", mZIndex=" + this.mZIndex + ", mCoordType=" + this.mCoordType + ", mModelFilePath='" + this.mModelFilePath + "', mPosition=" + this.mPosition + ", mScale=" + this.mScale + ", mRotationX=" + this.mRotationX + ", mRotationY=" + this.mRotationY + ", mRotationZ=" + this.mRotationZ + ", mLatLngBounds=" + this.mLatLngBounds + ", mAnimated=" + this.mAnimated + ", mExposure=" + this.mExposure + ", mBuildingHidden=" + this.mBuildingHidden + ", mClickEnabled=" + this.mClickEnabled + '}';
    }

    public final GLModelOverlayProvider unlit(boolean z16) {
        this.mUnlit = z16;
        return this;
    }

    public final GLModelOverlayProvider zoomRange(int i3, int i16) {
        if (i3 <= i16) {
            super.minZoom(i3);
            super.maxZoom(i16);
        }
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final GLModelOverlayProvider displayLevel(int i3) {
        super.displayLevel(i3);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final GLModelOverlayProvider opacity(float f16) {
        super.opacity(f16);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final GLModelOverlayProvider visibility(boolean z16) {
        super.visibility(z16);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final GLModelOverlayProvider zIndex(int i3) {
        super.zIndex(i3);
        return this;
    }
}

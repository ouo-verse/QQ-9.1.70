package com.tencent.tencentmap.mapsdk.maps.model;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.tencent.tencentmap.mapsdk.maps.model.IAnimatorModel;
import com.tencent.tencentmap.mapsdk.maps.model.transform.OverlayAnimator;
import com.tencent.tencentmap.mapsdk.maps.model.transform.Point;
import com.tencent.tencentmap.mapsdk.maps.model.transform.SphericalMercatorProjection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class GeneralTranslateAnimator extends OverlayAnimator {
    private List<IAnimatorModel.IAnimatorEndListener> mAnimatorEndListeners;
    private final IAnimatorModel mAnimatorModel;
    private double[] mDistances;
    private SphericalMercatorProjection mEarthMercatorProjection;
    private LatLng[] mLatLngs;
    private RotateAnimationController mRotateAnimationController;
    private double mSumDistance;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class Builder {
        private final IAnimatorModel animatorModel;
        private final long duration;
        private final LatLng[] latLngs;
        private boolean rotateEnabled = false;
        private float initRotate = 0.0f;
        private ModelType modelType = ModelType.MARKER_OVERLAY;

        public Builder(IAnimatorModel iAnimatorModel, long j3, LatLng[] latLngArr) {
            this.animatorModel = iAnimatorModel;
            this.duration = j3;
            this.latLngs = latLngArr;
        }

        public GeneralTranslateAnimator build() {
            return new GeneralTranslateAnimator(this);
        }

        public Builder initRotate(float f16) {
            this.initRotate = f16;
            return this;
        }

        public Builder modelType(ModelType modelType) {
            this.modelType = modelType;
            return this;
        }

        public Builder rotateEnabled(boolean z16) {
            this.rotateEnabled = z16;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum ModelType {
        MARKER_OVERLAY,
        MODEL_OVERLAY
    }

    public GeneralTranslateAnimator(Builder builder) {
        super(builder.animatorModel, builder.duration);
        this.mAnimatorModel = builder.animatorModel;
        if (builder.latLngs != null && builder.latLngs.length > 0 && builder.duration >= 0) {
            this.mLatLngs = builder.latLngs;
            this.mAnimatorEndListeners = new ArrayList();
            this.mEarthMercatorProjection = new SphericalMercatorProjection();
            ArrayList arrayList = new ArrayList();
            this.mDistances = new double[this.mLatLngs.length - 1];
            int i3 = 0;
            while (true) {
                LatLng[] latLngArr = this.mLatLngs;
                if (i3 >= latLngArr.length - 1) {
                    break;
                }
                int i16 = i3 + 1;
                this.mDistances[i3] = this.mEarthMercatorProjection.distanceBetween(latLngArr[i3], latLngArr[i16]);
                this.mSumDistance += this.mDistances[i3];
                i3 = i16;
            }
            for (int i17 = 0; i17 < this.mLatLngs.length - 1; i17++) {
                arrayList.add(createSegmentAnimator(i17));
            }
            getAnimatorSet().playSequentially(arrayList);
            this.mRotateAnimationController = new RotateAnimationController(builder.animatorModel, builder.duration, builder.modelType, builder.rotateEnabled, builder.initRotate, this.mLatLngs, this.mDistances, this.mSumDistance, this.mEarthMercatorProjection);
        }
    }

    public void addAnimatorEndListener(IAnimatorModel.IAnimatorEndListener iAnimatorEndListener) {
        List<IAnimatorModel.IAnimatorEndListener> list = this.mAnimatorEndListeners;
        if (list != null && !list.contains(iAnimatorEndListener) && iAnimatorEndListener != null) {
            this.mAnimatorEndListeners.add(iAnimatorEndListener);
            addAnimationListener();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.transform.OverlayAnimator
    public void cancelAnimation() {
        super.cancelAnimation();
        if (this.mRotateAnimationController == null) {
            return;
        }
        synchronized (this) {
            this.mRotateAnimationController.cancelAnimation();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.transform.OverlayAnimator
    public ValueAnimator createSegmentAnimator(final int i3) {
        final Point point = this.mEarthMercatorProjection.toPoint(this.mLatLngs[i3]);
        final Point point2 = this.mEarthMercatorProjection.toPoint(this.mLatLngs[i3 + 1]);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration((long) ((getDuration() * this.mDistances[i3]) / this.mSumDistance));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setFloatValues((float) this.mDistances[i3]);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.tencentmap.mapsdk.maps.model.GeneralTranslateAnimator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                if (point.equals(point2)) {
                    return;
                }
                double parseDouble = Double.parseDouble(String.valueOf(valueAnimator2.getAnimatedValue()));
                double d16 = point.f375392x;
                double d17 = d16 + (((point2.f375392x - d16) * parseDouble) / GeneralTranslateAnimator.this.mDistances[i3]);
                double d18 = point.f375393y;
                double d19 = d18 + (((point2.f375393y - d18) * parseDouble) / GeneralTranslateAnimator.this.mDistances[i3]);
                if (GeneralTranslateAnimator.this.mAnimatorModel == null) {
                    return;
                }
                GeneralTranslateAnimator.this.mAnimatorModel.setPosition(GeneralTranslateAnimator.this.mEarthMercatorProjection.toLatLng(new Point(d17, d19)));
            }
        });
        return valueAnimator;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.transform.OverlayAnimator
    public void endAnimation() {
        super.endAnimation();
        if (this.mRotateAnimationController == null) {
            return;
        }
        synchronized (this) {
            this.mRotateAnimationController.endAnimation();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.transform.OverlayAnimator
    public void innerAnimationEnd() {
        List<IAnimatorModel.IAnimatorEndListener> list = this.mAnimatorEndListeners;
        if (list == null) {
            return;
        }
        Iterator<IAnimatorModel.IAnimatorEndListener> it = list.iterator();
        while (it.hasNext()) {
            it.next().onAnimatorEnd();
        }
    }

    public void removeAnimatorEndListener(IAnimatorModel.IAnimatorEndListener iAnimatorEndListener) {
        List<IAnimatorModel.IAnimatorEndListener> list = this.mAnimatorEndListeners;
        if (list == null) {
            return;
        }
        list.remove(iAnimatorEndListener);
        removeAnimationListener();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.transform.OverlayAnimator
    public void startAnimation() {
        super.startAnimation();
        if (this.mRotateAnimationController == null) {
            return;
        }
        synchronized (this) {
            this.mRotateAnimationController.startAnimation();
        }
    }
}

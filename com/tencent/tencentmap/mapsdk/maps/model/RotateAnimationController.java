package com.tencent.tencentmap.mapsdk.maps.model;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.tencent.tencentmap.mapsdk.maps.model.GeneralTranslateAnimator;
import com.tencent.tencentmap.mapsdk.maps.model.transform.Point;
import com.tencent.tencentmap.mapsdk.maps.model.transform.SphericalMercatorProjection;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public class RotateAnimationController {
    private IAnimatorModel mAnimatorModel;
    private double[] mDistances;
    private long mDuration;
    private SphericalMercatorProjection mEarthMercatorProjection;
    private a mIValueAnimatorStrategy;
    private final float mInitRotate;
    private LatLng[] mLatLngs;
    private GeneralTranslateAnimator.ModelType mModelType;
    private AnimatorSet mRotateAnimatorSet;
    private final boolean mRotateEnabled;
    private double mSumDistance;

    /* compiled from: P */
    /* renamed from: com.tencent.tencentmap.mapsdk.maps.model.RotateAnimationController$3, reason: invalid class name */
    /* loaded from: classes26.dex */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f375389a;

        static {
            int[] iArr = new int[GeneralTranslateAnimator.ModelType.values().length];
            f375389a = iArr;
            try {
                iArr[GeneralTranslateAnimator.ModelType.MODEL_OVERLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface a {
        ValueAnimator a(float f16, float f17);

        double[] a();
    }

    public RotateAnimationController(IAnimatorModel iAnimatorModel, long j3, GeneralTranslateAnimator.ModelType modelType, boolean z16, float f16, LatLng[] latLngArr, double[] dArr, double d16, SphericalMercatorProjection sphericalMercatorProjection) {
        this.mRotateEnabled = z16;
        this.mInitRotate = f16;
        if (!z16) {
            return;
        }
        this.mAnimatorModel = iAnimatorModel;
        this.mDuration = j3;
        this.mModelType = modelType;
        this.mRotateAnimatorSet = new AnimatorSet();
        this.mLatLngs = latLngArr;
        this.mDistances = dArr;
        this.mSumDistance = d16;
        this.mEarthMercatorProjection = sphericalMercatorProjection;
        initValueAnimatorStrategy();
        initRotateAnimation();
    }

    private double calculateAngle(double d16, double d17, double d18, double d19) {
        double sqrt = ((d16 * d18) + (d17 * d19)) / (Math.sqrt((d16 * d16) + (d17 * d17)) * Math.sqrt((d18 * d18) + (d19 * d19)));
        if (Double.isNaN(sqrt)) {
            return 0.0d;
        }
        if (sqrt < -1.0d) {
            sqrt = -1.0d;
        }
        if (sqrt > 1.0d) {
            sqrt = 1.0d;
        }
        double acos = (Math.acos(sqrt) * 180.0d) / 3.141592653589793d;
        if ((d16 * d19) - (d17 * d18) > 0.0d) {
            acos = -acos;
        }
        return (float) acos;
    }

    private long calculateDelay(int i3, int i16) {
        double d16 = 0.0d;
        while (i3 < i16) {
            d16 += this.mDistances[i3];
            i3++;
        }
        return (long) ((this.mDuration * d16) / this.mSumDistance);
    }

    private ValueAnimator createRotateAnimator(float f16, float f17, long j3, long j16) {
        a aVar = this.mIValueAnimatorStrategy;
        float f18 = this.mInitRotate;
        ValueAnimator a16 = aVar.a(f16 + f18, f17 + f18);
        a16.setDuration(j3);
        a16.setStartDelay(j16);
        a16.setInterpolator(new LinearInterpolator());
        a16.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.tencentmap.mapsdk.maps.model.RotateAnimationController.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                double parseDouble = Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue()));
                if (RotateAnimationController.this.mAnimatorModel == null) {
                    return;
                }
                RotateAnimationController.this.mAnimatorModel.setRotation((float) parseDouble);
            }
        });
        return a16;
    }

    private void initRotateAnimation() {
        int i3;
        long j3;
        float f16;
        ArrayList arrayList = new ArrayList();
        float f17 = 0.0f;
        int i16 = 0;
        int i17 = 1;
        int i18 = 0;
        long j16 = 0;
        while (true) {
            Object[] objArr = this.mLatLngs;
            if (i17 < objArr.length) {
                if (!objArr[i18].equals(objArr[i17])) {
                    Point point = this.mEarthMercatorProjection.toPoint(this.mLatLngs[i16]);
                    Point point2 = this.mEarthMercatorProjection.toPoint(this.mLatLngs[i18]);
                    Point point3 = this.mEarthMercatorProjection.toPoint(this.mLatLngs[i17]);
                    double d16 = point2.f375392x;
                    double d17 = d16 - point.f375392x;
                    float f18 = f17;
                    double d18 = point.f375393y;
                    int i19 = i16;
                    double d19 = point2.f375393y;
                    int i26 = i17;
                    int i27 = i18;
                    float calculateAngle = (float) calculateAngle(d17, d18 - d19, point3.f375392x - d16, d19 - point3.f375393y);
                    if (arrayList.size() == 0) {
                        IAnimatorModel iAnimatorModel = this.mAnimatorModel;
                        if (iAnimatorModel == null) {
                            return;
                        }
                        float rotation = iAnimatorModel.getRotation();
                        double[] a16 = this.mIValueAnimatorStrategy.a();
                        i3 = i26;
                        calculateAngle = ((float) calculateAngle(a16[0], a16[1], point3.f375392x - point2.f375392x, point2.f375393y - point3.f375393y)) - rotation;
                        f16 = rotation;
                        j3 = 0;
                    } else {
                        i3 = i26;
                        long abs = (long) ((this.mDuration * (((Math.abs(calculateAngle) * 3.141592653589793d) * 6.0d) / 180.0d)) / this.mSumDistance);
                        j16 = calculateDelay(i19, i27) - (abs / 2);
                        j3 = abs;
                        f16 = f18;
                    }
                    float f19 = f16 + calculateAngle;
                    arrayList.add(createRotateAnimator(f16, f19, j3, j16));
                    f17 = f19;
                    i16 = i27;
                    i18 = i3;
                } else {
                    i3 = i17;
                }
                i17 = i3 + 1;
            } else {
                this.mRotateAnimatorSet.playSequentially(arrayList);
                return;
            }
        }
    }

    private void initValueAnimatorStrategy() {
        this.mIValueAnimatorStrategy = new a() { // from class: com.tencent.tencentmap.mapsdk.maps.model.RotateAnimationController.1
            @Override // com.tencent.tencentmap.mapsdk.maps.model.RotateAnimationController.a
            public final ValueAnimator a(float f16, float f17) {
                if (AnonymousClass3.f375389a[RotateAnimationController.this.mModelType.ordinal()] != 1) {
                    return ValueAnimator.ofFloat(f16, f17);
                }
                return ValueAnimator.ofFloat(f16 * (-1.0f), f17 * (-1.0f));
            }

            @Override // com.tencent.tencentmap.mapsdk.maps.model.RotateAnimationController.a
            public final double[] a() {
                double[] dArr = {0.0d, 1.0d};
                int[] iArr = AnonymousClass3.f375389a;
                RotateAnimationController.this.mModelType.ordinal();
                return dArr;
            }
        };
    }

    public void cancelAnimation() {
        if (!this.mRotateEnabled) {
            return;
        }
        this.mRotateAnimatorSet.cancel();
    }

    public void endAnimation() {
        if (!this.mRotateEnabled) {
            return;
        }
        this.mRotateAnimatorSet.end();
    }

    public void startAnimation() {
        if (this.mRotateEnabled && !this.mRotateAnimatorSet.isRunning()) {
            this.mRotateAnimatorSet.start();
        }
    }
}

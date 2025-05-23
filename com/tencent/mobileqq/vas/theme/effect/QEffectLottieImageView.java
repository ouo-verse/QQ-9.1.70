package com.tencent.mobileqq.vas.theme.effect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.IQEffect;
import com.tencent.qq.effect.IQEffectLoad;
import com.tencent.qq.effect.QEffectView;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.sensor.GravitySensor;
import com.tencent.qq.effect.sensor.SensorParams;
import com.tencent.qq.effect.utils.QEffectUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes20.dex */
public class QEffectLottieImageView extends LottieAnimationView implements IQEffect<QEffectData, Drawable>, GravitySensor.GravitySensorListener {
    private static final String TAG = "QEffectLottieImageView";
    private QEffectData mEffectData;
    private boolean mIsSoftWareRender;
    private boolean mIsStop;
    private OnCompositionLoadedListener mListener;
    protected SensorParams mSensorParams;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    static class QEffectImageAssetDelegate implements ImageAssetDelegate {
        String animPathFolder;

        public QEffectImageAssetDelegate(String str) {
            this.animPathFolder = str;
        }

        @Override // com.airbnb.lottie.ImageAssetDelegate
        public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
            String str = this.animPathFolder + lottieImageAsset.getFileName();
            if (!new File(str).exists()) {
                QLog.e(QEffectLottieImageView.TAG, 1, "fetchBitmap  bitmapPath is not exists: " + str);
                return null;
            }
            return LottieHelper.a(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements OnCompositionLoadedListener {
        a() {
        }

        @Override // com.airbnb.lottie.OnCompositionLoadedListener
        public void onCompositionLoaded(LottieComposition lottieComposition) {
            if (QLog.isColorLevel() || lottieComposition == null) {
                QLog.e(QEffectLottieImageView.TAG, 1, "onCompositionLoaded: composition= " + lottieComposition);
            }
            if (lottieComposition == null) {
                return;
            }
            if (QEffectLottieImageView.this.mIsStop) {
                QLog.e(QEffectLottieImageView.TAG, 1, "onCompositionLoaded: mIsStop " + QEffectLottieImageView.this.mIsStop);
                return;
            }
            QEffectLottieImageView.this.cancelAnimation();
            QEffectLottieImageView.this.setComposition(lottieComposition);
            QEffectLottieImageView.this.setProgress(0.0f);
            QEffectLottieImageView qEffectLottieImageView = QEffectLottieImageView.this;
            qEffectLottieImageView.setRepeatCount(qEffectLottieImageView.mEffectData.repeat);
            QEffectLottieImageView.this.setVisibility(0);
            QEffectLottieImageView.this.playAnimation();
        }
    }

    public QEffectLottieImageView(Context context) {
        super(context);
        this.mIsSoftWareRender = false;
        this.mIsStop = false;
        this.mListener = new a();
        if (VasToggle.isEnable(VasToggle.LOTTIE_IGNORE_SYSTEM_SETTINGS, false)) {
            setIgnoreDisabledSystemAnimations(true);
        }
    }

    public static QEffectData createDefData(String str, int i3) {
        QEffectData qEffectData = new QEffectData();
        qEffectData.f344465h = -1.0f;
        qEffectData.f344466w = -1.0f;
        qEffectData.resType = 1;
        qEffectData.type = 3;
        qEffectData.src = str;
        qEffectData.repeat = i3;
        return qEffectData;
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void complete(Drawable drawable) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!canvas.isHardwareAccelerated() && !VasToggle.isEnable(VasToggle.LOTTIE_SOFTWARE_RENDER, false)) {
            return;
        }
        super.draw(canvas);
    }

    @Override // com.tencent.qq.effect.IQEffect
    public boolean isGravityEnable() {
        QEffectData qEffectData = this.mEffectData;
        if (qEffectData != null && qEffectData.gravity) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void load(Context context, QEffectView qEffectView, IQEffectLoad iQEffectLoad, QEffectData qEffectData) {
        String str;
        this.mEffectData = qEffectData;
        this.mSensorParams = new SensorParams(getContext(), this.mEffectData);
        int i3 = qEffectData.resType;
        if ((i3 != 3 || qEffectData.resId <= 0) && i3 == 1 && (str = qEffectData.images) != null) {
            setImageAssetsFolder(str);
            try {
                LottieComposition.Factory.fromInputStream(new FileInputStream(qEffectData.src), this.mListener);
            } catch (FileNotFoundException e16) {
                QLog.e(TAG, 1, TAG, e16);
            }
            setImageAssetDelegate(new QEffectImageAssetDelegate(qEffectData.images));
        }
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void pause() {
        pauseAnimation();
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void play() {
        this.mIsStop = false;
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void resume() {
        resumeAnimation();
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void stop() {
        if (QLog.isColorLevel() && !this.mIsStop) {
            QLog.i(TAG, 1, "lottie stop");
        }
        this.mIsStop = true;
        cancelAnimation();
    }

    @Override // com.tencent.qq.effect.sensor.GravitySensor.GravitySensorListener
    public void updateGravityData(float[] fArr, boolean z16) {
        QEffectUtils.updateGravityData(this, fArr, this.mSensorParams, z16);
    }
}

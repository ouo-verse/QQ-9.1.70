package com.tencent.mobileqq.vas.theme.effect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.qq.effect.IQEffect;
import com.tencent.qq.effect.IQEffectLoad;
import com.tencent.qq.effect.QEffectView;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.sensor.GravitySensor;
import com.tencent.qq.effect.sensor.SensorParams;
import com.tencent.qq.effect.utils.QEffectUtils;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes20.dex */
public class QEffectGifImageView extends ImageView implements IQEffect<QEffectData, Drawable>, GravitySensor.GravitySensorListener {
    private static final String TAG = "QEffectGifImageView";
    private QEffectData mEffectData;
    protected SensorParams mSensorParams;

    public QEffectGifImageView(Context context) {
        super(context);
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
        this.mEffectData = qEffectData;
        this.mSensorParams = new SensorParams(getContext(), this.mEffectData);
        if (QEffectUtils.isEmpty(qEffectData.src)) {
            Log.e(TAG, " load data.src is null");
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = true;
        complete((Drawable) URLDrawable.getFileDrawable(qEffectData.src, obtain));
        AbstractGifImage.resumeAll();
    }

    @Override // com.tencent.qq.effect.sensor.GravitySensor.GravitySensorListener
    public void updateGravityData(float[] fArr, boolean z16) {
        QEffectUtils.updateGravityData(this, fArr, this.mSensorParams, z16);
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void complete(Drawable drawable) {
        setImageDrawable(drawable);
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void pause() {
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void play() {
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void resume() {
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void stop() {
    }
}

package com.tencent.qq.effect.impls;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.effect.IQEffect;
import com.tencent.qq.effect.IQEffectLoad;
import com.tencent.qq.effect.QEffectView;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.sensor.GravitySensor;
import com.tencent.qq.effect.sensor.SensorParams;
import com.tencent.qq.effect.utils.QEffectUtils;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes22.dex */
public class QEffectImageView extends ImageView implements IQEffect<QEffectData, Drawable>, GravitySensor.GravitySensorListener {
    static IPatchRedirector $redirector_;
    protected QEffectData mEffectData;
    protected SensorParams mSensorParams;

    public QEffectImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.qq.effect.IQEffect
    public boolean isGravityEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        QEffectData qEffectData = this.mEffectData;
        if (qEffectData != null && qEffectData.gravity) {
            return true;
        }
        return false;
    }

    public void load(Context context, QEffectView qEffectView, IQEffectLoad iQEffectLoad, QEffectData qEffectData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, qEffectView, iQEffectLoad, qEffectData);
            return;
        }
        this.mEffectData = qEffectData;
        this.mSensorParams = new SensorParams(getContext(), this.mEffectData);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        iQEffectLoad.load(context, this, qEffectData);
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void play() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            setImageDrawable(null);
        }
    }

    @Override // com.tencent.qq.effect.sensor.GravitySensor.GravitySensorListener
    public void updateGravityData(float[] fArr, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, fArr, Boolean.valueOf(z16));
        } else {
            QEffectUtils.updateGravityData(this, fArr, this.mSensorParams, z16);
        }
    }

    public QEffectImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void complete(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            setImageDrawable(drawable);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) drawable);
        }
    }

    public QEffectImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}

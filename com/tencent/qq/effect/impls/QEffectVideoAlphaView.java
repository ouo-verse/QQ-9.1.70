package com.tencent.qq.effect.impls;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.effect.IQEffect;
import com.tencent.qq.effect.IQEffectLoad;
import com.tencent.qq.effect.QEffectView;
import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoPLayListener;
import com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.sensor.GravitySensor;
import com.tencent.qq.effect.sensor.SensorParams;
import com.tencent.qq.effect.utils.QEffectUtils;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes22.dex */
public class QEffectVideoAlphaView extends PlayTextureView implements IQEffect<QEffectData, String>, GravitySensor.GravitySensorListener {
    static IPatchRedirector $redirector_;
    private String TAG;
    private QEffectData mEffectData;
    private String mFilepath;
    private boolean mPlay;
    protected SensorParams mSensorParams;

    public QEffectVideoAlphaView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.TAG = "QEffectVideoAlphaView";
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.qq.effect.IQEffect
    public boolean isGravityEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        QEffectData qEffectData = this.mEffectData;
        if (qEffectData != null && qEffectData.gravity) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void load(Context context, QEffectView qEffectView, IQEffectLoad iQEffectLoad, QEffectData qEffectData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, qEffectView, iQEffectLoad, qEffectData);
            return;
        }
        this.mEffectData = qEffectData;
        this.mSensorParams = new SensorParams(getContext(), this.mEffectData);
        if (qEffectData.resType == 1) {
            this.mFilepath = qEffectData.src;
        }
        complete(qEffectData.src);
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            stop();
        }
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void play() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            playFile(this.mFilepath);
        }
    }

    @Override // com.tencent.qq.effect.sensor.GravitySensor.GravitySensorListener
    public void updateGravityData(float[] fArr, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, fArr, Boolean.valueOf(z16));
        } else {
            QEffectUtils.updateGravityData(this, fArr, this.mSensorParams, z16);
        }
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void complete(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if (QEffectUtils.isEmpty(this.mFilepath)) {
            Log.e(this.TAG, "complete filepath is null");
            return;
        }
        setOpaque(false);
        setLoopState(true);
        setPlayListener(new IVideoPLayListener() { // from class: com.tencent.qq.effect.impls.QEffectVideoAlphaView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QEffectVideoAlphaView.this);
                }
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoPLayListener
            public void onEnd() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this);
                }
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoPLayListener
            public void onError(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this, i3);
                }
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoPLayListener
            public void onPlayAtTime(long j3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, j3);
                }
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoPLayListener
            public void onStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoPLayListener
            public void onVideoSize(int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
                }
            }
        });
        setContentVisible(true);
        playFile(this.mFilepath);
        this.mPlay = true;
    }

    public QEffectVideoAlphaView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.TAG = "QEffectVideoAlphaView";
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }
}

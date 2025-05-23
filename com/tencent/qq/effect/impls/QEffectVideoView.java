package com.tencent.qq.effect.impls;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.effect.IQEffect;
import com.tencent.qq.effect.IQEffectLoad;
import com.tencent.qq.effect.QEffectView;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.sensor.GravitySensor;
import com.tencent.qq.effect.sensor.SensorParams;
import com.tencent.qq.effect.utils.QEffectUtils;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QEffectVideoView extends TextureView implements TextureView.SurfaceTextureListener, IQEffect<QEffectData, String>, GravitySensor.GravitySensorListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QEffectVideoView";
    private QEffectData mEffectData;
    private String mFilePath;
    private MediaPlayer mMediaPlayer;
    private Thread mPlayThread;
    protected SensorParams mSensorParams;
    private Surface mSurface;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class PlayerVideo extends BaseThread {
        static IPatchRedirector $redirector_;

        PlayerVideo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) QEffectVideoView.this);
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                File file = new File(QEffectVideoView.this.mFilePath);
                if (!file.exists()) {
                    return;
                }
                QEffectVideoView.this.mMediaPlayer = new ReportMediaPlayer();
                QEffectVideoView.this.mMediaPlayer.setDataSource(file.getAbsolutePath());
                QEffectVideoView.this.mMediaPlayer.setSurface(QEffectVideoView.this.mSurface);
                QEffectVideoView.this.mMediaPlayer.setAudioStreamType(3);
                QEffectVideoView.this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.qq.effect.impls.QEffectVideoView.PlayerVideo.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PlayerVideo.this);
                        }
                    }

                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) mediaPlayer);
                        } else {
                            QEffectVideoView.this.mMediaPlayer.start();
                        }
                    }
                });
                QEffectVideoView.this.mMediaPlayer.setLooping(true);
                QEffectVideoView.this.mMediaPlayer.prepare();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        /* synthetic */ PlayerVideo(QEffectVideoView qEffectVideoView, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qEffectVideoView, (Object) anonymousClass1);
        }
    }

    public QEffectVideoView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            init();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    @Override // com.tencent.qq.effect.IQEffect
    public boolean isGravityEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, qEffectView, iQEffectLoad, qEffectData);
            return;
        }
        this.mEffectData = qEffectData;
        this.mSensorParams = new SensorParams(getContext(), this.mEffectData);
        if (qEffectData.resType == 1) {
            this.mFilePath = qEffectData.src;
        }
        complete(this.mFilePath);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Log.v(TAG, "onSurfaceTextureAvailable");
        this.mSurface = new Surface(surfaceTexture);
        complete(this.mFilePath);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) surfaceTexture)).booleanValue();
        }
        this.mSurface = null;
        this.mMediaPlayer.stop();
        this.mMediaPlayer.release();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            Log.v(TAG, "onSurfaceTextureSizeChanged");
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) surfaceTexture);
        }
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.mMediaPlayer.pause();
        }
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void play() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.mMediaPlayer.start();
        }
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.mMediaPlayer = null;
            this.mPlayThread = null;
        }
    }

    @Override // com.tencent.qq.effect.sensor.GravitySensor.GravitySensorListener
    public void updateGravityData(float[] fArr, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, fArr, Boolean.valueOf(z16));
        } else {
            QEffectUtils.updateGravityData(this, fArr, this.mSensorParams, z16);
        }
    }

    @Override // com.tencent.qq.effect.IQEffect
    public void complete(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            return;
        }
        if (QEffectUtils.isEmpty(this.mFilePath) || this.mSurface == null || this.mPlayThread != null) {
            return;
        }
        PlayerVideo playerVideo = new PlayerVideo(this, null);
        this.mPlayThread = playerVideo;
        playerVideo.start();
    }

    public QEffectVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            init();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public QEffectVideoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            init();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}

package com.tencent.ams.fusion.widget.alphaplayer;

import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.widget.FrameLayout;
import com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer;
import com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayerView;
import com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer;
import com.tencent.ams.fusion.widget.animatorview.AnimatorConfig;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AlphaVideoView extends FrameLayout {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AlphaVideoView";
    private AlphaPlayer.AlphaPlayerListener mListener;
    private IPlayer.OnCompletionListener mOnCompletionListener;
    private IPlayer.OnErrorListener mOnErrorListener;
    private IPlayer.OnInfoListener mOnInfoListener;
    private IPlayer.OnPreparedListener mOnPreparedListener;
    private IPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    private PlayInfo mPlayInfo;
    private AlphaPlayer mPlayer;
    private AlphaPlayerView mPlayerView;
    private boolean mShouldRequestAudioFocus;
    private boolean mSurfaceAvailable;
    private long mSurfaceDestroyTimeMillis;
    private final int mViewType;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ViewType {
        public static final int SURFACE = 1;
        public static final int TEXTURE = 2;
    }

    public AlphaVideoView(Context context) {
        this(context, (AttributeSet) null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void createSurface() {
        if (this.mViewType == 1) {
            this.mPlayerView = new AlphaSurfaceView(getContext());
        } else {
            this.mPlayerView = new AlphaTextureView(getContext());
        }
        addView(this.mPlayerView.getView(), 0, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyAndRebuildRenderIfSurfaceDestroyed(Object obj, int i3, int i16) {
        if (this.mPlayInfo != null && this.mPlayer != null) {
            try {
                if (obj instanceof SurfaceHolder) {
                    obj = ((SurfaceHolder) obj).getSurface();
                }
                RendererInfo rendererInfo = new RendererInfo(obj, i3, i16, this.mPlayInfo.getScaleType(), this.mPlayInfo.getFormatType());
                rendererInfo.setDecoderType(this.mPlayInfo.getDecoderType());
                rendererInfo.setDecoderPlayer(this.mPlayInfo.getDecoderPlayer());
                this.mPlayer.releaseRenderer();
                this.mPlayer.initRenderer(rendererInfo);
                return;
            } catch (Throwable th5) {
                Logger.e("AlphaVideoView", "rebuildRenderOnceSurfaceDestroyed error :", th5);
                return;
            }
        }
        Logger.e("AlphaVideoView", "surface recreate but mPlayInfo == null || mPlayer == null do nothing.");
    }

    private synchronized void initPlayer(Object obj, int i3, int i16) {
        PlayInfo playInfo;
        if (this.mPlayer == null && (playInfo = this.mPlayInfo) != null) {
            RendererInfo rendererInfo = new RendererInfo(obj, i3, i16, playInfo.getScaleType(), this.mPlayInfo.getFormatType());
            rendererInfo.setDecoderType(this.mPlayInfo.getDecoderType());
            rendererInfo.setDecoderPlayer(this.mPlayInfo.getDecoderPlayer());
            AlphaPlayer alphaPlayer = new AlphaPlayer(rendererInfo, this.mListener);
            this.mPlayer = alphaPlayer;
            alphaPlayer.setDataSource(this.mPlayInfo.getVideoPath());
            this.mPlayer.setOutputMute(this.mPlayInfo.isOutputMute());
            this.mPlayer.setLoopPlay(this.mPlayInfo.isLoopPlay());
            this.mPlayer.setOnPreparedListener(this.mOnPreparedListener);
            this.mPlayer.setOnCompletionListener(this.mOnCompletionListener);
            this.mPlayer.setOnInfoListener(this.mOnInfoListener);
            this.mPlayer.setOnErrorListener(this.mOnErrorListener);
            this.mPlayer.setOnSeekCompleteListener(this.mOnSeekCompleteListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay(Object obj, int i3, int i16) {
        Logger.d("AlphaVideoView", "startPlay: width-" + i3 + " height-" + i16);
        if (this.mShouldRequestAudioFocus) {
            ((AudioManager) getContext().getApplicationContext().getSystemService("audio")).requestAudioFocus(null, 3, 1);
        }
        try {
            initPlayer(obj, i3, i16);
            AlphaPlayer alphaPlayer = this.mPlayer;
            if (alphaPlayer != null) {
                alphaPlayer.start();
            }
        } catch (Throwable th5) {
            Logger.e("AlphaVideoView", "repeat failed" + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPrepare(Object obj, int i3, int i16) {
        Logger.d("AlphaVideoView", "startPrepare: width-" + i3 + " height-" + i16);
        try {
            initPlayer(obj, i3, i16);
            if (this.mPlayer == null) {
                Logger.w("AlphaVideoView", "startPrepare failed,mPlayer is null");
            }
        } catch (Throwable th5) {
            Logger.e("AlphaVideoView", "startPrepare failed" + th5);
        }
    }

    public long getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Long) iPatchRedirector.redirect((short) 18, (Object) this)).longValue();
        }
        AlphaPlayer alphaPlayer = this.mPlayer;
        if (alphaPlayer != null) {
            return alphaPlayer.getDuration();
        }
        return 0L;
    }

    public long getPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        AlphaPlayer alphaPlayer = this.mPlayer;
        if (alphaPlayer != null) {
            return alphaPlayer.getPosition();
        }
        return 0L;
    }

    public boolean isCompleted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        AlphaPlayer alphaPlayer = this.mPlayer;
        if (alphaPlayer != null && alphaPlayer.isCompleted()) {
            return true;
        }
        return false;
    }

    public boolean isPausing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        AlphaPlayer alphaPlayer = this.mPlayer;
        if (alphaPlayer != null && alphaPlayer.isPausing()) {
            return true;
        }
        return false;
    }

    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        AlphaPlayer alphaPlayer = this.mPlayer;
        if (alphaPlayer != null && alphaPlayer.isPlaying()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        AlphaPlayer alphaPlayer = this.mPlayer;
        if (alphaPlayer != null) {
            alphaPlayer.setSurfaceSize(i3, i16);
        }
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            pause(true);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    public void prepare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Logger.d("AlphaVideoView", "prepare start");
        if (this.mPlayInfo == null) {
            Logger.w("AlphaVideoView", "prepare failed: You must set play info first");
        } else if (this.mPlayerView.isAvailable()) {
            Logger.i("AlphaVideoView", "texture view is already available, start prepare");
            startPrepare(this.mPlayerView.getSurface(), this.mPlayerView.getWidth(), this.mPlayerView.getHeight());
        } else {
            this.mPlayerView.setSurfaceListener(new AlphaPlayerView.SurfaceListener() { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaVideoView.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphaVideoView.this);
                    }
                }

                @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayerView.SurfaceListener
                public void onSurfaceAvailable(Object obj, int i3, int i16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, obj, Integer.valueOf(i3), Integer.valueOf(i16));
                    } else {
                        Logger.i("AlphaVideoView", "onSurfaceAvailable");
                        AlphaVideoView.this.startPrepare(obj, i3, i16);
                    }
                }

                @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayerView.SurfaceListener
                public void onSurfaceDestroyed(Object obj) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, obj);
                    } else {
                        Logger.i("AlphaVideoView", "onSurfaceDestroyed");
                    }
                }
            });
        }
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Logger.d("AlphaVideoView", "resume");
        AlphaPlayer alphaPlayer = this.mPlayer;
        if (alphaPlayer != null) {
            alphaPlayer.resume();
        }
    }

    public void seekTo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        Logger.d("AlphaVideoView", "seekTo: " + i3);
        AlphaPlayer alphaPlayer = this.mPlayer;
        if (alphaPlayer != null) {
            alphaPlayer.seekTo(i3);
        }
    }

    public void setOnCompletionListener(IPlayer.OnCompletionListener onCompletionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) onCompletionListener);
        } else {
            this.mOnCompletionListener = onCompletionListener;
        }
    }

    public void setOnErrorListener(IPlayer.OnErrorListener onErrorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) onErrorListener);
        } else {
            this.mOnErrorListener = onErrorListener;
        }
    }

    public void setOnInfoListener(IPlayer.OnInfoListener onInfoListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) onInfoListener);
        } else {
            this.mOnInfoListener = onInfoListener;
        }
    }

    public void setOnPreparedListener(IPlayer.OnPreparedListener onPreparedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) onPreparedListener);
        } else {
            this.mOnPreparedListener = onPreparedListener;
        }
    }

    public void setOnSeekCompleteListener(IPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) onSeekCompleteListener);
        } else {
            this.mOnSeekCompleteListener = onSeekCompleteListener;
        }
    }

    public void setPlayInfo(PlayInfo playInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) playInfo);
        } else {
            this.mPlayInfo = playInfo;
            this.mPlayerView.setPlayInfo(playInfo);
        }
    }

    public void setPlayerListener(AlphaPlayer.AlphaPlayerListener alphaPlayerListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) alphaPlayerListener);
        } else {
            this.mListener = alphaPlayerListener;
        }
    }

    public void setShouldRequestAudioFocus(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
        } else {
            this.mShouldRequestAudioFocus = z16;
        }
    }

    public void setVolume(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Float.valueOf(f16));
            return;
        }
        AlphaPlayer alphaPlayer = this.mPlayer;
        if (alphaPlayer != null) {
            alphaPlayer.setVolume(f16);
        }
    }

    public void setVolumeOff() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        AlphaPlayer alphaPlayer = this.mPlayer;
        if (alphaPlayer != null) {
            alphaPlayer.setVolumeOff();
        }
    }

    public void setVolumeOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        AlphaPlayer alphaPlayer = this.mPlayer;
        if (alphaPlayer != null) {
            alphaPlayer.setVolumeOn();
        }
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Logger.d("AlphaVideoView", "start");
        if (this.mPlayInfo == null) {
            Logger.w("AlphaVideoView", "start failed: You must set play info first");
        } else if (this.mPlayerView.isAvailable()) {
            Logger.i("AlphaVideoView", "texture view is already available, start play");
            startPlay(this.mPlayerView.getSurface(), this.mPlayerView.getWidth(), this.mPlayerView.getHeight());
        } else {
            this.mPlayerView.setSurfaceListener(new AlphaPlayerView.SurfaceListener() { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaVideoView.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphaVideoView.this);
                    }
                }

                @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayerView.SurfaceListener
                public void onSurfaceAvailable(Object obj, int i3, int i16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, obj, Integer.valueOf(i3), Integer.valueOf(i16));
                        return;
                    }
                    Logger.i("AlphaVideoView", "onSurfaceAvailable");
                    AlphaVideoView.this.mSurfaceAvailable = true;
                    AlphaVideoView.this.startPlay(obj, i3, i16);
                    if (AlphaVideoView.this.mViewType == 1 && AnimatorConfig.isRebuildRenderOnceSurfaceDestroyed()) {
                        Logger.i("AlphaVideoView", "onSurfaceAvailable open rebuildRenderOnceSurfaceDestroyed");
                        if (AlphaVideoView.this.mSurfaceDestroyTimeMillis != 0) {
                            AlphaVideoView.this.destroyAndRebuildRenderIfSurfaceDestroyed(obj, i3, i16);
                        }
                    }
                }

                @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayerView.SurfaceListener
                public void onSurfaceDestroyed(Object obj) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, obj);
                        return;
                    }
                    Logger.i("AlphaVideoView", "onSurfaceDestroyed");
                    AlphaVideoView.this.mSurfaceAvailable = false;
                    AlphaVideoView.this.mSurfaceDestroyTimeMillis = System.currentTimeMillis();
                }
            });
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Logger.d("AlphaVideoView", "stop");
        AlphaPlayer alphaPlayer = this.mPlayer;
        if (alphaPlayer != null) {
            alphaPlayer.stop();
            this.mPlayer.release();
            if (this.mShouldRequestAudioFocus) {
                ((AudioManager) getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
            }
        }
    }

    public void stopPlayback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            Logger.d("AlphaVideoView", "stopPlayback");
            stop();
        }
    }

    public AlphaVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public void pause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        Logger.d("AlphaVideoView", "pause, isClearSurface:" + z16);
        AlphaPlayer alphaPlayer = this.mPlayer;
        if (alphaPlayer != null) {
            alphaPlayer.pause(z16);
        }
    }

    public AlphaVideoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mSurfaceAvailable = false;
        this.mShouldRequestAudioFocus = false;
        this.mViewType = 2;
        createSurface();
    }

    public AlphaVideoView(Context context, int i3) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, i3);
            return;
        }
        this.mSurfaceAvailable = false;
        this.mShouldRequestAudioFocus = false;
        this.mViewType = i3;
        createSurface();
    }
}

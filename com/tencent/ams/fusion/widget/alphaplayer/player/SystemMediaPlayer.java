package com.tencent.ams.fusion.widget.alphaplayer.player;

import android.media.MediaPlayer;
import android.os.Build;
import android.view.Surface;
import com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.IOException;

/* loaded from: classes3.dex */
public class SystemMediaPlayer implements IPlayer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SystemMediaPlayer";
    private final MediaPlayer mOrigin;

    public SystemMediaPlayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        this.mOrigin = reportMediaPlayer;
        reportMediaPlayer.setAudioStreamType(3);
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public int getCurrentPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.mOrigin.getCurrentPosition();
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public int getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.mOrigin.getDuration();
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public int getVideoHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.mOrigin.getVideoHeight();
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public int getVideoWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.mOrigin.getVideoWidth();
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.mOrigin.isPlaying();
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.mOrigin.pause();
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void prepareAsync() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.mOrigin.prepareAsync();
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.mOrigin.release();
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void seekTo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else if (Build.VERSION.SDK_INT >= 26) {
            this.mOrigin.seekTo(i3, 3);
        } else {
            this.mOrigin.seekTo(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setDataSource(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        try {
            this.mOrigin.setDataSource(str);
        } catch (IOException unused) {
            Logger.w(TAG, "setDataSource failed: " + str);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setLooping(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.mOrigin.setLooping(z16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setOnCompletionListener(IPlayer.OnCompletionListener onCompletionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) onCompletionListener);
        } else {
            this.mOrigin.setOnCompletionListener(new MediaPlayer.OnCompletionListener(onCompletionListener) { // from class: com.tencent.ams.fusion.widget.alphaplayer.player.SystemMediaPlayer.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ IPlayer.OnCompletionListener val$listener;

                {
                    this.val$listener = onCompletionListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SystemMediaPlayer.this, (Object) onCompletionListener);
                    }
                }

                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) mediaPlayer);
                        return;
                    }
                    IPlayer.OnCompletionListener onCompletionListener2 = this.val$listener;
                    if (onCompletionListener2 != null) {
                        onCompletionListener2.onCompletion(SystemMediaPlayer.this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setOnErrorListener(IPlayer.OnErrorListener onErrorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) onErrorListener);
        } else {
            this.mOrigin.setOnErrorListener(new MediaPlayer.OnErrorListener(onErrorListener) { // from class: com.tencent.ams.fusion.widget.alphaplayer.player.SystemMediaPlayer.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ IPlayer.OnErrorListener val$listener;

                {
                    this.val$listener = onErrorListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SystemMediaPlayer.this, (Object) onErrorListener);
                    }
                }

                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 2, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
                    }
                    IPlayer.OnErrorListener onErrorListener2 = this.val$listener;
                    if (onErrorListener2 == null) {
                        return false;
                    }
                    return onErrorListener2.onError(SystemMediaPlayer.this, i3, i16);
                }
            });
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setOnInfoListener(IPlayer.OnInfoListener onInfoListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) onInfoListener);
        } else {
            this.mOrigin.setOnInfoListener(new MediaPlayer.OnInfoListener(onInfoListener) { // from class: com.tencent.ams.fusion.widget.alphaplayer.player.SystemMediaPlayer.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ IPlayer.OnInfoListener val$listener;

                {
                    this.val$listener = onInfoListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SystemMediaPlayer.this, (Object) onInfoListener);
                    }
                }

                @Override // android.media.MediaPlayer.OnInfoListener
                public boolean onInfo(MediaPlayer mediaPlayer, int i3, int i16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 2, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
                    }
                    IPlayer.OnInfoListener onInfoListener2 = this.val$listener;
                    if (onInfoListener2 == null) {
                        return false;
                    }
                    return onInfoListener2.onInfo(SystemMediaPlayer.this, i3, i16);
                }
            });
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setOnPreparedListener(IPlayer.OnPreparedListener onPreparedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onPreparedListener);
        } else {
            this.mOrigin.setOnPreparedListener(new MediaPlayer.OnPreparedListener(onPreparedListener) { // from class: com.tencent.ams.fusion.widget.alphaplayer.player.SystemMediaPlayer.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IPlayer.OnPreparedListener val$preparedListener;

                {
                    this.val$preparedListener = onPreparedListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SystemMediaPlayer.this, (Object) onPreparedListener);
                    }
                }

                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) mediaPlayer);
                        return;
                    }
                    IPlayer.OnPreparedListener onPreparedListener2 = this.val$preparedListener;
                    if (onPreparedListener2 != null) {
                        onPreparedListener2.onPrepared(SystemMediaPlayer.this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setOnSeekCompleteListener(IPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onSeekCompleteListener);
        } else {
            this.mOrigin.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener(onSeekCompleteListener) { // from class: com.tencent.ams.fusion.widget.alphaplayer.player.SystemMediaPlayer.5
                static IPatchRedirector $redirector_;
                final /* synthetic */ IPlayer.OnSeekCompleteListener val$listener;

                {
                    this.val$listener = onSeekCompleteListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SystemMediaPlayer.this, (Object) onSeekCompleteListener);
                    }
                }

                @Override // android.media.MediaPlayer.OnSeekCompleteListener
                public void onSeekComplete(MediaPlayer mediaPlayer) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) mediaPlayer);
                        return;
                    }
                    IPlayer.OnSeekCompleteListener onSeekCompleteListener2 = this.val$listener;
                    if (onSeekCompleteListener2 != null) {
                        onSeekCompleteListener2.onSeekComplete(SystemMediaPlayer.this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setSurface(Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) surface);
        } else {
            this.mOrigin.setSurface(surface);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setVolume(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.mOrigin.setVolume(f16, f17);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.mOrigin.start();
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.mOrigin.stop();
        }
    }
}

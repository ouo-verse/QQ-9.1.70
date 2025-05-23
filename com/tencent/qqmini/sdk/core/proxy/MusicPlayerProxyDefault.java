package com.tencent.qqmini.sdk.core.proxy;

import android.media.MediaPlayer;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.model.SongInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy;
import java.io.IOException;

@ProxyService(proxy = MusicPlayerProxy.class)
/* loaded from: classes23.dex */
public class MusicPlayerProxyDefault implements MusicPlayerProxy {
    private MediaPlayer player = null;
    private MusicPlayerProxy.MusicPlayerListener mListener = null;

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public SongInfo getCurrentSong() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public int getCurrentSongPosition() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public int getDuration() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            return mediaPlayer.getDuration();
        }
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public void init(MusicPlayerProxy.MusicPlayerListener musicPlayerListener, String str, String str2) {
        this.mListener = musicPlayerListener;
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.player = null;
        }
        this.player = new ReportMediaPlayer();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public boolean isInit() {
        if (this.player != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            return mediaPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public void pause() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public void resume() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public void seekTo(int i3) {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i3);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public void setPlayMode(int i3) {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null && 100 == i3) {
            mediaPlayer.setLooping(false);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public void startPlay(SongInfo[] songInfoArr, int i3) {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setDataSource(songInfoArr[i3].url);
                this.player.prepareAsync();
                this.player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.qqmini.sdk.core.proxy.MusicPlayerProxyDefault.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer2) {
                        mediaPlayer2.start();
                    }
                });
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public void stop() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public void unInit() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}

package com.tencent.mobileqq.shortvideo.dancemachine;

import android.media.MediaPlayer;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.IOException;

/* loaded from: classes18.dex */
public class BgmPlayer implements MediaPlayer.OnPreparedListener {
    private MediaPlayer mediaPlayer = new ReportMediaPlayer();
    private boolean mPausedAudio = false;

    public boolean isPlaying() {
        return this.mediaPlayer.isPlaying();
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.mediaPlayer.start();
    }

    public void pauseAudio() {
        if (isPlaying()) {
            this.mediaPlayer.pause();
            this.mPausedAudio = true;
        }
    }

    public void playAsync(String str) {
        try {
            this.mediaPlayer.reset();
            this.mediaPlayer.setDataSource(str);
            if (this.mediaPlayer.isPlaying()) {
                return;
            }
            this.mediaPlayer.setOnPreparedListener(this);
            this.mediaPlayer.prepareAsync();
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    public void playSync(String str) {
        try {
            this.mediaPlayer.reset();
            this.mediaPlayer.setDataSource(str);
            if (this.mediaPlayer.isPlaying()) {
                return;
            }
            this.mediaPlayer.prepare();
            this.mediaPlayer.start();
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    public void releaseResource() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
    }

    public void resumeAudio() {
        if (this.mPausedAudio) {
            this.mediaPlayer.start();
            this.mPausedAudio = false;
        }
    }

    public void stop() {
        if (this.mediaPlayer.isPlaying()) {
            this.mediaPlayer.stop();
        }
        this.mPausedAudio = false;
    }
}

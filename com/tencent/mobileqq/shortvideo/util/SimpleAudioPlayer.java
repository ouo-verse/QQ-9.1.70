package com.tencent.mobileqq.shortvideo.util;

import android.media.MediaPlayer;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.sveffects.SdkContext;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;

/* loaded from: classes18.dex */
public class SimpleAudioPlayer implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {
    public static int INVALID_AUDIO_STREAM = -999;
    public static final String TAG = "SimpleAudioPlayer";
    private AmrPlayerThread mPlayThread;
    private MediaPlayer mPlayer;
    private String sourcePath;
    private volatile int phoneAudioStream = INVALID_AUDIO_STREAM;
    private int mSeekToTime = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class AmrPlayerThread extends BaseThread {
        AmrPlayerThread() {
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            if (SdkContext.getInstance().getLogger().isEnable()) {
                SdkContext.getInstance().getLogger().d(SimpleAudioPlayer.TAG, "playSimpleAudio " + SimpleAudioPlayer.this.sourcePath);
            }
            try {
                if (SimpleAudioPlayer.this.phoneAudioStream != SimpleAudioPlayer.INVALID_AUDIO_STREAM) {
                    SimpleAudioPlayer.this.mPlayer.setAudioStreamType(SimpleAudioPlayer.this.phoneAudioStream);
                }
                SimpleAudioPlayer.this.mPlayer.prepare();
                SimpleAudioPlayer.this.mPlayer.start();
                if (SimpleAudioPlayer.this.mSeekToTime > 0) {
                    SimpleAudioPlayer.this.mPlayer.seekTo(SimpleAudioPlayer.this.mSeekToTime);
                }
            } catch (Exception e16) {
                SdkContext.getInstance().getLogger().e(SimpleAudioPlayer.TAG, "playSimpleAudio " + SimpleAudioPlayer.this.sourcePath + "error: " + e16.toString());
            }
        }
    }

    private synchronized boolean play(String str, int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.sourcePath = str;
        if (!fileExistsAndNotEmpty(str)) {
            if (SdkContext.getInstance().getLogger().isEnable()) {
                SdkContext.getInstance().getLogger().d(TAG, "file not found, " + str);
            }
            stop();
            return false;
        }
        try {
            stopPlaying();
            ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
            this.mPlayer = reportMediaPlayer;
            reportMediaPlayer.setDataSource(str);
            this.mSeekToTime = i3;
            this.mPlayer.setOnCompletionListener(this);
            this.mPlayer.setOnErrorListener(this);
            if (this.mPlayThread == null) {
                AmrPlayerThread amrPlayerThread = new AmrPlayerThread();
                this.mPlayThread = amrPlayerThread;
                amrPlayerThread.start();
            }
            if (SdkContext.getInstance().getLogger().isEnable()) {
                SdkContext.getInstance().getLogger().d(TAG, "play music time = " + (System.currentTimeMillis() - currentTimeMillis));
            }
            return true;
        } catch (Exception e16) {
            if (SdkContext.getInstance().getLogger().isEnable()) {
                SdkContext.getInstance().getLogger().e(TAG, "play on error, ", e16);
            }
            onError(this.mPlayer, 0, 0);
            return false;
        }
    }

    private void stopPlaying() throws InterruptedException {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.mPlayer.stop();
                this.mPlayThread = null;
            }
            this.mPlayer.reset();
            this.mPlayer.release();
            this.mPlayer = null;
        }
    }

    public boolean fileExistsAndNotEmpty(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        return true;
    }

    public synchronized boolean isPlaying() {
        MediaPlayer mediaPlayer = this.mPlayer;
        boolean z16 = false;
        if (mediaPlayer == null) {
            return false;
        }
        try {
            z16 = mediaPlayer.isPlaying();
        } catch (IllegalStateException e16) {
            if (SdkContext.getInstance().getLogger().isEnable()) {
                SdkContext.getInstance().getLogger().e(TAG, "isPlaying on error, ", e16);
            }
        }
        return z16;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.mPlayThread = null;
        stop();
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
        this.mPlayThread = null;
        stop();
        SdkContext.getInstance().getLogger().e(TAG, "playSimpleAudio " + this.sourcePath + "onError: " + i3 + "," + i16);
        return true;
    }

    public boolean seekPlay(String str, int i3) {
        return play(str, i3);
    }

    public void setAudioStream(int i3) {
        this.phoneAudioStream = i3;
    }

    public synchronized void stop() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.mPlayer.stop();
                this.mPlayThread = null;
            }
            this.mPlayer.reset();
            this.mPlayer.release();
            this.sourcePath = null;
            this.mPlayer = null;
            this.phoneAudioStream = INVALID_AUDIO_STREAM;
        }
    }

    public boolean play(String str) {
        return play(str, 0);
    }
}

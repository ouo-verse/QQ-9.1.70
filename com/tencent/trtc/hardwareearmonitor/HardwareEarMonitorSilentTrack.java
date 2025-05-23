package com.tencent.trtc.hardwareearmonitor;

import android.media.AudioTrack;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
@JNINamespace("liteav::extensions")
/* loaded from: classes27.dex */
public class HardwareEarMonitorSilentTrack {
    private static final int DEFAULT_SAMPLE_RATE = 48000;
    private PlaybackThread mPlaybackThread;
    private int mChannelConfig = 12;
    private int mAudioFormat = 2;
    private boolean mIsPlaying = false;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class PlaybackThread extends BaseThread {
        private boolean isStop = false;

        PlaybackThread() {
        }

        public synchronized void closeThread() {
            this.isStop = true;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            int minBufferSize = AudioTrack.getMinBufferSize(48000, HardwareEarMonitorSilentTrack.this.mChannelConfig, HardwareEarMonitorSilentTrack.this.mAudioFormat);
            ReportAudioTrack reportAudioTrack = new ReportAudioTrack(3, 48000, HardwareEarMonitorSilentTrack.this.mChannelConfig, HardwareEarMonitorSilentTrack.this.mAudioFormat, minBufferSize, 1);
            if (reportAudioTrack.getState() == 1) {
                reportAudioTrack.play();
                byte[] bArr = new byte[minBufferSize];
                for (int i3 = 0; i3 < minBufferSize; i3++) {
                    bArr[i3] = 0;
                }
                while (!this.isStop && !isInterrupted()) {
                    try {
                        reportAudioTrack.write(bArr, 0, minBufferSize);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
                reportAudioTrack.stop();
                reportAudioTrack.flush();
            }
            reportAudioTrack.release();
        }
    }

    public static HardwareEarMonitorSilentTrack create() {
        return new HardwareEarMonitorSilentTrack();
    }

    public void StartAudioTrack() {
        if (!this.mIsPlaying && this.mPlaybackThread == null) {
            this.mIsPlaying = true;
            PlaybackThread playbackThread = new PlaybackThread();
            this.mPlaybackThread = playbackThread;
            playbackThread.start();
        }
    }

    public void StopAudioTrack() {
        PlaybackThread playbackThread = this.mPlaybackThread;
        if (playbackThread != null) {
            this.mIsPlaying = false;
            playbackThread.closeThread();
            try {
                this.mPlaybackThread.join();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            this.mPlaybackThread = null;
        }
    }
}

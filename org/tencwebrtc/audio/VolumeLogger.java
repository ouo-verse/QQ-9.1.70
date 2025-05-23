package org.tencwebrtc.audio;

import android.media.AudioManager;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;
import org.tencwebrtc.Logging;

/* compiled from: P */
/* loaded from: classes29.dex */
class VolumeLogger {
    private static final String TAG = "VolumeLogger";
    private static final String THREAD_NAME = "WebRtcVolumeLevelLoggerThread";
    private static final int TIMER_PERIOD_IN_SECONDS = 30;
    private final AudioManager audioManager;

    @Nullable
    private Timer timer;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private class LogVolumeTask extends TimerTask {
        private final int maxRingVolume;
        private final int maxVoiceCallVolume;

        LogVolumeTask(int i3, int i16) {
            this.maxRingVolume = i3;
            this.maxVoiceCallVolume = i16;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int mode = VolumeLogger.this.audioManager.getMode();
            if (mode == 1) {
                Logging.d(VolumeLogger.TAG, "STREAM_RING stream volume: " + SystemMethodProxy.getStreamVolume(VolumeLogger.this.audioManager, 2) + " (max=" + this.maxRingVolume + ")");
                return;
            }
            if (mode == 3) {
                Logging.d(VolumeLogger.TAG, "VOICE_CALL stream volume: " + SystemMethodProxy.getStreamVolume(VolumeLogger.this.audioManager, 0) + " (max=" + this.maxVoiceCallVolume + ")");
            }
        }
    }

    public VolumeLogger(AudioManager audioManager) {
        this.audioManager = audioManager;
    }

    public void start() {
        Logging.d(TAG, "start" + WebRtcAudioUtils.getThreadInfo());
        if (this.timer != null) {
            return;
        }
        Logging.d(TAG, "audio mode is: " + WebRtcAudioUtils.modeToString(this.audioManager.getMode()));
        BaseTimer baseTimer = new BaseTimer(THREAD_NAME);
        this.timer = baseTimer;
        baseTimer.schedule(new LogVolumeTask(this.audioManager.getStreamMaxVolume(2), this.audioManager.getStreamMaxVolume(0)), 0L, 30000L);
    }

    public void stop() {
        Logging.d(TAG, "stop" + WebRtcAudioUtils.getThreadInfo());
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }
}

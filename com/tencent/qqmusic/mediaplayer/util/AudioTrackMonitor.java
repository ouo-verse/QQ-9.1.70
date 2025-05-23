package com.tencent.qqmusic.mediaplayer.util;

import android.media.AudioTrack;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AudioTrackMonitor {
    private static final boolean ENABLE = false;
    private static final String TAG = "AudioTrackMonitor";
    private WeakReference<AudioTrack> mAudioTrackRef;
    private long mLastTime = System.nanoTime();
    private long mLastPosition = 0;
    private int mLooperTime = 200;
    private boolean mStop = false;
    private StringBuilder mBuilder = new StringBuilder(100);
    private Thread mMonitorThread = new BaseThread("Monitor-AudioTrack") { // from class: com.tencent.qqmusic.mediaplayer.util.AudioTrackMonitor.1
        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            while (!AudioTrackMonitor.this.mStop) {
                try {
                    Thread.currentThread();
                    LockMethodProxy.sleep(AudioTrackMonitor.this.mLooperTime);
                } catch (Throwable th5) {
                    Logger.e(AudioTrackMonitor.TAG, th5);
                }
                try {
                } catch (Throwable th6) {
                    Logger.e(AudioTrackMonitor.TAG, th6);
                }
                if (AudioTrackMonitor.this.mAudioTrackRef != null && AudioTrackMonitor.this.mAudioTrackRef.get() != null) {
                    AudioTrack audioTrack = (AudioTrack) AudioTrackMonitor.this.mAudioTrackRef.get();
                    if (audioTrack != null) {
                        long playbackHeadPosition = audioTrack.getPlaybackHeadPosition();
                        long j3 = playbackHeadPosition - AudioTrackMonitor.this.mLastPosition;
                        AudioTrackMonitor.this.mLastPosition = playbackHeadPosition;
                        long nanoTime = System.nanoTime() - AudioTrackMonitor.this.mLastTime;
                        AudioTrackMonitor.this.mLastTime = System.nanoTime();
                        StringBuilder sb5 = AudioTrackMonitor.this.mBuilder;
                        sb5.append("play-speedTime-");
                        sb5.append(nanoTime);
                        sb5.append(",play-speedPosition-");
                        sb5.append(j3);
                        StringBuilder sb6 = AudioTrackMonitor.this.mBuilder;
                        sb6.append(",playstate-");
                        sb6.append(audioTrack.getPlayState());
                        Logger.e(AudioTrackMonitor.TAG, AudioTrackMonitor.this.mBuilder.toString());
                        AudioTrackMonitor.this.mBuilder.delete(0, AudioTrackMonitor.this.mBuilder.length());
                    }
                } else {
                    return;
                }
            }
        }
    };

    public AudioTrackMonitor(AudioTrack audioTrack) {
        this.mAudioTrackRef = null;
        this.mAudioTrackRef = new WeakReference<>(audioTrack);
    }

    public void start() {
    }

    public void stop() {
    }
}

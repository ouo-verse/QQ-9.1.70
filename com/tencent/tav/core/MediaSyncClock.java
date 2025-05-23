package com.tencent.tav.core;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.logger.Logger;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MediaSyncClock {
    private static final String TAG = "MediaSyncClock";
    private final CMTime MAX_AHEAD;
    private final CMTime MAX_DELAY;
    private CMTime audioTime;
    private boolean enable;
    private CMTime videoTime;

    public MediaSyncClock(boolean z16) {
        CMTime cMTime = CMTime.CMTimeZero;
        this.videoTime = cMTime;
        this.audioTime = cMTime;
        this.MAX_DELAY = CMTime.fromMs(100L);
        this.MAX_AHEAD = CMTime.fromMs(300L);
        this.enable = z16;
    }

    private synchronized void syncAudioInternal(CMTime cMTime) {
        while (this.enable && cMTime.sub(this.MAX_AHEAD).bigThan(this.videoTime)) {
            try {
                LockMethodProxy.wait(this);
            } catch (InterruptedException unused) {
                Logger.e(TAG, "avSync interrupt");
            }
        }
        this.audioTime = cMTime;
        Logger.v(TAG, "syncAudioInternal() end.");
    }

    private synchronized void syncVideoInternal(CMTime cMTime) {
        this.videoTime = cMTime;
        notify();
    }

    public synchronized void close() {
        this.enable = false;
        notifyAll();
    }

    public void syncAudio(CMTime cMTime) {
        Logger.v(TAG, "syncAudio() called with: time = [" + cMTime + "]");
        if (!this.enable) {
            return;
        }
        syncAudioInternal(cMTime);
    }

    public void syncVideo(CMTime cMTime) {
        Logger.v(TAG, "syncVideo() called with: time = [" + cMTime + "]");
        if (!this.enable) {
            return;
        }
        syncVideoInternal(cMTime);
    }
}

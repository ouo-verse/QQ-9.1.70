package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes23.dex */
class PlayerStateRunner {
    private static final String TAG = "StateRunner";
    private Integer mState;
    private final ReadWriteLock mLock = new ReentrantReadWriteLock();
    private WeakReference<AudioTrack> mAudioTrack = new WeakReference<>(null);

    public PlayerStateRunner(Integer num) {
        this.mState = num;
    }

    public Integer get() {
        this.mLock.readLock().lock();
        try {
            int intValue = this.mState.intValue();
            AudioTrack audioTrack = this.mAudioTrack.get();
            if (audioTrack != null) {
                int playState = audioTrack.getPlayState();
                if (playState != 2) {
                    if (playState == 3) {
                        intValue = 4;
                    }
                } else {
                    intValue = 5;
                }
                if (!this.mState.equals(Integer.valueOf(intValue))) {
                    Logger.e(TAG, "!mState.equals(state), mstate = " + this.mState.toString() + "   state = " + intValue);
                }
            }
            return Integer.valueOf(intValue);
        } finally {
            this.mLock.readLock().unlock();
        }
    }

    public boolean isEqual(Integer... numArr) {
        this.mLock.readLock().lock();
        try {
            for (Integer num : numArr) {
                if (this.mState.equals(num)) {
                    this.mLock.readLock().unlock();
                    return true;
                }
            }
            return false;
        } finally {
            this.mLock.readLock().unlock();
        }
    }

    public void setAudioTrack(AudioTrack audioTrack) {
        this.mAudioTrack = new WeakReference<>(audioTrack);
    }

    public Integer transfer(Integer num) {
        this.mLock.writeLock().lock();
        try {
            Integer num2 = this.mState;
            this.mState = num;
            Logger.i(TAG, num2.toString() + " -> " + this.mState.toString());
            return num2;
        } finally {
            this.mLock.writeLock().unlock();
        }
    }

    public boolean transfer(Integer num, Integer... numArr) {
        this.mLock.writeLock().lock();
        try {
            if (!isEqual(numArr)) {
                this.mLock.writeLock().unlock();
                return false;
            }
            transfer(num);
            this.mLock.writeLock().unlock();
            return true;
        } catch (Throwable th5) {
            this.mLock.writeLock().unlock();
            throw th5;
        }
    }
}

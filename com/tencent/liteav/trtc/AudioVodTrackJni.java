package com.tencent.liteav.trtc;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.trtc.TRTCCloudDef;

/* compiled from: P */
@JNINamespace("liteav::trtc")
/* loaded from: classes7.dex */
public class AudioVodTrackJni {
    private long mNativeAudioVodTrackJni;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class AudioFrame {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCAudioFrame f119145a;

        public AudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
            this.f119145a = tRTCAudioFrame;
        }

        public int getChannel() {
            return this.f119145a.channel;
        }

        public byte[] getData() {
            return this.f119145a.data;
        }

        public int getSampleRate() {
            return this.f119145a.sampleRate;
        }

        public long getTimestamp() {
            return this.f119145a.timestamp;
        }
    }

    public AudioVodTrackJni() {
        this.mNativeAudioVodTrackJni = 0L;
        this.mNativeAudioVodTrackJni = nativeCreateAudioVodTrackJni(this);
    }

    private static native void nativeClean(long j3);

    private static native long nativeCreateAudioVodTrackJni(AudioVodTrackJni audioVodTrackJni);

    private static native void nativeEnablePlayout(long j3, boolean z16);

    private static native void nativePause(long j3);

    private static native void nativeResume(long j3);

    private static native void nativeSeek(long j3);

    private static native void nativeSetPlayoutVolume(long j3, int i3);

    private static native int nativeWriteData(long j3, AudioFrame audioFrame);

    public synchronized void clean() {
        long j3 = this.mNativeAudioVodTrackJni;
        if (j3 != 0) {
            nativeClean(j3);
        }
    }

    public synchronized void enablePlayout(boolean z16) {
        long j3 = this.mNativeAudioVodTrackJni;
        if (j3 != 0) {
            nativeEnablePlayout(j3, z16);
        }
    }

    public synchronized void pause() {
        long j3 = this.mNativeAudioVodTrackJni;
        if (j3 != 0) {
            nativePause(j3);
        }
    }

    public synchronized void resume() {
        long j3 = this.mNativeAudioVodTrackJni;
        if (j3 != 0) {
            nativeResume(j3);
        }
    }

    public synchronized void seek() {
        long j3 = this.mNativeAudioVodTrackJni;
        if (j3 != 0) {
            nativeSeek(j3);
        }
    }

    public synchronized void setPlayoutVolume(int i3) {
        long j3 = this.mNativeAudioVodTrackJni;
        if (j3 != 0) {
            nativeSetPlayoutVolume(j3, i3);
        }
    }

    public synchronized int writeData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        long j3 = this.mNativeAudioVodTrackJni;
        if (j3 != 0) {
            return nativeWriteData(j3, new AudioFrame(tRTCAudioFrame));
        }
        return -1;
    }
}

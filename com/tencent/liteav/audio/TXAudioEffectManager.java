package com.tencent.liteav.audio;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface TXAudioEffectManager {

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class AudioMusicParam {

        /* renamed from: id, reason: collision with root package name */
        public int f118843id;
        public String path;
        public int loopCount = 0;
        public boolean publish = false;
        public boolean isShortFile = false;
        public long startTimeMS = 0;
        public long endTimeMS = -1;

        public AudioMusicParam(int i3, String str) {
            this.path = str;
            this.f118843id = i3;
        }

        public String toString() {
            return "path=" + this.path + ", id=" + this.f118843id + ", loopCount=" + this.loopCount + ", publish=" + this.publish + ", isShortFile=" + this.isShortFile + ", startTimeMS=" + this.startTimeMS + ", endTimeMS=" + this.endTimeMS;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface TXMusicPlayObserver {
        void onComplete(int i3, int i16);

        void onPlayProgress(int i3, long j3, long j16);

        void onStart(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface TXMusicPreloadObserver {
        void onLoadError(int i3, int i16);

        void onLoadProgress(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum TXVoiceChangerType {
        TXLiveVoiceChangerType_0(0),
        TXLiveVoiceChangerType_1(1),
        TXLiveVoiceChangerType_2(2),
        TXLiveVoiceChangerType_3(3),
        TXLiveVoiceChangerType_4(4),
        TXLiveVoiceChangerType_5(5),
        TXLiveVoiceChangerType_6(6),
        TXLiveVoiceChangerType_7(7),
        TXLiveVoiceChangerType_8(8),
        TXLiveVoiceChangerType_9(9),
        TXLiveVoiceChangerType_10(10),
        TXLiveVoiceChangerType_11(11);

        private int nativeValue;

        TXVoiceChangerType(int i3) {
            this.nativeValue = i3;
        }

        public final int getNativeValue() {
            return this.nativeValue;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum TXVoiceReverbType {
        TXLiveVoiceReverbType_0(0),
        TXLiveVoiceReverbType_1(1),
        TXLiveVoiceReverbType_2(2),
        TXLiveVoiceReverbType_3(3),
        TXLiveVoiceReverbType_4(4),
        TXLiveVoiceReverbType_5(5),
        TXLiveVoiceReverbType_6(6),
        TXLiveVoiceReverbType_7(7),
        TXLiveVoiceReverbType_8(8),
        TXLiveVoiceReverbType_9(9),
        TXLiveVoiceReverbType_10(10),
        TXLiveVoiceReverbType_11(11);

        private int nativeValue;

        TXVoiceReverbType(int i3) {
            this.nativeValue = i3;
        }

        public final int getNativeValue() {
            return this.nativeValue;
        }
    }

    void enableVoiceEarMonitor(boolean z16);

    long getMusicCurrentPosInMS(int i3);

    long getMusicDurationInMS(String str);

    int getMusicTrackCount(int i3);

    void pausePlayMusic(int i3);

    boolean preloadMusic(AudioMusicParam audioMusicParam);

    void resumePlayMusic(int i3);

    void seekMusicToPosInMS(int i3, int i16);

    void setAllMusicVolume(int i3);

    void setMusicObserver(int i3, TXMusicPlayObserver tXMusicPlayObserver);

    void setMusicPitch(int i3, float f16);

    void setMusicPlayoutVolume(int i3, int i16);

    void setMusicPublishVolume(int i3, int i16);

    void setMusicScratchSpeedRate(int i3, float f16);

    void setMusicSpeedRate(int i3, float f16);

    void setMusicTrack(int i3, int i16);

    void setPreloadObserver(TXMusicPreloadObserver tXMusicPreloadObserver);

    void setVoiceCaptureVolume(int i3);

    void setVoiceChangerType(TXVoiceChangerType tXVoiceChangerType);

    void setVoiceEarMonitorVolume(int i3);

    void setVoicePitch(double d16);

    void setVoiceReverbType(TXVoiceReverbType tXVoiceReverbType);

    boolean startPlayMusic(AudioMusicParam audioMusicParam);

    void stopPlayMusic(int i3);
}

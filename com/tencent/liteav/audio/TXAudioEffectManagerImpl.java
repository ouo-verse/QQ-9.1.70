package com.tencent.liteav.audio;

import android.text.TextUtils;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
@JNINamespace("liteav::manager")
/* loaded from: classes7.dex */
public class TXAudioEffectManagerImpl implements TXAudioEffectManager {
    private static final int EFFECT_PLAYER_ID_TYPE = 2;
    private static final String TAG = "TXAudioEffectManagerImpl";
    private List<Integer> mEffectIdList = new ArrayList();
    private final MusicPlayObserver mMusicPlayObserver;
    private final MusicPreloadObserver mMusicPreloadObserver;
    private long mNativeAudioEffectMgr;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class AudioBgmParams {
        private TXAudioEffectManager.AudioMusicParam mParams;

        public AudioBgmParams(TXAudioEffectManager.AudioMusicParam audioMusicParam) {
            this.mParams = audioMusicParam;
        }

        public long getEndTimeMS() {
            return this.mParams.endTimeMS;
        }

        public int getLoopCount() {
            return this.mParams.loopCount;
        }

        public String getPath() {
            return this.mParams.path;
        }

        public long getStartTimeMS() {
            return this.mParams.startTimeMS;
        }

        public boolean isPublish() {
            return this.mParams.publish;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class MusicPlayObserver {
        private final HashMap<Long, TXAudioEffectManager.TXMusicPlayObserver> mObserverMap = new HashMap<>();

        MusicPlayObserver() {
        }

        public void addObserver(long j3, TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver) {
            if (tXMusicPlayObserver == null) {
                return;
            }
            synchronized (this) {
                this.mObserverMap.put(Long.valueOf(j3), tXMusicPlayObserver);
            }
        }

        public void onComplete(long j3, int i3) {
            TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver;
            synchronized (this) {
                tXMusicPlayObserver = this.mObserverMap.get(Long.valueOf(j3));
            }
            if (tXMusicPlayObserver != null) {
                tXMusicPlayObserver.onComplete((int) j3, i3);
            }
        }

        public void onPlayProgress(long j3, long j16, long j17) {
            TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver;
            synchronized (this) {
                tXMusicPlayObserver = this.mObserverMap.get(Long.valueOf(j3));
            }
            if (tXMusicPlayObserver != null) {
                tXMusicPlayObserver.onPlayProgress((int) j3, j16, j17);
            }
        }

        public void onStart(long j3, int i3) {
            TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver;
            synchronized (this) {
                tXMusicPlayObserver = this.mObserverMap.get(Long.valueOf(j3));
            }
            if (tXMusicPlayObserver != null) {
                tXMusicPlayObserver.onStart((int) j3, i3);
            }
        }

        public void removeObserver(long j3) {
            synchronized (this) {
                this.mObserverMap.remove(Long.valueOf(j3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class MusicPreloadObserver {
        private TXAudioEffectManager.TXMusicPreloadObserver mObserver;

        MusicPreloadObserver() {
        }

        public void onLoadError(long j3, int i3) {
            TXAudioEffectManager.TXMusicPreloadObserver tXMusicPreloadObserver = this.mObserver;
            if (tXMusicPreloadObserver != null) {
                tXMusicPreloadObserver.onLoadError((int) j3, i3);
            }
        }

        public void onLoadProgress(long j3, int i3) {
            TXAudioEffectManager.TXMusicPreloadObserver tXMusicPreloadObserver = this.mObserver;
            if (tXMusicPreloadObserver != null) {
                tXMusicPreloadObserver.onLoadProgress((int) j3, i3);
            }
        }

        public void setObserver(TXAudioEffectManager.TXMusicPreloadObserver tXMusicPreloadObserver) {
            this.mObserver = tXMusicPreloadObserver;
        }
    }

    public TXAudioEffectManagerImpl(long j3) {
        this.mNativeAudioEffectMgr = 0L;
        MusicPlayObserver musicPlayObserver = new MusicPlayObserver();
        this.mMusicPlayObserver = musicPlayObserver;
        MusicPreloadObserver musicPreloadObserver = new MusicPreloadObserver();
        this.mMusicPreloadObserver = musicPreloadObserver;
        this.mNativeAudioEffectMgr = j3;
        if (j3 != 0) {
            nativeSetMusicObserver(j3, musicPlayObserver);
            nativeSetPreloadObserver(this.mNativeAudioEffectMgr, musicPreloadObserver);
        }
    }

    private static long convertToEffectId(int i3) {
        return 8589934592L | i3;
    }

    private static native void nativeDestroy(long j3);

    private static native void nativeEnableVoiceEarMonitor(long j3, boolean z16);

    private static native long nativeGetMusicCurrentPosInMS(long j3, long j16);

    private static native long nativeGetMusicDurationInMS(long j3, String str);

    private static native int nativeGetMusicTrackCount(long j3, long j16);

    private static native void nativePausePlayMusic(long j3, long j16);

    private static native void nativePreloadMusic(long j3, long j16, AudioBgmParams audioBgmParams);

    private static native void nativeResumePlayMusic(long j3, long j16);

    private static native void nativeSeekMusicToPosInMS(long j3, long j16, long j17);

    private static native void nativeSetAllMusicVolume(long j3, int i3);

    private static native void nativeSetMusicObserver(long j3, MusicPlayObserver musicPlayObserver);

    private static native void nativeSetMusicPitch(long j3, long j16, float f16);

    private static native void nativeSetMusicPlayoutVolume(long j3, long j16, int i3);

    private static native void nativeSetMusicPublishVolume(long j3, long j16, int i3);

    private static native void nativeSetMusicScratchSpeedRate(long j3, long j16, float f16);

    private static native void nativeSetMusicSpeedRate(long j3, long j16, float f16);

    private static native void nativeSetMusicTrack(long j3, long j16, int i3);

    private static native void nativeSetPreloadObserver(long j3, MusicPreloadObserver musicPreloadObserver);

    private static native void nativeSetVoiceCaptureVolume(long j3, int i3);

    private static native void nativeSetVoiceChangerType(long j3, int i3);

    private static native void nativeSetVoiceEarMonitorVolume(long j3, int i3);

    private static native void nativeSetVoicePitch(long j3, double d16);

    private static native void nativeSetVoiceReverbType(long j3, int i3);

    private static native void nativeStartPlayMusic(long j3, long j16, AudioBgmParams audioBgmParams);

    private static native void nativeStopPlayMusic(long j3, long j16);

    public static TXAudioEffectManager.TXVoiceChangerType voiceChangerTypeFromInt(int i3) {
        if (i3 == 0) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0;
        }
        if (i3 == 1) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_1;
        }
        if (i3 == 2) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_2;
        }
        if (i3 == 3) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_3;
        }
        if (i3 == 4) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_4;
        }
        if (i3 == 5) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_5;
        }
        if (i3 == 6) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_6;
        }
        if (i3 == 7) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_7;
        }
        if (i3 == 8) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_8;
        }
        if (i3 == 9) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_9;
        }
        if (i3 == 10) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_10;
        }
        if (i3 == 11) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_11;
        }
        return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0;
    }

    public static TXAudioEffectManager.TXVoiceReverbType voiceReverbTypeFromInt(int i3) {
        if (i3 == 0) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0;
        }
        if (i3 == 1) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1;
        }
        if (i3 == 2) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2;
        }
        if (i3 == 3) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3;
        }
        if (i3 == 4) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4;
        }
        if (i3 == 5) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5;
        }
        if (i3 == 6) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6;
        }
        if (i3 == 7) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7;
        }
        if (i3 == 8) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_8;
        }
        if (i3 == 9) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_9;
        }
        if (i3 == 10) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_10;
        }
        return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0;
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void enableVoiceEarMonitor(boolean z16) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativeEnableVoiceEarMonitor(j3, z16);
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativeDestroy(j3);
            this.mNativeAudioEffectMgr = 0L;
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public long getMusicCurrentPosInMS(int i3) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 == 0) {
            return 0L;
        }
        return nativeGetMusicCurrentPosInMS(j3, i3);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public long getMusicDurationInMS(String str) {
        if (TextUtils.isEmpty(str)) {
            LiteavLog.e(TAG, "getMusicDurationInMS invalid params");
            return 0L;
        }
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 == 0) {
            return 0L;
        }
        return nativeGetMusicDurationInMS(j3, str);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public int getMusicTrackCount(int i3) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            return nativeGetMusicTrackCount(j3, i3);
        }
        return 0;
    }

    public void pauseAudioEffect(int i3) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativePausePlayMusic(j3, convertToEffectId(i3));
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void pausePlayMusic(int i3) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativePausePlayMusic(j3, i3);
        }
    }

    public void playAudioEffect(TXAudioEffectManager.AudioMusicParam audioMusicParam) {
        if (audioMusicParam != null && !TextUtils.isEmpty(audioMusicParam.path)) {
            long j3 = this.mNativeAudioEffectMgr;
            if (j3 != 0) {
                nativeStartPlayMusic(j3, convertToEffectId(audioMusicParam.f118843id), new AudioBgmParams(audioMusicParam));
                synchronized (this) {
                    this.mEffectIdList.add(Integer.valueOf(audioMusicParam.f118843id));
                }
                return;
            }
            return;
        }
        LiteavLog.e(TAG, "startPlayMusic invalid params");
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public boolean preloadMusic(TXAudioEffectManager.AudioMusicParam audioMusicParam) {
        if (audioMusicParam == null) {
            LiteavLog.e(TAG, "preloadMusic invalid params");
            return false;
        }
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativePreloadMusic(j3, audioMusicParam.f118843id, new AudioBgmParams(audioMusicParam));
            return true;
        }
        return true;
    }

    public void resumeAudioEffect(int i3) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativeResumePlayMusic(j3, convertToEffectId(i3));
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void resumePlayMusic(int i3) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativeResumePlayMusic(j3, i3);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void seekMusicToPosInMS(int i3, int i16) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativeSeekMusicToPosInMS(j3, i3, i16);
        }
    }

    public void setAllAudioEffectsVolume(int i3) {
        if (this.mNativeAudioEffectMgr != 0) {
            synchronized (this) {
                Iterator<Integer> it = this.mEffectIdList.iterator();
                while (it.hasNext()) {
                    setAudioEffectVolume(it.next().intValue(), i3);
                }
            }
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setAllMusicVolume(int i3) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativeSetAllMusicVolume(j3, i3);
        }
    }

    public void setAudioEffectVolume(int i3, int i16) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativeSetMusicPlayoutVolume(j3, convertToEffectId(i3), i16);
            nativeSetMusicPublishVolume(this.mNativeAudioEffectMgr, convertToEffectId(i3), i16);
        }
    }

    public void setEffectObserver(int i3, TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver) {
        if (this.mNativeAudioEffectMgr != 0) {
            if (tXMusicPlayObserver != null) {
                this.mMusicPlayObserver.addObserver(convertToEffectId(i3), tXMusicPlayObserver);
            } else {
                this.mMusicPlayObserver.removeObserver(convertToEffectId(i3));
            }
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setMusicObserver(int i3, TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver) {
        if (this.mNativeAudioEffectMgr != 0) {
            if (tXMusicPlayObserver != null) {
                this.mMusicPlayObserver.addObserver(i3, tXMusicPlayObserver);
            } else {
                this.mMusicPlayObserver.removeObserver(i3);
            }
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setMusicPitch(int i3, float f16) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativeSetMusicPitch(j3, i3, f16);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setMusicPlayoutVolume(int i3, int i16) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativeSetMusicPlayoutVolume(j3, i3, i16);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setMusicPublishVolume(int i3, int i16) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativeSetMusicPublishVolume(j3, i3, i16);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setMusicScratchSpeedRate(int i3, float f16) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativeSetMusicScratchSpeedRate(j3, i3, f16);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setMusicSpeedRate(int i3, float f16) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativeSetMusicSpeedRate(j3, i3, f16);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setMusicTrack(int i3, int i16) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativeSetMusicTrack(j3, i3, i16);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setPreloadObserver(TXAudioEffectManager.TXMusicPreloadObserver tXMusicPreloadObserver) {
        if (this.mNativeAudioEffectMgr != 0) {
            this.mMusicPreloadObserver.setObserver(tXMusicPreloadObserver);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setVoiceCaptureVolume(int i3) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativeSetVoiceCaptureVolume(j3, i3);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setVoiceChangerType(TXAudioEffectManager.TXVoiceChangerType tXVoiceChangerType) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0 && tXVoiceChangerType != null) {
            nativeSetVoiceChangerType(j3, tXVoiceChangerType.getNativeValue());
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setVoiceEarMonitorVolume(int i3) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativeSetVoiceEarMonitorVolume(j3, i3);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setVoicePitch(double d16) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativeSetVoicePitch(j3, d16);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setVoiceReverbType(TXAudioEffectManager.TXVoiceReverbType tXVoiceReverbType) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0 && tXVoiceReverbType != null) {
            nativeSetVoiceReverbType(j3, tXVoiceReverbType.getNativeValue());
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public boolean startPlayMusic(TXAudioEffectManager.AudioMusicParam audioMusicParam) {
        if (audioMusicParam == null) {
            LiteavLog.e(TAG, "startPlayMusic invalid params");
            return false;
        }
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativeStartPlayMusic(j3, audioMusicParam.f118843id, new AudioBgmParams(audioMusicParam));
            return true;
        }
        return true;
    }

    public void stopAllAudioEffects() {
        if (this.mNativeAudioEffectMgr != 0) {
            synchronized (this) {
                for (Integer num : this.mEffectIdList) {
                    this.mMusicPlayObserver.removeObserver(convertToEffectId(num.intValue()));
                    nativeStopPlayMusic(this.mNativeAudioEffectMgr, convertToEffectId(num.intValue()));
                }
                this.mEffectIdList.clear();
            }
        }
    }

    public void stopAudioEffect(int i3) {
        if (this.mNativeAudioEffectMgr != 0) {
            this.mMusicPlayObserver.removeObserver(convertToEffectId(i3));
            nativeStopPlayMusic(this.mNativeAudioEffectMgr, convertToEffectId(i3));
            synchronized (this) {
                int indexOf = this.mEffectIdList.indexOf(Integer.valueOf(i3));
                if (indexOf >= 0) {
                    this.mEffectIdList.remove(indexOf);
                }
            }
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void stopPlayMusic(int i3) {
        long j3 = this.mNativeAudioEffectMgr;
        if (j3 != 0) {
            nativeStopPlayMusic(j3, i3);
        }
    }
}

package com.tencent.liteav.live;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.SoLoader;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePremier;

@JNINamespace("liteav")
/* loaded from: classes7.dex */
public class V2TXLivePremierJni {
    private static final String TAG = "V2TXLivePremierJni";
    private static long mNativeV2TXLivePremierJni;
    private static V2TXLivePremier.V2TXLivePremierObserver sObserver;

    static {
        SoLoader.loadAllLibraries();
        mNativeV2TXLivePremierJni = 0L;
    }

    public static int callExperimentalAPI(String str) {
        createNativeV2TXLivePremierIfNeed();
        return nativeCallExperimentalAPI(mNativeV2TXLivePremierJni, str);
    }

    private static void createNativeV2TXLivePremierIfNeed() {
        synchronized (V2TXLivePremierJni.class) {
            if (mNativeV2TXLivePremierJni == 0) {
                mNativeV2TXLivePremierJni = nativeCreate();
            }
        }
    }

    public static int enableAudioCaptureObserver(boolean z16, V2TXLiveDef.V2TXLiveAudioFrameObserverFormat v2TXLiveAudioFrameObserverFormat) {
        createNativeV2TXLivePremierIfNeed();
        return nativeEnableAudioCaptureObserver(mNativeV2TXLivePremierJni, z16, v2TXLiveAudioFrameObserverFormat.sampleRate, v2TXLiveAudioFrameObserverFormat.channel, v2TXLiveAudioFrameObserverFormat.samplesPerCall, v2TXLiveAudioFrameObserverFormat.mode.ordinal());
    }

    public static int enableAudioPlayoutObserver(boolean z16, V2TXLiveDef.V2TXLiveAudioFrameObserverFormat v2TXLiveAudioFrameObserverFormat) {
        createNativeV2TXLivePremierIfNeed();
        return nativeEnableAudioPlayoutObserver(mNativeV2TXLivePremierJni, z16, v2TXLiveAudioFrameObserverFormat.sampleRate, v2TXLiveAudioFrameObserverFormat.channel, v2TXLiveAudioFrameObserverFormat.samplesPerCall, v2TXLiveAudioFrameObserverFormat.mode.ordinal());
    }

    public static int enableVoiceEarMonitorObserver(boolean z16) {
        createNativeV2TXLivePremierIfNeed();
        return nativeEnableVoiceEarMonitorObserver(mNativeV2TXLivePremierJni, z16);
    }

    private static native int nativeCallExperimentalAPI(long j3, String str);

    private static native long nativeCreate();

    private static native int nativeEnableAudioCaptureObserver(long j3, boolean z16, int i3, int i16, int i17, int i18);

    private static native int nativeEnableAudioPlayoutObserver(long j3, boolean z16, int i3, int i16, int i17, int i18);

    private static native int nativeEnableVoiceEarMonitorObserver(long j3, boolean z16);

    public static void onAudioCaptureData(byte[] bArr, long j3, int i3, int i16) {
        V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver = sObserver;
        if (v2TXLivePremierObserver == null) {
            return;
        }
        V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame = new V2TXLiveDef.V2TXLiveAudioFrame();
        v2TXLiveAudioFrame.data = bArr;
        v2TXLiveAudioFrame.sampleRate = i3;
        v2TXLiveAudioFrame.channel = i16;
        v2TXLiveAudioFrame.timestamp = j3;
        v2TXLivePremierObserver.onCaptureAudioFrame(v2TXLiveAudioFrame);
    }

    public static void onAudioPlayoutData(byte[] bArr, long j3, int i3, int i16) {
        V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver = sObserver;
        if (v2TXLivePremierObserver == null) {
            return;
        }
        V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame = new V2TXLiveDef.V2TXLiveAudioFrame();
        v2TXLiveAudioFrame.data = bArr;
        v2TXLiveAudioFrame.sampleRate = i3;
        v2TXLiveAudioFrame.channel = i16;
        v2TXLiveAudioFrame.timestamp = j3;
        v2TXLivePremierObserver.onPlayoutAudioFrame(v2TXLiveAudioFrame);
    }

    public static void onEarMonitoringData(byte[] bArr, int i3, int i16) {
        V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver = sObserver;
        if (v2TXLivePremierObserver == null) {
            return;
        }
        V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame = new V2TXLiveDef.V2TXLiveAudioFrame();
        v2TXLiveAudioFrame.data = bArr;
        v2TXLiveAudioFrame.sampleRate = i3;
        v2TXLiveAudioFrame.channel = i16;
        v2TXLivePremierObserver.onVoiceEarMonitorAudioFrame(v2TXLiveAudioFrame);
    }

    public static void setObserver(V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver) {
        sObserver = v2TXLivePremierObserver;
    }
}

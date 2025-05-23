package com.tencent.mobileqq.tritonaudio.webaudio;

/* compiled from: P */
/* loaded from: classes19.dex */
class AudioNativeManager {
    AudioNativeManager() {
    }

    public static native void adJustSourceGain(int i3, float f16);

    public static native void addGain();

    public static native void bindBufferToSource(int i3, int i16);

    public static native void closeAudioContext();

    public static native int copyToChannel(byte[] bArr, int i3, int i16, int i17, int i18);

    public static native int createBuffer(int i3, int i16, int i17);

    public static native int createBufferSource();

    public static native void createScriptProcessorNode(int i3, int i16, int i17);

    public static native byte[] getBufferChannelData(int i3, int i16);

    public static native float getChannelConeInnerAngle(int i3);

    public static native float getChannelConeOuterAngle(int i3);

    public static native float getChannelConeOuterGain(int i3);

    public static native float getCurrentGain(int i3);

    public static native void initAudioContext();

    public static native void initOpenAL();

    public static native boolean isSourceStopped(int i3);

    public static native int loadRawData(byte[] bArr, int i3, int i16, int i17);

    public static native void lossGain();

    public static native int onAudioProcess(int i3);

    public static native void pauseSource(int i3);

    public static native void play(int i3, float f16);

    public static native void resumeAudioContext();

    public static native void resumeSource(int i3);

    public static native void setBufferSourceLoop(int i3, boolean z16);

    public static native float setChannelConeInnerAngle(int i3, float f16);

    public static native float setChannelConeOuterAngle(int i3, float f16);

    public static native float setChannelConeOuterGain(int i3, float f16);

    public static native void setChannelPosition(int i3, float[] fArr);

    public static native void setCurrentGain(int i3, float f16);

    public static native void setQueueBuffer(int i3, int i16);

    public static native void stopSource(int i3);

    public static native void suspendAudioContext();

    public static native void testEndFunction();

    public static native void testInitFunction();
}

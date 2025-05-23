package com.tencent.avcore.jni.dav;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface NtrtcAudioCallback {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface NtrtcAudioDeviceState {
        public static final int STARTED_FAILED = 1;
        public static final int STARTED_OK = 0;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface NtrtcRecvAudioDataState {
        public static final int CAN_RECV_DATA = 1;
        public static final int HAS_RECV_FIRST_PKG = 0;
        public static final int NOT_RECV_DATA = 2;
    }

    void onAudioEngineInstanceIsOccupied();

    void onAudioEngineStartResult(int i3);

    void onMicStateChanged(int i3);

    void onMicZeroEnergy();

    void onPlayerStateChanged(int i3);

    void onRecordData(int i3, byte[] bArr, int i16);

    void onRecvDataState(int i3);

    void onSelfSpeakingWhenMicClosed();

    void onUpdateSelfSpeakingEnergy(int i3);
}

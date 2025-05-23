package org.tencwebrtc;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AudioTrack extends MediaStreamTrack {
    public AudioTrack(long j3) {
        super(j3);
    }

    private static native void nativeSetVolume(long j3, double d16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNativeAudioTrack() {
        return getNativeMediaStreamTrack();
    }

    public void setVolume(double d16) {
        nativeSetVolume(getNativeAudioTrack(), d16);
    }
}

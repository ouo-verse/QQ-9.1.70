package org.tencwebrtc;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MediaSource {
    private long nativeSource;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum State {
        INITIALIZING,
        LIVE,
        ENDED,
        MUTED;

        @CalledByNative("State")
        static State fromNativeIndex(int i3) {
            return values()[i3];
        }
    }

    public MediaSource(long j3) {
        this.nativeSource = j3;
    }

    private void checkMediaSourceExists() {
        if (this.nativeSource != 0) {
        } else {
            throw new IllegalStateException("MediaSource has been disposed.");
        }
    }

    private static native State nativeGetState(long j3);

    public void dispose() {
        checkMediaSourceExists();
        JniCommon.nativeReleaseRef(this.nativeSource);
        this.nativeSource = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getNativeMediaSource() {
        checkMediaSourceExists();
        return this.nativeSource;
    }

    public State state() {
        checkMediaSourceExists();
        return nativeGetState(this.nativeSource);
    }
}

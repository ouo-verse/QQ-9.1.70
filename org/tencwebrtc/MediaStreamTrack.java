package org.tencwebrtc;

import android.support.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MediaStreamTrack {
    public static final String AUDIO_TRACK_KIND = "audio";
    public static final String VIDEO_TRACK_KIND = "video";
    private long nativeTrack;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum MediaType {
        MEDIA_TYPE_AUDIO(0),
        MEDIA_TYPE_VIDEO(1);

        private final int nativeIndex;

        MediaType(int i3) {
            this.nativeIndex = i3;
        }

        @CalledByNative("MediaType")
        static MediaType fromNativeIndex(int i3) {
            for (MediaType mediaType : values()) {
                if (mediaType.getNative() == i3) {
                    return mediaType;
                }
            }
            throw new IllegalArgumentException("Unknown native media type: " + i3);
        }

        @CalledByNative("MediaType")
        int getNative() {
            return this.nativeIndex;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum State {
        LIVE,
        ENDED;

        @CalledByNative("State")
        static State fromNativeIndex(int i3) {
            return values()[i3];
        }
    }

    public MediaStreamTrack(long j3) {
        if (j3 != 0) {
            this.nativeTrack = j3;
            return;
        }
        throw new IllegalArgumentException("nativeTrack may not be null");
    }

    private void checkMediaStreamTrackExists() {
        if (this.nativeTrack != 0) {
        } else {
            throw new IllegalStateException("MediaStreamTrack has been disposed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static MediaStreamTrack createMediaStreamTrack(long j3) {
        if (j3 == 0) {
            return null;
        }
        String nativeGetKind = nativeGetKind(j3);
        if (nativeGetKind.equals("audio")) {
            return new AudioTrack(j3);
        }
        if (!nativeGetKind.equals("video")) {
            return null;
        }
        return new VideoTrack(j3);
    }

    private static native boolean nativeGetEnabled(long j3);

    private static native String nativeGetId(long j3);

    private static native String nativeGetKind(long j3);

    private static native State nativeGetState(long j3);

    private static native boolean nativeSetEnabled(long j3, boolean z16);

    public void dispose() {
        checkMediaStreamTrackExists();
        JniCommon.nativeReleaseRef(this.nativeTrack);
        this.nativeTrack = 0L;
    }

    public boolean enabled() {
        checkMediaStreamTrackExists();
        return nativeGetEnabled(this.nativeTrack);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNativeMediaStreamTrack() {
        checkMediaStreamTrackExists();
        return this.nativeTrack;
    }

    public String id() {
        checkMediaStreamTrackExists();
        return nativeGetId(this.nativeTrack);
    }

    public String kind() {
        checkMediaStreamTrackExists();
        return nativeGetKind(this.nativeTrack);
    }

    public boolean setEnabled(boolean z16) {
        checkMediaStreamTrackExists();
        return nativeSetEnabled(this.nativeTrack, z16);
    }

    public State state() {
        checkMediaStreamTrackExists();
        return nativeGetState(this.nativeTrack);
    }
}

package org.tencwebrtc;

import android.support.annotation.Nullable;
import org.tencwebrtc.MediaStreamTrack;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RtpReceiver {

    @Nullable
    private MediaStreamTrack cachedTrack;
    private long nativeObserver;
    private long nativeRtpReceiver;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface Observer {
        @CalledByNative("Observer")
        void onFirstPacketReceived(MediaStreamTrack.MediaType mediaType);
    }

    @CalledByNative
    public RtpReceiver(long j3) {
        this.nativeRtpReceiver = j3;
        this.cachedTrack = MediaStreamTrack.createMediaStreamTrack(nativeGetTrack(j3));
    }

    private void checkRtpReceiverExists() {
        if (this.nativeRtpReceiver != 0) {
        } else {
            throw new IllegalStateException("RtpReceiver has been disposed.");
        }
    }

    private static native String nativeGetId(long j3);

    private static native RtpParameters nativeGetParameters(long j3);

    private static native long nativeGetTrack(long j3);

    private static native void nativeSetFrameDecryptor(long j3, long j16);

    private static native long nativeSetObserver(long j3, Observer observer);

    private static native boolean nativeSetParameters(long j3, RtpParameters rtpParameters);

    private static native void nativeUnsetObserver(long j3, long j16);

    public void SetObserver(Observer observer) {
        checkRtpReceiverExists();
        long j3 = this.nativeObserver;
        if (j3 != 0) {
            nativeUnsetObserver(this.nativeRtpReceiver, j3);
        }
        this.nativeObserver = nativeSetObserver(this.nativeRtpReceiver, observer);
    }

    @CalledByNative
    public void dispose() {
        checkRtpReceiverExists();
        this.cachedTrack.dispose();
        long j3 = this.nativeObserver;
        if (j3 != 0) {
            nativeUnsetObserver(this.nativeRtpReceiver, j3);
            this.nativeObserver = 0L;
        }
        JniCommon.nativeReleaseRef(this.nativeRtpReceiver);
        this.nativeRtpReceiver = 0L;
    }

    public RtpParameters getParameters() {
        checkRtpReceiverExists();
        return nativeGetParameters(this.nativeRtpReceiver);
    }

    public String id() {
        checkRtpReceiverExists();
        return nativeGetId(this.nativeRtpReceiver);
    }

    public void setFrameDecryptor(FrameDecryptor frameDecryptor) {
        checkRtpReceiverExists();
        nativeSetFrameDecryptor(this.nativeRtpReceiver, frameDecryptor.getNativeFrameDecryptor());
    }

    public boolean setParameters(@Nullable RtpParameters rtpParameters) {
        checkRtpReceiverExists();
        if (rtpParameters == null) {
            return false;
        }
        return nativeSetParameters(this.nativeRtpReceiver, rtpParameters);
    }

    @Nullable
    public MediaStreamTrack track() {
        return this.cachedTrack;
    }
}

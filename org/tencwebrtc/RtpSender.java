package org.tencwebrtc;

import android.support.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RtpSender {

    @Nullable
    private MediaStreamTrack cachedTrack;

    @Nullable
    private final DtmfSender dtmfSender;
    private long nativeRtpSender;
    private boolean ownsTrack = true;

    @CalledByNative
    public RtpSender(long j3) {
        DtmfSender dtmfSender;
        this.nativeRtpSender = j3;
        this.cachedTrack = MediaStreamTrack.createMediaStreamTrack(nativeGetTrack(j3));
        long nativeGetDtmfSender = nativeGetDtmfSender(j3);
        if (nativeGetDtmfSender != 0) {
            dtmfSender = new DtmfSender(nativeGetDtmfSender);
        } else {
            dtmfSender = null;
        }
        this.dtmfSender = dtmfSender;
    }

    private void checkRtpSenderExists() {
        if (this.nativeRtpSender != 0) {
        } else {
            throw new IllegalStateException("RtpSender has been disposed.");
        }
    }

    private static native long nativeGetDtmfSender(long j3);

    private static native String nativeGetId(long j3);

    private static native RtpParameters nativeGetParameters(long j3);

    private static native long nativeGetTrack(long j3);

    private static native void nativeSetFrameEncryptor(long j3, long j16);

    private static native boolean nativeSetParameters(long j3, RtpParameters rtpParameters);

    private static native boolean nativeSetTrack(long j3, long j16);

    public void dispose() {
        checkRtpSenderExists();
        DtmfSender dtmfSender = this.dtmfSender;
        if (dtmfSender != null) {
            dtmfSender.dispose();
        }
        MediaStreamTrack mediaStreamTrack = this.cachedTrack;
        if (mediaStreamTrack != null && this.ownsTrack) {
            mediaStreamTrack.dispose();
        }
        JniCommon.nativeReleaseRef(this.nativeRtpSender);
        this.nativeRtpSender = 0L;
    }

    @Nullable
    public DtmfSender dtmf() {
        return this.dtmfSender;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNativeRtpSender() {
        checkRtpSenderExists();
        return this.nativeRtpSender;
    }

    public RtpParameters getParameters() {
        checkRtpSenderExists();
        return nativeGetParameters(this.nativeRtpSender);
    }

    public String id() {
        checkRtpSenderExists();
        return nativeGetId(this.nativeRtpSender);
    }

    public void setFrameEncryptor(FrameEncryptor frameEncryptor) {
        checkRtpSenderExists();
        nativeSetFrameEncryptor(this.nativeRtpSender, frameEncryptor.getNativeFrameEncryptor());
    }

    public boolean setParameters(RtpParameters rtpParameters) {
        checkRtpSenderExists();
        return nativeSetParameters(this.nativeRtpSender, rtpParameters);
    }

    public boolean setTrack(@Nullable MediaStreamTrack mediaStreamTrack, boolean z16) {
        long nativeMediaStreamTrack;
        checkRtpSenderExists();
        long j3 = this.nativeRtpSender;
        if (mediaStreamTrack == null) {
            nativeMediaStreamTrack = 0;
        } else {
            nativeMediaStreamTrack = mediaStreamTrack.getNativeMediaStreamTrack();
        }
        if (!nativeSetTrack(j3, nativeMediaStreamTrack)) {
            return false;
        }
        MediaStreamTrack mediaStreamTrack2 = this.cachedTrack;
        if (mediaStreamTrack2 != null && this.ownsTrack) {
            mediaStreamTrack2.dispose();
        }
        this.cachedTrack = mediaStreamTrack;
        this.ownsTrack = z16;
        return true;
    }

    @Nullable
    public MediaStreamTrack track() {
        return this.cachedTrack;
    }
}

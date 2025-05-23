package org.tencwebrtc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.tencwebrtc.MediaStreamTrack;
import org.tencwebrtc.RtpParameters;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RtpTransceiver {
    private RtpReceiver cachedReceiver;
    private RtpSender cachedSender;
    private long nativeRtpTransceiver;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum RtpTransceiverDirection {
        SEND_RECV(0),
        SEND_ONLY(1),
        RECV_ONLY(2),
        INACTIVE(3);

        private final int nativeIndex;

        RtpTransceiverDirection(int i3) {
            this.nativeIndex = i3;
        }

        @CalledByNative("RtpTransceiverDirection")
        static RtpTransceiverDirection fromNativeIndex(int i3) {
            for (RtpTransceiverDirection rtpTransceiverDirection : values()) {
                if (rtpTransceiverDirection.getNativeIndex() == i3) {
                    return rtpTransceiverDirection;
                }
            }
            throw new IllegalArgumentException("Uknown native RtpTransceiverDirection type" + i3);
        }

        @CalledByNative("RtpTransceiverDirection")
        int getNativeIndex() {
            return this.nativeIndex;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class RtpTransceiverInit {
        private final RtpTransceiverDirection direction;
        private final List<RtpParameters.Encoding> sendEncodings;
        private final List<String> streamIds;

        public RtpTransceiverInit() {
            this(RtpTransceiverDirection.SEND_RECV);
        }

        @CalledByNative("RtpTransceiverInit")
        int getDirectionNativeIndex() {
            return this.direction.getNativeIndex();
        }

        @CalledByNative("RtpTransceiverInit")
        List<RtpParameters.Encoding> getSendEncodings() {
            return new ArrayList(this.sendEncodings);
        }

        @CalledByNative("RtpTransceiverInit")
        List<String> getStreamIds() {
            return new ArrayList(this.streamIds);
        }

        public RtpTransceiverInit(RtpTransceiverDirection rtpTransceiverDirection) {
            this(rtpTransceiverDirection, Collections.emptyList(), Collections.emptyList());
        }

        public RtpTransceiverInit(RtpTransceiverDirection rtpTransceiverDirection, List<String> list) {
            this(rtpTransceiverDirection, list, Collections.emptyList());
        }

        public RtpTransceiverInit(RtpTransceiverDirection rtpTransceiverDirection, List<String> list, List<RtpParameters.Encoding> list2) {
            this.direction = rtpTransceiverDirection;
            this.streamIds = new ArrayList(list);
            this.sendEncodings = new ArrayList(list2);
        }
    }

    @CalledByNative
    protected RtpTransceiver(long j3) {
        this.nativeRtpTransceiver = j3;
        this.cachedSender = nativeGetSender(j3);
        this.cachedReceiver = nativeGetReceiver(j3);
    }

    private void checkRtpTransceiverExists() {
        if (this.nativeRtpTransceiver != 0) {
        } else {
            throw new IllegalStateException("RtpTransceiver has been disposed.");
        }
    }

    private static native RtpTransceiverDirection nativeCurrentDirection(long j3);

    private static native RtpTransceiverDirection nativeDirection(long j3);

    private static native MediaStreamTrack.MediaType nativeGetMediaType(long j3);

    private static native String nativeGetMid(long j3);

    private static native RtpReceiver nativeGetReceiver(long j3);

    private static native RtpSender nativeGetSender(long j3);

    private static native void nativeSetDirection(long j3, RtpTransceiverDirection rtpTransceiverDirection);

    private static native void nativeStop(long j3);

    private static native boolean nativeStopped(long j3);

    @CalledByNative
    public void dispose() {
        checkRtpTransceiverExists();
        this.cachedSender.dispose();
        this.cachedReceiver.dispose();
        JniCommon.nativeReleaseRef(this.nativeRtpTransceiver);
        this.nativeRtpTransceiver = 0L;
    }

    public RtpTransceiverDirection getCurrentDirection() {
        checkRtpTransceiverExists();
        return nativeCurrentDirection(this.nativeRtpTransceiver);
    }

    public RtpTransceiverDirection getDirection() {
        checkRtpTransceiverExists();
        return nativeDirection(this.nativeRtpTransceiver);
    }

    public MediaStreamTrack.MediaType getMediaType() {
        checkRtpTransceiverExists();
        return nativeGetMediaType(this.nativeRtpTransceiver);
    }

    public String getMid() {
        checkRtpTransceiverExists();
        return nativeGetMid(this.nativeRtpTransceiver);
    }

    public RtpReceiver getReceiver() {
        return this.cachedReceiver;
    }

    public RtpSender getSender() {
        return this.cachedSender;
    }

    public boolean isStopped() {
        checkRtpTransceiverExists();
        return nativeStopped(this.nativeRtpTransceiver);
    }

    public void setDirection(RtpTransceiverDirection rtpTransceiverDirection) {
        checkRtpTransceiverExists();
        nativeSetDirection(this.nativeRtpTransceiver, rtpTransceiverDirection);
    }

    public void stop() {
        checkRtpTransceiverExists();
        nativeStop(this.nativeRtpTransceiver);
    }
}

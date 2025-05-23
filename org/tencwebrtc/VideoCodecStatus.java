package org.tencwebrtc;

/* compiled from: P */
/* loaded from: classes29.dex */
public enum VideoCodecStatus {
    REQUEST_SLI(2),
    NO_OUTPUT(1),
    OK(0),
    ERROR(-1),
    LEVEL_EXCEEDED(-2),
    MEMORY(-3),
    ERR_PARAMETER(-4),
    ERR_SIZE(-5),
    TIMEOUT(-6),
    UNINITIALIZED(-7),
    ERR_REQUEST_SLI(-12),
    FALLBACK_SOFTWARE(-13),
    TARGET_BITRATE_OVERSHOOT(-14),
    SURFACE_NULL_OR_VALID(-15),
    SURFACE_TEXTURE_HELPER_NULL_EXCEPTION(-16),
    INIT_DECODE_EXCEPTION(-17),
    CODEC_IS_RUNNING(-18),
    NO_INPUT_DATA_OR_EMPTY(-19),
    COLOR_FORMAT_UNSUPPORT(-20),
    CREATE_DECODER_FAILED(-21),
    DO_DECODE_ERROR(-22);

    private final int number;

    VideoCodecStatus(int i3) {
        this.number = i3;
    }

    @CalledByNative
    public int getNumber() {
        return this.number;
    }
}

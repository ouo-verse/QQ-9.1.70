package com.tencent.karaoke.audiobasesdk.audiofx;

/* loaded from: classes7.dex */
public interface PitchInterface {
    public static final int MAX_SHIFT = 12;
    public static final int MIN_SHIFT = -12;

    boolean init(int i3, int i16);

    int process(byte[] bArr, int i3);

    int processLast(byte[] bArr, int i3);

    void release();

    int seek();

    void setPitchShift(int i3);
}

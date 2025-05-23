package com.tencent.liteav.videobase.common;

/* compiled from: P */
/* loaded from: classes7.dex */
public enum CodecType {
    UNKNOWN(-1),
    H264(0),
    H265(1),
    VP8(2),
    KAV1(3);


    /* renamed from: f, reason: collision with root package name */
    private static final CodecType[] f119285f = values();
    public final int mValue;

    CodecType(int i3) {
        this.mValue = i3;
    }

    public static CodecType a(int i3) {
        for (CodecType codecType : f119285f) {
            if (i3 == codecType.mValue) {
                return codecType;
            }
        }
        return H264;
    }
}

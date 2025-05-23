package com.tencent.ttpic.video;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AECoderFactory {
    private static AEDecoderFactory mAEDecoderFactory;
    private static AEEncoderFactory mAEEncoderFactory;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface AEDecoderFactory {
        AEDecoder createDecoder(String str);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface AEEncoderFactory {
        AEEncoder createEncoder(String str, int i3, int i16);
    }

    public static AEDecoder createDecoder(String str) {
        AEDecoderFactory aEDecoderFactory = mAEDecoderFactory;
        if (aEDecoderFactory == null) {
            return null;
        }
        return aEDecoderFactory.createDecoder(str);
    }

    public static AEEncoder createEncoder(String str, int i3, int i16) {
        AEEncoderFactory aEEncoderFactory = mAEEncoderFactory;
        if (aEEncoderFactory == null) {
            return null;
        }
        return aEEncoderFactory.createEncoder(str, i3, i16);
    }

    public static void setAEDecoder(AEDecoderFactory aEDecoderFactory) {
        mAEDecoderFactory = aEDecoderFactory;
    }

    public static void setAEEncoder(AEEncoderFactory aEEncoderFactory) {
        mAEEncoderFactory = aEEncoderFactory;
    }
}

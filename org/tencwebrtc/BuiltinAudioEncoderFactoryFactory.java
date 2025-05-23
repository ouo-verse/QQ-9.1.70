package org.tencwebrtc;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuiltinAudioEncoderFactoryFactory implements AudioEncoderFactoryFactory {
    private static native long nativeCreateBuiltinAudioEncoderFactory();

    @Override // org.tencwebrtc.AudioEncoderFactoryFactory
    public long createNativeAudioEncoderFactory() {
        return nativeCreateBuiltinAudioEncoderFactory();
    }
}

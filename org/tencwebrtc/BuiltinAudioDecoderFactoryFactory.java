package org.tencwebrtc;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuiltinAudioDecoderFactoryFactory implements AudioDecoderFactoryFactory {
    private static native long nativeCreateBuiltinAudioDecoderFactory();

    @Override // org.tencwebrtc.AudioDecoderFactoryFactory
    public long createNativeAudioDecoderFactory() {
        return nativeCreateBuiltinAudioDecoderFactory();
    }
}

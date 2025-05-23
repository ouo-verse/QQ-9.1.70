package com.tencent.liteav.extensions.codec;

import android.media.MediaFormat;
import com.tencent.liteav.extensions.codec.AacMediaCodecWrapper;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HardwareAacEncoder {

    /* renamed from: a, reason: collision with root package name */
    private final AacMediaCodecWrapper f119059a = new AacMediaCodecWrapper(AacMediaCodecWrapper.a.f119055a);

    public ByteBuffer encode(ByteBuffer byteBuffer) {
        return this.f119059a.processFrame(byteBuffer);
    }

    public boolean init(int i3, int i16, int i17) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i3, i16);
        createAudioFormat.setInteger("bitrate", i17);
        createAudioFormat.setInteger("aac-profile", 2);
        return this.f119059a.a(createAudioFormat);
    }

    public void unInit() {
        this.f119059a.a();
    }
}

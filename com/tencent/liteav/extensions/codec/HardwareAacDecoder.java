package com.tencent.liteav.extensions.codec;

import android.media.MediaFormat;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.extensions.codec.AacMediaCodecWrapper;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HardwareAacDecoder {

    /* renamed from: a, reason: collision with root package name */
    private final AacMediaCodecWrapper f119058a = new AacMediaCodecWrapper(AacMediaCodecWrapper.a.f119056b);

    public ByteBuffer decode(ByteBuffer byteBuffer) {
        return this.f119058a.processFrame(byteBuffer);
    }

    public int getCacheSize() {
        return this.f119058a.f119050b;
    }

    public int getOutputChannelCount() {
        MediaFormat mediaFormat = this.f119058a.f119049a;
        if (mediaFormat == null) {
            return -1;
        }
        try {
            return mediaFormat.getInteger("channel-count");
        } catch (Exception e16) {
            Log.e("HardwareAacDecoder", "getOutputChannelCount failed. ".concat(String.valueOf(e16)), new Object[0]);
            return -1;
        }
    }

    public int getOutputSampleRate() {
        MediaFormat mediaFormat = this.f119058a.f119049a;
        if (mediaFormat == null) {
            return -1;
        }
        try {
            return mediaFormat.getInteger("sample-rate");
        } catch (Exception e16) {
            Log.e("HardwareAacDecoder", "getOutputSampleRate failed. ".concat(String.valueOf(e16)), new Object[0]);
            return -1;
        }
    }

    public boolean init(int i3, int i16, ByteBuffer byteBuffer) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i3, i16);
        createAudioFormat.setString("mime", "audio/mp4a-latm");
        createAudioFormat.setByteBuffer("csd-0", byteBuffer);
        return this.f119058a.a(createAudioFormat);
    }

    public void unInit() {
        this.f119058a.a();
    }
}

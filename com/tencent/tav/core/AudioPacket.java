package com.tencent.tav.core;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;

/* loaded from: classes26.dex */
public class AudioPacket {
    public ByteBuffer audioBuffer;
    public MediaCodec.BufferInfo audioBufferInfo;
    public MediaFormat audioEncodeFormat;
    public int encoderBufferIndex = -1;
    public boolean audioDone = false;
}

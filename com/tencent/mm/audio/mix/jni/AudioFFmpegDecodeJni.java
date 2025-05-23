package com.tencent.mm.audio.mix.jni;

import com.tencent.mm.audio.mix.decode.IDecodeCallback;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AudioFFmpegDecodeJni {

    /* renamed from: a, reason: collision with root package name */
    public long f151687a = 0;

    static {
        System.loadLibrary("xffmpeg");
        System.loadLibrary("AudioFFmpegDecode");
    }

    public static native int decode(int i3, int i16, int i17, String str, IDecodeCallback iDecodeCallback);

    public native int clearResample(String str);

    public native int initResample(String str, int i3, int i16, int i17, int i18);

    public native ByteBuffer resamplePcm(String str, int i3, int i16, byte[] bArr, int i17, ByteBuffer byteBuffer);
}

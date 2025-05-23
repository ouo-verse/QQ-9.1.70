package com.tencent.luggage.wxa.f9;

import com.tencent.mm.audio.mix.jni.AudioFFmpegDecodeJni;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h implements j {

    /* renamed from: a, reason: collision with root package name */
    public int f125572a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f125573b = 2;

    /* renamed from: c, reason: collision with root package name */
    public int f125574c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final int f125575d = 2;

    /* renamed from: e, reason: collision with root package name */
    public AudioFFmpegDecodeJni f125576e;

    /* renamed from: f, reason: collision with root package name */
    public String f125577f;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f125578g;

    @Override // com.tencent.luggage.wxa.f9.j
    public boolean a(String str, int i3, int i16, int i17, int i18) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.FFmpegResampleAlgorithm", "ffmpeg resample algorithm  sSample:%d, dSample:%d", Integer.valueOf(i3), Integer.valueOf(i17));
        this.f125572a = i3;
        this.f125574c = i17;
        this.f125577f = str;
        AudioFFmpegDecodeJni audioFFmpegDecodeJni = new AudioFFmpegDecodeJni();
        this.f125576e = audioFFmpegDecodeJni;
        audioFFmpegDecodeJni.initResample(str, i3, i17, 2, 2);
        return true;
    }

    @Override // com.tencent.luggage.wxa.f9.j
    public boolean release() {
        this.f125576e.clearResample(this.f125577f);
        return false;
    }

    @Override // com.tencent.luggage.wxa.f9.j
    public byte[] a(byte[] bArr) {
        int ceil = ((int) Math.ceil(((bArr.length / 2) / 2) * (this.f125574c / this.f125572a))) * 2 * 2;
        ByteBuffer byteBuffer = this.f125578g;
        if (byteBuffer == null || byteBuffer.capacity() < ceil) {
            this.f125578g = ByteBuffer.allocateDirect(ceil).order(ByteOrder.LITTLE_ENDIAN);
        }
        ByteBuffer resamplePcm = this.f125576e.resamplePcm(this.f125577f, this.f125572a, this.f125574c, bArr, bArr.length, this.f125578g);
        this.f125578g = resamplePcm;
        if (resamplePcm != null) {
            byte[] bArr2 = new byte[resamplePcm.remaining()];
            resamplePcm.get(bArr2);
            return bArr2;
        }
        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.FFmpegResampleAlgorithm", "Failed to resample");
        return bArr;
    }
}

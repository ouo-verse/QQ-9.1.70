package com.qq.wx.voice.embedqqegg.vad;

/* compiled from: P */
/* loaded from: classes3.dex */
public class EVad {

    /* renamed from: a, reason: collision with root package name */
    private long f40962a = 0;

    /* renamed from: b, reason: collision with root package name */
    private EVadNative f40963b = new EVadNative();

    public int AddData(byte[] bArr, int i3) {
        int i16 = i3 / 2;
        short[] sArr = new short[i16];
        for (int i17 = 0; i17 < i3; i17 += 2) {
            sArr[i17 / 2] = (short) (((bArr[i17 + 1] & 255) << 8) | (bArr[i17] & 255));
        }
        return AddData(sArr, i16);
    }

    public int Init(int i3, int i16, float f16, int i17, int i18) {
        if (this.f40962a != 0) {
            Release();
        }
        long Init = this.f40963b.Init(i3, i16, f16, i17, i18);
        this.f40962a = Init;
        if (Init == 0) {
            return 1;
        }
        return 0;
    }

    public int Release() {
        long j3 = this.f40962a;
        if (j3 == 0) {
            return 0;
        }
        int Release = this.f40963b.Release(j3);
        this.f40962a = 0L;
        return Release;
    }

    public int Reset() {
        long j3 = this.f40962a;
        if (j3 == 0) {
            return 1;
        }
        return this.f40963b.Reset(j3);
    }

    public int AddData(short[] sArr, int i3) {
        long j3 = this.f40962a;
        if (j3 == 0) {
            return 1;
        }
        return this.f40963b.AddData(j3, sArr, i3);
    }
}

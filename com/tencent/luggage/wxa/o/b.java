package com.tencent.luggage.wxa.o;

import android.media.MediaCodec;
import com.tencent.luggage.wxa.n0.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f135936a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f135937b;

    /* renamed from: c, reason: collision with root package name */
    public int f135938c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f135939d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f135940e;

    /* renamed from: f, reason: collision with root package name */
    public int f135941f;

    /* renamed from: g, reason: collision with root package name */
    public int f135942g;

    /* renamed from: h, reason: collision with root package name */
    public int f135943h;

    /* renamed from: i, reason: collision with root package name */
    public final MediaCodec.CryptoInfo f135944i;

    /* renamed from: j, reason: collision with root package name */
    public final C6521b f135945j;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.o.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6521b {

        /* renamed from: a, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f135946a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f135947b;

        public C6521b(MediaCodec.CryptoInfo cryptoInfo) {
            this.f135946a = cryptoInfo;
            this.f135947b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        public final void a(int i3, int i16) {
            this.f135947b.set(i3, i16);
            this.f135946a.setPattern(this.f135947b);
        }
    }

    public b() {
        MediaCodec.CryptoInfo cryptoInfo;
        int i3 = v.f135103a;
        byte b16 = 0;
        if (i3 >= 16) {
            cryptoInfo = b();
        } else {
            cryptoInfo = null;
        }
        this.f135944i = cryptoInfo;
        this.f135945j = i3 >= 24 ? new C6521b(cryptoInfo) : null;
    }

    public void a(int i3, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i16, int i17, int i18) {
        this.f135941f = i3;
        this.f135939d = iArr;
        this.f135940e = iArr2;
        this.f135937b = bArr;
        this.f135936a = bArr2;
        this.f135938c = i16;
        this.f135942g = i17;
        this.f135943h = i18;
        if (v.f135103a >= 16) {
            c();
        }
    }

    public final MediaCodec.CryptoInfo b() {
        return new MediaCodec.CryptoInfo();
    }

    public final void c() {
        MediaCodec.CryptoInfo cryptoInfo = this.f135944i;
        cryptoInfo.numSubSamples = this.f135941f;
        cryptoInfo.numBytesOfClearData = this.f135939d;
        cryptoInfo.numBytesOfEncryptedData = this.f135940e;
        cryptoInfo.key = this.f135937b;
        cryptoInfo.iv = this.f135936a;
        cryptoInfo.mode = this.f135938c;
        if (v.f135103a >= 24) {
            this.f135945j.a(this.f135942g, this.f135943h);
        }
    }

    public MediaCodec.CryptoInfo a() {
        return this.f135944i;
    }
}

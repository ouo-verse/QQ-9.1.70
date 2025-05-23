package com.qq.wx.voice.vad;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TRSilk {
    public static int MAX_FRAME_SIZE = 64;
    public static final int TRSILK_ERROR_ALREADY_INIT = -103;
    public static final int TRSILK_ERROR_BIT_RATE = -105;
    public static final int TRSILK_ERROR_ENGINE = -101;
    public static final int TRSILK_ERROR_ILLEGAL_PARAM = -104;
    public static final int TRSILK_ERROR_INPUT_TOO_LONG = -107;
    public static final int TRSILK_ERROR_OUT_OF_MEMORY = -100;
    public static final int TRSILK_ERROR_SAMPLE_RATE = -106;
    public static final int TRSILK_ERROR_UN_INIT = -102;
    public static int defaultBitRate = 24000;
    public static int defaultSampleRate = 16000;

    /* renamed from: a, reason: collision with root package name */
    private byte[] f41126a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f41127b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f41128c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f41129d;

    /* renamed from: e, reason: collision with root package name */
    private TRSilkNative f41130e;

    public TRSilk() {
        int i3 = MAX_FRAME_SIZE;
        this.f41126a = new byte[i3 * 100];
        this.f41127b = new byte[i3 * 100];
        this.f41128c = false;
        this.f41129d = false;
        this.f41130e = new TRSilkNative();
    }

    public byte[] silkDecode(byte[] bArr, int i3, int i16) {
        if (this.f41129d) {
            if (bArr != null && bArr.length != 0) {
                int nativeTRSilkDecode = this.f41130e.nativeTRSilkDecode(bArr, i3, i16, this.f41127b);
                if (nativeTRSilkDecode == 0) {
                    return null;
                }
                if (nativeTRSilkDecode >= 0) {
                    byte[] bArr2 = new byte[nativeTRSilkDecode];
                    System.arraycopy(this.f41127b, 0, bArr2, 0, nativeTRSilkDecode);
                    return bArr2;
                }
                throw new TRSilkException(nativeTRSilkDecode);
            }
            throw new TRSilkException(-104);
        }
        throw new TRSilkException(-102);
    }

    public int silkDecodeInit(int i3, int i16) {
        if (this.f41129d) {
            return -103;
        }
        int nativeTRSilkDecodeInit = this.f41130e.nativeTRSilkDecodeInit(i3, i16);
        if (nativeTRSilkDecodeInit == 0) {
            this.f41129d = true;
        }
        return nativeTRSilkDecodeInit;
    }

    public int silkDecodeRelease() {
        if (!this.f41129d) {
            return -102;
        }
        this.f41129d = false;
        return this.f41130e.nativeTRSilkDecodeRelease();
    }

    public byte[] silkEncode(byte[] bArr, int i3, int i16) {
        if (this.f41128c) {
            if (bArr != null && bArr.length != 0) {
                int nativeTRSilkEncode = this.f41130e.nativeTRSilkEncode(bArr, i3, i16, this.f41126a);
                if (nativeTRSilkEncode == 0) {
                    return null;
                }
                if (nativeTRSilkEncode >= 0) {
                    byte[] bArr2 = new byte[nativeTRSilkEncode];
                    System.arraycopy(this.f41126a, 0, bArr2, 0, nativeTRSilkEncode);
                    return bArr2;
                }
                throw new TRSilkException(nativeTRSilkEncode);
            }
            throw new TRSilkException(-104);
        }
        throw new TRSilkException(-102);
    }

    public int silkInit(int i3, int i16) {
        if (this.f41128c) {
            return -103;
        }
        int nativeTRSilkInit = this.f41130e.nativeTRSilkInit(i3, i16);
        if (nativeTRSilkInit == 0) {
            this.f41128c = true;
        }
        return nativeTRSilkInit;
    }

    public int silkRelease() {
        if (!this.f41128c) {
            return -102;
        }
        this.f41128c = false;
        return this.f41130e.nativeTRSilkRelease();
    }

    public int silkDecodeInit() {
        return silkDecodeInit(defaultBitRate, defaultSampleRate);
    }

    public int silkInit() {
        return silkInit(defaultBitRate, defaultSampleRate);
    }
}

package oicq.wlogin_sdk.devicelock;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class h extends d {

    /* renamed from: a, reason: collision with root package name */
    public int f422763a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f422764b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f422765c = 0;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f422766d = new byte[0];

    /* renamed from: e, reason: collision with root package name */
    public byte[] f422767e = new byte[0];

    /* renamed from: f, reason: collision with root package name */
    public byte[] f422768f = new byte[0];

    /* renamed from: g, reason: collision with root package name */
    public byte[] f422769g = new byte[0];

    public h() {
        this._type = 3;
    }

    @Override // oicq.wlogin_sdk.devicelock.d
    public void parse() {
        int i3 = this._head_len;
        this.f422763a = util.buf_to_int32(this._buf, i3);
        int i16 = i3 + 4;
        this.f422764b = util.buf_to_int8(this._buf, i16);
        int i17 = i16 + 1;
        int buf_to_int16 = util.buf_to_int16(this._buf, i17);
        int i18 = i17 + 2;
        byte[] bArr = new byte[buf_to_int16];
        this.f422766d = bArr;
        System.arraycopy(this._buf, i18, bArr, 0, buf_to_int16);
        int i19 = i18 + buf_to_int16;
        int buf_to_int162 = util.buf_to_int16(this._buf, i19);
        int i26 = i19 + 2;
        byte[] bArr2 = new byte[buf_to_int162];
        this.f422767e = bArr2;
        System.arraycopy(this._buf, i26, bArr2, 0, buf_to_int162);
        int i27 = i26 + buf_to_int162;
        int buf_to_int163 = util.buf_to_int16(this._buf, i27);
        int i28 = i27 + 2;
        byte[] bArr3 = new byte[buf_to_int163];
        this.f422768f = bArr3;
        System.arraycopy(this._buf, i28, bArr3, 0, buf_to_int163);
        int i29 = i28 + buf_to_int163;
        this.f422765c = util.buf_to_int16(this._buf, i29);
        int i36 = i29 + 2;
        int buf_to_int164 = util.buf_to_int16(this._buf, i36);
        byte[] bArr4 = new byte[buf_to_int164];
        this.f422769g = bArr4;
        System.arraycopy(this._buf, i36 + 2, bArr4, 0, buf_to_int164);
    }
}

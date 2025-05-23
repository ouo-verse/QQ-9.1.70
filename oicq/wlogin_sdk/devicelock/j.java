package oicq.wlogin_sdk.devicelock;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class j extends d {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f422774a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    public byte[] f422775b = new byte[0];

    /* renamed from: c, reason: collision with root package name */
    public int f422776c;

    /* renamed from: d, reason: collision with root package name */
    public int f422777d;

    /* renamed from: e, reason: collision with root package name */
    public int f422778e;

    public j() {
        this._type = 4;
    }

    @Override // oicq.wlogin_sdk.devicelock.d
    public void parse() {
        int i3 = this._head_len;
        int buf_to_int16 = util.buf_to_int16(this._buf, i3);
        int i16 = i3 + 2;
        byte[] bArr = new byte[buf_to_int16];
        this.f422774a = bArr;
        System.arraycopy(this._buf, i16, bArr, 0, buf_to_int16);
        int i17 = i16 + buf_to_int16;
        int buf_to_int162 = util.buf_to_int16(this._buf, i17);
        int i18 = i17 + 2;
        byte[] bArr2 = new byte[buf_to_int162];
        this.f422775b = bArr2;
        System.arraycopy(this._buf, i18, bArr2, 0, buf_to_int162);
        int i19 = i18 + buf_to_int162;
        this.f422776c = util.buf_to_int32(this._buf, i19);
        int i26 = i19 + 4;
        this.f422777d = util.buf_to_int16(this._buf, i26);
        this.f422778e = util.buf_to_int16(this._buf, i26 + 2);
    }
}

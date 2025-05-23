package oicq.wlogin_sdk.devicelock;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class i extends d {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f422770a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    public byte[] f422771b = new byte[0];

    /* renamed from: c, reason: collision with root package name */
    public int f422772c;

    /* renamed from: d, reason: collision with root package name */
    public int f422773d;

    public i() {
        this._type = 14;
    }

    @Override // oicq.wlogin_sdk.devicelock.d
    public void parse() {
        int i3 = this._head_len;
        this.f422772c = util.buf_to_int16(this._buf, i3);
        int i16 = i3 + 2;
        int buf_to_int16 = util.buf_to_int16(this._buf, i16);
        int i17 = i16 + 2;
        byte[] bArr = new byte[buf_to_int16];
        this.f422770a = bArr;
        System.arraycopy(this._buf, i17, bArr, 0, buf_to_int16);
        int i18 = i17 + buf_to_int16;
        this.f422773d = util.buf_to_int16(this._buf, i18);
        int i19 = i18 + 2;
        int buf_to_int162 = util.buf_to_int16(this._buf, i19);
        byte[] bArr2 = new byte[buf_to_int162];
        this.f422771b = bArr2;
        System.arraycopy(this._buf, i19 + 2, bArr2, 0, buf_to_int162);
    }
}

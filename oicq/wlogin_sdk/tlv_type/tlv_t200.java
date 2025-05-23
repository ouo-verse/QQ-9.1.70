package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t200 extends tlv_t {

    /* renamed from: pf, reason: collision with root package name */
    public byte[] f422973pf = new byte[0];
    public byte[] pfkey = new byte[0];

    public tlv_t200() {
        this._cmd = 512;
    }

    public byte[] getPf() {
        return this.f422973pf;
    }

    public byte[] getPfKey() {
        return this.pfkey;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 2) {
            return Boolean.FALSE;
        }
        int buf_to_int16 = util.buf_to_int16(this._buf, this._head_len + 0);
        int i3 = buf_to_int16 + 2;
        if (this._body_len < i3) {
            return Boolean.FALSE;
        }
        byte[] bArr = new byte[buf_to_int16];
        this.f422973pf = bArr;
        System.arraycopy(this._buf, this._head_len + 2, bArr, 0, buf_to_int16);
        int i16 = i3 + 2;
        if (this._body_len < i16) {
            return Boolean.FALSE;
        }
        int buf_to_int162 = util.buf_to_int16(this._buf, this._head_len + i3);
        if (this._body_len < i16 + buf_to_int162) {
            return Boolean.FALSE;
        }
        byte[] bArr2 = new byte[buf_to_int162];
        this.pfkey = bArr2;
        System.arraycopy(this._buf, this._head_len + i16, bArr2, 0, buf_to_int162);
        return Boolean.TRUE;
    }
}

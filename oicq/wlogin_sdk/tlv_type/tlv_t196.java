package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t196 extends tlv_t {
    public int _state = 0;
    public byte[] _cn = new byte[0];
    public byte[] _mobile = new byte[0];

    public tlv_t196() {
        this._cmd = 406;
    }

    public String getBakMobile() {
        return new String(this._mobile);
    }

    public int getBakMobileState() {
        return this._state;
    }

    public String getCountryCode() {
        return new String(this._cn);
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 5) {
            return Boolean.FALSE;
        }
        int i3 = this._head_len;
        this._state = util.buf_to_int8(this._buf, i3);
        int i16 = i3 + 1;
        int buf_to_int16 = util.buf_to_int16(this._buf, i16);
        int i17 = i16 + 2;
        if ((i17 - this._head_len) + buf_to_int16 > this._body_len) {
            return Boolean.FALSE;
        }
        byte[] bArr = new byte[buf_to_int16];
        this._cn = bArr;
        System.arraycopy(this._buf, i17, bArr, 0, buf_to_int16);
        int i18 = i17 + buf_to_int16;
        int buf_to_int162 = util.buf_to_int16(this._buf, i18);
        int i19 = i18 + 2;
        if ((i19 - this._head_len) + buf_to_int162 > this._body_len) {
            return Boolean.FALSE;
        }
        byte[] bArr2 = new byte[buf_to_int162];
        this._mobile = bArr2;
        System.arraycopy(this._buf, i19, bArr2, 0, buf_to_int162);
        return Boolean.TRUE;
    }
}

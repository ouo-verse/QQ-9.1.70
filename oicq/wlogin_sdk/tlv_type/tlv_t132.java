package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t132 extends tlv_t {
    public int _token_len = 0;
    public int _openid_len = 0;

    public tlv_t132() {
        this._cmd = 306;
    }

    public byte[] get_access_token() {
        int i3 = this._token_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len + 2, bArr, 0, i3);
        return bArr;
    }

    public byte[] get_openid() {
        int i3 = this._openid_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len + 2 + this._token_len + 4 + 2, bArr, 0, i3);
        return bArr;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 2) {
            return Boolean.FALSE;
        }
        int buf_to_int16 = util.buf_to_int16(this._buf, this._head_len);
        this._token_len = buf_to_int16;
        if (buf_to_int16 + 2 + 4 + 2 > this._body_len) {
            return Boolean.FALSE;
        }
        this._openid_len = util.buf_to_int16(this._buf, this._head_len + 2 + buf_to_int16 + 4);
        return Boolean.TRUE;
    }
}

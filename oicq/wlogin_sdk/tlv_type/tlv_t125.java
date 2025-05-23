package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t125 extends tlv_t {
    public int _openid_len = 0;
    public int _openkey_len = 0;

    public tlv_t125() {
        this._cmd = 293;
    }

    public byte[] get_openid() {
        int i3 = this._openid_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len + 2, bArr, 0, i3);
        return bArr;
    }

    public byte[] get_openkey() {
        int i3 = this._openkey_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len + 2 + this._openid_len + 2, bArr, 0, i3);
        return bArr;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 2) {
            return Boolean.FALSE;
        }
        int buf_to_int16 = util.buf_to_int16(this._buf, this._head_len);
        this._openid_len = buf_to_int16;
        if (this._body_len < buf_to_int16 + 2 + 2) {
            return Boolean.FALSE;
        }
        this._openkey_len = util.buf_to_int16(this._buf, this._head_len + 2 + buf_to_int16);
        return Boolean.TRUE;
    }
}

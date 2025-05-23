package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t199 extends tlv_t {
    public byte[] openid = new byte[0];
    public byte[] paytoken = new byte[0];

    public tlv_t199() {
        this._cmd = 409;
    }

    public byte[] getOpenId() {
        return this.openid;
    }

    public byte[] getPayToken() {
        return this.paytoken;
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
        this.openid = bArr;
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
        this.paytoken = bArr2;
        System.arraycopy(this._buf, this._head_len + i16, bArr2, 0, buf_to_int162);
        return Boolean.TRUE;
    }
}

package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t126 extends tlv_t {
    public int _random_len = 0;

    public tlv_t126() {
        this._cmd = 294;
    }

    public byte[] get_random() {
        int i3 = this._random_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len + 2 + 2, bArr, 0, i3);
        return bArr;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        int i3 = this._body_len;
        if (i3 < 2) {
            return Boolean.FALSE;
        }
        if (i3 < 4) {
            return Boolean.FALSE;
        }
        int buf_to_int16 = util.buf_to_int16(this._buf, this._head_len + 2);
        this._random_len = buf_to_int16;
        if (buf_to_int16 + 2 + 2 > this._body_len) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}

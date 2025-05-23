package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t105 extends tlv_t {
    public int _piclen = 0;
    public int _enlen = 0;
    public int _pic_pos = 0;
    public int _en_pos = 0;

    public tlv_t105() {
        this._cmd = 261;
    }

    public byte[] get_pic() {
        int i3 = this._piclen;
        byte[] bArr = new byte[i3];
        if (i3 <= 0) {
            return bArr;
        }
        System.arraycopy(this._buf, this._pic_pos, bArr, 0, i3);
        return bArr;
    }

    public byte[] get_sign() {
        int i3 = this._enlen;
        byte[] bArr = new byte[i3];
        if (i3 <= 0) {
            return bArr;
        }
        System.arraycopy(this._buf, this._en_pos, bArr, 0, i3);
        return bArr;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 2) {
            return Boolean.FALSE;
        }
        int buf_to_int16 = util.buf_to_int16(this._buf, this._head_len);
        this._enlen = buf_to_int16;
        if (this._body_len < buf_to_int16 + 2 + 2) {
            return Boolean.FALSE;
        }
        int buf_to_int162 = util.buf_to_int16(this._buf, this._head_len + 2 + buf_to_int16);
        this._piclen = buf_to_int162;
        int i3 = this._body_len;
        int i16 = this._enlen + 2 + 2;
        if (i3 < buf_to_int162 + i16) {
            return Boolean.FALSE;
        }
        int i17 = this._head_len;
        this._en_pos = i17 + 2;
        this._pic_pos = i16 + i17;
        return Boolean.TRUE;
    }
}

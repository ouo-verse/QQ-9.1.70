package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t167 extends tlv_t {
    public int _url_len = 0;

    public tlv_t167() {
        this._cmd = 359;
    }

    public byte[] get_img_format() {
        byte[] bArr = new byte[1];
        System.arraycopy(this._buf, this._head_len + 1, bArr, 0, 1);
        return bArr;
    }

    public byte[] get_img_type() {
        byte[] bArr = new byte[1];
        System.arraycopy(this._buf, this._head_len, bArr, 0, 1);
        return bArr;
    }

    public byte[] get_img_url() {
        int i3 = this._url_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len + 1 + 1 + 2, bArr, 0, i3);
        return bArr;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 4) {
            return Boolean.FALSE;
        }
        int buf_to_int16 = util.buf_to_int16(this._buf, this._head_len + 1 + 1);
        if (this._body_len < buf_to_int16 + 4) {
            return Boolean.FALSE;
        }
        this._url_len = buf_to_int16;
        return Boolean.TRUE;
    }
}

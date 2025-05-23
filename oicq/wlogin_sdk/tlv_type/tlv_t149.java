package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t149 extends tlv_t {
    public int _title_len = 0;
    public int _content_len = 0;
    public int _otherinfo_len = 0;

    public tlv_t149() {
        this._cmd = 329;
    }

    public byte[] get_content() {
        int i3 = this._content_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len + 2 + 2 + this._title_len + 2, bArr, 0, i3);
        return bArr;
    }

    public byte[] get_otherinfo() {
        int i3 = this._otherinfo_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len + 2 + 2 + this._title_len + 2 + this._content_len + 2, bArr, 0, i3);
        return bArr;
    }

    public byte[] get_title() {
        int i3 = this._title_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len + 2 + 2, bArr, 0, i3);
        return bArr;
    }

    public int get_type() {
        return util.buf_to_int16(this._buf, this._head_len);
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 8) {
            return Boolean.FALSE;
        }
        int buf_to_int16 = util.buf_to_int16(this._buf, this._head_len + 2);
        if (this._body_len < buf_to_int16 + 8) {
            return Boolean.FALSE;
        }
        this._title_len = buf_to_int16;
        int buf_to_int162 = util.buf_to_int16(this._buf, this._head_len + 2 + 2 + buf_to_int16);
        int i3 = this._body_len;
        int i16 = this._title_len;
        if (i3 < i16 + 8 + buf_to_int162) {
            return Boolean.FALSE;
        }
        this._content_len = buf_to_int162;
        int buf_to_int163 = util.buf_to_int16(this._buf, this._head_len + 2 + 2 + i16 + 2 + buf_to_int162);
        if (this._body_len < this._title_len + 8 + this._content_len + buf_to_int163) {
            return Boolean.FALSE;
        }
        this._otherinfo_len = buf_to_int163;
        return Boolean.TRUE;
    }
}

package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t146 extends tlv_t {
    public int _title_len = 0;
    public int _msg_len = 0;
    public int _errorinfo_len = 0;

    public tlv_t146() {
        this._cmd = 326;
    }

    public int get_code() {
        return util.buf_to_int16(this._buf, this._head_len + 2);
    }

    public byte[] get_errorinfo() {
        int i3 = this._errorinfo_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len + 12 + this._title_len + this._msg_len, bArr, 0, i3);
        return bArr;
    }

    public byte[] get_msg() {
        int i3 = this._msg_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len + 8 + this._title_len, bArr, 0, i3);
        return bArr;
    }

    public byte[] get_title() {
        int i3 = this._title_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len + 6, bArr, 0, i3);
        return bArr;
    }

    public int get_type() {
        return util.buf_to_int16(this._buf, this._head_len + 8 + this._title_len + this._msg_len);
    }

    public int get_ver() {
        return util.buf_to_int16(this._buf, this._head_len);
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 12) {
            return Boolean.FALSE;
        }
        int buf_to_int16 = util.buf_to_int16(this._buf, this._head_len + 4);
        if (this._body_len < buf_to_int16 + 12) {
            return Boolean.FALSE;
        }
        this._title_len = buf_to_int16;
        int buf_to_int162 = util.buf_to_int16(this._buf, this._head_len + 6 + buf_to_int16);
        int i3 = this._body_len;
        int i16 = this._title_len;
        if (i3 < i16 + 12 + buf_to_int162) {
            return Boolean.FALSE;
        }
        this._msg_len = buf_to_int162;
        int buf_to_int163 = util.buf_to_int16(this._buf, this._head_len + 10 + i16 + buf_to_int162);
        if (this._body_len < this._title_len + 12 + this._msg_len + buf_to_int163) {
            return Boolean.FALSE;
        }
        this._errorinfo_len = buf_to_int163;
        return Boolean.TRUE;
    }
}

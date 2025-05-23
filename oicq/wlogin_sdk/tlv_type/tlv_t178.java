package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t178 extends tlv_t {
    public int _country_code_len = 0;
    public int _mobile_len = 0;

    public tlv_t178() {
        this._cmd = 376;
    }

    public int get_available_msg_cnt() {
        return util.buf_to_int16(this._buf, this._head_len + 2 + this._country_code_len + 2 + this._mobile_len + 4);
    }

    public byte[] get_country_code() {
        int i3 = this._country_code_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len + 2, bArr, 0, i3);
        return bArr;
    }

    public byte[] get_mobile() {
        int i3 = this._mobile_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len + 2 + this._country_code_len + 2, bArr, 0, i3);
        return bArr;
    }

    public int get_smscode_status() {
        return util.buf_to_int32(this._buf, this._head_len + 2 + this._country_code_len + 2 + this._mobile_len);
    }

    public int get_time_limit() {
        return util.buf_to_int16(this._buf, this._head_len + 2 + this._country_code_len + 2 + this._mobile_len + 4 + 2);
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 12) {
            return Boolean.FALSE;
        }
        int buf_to_int16 = util.buf_to_int16(this._buf, this._head_len);
        if (this._body_len < buf_to_int16 + 12) {
            return Boolean.FALSE;
        }
        this._country_code_len = buf_to_int16;
        int buf_to_int162 = util.buf_to_int16(this._buf, this._head_len + 2 + buf_to_int16);
        if (this._body_len < this._country_code_len + 12 + buf_to_int162) {
            return Boolean.FALSE;
        }
        this._mobile_len = buf_to_int162;
        return Boolean.TRUE;
    }
}

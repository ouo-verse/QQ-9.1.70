package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t17b extends tlv_t {
    public tlv_t17b() {
        this._cmd = 379;
    }

    public int get_available_msg_cnt() {
        if (this._body_len < 4) {
            return 0;
        }
        return util.buf_to_int16(this._buf, this._head_len);
    }

    public int get_time_limit() {
        if (this._body_len < 4) {
            return 0;
        }
        return util.buf_to_int16(this._buf, this._head_len + 2);
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 4) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}

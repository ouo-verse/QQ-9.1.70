package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t11f extends tlv_t {
    public tlv_t11f() {
        this._cmd = 287;
    }

    public int get_chg_time() {
        return util.buf_to_int32(this._buf, this._head_len);
    }

    public int get_tk_pri() {
        return util.buf_to_int32(this._buf, this._head_len + 4);
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 8) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}

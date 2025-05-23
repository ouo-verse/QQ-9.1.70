package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t113 extends tlv_t {
    public tlv_t113() {
        this._cmd = 275;
    }

    public long get_uin() {
        return util.buf_to_int32(this._buf, this._head_len) & 4294967295L;
    }
}

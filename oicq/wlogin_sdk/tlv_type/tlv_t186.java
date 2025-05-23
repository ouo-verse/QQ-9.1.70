package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t186 extends tlv_t {
    private int _pwdflag;

    public tlv_t186() {
        this._cmd = 390;
    }

    public boolean getPwdflag() {
        if (this._pwdflag == 1) {
            return true;
        }
        return false;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 2) {
            return Boolean.FALSE;
        }
        this._pwdflag = util.buf_to_int8(this._buf, this._head_len + 1);
        return Boolean.TRUE;
    }
}

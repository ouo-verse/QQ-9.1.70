package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t150 extends tlv_t {
    public int _other_len = 0;

    public tlv_t150() {
        this._cmd = 336;
    }

    public int get_bitmap() {
        return util.buf_to_int32(this._buf, this._head_len);
    }

    public byte get_network() {
        return (byte) (util.buf_to_int8(this._buf, this._head_len + 4) & 255);
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 7) {
            return Boolean.FALSE;
        }
        int buf_to_int16 = util.buf_to_int16(this._buf, this._head_len + 5);
        if (this._body_len < buf_to_int16 + 7) {
            return Boolean.FALSE;
        }
        this._other_len = buf_to_int16;
        return Boolean.TRUE;
    }
}

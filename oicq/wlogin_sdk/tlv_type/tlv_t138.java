package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t138 extends tlv_t {
    public int _count = 0;

    public tlv_t138() {
        this._cmd = 312;
    }

    public int get_a2_chg_time() {
        for (int i3 = 0; i3 < this._count; i3++) {
            int i16 = i3 * 10;
            if (util.buf_to_int16(this._buf, this._head_len + 4 + i16) == 266) {
                return util.buf_to_int32(this._buf, this._head_len + 4 + i16 + 2);
            }
        }
        return 0;
    }

    public int get_a8_chg_time() {
        for (int i3 = 0; i3 < this._count; i3++) {
            int i16 = i3 * 10;
            if (util.buf_to_int16(this._buf, this._head_len + 4 + i16) == 258) {
                return util.buf_to_int32(this._buf, this._head_len + 4 + i16 + 2);
            }
        }
        return 0;
    }

    public int get_d2_chg_time() {
        for (int i3 = 0; i3 < this._count; i3++) {
            int i16 = i3 * 10;
            if (util.buf_to_int16(this._buf, this._head_len + 4 + i16) == 323) {
                return util.buf_to_int32(this._buf, this._head_len + 4 + i16 + 2);
            }
        }
        return 0;
    }

    public int get_lskey_chg_time() {
        for (int i3 = 0; i3 < this._count; i3++) {
            int i16 = i3 * 10;
            if (util.buf_to_int16(this._buf, this._head_len + 4 + i16) == 284) {
                return util.buf_to_int32(this._buf, this._head_len + 4 + i16 + 2);
            }
        }
        return 0;
    }

    public int get_sid_chg_time() {
        for (int i3 = 0; i3 < this._count; i3++) {
            int i16 = i3 * 10;
            if (util.buf_to_int16(this._buf, this._head_len + 4 + i16) == 356) {
                return util.buf_to_int32(this._buf, this._head_len + 4 + i16 + 2);
            }
        }
        return 0;
    }

    public int get_skey_chg_time() {
        for (int i3 = 0; i3 < this._count; i3++) {
            int i16 = i3 * 10;
            if (util.buf_to_int16(this._buf, this._head_len + 4 + i16) == 288) {
                return util.buf_to_int32(this._buf, this._head_len + 4 + i16 + 2);
            }
        }
        return 0;
    }

    public int get_stweb_chg_time() {
        for (int i3 = 0; i3 < this._count; i3++) {
            int i16 = i3 * 10;
            if (util.buf_to_int16(this._buf, this._head_len + 4 + i16) == 259) {
                return util.buf_to_int32(this._buf, this._head_len + 4 + i16 + 2);
            }
        }
        return 0;
    }

    public int get_vkey_chg_time() {
        for (int i3 = 0; i3 < this._count; i3++) {
            int i16 = i3 * 10;
            if (util.buf_to_int16(this._buf, this._head_len + 4 + i16) == 310) {
                return util.buf_to_int32(this._buf, this._head_len + 4 + i16 + 2);
            }
        }
        return 0;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 4) {
            return Boolean.FALSE;
        }
        int buf_to_int32 = util.buf_to_int32(this._buf, this._head_len);
        this._count = buf_to_int32;
        if (this._body_len < (buf_to_int32 * 10) + 4) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}

package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t17d extends tlv_t {
    public int _mb_guide_msg_len = 0;
    public int _mb_guide_info_len = 0;

    public tlv_t17d() {
        this._cmd = 381;
    }

    public byte[] get_mb_guide_info() {
        int i3 = this._mb_guide_info_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len + 2 + 2 + this._mb_guide_msg_len + 2 + 2, bArr, 0, i3);
        return bArr;
    }

    public int get_mb_guide_info_type() {
        return util.buf_to_int16(this._buf, this._head_len + 2 + 2 + this._mb_guide_msg_len);
    }

    public byte[] get_mb_guide_msg() {
        int i3 = this._mb_guide_msg_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len + 2 + 2, bArr, 0, i3);
        return bArr;
    }

    public int get_mb_guide_type() {
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
        this._mb_guide_msg_len = buf_to_int16;
        int buf_to_int162 = util.buf_to_int16(this._buf, this._head_len + 2 + 2 + buf_to_int16 + 2);
        if (this._body_len < this._mb_guide_msg_len + 8 + buf_to_int162) {
            return Boolean.FALSE;
        }
        this._mb_guide_info_len = buf_to_int162;
        return Boolean.TRUE;
    }
}

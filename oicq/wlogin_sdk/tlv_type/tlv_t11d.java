package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t11d extends tlv_t {
    public int _st_len = 0;

    public tlv_t11d() {
        this._cmd = 285;
    }

    public long get_appid() {
        return util.buf_to_int32(this._buf, this._head_len) & 4294967295L;
    }

    public byte[] get_st() {
        int i3 = this._st_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len + 4 + 16 + 2, bArr, 0, i3);
        return bArr;
    }

    public byte[] get_stkey() {
        byte[] bArr = new byte[16];
        System.arraycopy(this._buf, this._head_len + 4, bArr, 0, 16);
        return bArr;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 22) {
            return Boolean.FALSE;
        }
        int buf_to_int16 = util.buf_to_int16(this._buf, this._head_len + 4 + 16) & 65535;
        this._st_len = buf_to_int16;
        if (this._body_len < buf_to_int16 + 22) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}

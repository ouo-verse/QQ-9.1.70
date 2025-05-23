package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t52b extends tlv_t {
    private String _mobile;
    private int _zone;

    public tlv_t52b() {
        this._cmd = 1323;
    }

    public String get_mobile() {
        return this._mobile;
    }

    public int get_zone() {
        return this._zone;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 8) {
            return Boolean.FALSE;
        }
        int i3 = this._head_len + 4;
        this._zone = util.buf_to_int16(this._buf, i3);
        int i16 = ((this._body_len - 4) - 2) - 2;
        byte[] bArr = new byte[i16];
        System.arraycopy(this._buf, i3 + 2 + 2, bArr, 0, i16);
        this._mobile = new String(bArr);
        return Boolean.TRUE;
    }
}

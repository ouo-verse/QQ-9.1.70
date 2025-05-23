package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t107 extends tlv_t {
    public int _t107_body_len = 6;

    public tlv_t107() {
        this._cmd = 263;
    }

    public byte[] get_tlv_107(int i3, int i16, int i17, int i18) {
        byte[] bArr = new byte[this._t107_body_len];
        util.int16_to_buf(bArr, 0, i3);
        util.int8_to_buf(bArr, 2, i16);
        util.int16_to_buf(bArr, 3, i17);
        util.int8_to_buf(bArr, 5, i18);
        fill_head(this._cmd);
        fill_body(bArr, this._t107_body_len);
        set_length();
        return get_buf();
    }
}

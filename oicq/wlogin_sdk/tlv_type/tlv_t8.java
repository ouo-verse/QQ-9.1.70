package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t8 extends tlv_t {
    public int _t8_body_len = 0;

    public tlv_t8() {
        this._cmd = 8;
    }

    public byte[] get_tlv_8(int i3, int i16, int i17) {
        this._t8_body_len = 8;
        byte[] bArr = new byte[8];
        util.int16_to_buf(bArr, 0, i3);
        util.int32_to_buf(bArr, 2, i16);
        util.int16_to_buf(bArr, 6, i17);
        fill_head(this._cmd);
        fill_body(bArr, this._t8_body_len);
        set_length();
        return get_buf();
    }
}

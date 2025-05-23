package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t153 extends tlv_t {
    public tlv_t153() {
        this._cmd = 339;
    }

    public byte[] get_tlv_153(int i3) {
        byte[] bArr = new byte[2];
        util.int16_to_buf(bArr, 0, i3);
        fill_head(this._cmd);
        fill_body(bArr, 2);
        set_length();
        return get_buf();
    }
}

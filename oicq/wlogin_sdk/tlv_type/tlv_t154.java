package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t154 extends tlv_t {
    public tlv_t154() {
        this._cmd = 340;
    }

    public byte[] get_tlv_154(int i3) {
        byte[] bArr = new byte[4];
        util.int32_to_buf(bArr, 0, i3);
        fill_head(this._cmd);
        fill_body(bArr, 4);
        set_length();
        return get_buf();
    }
}

package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t52c extends tlv_t {
    public tlv_t52c() {
        this._cmd = 1324;
    }

    public byte[] get_tlv_52c(int i3, long j3) {
        byte[] bArr = new byte[9];
        util.int8_to_buf(bArr, 0, i3);
        util.int64_to_buf(bArr, 1, j3);
        fill_head(this._cmd);
        fill_body(bArr, 9);
        set_length();
        return get_buf();
    }
}

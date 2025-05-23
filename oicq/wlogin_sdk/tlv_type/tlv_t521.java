package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t521 extends tlv_t {
    public static final int CMD_521 = 1313;

    public tlv_t521() {
        this._cmd = 1313;
    }

    public byte[] get_tlv_521(int i3) {
        byte[] bArr = new byte[6];
        util.int32_to_buf(bArr, 0, i3);
        util.int16_to_buf(bArr, 4, 0);
        set_data(bArr, 6);
        return get_buf();
    }
}

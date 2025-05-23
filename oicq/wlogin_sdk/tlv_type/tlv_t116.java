package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t116 extends tlv_t {
    public static final int CMD_116 = 278;
    public int _t116_body_len = 0;
    public int _ver = 0;

    public tlv_t116() {
        this._cmd = 278;
    }

    public byte[] get_tlv_116(int i3, int i16, long[] jArr) {
        if (jArr == null) {
            jArr = new long[0];
        }
        int i17 = 10;
        int length = (jArr.length * 4) + 10;
        this._t116_body_len = length;
        byte[] bArr = new byte[length];
        util.int8_to_buf(bArr, 0, this._ver);
        util.int32_to_buf(bArr, 1, i3);
        util.int32_to_buf(bArr, 5, i16);
        util.int8_to_buf(bArr, 9, jArr.length);
        for (long j3 : jArr) {
            util.int32_to_buf(bArr, i17, (int) j3);
            i17 += 4;
        }
        fill_head(this._cmd);
        fill_body(bArr, this._t116_body_len);
        set_length();
        return get_buf();
    }
}

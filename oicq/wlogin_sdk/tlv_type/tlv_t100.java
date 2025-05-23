package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t100 extends tlv_t {
    public static final int CMD_100 = 256;
    public int _db_buf_ver = 1;
    public int _sso_ver = 22;
    public int _t100_body_len = 22;

    public tlv_t100() {
        this._cmd = 256;
    }

    public byte[] get_tlv_100(long j3, long j16, int i3, int i16) {
        byte[] bArr = new byte[this._t100_body_len];
        util.int16_to_buf(bArr, 0, this._db_buf_ver);
        util.int32_to_buf(bArr, 2, this._sso_ver);
        util.int32_to_buf(bArr, 6, (int) j3);
        util.int32_to_buf(bArr, 10, (int) j16);
        util.int32_to_buf(bArr, 14, i3);
        util.int32_to_buf(bArr, 18, i16);
        fill_head(this._cmd);
        fill_body(bArr, this._t100_body_len);
        set_length();
        return get_buf();
    }
}

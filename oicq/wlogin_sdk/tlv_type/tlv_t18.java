package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t18 extends tlv_t {
    public int _t18_body_len = 22;
    public int _ping_version = 1;
    public int _sso_version = 1536;

    public tlv_t18() {
        this._cmd = 24;
    }

    public byte[] get_tlv_18(long j3, int i3, long j16, int i16) {
        byte[] bArr = new byte[this._t18_body_len];
        util.int16_to_buf(bArr, 0, this._ping_version);
        util.int32_to_buf(bArr, 2, this._sso_version);
        util.int32_to_buf(bArr, 6, (int) j3);
        util.int32_to_buf(bArr, 10, i3);
        util.int32_to_buf(bArr, 14, (int) j16);
        util.int16_to_buf(bArr, 18, i16);
        util.int16_to_buf(bArr, 20, 0);
        fill_head(this._cmd);
        fill_body(bArr, this._t18_body_len);
        set_length();
        return get_buf();
    }
}

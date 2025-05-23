package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t142 extends tlv_t {
    public static final int CMD_142 = 322;
    public int _version = 0;
    public int _t142_body_len = 0;

    public tlv_t142() {
        this._cmd = 322;
    }

    public byte[] get_tlv_142(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        int limit_len = limit_len(bArr, 32);
        int i3 = limit_len + 4;
        this._t142_body_len = i3;
        byte[] bArr2 = new byte[i3];
        util.int16_to_buf(bArr2, 0, this._version);
        util.int16_to_buf(bArr2, 2, limit_len);
        System.arraycopy(bArr, 0, bArr2, 4, limit_len);
        fill_head(this._cmd);
        fill_body(bArr2, i3);
        set_length();
        return get_buf();
    }
}

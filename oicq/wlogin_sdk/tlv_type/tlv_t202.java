package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t202 extends tlv_t {
    public tlv_t202() {
        this._cmd = 514;
    }

    public byte[] get_tlv_202(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr = new byte[16];
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        int limit_len = limit_len(bArr, 16);
        int limit_len2 = limit_len(bArr2, 32);
        int i3 = limit_len + 2;
        int i16 = i3 + 2;
        int i17 = i16 + limit_len2;
        byte[] bArr3 = new byte[i17];
        util.int16_to_buf(bArr3, 0, limit_len);
        System.arraycopy(bArr, 0, bArr3, 2, limit_len);
        util.int16_to_buf(bArr3, i3, limit_len2);
        System.arraycopy(bArr2, 0, bArr3, i16, limit_len2);
        fill_head(this._cmd);
        fill_body(bArr3, i17);
        set_length();
        return get_buf();
    }
}

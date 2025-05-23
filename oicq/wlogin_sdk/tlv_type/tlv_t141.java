package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t141 extends tlv_t {
    public int _version = 1;

    public tlv_t141() {
        this._cmd = 321;
    }

    public byte[] get_tlv_141(byte[] bArr, int i3, byte[] bArr2) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        int length = bArr.length + 4 + 2 + 2 + bArr2.length;
        byte[] bArr3 = new byte[length];
        util.int16_to_buf(bArr3, 0, this._version);
        util.int16_to_buf(bArr3, 2, bArr.length);
        System.arraycopy(bArr, 0, bArr3, 4, bArr.length);
        int length2 = bArr.length + 4;
        util.int16_to_buf(bArr3, length2, i3);
        int i16 = length2 + 2;
        util.int16_to_buf(bArr3, i16, bArr2.length);
        System.arraycopy(bArr2, 0, bArr3, i16 + 2, bArr2.length);
        fill_head(this._cmd);
        fill_body(bArr3, length);
        set_length();
        return get_buf();
    }
}

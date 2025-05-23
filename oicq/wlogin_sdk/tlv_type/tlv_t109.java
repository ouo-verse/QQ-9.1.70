package oicq.wlogin_sdk.tlv_type;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t109 extends tlv_t {
    public int _t109_body_len = 0;

    public tlv_t109() {
        this._cmd = 265;
    }

    public byte[] get_tlv_109(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[16];
        }
        int length = bArr.length;
        this._t109_body_len = length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        fill_head(this._cmd);
        fill_body(bArr2, this._t109_body_len);
        set_length();
        return get_buf();
    }
}

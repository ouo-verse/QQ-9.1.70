package oicq.wlogin_sdk.tlv_type;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t545 extends tlv_t {
    public int _t545_body_len = 0;

    public tlv_t545() {
        this._cmd = 1349;
    }

    public byte[] get_tlv_545(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[16];
        }
        int length = bArr.length;
        this._t545_body_len = length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        fill_head(this._cmd);
        fill_body(bArr2, this._t545_body_len);
        set_length();
        return get_buf();
    }
}

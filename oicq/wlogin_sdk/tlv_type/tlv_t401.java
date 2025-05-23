package oicq.wlogin_sdk.tlv_type;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t401 extends tlv_t {
    public tlv_t401() {
        this._cmd = 1025;
    }

    public byte[] get_tlv_401(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[16];
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        fill_head(this._cmd);
        fill_body(bArr2, length);
        set_length();
        return get_buf();
    }
}

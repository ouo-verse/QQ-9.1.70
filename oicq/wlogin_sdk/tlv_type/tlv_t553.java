package oicq.wlogin_sdk.tlv_type;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t553 extends tlv_t {
    public static final int CMD_553 = 1363;

    public tlv_t553() {
        this._cmd = CMD_553;
    }

    public byte[] get_tlv_t553(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        fill_head(this._cmd);
        fill_body(bArr2, length);
        set_length();
        return get_buf();
    }
}

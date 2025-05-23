package oicq.wlogin_sdk.tlv_type;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class tlv_t542 extends tlv_t {
    public static final int CMD_542 = 1346;

    public tlv_t542() {
        this._cmd = 1346;
    }

    public byte[] get_tlv_542(byte[] bArr) {
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

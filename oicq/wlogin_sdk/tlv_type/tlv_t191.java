package oicq.wlogin_sdk.tlv_type;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t191 extends tlv_t {
    public tlv_t191() {
        this._cmd = 401;
    }

    public byte[] get_tlv_191(int i3) {
        fill_head(this._cmd);
        fill_body(new byte[]{(byte) i3}, 1);
        set_length();
        return get_buf();
    }
}

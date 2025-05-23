package oicq.wlogin_sdk.devicelock;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TLV_SppKey extends d {
    public byte[] SppKey = new byte[0];

    public TLV_SppKey() {
        this._type = 11;
    }

    @Override // oicq.wlogin_sdk.devicelock.d
    public void parse() {
        this.SppKey = get_data();
    }
}

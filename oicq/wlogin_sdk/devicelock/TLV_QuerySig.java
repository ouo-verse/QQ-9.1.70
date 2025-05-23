package oicq.wlogin_sdk.devicelock;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TLV_QuerySig extends d {
    public byte[] QuerySig = new byte[0];

    public TLV_QuerySig() {
        this._type = 8;
    }

    @Override // oicq.wlogin_sdk.devicelock.d
    public void parse() {
        this.QuerySig = get_data();
    }
}

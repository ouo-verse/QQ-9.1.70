package oicq.wlogin_sdk.devicelock;

/* compiled from: P */
/* loaded from: classes28.dex */
public class DevlockRst {
    public static final int E_RST_UNKOWN = -1;
    public static final int E_SEND_QUERYSIG = 1201;
    public static final int E_VERIFY_QUERYSIG = 1301;
    public static final int S_OK = 0;
    public TLV_CommRsp commRsp = new TLV_CommRsp();
    public j mbMobileInfo = new j();
    public h devSetupInfo = new h();
    public i mbGuideInfo = new i();
    public TLV_QuerySig querySig = new TLV_QuerySig();
    public TLV_SppKey sppKey = new TLV_SppKey();
    public l smsInfo = new l();
    public g devGuideInfo = new g();
    public d transferInfo = new d();

    public void setSppKey(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        TLV_SppKey tLV_SppKey = new TLV_SppKey();
        this.sppKey = tLV_SppKey;
        tLV_SppKey.set_data(bArr, bArr.length);
    }
}

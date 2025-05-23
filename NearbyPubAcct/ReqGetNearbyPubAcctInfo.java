package NearbyPubAcct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ReqGetNearbyPubAcctInfo extends JceStruct {
    static LBSInfo cache_stLBSInfo;
    static byte[] cache_vContext;
    public int iCount;
    public short shVersion;
    public LBSInfo stLBSInfo;
    public byte[] vContext;

    public ReqGetNearbyPubAcctInfo() {
        this.shVersion = (short) 0;
        this.vContext = null;
        this.iCount = 0;
        this.stLBSInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shVersion = jceInputStream.read(this.shVersion, 0, true);
        if (cache_vContext == null) {
            cache_vContext = r0;
            byte[] bArr = {0};
        }
        this.vContext = jceInputStream.read(cache_vContext, 1, true);
        this.iCount = jceInputStream.read(this.iCount, 2, true);
        if (cache_stLBSInfo == null) {
            cache_stLBSInfo = new LBSInfo();
        }
        this.stLBSInfo = (LBSInfo) jceInputStream.read((JceStruct) cache_stLBSInfo, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shVersion, 0);
        jceOutputStream.write(this.vContext, 1);
        jceOutputStream.write(this.iCount, 2);
        jceOutputStream.write((JceStruct) this.stLBSInfo, 3);
    }

    public ReqGetNearbyPubAcctInfo(short s16, byte[] bArr, int i3, LBSInfo lBSInfo) {
        this.shVersion = s16;
        this.vContext = bArr;
        this.iCount = i3;
        this.stLBSInfo = lBSInfo;
    }
}

package NearbyPubAcct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class RspGetNearbyPubAcctInfo extends JceStruct {
    static int cache_eReplyCode;
    static byte[] cache_vContext;
    static ArrayList<PubAcctInfo> cache_vGroupInfo;
    public int eReplyCode;
    public int iCompletedFlag;
    public int iFlagStamp;
    public int iRadius;
    public int iRedFlag;
    public byte[] vContext;
    public ArrayList<PubAcctInfo> vGroupInfo;

    public RspGetNearbyPubAcctInfo() {
        this.eReplyCode = 0;
        this.vContext = null;
        this.iCompletedFlag = 0;
        this.iRadius = 0;
        this.vGroupInfo = null;
        this.iRedFlag = 0;
        this.iFlagStamp = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.eReplyCode = jceInputStream.read(this.eReplyCode, 0, true);
        if (cache_vContext == null) {
            cache_vContext = r0;
            byte[] bArr = {0};
        }
        this.vContext = jceInputStream.read(cache_vContext, 1, true);
        this.iCompletedFlag = jceInputStream.read(this.iCompletedFlag, 2, true);
        this.iRadius = jceInputStream.read(this.iRadius, 3, false);
        if (cache_vGroupInfo == null) {
            cache_vGroupInfo = new ArrayList<>();
            cache_vGroupInfo.add(new PubAcctInfo());
        }
        this.vGroupInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vGroupInfo, 4, false);
        this.iRedFlag = jceInputStream.read(this.iRedFlag, 5, false);
        this.iFlagStamp = jceInputStream.read(this.iFlagStamp, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.eReplyCode, 0);
        jceOutputStream.write(this.vContext, 1);
        jceOutputStream.write(this.iCompletedFlag, 2);
        jceOutputStream.write(this.iRadius, 3);
        ArrayList<PubAcctInfo> arrayList = this.vGroupInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        jceOutputStream.write(this.iRedFlag, 5);
        jceOutputStream.write(this.iFlagStamp, 6);
    }

    public RspGetNearbyPubAcctInfo(int i3, byte[] bArr, int i16, int i17, ArrayList<PubAcctInfo> arrayList, int i18, int i19) {
        this.eReplyCode = i3;
        this.vContext = bArr;
        this.iCompletedFlag = i16;
        this.iRadius = i17;
        this.vGroupInfo = arrayList;
        this.iRedFlag = i18;
        this.iFlagStamp = i19;
    }
}

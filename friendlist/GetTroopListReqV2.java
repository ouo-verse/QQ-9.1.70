package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetTroopListReqV2 extends JceStruct {
    static byte[] cache_vecCookies;
    static ArrayList<stTroopNum> cache_vecGroupInfo = new ArrayList<>();
    public byte bGetLongGroupName;
    public byte bGetMSFMsgFlag;
    public byte bGroupFlagExt;
    public long dwCompanyId;
    public int shVersion;
    public long uin;
    public byte[] vecCookies;
    public ArrayList<stTroopNum> vecGroupInfo;
    public long versionNum;

    static {
        cache_vecCookies = r0;
        byte[] bArr = {0};
        cache_vecGroupInfo.add(new stTroopNum());
    }

    public GetTroopListReqV2() {
        this.uin = 0L;
        this.bGetMSFMsgFlag = (byte) 0;
        this.vecCookies = null;
        this.vecGroupInfo = null;
        this.bGroupFlagExt = (byte) 0;
        this.shVersion = 0;
        this.dwCompanyId = 0L;
        this.versionNum = 0L;
        this.bGetLongGroupName = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.bGetMSFMsgFlag = jceInputStream.read(this.bGetMSFMsgFlag, 1, false);
        this.vecCookies = jceInputStream.read(cache_vecCookies, 2, false);
        this.vecGroupInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecGroupInfo, 3, false);
        this.bGroupFlagExt = jceInputStream.read(this.bGroupFlagExt, 4, false);
        this.shVersion = jceInputStream.read(this.shVersion, 5, false);
        this.dwCompanyId = jceInputStream.read(this.dwCompanyId, 6, false);
        this.versionNum = jceInputStream.read(this.versionNum, 7, false);
        this.bGetLongGroupName = jceInputStream.read(this.bGetLongGroupName, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.bGetMSFMsgFlag, 1);
        byte[] bArr = this.vecCookies;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
        ArrayList<stTroopNum> arrayList = this.vecGroupInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        jceOutputStream.write(this.bGroupFlagExt, 4);
        jceOutputStream.write(this.shVersion, 5);
        jceOutputStream.write(this.dwCompanyId, 6);
        jceOutputStream.write(this.versionNum, 7);
        jceOutputStream.write(this.bGetLongGroupName, 8);
    }

    public GetTroopListReqV2(long j3, byte b16, byte[] bArr, ArrayList<stTroopNum> arrayList, byte b17, int i3, long j16, long j17, byte b18) {
        this.uin = j3;
        this.bGetMSFMsgFlag = b16;
        this.vecCookies = bArr;
        this.vecGroupInfo = arrayList;
        this.bGroupFlagExt = b17;
        this.shVersion = i3;
        this.dwCompanyId = j16;
        this.versionNum = j17;
        this.bGetLongGroupName = b18;
    }
}

package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetNearbyGroup extends JceStruct {
    static LBSInfo cache_stLBSInfo = new LBSInfo();
    static byte[] cache_vClientVersion;
    static byte[] cache_vContext;
    public boolean bShowActivity;
    public boolean bShowOpen;
    public boolean bShowXiaoQu;
    public int iCount;
    public int iFilterId;
    public int iKeyType;
    public short shSortType;
    public short shVersion;
    public LBSInfo stLBSInfo;
    public String strCity;
    public String strCityCode;
    public String strGroupArea;
    public String strKey;
    public long uiClientType;
    public long uiLabelStyle;
    public byte[] vClientVersion;
    public byte[] vContext;

    static {
        cache_vContext = r1;
        byte[] bArr = {0};
        cache_vClientVersion = r0;
        byte[] bArr2 = {0};
    }

    public ReqGetNearbyGroup() {
        this.shVersion = (short) 0;
        this.vContext = null;
        this.iCount = 0;
        this.stLBSInfo = null;
        this.iKeyType = 0;
        this.strKey = "";
        this.bShowOpen = false;
        this.bShowXiaoQu = false;
        this.bShowActivity = false;
        this.shSortType = (short) 0;
        this.strGroupArea = "";
        this.strCity = "";
        this.strCityCode = "";
        this.iFilterId = 0;
        this.uiLabelStyle = 0L;
        this.vClientVersion = null;
        this.uiClientType = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shVersion = jceInputStream.read(this.shVersion, 0, true);
        this.vContext = jceInputStream.read(cache_vContext, 1, false);
        this.iCount = jceInputStream.read(this.iCount, 2, true);
        this.stLBSInfo = (LBSInfo) jceInputStream.read((JceStruct) cache_stLBSInfo, 3, true);
        this.iKeyType = jceInputStream.read(this.iKeyType, 4, false);
        this.strKey = jceInputStream.readString(5, false);
        this.bShowOpen = jceInputStream.read(this.bShowOpen, 6, false);
        this.bShowXiaoQu = jceInputStream.read(this.bShowXiaoQu, 7, false);
        this.bShowActivity = jceInputStream.read(this.bShowActivity, 8, false);
        this.shSortType = jceInputStream.read(this.shSortType, 9, false);
        this.strGroupArea = jceInputStream.readString(10, false);
        this.strCity = jceInputStream.readString(11, false);
        this.strCityCode = jceInputStream.readString(12, false);
        this.iFilterId = jceInputStream.read(this.iFilterId, 13, false);
        this.uiLabelStyle = jceInputStream.read(this.uiLabelStyle, 14, false);
        this.vClientVersion = jceInputStream.read(cache_vClientVersion, 15, false);
        this.uiClientType = jceInputStream.read(this.uiClientType, 16, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shVersion, 0);
        byte[] bArr = this.vContext;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
        jceOutputStream.write(this.iCount, 2);
        jceOutputStream.write((JceStruct) this.stLBSInfo, 3);
        jceOutputStream.write(this.iKeyType, 4);
        String str = this.strKey;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        jceOutputStream.write(this.bShowOpen, 6);
        jceOutputStream.write(this.bShowXiaoQu, 7);
        jceOutputStream.write(this.bShowActivity, 8);
        jceOutputStream.write(this.shSortType, 9);
        String str2 = this.strGroupArea;
        if (str2 != null) {
            jceOutputStream.write(str2, 10);
        }
        String str3 = this.strCity;
        if (str3 != null) {
            jceOutputStream.write(str3, 11);
        }
        String str4 = this.strCityCode;
        if (str4 != null) {
            jceOutputStream.write(str4, 12);
        }
        jceOutputStream.write(this.iFilterId, 13);
        jceOutputStream.write(this.uiLabelStyle, 14);
        byte[] bArr2 = this.vClientVersion;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 15);
        }
        jceOutputStream.write(this.uiClientType, 16);
    }

    public ReqGetNearbyGroup(short s16, byte[] bArr, int i3, LBSInfo lBSInfo, int i16, String str, boolean z16, boolean z17, boolean z18, short s17, String str2, String str3, String str4, int i17, long j3, byte[] bArr2, long j16) {
        this.shVersion = s16;
        this.vContext = bArr;
        this.iCount = i3;
        this.stLBSInfo = lBSInfo;
        this.iKeyType = i16;
        this.strKey = str;
        this.bShowOpen = z16;
        this.bShowXiaoQu = z17;
        this.bShowActivity = z18;
        this.shSortType = s17;
        this.strGroupArea = str2;
        this.strCity = str3;
        this.strCityCode = str4;
        this.iFilterId = i17;
        this.uiLabelStyle = j3;
        this.vClientVersion = bArr2;
        this.uiClientType = j16;
    }
}

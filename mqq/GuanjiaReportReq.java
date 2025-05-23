package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GuanjiaReportReq extends JceStruct {
    public boolean bKingCard;
    public boolean bReportFlag;
    public int iCardStatus;
    public int iCardType;
    public int iImplat;
    public String sIdfa;
    public String sIdfv;
    public String sMac;
    public String sMachine;
    public String sOsVersion;
    public String sPhoneNum;
    public String sPkgName;
    public long uin;

    public GuanjiaReportReq() {
        this.sIdfa = "";
        this.sIdfv = "";
        this.sMac = "";
        this.sMachine = "";
        this.sOsVersion = "";
        this.sPkgName = "";
        this.uin = 0L;
        this.iImplat = 0;
        this.sPhoneNum = "";
        this.bKingCard = true;
        this.iCardType = 0;
        this.iCardStatus = 0;
        this.bReportFlag = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sIdfa = jceInputStream.readString(0, false);
        this.sIdfv = jceInputStream.readString(1, false);
        this.sMac = jceInputStream.readString(2, false);
        this.sMachine = jceInputStream.readString(3, false);
        this.sOsVersion = jceInputStream.readString(4, false);
        this.sPkgName = jceInputStream.readString(5, false);
        this.uin = jceInputStream.read(this.uin, 6, false);
        this.iImplat = jceInputStream.read(this.iImplat, 7, false);
        this.sPhoneNum = jceInputStream.readString(8, false);
        this.bKingCard = jceInputStream.read(this.bKingCard, 9, false);
        this.iCardType = jceInputStream.read(this.iCardType, 10, false);
        this.iCardStatus = jceInputStream.read(this.iCardStatus, 11, false);
        this.bReportFlag = jceInputStream.read(this.bReportFlag, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sIdfa;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.sIdfv;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.sMac;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.sMachine;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.sOsVersion;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        String str6 = this.sPkgName;
        if (str6 != null) {
            jceOutputStream.write(str6, 5);
        }
        jceOutputStream.write(this.uin, 6);
        jceOutputStream.write(this.iImplat, 7);
        String str7 = this.sPhoneNum;
        if (str7 != null) {
            jceOutputStream.write(str7, 8);
        }
        jceOutputStream.write(this.bKingCard, 9);
        jceOutputStream.write(this.iCardType, 10);
        jceOutputStream.write(this.iCardStatus, 11);
        jceOutputStream.write(this.bReportFlag, 12);
    }

    public GuanjiaReportReq(String str, String str2, String str3, String str4, String str5, String str6, long j3, int i3, String str7, boolean z16, int i16, int i17, boolean z17) {
        this.sIdfa = str;
        this.sIdfv = str2;
        this.sMac = str3;
        this.sMachine = str4;
        this.sOsVersion = str5;
        this.sPkgName = str6;
        this.uin = j3;
        this.iImplat = i3;
        this.sPhoneNum = str7;
        this.bKingCard = z16;
        this.iCardType = i16;
        this.iCardStatus = i17;
        this.bReportFlag = z17;
    }
}

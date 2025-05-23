package protocol.KQQConfig;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetResourceRespInfo extends JceStruct {
    public int iResult;
    public short sLanType;
    public short sPriority;
    public short sResType;
    public String strPkgName;
    public String strResConf;
    public String strResDesc;
    public String strResName;
    public String strResURL_big;
    public String strResURL_small;
    public long uiNewVer;
    public long uiResID;

    public GetResourceRespInfo() {
        this.iResult = 0;
        this.uiResID = 0L;
        this.strPkgName = "";
        this.uiNewVer = 0L;
        this.sResType = (short) 0;
        this.sLanType = (short) 0;
        this.sPriority = (short) 0;
        this.strResName = "";
        this.strResDesc = "";
        this.strResURL_big = "";
        this.strResURL_small = "";
        this.strResConf = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.iResult, "iResult");
        jceDisplayer.display(this.uiResID, "uiResID");
        jceDisplayer.display(this.sResType, "sResType");
        jceDisplayer.display(this.strPkgName, "strPkgName");
        jceDisplayer.display(this.strResName, "strResName");
        jceDisplayer.display(this.uiNewVer, "uiNewVer");
        jceDisplayer.display(this.strResConf, "strResConf");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iResult = jceInputStream.read(this.iResult, 1, true);
        this.uiResID = jceInputStream.read(this.uiResID, 2, true);
        this.strPkgName = jceInputStream.readString(3, true);
        this.uiNewVer = jceInputStream.read(this.uiNewVer, 4, true);
        this.sResType = jceInputStream.read(this.sResType, 5, true);
        this.sLanType = jceInputStream.read(this.sLanType, 6, true);
        this.sPriority = jceInputStream.read(this.sPriority, 7, true);
        this.strResName = jceInputStream.readString(8, true);
        this.strResDesc = jceInputStream.readString(9, true);
        this.strResURL_big = jceInputStream.readString(10, true);
        this.strResURL_small = jceInputStream.readString(11, true);
        this.strResConf = jceInputStream.readString(12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iResult, 1);
        jceOutputStream.write(this.uiResID, 2);
        jceOutputStream.write(this.strPkgName, 3);
        jceOutputStream.write(this.uiNewVer, 4);
        jceOutputStream.write(this.sResType, 5);
        jceOutputStream.write(this.sLanType, 6);
        jceOutputStream.write(this.sPriority, 7);
        jceOutputStream.write(this.strResName, 8);
        jceOutputStream.write(this.strResDesc, 9);
        jceOutputStream.write(this.strResURL_big, 10);
        jceOutputStream.write(this.strResURL_small, 11);
        String str = this.strResConf;
        if (str != null) {
            jceOutputStream.write(str, 12);
        }
    }

    public GetResourceRespInfo(int i3, long j3, String str, long j16, short s16, short s17, short s18, String str2, String str3, String str4, String str5, String str6) {
        this.iResult = i3;
        this.uiResID = j3;
        this.strPkgName = str;
        this.uiNewVer = j16;
        this.sResType = s16;
        this.sLanType = s17;
        this.sPriority = s18;
        this.strResName = str2;
        this.strResDesc = str3;
        this.strResURL_big = str4;
        this.strResURL_small = str5;
        this.strResConf = str6;
    }
}

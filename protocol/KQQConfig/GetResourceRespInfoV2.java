package protocol.KQQConfig;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetResourceRespInfoV2 extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public byte cCanChangeState;
    public byte cDefaultState;
    public byte cPush;
    public byte cStatus;
    public int iPluginType;
    public short sLanType;
    public short sPriority;
    public short sResSubType;
    public String strNewPluginDesc;
    public String strNewPluginURL;
    public String strPkgName;
    public String strResConf;
    public String strResDesc;
    public String strResName;
    public String strResURL_big;
    public String strResURL_small;
    public long uiNewVer;
    public long uiResId;

    public GetResourceRespInfoV2() {
        this.strPkgName = "";
        this.uiNewVer = 0L;
        this.sResSubType = (short) 0;
        this.sLanType = (short) 0;
        this.sPriority = (short) 0;
        this.strResName = "";
        this.strResDesc = "";
        this.strResURL_big = "";
        this.strResURL_small = "";
        this.strResConf = "";
        this.cDefaultState = (byte) 0;
        this.cCanChangeState = (byte) 1;
        this.uiResId = 0L;
        this.cStatus = (byte) 0;
        this.cPush = (byte) 0;
        this.iPluginType = 64;
        this.strNewPluginDesc = "";
        this.strNewPluginURL = "";
    }

    public String className() {
        return "KQQConfig.GetResourceRespInfoV2";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.strPkgName, "strPkgName");
        jceDisplayer.display(this.uiNewVer, "uiNewVer");
        jceDisplayer.display(this.sResSubType, "sResSubType");
        jceDisplayer.display(this.sLanType, "sLanType");
        jceDisplayer.display(this.sPriority, "sPriority");
        jceDisplayer.display(this.strResName, "strResName");
        jceDisplayer.display(this.strResDesc, "strResDesc");
        jceDisplayer.display(this.strResURL_big, "strResURL_big");
        jceDisplayer.display(this.strResURL_small, "strResURL_small");
        jceDisplayer.display(this.strResConf, "strResConf");
        jceDisplayer.display(this.cDefaultState, "cDefaultState");
        jceDisplayer.display(this.cCanChangeState, "cCanChangeState");
        jceDisplayer.display(this.uiResId, "uiResId");
        jceDisplayer.display(this.cStatus, "cStatus");
        jceDisplayer.display(this.cPush, "cPush");
        jceDisplayer.display(this.iPluginType, "iPluginType");
        jceDisplayer.display(this.strNewPluginDesc, "strNewPluginDesc");
        jceDisplayer.display(this.strNewPluginURL, "strNewPluginURL");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.strPkgName, true);
        jceDisplayer.displaySimple(this.uiNewVer, true);
        jceDisplayer.displaySimple(this.sResSubType, true);
        jceDisplayer.displaySimple(this.sLanType, true);
        jceDisplayer.displaySimple(this.sPriority, true);
        jceDisplayer.displaySimple(this.strResName, true);
        jceDisplayer.displaySimple(this.strResDesc, true);
        jceDisplayer.displaySimple(this.strResURL_big, true);
        jceDisplayer.displaySimple(this.strResURL_small, true);
        jceDisplayer.displaySimple(this.strResConf, true);
        jceDisplayer.displaySimple(this.cDefaultState, true);
        jceDisplayer.displaySimple(this.cCanChangeState, true);
        jceDisplayer.displaySimple(this.uiResId, true);
        jceDisplayer.displaySimple(this.cStatus, true);
        jceDisplayer.displaySimple(this.cPush, true);
        jceDisplayer.displaySimple(this.iPluginType, true);
        jceDisplayer.displaySimple(this.strNewPluginDesc, true);
        jceDisplayer.displaySimple(this.strNewPluginURL, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        GetResourceRespInfoV2 getResourceRespInfoV2 = (GetResourceRespInfoV2) obj;
        if (!JceUtil.equals(this.strPkgName, getResourceRespInfoV2.strPkgName) || !JceUtil.equals(this.uiNewVer, getResourceRespInfoV2.uiNewVer) || !JceUtil.equals(this.sResSubType, getResourceRespInfoV2.sResSubType) || !JceUtil.equals(this.sLanType, getResourceRespInfoV2.sLanType) || !JceUtil.equals(this.sPriority, getResourceRespInfoV2.sPriority) || !JceUtil.equals(this.strResName, getResourceRespInfoV2.strResName) || !JceUtil.equals(this.strResDesc, getResourceRespInfoV2.strResDesc) || !JceUtil.equals(this.strResURL_big, getResourceRespInfoV2.strResURL_big) || !JceUtil.equals(this.strResURL_small, getResourceRespInfoV2.strResURL_small) || !JceUtil.equals(this.strResConf, getResourceRespInfoV2.strResConf) || !JceUtil.equals(this.cDefaultState, getResourceRespInfoV2.cDefaultState) || !JceUtil.equals(this.cCanChangeState, getResourceRespInfoV2.cCanChangeState) || !JceUtil.equals(this.uiResId, getResourceRespInfoV2.uiResId) || !JceUtil.equals(this.cStatus, getResourceRespInfoV2.cStatus) || !JceUtil.equals(this.cPush, getResourceRespInfoV2.cPush) || !JceUtil.equals(this.iPluginType, getResourceRespInfoV2.iPluginType) || !JceUtil.equals(this.strNewPluginDesc, getResourceRespInfoV2.strNewPluginDesc) || !JceUtil.equals(this.strNewPluginURL, getResourceRespInfoV2.strNewPluginURL)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "protocol.KQQConfig.GetResourceRespInfoV2";
    }

    public byte getCCanChangeState() {
        return this.cCanChangeState;
    }

    public byte getCDefaultState() {
        return this.cDefaultState;
    }

    public byte getCPush() {
        return this.cPush;
    }

    public byte getCStatus() {
        return this.cStatus;
    }

    public int getIPluginType() {
        return this.iPluginType;
    }

    public short getSLanType() {
        return this.sLanType;
    }

    public short getSPriority() {
        return this.sPriority;
    }

    public short getSResSubType() {
        return this.sResSubType;
    }

    public String getStrNewPluginDesc() {
        return this.strNewPluginDesc;
    }

    public String getStrNewPluginURL() {
        return this.strNewPluginURL;
    }

    public String getStrPkgName() {
        return this.strPkgName;
    }

    public String getStrResConf() {
        return this.strResConf;
    }

    public String getStrResDesc() {
        return this.strResDesc;
    }

    public String getStrResName() {
        return this.strResName;
    }

    public String getStrResURL_big() {
        return this.strResURL_big;
    }

    public String getStrResURL_small() {
        return this.strResURL_small;
    }

    public long getUiNewVer() {
        return this.uiNewVer;
    }

    public long getUiResId() {
        return this.uiResId;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strPkgName = jceInputStream.readString(1, true);
        this.uiNewVer = jceInputStream.read(this.uiNewVer, 2, true);
        this.sResSubType = jceInputStream.read(this.sResSubType, 3, true);
        this.sLanType = jceInputStream.read(this.sLanType, 4, true);
        this.sPriority = jceInputStream.read(this.sPriority, 5, true);
        this.strResName = jceInputStream.readString(6, true);
        this.strResDesc = jceInputStream.readString(7, true);
        this.strResURL_big = jceInputStream.readString(8, true);
        this.strResURL_small = jceInputStream.readString(9, true);
        this.strResConf = jceInputStream.readString(10, true);
        this.cDefaultState = jceInputStream.read(this.cDefaultState, 11, true);
        this.cCanChangeState = jceInputStream.read(this.cCanChangeState, 12, true);
        this.uiResId = jceInputStream.read(this.uiResId, 13, false);
        this.cStatus = jceInputStream.read(this.cStatus, 14, false);
        this.cPush = jceInputStream.read(this.cPush, 15, false);
        this.iPluginType = jceInputStream.read(this.iPluginType, 16, false);
        this.strNewPluginDesc = jceInputStream.readString(17, false);
        this.strNewPluginURL = jceInputStream.readString(18, false);
    }

    public void setCCanChangeState(byte b16) {
        this.cCanChangeState = b16;
    }

    public void setCDefaultState(byte b16) {
        this.cDefaultState = b16;
    }

    public void setCPush(byte b16) {
        this.cPush = b16;
    }

    public void setCStatus(byte b16) {
        this.cStatus = b16;
    }

    public void setIPluginType(int i3) {
        this.iPluginType = i3;
    }

    public void setSLanType(short s16) {
        this.sLanType = s16;
    }

    public void setSPriority(short s16) {
        this.sPriority = s16;
    }

    public void setSResSubType(short s16) {
        this.sResSubType = s16;
    }

    public void setStrNewPluginDesc(String str) {
        this.strNewPluginDesc = str;
    }

    public void setStrNewPluginURL(String str) {
        this.strNewPluginURL = str;
    }

    public void setStrPkgName(String str) {
        this.strPkgName = str;
    }

    public void setStrResConf(String str) {
        this.strResConf = str;
    }

    public void setStrResDesc(String str) {
        this.strResDesc = str;
    }

    public void setStrResName(String str) {
        this.strResName = str;
    }

    public void setStrResURL_big(String str) {
        this.strResURL_big = str;
    }

    public void setStrResURL_small(String str) {
        this.strResURL_small = str;
    }

    public void setUiNewVer(long j3) {
        this.uiNewVer = j3;
    }

    public void setUiResId(long j3) {
        this.uiResId = j3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strPkgName, 1);
        jceOutputStream.write(this.uiNewVer, 2);
        jceOutputStream.write(this.sResSubType, 3);
        jceOutputStream.write(this.sLanType, 4);
        jceOutputStream.write(this.sPriority, 5);
        jceOutputStream.write(this.strResName, 6);
        jceOutputStream.write(this.strResDesc, 7);
        jceOutputStream.write(this.strResURL_big, 8);
        jceOutputStream.write(this.strResURL_small, 9);
        jceOutputStream.write(this.strResConf, 10);
        jceOutputStream.write(this.cDefaultState, 11);
        jceOutputStream.write(this.cCanChangeState, 12);
        jceOutputStream.write(this.uiResId, 13);
        jceOutputStream.write(this.cStatus, 14);
        jceOutputStream.write(this.cPush, 15);
        jceOutputStream.write(this.iPluginType, 16);
        String str = this.strNewPluginDesc;
        if (str != null) {
            jceOutputStream.write(str, 17);
        }
        String str2 = this.strNewPluginURL;
        if (str2 != null) {
            jceOutputStream.write(str2, 18);
        }
    }

    public GetResourceRespInfoV2(String str, long j3, short s16, short s17, short s18, String str2, String str3, String str4, String str5, String str6, byte b16, byte b17, long j16, byte b18, byte b19, int i3, String str7, String str8) {
        this.strPkgName = str;
        this.uiNewVer = j3;
        this.sResSubType = s16;
        this.sLanType = s17;
        this.sPriority = s18;
        this.strResName = str2;
        this.strResDesc = str3;
        this.strResURL_big = str4;
        this.strResURL_small = str5;
        this.strResConf = str6;
        this.cDefaultState = b16;
        this.cCanChangeState = b17;
        this.uiResId = j16;
        this.cStatus = b18;
        this.cPush = b19;
        this.iPluginType = i3;
        this.strNewPluginDesc = str7;
        this.strNewPluginURL = str8;
    }
}

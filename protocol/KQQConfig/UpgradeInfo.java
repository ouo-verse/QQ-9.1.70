package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UpgradeInfo extends JceStruct {
    static PublicAccountInfo cache_stAccountInfo;
    public int iUpgradeSdkId64;
    public boolean is64;
    public int iAppid = 0;
    public byte bAppType = 0;
    public int iUpgradeType = 0;
    public int iUpgradeSdkId = 0;
    public String strTitle = "";
    public String strNewTitle = "";
    public String strUpgradeDesc = "";
    public String strUrl = "";
    public int iActionType = 0;
    public byte bNewSwitch = 1;
    public int iNewTimeStamp = 0;
    public String strUpgradePageUrl = "";
    public int iIncrementUpgrade = 0;
    public int iTipsType = 0;
    public String strBannerPicUrl = "";
    public String strNewUpgradeDescURL = "";
    public int iDisplayDay = 0;
    public int iTipsWaitDay = 0;
    public String strProgressName = "";
    public String strNewTipsDescURL = "";
    public String strNewSoftwareURL = "";
    public String strNewSoftwareMD5 = "";
    public PublicAccountInfo stAccountInfo = null;
    public byte bGray = 0;
    public String strButtonDesc = "";
    public String strCancelButtonDesc = "";
    public String strNewSoftwareURL64 = "";
    public String strNewSoftwareMD564 = "";
    public String strProgressName64 = "";
    public boolean isValid = true;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iAppid = jceInputStream.read(this.iAppid, 1, true);
        this.bAppType = jceInputStream.read(this.bAppType, 2, true);
        this.iUpgradeType = jceInputStream.read(this.iUpgradeType, 3, true);
        this.iUpgradeSdkId = jceInputStream.read(this.iUpgradeSdkId, 4, true);
        this.strTitle = jceInputStream.readString(5, false);
        this.strNewTitle = jceInputStream.readString(6, false);
        this.strUpgradeDesc = jceInputStream.readString(7, false);
        this.strUrl = jceInputStream.readString(8, false);
        this.iActionType = jceInputStream.read(this.iActionType, 9, false);
        this.bNewSwitch = jceInputStream.read(this.bNewSwitch, 10, false);
        this.iNewTimeStamp = jceInputStream.read(this.iNewTimeStamp, 11, false);
        this.strUpgradePageUrl = jceInputStream.readString(12, false);
        this.iIncrementUpgrade = jceInputStream.read(this.iIncrementUpgrade, 13, false);
        this.iTipsType = jceInputStream.read(this.iTipsType, 14, false);
        this.strBannerPicUrl = jceInputStream.readString(15, false);
        this.strNewUpgradeDescURL = jceInputStream.readString(16, false);
        this.iDisplayDay = jceInputStream.read(this.iDisplayDay, 17, false);
        this.iTipsWaitDay = jceInputStream.read(this.iTipsWaitDay, 18, false);
        this.strProgressName = jceInputStream.readString(19, false);
        this.strNewTipsDescURL = jceInputStream.readString(20, false);
        this.strNewSoftwareURL = jceInputStream.readString(21, false);
        if (cache_stAccountInfo == null) {
            cache_stAccountInfo = new PublicAccountInfo();
        }
        this.stAccountInfo = (PublicAccountInfo) jceInputStream.read((JceStruct) cache_stAccountInfo, 22, false);
        this.bGray = jceInputStream.read(this.bGray, 23, false);
        this.strButtonDesc = jceInputStream.readString(24, false);
        this.strCancelButtonDesc = jceInputStream.readString(25, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iAppid, 1);
        jceOutputStream.write(this.bAppType, 2);
        jceOutputStream.write(this.iUpgradeType, 3);
        jceOutputStream.write(this.iUpgradeSdkId, 4);
        String str = this.strTitle;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        String str2 = this.strNewTitle;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        String str3 = this.strUpgradeDesc;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        String str4 = this.strUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 8);
        }
        jceOutputStream.write(this.iActionType, 8);
        jceOutputStream.write(this.bNewSwitch, 10);
        jceOutputStream.write(this.iNewTimeStamp, 11);
        String str5 = this.strUpgradePageUrl;
        if (str5 != null) {
            jceOutputStream.write(str5, 12);
        }
        jceOutputStream.write(this.iIncrementUpgrade, 13);
        jceOutputStream.write(this.iTipsType, 14);
        String str6 = this.strBannerPicUrl;
        if (str6 != null) {
            jceOutputStream.write(str6, 15);
        }
        String str7 = this.strNewUpgradeDescURL;
        if (str7 != null) {
            jceOutputStream.write(str7, 16);
        }
        jceOutputStream.write(this.iDisplayDay, 17);
        jceOutputStream.write(this.iTipsWaitDay, 18);
        String str8 = this.strProgressName;
        if (str8 != null) {
            jceOutputStream.write(str8, 19);
        }
        String str9 = this.strNewTipsDescURL;
        if (str9 != null) {
            jceOutputStream.write(str9, 20);
        }
        String str10 = this.strNewSoftwareURL;
        if (str10 != null) {
            jceOutputStream.write(str10, 21);
        }
        PublicAccountInfo publicAccountInfo = this.stAccountInfo;
        if (publicAccountInfo != null) {
            jceOutputStream.write((JceStruct) publicAccountInfo, 22);
        }
        jceOutputStream.write(this.bGray, 23);
        String str11 = this.strButtonDesc;
        if (str11 != null) {
            jceOutputStream.write(str11, 24);
        }
        String str12 = this.strCancelButtonDesc;
        if (str12 != null) {
            jceOutputStream.write(str12, 25);
        }
    }
}

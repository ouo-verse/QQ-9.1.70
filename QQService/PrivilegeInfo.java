package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PrivilegeInfo extends JceStruct {
    public int iFeeType;
    public int iFlag;
    public int iIsBig;
    public int iIsRemind;
    public int iLevel;
    public int iRemindTime;
    public int iSort;
    public int iTipsTimes;
    public int iType;
    public boolean isOpen;
    public String strDeluxeIconUrl;
    public String strExtInfo;
    public String strIconUrl;
    public String strJumpUrl;
    public String strTipsIconUrl;

    public PrivilegeInfo() {
        this.iType = -1;
        this.iSort = -1;
        this.iFeeType = -1;
        this.iLevel = -1;
        this.iFlag = 0;
        this.strIconUrl = "";
        this.strDeluxeIconUrl = "";
        this.strJumpUrl = "";
        this.iIsBig = 0;
        this.isOpen = false;
        this.iIsRemind = 0;
        this.iRemindTime = 0;
        this.strTipsIconUrl = "";
        this.iTipsTimes = 0;
        this.strExtInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iType = jceInputStream.read(this.iType, 0, true);
        this.iSort = jceInputStream.read(this.iSort, 1, true);
        this.iFeeType = jceInputStream.read(this.iFeeType, 2, true);
        this.iLevel = jceInputStream.read(this.iLevel, 3, true);
        this.iFlag = jceInputStream.read(this.iFlag, 4, true);
        this.strIconUrl = jceInputStream.readString(5, false);
        this.strDeluxeIconUrl = jceInputStream.readString(6, false);
        this.strJumpUrl = jceInputStream.readString(7, false);
        this.iIsBig = jceInputStream.read(this.iIsBig, 8, false);
        this.iIsRemind = jceInputStream.read(this.iIsRemind, 9, false);
        this.iRemindTime = jceInputStream.read(this.iRemindTime, 10, false);
        this.strTipsIconUrl = jceInputStream.readString(11, false);
        this.iTipsTimes = jceInputStream.read(this.iTipsTimes, 12, false);
        this.strExtInfo = jceInputStream.readString(13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iType, 0);
        jceOutputStream.write(this.iSort, 1);
        jceOutputStream.write(this.iFeeType, 2);
        jceOutputStream.write(this.iLevel, 3);
        jceOutputStream.write(this.iFlag, 4);
        String str = this.strIconUrl;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        String str2 = this.strDeluxeIconUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        String str3 = this.strJumpUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        jceOutputStream.write(this.iIsBig, 8);
        jceOutputStream.write(this.iIsRemind, 9);
        jceOutputStream.write(this.iRemindTime, 10);
        jceOutputStream.write(this.strTipsIconUrl, 11);
        jceOutputStream.write(this.iTipsTimes, 12);
        String str4 = this.strExtInfo;
        if (str4 != null) {
            jceOutputStream.write(str4, 13);
        }
    }

    public PrivilegeInfo(int i3, int i16, int i17, int i18, int i19, String str, String str2, String str3, int i26, int i27, int i28, String str4, int i29, String str5) {
        this.isOpen = false;
        this.iType = i3;
        this.iSort = i16;
        this.iFeeType = i17;
        this.iLevel = i18;
        this.iFlag = i19;
        this.strIconUrl = str;
        this.strDeluxeIconUrl = str2;
        this.strJumpUrl = str3;
        this.iIsBig = i26;
        this.iIsRemind = i27;
        this.iRemindTime = i28;
        this.strTipsIconUrl = str4;
        this.iTipsTimes = i29;
        this.strExtInfo = str5;
    }
}

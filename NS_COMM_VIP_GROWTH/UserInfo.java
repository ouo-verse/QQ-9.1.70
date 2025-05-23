package NS_COMM_VIP_GROWTH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserInfo extends JceStruct {
    static int cache_iUserType;
    static int cache_stPayWay;
    static ArrayList<DouScoreInfo> cache_vecDouScoreInfos;
    static ArrayList<Integer> cache_vecKeepDays = new ArrayList<>();
    public int iAddExpScore;
    public int iEverSSuperVip;
    public int iEverSuperVip;
    public int iEverVip;
    public int iEverYearVip;
    public int iIconType;
    public int iIsUseVipIcon;
    public int iKeepDays;
    public int iLevel;
    public int iMaxScore;
    public int iRankId;
    public int iRenewal;
    public int iSSuperVip;
    public int iScore;
    public int iSpeed;
    public int iSuperVip;
    public int iUserType;
    public int iVip;
    public int iYearVip;
    public int stPayWay;
    public String strSSuperVipRenewal;
    public String strSuperVipRenewal;
    public String strUid;
    public String strVipRenewal;
    public long uiDouScoreExpTime;
    public long uiDouTimes;
    public long uiExpScoreExpireTime;
    public long uiLastCalcTime;
    public long uiSSuperVipCloseTime;
    public long uiSSuperVipOpenTime;
    public long uiSuperVipCloseTime;
    public long uiSuperVipOpenTime;
    public long uiVipCloseTime;
    public long uiVipOpenTime;
    public long uiYearVipCloseTime;
    public long uiYearVipOpenTime;
    public ArrayList<DouScoreInfo> vecDouScoreInfos;
    public ArrayList<Integer> vecKeepDays;

    static {
        cache_vecKeepDays.add(0);
        cache_stPayWay = 0;
        cache_vecDouScoreInfos = new ArrayList<>();
        cache_vecDouScoreInfos.add(new DouScoreInfo());
    }

    public UserInfo() {
        this.strUid = "";
        this.iUserType = 0;
        this.iVip = 0;
        this.iEverVip = 0;
        this.iSuperVip = 0;
        this.iEverSuperVip = 0;
        this.iYearVip = 0;
        this.iEverYearVip = 0;
        this.iScore = 0;
        this.iMaxScore = 0;
        this.iLevel = 0;
        this.iSpeed = 0;
        this.uiLastCalcTime = 0L;
        this.uiVipOpenTime = 0L;
        this.uiVipCloseTime = 0L;
        this.uiSuperVipOpenTime = 0L;
        this.uiSuperVipCloseTime = 0L;
        this.uiYearVipOpenTime = 0L;
        this.uiYearVipCloseTime = 0L;
        this.iSSuperVip = 0;
        this.iEverSSuperVip = 0;
        this.uiSSuperVipOpenTime = 0L;
        this.uiSSuperVipCloseTime = 0L;
        this.strVipRenewal = "";
        this.strSuperVipRenewal = "";
        this.strSSuperVipRenewal = "";
        this.iIsUseVipIcon = 0;
        this.iRankId = 0;
        this.iRenewal = 0;
        this.iIconType = 2;
        this.uiDouScoreExpTime = 0L;
        this.uiDouTimes = 0L;
        this.iAddExpScore = 0;
        this.uiExpScoreExpireTime = 0L;
        this.vecKeepDays = null;
        this.iKeepDays = 0;
        this.stPayWay = 0;
        this.vecDouScoreInfos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strUid = jceInputStream.readString(0, false);
        this.iUserType = jceInputStream.read(this.iUserType, 1, false);
        this.iVip = jceInputStream.read(this.iVip, 2, false);
        this.iEverVip = jceInputStream.read(this.iEverVip, 3, false);
        this.iSuperVip = jceInputStream.read(this.iSuperVip, 4, false);
        this.iEverSuperVip = jceInputStream.read(this.iEverSuperVip, 5, false);
        this.iYearVip = jceInputStream.read(this.iYearVip, 6, false);
        this.iEverYearVip = jceInputStream.read(this.iEverYearVip, 7, false);
        this.iScore = jceInputStream.read(this.iScore, 8, false);
        this.iMaxScore = jceInputStream.read(this.iMaxScore, 9, false);
        this.iLevel = jceInputStream.read(this.iLevel, 10, false);
        this.iSpeed = jceInputStream.read(this.iSpeed, 11, false);
        this.uiLastCalcTime = jceInputStream.read(this.uiLastCalcTime, 12, false);
        this.uiVipOpenTime = jceInputStream.read(this.uiVipOpenTime, 13, false);
        this.uiVipCloseTime = jceInputStream.read(this.uiVipCloseTime, 14, false);
        this.uiSuperVipOpenTime = jceInputStream.read(this.uiSuperVipOpenTime, 15, false);
        this.uiSuperVipCloseTime = jceInputStream.read(this.uiSuperVipCloseTime, 16, false);
        this.uiYearVipOpenTime = jceInputStream.read(this.uiYearVipOpenTime, 17, false);
        this.uiYearVipCloseTime = jceInputStream.read(this.uiYearVipCloseTime, 18, false);
        this.iSSuperVip = jceInputStream.read(this.iSSuperVip, 19, false);
        this.iEverSSuperVip = jceInputStream.read(this.iEverSSuperVip, 20, false);
        this.uiSSuperVipOpenTime = jceInputStream.read(this.uiSSuperVipOpenTime, 21, false);
        this.uiSSuperVipCloseTime = jceInputStream.read(this.uiSSuperVipCloseTime, 22, false);
        this.strVipRenewal = jceInputStream.readString(23, false);
        this.strSuperVipRenewal = jceInputStream.readString(24, false);
        this.strSSuperVipRenewal = jceInputStream.readString(25, false);
        this.iIsUseVipIcon = jceInputStream.read(this.iIsUseVipIcon, 26, false);
        this.iRankId = jceInputStream.read(this.iRankId, 27, false);
        this.iRenewal = jceInputStream.read(this.iRenewal, 28, false);
        this.iIconType = jceInputStream.read(this.iIconType, 29, false);
        this.uiDouScoreExpTime = jceInputStream.read(this.uiDouScoreExpTime, 30, false);
        this.uiDouTimes = jceInputStream.read(this.uiDouTimes, 31, false);
        this.iAddExpScore = jceInputStream.read(this.iAddExpScore, 32, false);
        this.uiExpScoreExpireTime = jceInputStream.read(this.uiExpScoreExpireTime, 33, false);
        this.vecKeepDays = (ArrayList) jceInputStream.read((JceInputStream) cache_vecKeepDays, 34, false);
        this.iKeepDays = jceInputStream.read(this.iKeepDays, 35, false);
        this.stPayWay = jceInputStream.read(this.stPayWay, 36, false);
        this.vecDouScoreInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_vecDouScoreInfos, 37, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strUid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.iUserType, 1);
        jceOutputStream.write(this.iVip, 2);
        jceOutputStream.write(this.iEverVip, 3);
        jceOutputStream.write(this.iSuperVip, 4);
        jceOutputStream.write(this.iEverSuperVip, 5);
        jceOutputStream.write(this.iYearVip, 6);
        jceOutputStream.write(this.iEverYearVip, 7);
        jceOutputStream.write(this.iScore, 8);
        jceOutputStream.write(this.iMaxScore, 9);
        jceOutputStream.write(this.iLevel, 10);
        jceOutputStream.write(this.iSpeed, 11);
        jceOutputStream.write(this.uiLastCalcTime, 12);
        jceOutputStream.write(this.uiVipOpenTime, 13);
        jceOutputStream.write(this.uiVipCloseTime, 14);
        jceOutputStream.write(this.uiSuperVipOpenTime, 15);
        jceOutputStream.write(this.uiSuperVipCloseTime, 16);
        jceOutputStream.write(this.uiYearVipOpenTime, 17);
        jceOutputStream.write(this.uiYearVipCloseTime, 18);
        jceOutputStream.write(this.iSSuperVip, 19);
        jceOutputStream.write(this.iEverSSuperVip, 20);
        jceOutputStream.write(this.uiSSuperVipOpenTime, 21);
        jceOutputStream.write(this.uiSSuperVipCloseTime, 22);
        String str2 = this.strVipRenewal;
        if (str2 != null) {
            jceOutputStream.write(str2, 23);
        }
        String str3 = this.strSuperVipRenewal;
        if (str3 != null) {
            jceOutputStream.write(str3, 24);
        }
        String str4 = this.strSSuperVipRenewal;
        if (str4 != null) {
            jceOutputStream.write(str4, 25);
        }
        jceOutputStream.write(this.iIsUseVipIcon, 26);
        jceOutputStream.write(this.iRankId, 27);
        jceOutputStream.write(this.iRenewal, 28);
        jceOutputStream.write(this.iIconType, 29);
        jceOutputStream.write(this.uiDouScoreExpTime, 30);
        jceOutputStream.write(this.uiDouTimes, 31);
        jceOutputStream.write(this.iAddExpScore, 32);
        jceOutputStream.write(this.uiExpScoreExpireTime, 33);
        ArrayList<Integer> arrayList = this.vecKeepDays;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 34);
        }
        jceOutputStream.write(this.iKeepDays, 35);
        jceOutputStream.write(this.stPayWay, 36);
        ArrayList<DouScoreInfo> arrayList2 = this.vecDouScoreInfos;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 37);
        }
    }

    public UserInfo(String str, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, long j3, long j16, long j17, long j18, long j19, long j26, long j27, int i38, int i39, long j28, long j29, String str2, String str3, String str4, int i46, int i47, int i48, int i49, long j36, long j37, int i56, long j38, ArrayList<Integer> arrayList, int i57, int i58, ArrayList<DouScoreInfo> arrayList2) {
        this.strUid = str;
        this.iUserType = i3;
        this.iVip = i16;
        this.iEverVip = i17;
        this.iSuperVip = i18;
        this.iEverSuperVip = i19;
        this.iYearVip = i26;
        this.iEverYearVip = i27;
        this.iScore = i28;
        this.iMaxScore = i29;
        this.iLevel = i36;
        this.iSpeed = i37;
        this.uiLastCalcTime = j3;
        this.uiVipOpenTime = j16;
        this.uiVipCloseTime = j17;
        this.uiSuperVipOpenTime = j18;
        this.uiSuperVipCloseTime = j19;
        this.uiYearVipOpenTime = j26;
        this.uiYearVipCloseTime = j27;
        this.iSSuperVip = i38;
        this.iEverSSuperVip = i39;
        this.uiSSuperVipOpenTime = j28;
        this.uiSSuperVipCloseTime = j29;
        this.strVipRenewal = str2;
        this.strSuperVipRenewal = str3;
        this.strSSuperVipRenewal = str4;
        this.iIsUseVipIcon = i46;
        this.iRankId = i47;
        this.iRenewal = i48;
        this.iIconType = i49;
        this.uiDouScoreExpTime = j36;
        this.uiDouTimes = j37;
        this.iAddExpScore = i56;
        this.uiExpScoreExpireTime = j38;
        this.vecKeepDays = arrayList;
        this.iKeepDays = i57;
        this.stPayWay = i58;
        this.vecDouScoreInfos = arrayList2;
    }
}

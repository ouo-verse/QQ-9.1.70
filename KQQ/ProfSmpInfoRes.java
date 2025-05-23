package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ProfSmpInfoRes extends JceStruct {
    public boolean bOpenLoginDays;
    public boolean bXManIconClick;
    public byte cBusiCardFlag;
    public byte cResult;
    public byte cSex;
    public byte cSpecialFlag;
    public long dwBirthday;
    public long dwCityID;
    public long dwCounrtyID;
    public int dwLevelOnline;
    public int dwLevelRemain;
    public long dwLoginDay;
    public long dwPhoneQQXManDay;
    public long dwProvinceID;
    public long dwUin;
    public long dwZoneID;
    public int iXManScene1DelayTime;
    public int iXManScene2DelayTime;
    public int isShowXMan;
    public String sCity;
    public String sCountry;
    public String sDateNick;
    public String sProvince;
    public String strNick;
    public String strSignature;
    public byte wAge;
    public short wFace;
    public short wLevel;

    public ProfSmpInfoRes() {
        this.dwUin = 0L;
        this.wFace = (short) 0;
        this.cSex = (byte) 0;
        this.wAge = (byte) 0;
        this.strNick = "";
        this.cResult = (byte) 0;
        this.strSignature = "";
        this.dwBirthday = 0L;
        this.dwCounrtyID = 0L;
        this.dwProvinceID = 0L;
        this.dwCityID = 0L;
        this.dwZoneID = 0L;
        this.sCountry = "";
        this.sProvince = "";
        this.sCity = "";
        this.wLevel = (short) 0;
        this.dwLevelOnline = 0;
        this.dwLevelRemain = 0;
        this.isShowXMan = -1;
        this.dwLoginDay = 0L;
        this.dwPhoneQQXManDay = 0L;
        this.bXManIconClick = false;
        this.bOpenLoginDays = false;
        this.cSpecialFlag = (byte) -1;
        this.sDateNick = "";
        this.cBusiCardFlag = (byte) -1;
        this.iXManScene1DelayTime = 0;
        this.iXManScene2DelayTime = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwUin = jceInputStream.read(this.dwUin, 1, true);
        this.wFace = jceInputStream.read(this.wFace, 2, true);
        this.cSex = jceInputStream.read(this.cSex, 3, true);
        this.wAge = jceInputStream.read(this.wAge, 4, true);
        this.strNick = jceInputStream.readString(5, true);
        this.cResult = jceInputStream.read(this.cResult, 6, false);
        this.strSignature = jceInputStream.readString(7, false);
        this.dwBirthday = jceInputStream.read(this.dwBirthday, 8, false);
        this.dwCounrtyID = jceInputStream.read(this.dwCounrtyID, 9, false);
        this.dwProvinceID = jceInputStream.read(this.dwProvinceID, 10, false);
        this.dwCityID = jceInputStream.read(this.dwCityID, 11, false);
        this.dwZoneID = jceInputStream.read(this.dwZoneID, 12, false);
        this.sCountry = jceInputStream.readString(13, false);
        this.sProvince = jceInputStream.readString(14, false);
        this.sCity = jceInputStream.readString(15, false);
        this.wLevel = jceInputStream.read(this.wLevel, 16, false);
        this.dwLevelOnline = jceInputStream.read(this.dwLevelOnline, 17, false);
        this.dwLevelRemain = jceInputStream.read(this.dwLevelRemain, 18, false);
        this.isShowXMan = jceInputStream.read(this.isShowXMan, 19, false);
        this.dwLoginDay = jceInputStream.read(this.dwLoginDay, 20, false);
        this.dwPhoneQQXManDay = jceInputStream.read(this.dwPhoneQQXManDay, 21, false);
        this.bXManIconClick = jceInputStream.read(this.bXManIconClick, 22, false);
        this.bOpenLoginDays = jceInputStream.read(this.bOpenLoginDays, 23, false);
        this.cSpecialFlag = jceInputStream.read(this.cSpecialFlag, 24, false);
        this.sDateNick = jceInputStream.readString(25, false);
        this.cBusiCardFlag = jceInputStream.read(this.cBusiCardFlag, 26, false);
        this.iXManScene1DelayTime = jceInputStream.read(this.iXManScene1DelayTime, 101, false);
        this.iXManScene2DelayTime = jceInputStream.read(this.iXManScene2DelayTime, 102, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwUin, 1);
        jceOutputStream.write(this.wFace, 2);
        jceOutputStream.write(this.cSex, 3);
        jceOutputStream.write(this.wAge, 4);
        jceOutputStream.write(this.strNick, 5);
        jceOutputStream.write(this.cResult, 6);
        String str = this.strSignature;
        if (str != null) {
            jceOutputStream.write(str, 7);
        }
        jceOutputStream.write(this.dwBirthday, 8);
        jceOutputStream.write(this.dwCounrtyID, 9);
        jceOutputStream.write(this.dwProvinceID, 10);
        jceOutputStream.write(this.dwCityID, 11);
        jceOutputStream.write(this.dwZoneID, 12);
        String str2 = this.sCountry;
        if (str2 != null) {
            jceOutputStream.write(str2, 13);
        }
        String str3 = this.sProvince;
        if (str3 != null) {
            jceOutputStream.write(str3, 14);
        }
        String str4 = this.sCity;
        if (str4 != null) {
            jceOutputStream.write(str4, 15);
        }
        jceOutputStream.write(this.wLevel, 16);
        jceOutputStream.write(this.dwLevelOnline, 17);
        jceOutputStream.write(this.dwLevelRemain, 18);
        jceOutputStream.write(this.isShowXMan, 19);
        jceOutputStream.write(this.dwLoginDay, 20);
        jceOutputStream.write(this.dwPhoneQQXManDay, 21);
        jceOutputStream.write(this.bXManIconClick, 22);
        jceOutputStream.write(this.bOpenLoginDays, 23);
        jceOutputStream.write(this.cSpecialFlag, 24);
        String str5 = this.sDateNick;
        if (str5 != null) {
            jceOutputStream.write(str5, 25);
        }
        jceOutputStream.write(this.cBusiCardFlag, 26);
        jceOutputStream.write(this.iXManScene1DelayTime, 101);
        jceOutputStream.write(this.iXManScene2DelayTime, 102);
    }

    public ProfSmpInfoRes(long j3, short s16, byte b16, byte b17, String str, byte b18, String str2, long j16, long j17, long j18, long j19, long j26, String str3, String str4, String str5, short s17, int i3, int i16, int i17, long j27, long j28, boolean z16, boolean z17, byte b19, String str6, byte b26, int i18, int i19) {
        this.dwUin = j3;
        this.wFace = s16;
        this.cSex = b16;
        this.wAge = b17;
        this.strNick = str;
        this.cResult = b18;
        this.strSignature = str2;
        this.dwBirthday = j16;
        this.dwCounrtyID = j17;
        this.dwProvinceID = j18;
        this.dwCityID = j19;
        this.dwZoneID = j26;
        this.sCountry = str3;
        this.sProvince = str4;
        this.sCity = str5;
        this.wLevel = s17;
        this.dwLevelOnline = i3;
        this.dwLevelRemain = i16;
        this.isShowXMan = i17;
        this.dwLoginDay = j27;
        this.dwPhoneQQXManDay = j28;
        this.bXManIconClick = z16;
        this.bOpenLoginDays = z17;
        this.cSpecialFlag = b19;
        this.sDateNick = str6;
        this.cBusiCardFlag = b26;
        this.iXManScene1DelayTime = i18;
        this.iXManScene2DelayTime = i19;
    }
}

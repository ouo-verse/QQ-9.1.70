package TianShuJce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CommInfo extends JceStruct {
    static Gps cache_stGps = new Gps();
    public long iBid;
    public int iNetWorkEnv;
    public long lUin;
    public Gps stGps;
    public String strApp;
    public String strCityCode;
    public String strDeviceInfo;
    public String strExpSeq;
    public String strOpenId;
    public String strOs;
    public String strQimei;
    public String strQua;
    public String strUid;
    public String strUserIp;
    public String strVersion;

    public CommInfo() {
        this.lUin = 0L;
        this.strDeviceInfo = "";
        this.stGps = null;
        this.iBid = 0L;
        this.strUserIp = "";
        this.strApp = "";
        this.strOs = "";
        this.strVersion = "";
        this.strOpenId = "";
        this.strCityCode = "";
        this.iNetWorkEnv = 0;
        this.strQua = "";
        this.strQimei = "";
        this.strUid = "";
        this.strExpSeq = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 1, false);
        this.strDeviceInfo = jceInputStream.readString(3, false);
        this.stGps = (Gps) jceInputStream.read((JceStruct) cache_stGps, 4, false);
        this.iBid = jceInputStream.read(this.iBid, 5, false);
        this.strUserIp = jceInputStream.readString(6, false);
        this.strApp = jceInputStream.readString(7, false);
        this.strOs = jceInputStream.readString(8, false);
        this.strVersion = jceInputStream.readString(9, false);
        this.strOpenId = jceInputStream.readString(10, false);
        this.strCityCode = jceInputStream.readString(11, false);
        this.iNetWorkEnv = jceInputStream.read(this.iNetWorkEnv, 12, false);
        this.strQua = jceInputStream.readString(13, false);
        this.strQimei = jceInputStream.readString(14, false);
        this.strUid = jceInputStream.readString(15, false);
        this.strExpSeq = jceInputStream.readString(16, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 1);
        String str = this.strDeviceInfo;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        Gps gps = this.stGps;
        if (gps != null) {
            jceOutputStream.write((JceStruct) gps, 4);
        }
        jceOutputStream.write(this.iBid, 5);
        String str2 = this.strUserIp;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        String str3 = this.strApp;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        String str4 = this.strOs;
        if (str4 != null) {
            jceOutputStream.write(str4, 8);
        }
        String str5 = this.strVersion;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
        String str6 = this.strOpenId;
        if (str6 != null) {
            jceOutputStream.write(str6, 10);
        }
        String str7 = this.strCityCode;
        if (str7 != null) {
            jceOutputStream.write(str7, 11);
        }
        jceOutputStream.write(this.iNetWorkEnv, 12);
        String str8 = this.strQua;
        if (str8 != null) {
            jceOutputStream.write(str8, 13);
        }
        String str9 = this.strQimei;
        if (str9 != null) {
            jceOutputStream.write(str9, 14);
        }
        String str10 = this.strUid;
        if (str10 != null) {
            jceOutputStream.write(str10, 15);
        }
        String str11 = this.strExpSeq;
        if (str11 != null) {
            jceOutputStream.write(str11, 16);
        }
    }

    public CommInfo(long j3, String str, Gps gps, long j16, String str2, String str3, String str4, String str5, String str6, String str7, int i3, String str8, String str9, String str10, String str11) {
        this.lUin = j3;
        this.strDeviceInfo = str;
        this.stGps = gps;
        this.iBid = j16;
        this.strUserIp = str2;
        this.strApp = str3;
        this.strOs = str4;
        this.strVersion = str5;
        this.strOpenId = str6;
        this.strCityCode = str7;
        this.iNetWorkEnv = i3;
        this.strQua = str8;
        this.strQimei = str9;
        this.strUid = str10;
        this.strExpSeq = str11;
    }
}

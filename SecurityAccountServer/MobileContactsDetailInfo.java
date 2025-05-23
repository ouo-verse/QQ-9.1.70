package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MobileContactsDetailInfo extends JceStruct {
    public String QQ;
    public int accountAbi;
    public long bindingDate;
    public long isRecommend;
    public String mobileCode;
    public String mobileNo;
    public String name;
    public String nationCode;
    public String nickname;
    public long originBinder;
    public String originMobileNo;
    public short rmdScore;

    public MobileContactsDetailInfo() {
        this.QQ = "";
        this.mobileNo = "";
        this.name = "";
        this.bindingDate = 0L;
        this.isRecommend = 0L;
        this.nationCode = "";
        this.mobileCode = "";
        this.nickname = "";
        this.originMobileNo = "";
        this.originBinder = 0L;
        this.accountAbi = 0;
        this.rmdScore = (short) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.QQ = jceInputStream.readString(0, true);
        this.mobileNo = jceInputStream.readString(1, true);
        this.name = jceInputStream.readString(2, true);
        this.bindingDate = jceInputStream.read(this.bindingDate, 3, false);
        this.isRecommend = jceInputStream.read(this.isRecommend, 4, false);
        this.nationCode = jceInputStream.readString(5, false);
        this.mobileCode = jceInputStream.readString(6, false);
        this.nickname = jceInputStream.readString(7, false);
        this.originMobileNo = jceInputStream.readString(8, false);
        this.originBinder = jceInputStream.read(this.originBinder, 9, false);
        this.accountAbi = jceInputStream.read(this.accountAbi, 10, false);
        this.rmdScore = jceInputStream.read(this.rmdScore, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.QQ, 0);
        jceOutputStream.write(this.mobileNo, 1);
        jceOutputStream.write(this.name, 2);
        jceOutputStream.write(this.bindingDate, 3);
        jceOutputStream.write(this.isRecommend, 4);
        String str = this.nationCode;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        String str2 = this.mobileCode;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        String str3 = this.nickname;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        String str4 = this.originMobileNo;
        if (str4 != null) {
            jceOutputStream.write(str4, 8);
        }
        jceOutputStream.write(this.originBinder, 9);
        jceOutputStream.write(this.accountAbi, 10);
        jceOutputStream.write(this.rmdScore, 11);
    }

    public MobileContactsDetailInfo(String str, String str2, String str3, long j3, long j16, String str4, String str5, String str6, String str7, long j17, int i3, short s16) {
        this.QQ = str;
        this.mobileNo = str2;
        this.name = str3;
        this.bindingDate = j3;
        this.isRecommend = j16;
        this.nationCode = str4;
        this.mobileCode = str5;
        this.nickname = str6;
        this.originMobileNo = str7;
        this.originBinder = j17;
        this.accountAbi = i3;
        this.rmdScore = s16;
    }
}

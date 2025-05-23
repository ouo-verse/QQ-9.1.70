package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_profile_for_get extends JceStruct {
    static s_address cache_addressid;
    public s_address addressid;
    public int age;
    public short birthday;
    public short birthmonth;
    public int birthyear;
    public String city;
    public String constellation;
    public String country;
    public byte gender;
    public byte isBrandQzone;
    public byte islunar;
    public long limitsMask;
    public String nickname;
    public String province;
    public String qzonedesc;
    public long systime;
    public byte vip;
    public int viplevel;
    public int viptype;

    public s_profile_for_get() {
        this.nickname = "";
        this.gender = (byte) -1;
        this.country = "";
        this.province = "";
        this.city = "";
        this.age = -1;
        this.constellation = "";
        this.systime = -1L;
        this.qzonedesc = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nickname = jceInputStream.readString(0, false);
        this.gender = jceInputStream.read(this.gender, 1, false);
        this.islunar = jceInputStream.read(this.islunar, 2, false);
        this.birthyear = jceInputStream.read(this.birthyear, 3, false);
        this.birthmonth = jceInputStream.read(this.birthmonth, 4, false);
        this.birthday = jceInputStream.read(this.birthday, 5, false);
        this.country = jceInputStream.readString(6, false);
        this.province = jceInputStream.readString(7, false);
        this.city = jceInputStream.readString(8, false);
        this.vip = jceInputStream.read(this.vip, 9, false);
        this.viplevel = jceInputStream.read(this.viplevel, 10, false);
        this.viptype = jceInputStream.read(this.viptype, 11, false);
        this.isBrandQzone = jceInputStream.read(this.isBrandQzone, 12, false);
        this.limitsMask = jceInputStream.read(this.limitsMask, 13, false);
        this.age = jceInputStream.read(this.age, 14, false);
        this.constellation = jceInputStream.readString(15, false);
        this.systime = jceInputStream.read(this.systime, 16, false);
        if (cache_addressid == null) {
            cache_addressid = new s_address();
        }
        this.addressid = (s_address) jceInputStream.read((JceStruct) cache_addressid, 17, false);
        this.qzonedesc = jceInputStream.readString(18, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.nickname;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.gender, 1);
        jceOutputStream.write(this.islunar, 2);
        jceOutputStream.write(this.birthyear, 3);
        jceOutputStream.write(this.birthmonth, 4);
        jceOutputStream.write(this.birthday, 5);
        String str2 = this.country;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        String str3 = this.province;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        String str4 = this.city;
        if (str4 != null) {
            jceOutputStream.write(str4, 8);
        }
        jceOutputStream.write(this.vip, 9);
        jceOutputStream.write(this.viplevel, 10);
        jceOutputStream.write(this.viptype, 11);
        jceOutputStream.write(this.isBrandQzone, 12);
        jceOutputStream.write(this.limitsMask, 13);
        jceOutputStream.write(this.age, 14);
        String str5 = this.constellation;
        if (str5 != null) {
            jceOutputStream.write(str5, 15);
        }
        jceOutputStream.write(this.systime, 16);
        s_address s_addressVar = this.addressid;
        if (s_addressVar != null) {
            jceOutputStream.write((JceStruct) s_addressVar, 17);
        }
        String str6 = this.qzonedesc;
        if (str6 != null) {
            jceOutputStream.write(str6, 18);
        }
    }

    public s_profile_for_get(String str, byte b16, byte b17, int i3, short s16, short s17, String str2, String str3, String str4, byte b18, int i16, int i17, byte b19, long j3, int i18, String str5, long j16, s_address s_addressVar, String str6) {
        this.nickname = str;
        this.gender = b16;
        this.islunar = b17;
        this.birthyear = i3;
        this.birthmonth = s16;
        this.birthday = s17;
        this.country = str2;
        this.province = str3;
        this.city = str4;
        this.vip = b18;
        this.viplevel = i16;
        this.viptype = i17;
        this.isBrandQzone = b19;
        this.limitsMask = j3;
        this.age = i18;
        this.constellation = str5;
        this.systime = j16;
        this.addressid = s_addressVar;
        this.qzonedesc = str6;
    }
}

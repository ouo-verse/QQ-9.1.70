package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_profile_for_set extends JceStruct {
    public short birthday;
    public short birthmonth;
    public int birthyear;
    public String city;
    public String country;
    public byte gender;
    public byte islunar;
    public String nickname;
    public String province;
    public String qzonedesc;

    public s_profile_for_set() {
        this.nickname = "";
        this.gender = (byte) -1;
        this.country = "";
        this.province = "";
        this.city = "";
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
        this.qzonedesc = jceInputStream.readString(9, false);
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
        String str5 = this.qzonedesc;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
    }

    public s_profile_for_set(String str, byte b16, byte b17, int i3, short s16, short s17, String str2, String str3, String str4, String str5) {
        this.nickname = str;
        this.gender = b16;
        this.islunar = b17;
        this.birthyear = i3;
        this.birthmonth = s16;
        this.birthday = s17;
        this.country = str2;
        this.province = str3;
        this.city = str4;
        this.qzonedesc = str5;
    }
}

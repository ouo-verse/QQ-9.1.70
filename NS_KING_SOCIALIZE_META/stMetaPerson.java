package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stMetaPerson extends JceStruct {
    public String address;
    public int age;
    public String avatar;
    public String chatlist_id;
    public int createtime;
    public String feedlist_hot_id;
    public String feedlist_time_id;
    public String followerlist_id;

    /* renamed from: id, reason: collision with root package name */
    public String f24937id;
    public String interesterlist_id;
    public String nick;
    public String related_feedlist_id;
    public int rich_flag;
    public int sex;
    public int type;
    public String uid;

    public stMetaPerson() {
        this.f24937id = "";
        this.type = 0;
        this.uid = "";
        this.createtime = 0;
        this.nick = "";
        this.avatar = "";
        this.sex = 0;
        this.feedlist_time_id = "";
        this.feedlist_hot_id = "";
        this.related_feedlist_id = "";
        this.followerlist_id = "";
        this.interesterlist_id = "";
        this.chatlist_id = "";
        this.rich_flag = 0;
        this.age = 0;
        this.address = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f24937id = jceInputStream.readString(0, false);
        this.type = jceInputStream.read(this.type, 1, false);
        this.uid = jceInputStream.readString(2, false);
        this.createtime = jceInputStream.read(this.createtime, 3, false);
        this.nick = jceInputStream.readString(4, false);
        this.avatar = jceInputStream.readString(5, false);
        this.sex = jceInputStream.read(this.sex, 6, false);
        this.feedlist_time_id = jceInputStream.readString(7, false);
        this.feedlist_hot_id = jceInputStream.readString(8, false);
        this.related_feedlist_id = jceInputStream.readString(9, false);
        this.followerlist_id = jceInputStream.readString(10, false);
        this.interesterlist_id = jceInputStream.readString(11, false);
        this.chatlist_id = jceInputStream.readString(12, false);
        this.rich_flag = jceInputStream.read(this.rich_flag, 13, false);
        this.age = jceInputStream.read(this.age, 14, false);
        this.address = jceInputStream.readString(15, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.f24937id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.type, 1);
        String str2 = this.uid;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.createtime, 3);
        String str3 = this.nick;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.avatar;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        jceOutputStream.write(this.sex, 6);
        String str5 = this.feedlist_time_id;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        String str6 = this.feedlist_hot_id;
        if (str6 != null) {
            jceOutputStream.write(str6, 8);
        }
        String str7 = this.related_feedlist_id;
        if (str7 != null) {
            jceOutputStream.write(str7, 9);
        }
        String str8 = this.followerlist_id;
        if (str8 != null) {
            jceOutputStream.write(str8, 10);
        }
        String str9 = this.interesterlist_id;
        if (str9 != null) {
            jceOutputStream.write(str9, 11);
        }
        String str10 = this.chatlist_id;
        if (str10 != null) {
            jceOutputStream.write(str10, 12);
        }
        jceOutputStream.write(this.rich_flag, 13);
        jceOutputStream.write(this.age, 14);
        String str11 = this.address;
        if (str11 != null) {
            jceOutputStream.write(str11, 15);
        }
    }

    public stMetaPerson(String str, int i3, String str2, int i16, String str3, String str4, int i17, String str5, String str6, String str7, String str8, String str9, String str10, int i18, int i19, String str11) {
        this.f24937id = str;
        this.type = i3;
        this.uid = str2;
        this.createtime = i16;
        this.nick = str3;
        this.avatar = str4;
        this.sex = i17;
        this.feedlist_time_id = str5;
        this.feedlist_hot_id = str6;
        this.related_feedlist_id = str7;
        this.followerlist_id = str8;
        this.interesterlist_id = str9;
        this.chatlist_id = str10;
        this.rich_flag = i18;
        this.age = i19;
        this.address = str11;
    }
}

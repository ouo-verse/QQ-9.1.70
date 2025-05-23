package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_user extends JceStruct {
    public int from;
    public String logo;
    public String nickname;
    public int timestamp;
    public long uin;
    public String uinkey;

    public s_user() {
        this.uin = 0L;
        this.nickname = "";
        this.timestamp = 0;
        this.from = 0;
        this.uinkey = "";
        this.logo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.nickname = jceInputStream.readString(1, false);
        this.timestamp = jceInputStream.read(this.timestamp, 2, false);
        this.from = jceInputStream.read(this.from, 3, false);
        this.uinkey = jceInputStream.readString(4, false);
        this.logo = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.nickname;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.timestamp, 2);
        jceOutputStream.write(this.from, 3);
        String str2 = this.uinkey;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.logo;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
    }

    public s_user(long j3, String str, int i3, int i16, String str2, String str3) {
        this.uin = j3;
        this.nickname = str;
        this.timestamp = i3;
        this.from = i16;
        this.uinkey = str2;
        this.logo = str3;
    }
}

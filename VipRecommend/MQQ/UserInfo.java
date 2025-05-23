package VipRecommend.MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserInfo extends JceStruct {
    public String aid;
    public String clientIp;
    public int isIOSJailbreak;
    public String platform;
    public String type;
    public String uin;
    public String version;

    public UserInfo() {
        this.uin = "";
        this.platform = "";
        this.clientIp = "";
        this.aid = "";
        this.version = "";
        this.isIOSJailbreak = 0;
        this.type = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.readString(0, true);
        this.platform = jceInputStream.readString(1, true);
        this.clientIp = jceInputStream.readString(2, true);
        this.aid = jceInputStream.readString(3, true);
        this.version = jceInputStream.readString(4, true);
        this.isIOSJailbreak = jceInputStream.read(this.isIOSJailbreak, 5, false);
        this.type = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.platform, 1);
        jceOutputStream.write(this.clientIp, 2);
        jceOutputStream.write(this.aid, 3);
        jceOutputStream.write(this.version, 4);
        jceOutputStream.write(this.isIOSJailbreak, 5);
        String str = this.type;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
    }

    public UserInfo(String str, String str2, String str3, String str4, String str5, int i3, String str6) {
        this.uin = str;
        this.platform = str2;
        this.clientIp = str3;
        this.aid = str4;
        this.version = str5;
        this.isIOSJailbreak = i3;
        this.type = str6;
    }
}

package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_openid_user extends JceStruct {
    public String logo;
    public String nickname;
    public String openid;

    public s_openid_user() {
        this.openid = "";
        this.nickname = "";
        this.logo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.openid = jceInputStream.readString(0, false);
        this.nickname = jceInputStream.readString(1, false);
        this.logo = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.openid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.nickname;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.logo;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public s_openid_user(String str, String str2, String str3) {
        this.openid = str;
        this.nickname = str2;
        this.logo = str3;
    }
}

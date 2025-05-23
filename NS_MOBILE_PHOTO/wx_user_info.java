package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class wx_user_info extends JceStruct {
    public String avatar_url;
    public String nickname;
    public String openid;

    public wx_user_info() {
        this.nickname = "";
        this.avatar_url = "";
        this.openid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nickname = jceInputStream.readString(0, false);
        this.avatar_url = jceInputStream.readString(1, false);
        this.openid = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.nickname;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.avatar_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.openid;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public wx_user_info(String str, String str2, String str3) {
        this.nickname = str;
        this.avatar_url = str2;
        this.openid = str3;
    }
}

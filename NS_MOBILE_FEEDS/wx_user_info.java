package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class wx_user_info extends JceStruct {
    public String avatar_url;
    public String nickname;

    public wx_user_info() {
        this.nickname = "";
        this.avatar_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nickname = jceInputStream.readString(0, false);
        this.avatar_url = jceInputStream.readString(1, false);
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
    }

    public wx_user_info(String str, String str2) {
        this.nickname = str;
        this.avatar_url = str2;
    }
}

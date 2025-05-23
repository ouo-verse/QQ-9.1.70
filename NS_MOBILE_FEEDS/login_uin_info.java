package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class login_uin_info extends JceStruct {
    public int highFiveNotifyStatus;
    public String nickname;

    public login_uin_info() {
        this.nickname = "";
        this.highFiveNotifyStatus = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nickname = jceInputStream.readString(0, false);
        this.highFiveNotifyStatus = jceInputStream.read(this.highFiveNotifyStatus, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.nickname;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.highFiveNotifyStatus, 1);
    }

    public login_uin_info(String str, int i3) {
        this.nickname = str;
        this.highFiveNotifyStatus = i3;
    }
}

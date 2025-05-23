package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class User extends JceStruct {
    public String nickname;
    public String recomReason;
    public String uid;

    public User() {
        this.uid = "";
        this.nickname = "";
        this.recomReason = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uid = jceInputStream.readString(0, false);
        this.nickname = jceInputStream.readString(1, false);
        this.recomReason = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.uid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.nickname;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.recomReason;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public User(String str, String str2, String str3) {
        this.uid = str;
        this.nickname = str2;
        this.recomReason = str3;
    }
}

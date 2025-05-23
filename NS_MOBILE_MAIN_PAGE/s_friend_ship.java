package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_friend_ship extends JceStruct {
    public int intimacyScore;
    public String url;

    public s_friend_ship() {
        this.url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.intimacyScore = jceInputStream.read(this.intimacyScore, 0, false);
        this.url = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.intimacyScore, 0);
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public s_friend_ship(int i3, String str) {
        this.intimacyScore = i3;
        this.url = str;
    }
}

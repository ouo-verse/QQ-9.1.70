package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PostBarBottom extends JceStruct {
    public String content;
    public String jumpUrl;

    public PostBarBottom() {
        this.content = "";
        this.jumpUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.content = jceInputStream.readString(0, false);
        this.jumpUrl = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.content;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.jumpUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public PostBarBottom(String str, String str2) {
        this.content = str;
        this.jumpUrl = str2;
    }
}

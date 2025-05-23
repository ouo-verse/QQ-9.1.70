package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ButtonInfo extends JceStruct {
    public String iconUrl;
    public String jumpUrl;
    public String words;

    public ButtonInfo() {
        this.words = "";
        this.iconUrl = "";
        this.jumpUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.words = jceInputStream.readString(0, false);
        this.iconUrl = jceInputStream.readString(1, false);
        this.jumpUrl = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.words;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.iconUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.jumpUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public ButtonInfo(String str, String str2, String str3) {
        this.words = str;
        this.iconUrl = str2;
        this.jumpUrl = str3;
    }
}

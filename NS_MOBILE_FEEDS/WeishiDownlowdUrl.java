package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class WeishiDownlowdUrl extends JceStruct {
    public String AndUrl;
    public String IOSUrl;

    public WeishiDownlowdUrl() {
        this.IOSUrl = "";
        this.AndUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.IOSUrl = jceInputStream.readString(0, false);
        this.AndUrl = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.IOSUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.AndUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public WeishiDownlowdUrl(String str, String str2) {
        this.IOSUrl = str;
        this.AndUrl = str2;
    }
}

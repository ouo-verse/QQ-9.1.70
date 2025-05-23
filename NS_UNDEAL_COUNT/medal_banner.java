package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class medal_banner extends JceStruct {
    public String bannerText;
    public int bannerType;
    public String jumpSchema;
    public String jumpUrl;
    public int retcode;

    public medal_banner() {
        this.retcode = -1;
        this.bannerText = "";
        this.jumpSchema = "";
        this.jumpUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.retcode = jceInputStream.read(this.retcode, 0, false);
        this.bannerType = jceInputStream.read(this.bannerType, 1, false);
        this.bannerText = jceInputStream.readString(2, false);
        this.jumpSchema = jceInputStream.readString(3, false);
        this.jumpUrl = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.retcode, 0);
        jceOutputStream.write(this.bannerType, 1);
        String str = this.bannerText;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.jumpSchema;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.jumpUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
    }

    public medal_banner(int i3, int i16, String str, String str2, String str3) {
        this.retcode = i3;
        this.bannerType = i16;
        this.bannerText = str;
        this.jumpSchema = str2;
        this.jumpUrl = str3;
    }
}

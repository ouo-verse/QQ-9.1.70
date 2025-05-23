package NS_MOBILE_WIDGET;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PartnerPlugin extends JceStruct {
    public String gameurl;
    public String iconurl;
    public String text1;
    public String text2;

    public PartnerPlugin() {
        this.gameurl = "";
        this.iconurl = "";
        this.text1 = "";
        this.text2 = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.gameurl = jceInputStream.readString(0, false);
        this.iconurl = jceInputStream.readString(1, false);
        this.text1 = jceInputStream.readString(2, false);
        this.text2 = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.gameurl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.iconurl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.text1;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.text2;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
    }

    public PartnerPlugin(String str, String str2, String str3, String str4) {
        this.gameurl = str;
        this.iconurl = str2;
        this.text1 = str3;
        this.text2 = str4;
    }
}

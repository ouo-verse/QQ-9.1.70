package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class guide_button extends JceStruct {
    public String action_url;
    public String button_title;
    public String pic_url;

    public guide_button() {
        this.button_title = "";
        this.action_url = "";
        this.pic_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.button_title = jceInputStream.readString(0, false);
        this.action_url = jceInputStream.readString(1, false);
        this.pic_url = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.button_title;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.action_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.pic_url;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public guide_button(String str, String str2, String str3) {
        this.button_title = str;
        this.action_url = str2;
        this.pic_url = str3;
    }
}

package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_tail_color extends JceStruct {
    public String background_color;
    public String text_color;
    public String token;

    public s_tail_color() {
        this.token = "";
        this.text_color = "";
        this.background_color = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.token = jceInputStream.readString(0, false);
        this.text_color = jceInputStream.readString(1, false);
        this.background_color = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.token;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.text_color;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.background_color;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public s_tail_color(String str, String str2, String str3) {
        this.token = str;
        this.text_color = str2;
        this.background_color = str3;
    }
}

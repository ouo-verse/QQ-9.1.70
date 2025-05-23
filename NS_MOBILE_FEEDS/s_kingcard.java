package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_kingcard extends JceStruct {
    public String button_title;
    public boolean is_guide;
    public String jump_url;

    public s_kingcard() {
        this.is_guide = false;
        this.button_title = "";
        this.jump_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.is_guide = jceInputStream.read(this.is_guide, 0, false);
        this.button_title = jceInputStream.readString(1, false);
        this.jump_url = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.is_guide, 0);
        String str = this.button_title;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.jump_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public s_kingcard(boolean z16, String str, String str2) {
        this.is_guide = z16;
        this.button_title = str;
        this.jump_url = str2;
    }
}

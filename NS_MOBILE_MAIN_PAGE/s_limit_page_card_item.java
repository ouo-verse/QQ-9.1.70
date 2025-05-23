package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_limit_page_card_item extends JceStruct {
    public String img;
    public String text;

    public s_limit_page_card_item() {
        this.img = "";
        this.text = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.img = jceInputStream.readString(0, true);
        this.text = jceInputStream.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.img, 0);
        jceOutputStream.write(this.text, 1);
    }

    public s_limit_page_card_item(String str, String str2) {
        this.img = str;
        this.text = str2;
    }
}

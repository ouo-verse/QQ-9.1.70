package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_urge_publish_info extends JceStruct {
    public String button_click_toast;
    public String button_text;
    public boolean show_urge_publish_button;

    public s_urge_publish_info() {
        this.show_urge_publish_button = false;
        this.button_text = "";
        this.button_click_toast = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.show_urge_publish_button = jceInputStream.read(this.show_urge_publish_button, 0, false);
        this.button_text = jceInputStream.readString(1, false);
        this.button_click_toast = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.show_urge_publish_button, 0);
        String str = this.button_text;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.button_click_toast;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public s_urge_publish_info(boolean z16, String str, String str2) {
        this.show_urge_publish_button = z16;
        this.button_text = str;
        this.button_click_toast = str2;
    }
}

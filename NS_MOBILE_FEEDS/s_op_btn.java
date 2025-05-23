package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_op_btn extends JceStruct {
    public int btn_actiontype;
    public int btn_color;
    public String btn_title;
    public String btn_url;

    public s_op_btn() {
        this.btn_title = "";
        this.btn_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.btn_title = jceInputStream.readString(0, false);
        this.btn_color = jceInputStream.read(this.btn_color, 1, false);
        this.btn_actiontype = jceInputStream.read(this.btn_actiontype, 2, false);
        this.btn_url = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.btn_title;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.btn_color, 1);
        jceOutputStream.write(this.btn_actiontype, 2);
        String str2 = this.btn_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public s_op_btn(String str, int i3, int i16, String str2) {
        this.btn_title = str;
        this.btn_color = i3;
        this.btn_actiontype = i16;
        this.btn_url = str2;
    }
}

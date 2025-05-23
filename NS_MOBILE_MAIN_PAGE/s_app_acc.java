package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_app_acc extends JceStruct {
    public String name;
    public String url;

    public s_app_acc() {
        this.name = "";
        this.url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.name = jceInputStream.readString(0, false);
        this.url = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.name;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.url;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public s_app_acc(String str, String str2) {
        this.name = str;
        this.url = str2;
    }
}

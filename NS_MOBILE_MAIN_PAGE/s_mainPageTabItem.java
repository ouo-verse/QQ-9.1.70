package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class s_mainPageTabItem extends JceStruct {
    public String content;
    public String icon;
    public String jumpUrl;
    public int order;

    public s_mainPageTabItem() {
        this.icon = "";
        this.content = "";
        this.jumpUrl = "";
        this.order = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.icon = jceInputStream.readString(0, false);
        this.content = jceInputStream.readString(1, false);
        this.jumpUrl = jceInputStream.readString(2, false);
        this.order = jceInputStream.read(this.order, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.icon;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.content;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.jumpUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.order, 3);
    }

    public s_mainPageTabItem(String str, String str2, String str3, int i3) {
        this.icon = str;
        this.content = str2;
        this.jumpUrl = str3;
        this.order = i3;
    }
}

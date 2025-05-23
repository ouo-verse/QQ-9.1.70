package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MenumItem extends JceStruct {
    public String icon;
    public int item_id;
    public String jumpurl;
    public String jumpurl_tab_expid;
    public String title;
    public int user_group;

    public MenumItem() {
        this.item_id = 0;
        this.icon = "";
        this.title = "";
        this.jumpurl = "";
        this.user_group = 0;
        this.jumpurl_tab_expid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.item_id = jceInputStream.read(this.item_id, 0, false);
        this.icon = jceInputStream.readString(1, false);
        this.title = jceInputStream.readString(2, false);
        this.jumpurl = jceInputStream.readString(4, false);
        this.user_group = jceInputStream.read(this.user_group, 5, false);
        this.jumpurl_tab_expid = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.item_id, 0);
        String str = this.icon;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.title;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.jumpurl;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        jceOutputStream.write(this.user_group, 5);
        String str4 = this.jumpurl_tab_expid;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
    }

    public MenumItem(int i3, String str, String str2, String str3, int i16, String str4) {
        this.item_id = i3;
        this.icon = str;
        this.title = str2;
        this.jumpurl = str3;
        this.user_group = i16;
        this.jumpurl_tab_expid = str4;
    }
}

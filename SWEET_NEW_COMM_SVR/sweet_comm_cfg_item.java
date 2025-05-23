package SWEET_NEW_COMM_SVR;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class sweet_comm_cfg_item extends JceStruct {
    public String cmd;
    public String dynamic_value;
    public String icon;
    public String title;
    public String url;
    public String wording;

    public sweet_comm_cfg_item() {
        this.cmd = "";
        this.dynamic_value = "";
        this.wording = "";
        this.url = "";
        this.icon = "";
        this.title = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cmd = jceInputStream.readString(0, true);
        this.dynamic_value = jceInputStream.readString(1, true);
        this.wording = jceInputStream.readString(2, true);
        this.url = jceInputStream.readString(3, true);
        this.icon = jceInputStream.readString(4, true);
        this.title = jceInputStream.readString(5, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cmd, 0);
        jceOutputStream.write(this.dynamic_value, 1);
        jceOutputStream.write(this.wording, 2);
        jceOutputStream.write(this.url, 3);
        jceOutputStream.write(this.icon, 4);
        jceOutputStream.write(this.title, 5);
    }

    public sweet_comm_cfg_item(String str, String str2, String str3, String str4, String str5, String str6) {
        this.cmd = str;
        this.dynamic_value = str2;
        this.wording = str3;
        this.url = str4;
        this.icon = str5;
        this.title = str6;
    }
}

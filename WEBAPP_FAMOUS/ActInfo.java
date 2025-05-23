package WEBAPP_FAMOUS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ActInfo extends JceStruct {
    public String act_icon;
    public String act_name;
    public String act_url;

    public ActInfo() {
        this.act_name = "";
        this.act_url = "";
        this.act_icon = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.act_name = jceInputStream.readString(0, false);
        this.act_url = jceInputStream.readString(1, false);
        this.act_icon = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.act_name;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.act_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.act_icon;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public ActInfo(String str, String str2, String str3) {
        this.act_name = str;
        this.act_url = str2;
        this.act_icon = str3;
    }
}

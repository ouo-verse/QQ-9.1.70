package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_videoremark extends JceStruct {
    public int actiontype;
    public String actionurl;
    public String icondesc;
    public String iconurl;
    public int orgwebsite;
    public String remark;

    public s_videoremark() {
        this.iconurl = "";
        this.icondesc = "";
        this.remark = "";
        this.actionurl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iconurl = jceInputStream.readString(0, false);
        this.icondesc = jceInputStream.readString(1, false);
        this.remark = jceInputStream.readString(2, false);
        this.actiontype = jceInputStream.read(this.actiontype, 3, false);
        this.actionurl = jceInputStream.readString(4, false);
        this.orgwebsite = jceInputStream.read(this.orgwebsite, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.iconurl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.icondesc;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.remark;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.actiontype, 3);
        String str4 = this.actionurl;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        jceOutputStream.write(this.orgwebsite, 5);
    }

    public s_videoremark(String str, String str2, String str3, int i3, String str4, int i16) {
        this.iconurl = str;
        this.icondesc = str2;
        this.remark = str3;
        this.actiontype = i3;
        this.actionurl = str4;
        this.orgwebsite = i16;
    }
}

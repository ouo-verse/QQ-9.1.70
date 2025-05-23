package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_red_info extends JceStruct {
    public String desc;
    public String logo;
    public String summary;
    public long uIsNew;
    public long uin;

    public s_red_info() {
        this.logo = "";
        this.summary = "";
        this.desc = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.logo = jceInputStream.readString(0, false);
        this.summary = jceInputStream.readString(1, false);
        this.desc = jceInputStream.readString(2, false);
        this.uIsNew = jceInputStream.read(this.uIsNew, 3, false);
        this.uin = jceInputStream.read(this.uin, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.logo;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.summary;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.desc;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.uIsNew, 3);
        jceOutputStream.write(this.uin, 4);
    }

    public s_red_info(String str, String str2, String str3, long j3, long j16) {
        this.logo = str;
        this.summary = str2;
        this.desc = str3;
        this.uIsNew = j3;
        this.uin = j16;
    }
}

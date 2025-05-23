package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_address extends JceStruct {
    public String cityid;
    public String countryid;
    public String provinceid;

    public s_address() {
        this.countryid = "";
        this.provinceid = "";
        this.cityid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.countryid = jceInputStream.readString(0, false);
        this.provinceid = jceInputStream.readString(1, false);
        this.cityid = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.countryid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.provinceid;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.cityid;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public s_address(String str, String str2, String str3) {
        this.countryid = str;
        this.provinceid = str2;
        this.cityid = str3;
    }
}

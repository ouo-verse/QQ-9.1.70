package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stMetaAddr extends JceStruct {
    public String city;
    public String country;
    public String province;

    public stMetaAddr() {
        this.country = "";
        this.province = "";
        this.city = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.country = jceInputStream.readString(0, false);
        this.province = jceInputStream.readString(1, false);
        this.city = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.country;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.province;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.city;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public stMetaAddr(String str, String str2, String str3) {
        this.country = str;
        this.province = str2;
        this.city = str3;
    }
}

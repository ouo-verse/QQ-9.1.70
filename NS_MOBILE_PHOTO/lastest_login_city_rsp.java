package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class lastest_login_city_rsp extends JceStruct {
    public String city_name;

    public lastest_login_city_rsp() {
        this.city_name = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.city_name = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.city_name;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public lastest_login_city_rsp(String str) {
        this.city_name = str;
    }
}

package camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MetaAuthInfo extends JceStruct {
    public String appid;
    public String encyptedStr;

    public MetaAuthInfo() {
        this.appid = "";
        this.encyptedStr = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.readString(0, false);
        this.encyptedStr = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.appid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.encyptedStr;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public MetaAuthInfo(String str, String str2) {
        this.appid = str;
        this.encyptedStr = str2;
    }
}

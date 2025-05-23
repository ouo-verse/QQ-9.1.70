package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stWMDBAndroidPushReq extends JceStruct {
    public String city;
    public String province;
    public int pushVersion;
    public int richFlagMask;

    public stWMDBAndroidPushReq() {
        this.pushVersion = 0;
        this.richFlagMask = 1;
        this.province = "";
        this.city = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.pushVersion = jceInputStream.read(this.pushVersion, 0, true);
        this.richFlagMask = jceInputStream.read(this.richFlagMask, 1, true);
        this.province = jceInputStream.readString(2, false);
        this.city = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.pushVersion, 0);
        jceOutputStream.write(this.richFlagMask, 1);
        String str = this.province;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.city;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public stWMDBAndroidPushReq(int i3, int i16, String str, String str2) {
        this.pushVersion = i3;
        this.richFlagMask = i16;
        this.province = str;
        this.city = str2;
    }
}

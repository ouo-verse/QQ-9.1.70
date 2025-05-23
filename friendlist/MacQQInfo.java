package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class MacQQInfo extends JceStruct {
    public String deviceName;
    public String guid;
    public String operatingSystem;

    public MacQQInfo() {
        this.guid = "";
        this.deviceName = "";
        this.operatingSystem = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.guid = jceInputStream.readString(0, false);
        this.deviceName = jceInputStream.readString(1, false);
        this.operatingSystem = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.guid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.deviceName;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.operatingSystem;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public MacQQInfo(String str, String str2, String str3) {
        this.guid = str;
        this.deviceName = str2;
        this.operatingSystem = str3;
    }
}

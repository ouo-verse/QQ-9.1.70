package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AcsHead extends JceStruct {
    public String model;
    public String platform;
    public String version;

    public AcsHead() {
        this.version = "";
        this.platform = "";
        this.model = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.version = jceInputStream.readString(0, false);
        this.platform = jceInputStream.readString(1, false);
        this.model = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.version;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.platform;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.model;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public AcsHead(String str, String str2, String str3) {
        this.version = str;
        this.platform = str2;
        this.model = str3;
    }
}

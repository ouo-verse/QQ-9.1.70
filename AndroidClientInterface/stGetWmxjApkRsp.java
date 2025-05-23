package AndroidClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetWmxjApkRsp extends JceStruct {
    public String apkUrl;
    public int apkVersion;

    public stGetWmxjApkRsp() {
        this.apkUrl = "";
        this.apkVersion = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.apkUrl = jceInputStream.readString(0, true);
        this.apkVersion = jceInputStream.read(this.apkVersion, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.apkUrl, 0);
        jceOutputStream.write(this.apkVersion, 1);
    }

    public stGetWmxjApkRsp(String str, int i3) {
        this.apkUrl = str;
        this.apkVersion = i3;
    }
}

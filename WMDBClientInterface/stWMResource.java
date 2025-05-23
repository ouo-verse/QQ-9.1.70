package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stWMResource extends JceStruct {
    public boolean isEncrypted;
    public int version;
    public String wmId;
    public String xmlResUrl;

    public stWMResource() {
        this.wmId = "";
        this.isEncrypted = true;
        this.version = 1;
        this.xmlResUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.wmId = jceInputStream.readString(0, true);
        this.isEncrypted = jceInputStream.read(this.isEncrypted, 1, true);
        this.version = jceInputStream.read(this.version, 2, true);
        this.xmlResUrl = jceInputStream.readString(3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.wmId, 0);
        jceOutputStream.write(this.isEncrypted, 1);
        jceOutputStream.write(this.version, 2);
        jceOutputStream.write(this.xmlResUrl, 3);
    }

    public stWMResource(String str, boolean z16, int i3, String str2) {
        this.wmId = str;
        this.isEncrypted = z16;
        this.version = i3;
        this.xmlResUrl = str2;
    }
}

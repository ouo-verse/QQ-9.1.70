package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetChangeFlagReq extends JceStruct {
    public int changeVersion;

    public stGetChangeFlagReq() {
        this.changeVersion = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.changeVersion = jceInputStream.read(this.changeVersion, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.changeVersion, 0);
    }

    public stGetChangeFlagReq(int i3) {
        this.changeVersion = i3;
    }
}

package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetChangeFlagRsp extends JceStruct {
    public int changeFlag;
    public int curChangeVersion;

    public stGetChangeFlagRsp() {
        this.changeFlag = 0;
        this.curChangeVersion = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.changeFlag = jceInputStream.read(this.changeFlag, 0, true);
        this.curChangeVersion = jceInputStream.read(this.curChangeVersion, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.changeFlag, 0);
        jceOutputStream.write(this.curChangeVersion, 1);
    }

    public stGetChangeFlagRsp(int i3, int i16) {
        this.changeFlag = i3;
        this.curChangeVersion = i16;
    }
}

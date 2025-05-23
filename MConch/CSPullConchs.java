package MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class CSPullConchs extends JceStruct {
    public int reserved = 0;
    public int cmdId = 0;
    public int busiType = 0;

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new CSPullConchs();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.reserved = jceInputStream.read(this.reserved, 0, false);
        this.cmdId = jceInputStream.read(this.cmdId, 1, false);
        this.busiType = jceInputStream.read(this.busiType, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        int i3 = this.reserved;
        if (i3 != 0) {
            jceOutputStream.write(i3, 0);
        }
        int i16 = this.cmdId;
        if (i16 != 0) {
            jceOutputStream.write(i16, 1);
        }
        int i17 = this.busiType;
        if (i17 != 0) {
            jceOutputStream.write(i17, 2);
        }
    }
}

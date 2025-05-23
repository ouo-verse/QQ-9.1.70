package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class DelGroup extends JceStruct {
    public byte cGroupId;

    public DelGroup() {
        this.cGroupId = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cGroupId = jceInputStream.read(this.cGroupId, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cGroupId, 0);
    }

    public DelGroup(byte b16) {
        this.cGroupId = b16;
    }
}

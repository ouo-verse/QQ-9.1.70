package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class RenameGroup extends JceStruct {
    public byte cGroupId;
    public byte cLen;
    public String sGroupName;

    public RenameGroup() {
        this.cGroupId = (byte) 0;
        this.cLen = (byte) 0;
        this.sGroupName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cGroupId = jceInputStream.read(this.cGroupId, 0, true);
        this.cLen = jceInputStream.read(this.cLen, 1, true);
        this.sGroupName = jceInputStream.readString(2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cGroupId, 0);
        jceOutputStream.write(this.cLen, 1);
        jceOutputStream.write(this.sGroupName, 2);
    }

    public RenameGroup(byte b16, byte b17, String str) {
        this.cGroupId = b16;
        this.cLen = b17;
        this.sGroupName = str;
    }
}

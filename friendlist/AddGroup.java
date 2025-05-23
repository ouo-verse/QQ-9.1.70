package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class AddGroup extends JceStruct {
    public byte cLen;
    public byte cSortId;
    public String sGroupName;

    public AddGroup() {
        this.cSortId = (byte) 0;
        this.cLen = (byte) 0;
        this.sGroupName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cSortId = jceInputStream.read(this.cSortId, 0, true);
        this.cLen = jceInputStream.read(this.cLen, 1, true);
        this.sGroupName = jceInputStream.readString(2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cSortId, 0);
        jceOutputStream.write(this.cLen, 1);
        jceOutputStream.write(this.sGroupName, 2);
    }

    public AddGroup(byte b16, byte b17, String str) {
        this.cSortId = b16;
        this.cLen = b17;
        this.sGroupName = str;
    }
}

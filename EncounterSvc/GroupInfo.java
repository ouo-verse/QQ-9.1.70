package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GroupInfo extends JceStruct {
    public byte cGroupId;
    public String strGroupName;

    public GroupInfo() {
        this.cGroupId = (byte) 0;
        this.strGroupName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cGroupId = jceInputStream.read(this.cGroupId, 0, true);
        this.strGroupName = jceInputStream.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cGroupId, 0);
        jceOutputStream.write(this.strGroupName, 1);
    }

    public GroupInfo(byte b16, String str) {
        this.cGroupId = b16;
        this.strGroupName = str;
    }
}

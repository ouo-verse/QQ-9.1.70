package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ModGroupName extends JceStruct {
    public long dwGroupID;
    public String strGroupName;

    public ModGroupName() {
        this.dwGroupID = 0L;
        this.strGroupName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwGroupID = jceInputStream.read(this.dwGroupID, 0, false);
        this.strGroupName = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwGroupID, 0);
        String str = this.strGroupName;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public ModGroupName(long j3, String str) {
        this.dwGroupID = j3;
        this.strGroupName = str;
    }
}

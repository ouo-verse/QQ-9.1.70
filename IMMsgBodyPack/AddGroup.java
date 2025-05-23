package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AddGroup extends JceStruct {
    public long dwGroupID;
    public long dwSortID;
    public String strGroupName;

    public AddGroup() {
        this.dwGroupID = 0L;
        this.dwSortID = 0L;
        this.strGroupName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwGroupID = jceInputStream.read(this.dwGroupID, 0, false);
        this.dwSortID = jceInputStream.read(this.dwSortID, 1, false);
        this.strGroupName = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwGroupID, 0);
        jceOutputStream.write(this.dwSortID, 1);
        String str = this.strGroupName;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public AddGroup(long j3, long j16, String str) {
        this.dwGroupID = j3;
        this.dwSortID = j16;
        this.strGroupName = str;
    }
}

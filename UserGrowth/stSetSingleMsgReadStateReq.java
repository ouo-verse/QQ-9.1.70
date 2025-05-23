package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stSetSingleMsgReadStateReq extends JceStruct {
    public int subjectID;
    public String userMsgID;

    public stSetSingleMsgReadStateReq() {
        this.subjectID = 0;
        this.userMsgID = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.subjectID = jceInputStream.read(this.subjectID, 0, false);
        this.userMsgID = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.subjectID, 0);
        String str = this.userMsgID;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public stSetSingleMsgReadStateReq(int i3, String str) {
        this.subjectID = i3;
        this.userMsgID = str;
    }
}

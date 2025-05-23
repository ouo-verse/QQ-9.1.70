package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetSubjectMsgDetailReq extends JceStruct {
    public String attachInfo;
    public int subjectID;

    public stGetSubjectMsgDetailReq() {
        this.attachInfo = "";
        this.subjectID = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.attachInfo = jceInputStream.readString(0, false);
        this.subjectID = jceInputStream.read(this.subjectID, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.attachInfo;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.subjectID, 1);
    }

    public stGetSubjectMsgDetailReq(String str, int i3) {
        this.attachInfo = str;
        this.subjectID = i3;
    }
}

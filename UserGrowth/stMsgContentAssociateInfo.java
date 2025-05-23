package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stMsgContentAssociateInfo extends JceStruct {
    public int assocateType;
    public String commentID;
    public String replyID;

    public stMsgContentAssociateInfo() {
        this.assocateType = 0;
        this.commentID = "";
        this.replyID = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.assocateType = jceInputStream.read(this.assocateType, 0, false);
        this.commentID = jceInputStream.readString(1, false);
        this.replyID = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.assocateType, 0);
        String str = this.commentID;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.replyID;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public stMsgContentAssociateInfo(int i3, String str, String str2) {
        this.assocateType = i3;
        this.commentID = str;
        this.replyID = str2;
    }
}

package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetSimpleCommentListReq extends JceStruct {
    public String attachInfo;
    public String feedID;

    public stGetSimpleCommentListReq() {
        this.attachInfo = "";
        this.feedID = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.attachInfo = jceInputStream.readString(0, true);
        this.feedID = jceInputStream.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.attachInfo, 0);
        jceOutputStream.write(this.feedID, 1);
    }

    public stGetSimpleCommentListReq(String str, String str2) {
        this.attachInfo = str;
        this.feedID = str2;
    }
}

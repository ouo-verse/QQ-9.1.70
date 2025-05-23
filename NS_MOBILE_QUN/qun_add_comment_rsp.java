package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class qun_add_comment_rsp extends JceStruct {
    public String commentid;
    public String verifyurl;

    public qun_add_comment_rsp() {
        this.verifyurl = "";
        this.commentid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.verifyurl = jceInputStream.readString(0, false);
        this.commentid = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.verifyurl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.commentid;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public qun_add_comment_rsp(String str, String str2) {
        this.verifyurl = str;
        this.commentid = str2;
    }
}

package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CommentInfo extends JceStruct {
    public String jumpUrlToDetail;
    public int totalComment;

    public CommentInfo() {
        this.totalComment = 0;
        this.jumpUrlToDetail = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.totalComment = jceInputStream.read(this.totalComment, 0, false);
        this.jumpUrlToDetail = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.totalComment, 0);
        String str = this.jumpUrlToDetail;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public CommentInfo(int i3, String str) {
        this.totalComment = i3;
        this.jumpUrlToDetail = str;
    }
}

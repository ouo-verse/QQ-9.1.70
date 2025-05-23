package NS_CLIENT_SHOW_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public class CommentQzmallDeco extends JceStruct {
    static QzmallCommentBadge cache_stBubble = new QzmallCommentBadge();
    public QzmallCommentBadge badge;

    public CommentQzmallDeco() {
        this.badge = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.badge = (QzmallCommentBadge) jceInputStream.read((JceStruct) cache_stBubble, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        QzmallCommentBadge qzmallCommentBadge = this.badge;
        if (qzmallCommentBadge != null) {
            jceOutputStream.write((JceStruct) qzmallCommentBadge, 0);
        }
    }

    public CommentQzmallDeco(QzmallCommentBadge qzmallCommentBadge) {
        this.badge = qzmallCommentBadge;
    }
}

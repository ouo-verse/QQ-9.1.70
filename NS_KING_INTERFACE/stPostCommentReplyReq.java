package NS_KING_INTERFACE;

import NS_KING_SOCIALIZE_META.stMetaReply;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stPostCommentReplyReq extends JceStruct {
    static stMetaReply cache_reply = new stMetaReply();
    public String commentId;
    public String feed_id;
    public stMetaReply reply;

    public stPostCommentReplyReq() {
        this.feed_id = "";
        this.commentId = "";
        this.reply = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.feed_id = jceInputStream.readString(0, false);
        this.commentId = jceInputStream.readString(1, false);
        this.reply = (stMetaReply) jceInputStream.read((JceStruct) cache_reply, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.feed_id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.commentId;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        stMetaReply stmetareply = this.reply;
        if (stmetareply != null) {
            jceOutputStream.write((JceStruct) stmetareply, 2);
        }
    }

    public stPostCommentReplyReq(String str, String str2, stMetaReply stmetareply) {
        this.feed_id = str;
        this.commentId = str2;
        this.reply = stmetareply;
    }
}

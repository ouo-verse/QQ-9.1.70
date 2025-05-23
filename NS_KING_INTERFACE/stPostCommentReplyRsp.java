package NS_KING_INTERFACE;

import NS_KING_SOCIALIZE_META.stMetaReply;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stPostCommentReplyRsp extends JceStruct {
    static stMetaReply cache_reply = new stMetaReply();
    public stMetaReply reply;

    public stPostCommentReplyRsp() {
        this.reply = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.reply = (stMetaReply) jceInputStream.read((JceStruct) cache_reply, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stMetaReply stmetareply = this.reply;
        if (stmetareply != null) {
            jceOutputStream.write((JceStruct) stmetareply, 0);
        }
    }

    public stPostCommentReplyRsp(stMetaReply stmetareply) {
        this.reply = stmetareply;
    }
}

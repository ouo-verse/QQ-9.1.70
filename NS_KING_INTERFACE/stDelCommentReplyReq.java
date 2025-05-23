package NS_KING_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stDelCommentReplyReq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public String commentId;
    public String feed_id;
    public String replyId;

    public stDelCommentReplyReq() {
        this.feed_id = "";
        this.commentId = "";
        this.replyId = "";
    }

    public String className() {
        return "NS_KING_INTERFACE.stDelCommentReplyReq";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.feed_id, "feed_id");
        jceDisplayer.display(this.commentId, WSAutoShowCommentParams.KEY_COMMENT_ID);
        jceDisplayer.display(this.replyId, WSAutoShowCommentParams.KEY_REPLY_ID);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.feed_id, true);
        jceDisplayer.displaySimple(this.commentId, true);
        jceDisplayer.displaySimple(this.replyId, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        stDelCommentReplyReq stdelcommentreplyreq = (stDelCommentReplyReq) obj;
        if (!JceUtil.equals(this.feed_id, stdelcommentreplyreq.feed_id) || !JceUtil.equals(this.commentId, stdelcommentreplyreq.commentId) || !JceUtil.equals(this.replyId, stdelcommentreplyreq.replyId)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "NS_KING_INTERFACE.stDelCommentReplyReq";
    }

    public String getCommentId() {
        return this.commentId;
    }

    public String getFeed_id() {
        return this.feed_id;
    }

    public String getReplyId() {
        return this.replyId;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.feed_id = jceInputStream.readString(0, false);
        this.commentId = jceInputStream.readString(1, false);
        this.replyId = jceInputStream.readString(2, false);
    }

    public void setCommentId(String str) {
        this.commentId = str;
    }

    public void setFeed_id(String str) {
        this.feed_id = str;
    }

    public void setReplyId(String str) {
        this.replyId = str;
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
        String str3 = this.replyId;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public stDelCommentReplyReq(String str, String str2) {
        this.replyId = "";
        this.feed_id = str;
        this.commentId = str2;
    }

    public stDelCommentReplyReq(String str, String str2, String str3) {
        this.feed_id = str;
        this.commentId = str2;
        this.replyId = str3;
    }
}

package NS_KING_INTERFACE;

import NS_KING_SOCIALIZE_META.stMetaComment;
import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stDeleteFeedCommentReq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static stMetaComment cache_comment = new stMetaComment();
    public stMetaComment comment;
    public String feed_id;

    public stDeleteFeedCommentReq() {
        this.feed_id = "";
        this.comment = null;
    }

    public String className() {
        return "NS_KING_INTERFACE.stDeleteFeedCommentReq";
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
        jceDisplayer.display((JceStruct) this.comment, "comment");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.feed_id, true);
        jceDisplayer.displaySimple((JceStruct) this.comment, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        stDeleteFeedCommentReq stdeletefeedcommentreq = (stDeleteFeedCommentReq) obj;
        if (!JceUtil.equals(this.feed_id, stdeletefeedcommentreq.feed_id) || !JceUtil.equals(this.comment, stdeletefeedcommentreq.comment)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "NS_KING_INTERFACE.stDeleteFeedCommentReq";
    }

    public stMetaComment getComment() {
        return this.comment;
    }

    public String getFeed_id() {
        return this.feed_id;
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
        this.feed_id = jceInputStream.readString(0, true);
        this.comment = (stMetaComment) jceInputStream.read((JceStruct) cache_comment, 1, true);
    }

    public void setComment(stMetaComment stmetacomment) {
        this.comment = stmetacomment;
    }

    public void setFeed_id(String str) {
        this.feed_id = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.feed_id, 0);
        jceOutputStream.write((JceStruct) this.comment, 1);
    }

    public stDeleteFeedCommentReq(String str, stMetaComment stmetacomment) {
        this.feed_id = str;
        this.comment = stmetacomment;
    }
}

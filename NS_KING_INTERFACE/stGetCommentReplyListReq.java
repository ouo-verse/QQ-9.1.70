package NS_KING_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetCommentReplyListReq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public String attach_info;
    public String commentId;
    public int direction;
    public String feed_id;

    public stGetCommentReplyListReq() {
        this.attach_info = "";
        this.feed_id = "";
        this.commentId = "";
        this.direction = 0;
    }

    public String className() {
        return "NS_KING_INTERFACE.stGetCommentReplyListReq";
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
        jceDisplayer.display(this.attach_info, "attach_info");
        jceDisplayer.display(this.feed_id, "feed_id");
        jceDisplayer.display(this.commentId, WSAutoShowCommentParams.KEY_COMMENT_ID);
        jceDisplayer.display(this.direction, "direction");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.attach_info, true);
        jceDisplayer.displaySimple(this.feed_id, true);
        jceDisplayer.displaySimple(this.commentId, true);
        jceDisplayer.displaySimple(this.direction, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        stGetCommentReplyListReq stgetcommentreplylistreq = (stGetCommentReplyListReq) obj;
        if (!JceUtil.equals(this.attach_info, stgetcommentreplylistreq.attach_info) || !JceUtil.equals(this.feed_id, stgetcommentreplylistreq.feed_id) || !JceUtil.equals(this.commentId, stgetcommentreplylistreq.commentId) || !JceUtil.equals(this.direction, stgetcommentreplylistreq.direction)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "NS_KING_INTERFACE.stGetCommentReplyListReq";
    }

    public String getAttach_info() {
        return this.attach_info;
    }

    public String getCommentId() {
        return this.commentId;
    }

    public int getDirection() {
        return this.direction;
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
        this.attach_info = jceInputStream.readString(0, true);
        this.feed_id = jceInputStream.readString(1, true);
        this.commentId = jceInputStream.readString(2, true);
        this.direction = jceInputStream.read(this.direction, 3, false);
    }

    public void setAttach_info(String str) {
        this.attach_info = str;
    }

    public void setCommentId(String str) {
        this.commentId = str;
    }

    public void setDirection(int i3) {
        this.direction = i3;
    }

    public void setFeed_id(String str) {
        this.feed_id = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.attach_info, 0);
        jceOutputStream.write(this.feed_id, 1);
        jceOutputStream.write(this.commentId, 2);
        jceOutputStream.write(this.direction, 3);
    }

    public stGetCommentReplyListReq(String str, String str2, String str3, int i3) {
        this.attach_info = str;
        this.feed_id = str2;
        this.commentId = str3;
        this.direction = i3;
    }
}

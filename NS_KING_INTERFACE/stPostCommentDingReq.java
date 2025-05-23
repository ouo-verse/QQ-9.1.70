package NS_KING_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;

/* loaded from: classes.dex */
public final class stPostCommentDingReq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public String commentId;
    public int dingAction;
    public String feed_id;

    public stPostCommentDingReq() {
        this.feed_id = "";
        this.commentId = "";
        this.dingAction = 0;
    }

    public String className() {
        return "NS_KING_INTERFACE.stPostCommentDingReq";
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
        jceDisplayer.display(this.dingAction, "dingAction");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.feed_id, true);
        jceDisplayer.displaySimple(this.commentId, true);
        jceDisplayer.displaySimple(this.dingAction, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        stPostCommentDingReq stpostcommentdingreq = (stPostCommentDingReq) obj;
        if (!JceUtil.equals(this.feed_id, stpostcommentdingreq.feed_id) || !JceUtil.equals(this.commentId, stpostcommentdingreq.commentId) || !JceUtil.equals(this.dingAction, stpostcommentdingreq.dingAction)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "NS_KING_INTERFACE.stPostCommentDingReq";
    }

    public String getCommentId() {
        return this.commentId;
    }

    public int getDingAction() {
        return this.dingAction;
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
        this.feed_id = jceInputStream.readString(0, false);
        this.commentId = jceInputStream.readString(1, false);
        this.dingAction = jceInputStream.read(this.dingAction, 2, false);
    }

    public void setCommentId(String str) {
        this.commentId = str;
    }

    public void setDingAction(int i3) {
        this.dingAction = i3;
    }

    public void setFeed_id(String str) {
        this.feed_id = str;
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
        jceOutputStream.write(this.dingAction, 2);
    }

    public stPostCommentDingReq(String str, String str2, int i3) {
        this.feed_id = str;
        this.commentId = str2;
        this.dingAction = i3;
    }
}

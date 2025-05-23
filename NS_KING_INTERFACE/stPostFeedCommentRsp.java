package NS_KING_INTERFACE;

import NS_KING_SOCIALIZE_META.stMetaComment;
import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* loaded from: classes.dex */
public final class stPostFeedCommentRsp extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static stMetaComment cache_comment = new stMetaComment();
    public stMetaComment comment;
    public int prompt;

    public stPostFeedCommentRsp() {
        this.comment = null;
        this.prompt = 0;
    }

    public String className() {
        return "NS_KING_INTERFACE.stPostFeedCommentRsp";
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
        jceDisplayer.display((JceStruct) this.comment, "comment");
        jceDisplayer.display(this.prompt, "prompt");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple((JceStruct) this.comment, true);
        jceDisplayer.displaySimple(this.prompt, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        stPostFeedCommentRsp stpostfeedcommentrsp = (stPostFeedCommentRsp) obj;
        if (!JceUtil.equals(this.comment, stpostfeedcommentrsp.comment) || !JceUtil.equals(this.prompt, stpostfeedcommentrsp.prompt)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "NS_KING_INTERFACE.stPostFeedCommentRsp";
    }

    public stMetaComment getComment() {
        return this.comment;
    }

    public int getPrompt() {
        return this.prompt;
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
        this.comment = (stMetaComment) jceInputStream.read((JceStruct) cache_comment, 0, true);
        this.prompt = jceInputStream.read(this.prompt, 1, false);
    }

    public void setComment(stMetaComment stmetacomment) {
        this.comment = stmetacomment;
    }

    public void setPrompt(int i3) {
        this.prompt = i3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.comment, 0);
        jceOutputStream.write(this.prompt, 1);
    }

    public stPostFeedCommentRsp(stMetaComment stmetacomment, int i3) {
        this.comment = stmetacomment;
        this.prompt = i3;
    }
}

package NS_KING_INTERFACE;

import NS_KING_SOCIALIZE_META.stMetaComment;
import NS_KING_SOCIALIZE_META.stMetaReportDataItem;
import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class stPostFeedCommentReq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static stMetaComment cache_comment = new stMetaComment();
    static ArrayList<stMetaReportDataItem> cache_data = new ArrayList<>();
    public stMetaComment comment;
    public ArrayList<stMetaReportDataItem> data;
    public String feed_id;
    public int hadMancheked;

    static {
        cache_data.add(new stMetaReportDataItem());
    }

    public stPostFeedCommentReq() {
        this.feed_id = "";
        this.comment = null;
        this.data = null;
        this.hadMancheked = 0;
    }

    public String className() {
        return "NS_KING_INTERFACE.stPostFeedCommentReq";
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
        jceDisplayer.display((Collection) this.data, "data");
        jceDisplayer.display(this.hadMancheked, "hadMancheked");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.feed_id, true);
        jceDisplayer.displaySimple((JceStruct) this.comment, true);
        jceDisplayer.displaySimple((Collection) this.data, true);
        jceDisplayer.displaySimple(this.hadMancheked, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        stPostFeedCommentReq stpostfeedcommentreq = (stPostFeedCommentReq) obj;
        if (!JceUtil.equals(this.feed_id, stpostfeedcommentreq.feed_id) || !JceUtil.equals(this.comment, stpostfeedcommentreq.comment) || !JceUtil.equals(this.data, stpostfeedcommentreq.data) || !JceUtil.equals(this.hadMancheked, stpostfeedcommentreq.hadMancheked)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "NS_KING_INTERFACE.stPostFeedCommentReq";
    }

    public stMetaComment getComment() {
        return this.comment;
    }

    public ArrayList<stMetaReportDataItem> getData() {
        return this.data;
    }

    public String getFeed_id() {
        return this.feed_id;
    }

    public int getHadMancheked() {
        return this.hadMancheked;
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
        this.data = (ArrayList) jceInputStream.read((JceInputStream) cache_data, 2, false);
        this.hadMancheked = jceInputStream.read(this.hadMancheked, 3, false);
    }

    public void setComment(stMetaComment stmetacomment) {
        this.comment = stmetacomment;
    }

    public void setData(ArrayList<stMetaReportDataItem> arrayList) {
        this.data = arrayList;
    }

    public void setFeed_id(String str) {
        this.feed_id = str;
    }

    public void setHadMancheked(int i3) {
        this.hadMancheked = i3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.feed_id, 0);
        jceOutputStream.write((JceStruct) this.comment, 1);
        ArrayList<stMetaReportDataItem> arrayList = this.data;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.hadMancheked, 3);
    }

    public stPostFeedCommentReq(String str, stMetaComment stmetacomment) {
        this.data = null;
        this.hadMancheked = 0;
        this.feed_id = str;
        this.comment = stmetacomment;
    }

    public stPostFeedCommentReq(String str, stMetaComment stmetacomment, ArrayList<stMetaReportDataItem> arrayList, int i3) {
        this.feed_id = str;
        this.comment = stmetacomment;
        this.data = arrayList;
        this.hadMancheked = i3;
    }
}

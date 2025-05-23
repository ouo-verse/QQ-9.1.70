package NS_KING_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetFeedCommentListV2Req extends JceStruct {
    public String attach_info;
    public String commentId;
    public String contextCommentID;
    public String contextReplyID;
    public String feed_id;
    public int getRepyListByPage;
    public int isFirst;
    public String replyId;
    public int reqFrom;

    public stGetFeedCommentListV2Req() {
        this.attach_info = "";
        this.feed_id = "";
        this.commentId = "";
        this.reqFrom = 0;
        this.replyId = "";
        this.getRepyListByPage = 0;
        this.contextCommentID = "";
        this.contextReplyID = "";
        this.isFirst = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.attach_info = jceInputStream.readString(0, true);
        this.feed_id = jceInputStream.readString(1, true);
        this.commentId = jceInputStream.readString(2, false);
        this.reqFrom = jceInputStream.read(this.reqFrom, 3, false);
        this.replyId = jceInputStream.readString(4, false);
        this.getRepyListByPage = jceInputStream.read(this.getRepyListByPage, 5, false);
        this.contextCommentID = jceInputStream.readString(6, false);
        this.contextReplyID = jceInputStream.readString(7, false);
        this.isFirst = jceInputStream.read(this.isFirst, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.attach_info, 0);
        jceOutputStream.write(this.feed_id, 1);
        String str = this.commentId;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.reqFrom, 3);
        String str2 = this.replyId;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.getRepyListByPage, 5);
        String str3 = this.contextCommentID;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        String str4 = this.contextReplyID;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        jceOutputStream.write(this.isFirst, 8);
    }

    public stGetFeedCommentListV2Req(String str, String str2, String str3, int i3, String str4, int i16, String str5, String str6, int i17) {
        this.attach_info = str;
        this.feed_id = str2;
        this.commentId = str3;
        this.reqFrom = i3;
        this.replyId = str4;
        this.getRepyListByPage = i16;
        this.contextCommentID = str5;
        this.contextReplyID = str6;
        this.isFirst = i17;
    }
}

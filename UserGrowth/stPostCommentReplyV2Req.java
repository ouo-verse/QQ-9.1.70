package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class stPostCommentReplyV2Req extends JceStruct {
    static ArrayList<String> cache_atUserQQ;
    static stSimpleMetaReply cache_reply = new stSimpleMetaReply();
    public ArrayList<String> atUserQQ;
    public String commentId;
    public String feed_id;
    public stSimpleMetaReply reply;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_atUserQQ = arrayList;
        arrayList.add("");
    }

    public stPostCommentReplyV2Req() {
        this.feed_id = "";
        this.commentId = "";
        this.reply = null;
        this.atUserQQ = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.feed_id = jceInputStream.readString(0, false);
        this.commentId = jceInputStream.readString(1, false);
        this.reply = (stSimpleMetaReply) jceInputStream.read((JceStruct) cache_reply, 2, false);
        this.atUserQQ = (ArrayList) jceInputStream.read((JceInputStream) cache_atUserQQ, 3, false);
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
        stSimpleMetaReply stsimplemetareply = this.reply;
        if (stsimplemetareply != null) {
            jceOutputStream.write((JceStruct) stsimplemetareply, 2);
        }
        ArrayList<String> arrayList = this.atUserQQ;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
    }

    public stPostCommentReplyV2Req(String str, String str2, stSimpleMetaReply stsimplemetareply, ArrayList<String> arrayList) {
        this.feed_id = str;
        this.commentId = str2;
        this.reply = stsimplemetareply;
        this.atUserQQ = arrayList;
    }
}

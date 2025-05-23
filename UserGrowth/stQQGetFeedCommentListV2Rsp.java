package UserGrowth;

import NS_KING_INTERFACE.stGetFeedCommentListV2Rsp;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stQQGetFeedCommentListV2Rsp extends JceStruct {
    public ArrayList<stCommentJumpText> comment_text;
    public int link;
    public stGetFeedCommentListV2Rsp rsp;
    static stGetFeedCommentListV2Rsp cache_rsp = new stGetFeedCommentListV2Rsp();
    static ArrayList<stCommentJumpText> cache_comment_text = new ArrayList<>();

    static {
        cache_comment_text.add(new stCommentJumpText());
    }

    public stQQGetFeedCommentListV2Rsp() {
        this.rsp = null;
        this.link = 0;
        this.comment_text = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.rsp = (stGetFeedCommentListV2Rsp) jceInputStream.read((JceStruct) cache_rsp, 0, false);
        this.link = jceInputStream.read(this.link, 1, false);
        this.comment_text = (ArrayList) jceInputStream.read((JceInputStream) cache_comment_text, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stGetFeedCommentListV2Rsp stgetfeedcommentlistv2rsp = this.rsp;
        if (stgetfeedcommentlistv2rsp != null) {
            jceOutputStream.write((JceStruct) stgetfeedcommentlistv2rsp, 0);
        }
        jceOutputStream.write(this.link, 1);
        ArrayList<stCommentJumpText> arrayList = this.comment_text;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public stQQGetFeedCommentListV2Rsp(stGetFeedCommentListV2Rsp stgetfeedcommentlistv2rsp, int i3, ArrayList<stCommentJumpText> arrayList) {
        this.rsp = stgetfeedcommentlistv2rsp;
        this.link = i3;
        this.comment_text = arrayList;
    }
}

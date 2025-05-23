package UserGrowth;

import NS_KING_INTERFACE.stGetFeedCommentListV2Req;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stQQGetFeedCommentListV2Req extends JceStruct {
    static stGetFeedCommentListV2Req cache_req = new stGetFeedCommentListV2Req();
    public stGetFeedCommentListV2Req req;

    public stQQGetFeedCommentListV2Req() {
        this.req = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.req = (stGetFeedCommentListV2Req) jceInputStream.read((JceStruct) cache_req, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stGetFeedCommentListV2Req stgetfeedcommentlistv2req = this.req;
        if (stgetfeedcommentlistv2req != null) {
            jceOutputStream.write((JceStruct) stgetfeedcommentlistv2req, 0);
        }
    }

    public stQQGetFeedCommentListV2Req(stGetFeedCommentListV2Req stgetfeedcommentlistv2req) {
        this.req = stgetfeedcommentlistv2req;
    }
}

package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stPostCommentReplyV2Rsp extends JceStruct {
    static stSimpleMetaReply cache_reply = new stSimpleMetaReply();
    public int arkPopWindow;
    public stSimpleMetaReply reply;
    public int sendArk;

    public stPostCommentReplyV2Rsp() {
        this.reply = null;
        this.sendArk = 0;
        this.arkPopWindow = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.reply = (stSimpleMetaReply) jceInputStream.read((JceStruct) cache_reply, 0, false);
        this.sendArk = jceInputStream.read(this.sendArk, 1, false);
        this.arkPopWindow = jceInputStream.read(this.arkPopWindow, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stSimpleMetaReply stsimplemetareply = this.reply;
        if (stsimplemetareply != null) {
            jceOutputStream.write((JceStruct) stsimplemetareply, 0);
        }
        jceOutputStream.write(this.sendArk, 1);
        jceOutputStream.write(this.arkPopWindow, 2);
    }

    public stPostCommentReplyV2Rsp(stSimpleMetaReply stsimplemetareply, int i3, int i16) {
        this.reply = stsimplemetareply;
        this.sendArk = i3;
        this.arkPopWindow = i16;
    }
}

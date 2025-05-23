package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stPostFeedCommentV2Rsp extends JceStruct {
    static stSimpleMetaComment cache_comment = new stSimpleMetaComment();
    public int arkPopWindow;
    public stSimpleMetaComment comment;
    public int prompt;
    public int sendArk;

    public stPostFeedCommentV2Rsp() {
        this.comment = null;
        this.prompt = 0;
        this.sendArk = 0;
        this.arkPopWindow = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.comment = (stSimpleMetaComment) jceInputStream.read((JceStruct) cache_comment, 0, true);
        this.prompt = jceInputStream.read(this.prompt, 1, false);
        this.sendArk = jceInputStream.read(this.sendArk, 2, false);
        this.arkPopWindow = jceInputStream.read(this.arkPopWindow, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.comment, 0);
        jceOutputStream.write(this.prompt, 1);
        jceOutputStream.write(this.sendArk, 2);
        jceOutputStream.write(this.arkPopWindow, 3);
    }

    public stPostFeedCommentV2Rsp(stSimpleMetaComment stsimplemetacomment, int i3, int i16, int i17) {
        this.comment = stsimplemetacomment;
        this.prompt = i3;
        this.sendArk = i16;
        this.arkPopWindow = i17;
    }
}

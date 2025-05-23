package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CommentUgcDeco extends JceStruct {
    static CommentBubble cache_stBubble = new CommentBubble();
    public CommentBubble stBubble;

    public CommentUgcDeco() {
        this.stBubble = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stBubble = (CommentBubble) jceInputStream.read((JceStruct) cache_stBubble, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CommentBubble commentBubble = this.stBubble;
        if (commentBubble != null) {
            jceOutputStream.write((JceStruct) commentBubble, 0);
        }
    }

    public CommentUgcDeco(CommentBubble commentBubble) {
        this.stBubble = commentBubble;
    }
}

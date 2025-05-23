package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BubbleReq extends JceStruct {
    public int bubbleID;

    public BubbleReq() {
        this.bubbleID = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bubbleID = jceInputStream.read(this.bubbleID, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.bubbleID, 0);
    }

    public BubbleReq(int i3) {
        this.bubbleID = i3;
    }
}

package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BubbleRsp extends JceStruct {
    public String actUrl;
    public int authRet;
    public int bubbleID;

    public BubbleRsp() {
        this.bubbleID = 0;
        this.authRet = 0;
        this.actUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bubbleID = jceInputStream.read(this.bubbleID, 0, false);
        this.authRet = jceInputStream.read(this.authRet, 1, false);
        this.actUrl = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.bubbleID, 0);
        jceOutputStream.write(this.authRet, 1);
        String str = this.actUrl;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public BubbleRsp(int i3, int i16, String str) {
        this.bubbleID = i3;
        this.authRet = i16;
        this.actUrl = str;
    }
}

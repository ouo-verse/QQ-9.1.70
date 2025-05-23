package NS_KING_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stPostFeedDingRsp extends JceStruct {
    public int is_ding;

    public stPostFeedDingRsp() {
        this.is_ding = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.is_ding = jceInputStream.read(this.is_ding, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.is_ding, 0);
    }

    public stPostFeedDingRsp(int i3) {
        this.is_ding = i3;
    }
}

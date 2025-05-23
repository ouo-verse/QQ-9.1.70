package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetMsgRedDotReq extends JceStruct {
    public int reserve;

    public stGetMsgRedDotReq() {
        this.reserve = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.reserve = jceInputStream.read(this.reserve, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.reserve, 0);
    }

    public stGetMsgRedDotReq(int i3) {
        this.reserve = i3;
    }
}

package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFollowRsp extends JceStruct {
    public int isFollow;

    public stFollowRsp() {
        this.isFollow = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.isFollow = jceInputStream.read(this.isFollow, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.isFollow, 0);
    }

    public stFollowRsp(int i3) {
        this.isFollow = i3;
    }
}

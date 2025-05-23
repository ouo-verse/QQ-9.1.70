package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stUpdateWatchDramaRsp extends JceStruct {
    public int code;

    public stUpdateWatchDramaRsp() {
        this.code = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.code = jceInputStream.read(this.code, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.code, 0);
    }

    public stUpdateWatchDramaRsp(int i3) {
        this.code = i3;
    }
}

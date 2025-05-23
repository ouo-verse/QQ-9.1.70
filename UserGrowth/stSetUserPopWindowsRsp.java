package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stSetUserPopWindowsRsp extends JceStruct {
    public int reserve;

    public stSetUserPopWindowsRsp() {
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

    public stSetUserPopWindowsRsp(int i3) {
        this.reserve = i3;
    }
}

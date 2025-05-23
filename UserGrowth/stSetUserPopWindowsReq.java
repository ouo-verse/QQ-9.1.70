package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stSetUserPopWindowsReq extends JceStruct {
    static int cache_window;
    public int action;
    public int window;

    public stSetUserPopWindowsReq() {
        this.window = 0;
        this.action = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.window = jceInputStream.read(this.window, 0, false);
        this.action = jceInputStream.read(this.action, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.window, 0);
        jceOutputStream.write(this.action, 1);
    }

    public stSetUserPopWindowsReq(int i3, int i16) {
        this.window = i3;
        this.action = i16;
    }
}

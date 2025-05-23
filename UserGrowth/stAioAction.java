package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stAioAction extends JceStruct {
    static int cache_landingPage;
    public int landingPage;

    public stAioAction() {
        this.landingPage = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.landingPage = jceInputStream.read(this.landingPage, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.landingPage, 1);
    }

    public stAioAction(int i3) {
        this.landingPage = i3;
    }
}

package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stAnnexation extends JceStruct {
    public int money;

    public stAnnexation() {
        this.money = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.money = jceInputStream.read(this.money, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.money, 0);
    }

    public stAnnexation(int i3) {
        this.money = i3;
    }
}

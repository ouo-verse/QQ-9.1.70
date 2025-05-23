package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Concise extends JceStruct {
    public int isSwitch;

    public Concise() {
        this.isSwitch = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.isSwitch = jceInputStream.read(this.isSwitch, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.isSwitch, 0);
    }

    public Concise(int i3) {
        this.isSwitch = i3;
    }
}

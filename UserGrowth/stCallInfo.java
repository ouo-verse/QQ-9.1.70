package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stCallInfo extends JceStruct {
    public boolean switch_call_live;
    public boolean switch_call_new;

    public stCallInfo() {
        this.switch_call_live = true;
        this.switch_call_new = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.switch_call_live = jceInputStream.read(this.switch_call_live, 0, false);
        this.switch_call_new = jceInputStream.read(this.switch_call_new, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.switch_call_live, 0);
        jceOutputStream.write(this.switch_call_new, 1);
    }

    public stCallInfo(boolean z16, boolean z17) {
        this.switch_call_live = z16;
        this.switch_call_new = z17;
    }
}

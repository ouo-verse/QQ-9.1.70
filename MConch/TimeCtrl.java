package MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TimeCtrl extends JceStruct {
    public int validEndTime = 0;

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new TimeCtrl();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.validEndTime = jceInputStream.read(this.validEndTime, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        int i3 = this.validEndTime;
        if (i3 != 0) {
            jceOutputStream.write(i3, 0);
        }
    }
}

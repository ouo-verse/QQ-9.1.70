package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class HeartInfo extends JceStruct {
    public int iHeartCount;

    public HeartInfo() {
        this.iHeartCount = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iHeartCount = jceInputStream.read(this.iHeartCount, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iHeartCount, 0);
    }

    public HeartInfo(int i3) {
        this.iHeartCount = i3;
    }
}

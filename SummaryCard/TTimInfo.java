package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TTimInfo extends JceStruct {
    public int iIsOnline;

    public TTimInfo() {
        this.iIsOnline = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iIsOnline = jceInputStream.read(this.iIsOnline, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iIsOnline, 0);
    }

    public TTimInfo(int i3) {
        this.iIsOnline = i3;
    }
}

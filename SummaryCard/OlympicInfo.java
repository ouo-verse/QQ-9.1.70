package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class OlympicInfo extends JceStruct {
    public int iTorch;

    public OlympicInfo() {
        this.iTorch = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iTorch = jceInputStream.read(this.iTorch, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iTorch, 0);
    }

    public OlympicInfo(int i3) {
        this.iTorch = i3;
    }
}

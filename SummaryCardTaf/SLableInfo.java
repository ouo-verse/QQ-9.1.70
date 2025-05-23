package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SLableInfo extends JceStruct {
    public long likeit;
    public String name;
    public boolean valid;

    public SLableInfo() {
        this.likeit = 0L;
        this.name = "";
        this.valid = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.likeit = jceInputStream.read(this.likeit, 0, true);
        this.name = jceInputStream.readString(1, true);
        this.valid = jceInputStream.read(this.valid, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.likeit, 0);
        jceOutputStream.write(this.name, 1);
        jceOutputStream.write(this.valid, 2);
    }

    public SLableInfo(long j3, String str, boolean z16) {
        this.likeit = j3;
        this.name = str;
        this.valid = z16;
    }
}

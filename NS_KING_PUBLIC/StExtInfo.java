package NS_KING_PUBLIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class StExtInfo extends JceStruct {
    public String logDepth;
    public int logLevel;
    public int logSeq;

    public StExtInfo() {
        this.logLevel = 0;
        this.logSeq = 0;
        this.logDepth = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.logLevel = jceInputStream.read(this.logLevel, 0, false);
        this.logSeq = jceInputStream.read(this.logSeq, 1, false);
        this.logDepth = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.logLevel, 0);
        jceOutputStream.write(this.logSeq, 1);
        String str = this.logDepth;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public StExtInfo(int i3, int i16, String str) {
        this.logLevel = i3;
        this.logSeq = i16;
        this.logDepth = str;
    }
}

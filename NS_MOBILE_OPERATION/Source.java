package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Source extends JceStruct {
    public int apptype;
    public int subtype;
    public int termtype;

    public Source() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.subtype = jceInputStream.read(this.subtype, 0, false);
        this.termtype = jceInputStream.read(this.termtype, 1, false);
        this.apptype = jceInputStream.read(this.apptype, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.subtype, 0);
        jceOutputStream.write(this.termtype, 1);
        jceOutputStream.write(this.apptype, 2);
    }

    public Source(int i3, int i16) {
        this.subtype = i3;
        this.termtype = i16;
    }

    public Source(int i3, int i16, int i17) {
        this.subtype = i3;
        this.termtype = i16;
        this.apptype = i17;
    }
}

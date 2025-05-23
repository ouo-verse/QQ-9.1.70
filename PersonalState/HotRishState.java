package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class HotRishState extends JceStruct {
    public int iActId;
    public int iDataId;

    public HotRishState() {
        this.iActId = 0;
        this.iDataId = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iActId = jceInputStream.read(this.iActId, 0, true);
        this.iDataId = jceInputStream.read(this.iDataId, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iActId, 0);
        jceOutputStream.write(this.iDataId, 1);
    }

    public HotRishState(int i3, int i16) {
        this.iActId = i3;
        this.iDataId = i16;
    }
}

package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniBusiSimpleFontItem extends JceStruct {
    public int fontType;

    public UniBusiSimpleFontItem() {
        this.fontType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.fontType = jceInputStream.read(this.fontType, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.fontType, 0);
    }

    public UniBusiSimpleFontItem(int i3) {
        this.fontType = i3;
    }
}

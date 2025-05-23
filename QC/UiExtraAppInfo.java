package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UiExtraAppInfo extends JceStruct {
    public int svipLevel;
    public int svipMonth;

    public UiExtraAppInfo() {
        this.svipLevel = 0;
        this.svipMonth = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.svipLevel = jceInputStream.read(this.svipLevel, 0, false);
        this.svipMonth = jceInputStream.read(this.svipMonth, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.svipLevel, 0);
        jceOutputStream.write(this.svipMonth, 1);
    }

    public UiExtraAppInfo(int i3, int i16) {
        this.svipLevel = i3;
        this.svipMonth = i16;
    }
}

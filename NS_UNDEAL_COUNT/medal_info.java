package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class medal_info extends JceStruct {
    public int level;
    public int medalid;
    public int updated;

    public medal_info() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.updated = jceInputStream.read(this.updated, 0, false);
        this.medalid = jceInputStream.read(this.medalid, 1, false);
        this.level = jceInputStream.read(this.level, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.updated, 0);
        jceOutputStream.write(this.medalid, 1);
        jceOutputStream.write(this.level, 2);
    }

    public medal_info(int i3, int i16, int i17) {
        this.updated = i3;
        this.medalid = i16;
        this.level = i17;
    }
}

package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stLinkStragegyArgs extends JceStruct {
    public boolean hasInstalledWeish;
    public int todayClickCount;
    public int todayEnterCount;
    public int todayLastLinkId;

    public stLinkStragegyArgs() {
        this.hasInstalledWeish = false;
        this.todayEnterCount = 0;
        this.todayClickCount = 0;
        this.todayLastLinkId = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.hasInstalledWeish = jceInputStream.read(this.hasInstalledWeish, 1, false);
        this.todayEnterCount = jceInputStream.read(this.todayEnterCount, 2, false);
        this.todayClickCount = jceInputStream.read(this.todayClickCount, 3, false);
        this.todayLastLinkId = jceInputStream.read(this.todayLastLinkId, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "stLinkStragegyArgs{hasInstalledWeish=" + this.hasInstalledWeish + ", todayEnterCount=" + this.todayEnterCount + ", todayClickCount=" + this.todayClickCount + ", todayLastLinkId=" + this.todayLastLinkId + '}';
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.hasInstalledWeish, 1);
        jceOutputStream.write(this.todayEnterCount, 2);
        jceOutputStream.write(this.todayClickCount, 3);
        jceOutputStream.write(this.todayLastLinkId, 4);
    }

    public stLinkStragegyArgs(boolean z16, int i3, int i16, int i17) {
        this.hasInstalledWeish = z16;
        this.todayEnterCount = i3;
        this.todayClickCount = i16;
        this.todayLastLinkId = i17;
    }
}

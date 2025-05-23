package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stWaterFallItemStrategy extends JceStruct {
    public boolean isCallWeishi;
    public boolean isDonwloadWeish;

    public stWaterFallItemStrategy() {
        this.isCallWeishi = true;
        this.isDonwloadWeish = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.isCallWeishi = jceInputStream.read(this.isCallWeishi, 0, false);
        this.isDonwloadWeish = jceInputStream.read(this.isDonwloadWeish, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.isCallWeishi, 0);
        jceOutputStream.write(this.isDonwloadWeish, 1);
    }

    public stWaterFallItemStrategy(boolean z16, boolean z17) {
        this.isCallWeishi = z16;
        this.isDonwloadWeish = z17;
    }
}

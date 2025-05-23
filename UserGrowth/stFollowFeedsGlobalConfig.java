package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFollowFeedsGlobalConfig extends JceStruct {
    public boolean showMute;

    public stFollowFeedsGlobalConfig() {
        this.showMute = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.showMute = jceInputStream.read(this.showMute, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.showMute, 0);
    }

    public stFollowFeedsGlobalConfig(boolean z16) {
        this.showMute = z16;
    }
}

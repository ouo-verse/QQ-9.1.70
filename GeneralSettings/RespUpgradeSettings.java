package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespUpgradeSettings extends JceStruct {
    public int Result;

    public RespUpgradeSettings() {
        this.Result = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Result = jceInputStream.read(this.Result, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Result, 0);
    }

    public RespUpgradeSettings(int i3) {
        this.Result = i3;
    }
}

package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespSetSettings extends JceStruct {
    public int Revision;

    public RespSetSettings() {
        this.Revision = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Revision = jceInputStream.read(this.Revision, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Revision, 0);
    }

    public RespSetSettings(int i3) {
        this.Revision = i3;
    }
}

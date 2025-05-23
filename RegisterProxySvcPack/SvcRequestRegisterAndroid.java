package RegisterProxySvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcRequestRegisterAndroid extends JceStruct {
    public long ulRequestOptional;

    public SvcRequestRegisterAndroid() {
        this.ulRequestOptional = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ulRequestOptional = jceInputStream.read(this.ulRequestOptional, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ulRequestOptional, 0);
    }

    public SvcRequestRegisterAndroid(long j3) {
        this.ulRequestOptional = j3;
    }
}

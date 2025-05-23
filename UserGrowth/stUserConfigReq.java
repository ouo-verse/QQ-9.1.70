package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stUserConfigReq extends JceStruct {
    public int config_set;
    public boolean is_auth;

    public stUserConfigReq() {
        this.config_set = 0;
        this.is_auth = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.config_set = jceInputStream.read(this.config_set, 0, false);
        this.is_auth = jceInputStream.read(this.is_auth, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.config_set, 0);
        jceOutputStream.write(this.is_auth, 1);
    }

    public stUserConfigReq(int i3, boolean z16) {
        this.config_set = i3;
        this.is_auth = z16;
    }
}

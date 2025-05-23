package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stGetAllABTestPolicyReq extends JceStruct {
    public boolean hasInstalledWeishi;
    public String uin;

    public stGetAllABTestPolicyReq() {
        this.uin = "";
        this.hasInstalledWeishi = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.readString(0, false);
        this.hasInstalledWeishi = jceInputStream.read(this.hasInstalledWeishi, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.uin;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.hasInstalledWeishi, 1);
    }

    public stGetAllABTestPolicyReq(String str, boolean z16) {
        this.uin = str;
        this.hasInstalledWeishi = z16;
    }
}

package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stJoinGroupRsp extends JceStruct {
    public String signature;
    public int status;

    public stJoinGroupRsp() {
        this.status = 0;
        this.signature = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.status = jceInputStream.read(this.status, 0, false);
        this.signature = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.status, 0);
        String str = this.signature;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public stJoinGroupRsp(int i3, String str) {
        this.status = i3;
        this.signature = str;
    }
}

package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFollowReq extends JceStruct {
    static int cache_action;
    public int action;
    public String personId;

    public stFollowReq() {
        this.personId = "";
        this.action = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.personId = jceInputStream.readString(0, false);
        this.action = jceInputStream.read(this.action, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.personId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.action, 1);
    }

    public stFollowReq(String str, int i3) {
        this.personId = str;
        this.action = i3;
    }
}

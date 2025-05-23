package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stUpdateFollowDramaReq extends JceStruct {
    public String dramaID;
    public int type;

    public stUpdateFollowDramaReq() {
        this.dramaID = "";
        this.type = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dramaID = jceInputStream.readString(0, false);
        this.type = jceInputStream.read(this.type, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.dramaID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.type, 1);
    }

    public stUpdateFollowDramaReq(String str, int i3) {
        this.dramaID = str;
        this.type = i3;
    }
}

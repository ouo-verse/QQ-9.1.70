package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetAllFeedsByDramaIDReq extends JceStruct {
    public String dramaID;

    public stGetAllFeedsByDramaIDReq() {
        this.dramaID = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dramaID = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.dramaID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public stGetAllFeedsByDramaIDReq(String str) {
        this.dramaID = str;
    }
}

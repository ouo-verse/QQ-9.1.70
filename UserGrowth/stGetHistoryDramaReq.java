package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetHistoryDramaReq extends JceStruct {
    public String attachInfo;
    public String personID;

    public stGetHistoryDramaReq() {
        this.personID = "";
        this.attachInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.personID = jceInputStream.readString(0, false);
        this.attachInfo = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.personID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.attachInfo;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public stGetHistoryDramaReq(String str, String str2) {
        this.personID = str;
        this.attachInfo = str2;
    }
}

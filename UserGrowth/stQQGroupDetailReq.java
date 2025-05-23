package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stQQGroupDetailReq extends JceStruct {
    public String groupId;
    public String posterPersonId;

    public stQQGroupDetailReq() {
        this.groupId = "";
        this.posterPersonId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.groupId = jceInputStream.readString(0, false);
        this.posterPersonId = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.groupId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.posterPersonId;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public stQQGroupDetailReq(String str, String str2) {
        this.groupId = str;
        this.posterPersonId = str2;
    }
}

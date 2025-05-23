package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_id extends JceStruct {
    public String cellid;
    public String subid;

    public cell_id() {
        this.cellid = "";
        this.subid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cellid = jceInputStream.readString(0, false);
        this.subid = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.cellid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.subid;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public cell_id(String str, String str2) {
        this.cellid = str;
        this.subid = str2;
    }
}

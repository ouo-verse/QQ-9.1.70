package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CKV_SingerInfo extends JceStruct {
    public String sSingerId;
    public String sSingerName;

    public CKV_SingerInfo() {
        this.sSingerId = "";
        this.sSingerName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sSingerId = jceInputStream.readString(0, false);
        this.sSingerName = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sSingerId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.sSingerName;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public CKV_SingerInfo(String str, String str2) {
        this.sSingerId = str;
        this.sSingerName = str2;
    }
}

package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RequestQueryQQBindingStat extends JceStruct {
    public String MobileUniqueNo;

    public RequestQueryQQBindingStat() {
        this.MobileUniqueNo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.MobileUniqueNo = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.MobileUniqueNo;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public RequestQueryQQBindingStat(String str) {
        this.MobileUniqueNo = str;
    }
}

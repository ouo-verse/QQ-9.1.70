package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_HighFive extends JceStruct {
    public long iCount;
    public String strResourceUrl;

    public s_HighFive() {
        this.iCount = 0L;
        this.strResourceUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iCount = jceInputStream.read(this.iCount, 0, false);
        this.strResourceUrl = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iCount, 0);
        String str = this.strResourceUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public s_HighFive(long j3, String str) {
        this.iCount = j3;
        this.strResourceUrl = str;
    }
}

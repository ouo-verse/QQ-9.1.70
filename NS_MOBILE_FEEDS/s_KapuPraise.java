package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class s_KapuPraise extends JceStruct {
    public long iCount;
    public int iItemId;
    public String strName;

    public s_KapuPraise() {
        this.iItemId = 0;
        this.iCount = 0L;
        this.strName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemId = jceInputStream.read(this.iItemId, 0, false);
        this.iCount = jceInputStream.read(this.iCount, 1, false);
        this.strName = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemId, 0);
        jceOutputStream.write(this.iCount, 1);
        String str = this.strName;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public s_KapuPraise(int i3, long j3, String str) {
        this.iItemId = i3;
        this.iCount = j3;
        this.strName = str;
    }
}

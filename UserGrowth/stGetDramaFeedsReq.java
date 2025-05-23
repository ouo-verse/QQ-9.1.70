package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetDramaFeedsReq extends JceStruct {
    public String attachInfo;
    public String curFeedID;
    public String dramaID;
    public int refresh;

    public stGetDramaFeedsReq() {
        this.dramaID = "";
        this.curFeedID = "";
        this.refresh = 0;
        this.attachInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dramaID = jceInputStream.readString(0, false);
        this.curFeedID = jceInputStream.readString(1, false);
        this.refresh = jceInputStream.read(this.refresh, 2, false);
        this.attachInfo = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.dramaID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.curFeedID;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.refresh, 2);
        String str3 = this.attachInfo;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public stGetDramaFeedsReq(String str, String str2, int i3, String str3) {
        this.dramaID = str;
        this.curFeedID = str2;
        this.refresh = i3;
        this.attachInfo = str3;
    }
}

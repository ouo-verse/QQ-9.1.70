package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stUpdateWatchDramaReq extends JceStruct {
    public String dramaID;
    public String feedID;
    public int feedNum;
    public int feedSecond;

    public stUpdateWatchDramaReq() {
        this.dramaID = "";
        this.feedNum = 0;
        this.feedSecond = 0;
        this.feedID = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dramaID = jceInputStream.readString(0, false);
        this.feedNum = jceInputStream.read(this.feedNum, 1, false);
        this.feedSecond = jceInputStream.read(this.feedSecond, 2, false);
        this.feedID = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.dramaID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.feedNum, 1);
        jceOutputStream.write(this.feedSecond, 2);
        String str2 = this.feedID;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public stUpdateWatchDramaReq(String str, int i3, int i16, String str2) {
        this.dramaID = str;
        this.feedNum = i3;
        this.feedSecond = i16;
        this.feedID = str2;
    }
}

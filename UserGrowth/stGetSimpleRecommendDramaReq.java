package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetSimpleRecommendDramaReq extends JceStruct {
    public String enterDramaID;

    public stGetSimpleRecommendDramaReq() {
        this.enterDramaID = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.enterDramaID = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.enterDramaID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public stGetSimpleRecommendDramaReq(String str) {
        this.enterDramaID = str;
    }
}

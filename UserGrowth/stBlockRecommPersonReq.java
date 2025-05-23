package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stBlockRecommPersonReq extends JceStruct {
    public String personId;

    public stBlockRecommPersonReq() {
        this.personId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.personId = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.personId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public stBlockRecommPersonReq(String str) {
        this.personId = str;
    }
}

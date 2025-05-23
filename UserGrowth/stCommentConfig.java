package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stCommentConfig extends JceStruct {
    public String guideText;

    public stCommentConfig() {
        this.guideText = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.guideText = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "stCommentConfig{guideText='" + this.guideText + "'}";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.guideText;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public stCommentConfig(String str) {
        this.guideText = str;
    }
}

package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class YoutuResultItem extends JceStruct {
    public double Confidence;
    public String Label;

    public YoutuResultItem() {
        this.Label = "";
        this.Confidence = 0.0d;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Label = jceInputStream.readString(0, false);
        this.Confidence = jceInputStream.read(this.Confidence, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.Label;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.Confidence, 1);
    }

    public YoutuResultItem(String str, double d16) {
        this.Label = str;
        this.Confidence = d16;
    }
}

package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BubbleData extends JceStruct {
    public String DisplayText;
    public String Id;

    public BubbleData() {
        this.Id = "";
        this.DisplayText = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Id = jceInputStream.readString(0, false);
        this.DisplayText = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.Id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.DisplayText;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public BubbleData(String str, String str2) {
        this.Id = str;
        this.DisplayText = str2;
    }
}

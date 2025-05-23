package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stWaterTemplate extends JceStruct {
    public String sWaterContent;
    public String sWaterTemplateID;

    public stWaterTemplate() {
        this.sWaterTemplateID = "";
        this.sWaterContent = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sWaterTemplateID = jceInputStream.readString(0, false);
        this.sWaterContent = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sWaterTemplateID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.sWaterContent;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public stWaterTemplate(String str, String str2) {
        this.sWaterTemplateID = str;
        this.sWaterContent = str2;
    }
}

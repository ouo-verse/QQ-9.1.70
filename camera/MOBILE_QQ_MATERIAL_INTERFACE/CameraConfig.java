package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CameraConfig extends JceStruct {
    public String ConfigContent;
    public String ExpId;

    public CameraConfig() {
        this.ExpId = "";
        this.ConfigContent = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ExpId = jceInputStream.readString(0, false);
        this.ConfigContent = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.ExpId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.ConfigContent;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public CameraConfig(String str, String str2) {
        this.ExpId = str;
        this.ConfigContent = str2;
    }
}

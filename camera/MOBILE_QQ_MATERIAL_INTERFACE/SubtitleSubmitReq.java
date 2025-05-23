package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SubtitleSubmitReq extends JceStruct {
    public String AudioURL;

    public SubtitleSubmitReq() {
        this.AudioURL = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.AudioURL = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.AudioURL;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public SubtitleSubmitReq(String str) {
        this.AudioURL = str;
    }
}

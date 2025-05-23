package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SubtitleQueryReq extends JceStruct {
    public String TaskID;

    public SubtitleQueryReq() {
        this.TaskID = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.TaskID = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.TaskID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public SubtitleQueryReq(String str) {
        this.TaskID = str;
    }
}

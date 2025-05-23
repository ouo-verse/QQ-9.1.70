package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SubtitleSubmitRsp extends JceStruct {
    public int Code;
    public String Msg;
    public String TaskID;

    public SubtitleSubmitRsp() {
        this.Code = 0;
        this.Msg = "";
        this.TaskID = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.Msg = jceInputStream.readString(1, false);
        this.TaskID = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Code, 0);
        String str = this.Msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.TaskID;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public SubtitleSubmitRsp(int i3, String str, String str2) {
        this.Code = i3;
        this.Msg = str;
        this.TaskID = str2;
    }
}

package Sound;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UploadRsp extends JceStruct implements Cloneable {
    public int result;
    public String voice_id;

    public UploadRsp() {
        this.result = 0;
        this.voice_id = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.result, "result");
        jceDisplayer.display(this.voice_id, QzoneCameraConst.Tag.ARG_PARAM_VOICE_ID);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.result = jceInputStream.read(this.result, 0, true);
        this.voice_id = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.result, 0);
        String str = this.voice_id;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public UploadRsp(int i3, String str) {
        this.result = i3;
        this.voice_id = str;
    }
}

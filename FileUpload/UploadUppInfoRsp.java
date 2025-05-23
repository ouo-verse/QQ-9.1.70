package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UploadUppInfoRsp extends JceStruct {
    public String sUrl;

    public UploadUppInfoRsp() {
        this.sUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sUrl = jceInputStream.readString(0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sUrl, 0);
    }

    public UploadUppInfoRsp(String str) {
        this.sUrl = str;
    }
}

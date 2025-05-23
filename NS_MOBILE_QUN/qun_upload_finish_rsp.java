package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class qun_upload_finish_rsp extends JceStruct {
    public int retry_timeout;

    public qun_upload_finish_rsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.retry_timeout = jceInputStream.read(this.retry_timeout, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.retry_timeout, 0);
    }

    public qun_upload_finish_rsp(int i3) {
        this.retry_timeout = i3;
    }
}

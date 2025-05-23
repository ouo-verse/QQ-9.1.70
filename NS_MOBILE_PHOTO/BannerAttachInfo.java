package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public class BannerAttachInfo extends JceStruct {
    public long last_upload_time;
    public int priv;

    public BannerAttachInfo() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.last_upload_time = jceInputStream.read(this.last_upload_time, 0, false);
        this.priv = jceInputStream.read(this.priv, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.last_upload_time, 0);
        jceOutputStream.write(this.priv, 1);
    }

    public BannerAttachInfo(long j3, int i3) {
        this.last_upload_time = j3;
        this.priv = i3;
    }
}

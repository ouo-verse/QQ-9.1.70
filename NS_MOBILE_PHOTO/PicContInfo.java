package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PicContInfo extends JceStruct {
    public String md5;
    public long size;

    public PicContInfo() {
        this.md5 = "";
        this.size = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.md5 = jceInputStream.readString(0, false);
        this.size = jceInputStream.read(this.size, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.md5;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.size, 1);
    }

    public PicContInfo(String str, long j3) {
        this.md5 = str;
        this.size = j3;
    }
}

package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class quote_photo_src extends JceStruct {
    public long fromUin;
    public int src_type;

    public quote_photo_src() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.src_type = jceInputStream.read(this.src_type, 0, false);
        this.fromUin = jceInputStream.read(this.fromUin, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.src_type, 0);
        jceOutputStream.write(this.fromUin, 1);
    }

    public quote_photo_src(int i3, long j3) {
        this.src_type = i3;
        this.fromUin = j3;
    }
}

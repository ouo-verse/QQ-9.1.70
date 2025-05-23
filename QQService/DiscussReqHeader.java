package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DiscussReqHeader extends JceStruct {
    public int Version;

    public DiscussReqHeader() {
        this.Version = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Version = jceInputStream.read(this.Version, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Version, 0);
    }

    public DiscussReqHeader(int i3) {
        this.Version = i3;
    }
}

package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GrpInfoItem extends JceStruct {
    public long Content;
    public byte Type;

    public GrpInfoItem() {
        this.Type = (byte) 0;
        this.Content = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Type = jceInputStream.read(this.Type, 0, true);
        this.Content = jceInputStream.read(this.Content, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Type, 0);
        jceOutputStream.write(this.Content, 1);
    }

    public GrpInfoItem(byte b16, long j3) {
        this.Type = b16;
        this.Content = j3;
    }
}

package SWEET_NEW_PAIR;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class invite_item extends JceStruct {
    public long time;
    public long uin;

    public invite_item() {
        this.uin = 0L;
        this.time = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.time = jceInputStream.read(this.time, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.time, 1);
    }

    public invite_item(long j3, long j16) {
        this.uin = j3;
        this.time = j16;
    }
}

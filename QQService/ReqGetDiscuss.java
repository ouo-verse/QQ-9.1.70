package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetDiscuss extends JceStruct {
    public long Uin;

    public ReqGetDiscuss() {
        this.Uin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Uin = jceInputStream.read(this.Uin, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Uin, 0);
    }

    public ReqGetDiscuss(long j3) {
        this.Uin = j3;
    }
}

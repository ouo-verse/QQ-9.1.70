package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqChangeDiscussName extends JceStruct {
    public long DiscussUin;
    public String NewName;

    public ReqChangeDiscussName() {
        this.DiscussUin = 0L;
        this.NewName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.DiscussUin = jceInputStream.read(this.DiscussUin, 0, true);
        this.NewName = jceInputStream.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.DiscussUin, 0);
        jceOutputStream.write(this.NewName, 1);
    }

    public ReqChangeDiscussName(long j3, String str) {
        this.DiscussUin = j3;
        this.NewName = str;
    }
}

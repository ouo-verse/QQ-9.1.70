package NS_WEISHI_QQ_PROFILE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stSetSwitchReq extends JceStruct {

    /* renamed from: op, reason: collision with root package name */
    public int f25071op;
    public long uin;

    public stSetSwitchReq() {
        this.uin = 0L;
        this.f25071op = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.f25071op = jceInputStream.read(this.f25071op, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.f25071op, 1);
    }

    public stSetSwitchReq(long j3, int i3) {
        this.uin = j3;
        this.f25071op = i3;
    }
}

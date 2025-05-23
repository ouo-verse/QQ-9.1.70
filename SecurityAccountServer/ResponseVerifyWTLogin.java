package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ResponseVerifyWTLogin extends JceStruct {
    public long preBindUin;

    public ResponseVerifyWTLogin() {
        this.preBindUin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.preBindUin = jceInputStream.read(this.preBindUin, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.preBindUin, 0);
    }

    public ResponseVerifyWTLogin(long j3) {
        this.preBindUin = j3;
    }
}

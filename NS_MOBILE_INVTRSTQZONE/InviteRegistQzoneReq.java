package NS_MOBILE_INVTRSTQZONE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class InviteRegistQzoneReq extends JceStruct {
    public long iHostUin;
    public long iInviteUin;

    public InviteRegistQzoneReq() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iHostUin = jceInputStream.read(this.iHostUin, 0, true);
        this.iInviteUin = jceInputStream.read(this.iInviteUin, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iHostUin, 0);
        jceOutputStream.write(this.iInviteUin, 1);
    }

    public InviteRegistQzoneReq(long j3, long j16) {
        this.iHostUin = j3;
        this.iInviteUin = j16;
    }
}

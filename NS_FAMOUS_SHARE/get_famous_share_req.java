package NS_FAMOUS_SHARE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_famous_share_req extends JceStruct {
    public long uiReqUin;

    public get_famous_share_req() {
        this.uiReqUin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uiReqUin = jceInputStream.read(this.uiReqUin, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uiReqUin, 0);
    }

    public get_famous_share_req(long j3) {
        this.uiReqUin = j3;
    }
}

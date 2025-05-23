package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetUserDiyFontReq extends JceStruct {
    public int diyFontId;
    public long targetUin;

    public GetUserDiyFontReq() {
        this.targetUin = 0L;
        this.diyFontId = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.targetUin = jceInputStream.read(this.targetUin, 0, false);
        this.diyFontId = jceInputStream.read(this.diyFontId, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.targetUin, 0);
        jceOutputStream.write(this.diyFontId, 1);
    }

    public GetUserDiyFontReq(long j3, int i3) {
        this.targetUin = j3;
        this.diyFontId = i3;
    }
}

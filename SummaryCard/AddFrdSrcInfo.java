package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AddFrdSrcInfo extends JceStruct {
    public String strSrcName;
    public long uSrcId;
    public long uSubSrcId;

    public AddFrdSrcInfo() {
        this.strSrcName = "";
        this.uSrcId = 0L;
        this.uSubSrcId = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strSrcName = jceInputStream.readString(0, false);
        this.uSrcId = jceInputStream.read(this.uSrcId, 1, false);
        this.uSubSrcId = jceInputStream.read(this.uSubSrcId, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strSrcName;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.uSrcId, 1);
        jceOutputStream.write(this.uSubSrcId, 2);
    }

    public AddFrdSrcInfo(String str, long j3, long j16) {
        this.strSrcName = str;
        this.uSrcId = j3;
        this.uSubSrcId = j16;
    }
}

package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QCallInfo extends JceStruct {
    static int cache_bStatus;
    public int bStatus;
    public String strNick;
    public long uQCallId;

    public QCallInfo() {
        this.bStatus = 0;
        this.strNick = "";
        this.uQCallId = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bStatus = jceInputStream.read(this.bStatus, 0, false);
        this.strNick = jceInputStream.readString(1, false);
        this.uQCallId = jceInputStream.read(this.uQCallId, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.bStatus, 0);
        String str = this.strNick;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.uQCallId, 2);
    }

    public QCallInfo(int i3, String str, long j3) {
        this.bStatus = i3;
        this.strNick = str;
        this.uQCallId = j3;
    }
}

package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QiqiVideoInfo extends JceStruct {
    public long uRoomid;

    public QiqiVideoInfo() {
        this.uRoomid = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uRoomid = jceInputStream.read(this.uRoomid, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uRoomid, 0);
    }

    public QiqiVideoInfo(long j3) {
        this.uRoomid = j3;
    }
}

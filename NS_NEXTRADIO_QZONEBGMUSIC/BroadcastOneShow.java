package NS_NEXTRADIO_QZONEBGMUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BroadcastOneShow extends JceStruct {
    public String bcShowId;
    public String bcShowName;
    public long endTime;
    public int singerId;
    public String singerName;
    public long startTime;

    public BroadcastOneShow() {
        this.bcShowId = "";
        this.bcShowName = "";
        this.startTime = 0L;
        this.endTime = 0L;
        this.singerId = 0;
        this.singerName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bcShowId = jceInputStream.readString(0, false);
        this.bcShowName = jceInputStream.readString(1, false);
        this.startTime = jceInputStream.read(this.startTime, 2, false);
        this.endTime = jceInputStream.read(this.endTime, 3, false);
        this.singerId = jceInputStream.read(this.singerId, 4, false);
        this.singerName = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.bcShowId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.bcShowName;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.startTime, 2);
        jceOutputStream.write(this.endTime, 3);
        jceOutputStream.write(this.singerId, 4);
        String str3 = this.singerName;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
    }

    public BroadcastOneShow(String str, String str2, long j3, long j16, int i3, String str3) {
        this.bcShowId = str;
        this.bcShowName = str2;
        this.startTime = j3;
        this.endTime = j16;
        this.singerId = i3;
        this.singerName = str3;
    }
}

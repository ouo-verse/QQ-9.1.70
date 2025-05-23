package NS_MOBILE_FEEDS_GAMES;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class st_Games_MarketData extends JceStruct {
    public String strZipUrl;
    public long uBeginTime;
    public long uEndTime;

    public st_Games_MarketData() {
        this.uBeginTime = 0L;
        this.uEndTime = 0L;
        this.strZipUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uBeginTime = jceInputStream.read(this.uBeginTime, 0, false);
        this.uEndTime = jceInputStream.read(this.uEndTime, 1, false);
        this.strZipUrl = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uBeginTime, 0);
        jceOutputStream.write(this.uEndTime, 1);
        String str = this.strZipUrl;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public st_Games_MarketData(long j3, long j16, String str) {
        this.uBeginTime = j3;
        this.uEndTime = j16;
        this.strZipUrl = str;
    }
}

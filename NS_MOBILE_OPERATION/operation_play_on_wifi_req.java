package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_play_on_wifi_req extends JceStruct {
    public boolean isSetPlayOnWifi;
    public String strFeedUgcKey;
    public long uFeedsUin;
    public long uTime;

    public operation_play_on_wifi_req() {
        this.uFeedsUin = 0L;
        this.uTime = 0L;
        this.strFeedUgcKey = "";
        this.isSetPlayOnWifi = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uFeedsUin = jceInputStream.read(this.uFeedsUin, 0, false);
        this.uTime = jceInputStream.read(this.uTime, 1, false);
        this.strFeedUgcKey = jceInputStream.readString(2, false);
        this.isSetPlayOnWifi = jceInputStream.read(this.isSetPlayOnWifi, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uFeedsUin, 0);
        jceOutputStream.write(this.uTime, 1);
        String str = this.strFeedUgcKey;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.isSetPlayOnWifi, 3);
    }

    public operation_play_on_wifi_req(long j3, long j16, String str, boolean z16) {
        this.uFeedsUin = j3;
        this.uTime = j16;
        this.strFeedUgcKey = str;
        this.isSetPlayOnWifi = z16;
    }
}

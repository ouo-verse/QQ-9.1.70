package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_hide_feeds_req extends JceStruct {
    public String strFeedUinKey;
    public long uHostUin;
    public long uTime;

    public operation_hide_feeds_req() {
        this.strFeedUinKey = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strFeedUinKey = jceInputStream.readString(0, false);
        this.uHostUin = jceInputStream.read(this.uHostUin, 1, false);
        this.uTime = jceInputStream.read(this.uTime, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strFeedUinKey;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.uHostUin, 1);
        jceOutputStream.write(this.uTime, 2);
    }

    public operation_hide_feeds_req(String str, long j3, long j16) {
        this.strFeedUinKey = str;
        this.uHostUin = j3;
        this.uTime = j16;
    }
}

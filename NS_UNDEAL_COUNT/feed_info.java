package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class feed_info extends JceStruct {
    public String strText;
    public long uFeedCTime;
    public long uOrgFeedTime;
    public long uOrgFeedUin;

    public feed_info() {
        this.uOrgFeedTime = 0L;
        this.uFeedCTime = 0L;
        this.uOrgFeedUin = 0L;
        this.strText = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uOrgFeedTime = jceInputStream.read(this.uOrgFeedTime, 0, false);
        this.uFeedCTime = jceInputStream.read(this.uFeedCTime, 1, false);
        this.uOrgFeedUin = jceInputStream.read(this.uOrgFeedUin, 2, false);
        this.strText = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uOrgFeedTime, 0);
        jceOutputStream.write(this.uFeedCTime, 1);
        jceOutputStream.write(this.uOrgFeedUin, 2);
        String str = this.strText;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }

    public feed_info(long j3, long j16, long j17, String str) {
        this.uOrgFeedTime = j3;
        this.uFeedCTime = j16;
        this.uOrgFeedUin = j17;
        this.strText = str;
    }
}

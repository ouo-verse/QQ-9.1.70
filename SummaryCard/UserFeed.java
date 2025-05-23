package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserFeed extends JceStruct {
    static byte[] cache_vFeedInfo;
    public long uFlag;
    public byte[] vFeedInfo;

    public UserFeed() {
        this.uFlag = 0L;
        this.vFeedInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uFlag = jceInputStream.read(this.uFlag, 0, false);
        if (cache_vFeedInfo == null) {
            cache_vFeedInfo = r0;
            byte[] bArr = {0};
        }
        this.vFeedInfo = jceInputStream.read(cache_vFeedInfo, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uFlag, 0);
        byte[] bArr = this.vFeedInfo;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
    }

    public UserFeed(long j3, byte[] bArr) {
        this.uFlag = j3;
        this.vFeedInfo = bArr;
    }
}

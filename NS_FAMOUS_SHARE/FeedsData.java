package NS_FAMOUS_SHARE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FeedsData extends JceStruct {
    public String sFeedDesc;
    public String sVideoCoverUrl;
    public long uiCreatTime;

    public FeedsData() {
        this.uiCreatTime = 0L;
        this.sVideoCoverUrl = "";
        this.sFeedDesc = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uiCreatTime = jceInputStream.read(this.uiCreatTime, 0, false);
        this.sVideoCoverUrl = jceInputStream.readString(1, false);
        this.sFeedDesc = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uiCreatTime, 0);
        String str = this.sVideoCoverUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.sFeedDesc;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public FeedsData(long j3, String str, String str2) {
        this.uiCreatTime = j3;
        this.sVideoCoverUrl = str;
        this.sFeedDesc = str2;
    }
}

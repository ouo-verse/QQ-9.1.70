package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ShuoShuoUgcDeco extends JceStruct {
    static FeedSkin cache_stFeedSkin = new FeedSkin();
    public FeedSkin stFeedSkin;

    public ShuoShuoUgcDeco() {
        this.stFeedSkin = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stFeedSkin = (FeedSkin) jceInputStream.read((JceStruct) cache_stFeedSkin, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        FeedSkin feedSkin = this.stFeedSkin;
        if (feedSkin != null) {
            jceOutputStream.write((JceStruct) feedSkin, 0);
        }
    }

    public ShuoShuoUgcDeco(FeedSkin feedSkin) {
        this.stFeedSkin = feedSkin;
    }
}

package NS_QMALL_COVER;

import NS_MOBILE_CUSTOM.FeedSkinInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QzmallFeedSkin extends JceStruct {
    static FeedSkinInfo cache_stFeedSkinInfo = new FeedSkinInfo();
    public FeedSkinInfo stFeedSkinInfo;

    public QzmallFeedSkin() {
        this.stFeedSkinInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stFeedSkinInfo = (FeedSkinInfo) jceInputStream.read((JceStruct) cache_stFeedSkinInfo, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        FeedSkinInfo feedSkinInfo = this.stFeedSkinInfo;
        if (feedSkinInfo != null) {
            jceOutputStream.write((JceStruct) feedSkinInfo, 0);
        }
    }

    public QzmallFeedSkin(FeedSkinInfo feedSkinInfo) {
        this.stFeedSkinInfo = feedSkinInfo;
    }
}

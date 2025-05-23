package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stSimpleGetFeedDetailRsp extends JceStruct {
    static stSimpleMetaFeed cache_feed = new stSimpleMetaFeed();
    public stSimpleMetaFeed feed;

    public stSimpleGetFeedDetailRsp() {
        this.feed = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.feed = (stSimpleMetaFeed) jceInputStream.read((JceStruct) cache_feed, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stSimpleMetaFeed stsimplemetafeed = this.feed;
        if (stsimplemetafeed != null) {
            jceOutputStream.write((JceStruct) stsimplemetafeed, 0);
        }
    }

    public stSimpleGetFeedDetailRsp(stSimpleMetaFeed stsimplemetafeed) {
        this.feed = stsimplemetafeed;
    }
}

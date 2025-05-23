package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetAIOFeedDetailRsp extends JceStruct {
    static stSimpleMetaFeed cache_feed = new stSimpleMetaFeed();
    public boolean enable;
    public stSimpleMetaFeed feed;

    public stGetAIOFeedDetailRsp() {
        this.enable = true;
        this.feed = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.enable = jceInputStream.read(this.enable, 0, false);
        this.feed = (stSimpleMetaFeed) jceInputStream.read((JceStruct) cache_feed, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.enable, 0);
        stSimpleMetaFeed stsimplemetafeed = this.feed;
        if (stsimplemetafeed != null) {
            jceOutputStream.write((JceStruct) stsimplemetafeed, 1);
        }
    }

    public stGetAIOFeedDetailRsp(boolean z16, stSimpleMetaFeed stsimplemetafeed) {
        this.enable = z16;
        this.feed = stsimplemetafeed;
    }
}

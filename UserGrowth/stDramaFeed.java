package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stDramaFeed extends JceStruct {
    static stSimpleMetaFeed cache_feed = new stSimpleMetaFeed();
    public String dramaID;
    public stSimpleMetaFeed feed;

    /* renamed from: id, reason: collision with root package name */
    public String f25115id;
    public int num;

    public stDramaFeed() {
        this.f25115id = "";
        this.feed = null;
        this.num = 0;
        this.dramaID = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25115id = jceInputStream.readString(0, false);
        this.feed = (stSimpleMetaFeed) jceInputStream.read((JceStruct) cache_feed, 1, false);
        this.num = jceInputStream.read(this.num, 2, false);
        this.dramaID = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.f25115id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        stSimpleMetaFeed stsimplemetafeed = this.feed;
        if (stsimplemetafeed != null) {
            jceOutputStream.write((JceStruct) stsimplemetafeed, 1);
        }
        jceOutputStream.write(this.num, 2);
        String str2 = this.dramaID;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public stDramaFeed(String str, stSimpleMetaFeed stsimplemetafeed, int i3, String str2) {
        this.f25115id = str;
        this.feed = stsimplemetafeed;
        this.num = i3;
        this.dramaID = str2;
    }
}

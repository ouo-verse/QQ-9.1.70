package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFeed extends JceStruct {
    static stFriendFeed cache_friendFeed;
    static stSplitBlock cache_recommend_splitter;
    public stSimpleMetaFeed feed;
    public int feed_type;
    public stFriendFeed friendFeed;
    public ArrayList<stSimpleMetaPerson> person_meta;
    public stSplitBlock recommend_splitter;
    static stSimpleMetaFeed cache_feed = new stSimpleMetaFeed();
    static ArrayList<stSimpleMetaPerson> cache_person_meta = new ArrayList<>();

    static {
        cache_person_meta.add(new stSimpleMetaPerson());
        cache_recommend_splitter = new stSplitBlock();
        cache_friendFeed = new stFriendFeed();
    }

    public stFeed() {
        this.feed = null;
        this.person_meta = null;
        this.feed_type = 0;
        this.recommend_splitter = null;
        this.friendFeed = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.feed = (stSimpleMetaFeed) jceInputStream.read((JceStruct) cache_feed, 0, false);
        this.person_meta = (ArrayList) jceInputStream.read((JceInputStream) cache_person_meta, 1, false);
        this.feed_type = jceInputStream.read(this.feed_type, 2, false);
        this.recommend_splitter = (stSplitBlock) jceInputStream.read((JceStruct) cache_recommend_splitter, 3, false);
        this.friendFeed = (stFriendFeed) jceInputStream.read((JceStruct) cache_friendFeed, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stSimpleMetaFeed stsimplemetafeed = this.feed;
        if (stsimplemetafeed != null) {
            jceOutputStream.write((JceStruct) stsimplemetafeed, 0);
        }
        ArrayList<stSimpleMetaPerson> arrayList = this.person_meta;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.feed_type, 2);
        stSplitBlock stsplitblock = this.recommend_splitter;
        if (stsplitblock != null) {
            jceOutputStream.write((JceStruct) stsplitblock, 3);
        }
        stFriendFeed stfriendfeed = this.friendFeed;
        if (stfriendfeed != null) {
            jceOutputStream.write((JceStruct) stfriendfeed, 4);
        }
    }

    public stFeed(stSimpleMetaFeed stsimplemetafeed, ArrayList<stSimpleMetaPerson> arrayList, int i3, stSplitBlock stsplitblock, stFriendFeed stfriendfeed) {
        this.feed = stsimplemetafeed;
        this.person_meta = arrayList;
        this.feed_type = i3;
        this.recommend_splitter = stsplitblock;
        this.friendFeed = stfriendfeed;
    }
}

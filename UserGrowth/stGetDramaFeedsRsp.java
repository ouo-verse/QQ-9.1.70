package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetDramaFeedsRsp extends JceStruct {
    static stDrama cache_drama = new stDrama();
    static ArrayList<stDramaFeed> cache_dramaFeeds = new ArrayList<>();
    public String attachInfo;
    public String curFeedID;
    public stDrama drama;
    public ArrayList<stDramaFeed> dramaFeeds;
    public boolean isFinished;
    public int refresh;

    static {
        cache_dramaFeeds.add(new stDramaFeed());
    }

    public stGetDramaFeedsRsp() {
        this.attachInfo = "";
        this.isFinished = true;
        this.drama = null;
        this.dramaFeeds = null;
        this.refresh = 0;
        this.curFeedID = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.attachInfo = jceInputStream.readString(0, false);
        this.isFinished = jceInputStream.read(this.isFinished, 1, false);
        this.drama = (stDrama) jceInputStream.read((JceStruct) cache_drama, 2, false);
        this.dramaFeeds = (ArrayList) jceInputStream.read((JceInputStream) cache_dramaFeeds, 3, false);
        this.refresh = jceInputStream.read(this.refresh, 4, false);
        this.curFeedID = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.attachInfo;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.isFinished, 1);
        stDrama stdrama = this.drama;
        if (stdrama != null) {
            jceOutputStream.write((JceStruct) stdrama, 2);
        }
        ArrayList<stDramaFeed> arrayList = this.dramaFeeds;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        jceOutputStream.write(this.refresh, 4);
        String str2 = this.curFeedID;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
    }

    public stGetDramaFeedsRsp(String str, boolean z16, stDrama stdrama, ArrayList<stDramaFeed> arrayList, int i3, String str2) {
        this.attachInfo = str;
        this.isFinished = z16;
        this.drama = stdrama;
        this.dramaFeeds = arrayList;
        this.refresh = i3;
        this.curFeedID = str2;
    }
}

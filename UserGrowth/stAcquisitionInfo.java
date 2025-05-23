package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stAcquisitionInfo extends JceStruct {
    static stBusinessIconInfo cache_businessIcon = new stBusinessIconInfo();
    static stFeedIconOpConf cache_feedIconOpConf = new stFeedIconOpConf();
    static ArrayList<sTadLowItem> cache_items = new ArrayList<>();
    private static final long serialVersionUID = 0;
    public int adId = 0;
    public String relateFeedId = "";
    public stBusinessIconInfo businessIcon = null;
    public stFeedIconOpConf feedIconOpConf = null;
    public String installSchema = "";
    public int adStyle = 0;
    public int hotRegion = 0;
    public ArrayList<sTadLowItem> items = null;
    public int isLoop = 0;

    static {
        cache_items.add(new sTadLowItem());
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.adId = jceInputStream.read(this.adId, 0, false);
        this.relateFeedId = jceInputStream.readString(1, false);
        this.businessIcon = (stBusinessIconInfo) jceInputStream.read((JceStruct) cache_businessIcon, 2, false);
        this.feedIconOpConf = (stFeedIconOpConf) jceInputStream.read((JceStruct) cache_feedIconOpConf, 3, false);
        this.installSchema = jceInputStream.readString(4, false);
        this.adStyle = jceInputStream.read(this.adStyle, 5, false);
        this.hotRegion = jceInputStream.read(this.hotRegion, 6, false);
        this.items = (ArrayList) jceInputStream.read((JceInputStream) cache_items, 7, false);
        this.isLoop = jceInputStream.read(this.isLoop, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.adId, 0);
        String str = this.relateFeedId;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        stBusinessIconInfo stbusinessiconinfo = this.businessIcon;
        if (stbusinessiconinfo != null) {
            jceOutputStream.write((JceStruct) stbusinessiconinfo, 2);
        }
        stFeedIconOpConf stfeediconopconf = this.feedIconOpConf;
        if (stfeediconopconf != null) {
            jceOutputStream.write((JceStruct) stfeediconopconf, 3);
        }
        String str2 = this.installSchema;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.adStyle, 5);
        jceOutputStream.write(this.hotRegion, 6);
        ArrayList<sTadLowItem> arrayList = this.items;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 7);
        }
        jceOutputStream.write(this.isLoop, 8);
    }
}

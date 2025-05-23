package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_get_eggskeyword_rsp extends JceStruct {
    static GuidePaster cache_guidePaster;
    static Map<String, String> cache_mapKeyWord;
    static Map<String, ImageSummaryList> cache_mapKeyWordEggs;
    public GuidePaster guidePaster;
    public int ifOpenEntrance;
    public Map<String, String> mapKeyWord;
    public Map<String, ImageSummaryList> mapKeyWordEggs;
    public long updatetime;

    public operation_get_eggskeyword_rsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ifOpenEntrance = jceInputStream.read(this.ifOpenEntrance, 0, true);
        if (cache_mapKeyWordEggs == null) {
            cache_mapKeyWordEggs = new HashMap();
            cache_mapKeyWordEggs.put("", new ImageSummaryList());
        }
        this.mapKeyWordEggs = (Map) jceInputStream.read((JceInputStream) cache_mapKeyWordEggs, 1, false);
        if (cache_mapKeyWord == null) {
            HashMap hashMap = new HashMap();
            cache_mapKeyWord = hashMap;
            hashMap.put("", "");
        }
        this.mapKeyWord = (Map) jceInputStream.read((JceInputStream) cache_mapKeyWord, 2, false);
        if (cache_guidePaster == null) {
            cache_guidePaster = new GuidePaster();
        }
        this.guidePaster = (GuidePaster) jceInputStream.read((JceStruct) cache_guidePaster, 3, false);
        this.updatetime = jceInputStream.read(this.updatetime, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ifOpenEntrance, 0);
        Map<String, ImageSummaryList> map = this.mapKeyWordEggs;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        Map<String, String> map2 = this.mapKeyWord;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 2);
        }
        GuidePaster guidePaster = this.guidePaster;
        if (guidePaster != null) {
            jceOutputStream.write((JceStruct) guidePaster, 3);
        }
        jceOutputStream.write(this.updatetime, 4);
    }

    public operation_get_eggskeyword_rsp(int i3, Map<String, ImageSummaryList> map, Map<String, String> map2, GuidePaster guidePaster, long j3) {
        this.ifOpenEntrance = i3;
        this.mapKeyWordEggs = map;
        this.mapKeyWord = map2;
        this.guidePaster = guidePaster;
        this.updatetime = j3;
    }
}

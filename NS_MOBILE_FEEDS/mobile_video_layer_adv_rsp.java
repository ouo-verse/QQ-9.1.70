package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_video_layer_adv_rsp extends JceStruct {
    static ArrayList<single_feed> cache_all_feeds_adv = new ArrayList<>();
    static ArrayList<single_feed> cache_all_pop_adv;
    static ArrayList<s_premovie_adv> cache_all_premovie_adv;
    static Map<String, single_feed> cache_all_tips_adv;
    static Map<String, String> cache_mapExt;
    public ArrayList<single_feed> all_feeds_adv;
    public ArrayList<single_feed> all_pop_adv;
    public ArrayList<s_premovie_adv> all_premovie_adv;
    public Map<String, single_feed> all_tips_adv;
    public Map<String, String> mapExt;

    static {
        cache_all_feeds_adv.add(new single_feed());
        cache_all_tips_adv = new HashMap();
        cache_all_tips_adv.put("", new single_feed());
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
        cache_all_premovie_adv = new ArrayList<>();
        cache_all_premovie_adv.add(new s_premovie_adv());
        cache_all_pop_adv = new ArrayList<>();
        cache_all_pop_adv.add(new single_feed());
    }

    public mobile_video_layer_adv_rsp() {
        this.all_feeds_adv = null;
        this.all_tips_adv = null;
        this.mapExt = null;
        this.all_premovie_adv = null;
        this.all_pop_adv = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.all_feeds_adv = (ArrayList) jceInputStream.read((JceInputStream) cache_all_feeds_adv, 0, false);
        this.all_tips_adv = (Map) jceInputStream.read((JceInputStream) cache_all_tips_adv, 1, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 2, false);
        this.all_premovie_adv = (ArrayList) jceInputStream.read((JceInputStream) cache_all_premovie_adv, 3, false);
        this.all_pop_adv = (ArrayList) jceInputStream.read((JceInputStream) cache_all_pop_adv, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<single_feed> arrayList = this.all_feeds_adv;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        Map<String, single_feed> map = this.all_tips_adv;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        Map<String, String> map2 = this.mapExt;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 2);
        }
        ArrayList<s_premovie_adv> arrayList2 = this.all_premovie_adv;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 3);
        }
        ArrayList<single_feed> arrayList3 = this.all_pop_adv;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 4);
        }
    }

    public mobile_video_layer_adv_rsp(ArrayList<single_feed> arrayList, Map<String, single_feed> map, Map<String, String> map2, ArrayList<s_premovie_adv> arrayList2, ArrayList<single_feed> arrayList3) {
        this.all_feeds_adv = arrayList;
        this.all_tips_adv = map;
        this.mapExt = map2;
        this.all_premovie_adv = arrayList2;
        this.all_pop_adv = arrayList3;
    }
}

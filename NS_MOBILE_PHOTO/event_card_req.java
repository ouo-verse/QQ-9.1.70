package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class event_card_req extends JceStruct {
    static Map<String, String> cache_extern;
    public ArrayList<event_card> cards;
    public Map<String, String> extern;
    public lbs_info lbs;
    public long uin;
    static lbs_info cache_lbs = new lbs_info();
    static ArrayList<event_card> cache_cards = new ArrayList<>();

    static {
        cache_cards.add(new event_card());
        HashMap hashMap = new HashMap();
        cache_extern = hashMap;
        hashMap.put("", "");
    }

    public event_card_req() {
        this.uin = 0L;
        this.lbs = null;
        this.cards = null;
        this.extern = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.lbs = (lbs_info) jceInputStream.read((JceStruct) cache_lbs, 1, true);
        this.cards = (ArrayList) jceInputStream.read((JceInputStream) cache_cards, 2, true);
        this.extern = (Map) jceInputStream.read((JceInputStream) cache_extern, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write((JceStruct) this.lbs, 1);
        jceOutputStream.write((Collection) this.cards, 2);
        Map<String, String> map = this.extern;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public event_card_req(long j3, lbs_info lbs_infoVar, ArrayList<event_card> arrayList, Map<String, String> map) {
        this.uin = j3;
        this.lbs = lbs_infoVar;
        this.cards = arrayList;
        this.extern = map;
    }
}

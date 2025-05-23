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
public final class cell_decorate extends JceStruct {
    static ArrayList<s_KapuPraise> cache_kapuPraise;
    static Map<String, byte[]> cache_mapInfoData;
    static ArrayList<s_PolyPraise> cache_pokePraise;
    static s_PrdData cache_sprdData;
    public stcustomPraise customPraise;
    public s_HighFive highFive;
    public ArrayList<s_KapuPraise> kapuPraise;
    public Map<String, byte[]> mapInfoData;
    public ArrayList<s_PolyPraise> pokePraise;
    public s_PolyPraise polyPraise;
    public s_PrdData sprdData;
    static stcustomPraise cache_customPraise = new stcustomPraise();
    static s_PolyPraise cache_polyPraise = new s_PolyPraise();
    static s_HighFive cache_highFive = new s_HighFive();

    static {
        HashMap hashMap = new HashMap();
        cache_mapInfoData = hashMap;
        hashMap.put("", new byte[]{0});
        cache_sprdData = new s_PrdData();
        cache_pokePraise = new ArrayList<>();
        cache_pokePraise.add(new s_PolyPraise());
        cache_kapuPraise = new ArrayList<>();
        cache_kapuPraise.add(new s_KapuPraise());
    }

    public cell_decorate() {
        this.customPraise = null;
        this.polyPraise = null;
        this.highFive = null;
        this.mapInfoData = null;
        this.sprdData = null;
        this.pokePraise = null;
        this.kapuPraise = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.customPraise = (stcustomPraise) jceInputStream.read((JceStruct) cache_customPraise, 0, false);
        this.polyPraise = (s_PolyPraise) jceInputStream.read((JceStruct) cache_polyPraise, 1, false);
        this.highFive = (s_HighFive) jceInputStream.read((JceStruct) cache_highFive, 2, false);
        this.mapInfoData = (Map) jceInputStream.read((JceInputStream) cache_mapInfoData, 3, false);
        this.sprdData = (s_PrdData) jceInputStream.read((JceStruct) cache_sprdData, 4, false);
        this.pokePraise = (ArrayList) jceInputStream.read((JceInputStream) cache_pokePraise, 5, false);
        this.kapuPraise = (ArrayList) jceInputStream.read((JceInputStream) cache_kapuPraise, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stcustomPraise stcustompraise = this.customPraise;
        if (stcustompraise != null) {
            jceOutputStream.write((JceStruct) stcustompraise, 0);
        }
        s_PolyPraise s_polypraise = this.polyPraise;
        if (s_polypraise != null) {
            jceOutputStream.write((JceStruct) s_polypraise, 1);
        }
        s_HighFive s_highfive = this.highFive;
        if (s_highfive != null) {
            jceOutputStream.write((JceStruct) s_highfive, 2);
        }
        Map<String, byte[]> map = this.mapInfoData;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        s_PrdData s_prddata = this.sprdData;
        if (s_prddata != null) {
            jceOutputStream.write((JceStruct) s_prddata, 4);
        }
        ArrayList<s_PolyPraise> arrayList = this.pokePraise;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 5);
        }
        ArrayList<s_KapuPraise> arrayList2 = this.kapuPraise;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 6);
        }
    }

    public cell_decorate(stcustomPraise stcustompraise, s_PolyPraise s_polypraise, s_HighFive s_highfive, Map<String, byte[]> map, s_PrdData s_prddata, ArrayList<s_PolyPraise> arrayList, ArrayList<s_KapuPraise> arrayList2) {
        this.customPraise = stcustompraise;
        this.polyPraise = s_polypraise;
        this.highFive = s_highfive;
        this.mapInfoData = map;
        this.sprdData = s_prddata;
        this.pokePraise = arrayList;
        this.kapuPraise = arrayList2;
    }
}

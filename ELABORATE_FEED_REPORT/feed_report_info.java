package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class feed_report_info extends JceStruct {
    static int cache_eLayerTtype;
    static Map<Integer, String> cache_mapFeedCookie = new HashMap();
    static Map<Integer, String> cache_mapParentFeedCookie;
    static ArrayList<action_flow> cache_vecActionFlow;
    public int eLayerTtype;
    public Map<Integer, String> mapFeedCookie;
    public Map<Integer, String> mapParentFeedCookie;
    public int uFeedIndex;
    public long uLayerNumber;
    public ArrayList<action_flow> vecActionFlow;

    static {
        cache_mapFeedCookie.put(0, "");
        cache_vecActionFlow = new ArrayList<>();
        cache_vecActionFlow.add(new action_flow());
        cache_mapParentFeedCookie = new HashMap();
        cache_mapParentFeedCookie.put(0, "");
        cache_eLayerTtype = 0;
    }

    public feed_report_info() {
        this.mapFeedCookie = null;
        this.uFeedIndex = 0;
        this.vecActionFlow = null;
        this.mapParentFeedCookie = null;
        this.uLayerNumber = 0L;
        this.eLayerTtype = -1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mapFeedCookie = (Map) jceInputStream.read((JceInputStream) cache_mapFeedCookie, 0, false);
        this.uFeedIndex = jceInputStream.read(this.uFeedIndex, 1, false);
        this.vecActionFlow = (ArrayList) jceInputStream.read((JceInputStream) cache_vecActionFlow, 2, false);
        this.mapParentFeedCookie = (Map) jceInputStream.read((JceInputStream) cache_mapParentFeedCookie, 3, false);
        this.uLayerNumber = jceInputStream.read(this.uLayerNumber, 4, false);
        this.eLayerTtype = jceInputStream.read(this.eLayerTtype, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Integer, String> map = this.mapFeedCookie;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
        jceOutputStream.write(this.uFeedIndex, 1);
        ArrayList<action_flow> arrayList = this.vecActionFlow;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        Map<Integer, String> map2 = this.mapParentFeedCookie;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 3);
        }
        jceOutputStream.write(this.uLayerNumber, 4);
        jceOutputStream.write(this.eLayerTtype, 5);
    }

    public feed_report_info(Map<Integer, String> map, int i3, ArrayList<action_flow> arrayList, Map<Integer, String> map2, long j3, int i16) {
        this.mapFeedCookie = map;
        this.uFeedIndex = i3;
        this.vecActionFlow = arrayList;
        this.mapParentFeedCookie = map2;
        this.uLayerNumber = j3;
        this.eLayerTtype = i16;
    }
}

package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class tag_together_query_rsp extends JceStruct {
    static Map<Long, String> cache_mapClassId2Text;
    public Map<Long, ArrayList<Long>> mapClassContrastList;
    public Map<Long, String> mapClassId2Text;
    public tag_deatail_info stTagDetailInfo;
    static tag_deatail_info cache_stTagDetailInfo = new tag_deatail_info();
    static Map<Long, ArrayList<Long>> cache_mapClassContrastList = new HashMap();

    static {
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(0L);
        cache_mapClassContrastList.put(0L, arrayList);
        cache_mapClassId2Text = new HashMap();
        cache_mapClassId2Text.put(0L, "");
    }

    public tag_together_query_rsp() {
        this.stTagDetailInfo = null;
        this.mapClassContrastList = null;
        this.mapClassId2Text = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stTagDetailInfo = (tag_deatail_info) jceInputStream.read((JceStruct) cache_stTagDetailInfo, 0, false);
        this.mapClassContrastList = (Map) jceInputStream.read((JceInputStream) cache_mapClassContrastList, 1, false);
        this.mapClassId2Text = (Map) jceInputStream.read((JceInputStream) cache_mapClassId2Text, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        tag_deatail_info tag_deatail_infoVar = this.stTagDetailInfo;
        if (tag_deatail_infoVar != null) {
            jceOutputStream.write((JceStruct) tag_deatail_infoVar, 0);
        }
        Map<Long, ArrayList<Long>> map = this.mapClassContrastList;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        Map<Long, String> map2 = this.mapClassId2Text;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 2);
        }
    }

    public tag_together_query_rsp(tag_deatail_info tag_deatail_infoVar, Map<Long, ArrayList<Long>> map, Map<Long, String> map2) {
        this.stTagDetailInfo = tag_deatail_infoVar;
        this.mapClassContrastList = map;
        this.mapClassId2Text = map2;
    }
}

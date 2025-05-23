package NS_MOBILE_FEEDS;

import NS_MOBILE_COMM.sparkle_word;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_summary extends JceStruct {
    static Map<String, String> cache_mapExt;
    static Map<String, byte[]> cache_mapProtoExt;
    static sparkle_word cache_sparkleword;
    static ArrayList<s_picdata> cache_summarypic = new ArrayList<>();
    public int actiontype;
    public String actionurl;
    public int hasmore;
    public Map<String, String> mapExt;
    public Map<String, byte[]> mapProtoExt;
    public String more_info;
    public sparkle_word sparkleword;
    public String summary;
    public ArrayList<s_picdata> summarypic;

    static {
        cache_summarypic.add(new s_picdata());
        cache_sparkleword = new sparkle_word();
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
        HashMap hashMap2 = new HashMap();
        cache_mapProtoExt = hashMap2;
        hashMap2.put("", new byte[]{0});
    }

    public cell_summary() {
        this.summary = "";
        this.hasmore = 0;
        this.actiontype = 0;
        this.summarypic = null;
        this.more_info = "";
        this.sparkleword = null;
        this.mapExt = null;
        this.mapProtoExt = null;
        this.actionurl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.summary = jceInputStream.readString(0, false);
        this.hasmore = jceInputStream.read(this.hasmore, 1, false);
        this.actiontype = jceInputStream.read(this.actiontype, 2, false);
        this.summarypic = (ArrayList) jceInputStream.read((JceInputStream) cache_summarypic, 3, false);
        this.more_info = jceInputStream.readString(4, false);
        this.sparkleword = (sparkle_word) jceInputStream.read((JceStruct) cache_sparkleword, 5, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 6, false);
        this.mapProtoExt = (Map) jceInputStream.read((JceInputStream) cache_mapProtoExt, 7, false);
        this.actionurl = jceInputStream.readString(8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.summary;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.hasmore, 1);
        jceOutputStream.write(this.actiontype, 2);
        ArrayList<s_picdata> arrayList = this.summarypic;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        String str2 = this.more_info;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        sparkle_word sparkle_wordVar = this.sparkleword;
        if (sparkle_wordVar != null) {
            jceOutputStream.write((JceStruct) sparkle_wordVar, 5);
        }
        Map<String, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
        Map<String, byte[]> map2 = this.mapProtoExt;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 7);
        }
        String str3 = this.actionurl;
        if (str3 != null) {
            jceOutputStream.write(str3, 8);
        }
    }

    public cell_summary(String str, int i3, int i16, ArrayList<s_picdata> arrayList, String str2, sparkle_word sparkle_wordVar, Map<String, String> map, Map<String, byte[]> map2, String str3) {
        this.summary = str;
        this.hasmore = i3;
        this.actiontype = i16;
        this.summarypic = arrayList;
        this.more_info = str2;
        this.sparkleword = sparkle_wordVar;
        this.mapExt = map;
        this.mapProtoExt = map2;
        this.actionurl = str3;
    }
}

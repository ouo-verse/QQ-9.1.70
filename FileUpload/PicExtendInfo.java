package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class PicExtendInfo extends JceStruct {
    static Map<String, String> cache_mapExif;
    static Map<String, String> cache_mapParams;
    static ArrayList<QuanInfo> cache_vQuanInfo = new ArrayList<>();
    public int iEffect;
    public Map<String, String> mapExif;
    public Map<String, String> mapParams;
    public String sUserDefineSource;
    public ArrayList<QuanInfo> vQuanInfo;

    static {
        cache_vQuanInfo.add(new QuanInfo());
        HashMap hashMap = new HashMap();
        cache_mapExif = hashMap;
        hashMap.put("", "");
        HashMap hashMap2 = new HashMap();
        cache_mapParams = hashMap2;
        hashMap2.put("", "");
    }

    public PicExtendInfo() {
        this.iEffect = 0;
        this.vQuanInfo = null;
        this.mapExif = null;
        this.sUserDefineSource = "";
        this.mapParams = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iEffect = jceInputStream.read(this.iEffect, 0, false);
        this.vQuanInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vQuanInfo, 1, false);
        this.mapExif = (Map) jceInputStream.read((JceInputStream) cache_mapExif, 2, false);
        this.sUserDefineSource = jceInputStream.readString(3, false);
        this.mapParams = (Map) jceInputStream.read((JceInputStream) cache_mapParams, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iEffect, 0);
        ArrayList<QuanInfo> arrayList = this.vQuanInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        Map<String, String> map = this.mapExif;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        String str = this.sUserDefineSource;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        Map<String, String> map2 = this.mapParams;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 4);
        }
    }

    public PicExtendInfo(int i3, ArrayList<QuanInfo> arrayList, Map<String, String> map, String str, Map<String, String> map2) {
        this.iEffect = i3;
        this.vQuanInfo = arrayList;
        this.mapExif = map;
        this.sUserDefineSource = str;
        this.mapParams = map2;
    }
}

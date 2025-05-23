package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_COVER_DATE.CoverPackageInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_get_cover_rsp extends JceStruct {
    static Map<String, String> cache_MulRelsotionUrl;
    static CoverPackageInfo cache_packageInfo;
    static ArrayList<Map<Integer, String>> cache_vecUrls;
    public Map<String, String> MulRelsotionUrl;
    public String cover;

    /* renamed from: id, reason: collision with root package name */
    public String f25005id;
    public CoverPackageInfo packageInfo;
    public int photoWallCombinePic;
    public String type;
    public ArrayList<Map<Integer, String>> vecUrls;

    public mobile_sub_get_cover_rsp() {
        this.cover = "";
        this.type = "";
        this.f25005id = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cover = jceInputStream.readString(0, false);
        this.type = jceInputStream.readString(1, false);
        if (cache_MulRelsotionUrl == null) {
            HashMap hashMap = new HashMap();
            cache_MulRelsotionUrl = hashMap;
            hashMap.put("", "");
        }
        this.MulRelsotionUrl = (Map) jceInputStream.read((JceInputStream) cache_MulRelsotionUrl, 2, false);
        if (cache_packageInfo == null) {
            cache_packageInfo = new CoverPackageInfo();
        }
        this.packageInfo = (CoverPackageInfo) jceInputStream.read((JceStruct) cache_packageInfo, 3, false);
        if (cache_vecUrls == null) {
            cache_vecUrls = new ArrayList<>();
            HashMap hashMap2 = new HashMap();
            hashMap2.put(0, "");
            cache_vecUrls.add(hashMap2);
        }
        this.vecUrls = (ArrayList) jceInputStream.read((JceInputStream) cache_vecUrls, 4, false);
        this.f25005id = jceInputStream.readString(5, false);
        this.photoWallCombinePic = jceInputStream.read(this.photoWallCombinePic, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.cover;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.type;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        Map<String, String> map = this.MulRelsotionUrl;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        CoverPackageInfo coverPackageInfo = this.packageInfo;
        if (coverPackageInfo != null) {
            jceOutputStream.write((JceStruct) coverPackageInfo, 3);
        }
        ArrayList<Map<Integer, String>> arrayList = this.vecUrls;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        String str3 = this.f25005id;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        jceOutputStream.write(this.photoWallCombinePic, 6);
    }

    public mobile_sub_get_cover_rsp(String str, String str2, Map<String, String> map, CoverPackageInfo coverPackageInfo, ArrayList<Map<Integer, String>> arrayList, String str3, int i3) {
        this.cover = str;
        this.type = str2;
        this.MulRelsotionUrl = map;
        this.packageInfo = coverPackageInfo;
        this.vecUrls = arrayList;
        this.f25005id = str3;
        this.photoWallCombinePic = i3;
    }
}

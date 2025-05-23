package NS_MOBILE_COVER_DATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class feeds_cover extends JceStruct {
    static Map<String, String> cache_MulRelsotionUrl;
    static GameCoverInfo cache_gameCoverInfo;
    static Map<String, String> cache_mapExtInfo;
    static CoverPackageInfo cache_packageInfo;
    static ArrayList<Map<Integer, String>> cache_vecUrls;
    public Map<String, String> MulRelsotionUrl;
    public GameCoverInfo gameCoverInfo;

    /* renamed from: id, reason: collision with root package name */
    public String f24972id;
    public Map<String, String> mapExtInfo;
    public CoverPackageInfo packageInfo;
    public int photoWallCombinePic;
    public String type;
    public ArrayList<Map<Integer, String>> vecUrls;

    public feeds_cover() {
        this.type = "";
        this.f24972id = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.readString(0, false);
        if (cache_MulRelsotionUrl == null) {
            HashMap hashMap = new HashMap();
            cache_MulRelsotionUrl = hashMap;
            hashMap.put("", "");
        }
        this.MulRelsotionUrl = (Map) jceInputStream.read((JceInputStream) cache_MulRelsotionUrl, 1, false);
        if (cache_packageInfo == null) {
            cache_packageInfo = new CoverPackageInfo();
        }
        this.packageInfo = (CoverPackageInfo) jceInputStream.read((JceStruct) cache_packageInfo, 2, false);
        if (cache_vecUrls == null) {
            cache_vecUrls = new ArrayList<>();
            HashMap hashMap2 = new HashMap();
            hashMap2.put(0, "");
            cache_vecUrls.add(hashMap2);
        }
        this.vecUrls = (ArrayList) jceInputStream.read((JceInputStream) cache_vecUrls, 3, false);
        this.f24972id = jceInputStream.readString(4, false);
        this.photoWallCombinePic = jceInputStream.read(this.photoWallCombinePic, 5, false);
        if (cache_gameCoverInfo == null) {
            cache_gameCoverInfo = new GameCoverInfo();
        }
        this.gameCoverInfo = (GameCoverInfo) jceInputStream.read((JceStruct) cache_gameCoverInfo, 6, false);
        if (cache_mapExtInfo == null) {
            HashMap hashMap3 = new HashMap();
            cache_mapExtInfo = hashMap3;
            hashMap3.put("", "");
        }
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.type;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        Map<String, String> map = this.MulRelsotionUrl;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        CoverPackageInfo coverPackageInfo = this.packageInfo;
        if (coverPackageInfo != null) {
            jceOutputStream.write((JceStruct) coverPackageInfo, 2);
        }
        ArrayList<Map<Integer, String>> arrayList = this.vecUrls;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        String str2 = this.f24972id;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.photoWallCombinePic, 5);
        GameCoverInfo gameCoverInfo = this.gameCoverInfo;
        if (gameCoverInfo != null) {
            jceOutputStream.write((JceStruct) gameCoverInfo, 6);
        }
        Map<String, String> map2 = this.mapExtInfo;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 7);
        }
    }

    public feeds_cover(String str, Map<String, String> map, CoverPackageInfo coverPackageInfo, ArrayList<Map<Integer, String>> arrayList, String str2, int i3, GameCoverInfo gameCoverInfo, Map<String, String> map2) {
        this.type = str;
        this.MulRelsotionUrl = map;
        this.packageInfo = coverPackageInfo;
        this.vecUrls = arrayList;
        this.f24972id = str2;
        this.photoWallCombinePic = i3;
        this.gameCoverInfo = gameCoverInfo;
        this.mapExtInfo = map2;
    }
}

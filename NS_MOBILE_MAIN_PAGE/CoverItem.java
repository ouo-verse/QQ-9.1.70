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
public final class CoverItem extends JceStruct {
    static Map<String, String> cache_extendinfo;
    static ArrayList<String> cache_imageUrls;
    static ArrayList<String> cache_imageUrls340;
    static ArrayList<CoverPackageInfo> cache_packages;
    public String description;
    public Map<String, String> extendinfo;

    /* renamed from: id, reason: collision with root package name */
    public String f25000id;
    public ArrayList<String> imageUrls;
    public ArrayList<String> imageUrls340;
    public int initIndex;
    public int isFree;
    public int isNew;
    public int isVip;
    public int manyBits;
    public String name;
    public ArrayList<CoverPackageInfo> packages;
    public String size;
    public String thumbUrl;
    public String type;

    public CoverItem() {
        this.f25000id = "";
        this.type = "";
        this.thumbUrl = "";
        this.name = "";
        this.size = "";
        this.description = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25000id = jceInputStream.readString(0, false);
        this.type = jceInputStream.readString(1, false);
        if (cache_imageUrls == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            cache_imageUrls = arrayList;
            arrayList.add("");
        }
        this.imageUrls = (ArrayList) jceInputStream.read((JceInputStream) cache_imageUrls, 2, false);
        this.thumbUrl = jceInputStream.readString(3, false);
        this.isVip = jceInputStream.read(this.isVip, 4, false);
        this.initIndex = jceInputStream.read(this.initIndex, 5, false);
        this.name = jceInputStream.readString(6, false);
        if (cache_packages == null) {
            cache_packages = new ArrayList<>();
            cache_packages.add(new CoverPackageInfo());
        }
        this.packages = (ArrayList) jceInputStream.read((JceInputStream) cache_packages, 7, false);
        this.size = jceInputStream.readString(8, false);
        this.isFree = jceInputStream.read(this.isFree, 9, false);
        this.isNew = jceInputStream.read(this.isNew, 10, false);
        this.description = jceInputStream.readString(11, false);
        this.manyBits = jceInputStream.read(this.manyBits, 12, false);
        if (cache_extendinfo == null) {
            HashMap hashMap = new HashMap();
            cache_extendinfo = hashMap;
            hashMap.put("", "");
        }
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 13, false);
        if (cache_imageUrls340 == null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            cache_imageUrls340 = arrayList2;
            arrayList2.add("");
        }
        this.imageUrls340 = (ArrayList) jceInputStream.read((JceInputStream) cache_imageUrls340, 14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.f25000id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.type;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        ArrayList<String> arrayList = this.imageUrls;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        String str3 = this.thumbUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.isVip, 4);
        jceOutputStream.write(this.initIndex, 5);
        String str4 = this.name;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        ArrayList<CoverPackageInfo> arrayList2 = this.packages;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 7);
        }
        String str5 = this.size;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
        jceOutputStream.write(this.isFree, 9);
        jceOutputStream.write(this.isNew, 10);
        String str6 = this.description;
        if (str6 != null) {
            jceOutputStream.write(str6, 11);
        }
        jceOutputStream.write(this.manyBits, 12);
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 13);
        }
        ArrayList<String> arrayList3 = this.imageUrls340;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 14);
        }
    }

    public CoverItem(String str, String str2, ArrayList<String> arrayList, String str3, int i3, int i16, String str4, ArrayList<CoverPackageInfo> arrayList2, String str5, int i17, int i18, String str6, int i19, Map<String, String> map, ArrayList<String> arrayList3) {
        this.f25000id = str;
        this.type = str2;
        this.imageUrls = arrayList;
        this.thumbUrl = str3;
        this.isVip = i3;
        this.initIndex = i16;
        this.name = str4;
        this.packages = arrayList2;
        this.size = str5;
        this.isFree = i17;
        this.isNew = i18;
        this.description = str6;
        this.manyBits = i19;
        this.extendinfo = map;
        this.imageUrls340 = arrayList3;
    }
}

package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CoverCate extends JceStruct {
    static ArrayList<CoverItem> cache_items;
    public String attachInfo;
    public String description;
    public int hasMore;

    /* renamed from: id, reason: collision with root package name */
    public String f24999id;
    public ArrayList<CoverItem> items;
    public int manyBits;
    public String name;
    public int showCount;
    public int totalCount;
    public int type;
    public String zhuanTiBannerUrl;
    public String zhuanTiThumbUrl;

    public CoverCate() {
        this.name = "";
        this.attachInfo = "";
        this.f24999id = "";
        this.description = "";
        this.zhuanTiThumbUrl = "";
        this.zhuanTiBannerUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.name = jceInputStream.readString(0, false);
        if (cache_items == null) {
            cache_items = new ArrayList<>();
            cache_items.add(new CoverItem());
        }
        this.items = (ArrayList) jceInputStream.read((JceInputStream) cache_items, 1, false);
        this.showCount = jceInputStream.read(this.showCount, 2, false);
        this.totalCount = jceInputStream.read(this.totalCount, 3, false);
        this.hasMore = jceInputStream.read(this.hasMore, 4, false);
        this.attachInfo = jceInputStream.readString(5, false);
        this.f24999id = jceInputStream.readString(6, false);
        this.description = jceInputStream.readString(7, false);
        this.type = jceInputStream.read(this.type, 8, false);
        this.zhuanTiThumbUrl = jceInputStream.readString(9, false);
        this.zhuanTiBannerUrl = jceInputStream.readString(10, false);
        this.manyBits = jceInputStream.read(this.manyBits, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.name;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        ArrayList<CoverItem> arrayList = this.items;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.showCount, 2);
        jceOutputStream.write(this.totalCount, 3);
        jceOutputStream.write(this.hasMore, 4);
        String str2 = this.attachInfo;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        String str3 = this.f24999id;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        String str4 = this.description;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        jceOutputStream.write(this.type, 8);
        String str5 = this.zhuanTiThumbUrl;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
        String str6 = this.zhuanTiBannerUrl;
        if (str6 != null) {
            jceOutputStream.write(str6, 10);
        }
        jceOutputStream.write(this.manyBits, 11);
    }

    public CoverCate(String str, ArrayList<CoverItem> arrayList, int i3, int i16, int i17, String str2, String str3, String str4, int i18, String str5, String str6, int i19) {
        this.name = str;
        this.items = arrayList;
        this.showCount = i3;
        this.totalCount = i16;
        this.hasMore = i17;
        this.attachInfo = str2;
        this.f24999id = str3;
        this.description = str4;
        this.type = i18;
        this.zhuanTiThumbUrl = str5;
        this.zhuanTiBannerUrl = str6;
        this.manyBits = i19;
    }
}

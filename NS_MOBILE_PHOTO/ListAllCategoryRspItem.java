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
public final class ListAllCategoryRspItem extends JceStruct {
    static Map<String, CategoryPhoto> cache_categoryid_photos;
    static ArrayList<SummaryInfo> cache_categoryid_summaryinfos = new ArrayList<>();
    public Map<String, CategoryPhoto> categoryid_photos;
    public ArrayList<SummaryInfo> categoryid_summaryinfos;
    public boolean has_more;
    public String page_str;
    public int ret;
    public long total;

    static {
        cache_categoryid_summaryinfos.add(new SummaryInfo());
        cache_categoryid_photos = new HashMap();
        cache_categoryid_photos.put("", new CategoryPhoto());
    }

    public ListAllCategoryRspItem() {
        this.categoryid_summaryinfos = null;
        this.categoryid_photos = null;
        this.has_more = false;
        this.page_str = "";
        this.total = 0L;
        this.ret = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.categoryid_summaryinfos = (ArrayList) jceInputStream.read((JceInputStream) cache_categoryid_summaryinfos, 0, false);
        this.categoryid_photos = (Map) jceInputStream.read((JceInputStream) cache_categoryid_photos, 1, false);
        this.has_more = jceInputStream.read(this.has_more, 2, false);
        this.page_str = jceInputStream.readString(3, false);
        this.total = jceInputStream.read(this.total, 4, false);
        this.ret = jceInputStream.read(this.ret, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<SummaryInfo> arrayList = this.categoryid_summaryinfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        Map<String, CategoryPhoto> map = this.categoryid_photos;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        jceOutputStream.write(this.has_more, 2);
        String str = this.page_str;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.total, 4);
        jceOutputStream.write(this.ret, 5);
    }

    public ListAllCategoryRspItem(ArrayList<SummaryInfo> arrayList, Map<String, CategoryPhoto> map, boolean z16, String str, long j3, int i3) {
        this.categoryid_summaryinfos = arrayList;
        this.categoryid_photos = map;
        this.has_more = z16;
        this.page_str = str;
        this.total = j3;
        this.ret = i3;
    }
}

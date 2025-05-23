package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CoverRecommend extends JceStruct {
    static ArrayList<String> cache_imageUrls;
    static CoverItem cache_item;
    static CoverCate cache_zhuanti;
    public ArrayList<String> imageUrls;
    public CoverItem item;
    public String jumpUrl;
    public int type;
    public CoverCate zhuanti;

    public CoverRecommend() {
        this.jumpUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_imageUrls == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            cache_imageUrls = arrayList;
            arrayList.add("");
        }
        this.imageUrls = (ArrayList) jceInputStream.read((JceInputStream) cache_imageUrls, 0, false);
        if (cache_item == null) {
            cache_item = new CoverItem();
        }
        this.item = (CoverItem) jceInputStream.read((JceStruct) cache_item, 1, false);
        if (cache_zhuanti == null) {
            cache_zhuanti = new CoverCate();
        }
        this.zhuanti = (CoverCate) jceInputStream.read((JceStruct) cache_zhuanti, 2, false);
        this.type = jceInputStream.read(this.type, 3, false);
        this.jumpUrl = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<String> arrayList = this.imageUrls;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        CoverItem coverItem = this.item;
        if (coverItem != null) {
            jceOutputStream.write((JceStruct) coverItem, 1);
        }
        CoverCate coverCate = this.zhuanti;
        if (coverCate != null) {
            jceOutputStream.write((JceStruct) coverCate, 2);
        }
        jceOutputStream.write(this.type, 3);
        String str = this.jumpUrl;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public CoverRecommend(ArrayList<String> arrayList, CoverItem coverItem, CoverCate coverCate, int i3, String str) {
        this.imageUrls = arrayList;
        this.item = coverItem;
        this.zhuanti = coverCate;
        this.type = i3;
        this.jumpUrl = str;
    }
}

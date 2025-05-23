package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CategoryRecommend extends JceStruct {
    static ArrayList<CategoryRecommendItem> cache_items = new ArrayList<>();
    public ArrayList<CategoryRecommendItem> items;

    static {
        cache_items.add(new CategoryRecommendItem());
    }

    public CategoryRecommend() {
        this.items = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.items = (ArrayList) jceInputStream.read((JceInputStream) cache_items, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<CategoryRecommendItem> arrayList = this.items;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public CategoryRecommend(ArrayList<CategoryRecommendItem> arrayList) {
        this.items = arrayList;
    }
}

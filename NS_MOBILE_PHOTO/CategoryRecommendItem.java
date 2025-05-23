package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CategoryRecommendItem extends JceStruct {
    static ArrayList<PhotoFeedsData> cache_photos = new ArrayList<>();
    public String categoryid;
    public String desc;
    public ArrayList<PhotoFeedsData> photos;

    static {
        cache_photos.add(new PhotoFeedsData());
    }

    public CategoryRecommendItem() {
        this.photos = null;
        this.categoryid = "";
        this.desc = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.photos = (ArrayList) jceInputStream.read((JceInputStream) cache_photos, 0, false);
        this.categoryid = jceInputStream.readString(1, false);
        this.desc = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<PhotoFeedsData> arrayList = this.photos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.categoryid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.desc;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public CategoryRecommendItem(ArrayList<PhotoFeedsData> arrayList, String str, String str2) {
        this.photos = arrayList;
        this.categoryid = str;
        this.desc = str2;
    }
}

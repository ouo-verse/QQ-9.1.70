package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class CategoryPhoto extends JceStruct {
    static ArrayList<PhotoFeedsData> cache_cover_photos;
    static ArrayList<PhotoFeedsData> cache_photos = new ArrayList<>();
    public String categoryid;
    public ArrayList<PhotoFeedsData> cover_photos;
    public boolean has_more;
    public String photo_page_str;
    public ArrayList<PhotoFeedsData> photos;

    static {
        cache_photos.add(new PhotoFeedsData());
        cache_cover_photos = new ArrayList<>();
        cache_cover_photos.add(new PhotoFeedsData());
    }

    public CategoryPhoto() {
        this.photos = null;
        this.categoryid = "";
        this.photo_page_str = "";
        this.has_more = false;
        this.cover_photos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.photos = (ArrayList) jceInputStream.read((JceInputStream) cache_photos, 0, false);
        this.categoryid = jceInputStream.readString(1, false);
        this.photo_page_str = jceInputStream.readString(2, false);
        this.has_more = jceInputStream.read(this.has_more, 3, false);
        this.cover_photos = (ArrayList) jceInputStream.read((JceInputStream) cache_cover_photos, 4, false);
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
        String str2 = this.photo_page_str;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.has_more, 3);
        ArrayList<PhotoFeedsData> arrayList2 = this.cover_photos;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 4);
        }
    }

    public CategoryPhoto(ArrayList<PhotoFeedsData> arrayList, String str, String str2, boolean z16, ArrayList<PhotoFeedsData> arrayList2) {
        this.photos = arrayList;
        this.categoryid = str;
        this.photo_page_str = str2;
        this.has_more = z16;
        this.cover_photos = arrayList2;
    }
}

package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class RecommendPhotos extends JceStruct {
    static PhotoDetailPageBanner cache_banner;
    static ArrayList<s_picdata> cache_recommend_photos = new ArrayList<>();
    public PhotoDetailPageBanner banner;
    public String recommend_id;
    public ArrayList<s_picdata> recommend_photos;

    static {
        cache_recommend_photos.add(new s_picdata());
        cache_banner = new PhotoDetailPageBanner();
    }

    public RecommendPhotos() {
        this.recommend_photos = null;
        this.recommend_id = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.recommend_photos = (ArrayList) jceInputStream.read((JceInputStream) cache_recommend_photos, 0, false);
        this.recommend_id = jceInputStream.readString(1, false);
        this.banner = (PhotoDetailPageBanner) jceInputStream.read((JceStruct) cache_banner, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<s_picdata> arrayList = this.recommend_photos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.recommend_id;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        PhotoDetailPageBanner photoDetailPageBanner = this.banner;
        if (photoDetailPageBanner != null) {
            jceOutputStream.write((JceStruct) photoDetailPageBanner, 2);
        }
    }

    public RecommendPhotos(ArrayList<s_picdata> arrayList, String str) {
        this.recommend_photos = arrayList;
        this.recommend_id = str;
    }

    public RecommendPhotos(ArrayList<s_picdata> arrayList, String str, PhotoDetailPageBanner photoDetailPageBanner) {
        this.recommend_photos = arrayList;
        this.recommend_id = str;
        this.banner = photoDetailPageBanner;
    }
}

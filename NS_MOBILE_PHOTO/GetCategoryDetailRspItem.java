package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetCategoryDetailRspItem extends JceStruct {
    public SummaryInfo attr;
    public ArrayList<face_show_info> face_shows;
    public boolean is_recommend_appoint;
    public CategoryPhoto photos;
    public CategoryRecommend recommend;
    public int ret;
    static CategoryPhoto cache_photos = new CategoryPhoto();
    static SummaryInfo cache_attr = new SummaryInfo();
    static CategoryRecommend cache_recommend = new CategoryRecommend();
    static ArrayList<face_show_info> cache_face_shows = new ArrayList<>();

    static {
        cache_face_shows.add(new face_show_info());
    }

    public GetCategoryDetailRspItem() {
        this.photos = null;
        this.attr = null;
        this.recommend = null;
        this.face_shows = null;
        this.ret = 0;
        this.is_recommend_appoint = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.photos = (CategoryPhoto) jceInputStream.read((JceStruct) cache_photos, 0, false);
        this.attr = (SummaryInfo) jceInputStream.read((JceStruct) cache_attr, 1, false);
        this.recommend = (CategoryRecommend) jceInputStream.read((JceStruct) cache_recommend, 2, false);
        this.face_shows = (ArrayList) jceInputStream.read((JceInputStream) cache_face_shows, 3, false);
        this.ret = jceInputStream.read(this.ret, 4, false);
        this.is_recommend_appoint = jceInputStream.read(this.is_recommend_appoint, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CategoryPhoto categoryPhoto = this.photos;
        if (categoryPhoto != null) {
            jceOutputStream.write((JceStruct) categoryPhoto, 0);
        }
        SummaryInfo summaryInfo = this.attr;
        if (summaryInfo != null) {
            jceOutputStream.write((JceStruct) summaryInfo, 1);
        }
        CategoryRecommend categoryRecommend = this.recommend;
        if (categoryRecommend != null) {
            jceOutputStream.write((JceStruct) categoryRecommend, 2);
        }
        ArrayList<face_show_info> arrayList = this.face_shows;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        jceOutputStream.write(this.ret, 4);
        jceOutputStream.write(this.is_recommend_appoint, 5);
    }

    public GetCategoryDetailRspItem(CategoryPhoto categoryPhoto, SummaryInfo summaryInfo, CategoryRecommend categoryRecommend, ArrayList<face_show_info> arrayList, int i3, boolean z16) {
        this.photos = categoryPhoto;
        this.attr = summaryInfo;
        this.recommend = categoryRecommend;
        this.face_shows = arrayList;
        this.ret = i3;
        this.is_recommend_appoint = z16;
    }
}

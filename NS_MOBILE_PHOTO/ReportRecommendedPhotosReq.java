package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ReportRecommendedPhotosReq extends JceStruct {
    static RecommendPhotos cache_recommend_photos = new RecommendPhotos();
    public RecommendPhotos recommend_photos;
    public long uin;

    public ReportRecommendedPhotosReq() {
        this.uin = 0L;
        this.recommend_photos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.recommend_photos = (RecommendPhotos) jceInputStream.read((JceStruct) cache_recommend_photos, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        RecommendPhotos recommendPhotos = this.recommend_photos;
        if (recommendPhotos != null) {
            jceOutputStream.write((JceStruct) recommendPhotos, 1);
        }
    }

    public ReportRecommendedPhotosReq(long j3, RecommendPhotos recommendPhotos) {
        this.uin = j3;
        this.recommend_photos = recommendPhotos;
    }
}

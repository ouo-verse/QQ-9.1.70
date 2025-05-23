package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class GetPhotoSearchRsp extends JceStruct {
    static PhotoSearchBox cache_photo_search_box = new PhotoSearchBox();
    static PhotoSearchBoxPhoto cache_photo_search_box_photo = new PhotoSearchBoxPhoto();
    static s_outshare cache_shareinfo = new s_outshare();

    /* renamed from: msg, reason: collision with root package name */
    public String f25027msg;
    public PhotoSearchBox photo_search_box;
    public PhotoSearchBoxPhoto photo_search_box_photo;
    public int ret;
    public long share_ctime;
    public s_outshare shareinfo;

    public GetPhotoSearchRsp() {
        this.ret = 0;
        this.f25027msg = "";
        this.photo_search_box = null;
        this.photo_search_box_photo = null;
        this.shareinfo = null;
        this.share_ctime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25027msg = jceInputStream.readString(1, false);
        this.photo_search_box = (PhotoSearchBox) jceInputStream.read((JceStruct) cache_photo_search_box, 2, false);
        this.photo_search_box_photo = (PhotoSearchBoxPhoto) jceInputStream.read((JceStruct) cache_photo_search_box_photo, 3, false);
        this.shareinfo = (s_outshare) jceInputStream.read((JceStruct) cache_shareinfo, 4, false);
        this.share_ctime = jceInputStream.read(this.share_ctime, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25027msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        PhotoSearchBox photoSearchBox = this.photo_search_box;
        if (photoSearchBox != null) {
            jceOutputStream.write((JceStruct) photoSearchBox, 2);
        }
        PhotoSearchBoxPhoto photoSearchBoxPhoto = this.photo_search_box_photo;
        if (photoSearchBoxPhoto != null) {
            jceOutputStream.write((JceStruct) photoSearchBoxPhoto, 3);
        }
        s_outshare s_outshareVar = this.shareinfo;
        if (s_outshareVar != null) {
            jceOutputStream.write((JceStruct) s_outshareVar, 4);
        }
        jceOutputStream.write(this.share_ctime, 5);
    }

    public GetPhotoSearchRsp(int i3, String str, PhotoSearchBox photoSearchBox, PhotoSearchBoxPhoto photoSearchBoxPhoto, s_outshare s_outshareVar, long j3) {
        this.ret = i3;
        this.f25027msg = str;
        this.photo_search_box = photoSearchBox;
        this.photo_search_box_photo = photoSearchBoxPhoto;
        this.shareinfo = s_outshareVar;
        this.share_ctime = j3;
    }
}

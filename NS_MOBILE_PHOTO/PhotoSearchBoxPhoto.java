package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class PhotoSearchBoxPhoto extends JceStruct {
    static ArrayList<PhotoFeedsData> cache_photos = new ArrayList<>();
    public String attach_info;
    public boolean hasmore;
    public ArrayList<PhotoFeedsData> photos;
    public long total;

    static {
        cache_photos.add(new PhotoFeedsData());
    }

    public PhotoSearchBoxPhoto() {
        this.photos = null;
        this.total = 0L;
        this.hasmore = false;
        this.attach_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.photos = (ArrayList) jceInputStream.read((JceInputStream) cache_photos, 0, false);
        this.total = jceInputStream.read(this.total, 1, false);
        this.hasmore = jceInputStream.read(this.hasmore, 2, false);
        this.attach_info = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<PhotoFeedsData> arrayList = this.photos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.total, 1);
        jceOutputStream.write(this.hasmore, 2);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }

    public PhotoSearchBoxPhoto(ArrayList<PhotoFeedsData> arrayList, long j3, boolean z16, String str) {
        this.photos = arrayList;
        this.total = j3;
        this.hasmore = z16;
        this.attach_info = str;
    }
}

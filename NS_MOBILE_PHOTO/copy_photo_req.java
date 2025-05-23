package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class copy_photo_req extends JceStruct {
    static ArrayList<st_copy_photo> cache_photos = new ArrayList<>();
    public String desc;
    public String dstAlbumType;
    public String dstAlbumid;
    public ArrayList<st_copy_photo> photos;
    public String reqSource;
    public long uin;

    static {
        cache_photos.add(new st_copy_photo());
    }

    public copy_photo_req() {
        this.uin = 0L;
        this.reqSource = "";
        this.dstAlbumid = "";
        this.dstAlbumType = "";
        this.desc = "";
        this.photos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.reqSource = jceInputStream.readString(1, true);
        this.dstAlbumid = jceInputStream.readString(2, true);
        this.dstAlbumType = jceInputStream.readString(3, true);
        this.desc = jceInputStream.readString(4, true);
        this.photos = (ArrayList) jceInputStream.read((JceInputStream) cache_photos, 5, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.reqSource, 1);
        jceOutputStream.write(this.dstAlbumid, 2);
        jceOutputStream.write(this.dstAlbumType, 3);
        jceOutputStream.write(this.desc, 4);
        jceOutputStream.write((Collection) this.photos, 5);
    }

    public copy_photo_req(long j3, String str, String str2, String str3, String str4, ArrayList<st_copy_photo> arrayList) {
        this.uin = j3;
        this.reqSource = str;
        this.dstAlbumid = str2;
        this.dstAlbumType = str3;
        this.desc = str4;
        this.photos = arrayList;
    }
}

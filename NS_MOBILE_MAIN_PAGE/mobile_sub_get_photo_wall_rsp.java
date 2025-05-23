package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_get_photo_wall_rsp extends JceStruct {
    static ArrayList<PhotoWall> cache_vecUrls;
    public String attachInfo;
    public int iHasMore;
    public int photoWallCombinePic;
    public int total_pic;
    public ArrayList<PhotoWall> vecUrls;

    public mobile_sub_get_photo_wall_rsp() {
        this.attachInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vecUrls == null) {
            cache_vecUrls = new ArrayList<>();
            cache_vecUrls.add(new PhotoWall());
        }
        this.vecUrls = (ArrayList) jceInputStream.read((JceInputStream) cache_vecUrls, 0, false);
        this.total_pic = jceInputStream.read(this.total_pic, 1, false);
        this.attachInfo = jceInputStream.readString(2, false);
        this.iHasMore = jceInputStream.read(this.iHasMore, 3, false);
        this.photoWallCombinePic = jceInputStream.read(this.photoWallCombinePic, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<PhotoWall> arrayList = this.vecUrls;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.total_pic, 1);
        String str = this.attachInfo;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.iHasMore, 3);
        jceOutputStream.write(this.photoWallCombinePic, 4);
    }

    public mobile_sub_get_photo_wall_rsp(ArrayList<PhotoWall> arrayList, int i3, String str, int i16, int i17) {
        this.vecUrls = arrayList;
        this.total_pic = i3;
        this.attachInfo = str;
        this.iHasMore = i16;
        this.photoWallCombinePic = i17;
    }
}

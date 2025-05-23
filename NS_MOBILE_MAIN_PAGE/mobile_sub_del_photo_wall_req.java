package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_del_photo_wall_req extends JceStruct {
    static ArrayList<PhotoWall> cache_vecUrls;
    public ArrayList<PhotoWall> vecUrls;

    public mobile_sub_del_photo_wall_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vecUrls == null) {
            cache_vecUrls = new ArrayList<>();
            cache_vecUrls.add(new PhotoWall());
        }
        this.vecUrls = (ArrayList) jceInputStream.read((JceInputStream) cache_vecUrls, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vecUrls, 0);
    }

    public mobile_sub_del_photo_wall_req(ArrayList<PhotoWall> arrayList) {
        this.vecUrls = arrayList;
    }
}

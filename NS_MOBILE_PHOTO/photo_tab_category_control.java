package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class photo_tab_category_control extends JceStruct {
    static ArrayList<photo_tab_categroy_info> cache_category_infos = new ArrayList<>();
    public ArrayList<photo_tab_categroy_info> category_infos;
    public boolean is_visible;

    static {
        cache_category_infos.add(new photo_tab_categroy_info());
    }

    public photo_tab_category_control() {
        this.is_visible = false;
        this.category_infos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.is_visible = jceInputStream.read(this.is_visible, 0, false);
        this.category_infos = (ArrayList) jceInputStream.read((JceInputStream) cache_category_infos, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.is_visible, 0);
        ArrayList<photo_tab_categroy_info> arrayList = this.category_infos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public photo_tab_category_control(boolean z16, ArrayList<photo_tab_categroy_info> arrayList) {
        this.is_visible = z16;
        this.category_infos = arrayList;
    }
}

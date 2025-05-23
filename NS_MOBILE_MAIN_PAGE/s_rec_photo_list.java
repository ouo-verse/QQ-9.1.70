package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_rec_photo_list extends JceStruct {
    static ArrayList<s_recent_photo> cache_rec_photo_list;
    public ArrayList<s_recent_photo> rec_photo_list;

    public s_rec_photo_list() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_rec_photo_list == null) {
            cache_rec_photo_list = new ArrayList<>();
            cache_rec_photo_list.add(new s_recent_photo());
        }
        this.rec_photo_list = (ArrayList) jceInputStream.read((JceInputStream) cache_rec_photo_list, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<s_recent_photo> arrayList = this.rec_photo_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public s_rec_photo_list(ArrayList<s_recent_photo> arrayList) {
        this.rec_photo_list = arrayList;
    }
}

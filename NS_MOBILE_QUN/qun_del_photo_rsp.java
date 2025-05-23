package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class qun_del_photo_rsp extends JceStruct {
    static ArrayList<String> cache_failed_photo_list;
    public ArrayList<String> failed_photo_list;

    public qun_del_photo_rsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_failed_photo_list == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            cache_failed_photo_list = arrayList;
            arrayList.add("");
        }
        this.failed_photo_list = (ArrayList) jceInputStream.read((JceInputStream) cache_failed_photo_list, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.failed_photo_list, 0);
    }

    public qun_del_photo_rsp(ArrayList<String> arrayList) {
        this.failed_photo_list = arrayList;
    }
}

package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QzoneWeisiReqcommendReq extends JceStruct {
    static int cache_entrance_type;
    static ArrayList<QzoneWeisiReqcommendKey> cache_keys = new ArrayList<>();
    public String aggregate_name;
    public String aggregate_page_id;
    public int entrance_type;
    public int index;
    public ArrayList<QzoneWeisiReqcommendKey> keys;

    static {
        cache_keys.add(new QzoneWeisiReqcommendKey());
        cache_entrance_type = 0;
    }

    public QzoneWeisiReqcommendReq() {
        this.keys = null;
        this.index = 0;
        this.entrance_type = 2;
        this.aggregate_page_id = "";
        this.aggregate_name = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.keys = (ArrayList) jceInputStream.read((JceInputStream) cache_keys, 0, false);
        this.index = jceInputStream.read(this.index, 1, false);
        this.entrance_type = jceInputStream.read(this.entrance_type, 2, false);
        this.aggregate_page_id = jceInputStream.readString(3, false);
        this.aggregate_name = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<QzoneWeisiReqcommendKey> arrayList = this.keys;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.index, 1);
        jceOutputStream.write(this.entrance_type, 2);
        String str = this.aggregate_page_id;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.aggregate_name;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
    }

    public QzoneWeisiReqcommendReq(ArrayList<QzoneWeisiReqcommendKey> arrayList, int i3, int i16, String str, String str2) {
        this.keys = arrayList;
        this.index = i3;
        this.entrance_type = i16;
        this.aggregate_page_id = str;
        this.aggregate_name = str2;
    }
}

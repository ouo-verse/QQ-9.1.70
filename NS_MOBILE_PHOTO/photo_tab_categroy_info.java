package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class photo_tab_categroy_info extends JceStruct {
    static int cache_status;
    static int cache_type;
    static ArrayList<String> cache_url;
    public long count;
    public int status;
    public int type;
    public ArrayList<String> url;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_url = arrayList;
        arrayList.add("");
        cache_status = 0;
    }

    public photo_tab_categroy_info() {
        this.type = 0;
        this.url = null;
        this.count = 0L;
        this.status = 1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.url = (ArrayList) jceInputStream.read((JceInputStream) cache_url, 1, false);
        this.count = jceInputStream.read(this.count, 2, false);
        this.status = jceInputStream.read(this.status, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        ArrayList<String> arrayList = this.url;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.count, 2);
        jceOutputStream.write(this.status, 3);
    }

    public photo_tab_categroy_info(int i3, ArrayList<String> arrayList, long j3, int i16) {
        this.type = i3;
        this.url = arrayList;
        this.count = j3;
        this.status = i16;
    }
}

package NS_MOBILE_QUN;

import NS_MOBILE_FEEDS.single_feed;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class qun_feeds_rsp extends JceStruct {
    static ArrayList<single_feed> cache_all_feeds_data;
    public ArrayList<single_feed> all_feeds_data;
    public String attach_info;
    public int auto_load;
    public int hasmore;

    public qun_feeds_rsp() {
        this.attach_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.hasmore = jceInputStream.read(this.hasmore, 0, false);
        this.attach_info = jceInputStream.readString(1, false);
        if (cache_all_feeds_data == null) {
            cache_all_feeds_data = new ArrayList<>();
            cache_all_feeds_data.add(new single_feed());
        }
        this.all_feeds_data = (ArrayList) jceInputStream.read((JceInputStream) cache_all_feeds_data, 2, false);
        this.auto_load = jceInputStream.read(this.auto_load, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.hasmore, 0);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<single_feed> arrayList = this.all_feeds_data;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.auto_load, 3);
    }

    public qun_feeds_rsp(int i3, String str, ArrayList<single_feed> arrayList, int i16) {
        this.hasmore = i3;
        this.attach_info = str;
        this.all_feeds_data = arrayList;
        this.auto_load = i16;
    }
}

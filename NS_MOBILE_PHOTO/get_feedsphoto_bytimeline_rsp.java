package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_feedsphoto_bytimeline_rsp extends JceStruct {
    static ArrayList<PhotoFeedsData> cache_all_applist_data = new ArrayList<>();
    public ArrayList<PhotoFeedsData> all_applist_data;
    public String attach_info;
    public int hasmore;

    static {
        cache_all_applist_data.add(new PhotoFeedsData());
    }

    public get_feedsphoto_bytimeline_rsp() {
        this.all_applist_data = null;
        this.hasmore = 0;
        this.attach_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.all_applist_data = (ArrayList) jceInputStream.read((JceInputStream) cache_all_applist_data, 0, false);
        this.hasmore = jceInputStream.read(this.hasmore, 1, false);
        this.attach_info = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<PhotoFeedsData> arrayList = this.all_applist_data;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.hasmore, 1);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public get_feedsphoto_bytimeline_rsp(ArrayList<PhotoFeedsData> arrayList, int i3, String str) {
        this.all_applist_data = arrayList;
        this.hasmore = i3;
        this.attach_info = str;
    }
}

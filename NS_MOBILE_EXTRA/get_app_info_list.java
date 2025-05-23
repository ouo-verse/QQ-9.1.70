package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_app_info_list extends JceStruct {
    static ArrayList<s_app_info> cache_applist;
    public ArrayList<s_app_info> applist;
    public int serial;

    public get_app_info_list() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_applist == null) {
            cache_applist = new ArrayList<>();
            cache_applist.add(new s_app_info());
        }
        this.applist = (ArrayList) jceInputStream.read((JceInputStream) cache_applist, 0, true);
        this.serial = jceInputStream.read(this.serial, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.applist, 0);
        jceOutputStream.write(this.serial, 1);
    }

    public get_app_info_list(ArrayList<s_app_info> arrayList, int i3) {
        this.applist = arrayList;
        this.serial = i3;
    }
}

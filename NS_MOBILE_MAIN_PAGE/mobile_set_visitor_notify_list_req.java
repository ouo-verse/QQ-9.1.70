package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_set_visitor_notify_list_req extends JceStruct {
    static ArrayList<Long> cache_fuin_vec;
    public ArrayList<Long> fuin_vec;
    public int operation;

    public mobile_set_visitor_notify_list_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_fuin_vec == null) {
            cache_fuin_vec = new ArrayList<>();
            cache_fuin_vec.add(0L);
        }
        this.fuin_vec = (ArrayList) jceInputStream.read((JceInputStream) cache_fuin_vec, 0, true);
        this.operation = jceInputStream.read(this.operation, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.fuin_vec, 0);
        jceOutputStream.write(this.operation, 1);
    }

    public mobile_set_visitor_notify_list_req(ArrayList<Long> arrayList, int i3) {
        this.fuin_vec = arrayList;
        this.operation = i3;
    }
}

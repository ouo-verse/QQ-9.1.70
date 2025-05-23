package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_visit_report_req extends JceStruct {
    static ArrayList<s_visit_record> cache_vec_visit_record;
    public ArrayList<s_visit_record> vec_visit_record;

    public mobile_visit_report_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vec_visit_record == null) {
            cache_vec_visit_record = new ArrayList<>();
            cache_vec_visit_record.add(new s_visit_record());
        }
        this.vec_visit_record = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_visit_record, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vec_visit_record, 0);
    }

    public mobile_visit_report_req(ArrayList<s_visit_record> arrayList) {
        this.vec_visit_record = arrayList;
    }
}

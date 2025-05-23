package NS_MOBILE_USERLOGO_TIMESTAMP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_rc_tab_info extends JceStruct {
    static ArrayList<Long> cache_expression_list;
    public ArrayList<Long> expression_list;
    public String tab_icon_url;
    public long tab_id;
    public String zip_md5_value;

    public s_rc_tab_info() {
        this.tab_icon_url = "";
        this.zip_md5_value = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.tab_id = jceInputStream.read(this.tab_id, 0, false);
        this.tab_icon_url = jceInputStream.readString(1, false);
        if (cache_expression_list == null) {
            cache_expression_list = new ArrayList<>();
            cache_expression_list.add(0L);
        }
        this.expression_list = (ArrayList) jceInputStream.read((JceInputStream) cache_expression_list, 2, false);
        this.zip_md5_value = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.tab_id, 0);
        String str = this.tab_icon_url;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<Long> arrayList = this.expression_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        String str2 = this.zip_md5_value;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public s_rc_tab_info(long j3, String str, ArrayList<Long> arrayList, String str2) {
        this.tab_id = j3;
        this.tab_icon_url = str;
        this.expression_list = arrayList;
        this.zip_md5_value = str2;
    }
}

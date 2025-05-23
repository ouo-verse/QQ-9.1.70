package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_getRecommend_rsp extends JceStruct {
    static ArrayList<s_user> cache_datalist;
    public int allnum;
    public String attach_info;
    public ArrayList<s_user> datalist;

    public mobile_sub_getRecommend_rsp() {
        this.attach_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.allnum = jceInputStream.read(this.allnum, 0, false);
        if (cache_datalist == null) {
            cache_datalist = new ArrayList<>();
            cache_datalist.add(new s_user());
        }
        this.datalist = (ArrayList) jceInputStream.read((JceInputStream) cache_datalist, 1, false);
        this.attach_info = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.allnum, 0);
        ArrayList<s_user> arrayList = this.datalist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public mobile_sub_getRecommend_rsp(int i3, ArrayList<s_user> arrayList, String str) {
        this.allnum = i3;
        this.datalist = arrayList;
        this.attach_info = str;
    }
}

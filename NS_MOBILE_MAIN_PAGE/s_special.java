package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_special extends JceStruct {
    static ArrayList<s_user> cache_datalist;
    public int allnum;
    public ArrayList<s_user> datalist;

    public s_special() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.allnum = jceInputStream.read(this.allnum, 0, false);
        if (cache_datalist == null) {
            cache_datalist = new ArrayList<>();
            cache_datalist.add(new s_user());
        }
        this.datalist = (ArrayList) jceInputStream.read((JceInputStream) cache_datalist, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.allnum, 0);
        ArrayList<s_user> arrayList = this.datalist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public s_special(int i3, ArrayList<s_user> arrayList) {
        this.allnum = i3;
        this.datalist = arrayList;
    }
}

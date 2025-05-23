package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_friendreq extends JceStruct {
    static ArrayList<s_user> cache_datalist;
    static ArrayList<s_user> cache_datalistnew;
    static ArrayList<s_user> cache_datalistold;
    static Map<Long, String> cache_msglist;
    public int allnum;
    public ArrayList<s_user> datalist;
    public ArrayList<s_user> datalistnew;
    public ArrayList<s_user> datalistold;
    public Map<Long, String> msglist;

    public s_friendreq() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.allnum = jceInputStream.read(this.allnum, 0, false);
        if (cache_datalist == null) {
            cache_datalist = new ArrayList<>();
            cache_datalist.add(new s_user());
        }
        this.datalist = (ArrayList) jceInputStream.read((JceInputStream) cache_datalist, 1, false);
        if (cache_msglist == null) {
            cache_msglist = new HashMap();
            cache_msglist.put(0L, "");
        }
        this.msglist = (Map) jceInputStream.read((JceInputStream) cache_msglist, 2, false);
        if (cache_datalistnew == null) {
            cache_datalistnew = new ArrayList<>();
            cache_datalistnew.add(new s_user());
        }
        this.datalistnew = (ArrayList) jceInputStream.read((JceInputStream) cache_datalistnew, 3, false);
        if (cache_datalistold == null) {
            cache_datalistold = new ArrayList<>();
            cache_datalistold.add(new s_user());
        }
        this.datalistold = (ArrayList) jceInputStream.read((JceInputStream) cache_datalistold, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.allnum, 0);
        ArrayList<s_user> arrayList = this.datalist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        Map<Long, String> map = this.msglist;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        ArrayList<s_user> arrayList2 = this.datalistnew;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 3);
        }
        ArrayList<s_user> arrayList3 = this.datalistold;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 4);
        }
    }

    public s_friendreq(int i3, ArrayList<s_user> arrayList, Map<Long, String> map, ArrayList<s_user> arrayList2, ArrayList<s_user> arrayList3) {
        this.allnum = i3;
        this.datalist = arrayList;
        this.msglist = map;
        this.datalistnew = arrayList2;
        this.datalistold = arrayList3;
    }
}

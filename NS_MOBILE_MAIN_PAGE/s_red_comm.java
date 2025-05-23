package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_red_comm extends JceStruct {
    static ArrayList<s_red_info> cache_redinfo;
    static int cache_showtype;
    static ArrayList<Integer> cache_subid;
    public ArrayList<s_red_info> redinfo;
    public int showtype;
    public ArrayList<Integer> subid;
    public long undealnum;

    public s_red_comm() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.showtype = jceInputStream.read(this.showtype, 0, false);
        this.undealnum = jceInputStream.read(this.undealnum, 1, false);
        if (cache_redinfo == null) {
            cache_redinfo = new ArrayList<>();
            cache_redinfo.add(new s_red_info());
        }
        this.redinfo = (ArrayList) jceInputStream.read((JceInputStream) cache_redinfo, 2, false);
        if (cache_subid == null) {
            cache_subid = new ArrayList<>();
            cache_subid.add(0);
        }
        this.subid = (ArrayList) jceInputStream.read((JceInputStream) cache_subid, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.showtype, 0);
        jceOutputStream.write(this.undealnum, 1);
        ArrayList<s_red_info> arrayList = this.redinfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        ArrayList<Integer> arrayList2 = this.subid;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 3);
        }
    }

    public s_red_comm(int i3, long j3, ArrayList<s_red_info> arrayList, ArrayList<Integer> arrayList2) {
        this.showtype = i3;
        this.undealnum = j3;
        this.redinfo = arrayList;
        this.subid = arrayList2;
    }
}

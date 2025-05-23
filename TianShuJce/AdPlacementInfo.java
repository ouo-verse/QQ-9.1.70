package TianShuJce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class AdPlacementInfo extends JceStruct {
    static ArrayList<AdItem> cache_lst = new ArrayList<>();
    public String ctlInfo;
    public String extInfo;
    public ArrayList<AdItem> lst;
    public long next_query_ts;
    public int type;

    static {
        cache_lst.add(new AdItem());
    }

    public AdPlacementInfo() {
        this.type = 0;
        this.lst = null;
        this.next_query_ts = 0L;
        this.extInfo = "";
        this.ctlInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 1, false);
        this.lst = (ArrayList) jceInputStream.read((JceInputStream) cache_lst, 2, false);
        this.next_query_ts = jceInputStream.read(this.next_query_ts, 3, false);
        this.extInfo = jceInputStream.readString(4, false);
        this.ctlInfo = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 1);
        ArrayList<AdItem> arrayList = this.lst;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.next_query_ts, 3);
        String str = this.extInfo;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this.ctlInfo;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
    }

    public AdPlacementInfo(int i3, ArrayList<AdItem> arrayList, long j3, String str, String str2) {
        this.type = i3;
        this.lst = arrayList;
        this.next_query_ts = j3;
        this.extInfo = str;
        this.ctlInfo = str2;
    }
}

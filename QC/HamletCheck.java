package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class HamletCheck extends JceStruct {
    static ArrayList<UniBusinessCheckItem> cache_itemlist = new ArrayList<>();
    public ArrayList<UniBusinessCheckItem> itemlist;
    public int locationtype;
    public long uid;

    static {
        cache_itemlist.add(new UniBusinessCheckItem());
    }

    public HamletCheck() {
        this.uid = 0L;
        this.locationtype = 0;
        this.itemlist = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uid = jceInputStream.read(this.uid, 0, false);
        this.locationtype = jceInputStream.read(this.locationtype, 1, false);
        this.itemlist = (ArrayList) jceInputStream.read((JceInputStream) cache_itemlist, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uid, 0);
        jceOutputStream.write(this.locationtype, 1);
        ArrayList<UniBusinessCheckItem> arrayList = this.itemlist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public HamletCheck(long j3, int i3, ArrayList<UniBusinessCheckItem> arrayList) {
        this.uid = j3;
        this.locationtype = i3;
        this.itemlist = arrayList;
    }
}

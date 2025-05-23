package ProfileLogic.QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class readUserInfoRsp extends JceStruct {
    static ArrayList<profileItem> cache_itemlist = new ArrayList<>();
    public int flag;
    public int index;
    public int itemid;
    public ArrayList<profileItem> itemlist;
    public int listend;
    public String urlprefix;

    static {
        cache_itemlist.add(new profileItem());
    }

    public readUserInfoRsp() {
        this.itemlist = null;
        this.index = 0;
        this.listend = 0;
        this.urlprefix = "";
        this.itemid = 0;
        this.flag = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.itemlist = (ArrayList) jceInputStream.read((JceInputStream) cache_itemlist, 0, false);
        this.index = jceInputStream.read(this.index, 1, false);
        this.listend = jceInputStream.read(this.listend, 2, false);
        this.urlprefix = jceInputStream.readString(3, false);
        this.itemid = jceInputStream.read(this.itemid, 4, false);
        this.flag = jceInputStream.read(this.flag, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<profileItem> arrayList = this.itemlist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.index, 1);
        jceOutputStream.write(this.listend, 2);
        String str = this.urlprefix;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.itemid, 4);
        jceOutputStream.write(this.flag, 5);
    }

    public readUserInfoRsp(ArrayList<profileItem> arrayList, int i3, int i16, String str, int i17, int i18) {
        this.itemlist = arrayList;
        this.index = i3;
        this.listend = i16;
        this.urlprefix = str;
        this.itemid = i17;
        this.flag = i18;
    }
}

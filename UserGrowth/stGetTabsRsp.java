package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetTabsRsp extends JceStruct {
    static ArrayList<stTabInfo> cache_Tabs = new ArrayList<>();
    public ArrayList<stTabInfo> Tabs;

    static {
        cache_Tabs.add(new stTabInfo());
    }

    public stGetTabsRsp() {
        this.Tabs = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Tabs = (ArrayList) jceInputStream.read((JceInputStream) cache_Tabs, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<stTabInfo> arrayList = this.Tabs;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public stGetTabsRsp(ArrayList<stTabInfo> arrayList) {
        this.Tabs = arrayList;
    }
}

package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ItemCfgList extends JceStruct {
    static ArrayList<ItemCfgInfo> cache_itemCfgInfo = new ArrayList<>();
    public long iItemCfgVer;
    public ArrayList<ItemCfgInfo> itemCfgInfo;

    static {
        cache_itemCfgInfo.add(new ItemCfgInfo());
    }

    public ItemCfgList() {
        this.iItemCfgVer = 0L;
        this.itemCfgInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemCfgVer = jceInputStream.read(this.iItemCfgVer, 0, false);
        this.itemCfgInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_itemCfgInfo, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemCfgVer, 0);
        ArrayList<ItemCfgInfo> arrayList = this.itemCfgInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public ItemCfgList(long j3, ArrayList<ItemCfgInfo> arrayList) {
        this.iItemCfgVer = j3;
        this.itemCfgInfo = arrayList;
    }
}

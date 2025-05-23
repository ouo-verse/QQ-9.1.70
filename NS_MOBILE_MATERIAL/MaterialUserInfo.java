package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MaterialUserInfo extends JceStruct {
    static int cache_iSwitchState;
    static MaterialUserItem cache_stCurrentItem;
    static ArrayList<MaterialUserItem> cache_vecHistoryItem;
    static ArrayList<MaterialUserItem> cache_vecUserItem = new ArrayList<>();
    public int iSwitchState;
    public MaterialUserItem stCurrentItem;
    public ArrayList<MaterialUserItem> vecHistoryItem;
    public ArrayList<MaterialUserItem> vecUserItem;

    static {
        cache_vecUserItem.add(new MaterialUserItem());
        cache_vecHistoryItem = new ArrayList<>();
        cache_vecHistoryItem.add(new MaterialUserItem());
        cache_iSwitchState = 0;
        cache_stCurrentItem = new MaterialUserItem();
    }

    public MaterialUserInfo() {
        this.vecUserItem = null;
        this.vecHistoryItem = null;
        this.iSwitchState = 0;
        this.stCurrentItem = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vecUserItem = (ArrayList) jceInputStream.read((JceInputStream) cache_vecUserItem, 0, false);
        this.vecHistoryItem = (ArrayList) jceInputStream.read((JceInputStream) cache_vecHistoryItem, 1, false);
        this.iSwitchState = jceInputStream.read(this.iSwitchState, 2, false);
        this.stCurrentItem = (MaterialUserItem) jceInputStream.read((JceStruct) cache_stCurrentItem, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<MaterialUserItem> arrayList = this.vecUserItem;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        ArrayList<MaterialUserItem> arrayList2 = this.vecHistoryItem;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 1);
        }
        jceOutputStream.write(this.iSwitchState, 2);
        MaterialUserItem materialUserItem = this.stCurrentItem;
        if (materialUserItem != null) {
            jceOutputStream.write((JceStruct) materialUserItem, 3);
        }
    }

    public MaterialUserInfo(ArrayList<MaterialUserItem> arrayList, ArrayList<MaterialUserItem> arrayList2, int i3, MaterialUserItem materialUserItem) {
        this.vecUserItem = arrayList;
        this.vecHistoryItem = arrayList2;
        this.iSwitchState = i3;
        this.stCurrentItem = materialUserItem;
    }
}

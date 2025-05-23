package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ModGroupSort extends JceStruct {
    static ArrayList<GroupSort> cache_vMsgGroupSort;
    public ArrayList<GroupSort> vMsgGroupSort;

    public ModGroupSort() {
        this.vMsgGroupSort = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vMsgGroupSort == null) {
            cache_vMsgGroupSort = new ArrayList<>();
            cache_vMsgGroupSort.add(new GroupSort());
        }
        this.vMsgGroupSort = (ArrayList) jceInputStream.read((JceInputStream) cache_vMsgGroupSort, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<GroupSort> arrayList = this.vMsgGroupSort;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public ModGroupSort(ArrayList<GroupSort> arrayList) {
        this.vMsgGroupSort = arrayList;
    }
}

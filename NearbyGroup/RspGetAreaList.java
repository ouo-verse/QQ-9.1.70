package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RspGetAreaList extends JceStruct {
    static ArrayList<GroupArea> cache_vGroupArea;
    public ArrayList<GroupArea> vGroupArea;

    public RspGetAreaList() {
        this.vGroupArea = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vGroupArea == null) {
            cache_vGroupArea = new ArrayList<>();
            cache_vGroupArea.add(new GroupArea());
        }
        this.vGroupArea = (ArrayList) jceInputStream.read((JceInputStream) cache_vGroupArea, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<GroupArea> arrayList = this.vGroupArea;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public RspGetAreaList(ArrayList<GroupArea> arrayList) {
        this.vGroupArea = arrayList;
    }
}

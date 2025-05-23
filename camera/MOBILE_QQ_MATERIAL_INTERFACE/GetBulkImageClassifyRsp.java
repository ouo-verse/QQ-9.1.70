package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetBulkImageClassifyRsp extends JceStruct {
    static ArrayList<SmartFilterRspItem> cache_MiltiRsps = new ArrayList<>();
    public ArrayList<SmartFilterRspItem> MiltiRsps;

    static {
        cache_MiltiRsps.add(new SmartFilterRspItem());
    }

    public GetBulkImageClassifyRsp() {
        this.MiltiRsps = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.MiltiRsps = (ArrayList) jceInputStream.read((JceInputStream) cache_MiltiRsps, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<SmartFilterRspItem> arrayList = this.MiltiRsps;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public GetBulkImageClassifyRsp(ArrayList<SmartFilterRspItem> arrayList) {
        this.MiltiRsps = arrayList;
    }
}

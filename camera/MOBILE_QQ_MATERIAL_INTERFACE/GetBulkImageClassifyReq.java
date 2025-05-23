package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetBulkImageClassifyReq extends JceStruct {
    static ArrayList<SmartFilterReqItem> cache_MultiPics = new ArrayList<>();
    public ArrayList<SmartFilterReqItem> MultiPics;

    static {
        cache_MultiPics.add(new SmartFilterReqItem());
    }

    public GetBulkImageClassifyReq() {
        this.MultiPics = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.MultiPics = (ArrayList) jceInputStream.read((JceInputStream) cache_MultiPics, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<SmartFilterReqItem> arrayList = this.MultiPics;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public GetBulkImageClassifyReq(ArrayList<SmartFilterReqItem> arrayList) {
        this.MultiPics = arrayList;
    }
}

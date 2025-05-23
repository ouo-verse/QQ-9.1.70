package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class GetBatchPoiRsp_V2 extends JceStruct {
    static ArrayList<PoiInfoCell_V2> cache_vecPoiInfoCell = new ArrayList<>();
    public ArrayList<PoiInfoCell_V2> vecPoiInfoCell;

    static {
        cache_vecPoiInfoCell.add(new PoiInfoCell_V2());
    }

    public GetBatchPoiRsp_V2() {
        this.vecPoiInfoCell = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vecPoiInfoCell = (ArrayList) jceInputStream.read((JceInputStream) cache_vecPoiInfoCell, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<PoiInfoCell_V2> arrayList = this.vecPoiInfoCell;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public GetBatchPoiRsp_V2(ArrayList<PoiInfoCell_V2> arrayList) {
        this.vecPoiInfoCell = arrayList;
    }
}

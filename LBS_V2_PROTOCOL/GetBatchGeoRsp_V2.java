package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetBatchGeoRsp_V2 extends JceStruct {
    static ArrayList<GeoInfoCell_V2> cache_vecGeoInfoCell;
    public ArrayList<GeoInfoCell_V2> vecGeoInfoCell;

    public GetBatchGeoRsp_V2() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vecGeoInfoCell == null) {
            cache_vecGeoInfoCell = new ArrayList<>();
            cache_vecGeoInfoCell.add(new GeoInfoCell_V2());
        }
        this.vecGeoInfoCell = (ArrayList) jceInputStream.read((JceInputStream) cache_vecGeoInfoCell, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<GeoInfoCell_V2> arrayList = this.vecGeoInfoCell;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public GetBatchGeoRsp_V2(ArrayList<GeoInfoCell_V2> arrayList) {
        this.vecGeoInfoCell = arrayList;
    }
}

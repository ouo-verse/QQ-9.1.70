package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetBatchGeoReq_V2 extends JceStruct {
    static ReqCommon_V2 cache_stCommon;
    static ArrayList<GPS_V2> cache_vecGpsInfo;
    public int opMask;
    public ReqCommon_V2 stCommon;
    public ArrayList<GPS_V2> vecGpsInfo;

    public GetBatchGeoReq_V2() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stCommon == null) {
            cache_stCommon = new ReqCommon_V2();
        }
        this.stCommon = (ReqCommon_V2) jceInputStream.read((JceStruct) cache_stCommon, 0, true);
        if (cache_vecGpsInfo == null) {
            cache_vecGpsInfo = new ArrayList<>();
            cache_vecGpsInfo.add(new GPS_V2());
        }
        this.vecGpsInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecGpsInfo, 1, false);
        this.opMask = jceInputStream.read(this.opMask, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stCommon, 0);
        ArrayList<GPS_V2> arrayList = this.vecGpsInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.opMask, 2);
    }

    public GetBatchGeoReq_V2(ReqCommon_V2 reqCommon_V2, ArrayList<GPS_V2> arrayList, int i3) {
        this.stCommon = reqCommon_V2;
        this.vecGpsInfo = arrayList;
        this.opMask = i3;
    }
}

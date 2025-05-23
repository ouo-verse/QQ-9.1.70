package fz3;

import LBS_V2_PROTOCOL.GetBatchPoiReq_V2;
import LBS_V2_PROTOCOL.ReqCommon_V2;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneCommonRequest;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends QZoneCommonRequest {

    /* renamed from: d, reason: collision with root package name */
    public JceStruct f400977d;

    /* renamed from: e, reason: collision with root package name */
    private int f400978e;

    public a(ArrayList<LbsDataV2.GpsInfo> arrayList, int i3, Map<String, String> map, int i16, int i17) {
        this.f400978e = i16;
        GetBatchPoiReq_V2 getBatchPoiReq_V2 = new GetBatchPoiReq_V2();
        ReqCommon_V2 reqCommon_V2 = new ReqCommon_V2();
        getBatchPoiReq_V2.stCommon = reqCommon_V2;
        reqCommon_V2.iAppId = i3;
        reqCommon_V2.iDeviceType = 1;
        getBatchPoiReq_V2.vecGpsInfo = new ArrayList<>();
        if (map != null) {
            getBatchPoiReq_V2.map_ext = map;
        }
        for (int i18 = 0; i18 < arrayList.size(); i18++) {
            getBatchPoiReq_V2.vecGpsInfo.add(LbsDataV2.convertToGPS_V2(arrayList.get(i18)));
        }
        getBatchPoiReq_V2.opMask = i17;
        this.f400977d = getBatchPoiReq_V2;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return "QzoneNewService.getBatchPoi";
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.f400977d;
    }

    @Override // cooperation.qzone.QZoneCommonRequest
    public int getType() {
        return this.f400978e;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "getBatchPoi";
    }
}

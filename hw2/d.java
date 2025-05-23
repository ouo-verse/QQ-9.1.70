package hw2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.parse.IVRParamsParser;
import com.tencent.tvideo.protocol.pb.AdVRReportList;
import com.tencent.tvideo.protocol.pb.AdVRReportType;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class d implements IVRParamsParser<String, String> {

    /* renamed from: a, reason: collision with root package name */
    protected static final HashMap<Integer, Integer> f406508a;

    static {
        HashMap<Integer, Integer> hashMap = new HashMap<>(10);
        f406508a = hashMap;
        hashMap.put(0, Integer.valueOf(AdVRReportType.AD_VR_REPORT_TYPE_UNKNOWN.getValue()));
        hashMap.put(1, Integer.valueOf(AdVRReportType.AD_VR_REPORT_TYPE_COMMON_EXPOSURE_CLICK.getValue()));
        hashMap.put(2, Integer.valueOf(AdVRReportType.AD_VR_REPORT_TYPE_HEADER_CLICK.getValue()));
        hashMap.put(3, Integer.valueOf(AdVRReportType.AD_VR_REPORT_TYPE_ACTION_BTN_CLICK.getValue()));
        hashMap.put(4, Integer.valueOf(AdVRReportType.AD_VR_REPORT_TYPE_POSTER_CLICK.getValue()));
        hashMap.put(5, Integer.valueOf(AdVRReportType.AD_VR_REPORT_TYPE_COMMON_PLAY.getValue()));
        hashMap.put(6, Integer.valueOf(AdVRReportType.AD_VR_REPORT_TYPE_COMMON_DOWNLOAD.getValue()));
        hashMap.put(7, Integer.valueOf(AdVRReportType.AD_VR_REPORT_TYPE_SKIP_CLICK.getValue()));
        hashMap.put(9, Integer.valueOf(AdVRReportType.AD_VR_REPORT_TYPE_COMMON.getValue()));
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.parse.IVRParamsParser
    public Map<String, String> a(int i3) {
        Map<String, String> map;
        Map<String, String> b16 = b(c(), AdVRReportType.fromValue(d(i3)));
        if (i3 != 9) {
            map = b(c(), AdVRReportType.fromValue(d(9)));
        } else {
            map = null;
        }
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        if (b16 != null) {
            hashMap.putAll(b16);
        }
        if (!hashMap.containsKey("ad_action_type")) {
            hashMap.put("ad_action_type", QAdVrReportParams.ClickAdActionTypeValue.ACTION_TYPE_NO_JUMP);
        }
        return hashMap;
    }

    protected Map<String, String> b(Map<Integer, AdVRReportList> map, AdVRReportType adVRReportType) {
        AdVRReportList adVRReportList;
        if (map == null || adVRReportType == null || (adVRReportList = map.get(Integer.valueOf(adVRReportType.getValue()))) == null || adVRReportList.report_dict == null) {
            return null;
        }
        return new HashMap(adVRReportList.report_dict);
    }

    protected abstract Map<Integer, AdVRReportList> c();

    public int d(int i3) {
        Integer num = f406508a.get(Integer.valueOf(i3));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }
}

package hw2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.parse.IVRParamsParser;
import com.tencent.qqlive.ona.protocol.jce.AdVRReportItem;
import com.tencent.qqlive.ona.protocol.jce.EAdVRReportType;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class c implements IVRParamsParser<String, String> {

    /* renamed from: a, reason: collision with root package name */
    protected static final HashMap<Integer, Integer> f406507a;

    static {
        HashMap<Integer, Integer> hashMap = new HashMap<>(10);
        f406507a = hashMap;
        hashMap.put(0, Integer.valueOf(EAdVRReportType.EAdVRReportTypeUnknown.value()));
        hashMap.put(1, Integer.valueOf(EAdVRReportType.EAdVRReportTypeCommonExposureClick.value()));
        hashMap.put(2, Integer.valueOf(EAdVRReportType.EAdVRReportTypeHeaderClick.value()));
        hashMap.put(3, Integer.valueOf(EAdVRReportType.EAdVRReportTypeActionBtnClick.value()));
        hashMap.put(4, Integer.valueOf(EAdVRReportType.EAdVRReportTypePosterClick.value()));
        hashMap.put(5, Integer.valueOf(EAdVRReportType.EAdVRReportTypeCommonPlay.value()));
        hashMap.put(6, Integer.valueOf(EAdVRReportType.EAdVRReportTypeCommonDownload.value()));
        hashMap.put(7, Integer.valueOf(EAdVRReportType.EAdVRReportTypeSkipClick.value()));
        hashMap.put(8, Integer.valueOf(EAdVRReportType.EAdVRReportTypeSplashChain.value()));
        hashMap.put(9, Integer.valueOf(EAdVRReportType.EAdVRReportTypeCommonParams.value()));
    }

    private Map<String, String> b(Map<Integer, AdVRReportItem> map, EAdVRReportType eAdVRReportType) {
        AdVRReportItem adVRReportItem;
        if (map == null || eAdVRReportType == null || (adVRReportItem = map.get(Integer.valueOf(eAdVRReportType.value()))) == null || adVRReportItem.vrReportMap == null) {
            return null;
        }
        return new HashMap(adVRReportItem.vrReportMap);
    }

    private EAdVRReportType e(int i3) {
        try {
            return EAdVRReportType.convert(d(i3));
        } catch (Throwable unused) {
            if (!qv2.b.e()) {
                return null;
            }
            throw new IllegalArgumentException("toEAdVRReportType error, check paramType first!");
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.parse.IVRParamsParser
    public Map<String, String> a(int i3) {
        Map<String, String> map;
        if (i3 != 9) {
            map = b(c(), e(9));
        } else {
            map = null;
        }
        Map<String, String> b16 = b(c(), e(i3));
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

    protected abstract Map<Integer, AdVRReportItem> c();

    public int d(int i3) {
        Integer num = f406507a.get(Integer.valueOf(i3));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }
}

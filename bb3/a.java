package bb3;

import com.tencent.ad.tangram.statistics.metric.AdMetricService;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ad.tangram.statistics.metric.IAdMetric;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class a {
    public static void b(String str, String str2, long j3, GdtAd gdtAd, String str3, String str4, String str5) {
        QLog.i(str, 1, str2);
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtAd, str3, str4, j3).setTagSet(AdMetricTag.EVENT_NAME, str5));
    }

    private static IAdMetric a(GdtAd gdtAd, String str, String str2, long j3) {
        return AdMetricService.getInstance().build(j3).setTagSet("posId", gdtAd != null ? gdtAd.getPosId() : null).setTagSet(AdMetricTag.Kuikly.BUNDLE_NAME, str).setTagSet(AdMetricTag.Kuikly.PAGE_NAME, str2);
    }
}

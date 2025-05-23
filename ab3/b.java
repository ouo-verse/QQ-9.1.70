package ab3;

import ab3.a;
import android.app.Activity;
import android.content.Context;
import com.tencent.ad.tangram.statistics.metric.AdMetricService;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ad.tangram.statistics.metric.IAdMetric;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
final class b {
    private static IAdMetric a(a.b bVar, long j3) {
        GdtAd gdtAd = bVar != null ? bVar.f25776a : null;
        return AdMetricService.getInstance().build(j3).setTagSet("posId", gdtAd != null ? gdtAd.getPosId() : null);
    }

    public static void b(String str, String str2, long j3, a.b bVar, a.c cVar) {
        WeakReference<Activity> weakReference = bVar != null ? bVar.f25782g : null;
        Activity activity = weakReference != null ? weakReference.get() : null;
        Context applicationContext = activity != null ? activity.getApplicationContext() : null;
        QLog.e(str, 1, str2);
        AdMetricService.getInstance().handle(new WeakReference<>(applicationContext), a(bVar, j3).setTagSet(AdMetricTag.ERROR_CODE, String.valueOf(cVar != null ? cVar.b() : 1)));
    }

    public static void c(String str, String str2, long j3, a.b bVar) {
        WeakReference<Activity> weakReference = bVar != null ? bVar.f25782g : null;
        Activity activity = weakReference != null ? weakReference.get() : null;
        Context applicationContext = activity != null ? activity.getApplicationContext() : null;
        QLog.i(str, 1, str2);
        AdMetricService.getInstance().handle(new WeakReference<>(applicationContext), a(bVar, j3));
    }

    public static void d(String str, String str2, long j3, a.b bVar, a.c cVar) {
        WeakReference<Activity> weakReference = bVar != null ? bVar.f25782g : null;
        Activity activity = weakReference != null ? weakReference.get() : null;
        Context applicationContext = activity != null ? activity.getApplicationContext() : null;
        QLog.i(str, 1, str2);
        AdMetricService.getInstance().handle(new WeakReference<>(applicationContext), a(bVar, j3).setTagSet(AdMetricTag.Click.ACTION, String.valueOf(cVar != null ? cVar.a() : 0)));
    }
}

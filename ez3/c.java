package ez3;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.ISosoUtils;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.report.QzoneLbsReporter;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c implements a {

    /* renamed from: b, reason: collision with root package name */
    private static final Object f397468b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, c> f397469c = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private final String f397470a;

    c(String str) {
        this.f397470a = str;
    }

    public static c b(String str) {
        c cVar = f397469c.get(str);
        if (cVar == null) {
            synchronized (f397468b) {
                cVar = f397469c.get(str);
                if (cVar == null) {
                    cVar = new c(str);
                    f397469c.put(str, cVar);
                }
            }
        }
        return cVar;
    }

    @Override // ez3.a
    public LbsDataV2.GpsInfo a() {
        SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo(this.f397470a);
        QzoneLbsReporter.reportLocationCacheResult(cachedLbsInfo != null, this.f397470a);
        QLog.i("QZoneNewJustLocation.NewLbsInterface", 1, "[QZ_LBS_MODULE]----getCurrGps");
        if (cachedLbsInfo != null) {
            return ((ISosoUtils) QRoute.api(ISosoUtils.class)).convertFromSoso(cachedLbsInfo.mLocation);
        }
        return null;
    }
}

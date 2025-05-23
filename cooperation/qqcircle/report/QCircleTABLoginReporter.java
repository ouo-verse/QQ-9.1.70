package cooperation.qqcircle.report;

import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes28.dex */
public class QCircleTABLoginReporter {
    private static IQCircleABTestApi sABTestApi;
    private static final List<String> sReportExpName;

    static {
        ArrayList arrayList = new ArrayList();
        sReportExpName = arrayList;
        arrayList.add("exp_sxj_feed_delete_exp");
        arrayList.add("exp_qcircle_load_more_limit_clip_new_1505");
    }

    private static IQCircleABTestApi getABTestApi() {
        if (sABTestApi == null) {
            synchronized (IQCircleABTestApi.class) {
                if (sABTestApi == null) {
                    sABTestApi = (IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class);
                }
            }
        }
        return sABTestApi;
    }

    public static void reportTABExpExportWhenLogin() {
        IQCircleABTestApi aBTestApi = getABTestApi();
        if (aBTestApi == null) {
            return;
        }
        Iterator<String> it = sReportExpName.iterator();
        while (it.hasNext()) {
            aBTestApi.reportExpExposure(it.next());
        }
    }
}

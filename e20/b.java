package e20;

import com.tencent.biz.richframework.delegate.IReportDelegate;
import com.tencent.richframework.argus.business.performance.report.ArgusPreloadEventInterceptor;
import com.tencent.richframework.argus.business.performance.report.CommonEventInterceptor;
import com.tencent.richframework.argus.business.performance.report.IEventReportInterceptor;
import com.tencent.richframework.argus.business.performance.report.PagePerformanceEventInterceptor;
import com.tencent.richframework.argus.business.performance.report.RecyclerViewEventInterceptor;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b implements IReportDelegate {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<IEventReportInterceptor> f395372a;

    public b() {
        ArrayList<IEventReportInterceptor> arrayList = new ArrayList<>();
        this.f395372a = arrayList;
        arrayList.add(new ArgusPreloadEventInterceptor());
        arrayList.add(new RecyclerViewEventInterceptor());
        arrayList.add(new PagePerformanceEventInterceptor());
        arrayList.add(new CommonEventInterceptor());
    }

    private boolean a(String str, Map<String, Object> map) {
        Iterator<IEventReportInterceptor> it = this.f395372a.iterator();
        while (it.hasNext()) {
            if (it.next().dispatchEvent(str, map)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.delegate.IReportDelegate
    public void report(String str, Map<String, Object> map) {
        if (a(str, map)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry != null && entry.getValue() != null) {
                arrayList.add(QCircleReportHelper.newEntry(entry.getKey(), entry.getValue().toString()));
            }
        }
        QCircleQualityReporter.reportQualityEvent(str, arrayList);
    }
}

package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.ItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.servlet.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import k15.a;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ReportLiveTask extends BaseReportTask {
    @Override // cooperation.qzone.mobilereport.BaseReportTask
    protected void doMobileReport(HashMap<ReportKey, ArrayList<ItemInfo>> hashMap) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<ReportKey, ArrayList<ItemInfo>> entry : hashMap.entrySet()) {
            UserActionReportBuilder userActionReportBuilder = new UserActionReportBuilder();
            userActionReportBuilder.setReportKey(entry.getKey());
            Iterator<ItemInfo> it = entry.getValue().iterator();
            while (it.hasNext()) {
                userActionReportBuilder.addItemInfo(it.next());
            }
            arrayList.add(userActionReportBuilder.build());
        }
        g.a(8, runtime, new UserCommReportBuilder().setUin(runtime.getLongAccountUin()).setNetwork_type(a.e()).build(), arrayList);
    }
}

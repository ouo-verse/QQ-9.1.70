package do2;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f extends r {
    public String C;
    public String D;
    public long F;
    public boolean E = true;
    public String G = "xiaoweiba";

    public f(String str, String str2, long j3) {
        this.C = str;
        this.D = str2;
        this.F = j3;
    }

    public void v(View view) {
        if (!TextUtils.isEmpty(this.D)) {
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            ax c16 = bi.c((BaseQQAppInterface) appInterface, view.getContext(), this.D);
            if (c16 != null) {
                c16.b();
            } else if (this.D.startsWith("http://") || this.D.startsWith("https://")) {
                Context context = view.getContext();
                HashMap hashMap = new HashMap();
                hashMap.put("url", this.D);
                ((ISearchActivityJumpFetcher) QRoute.api(ISearchActivityJumpFetcher.class)).jumpToQQBrowserActivity(context, hashMap);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                jSONObject.put("event_src", "client");
                jSONObject.put("get_src", "web");
            } catch (JSONException e16) {
                QLog.e("Q.uniteSearch.SearchResultGroupModelImpl", 2, "e = " + e16);
            }
            com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_result").action("clk_tail").obj1(this.F + "").ver1(((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getCurrKeyword()).ver2(com.tencent.mobileqq.search.report.b.a(((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getFromForHistoryCode())).ver7(jSONObject.toString()).session_id(appInterface.getCurrentAccountUin() + SearchUtils.f284963l));
        }
    }

    public void w(boolean z16) {
        this.E = z16;
    }
}

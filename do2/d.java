package do2;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.al;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends com.tencent.mobileqq.search.model.a {
    public static final String C = "d";
    public static final String D = HardCodeUtil.qqStr(R.string.n5o);

    /* renamed from: i, reason: collision with root package name */
    private List<y> f394365i;

    /* renamed from: m, reason: collision with root package name */
    private String f394366m;

    public d(List<y> list, String str) {
        this.f394365i = list;
        this.f394366m = str;
        r(15);
    }

    @Override // com.tencent.mobileqq.search.model.x
    public String l() {
        return HardCodeUtil.qqStr(R.string.n5u);
    }

    @Override // com.tencent.mobileqq.search.model.x
    /* renamed from: m */
    public String getKeyword() {
        return this.f394366m;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public int n() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public List<y> o() {
        return this.f394365i;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public void q(View view) {
        if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
            HashMap<v, SearchUtils.d> hashMap = SearchUtils.f284965n;
            if (hashMap.containsKey(this)) {
                SearchUtils.d dVar = hashMap.get(this);
                AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                    jSONObject.put("event_src", "client");
                    jSONObject.put("obj_lct", dVar.f284978c);
                    jSONObject.put("get_src", "native");
                } catch (JSONException e16) {
                    QLog.e(C, 2, "e = " + e16);
                }
                com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(dVar.f284977b + "").obj2(dVar.f284980e).ver1(dVar.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getFromForHistoryCode())).ver7(jSONObject.toString()).session_id(appInterface.getCurrentAccountUin() + SearchUtils.f284963l));
            }
        }
        QBaseActivity qBaseActivity = (QBaseActivity) view.getContext();
        ((ISearchActivityJumpFetcher) QRoute.api(ISearchActivityJumpFetcher.class)).jumpToFavoriteSearchActivity(qBaseActivity, this.f394366m);
        ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).refreshFavList(qBaseActivity, qBaseActivity.getAppRuntime().getAccount(), 0L);
        SearchUtils.c1(this.f394366m, 60, 0, view);
        al.a(s(), k(), getKeyword(), D);
        com.tencent.mobileqq.search.report.b.e(null, s(), 0, "0X8009D55", 0, 0, null, null);
    }
}

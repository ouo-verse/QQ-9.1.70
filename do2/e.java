package do2;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends x {
    public static final String C = "e";
    public static final String D = HardCodeUtil.qqStr(R.string.n5x);

    /* renamed from: h, reason: collision with root package name */
    List<y> f394367h;

    /* renamed from: i, reason: collision with root package name */
    String f394368i;

    /* renamed from: m, reason: collision with root package name */
    int f394369m;

    public e(List<y> list, String str, int i3) {
        this.f394367h = list;
        this.f394368i = str;
        this.f394369m = i3;
        r(16);
    }

    @Override // com.tencent.mobileqq.search.model.x
    public String l() {
        return HardCodeUtil.qqStr(R.string.n5f);
    }

    @Override // com.tencent.mobileqq.search.model.x
    /* renamed from: m */
    public String getKeyword() {
        if (this.f394367h.size() > n()) {
            com.tencent.mobileqq.search.report.b.e(null, 0, this.f394369m, "0X8009D5A", 0, 0, null, null);
        }
        return this.f394368i;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public int n() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public List<y> o() {
        return this.f394367h;
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
        SearchUtils.c1(this.f394368i, 100, 0, view);
        FileManagerReporter.addData("0X8006061");
        com.tencent.mobileqq.search.report.b.e(null, 0, this.f394369m, "0X8009D5B", 0, 0, null, null);
        ((ISearchActivityJumpFetcher) QRoute.api(ISearchActivityJumpFetcher.class)).jumpToFileSearchActivity(view.getContext(), this.f394368i, this.f394367h, true, this.f394369m);
    }
}

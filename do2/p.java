package do2;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class p extends x {
    public static final String C = HardCodeUtil.qqStr(R.string.n5a);

    /* renamed from: h, reason: collision with root package name */
    private final List<y> f394395h;

    /* renamed from: i, reason: collision with root package name */
    private final String f394396i;

    /* renamed from: m, reason: collision with root package name */
    private int f394397m;

    public p(List<y> list, String str, int i3) {
        this.f394395h = list;
        this.f394396i = str;
        this.f394397m = i3;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public String l() {
        if (this.f394397m == 12) {
            return HardCodeUtil.qqStr(R.string.n5z) + ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), MobileQQ.sMobileQQ);
        }
        return C;
    }

    @Override // com.tencent.mobileqq.search.model.x
    /* renamed from: m */
    public String getKeyword() {
        return this.f394396i;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public int n() {
        return nn2.a.e("pref_fts_native_search_public_account_max_num", 3);
    }

    @Override // com.tencent.mobileqq.search.model.x
    public List<y> o() {
        return this.f394395h;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public void q(View view) {
        SearchUtils.c1(this.f394396i, 50, 0, view);
        Context context = view.getContext();
        if (context != null && (context instanceof QBaseActivity)) {
            ReportController.n((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "0", "0X8005D1C", "0X8005D1C", 0, 1, 0, "0", "", this.f394396i, "");
        }
        if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
            SearchUtils.W0("all_result", "clk_public_uin_more", "" + this.f394396i);
            com.tencent.mobileqq.search.report.b.e(null, 0, this.f394397m, "0X8009D53", 0, 0, null, null);
        }
        ((ISearchActivityJumpFetcher) QRoute.api(ISearchActivityJumpFetcher.class)).jumpToPublicAcntSearchActivity(view.getContext(), this.f394396i, this.f394397m);
    }
}

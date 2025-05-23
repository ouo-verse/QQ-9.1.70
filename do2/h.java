package do2;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.api.ISearchReportFetcher;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h extends x {
    public static final String D = HardCodeUtil.qqStr(R.string.n5d);
    private y C;

    /* renamed from: h, reason: collision with root package name */
    public List<y> f394373h;

    /* renamed from: i, reason: collision with root package name */
    private String f394374i;

    /* renamed from: m, reason: collision with root package name */
    private int f394375m;

    public h(List<y> list, String str, int i3) {
        this.f394373h = list;
        this.f394374i = str;
        this.f394375m = i3;
        r(6);
    }

    @Override // com.tencent.mobileqq.search.model.x
    public String l() {
        return D;
    }

    @Override // com.tencent.mobileqq.search.model.x
    /* renamed from: m */
    public String getKeyword() {
        return this.f394374i;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public int n() {
        return nn2.a.e("fts_native_contactor_maxnum", 3);
    }

    @Override // com.tencent.mobileqq.search.model.x
    public List<y> o() {
        return this.f394373h;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public void q(View view) {
        ((ISearchActivityJumpFetcher) QRoute.api(ISearchActivityJumpFetcher.class)).jumpToContactSearchActivity(view.getContext(), this.f394374i, this.f394375m, SearchConfig.needSeparate ? 1 : 0);
        SearchUtils.c1(this.f394374i, 20, 0, view);
        if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
            SearchUtils.W0("all_result", "more_contact", "" + this.f394374i);
            if (SearchConfig.needSeparate) {
                SearchUtils.V0("search", "contact", "more", 0, 0, SearchUtils.b0(this.f394375m));
            }
            ((ISearchReportFetcher) QRoute.api(ISearchReportFetcher.class)).onReportClick898(null, 0, this.f394375m, "0X8009D39", 0, 0, null, null);
        }
    }

    public y s() {
        return this.C;
    }

    public int t() {
        return this.f394375m;
    }
}

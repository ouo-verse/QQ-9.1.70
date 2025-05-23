package do2;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchReportFetcher;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j extends x {

    /* renamed from: h, reason: collision with root package name */
    public List<y> f394379h;

    /* renamed from: i, reason: collision with root package name */
    private String f394380i;

    /* renamed from: m, reason: collision with root package name */
    protected int f394381m;

    public j(List<y> list, String str, int i3) {
        this.f394379h = list;
        this.f394380i = str;
        this.f394381m = i3;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public String l() {
        return HardCodeUtil.qqStr(R.string.f172078n61);
    }

    @Override // com.tencent.mobileqq.search.model.x
    /* renamed from: m */
    public String getKeyword() {
        return this.f394380i;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public int n() {
        return 3;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public List<y> o() {
        return this.f394379h;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public void q(View view) {
        ((ISearchReportFetcher) QRoute.api(ISearchReportFetcher.class)).onReportClick898(null, 0, this.f394381m, "0X8009D47", 0, 0, null, null);
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(view.getContext(), "mqqapi://microapp/open?url=" + SearchUtils.m("https://m.q.qq.com/a/p/1108291530?via=2005_2&referer=2005&s=" + SearchUtils.m("pages/search-results/search-results?mode=search&q=" + this.f394380i)), 2005, null);
    }

    public int s() {
        return this.f394381m;
    }
}

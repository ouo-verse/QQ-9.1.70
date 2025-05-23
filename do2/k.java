package do2;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class k extends x {

    /* renamed from: h, reason: collision with root package name */
    private String f394382h;

    /* renamed from: i, reason: collision with root package name */
    private int f394383i;

    public k(String str, int i3) {
        this.f394382h = str;
        this.f394383i = i3;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public String l() {
        return HardCodeUtil.qqStr(R.string.n5l);
    }

    @Override // com.tencent.mobileqq.search.model.x
    /* renamed from: m */
    public String getKeyword() {
        return this.f394382h;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public int n() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public List<y> o() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public void q(View view) {
        ((ISearchActivityJumpFetcher) QRoute.api(ISearchActivityJumpFetcher.class)).jumpToSearchBaseActivity((Activity) view.getContext(), this.f394382h, this.f394383i);
        SearchUtils.c1(this.f394382h, 0, 0, view);
        ReportController.o(null, "CliOper", "", "", "0X80061B7", "0X80061B7", 0, 0, "", "", "", "");
    }
}

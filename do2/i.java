package do2;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i extends x {

    /* renamed from: m, reason: collision with root package name */
    public static final String f394376m = HardCodeUtil.qqStr(R.string.f172080n63);

    /* renamed from: h, reason: collision with root package name */
    private List<y> f394377h;

    /* renamed from: i, reason: collision with root package name */
    private String f394378i;

    @Override // com.tencent.mobileqq.search.model.x
    public String l() {
        return f394376m;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public String m() {
        return this.f394378i;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public int n() {
        return 3;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public List<y> o() {
        return this.f394377h;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public void q(View view) {
        SearchUtils.c1(this.f394378i, 40, 0, view);
        ((ISearchActivityJumpFetcher) QRoute.api(ISearchActivityJumpFetcher.class)).jumpToMessageSearchActivity(view.getContext(), this.f394378i);
    }
}

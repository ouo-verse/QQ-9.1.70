package do2;

import addcontacts.AccountSearchPb$record;
import android.app.Activity;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.mobileqq.search.model.z;
import com.tencent.mobileqq.search.util.SearchUtils;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends z {
    private AccountSearchPb$record G;
    private String H;
    private CharSequence I;
    private CharSequence J;

    public c(AccountSearchPb$record accountSearchPb$record, String str, CharSequence charSequence) {
        this.G = accountSearchPb$record;
        this.H = str;
        this.I = charSequence;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        if (this.G.uin.get() != 0) {
            return 1;
        }
        return 11;
    }

    @Override // com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        if (this.G.uin.get() != 0) {
            return String.valueOf(this.G.uin.get());
        }
        return this.G.mobile.get();
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        return HardCodeUtil.qqStr(R.string.n4y);
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence o() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: s */
    public String getKeyword() {
        return this.H;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: t */
    public CharSequence getSubTitleSpans() {
        String str;
        if (this.J == null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("(");
            if (this.G.uin.get() != 0) {
                str = String.valueOf(this.G.uin.get());
            } else {
                str = this.G.mobile.get();
            }
            sb5.append(str);
            sb5.append(")");
            this.J = SearchUtils.C(sb5.toString(), this.H);
        }
        return this.J;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        return this.I;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(View view) {
        ((ISearchActivityJumpFetcher) QRoute.api(ISearchActivityJumpFetcher.class)).jumpToProfileCardActivity((Activity) view.getContext(), new SearchResultItem(this.G), (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), true, 1);
        SearchUtils.c1(this.H, 70, 0, view);
        SearchUtils.Z0(this.H, 70, view, false);
    }
}

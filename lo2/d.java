package lo2;

import addcontacts.AccountSearchPb$hotwordrecord;
import addcontacts.AccountSearchPb$record;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.search.util.SearchUtils;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends com.tencent.mobileqq.search.model.z {
    private AccountSearchPb$record G;
    private AccountSearchPb$hotwordrecord H;
    private String I;
    private CharSequence J;
    private String K;
    private CharSequence L;

    public d(AccountSearchPb$record accountSearchPb$record, String str, CharSequence charSequence) {
        this.H = null;
        this.G = accountSearchPb$record;
        this.I = str;
        this.J = charSequence;
    }

    public String G() {
        AccountSearchPb$hotwordrecord accountSearchPb$hotwordrecord = this.H;
        if (accountSearchPb$hotwordrecord != null) {
            return accountSearchPb$hotwordrecord.hotword_cover_url.get();
        }
        return this.G.title_image.get();
    }

    public AccountSearchPb$hotwordrecord H() {
        return this.H;
    }

    public AccountSearchPb$record I() {
        return this.G;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        AccountSearchPb$hotwordrecord accountSearchPb$hotwordrecord = this.H;
        if (accountSearchPb$hotwordrecord == null || !accountSearchPb$hotwordrecord.hotword_description.has()) {
            return null;
        }
        return this.H.hotword_description.get();
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
        return this.I;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: t */
    public CharSequence getSubTitle() {
        if (this.H != null) {
            return this.L;
        }
        return HardCodeUtil.qqStr(R.string.f172074n51);
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitle() {
        return this.J;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(View view) {
        SearchUtils.c1(this.I, 110, 0, view);
        Bundle bundle = new Bundle();
        if (this.H != null) {
            bundle.putString("url", this.K);
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8006F28", "0X8006F28", 0, 0, getKeyword(), this.H.hotword.get(), String.valueOf(this.H.hotword_type.get()), "1");
        } else {
            AccountSearchPb$record accountSearchPb$record = this.G;
            if (accountSearchPb$record != null) {
                bundle.putString("url", accountSearchPb$record.article_short_url.get());
            }
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(view.getContext(), IPublicAccountBrowser.ROUTE_NAME);
        activityURIRequest.extra().putAll(bundle);
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
        if (this.G != null) {
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8006536", "0X8006536", 0, 0, "", "", this.I, String.valueOf(this.G.account_id.get()));
        }
    }

    public d(AccountSearchPb$hotwordrecord accountSearchPb$hotwordrecord, String str, CharSequence charSequence, String str2, CharSequence charSequence2) {
        this.H = accountSearchPb$hotwordrecord;
        this.I = str;
        this.J = charSequence;
        this.K = str2;
        this.L = charSequence2;
    }
}

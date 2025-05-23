package do2;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends x {
    private String C;

    /* renamed from: h, reason: collision with root package name */
    private List<y> f394362h;

    /* renamed from: i, reason: collision with root package name */
    private String f394363i;

    /* renamed from: m, reason: collision with root package name */
    private un2.a f394364m;

    public b(un2.a aVar, List<y> list, String str, String str2) {
        this.f394362h = list;
        this.f394363i = str;
        this.f394364m = aVar;
        this.C = str2;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public String l() {
        return HardCodeUtil.qqStr(R.string.f172073n50);
    }

    @Override // com.tencent.mobileqq.search.model.x
    /* renamed from: m */
    public String getKeyword() {
        return this.f394363i;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public int n() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public List<y> o() {
        return this.f394362h;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public void q(View view) {
        SearchUtils.c1(this.f394363i, 110, 0, view);
        lo2.d dVar = (lo2.d) this.f394362h.get(0);
        if (dVar != null && !TextUtils.isEmpty(this.C)) {
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(view.getContext(), IPublicAccountBrowser.ROUTE_NAME);
            activityURIRequest.extra().putString("url", this.C);
            QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
            if (dVar.H() != null) {
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8006F28", "0X8006F28", 0, 0, dVar.getKeyword(), dVar.H().hotword.get(), String.valueOf(dVar.H().hotword_type.get()), "2");
            }
        }
        view.getContext();
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8006536", "0X8006536", 0, 0, "", "0", this.f394363i, "0");
    }
}

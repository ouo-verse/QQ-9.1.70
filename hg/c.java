package hg;

import android.view.View;
import android.widget.TextView;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends vg.a {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f441565h != null && un.c.e().h(this.f441565h)) {
            un.c.e().k(i());
        } else {
            QQToast.makeText(BaseApplication.getContext(), l.a(R.string.kvz), 1).show();
        }
        M();
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData != null) {
            LpReportInfo_pf00064.allReport(3001, 1, 1, (String) null, J(businessFeedData.getFeedCommInfo().appid));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void M() {
        if (this.f441565h != null) {
            QZoneFeedService.U().Q(this.f441565h);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFeedReeditPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nou;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void C(View view) {
        ((TextView) view.findViewById(R.id.mtv)).setOnClickListener(new View.OnClickListener() { // from class: hg.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.this.K(view2);
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: hg.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.L(view2);
            }
        });
    }

    private String J(int i3) {
        if (i3 == 4) {
            return "album";
        }
        if (i3 != 311) {
            return "unknown";
        }
        return LpReportInfoConfig.RESERVE_DELETE_FEED_TYPE_SHUOSHUO;
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
    }
}

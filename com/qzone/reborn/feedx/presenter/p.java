package com.qzone.reborn.feedx.presenter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes37.dex */
public class p extends vg.a implements View.OnClickListener {
    private TextView F;
    private ImageView G;

    private String I(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        return calendar.get(1) + "\u5e74" + (calendar.get(2) + 1) + "\u6708";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        gf.m mVar = (gf.m) j(gf.m.class);
        if (mVar != null) {
            mVar.db(true);
        }
        com.qzone.misc.network.report.c.b("308", "67");
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (businessFeedData.showDateHeader) {
            this.f441562d.setVisibility(0);
            this.F.setText(I(businessFeedData.getFeedCommInfo().getTime()));
            com.tencent.mobileqq.qzone.picload.c.a().j(this.G, new c.C8489c().h("qui_calendar").e(R.color.qui_common_icon_secondary));
            this.G.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    p.this.J(view);
                }
            });
            AccessibilityUtil.p(this.G, com.qzone.util.l.a(R.string.f2201768e));
            return;
        }
        this.f441562d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFeedDateHeaderPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nng;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void C(View view) {
        this.F = (TextView) view.findViewById(R.id.f162850mz1);
        this.G = (ImageView) view.findViewById(R.id.f162849mz0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}

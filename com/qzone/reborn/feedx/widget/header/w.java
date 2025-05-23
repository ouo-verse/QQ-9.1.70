package com.qzone.reborn.feedx.widget.header;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.feedx.viewmodel.QZoneFeedxMoodListViewModel;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.widget.DinTypeFaceTextView;

/* compiled from: P */
/* loaded from: classes37.dex */
public class w extends d {
    private DinTypeFaceTextView C;
    private TextView D;
    private final ImageView E;

    /* renamed from: f, reason: collision with root package name */
    private QZoneFeedxMoodListViewModel f56329f;

    /* renamed from: h, reason: collision with root package name */
    private int f56330h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f56331i;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f56332m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            userInfo.qzone_uin = LoginData.getInstance().getUin() + "";
            userInfo.nickname = LoginData.getInstance().getNickName("");
            QZoneHelper.forwardToShuoshuoDailyCalendar(w.this.g(), userInfo, -1);
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 32, 7);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (w.this.g() != null) {
                RDMEtraMsgCollector.getInstance().addNoramlClickAction(w.this.g().getLocalClassName(), view);
                QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
                qZonePublishMoodInitBean.t0(0);
                Boolean bool = Boolean.FALSE;
                qZonePublishMoodInitBean.R0(bool);
                qZonePublishMoodInitBean.C0("shuoshuoList");
                qZonePublishMoodInitBean.O0(22);
                qZonePublishMoodInitBean.G0(Boolean.TRUE);
                qZonePublishMoodInitBean.v0(bool);
                ho.i.w().c(w.this.g(), qZonePublishMoodInitBean);
                com.qzone.misc.network.report.b.d();
                LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 4, 2);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public w(View view) {
        super(view);
        this.f56330h = 0;
        this.f56331i = true;
        this.f56332m = (LinearLayout) view.findViewById(R.id.mh5);
        this.C = (DinTypeFaceTextView) view.findViewById(R.id.f162761mh4);
        this.D = (TextView) view.findViewById(R.id.niw);
        this.E = (ImageView) view.findViewById(R.id.mqh);
    }

    private void o() {
        rn.h.a(this.E, "qui_chevron_right", R.color.qui_common_icon_secondary);
    }

    private void p() {
        this.f56332m.setOnClickListener(new a());
        this.D.setOnClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(x6.e eVar) {
        s(eVar);
        t(eVar);
    }

    private void s(x6.e eVar) {
        this.f56330h = LocalMultiProcConfig.getInt4Uin("qzone_applist_daily_shuoshuo_count", 0, LoginData.getInstance().getUin());
        boolean config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_SHUOSHUO_CALENDAR_FRIEND_FEED, true);
        this.f56331i = config;
        if (this.f56330h > 0 && config) {
            this.f56332m.setVisibility(0);
            this.C.setText(String.valueOf(this.f56330h));
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 32, 6);
            return;
        }
        this.f56332m.setVisibility(8);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneMoodListHeaderShareElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        QZoneFeedxMoodListViewModel qZoneFeedxMoodListViewModel = (QZoneFeedxMoodListViewModel) k(QZoneFeedxMoodListViewModel.class);
        this.f56329f = qZoneFeedxMoodListViewModel;
        qZoneFeedxMoodListViewModel.v2().observe(i(), new Observer() { // from class: com.qzone.reborn.feedx.widget.header.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                w.this.q((x6.e) obj);
            }
        });
        o();
        p();
    }

    private void t(x6.e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.f447271b)) {
            return;
        }
        this.D.setText(eVar.f447271b);
    }
}

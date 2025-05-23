package com.qzone.reborn.feedx.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.business.tianshu.QZoneCommentQuickInputHelper;
import com.qzone.business.tianshu.model.QZoneQuickCommentInfo;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;

/* compiled from: P */
/* loaded from: classes37.dex */
public class n extends vg.a implements View.OnClickListener {
    private View F;
    private QZoneUserAvatarView G;
    private TextView H;
    private ImageView I;
    private gf.a J;

    private void J(String str) {
        L();
        if (TextUtils.isEmpty(str)) {
            rn.h.a(this.I, "qui_quick_comment", R.color.qui_common_icon_secondary);
            return;
        }
        Option obtain = Option.obtain();
        obtain.setUrl(str);
        obtain.setTargetView(this.I);
        if (this.I.getLayoutParams() != null) {
            obtain.setRequestWidth(this.I.getLayoutParams().width);
            obtain.setRequestHeight(this.I.getLayoutParams().height);
        }
        com.tencent.mobileqq.qzone.picload.c.a().i(obtain, new a());
    }

    private void K() {
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData == null) {
            return;
        }
        final String a16 = ef.b.a(businessFeedData);
        RFWIocAbilityProvider.g().getIoc(gf.e.class).originView(this.f441563e).done(new OnPromiseResolved() { // from class: com.qzone.reborn.feedx.presenter.m
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                n.this.O(a16, (gf.e) obj);
            }
        }).run();
    }

    private void L() {
        fo.c.o(this.I, "em_qz_quick_review_icon", new fo.b().i(ef.b.a(this.f441565h)).k(ExposurePolicy.REPORT_ALL).j(EndExposurePolicy.REPORT_ALL).g(ClickPolicy.REPORT_ALL));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(String str, gf.e eVar) {
        eVar.k5(this.F, "em_qz_comment_box", str, this.f441565h);
        eVar.k5(this.H, "em_qz_comment_box", str, this.f441565h);
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (!com.qzone.reborn.feedx.util.x.f55790a.h(businessFeedData)) {
            this.f441562d.setVisibility(8);
            if (businessFeedData.isFakeFeed()) {
                this.f441562d.setVisibility(0);
                this.H.setEnabled(false);
                this.I.setEnabled(false);
                this.F.setEnabled(false);
            }
        } else {
            this.f441562d.setVisibility(0);
            this.H.setEnabled(true);
            this.I.setEnabled(true);
            this.F.setEnabled(true);
        }
        String g16 = com.qzone.reborn.feedx.util.aa.g(businessFeedData);
        if (!TextUtils.isEmpty(g16) && businessFeedData.isCommentEmpty()) {
            this.H.setText(g16);
        } else {
            this.H.setText(com.qzone.util.l.a(R.string.f21933665));
        }
        if (com.qzone.reborn.feedx.util.x.f(o())) {
            QZoneCommentQuickInputHelper.n().p(new QZoneCommentQuickInputHelper.a() { // from class: com.qzone.reborn.feedx.presenter.l
                @Override // com.qzone.business.tianshu.QZoneCommentQuickInputHelper.a
                public final void a(QZoneQuickCommentInfo qZoneQuickCommentInfo) {
                    n.this.P(qZoneQuickCommentInfo);
                }
            });
        }
        K();
    }

    protected void N(int i3) {
        if (this.J == null) {
            this.J = (gf.a) j(gf.a.class);
        }
        if (this.J != null) {
            com.qzone.reborn.feedx.bean.b bVar = new com.qzone.reborn.feedx.bean.b(this.f441565h);
            bVar.f54740a = this.f441567m;
            bVar.f54741b = 5;
            bVar.f54742c = i3;
            this.J.f6(bVar);
            this.J.c1(this.f441565h, null, this.f441567m);
        }
        com.qzone.util.ap.f59791b.e(5, 1, this.f441567m, this.f441565h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFeedCommonInputPresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        switch (view.getId()) {
            case R.id.mrr /* 1745224632 */:
            case R.id.mrs /* 1745224633 */:
                M();
                break;
            case R.id.f162822mt3 /* 1745224680 */:
                N(2);
                break;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        super.onDestroy();
        QZoneCommentQuickInputHelper.n().r();
    }

    @Override // vg.a
    protected int s() {
        return R.id.nne;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements IPicLoadStateListener {
        a() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState == null || !loadState.isFinishSuccess()) {
                return;
            }
            QLog.i("QZoneFeedCommonInputPresenter", 2, "[bindCommentQuickInput] success ");
        }
    }

    protected void M() {
        N(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(QZoneQuickCommentInfo qZoneQuickCommentInfo) {
        if (qZoneQuickCommentInfo != null) {
            J(qZoneQuickCommentInfo.getEntrancePic());
        }
    }

    @Override // vg.a
    protected void C(View view) {
        QZoneUserAvatarView qZoneUserAvatarView = (QZoneUserAvatarView) view.findViewById(R.id.ncf);
        this.G = qZoneUserAvatarView;
        qZoneUserAvatarView.setUser(LoginData.getInstance().getUin());
        this.G.setIsShieldJumpToMainPage(com.qzone.reborn.feedx.util.x.f55790a.g(o()));
        this.H = (TextView) view.findViewById(R.id.mrs);
        this.I = (ImageView) view.findViewById(R.id.f162822mt3);
        if (QQTheme.isNowThemeIsNight()) {
            this.H.setBackgroundResource(R.drawable.f15103h);
        } else {
            this.H.setBackgroundResource(R.drawable.f15093g);
        }
        this.F = view.findViewById(R.id.mrr);
        this.H.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.I.setOnClickListener(this);
        AccessibilityUtil.s(this.G, com.qzone.util.l.a(R.string.gqm));
    }
}

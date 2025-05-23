package com.qzone.common.activities.base;

import com.qzone.detail.ui.component.QzoneForbidenUserView;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.AbsListView;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;

/* compiled from: P */
@Named("BaseFeedFragmentForbiddenViewImp")
/* loaded from: classes39.dex */
public class p implements d5.q {

    /* renamed from: d, reason: collision with root package name */
    private static final int f45529d = ViewUtils.dip2px(480.0f);

    /* renamed from: a, reason: collision with root package name */
    protected d5.u f45530a;

    /* renamed from: b, reason: collision with root package name */
    protected QzoneForbidenUserView f45531b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f45532c = false;

    @Inject
    public p() {
    }

    private void h() {
        this.f45531b.setTopIcon(null, R.drawable.f162264g74);
        this.f45531b.setMessage((String) null);
        this.f45531b.setmTimelimitMessage(R.string.gn_);
        this.f45531b.b();
        this.f45531b.setTimelimitTextSize(15.0f);
        this.f45531b.setTimelimitTopMargin(-AreaConst.dp10);
        this.f45531b.setBackgroundAlpha(0);
    }

    @Override // d5.q
    public void a(d5.m mVar) {
        QzoneForbidenUserView qzoneForbidenUserView = this.f45531b;
        if (qzoneForbidenUserView != null) {
            mVar.a(qzoneForbidenUserView);
        }
    }

    @Override // d5.q
    public void b(d5.m mVar) {
        if (this.f45531b != null || mVar == null) {
            return;
        }
        this.f45531b = new QzoneForbidenUserView(this.f45530a.getActivity());
        this.f45531b.setLayoutParams(new AbsListView.LayoutParams(-1, f45529d));
        this.f45531b.setShowTopLine(false);
        this.f45531b.setDefaultTopIcon(R.drawable.g75);
        this.f45531b.setmTimelimitMessage(R.string.ghb);
        this.f45531b.setTimelimitTextSize(15.0f);
        this.f45531b.setTimelimitTopMargin(-AreaConst.dp10);
        this.f45531b.setBackgroundAlpha(0);
    }

    @Override // d5.q
    public boolean c(d5.m mVar) {
        return false;
    }

    @Override // d5.q
    public void d(d5.m mVar, int i3, boolean z16) {
        if (this.f45531b == null) {
            return;
        }
        if (!NetworkState.isNetSupport()) {
            f(i3);
        } else if (z16) {
            h();
        } else {
            g(i3);
        }
        mVar.a(this.f45531b);
        mVar.q(this.f45531b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(int i3) {
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "forbiddenViewFeedNoNetworkTitle", "\u65e0\u6cd5\u8fde\u63a5\u5230\u4e92\u8054\u7f51");
        String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "forbiddenViewFeedNoNetworkSummary", "\u8bf7\u5173\u95ed\u98de\u884c\u6a21\u5f0f\u6216\u68c0\u67e5\u8bbe\u5907\u7684\u7f51\u7edc\u8bbe\u7f6e");
        this.f45531b.setTopIcon(null, R.drawable.f162264g74);
        this.f45531b.setMessage(config);
        this.f45531b.setmTimelimitMessage(config2);
        this.f45531b.b();
        this.f45531b.setBackgroundAlpha(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(int i3) {
        this.f45531b.setBackgroundAlpha(i3);
        this.f45531b.a();
    }

    @Inject
    public void setContainer(d5.u uVar) {
        this.f45530a = uVar;
    }

    @Override // d5.q
    public void e(d5.m mVar, int i3) {
        QzoneForbidenUserView qzoneForbidenUserView;
        d(mVar, i3, false);
        if (!this.f45532c || (qzoneForbidenUserView = this.f45531b) == null) {
            return;
        }
        qzoneForbidenUserView.d();
    }
}

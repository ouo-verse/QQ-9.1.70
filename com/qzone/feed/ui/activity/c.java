package com.qzone.feed.ui.activity;

import com.qzone.common.activities.base.p;
import com.qzone.detail.ui.component.QzoneForbidenUserView;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.SystemUtil;
import d5.m;

/* compiled from: P */
@Named("MyFeedFragmentForbiddenViewImp")
/* loaded from: classes39.dex */
public class c extends p {

    /* renamed from: e, reason: collision with root package name */
    private static final int f47337e = ViewUtils.dip2px(230.0f);

    /* renamed from: f, reason: collision with root package name */
    private static final int f47338f = ViewUtils.dip2px(256.0f);

    /* renamed from: g, reason: collision with root package name */
    private static final int f47339g = ViewUtils.dip2px(256.0f);

    @Inject
    public c() {
    }

    @Override // com.qzone.common.activities.base.p, d5.q
    public void b(m mVar) {
        super.b(mVar);
        this.f45531b.setShowTopLine(false);
        this.f45531b.setTopIconTopMargin(f47337e);
        int notchHeight = SystemUtil.getNotchHeight(BaseApplication.getContext(), this.f45530a.getActivity());
        if (notchHeight == 0) {
            notchHeight = this.f45530a.getResources().getDimensionPixelSize(R.dimen.f159598b01);
        }
        int dimensionPixelSize = this.f45530a.getResources().getDimensionPixelSize(R.dimen.title_bar_height) + notchHeight;
        this.f45531b.getLayoutParams().height = (ViewUtils.getScreenHeight() - dimensionPixelSize) + ImmersiveUtils.getStatusBarHeight(this.f45530a.getContext());
        this.f45531b.setTopIconSize(f47338f, f47339g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.p
    public void f(int i3) {
        super.f(i3);
        this.f45531b.setMessageTopMargin(AreaConst.dp6);
        this.f45531b.setTimelimitTopMargin(AreaConst.dp8);
        this.f45531b.setMessageTextSize(18.0f);
        this.f45531b.setTimelimitTextSize(14.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.p
    public void g(int i3) {
        String config;
        super.g(i3);
        if (QQTheme.isNowThemeIsNightForQzone()) {
            config = "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_night_icon.png";
        } else {
            config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_FORBIDDEN_PAGE_FEED, QzoneConfig.SECONDARY_FORBIDDEN_VIEW_FEED_EMPTY_IMAGE_URL, "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_icon.png");
        }
        String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "myFeedPageForbiddenViewFeedEmptyTitle", "\u6682\u65f6\u8fd8\u6ca1\u6709\u6d88\u606f\u54e6\uff0c\u5206\u4eab\u4f60\u7684\u751f\u6d3b\u5427");
        QzoneForbidenUserView qzoneForbidenUserView = this.f45531b;
        int i16 = AreaConst.dp8;
        qzoneForbidenUserView.setMessageTopMargin(i16);
        this.f45531b.setTimelimitTopMargin(-i16);
        this.f45531b.setMessageTextSize(17.0f);
        this.f45531b.setTimelimitTextSize(14.0f);
        this.f45531b.setTopIcon(config);
        this.f45531b.setMessage(config2);
        this.f45531b.setmTimelimitMessage((String) null);
    }
}

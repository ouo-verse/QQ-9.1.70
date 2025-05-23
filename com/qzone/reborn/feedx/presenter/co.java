package com.qzone.reborn.feedx.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;

/* compiled from: P */
/* loaded from: classes37.dex */
public class co extends vg.a {
    private static final int I = ViewUtils.dip2px(176.0f);
    private static final int J = ViewUtils.dip2px(132.0f);
    private ImageView F;
    private TextView G;
    private TextView H;

    private void I(BusinessFeedData businessFeedData) {
        String str;
        if (this.G == null) {
            return;
        }
        if (businessFeedData != null) {
            str = com.qzone.reborn.feedx.util.n.a(businessFeedData.searchClickCalendar, businessFeedData.searchRealCalendar, businessFeedData.isBlankSearchNoResultTip);
        } else {
            str = "";
        }
        TextView textView = this.G;
        if (TextUtils.isEmpty(str)) {
            str = "\u8fd9\u7247\u661f\u7a7a\uff0c\u7b49\u4f60\u7684\u6545\u4e8b\u6765\u70b9\u4eae";
        }
        textView.setText(str);
    }

    private void J() {
        if (this.H == null) {
            return;
        }
        this.H.setText(com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NotTrace", "\u6ca1\u6709\u7559\u4e0b\u75d5\u8ff9"));
    }

    private void K() {
        ImageView imageView = this.F;
        if (imageView == null) {
            return;
        }
        com.qzone.reborn.util.h.i(this.C, imageView, "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_icon.png", I, J);
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        I(businessFeedData);
        K();
        J();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneUserHomeTimelineEmptyPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.now;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    private void H(View view) {
        if (view == null || !(view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = ViewUtils.getScreenWidth();
        layoutParams.height = ViewUtils.getScreenHeight() - ViewUtils.dip2px(200.0f);
        view.setLayoutParams(layoutParams);
    }

    @Override // vg.a
    protected void C(View view) {
        if (view == null) {
            return;
        }
        H(view);
        this.F = (ImageView) view.findViewById(R.id.mzc);
        this.G = (TextView) view.findViewById(R.id.f162824mu0);
        this.H = (TextView) view.findViewById(R.id.f162825mu1);
    }
}

package com.qzone.reborn.feedx.presenter;

import android.view.View;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes37.dex */
public class aq extends vg.a {
    private TextView F;
    private TextView G;

    private void H(Calendar calendar, Calendar calendar2, boolean z16) {
        this.G.setText(com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NotTrace", "\u6ca1\u6709\u7559\u4e0b\u75d5\u8ff9"));
        this.F.setText(com.qzone.reborn.feedx.util.n.a(calendar, calendar2, z16));
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (businessFeedData.isNeedShowSearchNoResultTip()) {
            this.f441562d.setVisibility(0);
            H(businessFeedData.searchClickCalendar, businessFeedData.searchRealCalendar, businessFeedData.isBlankSearchNoResultTip);
        } else {
            this.f441562d.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFeedNoResultTipsPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nns;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void C(View view) {
        this.F = (TextView) view.findViewById(R.id.f162865n15);
        this.G = (TextView) view.findViewById(R.id.n16);
    }
}

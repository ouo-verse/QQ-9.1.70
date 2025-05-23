package com.qzone.reborn.feedx.presenter;

import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bl extends vg.a implements View.OnClickListener {
    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (businessFeedData.getFeedCommInfo().isTopFeed()) {
            this.f441562d.setVisibility(0);
        } else {
            this.f441562d.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFeedTopTipsPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.noh;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void C(View view) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}

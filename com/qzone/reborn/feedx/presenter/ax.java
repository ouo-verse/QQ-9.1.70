package com.qzone.reborn.feedx.presenter;

import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneSinglePicWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ax extends vg.a {
    private QZoneSinglePicWidgetView F;
    private QZoneSinglePicWidgetView.b G;

    public void H(QZoneSinglePicWidgetView.b bVar) {
        this.G = bVar;
        this.F.z0(bVar);
    }

    @Override // vg.a
    /* renamed from: k */
    protected String getTAG() {
        return "QZoneFeedSinglePicPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nod;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            QLog.e("QZoneFeedSinglePicPresenter", 1, "onBindData params error");
        } else {
            this.F.setData(businessFeedData, this.f441567m);
        }
    }

    @Override // vg.a
    protected void C(View view) {
        this.F = (QZoneSinglePicWidgetView) view.findViewById(R.id.nba);
    }
}

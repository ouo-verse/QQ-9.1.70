package com.qzone.reborn.feedx.presenter;

import android.text.TextUtils;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ck extends bk {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        VideoInfo videoInfo = this.f441565h.getVideoInfo();
        if (videoInfo.actionType == 23 && !TextUtils.isEmpty(videoInfo.actionUrl)) {
            yo.d.d(videoInfo.actionUrl, view.getContext(), null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.presenter.bk, vg.a
    public void A(BusinessFeedData businessFeedData) {
        BusinessFeedData businessFeedData2;
        super.A(businessFeedData);
        if (this.F == null || (businessFeedData2 = this.f441565h) == null || businessFeedData2.getVideoInfo() == null) {
            return;
        }
        this.F.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.cj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ck.this.i0(view);
            }
        });
    }
}

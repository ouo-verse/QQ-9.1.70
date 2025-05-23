package com.qzone.reborn.feedx.presenter;

import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes37.dex */
public class cg extends al {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(BusinessFeedData businessFeedData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        xg.d.a(businessFeedData, this.C, this.I);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.reborn.feedx.presenter.al
    protected void J(BusinessFeedData businessFeedData, View view) {
        xg.d.a(businessFeedData, this.C, view);
    }

    @Override // com.qzone.reborn.feedx.presenter.al
    protected void L(BusinessFeedData businessFeedData) {
        if (this.G == null || !I(businessFeedData)) {
            return;
        }
        this.G.setVisibility(8);
    }

    @Override // com.qzone.reborn.feedx.presenter.al
    protected void M(final BusinessFeedData businessFeedData) {
        if (this.I == null || !I(businessFeedData)) {
            return;
        }
        if (businessFeedData != null && businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getCellSummaryV2() != null) {
            H(0, 0, 0, 0);
            this.I.setRichText(businessFeedData.getOriginalInfo().getCellSummaryV2().displayStr);
            this.I.setVisibility(0);
            this.I.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.cf
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    cg.this.Q(businessFeedData, view);
                }
            });
            return;
        }
        this.I.setVisibility(8);
    }

    @Override // com.qzone.reborn.feedx.presenter.al
    protected void N(BusinessFeedData businessFeedData) {
        if (this.H == null || this.J == null || !I(businessFeedData)) {
            return;
        }
        this.J.setVisibility(8);
        this.H.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.presenter.al
    public boolean I(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || !businessFeedData.isReprintedTextBlogFeed() || businessFeedData.isNewHandBlogFeed()) ? false : true;
    }
}

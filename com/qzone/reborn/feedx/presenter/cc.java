package com.qzone.reborn.feedx.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes37.dex */
public class cc extends vg.a {
    private QZoneRichTextView F;
    private TextView G;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(BusinessFeedData businessFeedData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ho.h.b(this.C, businessFeedData.getUser().uin);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // vg.a
    protected void A(final BusinessFeedData businessFeedData) {
        String c16 = com.qzone.reborn.feedx.util.n.c(businessFeedData);
        if (businessFeedData == null || businessFeedData.getUser() == null) {
            return;
        }
        if (!TextUtils.isEmpty(c16)) {
            this.F.setRichText(c16);
            this.F.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.cb
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    cc.this.I(businessFeedData, view);
                }
            });
            this.G.setText(BaseApplication.getContext().getString(R.string.mvr));
            this.f441562d.setVisibility(0);
            return;
        }
        this.G.setText("");
        this.f441562d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneForwardBlogContentTitlePresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.noj;
    }

    @Override // vg.a
    protected boolean w(BusinessFeedData businessFeedData) {
        return com.qzone.reborn.feedx.itemview.d.e(businessFeedData);
    }

    @Override // vg.a
    protected boolean x() {
        return true;
    }

    @Override // vg.a
    protected void C(View view) {
        this.F = (QZoneRichTextView) view.findViewById(R.id.f192254);
        this.G = (TextView) view.findViewById(R.id.f192355);
    }
}

package com.qzone.reborn.feedx.presenter;

import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZonePicMixVideoView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class cd extends d {
    private QZoneRichTextView F;
    private QZoneRichTextView G;
    private QZonePicMixVideoView H;
    private View I;

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        Q(businessFeedData, this.F);
        O(businessFeedData, this.G);
        P(businessFeedData, this.G, this.H);
        View view = this.I;
        if (view != null) {
            view.setBackgroundResource(R.drawable.f15153m);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFeedBlogPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nmc;
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
        this.I = view.findViewById(R.id.n29);
        this.F = (QZoneRichTextView) view.findViewById(R.id.f162809mr1);
        this.G = (QZoneRichTextView) view.findViewById(R.id.mqy);
        QZonePicMixVideoView qZonePicMixVideoView = (QZonePicMixVideoView) view.findViewById(R.id.f162808mr0);
        this.H = qZonePicMixVideoView;
        qZonePicMixVideoView.setItemViewMultiBorderWidth((int) (com.qzone.reborn.feedx.itemview.c.f54845a * 4.0f));
    }
}

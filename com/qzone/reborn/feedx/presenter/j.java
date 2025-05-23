package com.qzone.reborn.feedx.presenter;

import android.view.View;
import com.qzone.proxy.covercomponent.QZoneCoverUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZonePicMixVideoView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class j extends d {
    private QZoneRichTextView F;
    private QZoneRichTextView G;
    private QZonePicMixVideoView H;

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        Q(businessFeedData, this.F);
        O(businessFeedData, this.G);
        P(businessFeedData, this.G, this.H);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFeedBlogPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nn_;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void C(View view) {
        this.F = (QZoneRichTextView) view.findViewById(R.id.f162809mr1);
        this.G = (QZoneRichTextView) view.findViewById(R.id.mqy);
        this.H = (QZonePicMixVideoView) view.findViewById(R.id.f162808mr0);
        if (view.getBackground() != null) {
            com.qzone.reborn.feedx.widget.i.a(view, QZoneCoverUtils.getSuperCoverTrans(null));
        }
        this.H.setItemViewMultiBorderWidth((int) (com.qzone.reborn.feedx.itemview.c.f54845a * 2.0f));
    }
}

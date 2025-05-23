package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import bx2.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.FeedViewSkinType;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.QAdFeedBaseUI;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.c;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.landscape.QAdInteractiveImmersiveHorizontalView;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdInteractiveImmersiveHVView extends QAdFeedBaseUI<a, Object> {
    private QAdInteractiveImmersiveView C;
    private QAdInteractiveImmersiveHorizontalView D;
    private boolean E;

    public QAdInteractiveImmersiveHVView(Context context) {
        super(context);
        j();
    }

    private void h(boolean z16) {
        if (z16) {
            this.C.setVisibility(8);
            this.D.setVisibility(0);
        } else {
            this.C.setVisibility(0);
            this.D.setVisibility(8);
        }
    }

    private void j() {
        View.inflate(getContext(), R.layout.fsi, this);
        this.C = (QAdInteractiveImmersiveView) findViewById(R.id.f29810mn);
        this.D = (QAdInteractiveImmersiveHorizontalView) findViewById(R.id.f29820mo);
        k();
    }

    private void k() {
        boolean z16;
        if (getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.E = z16;
        this.C.setLandscape(z16);
        this.D.setLandscape(this.E);
        h(this.E);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.QAdFeedBaseUI
    public void e(cx2.a aVar) {
        super.e(aVar);
        this.C.e(aVar);
        this.D.e(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.QAdFeedBaseUI
    public void g(FeedViewSkinType feedViewSkinType) {
        super.g(feedViewSkinType);
        this.C.setSkinType(feedViewSkinType);
        this.D.setSkinType(feedViewSkinType);
    }

    public RelativeLayout i() {
        if (this.E) {
            return this.D.o();
        }
        return this.C.o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.QAdFeedBaseUI
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void f(a aVar) {
        super.f(aVar);
        this.C.setData(aVar);
        this.D.setData(aVar);
    }

    public void m(zw2.a aVar) {
        this.C.t(aVar);
        this.D.t(aVar);
    }

    public void setContentImageViewShow(boolean z16) {
        this.C.setContentImageViewShow(z16);
        this.D.setContentImageViewShow(z16);
    }

    public void setEndMaskShow(boolean z16) {
        this.C.setEndMaskShow(z16);
        this.D.setEndMaskShow(z16);
    }

    public void setEndMaskViewData(c cVar) {
        this.C.setEndMaskViewData(cVar);
        this.D.setEndMaskViewData(cVar);
    }

    public void setImmersiveType(int i3) {
        this.C.setImmersiveType(i3);
        this.D.setImmersiveType(i3);
    }

    public void setLandscape(boolean z16) {
        if (this.E == z16) {
            return;
        }
        this.E = z16;
        this.C.setLandscape(z16);
        this.D.setLandscape(z16);
        h(this.E);
    }

    public void setProgress(int i3) {
        this.C.setProgress(i3);
        this.D.setProgress(i3);
    }

    public void setReturnImageVisible(int i3) {
        this.D.setReturnImageVisible(i3);
        this.C.setReturnImageVisible(i3);
    }

    public void setTitleLayoutMargin(int i3) {
        this.D.setTitleLayoutMargin(i3);
        this.C.setTitleLayoutMargin(i3);
    }

    public void setVideoPauseIconShow(boolean z16) {
        this.C.setVideoPauseIconShow(z16);
        this.D.setVideoPauseIconShow(z16);
    }

    public QAdInteractiveImmersiveHVView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j();
    }

    public QAdInteractiveImmersiveHVView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        j();
    }
}

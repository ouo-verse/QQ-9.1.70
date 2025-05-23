package com.qzone.reborn.feedx.presenter;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.biz.richframework.widget.RFWSquareImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class al extends vg.a implements View.OnClickListener {
    protected ConstraintLayout F;
    protected RFWSquareImageView G;
    protected QZoneRichTextView H;
    protected QZoneRichTextView I;
    protected TextView J;
    protected FrameLayout K;
    protected View L;
    protected CellLeftThumb M;

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(int i3, int i16, int i17, int i18) {
        ((ConstraintLayout.LayoutParams) this.I.getLayoutParams()).setMargins(i3, i16, i17, i18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean I(BusinessFeedData businessFeedData);

    protected abstract void J(BusinessFeedData businessFeedData, View view);

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(String str) {
        RFWSquareImageView rFWSquareImageView = this.G;
        if (rFWSquareImageView == null) {
            return;
        }
        rFWSquareImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(str).setTargetView(this.G).setFromPreLoad(false).setPredecode(true).setSupportRecycler(true).setRequestWidth(ImmersiveUtils.dpToPx(60.0f)).setRequestHeight(ImmersiveUtils.dpToPx(60.0f)).setFailedDrawableId(R.drawable.fux), null);
    }

    protected abstract void L(BusinessFeedData businessFeedData);

    protected abstract void M(BusinessFeedData businessFeedData);

    protected abstract void N(BusinessFeedData businessFeedData);

    /* JADX INFO: Access modifiers changed from: protected */
    public void O(int i3) {
        ((LinearLayout.LayoutParams) this.H.getLayoutParams()).setMarginStart(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFeedLeftPicRightTextBasePresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.n2t) {
            J(this.f441565h, view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // vg.a
    protected int s() {
        return R.id.nnn;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        this.M = businessFeedData.getLeftThumb();
        N(businessFeedData);
        L(businessFeedData);
        M(businessFeedData);
    }

    @Override // vg.a
    protected void C(View view) {
        this.K = (FrameLayout) view.findViewById(R.id.nb9);
        this.F = (ConstraintLayout) view.findViewById(R.id.n2t);
        this.G = (RFWSquareImageView) view.findViewById(R.id.n2s);
        this.L = view.findViewById(R.id.n2w);
        QZoneRichTextView qZoneRichTextView = (QZoneRichTextView) view.findViewById(R.id.n2v);
        this.H = qZoneRichTextView;
        qZoneRichTextView.setMaxLine(1);
        QZoneRichTextView qZoneRichTextView2 = (QZoneRichTextView) view.findViewById(R.id.n2u);
        this.I = qZoneRichTextView2;
        qZoneRichTextView2.setMaxLine(2);
        this.J = (TextView) view.findViewById(R.id.n2x);
        this.F.setOnClickListener(this);
    }
}

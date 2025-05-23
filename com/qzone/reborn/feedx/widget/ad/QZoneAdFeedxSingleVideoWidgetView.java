package com.qzone.reborn.feedx.widget.ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.reborn.feedx.video.view.QZoneVideoView;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QZoneAdFeedxSingleVideoWidgetView extends QZoneAdVideoItemWidgetView {
    public QZoneAdFeedxSingleVideoWidgetView(Context context) {
        this(context, null);
    }

    private void I1(float f16) {
        VideoInfo videoInfo;
        int i3;
        QZoneVideoView qZoneVideoView = this.E;
        if (qZoneVideoView != null && (videoInfo = this.D) != null && videoInfo.width > 0 && videoInfo.height > 0) {
            ViewGroup.LayoutParams layoutParams = qZoneVideoView.getLayoutParams();
            QZoneAdFeedUtils.f55717a.e(getContext(), layoutParams, f16);
            if (layoutParams != null && layoutParams.width > 0 && (i3 = layoutParams.height) > 0) {
                int intValue = Double.valueOf(i3 * 1.0d * f16).intValue();
                layoutParams.width = intValue;
                i1(this.F, intValue, layoutParams.height);
                i1(this.E, layoutParams.width, layoutParams.height);
                QLog.i("PSLink-QZoneAdFeedxSingleVideoWidgetView", 2, "[adjustViewSizeForVideo]  | position = " + this.f56455f + " | videoWidth = " + this.D.width + " | videoHeight = " + this.D.height + " | realWidth = " + layoutParams.width + " | realHeight = " + layoutParams.height);
                return;
            }
            QLog.e("PSLink-QZoneAdFeedxSingleVideoWidgetView", 1, "[adjustViewSizeForVideo] error, layoutParams is null,video ratio:" + f16);
            return;
        }
        QLog.e("PSLink-QZoneAdFeedxSingleVideoWidgetView", 1, "[adjustViewSizeForVideo] error, video ratio:" + f16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView
    public void F0() {
        GdtAd gdtAd = this.f55970a0;
        long aId = gdtAd != null ? gdtAd.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        GdtAd gdtAd2 = this.f55970a0;
        QLog.i("PSLink-QZoneAdFeedxSingleVideoWidgetView", 2, "[adjustViewSize] aid:" + aId + " innerAdShowType:" + (gdtAd2 != null ? gdtAd2.getInnerShowType() : Integer.MIN_VALUE));
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        if (qZoneAdFeedUtils.L(this.f56454e)) {
            G1();
        } else if (qZoneAdFeedUtils.a0(this.f56454e)) {
            H1();
        } else {
            super.F0();
            QLog.i("PSLink-QZoneAdFeedxSingleVideoWidgetView", 2, "[adjustViewSize] not video");
        }
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView
    protected boolean Y0() {
        return true;
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.ch9;
    }

    public void setTimeMuteLayoutMarginBottom(int i3) {
        LinearLayout linearLayout = this.H;
        if (linearLayout == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams();
        marginLayoutParams.bottomMargin = i3;
        this.H.setLayoutParams(marginLayoutParams);
    }

    public QZoneAdFeedxSingleVideoWidgetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QZoneAdFeedxSingleVideoWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        ImageView imageView = this.G;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.f15538f);
        }
    }

    private void H1() {
        I1(0.5625f);
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.f56457i;
        if (roundCorneredFrameLayout != null) {
            roundCorneredFrameLayout.setRadius(0.0f);
        }
    }

    private void G1() {
        I1(1.7777778f);
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.f56457i;
        if (roundCorneredFrameLayout != null) {
            roundCorneredFrameLayout.setRadius(DisplayUtil.dip2px(getContext(), 2.0f));
        }
    }
}

package com.qzone.reborn.feedpro.widget.ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.qzone.reborn.feedpro.utils.aq;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonVideo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pl.a;
import qe.b;
import xd.c;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProSingleVideoWidgetView;", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView;", "", "videoRatio", "", "c2", "X1", "Z1", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", QAdVrReportParams.ParamKey.MEDIA, "Landroid/view/ViewGroup$LayoutParams;", "rootViewParams", "m0", "", "m1", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "q0", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAdFeedProSingleVideoWidgetView extends QZoneAdFeedProVideoItemWidgetView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneAdFeedProSingleVideoWidgetView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c2(float videoRatio) {
        int i3;
        if (getMVideoInfo() != null) {
            CommonVideo mVideoInfo = getMVideoInfo();
            if ((mVideoInfo != null ? mVideoInfo.getWidth() : 0) > 0) {
                CommonVideo mVideoInfo2 = getMVideoInfo();
                if ((mVideoInfo2 != null ? mVideoInfo2.getHeight() : 0) > 0) {
                    ViewGroup.LayoutParams layoutParams = g1().getLayoutParams();
                    aq aqVar = aq.f54314a;
                    Context context = getContext();
                    CommonVideo mVideoInfo3 = getMVideoInfo();
                    int width = mVideoInfo3 != null ? mVideoInfo3.getWidth() : 0;
                    CommonVideo mVideoInfo4 = getMVideoInfo();
                    aqVar.b(context, layoutParams, width, mVideoInfo4 != null ? mVideoInfo4.getHeight() : 0, a.f426446a.k(getContext()));
                    if (layoutParams != null && layoutParams.width > 0 && (i3 = layoutParams.height) > 0) {
                        layoutParams.width = (int) (i3 * 1.0d * videoRatio);
                        A1(b1(), layoutParams.width, layoutParams.height);
                        A1(g1(), layoutParams.width, layoutParams.height);
                        int mFeedPosition = getMFeedPosition();
                        CommonVideo mVideoInfo5 = getMVideoInfo();
                        Intrinsics.checkNotNull(mVideoInfo5);
                        int width2 = mVideoInfo5.getWidth();
                        CommonVideo mVideoInfo6 = getMVideoInfo();
                        Intrinsics.checkNotNull(mVideoInfo6);
                        QLog.i("PSLink-QZoneAdFeedProSingleVideoWidgetView", 2, "[adjustViewSizeForVideo]  | position = " + mFeedPosition + " | videoWidth = " + width2 + " | videoHeight = " + mVideoInfo6.getHeight() + " | realWidth = " + layoutParams.width + " | realHeight = " + layoutParams.height);
                        return;
                    }
                    QLog.e("PSLink-QZoneAdFeedProSingleVideoWidgetView", 1, "[adjustViewSizeForVideo] error, layoutParams is null,video ratio:" + videoRatio);
                    return;
                }
            }
        }
        QLog.e("PSLink-QZoneAdFeedProSingleVideoWidgetView", 1, "[adjustViewSizeForVideo] error, video ratio:" + videoRatio);
    }

    @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProVideoItemWidgetView, com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProMixBaseWidgetView
    protected void m0(CommonMedia media, ViewGroup.LayoutParams rootViewParams) {
        Object valueOf;
        Intrinsics.checkNotNullParameter(media, "media");
        GdtAd gdtAd = this.mAd;
        long aId = gdtAd != null ? gdtAd.getAId() : -2147483648L;
        GdtAd gdtAd2 = this.mAd;
        if (gdtAd2 != null) {
            valueOf = Integer.valueOf(gdtAd2.getInnerShowType());
        } else {
            valueOf = Long.valueOf(WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
        }
        QLog.i("PSLink-QZoneAdFeedProSingleVideoWidgetView", 2, "[adjustViewSize] aid:" + aId + " innerAdShowType:" + valueOf);
        b bVar = b.f428879a;
        if (bVar.b(c.h(getMFeedData()))) {
            X1();
        } else if (bVar.i(c.h(getMFeedData()))) {
            Z1();
        } else {
            super.m0(media, rootViewParams);
            QLog.i("PSLink-QZoneAdFeedProSingleVideoWidgetView", 2, "[adjustViewSize] not video");
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProVideoItemWidgetView
    protected boolean m1() {
        return true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneAdFeedProSingleVideoWidgetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QZoneAdFeedProSingleVideoWidgetView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void Z1() {
        c2(0.5625f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAdFeedProSingleVideoWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void X1() {
        c2(1.7777778f);
    }
}

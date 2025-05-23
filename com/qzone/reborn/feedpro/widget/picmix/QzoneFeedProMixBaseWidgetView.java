package com.qzone.reborn.feedpro.widget.picmix;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.feedpro.utils.aq;
import com.qzone.reborn.util.r;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010F\u001a\u00020E\u00a2\u0006\u0004\bG\u0010HB\u001b\b\u0016\u0012\u0006\u0010F\u001a\u00020E\u0012\b\u0010J\u001a\u0004\u0018\u00010I\u00a2\u0006\u0004\bG\u0010KB#\b\u0016\u0012\u0006\u0010F\u001a\u00020E\u0012\b\u0010J\u001a\u0004\u0018\u00010I\u0012\u0006\u0010L\u001a\u00020\n\u00a2\u0006\u0004\bG\u0010MJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0005J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\nH\u0014J\b\u0010\u0017\u001a\u00020\u0005H\u0014J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0014J\u001a\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH$J\b\u0010\u001e\u001a\u00020\nH\u0004J\n\u0010 \u001a\u0004\u0018\u00010\u001fH&J\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\nJ\b\u0010$\u001a\u00020#H$R$\u0010+\u001a\u0004\u0018\u00010\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00102\u001a\u00020\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00106\u001a\u00020\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010-\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\"\u0010<\u001a\u00020\u00038\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0015\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00107R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010-\u00a8\u0006N"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProMixBaseWidgetView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "p0", "", "n0", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "setFeedData", "", "picPosition", "setPicPosition", "feedPosition", "setFeedPosition", "count", "A0", "", "y0", "x0", QAdVrReportParams.ParamKey.MEDIA, "i", "o0", NodeProps.ON_ATTACHED_TO_WINDOW, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/view/ViewGroup$LayoutParams;", "rootViewParams", "m0", "r0", "Landroid/widget/ImageView;", "q0", "multiBorderWidth", "setItemViewMultiBorderWidth", "", "getLogTag", "e", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "s0", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "setMFeedData", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;)V", "mFeedData", "f", "I", "u0", "()I", "setMFeedPosition", "(I)V", "mFeedPosition", tl.h.F, "w0", "setMPicPosition", "mPicPosition", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "v0", "()Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "z0", "(Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;)V", "mLayoutRootView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mCountTextContainer", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "mCountTextView", "D", "mMultiBorderWidth", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QzoneFeedProMixBaseWidgetView extends QZoneBaseWidgetView<CommonMedia> {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mCountTextView;

    /* renamed from: D, reason: from kotlin metadata */
    private int mMultiBorderWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private CommonFeed mFeedData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mFeedPosition;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mPicPosition;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    protected RoundCorneredFrameLayout mLayoutRootView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RoundCorneredFrameLayout mCountTextContainer;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProMixBaseWidgetView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void n0() {
        CommonFeed commonFeed;
        ImageView mImageView;
        ViewGroup.LayoutParams layoutParams;
        CommonCellMedia cellMedia;
        CommonCellMedia cellMedia2;
        if (this.mLayoutRootView != null && (commonFeed = this.mFeedData) != null) {
            if ((commonFeed != null ? commonFeed.getCellMedia() : null) != null) {
                CommonFeed commonFeed2 = this.mFeedData;
                if (!bl.b((commonFeed2 == null || (cellMedia2 = commonFeed2.getCellMedia()) == null) ? null : cellMedia2.getMediaItems())) {
                    ViewGroup.LayoutParams layoutParams2 = v0().getLayoutParams();
                    CommonFeed commonFeed3 = this.mFeedData;
                    CommonCellMedia cellMedia3 = commonFeed3 != null ? commonFeed3.getCellMedia() : null;
                    Intrinsics.checkNotNull(cellMedia3);
                    List<CommonMedia> mediaItems = cellMedia3.getMediaItems();
                    if (mediaItems.size() != 1) {
                        CommonFeed commonFeed4 = this.mFeedData;
                        if (!((commonFeed4 == null || (cellMedia = commonFeed4.getCellMedia()) == null || !cellMedia.getLongPicsBrowsingMode()) ? false : true)) {
                            aq.f54314a.e(r0(), mediaItems.size(), layoutParams2);
                            v0().setLayoutParams(layoutParams2);
                            mImageView = getMImageView();
                            if (mImageView != null || (layoutParams = mImageView.getLayoutParams()) == null || layoutParams2 == null) {
                                return;
                            }
                            layoutParams.width = layoutParams2.width;
                            layoutParams.height = layoutParams2.height;
                            mImageView.setLayoutParams(layoutParams);
                            return;
                        }
                    }
                    m0(mediaItems.get(0), layoutParams2);
                    v0().setLayoutParams(layoutParams2);
                    mImageView = getMImageView();
                    if (mImageView != null) {
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
        QLog.e(getLogTag(), 1, "adjustItemViewSize  params error");
    }

    private final RoundCorneredFrameLayout p0() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f1301984, (ViewGroup) v0(), true);
        RoundCorneredFrameLayout roundCorneredFrameLayout = inflate instanceof RoundCorneredFrameLayout ? (RoundCorneredFrameLayout) inflate : null;
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = roundCorneredFrameLayout != null ? (RoundCorneredFrameLayout) roundCorneredFrameLayout.findViewById(R.id.mx_) : null;
        TextView textView = roundCorneredFrameLayout != null ? (TextView) roundCorneredFrameLayout.findViewById(R.id.mx9) : null;
        this.mCountTextView = textView;
        if (textView != null) {
            textView.setBackgroundColor(Color.parseColor("#B2000000"));
        }
        if (roundCorneredFrameLayout2 != null) {
            roundCorneredFrameLayout2.setRadius(r.f59560a.d(Float.valueOf(6.0f)));
        }
        return roundCorneredFrameLayout2;
    }

    public final void A0(int count) {
        if (this.mCountTextContainer == null) {
            this.mCountTextContainer = p0();
        }
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.mCountTextContainer;
        if (roundCorneredFrameLayout != null) {
            roundCorneredFrameLayout.setVisibility(0);
        }
        TextView textView = this.mCountTextView;
        if (textView == null) {
            return;
        }
        textView.setText(Marker.ANY_NON_NULL_MARKER + count);
    }

    protected abstract String getLogTag();

    protected abstract void m0(CommonMedia media, ViewGroup.LayoutParams rootViewParams);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void bindData(CommonMedia media, int i3) {
        Intrinsics.checkNotNullParameter(media, "media");
        n0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mFeedData != null) {
            n0();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        n0();
    }

    /* renamed from: q0 */
    public abstract ImageView getMImageView();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int r0() {
        return pl.a.f426446a.k(getContext()) - this.mMultiBorderWidth;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: s0, reason: from getter */
    public final CommonFeed getMFeedData() {
        return this.mFeedData;
    }

    public final void setFeedData(CommonFeed feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        this.mFeedData = feedData;
    }

    public final void setFeedPosition(int feedPosition) {
        this.mFeedPosition = feedPosition;
    }

    public final void setItemViewMultiBorderWidth(int multiBorderWidth) {
        this.mMultiBorderWidth = multiBorderWidth;
    }

    public final void setPicPosition(int picPosition) {
        this.mPicPosition = picPosition;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: u0, reason: from getter */
    public final int getMFeedPosition() {
        return this.mFeedPosition;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RoundCorneredFrameLayout v0() {
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.mLayoutRootView;
        if (roundCorneredFrameLayout != null) {
            return roundCorneredFrameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLayoutRootView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: w0, reason: from getter */
    public final int getMPicPosition() {
        return this.mPicPosition;
    }

    public final void x0() {
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.mCountTextContainer;
        if (roundCorneredFrameLayout == null) {
            return;
        }
        roundCorneredFrameLayout.setVisibility(8);
    }

    public final boolean y0() {
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.mCountTextContainer;
        if (roundCorneredFrameLayout != null) {
            return roundCorneredFrameLayout != null && roundCorneredFrameLayout.getVisibility() == 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void z0(RoundCorneredFrameLayout roundCorneredFrameLayout) {
        Intrinsics.checkNotNullParameter(roundCorneredFrameLayout, "<set-?>");
        this.mLayoutRootView = roundCorneredFrameLayout;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProMixBaseWidgetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProMixBaseWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}

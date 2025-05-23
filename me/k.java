package me;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tencent.gdt.qq_common;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\f\u001a\u00020\u0006H\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001eR\u0018\u0010&\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lme/k;", "Lne/a;", "", "I", "Landroid/content/res/Resources;", "res", "", "H", "Landroid/view/View$OnClickListener;", UserInfo.SEX_FEMALE, "", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "Landroid/view/View;", "containerView", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", HippyTKDListViewAdapter.X, "Lcom/tencent/gdtad/aditem/GdtAd;", "E", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", "Landroid/view/View;", "mAppTips", "G", "mIndustrialTips", "Lcom/tencent/image/URLImageView;", "Lcom/tencent/image/URLImageView;", "mAppIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mAppText", "J", "mIndustrialIcon", "K", "mIndustrialText", "Landroid/view/ViewStub;", "L", "Landroid/view/ViewStub;", "mAppTipsViewStub", "M", "Z", "mIsAppTipsInflate", "<init>", "()V", "N", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class k extends ne.a {

    /* renamed from: E, reason: from kotlin metadata */
    private GdtAd mAd;

    /* renamed from: F, reason: from kotlin metadata */
    private View mAppTips;

    /* renamed from: G, reason: from kotlin metadata */
    private View mIndustrialTips;

    /* renamed from: H, reason: from kotlin metadata */
    private URLImageView mAppIcon;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView mAppText;

    /* renamed from: J, reason: from kotlin metadata */
    private URLImageView mIndustrialIcon;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView mIndustrialText;

    /* renamed from: L, reason: from kotlin metadata */
    private ViewStub mAppTipsViewStub;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mIsAppTipsInflate;

    private final View.OnClickListener F() {
        GdtAd gdtAd = this.mAd;
        final long aId = gdtAd != null ? gdtAd.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        return new View.OnClickListener() { // from class: me.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.G(aId, this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(long j3, k this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FeedElement feedElement = FeedElement.GDT_FLOAT_TIPS_OPEN_APP;
        QLog.i("QZoneAdFeedTipsSection", 1, "[onClick] aid:" + j3 + " element:" + feedElement + " areaId:55");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            g6.c.f401419a.g(activity, view, xd.c.h(this$0.getMFeedData()), feedElement, 55, this$0.getMPosition(), null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void I() {
        if (this.mIsAppTipsInflate) {
            return;
        }
        View mContainerView = getMContainerView();
        ViewStub viewStub = mContainerView != null ? (ViewStub) mContainerView.findViewById(R.id.nmw) : null;
        this.mAppTipsViewStub = viewStub;
        if (viewStub != null) {
            viewStub.inflate();
        }
        View mContainerView2 = getMContainerView();
        this.mAppTips = mContainerView2 != null ? mContainerView2.findViewById(R.id.mme) : null;
        View mContainerView3 = getMContainerView();
        this.mIndustrialTips = mContainerView3 != null ? mContainerView3.findViewById(R.id.mmf) : null;
        View view = this.mAppTips;
        this.mAppIcon = view != null ? (URLImageView) view.findViewById(R.id.f162787mn0) : null;
        View view2 = this.mAppTips;
        this.mAppText = view2 != null ? (TextView) view2.findViewById(R.id.f162788mn1) : null;
        View view3 = this.mIndustrialTips;
        this.mIndustrialIcon = view3 != null ? (URLImageView) view3.findViewById(R.id.f162787mn0) : null;
        View view4 = this.mIndustrialTips;
        this.mIndustrialText = view4 != null ? (TextView) view4.findViewById(R.id.f162788mn1) : null;
        View view5 = this.mIndustrialTips;
        if (view5 != null) {
            view5.setOnClickListener(null);
        }
        View mContainerView4 = getMContainerView();
        if (mContainerView4 != null) {
            mContainerView4.setVisibility(8);
        }
        this.mIsAppTipsInflate = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "QZoneAdFeedTipsSection";
    }

    @Override // ne.a
    protected int q() {
        return R.id.nmv;
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        yd.a h16 = feedData != null ? xd.c.h(feedData) : null;
        this.mAd = h16 != null ? h16.getGdtAd() : null;
        List<qq_common.FloatingTip> b16 = h16 != null ? yd.b.b(h16) : null;
        List<qq_common.FloatingTip> list = b16;
        if (list == null || list.isEmpty()) {
            View mContainerView = getMContainerView();
            if (mContainerView == null) {
                return;
            }
            mContainerView.setVisibility(8);
            return;
        }
        I();
        for (qq_common.FloatingTip floatingTip : b16) {
            URLDrawable drawable = URLDrawable.getDrawable(floatingTip.icon_url.get(), URLDrawable.URLDrawableOptions.obtain());
            Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(info.icon_ur\u2026DrawableOptions.obtain())");
            String str = floatingTip.text.get();
            Intrinsics.checkNotNullExpressionValue(str, "info.text.get()");
            if (floatingTip.type.get() == 1) {
                URLImageView uRLImageView = this.mAppIcon;
                if (uRLImageView != null) {
                    uRLImageView.setImageDrawable(drawable);
                }
                TextView textView = this.mAppText;
                if (textView != null) {
                    textView.setText(str);
                }
            } else if (floatingTip.type.get() == 2) {
                URLImageView uRLImageView2 = this.mIndustrialIcon;
                if (uRLImageView2 != null) {
                    uRLImageView2.setImageDrawable(drawable);
                }
                TextView textView2 = this.mIndustrialText;
                if (textView2 != null) {
                    textView2.setText(str);
                }
            }
        }
        View view = this.mAppTips;
        if (view != null) {
            view.setOnClickListener(F());
        }
        View mContainerView2 = getMContainerView();
        if (mContainerView2 != null) {
            URLImageView uRLImageView3 = this.mAppIcon;
            if (uRLImageView3 != null) {
                Resources resources = mContainerView2.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "it.resources");
                uRLImageView3.setColorFilter(H(resources));
            }
            URLImageView uRLImageView4 = this.mIndustrialIcon;
            if (uRLImageView4 != null) {
                Resources resources2 = mContainerView2.getResources();
                Intrinsics.checkNotNullExpressionValue(resources2, "it.resources");
                uRLImageView4.setColorFilter(H(resources2));
            }
        }
        View mContainerView3 = getMContainerView();
        if (mContainerView3 == null) {
            return;
        }
        mContainerView3.setVisibility(0);
    }

    private final int H(Resources res) {
        return ResourcesCompat.getColor(res, R.color.qui_common_text_secondary, null);
    }
}

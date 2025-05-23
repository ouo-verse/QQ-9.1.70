package com.tencent.sqshow.zootopia.nativeui.view.panel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.sqshow.zootopia.nativeui.data.OrientationMode;
import com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreCreateRoleBubbleHelper;
import com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreCreateRoleBubbleView;
import com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreLeftOptView;
import com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreTopOptView;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarPanelErrorView;
import com.tencent.sqshow.zootopia.nativeui.view.control.PortalStorePanelControlView;
import com.tencent.sqshow.zootopia.nativeui.view.title.PortalStoreTitleView;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010-\u001a\u00020*\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J(\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J(\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0002J(\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0002J\u0012\u0010\u001d\u001a\u00020\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ,\u0010#\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010!J,\u0010$\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010!J\u0016\u0010'\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%J\u000e\u0010(\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0006J\u0006\u0010)\u001a\u00020\u0002R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001c\u00101\u001a\u00020%8\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b\u0015\u0010.\u0012\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u00102R\u0016\u00104\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010.R\"\u0010;\u001a\u0002058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:\u00a8\u0006>"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/panel/o;", "", "", "r", "Landroid/view/View;", "view", "", MiniChatConstants.MINI_APP_LANDSCAPE, "", "panelWidth", "panelHeight", "Landroid/animation/ObjectAnimator;", "g", "f", "width", "height", "e", "d", "show", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "l", "needShow", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Ljava/lang/Runnable;", "retryCallback", DomainData.DOMAIN_NAME, "withAnim", "", "source", "Lkotlin/Function0;", "callback", "u", "i", "", "style", "v", "k", "c", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/a;", "a", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/a;", "nativeUI", "I", "getMViewState$annotations", "()V", "mViewState", "Z", "mShowRightTopArea", "mStyle", "Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;", "Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;", "getOrientationMode", "()Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;)V", "orientationMode", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/view/panel/a;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class o {

    /* renamed from: a, reason: from kotlin metadata */
    private final a nativeUI;

    /* renamed from: b, reason: from kotlin metadata */
    private int mViewState;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean mShowRightTopArea;

    /* renamed from: d, reason: from kotlin metadata */
    private int mStyle;

    /* renamed from: e, reason: from kotlin metadata */
    private OrientationMode orientationMode;

    public o(a nativeUI) {
        Intrinsics.checkNotNullParameter(nativeUI, "nativeUI");
        this.nativeUI = nativeUI;
        this.mViewState = 2;
        this.mShowRightTopArea = true;
        this.orientationMode = OrientationMode.UNSPECIFIED;
    }

    private final boolean b() {
        int i3 = this.mStyle;
        return (i3 == 2 || i3 == 1) ? false : true;
    }

    private final ObjectAnimator e(View view, boolean r75, float width, float height) {
        if (r75) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", width, 0.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "{\n            ObjectAnim\u2026f\n            )\n        }");
            return ofFloat;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", height, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "{\n            ObjectAnim\u2026f\n            )\n        }");
        return ofFloat2;
    }

    private final ObjectAnimator g(View view, boolean r75, float panelWidth, float panelHeight) {
        if (r75) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", panelWidth, 0.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "{\n            ObjectAnim\u2026f\n            )\n        }");
            return ofFloat;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", panelHeight, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "{\n            ObjectAnim\u2026f\n            )\n        }");
        return ofFloat2;
    }

    private final boolean m() {
        BaseApplication context;
        Resources resources;
        Configuration configuration;
        return (this.orientationMode == OrientationMode.PORTRAIT || (context = BaseApplication.getContext()) == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2) ? false : true;
    }

    private final void r() {
        PortalStorePanelControlView mCategoryView = this.nativeUI.getMCategoryView();
        if (mCategoryView != null) {
            mCategoryView.setVisibility((this.mShowRightTopArea && b()) ? 0 : 4);
        }
        RelativeLayout D = this.nativeUI.D();
        if (D != null) {
            D.setVisibility(0);
        }
        PortalStoreTopOptView mSaveView = this.nativeUI.getMSaveView();
        if (mSaveView != null) {
            mSaveView.setVisibility(0);
        }
        View r06 = this.nativeUI.r0();
        if (r06 != null) {
            r06.setVisibility(0);
        }
        PortalStoreTitleView mTopTitileView = this.nativeUI.getMTopTitileView();
        if (mTopTitileView != null) {
            mTopTitileView.setVisibility(0);
        }
        View W = this.nativeUI.W();
        if (W == null) {
            return;
        }
        W.setVisibility(0);
    }

    public final void c() {
        PortalStorePanelControlView mCategoryView = this.nativeUI.getMCategoryView();
        if (mCategoryView != null) {
            mCategoryView.m();
        }
    }

    public final void i(boolean withAnim, String source, Function0<Unit> callback) {
        boolean m3 = m();
        float width = this.nativeUI.D() != null ? r0.getWidth() : 0.0f;
        float height = (this.nativeUI.D() != null ? r2.getHeight() : 0.0f) + (this.nativeUI.getMSaveView() != null ? r3.getHeight() : 0.0f);
        RelativeLayout D = this.nativeUI.D();
        ObjectAnimator objectAnimator = null;
        ObjectAnimator f16 = D != null ? f(D, m3, width, height) : null;
        PortalStoreTopOptView mSaveView = this.nativeUI.getMSaveView();
        ObjectAnimator h16 = mSaveView != null ? h(mSaveView, false) : null;
        View W = this.nativeUI.W();
        ObjectAnimator d16 = W != null ? d(W, m3, width, height) : null;
        PortalStoreTitleView mTopTitileView = this.nativeUI.getMTopTitileView();
        ObjectAnimator ofFloat = mTopTitileView != null ? ObjectAnimator.ofFloat(mTopTitileView, "translationY", 0.0f, 0.0f - mTopTitileView.getHeight()) : null;
        PortalStorePanelControlView mCategoryView = this.nativeUI.getMCategoryView();
        if (mCategoryView != null) {
            float width2 = mCategoryView.getWidth();
            Intrinsics.checkNotNull(mCategoryView.getLayoutParams(), "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            objectAnimator = ObjectAnimator.ofFloat(mCategoryView, "translationX", 0.0f, (-width2) - ((ViewGroup.MarginLayoutParams) r9).leftMargin);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        if (f16 != null) {
            animatorSet.play(f16);
        }
        if (h16 != null) {
            animatorSet.play(h16);
        }
        if (d16 != null) {
            animatorSet.play(d16);
        }
        if (ofFloat != null) {
            animatorSet.play(ofFloat);
        }
        if (objectAnimator != null) {
            animatorSet.play(objectAnimator);
        }
        animatorSet.setDuration(withAnim ? 200L : 0L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new b(callback));
        PortalStorePanelControlView mCategoryView2 = this.nativeUI.getMCategoryView();
        if (mCategoryView2 != null) {
            mCategoryView2.setVisibility(8);
        }
        PortalStoreLeftOptView mHistoryView = this.nativeUI.getMHistoryView();
        if (mHistoryView != null) {
            mHistoryView.setVisibility(8);
        }
        PortalStoreCreateRoleBubbleView mCreateRoleBubbleView = this.nativeUI.getMCreateRoleBubbleView();
        if (mCreateRoleBubbleView != null) {
            mCreateRoleBubbleView.setVisibility(8);
        }
        animatorSet.start();
    }

    public final void k(boolean withAnim) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.nativeUI.getMTopTitileView(), "translationY", 0.0f, 0.0f - (this.nativeUI.getMTopTitileView() != null ? r0.getHeight() : 0.0f));
        ofFloat.setDuration(withAnim ? 200L : 0L);
        ofFloat.start();
    }

    public final void l() {
        this.nativeUI.getRoot().setAlpha(0.0f);
    }

    public final void n(final Runnable runnable) {
        PortalStoreTopOptView mSaveView = this.nativeUI.getMSaveView();
        if (mSaveView != null) {
            mSaveView.r();
        }
        PortalStorePanelControlView mCategoryView = this.nativeUI.getMCategoryView();
        if (mCategoryView != null) {
            mCategoryView.setVisibility(4);
        }
        AvatarPanelErrorView w3 = this.nativeUI.w();
        if (w3 != null) {
            String string = BaseApplication.context.getResources().getString(R.string.xrf);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ui_shop_empty_fail_title)");
            w3.f(string);
        }
        AvatarPanelErrorView w16 = this.nativeUI.w();
        if (w16 != null) {
            String string2 = BaseApplication.context.getResources().getString(R.string.xre);
            Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026eui_shop_empty_fail_desc)");
            w16.b(string2);
        }
        AvatarPanelErrorView w17 = this.nativeUI.w();
        if (w17 != null) {
            String string3 = BaseApplication.context.getResources().getString(R.string.xrd);
            Intrinsics.checkNotNullExpressionValue(string3, "context.resources.getStr\u2026i_shop_empty_fail_button)");
            w17.setRetryButton(string3, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.panel.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o.o(runnable, view);
                }
            });
        }
        View X = this.nativeUI.X();
        if (X != null) {
            X.setVisibility(0);
        }
        ShimmerLinearLayout C = this.nativeUI.C();
        if (C != null) {
            C.setVisibility(8);
        }
        ShimmerLinearLayout C2 = this.nativeUI.C();
        if (C2 != null) {
            C2.d();
        }
        AvatarPanelErrorView w18 = this.nativeUI.w();
        if (w18 == null) {
            return;
        }
        w18.setVisibility(0);
    }

    public final void p() {
        PortalStoreTopOptView mSaveView = this.nativeUI.getMSaveView();
        if (mSaveView != null) {
            mSaveView.C();
        }
        PortalStorePanelControlView mCategoryView = this.nativeUI.getMCategoryView();
        if (mCategoryView != null) {
            mCategoryView.setVisibility(0);
        }
        View X = this.nativeUI.X();
        if (X != null) {
            X.setVisibility(8);
        }
        ShimmerLinearLayout C = this.nativeUI.C();
        if (C != null) {
            C.setVisibility(4);
        }
        ShimmerLinearLayout C2 = this.nativeUI.C();
        if (C2 != null) {
            C2.d();
        }
        AvatarPanelErrorView w3 = this.nativeUI.w();
        if (w3 == null) {
            return;
        }
        w3.setVisibility(4);
    }

    public final void q() {
        PortalStoreTopOptView mSaveView = this.nativeUI.getMSaveView();
        if (mSaveView != null) {
            mSaveView.r();
        }
        PortalStorePanelControlView mCategoryView = this.nativeUI.getMCategoryView();
        if (mCategoryView != null) {
            mCategoryView.setVisibility(4);
        }
        View X = this.nativeUI.X();
        if (X != null) {
            X.setVisibility(0);
        }
        ShimmerLinearLayout C = this.nativeUI.C();
        if (C != null) {
            C.setVisibility(0);
        }
        ShimmerLinearLayout C2 = this.nativeUI.C();
        if (C2 != null) {
            C2.c();
        }
        AvatarPanelErrorView w3 = this.nativeUI.w();
        if (w3 == null) {
            return;
        }
        w3.setVisibility(8);
    }

    public final void s(OrientationMode orientationMode) {
        Intrinsics.checkNotNullParameter(orientationMode, "<set-?>");
        this.orientationMode = orientationMode;
    }

    public final void t(boolean needShow) {
        this.mShowRightTopArea = needShow;
        r();
    }

    public final void u(boolean withAnim, String source, Function0<Unit> callback) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        boolean m3 = m();
        float width = this.nativeUI.D() != null ? r0.getWidth() : 0.0f;
        float height = (this.nativeUI.D() != null ? r2.getHeight() : 0.0f) + (this.nativeUI.getMSaveView() != null ? r3.getHeight() : 0.0f);
        RelativeLayout D = this.nativeUI.D();
        if (D != null) {
            if (m3) {
                D.setTranslationY(0.0f);
            } else {
                D.setTranslationX(0.0f);
            }
            objectAnimator = g(D, m3, width, height);
        } else {
            objectAnimator = null;
        }
        PortalStoreTopOptView mSaveView = this.nativeUI.getMSaveView();
        ObjectAnimator h16 = mSaveView != null ? h(mSaveView, true) : null;
        View W = this.nativeUI.W();
        ObjectAnimator e16 = W != null ? e(W, m3, width, height) : null;
        PortalStorePanelControlView mCategoryView = this.nativeUI.getMCategoryView();
        if (mCategoryView != null) {
            float width2 = mCategoryView.getWidth();
            Intrinsics.checkNotNull(mCategoryView.getLayoutParams(), "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            objectAnimator2 = ObjectAnimator.ofFloat(mCategoryView, "translationX", (-width2) - ((ViewGroup.MarginLayoutParams) r9).leftMargin, 0.0f);
        } else {
            objectAnimator2 = null;
        }
        PortalStoreTitleView mTopTitileView = this.nativeUI.getMTopTitileView();
        ObjectAnimator ofFloat = mTopTitileView != null ? ObjectAnimator.ofFloat(mTopTitileView, "translationY", 0.0f - mTopTitileView.getHeight(), 0.0f) : null;
        AnimatorSet animatorSet = new AnimatorSet();
        if (objectAnimator != null) {
            animatorSet.play(objectAnimator);
        }
        if (h16 != null) {
            animatorSet.play(h16);
        }
        if (e16 != null) {
            animatorSet.play(e16);
        }
        if (objectAnimator2 != null) {
            animatorSet.play(objectAnimator2);
        }
        if (ofFloat != null) {
            animatorSet.play(ofFloat);
        }
        animatorSet.setDuration(withAnim ? 200L : 0L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new c(callback));
        PortalStoreTitleView mTopTitileView2 = this.nativeUI.getMTopTitileView();
        if (mTopTitileView2 != null) {
            mTopTitileView2.setStyle(0);
        }
        PortalStoreTopOptView mSaveView2 = this.nativeUI.getMSaveView();
        if (mSaveView2 != null) {
            mSaveView2.setStyle(0);
        }
        PortalStoreLeftOptView mHistoryView = this.nativeUI.getMHistoryView();
        if (mHistoryView != null) {
            mHistoryView.setStyle(0);
        }
        PortalStorePanelControlView mCategoryView2 = this.nativeUI.getMCategoryView();
        if (mCategoryView2 != null) {
            mCategoryView2.setVisibility(0);
        }
        PortalStoreLeftOptView mHistoryView2 = this.nativeUI.getMHistoryView();
        if (mHistoryView2 != null) {
            mHistoryView2.setVisibility(0);
        }
        PortalStoreCreateRoleBubbleHelper.f371421a.b(this.nativeUI.getMCreateRoleBubbleView());
        animatorSet.start();
        this.mStyle = 0;
    }

    public final void v(boolean withAnim, int style) {
        this.mStyle = style;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.nativeUI.getMTopTitileView(), "translationY", 0.0f - (this.nativeUI.getMTopTitileView() != null ? r0.getHeight() : 0.0f), 0.0f);
        ofFloat.setDuration(withAnim ? 200L : 0L);
        PortalStoreTitleView mTopTitileView = this.nativeUI.getMTopTitileView();
        if (mTopTitileView != null) {
            mTopTitileView.setStyle(style);
        }
        PortalStoreTopOptView mSaveView = this.nativeUI.getMSaveView();
        if (mSaveView != null) {
            mSaveView.setStyle(style);
        }
        if (style == 1) {
            PortalStoreLeftOptView mHistoryView = this.nativeUI.getMHistoryView();
            if (mHistoryView != null) {
                mHistoryView.setVisibility(0);
            }
            PortalStoreCreateRoleBubbleHelper.f371421a.b(this.nativeUI.getMCreateRoleBubbleView());
            PortalStorePanelControlView mCategoryView = this.nativeUI.getMCategoryView();
            if (mCategoryView != null) {
                mCategoryView.setVisibility(8);
            }
        } else if (style == 2) {
            PortalStoreLeftOptView mHistoryView2 = this.nativeUI.getMHistoryView();
            if (mHistoryView2 != null) {
                mHistoryView2.setVisibility(0);
            }
            PortalStoreCreateRoleBubbleHelper.f371421a.b(this.nativeUI.getMCreateRoleBubbleView());
            PortalStorePanelControlView mCategoryView2 = this.nativeUI.getMCategoryView();
            if (mCategoryView2 != null) {
                mCategoryView2.setVisibility(8);
            }
        }
        PortalStoreLeftOptView mHistoryView3 = this.nativeUI.getMHistoryView();
        if (mHistoryView3 != null) {
            mHistoryView3.setStyle(style);
        }
        ofFloat.start();
    }

    public static final void o(Runnable runnable, View view) {
        if (runnable != null) {
            runnable.run();
        }
    }

    private final ObjectAnimator h(View view, boolean z16) {
        if (z16) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getWidth(), 0.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "{\n            ObjectAnim\u2026f\n            )\n        }");
            return ofFloat;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, view.getWidth());
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "{\n            ObjectAnim\u2026)\n            )\n        }");
        return ofFloat2;
    }

    private final ObjectAnimator d(View view, boolean r65, float width, float height) {
        if (r65) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, width);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "{\n            ObjectAnim\u2026h\n            )\n        }");
            return ofFloat;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, height);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "{\n            ObjectAnim\u2026t\n            )\n        }");
        return ofFloat2;
    }

    private final ObjectAnimator f(View view, boolean r65, float panelWidth, float panelHeight) {
        if (r65) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, panelWidth);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "{\n            ObjectAnim\u2026h\n            )\n        }");
            return ofFloat;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, panelHeight);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "{\n            ObjectAnim\u2026t\n            )\n        }");
        return ofFloat2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void j(o oVar, boolean z16, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        oVar.i(z16, str, function0);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/panel/o$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements Animator.AnimatorListener {

        /* renamed from: d */
        final /* synthetic */ Function0<Unit> f372059d;

        b(Function0<Unit> function0) {
            this.f372059d = function0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Function0<Unit> function0 = this.f372059d;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/panel/o$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements Animator.AnimatorListener {

        /* renamed from: d */
        final /* synthetic */ Function0<Unit> f372060d;

        c(Function0<Unit> function0) {
            this.f372060d = function0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Function0<Unit> function0 = this.f372060d;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }
}

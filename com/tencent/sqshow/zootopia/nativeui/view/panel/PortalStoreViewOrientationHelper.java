package com.tencent.sqshow.zootopia.nativeui.view.panel;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreTopOptView;
import com.tencent.sqshow.zootopia.nativeui.view.title.PortalStoreTitleView;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 ,2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R#\u0010\u001f\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0010\u0010\u001eR\u0016\u0010!\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u0011R\u0014\u0010#\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0014R\u0014\u0010%\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u0014R\u0014\u0010'\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u0014R\u0016\u0010)\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\r\u00a8\u0006-"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreViewOrientationHelper;", "", "", "f", "e", "", "orientation", "d", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/a;", "a", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/a;", "nativeUI", "b", "I", "TITLE_HEIGHT", "Landroid/graphics/drawable/Drawable;", "c", "Landroid/graphics/drawable/Drawable;", "PORTRAIT_PANEL_BACKGROUND_DRAWABLE", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "PORTRAIT_TITLE_LAYOUT_PARAM", "PORTRAIT_PANEL_LAYOUT_PARAM", "PORTRAIT_HOLDER_SPACE_LAYOUT_PARAM", "g", "PORTRAIT_SAVE_LAYOUT_PARAM", "Lcom/tencent/image/URLDrawable;", "kotlin.jvm.PlatformType", tl.h.F, "Lkotlin/Lazy;", "()Lcom/tencent/image/URLDrawable;", "LANDSCAPE_SAVE_BACKGROUND_DRAWABLE", "i", "LANDSCAPE_PANEL_BACKGROUND_DRAWABLE", "j", "LANDSCAPE_TITLE_LAYOUT_PARAM", "k", "LANDSCAPE_PANEL_LAYOUT_PARAM", "l", "LANDSCAPE_SAVE_LAYOUT_PARAM", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "currentOrientation", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/view/panel/a;)V", DomainData.DOMAIN_NAME, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreViewOrientationHelper {

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: o, reason: collision with root package name */
    private static final int f372012o = ViewUtils.dip2px(68.0f);

    /* renamed from: p, reason: collision with root package name */
    private static final int f372013p = ViewUtils.dip2px(24.0f);

    /* renamed from: q, reason: collision with root package name */
    private static final int f372014q = ViewUtils.dip2px(5.5f);

    /* renamed from: r, reason: collision with root package name */
    private static final int f372015r;

    /* renamed from: s, reason: collision with root package name */
    private static final float f372016s;

    /* renamed from: t, reason: collision with root package name */
    private static final int f372017t;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final a nativeUI;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int TITLE_HEIGHT;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Drawable PORTRAIT_PANEL_BACKGROUND_DRAWABLE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ConstraintLayout.LayoutParams PORTRAIT_TITLE_LAYOUT_PARAM;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ConstraintLayout.LayoutParams PORTRAIT_PANEL_LAYOUT_PARAM;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ConstraintLayout.LayoutParams PORTRAIT_HOLDER_SPACE_LAYOUT_PARAM;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final ConstraintLayout.LayoutParams PORTRAIT_SAVE_LAYOUT_PARAM;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy LANDSCAPE_SAVE_BACKGROUND_DRAWABLE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Drawable LANDSCAPE_PANEL_BACKGROUND_DRAWABLE;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final ConstraintLayout.LayoutParams LANDSCAPE_TITLE_LAYOUT_PARAM;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final ConstraintLayout.LayoutParams LANDSCAPE_PANEL_LAYOUT_PARAM;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final ConstraintLayout.LayoutParams LANDSCAPE_SAVE_LAYOUT_PARAM;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int currentOrientation;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreViewOrientationHelper$a;", "", "", "LANDSCAPE_PANEL_RIGHT_EMPTY_WIDTH", "I", "a", "()I", "LANDSCAPE_PANEL_WIDTH", "b", "", "PORTRAIT_PANEL_PERCENT_HEIGHT", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.panel.PortalStoreViewOrientationHelper$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return PortalStoreViewOrientationHelper.f372015r;
        }

        public final int b() {
            return PortalStoreViewOrientationHelper.f372017t;
        }

        Companion() {
        }
    }

    static {
        int screenHeight;
        int statusBarHeight;
        int dip2px = ViewUtils.dip2px(36.0f);
        f372015r = dip2px;
        f372016s = 0.46f;
        if (ViewUtils.getScreenWidth() > ViewUtils.getScreenHeight()) {
            screenHeight = (int) (ViewUtils.getScreenWidth() * 0.46f);
            statusBarHeight = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
        } else {
            screenHeight = (int) (ViewUtils.getScreenHeight() * 0.46f);
            statusBarHeight = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
        }
        f372017t = (screenHeight - statusBarHeight) + dip2px;
    }

    public PortalStoreViewOrientationHelper(a nativeUI) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(nativeUI, "nativeUI");
        this.nativeUI = nativeUI;
        int dip2px = ViewUtils.dip2px(44.0f) + ImmersiveUtils.getStatusBarHeight(nativeUI.getRoot().getContext());
        this.TITLE_HEIGHT = dip2px;
        this.PORTRAIT_PANEL_BACKGROUND_DRAWABLE = ContextCompat.getDrawable(nativeUI.getRoot().getContext(), R.drawable.f159917i52);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, dip2px);
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        this.PORTRAIT_TITLE_LAYOUT_PARAM = layoutParams;
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-1, 0);
        layoutParams2.matchConstraintPercentHeight = 0.477f;
        layoutParams2.bottomToBottom = 0;
        layoutParams2.startToStart = 0;
        layoutParams2.endToEnd = 0;
        this.PORTRAIT_PANEL_LAYOUT_PARAM = layoutParams2;
        int i3 = f372012o;
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(0, i3);
        layoutParams3.endToEnd = 0;
        RelativeLayout D = nativeUI.D();
        if (D != null) {
            layoutParams3.bottomToTop = D.getId();
        }
        this.PORTRAIT_HOLDER_SPACE_LAYOUT_PARAM = layoutParams3;
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, i3);
        layoutParams4.endToEnd = 0;
        RelativeLayout D2 = nativeUI.D();
        if (D2 != null) {
            layoutParams4.bottomToTop = D2.getId();
        }
        this.PORTRAIT_SAVE_LAYOUT_PARAM = layoutParams4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<URLDrawable>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.panel.PortalStoreViewOrientationHelper$LANDSCAPE_SAVE_BACKGROUND_DRAWABLE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final URLDrawable invoke() {
                return URLDrawable.getDrawable("https://image.superqqshow.qq.com/qq/smallhome/ztp_store_save_button_click_area.png", URLDrawable.URLDrawableOptions.obtain());
            }
        });
        this.LANDSCAPE_SAVE_BACKGROUND_DRAWABLE = lazy;
        this.LANDSCAPE_PANEL_BACKGROUND_DRAWABLE = ContextCompat.getDrawable(nativeUI.getRoot().getContext(), R.drawable.f159916i51);
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(0, dip2px);
        layoutParams5.startToStart = 0;
        RelativeLayout D3 = nativeUI.D();
        if (D3 != null) {
            layoutParams5.rightToLeft = D3.getId();
            layoutParams5.endToStart = D3.getId();
        }
        this.LANDSCAPE_TITLE_LAYOUT_PARAM = layoutParams5;
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(f372017t, -1);
        layoutParams6.bottomToBottom = 0;
        layoutParams6.topToTop = 0;
        layoutParams6.endToEnd = 0;
        this.LANDSCAPE_PANEL_LAYOUT_PARAM = layoutParams6;
        ConstraintLayout.LayoutParams layoutParams7 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams7.endToEnd = 0;
        layoutParams7.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin = f372013p;
        ((ViewGroup.MarginLayoutParams) layoutParams7).bottomMargin = -f372014q;
        this.LANDSCAPE_SAVE_LAYOUT_PARAM = layoutParams7;
        this.currentOrientation = 1;
    }

    private final URLDrawable c() {
        return (URLDrawable) this.LANDSCAPE_SAVE_BACKGROUND_DRAWABLE.getValue();
    }

    private final void e() {
        PortalStoreTitleView mTopTitileView = this.nativeUI.getMTopTitileView();
        if (mTopTitileView != null) {
            mTopTitileView.setLayoutParams(this.LANDSCAPE_TITLE_LAYOUT_PARAM);
        }
        RelativeLayout D = this.nativeUI.D();
        if (D != null) {
            D.setLayoutParams(this.LANDSCAPE_PANEL_LAYOUT_PARAM);
            D.setBackground(this.LANDSCAPE_PANEL_BACKGROUND_DRAWABLE);
            if (D.getTranslationY() > 0.0f) {
                D.setTranslationX(D.getWidth());
                D.setTranslationY(0.0f);
            }
        }
        View r06 = this.nativeUI.r0();
        if (r06 != null) {
            r06.setBackground(this.LANDSCAPE_PANEL_BACKGROUND_DRAWABLE);
        }
        PortalStoreTopOptView mSaveView = this.nativeUI.getMSaveView();
        if (mSaveView != null) {
            mSaveView.setLayoutParams(this.LANDSCAPE_SAVE_LAYOUT_PARAM);
            URLDrawable LANDSCAPE_SAVE_BACKGROUND_DRAWABLE = c();
            Intrinsics.checkNotNullExpressionValue(LANDSCAPE_SAVE_BACKGROUND_DRAWABLE, "LANDSCAPE_SAVE_BACKGROUND_DRAWABLE");
            mSaveView.setSaveBackgroundDrawable(LANDSCAPE_SAVE_BACKGROUND_DRAWABLE);
            mSaveView.setSaveBackgroundVisibilty(0);
        }
        View W = this.nativeUI.W();
        if (W != null) {
            if (W.getTranslationY() > 0.0f) {
                W.setTranslationX(W.getWidth());
                W.setTranslationY(0.0f);
            }
            W.setVisibility(8);
        }
        View O = this.nativeUI.O();
        if (O != null) {
            O.setVisibility(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void f() {
        float f16;
        View r06;
        PortalStoreTopOptView mSaveView;
        View W;
        View O;
        PortalStoreTitleView mTopTitileView = this.nativeUI.getMTopTitileView();
        if (mTopTitileView != null) {
            mTopTitileView.setLayoutParams(this.PORTRAIT_TITLE_LAYOUT_PARAM);
        }
        RelativeLayout D = this.nativeUI.D();
        if (D != null) {
            D.setLayoutParams(this.PORTRAIT_PANEL_LAYOUT_PARAM);
            D.setBackground(this.PORTRAIT_PANEL_BACKGROUND_DRAWABLE);
            if (D.getTranslationX() > 0.0f) {
                D.setTranslationX(0.0f);
                D.setTranslationY(D.getHeight() + f372012o);
                f16 = D.getTranslationY();
                r06 = this.nativeUI.r0();
                if (r06 != null) {
                    r06.setBackground(this.PORTRAIT_PANEL_BACKGROUND_DRAWABLE);
                }
                mSaveView = this.nativeUI.getMSaveView();
                if (mSaveView != null) {
                    mSaveView.setLayoutParams(this.PORTRAIT_SAVE_LAYOUT_PARAM);
                    mSaveView.setSaveBackgroundVisibilty(8);
                }
                W = this.nativeUI.W();
                if (W != null) {
                    if (W.getTranslationX() > 0.0f) {
                        W.setTranslationX(0.0f);
                        W.setTranslationY(f16);
                    }
                    W.setVisibility(0);
                }
                O = this.nativeUI.O();
                if (O == null) {
                    O.setVisibility(8);
                    return;
                }
                return;
            }
        }
        f16 = 0.0f;
        r06 = this.nativeUI.r0();
        if (r06 != null) {
        }
        mSaveView = this.nativeUI.getMSaveView();
        if (mSaveView != null) {
        }
        W = this.nativeUI.W();
        if (W != null) {
        }
        O = this.nativeUI.O();
        if (O == null) {
        }
    }

    public final void d(int orientation) {
        QLog.i("PortalStoreViewOrientationHelper", 1, "onChangeOrientation orientation:" + orientation + ", currentOrientation=" + this.currentOrientation);
        if (this.currentOrientation == orientation) {
            return;
        }
        if (orientation == 1) {
            f();
        } else if (orientation == 2) {
            e();
        }
        this.currentOrientation = orientation;
    }
}

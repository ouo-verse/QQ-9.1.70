package com.qzone.reborn.feedx.widget.title;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.activities.base.ak;
import com.qzone.reborn.feedx.part.userhome.a;
import com.qzone.reborn.feedx.widget.f;
import com.qzone.reborn.feedx.widget.title.QZoneBaseFeedxTitle;
import com.qzone.util.l;
import com.qzone.widget.RedDotImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.simpleui.b;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import ef.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001mB'\b\u0007\u0012\u0006\u0010g\u001a\u00020f\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010h\u0012\b\b\u0002\u0010j\u001a\u00020\u0003\u00a2\u0006\u0004\bk\u0010lJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0012\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\u0003H\u0002J\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0003H&J\u0006\u0010\u0016\u001a\u00020\bJ\b\u0010\u0017\u001a\u00020\bH\u0014J\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fJ\u0006\u0010\u001e\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\bJ\u0006\u0010 \u001a\u00020\bJ\u000e\u0010!\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0006\u0010#\u001a\u00020\u0003J\b\u0010$\u001a\u00020\bH\u0017J\b\u0010%\u001a\u00020\bH\u0017J\b\u0010&\u001a\u00020\bH\u0017J\n\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010+\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0013H\u0016J\u000e\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020.J\u000e\u00102\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0013J\u0006\u00103\u001a\u00020\bJ\u000e\u00106\u001a\u00020\b2\u0006\u00105\u001a\u000204J\u000e\u00108\u001a\u00020\b2\u0006\u00107\u001a\u00020\u0013J\u0010\u00109\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\n\u0010;\u001a\u0004\u0018\u00010:H\u0016J\n\u0010<\u001a\u0004\u0018\u00010:H\u0016J\b\u0010=\u001a\u00020\u0003H\u0005J\b\u0010>\u001a\u00020\u0003H\u0005J\b\u0010?\u001a\u00020\u0003H\u0017J\b\u0010@\u001a\u00020\u0003H\u0017R\u0016\u0010C\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010DR\u0016\u0010F\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010+R\u0016\u0010G\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010+R\u0016\u0010J\u001a\u00020H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010IR\u0016\u0010K\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010DR\"\u0010P\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010D\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010W\u001a\u00020Q8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0016\u0010Z\u001a\u00020X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010YR\u0016\u0010]\u001a\u00020[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\\R2\u0010e\u001a\u0012\u0012\u0004\u0012\u00020\f0^j\b\u0012\u0004\u0012\u00020\f`_8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010d\u00a8\u0006n"}, d2 = {"Lcom/qzone/reborn/feedx/widget/title/QZoneBaseFeedxTitle;", "Landroid/widget/FrameLayout;", "Lcom/qzone/reborn/feedx/widget/f$c;", "", "k", "Landroid/widget/LinearLayout$LayoutParams;", "p", c.f123400v, "", h.F, "color", "H", "Landroid/view/View;", "view", "J", "L", BdhLogUtil.LogTag.Tag_Conn, "i", NodeProps.ON_ATTACHED_TO_WINDOW, "", "y", DomainData.DOMAIN_NAME, "w", "D", "Luh/d;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "f", "g", "childView", "e", "G", "v", HippyTKDListViewAdapter.X, "setTitleAlpha", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "j", "E", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/ViewGroup;", "B", "Landroid/os/Bundle;", "bundle", "I", "show", "b0", "Landroid/content/Intent;", "intent", "K", "isGuest", "setIsGuest", "u", "", "text", "setCenterTitleText", "enable", "setProgressBarEnable", "M", "Landroid/graphics/drawable/Drawable;", ReportConstant.COSTREPORT_PREFIX, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "Z", "mIsProgressBarEnable", "Landroid/view/View;", "mProgressBar", "mCoverStatus", "mCurAlpha", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mBtnBack", "mTitleHost", "getMViewBg", "()Landroid/view/View;", "setMViewBg", "(Landroid/view/View;)V", "mViewBg", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "o", "()Landroid/widget/TextView;", "setMTitleName", "(Landroid/widget/TextView;)V", "mTitleName", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "mRightBtnContainer", "Lcom/qzone/reborn/feedx/widget/f;", "Lcom/qzone/reborn/feedx/widget/f;", "mPublishBox", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getMRightButtonAddList", "()Ljava/util/ArrayList;", "setMRightButtonAddList", "(Ljava/util/ArrayList;)V", "mRightButtonAddList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZoneBaseFeedxTitle extends FrameLayout implements f.c {

    /* renamed from: C, reason: from kotlin metadata */
    private View mViewBg;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mTitleName;

    /* renamed from: E, reason: from kotlin metadata */
    private LinearLayout mRightBtnContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private f mPublishBox;

    /* renamed from: G, reason: from kotlin metadata */
    private ArrayList<View> mRightButtonAddList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsProgressBarEnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mProgressBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mCoverStatus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mCurAlpha;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mBtnBack;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View mTitleHost;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneBaseFeedxTitle(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void C() {
        f fVar = this.mPublishBox;
        if (fVar.f56101i) {
            fVar.i();
        } else if (fVar.f56100h != 0) {
            fVar.j();
        }
    }

    private final void H(int color) {
        com.tencent.mobileqq.qzone.picload.c.a().m(this.mBtnBack, color);
        i(this.mBtnBack);
        int childCount = this.mRightBtnContainer.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View view = this.mRightBtnContainer.getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            J(view, color);
            i(view);
        }
        this.mPublishBox.k(color);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void J(View view, int color) {
        if (view instanceof ImageView) {
            com.tencent.mobileqq.qzone.picload.c.a().m((ImageView) view, color);
        } else if (view instanceof a) {
            ((a) view).a(color);
        }
    }

    private final void L() {
        if (getContext() instanceof Activity) {
            try {
                Context context = getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                QUIImmersiveHelper.s((Activity) context, true, false);
            } catch (Throwable th5) {
                RFWLog.fatal("QZoneBaseFeedxTitle", RFWLog.USR, th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(QZoneBaseFeedxTitle this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context instanceof Activity) {
            ((Activity) context).onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void i(View view) {
        if (y() && this.mCoverStatus == 0) {
            view.setBackgroundResource(R.drawable.f170071);
        } else {
            view.setBackgroundResource(0);
        }
    }

    private final int k() {
        if (this.mCoverStatus == 1) {
            return l();
        }
        return m();
    }

    private final LinearLayout.LayoutParams p() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.b(28), d.b(28));
        layoutParams.setMargins(d.b(8), 0, 0, 0);
        return layoutParams;
    }

    protected void D() {
        this.mViewBg.setAlpha(0.0f);
        try {
            Drawable s16 = s();
            if (s16 == null) {
                s16 = new ColorDrawable(getContext().getColor(R.color.qui_common_bg_nav_primary));
            }
            this.mViewBg.setBackground(s16);
        } catch (Throwable th5) {
            RFWLog.fatal("QZoneBaseFeedxTitle", RFWLog.USR, th5);
        }
    }

    public final void G() {
        if (this.mIsProgressBarEnable) {
            if (this.mProgressBar == null) {
                x();
            }
            View view = this.mProgressBar;
            if (view == null) {
                return;
            }
            view.setVisibility(0);
        }
    }

    @Override // com.qzone.reborn.feedx.widget.f.c
    public void I(Bundle bundle) {
        Intent B = ak.B(getContext());
        if (bundle != null) {
            B.putExtras(bundle);
        }
        getContext().startActivity(B);
    }

    public final void K(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.mPublishBox.n(intent);
    }

    public void M(int color) {
        for (View view : this.mRightButtonAddList) {
            ImageView imageView = view instanceof ImageView ? (ImageView) view : null;
            if (imageView != null) {
                imageView.setColorFilter(color);
            }
        }
    }

    public final View e(View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        J(childView, k());
        this.mRightBtnContainer.addView(childView, p());
        i(childView);
        this.mRightButtonAddList.add(childView);
        return childView;
    }

    public final View f(uh.d item) {
        Intrinsics.checkNotNullParameter(item, "item");
        FadeIconImageView fadeIconImageView = new FadeIconImageView(getContext());
        AccessibilityUtil.p(fadeIconImageView, item.getContentDescription());
        fadeIconImageView.setImageResource(item.getDrawableId());
        fadeIconImageView.setOnClickListener(item.getOnClickListener());
        fadeIconImageView.setOnLongClickListener(item.getOnLongClickListener());
        fadeIconImageView.setScaleType(ImageView.ScaleType.CENTER);
        fadeIconImageView.setLayoutParams(p());
        fadeIconImageView.setPadding(d.b(4), d.b(4), d.b(4), d.b(4));
        i(fadeIconImageView);
        com.tencent.mobileqq.qzone.picload.c.a().m(fadeIconImageView, k());
        this.mRightBtnContainer.addView(fadeIconImageView);
        this.mRightButtonAddList.add(fadeIconImageView);
        return fadeIconImageView;
    }

    public final View g(uh.d item) {
        Intrinsics.checkNotNullParameter(item, "item");
        RedDotImageView redDotImageView = new RedDotImageView(getContext());
        redDotImageView.setPressedFadeIcon(true);
        redDotImageView.h(item.getShowRedDot());
        redDotImageView.setImageResource(item.getDrawableId());
        redDotImageView.setOnClickListener(item.getOnClickListener());
        redDotImageView.setOnLongClickListener(item.getOnLongClickListener());
        redDotImageView.setScaleType(ImageView.ScaleType.CENTER);
        redDotImageView.setLayoutParams(p());
        redDotImageView.setPadding(d.b(4), d.b(4), d.b(4), d.b(4));
        AccessibilityUtil.p(redDotImageView, item.getContentDescription());
        return e(redDotImageView);
    }

    /* renamed from: j, reason: from getter */
    public final int getMCurAlpha() {
        return this.mCurAlpha;
    }

    public int l() {
        return getContext().getColor(R.color.qui_common_icon_nav_secondary);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int m() {
        return getContext().getColor(R.color.qui_common_icon_white);
    }

    public abstract int n();

    /* renamed from: o, reason: from getter */
    public final TextView getMTitleName() {
        return this.mTitleName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mPublishBox.f();
    }

    public int q() {
        return getContext().getColor(R.color.qui_common_text_nav_secondary);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int r() {
        return getContext().getColor(R.color.qui_common_icon_white);
    }

    public Drawable s() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qzone_title_bg_legacy", false)) {
            return t();
        }
        if (QQTheme.isVasTheme()) {
            return SkinEngine.getInstances().getDefaultThemeDrawable(R.drawable.qui_bg_nav_primary);
        }
        return ContextCompat.getDrawable(getContext(), R.drawable.qui_bg_nav_primary);
    }

    public final void setCenterTitleText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.mTitleName.setText(text);
    }

    public final void setIsGuest(boolean isGuest) {
        this.mPublishBox.g(isGuest);
    }

    public final void setMRightButtonAddList(ArrayList<View> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mRightButtonAddList = arrayList;
    }

    public final void setMTitleName(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mTitleName = textView;
    }

    public final void setMViewBg(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mViewBg = view;
    }

    public final void setProgressBarEnable(boolean enable) {
        this.mIsProgressBarEnable = enable;
        View view = this.mProgressBar;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public Drawable t() {
        if (b.c()) {
            return new ColorDrawable(SimpleUIUtil.getSimpleUiBgColor());
        }
        if (QQTheme.isNowThemeIsNightForQzone()) {
            return new ColorDrawable(-16777216);
        }
        return ContextCompat.getDrawable(getContext(), R.drawable.qq_title_immersive_bar);
    }

    public final void u() {
        this.mBtnBack.setVisibility(8);
    }

    public final void v() {
        if (this.mIsProgressBarEnable) {
            if (this.mProgressBar == null) {
                x();
            }
            View view = this.mProgressBar;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    public final void w() {
        D();
        h(this.mCurAlpha);
    }

    public boolean y() {
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneBaseFeedxTitle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void E() {
        this.mCoverStatus = 1;
        L();
        H(l());
        this.mTitleName.setTextColor(q());
        C();
    }

    public void F() {
        this.mCoverStatus = 0;
        L();
        H(m());
        this.mTitleName.setTextColor(r());
        C();
    }

    public /* synthetic */ QZoneBaseFeedxTitle(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneBaseFeedxTitle(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsProgressBarEnable = true;
        this.mRightButtonAddList = new ArrayList<>();
        LayoutInflater.from(getContext()).inflate(n(), this);
        View findViewById = findViewById(R.id.mjb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qz_feedx_title_bg)");
        this.mViewBg = findViewById;
        View findViewById2 = findViewById(R.id.mjc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qz_feedx_title_host)");
        this.mTitleHost = findViewById2;
        View findViewById3 = findViewById(R.id.mja);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qz_feedx_title_back)");
        this.mBtnBack = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.mje);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qz_feedx_title_name)");
        this.mTitleName = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.mjh);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qz_fee\u2026itle_right_btn_container)");
        LinearLayout linearLayout = (LinearLayout) findViewById5;
        this.mRightBtnContainer = linearLayout;
        linearLayout.setPadding(0, 0, d.b(2), 0);
        this.mTitleHost.setPadding(d.b(8), ImmersiveUtils.getStatusBarHeight(getContext()), d.b(8), 0);
        this.mBtnBack.setPadding(d.b(4), d.b(4), d.b(4), d.b(4));
        this.mBtnBack.setImageResource(R.drawable.qui_chevron_left);
        this.mBtnBack.setScaleType(ImageView.ScaleType.CENTER);
        this.mBtnBack.setOnClickListener(new View.OnClickListener() { // from class: uh.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneBaseFeedxTitle.d(QZoneBaseFeedxTitle.this, view);
            }
        });
        i(this.mBtnBack);
        this.mPublishBox = new f(this, "");
        AccessibilityUtil.s(this.mBtnBack, l.a(R.string.f2201668d));
    }

    @Override // com.qzone.reborn.feedx.widget.f.c
    public ViewGroup B() {
        View findViewById = findViewById(R.id.mjg);
        if (findViewById instanceof ViewStub) {
            View inflate = ((ViewStub) findViewById).inflate();
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
            return (ViewGroup) inflate;
        }
        if (findViewById instanceof ViewGroup) {
            return (ViewGroup) findViewById;
        }
        return null;
    }

    public final void x() {
        this.mProgressBar = jm.b.f410600a.g((ViewStub) findViewById(R.id.mjf));
    }

    private final void h(int alpha) {
        if (alpha >= 125) {
            E();
        } else {
            F();
        }
    }

    public final void setTitleAlpha(int alpha) {
        if (alpha < 0 || alpha > 255 || this.mCurAlpha == alpha) {
            return;
        }
        this.mCurAlpha = alpha;
        this.mViewBg.setAlpha(alpha / 255.0f);
        A(this.mCurAlpha);
        int i3 = this.mCurAlpha;
        if (i3 > 125) {
            if (this.mCoverStatus == 0) {
                h(i3);
            }
        } else if (this.mCoverStatus == 1) {
            h(i3);
        }
    }

    public void z() {
    }

    public void A(int alpha) {
    }

    @Override // com.qzone.reborn.feedx.widget.f.c
    public void b0(boolean show) {
    }
}

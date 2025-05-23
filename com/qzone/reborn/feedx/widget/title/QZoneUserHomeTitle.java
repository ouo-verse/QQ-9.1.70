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
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.activities.base.ak;
import com.qzone.reborn.feedx.part.userhome.a;
import com.qzone.reborn.feedx.widget.f;
import com.qzone.reborn.feedx.widget.title.QZoneUserHomeTitle;
import com.qzone.util.l;
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
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0002\\]B'\b\u0007\u0012\u0006\u0010U\u001a\u00020T\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010V\u0012\b\b\u0002\u0010X\u001a\u00020\u0003\u00a2\u0006\u0004\bY\u0010ZJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\bH\u0014J\u0006\u0010\u0014\u001a\u00020\bJ\b\u0010\u0015\u001a\u00020\bH\u0014J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\bH\u0017J\b\u0010\u001c\u001a\u00020\bH\u0017J\u0012\u0010\u001d\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\u0003H\u0016J\u000e\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eJ\b\u0010!\u001a\u00020\bH\u0017J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010&\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0011H\u0016J\u000e\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020)J\u000e\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0011J\n\u0010/\u001a\u0004\u0018\u00010.H\u0016J\n\u00100\u001a\u0004\u0018\u00010.H\u0016J\b\u00101\u001a\u00020\u0003H\u0005J\b\u00102\u001a\u00020\u0003H\u0017J\u000e\u00103\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u001e048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u00105R\u0016\u00107\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010&R\u0016\u00108\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010&R\u0016\u0010;\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010:R\u0016\u0010=\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010<R\"\u0010B\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010<\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR2\u0010S\u001a\u0012\u0012\u0004\u0012\u00020\n0Kj\b\u0012\u0004\u0012\u00020\n`L8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010R\u00a8\u0006^"}, d2 = {"Lcom/qzone/reborn/feedx/widget/title/QZoneUserHomeTitle;", "Landroid/widget/FrameLayout;", "Lcom/qzone/reborn/feedx/widget/f$c;", "", "g", "Landroid/widget/LinearLayout$LayoutParams;", "k", c.f123400v, "", "e", "Landroid/view/View;", "view", "color", "w", "y", "r", "j", "", "o", NodeProps.ON_ATTACHED_TO_WINDOW, DomainData.DOMAIN_NAME, ReportConstant.COSTREPORT_PREFIX, "Luh/d;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "d", "setTitleAlpha", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "u", "v", "Lcom/qzone/reborn/feedx/widget/title/QZoneUserHomeTitle$b;", "listener", "c", "p", "Landroid/view/ViewGroup;", "B", "Landroid/os/Bundle;", "bundle", "I", "show", "b0", "Landroid/content/Intent;", "intent", HippyTKDListViewAdapter.X, "isGuest", "setIsGuest", "Landroid/graphics/drawable/Drawable;", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", h.F, "f", "", "Ljava/util/List;", "mTintListenerList", "mCoverStatus", "mCurAlpha", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mBtnBack", "Landroid/view/View;", "mTitleHost", "getMViewBg", "()Landroid/view/View;", "setMViewBg", "(Landroid/view/View;)V", "mViewBg", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "mRightBtnContainer", "Lcom/qzone/reborn/feedx/widget/f;", "D", "Lcom/qzone/reborn/feedx/widget/f;", "mPublishBox", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "getMRightButtonAddList", "()Ljava/util/ArrayList;", "setMRightButtonAddList", "(Ljava/util/ArrayList;)V", "mRightButtonAddList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZoneUserHomeTitle extends FrameLayout implements f.c {

    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayout mRightBtnContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private f mPublishBox;

    /* renamed from: E, reason: from kotlin metadata */
    private ArrayList<View> mRightButtonAddList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<b> mTintListenerList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mCoverStatus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mCurAlpha;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mBtnBack;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View mTitleHost;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View mViewBg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/qzone/reborn/feedx/widget/title/QZoneUserHomeTitle$b;", "", "", "color", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface b {
        void a(int color);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneUserHomeTitle(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QZoneUserHomeTitle this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context instanceof Activity) {
            ((Activity) context).onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final int g() {
        if (this.mCoverStatus == 1) {
            return h();
        }
        return i();
    }

    private final LinearLayout.LayoutParams k() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.b(28), d.b(28));
        layoutParams.setMargins(d.b(8), 0, 0, 0);
        return layoutParams;
    }

    private final void r() {
        f fVar = this.mPublishBox;
        if (fVar.f56101i) {
            fVar.i();
        } else if (fVar.f56100h != 0) {
            fVar.j();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w(View view, int color) {
        if (view instanceof ImageView) {
            com.tencent.mobileqq.qzone.picload.c.a().m((ImageView) view, color);
        } else if (view instanceof a) {
            ((a) view).a(color);
        }
    }

    private final void y() {
        if (getContext() instanceof Activity) {
            try {
                Context context = getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                QUIImmersiveHelper.s((Activity) context, true, false);
            } catch (Throwable th5) {
                RFWLog.fatal("QZoneUserHomeTitle", RFWLog.USR, th5);
            }
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

    public final void c(b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mTintListenerList.add(listener);
    }

    public final View d(uh.d item) {
        Intrinsics.checkNotNullParameter(item, "item");
        FadeIconImageView fadeIconImageView = new FadeIconImageView(getContext());
        AccessibilityUtil.p(fadeIconImageView, item.getContentDescription());
        fadeIconImageView.setImageResource(item.getDrawableId());
        fadeIconImageView.setOnClickListener(item.getOnClickListener());
        fadeIconImageView.setOnLongClickListener(item.getOnLongClickListener());
        fadeIconImageView.setScaleType(ImageView.ScaleType.CENTER);
        fadeIconImageView.setLayoutParams(k());
        fadeIconImageView.setPadding(d.b(4), d.b(4), d.b(4), d.b(4));
        f(fadeIconImageView);
        com.tencent.mobileqq.qzone.picload.c.a().m(fadeIconImageView, g());
        this.mRightBtnContainer.addView(fadeIconImageView);
        this.mRightButtonAddList.add(fadeIconImageView);
        return fadeIconImageView;
    }

    public final void f(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (o() && this.mCoverStatus == 0) {
            view.setBackgroundResource(R.drawable.f170071);
        } else {
            view.setBackgroundResource(0);
        }
    }

    public int h() {
        return getContext().getColor(R.color.qui_common_icon_nav_secondary);
    }

    protected final int i() {
        return getContext().getColor(R.color.qui_common_icon_white);
    }

    public final int j() {
        return R.layout.cod;
    }

    public Drawable l() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qzone_title_bg_legacy", false)) {
            return m();
        }
        if (QQTheme.isVasTheme()) {
            return SkinEngine.getInstances().getDefaultThemeDrawable(R.drawable.qui_bg_nav_primary);
        }
        return ContextCompat.getDrawable(getContext(), R.drawable.qui_bg_nav_primary);
    }

    public Drawable m() {
        if (com.tencent.mobileqq.simpleui.b.c()) {
            return new ColorDrawable(SimpleUIUtil.getSimpleUiBgColor());
        }
        if (QQTheme.isNowThemeIsNightForQzone()) {
            return new ColorDrawable(-16777216);
        }
        return ContextCompat.getDrawable(getContext(), R.drawable.qq_title_immersive_bar);
    }

    public final void n() {
        s();
        e(this.mCurAlpha);
    }

    public final boolean o() {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mPublishBox.f();
    }

    protected void s() {
        this.mViewBg.setAlpha(0.0f);
        try {
            Drawable l3 = l();
            if (l3 == null) {
                l3 = new ColorDrawable(getContext().getColor(R.color.qui_common_bg_nav_primary));
            }
            this.mViewBg.setBackground(l3);
        } catch (Throwable th5) {
            RFWLog.fatal("QZoneUserHomeTitle", RFWLog.USR, th5);
        }
    }

    public final void setIsGuest(boolean isGuest) {
        this.mPublishBox.g(isGuest);
    }

    public final void setMRightButtonAddList(ArrayList<View> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mRightButtonAddList = arrayList;
    }

    public final void setMViewBg(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mViewBg = view;
    }

    public void v(int color) {
        com.tencent.mobileqq.qzone.picload.c.a().m(this.mBtnBack, color);
        f(this.mBtnBack);
        int childCount = this.mRightBtnContainer.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View view = this.mRightBtnContainer.getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            w(view, color);
            f(view);
        }
        this.mPublishBox.k(color);
        Iterator<T> it = this.mTintListenerList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(color);
        }
    }

    public final void x(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.mPublishBox.n(intent);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneUserHomeTitle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void t() {
        this.mCoverStatus = 1;
        y();
        v(h());
        r();
    }

    public void u() {
        this.mCoverStatus = 0;
        y();
        v(i());
        r();
    }

    public /* synthetic */ QZoneUserHomeTitle(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneUserHomeTitle(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTintListenerList = new ArrayList();
        this.mRightButtonAddList = new ArrayList<>();
        LayoutInflater.from(getContext()).inflate(j(), this);
        View findViewById = findViewById(R.id.mjb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qz_feedx_title_bg)");
        this.mViewBg = findViewById;
        View findViewById2 = findViewById(R.id.mjc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qz_feedx_title_host)");
        this.mTitleHost = findViewById2;
        View findViewById3 = findViewById(R.id.mja);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qz_feedx_title_back)");
        this.mBtnBack = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.mjh);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qz_fee\u2026itle_right_btn_container)");
        LinearLayout linearLayout = (LinearLayout) findViewById4;
        this.mRightBtnContainer = linearLayout;
        linearLayout.setPadding(0, 0, d.b(2), 0);
        this.mTitleHost.setPadding(d.b(8), ImmersiveUtils.getStatusBarHeight(getContext()), d.b(8), 0);
        this.mBtnBack.setPadding(d.b(4), d.b(4), d.b(4), d.b(4));
        this.mBtnBack.setImageResource(R.drawable.qui_chevron_left);
        this.mBtnBack.setScaleType(ImageView.ScaleType.CENTER);
        this.mBtnBack.setOnClickListener(new View.OnClickListener() { // from class: uh.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneUserHomeTitle.b(QZoneUserHomeTitle.this, view);
            }
        });
        f(this.mBtnBack);
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

    private final void e(int alpha) {
        if (alpha >= 125) {
            t();
        } else {
            u();
        }
    }

    public final void setTitleAlpha(int alpha) {
        if (alpha < 0 || alpha > 255 || this.mCurAlpha == alpha) {
            return;
        }
        this.mCurAlpha = alpha;
        this.mViewBg.setAlpha(alpha / 255.0f);
        q(this.mCurAlpha);
        int i3 = this.mCurAlpha;
        if (i3 > 125) {
            if (this.mCoverStatus == 0) {
                e(i3);
            }
        } else if (this.mCoverStatus == 1) {
            e(i3);
        }
    }

    public void p() {
    }

    @Override // com.qzone.reborn.feedx.widget.f.c
    public void b0(boolean show) {
    }

    public void q(int alpha) {
    }
}

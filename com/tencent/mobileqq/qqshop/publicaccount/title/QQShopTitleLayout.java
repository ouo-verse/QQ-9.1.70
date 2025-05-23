package com.tencent.mobileqq.qqshop.publicaccount.title;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.content.res.ResourcesCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqshop.publicaccount.d;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.constants.QQBrowserActivityConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001FB'\b\u0007\u0012\u0006\u0010?\u001a\u00020>\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@\u0012\b\b\u0002\u0010B\u001a\u00020\u0002\u00a2\u0006\u0004\bC\u0010DJ\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010!R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010!R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010*\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010&R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010,R\u0016\u0010/\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00101\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u0016\u00103\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010,R\u0016\u00105\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010,R\u0016\u00107\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010,R<\u0010=\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020+0908j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020+09`:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/title/QQShopTitleLayout;", "Landroid/widget/LinearLayout;", "", "drawableId", "color", "Landroid/graphics/drawable/Drawable;", "d", "resId", "", "i", "e", "tabIndex", "j", "Landroid/view/View$OnClickListener;", "onBackClickListener", "setOnBackClickListener", "dailyTitleClickListener", "setDailyTitleClickListener", "coinsTitleClickListener", "setCoinsTitleClickListener", "paTitleClickListener", "setPaTitleClickListener", "onDetailClickListener", "setOnDetailClickListener", "Lcom/tencent/mobileqq/qqshop/publicaccount/d$b;", QQBrowserActivityConstants.KEY_TITLE_STYLE, DomainData.DOMAIN_NAME, "", NodeProps.VISIBLE, "l", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mBackImg", "mRightImg", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mDailyTitle", tl.h.F, "mCoinsTitle", "mPaTitle", "Landroid/view/View;", "Landroid/view/View;", "mDailyLine", BdhLogUtil.LogTag.Tag_Conn, "mCoinsLine", "D", "mPaLine", "E", "mDailyRedDot", UserInfo.SEX_FEMALE, "mCoinsRedDot", "G", "mPaRedDot", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "mTitleLayoutList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "I", "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQShopTitleLayout extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private View mCoinsLine;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private View mPaLine;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private View mDailyRedDot;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private View mCoinsRedDot;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private View mPaRedDot;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<Pair<TextView, View>> mTitleLayoutList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView mBackImg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView mRightImg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mDailyTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mCoinsTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mPaTitle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View mDailyLine;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/title/QQShopTitleLayout$a;", "", "", "TAG", "Ljava/lang/String;", "", "TOUCH_EXPAND_SIZE", UserInfo.SEX_FEMALE, "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.publicaccount.title.QQShopTitleLayout$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40584);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQShopTitleLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this, (Object) context);
    }

    private final Drawable d(@DrawableRes int drawableId, int color) {
        Drawable mutate;
        String str;
        Drawable drawable = ResourcesCompat.getDrawable(getContext().getResources(), drawableId, getContext().getTheme());
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof SkinnableBitmapDrawable) {
            mutate = ((SkinnableBitmapDrawable) drawable).mutate2();
            str = "drawable.mutate2()";
        } else {
            mutate = drawable.mutate();
            str = "drawable.mutate()";
        }
        Intrinsics.checkNotNullExpressionValue(mutate, str);
        mutate.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
        return mutate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(View.OnClickListener coinsTitleClickListener, QQShopTitleLayout this$0, View view) {
        HashMap<String, String> hashMapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(coinsTitleClickListener, "$coinsTitleClickListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        coinsTitleClickListener.onClick(view);
        com.tencent.mobileqq.qqshop.report.beacon.b bVar = com.tencent.mobileqq.qqshop.report.beacon.b.f274709a;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("ext1", this$0.mCoinsTitle.getText().toString()));
        bVar.b("qgg_gzh_lifeselection_top_tab_click", hashMapOf);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(View.OnClickListener dailyTitleClickListener, QQShopTitleLayout this$0, View view) {
        HashMap<String, String> hashMapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(dailyTitleClickListener, "$dailyTitleClickListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dailyTitleClickListener.onClick(view);
        com.tencent.mobileqq.qqshop.report.beacon.b bVar = com.tencent.mobileqq.qqshop.report.beacon.b.f274709a;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("ext1", this$0.mDailyTitle.getText().toString()));
        bVar.b("qgg_gzh_lifeselection_top_tab_click", hashMapOf);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(View.OnClickListener paTitleClickListener, QQShopTitleLayout this$0, View view) {
        HashMap<String, String> hashMapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(paTitleClickListener, "$paTitleClickListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        paTitleClickListener.onClick(view);
        com.tencent.mobileqq.qqshop.report.beacon.b bVar = com.tencent.mobileqq.qqshop.report.beacon.b.f274709a;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("ext1", this$0.mPaTitle.getText().toString()));
        bVar.b("qgg_gzh_lifeselection_top_tab_click", hashMapOf);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void i(int resId) {
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        setBackgroundResource(resId);
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public final void e() {
        int i3;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        TextView textView = this.mCoinsTitle;
        boolean z18 = false;
        if (com.tencent.mobileqq.qqshop.publicaccount.d.f274576a.d()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
        BaseAIOUtils.g(this.mDailyTitle, ViewUtils.dpToPx(20.0f));
        BaseAIOUtils.g(this.mCoinsTitle, ViewUtils.dpToPx(20.0f));
        BaseAIOUtils.g(this.mPaTitle, ViewUtils.dpToPx(20.0f));
        EcshopConfBean ecshopConfBean = EcshopConfUtil.getEcshopConfBean();
        if (ecshopConfBean == null) {
            return;
        }
        EcshopConfBean.MsgTabPageConfig msgTabPageConfig = ecshopConfBean.msgTabPageConfig;
        String str = msgTabPageConfig.dailyMsgTabTitle;
        String str2 = msgTabPageConfig.coinsMsgTabTitle;
        String str3 = msgTabPageConfig.paMsgTabTitle;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            this.mDailyTitle.setText(str);
        }
        if (str2 != null && str2.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            this.mCoinsTitle.setText(str2);
        }
        if (str3 == null || str3.length() == 0) {
            z18 = true;
        }
        if (!z18) {
            this.mPaTitle.setText(str3);
        }
    }

    public final void j(int tabIndex) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, tabIndex);
            return;
        }
        int i3 = 0;
        for (Object obj : this.mTitleLayoutList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) obj;
            if (i3 == tabIndex) {
                ((TextView) pair.getFirst()).setTypeface(Typeface.DEFAULT_BOLD);
                ((View) pair.getSecond()).setVisibility(0);
            } else {
                ((TextView) pair.getFirst()).setTypeface(Typeface.DEFAULT);
                ((View) pair.getSecond()).setVisibility(4);
            }
            i3 = i16;
        }
    }

    public final void k(boolean visible) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, visible);
            return;
        }
        View view = this.mCoinsRedDot;
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    public final void l(boolean visible) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, visible);
            return;
        }
        View view = this.mDailyRedDot;
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    public final void m(boolean visible) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, visible);
            return;
        }
        View view = this.mPaRedDot;
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    public final void n(@NotNull d.b titleStyle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) titleStyle);
            return;
        }
        Intrinsics.checkNotNullParameter(titleStyle, "titleStyle");
        int b16 = titleStyle.b();
        this.mBackImg.setImageDrawable(d(R.drawable.f160871cr1, b16));
        this.mDailyTitle.setTextColor(b16);
        this.mCoinsTitle.setTextColor(b16);
        this.mPaTitle.setTextColor(b16);
        this.mRightImg.setImageDrawable(d(R.drawable.hxy, b16));
        if (titleStyle.c()) {
            i(R.drawable.qui_common_bg_nav_aio_bg);
            this.mDailyLine.setBackgroundResource(R.drawable.qui_common_brand_standard_bg);
            this.mCoinsLine.setBackgroundResource(R.drawable.qui_common_brand_standard_bg);
            this.mPaLine.setBackgroundResource(R.drawable.qui_common_brand_standard_bg);
            return;
        }
        setBackgroundColor(titleStyle.a());
        this.mDailyLine.setBackgroundColor(b16);
        this.mCoinsLine.setBackgroundColor(b16);
        this.mPaLine.setBackgroundColor(b16);
    }

    public final void setCoinsTitleClickListener(@NotNull final View.OnClickListener coinsTitleClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) coinsTitleClickListener);
        } else {
            Intrinsics.checkNotNullParameter(coinsTitleClickListener, "coinsTitleClickListener");
            this.mCoinsTitle.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.title.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QQShopTitleLayout.f(coinsTitleClickListener, this, view);
                }
            });
        }
    }

    public final void setDailyTitleClickListener(@NotNull final View.OnClickListener dailyTitleClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dailyTitleClickListener);
        } else {
            Intrinsics.checkNotNullParameter(dailyTitleClickListener, "dailyTitleClickListener");
            this.mDailyTitle.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.title.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QQShopTitleLayout.g(dailyTitleClickListener, this, view);
                }
            });
        }
    }

    public final void setOnBackClickListener(@NotNull View.OnClickListener onBackClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) onBackClickListener);
        } else {
            Intrinsics.checkNotNullParameter(onBackClickListener, "onBackClickListener");
            this.mBackImg.setOnClickListener(onBackClickListener);
        }
    }

    public final void setOnDetailClickListener(@NotNull View.OnClickListener onDetailClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onDetailClickListener);
        } else {
            Intrinsics.checkNotNullParameter(onDetailClickListener, "onDetailClickListener");
            this.mRightImg.setOnClickListener(onDetailClickListener);
        }
    }

    public final void setPaTitleClickListener(@NotNull final View.OnClickListener paTitleClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) paTitleClickListener);
        } else {
            Intrinsics.checkNotNullParameter(paTitleClickListener, "paTitleClickListener");
            this.mPaTitle.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.title.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QQShopTitleLayout.h(paTitleClickListener, this, view);
                }
            });
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQShopTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ QQShopTitleLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQShopTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        View.inflate(context, R.layout.h4v, this);
        i(R.drawable.qui_common_bg_nav_aio_bg);
        setPadding(getPaddingLeft(), ImmersiveUtils.isSupporImmersive() == 1 ? ImmersiveUtils.getStatusBarHeight(context) : 0, getPaddingRight(), getPaddingBottom());
        View findViewById = findViewById(R.id.f623230i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qq_shop_back_img)");
        this.mBackImg = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.f624030q);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qq_shop_right_img)");
        this.mRightImg = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.f624430u);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qq_shop_title_daily_text)");
        this.mDailyTitle = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f624230s);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qq_shop_title_coins_text)");
        this.mCoinsTitle = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f624630w);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qq_shop_title_pa_text)");
        this.mPaTitle = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.f623430k);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.qq_shop_daily_line)");
        this.mDailyLine = findViewById6;
        View findViewById7 = findViewById(R.id.f623330j);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.qq_shop_coins_line)");
        this.mCoinsLine = findViewById7;
        View findViewById8 = findViewById(R.id.f623630m);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.qq_shop_pa_line)");
        this.mPaLine = findViewById8;
        View findViewById9 = findViewById(R.id.f624330t);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.qq_shop_title_daily_red_dot)");
        this.mDailyRedDot = findViewById9;
        View findViewById10 = findViewById(R.id.f624130r);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.qq_shop_title_coins_red_dot)");
        this.mCoinsRedDot = findViewById10;
        View findViewById11 = findViewById(R.id.f624530v);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.qq_shop_title_pa_red_dot)");
        this.mPaRedDot = findViewById11;
        ArrayList<Pair<TextView, View>> arrayList = new ArrayList<>();
        arrayList.add(new Pair<>(this.mDailyTitle, this.mDailyLine));
        if (com.tencent.mobileqq.qqshop.publicaccount.d.f274576a.d()) {
            arrayList.add(new Pair<>(this.mCoinsTitle, this.mCoinsLine));
        }
        arrayList.add(new Pair<>(this.mPaTitle, this.mPaLine));
        this.mTitleLayoutList = arrayList;
    }
}

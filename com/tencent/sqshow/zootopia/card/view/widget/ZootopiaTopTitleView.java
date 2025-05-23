package com.tencent.sqshow.zootopia.card.view.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.model.MaintEntryType;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.sqshow.zootopia.avatar.e;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.guide.ZplanGuideManager;
import com.tencent.sqshow.zootopia.guide.i;
import com.tencent.sqshow.zootopia.usercenter.view.UserAvatarView;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotView;
import com.tencent.state.report.SquareReportConst;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import qv4.bq;
import t74.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 s2\u00020\u0001:\u0002tuB!\u0012\u0006\u0010k\u001a\u00020j\u0012\b\u0010m\u001a\u0004\u0018\u00010l\u0012\u0006\u0010n\u001a\u00020\u0011\u00a2\u0006\u0004\bo\u0010pB\u0011\b\u0016\u0012\u0006\u0010k\u001a\u00020j\u00a2\u0006\u0004\bo\u0010qB\u001b\b\u0016\u0012\u0006\u0010k\u001a\u00020j\u0012\b\u0010m\u001a\u0004\u0018\u00010l\u00a2\u0006\u0004\bo\u0010rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0014J\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011R#\u0010\u001a\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u001f\u001a\n \u0015*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001eR#\u0010!\u001a\n \u0015*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b \u0010\u001eR#\u0010%\u001a\n \u0015*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010$R#\u0010'\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b&\u0010\u0019R#\u0010+\u001a\n \u0015*\u0004\u0018\u00010(0(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u0017\u001a\u0004\b)\u0010*R#\u0010.\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010\u0017\u001a\u0004\b-\u0010\u0019R#\u00102\u001a\n \u0015*\u0004\u0018\u00010/0/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b0\u00101R#\u00104\u001a\n \u0015*\u0004\u0018\u00010/0/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b3\u00101R#\u00105\u001a\n \u0015*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\"\u0010$R#\u0010:\u001a\n \u0015*\u0004\u0018\u000106068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u0010\u0017\u001a\u0004\b8\u00109R#\u0010=\u001a\n \u0015*\u0004\u0018\u000106068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010\u0017\u001a\u0004\b<\u00109R#\u0010@\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010\u0017\u001a\u0004\b?\u0010\u0019R#\u0010C\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010\u0017\u001a\u0004\bB\u0010\u0019R#\u0010F\u001a\n \u0015*\u0004\u0018\u000106068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010\u0017\u001a\u0004\bE\u00109R\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u001b\u0010O\u001a\u00020K8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bL\u0010\u0017\u001a\u0004\bM\u0010NR\u001b\u0010T\u001a\u00020P8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u0010\u0017\u001a\u0004\bR\u0010SR\u0014\u0010W\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010VR\"\u0010a\u001a\u00020Z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R*\u0010i\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010h\u00a8\u0006v"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaTopTitleView;", "Landroid/widget/FrameLayout;", "", "g", "Landroid/view/View;", "view", "f", HippyTKDListViewAdapter.X, "D", "w", "", "E", NodeProps.ON_ATTACHED_TO_WINDOW, UserInfo.SEX_FEMALE, "", "float", "setBackGroundAlpha", "", "state", "setTitleState", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "j", "()Landroid/widget/ImageView;", "backButton", "Landroid/widget/TextView;", "e", "u", "()Landroid/widget/TextView;", "silverCoin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "goalCoin", tl.h.F, "i", "()Landroid/view/View;", "addCoinView", ReportConstant.COSTREPORT_PREFIX, "settingButton", "Lcom/tencent/sqshow/zootopia/usercenter/view/UserAvatarView;", "v", "()Lcom/tencent/sqshow/zootopia/usercenter/view/UserAvatarView;", "userAvatarView", BdhLogUtil.LogTag.Tag_Conn, "p", "mailButton", "Landroid/view/ViewGroup;", "k", "()Landroid/view/ViewGroup;", VasProfileTemplatePreloadHelper.BACKGROUND, "l", "coinBg", "addBtn", "Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;", "redDotMail", "H", "getRedDotUserCenter", "redDotUserCenter", "I", "t", "shadowView", "J", "o", "inventoryView", "K", "getBagRedDotMail", "bagRedDotMail", "Lqv4/bq;", "L", "Lqv4/bq;", "ugcEnterInfo", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "M", "r", "()Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "Landroid/view/animation/DecelerateInterpolator;", "N", DomainData.DOMAIN_NAME, "()Landroid/view/animation/DecelerateInterpolator;", "interpolator", "P", "Z", "isZplanMaintaining", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "isShowAnim", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSourceCurrent", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "setSourceCurrent", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "sourceCurrent", "Lkotlin/Function0;", ExifInterface.LATITUDE_SOUTH, "Lkotlin/jvm/functions/Function0;", "getNeedUpdateCurrency", "()Lkotlin/jvm/functions/Function0;", "setNeedUpdateCurrency", "(Lkotlin/jvm/functions/Function0;)V", "needUpdateCurrency", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "T", "a", "NativeTitleState", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaTopTitleView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy mailButton;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy bg;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy coinBg;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy addBtn;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy redDotMail;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy redDotUserCenter;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy shadowView;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy inventoryView;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy bagRedDotMail;

    /* renamed from: L, reason: from kotlin metadata */
    private bq ugcEnterInfo;

    /* renamed from: M, reason: from kotlin metadata */
    private final Lazy reportHelper;

    /* renamed from: N, reason: from kotlin metadata */
    private final Lazy interpolator;

    /* renamed from: P, reason: from kotlin metadata */
    private final boolean isZplanMaintaining;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isShowAnim;

    /* renamed from: R, reason: from kotlin metadata */
    private ZootopiaSource sourceCurrent;

    /* renamed from: S, reason: from kotlin metadata */
    private Function0<Unit> needUpdateCurrency;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy backButton;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy silverCoin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy goalCoin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy addCoinView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy settingButton;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy userAvatarView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaTopTitleView$NativeTitleState;", "", "Companion", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes34.dex */
    public @interface NativeTitleState {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.f370261a;
        public static final int STATE_FULL_WITH_AVATAR = 3;
        public static final int STATE_FULL_WITH_LOADING = 2;
        public static final int STATE_NORMAL = 1;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaTopTitleView$NativeTitleState$a;", "", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaTopTitleView$NativeTitleState$a, reason: from kotlin metadata */
        /* loaded from: classes34.dex */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f370261a = new Companion();

            Companion() {
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/card/view/widget/ZootopiaTopTitleView$b", "Lcom/tencent/mobileqq/vas/pay/api/IVasNativePayManager$PayObserver;", "", "onOpenPayViewFail", "onOpenPayViewSuccess", "onPaySuccess", "", "code", "onPayError", "onPayViewClose", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements IVasNativePayManager.PayObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayError(int code) {
            QLog.d("cuilamTest", 4, "onPayError, code: " + code);
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewFail() {
            QLog.d("cuilamTest", 4, "onOpenPayViewFail");
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewSuccess() {
            QLog.d("cuilamTest", 4, "onOpenPayViewSuccess");
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPaySuccess() {
            QLog.d("cuilamTest", 4, "onPaySuccess");
            yb4.e.g(yb4.e.f450058a, "paySuccess", 0, 2, null);
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayViewClose() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaTopTitleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        Lazy lazy12;
        Lazy lazy13;
        Lazy lazy14;
        Lazy lazy15;
        Lazy lazy16;
        Lazy lazy17;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaTopTitleView$backButton$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) ZootopiaTopTitleView.this.findViewById(R.id.r38);
            }
        });
        this.backButton = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaTopTitleView$silverCoin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) ZootopiaTopTitleView.this.findViewById(R.id.r99);
            }
        });
        this.silverCoin = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaTopTitleView$goalCoin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) ZootopiaTopTitleView.this.findViewById(R.id.r96);
            }
        });
        this.goalCoin = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaTopTitleView$addCoinView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return ZootopiaTopTitleView.this.findViewById(R.id.r3v);
            }
        });
        this.addCoinView = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaTopTitleView$settingButton$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) ZootopiaTopTitleView.this.findViewById(R.id.r6k);
            }
        });
        this.settingButton = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<UserAvatarView>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaTopTitleView$userAvatarView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UserAvatarView invoke() {
                return (UserAvatarView) ZootopiaTopTitleView.this.findViewById(R.id.qvv);
            }
        });
        this.userAvatarView = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaTopTitleView$mailButton$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) ZootopiaTopTitleView.this.findViewById(R.id.r6i);
            }
        });
        this.mailButton = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<ViewGroup>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaTopTitleView$bg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewGroup invoke() {
                return (ViewGroup) ZootopiaTopTitleView.this.findViewById(R.id.f163610r21);
            }
        });
        this.bg = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<ViewGroup>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaTopTitleView$coinBg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewGroup invoke() {
                return (ViewGroup) ZootopiaTopTitleView.this.findViewById(R.id.r6o);
            }
        });
        this.coinBg = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaTopTitleView$addBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return ZootopiaTopTitleView.this.findViewById(R.id.r67);
            }
        });
        this.addBtn = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanRedDotView>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaTopTitleView$redDotMail$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanRedDotView invoke() {
                return (ZPlanRedDotView) ZootopiaTopTitleView.this.findViewById(R.id.r6p);
            }
        });
        this.redDotMail = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanRedDotView>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaTopTitleView$redDotUserCenter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanRedDotView invoke() {
                return (ZPlanRedDotView) ZootopiaTopTitleView.this.findViewById(R.id.r9f);
            }
        });
        this.redDotUserCenter = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaTopTitleView$shadowView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) ZootopiaTopTitleView.this.findViewById(R.id.r8d);
            }
        });
        this.shadowView = lazy13;
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaTopTitleView$inventoryView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) ZootopiaTopTitleView.this.findViewById(R.id.r6d);
            }
        });
        this.inventoryView = lazy14;
        lazy15 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanRedDotView>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaTopTitleView$bagRedDotMail$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanRedDotView invoke() {
                return (ZPlanRedDotView) ZootopiaTopTitleView.this.findViewById(R.id.r39);
            }
        });
        this.bagRedDotMail = lazy15;
        lazy16 = LazyKt__LazyJVMKt.lazy(new Function0<ZplanViewReportHelper>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaTopTitleView$reportHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZplanViewReportHelper invoke() {
                return new ZplanViewReportHelper();
            }
        });
        this.reportHelper = lazy16;
        lazy17 = LazyKt__LazyJVMKt.lazy(new Function0<DecelerateInterpolator>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaTopTitleView$interpolator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DecelerateInterpolator invoke() {
                return new DecelerateInterpolator();
            }
        });
        this.interpolator = lazy17;
        this.isZplanMaintaining = com.tencent.mobileqq.zplan.model.j.a(((IZPlanApi) QRoute.api(IZPlanApi.class)).getMaintenanceInfo(MaintEntryType.ALL), new Date());
        LayoutInflater.from(context).inflate(R.layout.d8n, (ViewGroup) this, true);
        x();
        g();
        this.sourceCurrent = new ZootopiaSource(Source.PortalActivity, ZootopiaSource.SUB_SOURCE_MAIN_HOME_LIST, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(ZootopiaTopTitleView this$0, View view) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isShowAnim) {
            return;
        }
        ZplanViewReportHelper r16 = this$0.r();
        ImageView mailButton = this$0.p();
        Intrinsics.checkNotNullExpressionValue(mailButton, "mailButton");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("zplan_redpoint_type", Integer.valueOf(this$0.q().getReddotStatus())));
        r16.e(mailButton, "em_zplan_mail_btn", hashMapOf);
        String buildMailScheme = ((ISchemeApi) QRoute.api(ISchemeApi.class)).buildMailScheme(this$0.sourceCurrent);
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iSchemeApi.launchScheme(context, buildMailScheme);
        i.a.a(ZplanGuideManager.INSTANCE.a(), 6, 11, 0, 4, null);
        QLog.d("ZootopiaTopTitle", 1, "mailButton Click ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(ZootopiaTopTitleView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isShowAnim) {
            return;
        }
        ZplanViewReportHelper r16 = this$0.r();
        ImageView settingButton = this$0.s();
        Intrinsics.checkNotNullExpressionValue(settingButton, "settingButton");
        ZplanViewReportHelper.f(r16, settingButton, "em_zplan_setting_btn", null, 4, null);
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iZPlanApi.startSettingActivity(context, IZPlanApi.FROM_QQ_SETTING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(ZootopiaTopTitleView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("ZootopiaTopTitle", 1, "inventoryView Click " + this$0.isShowAnim);
        if (this$0.isShowAnim) {
            return;
        }
        String buildInventoryScheme = ((ISchemeApi) QRoute.api(ISchemeApi.class)).buildInventoryScheme(this$0.sourceCurrent);
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iSchemeApi.launchScheme(context, buildInventoryScheme);
    }

    private final void D() {
        HashMap hashMapOf;
        HashMap hashMapOf2;
        Intent intent;
        ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
        Activity topActivity = Foreground.getTopActivity();
        FragmentSource f16 = companion.f((topActivity == null || (intent = topActivity.getIntent()) == null) ? null : intent.getExtras());
        id3.d dVar = new id3.d(null, 1, null);
        Pair[] pairArr = new Pair[4];
        ZootopiaSource c16 = ag.f373258a.c(f16 != null ? f16.getFrom() : null);
        if (c16 == null) {
            c16 = companion.i();
        }
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(c16));
        pairArr[1] = TuplesKt.to("dt_pgid", "pg_zplan_paradise");
        pairArr[2] = TuplesKt.to("zplan_return_type", "1");
        pairArr[3] = TuplesKt.to("zplan_return_to", "2");
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        dVar.d("ev_zplan_anti_mistouch_trigger", hashMapOf);
        mb4.c cVar = mb4.c.f416532a;
        hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("k_exit_mode", "0"));
        mb4.c.c(cVar, "e_zplan__exit", hashMapOf2, false, 4, null);
    }

    private final boolean E() {
        bq bqVar = this.ugcEnterInfo;
        if (bqVar == null) {
            return false;
        }
        String str = bqVar != null ? bqVar.f430102a : null;
        return !(str == null || str.length() == 0);
    }

    private final void f(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(com.tencent.sqshow.zootopia.utils.i.b(6));
            view.setLayoutParams(layoutParams);
        }
    }

    private final void g() {
        int screenWidth = ScreenUtils.getScreenWidth(BaseApplication.context);
        int pxToDp = ViewUtils.pxToDp(screenWidth);
        QLog.d("ZootopiaTopTitle", 1, " get width: " + screenWidth + ", " + pxToDp + " ");
        if (pxToDp < 313) {
            ImageView mailButton = p();
            Intrinsics.checkNotNullExpressionValue(mailButton, "mailButton");
            f(mailButton);
            ImageView inventoryView = o();
            Intrinsics.checkNotNullExpressionValue(inventoryView, "inventoryView");
            f(inventoryView);
        }
    }

    private final View h() {
        return (View) this.addBtn.getValue();
    }

    private final View i() {
        return (View) this.addCoinView.getValue();
    }

    private final ImageView j() {
        return (ImageView) this.backButton.getValue();
    }

    private final ViewGroup k() {
        return (ViewGroup) this.bg.getValue();
    }

    private final ViewGroup l() {
        return (ViewGroup) this.coinBg.getValue();
    }

    private final TextView m() {
        return (TextView) this.goalCoin.getValue();
    }

    private final DecelerateInterpolator n() {
        return (DecelerateInterpolator) this.interpolator.getValue();
    }

    private final ImageView o() {
        return (ImageView) this.inventoryView.getValue();
    }

    private final ZPlanRedDotView q() {
        return (ZPlanRedDotView) this.redDotMail.getValue();
    }

    private final ZplanViewReportHelper r() {
        return (ZplanViewReportHelper) this.reportHelper.getValue();
    }

    private final ImageView s() {
        return (ImageView) this.settingButton.getValue();
    }

    private final ImageView t() {
        return (ImageView) this.shadowView.getValue();
    }

    private final TextView u() {
        return (TextView) this.silverCoin.getValue();
    }

    private final UserAvatarView v() {
        return (UserAvatarView) this.userAvatarView.getValue();
    }

    private final void w() {
        ((IVasNativePayManager) QRoute.api(IVasNativePayManager.class)).initAndShowPayPanel(Foreground.getTopActivity(), IVasNativePayManager.TITLE_RECHARGE, "\u8d85\u7ea7QQ\u79c0", new IVasNativePayManager.ReportData("1009", "0", "0", "0"), new b());
    }

    private final void x() {
        TextView m3 = m();
        m mVar = m.f435564a;
        AssetManager assets = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        m3.setTypeface(mVar.b(assets));
        TextView u16 = u();
        AssetManager assets2 = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets2, "context.assets");
        u16.setTypeface(mVar.b(assets2));
        QLog.d("ZootopiaTopTitle", 1, "initTopTitle and isZplanMaintaining " + this.isZplanMaintaining + " ");
        ImageView backButton = j();
        Intrinsics.checkNotNullExpressionValue(backButton, "backButton");
        aa.d(backButton, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.card.view.widget.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaTopTitleView.y(ZootopiaTopTitleView.this, view);
            }
        });
        View addCoinView = i();
        Intrinsics.checkNotNullExpressionValue(addCoinView, "addCoinView");
        aa.d(addCoinView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.card.view.widget.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaTopTitleView.z(ZootopiaTopTitleView.this, view);
            }
        });
        ImageView mailButton = p();
        Intrinsics.checkNotNullExpressionValue(mailButton, "mailButton");
        aa.e(mailButton, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.card.view.widget.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaTopTitleView.A(ZootopiaTopTitleView.this, view);
            }
        }, 1000L);
        ImageView settingButton = s();
        Intrinsics.checkNotNullExpressionValue(settingButton, "settingButton");
        aa.d(settingButton, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.card.view.widget.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaTopTitleView.B(ZootopiaTopTitleView.this, view);
            }
        });
        if (this.isZplanMaintaining) {
            h().setVisibility(4);
        } else {
            h().setVisibility(0);
        }
        ImageView inventoryView = o();
        Intrinsics.checkNotNullExpressionValue(inventoryView, "inventoryView");
        aa.e(inventoryView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.card.view.widget.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaTopTitleView.C(ZootopiaTopTitleView.this, view);
            }
        }, 1000L);
        k().getBackground().mutate();
        k().getBackground().setAlpha(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(ZootopiaTopTitleView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isShowAnim) {
            return;
        }
        ZplanViewReportHelper r16 = this$0.r();
        ImageView backButton = this$0.j();
        Intrinsics.checkNotNullExpressionValue(backButton, "backButton");
        ZplanViewReportHelper.f(r16, backButton, "em_zplan_back_btn", null, 4, null);
        com.tencent.zplan.luabridge.a S = ZPlanServiceHelper.I.S();
        com.tencent.sqshow.zootopia.avatar.f fVar = com.tencent.sqshow.zootopia.avatar.f.f369932a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        boolean c16 = fVar.c(context);
        QLog.d("ZootopiaTopTitle", 1, "backButton Click avater status " + c16);
        if (S != null) {
            S.callLua("N2L_NavigatorBackPressed", "{}", (a.b) null);
        }
        if (c16) {
            e.a.a(fVar, 1, false, 2, null);
        } else {
            IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
            Context context2 = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            Activity activityFromContext = iZPlanApi.getActivityFromContext(context2);
            if (activityFromContext != null) {
                activityFromContext.finish();
            }
            this$0.D();
        }
        QLog.d("ZootopiaTopTitle", 1, "backButton Click ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ZootopiaTopTitleView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isZplanMaintaining) {
            QLog.e("ZootopiaTopTitle", 1, "addCoinButton error as rainting");
            return;
        }
        if (this$0.isShowAnim) {
            return;
        }
        ZplanViewReportHelper r16 = this$0.r();
        View addCoinView = this$0.i();
        Intrinsics.checkNotNullExpressionValue(addCoinView, "addCoinView");
        ZplanViewReportHelper.f(r16, addCoinView, "em_zplan_topup_entrance_btn", null, 4, null);
        QLog.d("ZootopiaTopTitle", 1, "addCoinButton Click ");
        this$0.w();
    }

    public final void F() {
        Function0<Unit> function0 = this.needUpdateCurrency;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        HashMap hashMapOf;
        super.onAttachedToWindow();
        ZplanViewReportHelper r16 = r();
        ImageView backButton = j();
        Intrinsics.checkNotNullExpressionValue(backButton, "backButton");
        r16.g(backButton, "em_zplan_back_btn", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        if (!this.isZplanMaintaining) {
            ZplanViewReportHelper r17 = r();
            View addCoinView = i();
            Intrinsics.checkNotNullExpressionValue(addCoinView, "addCoinView");
            r17.g(addCoinView, "em_zplan_topup_entrance_btn", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
        ZplanViewReportHelper r18 = r();
        ImageView mailButton = p();
        Intrinsics.checkNotNullExpressionValue(mailButton, "mailButton");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("zplan_redpoint_type", Integer.valueOf(q().getReddotStatus())));
        r18.g(mailButton, "em_zplan_mail_btn", (r16 & 4) != 0 ? null : hashMapOf, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    public final ImageView p() {
        return (ImageView) this.mailButton.getValue();
    }

    public final void setBackGroundAlpha(float r46) {
        QLog.i("ZootopiaTopTitle", 1, "setBackGroundAlpha " + r46);
        float interpolation = n().getInterpolation(r46);
        ViewGroup k3 = k();
        Drawable background = k3 != null ? k3.getBackground() : null;
        if (background != null) {
            background.setAlpha((int) (255 * interpolation));
        }
        ImageView t16 = t();
        if (t16 == null) {
            return;
        }
        t16.setAlpha(interpolation);
    }

    public final void setNeedUpdateCurrency(Function0<Unit> function0) {
        this.needUpdateCurrency = function0;
    }

    public final void setSourceCurrent(ZootopiaSource zootopiaSource) {
        Intrinsics.checkNotNullParameter(zootopiaSource, "<set-?>");
        this.sourceCurrent = zootopiaSource;
    }

    public final void setTitleState(int state) {
        QLog.i("ZootopiaTopTitle", 1, "setTitleState " + state);
        if (state != 1) {
            if (state == 2) {
                u().setVisibility(4);
                m().setVisibility(4);
                i().setVisibility(4);
                s().setVisibility(4);
                p().setVisibility(4);
                l().setVisibility(4);
                k().setVisibility(0);
                setVisibility(0);
                return;
            }
            if (state != 3) {
                return;
            }
        }
        u().setVisibility(0);
        m().setVisibility(0);
        i().setVisibility(0);
        if (E()) {
            v().setVisibility(0);
            s().setVisibility(8);
        } else {
            v().setVisibility(8);
            s().setVisibility(0);
        }
        p().setVisibility(0);
        k().setVisibility(0);
        l().setVisibility(0);
        setVisibility(0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaTopTitleView(Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaTopTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}

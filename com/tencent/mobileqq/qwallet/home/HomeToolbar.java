package com.tencent.mobileqq.qwallet.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$VirtualEntity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 I2\u00020\u0001:\u0001JB'\b\u0007\u0012\u0006\u0010B\u001a\u00020A\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C\u0012\b\b\u0002\u0010F\u001a\u00020E\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\n\u001a\u00020\u0002H\u0014J\b\u0010\u000b\u001a\u00020\u0002H\u0014R\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010!\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001dR\u0016\u0010#\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001dR\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001b\u00102\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010\u000e\u001a\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010=\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/HomeToolbar;", "Landroidx/appcompat/widget/Toolbar;", "", "onFinishInflate", "Lcom/tencent/mobileqq/qwallet/home/TopAppsLayout;", "bigTal", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "isLoading", "o", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeFragment;", "d", "Lkotlin/Lazy;", "j", "()Lcom/tencent/mobileqq/qwallet/home/QWalletHomeFragment;", "fragment", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeViewModel;", "e", "k", "()Lcom/tencent/mobileqq/qwallet/home/QWalletHomeViewModel;", "viewModel", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$VirtualEntity;", "f", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$VirtualEntity;", "settingEntity", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "loadingView", "i", "settingBtn", "payCodeBtn", BdhLogUtil.LogTag.Tag_Conn, "redPoint", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "titleView", "E", "Lcom/tencent/mobileqq/qwallet/home/TopAppsLayout;", "smallTopAppsLayout", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", UserInfo.SEX_FEMALE, "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "payCodeAppInfo", "G", "l", "()Z", "isNowElderMode", "Landroid/widget/PopupWindow;", "H", "Landroid/widget/PopupWindow;", "payCodePopWindow", "Ljava/lang/Runnable;", "I", "Ljava/lang/Runnable;", "dismissPopupWindow", "Landroidx/lifecycle/Observer;", "J", "Landroidx/lifecycle/Observer;", "entityObserver", "K", "payCodeObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HomeToolbar extends Toolbar {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView redPoint;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView titleView;

    /* renamed from: E, reason: from kotlin metadata */
    private TopAppsLayout smallTopAppsLayout;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QWalletHomePage$AppInfo payCodeAppInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy isNowElderMode;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private PopupWindow payCodePopWindow;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Runnable dismissPopupWindow;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Observer<QWalletHomePage$VirtualEntity> entityObserver;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Observer<QWalletHomePage$AppInfo> payCodeObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy fragment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QWalletHomePage$VirtualEntity settingEntity;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView loadingView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView settingBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView payCodeBtn;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomeToolbar(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(HomeToolbar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.payCodePopWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(HomeToolbar this$0, QWalletHomePage$VirtualEntity qWalletHomePage$VirtualEntity) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (qWalletHomePage$VirtualEntity == null) {
            return;
        }
        ImageView imageView = this$0.redPoint;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redPoint");
            imageView = null;
        }
        if (c4.a.d(qWalletHomePage$VirtualEntity)) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QWalletHomeFragment j() {
        return (QWalletHomeFragment) this.fragment.getValue();
    }

    private final QWalletHomeViewModel k() {
        return (QWalletHomeViewModel) this.viewModel.getValue();
    }

    private final boolean l() {
        return ((Boolean) this.isNowElderMode.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(HomeToolbar this$0, QWalletHomePage$AppInfo qWalletHomePage$AppInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.payCodeAppInfo = qWalletHomePage$AppInfo;
        if (qWalletHomePage$AppInfo != null) {
            c4.a.y(qWalletHomePage$AppInfo, "index.topbutton.show", null, 0, 6, null);
        }
    }

    public final void m(@NotNull TopAppsLayout bigTal) {
        float coerceAtLeast;
        float coerceAtMost;
        Intrinsics.checkNotNullParameter(bigTal, "bigTal");
        if (l()) {
            return;
        }
        getLocationOnScreen(new int[2]);
        bigTal.getLocationOnScreen(new int[2]);
        float height = ((((r0[1] + r6) - r1[1]) - (getHeight() / 4.0f)) * 1.0f) / bigTal.getHeight();
        float f16 = 0.0f;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(height, 0.0f);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, 1.0f);
        TextView textView = this.titleView;
        TopAppsLayout topAppsLayout = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            textView = null;
        }
        if (coerceAtMost > 0.95f) {
            f16 = coerceAtMost;
        }
        textView.setAlpha(f16);
        TopAppsLayout topAppsLayout2 = this.smallTopAppsLayout;
        if (topAppsLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallTopAppsLayout");
        } else {
            topAppsLayout = topAppsLayout2;
        }
        topAppsLayout.setAlpha(1.0f - coerceAtMost);
    }

    public final void o(boolean isLoading) {
        ImageView imageView = null;
        if (isLoading) {
            ImageView imageView2 = this.loadingView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView3 = this.loadingView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        k().b2().observeForever(this.entityObserver);
        k().Z1().observeForever(this.payCodeObserver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k().b2().removeObserver(this.entityObserver);
        k().Z1().removeObserver(this.payCodeObserver);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.dismissPopupWindow);
        PopupWindow popupWindow = this.payCodePopWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        ImageView imageView;
        int i3;
        ImageView imageView2;
        super.onFinishInflate();
        setOutlineProvider(null);
        View.inflate(getContext(), R.layout.hil, this);
        View findViewById = findViewById(R.id.efs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.loading_view)");
        this.loadingView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.ywk);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.main_title)");
        this.titleView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.t2h);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<View>(R.id.back_arrow)");
        com.tencent.mobileqq.qwallet.k.d(findViewById3, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.home.HomeToolbar$onFinishInflate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QWalletHomeFragment j3;
                j3 = HomeToolbar.this.j();
                j3.finish();
                u.m("index.back", "1", String.valueOf(NetConnInfoCenter.getServerTimeMillis()), null, null, 0, 56, null);
            }
        }, 1, null);
        View findViewById4 = findViewById(R.id.f83724kb);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.setting_btn)");
        ImageView imageView3 = (ImageView) findViewById4;
        this.settingBtn = imageView3;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingBtn");
            imageView = null;
        } else {
            imageView = imageView3;
        }
        com.tencent.mobileqq.qwallet.k.d(imageView, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.home.HomeToolbar$onFinishInflate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ImageView imageView4;
                QWalletHomePage$VirtualEntity qWalletHomePage$VirtualEntity;
                com.tencent.mobileqq.qwallet.setting.f fVar = com.tencent.mobileqq.qwallet.setting.f.f279176a;
                Context context = HomeToolbar.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                fVar.b(context);
                imageView4 = HomeToolbar.this.redPoint;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("redPoint");
                    imageView4 = null;
                }
                imageView4.setVisibility(8);
                qWalletHomePage$VirtualEntity = HomeToolbar.this.settingEntity;
                if (qWalletHomePage$VirtualEntity != null) {
                    c4.a.C(qWalletHomePage$VirtualEntity);
                }
            }
        }, 1, null);
        View findViewById5 = findViewById(R.id.f228004p);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.pay_code_btn)");
        ImageView imageView4 = (ImageView) findViewById5;
        this.payCodeBtn = imageView4;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payCodeBtn");
            imageView4 = null;
        }
        if (ol2.a.c()) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        imageView4.setVisibility(i3);
        ImageView imageView5 = this.payCodeBtn;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payCodeBtn");
            imageView2 = null;
        } else {
            imageView2 = imageView5;
        }
        com.tencent.mobileqq.qwallet.k.d(imageView2, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.home.HomeToolbar$onFinishInflate$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QWalletHomePage$AppInfo qWalletHomePage$AppInfo;
                QWalletHomePage$AppInfo qWalletHomePage$AppInfo2;
                u uVar = u.f278200a;
                Context context = HomeToolbar.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                qWalletHomePage$AppInfo = HomeToolbar.this.payCodeAppInfo;
                uVar.e(context, qWalletHomePage$AppInfo);
                qWalletHomePage$AppInfo2 = HomeToolbar.this.payCodeAppInfo;
                if (qWalletHomePage$AppInfo2 != null) {
                    c4.a.y(qWalletHomePage$AppInfo2, "index.topbutton.click", null, 0, 6, null);
                }
            }
        }, 1, null);
        View findViewById6 = findViewById(R.id.f83834km);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.setting_red_point)");
        this.redPoint = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.f86384ri);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.small_top_apps_layout)");
        this.smallTopAppsLayout = (TopAppsLayout) findViewById7;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomeToolbar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ HomeToolbar(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomeToolbar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QWalletHomeFragment>() { // from class: com.tencent.mobileqq.qwallet.home.HomeToolbar$fragment$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QWalletHomeFragment invoke() {
                return (QWalletHomeFragment) FragmentManager.findFragment(HomeToolbar.this);
            }
        });
        this.fragment = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QWalletHomeViewModel>() { // from class: com.tencent.mobileqq.qwallet.home.HomeToolbar$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QWalletHomeViewModel invoke() {
                QWalletHomeFragment j3;
                j3 = HomeToolbar.this.j();
                return j3.Oh();
            }
        });
        this.viewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.qwallet.home.HomeToolbar$isNowElderMode$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(ol2.a.c());
            }
        });
        this.isNowElderMode = lazy3;
        this.dismissPopupWindow = new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.e
            @Override // java.lang.Runnable
            public final void run() {
                HomeToolbar.h(HomeToolbar.this);
            }
        };
        this.entityObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.home.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeToolbar.i(HomeToolbar.this, (QWalletHomePage$VirtualEntity) obj);
            }
        };
        this.payCodeObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.home.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeToolbar.n(HomeToolbar.this, (QWalletHomePage$AppInfo) obj);
            }
        };
    }
}

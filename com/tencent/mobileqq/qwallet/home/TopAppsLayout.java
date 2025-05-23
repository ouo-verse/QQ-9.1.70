package com.tencent.mobileqq.qwallet.home;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.qwallet.data.TenPayInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001+B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\u0004\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0014R\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001b\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/TopAppsLayout;", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout$LayoutParams;", "d", "", "index", "e", "", "onFinishInflate", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "", "Z", "isShrinkMode", "", "Lcom/tencent/mobileqq/qwallet/home/TopAppView;", "[Lcom/tencent/mobileqq/qwallet/home/TopAppView;", "appViews", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeViewModel;", "f", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/qwallet/home/QWalletHomeViewModel;", "viewModel", "Landroidx/lifecycle/Observer;", "", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", tl.h.F, "Landroidx/lifecycle/Observer;", "topAppsObserver", "Lcom/qwallet/data/TenPayInfo;", "i", "tenpayInfoObserver", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qcoinObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class TopAppsLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isShrinkMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TopAppView[] appViews;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<List<QWalletHomePage$AppInfo>> topAppsObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<TenPayInfo> tenpayInfoObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Long> qcoinObserver;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopAppsLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final LinearLayout.LayoutParams d() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    private final int e(int index) {
        if (index == 0) {
            return 1;
        }
        if (index != 1) {
            if (index != 2 || !ol2.a.c()) {
                return 0;
            }
            return 2;
        }
        return 3;
    }

    private final QWalletHomeViewModel f() {
        return (QWalletHomeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(TopAppsLayout this$0, Long it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qwallet.utils.a aVar = com.tencent.mobileqq.qwallet.utils.a.f279249a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        Pair<String, String> b16 = aVar.b(it.longValue());
        QLog.d("TopAppsLayout", 1, "qcoinObserver : " + it + " " + b16);
        TopAppView[] topAppViewArr = this$0.appViews;
        if (topAppViewArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appViews");
            topAppViewArr = null;
        }
        topAppViewArr[1].Q0(b16.getFirst(), b16.getSecond());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(TopAppsLayout this$0, TenPayInfo tenPayInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qwallet.utils.a aVar = com.tencent.mobileqq.qwallet.utils.a.f279249a;
        String str = tenPayInfo.f41528a;
        Intrinsics.checkNotNullExpressionValue(str, "it.tenPayBalance");
        Pair<String, String> a16 = aVar.a(Long.parseLong(str));
        TopAppView[] topAppViewArr = this$0.appViews;
        if (topAppViewArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appViews");
            topAppViewArr = null;
        }
        topAppViewArr[0].P0(tenPayInfo.b(), a16.getFirst(), a16.getSecond());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0083, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r14, r15[r8 - 1].H0()) == false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[LOOP:1: B:7:0x0058->B:22:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void i(TopAppsLayout this$0, List topApps) {
        String joinToString$default;
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(topApps, "topApps");
        List list = topApps;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, null, null, null, 0, null, new Function1<QWalletHomePage$AppInfo, CharSequence>() { // from class: com.tencent.mobileqq.qwallet.home.TopAppsLayout$topAppsObserver$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull QWalletHomePage$AppInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.name.get() + " " + it.type.get();
            }
        }, 31, null);
        QLog.d("TopAppsLayout", 2, "topAppsObserver: " + joinToString$default);
        TopAppView[] topAppViewArr = this$0.appViews;
        if (topAppViewArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appViews");
            topAppViewArr = null;
        }
        int length = topAppViewArr.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            TopAppView topAppView = topAppViewArr[i3];
            int i17 = i16 + 1;
            int e16 = this$0.e(i16);
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    QWalletHomePage$AppInfo qWalletHomePage$AppInfo = (QWalletHomePage$AppInfo) obj;
                    if (qWalletHomePage$AppInfo.type.get() == e16) {
                        if (i16 != 0) {
                            TopAppView[] topAppViewArr2 = this$0.appViews;
                            if (topAppViewArr2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("appViews");
                                topAppViewArr2 = null;
                            }
                        }
                        z16 = true;
                        if (!z16) {
                            break;
                        }
                    }
                    z16 = false;
                    if (!z16) {
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            topAppView.setTypeAndAppInfo(e16, (QWalletHomePage$AppInfo) obj, HomeLegacyBizManager.f277929d.g(), this$0.isShrinkMode);
            i3++;
            i16 = i17;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QWalletHomePreviewController qWalletHomePreviewController = QWalletHomePreviewController.f277969a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        qWalletHomePreviewController.g(context);
        f().d2().observeForever(this.topAppsObserver);
        HomeLegacyBizManager homeLegacyBizManager = HomeLegacyBizManager.f277929d;
        homeLegacyBizManager.j().observeForever(this.qcoinObserver);
        homeLegacyBizManager.m().observeForever(this.tenpayInfoObserver);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f().d2().removeObserver(this.topAppsObserver);
        HomeLegacyBizManager homeLegacyBizManager = HomeLegacyBizManager.f277929d;
        homeLegacyBizManager.j().removeObserver(this.qcoinObserver);
        homeLegacyBizManager.m().removeObserver(this.tenpayInfoObserver);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        TopAppView[] topAppViewArr = new TopAppView[4];
        for (int i3 = 0; i3 < 4; i3++) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            topAppViewArr[i3] = new TopAppView(context, null, 0, 0, 14, null);
        }
        this.appViews = topAppViewArr;
        for (TopAppView topAppView : topAppViewArr) {
            topAppView.setClipChildren(false);
            addView(topAppView, d());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopAppsLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TopAppsLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopAppsLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QWalletHomeViewModel>() { // from class: com.tencent.mobileqq.qwallet.home.TopAppsLayout$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QWalletHomeViewModel invoke() {
                return ((QWalletHomeFragment) FragmentManager.findFragment(TopAppsLayout.this)).Oh();
            }
        });
        this.viewModel = lazy;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.tencent.mobileqq.qwallet.impl.f.L7, 0, 0);
        try {
            this.isShrinkMode = obtainStyledAttributes.getBoolean(com.tencent.mobileqq.qwallet.impl.f.M7, false);
            obtainStyledAttributes.recycle();
            this.topAppsObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.home.an
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TopAppsLayout.i(TopAppsLayout.this, (List) obj);
                }
            };
            this.tenpayInfoObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.home.ao
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TopAppsLayout.h(TopAppsLayout.this, (TenPayInfo) obj);
                }
            };
            this.qcoinObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.home.ap
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TopAppsLayout.g(TopAppsLayout.this, (Long) obj);
                }
            };
        } catch (Throwable th5) {
            obtainStyledAttributes.recycle();
            throw th5;
        }
    }
}

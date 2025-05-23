package com.tencent.mobileqq.qwallet.home;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$VirtualAsset;
import com.qwallet.protocol.Wallet.pb.QWalletHomePrivilege$Privilege;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001&B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\u0012R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0018\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/AssetsLayout;", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout$LayoutParams;", "d", "", "onFinishInflate", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/qwallet/home/AssetCoinView;", "Lcom/tencent/mobileqq/qwallet/home/AssetCoinView;", "couponView", "Lcom/tencent/mobileqq/qwallet/home/AssetPrivilegeView;", "e", "Lcom/tencent/mobileqq/qwallet/home/AssetPrivilegeView;", "privilegeView", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeViewModel;", "f", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/qwallet/home/QWalletHomeViewModel;", "viewModel", "Landroidx/lifecycle/Observer;", "", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$VirtualAsset;", tl.h.F, "Landroidx/lifecycle/Observer;", "assetsObserver", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePrivilege$Privilege;", "i", "privilegeObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class AssetsLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AssetCoinView couponView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AssetPrivilegeView privilegeView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<List<QWalletHomePage$VirtualAsset>> assetsObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<List<QWalletHomePrivilege$Privilege>> privilegeObserver;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AssetsLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AssetsLayout this$0, List list) {
        QWalletHomePage$VirtualAsset qWalletHomePage$VirtualAsset;
        QWalletHomePage$VirtualAsset qWalletHomePage$VirtualAsset2;
        Object obj;
        boolean z16;
        Object obj2;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = 0;
        AssetPrivilegeView assetPrivilegeView = null;
        if (list != null) {
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj2 = it.next();
                    if (((QWalletHomePage$VirtualAsset) obj2).type.get() == 5) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            qWalletHomePage$VirtualAsset = (QWalletHomePage$VirtualAsset) obj2;
        } else {
            qWalletHomePage$VirtualAsset = null;
        }
        AssetCoinView assetCoinView = this$0.couponView;
        if (assetCoinView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("couponView");
            assetCoinView = null;
        }
        assetCoinView.D0(qWalletHomePage$VirtualAsset);
        if (list != null) {
            Iterator it5 = list.iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj = it5.next();
                    if (((QWalletHomePage$VirtualAsset) obj).type.get() == 2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            qWalletHomePage$VirtualAsset2 = (QWalletHomePage$VirtualAsset) obj;
        } else {
            qWalletHomePage$VirtualAsset2 = null;
        }
        AssetPrivilegeView assetPrivilegeView2 = this$0.privilegeView;
        if (assetPrivilegeView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privilegeView");
        } else {
            assetPrivilegeView = assetPrivilegeView2;
        }
        assetPrivilegeView.D0(qWalletHomePage$VirtualAsset2);
        if (qWalletHomePage$VirtualAsset == null && qWalletHomePage$VirtualAsset2 == null) {
            i3 = 8;
        }
        this$0.setVisibility(i3);
    }

    private final LinearLayout.LayoutParams d() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.setMarginStart(com.tencent.mobileqq.util.x.c(getContext(), 5.5f));
        layoutParams.setMarginEnd(com.tencent.mobileqq.util.x.c(getContext(), 5.5f));
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    private final QWalletHomeViewModel e() {
        return (QWalletHomeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(AssetsLayout this$0, List privileges) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AssetPrivilegeView assetPrivilegeView = this$0.privilegeView;
        if (assetPrivilegeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privilegeView");
            assetPrivilegeView = null;
        }
        Intrinsics.checkNotNullExpressionValue(privileges, "privileges");
        ArrayList arrayList = new ArrayList();
        for (Object obj : privileges) {
            if (((QWalletHomePrivilege$Privilege) obj).is_open.get()) {
                arrayList.add(obj);
            }
        }
        assetPrivilegeView.G0(arrayList.size());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e().Q1().observeForever(this.assetsObserver);
        e().a2().observeForever(this.privilegeObserver);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e().Q1().removeObserver(this.assetsObserver);
        e().a2().removeObserver(this.privilegeObserver);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        AssetCoinView assetCoinView = new AssetCoinView(context, null, 0, 0, 14, null);
        assetCoinView.initView();
        this.couponView = assetCoinView;
        addView(assetCoinView, d());
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        AssetPrivilegeView assetPrivilegeView = new AssetPrivilegeView(context2, null, 0, 0, 14, null);
        assetPrivilegeView.initView();
        this.privilegeView = assetPrivilegeView;
        addView(assetPrivilegeView, d());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AssetsLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AssetsLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AssetsLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QWalletHomeViewModel>() { // from class: com.tencent.mobileqq.qwallet.home.AssetsLayout$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QWalletHomeViewModel invoke() {
                return ((QWalletHomeFragment) FragmentManager.findFragment(AssetsLayout.this)).Oh();
            }
        });
        this.viewModel = lazy;
        this.assetsObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.home.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AssetsLayout.c(AssetsLayout.this, (List) obj);
            }
        };
        this.privilegeObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.home.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AssetsLayout.f(AssetsLayout.this, (List) obj);
            }
        };
    }
}

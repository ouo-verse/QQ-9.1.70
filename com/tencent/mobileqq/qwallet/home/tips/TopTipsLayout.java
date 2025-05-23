package com.tencent.mobileqq.qwallet.home.tips;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.qwallet.data.TenPayInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$Belt;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qwallet.home.HomeLegacyBizManager;
import com.tencent.mobileqq.qwallet.home.QWalletHomeFragment;
import com.tencent.mobileqq.qwallet.home.QWalletHomeViewModel;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001 B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0014R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\fR \u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0012\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/tips/TopTipsLayout;", "Landroid/widget/FrameLayout;", "", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/qwallet/home/tips/g;", "d", "Lcom/tencent/mobileqq/qwallet/home/tips/g;", "mBeltTipsManager", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeViewModel;", "e", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/qwallet/home/QWalletHomeViewModel;", "viewModel", "Landroidx/lifecycle/Observer;", "", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$Belt;", "f", "Landroidx/lifecycle/Observer;", "beltsObserver", "Lcom/qwallet/data/TenPayInfo;", tl.h.F, "tenpayInfoObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class TopTipsLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g mBeltTipsManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<List<QWalletHomePage$Belt>> beltsObserver;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<TenPayInfo> tenpayInfoObserver;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopTipsLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(TopTipsLayout this$0, List beltRsp) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(beltRsp, "beltRsp");
        ArrayList arrayList = new ArrayList();
        for (Object obj : beltRsp) {
            if (!c4.a.o((QWalletHomePage$Belt) obj)) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(com.qwallet.data.d.INSTANCE.a((QWalletHomePage$Belt) it.next()));
        }
        this$0.mBeltTipsManager.c(arrayList2);
    }

    private final QWalletHomeViewModel d() {
        return (QWalletHomeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(TopTipsLayout this$0, TenPayInfo tenPayInfo) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean c16 = com.tencent.mobileqq.qwallet.utils.g.c(IQWalletHelper.PREF_KEY_MULTI_IS_TENPAY_YELLOWTIP_VALID, true);
        if (tenPayInfo.c() && c16 && (jSONObject = tenPayInfo.f41534g) != null) {
            this$0.mBeltTipsManager.d(new com.qwallet.data.d(0, jSONObject.optString("tips_title"), tenPayInfo.f41534g.optString("tips_url"), 0, 4, null, 41, null));
        } else {
            this$0.mBeltTipsManager.d(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!QWalletHomeBeltConfig.INSTANCE.b()) {
            d().R1().observeForever(this.beltsObserver);
            HomeLegacyBizManager.f277929d.m().observeForever(this.tenpayInfoObserver);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!QWalletHomeBeltConfig.INSTANCE.b()) {
            d().R1().removeObserver(this.beltsObserver);
            HomeLegacyBizManager.f277929d.m().removeObserver(this.tenpayInfoObserver);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopTipsLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TopTipsLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopTipsLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBeltTipsManager = new g(context, this);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QWalletHomeViewModel>() { // from class: com.tencent.mobileqq.qwallet.home.tips.TopTipsLayout$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QWalletHomeViewModel invoke() {
                return ((QWalletHomeFragment) FragmentManager.findFragment(TopTipsLayout.this)).Oh();
            }
        });
        this.viewModel = lazy;
        this.beltsObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.home.tips.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopTipsLayout.c(TopTipsLayout.this, (List) obj);
            }
        };
        this.tenpayInfoObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.home.tips.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopTipsLayout.e(TopTipsLayout.this, (TenPayInfo) obj);
            }
        };
    }
}

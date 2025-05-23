package com.tencent.sqshow.zootopia.nativeui.dialog.views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.sqshow.zootopia.card.view.widget.CurrencyView;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarGlobalLoadingView;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarPanelErrorView;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.cq;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u00106\u001a\u00020\t\u0012\u0006\u00108\u001a\u000207\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\tH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\rH\u0014J\b\u0010\u0012\u001a\u00020\u000fH\u0014J\b\u0010\u0013\u001a\u00020\rH\u0014J\b\u0010\u0014\u001a\u00020\u000fH\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0017\u001a\u00020\rH\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\b\u0010\u001c\u001a\u00020\rH\u0014J\b\u0010\u001e\u001a\u00020\u001dH\u0014J\b\u0010 \u001a\u00020\u001fH\u0014J\b\u0010\"\u001a\u00020!H\u0014J\b\u0010#\u001a\u00020\u000fH\u0014J\b\u0010$\u001a\u00020\u0015H\u0014J\n\u0010&\u001a\u0004\u0018\u00010%H\u0014J\n\u0010'\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010(\u001a\u00020\u0002H\u0002R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u0006;"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/dialog/views/ShoppingCartDialogViewLand;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/ShoppingCartDialogView;", "", "onDismiss", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "N0", "", UserInfo.SEX_FEMALE, "", "r", "t", HippyTKDListViewAdapter.X, "Landroid/widget/TextView;", "A0", "Landroid/widget/ImageView;", "z0", "r0", "s0", "q0", "j0", "Landroid/widget/LinearLayout;", "D0", "C0", "Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarPanelErrorView;", "v0", "Landroidx/recyclerview/widget/RecyclerView;", "t0", "B0", "Lcom/tencent/sqshow/zootopia/portal/shimmer/ShimmerLinearLayout;", "w0", "Landroid/widget/FrameLayout;", "x0", "Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarGlobalLoadingView;", "y0", "l0", "o0", "Lcom/tencent/sqshow/zootopia/card/view/widget/CurrencyView;", "m0", "p0", BdhLogUtil.LogTag.Tag_Conn, "Ln74/cq;", "K", "Ln74/cq;", "binding", "Landroidx/lifecycle/Observer;", "Lcom/tencent/sqshow/zootopia/data/f;", "L", "Landroidx/lifecycle/Observer;", "coinUpdateObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class ShoppingCartDialogViewLand extends ShoppingCartDialogView {

    /* renamed from: K, reason: from kotlin metadata */
    private cq binding;

    /* renamed from: L, reason: from kotlin metadata */
    private final Observer<com.tencent.sqshow.zootopia.data.f> coinUpdateObserver;

    public /* synthetic */ ShoppingCartDialogViewLand(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j jVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(ShoppingCartDialogViewLand this$0, com.tencent.sqshow.zootopia.data.f data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cq cqVar = this$0.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        CurrencyView currencyView = cqVar.f419073e;
        Intrinsics.checkNotNullExpressionValue(data, "data");
        currencyView.d(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(ShoppingCartDialogViewLand this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected TextView A0() {
        cq cqVar = this.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        TextView textView = cqVar.f419091w;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.silverText");
        return textView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected TextView B0() {
        cq cqVar = this.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        TextView textView = cqVar.f419092x;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.totalNumsText");
        return textView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected TextView C0() {
        cq cqVar = this.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        TextView textView = cqVar.f419071c;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.bugBtn");
        return textView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected LinearLayout D0() {
        cq cqVar = this.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        LinearLayout linearLayout = cqVar.f419075g;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.currencyStrategyContainer");
        return linearLayout;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected boolean F() {
        return true;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    public void N0() {
        super.N0();
        if (getMChannel().getLifecycleOwner() != null) {
            gb4.a.f401894a.b().removeObserver(this.coinUpdateObserver);
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected ImageView j0() {
        cq cqVar = this.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        ImageView imageView = cqVar.f419070b;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.addImage");
        return imageView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected ImageView l0() {
        cq cqVar = this.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        ImageView imageView = cqVar.f419076h;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.dialogCloseBtn");
        return imageView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView, com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected View m() {
        cq g16 = cq.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.binding = g16;
        F0(1);
        getControl().E(true);
        C();
        cq cqVar = this.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        LinearLayout mRv = cqVar.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        return mRv;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected CurrencyView m0() {
        cq cqVar = this.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        return cqVar.f419073e;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected LinearLayout o0() {
        cq cqVar = this.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        LinearLayout linearLayout = cqVar.f419074f;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.currencyContainer");
        return linearLayout;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView, com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView, ga4.g
    public void onDismiss() {
        super.onDismiss();
        setTitleVisible(false);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected ImageView p0() {
        cq cqVar = this.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        return cqVar.f419077i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    public TextView q0() {
        cq cqVar = this.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        TextView textView = cqVar.f419078j;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.dialogCurrencyStrategy");
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    public int r() {
        return Color.parseColor("#00000000");
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected TextView r0() {
        cq cqVar = this.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        TextView textView = cqVar.f419083o;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.goalText");
        return textView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected ImageView s0() {
        cq cqVar = this.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        ImageView imageView = cqVar.f419082n;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.goalIcon");
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    public int t() {
        return -1;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected RecyclerView t0() {
        cq cqVar = this.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        RecyclerView recyclerView = cqVar.f419084p;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.goodsList");
        return recyclerView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected AvatarPanelErrorView v0() {
        cq cqVar = this.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        AvatarPanelErrorView avatarPanelErrorView = cqVar.f419086r;
        Intrinsics.checkNotNullExpressionValue(avatarPanelErrorView, "binding.loadErrorView");
        return avatarPanelErrorView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected ShimmerLinearLayout w0() {
        cq cqVar = this.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        ShimmerLinearLayout shimmerLinearLayout = cqVar.f419087s.f419190b;
        Intrinsics.checkNotNullExpressionValue(shimmerLinearLayout, "binding.loadingShimmerView.avatarCartWaitingView");
        return shimmerLinearLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    public int x() {
        return 3;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected FrameLayout x0() {
        cq cqVar = this.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        FrameLayout frameLayout = cqVar.f419088t;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingStatusView");
        return frameLayout;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected AvatarGlobalLoadingView y0() {
        cq cqVar = this.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        AvatarGlobalLoadingView avatarGlobalLoadingView = cqVar.f419081m;
        Intrinsics.checkNotNullExpressionValue(avatarGlobalLoadingView, "binding.globalLoadingView");
        return avatarGlobalLoadingView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected ImageView z0() {
        cq cqVar = this.binding;
        if (cqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cqVar = null;
        }
        ImageView imageView = cqVar.f419090v;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.silverIcon");
        return imageView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShoppingCartDialogViewLand(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        super(context, attributeSet, i3, channel);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.coinUpdateObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.views.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ShoppingCartDialogViewLand.X0(ShoppingCartDialogViewLand.this, (com.tencent.sqshow.zootopia.data.f) obj);
            }
        };
    }

    private final void C() {
        setTitleVisible(false);
        cq cqVar = null;
        yb4.e.g(yb4.e.f450058a, null, 0, 3, null);
        LifecycleOwner lifecycleOwner = getMChannel().getLifecycleOwner();
        if (lifecycleOwner != null) {
            gb4.a.f401894a.b().observe(lifecycleOwner, this.coinUpdateObserver);
        }
        cq cqVar2 = this.binding;
        if (cqVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cqVar = cqVar2;
        }
        cqVar.f419089u.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.views.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShoppingCartDialogViewLand.Y0(ShoppingCartDialogViewLand.this, view);
            }
        });
    }
}

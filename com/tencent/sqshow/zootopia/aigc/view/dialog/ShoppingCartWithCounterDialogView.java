package com.tencent.sqshow.zootopia.aigc.view.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.aigc.view.dialog.ShoppingCartWithCounterDialogView;
import com.tencent.sqshow.zootopia.card.view.widget.CurrencyView;
import com.tencent.sqshow.zootopia.nativeui.data.c;
import com.tencent.sqshow.zootopia.nativeui.data.j;
import com.tencent.sqshow.zootopia.nativeui.dialog.views.ShoppingCartControl;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarGlobalLoadingView;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarPanelErrorView;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import com.tencent.sqshow.zootopia.utils.aa;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import n74.cs;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u00017B-\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00103\u001a\u000202\u0012\u0006\u0010)\u001a\u00020$\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\tH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014J\b\u0010\u000f\u001a\u00020\tH\u0014J\b\u0010\u0010\u001a\u00020\u000bH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0013\u001a\u00020\tH\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u0018\u001a\u00020\tH\u0014J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\b\u0010\u001e\u001a\u00020\u001dH\u0014J\b\u0010\u001f\u001a\u00020\u000bH\u0014J\b\u0010 \u001a\u00020\u0011H\u0014J\n\u0010\"\u001a\u0004\u0018\u00010!H\u0014J\n\u0010#\u001a\u0004\u0018\u00010\u000bH\u0014R\u0017\u0010)\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00068"}, d2 = {"Lcom/tencent/sqshow/zootopia/aigc/view/dialog/ShoppingCartWithCounterDialogView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/ShoppingCartDialogView;", "", "X0", "Luv4/az;", "storeItem", "Z0", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "A0", "Landroid/widget/ImageView;", "z0", "r0", "s0", "q0", "j0", "Landroid/widget/LinearLayout;", "D0", "C0", "Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarPanelErrorView;", "v0", "Landroidx/recyclerview/widget/RecyclerView;", "t0", "B0", "Lcom/tencent/sqshow/zootopia/portal/shimmer/ShimmerLinearLayout;", "w0", "Landroid/widget/FrameLayout;", "x0", "Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarGlobalLoadingView;", "y0", "l0", "o0", "Lcom/tencent/sqshow/zootopia/card/view/widget/CurrencyView;", "m0", "p0", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "K", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "W0", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "Ln74/cs;", "L", "Ln74/cs;", "shopCartBinding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "M", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ShoppingCartWithCounterDialogView extends ShoppingCartDialogView {

    /* renamed from: K, reason: from kotlin metadata */
    private final j channel;

    /* renamed from: L, reason: from kotlin metadata */
    private cs shopCartBinding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/aigc/view/dialog/ShoppingCartWithCounterDialogView$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "count", "", "b", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements e<Long> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(long j3, ShoppingCartWithCounterDialogView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            c.f370920a.j().e(Long.valueOf(j3));
            j channel = this$0.getChannel();
            AvatarGlobalLoadingView fullScreenLoadingView = channel.getFullScreenLoadingView();
            if (fullScreenLoadingView != null) {
                fullScreenLoadingView.e();
            }
            channel.X(null);
            channel.getDialogController().d();
        }

        public void b(final long count) {
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final ShoppingCartWithCounterDialogView shoppingCartWithCounterDialogView = ShoppingCartWithCounterDialogView.this;
            uIHandler.post(new Runnable() { // from class: y74.b
                @Override // java.lang.Runnable
                public final void run() {
                    ShoppingCartWithCounterDialogView.b.c(count, shoppingCartWithCounterDialogView);
                }
            });
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ShoppingCartWithCounterDialogView", 1, "buy coupon failed, errorCode: " + error + ", errMsg: " + message);
            AvatarGlobalLoadingView fullScreenLoadingView = ShoppingCartWithCounterDialogView.this.getChannel().getFullScreenLoadingView();
            if (fullScreenLoadingView != null) {
                fullScreenLoadingView.e();
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public /* bridge */ /* synthetic */ void onResultSuccess(Long l3) {
            b(l3.longValue());
        }
    }

    public /* synthetic */ ShoppingCartWithCounterDialogView(Context context, AttributeSet attributeSet, int i3, j jVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, jVar);
    }

    private final void X0() {
        aa.d(C0(), new View.OnClickListener() { // from class: y74.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShoppingCartWithCounterDialogView.Y0(ShoppingCartWithCounterDialogView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(ShoppingCartWithCounterDialogView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AvatarGlobalLoadingView fullScreenLoadingView = this$0.channel.getFullScreenLoadingView();
        if (fullScreenLoadingView != null) {
            fullScreenLoadingView.h(500L);
        }
        ShoppingCartControl control = this$0.getControl();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        control.x(it, new b());
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected TextView A0() {
        cs csVar = this.shopCartBinding;
        if (csVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopCartBinding");
            csVar = null;
        }
        TextView textView = csVar.f419140t;
        Intrinsics.checkNotNullExpressionValue(textView, "shopCartBinding.silverText");
        return textView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected TextView B0() {
        cs csVar = this.shopCartBinding;
        if (csVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopCartBinding");
            csVar = null;
        }
        TextView textView = csVar.f419141u;
        Intrinsics.checkNotNullExpressionValue(textView, "shopCartBinding.totalNumsText");
        return textView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected TextView C0() {
        cs csVar = this.shopCartBinding;
        if (csVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopCartBinding");
            csVar = null;
        }
        TextView textView = csVar.f419123c;
        Intrinsics.checkNotNullExpressionValue(textView, "shopCartBinding.bugBtn");
        return textView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected LinearLayout D0() {
        cs csVar = this.shopCartBinding;
        if (csVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopCartBinding");
            csVar = null;
        }
        LinearLayout linearLayout = csVar.f419126f;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "shopCartBinding.currencyStrategyContainer");
        return linearLayout;
    }

    /* renamed from: W0, reason: from getter */
    public final j getChannel() {
        return this.channel;
    }

    public final void Z0(az storeItem) {
        getControl().h(storeItem);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected ImageView j0() {
        cs csVar = this.shopCartBinding;
        if (csVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopCartBinding");
            csVar = null;
        }
        ImageView imageView = csVar.f419122b;
        Intrinsics.checkNotNullExpressionValue(imageView, "shopCartBinding.addImage");
        return imageView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected ImageView l0() {
        cs csVar = this.shopCartBinding;
        if (csVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopCartBinding");
            csVar = null;
        }
        ImageView imageView = csVar.f419127g;
        Intrinsics.checkNotNullExpressionValue(imageView, "shopCartBinding.dialogCloseBtn");
        return imageView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView, com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected View m() {
        cs g16 = cs.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.shopCartBinding = g16;
        F0(3);
        X0();
        cs csVar = this.shopCartBinding;
        if (csVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopCartBinding");
            csVar = null;
        }
        ConstraintLayout mContainer = csVar.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "shopCartBinding.root");
        return mContainer;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected CurrencyView m0() {
        return null;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected LinearLayout o0() {
        cs csVar = this.shopCartBinding;
        if (csVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopCartBinding");
            csVar = null;
        }
        LinearLayout linearLayout = csVar.f419125e;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "shopCartBinding.currencyContainer");
        return linearLayout;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected ImageView p0() {
        cs csVar = this.shopCartBinding;
        if (csVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopCartBinding");
            csVar = null;
        }
        return csVar.f419128h;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected TextView q0() {
        cs csVar = this.shopCartBinding;
        if (csVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopCartBinding");
            csVar = null;
        }
        TextView textView = csVar.f419129i;
        Intrinsics.checkNotNullExpressionValue(textView, "shopCartBinding.dialogCurrencyStrategy");
        return textView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected TextView r0() {
        cs csVar = this.shopCartBinding;
        if (csVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopCartBinding");
            csVar = null;
        }
        TextView textView = csVar.f419134n;
        Intrinsics.checkNotNullExpressionValue(textView, "shopCartBinding.goalText");
        return textView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected ImageView s0() {
        cs csVar = this.shopCartBinding;
        if (csVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopCartBinding");
            csVar = null;
        }
        ImageView imageView = csVar.f419133m;
        Intrinsics.checkNotNullExpressionValue(imageView, "shopCartBinding.goalIcon");
        return imageView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected RecyclerView t0() {
        cs csVar = this.shopCartBinding;
        if (csVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopCartBinding");
            csVar = null;
        }
        RecyclerView recyclerView = csVar.f419135o;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "shopCartBinding.goodsList");
        return recyclerView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected AvatarPanelErrorView v0() {
        cs csVar = this.shopCartBinding;
        if (csVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopCartBinding");
            csVar = null;
        }
        AvatarPanelErrorView avatarPanelErrorView = csVar.f419136p;
        Intrinsics.checkNotNullExpressionValue(avatarPanelErrorView, "shopCartBinding.loadErrorView");
        return avatarPanelErrorView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected ShimmerLinearLayout w0() {
        cs csVar = this.shopCartBinding;
        if (csVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopCartBinding");
            csVar = null;
        }
        ShimmerLinearLayout shimmerLinearLayout = csVar.f419137q.f419188b;
        Intrinsics.checkNotNullExpressionValue(shimmerLinearLayout, "shopCartBinding.loadingS\u2026iew.avatarCartWaitingView");
        return shimmerLinearLayout;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected FrameLayout x0() {
        cs csVar = this.shopCartBinding;
        if (csVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopCartBinding");
            csVar = null;
        }
        FrameLayout frameLayout = csVar.f419138r;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "shopCartBinding.loadingStatusView");
        return frameLayout;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected AvatarGlobalLoadingView y0() {
        cs csVar = this.shopCartBinding;
        if (csVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopCartBinding");
            csVar = null;
        }
        AvatarGlobalLoadingView avatarGlobalLoadingView = csVar.f419132l;
        Intrinsics.checkNotNullExpressionValue(avatarGlobalLoadingView, "shopCartBinding.globalLoadingView");
        return avatarGlobalLoadingView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected ImageView z0() {
        cs csVar = this.shopCartBinding;
        if (csVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopCartBinding");
            csVar = null;
        }
        ImageView imageView = csVar.f419139s;
        Intrinsics.checkNotNullExpressionValue(imageView, "shopCartBinding.silverIcon");
        return imageView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShoppingCartWithCounterDialogView(Context context, AttributeSet attributeSet, int i3, j channel) {
        super(context, attributeSet, i3, channel);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
    }
}

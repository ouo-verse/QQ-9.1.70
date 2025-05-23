package com.tencent.qqnt.qwallet.aio.pay;

import android.content.Context;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0002H\u0014R\u001b\u0010\f\u001a\u00020\u00078VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/pay/AAPayMsgView;", "Lcom/tencent/qqnt/qwallet/aio/pay/PaymentView;", "", "D0", "onResume", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/qqnt/qwallet/aio/pay/b;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "I0", "()Lcom/tencent/qqnt/qwallet/aio/pay/b;", "viewModel", "", "G", "I", "F0", "()I", "iconResId", "H", "E0", "bgColor", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AAPayMsgView extends PaymentView {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private final int iconResId;

    /* renamed from: H, reason: from kotlin metadata */
    private final int bgColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AAPayMsgView(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.qqnt.qwallet.aio.pay.AAPayMsgView$viewModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final b invoke() {
                return new b();
            }
        });
        this.viewModel = lazy;
        this.iconResId = R.drawable.oth;
        this.bgColor = R.color.cmo;
    }

    @Override // com.tencent.qqnt.qwallet.aio.pay.PaymentView
    protected void D0() {
        W0().e2();
    }

    @Override // com.tencent.qqnt.qwallet.aio.pay.PaymentView
    /* renamed from: E0, reason: from getter */
    public int getBgColor() {
        return this.bgColor;
    }

    @Override // com.tencent.qqnt.qwallet.aio.pay.PaymentView
    /* renamed from: F0, reason: from getter */
    public int getIconResId() {
        return this.iconResId;
    }

    @Override // com.tencent.qqnt.qwallet.aio.pay.PaymentView
    @NotNull
    /* renamed from: I0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public b G0() {
        return (b) this.viewModel.getValue();
    }

    @Override // com.tencent.qqnt.qwallet.aio.pay.PaymentView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        W0().h2();
        ux3.d.INSTANCE.c(221007, W0().getPushCallback());
    }

    @Override // com.tencent.qqnt.qwallet.aio.pay.PaymentView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ux3.d.INSTANCE.g(221007, W0().getPushCallback());
    }

    @Override // com.tencent.qqnt.qwallet.aio.pay.PaymentView
    protected void onResume() {
        super.onResume();
        W0().onResume();
    }
}

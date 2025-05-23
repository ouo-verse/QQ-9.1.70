package com.tencent.qqnt.qwallet.aio.hb;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.qwallet.aio.AIOContentView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014R\u001b\u0010\r\u001a\u00020\b8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/hb/UnsupportedView;", "Lcom/tencent/qqnt/qwallet/aio/AIOContentView;", "Landroid/content/Context;", "context", "", "D0", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/qqnt/qwallet/aio/hb/s;", "e", "Lkotlin/Lazy;", "H0", "()Lcom/tencent/qqnt/qwallet/aio/hb/s;", "viewModel", "", "f", "G0", "()I", "verticalPadding", tl.h.F, "F0", "horizontalPadding", "Landroidx/lifecycle/Observer;", "", "i", "Landroidx/lifecycle/Observer;", "bindObserver", "<init>", "(Landroid/content/Context;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class UnsupportedView extends AIOContentView {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy verticalPadding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy horizontalPadding;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Boolean> bindObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnsupportedView(@NotNull final Context context) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<s>() { // from class: com.tencent.qqnt.qwallet.aio.hb.UnsupportedView$viewModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final s invoke() {
                return new s();
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.qqnt.qwallet.aio.hb.UnsupportedView$verticalPadding$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ViewUtils.dip2px(16.0f));
            }
        });
        this.verticalPadding = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.qqnt.qwallet.aio.hb.UnsupportedView$horizontalPadding$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ViewUtils.dip2px(19.0f));
            }
        });
        this.horizontalPadding = lazy3;
        this.bindObserver = new Observer() { // from class: com.tencent.qqnt.qwallet.aio.hb.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UnsupportedView.E0(UnsupportedView.this, context, (Boolean) obj);
            }
        };
    }

    private final void D0(Context context) {
        int i3;
        int i16;
        boolean isSelf = W0().M1().getIsSelf();
        TextView textView = new TextView(context);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.setClickable(false);
        textView.setFocusable(false);
        textView.setTextSize(2, 17.0f);
        if (isSelf) {
            i3 = R.color.skin_chat_buble_mine;
        } else {
            i3 = R.color.skin_chat_buble;
        }
        textView.setTextColor(context.getResources().getColorStateList(i3));
        if (isSelf) {
            i16 = R.drawable.skin_aio_user_bubble_nor_simple;
        } else {
            i16 = R.drawable.skin_aio_friend_bubble_nor_simple;
        }
        textView.setBackgroundResource(i16);
        textView.setPadding(F0(), G0(), F0(), G0());
        textView.setText("\u6682\u4e0d\u652f\u6301\u7684\u7ea2\u5305\u7c7b\u578b");
        removeAllViews();
        addView(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(UnsupportedView this$0, Context context, Boolean bound) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullExpressionValue(bound, "bound");
        if (bound.booleanValue()) {
            this$0.D0(context);
        }
    }

    private final int F0() {
        return ((Number) this.horizontalPadding.getValue()).intValue();
    }

    private final int G0() {
        return ((Number) this.verticalPadding.getValue()).intValue();
    }

    @Override // com.tencent.qqnt.qwallet.aio.AIOContentView
    @NotNull
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public s W0() {
        return (s) this.viewModel.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        W0().Q1().observeForever(this.bindObserver);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        W0().Q1().removeObserver(this.bindObserver);
    }
}

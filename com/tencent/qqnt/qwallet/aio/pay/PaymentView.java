package com.tencent.qqnt.qwallet.aio.pay;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qwallet.aio.AIOContentView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00011B\u000f\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0005\u001a\u00020\u0003H\u0015J\b\u0010\u0006\u001a\u00020\u0003H\u0014J\b\u0010\u0007\u001a\u00020\u0003H\u0014R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020&8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010(\u00a8\u00062"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/pay/PaymentView;", "Lcom/tencent/qqnt/qwallet/aio/AIOContentView;", "Landroidx/lifecycle/LifecycleObserver;", "", "D0", "onResume", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "paymentIcon", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "paymentTitle", tl.h.F, "paymentSubTitle", "i", "paymentType", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "maskView", "Lmqq/util/WeakReference;", "Landroidx/lifecycle/Lifecycle;", BdhLogUtil.LogTag.Tag_Conn, "Lmqq/util/WeakReference;", "lifecycleWeak", "Landroidx/lifecycle/Observer;", "Lcom/tencent/qqnt/qwallet/aio/pay/g;", "D", "Landroidx/lifecycle/Observer;", "paymentDataObserver", "Lcom/tencent/qqnt/qwallet/aio/pay/j;", "G0", "()Lcom/tencent/qqnt/qwallet/aio/pay/j;", "viewModel", "", "F0", "()I", "iconResId", "E0", "bgColor", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "E", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class PaymentView extends AIOContentView implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private WeakReference<Lifecycle> lifecycleWeak;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Observer<PaymentData> paymentDataObserver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView paymentIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView paymentTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView paymentSubTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView paymentType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View maskView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentView(@NotNull final Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.mobileqq.qwallet.utils.m mVar = com.tencent.mobileqq.qwallet.utils.m.f279290a;
        int min = Math.min(mVar.b(context, R.dimen.cxs), a.C7329a.f192417a.f(true));
        int b16 = mVar.b(context, R.dimen.cxr);
        int b17 = mVar.b(context, R.dimen.ciw);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(min, b16);
        marginLayoutParams.setMargins(b17, b17, b17, b17);
        setLayoutParams(marginLayoutParams);
        View.inflate(context, R.layout.hjx, this);
        View findViewById = findViewById(R.id.f230905h);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.payment_icon)");
        this.paymentIcon = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.f234506g);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.payment_title)");
        this.paymentTitle = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f234406f);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.payment_sub_title)");
        this.paymentSubTitle = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f234606h);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.payment_type)");
        this.paymentType = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f232005s);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.payment_mask_view)");
        this.maskView = findViewById5;
        com.tencent.mobileqq.qwallet.k.d(this, 0L, new Function0<Unit>() { // from class: com.tencent.qqnt.qwallet.aio.pay.PaymentView.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Pair<String, Intent> R1 = PaymentView.this.G0().R1();
                if (R1 != null) {
                    RouteUtils.startActivity(context, R1.getSecond(), R1.getFirst());
                }
                PaymentView.this.D0();
            }
        }, 1, null);
        this.paymentDataObserver = new Observer() { // from class: com.tencent.qqnt.qwallet.aio.pay.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PaymentView.H0(PaymentView.this, context, (PaymentData) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(PaymentView this$0, Context context, PaymentData paymentData) {
        int iconResId;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        QLog.i(this$0.getTAG(), 1, "update data: title=" + paymentData.getTitle() + " mask = " + paymentData.getIsShowMask());
        this$0.paymentTitle.setText(paymentData.getTitle());
        this$0.paymentSubTitle.setText(paymentData.getSubtitle());
        this$0.paymentType.setText(paymentData.getType());
        ImageView imageView = this$0.paymentIcon;
        Integer stateIconResId = paymentData.getStateIconResId();
        if (stateIconResId != null) {
            iconResId = stateIconResId.intValue();
        } else {
            iconResId = this$0.getIconResId();
        }
        imageView.setImageResource(iconResId);
        if (paymentData.getIsShowMask()) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(context.getColor(R.color.cn6));
            gradientDrawable.setCornerRadius(context.getResources().getDimension(R.dimen.cix));
            this$0.maskView.setBackground(gradientDrawable);
        } else {
            this$0.maskView.setBackground(null);
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(context.getColor(this$0.getBgColor()));
        gradientDrawable2.setCornerRadius(context.getResources().getDimension(R.dimen.cix));
        this$0.setBackground(gradientDrawable2);
    }

    /* renamed from: E0 */
    public abstract int getBgColor();

    /* renamed from: F0 */
    public abstract int getIconResId();

    @NotNull
    public abstract j G0();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Lifecycle lifecycle;
        Lifecycle lifecycle2;
        super.onAttachedToWindow();
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this);
        if (lifecycleOwner != null) {
            lifecycle = lifecycleOwner.getLifecycle();
        } else {
            lifecycle = null;
        }
        if (lifecycle != null) {
            lifecycle.addObserver(this);
            this.lifecycleWeak = new WeakReference<>(lifecycle);
        } else {
            WeakReference<Lifecycle> weakReference = this.lifecycleWeak;
            if (weakReference != null && (lifecycle2 = weakReference.get()) != null) {
                lifecycle2.addObserver(this);
            }
        }
        G0().S1().observeForever(this.paymentDataObserver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Lifecycle lifecycle;
        super.onDetachedFromWindow();
        WeakReference<Lifecycle> weakReference = this.lifecycleWeak;
        if (weakReference != null) {
            lifecycle = weakReference.get();
        } else {
            lifecycle = null;
        }
        if (lifecycle != null) {
            lifecycle.removeObserver(this);
        } else {
            QLog.e(getTAG(), 1, "onDetachedFromWindow lifecycle is null");
        }
        G0().S1().removeObserver(this.paymentDataObserver);
    }

    protected void D0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
    }
}

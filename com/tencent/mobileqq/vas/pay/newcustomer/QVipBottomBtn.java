package com.tencent.mobileqq.vas.pay.newcustomer;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eB\u001b\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\r\u0010\u0011B#\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\r\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipBottomBtn;", "Landroid/widget/FrameLayout;", "", "a", "Landroid/view/View$OnClickListener;", "click", "setGotoOfficialWebBtnClick", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "gotoOfficialWebBtn", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QVipBottomBtn extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView gotoOfficialWebBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipBottomBtn(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setPadding(com.tencent.mobileqq.vas.pay.page.o.i(16), com.tencent.mobileqq.vas.pay.page.o.i(12), com.tencent.mobileqq.vas.pay.page.o.i(16), com.tencent.mobileqq.vas.pay.page.o.i(30));
        a();
        this.gotoOfficialWebBtn = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6552396, new FrameLayout.LayoutParams(-1, com.tencent.mobileqq.vas.pay.page.o.i(45)), new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipBottomBtn$gotoOfficialWebBtn$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipBottomBtn.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipBottomBtn$gotoOfficialWebBtn$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setText(text.getContext().getString(R.string.f2173160o));
                        text.setTextColor(Color.parseColor("#9A6310"));
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(17));
                        text.setBackgroundResource(R.drawable.l7s);
                        text.setGravity(17);
                    }
                });
            }
        });
    }

    public final void a() {
        setBackgroundColor(com.tencent.mobileqq.vas.pay.page.o.f("#e9ffffff", "#2A2A2A"));
    }

    public final void setGotoOfficialWebBtnClick(@NotNull View.OnClickListener click) {
        Intrinsics.checkNotNullParameter(click, "click");
        this.gotoOfficialWebBtn.setOnClickListener(click);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipBottomBtn(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setPadding(com.tencent.mobileqq.vas.pay.page.o.i(16), com.tencent.mobileqq.vas.pay.page.o.i(12), com.tencent.mobileqq.vas.pay.page.o.i(16), com.tencent.mobileqq.vas.pay.page.o.i(30));
        a();
        this.gotoOfficialWebBtn = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6552396, new FrameLayout.LayoutParams(-1, com.tencent.mobileqq.vas.pay.page.o.i(45)), new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipBottomBtn$gotoOfficialWebBtn$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipBottomBtn.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipBottomBtn$gotoOfficialWebBtn$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setText(text.getContext().getString(R.string.f2173160o));
                        text.setTextColor(Color.parseColor("#9A6310"));
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(17));
                        text.setBackgroundResource(R.drawable.l7s);
                        text.setGravity(17);
                    }
                });
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipBottomBtn(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setPadding(com.tencent.mobileqq.vas.pay.page.o.i(16), com.tencent.mobileqq.vas.pay.page.o.i(12), com.tencent.mobileqq.vas.pay.page.o.i(16), com.tencent.mobileqq.vas.pay.page.o.i(30));
        a();
        this.gotoOfficialWebBtn = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6552396, new FrameLayout.LayoutParams(-1, com.tencent.mobileqq.vas.pay.page.o.i(45)), new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipBottomBtn$gotoOfficialWebBtn$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipBottomBtn.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipBottomBtn$gotoOfficialWebBtn$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setText(text.getContext().getString(R.string.f2173160o));
                        text.setTextColor(Color.parseColor("#9A6310"));
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(17));
                        text.setBackgroundResource(R.drawable.l7s);
                        text.setGravity(17);
                    }
                });
            }
        });
    }
}

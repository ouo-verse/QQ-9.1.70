package com.tencent.mobileqq.vas.pay.newcustomer;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017B\u001b\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u0016\u0010\u001aB#\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u0016\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerPayListTitle;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "initView", "z0", "", "title", "setTitle", "subtitle", "setSubtitle", "Landroid/view/View;", "d", "Landroid/view/View;", "shadowView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "titleTv", "f", "subtitleTv", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QVipNewCustomerPayListTitle extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View shadowView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView titleTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView subtitleTv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipNewCustomerPayListTitle(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.shadowView = com.tencent.mobileqq.vas.pay.page.o.c(this, new ConstraintLayout.LayoutParams(-1, com.tencent.mobileqq.vas.pay.page.o.i(287)), new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPayListTitle$shadowView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.w(QVipNewCustomerPayListTitle.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPayListTitle$shadowView$1.1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(16);
        layoutParams.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(16));
        Unit unit = Unit.INSTANCE;
        this.titleTv = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f655839b, layoutParams, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPayListTitle$titleTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipNewCustomerPayListTitle.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPayListTitle$titleTv$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextColor(Color.parseColor("#000000"));
                        text.setMaxLines(1);
                        text.getPaint().setFakeBoldText(true);
                        text.setTypeface(Typeface.SANS_SERIF);
                        text.setSingleLine(true);
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(21));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, com.tencent.mobileqq.vas.pay.page.o.i(20));
        layoutParams2.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(4));
        layoutParams2.startToEnd = R.id.f655839b;
        layoutParams2.topToTop = R.id.f655839b;
        layoutParams2.bottomToBottom = R.id.f655839b;
        this.subtitleTv = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f655739a, layoutParams2, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPayListTitle$subtitleTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipNewCustomerPayListTitle.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPayListTitle$subtitleTv$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setPadding(com.tencent.mobileqq.vas.pay.page.o.i(3), 0, com.tencent.mobileqq.vas.pay.page.o.i(6), 0);
                        text.setBackground(URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/82575c95-1d4e-40b3-8826-3d5be7b5a266.png", URLDrawable.URLDrawableOptions.obtain()));
                        text.setGravity(17);
                        text.setTextColor(Color.parseColor("#FFFFFF"));
                        text.setMaxLines(1);
                        text.setSingleLine(true);
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(12));
                    }
                });
            }
        });
        initView();
    }

    public final void initView() {
        String string = getContext().getString(R.string.f2173760u);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026w_customer_svip_discount)");
        setTitle(string);
        String string2 = getContext().getString(R.string.f2173460r);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026only_one_time_per_person)");
        setSubtitle(string2);
        z0();
    }

    public final void setSubtitle(@NotNull String subtitle) {
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        if (TextUtils.isEmpty(subtitle)) {
            this.subtitleTv.setVisibility(8);
        } else {
            this.subtitleTv.setVisibility(0);
        }
        this.subtitleTv.setText(subtitle);
        if (subtitle.length() <= 6) {
            TextView textView = this.subtitleTv;
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = com.tencent.mobileqq.vas.pay.page.o.i(92);
            textView.setLayoutParams(layoutParams);
            return;
        }
        TextView textView2 = this.subtitleTv;
        ViewGroup.LayoutParams layoutParams2 = textView2.getLayoutParams();
        layoutParams2.width = com.tencent.mobileqq.vas.pay.page.o.i(92) + ((subtitle.length() - 6) * com.tencent.mobileqq.vas.pay.page.o.i(12));
        textView2.setLayoutParams(layoutParams2);
    }

    public final void setTitle(@NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        if (TextUtils.isEmpty(title)) {
            this.titleTv.setVisibility(8);
        } else {
            this.titleTv.setVisibility(0);
        }
        this.titleTv.setText(title);
    }

    public final void z0() {
        Drawable drawable = BaseApplication.context.getDrawable(R.drawable.l7t);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        if (com.tencent.mobileqq.vas.pay.page.o.n()) {
            this.shadowView.setBackground(URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/ca7ad1fc-16d6-4c4c-8b58-5ec3b36ebb96.png", obtain));
        } else {
            this.shadowView.setBackground(URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/8a2ceb10-cde8-4634-b34e-a509a012e9fa.png", obtain));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipNewCustomerPayListTitle(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.shadowView = com.tencent.mobileqq.vas.pay.page.o.c(this, new ConstraintLayout.LayoutParams(-1, com.tencent.mobileqq.vas.pay.page.o.i(287)), new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPayListTitle$shadowView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.w(QVipNewCustomerPayListTitle.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPayListTitle$shadowView$1.1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(16);
        layoutParams.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(16));
        Unit unit = Unit.INSTANCE;
        this.titleTv = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f655839b, layoutParams, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPayListTitle$titleTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipNewCustomerPayListTitle.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPayListTitle$titleTv$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextColor(Color.parseColor("#000000"));
                        text.setMaxLines(1);
                        text.getPaint().setFakeBoldText(true);
                        text.setTypeface(Typeface.SANS_SERIF);
                        text.setSingleLine(true);
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(21));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, com.tencent.mobileqq.vas.pay.page.o.i(20));
        layoutParams2.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(4));
        layoutParams2.startToEnd = R.id.f655839b;
        layoutParams2.topToTop = R.id.f655839b;
        layoutParams2.bottomToBottom = R.id.f655839b;
        this.subtitleTv = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f655739a, layoutParams2, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPayListTitle$subtitleTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipNewCustomerPayListTitle.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPayListTitle$subtitleTv$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setPadding(com.tencent.mobileqq.vas.pay.page.o.i(3), 0, com.tencent.mobileqq.vas.pay.page.o.i(6), 0);
                        text.setBackground(URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/82575c95-1d4e-40b3-8826-3d5be7b5a266.png", URLDrawable.URLDrawableOptions.obtain()));
                        text.setGravity(17);
                        text.setTextColor(Color.parseColor("#FFFFFF"));
                        text.setMaxLines(1);
                        text.setSingleLine(true);
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(12));
                    }
                });
            }
        });
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipNewCustomerPayListTitle(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.shadowView = com.tencent.mobileqq.vas.pay.page.o.c(this, new ConstraintLayout.LayoutParams(-1, com.tencent.mobileqq.vas.pay.page.o.i(287)), new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPayListTitle$shadowView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.w(QVipNewCustomerPayListTitle.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPayListTitle$shadowView$1.1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(16);
        layoutParams.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(16));
        Unit unit = Unit.INSTANCE;
        this.titleTv = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f655839b, layoutParams, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPayListTitle$titleTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipNewCustomerPayListTitle.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPayListTitle$titleTv$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextColor(Color.parseColor("#000000"));
                        text.setMaxLines(1);
                        text.getPaint().setFakeBoldText(true);
                        text.setTypeface(Typeface.SANS_SERIF);
                        text.setSingleLine(true);
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(21));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, com.tencent.mobileqq.vas.pay.page.o.i(20));
        layoutParams2.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(4));
        layoutParams2.startToEnd = R.id.f655839b;
        layoutParams2.topToTop = R.id.f655839b;
        layoutParams2.bottomToBottom = R.id.f655839b;
        this.subtitleTv = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f655739a, layoutParams2, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPayListTitle$subtitleTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipNewCustomerPayListTitle.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPayListTitle$subtitleTv$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setPadding(com.tencent.mobileqq.vas.pay.page.o.i(3), 0, com.tencent.mobileqq.vas.pay.page.o.i(6), 0);
                        text.setBackground(URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/82575c95-1d4e-40b3-8826-3d5be7b5a266.png", URLDrawable.URLDrawableOptions.obtain()));
                        text.setGravity(17);
                        text.setTextColor(Color.parseColor("#FFFFFF"));
                        text.setMaxLines(1);
                        text.setSingleLine(true);
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(12));
                    }
                });
            }
        });
        initView();
    }
}

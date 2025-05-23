package com.tencent.mobileqq.vas.pay.page;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015B\u001b\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0018B#\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u0014\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/QVipRenewalTitle;", "Landroid/widget/LinearLayout;", "", "a", "", "title", "setTitle", "Landroid/view/View$OnClickListener;", "leftOnClickListener", "setLeftOnClickListener", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "backBtn", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "titleTv", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QVipRenewalTitle extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView backBtn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView titleTv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipRenewalTitle(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        o.s(this, ViewUtils.getStatusBarHeight(getContext()));
        final FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, o.i(30));
        layoutParams.gravity = 16;
        layoutParams.setMarginStart(o.i(11));
        Unit unit = Unit.INSTANCE;
        this.backBtn = (ImageView) o.c(frameLayout, layoutParams, new Function0<ImageView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalTitle$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                return o.m(frameLayout, new Function1<ImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalTitle$1$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView) {
                        invoke2(imageView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull ImageView image) {
                        Intrinsics.checkNotNullParameter(image, "$this$image");
                        image.setPadding(o.i(5), o.i(5), o.i(5), o.i(5));
                    }
                });
            }
        });
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.titleTv = (TextView) o.c(frameLayout, layoutParams2, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalTitle$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(frameLayout, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalTitle$1$4.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView tv5) {
                        Intrinsics.checkNotNullParameter(tv5, "$this$tv");
                        tv5.setText(tv5.getContext().getString(R.string.f2175761d));
                        tv5.setTextSize(o.u(16));
                        tv5.setTypeface(Typeface.DEFAULT_BOLD);
                    }
                });
            }
        });
        addView(frameLayout, new LinearLayout.LayoutParams(-1, o.i(50)));
        a();
    }

    public final void a() {
        this.backBtn.setBackground(o.l(this, R.drawable.skin_header_btn_back_normal_black, R.drawable.skin_header_btn_back_normal));
        this.titleTv.setTextColor(o.e(-16777216, -1));
    }

    public final void setLeftOnClickListener(@NotNull View.OnClickListener leftOnClickListener) {
        Intrinsics.checkNotNullParameter(leftOnClickListener, "leftOnClickListener");
        this.backBtn.setOnClickListener(leftOnClickListener);
    }

    public final void setTitle(@NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.titleTv.setText(title);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipRenewalTitle(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        o.s(this, ViewUtils.getStatusBarHeight(getContext()));
        final FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, o.i(30));
        layoutParams.gravity = 16;
        layoutParams.setMarginStart(o.i(11));
        Unit unit = Unit.INSTANCE;
        this.backBtn = (ImageView) o.c(frameLayout, layoutParams, new Function0<ImageView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalTitle$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                return o.m(frameLayout, new Function1<ImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalTitle$1$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView) {
                        invoke2(imageView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull ImageView image) {
                        Intrinsics.checkNotNullParameter(image, "$this$image");
                        image.setPadding(o.i(5), o.i(5), o.i(5), o.i(5));
                    }
                });
            }
        });
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.titleTv = (TextView) o.c(frameLayout, layoutParams2, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalTitle$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(frameLayout, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalTitle$1$4.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView tv5) {
                        Intrinsics.checkNotNullParameter(tv5, "$this$tv");
                        tv5.setText(tv5.getContext().getString(R.string.f2175761d));
                        tv5.setTextSize(o.u(16));
                        tv5.setTypeface(Typeface.DEFAULT_BOLD);
                    }
                });
            }
        });
        addView(frameLayout, new LinearLayout.LayoutParams(-1, o.i(50)));
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipRenewalTitle(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        o.s(this, ViewUtils.getStatusBarHeight(getContext()));
        final FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, o.i(30));
        layoutParams.gravity = 16;
        layoutParams.setMarginStart(o.i(11));
        Unit unit = Unit.INSTANCE;
        this.backBtn = (ImageView) o.c(frameLayout, layoutParams, new Function0<ImageView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalTitle$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                return o.m(frameLayout, new Function1<ImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalTitle$1$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView) {
                        invoke2(imageView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull ImageView image) {
                        Intrinsics.checkNotNullParameter(image, "$this$image");
                        image.setPadding(o.i(5), o.i(5), o.i(5), o.i(5));
                    }
                });
            }
        });
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.titleTv = (TextView) o.c(frameLayout, layoutParams2, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalTitle$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(frameLayout, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalTitle$1$4.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView tv5) {
                        Intrinsics.checkNotNullParameter(tv5, "$this$tv");
                        tv5.setText(tv5.getContext().getString(R.string.f2175761d));
                        tv5.setTextSize(o.u(16));
                        tv5.setTypeface(Typeface.DEFAULT_BOLD);
                    }
                });
            }
        });
        addView(frameLayout, new LinearLayout.LayoutParams(-1, o.i(50)));
        a();
    }
}

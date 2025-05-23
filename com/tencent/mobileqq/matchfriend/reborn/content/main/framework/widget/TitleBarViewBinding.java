package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.carousel.CarouselLayout;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/TitleBarViewBinding;", "", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/carousel/CarouselLayout;", "a", "Lkotlin/Lazy;", "e", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/carousel/CarouselLayout;", "carouseLayout", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/MainTitleIconGroup;", "b", "f", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/MainTitleIconGroup;", "titleCenterLayout", "Landroid/widget/TextView;", "c", "g", "()Landroid/widget/TextView;", "tvOnlineTxt", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "d", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class TitleBarViewBinding {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final int f244381e = View.generateViewId();

    /* renamed from: f, reason: collision with root package name */
    private static final int f244382f = View.generateViewId();

    /* renamed from: g, reason: collision with root package name */
    private static final int f244383g = View.generateViewId();

    /* renamed from: h, reason: collision with root package name */
    private static final int f244384h = View.generateViewId();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy carouseLayout;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy titleCenterLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy tvOnlineTxt;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/TitleBarViewBinding$a;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "b", "a", "", "carouseLayoutId", "I", "centerViewId", "leftViewId", "onLineId", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.TitleBarViewBinding$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final View a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            MainTitleIconGroup mainTitleIconGroup = new MainTitleIconGroup(context);
            mainTitleIconGroup.setLayoutParams(new ViewGroup.LayoutParams(-2, o.e(36)));
            mainTitleIconGroup.setAlpha(0.0f);
            mainTitleIconGroup.setId(TitleBarViewBinding.f244382f);
            return w72.a.g(w72.a.e(w72.a.c(mainTitleIconGroup, "em_bas_immediate_matching"), null, 1, null), null, 1, null);
        }

        public final View b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setId(TitleBarViewBinding.f244381e);
            linearLayout.setGravity(16);
            CarouselLayout carouselLayout = new CarouselLayout(context);
            carouselLayout.setLayoutParams(new ViewGroup.LayoutParams(o.e(60), o.e(20)));
            carouselLayout.setId(TitleBarViewBinding.f244383g);
            linearLayout.addView(carouselLayout);
            TextView textView = new TextView(context);
            textView.setTextColor(context.getColorStateList(R.color.qui_common_text_primary));
            textView.setTextSize(2, 17.0f);
            textView.setText("22390\u4eba\u5728\u7ebf\u7ed3\u4f34");
            textView.setGravity(16);
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setId(TitleBarViewBinding.f244384h);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = o.e(6);
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(textView, layoutParams);
            return linearLayout;
        }

        Companion() {
        }
    }

    public TitleBarViewBinding(final Context context) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CarouselLayout>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.TitleBarViewBinding$carouseLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CarouselLayout invoke() {
                Context context2 = context;
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                View findViewById = ((Activity) context2).findViewById(TitleBarViewBinding.f244383g);
                if (findViewById instanceof CarouselLayout) {
                    return (CarouselLayout) findViewById;
                }
                return null;
            }
        });
        this.carouseLayout = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MainTitleIconGroup>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.TitleBarViewBinding$titleCenterLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MainTitleIconGroup invoke() {
                Context context2 = context;
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                View findViewById = ((Activity) context2).findViewById(TitleBarViewBinding.f244382f);
                if (findViewById instanceof MainTitleIconGroup) {
                    return (MainTitleIconGroup) findViewById;
                }
                return null;
            }
        });
        this.titleCenterLayout = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.TitleBarViewBinding$tvOnlineTxt$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                Context context2 = context;
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                View findViewById = ((Activity) context2).findViewById(TitleBarViewBinding.f244384h);
                if (findViewById instanceof TextView) {
                    return (TextView) findViewById;
                }
                return null;
            }
        });
        this.tvOnlineTxt = lazy3;
    }

    public final CarouselLayout e() {
        return (CarouselLayout) this.carouseLayout.getValue();
    }

    public final MainTitleIconGroup f() {
        return (MainTitleIconGroup) this.titleCenterLayout.getValue();
    }

    public final TextView g() {
        return (TextView) this.tvOnlineTxt.getValue();
    }
}

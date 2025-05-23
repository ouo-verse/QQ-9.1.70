package com.tencent.sqshow.zootopia.view.pull2refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.widget.pull2refresh.ILoadMoreLayout;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\"B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001a\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u0014\u0010\u0019\u00a8\u0006#"}, d2 = {"Lcom/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaLoadMoreView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/widget/pull2refresh/ILoadMoreLayout;", "", "f", "", "state", "", "i", "oldState", "newState", "d", "", "tipsTxt", tl.h.F, "setState", "getState", "checkState", "I", "Lcom/airbnb/lottie/LottieDrawable;", "e", "Lcom/airbnb/lottie/LottieDrawable;", ToastView.ICON_LOADING, "Ln74/f;", "Lkotlin/Lazy;", "()Ln74/f;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaLoadMoreView extends FrameLayout implements ILoadMoreLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int state;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LottieDrawable loading;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaLoadMoreView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean d(int oldState, int newState) {
        if (oldState >= 0 && oldState != 0) {
            if (oldState != 1) {
                if (oldState != 2) {
                    if (oldState != 3) {
                        if (oldState != 4) {
                            if (oldState == 5) {
                                if (newState == 0 || newState == 1 || newState == 2 || newState == 3) {
                                    return true;
                                }
                                return false;
                            }
                            return false;
                        }
                        if (newState == 0 || newState == 1 || newState == 3) {
                            return true;
                        }
                        return false;
                    }
                    if (newState == 0 || newState == 1 || newState == 2 || newState == 4 || newState == 5) {
                        return true;
                    }
                    return false;
                }
                if (newState == 0 || newState == 3 || newState == 4 || newState == 5) {
                    return true;
                }
                return false;
            }
            if (newState != 0 && newState != 3 && newState != 4 && newState != 5) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n74.f e() {
        return (n74.f) this.binding.getValue();
    }

    private final void f() {
        LottieHelper.b(getContext(), "zootopia_load_more.json", null, i.b(16), i.b(16), -1, new LottieHelper.d() { // from class: com.tencent.sqshow.zootopia.view.pull2refresh.b
            @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
            public final void onLoad(LottieDrawable lottieDrawable) {
                ZootopiaLoadMoreView.g(ZootopiaLoadMoreView.this, lottieDrawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ZootopiaLoadMoreView this$0, LottieDrawable lottieDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.loading = lottieDrawable;
        this$0.e().f419335c.setImageDrawable(lottieDrawable);
    }

    private final boolean i(final int state) {
        if (!d(this.state, state)) {
            return false;
        }
        this.state = state;
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaLoadMoreView$updateState$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                n74.f e16;
                n74.f e17;
                n74.f e18;
                LottieDrawable lottieDrawable;
                n74.f e19;
                n74.f e26;
                n74.f e27;
                LottieDrawable lottieDrawable2;
                n74.f e28;
                n74.f e29;
                n74.f e36;
                LottieDrawable lottieDrawable3;
                n74.f e37;
                n74.f e38;
                n74.f e39;
                LottieDrawable lottieDrawable4;
                int i3 = state;
                if (i3 == 0) {
                    e16 = this.e();
                    e16.f419335c.setVisibility(8);
                    e17 = this.e();
                    e17.f419336d.setVisibility(8);
                    e18 = this.e();
                    e18.f419334b.setVisibility(0);
                    lottieDrawable = this.loading;
                    if (lottieDrawable != null) {
                        lottieDrawable.stop();
                        return;
                    }
                    return;
                }
                if (i3 == 1 || i3 == 2 || i3 == 3) {
                    e19 = this.e();
                    e19.f419335c.setVisibility(0);
                    e26 = this.e();
                    e26.f419336d.setVisibility(8);
                    e27 = this.e();
                    e27.f419334b.setVisibility(8);
                    lottieDrawable2 = this.loading;
                    if (lottieDrawable2 == null || lottieDrawable2.isAnimating()) {
                        return;
                    }
                    lottieDrawable2.start();
                    return;
                }
                if (i3 == 4) {
                    e28 = this.e();
                    e28.f419335c.setVisibility(8);
                    e29 = this.e();
                    e29.f419336d.setVisibility(0);
                    e36 = this.e();
                    e36.f419334b.setVisibility(8);
                    lottieDrawable3 = this.loading;
                    if (lottieDrawable3 != null) {
                        lottieDrawable3.stop();
                        return;
                    }
                    return;
                }
                if (i3 != 5) {
                    return;
                }
                e37 = this.e();
                e37.f419335c.setVisibility(4);
                e38 = this.e();
                e38.f419336d.setVisibility(8);
                e39 = this.e();
                e39.f419334b.setVisibility(8);
                lottieDrawable4 = this.loading;
                if (lottieDrawable4 != null) {
                    lottieDrawable4.stop();
                }
            }
        });
        return true;
    }

    @Override // com.tencent.widget.pull2refresh.ILoadMoreLayout
    public boolean checkState(int state) {
        return d(this.state, state);
    }

    @Override // com.tencent.widget.pull2refresh.ILoadMoreLayout
    public int getState() {
        return this.state;
    }

    public final void h(String tipsTxt) {
        e().f419336d.setText(tipsTxt);
        e().f419336d.setPadding(0, i.b(15), 0, i.b(15));
    }

    @Override // com.tencent.widget.pull2refresh.ILoadMoreLayout
    public boolean setState(int state) {
        return i(state);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaLoadMoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZootopiaLoadMoreView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaLoadMoreView(final Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<n74.f>() { // from class: com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaLoadMoreView$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final n74.f invoke() {
                return n74.f.f(LayoutInflater.from(context), this);
            }
        });
        this.binding = lazy;
        i(0);
        f();
    }
}

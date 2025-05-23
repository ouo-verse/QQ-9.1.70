package com.tencent.mobileqq.vas.kuikly;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.qphone.base.util.QLog;
import i01.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016JI\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032+\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rj\u0004\u0018\u0001`\u0011H\u0016R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018RG\u0010 \u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rj\u0004\u0018\u0001`\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/VasNavBarView;", "Landroid/widget/FrameLayout;", "Li01/c;", "", "params", "", "a", "propKey", "", "propValue", "", "b", "method", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "d", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "getNavBar", "()Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "navBar", "e", "Lkotlin/jvm/functions/Function1;", "c", "()Lkotlin/jvm/functions/Function1;", "setClickBackCallback", "(Lkotlin/jvm/functions/Function1;)V", "clickBackCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes20.dex */
public class VasNavBarView extends FrameLayout implements i01.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUISecNavBar navBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> clickBackCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasNavBarView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        QUISecNavBar qUISecNavBar = new QUISecNavBar(context, null, 0, 6, null);
        qUISecNavBar.setLeftType(2);
        qUISecNavBar.setCenterType(1);
        qUISecNavBar.setBaseViewDescription(BaseAction.ACTION_LEFT_BUTTON, "\u8fd4\u56de");
        this.navBar = qUISecNavBar;
        addView(qUISecNavBar, -1, -2);
        if (context instanceof com.tencent.kuikly.core.render.android.j) {
            Context baseContext = ((com.tencent.kuikly.core.render.android.j) context).getBaseContext();
            Intrinsics.checkNotNull(baseContext, "null cannot be cast to non-null type android.app.Activity");
            qUISecNavBar.R((Activity) baseContext);
        }
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasNavBarView.2

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.vas.kuikly.VasNavBarView$2$a */
            /* loaded from: classes20.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f309711a;

                static {
                    int[] iArr = new int[BaseAction.values().length];
                    try {
                        iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    f309711a = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                invoke2(view, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view, @NotNull BaseAction action) {
                Function1<Object, Unit> c16;
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(action, "action");
                if (a.f309711a[action.ordinal()] != 1 || (c16 = VasNavBarView.this.c()) == null) {
                    return;
                }
                c16.invoke(null);
            }
        });
    }

    private final void a(String params) {
        QLog.d("VasDynamicView", 1, "callTestMethod: " + params);
    }

    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        if (Intrinsics.areEqual(propKey, "centerText")) {
            this.navBar.setCenterText((String) propValue);
            return true;
        }
        if (Intrinsics.areEqual(propKey, "clickBack")) {
            this.clickBackCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            return true;
        }
        return c.a.p(this, propKey, propValue);
    }

    @Nullable
    public final Function1<Object, Unit> c() {
        return this.clickBackCallback;
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
    }

    public final void setClickBackCallback(@Nullable Function1<Object, Unit> function1) {
        this.clickBackCallback = function1;
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b bVar) {
        c.a.q(this, bVar);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (!Intrinsics.areEqual(method, "test")) {
            return c.a.b(this, method, params, callback);
        }
        a(params);
        return Unit.INSTANCE;
    }
}

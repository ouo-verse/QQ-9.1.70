package com.tencent.mobileqq.vas.kuikly;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.UiThread;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasMqqView;
import com.tencent.qphone.base.util.QLog;
import i01.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00015B\u000f\u0012\u0006\u00101\u001a\u000200\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J0\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0014J\u0012\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014JI\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\b\u0018\u00010\u001dj\u0004\u0018\u0001`!H\u0016J\b\u0010#\u001a\u00020\bH\u0016R\u0016\u0010%\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R;\u0010,\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\b\u0018\u00010\u001dj\u0004\u0018\u0001`!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/VasPAPageContentView;", "Landroid/widget/RelativeLayout;", "Li01/c;", "Landroid/app/Activity;", "kotlin.jvm.PlatformType", "g", "", "param", "", "c", "callback", "d", "", "propKey", "propValue", "", "b", "changed", "", "left", "top", "right", "bottom", "onLayout", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/lang/String;", "cacheParam", "Lcom/tencent/mobileqq/vas/api/a;", "e", "Lcom/tencent/mobileqq/vas/api/a;", "arkView", "f", "Lkotlin/jvm/functions/Function1;", "arkReportCallback", tl.h.F, "Z", "isFirstLayout", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "i", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes20.dex */
public final class VasPAPageContentView extends RelativeLayout implements i01.c {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final List<Function1<Object, Unit>> f309713m = new ArrayList();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String cacheParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.vas.api.a arkView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> arkReportCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstLayout;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R;\u0010\u000e\u001a)\u0012%\u0012#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00040\tj\u0002`\r0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/VasPAPageContentView$a;", "", "", "param", "", "a", "TAG", "Ljava/lang/String;", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "arkReportCallbackList", "Ljava/util/List;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.kuikly.VasPAPageContentView$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull String param) {
            Intrinsics.checkNotNullParameter(param, "param");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", param);
            Iterator it = VasPAPageContentView.f309713m.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(jSONObject.toString());
            }
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasPAPageContentView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.cacheParam = "";
        this.isFirstLayout = true;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        IVasMqqView iVasMqqView = (IVasMqqView) QRoute.api(IVasMqqView.class);
        Activity g16 = g();
        Intrinsics.checkNotNullExpressionValue(g16, "getAct()");
        com.tencent.mobileqq.vas.api.a qQVipArkHeaderView = iVasMqqView.getQQVipArkHeaderView(g16, this.cacheParam);
        addView(qQVipArkHeaderView.getView(), layoutParams);
        this.arkView = qQVipArkHeaderView;
    }

    private final void c(Object param) {
        if (param == null) {
            return;
        }
        if (!(param instanceof String)) {
            QLog.e("VasPAPageContentView", 1, "\u53c2\u6570\u7c7b\u578b\u9519\u8bef");
        } else {
            this.cacheParam = (String) param;
        }
    }

    private final void d(Object callback) {
        Function1<Object, Unit> function1;
        boolean contains;
        if (callback == null) {
            try {
                Function1<Object, Unit> function12 = this.arkReportCallback;
                if (function12 != null) {
                    TypeIntrinsics.asMutableCollection(f309713m).remove(function12);
                }
            } catch (Exception e16) {
                QLog.e("VasPAPageContentView", 1, "arkReport exception", e16);
                return;
            }
        }
        if (TypeIntrinsics.isFunctionOfArity(callback, 1)) {
            function1 = (Function1) callback;
        } else {
            function1 = null;
        }
        this.arkReportCallback = function1;
        if (callback != null) {
            List<Function1<Object, Unit>> list = f309713m;
            contains = CollectionsKt___CollectionsKt.contains(list, callback);
            if (!contains) {
                list.add((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(callback, 1));
            }
        }
    }

    private final Activity g() {
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            return (Activity) context;
        }
        return Foreground.getTopActivity();
    }

    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        if (Intrinsics.areEqual(propKey, "arkContent")) {
            c(propValue);
        } else if (Intrinsics.areEqual(propKey, "arkReport")) {
            d(propValue);
        }
        return c.a.p(this, propKey, propValue);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable String str2, @Nullable Function1<Object, Unit> function1) {
        return c.a.b(this, str, str2, function1);
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
        com.tencent.mobileqq.vas.api.a aVar = this.arkView;
        if (aVar != null) {
            aVar.onDestory();
        }
        Function1<Object, Unit> function1 = this.arkReportCallback;
        if (function1 != null) {
            TypeIntrinsics.asMutableCollection(f309713m).remove(function1);
        }
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (this.isFirstLayout && !TextUtils.isEmpty(this.cacheParam)) {
            int i3 = right - left;
            int i16 = bottom - top;
            com.tencent.mobileqq.vas.api.a aVar = this.arkView;
            if (aVar != null) {
                String str = this.cacheParam;
                Activity g16 = g();
                Intrinsics.checkNotNullExpressionValue(g16, "getAct()");
                aVar.a(str, g16, i3, i16);
            }
            this.isFirstLayout = false;
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
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

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "arkReport")) {
            d(callback);
        }
        return c.a.a(this, method, params, callback);
    }
}

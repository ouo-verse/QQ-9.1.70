package i01;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.UiThread;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import i01.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0017J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0017J\b\u0010\n\u001a\u00020\tH\u0017J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0017J\b\u0010\u000f\u001a\u00020\u000eH\u0016JI\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032+\u0010\u0017\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\t\u0018\u00010\u0012j\u0004\u0018\u0001`\u0016H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016R\u0014\u0010 \u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR(\u0010'\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010+\u001a\u0004\u0018\u00010(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\u00a8\u0006,"}, d2 = {"Li01/c;", "Li01/a;", "", "", "propKey", "propValue", "", "b", ReportConstant.COSTREPORT_PREFIX, "", h.F, "Li01/b;", "shadow", CanvasView.ACTION_SET_SHADOW, "Landroid/view/View;", "f", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, DomainData.DOMAIN_NAME, "e", "k", "()Z", "reusable", "Lcom/tencent/kuikly/core/render/android/a;", "<anonymous parameter 0>", "getKuiklyRenderContext", "()Lcom/tencent/kuikly/core/render/android/a;", "setKuiklyRenderContext", "(Lcom/tencent/kuikly/core/render/android/a;)V", "kuiklyRenderContext", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface c extends i01.a {
    @UiThread
    boolean b(@NotNull String propKey, @NotNull Object propValue);

    @Override // i01.a
    @Nullable
    Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback);

    void e(@NotNull ViewGroup parent);

    @NotNull
    View f();

    @Override // i01.a
    @Nullable
    Activity getActivity();

    @Override // i01.a
    @Nullable
    com.tencent.kuikly.core.render.android.a getKuiklyRenderContext();

    @UiThread
    void h();

    boolean k();

    void n(@NotNull ViewGroup parent);

    @Override // i01.a
    void onDestroy();

    @UiThread
    boolean s(@NotNull String propKey);

    @Override // i01.a
    void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar);

    @UiThread
    void setShadow(@NotNull b shadow);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class a {
        @Nullable
        public static Object a(@NotNull c cVar, @NotNull String method, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
            Intrinsics.checkNotNullParameter(method, "method");
            return a.C10497a.a(cVar, method, obj, function1);
        }

        @Nullable
        public static Object b(@NotNull c cVar, @NotNull String method, @Nullable String str, @Nullable Function1<Object, Unit> function1) {
            Intrinsics.checkNotNullParameter(method, "method");
            if (method.hashCode() == 268327548 && method.equals("bringToFront")) {
                cVar.f().bringToFront();
                return Unit.INSTANCE;
            }
            return a.C10497a.b(cVar, method, str, function1);
        }

        public static void c(@NotNull c cVar, int i3, int i16, @NotNull Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            KRCSSViewExtensionKt.g(cVar.f(), canvas);
        }

        public static void d(@NotNull c cVar, int i3, int i16, @NotNull Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            KRCSSViewExtensionKt.h(cVar.f(), canvas);
        }

        @Nullable
        public static Activity e(@NotNull c cVar) {
            Context context = cVar.f().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view().context");
            return KRCSSViewExtensionKt.i(context);
        }

        @Nullable
        public static com.tencent.kuikly.core.render.android.a f(@NotNull c cVar) {
            Object context = cVar.f().getContext();
            if (!(context instanceof com.tencent.kuikly.core.render.android.a)) {
                context = null;
            }
            return (com.tencent.kuikly.core.render.android.a) context;
        }

        public static boolean g(@NotNull c cVar) {
            return false;
        }

        @Nullable
        public static ViewGroup h(@NotNull c cVar) {
            com.tencent.kuikly.core.render.android.d O0;
            com.tencent.kuikly.core.render.android.a kuiklyRenderContext = cVar.getKuiklyRenderContext();
            if (kuiklyRenderContext != null && (O0 = kuiklyRenderContext.O0()) != null) {
                return O0.getView();
            }
            return null;
        }

        public static void i(@NotNull c cVar, @NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
        }

        @UiThread
        public static void j(@NotNull c cVar) {
            a.C10497a.c(cVar);
        }

        public static void k(@NotNull c cVar) {
            a.C10497a.d(cVar);
            KRCSSViewExtensionKt.j0(cVar.f());
        }

        public static void l(@NotNull c cVar, @NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
        }

        @UiThread
        public static boolean m(@NotNull c cVar, @NotNull String propKey) {
            Intrinsics.checkNotNullParameter(propKey, "propKey");
            View f16 = cVar.f();
            KRCSSViewExtensionKt.G(f16);
            return KRCSSViewExtensionKt.J(f16, propKey);
        }

        @UiThread
        public static boolean p(@NotNull c cVar, @NotNull String propKey, @NotNull Object propValue) {
            Intrinsics.checkNotNullParameter(propKey, "propKey");
            Intrinsics.checkNotNullParameter(propValue, "propValue");
            return KRCSSViewExtensionKt.V(cVar.f(), propKey, propValue);
        }

        @UiThread
        public static void q(@NotNull c cVar, @NotNull b shadow) {
            Intrinsics.checkNotNullParameter(shadow, "shadow");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public static View r(@NotNull c cVar) {
            if (cVar != 0) {
                return (View) cVar;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }

        @UiThread
        public static void n(@NotNull c cVar) {
        }

        public static void o(@NotNull c cVar, @Nullable com.tencent.kuikly.core.render.android.a aVar) {
        }
    }
}

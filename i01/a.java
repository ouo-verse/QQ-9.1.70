package i01;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JI\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nH\u0016JI\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nH\u0016J\b\u0010\r\u001a\u00020\tH\u0017J\b\u0010\u000e\u001a\u00020\tH\u0017R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000f8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0019"}, d2 = {"Li01/a;", "", "", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/kuikly/core/render/android/a;", "getKuiklyRenderContext", "()Lcom/tencent/kuikly/core/render/android/a;", "setKuiklyRenderContext", "(Lcom/tencent/kuikly/core/render/android/a;)V", "kuiklyRenderContext", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface a {
    @Nullable
    Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback);

    @Nullable
    Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback);

    @Nullable
    Activity getActivity();

    @Nullable
    com.tencent.kuikly.core.render.android.a getKuiklyRenderContext();

    @UiThread
    void onCreate();

    @UiThread
    void onDestroy();

    void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* renamed from: i01.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C10497a {
        @Nullable
        public static Object a(@NotNull a aVar, @NotNull String method, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
            Intrinsics.checkNotNullParameter(method, "method");
            if (obj != null && !(obj instanceof String)) {
                return null;
            }
            if (!(obj instanceof String)) {
                obj = null;
            }
            return aVar.call(method, (String) obj, function1);
        }

        @Nullable
        public static Object b(@NotNull a aVar, @NotNull String method, @Nullable String str, @Nullable Function1<Object, Unit> function1) {
            Intrinsics.checkNotNullParameter(method, "method");
            return null;
        }

        @UiThread
        public static void c(@NotNull a aVar) {
        }

        @UiThread
        public static void d(@NotNull a aVar) {
        }
    }
}

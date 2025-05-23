package g01;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import d01.HRImageLoadOption;
import d01.h;
import d01.u;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002Jk\u0010\u0013\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022Q\u0010\u0012\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00040\bj\u0002`\u0011R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lg01/a;", "", "Ld01/a;", "options", "", "a", "Landroid/content/Context;", "context", "Lkotlin/Function3;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "", "errorCode", "", "errorMsg", "Lcom/tencent/kuikly/core/render/android/expand/component/image/FetchImageCallback;", "callback", "b", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "getExecuteMode", "()Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "Ljava/lang/String;", "getAssetsPath", "()Ljava/lang/String;", "assetsPath", "<init>", "(Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;Ljava/lang/String;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final KuiklyRenderCoreExecuteMode executeMode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String assetsPath;

    public a(@NotNull KuiklyRenderCoreExecuteMode executeMode, @Nullable String str) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        this.executeMode = executeMode;
        this.assetsPath = str;
    }

    private final void a(HRImageLoadOption options) {
        String str;
        String replaceFirst$default;
        if (!options.g()) {
            return;
        }
        KuiklyRenderCoreExecuteMode kuiklyRenderCoreExecuteMode = this.executeMode;
        if ((kuiklyRenderCoreExecuteMode == KuiklyRenderCoreExecuteMode.JS || kuiklyRenderCoreExecuteMode == KuiklyRenderCoreExecuteMode.DEX) && (str = this.assetsPath) != null) {
            replaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(options.getSrc(), "assets://", "", false, 4, (Object) null);
            options.i("file://" + new File(str, replaceFirst$default).getAbsolutePath());
        }
    }

    public final void b(@Nullable Context context, @NotNull HRImageLoadOption options, @NotNull Function3<? super Drawable, ? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(callback, "callback");
        a(options);
        h e16 = u.f392615m.e();
        if (e16 != null) {
            e16.a(context, options, callback);
        }
    }
}

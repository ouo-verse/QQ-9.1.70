package kotlin;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0014\u0010\b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0007J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0012"}, d2 = {"Lsg1/g;", "", "Landroid/view/View;", "", "dp", "", "c", "percent", "a", "Landroid/content/res/Resources;", "res", "b", "Landroid/content/Context;", "context", "", "d", "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f433789a = new g();

    g() {
    }

    @JvmStatic
    public static final int a(int i3, int i16) {
        return (i3 & 16777215) | (((int) ((i16 / 100.0f) * 255)) << 24);
    }

    @JvmStatic
    public static final int c(@NotNull View view, float f16) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        g gVar = f433789a;
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return gVar.b(f16, resources);
    }

    public final int b(float dp5, @NotNull Resources res) {
        boolean z16;
        Intrinsics.checkNotNullParameter(res, "res");
        if (dp5 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 0;
        }
        return (int) ((dp5 * res.getDisplayMetrics().density) + 0.5f);
    }

    public final boolean d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Intrinsics.areEqual("com.tencent.mobileqq.guild.dev.component.demo.app", context.getPackageName());
    }
}

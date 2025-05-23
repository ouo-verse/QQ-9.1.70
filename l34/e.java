package l34;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\tH\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fH\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007\u00a8\u0006\u0014"}, d2 = {"Ll34/e;", "", "Landroid/view/View;", "view", "Ll34/a;", "listener", "", "e", "b", "Ll34/c;", "f", "c", "Ljava/lang/Class;", "iocClass", "g", "Ll34/d;", "d", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f413780a = new e();

    e() {
    }

    @JvmStatic
    @Nullable
    public static final View a(@Nullable View view) {
        if (view == null) {
            return null;
        }
        if (view.getContext() instanceof Activity) {
            Context context = view.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            if (((Activity) context).getWindow() != null) {
                Context context2 = view.getContext();
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                return ((Activity) context2).getWindow().getDecorView();
            }
            return view;
        }
        return view;
    }

    @JvmStatic
    @Nullable
    public static final a b(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (a) RFWIocAbilityProvider.g().getIocInterface(a.class, a(view), null);
    }

    @JvmStatic
    @Nullable
    public static final c c(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (c) RFWIocAbilityProvider.g().getIocInterface(c.class, a(view), null);
    }

    @JvmStatic
    @Nullable
    public static final d d(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (d) RFWIocAbilityProvider.g().getIocInterface(d.class, a(view), null);
    }

    @JvmStatic
    public static final void e(@NotNull View view, @NotNull a listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(listener, "listener");
        RFWIocAbilityProvider.g().registerIoc(a(view), listener, a.class);
    }

    @JvmStatic
    public static final void f(@NotNull View view, @NotNull c listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(listener, "listener");
        RFWIocAbilityProvider.g().registerIoc(a(view), listener, c.class);
    }

    @JvmStatic
    public static final void g(@NotNull View view, @Nullable Class<?> iocClass) {
        Intrinsics.checkNotNullParameter(view, "view");
        RFWIocAbilityProvider.g().unregisterSingleIoc(a(view), iocClass);
    }
}

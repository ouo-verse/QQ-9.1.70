package p51;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lp51/d;", "", "Landroid/content/Context;", "context", "Landroid/content/SharedPreferences;", "a", "<init>", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f425349a = new d();

    d() {
    }

    @NotNull
    public final SharedPreferences a(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("minibox_busi_sp", 0);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPrefere\u2026ME, Context.MODE_PRIVATE)");
        return sharedPreferences;
    }
}

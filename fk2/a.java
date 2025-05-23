package fk2;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lfk2/a;", "", "", "msg", "", "throwable", "a", "(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/String;", "b", "(Ljava/lang/Throwable;)Ljava/lang/String;", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f399711a = new a();

    a() {
    }

    @NotNull
    public final String a(@NotNull String msg2, @NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        return msg2 + "\n" + b(throwable);
    }

    @NotNull
    public final String b(@NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        String stackTraceString = Log.getStackTraceString(throwable);
        Intrinsics.checkNotNullExpressionValue(stackTraceString, "getStackTraceString(throwable)");
        return stackTraceString;
    }
}

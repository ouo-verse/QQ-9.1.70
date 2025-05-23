package id3;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a8\u0006\u000b"}, d2 = {"Lid3/c;", "", "", "tag", "message", "", "t", "", "a", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f407549a = new c();

    c() {
    }

    public final void a(@Nullable String tag, @Nullable String message, @Nullable Throwable t16) {
        String str;
        Throwable th5 = new Throwable("LUA_ERROR" + tag);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(message);
        sb5.append(" \n ");
        if (t16 != null) {
            str = t16.getMessage();
        } else {
            str = null;
        }
        sb5.append(str);
        com.tencent.qqperf.monitor.crash.catchedexception.a.c(th5, sb5.toString());
    }
}

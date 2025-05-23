package com.tdsrightly.tds.fg.observer;

import android.app.Application;
import com.tdsrightly.tds.fg.observer.d;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tdsrightly/tds/fg/observer/b;", "Lcom/tdsrightly/tds/fg/observer/d;", "Landroid/app/Application;", "app", "Lop/e;", "listener", "", "d", "", "getAppState", "", "getName", "<init>", "()V", "fg_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class b implements d {
    @Override // com.tdsrightly.tds.fg.observer.d
    public void a(@NotNull HashMap<String, String> map) {
        Intrinsics.checkParameterIsNotNull(map, "map");
        d.a.a(this, map);
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    public void b(int i3, @NotNull d from) {
        Intrinsics.checkParameterIsNotNull(from, "from");
        d.a.c(this, i3, from);
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    public void d(@NotNull Application app, @NotNull op.e listener) {
        Intrinsics.checkParameterIsNotNull(app, "app");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    public int getAppState() {
        return 0;
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    @NotNull
    public String getName() {
        return d.a.b(this);
    }
}

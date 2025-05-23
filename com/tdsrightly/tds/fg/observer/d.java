package com.tdsrightly.tds.fg.observer;

import android.app.Application;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH&J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0000H\u0016J,\u0010\u0012\u001a\u00020\u00062\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000fj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u0010H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tdsrightly/tds/fg/observer/d;", "", "Landroid/app/Application;", "app", "Lop/e;", "listener", "", "d", "", "getName", "", "getAppState", "appState", "from", "b", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "a", "fg_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface d {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes3.dex */
    public static final class a {
        public static void a(d dVar, @NotNull HashMap<String, String> map) {
            Intrinsics.checkParameterIsNotNull(map, "map");
        }

        @NotNull
        public static String b(d dVar) {
            String name = dVar.getClass().getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "this::class.java.name");
            return name;
        }

        public static void c(d dVar, int i3, @NotNull d from) {
            Intrinsics.checkParameterIsNotNull(from, "from");
        }
    }

    void a(@NotNull HashMap<String, String> map);

    void b(int appState, @NotNull d from);

    void d(@NotNull Application app, @NotNull op.e listener);

    int getAppState();

    @NotNull
    String getName();
}

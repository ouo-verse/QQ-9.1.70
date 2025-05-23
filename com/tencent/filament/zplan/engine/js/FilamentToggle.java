package com.tencent.filament.zplan.engine.js;

import androidx.annotation.Keep;
import dl0.k;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@NativeProxy(allFields = false, allMethods = false)
@Keep
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/filament/zplan/engine/js/FilamentToggle;", "", "", "toggleName", "jsonValue", "stringValue", "", "boolValue", "Ldl0/k;", "toggleProxy", "Ldl0/k;", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentToggle {

    @NotNull
    public static final FilamentToggle INSTANCE = new FilamentToggle();
    private static final k toggleProxy = (k) fl0.a.f399763a.a(k.class);

    FilamentToggle() {
    }

    @JvmStatic
    @NativeMethodProxy
    public static final boolean boolValue(@NotNull String toggleName) {
        Intrinsics.checkNotNullParameter(toggleName, "toggleName");
        k kVar = toggleProxy;
        if (kVar != null) {
            return kVar.c(toggleName);
        }
        return false;
    }

    @JvmStatic
    @NativeMethodProxy
    @NotNull
    public static final String jsonValue(@NotNull String toggleName) {
        String a16;
        Intrinsics.checkNotNullParameter(toggleName, "toggleName");
        k kVar = toggleProxy;
        if (kVar == null || (a16 = kVar.a(toggleName)) == null) {
            return "";
        }
        return a16;
    }

    @JvmStatic
    @NativeMethodProxy
    @NotNull
    public static final String stringValue(@NotNull String toggleName) {
        String b16;
        Intrinsics.checkNotNullParameter(toggleName, "toggleName");
        k kVar = toggleProxy;
        if (kVar == null || (b16 = kVar.b(toggleName)) == null) {
            return "";
        }
        return b16;
    }
}

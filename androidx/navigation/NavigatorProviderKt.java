package androidx.navigation;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\u0002H\u0001\"\u0010\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\n\u00a2\u0006\u0002\u0010\u0007\u001a2\u0010\u0000\u001a\u0002H\u0001\"\u0010\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002*\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00010\tH\u0086\n\u00a2\u0006\u0002\u0010\n\u001a\u001d\u0010\u000b\u001a\u00020\f*\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0086\n\u001a7\u0010\u000e\u001a\u0014\u0012\u000e\b\u0001\u0012\n \u000f*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u0002*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0086\n\u00a8\u0006\u0010"}, d2 = {"get", "T", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/NavigatorProvider;", "name", "", "(Landroidx/navigation/NavigatorProvider;Ljava/lang/String;)Landroidx/navigation/Navigator;", "clazz", "Lkotlin/reflect/KClass;", "(Landroidx/navigation/NavigatorProvider;Lkotlin/reflect/KClass;)Landroidx/navigation/Navigator;", "plusAssign", "", "navigator", "set", "kotlin.jvm.PlatformType", "navigation-common-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class NavigatorProviderKt {
    @NotNull
    public static final <T extends Navigator<? extends NavDestination>> T get(@NotNull NavigatorProvider get, @NotNull String name) {
        Intrinsics.checkParameterIsNotNull(get, "$this$get");
        Intrinsics.checkParameterIsNotNull(name, "name");
        T t16 = (T) get.getNavigator(name);
        Intrinsics.checkExpressionValueIsNotNull(t16, "getNavigator(name)");
        return t16;
    }

    public static final void plusAssign(@NotNull NavigatorProvider plusAssign, @NotNull Navigator<? extends NavDestination> navigator) {
        Intrinsics.checkParameterIsNotNull(plusAssign, "$this$plusAssign");
        Intrinsics.checkParameterIsNotNull(navigator, "navigator");
        plusAssign.addNavigator(navigator);
    }

    @Nullable
    public static final Navigator<? extends NavDestination> set(@NotNull NavigatorProvider set, @NotNull String name, @NotNull Navigator<? extends NavDestination> navigator) {
        Intrinsics.checkParameterIsNotNull(set, "$this$set");
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(navigator, "navigator");
        return set.addNavigator(name, navigator);
    }

    @NotNull
    public static final <T extends Navigator<? extends NavDestination>> T get(@NotNull NavigatorProvider get, @NotNull KClass<T> clazz) {
        Intrinsics.checkParameterIsNotNull(get, "$this$get");
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        T t16 = (T) get.getNavigator(JvmClassMappingKt.getJavaClass((KClass) clazz));
        Intrinsics.checkExpressionValueIsNotNull(t16, "getNavigator(clazz.java)");
        return t16;
    }
}

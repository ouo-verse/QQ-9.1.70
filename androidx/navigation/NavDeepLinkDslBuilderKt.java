package androidx.navigation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"navDeepLink", "Landroidx/navigation/NavDeepLink;", "deepLinkBuilder", "Lkotlin/Function1;", "Landroidx/navigation/NavDeepLinkDslBuilder;", "", "Lkotlin/ExtensionFunctionType;", "navigation-common-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class NavDeepLinkDslBuilderKt {
    @NotNull
    public static final NavDeepLink navDeepLink(@NotNull Function1<? super NavDeepLinkDslBuilder, Unit> deepLinkBuilder) {
        Intrinsics.checkParameterIsNotNull(deepLinkBuilder, "deepLinkBuilder");
        NavDeepLinkDslBuilder navDeepLinkDslBuilder = new NavDeepLinkDslBuilder();
        deepLinkBuilder.invoke(navDeepLinkDslBuilder);
        return navDeepLinkDslBuilder.build$navigation_common_ktx_release();
    }
}

package androidx.navigation;

import androidx.annotation.IdRes;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0007\u00a2\u0006\u0002\b\bH\u0086\b\u001a:\u0010\u0000\u001a\u00020\t*\u00020\n2\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0007\u00a2\u0006\u0002\b\bH\u0086\b\u00a8\u0006\u000b"}, d2 = {NotificationCompat.CATEGORY_NAVIGATION, "", "Landroidx/navigation/NavGraphBuilder;", "id", "", "startDestination", "builder", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavigatorProvider;", "navigation-common-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class NavGraphBuilderKt {
    @NotNull
    public static final NavGraph navigation(@NotNull NavigatorProvider navigation, @IdRes int i3, @IdRes int i16, @NotNull Function1<? super NavGraphBuilder, Unit> builder) {
        Intrinsics.checkParameterIsNotNull(navigation, "$this$navigation");
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigation, i3, i16);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider navigation, int i3, int i16, Function1 builder, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = 0;
        }
        Intrinsics.checkParameterIsNotNull(navigation, "$this$navigation");
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigation, i3, i16);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static final void navigation(@NotNull NavGraphBuilder navigation, @IdRes int i3, @IdRes int i16, @NotNull Function1<? super NavGraphBuilder, Unit> builder) {
        Intrinsics.checkParameterIsNotNull(navigation, "$this$navigation");
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigation.getProvider(), i3, i16);
        builder.invoke(navGraphBuilder);
        navigation.destination(navGraphBuilder);
    }
}

package androidx.navigation;

import androidx.annotation.IdRes;
import androidx.navigation.NavOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00140\u0016\u00a2\u0006\u0002\b\u0018J\r\u0010\u0019\u001a\u00020\u001aH\u0000\u00a2\u0006\u0002\b\u001bJ)\u0010\u000e\u001a\u00020\u00142\b\b\u0001\u0010\u001c\u001a\u00020\r2\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u0016\u00a2\u0006\u0002\b\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR&\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8\u0006@FX\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001f"}, d2 = {"Landroidx/navigation/NavOptionsBuilder;", "", "()V", "builder", "Landroidx/navigation/NavOptions$Builder;", "inclusive", "", "launchSingleTop", "getLaunchSingleTop", "()Z", "setLaunchSingleTop", "(Z)V", "value", "", "popUpTo", "getPopUpTo", "()I", "setPopUpTo", "(I)V", "anim", "", "animBuilder", "Lkotlin/Function1;", "Landroidx/navigation/AnimBuilder;", "Lkotlin/ExtensionFunctionType;", "build", "Landroidx/navigation/NavOptions;", "build$navigation_common_ktx_release", "id", "popUpToBuilder", "Landroidx/navigation/PopUpToBuilder;", "navigation-common-ktx_release"}, k = 1, mv = {1, 1, 16})
@NavOptionsDsl
/* loaded from: classes.dex */
public final class NavOptionsBuilder {
    private boolean inclusive;
    private boolean launchSingleTop;
    private final NavOptions.Builder builder = new NavOptions.Builder();

    @IdRes
    private int popUpTo = -1;

    public final void anim(@NotNull Function1<? super AnimBuilder, Unit> animBuilder) {
        Intrinsics.checkParameterIsNotNull(animBuilder, "animBuilder");
        AnimBuilder animBuilder2 = new AnimBuilder();
        animBuilder.invoke(animBuilder2);
        this.builder.setEnterAnim(animBuilder2.getEnter()).setExitAnim(animBuilder2.getExit()).setPopEnterAnim(animBuilder2.getPopEnter()).setPopExitAnim(animBuilder2.getPopExit());
    }

    @NotNull
    public final NavOptions build$navigation_common_ktx_release() {
        NavOptions.Builder builder = this.builder;
        builder.setLaunchSingleTop(this.launchSingleTop);
        builder.setPopUpTo(this.popUpTo, this.inclusive);
        NavOptions build = builder.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "builder.apply {\n        \u2026 inclusive)\n    }.build()");
        return build;
    }

    public final boolean getLaunchSingleTop() {
        return this.launchSingleTop;
    }

    public final int getPopUpTo() {
        return this.popUpTo;
    }

    public final void popUpTo(@IdRes int id5, @NotNull Function1<? super PopUpToBuilder, Unit> popUpToBuilder) {
        Intrinsics.checkParameterIsNotNull(popUpToBuilder, "popUpToBuilder");
        setPopUpTo(id5);
        PopUpToBuilder popUpToBuilder2 = new PopUpToBuilder();
        popUpToBuilder.invoke(popUpToBuilder2);
        this.inclusive = popUpToBuilder2.getInclusive();
    }

    public final void setLaunchSingleTop(boolean z16) {
        this.launchSingleTop = z16;
    }

    public final void setPopUpTo(int i3) {
        this.popUpTo = i3;
        this.inclusive = false;
    }
}

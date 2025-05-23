package androidx.navigation;

import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a;\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0087\b\u00a8\u0006\n"}, d2 = {"navGraphViewModels", "Lkotlin/Lazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "navGraphId", "", "factoryProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "navigation-fragment-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class NavGraphViewModelLazyKt {
    @MainThread
    @NotNull
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> navGraphViewModels(@NotNull Fragment navGraphViewModels, @IdRes int i3, @Nullable Function0<? extends ViewModelProvider.Factory> function0) {
        Lazy lazy;
        Intrinsics.checkParameterIsNotNull(navGraphViewModels, "$this$navGraphViewModels");
        lazy = LazyKt__LazyJVMKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(navGraphViewModels, i3));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(lazy, null);
        Intrinsics.reifiedOperationMarker(4, "VM");
        return FragmentViewModelLazyKt.createViewModelLazy(navGraphViewModels, Reflection.getOrCreateKotlinClass(ViewModel.class), navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1, new NavGraphViewModelLazyKt$navGraphViewModels$1(function0, lazy, null));
    }

    public static /* synthetic */ Lazy navGraphViewModels$default(Fragment navGraphViewModels, int i3, Function0 function0, int i16, Object obj) {
        Lazy lazy;
        if ((i16 & 2) != 0) {
            function0 = null;
        }
        Intrinsics.checkParameterIsNotNull(navGraphViewModels, "$this$navGraphViewModels");
        lazy = LazyKt__LazyJVMKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(navGraphViewModels, i3));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(lazy, null);
        Intrinsics.reifiedOperationMarker(4, "VM");
        return FragmentViewModelLazyKt.createViewModelLazy(navGraphViewModels, Reflection.getOrCreateKotlinClass(ViewModel.class), navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1, new NavGraphViewModelLazyKt$navGraphViewModels$1(function0, lazy, null));
    }
}

package com.tencent.mobileqq.guild.base.fragments;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Landroidx/fragment/app/Fragment;", "Landroidx/lifecycle/ViewModelStore;", "a", "(Landroidx/fragment/app/Fragment;)Landroidx/lifecycle/ViewModelStore;", "sharedViewModelStore", "Landroidx/lifecycle/ViewModelStoreOwner;", "b", "(Landroidx/fragment/app/Fragment;)Landroidx/lifecycle/ViewModelStoreOwner;", "sharedViewModelStoreOwner", "qqguild-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class f {
    @NotNull
    public static final ViewModelStore a(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        return SharedViewModelStoreOwner.INSTANCE.a().a(fragment);
    }

    @NotNull
    public static final ViewModelStoreOwner b(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        return SharedViewModelStoreOwner.INSTANCE.b().a(fragment);
    }
}

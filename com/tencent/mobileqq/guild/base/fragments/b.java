package com.tencent.mobileqq.guild.base.fragments;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0011\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/base/fragments/b;", "Lcom/tencent/mobileqq/guild/base/fragments/a;", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelStore;", "b", "a", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b implements a {
    private final ViewModelStore b(Fragment fragment) {
        ViewModelStore viewModelStore;
        ViewModelStoreOwner parentFragment = fragment.getParentFragment();
        if (parentFragment instanceof SharedViewModelStoreOwner) {
            return ((SharedViewModelStoreOwner) parentFragment).p3();
        }
        if (parentFragment != null) {
            ViewModelStore viewModelStore2 = parentFragment.get_viewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore2, "parent.viewModelStore");
            return viewModelStore2;
        }
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            viewModelStore = activity.get_viewModelStore();
        } else {
            viewModelStore = null;
        }
        if (viewModelStore == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = fragment.getClass().getName() + " parentFragment and activity is null, return self viewModelStore";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("SharedViewModelStoreOwnerImpl", 1, (String) it.next(), null);
            }
            ViewModelStore viewModelStore3 = fragment.get_viewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore3, "fragment.viewModelStore");
            return viewModelStore3;
        }
        return viewModelStore;
    }

    @Override // com.tencent.mobileqq.guild.base.fragments.a
    @NotNull
    public ViewModelStore a(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return b(fragment);
    }
}

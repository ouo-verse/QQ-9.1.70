package com.tencent.mobileqq.guild.base.fragments;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/base/fragments/e;", "Lcom/tencent/mobileqq/guild/base/fragments/c;", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelStoreOwner;", "a", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class e implements c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelStore c(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        return f.a(fragment);
    }

    @Override // com.tencent.mobileqq.guild.base.fragments.c
    @NotNull
    public ViewModelStoreOwner a(@NotNull final Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return new ViewModelStoreOwner() { // from class: com.tencent.mobileqq.guild.base.fragments.d
            @Override // androidx.lifecycle.ViewModelStoreOwner
            /* renamed from: getViewModelStore */
            public final ViewModelStore get_viewModelStore() {
                ViewModelStore c16;
                c16 = e.c(Fragment.this);
                return c16;
            }
        };
    }
}

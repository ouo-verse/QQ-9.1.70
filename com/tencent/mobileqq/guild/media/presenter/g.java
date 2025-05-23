package com.tencent.mobileqq.guild.media.presenter;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/presenter/g;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "", "a", "e", "Landroidx/lifecycle/ViewModelStore;", "viewModelStore", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g implements ViewModelStoreOwner {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final g f229131d = new g();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static ViewModelStore viewModelStore;

    g() {
    }

    public final void a() {
        ViewModelStore viewModelStore2 = viewModelStore;
        if (viewModelStore2 != null) {
            if (viewModelStore2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModelStore");
                viewModelStore2 = null;
            }
            viewModelStore2.clear();
        }
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NotNull
    /* renamed from: getViewModelStore */
    public ViewModelStore get_viewModelStore() {
        if (viewModelStore == null) {
            viewModelStore = new ViewModelStore();
        }
        ViewModelStore viewModelStore2 = viewModelStore;
        if (viewModelStore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelStore");
            return null;
        }
        return viewModelStore2;
    }
}

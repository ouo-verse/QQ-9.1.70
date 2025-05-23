package com.tencent.qqnt.base.lifecycle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/base/lifecycle/b;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "", "param", "Landroidx/fragment/app/Fragment;", "fragment", "", "v0", "", "getTag", "getModule", "", "getId", "Landroidx/lifecycle/LifecycleOwner;", "owner", "H1", "q1", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface b extends DefaultLifecycleObserver {
    void H1(@NotNull LifecycleOwner owner);

    int getId();

    @NotNull
    String getModule();

    @NotNull
    String getTag();

    void q1(@NotNull LifecycleOwner owner);

    void v0(@Nullable Object param, @Nullable Fragment fragment);
}

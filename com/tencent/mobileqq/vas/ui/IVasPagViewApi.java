package com.tencent.mobileqq.vas.ui;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\nH&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J\"\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\nH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/IVasPagViewApi;", "T", "Landroid/view/View;", "", "build", "getCurrentView", "isBuild", "", "postAction", "block", "Lkotlin/Function1;", "", "refresh", "setStateChangeListener", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface IVasPagViewApi<T extends View> {
    @NotNull
    IVasPagViewApi<T> build();

    @Nullable
    View getCurrentView();

    boolean isBuild();

    @NotNull
    IVasPagViewApi<T> postAction(@NotNull Function1<? super T, Unit> block);

    @NotNull
    IVasPagViewApi<T> refresh();

    @NotNull
    IVasPagViewApi<T> setStateChangeListener(@NotNull Function1<? super View, Unit> block);
}

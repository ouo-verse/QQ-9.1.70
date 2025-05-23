package com.tencent.kuikly.core.render.android;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J#\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH&J'\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\tH&\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0001H&J'\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\tH&\u00a2\u0006\u0004\b\u0018\u0010\u0014J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u0006#"}, d2 = {"Lcom/tencent/kuikly/core/render/android/a;", "", "Lcom/tencent/kuikly/core/render/android/g;", "R0", "", "M0", "u0", "Li01/e;", "T", "", "name", "a", "(Ljava/lang/String;)Li01/e;", "", "tag", "Landroid/view/View;", "b", "view", "key", "P0", "(Landroid/view/View;Ljava/lang/String;)Ljava/lang/Object;", "data", "", "N0", "Q0", "Lg01/a;", "c", "Lcom/tencent/kuikly/core/render/android/d;", "O0", "()Lcom/tencent/kuikly/core/render/android/d;", "kuiklyRenderRootView", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface a {
    boolean M0();

    void N0(@NotNull View view, @NotNull String key, @NotNull Object data);

    @Nullable
    d O0();

    @Nullable
    <T> T P0(@NotNull View view, @NotNull String key);

    @Nullable
    <T> T Q0(@NotNull View view, @NotNull String key);

    @Nullable
    KuiklyContextParams R0();

    @Nullable
    <T extends i01.e> T a(@NotNull String name);

    @Nullable
    View b(int tag);

    @Nullable
    g01.a c();

    @NotNull
    Context getContext();

    boolean u0();
}

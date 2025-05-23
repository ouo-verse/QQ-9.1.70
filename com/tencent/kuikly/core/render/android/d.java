package com.tencent.kuikly.core.render.android;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001H&J#\u0010\n\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH&J\u001a\u0010\u0013\u001a\u00020\u00052\u0010\u0010\u0012\u001a\f\u0012\u0004\u0012\u00020\u00050\u0010j\u0002`\u0011H&J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H&R\u0014\u0010\u001b\u001a\u00020\u00188&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006$"}, d2 = {"Lcom/tencent/kuikly/core/render/android/d;", "", "", "event", "data", "", "d", "Li01/e;", "T", "name", "a", "(Ljava/lang/String;)Li01/e;", "", "tag", "Landroid/view/View;", "b", "Lkotlin/Function0;", "Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreTask;", "task", "c", "Lcom/tencent/kuikly/core/render/android/c;", "callback", "g", "f", "Lcom/tencent/kuikly/core/render/android/b;", "e", "()Lcom/tencent/kuikly/core/render/android/b;", "kuiklyRenderExport", "Lcom/tencent/kuikly/core/render/android/a;", "getKuiklyRenderContext", "()Lcom/tencent/kuikly/core/render/android/a;", "kuiklyRenderContext", "Landroid/view/ViewGroup;", "getView", "()Landroid/view/ViewGroup;", "view", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface d {
    @Nullable
    <T extends i01.e> T a(@NotNull String name);

    @Nullable
    View b(int tag);

    void c(@NotNull Function0<Unit> task);

    void d(@NotNull String event, @NotNull Object data);

    @NotNull
    b e();

    void f(@NotNull c callback);

    void g(@NotNull c callback);

    @NotNull
    a getKuiklyRenderContext();

    @NotNull
    ViewGroup getView();
}

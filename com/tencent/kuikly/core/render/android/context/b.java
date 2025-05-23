package com.tencent.kuikly.core.render.android.context;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0012H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/kuikly/core/render/android/context/b;", "", "", "contextCode", "", "init", "destroy", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderContextMethod;", "method", "", "args", "call", "Lcom/tencent/kuikly/core/render/android/context/c;", "callback", "registerCallNative", "Lcom/tencent/kuikly/core/render/android/context/a;", "listener", "setBridgeStatusListener", "Lcom/tencent/kuikly/core/render/android/exception/a;", "setRenderExceptionListener", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface b {
    void call(@NotNull KuiklyRenderContextMethod method, @NotNull List<? extends Object> args);

    void destroy();

    void init(@NotNull String contextCode);

    void registerCallNative(@NotNull c callback);

    void setBridgeStatusListener(@NotNull a listener);

    void setRenderExceptionListener(@Nullable com.tencent.kuikly.core.render.android.exception.a listener);
}

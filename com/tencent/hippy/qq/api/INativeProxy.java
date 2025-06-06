package com.tencent.hippy.qq.api;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&J&\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0001H&J\u001c\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/hippy/qq/api/INativeProxy;", "", "callNativeMethod", "", "module", "", "method", "readable", "callback", "registerNativeMethod", "reactJsCallBack", "unRegisterNativeMethod", "hippy-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public interface INativeProxy {
    void callNativeMethod(@Nullable String module, @Nullable String method, @Nullable Object readable, @Nullable Object callback);

    void registerNativeMethod(@Nullable String module, @Nullable String method, @Nullable Object reactJsCallBack);

    void unRegisterNativeMethod(@Nullable String module, @Nullable String method);
}

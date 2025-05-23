package com.tencent.qqmini.sdk.launcher.core.proxy;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqmini/sdk/launcher/core/proxy/RequestPermissionCallback;", "", "onFail", "", "onPartialGrant", "onSuccess", "lib_minilauncher_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public interface RequestPermissionCallback {
    void onFail();

    void onPartialGrant();

    void onSuccess();
}

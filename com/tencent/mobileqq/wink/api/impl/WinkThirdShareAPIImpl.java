package com.tencent.mobileqq.wink.api.impl;

import android.content.Context;
import com.tencent.mobileqq.wink.api.IWinkThirdShareAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/WinkThirdShareAPIImpl;", "Lcom/tencent/mobileqq/wink/api/IWinkThirdShareAPI;", "()V", "backToShareApp", "", "context", "Landroid/content/Context;", "success", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkThirdShareAPIImpl implements IWinkThirdShareAPI {
    @Override // com.tencent.mobileqq.wink.api.IWinkThirdShareAPI
    public boolean backToShareApp(@NotNull Context context, boolean success) {
        Intrinsics.checkNotNullParameter(context, "context");
        return com.tencent.mobileqq.wink.preprocess.m.c(context, success);
    }
}

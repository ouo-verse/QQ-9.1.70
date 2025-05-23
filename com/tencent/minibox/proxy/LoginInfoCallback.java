package com.tencent.minibox.proxy;

import androidx.annotation.Keep;
import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/minibox/proxy/LoginInfoCallback;", "", "()V", "onLoaded", "", CommonConstant.KEY_ACCESS_TOKEN, "", "payToken", "openId", "appId", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public class LoginInfoCallback {
    public void onLoaded(@NotNull String accessToken, @NotNull String payToken, @NotNull String openId, @NotNull String appId) {
        Intrinsics.checkParameterIsNotNull(accessToken, "accessToken");
        Intrinsics.checkParameterIsNotNull(payToken, "payToken");
        Intrinsics.checkParameterIsNotNull(openId, "openId");
        Intrinsics.checkParameterIsNotNull(appId, "appId");
    }
}

package com.tencent.filament.zplanservice.download;

import androidx.annotation.Keep;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@NativeProxy(allFields = false, allMethods = true)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001b\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/filament/zplanservice/download/IZPlanAvatarCheckCallback;", "", "onFail", "", "error", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarError;", "onSuccess", "result", "", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarCheckResult;", "([Lcom/tencent/filament/zplanservice/download/ZPlanAvatarCheckResult;)V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface IZPlanAvatarCheckCallback {
    void onFail(@NotNull ZPlanAvatarError error);

    void onSuccess(@NotNull ZPlanAvatarCheckResult[] result);
}

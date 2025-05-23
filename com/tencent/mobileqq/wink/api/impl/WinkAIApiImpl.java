package com.tencent.mobileqq.wink.api.impl;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.ai.imagetext.WinkAIImageTextAPIHelper;
import com.tencent.mobileqq.wink.api.IWinkAIApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/WinkAIApiImpl;", "Lcom/tencent/mobileqq/wink/api/IWinkAIApi;", "", "imagePath", "originText", "", "useCache", "Lcom/tencent/mobileqq/wink/api/e;", "imageTextResponseCallback", "", "requestImageText", "cancelImageText", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "enableAIAvatar", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIApiImpl implements IWinkAIApi {
    @Override // com.tencent.mobileqq.wink.api.IWinkAIApi
    public void cancelImageText(@NotNull String imagePath) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        WinkAIImageTextAPIHelper.f317663a.f();
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkAIApi
    public void clearCache(@Nullable String imagePath) {
        WinkAIImageTextAPIHelper.f317663a.g(imagePath);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkAIApi
    public boolean enableAIAvatar() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105910", true);
        w53.b.f("WinkAIApiImpl", "enableAIAvatar: " + isSwitchOn);
        return isSwitchOn;
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkAIApi
    public void requestImageText(@NotNull String imagePath, @NotNull String originText, boolean useCache, @NotNull com.tencent.mobileqq.wink.api.e imageTextResponseCallback) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(originText, "originText");
        Intrinsics.checkNotNullParameter(imageTextResponseCallback, "imageTextResponseCallback");
        WinkAIImageTextAPIHelper.f317663a.k(imagePath, originText, useCache, imageTextResponseCallback);
    }
}

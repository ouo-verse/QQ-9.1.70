package com.tencent.mobileqq.vas.api.impl;

import android.os.Build;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.api.IAIAvatarConfig;
import com.tencent.mobileqq.wink.api.IWinkAIApi;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/AIAvatarConfigImpl;", "Lcom/tencent/mobileqq/vas/api/IAIAvatarConfig;", "()V", "enableAvatarNewPage", "", "enableAvatarPageTransitionAnim", "isHonorDevice", "isHuaWeiDevice", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class AIAvatarConfigImpl implements IAIAvatarConfig {
    private final boolean isHonorDevice() {
        boolean equals;
        equals = StringsKt__StringsJVMKt.equals(Build.MANUFACTURER, "honor", true);
        return equals;
    }

    private final boolean isHuaWeiDevice() {
        boolean equals;
        equals = StringsKt__StringsJVMKt.equals(Build.MANUFACTURER, CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI, true);
        return equals;
    }

    @Override // com.tencent.mobileqq.vas.api.IAIAvatarConfig
    public boolean enableAvatarNewPage() {
        return ((IWinkAIApi) QRoute.api(IWinkAIApi.class)).enableAIAvatar();
    }

    @Override // com.tencent.mobileqq.vas.api.IAIAvatarConfig
    public boolean enableAvatarPageTransitionAnim() {
        boolean z16;
        if (Build.VERSION.SDK_INT >= 29 && !isHuaWeiDevice() && !isHonorDevice()) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105998", true);
        if (!z16 || !enableAvatarNewPage() || !isSwitchOn) {
            return false;
        }
        return true;
    }
}

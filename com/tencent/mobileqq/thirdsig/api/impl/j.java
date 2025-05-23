package com.tencent.mobileqq.thirdsig.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0002"}, d2 = {"", "a", "third-sig-kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class j {
    public static final boolean a() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102430", false);
    }
}

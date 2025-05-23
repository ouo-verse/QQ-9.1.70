package com.tencent.mobileqq.vas.pendant.api.impl;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.avatar.g;
import com.tencent.mobileqq.vas.pendant.api.IPendantManager;
import com.tencent.mobileqq.vas.pendant.drawable.CacheStateMap;
import com.tencent.mobileqq.vas.pendant.drawable.PendantConstant;
import com.tencent.mobileqq.vas.pendant.drawable.api.IPendantHelperApi;
import com.tencent.mobileqq.vip.api.VipData;

/* loaded from: classes20.dex */
public class PendantManagerImpl implements IPendantManager {
    private static long sPendantId = 124169;

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantManager
    @Nullable
    public g getPendantDrawable(long j3, int i3, @NonNull String str, int i16, @Nullable VipData.VipNumberInfo vipNumberInfo) {
        return new e(((IPendantHelperApi) QRoute.api(IPendantHelperApi.class)).getAvatarPendantManager().getPendantInfo(j3).getDrawable(2, i3, str, i16, true, vipNumberInfo, f13.a.f397699a.c()), j3);
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantManager
    public void pause() {
        CacheStateMap.stop();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantManager
    public void resume() {
        CacheStateMap.restart();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantManager
    @NonNull
    public Drawable getPendantDrawable(int i3) {
        return ((IPendantHelperApi) QRoute.api(IPendantHelperApi.class)).getAvatarPendantManager().getPendantInfo(i3).getDrawable(2, PendantConstant.PENDANT_TARGET_ID_RECENT_MSG, "", 0, false);
    }
}

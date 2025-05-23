package com.tencent.gdtad.adapter;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.lbs.AdLocation;
import com.tencent.ad.tangram.lbs.AdLocationAdapter;
import com.tencent.ad.tangram.lbs.AdLocationManager;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class i implements AdLocationAdapter {
    @Override // com.tencent.ad.tangram.lbs.AdLocationAdapter
    @Nullable
    public AdLocation getLocationCache() {
        if (!AdLocationManager.getInstance().isSwichOn()) {
            return null;
        }
        SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("gdt_tangram");
        if (cachedLbsInfo != null && cachedLbsInfo.mLocation != null) {
            AdLocation adLocation = new AdLocation();
            SosoLocation sosoLocation = cachedLbsInfo.mLocation;
            adLocation.latitude = sosoLocation.mLat02;
            adLocation.longitude = sosoLocation.mLon02;
            adLocation.timeMillis = sosoLocation.locationTime;
            return adLocation;
        }
        GdtLog.i("GdtLocationAdapter", String.format("getLocationCache %s", null));
        return null;
    }
}

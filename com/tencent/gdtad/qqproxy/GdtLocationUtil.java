package com.tencent.gdtad.qqproxy;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.lbs.AdLocationManager;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import java.lang.ref.WeakReference;

/* compiled from: P */
@Deprecated
/* loaded from: classes6.dex */
final class GdtLocationUtil {
    public static final String TAG = "GdtLocationUtil";

    GdtLocationUtil() {
    }

    @Nullable
    @Deprecated
    public static int[] getLocation(Context context) {
        SosoLbsInfo sosoLbsInfo;
        boolean z16;
        long j3;
        SosoLocation sosoLocation;
        long currentTimeMillis = System.currentTimeMillis();
        if (AdLocationManager.getInstance().isSwichOn()) {
            sosoLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("gdt_tangram");
        } else {
            sosoLbsInfo = null;
        }
        if (sosoLbsInfo != null && sosoLbsInfo.mLocation != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        AdAnalysis adAnalysis = AdAnalysis.getInstance();
        WeakReference<Context> weakReference = new WeakReference<>(context);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (z16) {
            j3 = System.currentTimeMillis() - sosoLbsInfo.mLocation.locationTime;
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        adAnalysis.handleAsync(weakReference, AdAnalysisHelperForUtil.createEventForLocation(context, z16, currentTimeMillis2, j3));
        if (sosoLbsInfo == null || (sosoLocation = sosoLbsInfo.mLocation) == null) {
            return null;
        }
        return new int[]{(int) (sosoLocation.mLat02 * 1000000.0d), (int) (sosoLocation.mLon02 * 1000000.0d)};
    }
}

package com.tencent.biz.richframework.video.rfw;

import android.text.TextUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import uq3.o;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWVideoUrlBackUpUtils {
    private static String getBackUpDalV4(RFWPlayerOptions rFWPlayerOptions) {
        if (rFWPlayerOptions != null && !TextUtils.isEmpty(rFWPlayerOptions.getTargetDualStackV4IpUrl())) {
            String targetDualStackV4IpUrl = rFWPlayerOptions.getTargetDualStackV4IpUrl();
            QLog.d("QFSVideoUrlBackUpUtils", 1, "[getBackUpDalV4] backUrl: " + targetDualStackV4IpUrl);
            return targetDualStackV4IpUrl;
        }
        return "";
    }

    public static List<String> getBackUpVideoUrl(RFWPlayerOptions rFWPlayerOptions) {
        if (o.t1()) {
            return rFWPlayerOptions.getDirectIPBackUpList();
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(rFWPlayerOptions.getTargetIPURL()) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_use_ip_url_back_up", true)) {
            arrayList.add(rFWPlayerOptions.getTargetIPURL());
        }
        String ipBackUpUrl = getIpBackUpUrl(rFWPlayerOptions);
        if (!TextUtils.isEmpty(ipBackUpUrl)) {
            arrayList.add(ipBackUpUrl);
        }
        return arrayList;
    }

    private static String getIpBackUpUrl(RFWPlayerOptions rFWPlayerOptions) {
        if (!uq3.c.D5()) {
            return "";
        }
        if (rFWPlayerOptions != null && !TextUtils.isEmpty(rFWPlayerOptions.getTargetIPURL())) {
            String playUrl = rFWPlayerOptions.getPlayUrl();
            QLog.d("QFSVideoUrlBackUpUtils", 1, "[getBackUpVideoUrl] backUrl: " + playUrl);
            return playUrl;
        }
        return getBackUpDalV4(rFWPlayerOptions);
    }
}

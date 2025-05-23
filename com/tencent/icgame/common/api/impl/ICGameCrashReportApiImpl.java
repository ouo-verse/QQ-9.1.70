package com.tencent.icgame.common.api.impl;

import android.text.TextUtils;
import b22.a;
import com.tencent.icgame.ICGameOriginalPkgNameUtil1;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.common.api.IICGameCrashReportApi;
import com.tencent.mobileqq.icgame.ICGameOriginalPkgNameUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem;
import tt0.b;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ICGameCrashReportApiImpl implements IICGameCrashReportApi {
    private static final int LEN_MAX_ALERT_MSG = 2000;
    private static final int LEN_PREFIX_MSG = 200;
    private static final String PROCESS_NAME_MAIN = "com.tencent.mobileqq";
    private static final String PROCESS_NAME_TOOL = "com.tencent.mobileqq:tool";
    private static final String TAG = "ICGameCrashReportApiImpl";
    private static final String PKG_NAME_ORIGINAL_ICGAME = ICGameOriginalPkgNameUtil.getName();
    private static final String PKG_NAME_MIXED_ICGAME = a.a();
    private static final String PKG_NAME_ORIGINAL_ICGAME1 = ICGameOriginalPkgNameUtil1.getName();
    private static final String PKG_NAME_MIXED_ICGAME1 = jt0.a.a();
    private static final int LEN_CRASH_MSG = TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC;

    @Override // com.tencent.icgame.common.api.IICGameCrashReportApi
    public boolean isICGameCrash(String str, String str2, String str3, long j3, String str4) {
        if ((!"com.tencent.mobileqq:tool".equalsIgnoreCase(str4) && !"com.tencent.mobileqq".equalsIgnoreCase(str4)) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (!str3.contains(PKG_NAME_ORIGINAL_ICGAME) && !str3.contains(PKG_NAME_MIXED_ICGAME) && !str3.contains(PKG_NAME_ORIGINAL_ICGAME1) && !str3.contains(PKG_NAME_MIXED_ICGAME1)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.icgame.common.api.IICGameCrashReportApi
    public void reportCrash(b bVar) {
        IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        tt0.a aVar = new tt0.a(bVar.f437442b, bVar.f437445e, true);
        String str = "versionCode_" + bVar.f437446f + " crashType:" + bVar.f437441a + " crashAddress:" + bVar.f437442b + " crashStack:" + bVar.f437443c + " crashTime:" + bVar.f437444d;
        int length = str.length();
        int i3 = LEN_CRASH_MSG;
        if (length > i3) {
            str = str.substring(0, i3) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        iAegisLogApi.a(TAG, "icgame_crash " + str, aVar);
        iAegisLogApi.reportEvent("icgame_crash", bVar.f437445e, bVar.f437442b);
    }
}

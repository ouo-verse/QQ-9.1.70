package com.tencent.biz.pubaccount.weishi.download;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.hippy.qq.module.QQBridgeModule;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.appstore.dl.DownloadProxy;
import com.tencent.open.downloadnew.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f80659a = HardCodeUtil.qqStr(R.string.vk8);

    private static Bundle a(String str, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putString(e.f341493b, "10261931");
        bundle.putString(e.f341503l, f80659a);
        bundle.putString(e.f341497f, QQBridgeModule.WEISHI_PAKG_NAME);
        bundle.putString(e.f341501j, str);
        bundle.putInt(e.f341502k, 2);
        bundle.putBoolean(e.f341499h, false);
        bundle.putBoolean(e.f341515x, !z16);
        return bundle;
    }

    public static String b() {
        return "https://weseeugg.qq.com/download?channelid=204002177";
    }

    public static boolean d(Activity activity, String str, WSDownloadParams wSDownloadParams, boolean z16, int i3, a aVar) {
        if (activity != null && wSDownloadParams != null) {
            x.b("WeishiDownloadUtil", "downloadWeishi:" + wSDownloadParams);
            DownloadManagerV2.V().t0(aVar);
            return c(activity, str, z16, false, wSDownloadParams, i3);
        }
        x.b("WeishiDownloadUtil", "startQQDownload: activity is null Or params is null:");
        return false;
    }

    private static boolean c(Activity activity, String str, boolean z16, boolean z17, WSDownloadParams wSDownloadParams, int i3) {
        x.i("WeishiDownloadUtil", String.format("downloadWeishi : autoInstall = %s, showNotification = %s, mDownloadUrlStr = %s", Boolean.valueOf(z16), Boolean.valueOf(z17), str));
        DownloadProxy.k().g(activity, a(str, z17), "biz_src_jc_gzh_weishi", null, 0);
        WSReportDc00898.j(true, wSDownloadParams);
        WSReportDc00898.l(wSDownloadParams, 2);
        WSPublicAccReport.getInstance().reportDownload(wSDownloadParams.mEventId, i3, 1, 2, 0, wSDownloadParams.mScene);
        return true;
    }
}

package com.tencent.luggage.wxa.wq;

import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.v0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.XWebDownloader;
import com.tencent.xweb.XWebSdk;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {
    public static void a(XWebDownloader.DownloadInfo downloadInfo, com.tencent.luggage.wxa.yq.f fVar) {
        int i3 = fVar.f146066a != null ? !com.tencent.luggage.wxa.yq.m.f().getScheduleType().equalsIgnoreCase(fVar.f146066a.getScheduleType()) ? 1 : 0 : 0;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(fVar.f146069d ? 2 : 1);
        sb5.append(",");
        sb5.append(XWebSdk.getAvailableVersion());
        sb5.append(",");
        sb5.append(fVar.f146073h);
        sb5.append(",");
        sb5.append(XWebSdk.getXWebSdkVersion());
        sb5.append(",");
        sb5.append(downloadInfo.mErrorCode);
        sb5.append(",");
        sb5.append(downloadInfo.mNetWorkType);
        sb5.append(",");
        sb5.append(downloadInfo.mRetryTimes);
        sb5.append(",");
        sb5.append(System.currentTimeMillis() - downloadInfo.mStartTimestamp);
        sb5.append(",");
        sb5.append(downloadInfo.mFileTotalSize);
        sb5.append(",");
        sb5.append(downloadInfo.mDownloadType);
        sb5.append(",");
        sb5.append(downloadInfo.mIsDownloadResume ? 1 : 0);
        sb5.append(",");
        sb5.append(downloadInfo.mUrl);
        sb5.append(",");
        sb5.append(i3);
        sb5.append(",");
        sb5.append(XWalkEnvironment.dumpAppInfo());
        sb5.append(",");
        sb5.append(XWalkEnvironment.getApplicationContext().getPackageName());
        sb5.append(",");
        sb5.append(v0.b());
        sb5.append(",");
        sb5.append(fVar.f146078m == 1 ? "1" : "2");
        sb5.append(",");
        sb5.append(CommandCfg.getInstance().getConfigVersion());
        sb5.append(",");
        sb5.append(a(fVar));
        String sb6 = sb5.toString();
        x0.d("KVReportForDownloadRuntime", "report:" + sb6);
        if (XWalkEnvironment.getBuildConfigThirdPartyRelease() && CommandCfg.getInstance().getEnableThirdAppReport()) {
            n0.a(10125, sb6);
        } else {
            n0.a(15124, sb6);
        }
    }

    public static String a(com.tencent.luggage.wxa.yq.f fVar) {
        try {
            return fVar.b();
        } catch (Exception unused) {
            return "";
        }
    }
}

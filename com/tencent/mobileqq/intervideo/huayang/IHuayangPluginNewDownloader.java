package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.io.File;
import java.util.Map;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IHuayangPluginNewDownloader extends QRouteApi {
    public static final String TAG = "IHuayangPluginNewDownloader";

    /* loaded from: classes15.dex */
    public interface a {
        void a(int i3, Object... objArr);
    }

    void cancelDownload();

    void cancelLauncher();

    void download(String str, String str2, String str3, Map<String, IVPluginInfo> map);

    String getUin();

    IHuayangPluginNewDownloader init(Context context, File file, String str);

    void setDonwanlodPreloadListener(a aVar);

    void setRunning(boolean z16);

    void setUin(String str);
}

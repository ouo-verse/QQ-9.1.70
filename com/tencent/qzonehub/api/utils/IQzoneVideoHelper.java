package com.tencent.qzonehub.api.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.webviewwrapper.IWebviewOnClassLoaded;
import mqq.app.NewIntent;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneVideoHelper extends QRouteApi {
    public static final String IS_QZONE_LIVE_LAUNCH = "is_qzone_live_launch";
    public static final String QZONE_LIVE_PROCESS_ID = "qzone_live_process_id";

    void bindService(Context context, String str, ServiceConnection serviceConnection);

    void cancel(String str);

    void forwardToBrowser(Activity activity, String str, int i3, Bundle bundle, String str2);

    String getCacheDir(String str);

    NewIntent getTcSdkDownloadReportServlet(Context context);

    Object getVideoComponentCallback();

    void preInitWebview(IWebviewOnClassLoaded iWebviewOnClassLoaded);

    int trimByFFmpeg(String str, String[] strArr);

    int trimByFFmpeg(String[] strArr);
}

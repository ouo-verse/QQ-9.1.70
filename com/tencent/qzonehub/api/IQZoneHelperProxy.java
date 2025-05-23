package com.tencent.qzonehub.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.QZoneHelper;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneHelperProxy extends QRouteApi {
    void addQZoneStatis(Intent intent, int i3);

    void bindQzonePublishQueueService(AppRuntime appRuntime, ServiceConnection serviceConnection);

    void cleanAllQZconfig();

    AppRuntime createQZoneMainRuntime(Context context, String str);

    void createShortcut(AppRuntime appRuntime, Intent intent, String str, Bitmap bitmap);

    void deleteAllH5Data(AppRuntime appRuntime);

    void forwardH5QZone(String str, Context context);

    boolean forwardToQZoneFriendFeedActivity(Context context, Intent intent, boolean z16);

    void forwardToQzoneVideoCaptureNew(Activity activity, Bundle bundle, int i3);

    void forwardToQzoneVideoCaptureNew(AppRuntime appRuntime, Activity activity, QZoneHelper.UserInfo userInfo, int i3, boolean z16, boolean z17, String str, String str2, boolean z18, boolean z19, String str3, boolean z26, String str4, String str5, boolean z27, boolean z28, boolean z29, boolean z36, String str6, boolean z37, boolean z38, boolean z39, int i16, boolean z46, Bundle bundle);

    void forwardToWriteMood(Activity activity, AppRuntime appRuntime, Intent intent, int i3, boolean z16);

    Intent getJumpQzoneTabIntent(Context context, Intent intent);

    Intent getQQBrowserActivityIntent(Context context);

    Intent getQZoneVideoDownloadActivityIntent(Context context);

    int getQzoneManagerInQQManagerFactory();

    QIPCModule getQzoneVideoSoDownloadModule();

    int getSendSizeSpecNOR();

    int getSendSizeSpecRAW();

    Intent getShortcutIntent(Context context);

    boolean getSimpleQZoneUISwitch();

    boolean isInQZoneEnvironment();

    void killQZoneProcess();

    void launchQZoneGroupAlbumGalleryLayer(Activity activity, QZoneHelper.UserInfo userInfo, Bundle bundle, int i3);

    void putQzoneSourceName(Intent intent);

    void putWebViewPluginPackageName(Intent intent);

    void reportTroopAlbumExp();

    int sendRemoteHandleManagerData(String str, Bundle bundle, boolean z16);

    void startTranslucentBrowserActivityForResult(Context context, String str, int i3, Bundle bundle, String str2, boolean z16, boolean z17);
}

package com.tencent.comic.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;
import mqq.app.ISecurityFileHelper;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes5.dex */
public interface IQQComicUtil extends QRouteApi {
    String addParamToUrl(String str, String str2);

    void fetchReportInfo(Intent intent, boolean z16);

    String getActionId();

    Intent getBackgroundQQComicIntent(AppRuntime appRuntime);

    Class getComicJumpActivityClass();

    ISecurityFileHelper getComicSecurityFileHelper();

    QIPCModule getIpcModule();

    Class<? extends Activity> getProxyActivityClass(String str);

    String getUrl(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    boolean handleParam(AppRuntime appRuntime, Activity activity, Intent intent);

    boolean initPluginBeforeEnter(AppInterface appInterface, Activity activity, Intent intent);

    void initUrlMap(Intent intent);

    boolean isVideoUrl(String str, Intent intent);

    void notifyFirstInObservableChanged(Context context);

    void openQQBrowserActivityForComic(Activity activity, Intent intent, int i3);

    void preloadQQBoodoComic(AppRuntime appRuntime);

    void reportClickEventTo644(AppInterface appInterface, String str, String str2, String str3, int i3, int i16, String... strArr);

    void setDefaultComicTab(String str);
}

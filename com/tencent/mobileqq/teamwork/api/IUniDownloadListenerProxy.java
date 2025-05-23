package com.tencent.mobileqq.teamwork.api;

import android.app.Activity;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IUniDownloadListenerProxy extends QRouteApi {
    void onCreate(AppRuntime appRuntime, Activity activity, TouchWebView touchWebView, boolean z16);

    void onDestroy();

    void setDownloadListener(TouchWebView touchWebView);
}

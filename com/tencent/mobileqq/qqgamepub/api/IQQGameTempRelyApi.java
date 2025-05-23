package com.tencent.mobileqq.qqgamepub.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.view.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQGameTempRelyApi extends QRouteApi {
    void addNightModeMask(Activity activity);

    void bindQQGameWebViewBuilderJavaScript(ArrayList<WebViewPlugin> arrayList);

    void cancelCompressTask(String str);

    a createHeader(QQGameMsgInfo qQGameMsgInfo, Activity activity);

    void exePublicAccountTianshuReport(int i3, int i16, String str, String str2);

    void exitVideoFullScreen();

    Context getCurrentContext(WebViewPlugin.b bVar);

    Map<String, String> getGameMsgInfoMap();

    String getPhotoListCustomizationAIOClassName();

    String getPhotoPreviewCustomizationAIOClassName();

    void handleGcArkDeleteMsg(String str);

    void initPublicAccountChatPieIntent(ActivityURIRequest activityURIRequest);

    boolean isConversationTabShow();

    boolean isInNightMode();

    boolean isToolAppRuntime(AppRuntime appRuntime);

    boolean isVideoFullScreenMode();

    void publicAccountExposureReport(String str, long j3);

    void stopVideo();

    void submitAndExecuteCompress(String str, String str2, jh2.a aVar);
}

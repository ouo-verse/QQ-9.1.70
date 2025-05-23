package com.tencent.mobileqq.teamwork.api;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.teamwork.k;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ITeamWorkFacadeCreator extends QRouteApi {
    ICameraHelper getCameraHelper(WebViewPlugin webViewPlugin);

    String getExportHandlerName();

    String getGroupTeamWorkHandlerName();

    IVoiceInputHelper getIVoiceInputHelper(WebViewPlugin webViewPlugin);

    String getImportHandlerName();

    k getShareUtils(Activity activity, AppInterface appInterface);

    Class getTeamWorkHandlerClass();

    String getTeamWorkHandlerName();

    Dialog getTroopTeamWorkFileSearchDialog(Activity activity, View view, AppInterface appInterface, long j3);
}

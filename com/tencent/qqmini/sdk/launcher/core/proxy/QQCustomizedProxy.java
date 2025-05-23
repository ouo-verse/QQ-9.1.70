package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.StartupReportData;
import com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView;
import com.tencent.qqmini.sdk.launcher.ui.BaseGameNavigationBar;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public abstract class QQCustomizedProxy {
    public BaseGameLoadingView createCustomLoadingView(Context context, MiniAppInfo miniAppInfo) {
        return null;
    }

    public BaseGameNavigationBar createCustomNavigationBar(Context context, MiniAppInfo miniAppInfo) {
        return null;
    }

    public Dialog createQQCenterTextDialog(Context context, int i3, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        return null;
    }

    public boolean disableHeartBeatCheck(MiniAppInfo miniAppInfo) {
        return false;
    }

    public boolean disableNewTask(MiniAppInfo miniAppInfo) {
        return false;
    }

    public boolean enableMiniGameInspect() {
        return false;
    }

    public String getCustomPackageLoadFailToast(Context context, MiniAppInfo miniAppInfo) {
        return null;
    }

    public String getDebugJsPath() {
        return null;
    }

    public String getDebugTritonPath() {
        return null;
    }

    public int getDeviceLevel() {
        return 0;
    }

    public long getRequestLandscapeDelay(Activity activity) {
        return 0L;
    }

    public String getRequiredContainerVersion() {
        return "";
    }

    public boolean isCustomMiniGame(MiniAppInfo miniAppInfo) {
        return false;
    }

    public boolean isMiniAppConsumeBackPress(MiniAppInfo miniAppInfo) {
        return false;
    }

    public boolean needCustomActivityAnim(MiniAppInfo miniAppInfo) {
        return false;
    }

    public void add2MyApps(MiniAppInfo miniAppInfo) {
    }

    public void clearNetEventHandler(Context context) {
    }

    public void openFeedbackPage(IMiniAppContext iMiniAppContext) {
    }

    public void registerSoFilePath(String str) {
    }

    public void reportStartup(StartupReportData startupReportData) {
    }

    public void checkRoamLocalAuthState(Context context, String str) {
    }

    public void fastLogin(MiniAppInfo miniAppInfo, AsyncResult asyncResult) {
    }

    public void getOAID(boolean z16, AsyncResult asyncResult) {
    }

    public void httpToSsoRequest(JSONObject jSONObject, AsyncResult asyncResult) {
    }

    public void isAdded2MyApps(String str, AsyncResult asyncResult) {
    }

    public void setActivityAnim(MiniAppInfo miniAppInfo, Activity activity) {
    }

    public void setNetChangeReceiver(Context context, AsyncObjectResult asyncObjectResult) {
    }

    public void showCallOutPopupWindow(View view, String str) {
    }

    public void checkShowExpireDialog(MiniAppInfo miniAppInfo, Activity activity, JSONObject jSONObject) {
    }

    public void handleMiniExit(Activity activity, BaseRuntime baseRuntime, boolean z16, boolean z17, boolean z18) {
    }
}

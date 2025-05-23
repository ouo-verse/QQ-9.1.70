package com.tencent.mobileqq.qqgamepub.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.gamecenter.wadl.biz.jsplugin.WadlWebViewJsPlugin;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationStrategy;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationStrategy;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopPublicAccountChatPieTempApi;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.gamecenter.view.ImgHeaderView;
import com.tencent.mobileqq.gamecenter.view.TextHeaderView;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.api.impl.l;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.webview.api.IJsApi;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGameTempRelyApiImpl implements IQQGameTempRelyApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQGamePub_QQGameTempRelyApiImpl";

    public QQGameTempRelyApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getPAMsgId(MessageRecord messageRecord) {
        String str = "";
        try {
            String str2 = messageRecord.extStr;
            if (TextUtils.isEmpty(str2)) {
                str2 = messageRecord.mExJsonObject.toString();
            }
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(str2);
            String d16 = PublicAccountEventReport.d(jSONObject.optString(QQHealthReportApiImpl.REPORT_KEY_BYTES_OAC_MSG_EXTEND, ""));
            if (!TextUtils.isEmpty(d16)) {
                return d16;
            }
            String optString = jSONObject.optString(AppConstants.Key.KEY_PUBLIC_ACCOUNT_MSGID, "");
            try {
                if (TextUtils.isEmpty(optString)) {
                    return jSONObject.optString("pa_msgId", "");
                }
                return optString;
            } catch (Throwable th5) {
                th = th5;
                str = optString;
                QLog.e(TAG, 1, "getPAMsgId error =" + th.toString());
                return str;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private long getTaskIdByVideoPath(@NotNull String str) {
        return str.hashCode();
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
    public void addNightModeMask(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity);
        } else {
            SubscribeUtils.a(activity);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
    public void bindQQGameWebViewBuilderJavaScript(ArrayList<WebViewPlugin> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) arrayList);
            return;
        }
        arrayList.add(new WadlWebViewJsPlugin());
        arrayList.add(new com.tencent.mobileqq.qqgamepub.web.d());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQWalletPayJsPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getPayJsPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQWalletCommonJsPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQWalletBluetoothJsPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQQApiPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getUIApiPlugin());
        arrayList.add(new SensorAPIJavaScript());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getDataApiPlugin());
        arrayList.add(new MediaApiPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getVasCommonJsPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQWalletCommonHbJsPlugin());
        arrayList.add(new QWalletMixJsPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getSSOWebviewPlugin());
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
    public void cancelCompressTask(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
            return;
        }
        long taskIdByVideoPath = getTaskIdByVideoPath(str);
        l.d().b(taskIdByVideoPath);
        l.d().f(taskIdByVideoPath);
        QLog.i(TAG, 1, "[cancelCompressTask] videoPath:" + str);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
    public com.tencent.mobileqq.qqgamepub.view.a createHeader(QQGameMsgInfo qQGameMsgInfo, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.mobileqq.qqgamepub.view.a) iPatchRedirector.redirect((short) 8, (Object) this, (Object) qQGameMsgInfo, (Object) activity);
        }
        if (activity != null && !activity.isFinishing()) {
            try {
                if (qQGameMsgInfo == null) {
                    return ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).getMoreMsgHeaderView(activity);
                }
                int i3 = qQGameMsgInfo.msgType;
                if (i3 == 1) {
                    return ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).getGameArkView(activity);
                }
                if (i3 == 2) {
                    return new ImgHeaderView(activity);
                }
                if (i3 == 3) {
                    return new TextHeaderView(activity);
                }
                return ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).getMoreMsgHeaderView(activity);
            } catch (Throwable th5) {
                QLog.d(TAG, 4, "decode header(web) faile:" + th5.getMessage());
                return null;
            }
        }
        QLog.d(TAG, 4, "createHeader fail activity is null");
        return null;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
    public void exePublicAccountTianshuReport(int i3, int i16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), str, str2);
        } else {
            PublicAccountEventReport.b(i3, i16, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
    public void exitVideoFullScreen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        GameCenterVideoViewController a16 = com.tencent.mobileqq.gamecenter.media.c.b().a();
        if (a16 != null) {
            a16.exitFullScreen();
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
    public Context getCurrentContext(WebViewPlugin.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Context) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bVar);
        }
        if (bVar == null) {
            return null;
        }
        Activity a16 = bVar.a();
        while (a16 instanceof BasePluginActivity) {
            a16 = ((BasePluginActivity) a16).getOutActivity();
        }
        return a16;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
    public Map<String, String> getGameMsgInfoMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return com.tencent.mobileqq.gamecenter.util.b.f213409b;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
    public String getPhotoListCustomizationAIOClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return PhotoListCustomizationStrategy.V;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
    public String getPhotoPreviewCustomizationAIOClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return PhotoPreviewCustomizationStrategy.S;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
    public void handleGcArkDeleteMsg(String str) {
        a61.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            return;
        }
        try {
            QLog.d(TAG, 1, "call gc_ark_msg_delete");
            String string = new JSONObject(str).getString("arkViewId");
            Intent intent = new Intent("action_qgame_delete_ad");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity instanceof BaseActivity) {
                intent.putExtra("isAioDeletMsg", true);
                BaseActivity baseActivity = (BaseActivity) topActivity;
                ChatFragment chatFragment = baseActivity.getChatFragment();
                if (chatFragment != null && (cVar = chatFragment.C) != null) {
                    List<ChatMessage> a16 = cVar.f25585j.a();
                    if (a16 != null) {
                        Iterator<ChatMessage> it = a16.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ChatMessage next = it.next();
                            if (string.equals(String.valueOf(next.uniseq))) {
                                ((IEcshopPublicAccountChatPieTempApi) QRoute.api(IEcshopPublicAccountChatPieTempApi.class)).startDelAnimAndDelMsg(baseActivity, next);
                                QQToast.makeText(BaseApplication.getContext(), R.string.f209865gk, 1).show();
                                break;
                            }
                        }
                    }
                }
                return;
            }
            intent.setPackage(MobileQQ.sMobileQQ.getPackageName());
            intent.putExtra("arkViewId", string);
            MobileQQ.sMobileQQ.sendBroadcast(intent);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
    public void initPublicAccountChatPieIntent(ActivityURIRequest activityURIRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activityURIRequest);
            return;
        }
        activityURIRequest.extra().putBoolean("shouldreport", true);
        activityURIRequest.extra().putBoolean("has_unread_msg", false);
        activityURIRequest.extra().putInt("jump_from", 1);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
    public boolean isConversationTabShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime instanceof QQAppInterface) {
            return ((QQAppInterface) waitAppRuntime).isConversationTabShow;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
    public boolean isInNightMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return SubscribeUtils.m();
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
    public boolean isToolAppRuntime(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime)).booleanValue();
        }
        return appRuntime instanceof ToolAppRuntime;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
    public boolean isVideoFullScreenMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        GameCenterVideoViewController a16 = com.tencent.mobileqq.gamecenter.media.c.b().a();
        if (a16 != null && a16.isFullScreenMode()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
    public void publicAccountExposureReport(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3));
        } else {
            PublicAccountEventReport.g(str, j3);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
    public void stopVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        GameCenterVideoViewController a16 = com.tencent.mobileqq.gamecenter.media.c.b().a();
        if (a16 != null) {
            a16.stop();
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
    public void submitAndExecuteCompress(String str, String str2, jh2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, str, str2, aVar);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.e(TAG, 1, "[submitAndExecuteCompress] is not QQAppInterface");
            return;
        }
        if (FileUtils.isEmptyFile(str)) {
            QLog.e(TAG, 1, "[submitAndExecuteCompress] file not exists,path:" + str);
            return;
        }
        l.d().g(getTaskIdByVideoPath(str), new l.a((QQAppInterface) peekAppRuntime, peekAppRuntime.getApp(), str, str2, aVar));
    }
}

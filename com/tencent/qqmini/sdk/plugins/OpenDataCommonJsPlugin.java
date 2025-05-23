package com.tencent.qqmini.sdk.plugins;

import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetPotentialFriendListRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetUserInteractiveStorageRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StInteractiveTemplate;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StUserGameData;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.action.CheckJsServiceAction;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.RequestServer;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.OpenDataDomainUtil;
import com.tencent.qqmini.sdk.utils.WnsUtil;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class OpenDataCommonJsPlugin extends BaseJsPlugin {
    public static final String API_ON_INTERACTIVE_STORAGE_MODIFIED = "onInteractiveStorageModified";
    public static final int SHARE_TARGET_SHARE_CHAT = 5;
    private static final String TAG = "OpenDataCommonJsPlugin";
    private ChannelProxy mChannelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (dialogInterface != null) {
                try {
                    dialogInterface.dismiss();
                } catch (Throwable th5) {
                    QMLog.e(OpenDataCommonJsPlugin.TAG, "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE share cancel error " + th5.getMessage());
                    return;
                }
            }
            OpenDataCommonJsPlugin openDataCommonJsPlugin = OpenDataCommonJsPlugin.this;
            openDataCommonJsPlugin.reportOpenDataShareResultTo4239(((BaseJsPlugin) openDataCommonJsPlugin).mMiniAppContext, "share_modifyFriendInteractiveStorage", "fail", 2, "negative button click");
            QMLog.e(OpenDataCommonJsPlugin.TAG, "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE   share cancel");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            QMLog.e(OpenDataCommonJsPlugin.TAG, "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE share cancel");
            OpenDataCommonJsPlugin openDataCommonJsPlugin = OpenDataCommonJsPlugin.this;
            openDataCommonJsPlugin.reportOpenDataShareResultTo4239(((BaseJsPlugin) openDataCommonJsPlugin).mMiniAppContext, "share_modifyFriendInteractiveStorage", "fail", 2, "cancel");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class c implements DialogInterface.OnClickListener {
        final /* synthetic */ String C;
        final /* synthetic */ String D;
        final /* synthetic */ Boolean E;
        final /* synthetic */ RequestEvent F;
        final /* synthetic */ String G;
        final /* synthetic */ String H;
        final /* synthetic */ int I;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f348220d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f348221e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f348222f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f348223h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f348224i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f348225m;

        c(String str, int i3, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, RequestEvent requestEvent, String str8, String str9, int i16) {
            this.f348220d = str;
            this.f348221e = i3;
            this.f348222f = str2;
            this.f348223h = str3;
            this.f348224i = str4;
            this.f348225m = str5;
            this.C = str6;
            this.D = str7;
            this.E = bool;
            this.F = requestEvent;
            this.G = str8;
            this.H = str9;
            this.I = i16;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (dialogInterface != null) {
                try {
                    dialogInterface.dismiss();
                } catch (Throwable th5) {
                    QMLog.e(OpenDataCommonJsPlugin.TAG, "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + th5);
                    this.F.fail(th5.getMessage());
                    return;
                }
            }
            OpenDataCommonJsPlugin openDataCommonJsPlugin = OpenDataCommonJsPlugin.this;
            openDataCommonJsPlugin.reportOpenDataShareResultTo4239(((BaseJsPlugin) openDataCommonJsPlugin).mMiniAppContext, "share_modifyFriendInteractiveStorage", "success", 1, null);
            OpenDataCommonJsPlugin.this.modifyFriendInteractiveStorage(this.f348220d, this.f348221e, this.f348222f, this.f348223h, this.f348224i, this.f348225m, this.C, this.D, this.E, this.F, this.G, this.H, this.I);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class d implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RequestEvent f348226d;

        d(RequestEvent requestEvent) {
            this.f348226d = requestEvent;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            QMLog.e(OpenDataCommonJsPlugin.TAG, "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE cancel");
            this.f348226d.fail("cancel");
            OpenDataCommonJsPlugin openDataCommonJsPlugin = OpenDataCommonJsPlugin.this;
            openDataCommonJsPlugin.reportOpenDataShareResultTo4239(((BaseJsPlugin) openDataCommonJsPlugin).mMiniAppContext, "share_modifyFriendInteractiveStorage", "fail", 1, "cancel");
        }
    }

    private void doShareAppMsg(String str, boolean z16, boolean z17, final InnerShareData.Builder builder) {
        if (!StringUtil.isEmpty(str) && (z16 || z17)) {
            if (!str.startsWith("http") && !str.startsWith("https")) {
                builder.setSharePicPath(((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str)).setIsLocalPic(true).build().shareAppMessage();
                return;
            } else {
                builder.setSharePicPath(str).build().shareAppMessage();
                return;
            }
        }
        getDefaultImg(new GetScreenshot.Callback() { // from class: com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.9
            @Override // com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback
            public void onGetScreenshot(String str2) {
                if (!str2.startsWith("http") && !str2.startsWith("https")) {
                    builder.setSharePicPath(((MiniAppFileManager) ((BaseJsPlugin) OpenDataCommonJsPlugin.this).mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str2)).setIsLocalPic(true).build().shareAppMessage();
                } else {
                    builder.setSharePicPath(str2).build().shareAppMessage();
                }
            }
        });
    }

    private void getDefaultImg(final GetScreenshot.Callback callback) {
        if (callback == null) {
            return;
        }
        if (this.mMiniAppContext.isMiniGame()) {
            callback.onGetScreenshot(WnsUtil.defaultShareImg());
            QMLog.e(TAG, "[minigame]getDefaultImg, use default share image");
        } else if (GetShareState.obtain(this.mMiniAppContext) != null) {
            if (GetShareState.obtain(this.mMiniAppContext).isGettingScreenShot) {
                QMLog.e(TAG, "getScreenshot isGettingScreenShot now, return directly !");
            } else {
                GetScreenshot.obtain(this.mMiniAppContext, new GetScreenshot.Callback() { // from class: com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.12
                    @Override // com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback
                    public void onGetScreenshot(String str) {
                        callback.onGetScreenshot(str);
                    }
                });
            }
        }
    }

    private String getPath(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.mMiniAppInfo.isEngineTypeMiniGame()) {
                return "miniGamePath";
            }
            return "";
        }
        return str;
    }

    private void getPotentialFriendListImpl(final RequestEvent requestEvent) {
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo == null) {
            QMLog.e(TAG, "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , no appid");
            requestEvent.fail("appid is null");
        } else {
            ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getPotentialFriendList(null, miniAppInfo.appId, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.11
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    QMLog.d(OpenDataCommonJsPlugin.TAG, "getPotentialFriendList receive isSuc= " + z16 + " ret=" + String.valueOf(jSONObject));
                    if (jSONObject == null) {
                        QMLog.e(OpenDataCommonJsPlugin.TAG, "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , ret == null");
                        requestEvent.fail();
                        return;
                    }
                    if (z16) {
                        try {
                            CloudStorage$StGetPotentialFriendListRsp cloudStorage$StGetPotentialFriendListRsp = (CloudStorage$StGetPotentialFriendListRsp) jSONObject.get("response");
                            int i3 = jSONObject.getInt("retCode");
                            String string = jSONObject.getString("errMsg");
                            List<CloudStorage$StUserGameData> list = cloudStorage$StGetPotentialFriendListRsp.data.get();
                            QMLog.d(OpenDataCommonJsPlugin.TAG, "getPotentialFriendList receive retCode= " + i3 + " errMsg=" + string);
                            JSONObject jSONObject2 = new JSONObject();
                            if (i3 == 0 && list != null && list.size() > 0) {
                                JSONArray jSONArray = new JSONArray();
                                for (CloudStorage$StUserGameData cloudStorage$StUserGameData : list) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put(PhotoCategorySummaryInfo.AVATAR_URL, cloudStorage$StUserGameData.avatarUrl.get());
                                    jSONObject3.put("nickname", cloudStorage$StUserGameData.nickname.get());
                                    jSONObject3.put("openid", cloudStorage$StUserGameData.openid.get());
                                    jSONArray.mo162put(jSONObject3);
                                }
                                jSONObject2.put("list", jSONArray);
                                requestEvent.ok(jSONObject2);
                                return;
                            }
                            jSONObject2.put("retErrMsg", string);
                            jSONObject2.put("errCode", i3);
                            QMLog.e(OpenDataCommonJsPlugin.TAG, "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , retCode!=0 or userGameDataList is empty");
                            requestEvent.fail(jSONObject2, "retCode!=0 or userGameDataList is empty");
                            return;
                        } catch (Exception e16) {
                            QMLog.e(OpenDataCommonJsPlugin.TAG, "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error ", e16);
                            requestEvent.fail(e16.getMessage());
                            return;
                        }
                    }
                    QMLog.e(OpenDataCommonJsPlugin.TAG, "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , isSuc false");
                    requestEvent.fail("getPotentialFriendList failed.");
                }
            });
        }
    }

    private void getReactiveFriendListImpl(final RequestEvent requestEvent) {
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo == null) {
            QMLog.e(TAG, "handleNativeRequest API_GET_REACTIVE_FRIEND_LIST error , no appid");
            requestEvent.fail("appid is null");
        } else {
            RequestServer.getInstance().getReactiveFriendList(miniAppInfo.appId, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.10
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    if (z16) {
                        JSONObject jSONObject2 = new JSONObject();
                        JSONArray optJSONArray = jSONObject.optJSONArray("key_result_data");
                        try {
                            if (optJSONArray == null) {
                                jSONObject2.putOpt("list", new JSONArray());
                            } else {
                                jSONObject2.putOpt("list", optJSONArray);
                            }
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                        requestEvent.ok(jSONObject2);
                        return;
                    }
                    QMLog.e(OpenDataCommonJsPlugin.TAG, "getReactiveFriendList fail, retCode: " + jSONObject.optLong("retCode") + "; errMsg : " + jSONObject.optString("errMsg"));
                    requestEvent.fail(jSONObject, null);
                }
            });
        }
    }

    private boolean isFileExists(String str) {
        return new File(((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str)).exists();
    }

    private boolean miniAppNotPageWebviewCall(RequestEvent requestEvent) {
        if (!this.mMiniAppContext.isMiniGame() && !CheckJsServiceAction.obtain(this.mMiniAppContext).isPageWebviewCall(requestEvent.jsService)) {
            requestEvent.fail("forbidden");
            QMLog.e(TAG, "miniapp, not pagewebview call, return.");
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInteractiveStorageModified(JSONObject jSONObject, RequestEvent requestEvent, String str) {
        try {
            jSONObject.put("key", str);
            IMiniAppContext iMiniAppContext = this.mMiniAppContext;
            int i3 = -1;
            if ((iMiniAppContext instanceof BaseRuntime) && iMiniAppContext.isMiniGame()) {
                ((BaseRuntime) this.mMiniAppContext).getJsService().evaluateSubscribeJS(API_ON_INTERACTIVE_STORAGE_MODIFIED, jSONObject.toString(), -1);
                return;
            }
            if (CheckJsServiceAction.obtain(this.mMiniAppContext).isServiceOrMainContext(requestEvent.jsService)) {
                IJsService iJsService = requestEvent.jsService;
                String jSONObject2 = jSONObject.toString();
                if (!this.mIsMiniGame) {
                    i3 = PageAction.obtain(this.mMiniAppContext).getPageId();
                }
                iJsService.evaluateSubscribeJS(API_ON_INTERACTIVE_STORAGE_MODIFIED, jSONObject2, i3);
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "onInteractiveStorageModified error,", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportOpenDataShareResultTo4239(final IMiniAppContext iMiniAppContext, final String str, final String str2, final int i3, final String str3) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.19
            @Override // java.lang.Runnable
            public void run() {
                String str4;
                MiniAppInfo miniAppInfo = iMiniAppContext.getMiniAppInfo();
                String appType = SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo);
                if ("0".equals(appType)) {
                    str4 = PageAction.obtain(iMiniAppContext).getPageUrl();
                } else {
                    str4 = null;
                }
                String str5 = str4;
                SDKMiniProgramLpReportDC04239.report(miniAppInfo, appType, str5, "user_click", "custom_button", str, str2, String.valueOf(i3), str5, str3, null);
            }
        });
    }

    private void showConfirmModificationModel(String str, int i3, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, RequestEvent requestEvent, String str8, String str9, int i16) {
        StringBuilder sb5;
        String str10 = str9 + str8;
        if (i16 > 0) {
            sb5 = new StringBuilder();
            sb5.append("\u786e\u8ba4");
            sb5.append(str8);
            sb5.append(str4);
            sb5.append(i3 * i16);
        } else {
            sb5 = new StringBuilder();
            sb5.append("\u786e\u8ba4");
            sb5.append(str8);
            sb5.append(str4);
        }
        sb5.append(str9);
        sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        sb5.toString();
        if (bool.booleanValue()) {
            modifyFriendInteractiveStorage(str, i3, str2, str3, str4, str5, str6, str7, bool, requestEvent, str8, str9, i16);
            return;
        }
        showQQCustomModel(str10, null, "\u786e\u8ba4" + str8, Boolean.FALSE, "", new c(str, i3, str2, str3, str4, str5, str6, str7, bool, requestEvent, str8, str9, i16), null, new d(requestEvent));
    }

    private void showQQCustomModel(final String str, final String str2, final String str3, final Boolean bool, final String str4, final DialogInterface.OnClickListener onClickListener, final DialogInterface.OnClickListener onClickListener2, final DialogInterface.OnCancelListener onCancelListener) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.18
            @Override // java.lang.Runnable
            public void run() {
                String str5;
                if (((BaseJsPlugin) OpenDataCommonJsPlugin.this).mMiniAppContext.getAttachActivity() != null && !((BaseJsPlugin) OpenDataCommonJsPlugin.this).mMiniAppContext.getAttachActivity().isFinishing()) {
                    try {
                        MiniCustomDialog miniCustomDialog = new MiniCustomDialog(((BaseJsPlugin) OpenDataCommonJsPlugin.this).mMiniAppContext.getAttachActivity(), R.style.mini_sdk_MiniAppInputDialog);
                        miniCustomDialog.setContentView(R.layout.mini_sdk_custom_dialog_temp);
                        if (TextUtils.isEmpty(str)) {
                            str5 = null;
                        } else {
                            str5 = str;
                        }
                        miniCustomDialog.setTitle(str5).setMessage(str2);
                        miniCustomDialog.setPositiveButton(str3, ColorUtils.parseColor("#3CC51F"), onClickListener);
                        if (bool.booleanValue()) {
                            miniCustomDialog.setNegativeButton(str4, ColorUtils.parseColor("#000000"), onClickListener2);
                        }
                        miniCustomDialog.setCanceledOnTouchOutside(true);
                        miniCustomDialog.setOnCancelListener(onCancelListener);
                        miniCustomDialog.show();
                    } catch (Throwable th5) {
                        QMLog.e(OpenDataCommonJsPlugin.TAG, "showQQCustomModel error " + th5.getMessage());
                    }
                }
            }
        });
    }

    @JsEvent({"canUseComponent"})
    public void canUseComponent(RequestEvent requestEvent) {
        if (this.mIsMiniGame) {
            requestEvent.fail("not mini app");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("canUse", true);
            requestEvent.ok(jSONObject);
        } catch (Throwable th5) {
            QMLog.e(TAG, "canUseComponent " + th5);
            requestEvent.fail(th5.getMessage());
        }
    }

    public void doShowFriendInteractiveDialog(String str, String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final RequestEvent requestEvent) {
        showQQCustomModel(str, str2, "\u544a\u8bc9\u4ed6", Boolean.TRUE, "\u4e0b\u6b21\u5427", new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (dialogInterface != null) {
                    try {
                        dialogInterface.dismiss();
                    } catch (Throwable th5) {
                        QMLog.e(OpenDataCommonJsPlugin.TAG, "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE  share error " + th5.getMessage());
                        return;
                    }
                }
                OpenDataCommonJsPlugin.this.shareMessageToFriend(str3, str4, str5, str6, str7, requestEvent);
                OpenDataCommonJsPlugin openDataCommonJsPlugin = OpenDataCommonJsPlugin.this;
                openDataCommonJsPlugin.reportOpenDataShareResultTo4239(((BaseJsPlugin) openDataCommonJsPlugin).mMiniAppContext, "share_modifyFriendInteractiveStorage", "success", 2, null);
            }
        }, new a(), new b());
    }

    @JsEvent({"getFriendCloudStorage"})
    public void getFriendCloudStorage(RequestEvent requestEvent) {
        String[] strArr;
        try {
            if (miniAppNotPageWebviewCall(requestEvent)) {
                return;
            }
            JSONArray optJSONArray = new JSONObject(requestEvent.jsonParams).optJSONArray("keyList");
            if (optJSONArray != null) {
                strArr = new String[optJSONArray.length()];
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    strArr[i3] = (String) optJSONArray.get(i3);
                }
            } else {
                strArr = new String[0];
            }
            getFriendCloudStorage(strArr, requestEvent);
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleNativeRequest getFriendCloudStorage error " + th5.getMessage());
        }
    }

    @JsEvent({"getGroupCloudStorage"})
    public void getGroupCloudStorage(RequestEvent requestEvent) {
        String[] strArr;
        try {
            if (miniAppNotPageWebviewCall(requestEvent)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("shareTicket");
            JSONArray optJSONArray = jSONObject.optJSONArray("keyList");
            if (optJSONArray != null) {
                strArr = new String[optJSONArray.length()];
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    strArr[i3] = (String) optJSONArray.get(i3);
                }
            } else {
                strArr = new String[0];
            }
            getGroupCloudStorage(optString, strArr, requestEvent);
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleNativeRequest getUserCloudStorage error " + th5.getMessage());
        }
    }

    @JsEvent({"getPotentialFriendList"})
    public void getPotentialFriendList(RequestEvent requestEvent) {
        try {
            getPotentialFriendListImpl(requestEvent);
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error " + th5);
            requestEvent.fail(th5.getMessage());
        }
    }

    @JsEvent({"getReactiveFriendList"})
    public void getReactiveFriendList(RequestEvent requestEvent) {
        try {
            getReactiveFriendListImpl(requestEvent);
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error " + th5);
            requestEvent.fail(th5.getMessage());
        }
    }

    @JsEvent({"getUserCloudStorage"})
    public void getUserCloudStorage(RequestEvent requestEvent) {
        String[] strArr;
        try {
            if (miniAppNotPageWebviewCall(requestEvent)) {
                return;
            }
            JSONArray optJSONArray = new JSONObject(requestEvent.jsonParams).optJSONArray("keyList");
            if (optJSONArray != null) {
                strArr = new String[optJSONArray.length()];
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    strArr[i3] = (String) optJSONArray.get(i3);
                }
            } else {
                strArr = new String[0];
            }
            getUserCloudStorage(strArr, requestEvent);
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleNativeRequest getUserCloudStorage error " + th5.getMessage());
        }
    }

    @JsEvent({"getUserInteractiveStorage"})
    public void getUserInteractiveStorage(RequestEvent requestEvent) {
        String[] strArr;
        try {
            JSONArray optJSONArray = new JSONObject(requestEvent.jsonParams).optJSONArray("keyList");
            if (optJSONArray != null) {
                strArr = new String[optJSONArray.length()];
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    strArr[i3] = (String) optJSONArray.get(i3);
                }
            } else {
                strArr = new String[0];
            }
            getUserInteractiveStorage(strArr, requestEvent);
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error " + th5);
            requestEvent.fail(th5.getMessage());
        }
    }

    @JsEvent({"modifyFriendInteractiveStorage"})
    public void modifyFriendInteractiveStorage(RequestEvent requestEvent) {
        String str;
        String str2;
        int i3;
        String str3;
        String str4;
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String string = jSONObject.getString("key");
            int i16 = jSONObject.getInt("opNum");
            String string2 = jSONObject.getString(QCircleDaTongConstant.ElementParamValue.OPERATION);
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("imageUrl");
            String optString3 = jSONObject.optString("imageUrlId");
            Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean("quiet"));
            JSONObject optJSONObject = jSONObject.optJSONObject("friendInfo");
            if (optJSONObject != null) {
                str = optJSONObject.getString("openid");
                str2 = optJSONObject.getString("nickname");
            } else {
                str = "";
                str2 = str;
            }
            if (!TextUtils.isEmpty(this.mApkgInfo.mConfigStr) && (optJSONArray = new JSONObject(this.mApkgInfo.mConfigStr).optJSONArray("modifyFriendInteractiveStorageTemplates")) != null && optJSONArray.length() > 0) {
                int i17 = 0;
                while (i17 < optJSONArray.length()) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i17);
                    JSONArray jSONArray = optJSONArray;
                    if (jSONObject2 != null) {
                        String optString4 = jSONObject2.optString("key");
                        if (!TextUtils.isEmpty(optString4) && optString4.equals(string)) {
                            i3 = jSONObject2.optInt("ratio");
                            str3 = jSONObject2.optString("action");
                            str4 = jSONObject2.optString("object");
                            break;
                        }
                    }
                    i17++;
                    optJSONArray = jSONArray;
                }
            }
            i3 = -1;
            str3 = "";
            str4 = str3;
            if (valueOf.booleanValue()) {
                modifyFriendInteractiveStorage(string, i16, string2, str, str2, optString, optString2, optString3, valueOf, requestEvent, str3, str4, i3);
            } else {
                showConfirmModificationModel(string, i16, string2, str, str2, optString, optString2, optString3, valueOf, requestEvent, str3, str4, i3);
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + th5.getMessage());
            requestEvent.fail();
        }
    }

    @JsEvent({"onMessage"})
    public void onMessage(RequestEvent requestEvent) {
        List<String> list;
        if (!this.mIsMiniGame) {
            requestEvent.fail("not mini game");
            return;
        }
        if (CheckJsServiceAction.obtain(this.mMiniAppContext).isServiceOrMainContext(requestEvent.jsService)) {
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            if (miniAppInfo != null && (list = miniAppInfo.whiteList) != null && list.contains("onMessage")) {
                requestEvent.jsService.evaluateSubscribeJS("onMessage", requestEvent.jsonParams, 0);
                return;
            } else {
                QMLog.e(TAG, "\u5f00\u653e\u57df\u8c03\u7528\u4e86\u672a\u6388\u6743\u7684\u79c1\u6709API: postMessage -> onMessage");
                return;
            }
        }
        requestEvent.jsService.evaluateSubscribeJS("onMessage", requestEvent.jsonParams, 0);
    }

    @JsEvent({"removeUserCloudStorage"})
    public void removeUserCloudStorage(RequestEvent requestEvent) {
        String[] strArr;
        try {
            JSONArray optJSONArray = new JSONObject(requestEvent.jsonParams).optJSONArray("keyList");
            if (optJSONArray != null) {
                strArr = new String[optJSONArray.length()];
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    strArr[i3] = (String) optJSONArray.get(i3);
                }
            } else {
                strArr = new String[0];
            }
            removeUserCloudStorage(strArr, requestEvent);
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleNativeRequest removeUserCloudStorage error " + th5.getMessage());
        }
    }

    @JsEvent({"setMessageToFriendQuery"})
    public void setMessageToFriendQuery(RequestEvent requestEvent) {
        String str;
        try {
            int optInt = new JSONObject(requestEvent.jsonParams).optInt("shareMessageToFriendScene", -1);
            if (optInt == -1) {
                requestEvent.fail();
            }
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            if (miniAppInfo != null) {
                miniAppInfo.friendMessageQuery = "shareMessageToFriendScene=" + optInt;
                if (this.mMiniAppInfo.isEngineTypeMiniApp()) {
                    this.mMiniAppInfo.friendMessageQuery = AppBrandUtil.getUrlWithoutParams(PageAction.obtain(this.mMiniAppContext).getPageUrl()) + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + this.mMiniAppInfo.friendMessageQuery;
                    JSONObject queryJson = AppBrandUtil.getQueryJson(PageAction.obtain(this.mMiniAppContext).getPageUrl());
                    queryJson.put("shareMessageToFriendScene", optInt);
                    StringBuilder sb5 = new StringBuilder(AppBrandUtil.getUrlWithoutParams(PageAction.obtain(this.mMiniAppContext).getPageUrl()));
                    Iterator keys = queryJson.keys();
                    int i3 = 0;
                    while (keys.hasNext()) {
                        String str2 = (String) keys.next();
                        if (!TextUtils.isEmpty(str2)) {
                            if (i3 == 0) {
                                str = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                            } else {
                                str = ContainerUtils.FIELD_DELIMITER;
                            }
                            sb5.append(str);
                            sb5.append(str2);
                            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                            sb5.append(queryJson.getString(str2));
                            i3++;
                        }
                    }
                    this.mMiniAppInfo.friendMessageQuery = sb5.toString();
                    QMLog.d(TAG, "friendMessageQuery : " + this.mMiniAppInfo.friendMessageQuery);
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", true);
            requestEvent.ok(jSONObject);
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleNativeRequest API_SET_MESSAGE_TO_FRIEND_QUERY error ", th5);
            requestEvent.fail(th5.getMessage());
        }
    }

    @JsEvent({"setUserCloudStorage"})
    public void setUserCloudStorage(RequestEvent requestEvent) {
        try {
            JSONArray optJSONArray = new JSONObject(requestEvent.jsonParams).optJSONArray("KVDataList");
            HashMap<String, String> hashMap = new HashMap<>();
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                    hashMap.put(jSONObject.get("key").toString(), jSONObject.get("value").toString());
                }
            }
            setUserCloudStorage(hashMap, requestEvent);
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleNativeRequest setUserCloudStorage error " + th5.getMessage());
        }
    }

    @JsEvent({"shareMessageToFriend"})
    public void shareMessageToFriend(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            JSONObject jSONObject2 = jSONObject.getJSONObject("friendInfo");
            shareMessageToFriend(jSONObject2.getString("openid"), jSONObject2.getString("nickname"), jSONObject.optString("title"), jSONObject.optString("imageUrl"), jSONObject.optString("imageUrlId"), requestEvent);
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND error " + th5);
            requestEvent.fail(th5.getMessage());
        }
    }

    public void removeUserCloudStorage(String[] strArr, final RequestEvent requestEvent) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("removeUserCloudStorage appid:");
        sb5.append(this.mMiniAppInfo.appId);
        sb5.append(", keys:");
        sb5.append(strArr != null ? Arrays.toString(strArr) : "");
        QMLog.i(TAG, sb5.toString());
        this.mChannelProxy.removeUserCloudStorage(this.mMiniAppInfo.appId, strArr, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.5
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                QMLog.i(OpenDataCommonJsPlugin.TAG, "removeUserCloudStorage callback appid:" + ((BaseJsPlugin) OpenDataCommonJsPlugin.this).mMiniAppInfo.appId + ", isSuc" + z16 + ", ret:" + String.valueOf(jSONObject));
                JSONObject jSONObject2 = new JSONObject();
                try {
                    if (z16) {
                        jSONObject2.put("state", "success");
                        requestEvent.ok(jSONObject2);
                    } else {
                        jSONObject2.put("state", "fail");
                        requestEvent.fail(jSONObject2, null);
                    }
                } catch (Throwable th5) {
                    QMLog.e(OpenDataCommonJsPlugin.TAG, "removeUserCloudStorage error " + th5.getMessage());
                    requestEvent.fail();
                }
            }
        });
    }

    private void getUserInteractiveStorage(String[] strArr, final RequestEvent requestEvent) {
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo == null) {
            QMLog.e(TAG, "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , no appid");
            requestEvent.fail("appid is null");
        } else {
            ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getUserInteractiveStorage(null, miniAppInfo.appId, strArr, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.6
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    QMLog.d(OpenDataCommonJsPlugin.TAG, "getUserInteractiveStorage receive isSuc= " + z16 + " ret=" + String.valueOf(jSONObject));
                    if (jSONObject == null) {
                        QMLog.e(OpenDataCommonJsPlugin.TAG, "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , ret == null");
                        requestEvent.fail("request request is null.");
                        return;
                    }
                    if (z16) {
                        try {
                            CloudStorage$StGetUserInteractiveStorageRsp cloudStorage$StGetUserInteractiveStorageRsp = (CloudStorage$StGetUserInteractiveStorageRsp) jSONObject.get("response");
                            int i3 = jSONObject.getInt("retCode");
                            String string = jSONObject.getString("errMsg");
                            String str = cloudStorage$StGetUserInteractiveStorageRsp.encryptedData.get();
                            String str2 = cloudStorage$StGetUserInteractiveStorageRsp.f24953iv.get();
                            JSONObject jSONObject2 = new JSONObject();
                            if (i3 == 0) {
                                jSONObject2.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, str);
                                jSONObject2.put("iv", str2);
                                requestEvent.ok(jSONObject2);
                            } else {
                                jSONObject2.put("retErrMsg", string);
                                jSONObject2.put("errCode", i3);
                                QMLog.e(OpenDataCommonJsPlugin.TAG, "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE " + jSONObject2.toString());
                                requestEvent.fail(jSONObject2, "");
                            }
                            return;
                        } catch (Exception e16) {
                            QMLog.e(OpenDataCommonJsPlugin.TAG, "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error ", e16);
                            requestEvent.fail(e16.getMessage());
                            return;
                        }
                    }
                    QMLog.e(OpenDataCommonJsPlugin.TAG, "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , isSuc false");
                    requestEvent.fail("request failed.");
                }
            });
        }
    }

    public void getFriendCloudStorage(String[] strArr, final RequestEvent requestEvent) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getFriendCloudStorage appid:");
        sb5.append(this.mMiniAppInfo.appId);
        sb5.append(", keys:");
        sb5.append(strArr != null ? Arrays.toString(strArr) : "");
        QMLog.i(TAG, sb5.toString());
        this.mChannelProxy.getFriendCloudStorage(this.mMiniAppInfo.appId, strArr, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                String str;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("getFriendCloudStorage callback appid:");
                sb6.append(((BaseJsPlugin) OpenDataCommonJsPlugin.this).mMiniAppInfo.appId);
                sb6.append(", isSuc:");
                sb6.append(z16);
                sb6.append(", ret:");
                if (jSONObject != null) {
                    str = jSONObject.toString();
                } else {
                    str = "";
                }
                sb6.append(str);
                QMLog.i(OpenDataCommonJsPlugin.TAG, sb6.toString());
                JSONObject jSONObject2 = new JSONObject();
                try {
                    if (z16) {
                        jSONObject2.put("state", "success");
                        if (jSONObject != null && jSONObject.get("data") != null) {
                            jSONObject2.put("data", jSONObject.get("data"));
                        } else {
                            jSONObject2.put("data", jSONObject);
                        }
                        requestEvent.ok(jSONObject2);
                        return;
                    }
                    jSONObject2.put("state", "fail");
                    requestEvent.fail(jSONObject2, null);
                } catch (Throwable th5) {
                    QMLog.e(OpenDataCommonJsPlugin.TAG, "getFriendCloudStorage error " + th5.getMessage());
                    requestEvent.fail();
                }
            }
        });
    }

    public void getUserCloudStorage(String[] strArr, final RequestEvent requestEvent) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getUserCloudStorage appid:");
        sb5.append(this.mMiniAppInfo.appId);
        sb5.append(", keys:");
        sb5.append(strArr != null ? Arrays.toString(strArr) : "");
        QMLog.i(TAG, sb5.toString());
        if (strArr == null || requestEvent.jsService == null) {
            return;
        }
        this.mChannelProxy.getUserCloudStorage(this.mMiniAppInfo.appId, strArr, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.1
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                QMLog.i(OpenDataCommonJsPlugin.TAG, "getUserCloudStorage callback appid:" + ((BaseJsPlugin) OpenDataCommonJsPlugin.this).mMiniAppInfo.appId + ", isSuc" + z16 + ", ret:" + String.valueOf(jSONObject));
                JSONObject jSONObject2 = new JSONObject();
                try {
                    if (z16) {
                        jSONObject2.put("state", "success");
                        if (jSONObject != null && jSONObject.has("KVDataList")) {
                            jSONObject2.put("KVDataList", jSONObject.get("KVDataList"));
                        } else {
                            jSONObject2.put("KVDataList", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                        }
                        requestEvent.ok(jSONObject2);
                        return;
                    }
                    jSONObject2.put("state", "fail");
                    requestEvent.fail(jSONObject2, null);
                } catch (Throwable th5) {
                    QMLog.e(OpenDataCommonJsPlugin.TAG, "getUserCloudStorage error " + th5.getMessage());
                    requestEvent.fail();
                }
            }
        });
    }

    public void getGroupCloudStorage(String str, String[] strArr, final RequestEvent requestEvent) {
        if (TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("state", "fail");
                requestEvent.fail(jSONObject, "\u5f53\u524d\u5c0f\u7a0b\u5e8f\u4e0d\u662f\u4ece\u7fa4\u5206\u4eab\u5361\u7247\u6253\u5f00");
                return;
            } catch (JSONException e16) {
                QMLog.e(TAG, "getGroupCloudStorage error " + e16.getMessage());
                requestEvent.fail();
                return;
            }
        }
        this.mChannelProxy.getGroupCloudStorage(this.mMiniAppInfo.appId, str, strArr, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.3
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject2) {
                QMLog.i(OpenDataCommonJsPlugin.TAG, "getGroupCloudStorage callback appid:" + ((BaseJsPlugin) OpenDataCommonJsPlugin.this).mMiniAppInfo.appId + ", isSuc" + z16 + ", ret:" + String.valueOf(jSONObject2));
                JSONObject jSONObject3 = new JSONObject();
                try {
                    if (z16) {
                        jSONObject3.put("state", "success");
                        if (jSONObject2 != null && jSONObject2.get("data") != null) {
                            jSONObject3.put("data", jSONObject2.get("data"));
                        } else {
                            jSONObject3.put("data", jSONObject2);
                        }
                        requestEvent.ok(jSONObject3);
                        return;
                    }
                    jSONObject3.put("state", "fail");
                    requestEvent.fail(jSONObject3, null);
                } catch (Throwable th5) {
                    QMLog.e(OpenDataCommonJsPlugin.TAG, "getGroupCloudStorage error " + th5.getMessage());
                    requestEvent.fail();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shareMessageToFriend(String str, String str2, String str3, String str4, String str5, RequestEvent requestEvent) {
        ShareState obtain = GetShareState.obtain(this.mMiniAppContext);
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        String str6 = "";
        if (miniAppInfo != null) {
            if (!TextUtils.isEmpty(miniAppInfo.friendMessageQuery)) {
                str6 = "" + this.mMiniAppInfo.friendMessageQuery;
            }
            obtain.shareAppid = this.mMiniAppInfo.appId;
        }
        obtain.shareEvent = requestEvent.event;
        obtain.shareCallbackId = requestEvent.callbackId;
        obtain.shareOpenid = str;
        obtain.requestEvent = requestEvent;
        doShareAppMsg(str4, OpenDataDomainUtil.getInstance().isDomainValid(str4), !TextUtils.isEmpty(str4) && isFileExists(str4), new InnerShareData.Builder().setShareSource(11).setShareTarget(5).setTitle(this.mMiniAppInfo.name).setSummary(str3).setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachActivity()).setEntryPath(getPath(str6)).setShareChatModel(new ShareChatModel(0, 0L, str2)).setWithShareTicket(obtain.withShareTicket).setRecvOpenId(str).setShareInMiniProcess(obtain.isShareInMiniProcess));
    }

    public void setUserCloudStorage(HashMap<String, String> hashMap, final RequestEvent requestEvent) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setUserCloudStorage appid:");
        sb5.append(this.mMiniAppInfo.appId);
        sb5.append(", kvData:");
        sb5.append(hashMap != null ? hashMap.toString() : "");
        QMLog.i(TAG, sb5.toString());
        this.mChannelProxy.setUserCloudStorage(this.mMiniAppInfo.appId, hashMap, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.4
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                String str;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("setUserCloudStorage callback appid:");
                sb6.append(((BaseJsPlugin) OpenDataCommonJsPlugin.this).mMiniAppInfo.appId);
                sb6.append(", isSuc");
                sb6.append(z16);
                sb6.append(", ret:");
                if (jSONObject != null) {
                    str = jSONObject.toString();
                } else {
                    str = "";
                }
                sb6.append(str);
                QMLog.i(OpenDataCommonJsPlugin.TAG, sb6.toString());
                JSONObject jSONObject2 = new JSONObject();
                try {
                    if (z16) {
                        jSONObject2.put("state", "success");
                        requestEvent.ok(jSONObject2);
                    } else {
                        jSONObject2.put("state", "fail");
                        requestEvent.fail(jSONObject2, null);
                    }
                } catch (Throwable th5) {
                    QMLog.e(OpenDataCommonJsPlugin.TAG, "setUserCloudStorage error " + th5.getMessage());
                    requestEvent.fail();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void modifyFriendInteractiveStorage(final String str, final int i3, final String str2, final String str3, final String str4, final String str5, String str6, final String str7, final Boolean bool, final RequestEvent requestEvent, final String str8, final String str9, final int i16) {
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo == null) {
            QMLog.e(TAG, "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no appid");
            requestEvent.fail("appid is null.");
            return;
        }
        final String str10 = miniAppInfo.appId;
        final String str11 = miniAppInfo.shareId;
        if (!bool.booleanValue()) {
            if (TextUtils.isEmpty(str3)) {
                QMLog.e(TAG, "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no openid");
                requestEvent.fail("openid is null.");
                return;
            }
        } else if (TextUtils.isEmpty(str11)) {
            QMLog.e(TAG, "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no shareId");
            requestEvent.fail("shareId is null.");
            return;
        }
        boolean isDomainValid = OpenDataDomainUtil.getInstance().isDomainValid(str6);
        boolean z16 = !TextUtils.isEmpty(str6) && new File(((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str6)).exists();
        if (!StringUtil.isEmpty(str6) && (isDomainValid || z16)) {
            modifyFriendInteractiveStorage(str, i3, str2, str3, str4, str5, str6, str7, bool, requestEvent, str8, str9, i16, str10, str11);
        } else {
            QMLog.e(TAG, "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , image illegal");
            getDefaultImg(new GetScreenshot.Callback() { // from class: com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.7
                @Override // com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback
                public void onGetScreenshot(String str12) {
                    OpenDataCommonJsPlugin.this.modifyFriendInteractiveStorage(str, i3, str2, str3, str4, str5, str12, str7, bool, requestEvent, str8, str9, i16, str10, str11);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void modifyFriendInteractiveStorage(final String str, int i3, String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final Boolean bool, final RequestEvent requestEvent, final String str8, final String str9, int i16, String str10, String str11) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(str, i3 + "");
        CloudStorage$StInteractiveTemplate cloudStorage$StInteractiveTemplate = new CloudStorage$StInteractiveTemplate();
        cloudStorage$StInteractiveTemplate.action.set(str8);
        cloudStorage$StInteractiveTemplate.object.set(str9);
        cloudStorage$StInteractiveTemplate.ratio.set(i16);
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).modifyFriendInteractiveStorage(null, str10, str3, str11, i3, str2, hashMap, bool.booleanValue(), cloudStorage$StInteractiveTemplate, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.8
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                QMLog.d(OpenDataCommonJsPlugin.TAG, "modifyFriendInteractiveStorage receive isSuc= " + z16 + " ret=" + String.valueOf(jSONObject));
                if (jSONObject == null) {
                    QMLog.e(OpenDataCommonJsPlugin.TAG, "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , ret == null");
                    requestEvent.fail("request ret is null.");
                    return;
                }
                if (z16) {
                    try {
                        int i17 = jSONObject.getInt("retCode");
                        String string = jSONObject.getString("errMsg");
                        JSONObject jSONObject2 = new JSONObject();
                        if (i17 == 0) {
                            requestEvent.ok();
                            if (!TextUtils.isEmpty(str5) && !bool.booleanValue()) {
                                OpenDataCommonJsPlugin.this.doShowFriendInteractiveDialog(str9 + str8, "\u5df2" + str8 + "\n\u9a6c\u4e0aQQ\u544a\u8bc9\u597d\u53cb\uff1f", str3, str4, str5, str6, str7, requestEvent);
                            }
                            OpenDataCommonJsPlugin.this.onInteractiveStorageModified(jSONObject2, requestEvent, str);
                            return;
                        }
                        jSONObject2.put("errMsg", string);
                        jSONObject2.put("errCode", i17);
                        QMLog.e(OpenDataCommonJsPlugin.TAG, "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE " + jSONObject2.toString());
                        requestEvent.fail(jSONObject2, "");
                        return;
                    } catch (Exception e16) {
                        QMLog.e(OpenDataCommonJsPlugin.TAG, "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error ", e16);
                        requestEvent.fail();
                        return;
                    }
                }
                QMLog.e(OpenDataCommonJsPlugin.TAG, "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , isSuc false");
                requestEvent.fail("request failed.");
            }
        });
    }
}

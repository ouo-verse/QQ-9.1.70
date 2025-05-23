package com.tencent.qqmini.sdk.core.proxy.service;

import NS_COMM.COMM;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StInteractiveTemplate;
import NS_MINI_INTERFACE.INTERFACE$StGetAuthListRsp;
import NS_MINI_INTERFACE.INTERFACE$StUserAuthInfo;
import NS_MINI_INTERFACE.INTERFACE$StUserSettingInfo;
import NS_MINI_SHARE.MiniProgramShare$StAdaptShareInfoReq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ark.ark;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.manager.HttpServer;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.launcher.core.auth.UserSettingInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncMultiObjResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IFlutterProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayerUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAIOEntranceProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PluginInfo;
import com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem;
import com.tencent.qqmini.sdk.launcher.model.TouchInfo;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.request.AddPhoneNumberRequest;
import com.tencent.qqmini.sdk.request.BatchGetContactRequest;
import com.tencent.qqmini.sdk.request.BatchGetUserInfoRequest;
import com.tencent.qqmini.sdk.request.BookShelfInsertRequest;
import com.tencent.qqmini.sdk.request.BookShelfQueryRequest;
import com.tencent.qqmini.sdk.request.BookShelfUpdateRequest;
import com.tencent.qqmini.sdk.request.CheckBindingStateRequest;
import com.tencent.qqmini.sdk.request.CheckNavigateRightRequest;
import com.tencent.qqmini.sdk.request.CheckOfferIdRequest;
import com.tencent.qqmini.sdk.request.CheckSessionRequest;
import com.tencent.qqmini.sdk.request.CheckWxPayUrlRequest;
import com.tencent.qqmini.sdk.request.ContentAccelerateRequest;
import com.tencent.qqmini.sdk.request.DataReportRequest;
import com.tencent.qqmini.sdk.request.DcReportRequest;
import com.tencent.qqmini.sdk.request.DelPhoneNumberRequest;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.qqmini.sdk.request.GetAdRequest;
import com.tencent.qqmini.sdk.request.GetAppInfoByIdRequest;
import com.tencent.qqmini.sdk.request.GetAppInfoByLinkRequest;
import com.tencent.qqmini.sdk.request.GetAuthListsRequest;
import com.tencent.qqmini.sdk.request.GetCloudStorageRequest;
import com.tencent.qqmini.sdk.request.GetContainerInfoByIdRequest;
import com.tencent.qqmini.sdk.request.GetFirstPageByTypeRequest;
import com.tencent.qqmini.sdk.request.GetFormIdRequest;
import com.tencent.qqmini.sdk.request.GetFriendCloudStorageRequest;
import com.tencent.qqmini.sdk.request.GetGroupCloudStorageRequest;
import com.tencent.qqmini.sdk.request.GetLoginCodeRequest;
import com.tencent.qqmini.sdk.request.GetNativeAppInfoRequest;
import com.tencent.qqmini.sdk.request.GetNewBaseLibRequest;
import com.tencent.qqmini.sdk.request.GetPotentialFriendListRequest;
import com.tencent.qqmini.sdk.request.GetProfileRequest;
import com.tencent.qqmini.sdk.request.GetRobotUinRequest;
import com.tencent.qqmini.sdk.request.GetSDKOpenKeyTokenRequest;
import com.tencent.qqmini.sdk.request.GetShareInfoRequest;
import com.tencent.qqmini.sdk.request.GetTcbTicketRequest;
import com.tencent.qqmini.sdk.request.GetTransRoomIdRequest;
import com.tencent.qqmini.sdk.request.GetUserAppInfoRequest;
import com.tencent.qqmini.sdk.request.GetUserGroupInfoRequest;
import com.tencent.qqmini.sdk.request.GetUserHealthDataRequest;
import com.tencent.qqmini.sdk.request.GetUserInfoExtraRequest;
import com.tencent.qqmini.sdk.request.GetUserInteractiveStorageRequest;
import com.tencent.qqmini.sdk.request.GetUserSettingRequest;
import com.tencent.qqmini.sdk.request.JudgeTimingRequest;
import com.tencent.qqmini.sdk.request.MiniAppGetGroupShareInfoRequest;
import com.tencent.qqmini.sdk.request.ModifyFriendInteractiveStorageRequest;
import com.tencent.qqmini.sdk.request.PayRequest;
import com.tencent.qqmini.sdk.request.ProtoBufRequest;
import com.tencent.qqmini.sdk.request.QueryCurrencyRequest;
import com.tencent.qqmini.sdk.request.RealTimeLogReportRequest;
import com.tencent.qqmini.sdk.request.RemoveCloudStorageRequest;
import com.tencent.qqmini.sdk.request.ReportExecuteRequest;
import com.tencent.qqmini.sdk.request.ReportShareRequest;
import com.tencent.qqmini.sdk.request.SetAuthsRequest;
import com.tencent.qqmini.sdk.request.SetAvatarRequest;
import com.tencent.qqmini.sdk.request.SetCloudStorageRequest;
import com.tencent.qqmini.sdk.request.SetUserAppLikeRequest;
import com.tencent.qqmini.sdk.request.UseUserAppRequest;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tenpay.proxy.dlg.location.QbAddrData;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ProxyService(proxy = ChannelProxy.class)
/* loaded from: classes23.dex */
public class ChannelProxyDefault implements ChannelProxy {
    private static final String TAG = "ChannelProxyDefault";
    private boolean useHttpDirectly;

    public ChannelProxyDefault() {
        boolean z16;
        if (!QUAUtil.isAlienApp() && !QUAUtil.isDemoApp()) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.useHttpDirectly = z16;
    }

    private int getGTK(String str) {
        int i3 = 5381;
        if (TextUtils.isEmpty(str)) {
            return 5381;
        }
        int length = str.length();
        for (int i16 = 0; i16 < length; i16++) {
            i3 += (i3 << 5) + str.charAt(i16);
        }
        return Integer.MAX_VALUE & i3;
    }

    private Map<String, String> getHeaderMap(JSONObject jSONObject) {
        if (jSONObject.has("header")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            Iterator keys = optJSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, optJSONObject.optString(str));
            }
            return hashMap;
        }
        return null;
    }

    private void handleRequest(ProtoBufRequest protoBufRequest, AsyncResult asyncResult) {
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        try {
            byte[] encode = protoBufRequest.encode();
            QMLog.w(TAG, "sendData " + protoBufRequest);
            if (this.useHttpDirectly) {
                sendDataByHttpServer(protoBufRequest, asyncResult, encode);
            } else {
                sendDataByProxy(protoBufRequest, asyncResult, miniAppProxy, encode);
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "handleRequest Exception", e16);
            if (asyncResult != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("retCode", -1);
                    jSONObject.put("errMsg", "\u6570\u636e\u7f16\u7801\u9519\u8bef");
                } catch (Throwable unused) {
                }
                asyncResult.onReceiveResult(false, jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWnsCgiRequestSucceed(int i3, byte[] bArr, Map<String, List<String>> map, boolean z16, boolean z17, AsyncResult asyncResult) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            if (bArr != null) {
                if (z16) {
                    jSONObject.put("data", new JSONObject(new String(bArr)));
                } else {
                    if (z17) {
                        str = Base64.encodeToString(bArr, 0);
                    } else {
                        str = new String(bArr);
                    }
                    jSONObject.put("data", str);
                }
            } else {
                jSONObject.put("data", "");
            }
            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, i3);
            jSONObject.put("wnsCode", 0);
            jSONObject.put("header", JSONUtil.headerToJson(map));
            asyncResult.onReceiveResult(true, jSONObject);
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleMessage wnsCgiRequest exception ", th5);
            asyncResult.onReceiveResult(false, null);
        }
    }

    private void sendDataByHttpServer(final ProtoBufRequest protoBufRequest, final AsyncResult asyncResult, byte[] bArr) {
        HttpServer.sendData(bArr, new MiniAppProxy.SenderListener() { // from class: com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault.6
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.SenderListener
            public boolean onReply(int i3, byte[] bArr2, String str) {
                QMLog.w(ChannelProxyDefault.TAG, "useHttpDirectly recvData " + protoBufRequest + ",retCode = " + i3);
                if (i3 == 0) {
                    if (asyncResult != null) {
                        JSONObject response = protoBufRequest.getResponse(bArr2);
                        if (response != null) {
                            if (response.optInt("retCode", 0) == 0) {
                                asyncResult.onReceiveResult(true, response);
                            } else {
                                asyncResult.onReceiveResult(false, response);
                            }
                        } else {
                            asyncResult.onReceiveResult(false, new JSONObject());
                        }
                    }
                } else {
                    AsyncResult asyncResult2 = asyncResult;
                    if (asyncResult2 != null) {
                        asyncResult2.onReceiveResult(false, new JSONObject());
                    }
                }
                return true;
            }
        });
    }

    private void sendDataByProxy(final ProtoBufRequest protoBufRequest, final AsyncResult asyncResult, MiniAppProxy miniAppProxy, byte[] bArr) {
        miniAppProxy.sendData(bArr, new MiniAppProxy.SenderListener() { // from class: com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault.5
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.SenderListener
            public boolean onReply(int i3, byte[] bArr2, String str) {
                QMLog.w(ChannelProxyDefault.TAG, "recvData " + protoBufRequest + ",retCode = " + i3);
                if (i3 == 0) {
                    if (asyncResult != null) {
                        JSONObject response = protoBufRequest.getResponse(bArr2);
                        if (response != null) {
                            if (response.optInt("retCode", 0) == 0) {
                                asyncResult.onReceiveResult(true, response);
                            } else {
                                asyncResult.onReceiveResult(false, response);
                            }
                        } else {
                            asyncResult.onReceiveResult(false, new JSONObject());
                        }
                    }
                } else {
                    AsyncResult asyncResult2 = asyncResult;
                    if (asyncResult2 != null) {
                        asyncResult2.onReceiveResult(false, new JSONObject());
                    }
                }
                return true;
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void addPhoneNumber(String str, String str2, String str3, int i3, AsyncResult asyncResult) {
        handleRequest(new AddPhoneNumberRequest(str, str2, str3, i3), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean addPublicAccount(String str, String str2, AsyncResult asyncResult) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void batchGetContact(ArrayList<String> arrayList, AsyncResult asyncResult) {
        handleRequest(new BatchGetContactRequest(arrayList), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void buildCookieForRedirect(String str) {
        QMLog.i(TAG, "buildCookieForRedirect redirectUrl:" + str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void checkBindingState(String str, String str2, int i3, AsyncResult asyncResult) {
        handleRequest(new CheckBindingStateRequest(str, str2, i3), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void checkNavigateRight(String str, String str2, AsyncResult asyncResult) {
        handleRequest(new CheckNavigateRightRequest(str, str2), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void checkOfferId(String str, String str2, AsyncResult asyncResult) {
        handleRequest(new CheckOfferIdRequest(null, str, str2), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void checkSession(String str, AsyncResult asyncResult) {
        handleRequest(new CheckSessionRequest(str), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void checkWxPayUrl(String str, String str2, AsyncResult asyncResult) {
        handleRequest(new CheckWxPayUrlRequest(str, str2), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void dataReport(byte[] bArr, AsyncResult asyncResult) {
        handleRequest(new DataReportRequest(bArr), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public String decodeQR(byte[] bArr, int i3, int i16, int i17, int i18, int i19, int i26) {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void delPhoneNumber(String str, String str2, AsyncResult asyncResult) {
        handleRequest(new DelPhoneNumberRequest(str, str2), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getAppInfoById(String str, String str2, String str3, AsyncResult asyncResult) {
        handleRequest(new GetAppInfoByIdRequest(null, str, 1, 0, str2, str3, null), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getAppInfoByLink(String str, int i3, AsyncResult asyncResult) {
        handleRequest(new GetAppInfoByLinkRequest(str, i3), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getAuthList(String str, final ChannelProxy.AuthListResult authListResult) {
        GetAuthListsRequest getAuthListsRequest = new GetAuthListsRequest(null, str);
        handleRequest(getAuthListsRequest, new AsyncResult() { // from class: com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault.1
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                if (z16 && jSONObject != null) {
                    Object opt = jSONObject.opt("authList");
                    if (opt instanceof byte[]) {
                        INTERFACE$StGetAuthListRsp iNTERFACE$StGetAuthListRsp = new INTERFACE$StGetAuthListRsp();
                        try {
                            iNTERFACE$StGetAuthListRsp.mergeFrom((byte[]) opt);
                            for (INTERFACE$StUserAuthInfo iNTERFACE$StUserAuthInfo : iNTERFACE$StGetAuthListRsp.auths.get()) {
                                UserAuthInfo userAuthInfo = new UserAuthInfo();
                                userAuthInfo.scope = iNTERFACE$StUserAuthInfo.scope.get();
                                userAuthInfo.desc = iNTERFACE$StUserAuthInfo.desc.get();
                                userAuthInfo.authState = iNTERFACE$StUserAuthInfo.authState.get();
                                arrayList.add(userAuthInfo);
                            }
                            for (INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo : iNTERFACE$StGetAuthListRsp.settings.get()) {
                                UserSettingInfo userSettingInfo = new UserSettingInfo();
                                userSettingInfo.settingItem = iNTERFACE$StUserSettingInfo.settingItem.get();
                                userSettingInfo.authState = iNTERFACE$StUserSettingInfo.authState.get();
                                userSettingInfo.desc = iNTERFACE$StUserSettingInfo.desc.get();
                            }
                            ChannelProxy.AuthListResult authListResult2 = authListResult;
                            if (authListResult2 != null) {
                                authListResult2.onReceiveResult(true, arrayList, arrayList2);
                                return;
                            }
                            return;
                        } catch (InvalidProtocolBufferMicroException e16) {
                            QMLog.e(ChannelProxyDefault.TAG, "getSetting, InvalidProtocolBufferMicroException:" + e16);
                            e16.printStackTrace();
                        }
                    }
                }
                ChannelProxy.AuthListResult authListResult3 = authListResult;
                if (authListResult3 != null) {
                    authListResult3.onReceiveResult(false, arrayList, arrayList2);
                }
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getAuthListForSubscribe(String str, final AsyncResult asyncResult) {
        handleRequest(new GetAuthListsRequest(null, str), new AsyncResult() { // from class: com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                AsyncResult asyncResult2 = asyncResult;
                if (asyncResult2 != null) {
                    asyncResult2.onReceiveResult(z16, jSONObject);
                }
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public JSONArray getChooseMessageTempFilesArray(Intent intent) {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getContainerInfoById(String str, String str2, String str3, AsyncResult asyncResult) {
        HttpServer.requestContainerInfo(new GetContainerInfoByIdRequest(str, 1, 0, str2, str3, null), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getContentAccelerate(String str, String str2, int i3, Map<String, String> map, AsyncResult asyncResult) {
        handleRequest(new ContentAccelerateRequest(null, str, str2, i3, map), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public String getDeviceInfo() {
        return QUAUtil.getSimpleDeviceInfo(AppLoaderFactory.g().getContext());
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public IFlutterProxy getFlutterProxy() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getFormId(String str, AsyncResult asyncResult) {
        handleRequest(new GetFormIdRequest(str), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getFriendCloudStorage(String str, String[] strArr, AsyncResult asyncResult) {
        handleRequest(new GetFriendCloudStorageRequest(strArr, str), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getGameFloatEnableConfig(String str, AsyncResult asyncResult) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isShowGameBoxFloatEnable", false);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        asyncResult.onReceiveResult(true, jSONObject);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getGameLaunchConfig(String str, AsyncResult asyncResult) {
        asyncResult.onReceiveResult(false, null);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getGameTaskTicket(String str, AsyncResult asyncResult) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ticket", 1000);
            jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, 1);
            asyncResult.onReceiveResult(true, jSONObject);
        } catch (Exception unused) {
            asyncResult.onReceiveResult(true, null);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getGdtAd(String str, int i3, String str2, String str3, String str4, HashMap<String, String> hashMap, AsyncResult asyncResult) {
        handleRequest(new GetAdRequest(str, i3, str2, str3, str4, hashMap), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getGdtAdInfo(String str, int i3, String str2, AsyncResult asyncResult) {
        handleRequest(new GetAdInfoRequest(str, i3, str2), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public Drawable getGifDrawable(String str) {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getGroupCloudStorage(String str, String str2, String[] strArr, AsyncResult asyncResult) {
        handleRequest(new GetGroupCloudStorageRequest(strArr, str2, str), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getGroupShareInfo(String str, String str2, AsyncResult asyncResult) {
        handleRequest(new MiniAppGetGroupShareInfoRequest(null, str, str2), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getLatestUserKey(String str, AsyncResult asyncResult) {
        try {
            asyncResult.onReceiveResult(true, new JSONObject("{\"iv\":\"2onir8cw9dhwy3cm\",\"encryptKey\":\"0/cYuEbbyOUs7GbI8zV8Ig==\",\"expireTime\":38,\"version\":1662017064} "));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public IMediaPlayer getMediaPlayer() {
        return new DefaultMediaPlayer();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public IMediaPlayerUtil getMediaPlayerUtil() {
        return new IMediaPlayerUtil() { // from class: com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault.7
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayerUtil
            public int getContentFlag(String str) {
                return 0;
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayerUtil
            public String getUrl(String str) {
                return str;
            }
        };
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getMidasConsumeResult(String str, String str2, int i3, int i16, int i17, int i18, int i19, String str3, String str4, AsyncResult asyncResult) {
        handleRequest(new PayRequest(str, str2, i3, i16, i17, i18, i19, str3, str4), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public MiniAIOEntranceProxy getMiniAIOEntranceView(Context context, String str) {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getMiniAppStoreAppList(int i3, AsyncResult asyncResult) {
        handleRequest(new GetFirstPageByTypeRequest(i3), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public Object getMiniGameUserAgreementData(String str) {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getNativeAppInfoForJump(String str, String str2, String str3, int i3, AsyncResult asyncResult) {
        handleRequest(new GetNativeAppInfoRequest(null, str, str2, str3, i3), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getPhoneNumber(String str, AsyncResult asyncResult) {
        handleRequest(new com.tencent.qqmini.sdk.request.a(str), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getPotentialFriendList(COMM.StCommonExt stCommonExt, String str, AsyncResult asyncResult) {
        handleRequest(new GetPotentialFriendListRequest(stCommonExt, str), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getRobotUin(String str, AsyncResult asyncResult) {
        handleRequest(new GetRobotUinRequest(null, str), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public int getRunTimeReportRate() {
        return 100;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getSDKOpenKeyToken(COMM.StCommonExt stCommonExt, AsyncResult asyncResult) {
        handleRequest(new GetSDKOpenKeyTokenRequest(stCommonExt), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public long getServerTime() {
        return 0L;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getShareInfo(MiniProgramShare$StAdaptShareInfoReq miniProgramShare$StAdaptShareInfoReq, AsyncResult asyncResult) {
        handleRequest(new GetShareInfoRequest(miniProgramShare$StAdaptShareInfoReq), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getTcbTicket(String str, String str2, AsyncResult asyncResult) {
        handleRequest(new GetTcbTicketRequest(null, str, str2), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public ChannelProxy.SoLoaderOption getTissueSoLoaderOption() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getUserAppInfo(COMM.StCommonExt stCommonExt, ArrayList<String> arrayList, AsyncResult asyncResult) {
        handleRequest(new GetUserAppInfoRequest(stCommonExt, arrayList), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getUserCloudStorage(String str, String[] strArr, AsyncResult asyncResult) {
        handleRequest(new GetCloudStorageRequest(strArr, str), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getUserGroupInfo(COMM.StCommonExt stCommonExt, String str, String str2, long j3, AsyncResult asyncResult) {
        handleRequest(new GetUserGroupInfoRequest(str, str2, j3, stCommonExt), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getUserHealthData(String str, AsyncResult asyncResult) {
        handleRequest(new GetUserHealthDataRequest(null, str), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getUserInfo(String str, boolean z16, String str2, AsyncResult asyncResult) {
        handleRequest(new GetProfileRequest(str, z16, str2), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getUserInfoExtra(String str, AsyncResult asyncResult) {
        handleRequest(new GetUserInfoExtraRequest(str), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getUserInfoOpenData(String str, String str2, String[] strArr, AsyncResult asyncResult) {
        handleRequest(new BatchGetUserInfoRequest(str, str2, strArr), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getUserInteractiveStorage(COMM.StCommonExt stCommonExt, String str, String[] strArr, AsyncResult asyncResult) {
        handleRequest(new GetUserInteractiveStorageRequest(stCommonExt, str, strArr), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getUserSetting(String str, String str2, String str3, ArrayList<String> arrayList, AsyncResult asyncResult) {
        handleRequest(new GetUserSettingRequest(str, str2, str3), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public String getUserTheme() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public AbsVideoPlayer getVideoPlayer() {
        return new VideoPlayerDefault();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void httpReport(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        String string = bundle.getString("log_key");
        String[] stringArray = bundle.getStringArray("data");
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < stringArray.length; i3++) {
            sb5.append(stringArray[i3]);
            if (i3 < stringArray.length - 1) {
                sb5.append(QbAddrData.DATA_SPLITER);
            }
        }
        ((RequestProxy) ProxyManager.get(RequestProxy.class)).request("https://q.qq.com/report/dc/" + string, sb5.toString().getBytes(), null, "POST", 60, new RequestProxy.RequestListener() { // from class: com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault.3
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener
            public void onRequestFailed(int i16, String str) {
                QMLog.e(ChannelProxyDefault.TAG, "httpReport onRequestFailed code = " + i16);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener
            public void onRequestSucceed(int i16, byte[] bArr, Map<String, List<String>> map) {
                QMLog.d(ChannelProxyDefault.TAG, "httpReport onRequestSucceed");
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener
            public void onRequestHeadersReceived(int i16, Map<String, List<String>> map) {
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void insertBookShelf(String str, String str2, ArrayList<String> arrayList, AsyncResult asyncResult) {
        handleRequest(new BookShelfInsertRequest(str, str2, arrayList), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean isGooglePlayVersion() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void joinGroupByTags(String str, String[] strArr, AsyncResult asyncResult) {
        QMLog.i(TAG, "joinGroupByTags: appId=" + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errMsg", "Not implement joinGroupByTags cgi");
        } catch (JSONException unused) {
        }
        asyncResult.onReceiveResult(false, jSONObject);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void judgeTiming(String str, int i3, int i16, int i17, long j3, int i18, int i19, String str2, int i26, String str3, int i27, COMM.StCommonExt stCommonExt, String str4, String str5, AsyncResult asyncResult) {
        handleRequest(new JudgeTimingRequest(str, i3, i16, i17, j3, i18, i19, str2, i26, str3, i27, stCommonExt, str4, str5), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean jump2PublicAccount(Context context, String str, String str2) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void launchAddPhoneNumberFragment(Activity activity, Intent intent, int i3) {
        MiniFragmentLauncher.startForResult(activity, intent, i3, MiniFragmentLauncher.FragmentType.FRAGMENT_ADD_PHONE_NUMBER);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void launchPhoneNumberManagementFragment(Activity activity, Intent intent, int i3) {
        MiniFragmentLauncher.startForResult(activity, intent, i3, MiniFragmentLauncher.FragmentType.FRAGMENT_PHONE_NUMBER_MANAGEMENT);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void launchSubMsgPermissionSettingFragment(Activity activity, Intent intent, int i3) {
        MiniFragmentLauncher.startForResult(activity, intent, i3, MiniFragmentLauncher.FragmentType.FRAGMENT_SUB_MSG_PERMISSION_SETTING);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void login(String str, AsyncResult asyncResult) {
        handleRequest(new GetLoginCodeRequest(str), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void modifyFriendInteractiveStorage(COMM.StCommonExt stCommonExt, String str, String str2, String str3, int i3, String str4, HashMap<String, String> hashMap, boolean z16, CloudStorage$StInteractiveTemplate cloudStorage$StInteractiveTemplate, AsyncResult asyncResult) {
        handleRequest(new ModifyFriendInteractiveStorageRequest(stCommonExt, str, str2, str3, i3, str4, hashMap, z16, cloudStorage$StInteractiveTemplate), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean openGroup(Context context, String str, AsyncResult asyncResult) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean openPermissionSettingsActivity(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("key_appid", str);
        intent.putExtra("key_name", str2);
        MiniFragmentLauncher.startForResult((Activity) context, intent, 5, MiniFragmentLauncher.FragmentType.FRAGMENT_PERMISSION_SETTING);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean openQzonePublish(IMiniAppContext iMiniAppContext, Activity activity, String str, MiniAppInfo miniAppInfo) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean openRobotProfileCard(Context context, String str, String str2) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void queryBookShelf(String str, ArrayList<String> arrayList, AsyncResult asyncResult) {
        handleRequest(new BookShelfQueryRequest(str, arrayList), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void queryCurrency(String str, String str2, int i3, int i16, AsyncResult asyncResult) {
        handleRequest(new QueryCurrencyRequest(null, str2, str, i3, i16), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void queryMiniGameUserAgreement(String str, AsyncResult asyncResult) {
        try {
            asyncResult.onReceiveResult(true, new JSONObject("{\n\t\"is_compulsory\": true,\n\t\"isSigned\": false,\n\t\"appid\": \"123455\",\n\t\"version\": \"1123\",\n\t\"title\": \"\u7528\u6237\u534f\u8bae\u53ca\u9690\u79c1\u653f\u7b56\u6982\u8981\",\n\t\"text\": \"\u8bf7\u4f60\u52a1\u5fc5\u9605\u8bfb\u3001\u5145\u5206\u7406\u89e3\u300a\u670d\u52a1\u534f\u8bae\u300b\u548c\u300a\u9690\u79c1\u653f\u7b56\u300b\u5404\u6761\u6b3e\uff0c\u5982\u9700\u5feb\u901f\u3001\u627c\u8981\u4e86\u89e3\u6211\u4eec\u5982\u4f55\u6536\u96c6\u60a8\u7684\u4fe1\u606f\uff0c\u53ef\u4ee5\u53c2\u8003\u300aQQ\u9690\u79c1\u4fdd\u62a4\u6307\u5f15\u6458\u8981\u300b\u3002\u4f60\u53ef\u4ee5\u5728\u201c\u9690\u79c1\u8bbe\u7f6e\u201d\u4e2d\u67e5\u770b\u3001\u53d8\u66f4\u3001\u5220\u9664\u4f60\u7684\u4e2a\u4eba\u4fe1\u606f\u5e76\u7ba1\u7406\u4f60\u7684\u6388\u6743\u3002\\n\\n\u672a\u7ecf\u4f60\u7684\u6388\u6743\u540c\u610f\uff0c\u6211\u4eec\u4e0d\u4f1a\u4e3b\u52a8\u5411\u4efb\u4f55\u7b2c\u4e09\u65b9\u5171\u4eab\u4f60\u7684\u4e2a\u4eba\u4fe1\u606f\u3002\u4f60\u53ef\u4ee5\u901a\u8fc7\u300aQQ\u7b2c\u4e09\u65b9\u4fe1\u606f\u5171\u4eab\u6e05\u5355\u300b\u4e86\u89e3\u672c\u8f6f\u4ef6\u63a5\u5165\u7684\u7b2c\u4e09\u65b9SDK\u670d\u52a1\u5546\u7684\u5177\u4f53\u4fe1\u606f\u4ee5\u53ca\u5176\u4ed6\u6211\u4eec\u4e0e\u7b2c\u4e09\u65b9\u5171\u4eab\u4fe1\u606f\u7684\u60c5\u51b5\u3002\\n\\n\u5982\u679c\u4f60\u662f14\u5468\u5c81\u4ee5\u4e0b\u7684\u672a\u6210\u5e74\u4eba\uff0c\u4f60\u9700\u8981\u548c\u4f60\u7684\u76d1\u62a4\u4eba\u4e00\u8d77\u4ed4\u7ec6\u9605\u8bfb\u300a\u513f\u7ae5\u9690\u79c1\u4fdd\u62a4\u58f0\u660e\u300b\uff0c\u5e76\u5728\u5f81\u5f97\u4f60\u7684\u76d1\u62a4\u4eba\u540c\u610f\u540e\uff0c\u4f7f\u7528\u6211\u4eec\u7684\u4ea7\u54c1\u3001\u670d\u52a1\u6216\u5411\u6211\u4eec\u63d0\u4f9b\u4fe1\u606f\u3002\\n\\n\u4f60\u53ef\u9605\u8bfb\u300a\u670d\u52a1\u534f\u8bae\u300b\u300a\u9690\u79c1\u653f\u7b56\u300b\u300aQQ\u9690\u79c1\u4fdd\u62a4\u6307\u5f15\u6458\u8981\u300b\u300a\u513f\u7ae5\u9690\u79c1\u4fdd\u62a4\u58f0\u660e\u300b\u300a\u6743\u9650\u4f7f\u7528\u89c4\u5219\u300b\u4ee5\u53ca\u300aQQ\u7b2c\u4e09\u65b9\u4fe1\u606f\u5171\u4eab\u6e05\u5355\u300b\u4e86\u89e3\u8be6\u7ec6\u4fe1\u606f\u3002\u5982\u4f60\u540c\u610f\uff0c\u8bf7\u70b9\u51fb\u201c\u540c\u610f\u201d\u5f00\u59cb\u63a5\u53d7\u6211\u4eec\u7684\u670d\u52a1\u3002\",\n\t\"links\": [{\n\t\t\t\"linkText\": \"\u300a\u670d\u52a1\u534f\u8bae\u300b\",\n\t\t\t\"url\": \"https://ti.qq.com/agreement/index.html\"\n\t\t},\n\t\t{\n\t\t\t\"linkText\": \"\u300a\u9690\u79c1\u653f\u7b56\u300b\",\n\t\t\t\"url\": \"https://ti.qq.com/doc/redirect/qq-privacy-guild\"\n\t\t}\n\t]\n}"));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void realTimeLogReport(String str, String str2, String str3, String[] strArr, ArrayList<RealTimeLogItem> arrayList, AsyncResult asyncResult) {
        handleRequest(new RealTimeLogReportRequest(str, str2, str3, strArr, arrayList), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void removeUserCloudStorage(String str, String[] strArr, AsyncResult asyncResult) {
        handleRequest(new RemoveCloudStorageRequest(strArr, str), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void report(byte[] bArr, String str, String str2, AsyncResult asyncResult) {
        handleRequest(new DcReportRequest(bArr, str, str2), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void reportBeacon(@NonNull ChannelProxy.BeaconReportCategory beaconReportCategory, @NonNull String str, @Nullable Map<String, String> map) {
        QMLog.d(TAG, "reportBeacon() called with: category = [" + beaconReportCategory + "], eventName = [" + str + "], param = [" + map + "]");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void reportExecute(String str, int i3, String str2, String str3, AsyncResult asyncResult) {
        handleRequest(new ReportExecuteRequest(str, i3, str2, str3), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void reportShare(COMM.StCommonExt stCommonExt, long j3, String str, int i3, int i16, int i17, int i18, String str2, AsyncResult asyncResult) {
        handleRequest(new ReportShareRequest(j3, str, i3, i16, i17, i18, str2), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void reportTrafficFlow(int i3, String str, String str2, String str3, int i16) {
        QMLog.i(TAG, "reportTrafficFlow: scene=" + str + ", url=" + str3 + ", flowAmount=" + i16);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void setAuth(String str, UserAuthInfo userAuthInfo, AsyncResult asyncResult) {
        INTERFACE$StUserAuthInfo iNTERFACE$StUserAuthInfo = new INTERFACE$StUserAuthInfo();
        iNTERFACE$StUserAuthInfo.scope.set(userAuthInfo.scope);
        if (!TextUtils.isEmpty(userAuthInfo.desc)) {
            iNTERFACE$StUserAuthInfo.desc.set(userAuthInfo.desc);
        }
        iNTERFACE$StUserAuthInfo.authState.set(userAuthInfo.authState);
        handleRequest(new SetAuthsRequest(null, str, iNTERFACE$StUserAuthInfo), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void setPersonalizeInfo(String str, String str2, int i3, String str3, String str4, AsyncResult asyncResult) {
        handleRequest(new SetAvatarRequest(null, str, str2, i3, str3, str4), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void setUserAppLike(boolean z16, COMM.StCommonExt stCommonExt, String str, AsyncResult asyncResult) {
        handleRequest(new SetUserAppLikeRequest(stCommonExt, str, z16 ? 1 : 0), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void setUserCloudStorage(String str, HashMap<String, String> hashMap, AsyncResult asyncResult) {
        handleRequest(new SetCloudStorageRequest(hashMap, str), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean setWebviewCookie(Context context, List<String> list, ChannelProxy.SetCookieCallback setCookieCallback) {
        setCookieCallback.onFinish();
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void signMiniGameUserAgreement(String str, String str2, boolean z16, AsyncResult asyncResult) {
        asyncResult.onReceiveResult(true, null);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean startAddFriendActivity(Context context, String str, String str2, String str3) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean startBrowserSupportHeaderActivityForResult(Activity activity, String str, Bundle bundle, int i3) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean startChooseMessageFileActivityForResult(Activity activity, int i3, String str, int i16) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean startRedpacketTranslucentBrowserActivityForResult(Activity activity, String str, Bundle bundle, int i3) {
        Intent intent = new Intent();
        intent.putExtra("url", str);
        intent.putExtra(IPCConst.KEY_ORIENTATION_LANDSCAPE, false);
        intent.putExtras(bundle);
        intent.putExtra("public_fragment_window_feature", 1);
        MiniFragmentLauncher.startTranslucentForResult(activity, intent, i3, MiniFragmentLauncher.FragmentType.FRAGMENT_TRANSLUCENT_BROWSER);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean startTransparentBrowserActivityForResult(Activity activity, String str, Bundle bundle, int i3) {
        Intent intent = new Intent();
        intent.putExtra("url", str);
        intent.putExtras(bundle);
        intent.putExtra("public_fragment_window_feature", 1);
        MiniFragmentLauncher.startTranslucentForResult(activity, intent, i3, MiniFragmentLauncher.FragmentType.FRAGMENT_TRANSLUCENT_BROWSER);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void subscribePublicAccount(String str, AsyncResult asyncResult) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errorMsg", "not support in this app");
            asyncResult.onReceiveResult(false, jSONObject);
        } catch (JSONException e16) {
            QMLog.e(TAG, "subscribePublicAccount: default result fail.", e16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean tianshuReport(TianShuAccess.AdItem adItem, String str, int i3) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean tianshuRequestAdv(Context context, String str, int i3, int i16, int i17, AsyncResult asyncResult) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void transForRoomId(String str, String str2, AsyncResult asyncResult) {
        handleRequest(new GetTransRoomIdRequest(str, str2), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean updateBaseLib(String str, boolean z16, boolean z17, AsyncResult asyncResult) {
        QMLog.i(TAG, "[MiniEng] doUpdateBaseLib nocheck=" + z16 + ", force=" + z17);
        if (!z16 && !z17) {
            if (System.currentTimeMillis() - StorageUtil.getPreference().getLong("baselib_min_update_time", 0L) <= 0) {
                QMLog.i(TAG, "[MiniEng] updateBaseLib \u5728\u65f6\u95f4\u95f4\u9694\u5185\uff0c\u6682\u65f6\u4e0d\u66f4\u65b0");
                return false;
            }
        }
        handleRequest(new GetNewBaseLibRequest(str, 0), asyncResult);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void updateBookshelfReadtime(String str, String str2, String str3, AsyncResult asyncResult) {
        handleRequest(new BookShelfUpdateRequest(str, str2, str3), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean updateEntryList(String str) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void useUserApp(String str, int i3, int i16, String str2, String str3, COMM.StCommonExt stCommonExt, AsyncResult asyncResult) {
        handleRequest(new UseUserAppRequest(stCommonExt, str, i3, i16, str2, str3), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean wnsCgiRequest(JSONObject jSONObject, final AsyncResult asyncResult) {
        String str;
        byte[] bArr;
        if (asyncResult == null) {
            return false;
        }
        if (jSONObject == null) {
            asyncResult.onReceiveResult(false, new JSONObject());
            return false;
        }
        try {
            Map<String, String> headerMap = getHeaderMap(jSONObject);
            String optString = jSONObject.optString("url");
            if (jSONObject.has("data")) {
                str = jSONObject.optString("data");
            } else {
                str = null;
            }
            String optString2 = jSONObject.optString("method", "GET");
            final boolean equalsIgnoreCase = jSONObject.optString("dataType").equalsIgnoreCase(ark.ARKMETADATA_JSON);
            final boolean equals = jSONObject.optString("responseType").equals("base64");
            if (TextUtils.isEmpty(optString)) {
                asyncResult.onReceiveResult(false, null);
                return false;
            }
            if (TextUtils.isEmpty(optString2)) {
                asyncResult.onReceiveResult(false, null);
                return false;
            }
            RequestProxy requestProxy = (RequestProxy) ProxyManager.get(RequestProxy.class);
            if (str != null) {
                bArr = str.getBytes();
            } else {
                bArr = null;
            }
            requestProxy.request(optString, bArr, headerMap, optString2, 60000, new RequestProxy.RequestListener() { // from class: com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault.4
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener
                public void onRequestFailed(int i3, String str2) {
                    QMLog.e(ChannelProxyDefault.TAG, "onRequestFailed ");
                    asyncResult.onReceiveResult(false, null);
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener
                public void onRequestSucceed(int i3, byte[] bArr2, Map<String, List<String>> map) {
                    ChannelProxyDefault.this.handleWnsCgiRequestSucceed(i3, bArr2, map, equalsIgnoreCase, equals, asyncResult);
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener
                public void onRequestHeadersReceived(int i3, Map<String, List<String>> map) {
                }
            });
            return true;
        } catch (Throwable th5) {
            QMLog.e(TAG, "performWnsCgiRequest ", th5);
            asyncResult.onReceiveResult(false, null);
            return false;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void reportBeacon(@NonNull ChannelProxy.BeaconReportCategory beaconReportCategory, @NonNull String str, @Nullable Map<String, String> map, boolean z16, boolean z17) {
        QMLog.d(TAG, "reportBeacon() called with: category = [" + beaconReportCategory + "], eventName = [" + str + "], param = [" + map + "], isRealTimeEvent = [" + z16 + "], isImmediatelyUpload = [" + z17 + "]");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getAppInfoById(String str, String str2, String str3, String str4, AsyncResult asyncResult) {
        handleRequest(new GetAppInfoByIdRequest(null, str, 1, 0, str2, str3, str4), asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void onInitFinish() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void clearMiniGameUserAgreementData(String str) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void downloadQQBrowser(String str) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void startDownloadX5(IMiniAppContext iMiniAppContext) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void updateTouchInfoList(ArrayList<TouchInfo> arrayList) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void uploadUserLog(String str) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void addGroupApp(IMiniAppContext iMiniAppContext, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void ffmpegExecCommand(String[] strArr, ChannelProxy.ICommandListenr iCommandListenr) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getFloatBubble(String str, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void saveMiniGameUserAgreementData(String str, Object obj) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void setUserAppTop(MiniAppInfo miniAppInfo, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void closeFloatBubble(String str, String str2, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void doGameRaffle(String str, String str2, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getGameRaffleMaterial(String str, String str2, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getGroupAppStatus(IMiniAppContext iMiniAppContext, String str, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void openSchemeOrUrl(Context context, String str, boolean z16) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void sendSmsCodeRequest(String str, String str2, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void syncForceGroundAndRefreshBadge(Activity activity, String str, String str2) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void updateUserSetting(String str, INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void verifyPlugin(String str, ArrayList<PluginInfo> arrayList, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void sendVerifySmsCodeRequest(String str, String str2, String str3, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void springHbReport(String str, int i3, int i16, Map<String, String> map, String str2) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void showMiniGameUserAgreementDialog(Activity activity, String str, String str2, SpannableString spannableString, MovementMethod movementMethod, boolean z16, AsyncMultiObjResult asyncMultiObjResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void showDialog(Activity activity, String str, String str2, String str3, String str4, AsyncMultiObjResult asyncMultiObjResult) {
    }
}

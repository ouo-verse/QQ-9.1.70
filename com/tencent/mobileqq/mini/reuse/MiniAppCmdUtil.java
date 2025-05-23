package com.tencent.mobileqq.mini.reuse;

import NS_COMM.COMM;
import NS_MINI_AD.MiniAppAd$ContextInfo;
import NS_MINI_AD.MiniAppAd$DebugInfo;
import NS_MINI_AD.MiniAppAd$DeviceInfo;
import NS_MINI_AD.MiniAppAd$PositionInfo;
import NS_MINI_AD.MiniAppAd$StGetAdReq;
import NS_MINI_AD.MiniAppAd$StGetAdRsp;
import NS_MINI_AD.MiniAppAd$StGetMemberStateRsp;
import NS_MINI_AD.MiniAppAd$UserInfo;
import NS_MINI_APP_PAY.MiniAppMidasPay$StGamePayRsp;
import NS_MINI_APP_PAY.MiniAppMidasPay$StQueryStarCurrencyRsp;
import NS_MINI_APP_SEARCH.SEARCH$StLocalSearchDataRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetPotentialFriendListRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetReactiveFriendListRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetUserInteractiveStorageRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StInteractiveTemplate;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StModifyFriendInteractiveStorageRsp;
import NS_MINI_INTERFACE.INTERFACE$StBatchQueryAppInfoRsp;
import NS_MINI_INTERFACE.INTERFACE$StGetPhoneNumberRsp;
import NS_MINI_INTERFACE.INTERFACE$StGetSwitchListRsp;
import NS_MINI_INTERFACE.INTERFACE$StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE$StPhoneNumber;
import NS_MINI_INTERFACE.INTERFACE$StSetUserSwitchRsp;
import NS_MINI_INTERFACE.INTERFACE$StUsageGuideMedia;
import NS_MINI_INTERFACE.INTERFACE$StUsageGuideStyle;
import NS_MINI_INTERFACE.INTERFACE$StUseUserAppRsp;
import NS_MINI_INTERFACE.INTERFACE$StUserAppInfo;
import NS_MINI_INTERFACE.INTERFACE$StUserAuthInfo;
import NS_MINI_INTERFACE.INTERFACE$StUserSettingInfo;
import NS_MINI_INTERFACE.INTERFACE$UseUserInfo;
import NS_MINI_SHARE.MiniProgramShare$StAdaptShareInfoReq;
import NS_MINI_SHARE.MiniProgramShare$StGetGroupShareInfoRsp;
import NS_MINI_SHARE.MiniProgramShare$StSendArkMsgRsp;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.xd.c1;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.apkg.ApkgConfigManager;
import com.tencent.mobileqq.mini.apkg.CommExtInfo;
import com.tencent.mobileqq.mini.apkg.ExtConfigInfo;
import com.tencent.mobileqq.mini.apkg.PluginInfo;
import com.tencent.mobileqq.mini.apkg.RecommendAppInfo;
import com.tencent.mobileqq.mini.apkg.UseUserInfo;
import com.tencent.mobileqq.mini.app.PreCacheManager;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.network.http.HttpCmdManager;
import com.tencent.mobileqq.mini.network.http.HttpCmdResult;
import com.tencent.mobileqq.mini.network.http.httpRequest.HttpGetAppInfoByLinkRequest;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.servlet.AddRecentPlayRequest;
import com.tencent.mobileqq.mini.servlet.BatchGetUserInfoServlet;
import com.tencent.mobileqq.mini.servlet.BatchQueryAppInfoRequest;
import com.tencent.mobileqq.mini.servlet.BookShelfInsertServlet;
import com.tencent.mobileqq.mini.servlet.BookShelfQueryServlet;
import com.tencent.mobileqq.mini.servlet.BookShelfUpdateServlet;
import com.tencent.mobileqq.mini.servlet.CMShowSetPetStatusServlet;
import com.tencent.mobileqq.mini.servlet.CheckBindingStateServlet;
import com.tencent.mobileqq.mini.servlet.CloudStorageServlet;
import com.tencent.mobileqq.mini.servlet.CreateUpdatableMsgServlet;
import com.tencent.mobileqq.mini.servlet.DoGameRaffleServlet;
import com.tencent.mobileqq.mini.servlet.FollowServlet;
import com.tencent.mobileqq.mini.servlet.GetCMShowInfoServlet;
import com.tencent.mobileqq.mini.servlet.GetGameRaffleMaterialServlet;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.mini.servlet.GetHotSearchAppsRequest;
import com.tencent.mobileqq.mini.servlet.GetHotSearchAppsV2Request;
import com.tencent.mobileqq.mini.servlet.GetPotentialFriendListRequest;
import com.tencent.mobileqq.mini.servlet.GetPotentialFriendListServlet;
import com.tencent.mobileqq.mini.servlet.GetReactiveFriendListRequest;
import com.tencent.mobileqq.mini.servlet.GetReactiveFriendListServlet;
import com.tencent.mobileqq.mini.servlet.GetRecommendAppListRequest;
import com.tencent.mobileqq.mini.servlet.GetUserAppListRequest;
import com.tencent.mobileqq.mini.servlet.GetUserAppListRequestV2;
import com.tencent.mobileqq.mini.servlet.GetUserAppListRequestV3;
import com.tencent.mobileqq.mini.servlet.GetUserInfoExtraRequest;
import com.tencent.mobileqq.mini.servlet.GetUserInteractiveStorageRequest;
import com.tencent.mobileqq.mini.servlet.GetUserInteractiveStorageServlet;
import com.tencent.mobileqq.mini.servlet.GetWeixinSDKAppInfoServlet;
import com.tencent.mobileqq.mini.servlet.GetWxAppUrlServlet;
import com.tencent.mobileqq.mini.servlet.GuessYouLikeRequest;
import com.tencent.mobileqq.mini.servlet.LocalSearchDataRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppAddPhoneNumberServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppBatchGetContactServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppBatchQueryAppInfoServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppChangeShareImageUrlServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppCheckNavigateRightServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppCheckOfferIdServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppCheckSessionServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppContentAccelerateServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppDataReportServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppDcReportServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppDelPhoneNumberServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppDelUserAppServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGeneralServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetAdRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppGetAppInfoByIdForSDKServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetAppInfoByIdServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetAppInfoByLinkForSDKServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetAppInfoByLinkServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetAuthListServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetContainerInfoByIdForSDKServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetExtConfigDetailServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetFormIdServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameBoxOptionsServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGroupShareInfoRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGroupShareInfoServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetHotSearchAppsServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetHotSearchAppsV2Servlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetKuolieApplistServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetLaunchConfigServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetLoginCodeServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetNativeAppInfoServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetNewBaseLibForSDKServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetNewBaseLibServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetPhoneNumberServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetPrivacyDetailServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetProfileServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetRecommendAppListServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetRobotUinServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetRoleGroupInfoServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetShareInfoServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetSwitchListRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppGetSwitchListServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTcbTicketServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTinyIdServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetUserAppInfoServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetUserAppListServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetUserAppListServletV2;
import com.tencent.mobileqq.mini.servlet.MiniAppGetUserAppListServletV3;
import com.tencent.mobileqq.mini.servlet.MiniAppGetUserGroupInfoServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetUserInfoExtraServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetUserSettingServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGuessYouLikeServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppLocalSearchDataServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppObserver;
import com.tencent.mobileqq.mini.servlet.MiniAppOpenChannelAbstractServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppRealTimeLogReportServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppReportLogFileServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppSearchAppServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppSendArkMsgRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppSendArkMsgServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppSetAuthsServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppSetGameBoxOptionsServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppSetUserAppLikeServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppSetUserAppTopServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppSetUserSwitchRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppSetUserSwitchServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppStoreGetAppListServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppTranRoomIdServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppUpdateUserSettingServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppUseUserAppServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppUserHealthDataServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppVerifyPluginServlet;
import com.tencent.mobileqq.mini.servlet.MiniGameAddRecentPlayServlet;
import com.tencent.mobileqq.mini.servlet.MiniMidasConsumeServlet;
import com.tencent.mobileqq.mini.servlet.MiniMidasQueryServlet;
import com.tencent.mobileqq.mini.servlet.MiniReportShareServlet;
import com.tencent.mobileqq.mini.servlet.MiniRewardedVideoAdServlet;
import com.tencent.mobileqq.mini.servlet.MiniVipWithoutAdRequest;
import com.tencent.mobileqq.mini.servlet.MiniVipWithoutAdServlet;
import com.tencent.mobileqq.mini.servlet.MiniWxPayCheckUrlServlet;
import com.tencent.mobileqq.mini.servlet.ModifyFriendInteractiveStorageReq;
import com.tencent.mobileqq.mini.servlet.ModifyFriendInteractiveStorageServlet;
import com.tencent.mobileqq.mini.servlet.PayRequest;
import com.tencent.mobileqq.mini.servlet.PersonalizeSetAvatarServlet;
import com.tencent.mobileqq.mini.servlet.QueryCurrencyRequest;
import com.tencent.mobileqq.mini.servlet.RejectFrequentlyRecommendsServlet;
import com.tencent.mobileqq.mini.servlet.SearchAppRequest;
import com.tencent.mobileqq.mini.servlet.SetWxAppInfoServlet;
import com.tencent.mobileqq.mini.servlet.SetWxAppUrlServlet;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.mini.util.RetainDialogModuleUtil;
import com.tencent.mobileqq.mini.util.SimpleRequest;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.qqexpand.bean.feed.MiniAppRecommInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqmini.proxyimpl.aq;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem;
import com.tencent.ttpic.util.GsonUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.Servlet;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppCmdUtil {
    public static final String CMD_SEQ = "CMD_SEQ";
    public static final String CMD_SEQ_SPLIT = "-";
    public static final String KEY_APPID = "key_appid";
    public static final String KEY_APP_INFO = "key_app_info";
    public static final String KEY_APP_INFO_PB = "appInfo_pb";
    public static final String KEY_CMD_STRING = "key_cmd_string";
    public static final String KEY_ERROR_MSG = "errMsg";
    public static final String KEY_INDEX = "key_index";
    public static final String KEY_LIBTYPE = "key_libtype";
    public static final String KEY_REQ_DATA = "key_request_data";
    public static final String KEY_RETURN_CODE = "retCode";
    public static final String KEY_RSP_DATA = "key_response_data";
    public static final String KEY_UIN = "key_uin";
    public static final long MINI_RET_CODE_SUB_SWITCH_OFF = 20004;
    public static final long MINI_RET_CODE_TEMPLATEID_COUNT_OUT_OF_MAX = 20003;
    public static final long MINI_RET_CODE_TEMPLATEID_INVAILD = 20001;
    public static final long RET_CODE_SUB_SWITCH_OFF = -101511021;
    public static final long RET_CODE_TEMPLATEID_COUNT_OUT_OF_MAX = -101511020;
    public static final long RET_CODE_TEMPLATEID_INVAILD = -101511014;
    public static String TAG = "MiniAppCmdUtil";
    private static volatile AtomicInteger index = new AtomicInteger(0);
    private static volatile MiniAppCmdUtil instance;
    private MiniAppObserver cmdObserver;
    private ConcurrentHashMap<Integer, MiniAppCmdInterface> listenerMap;
    private final AtomicLong requestSeq = new AtomicLong();
    private ConcurrentHashMap<Integer, MiniAppProxy.SenderListener> senderListenerMap;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface BunddleListener {
        void onResult(boolean z16, Bundle bundle);
    }

    MiniAppCmdUtil() {
        if (this.listenerMap == null) {
            this.listenerMap = new ConcurrentHashMap<>();
        }
        if (this.senderListenerMap == null) {
            this.senderListenerMap = new ConcurrentHashMap<>();
        }
        if (this.cmdObserver == null) {
            this.cmdObserver = new MiniAppObserver() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.1
                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onAddPhoneNumber(int i3, boolean z16, Bundle bundle) {
                    super.onAddPhoneNumber(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            JSONObject jSONObject = new JSONObject();
                            String string = bundle.getString("errMsg");
                            String string2 = bundle.getString("retCode");
                            jSONObject.put("errMsg", string);
                            jSONObject.put("retCode", string2);
                            if (z16) {
                                jSONObject.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, bundle.getString(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, ""));
                                jSONObject.put("iv", bundle.getString("iv", ""));
                                jSONObject.put(MiniConst.MiniAppCmdUtilConst.PHONE_NUMBER_ID, bundle.getString(MiniConst.MiniAppCmdUtilConst.PHONE_NUMBER_ID, ""));
                            }
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(z16, jSONObject);
                                return;
                            }
                            return;
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onAddPhoneNumber error.", th5);
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onAddPhoneNumber no listener for " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onBatchGetContact(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (z16) {
                                JSONObject jSONObject2 = new JSONObject(bundle.getString(MiniAppBatchGetContactServlet.KEY_CONTACT_LIST));
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject2);
                                    return;
                                }
                                return;
                            }
                            QLog.d(MiniAppObserver.TAG, 1, "call onBatchGetContact fail.");
                            if (!TextUtils.isEmpty(bundle.getString("errMsg"))) {
                                jSONObject.put("errMsg", bundle.getString("errMsg"));
                            }
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, jSONObject);
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onBatchGetContact exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onBatchGetContact can not found listener. " + i3);
                }

                /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:9:0x0045  */
                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                protected void onBatchGetFollowingCount(int i3, boolean z16, Bundle bundle) {
                    JSONObject jSONObject;
                    if (MiniAppCmdUtil.this.listenerMap == null || !MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        return;
                    }
                    MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                    if (z16) {
                        try {
                            jSONObject = new JSONObject(bundle.getString(FollowServlet.KEY_RSP_FOLLOW_COUNT));
                        } catch (JSONException e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "onBatchGetFollowingCount error. ", e16);
                        }
                        if (miniAppCmdInterface == null) {
                            miniAppCmdInterface.onCmdListener(z16, jSONObject);
                            return;
                        }
                        return;
                    }
                    jSONObject = null;
                    if (miniAppCmdInterface == null) {
                    }
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onBatchGetUserInfoResult(int i3, boolean z16, Bundle bundle) {
                    JSONObject jSONObject;
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            jSONObject = new JSONObject(bundle.getString("key_reslut_data"));
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onBatchGetUserInfoResult error. ", th5);
                            jSONObject = new JSONObject();
                        }
                        if (miniAppCmdInterface != null) {
                            miniAppCmdInterface.onCmdListener(z16, jSONObject);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onBatchGetUserInfoResult can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onBatchQueryAppInfoFin(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable("batchQueryAppInfo");
                                if (fromServiceMsg != null) {
                                    INTERFACE$StBatchQueryAppInfoRsp onResponse = BatchQueryAppInfoRequest.onResponse(fh.a(fromServiceMsg.getWupBuffer()));
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("batch_query_app_info", onResponse);
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call onBatchQueryAppInfoFin fail.");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onBatchQueryAppInfoFin exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onBatchQueryAppInfoFin can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onBookShelfInsertResult(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("retCode", bundle.getInt("retCode"));
                            jSONObject.put("errMsg", bundle.getString("errMsg"));
                            if (z16) {
                                jSONObject.put("key_result_data", bundle.getString("key_result_data"));
                            }
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onBookShelfInsertResult error. ", th5);
                        }
                        if (miniAppCmdInterface != null) {
                            miniAppCmdInterface.onCmdListener(z16, jSONObject);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onBookShelfInsertResult can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onBookShelfQueryResult(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("retCode", bundle.getInt("retCode"));
                            jSONObject.put("errMsg", bundle.getString("errMsg"));
                            if (z16) {
                                jSONObject.put("key_result_data", bundle.getString("key_result_data"));
                            }
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onBookShelfQueryResult error. ", th5);
                        }
                        if (miniAppCmdInterface != null) {
                            miniAppCmdInterface.onCmdListener(z16, jSONObject);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onBookShelfQueryResult can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onBookShelfUpdateResult(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("retCode", bundle.getInt("retCode"));
                            jSONObject.put("errMsg", bundle.getString("errMsg"));
                            if (z16) {
                                jSONObject.put("key_result_data", bundle.getString("key_result_data"));
                            }
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onBookShelfUpdateResult error. ", th5);
                        }
                        if (miniAppCmdInterface != null) {
                            miniAppCmdInterface.onCmdListener(z16, jSONObject);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onBookShelfUpdateResult can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onChangeShareImageUrl(int i3, boolean z16, Bundle bundle) {
                    MiniAppCmdInterface miniAppCmdInterface;
                    super.onChangeShareImageUrl(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap == null || !MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3)) || (miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3))) == null) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("imageUrl", bundle.getString("imageUrl"));
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                    miniAppCmdInterface.onCmdListener(z16, jSONObject);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onCheckBindingState(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("retCode", bundle.getLong("retCode"));
                            jSONObject.put("errMsg", bundle.getString("key_Msg"));
                            if (z16) {
                                int i16 = bundle.getInt(CheckBindingStateServlet.KEY_CHECK_STATE, -1);
                                if (i16 != -1) {
                                    jSONObject.put(CheckBindingStateServlet.KEY_CHECK_STATE, i16);
                                } else {
                                    QLog.d(MiniAppObserver.TAG, 1, "call checkBindingType is null.");
                                }
                            } else {
                                QLog.e(MiniAppObserver.TAG, 1, "onCheckBindingType fail");
                            }
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onCheckBindingType error. ", th5);
                        }
                        if (miniAppCmdInterface != null) {
                            miniAppCmdInterface.onCmdListener(z16, jSONObject);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onCheckBindingType can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onCheckNavigateRightServlet(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                int i16 = bundle.getInt(MiniAppCheckNavigateRightServlet.KEY_ACTION_CODE, 0);
                                int i17 = bundle.getInt(MiniAppCheckNavigateRightServlet.KEY_SKIP_LOCAL_CHECK, 0);
                                String string = bundle.getString(MiniAppCheckNavigateRightServlet.KEY_NAVIGATE_WORDING);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("action_code", i16);
                                jSONObject.put("skip_local_check", i17);
                                if (i16 == 0) {
                                    jSONObject.put("reason", string);
                                } else {
                                    jSONObject.put("wording", string);
                                }
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    return;
                                }
                                return;
                            }
                            QLog.d(MiniAppObserver.TAG, 1, "call onCheckNavigateRightServlet fail.");
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onCheckNavigateRightServlet exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onCheckNavigateRightServlet can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onCheckOfferIdFin(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (z16) {
                                int i16 = bundle.getInt("key_result");
                                String string = bundle.getString("errMsg");
                                jSONObject.put("result", i16);
                                jSONObject.put("firstRefer", bundle.getString(MiniAppCheckOfferIdServlet.KEY_FIRST_REFER));
                                jSONObject.put("firstVia", bundle.getString(MiniAppCheckOfferIdServlet.KEY_FIRST_VIA));
                                jSONObject.put("errMsg", string);
                                byte[] byteArray = bundle.getByteArray("key_extendinfo");
                                if (byteArray != null) {
                                    COMM.StCommonExt stCommonExt = new COMM.StCommonExt();
                                    stCommonExt.mergeFrom(byteArray);
                                    jSONObject.put("ext", stCommonExt);
                                }
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    return;
                                }
                                return;
                            }
                            QLog.d(MiniAppObserver.TAG, 1, "call onCheckOfferIdFin fail.");
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, jSONObject);
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onCheckOfferIdFin exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, jSONObject);
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onCheckOfferIdFin can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onCheckSessionFin(int i3, boolean z16, int i16, String str) {
                    super.onCheckSessionFin(i3, z16, i16, str);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16 && i16 == 0) {
                                QLog.d(MiniAppObserver.TAG, 1, "call API_REFRESH_SESSION success.");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, new JSONObject());
                                }
                            } else {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("errMsg", str);
                                QLog.e(MiniAppObserver.TAG, 1, "call API_LOGIN failed " + str);
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, jSONObject);
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call API_LOGIN exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onCheckSessionFin can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onCreateUpdatableMsgResult(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("retCode", bundle.getLong("retCode"));
                            jSONObject.put("errMsg", bundle.getString("errMsg"));
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onCreateUpdatableMsgResult error. ", th5);
                        }
                        if (miniAppCmdInterface != null) {
                            miniAppCmdInterface.onCmdListener(z16, jSONObject);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onCreateUpdatableMsgResult can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onDcReport(int i3, boolean z16, int i16) {
                    super.onDcReport(i3, z16, i16);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        if (z16 && i16 == 0) {
                            if (miniAppCmdInterface != null) {
                                QLog.d(MiniAppObserver.TAG, 1, "onDcReport ok");
                                miniAppCmdInterface.onCmdListener(true, new JSONObject());
                                return;
                            }
                            return;
                        }
                        if (miniAppCmdInterface != null) {
                            QLog.e(MiniAppObserver.TAG, 1, "onDcReport fail");
                            miniAppCmdInterface.onCmdListener(false, new JSONObject());
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onDcReport can not found listener for index " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onDelMiniAppFin(int i3, boolean z16, Bundle bundle) {
                    super.onDelMiniAppFin(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                JSONObject jSONObject = new JSONObject();
                                byte[] byteArray = bundle.getByteArray("key_extendinfo");
                                if (byteArray != null) {
                                    COMM.StCommonExt stCommonExt = new COMM.StCommonExt();
                                    stCommonExt.mergeFrom(byteArray);
                                    jSONObject.put("ext", stCommonExt);
                                }
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    return;
                                }
                                return;
                            }
                            QLog.d(MiniAppObserver.TAG, 1, "call onDelMiniAppFin fail.");
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onDelMiniAppFin exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onDelMiniAppFin can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onDelPhoneNumber(int i3, boolean z16, Bundle bundle) {
                    super.onDelPhoneNumber(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            JSONObject jSONObject = new JSONObject();
                            String string = bundle.getString("errMsg");
                            String string2 = bundle.getString("retCode");
                            jSONObject.put("errMsg", string);
                            jSONObject.put("retCode", string2);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(z16, jSONObject);
                                return;
                            }
                            return;
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onDelPhoneNumber error.", th5);
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onDelPhoneNumber no listener for " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onDoGameRaffle(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("retCode", bundle.getLong("retCode", -1L));
                            jSONObject.put("errMsg", bundle.getString("errMsg"));
                            if (z16) {
                                jSONObject.put("key_result_data", bundle.getString("key_result_data"));
                            }
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onDoGameRaffle error. ", th5);
                        }
                        if (miniAppCmdInterface != null) {
                            miniAppCmdInterface.onCmdListener(z16, jSONObject);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onDoGameRaffle can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetAppInfoByIdForSDKServlet(int i3, boolean z16, Bundle bundle) {
                    super.onGetAppInfoByIdForSDKServlet(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            long j3 = bundle.getLong("retCode", 0L);
                            String string = bundle.getString("errMsg");
                            if (z16) {
                                MiniAppInfo miniAppInfo = (MiniAppInfo) bundle.getParcelable("mini_app_info_data");
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("mini_app_info_data", miniAppInfo);
                                jSONObject.put("retCode", j3);
                                jSONObject.put("errMsg", string);
                                if (miniAppCmdInterface != null) {
                                    QLog.e(MiniAppObserver.TAG, 1, "onGetAppInfoByIdForSDKServlet . " + i3);
                                    miniAppCmdInterface.onCmdListener(j3 == 0, jSONObject);
                                }
                                if (miniAppInfo != null) {
                                    MiniAppCmdUtil.this.getExtConfigDetail(miniAppInfo.commonExt, aq.f(miniAppInfo.extConfigInfoList), new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.1.3
                                        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                                        public void onCmdListener(boolean z17, JSONObject jSONObject2) {
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            QLog.d(MiniAppObserver.TAG, 1, "call onGetAppInfoByIdForSDKServlet fail.");
                            if (miniAppCmdInterface != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("retCode", j3);
                                jSONObject2.put("errMsg", string);
                                miniAppCmdInterface.onCmdListener(false, jSONObject2);
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetAppInfoByIdForSDKServlet exception ", e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetAppInfoByIdForSDKServlet can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetAppInfoByLinkFinForSDK(int i3, boolean z16, Bundle bundle) {
                    super.onGetAppInfoByLinkFinForSDK(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            long j3 = bundle.getLong("retCode", -1L);
                            String string = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.o6k));
                            if (z16) {
                                MiniAppInfo miniAppInfo = (MiniAppInfo) bundle.getParcelable("mini_app_info_data");
                                String string2 = bundle.getString("shareTicket", "");
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("mini_app_info_data", miniAppInfo);
                                jSONObject.put("shareTicket", string2);
                                jSONObject.put("retCode", j3);
                                jSONObject.put("errMsg", string);
                                if (miniAppCmdInterface != null) {
                                    QLog.e(MiniAppObserver.TAG, 1, "  onGetAppInfoByLinkFinForSDK . " + i3);
                                    miniAppCmdInterface.onCmdListener(j3 == 0, jSONObject);
                                }
                                if (miniAppInfo != null) {
                                    MiniAppCmdUtil.this.getExtConfigDetail(miniAppInfo.commonExt, aq.f(miniAppInfo.extConfigInfoList), new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.1.4
                                        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                                        public void onCmdListener(boolean z17, JSONObject jSONObject2) {
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            QLog.d(MiniAppObserver.TAG, 1, "call onGetAppInfoByLinkFinForSDK fail.");
                            if (miniAppCmdInterface != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("retCode", j3);
                                jSONObject2.put("errMsg", string);
                                miniAppCmdInterface.onCmdListener(false, jSONObject2);
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetAppInfoByLinkFinForSDK exception ", e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetAppInfoByLinkFinForSDK can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetAuthList(int i3, boolean z16, Bundle bundle) {
                    super.onGetAuthList(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (z16) {
                                if (bundle != null) {
                                    jSONObject.put("authList", bundle.get(MiniAppGetAuthListServlet.KEY_GET_AUTH_LIST_RESULT));
                                    jSONObject.put("extendInfo", bundle.get("key_ext"));
                                }
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    return;
                                }
                                return;
                            }
                            QLog.d(MiniAppObserver.TAG, 1, "call onGetAuthList fail.");
                            if (!TextUtils.isEmpty(bundle.getString("errMsg"))) {
                                jSONObject.put("errMsg", bundle.getString("errMsg"));
                            }
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, jSONObject);
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetAuthList exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetAuthList can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetCMShowInfo(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("retCode", bundle.getLong("retCode"));
                            jSONObject.put("errMsg", bundle.getString("errMsg"));
                            if (z16) {
                                jSONObject.put(GetCMShowInfoServlet.EXTRA_RESULT_DATA, bundle.getString(GetCMShowInfoServlet.EXTRA_RESULT_DATA));
                            }
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onGetCMShowInfo error. ", th5);
                        }
                        if (miniAppCmdInterface != null) {
                            miniAppCmdInterface.onCmdListener(z16, jSONObject);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetCMShowInfo can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetConfigAfterLaunchGame(int i3, boolean z16, Bundle bundle) {
                    JSONObject jSONObject;
                    super.onGetConfigAfterLaunchGame(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        if (z16) {
                            try {
                                jSONObject = new JSONObject(bundle.getString(MiniAppGetLaunchConfigServlet.KEY_LAUNCH_CONFIG_JSON_STRING));
                            } catch (JSONException e16) {
                                QLog.e(MiniAppObserver.TAG, 1, "onGetGameTaskTicket error.", e16);
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                        } else {
                            jSONObject = null;
                        }
                        if (miniAppCmdInterface != null) {
                            miniAppCmdInterface.onCmdListener(z16, jSONObject);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetGameTaskTicket can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetContainerInfoByIdForSDKServlet(int i3, boolean z16, Bundle bundle) {
                    onGetAppInfoByIdForSDKServlet(i3, z16, bundle);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetContentAccelerateServlet(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            long j3 = bundle.getLong("retCode", 0L);
                            String string = bundle.getString("errMsg");
                            if (z16) {
                                bundle.setClassLoader(PreCacheManager.ContentAccelerateRsp.class.getClassLoader());
                                PreCacheManager.ContentAccelerateRsp contentAccelerateRsp = (PreCacheManager.ContentAccelerateRsp) bundle.getParcelable(MiniAppContentAccelerateServlet.KEY_RSP_DATA);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(MiniAppContentAccelerateServlet.KEY_RSP_DATA, contentAccelerateRsp);
                                jSONObject.put("retCode", j3);
                                jSONObject.put("errMsg", string);
                                if (miniAppCmdInterface != null) {
                                    QLog.e(MiniAppObserver.TAG, 1, "onGetContentAccelerateServlet . " + i3);
                                    miniAppCmdInterface.onCmdListener(j3 == 0, jSONObject);
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call onGetContentAccelerateServlet fail.");
                                if (miniAppCmdInterface != null) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("retCode", j3);
                                    jSONObject2.put("errMsg", string);
                                    miniAppCmdInterface.onCmdListener(false, jSONObject2);
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetContentAccelerateServlet exception ", e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetContentAccelerateServlet can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetExtConfigDetail(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        if (!z16) {
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(bundle.getString(MiniAppGetExtConfigDetailServlet.KEY_EXT_CONFIG_DETAIL_RESULT));
                            JSONObject optJSONObject = jSONObject.optJSONObject(MiniAppGetExtConfigDetailServlet.CONFIG_KEY_API_SCOPE);
                            if (optJSONObject != null) {
                                BaseApplicationImpl.getApplication().getSharedPreferences("MiniAppExtConfigDetail", 4).edit().putString("MiniAppExtConfigDetail", optJSONObject.toString()).commit();
                                if (QLog.isColorLevel()) {
                                    QLog.i(MiniAppObserver.TAG, 2, "apiScopeConfigJson " + optJSONObject.toString());
                                }
                            }
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(true, jSONObject);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i(MiniAppObserver.TAG, 2, "onGetExtConfigDetail " + jSONObject.toString());
                                return;
                            }
                            return;
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onGetExtConfigDetail error.", th5);
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetExtConfigDetail can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetFormId(int i3, boolean z16, Bundle bundle) {
                    super.onGetFormId(i3, z16, bundle);
                    QLog.d(MiniAppObserver.TAG, 2, "onGetFormId() called with: index = [" + i3 + "], isSuccess = [" + z16 + "], bundle = [" + bundle + "]");
                    if (MiniAppCmdUtil.this.listenerMap == null || !MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        return;
                    }
                    MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                    JSONObject jSONObject = new JSONObject();
                    if (z16) {
                        try {
                            jSONObject.putOpt("formId", bundle.getString("formId", ""));
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                    }
                    miniAppCmdInterface.onCmdListener(z16, jSONObject);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetFriendCloudStorage(int i3, boolean z16, Bundle bundle) {
                    JSONObject jSONObject;
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (TextUtils.isEmpty(bundle.getString("key_reslut_data"))) {
                                jSONObject = new JSONObject("{data:[]}");
                            } else {
                                jSONObject = new JSONObject(bundle.getString("key_reslut_data"));
                            }
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onGetFriendCloudStorage error. ", th5);
                            try {
                                jSONObject = new JSONObject("{data:[],error:\"" + th5.getMessage() + "\"}");
                            } catch (Throwable unused) {
                                jSONObject = new JSONObject();
                            }
                        }
                        if (miniAppCmdInterface != null) {
                            miniAppCmdInterface.onCmdListener(z16, jSONObject);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetFriendCloudStorage can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetGameBoxOptions(int i3, boolean z16, Bundle bundle) {
                    super.onGetGameBoxOptions(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        if (miniAppCmdInterface == null) {
                            return;
                        }
                        JSONObject jSONObject = new JSONObject();
                        if (z16) {
                            try {
                                jSONObject = new JSONObject(bundle.getString("query_result"));
                            } catch (JSONException e16) {
                                QLog.e(MiniAppObserver.TAG, 1, "onGetGameBoxOptions error.", e16);
                            }
                        }
                        miniAppCmdInterface.onCmdListener(z16, jSONObject);
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetGameBoxOptions can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetGameRaffleMaterial(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("retCode", bundle.getLong("retCode", -1L));
                            jSONObject.put("errMsg", bundle.getString("errMsg"));
                            if (z16) {
                                jSONObject.put("key_result_data", bundle.getString("key_result_data"));
                            }
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onGetGameRaffleMaterial error. ", th5);
                        }
                        if (miniAppCmdInterface != null) {
                            miniAppCmdInterface.onCmdListener(z16, jSONObject);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetGameRaffleMaterial can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetGameTaskTicket(int i3, boolean z16, Bundle bundle) {
                    super.onGetGameTaskTicket(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        JSONObject jSONObject = new JSONObject();
                        if (z16) {
                            try {
                                String string = bundle.getString("ticket");
                                int i16 = bundle.getInt(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
                                jSONObject.put("ticket", string);
                                jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, i16);
                            } catch (JSONException e16) {
                                QLog.e(MiniAppObserver.TAG, 1, "onGetGameTaskTicket error.", e16);
                            }
                        }
                        if (miniAppCmdInterface != null) {
                            miniAppCmdInterface.onCmdListener(z16, jSONObject);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetGameTaskTicket can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetGeneralCmdFin(int i3, long j3, byte[] bArr, String str) {
                    super.onGetGeneralCmdFin(i3, j3, bArr, str);
                    if (MiniAppCmdUtil.this.senderListenerMap != null && MiniAppCmdUtil.this.senderListenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppProxy.SenderListener senderListener = (MiniAppProxy.SenderListener) MiniAppCmdUtil.this.senderListenerMap.remove(Integer.valueOf(i3));
                        if (senderListener != null) {
                            senderListener.onReply((int) j3, bArr, str);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetGeneralCmdFin can not found listener. " + i3);
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0079  */
                /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                protected void onGetGroupCloudStorage(int i3, boolean z16, Bundle bundle) {
                    JSONObject jSONObject;
                    JSONObject jSONObject2;
                    String string;
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            string = bundle.getString("key_reslut_data");
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onGetGroupCloudStorage error. ", th5);
                            try {
                                jSONObject2 = new JSONObject("{data:[],error:\"" + th5.getMessage() + "\"}");
                            } catch (Throwable unused) {
                                jSONObject = new JSONObject();
                            }
                        }
                        if (TextUtils.isEmpty(string)) {
                            jSONObject = new JSONObject("{data:[]}");
                            if (miniAppCmdInterface == null) {
                                miniAppCmdInterface.onCmdListener(z16, jSONObject);
                                return;
                            }
                            return;
                        }
                        jSONObject2 = new JSONObject(string);
                        jSONObject = jSONObject2;
                        if (miniAppCmdInterface == null) {
                        }
                    } else {
                        QLog.e(MiniAppObserver.TAG, 1, "onGetGroupCloudStorage can not found listener. " + i3);
                    }
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetGroupShareInfo(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable("getGroupShareInfo");
                                String string = bundle.getString("getGroupShareInfoErrMsg");
                                int i16 = bundle.getInt("getGroupShareInfoRetCode");
                                if (fromServiceMsg != null) {
                                    MiniProgramShare$StGetGroupShareInfoRsp onResponse = MiniAppGetGroupShareInfoRequest.onResponse(fh.a(fromServiceMsg.getWupBuffer()));
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("response", onResponse);
                                    jSONObject.put(QzoneIPCModule.RESULT_CODE, i16);
                                    jSONObject.put("errMsg", string);
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                } else {
                                    QLog.d(MiniAppObserver.TAG, 1, "call getGroupShareInfo FromServiceMsg rsp is null.");
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, new JSONObject());
                                    }
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call getGroupShareInfo fail.");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call getGroupShareInfo exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "getGroupShareInfo can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetHotSearchApps(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            long j3 = bundle.getLong("retCode", -1L);
                            String string = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.o6m));
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("retCode", j3);
                            jSONObject.put("errMsg", string);
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable(MiniAppGetHotSearchAppsServlet.KEY_GET_HOT_SEARCH_APPS);
                                if (fromServiceMsg != null) {
                                    jSONObject.put(MiniAppGetHotSearchAppsServlet.KEY_GET_HOT_SEARCH_APPS_RSP, GetHotSearchAppsRequest.onResponse(fh.a(fromServiceMsg.getWupBuffer())));
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                } else {
                                    QLog.e(MiniAppObserver.TAG, 1, "call onGetHotSearchApps FromServiceMsg rsp is null.");
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(false, jSONObject);
                                    }
                                }
                            } else {
                                QLog.e(MiniAppObserver.TAG, 1, "call onGetHotSearchApps fail. errCode = " + j3 + ", errMsg = " + string);
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, jSONObject);
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetHotSearchApps exception " + Log.getStackTraceString(e16));
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetHotSearchApps can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetHotSearchAppsV2(int i3, boolean z16, Bundle bundle) {
                    MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdUtil.this.listenerMap == null || !MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) ? null : (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                    if (miniAppCmdInterface == null) {
                        QLog.e(MiniAppObserver.TAG, 1, "onGetHotSearchAppsV2 can not found listener.", Integer.valueOf(i3));
                        return;
                    }
                    try {
                        long j3 = bundle.getLong("retCode", -1L);
                        String string = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.o6m));
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("retCode", j3);
                        jSONObject.put("errMsg", string);
                        if (!z16) {
                            QLog.e(MiniAppObserver.TAG, 1, "onGetHotSearchAppsV2 fail. code:", Long.valueOf(j3), ", errMsg:", string);
                            miniAppCmdInterface.onCmdListener(false, jSONObject);
                            return;
                        }
                        FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable(MiniAppGetHotSearchAppsV2Servlet.KEY_GET_HOT_SEARCH_APPS);
                        if (fromServiceMsg != null) {
                            jSONObject.put(MiniAppGetHotSearchAppsV2Servlet.KEY_GET_HOT_SEARCH_APPS_RSP, GetHotSearchAppsV2Request.onResponse(fh.a(fromServiceMsg.getWupBuffer())));
                            miniAppCmdInterface.onCmdListener(true, jSONObject);
                        } else {
                            QLog.e(MiniAppObserver.TAG, 1, "onGetHotSearchAppsV2 rsp is null.");
                            miniAppCmdInterface.onCmdListener(false, jSONObject);
                        }
                    } catch (Exception e16) {
                        QLog.e(MiniAppObserver.TAG, 1, "onGetHotSearchAppsV2 e:", Log.getStackTraceString(e16));
                    }
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetKuolieAppListServlet(int i3, boolean z16, Bundle bundle) {
                    super.onGetAppInfoByLinkFin(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            long j3 = bundle.getLong("retCode", -1L);
                            String string = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.o6q));
                            if (z16) {
                                MiniAppRecommInfo miniAppRecommInfo = (MiniAppRecommInfo) bundle.getSerializable(MiniAppGetKuolieApplistServlet.KEY_KUOLIE_APPLIST);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("data", miniAppRecommInfo);
                                jSONObject.put("retCode", j3);
                                jSONObject.put("errMsg", string);
                                if (miniAppCmdInterface != null) {
                                    QLog.e(MiniAppObserver.TAG, 1, "  onGetKuolieAppListServlet . " + i3);
                                    miniAppCmdInterface.onCmdListener(j3 == 0, jSONObject);
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call onGetKuolieAppListServlet fail.");
                                if (miniAppCmdInterface != null) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("retCode", j3);
                                    jSONObject2.put("errMsg", string);
                                    miniAppCmdInterface.onCmdListener(false, jSONObject2);
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetKuolieAppListServlet exception ", e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetKuolieAppListServlet can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetLoginCodeFin(int i3, boolean z16, String str, long j3, String str2) {
                    super.onGetLoginCodeFin(i3, z16, str, j3, str2);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        if (z16) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("code", str);
                                QLog.d(MiniAppObserver.TAG, 1, "call API_LOGIN  code:" + str);
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(z16, jSONObject);
                                    return;
                                }
                                return;
                            } catch (Exception e16) {
                                QLog.e(MiniAppObserver.TAG, 1, "call API_LOGIN exception " + e16);
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                    return;
                                }
                                return;
                            }
                        }
                        QLog.e(MiniAppObserver.TAG, 1, "call API_LOGIN failed ");
                        if (miniAppCmdInterface != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("retCode", j3);
                                jSONObject2.put("errMsg", str2);
                            } catch (Exception e17) {
                                QLog.d(MiniAppObserver.TAG, 1, "call onBatchGetUserInfoResult exception", e17);
                            }
                            miniAppCmdInterface.onCmdListener(false, jSONObject2);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetLoginCodeFin can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetMidasConsumeResult(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable("getMidasConsumeResult");
                                String string = bundle.getString("getMidasConsumeResultErrMsg");
                                int i16 = bundle.getInt("getMidasConsumeResultRetCode");
                                if (fromServiceMsg != null) {
                                    MiniAppMidasPay$StGamePayRsp onResponse = PayRequest.onResponse(fh.a(fromServiceMsg.getWupBuffer()));
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("response", onResponse);
                                    jSONObject.put(QzoneIPCModule.RESULT_CODE, i16);
                                    jSONObject.put("errMsg", string);
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                } else {
                                    QLog.d(MiniAppObserver.TAG, 1, "call getMidasConsumeResult FromServiceMsg rsp is null.");
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, new JSONObject());
                                    }
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call getMidasConsumeResult fail.");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call getMidasConsumeResult exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "getMidasConsumeResult can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetMidasQueryResult(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable("getMidasQueryResult");
                                String string = bundle.getString("getMidasQueryResultErrMsg");
                                int i16 = bundle.getInt("getMidasQueryResultRetCode");
                                if (fromServiceMsg != null) {
                                    MiniAppMidasPay$StQueryStarCurrencyRsp onResponse = QueryCurrencyRequest.onResponse(fh.a(fromServiceMsg.getWupBuffer()));
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("response", onResponse);
                                    jSONObject.put(QzoneIPCModule.RESULT_CODE, i16);
                                    jSONObject.put("errMsg", string);
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                } else {
                                    QLog.d(MiniAppObserver.TAG, 1, "call getMidasQueryResult FromServiceMsg rsp is null.");
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, new JSONObject());
                                    }
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call onGetMidasQueryResult fail.");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetMidasQueryResult exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetMidasQueryResult can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetNativeAppInfoForJump(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                JSONObject jSONObject = new JSONObject();
                                String obj = bundle.get(MiniAppGetNativeAppInfoServlet.KEY_PACKAGE_NAME).toString();
                                String obj2 = bundle.get(MiniAppGetNativeAppInfoServlet.KEY_NATIVE_APP_ID).toString();
                                String obj3 = bundle.get("key_app_id").toString();
                                int i16 = bundle.getInt(MiniAppGetNativeAppInfoServlet.KEY_ONLY_OPEN);
                                String str = bundle.getString(MiniAppGetNativeAppInfoServlet.KEY_DOWNLOAD_URL).toString();
                                jSONObject.put("packageName", obj);
                                jSONObject.put("nativeAppId", obj2);
                                jSONObject.put("appName", obj3);
                                jSONObject.put("onlyOpen", i16);
                                jSONObject.put("downloadUrl", str);
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call onGetNativeAppInfoForJump fail.");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetNativeAppInfoForJump exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetNativeAppInfoForJump can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetNewBaseLibFin(int i3, boolean z16, String str, String str2, Bundle bundle) {
                    super.onGetNewBaseLibFin(i3, z16, str, str2, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                QLog.d(MiniAppObserver.TAG, 1, "call onGetNewBaseLibFin success.");
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("version", str);
                                jSONObject.put("downloadUrl", str2);
                                BaseLibInfo baseLibInfo = (BaseLibInfo) bundle.getParcelable(BaseLibInfo.getKey(2));
                                if (baseLibInfo != null) {
                                    jSONObject.put(BaseLibInfo.getKey(2), baseLibInfo.toJSONObject());
                                }
                                BaseLibInfo baseLibInfo2 = (BaseLibInfo) bundle.getParcelable(BaseLibInfo.getKey(3));
                                if (baseLibInfo2 != null) {
                                    jSONObject.put(BaseLibInfo.getKey(3), baseLibInfo2.toJSONObject());
                                }
                                BaseLibInfo baseLibInfo3 = (BaseLibInfo) bundle.getParcelable(BaseLibInfo.getKey(1));
                                if (baseLibInfo3 != null) {
                                    jSONObject.put(BaseLibInfo.getKey(1), baseLibInfo3.toJSONObject());
                                }
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    return;
                                }
                                return;
                            }
                            QLog.d(MiniAppObserver.TAG, 1, "call onGetNewBaseLibFin fail.");
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetNewBaseLibFin exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetNewBaseLibFin can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetNewBaseLibFinForSDK(int i3, boolean z16, String str, String str2, Bundle bundle) {
                    super.onGetNewBaseLibFinForSDK(i3, z16, str, str2, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                QLog.d(MiniAppObserver.TAG, 1, "call onGetNewBaseLibFinForSDK success.");
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("version", str);
                                jSONObject.put("downloadUrl", str2);
                                com.tencent.qqmini.sdk.launcher.model.BaseLibInfo baseLibInfo = (com.tencent.qqmini.sdk.launcher.model.BaseLibInfo) bundle.getParcelable(BaseLibInfo.getKey(2));
                                if (baseLibInfo != null) {
                                    jSONObject.put(BaseLibInfo.getKey(2), baseLibInfo.toJSONObject());
                                }
                                com.tencent.qqmini.sdk.launcher.model.BaseLibInfo baseLibInfo2 = (com.tencent.qqmini.sdk.launcher.model.BaseLibInfo) bundle.getParcelable(BaseLibInfo.getKey(3));
                                if (baseLibInfo2 != null) {
                                    jSONObject.put(BaseLibInfo.getKey(3), baseLibInfo2.toJSONObject());
                                }
                                com.tencent.qqmini.sdk.launcher.model.BaseLibInfo baseLibInfo3 = (com.tencent.qqmini.sdk.launcher.model.BaseLibInfo) bundle.getParcelable(BaseLibInfo.getKey(1));
                                if (baseLibInfo3 != null) {
                                    jSONObject.put(BaseLibInfo.getKey(1), baseLibInfo3.toJSONObject());
                                }
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    return;
                                }
                                return;
                            }
                            QLog.d(MiniAppObserver.TAG, 1, "call onGetNewBaseLibFinForSDK fail.");
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetNewBaseLibFinForSDK exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetNewBaseLibFinForSDK can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetPotentialFriendList(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable("getPotentialFriendList");
                                long j3 = bundle.getLong("retCode");
                                String string = bundle.getString("errMsg");
                                if (fromServiceMsg != null) {
                                    CloudStorage$StGetPotentialFriendListRsp onResponse = GetPotentialFriendListRequest.onResponse(fh.a(fromServiceMsg.getWupBuffer()));
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("response", onResponse);
                                    jSONObject.put(QzoneIPCModule.RESULT_CODE, fromServiceMsg.getResultCode());
                                    jSONObject.put("retCode", j3);
                                    jSONObject.put("errMsg", string);
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                } else {
                                    QLog.d(MiniAppObserver.TAG, 1, "call getPotentialFriendList FromServiceMsg rsp is null.");
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, new JSONObject());
                                    }
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call getPotentialFriendList fail.");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call getPotentialFriendList exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "getPotentialFriendList can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetProfileFin(int i3, String str, boolean z16, String str2, String str3, int i16, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, long j3, String str12) {
                    super.onGetProfileFin(i3, str, z16, str2, str3, i16, str4, str5, str6, str7, str8, str9, str10, str11, j3, str12);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        if (z16) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                JSONObject jSONObject2 = new JSONObject();
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject.put("nickName", str2);
                                jSONObject.put(PhotoCategorySummaryInfo.AVATAR_URL, str3);
                                jSONObject.put("gender", i16);
                                jSONObject.put("province", str5);
                                jSONObject.put("city", str6);
                                jSONObject.put("country", str4);
                                jSONObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, str7);
                                jSONObject3.put("rawData", str8);
                                jSONObject3.put("signature", str9);
                                jSONObject3.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, str10);
                                jSONObject3.put("iv", str11);
                                jSONObject3.put(ITVKPlayerEventListener.KEY_USER_INFO, jSONObject);
                                jSONObject2.put("data", str8);
                                jSONObject2.put("signature", str9);
                                jSONObject3.put("data", jSONObject2.toString());
                                if (QLog.isDevelopLevel()) {
                                    QLog.d(MiniAppObserver.TAG, 4, "call getUserInfo \uff1a " + jSONObject3.toString());
                                }
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject3);
                                    return;
                                }
                                return;
                            } catch (Exception e16) {
                                QLog.e(MiniAppObserver.TAG, 1, "call getUserInfo exception " + e16);
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                    return;
                                }
                                return;
                            }
                        }
                        QLog.e(MiniAppObserver.TAG, 1, "call getUserInfo failed ");
                        if (miniAppCmdInterface != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            try {
                                jSONObject4.put("retCode", j3);
                                jSONObject4.put("errMsg", str12);
                            } catch (Exception e17) {
                                QLog.d(MiniAppObserver.TAG, 1, "call onBatchGetUserInfoResult exception", e17);
                            }
                            miniAppCmdInterface.onCmdListener(false, jSONObject4);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetProfileFin can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetReactiveFriendList(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable("getReactiveFriendList");
                                long j3 = bundle.getLong("retCode");
                                String string = bundle.getString("errMsg");
                                if (fromServiceMsg != null) {
                                    CloudStorage$StGetReactiveFriendListRsp onResponse = GetReactiveFriendListRequest.onResponse(fh.a(fromServiceMsg.getWupBuffer()));
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("response", onResponse);
                                    jSONObject.put(QzoneIPCModule.RESULT_CODE, fromServiceMsg.getResultCode());
                                    jSONObject.put("retCode", j3);
                                    jSONObject.put("errMsg", string);
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                } else {
                                    QLog.d(MiniAppObserver.TAG, 1, "call getReactiveFriendList FromServiceMsg rsp is null.");
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, new JSONObject());
                                    }
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call getReactiveFriendList fail.");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call getReactiveFriendList exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "getReactiveFriendList can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetRecommendAppList(int i3, boolean z16, Bundle bundle) {
                    super.onGetRecommendAppList(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            long j3 = bundle.getLong("retCode", -1L);
                            String string = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.o6o));
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("retCode", j3);
                            jSONObject.put("errMsg", string);
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable(MiniAppGetRecommendAppListServlet.KEY_RECOMMEND_MODULE);
                                if (fromServiceMsg != null) {
                                    jSONObject.put("response", GetRecommendAppListRequest.onResponse(fh.a(fromServiceMsg.getWupBuffer())));
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                } else {
                                    QLog.e(MiniAppObserver.TAG, 1, "call onGetUserAppListV2 FromServiceMsg rsp is null.");
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(false, jSONObject);
                                    }
                                }
                            } else {
                                QLog.e(MiniAppObserver.TAG, 1, "call onGetUserAppListV2 fail. errCode = " + j3 + ", errMsg = " + string);
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, jSONObject);
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetUserAppListV2 exception " + Log.getStackTraceString(e16));
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetUserAppListV2 can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetRewardedVideoAdResult(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        QLog.i(MiniAppObserver.TAG, 1, "onGetRewardedVideoAdResult, index=" + i3);
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable("getRewardedVideoADInfo");
                                long j3 = bundle.getLong("retCode");
                                String string = bundle.getString("errMsg");
                                if (fromServiceMsg != null) {
                                    MiniAppAd$StGetAdRsp onResponse = MiniAppGetAdRequest.onResponse(fh.a(fromServiceMsg.getWupBuffer()));
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("response", onResponse);
                                    jSONObject.put(QzoneIPCModule.RESULT_CODE, fromServiceMsg.getResultCode());
                                    jSONObject.put("retCode", j3);
                                    jSONObject.put("errMsg", string);
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                } else {
                                    QLog.d(MiniAppObserver.TAG, 1, "call getRewardedVideoADInfo FromServiceMsg rsp is null.");
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, new JSONObject());
                                    }
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call onGetRewardedVideoAdResult fail.");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetRewardedVideoAdResult exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetRewardedVideoAdResult can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetRobotUin(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        if (!z16) {
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                        String string = bundle.getString(MiniAppGetRobotUinServlet.KEY_ROBOT_RESULT_UIN);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("robotUin", string);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(true, jSONObject);
                                return;
                            }
                            return;
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onGetRobotUin error.", th5);
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetRobotUin can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetShareInfo(int i3, boolean z16, Bundle bundle) {
                    super.onGetShareInfo(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            long j3 = bundle.getLong("retCode", -1L);
                            String string = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.o6j));
                            if (!z16) {
                                QLog.e(MiniAppObserver.TAG, 1, "onGetShareInfo isSuccess=false, retCode=" + j3);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("retCode", j3);
                                jSONObject.put("errMsg", string);
                                jSONObject.put("needShareCallBack", bundle.getBoolean("needShareCallBack", false));
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, jSONObject);
                                }
                            } else if (j3 == -100070004 || j3 == -1000710003 || j3 == -100070016) {
                                QLog.e(MiniAppObserver.TAG, 1, "onGetShareInfo isSuccess=false, retCode=" + j3);
                                if (miniAppCmdInterface != null) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("retCode", j3);
                                    jSONObject2.put("errMsg", string);
                                    jSONObject2.put("needShareCallBack", bundle.getBoolean("needShareCallBack", false));
                                    miniAppCmdInterface.onCmdListener(false, jSONObject2);
                                }
                            } else if (miniAppCmdInterface != null) {
                                JSONObject jSONObject3 = new JSONObject(bundle.getString("jsonData"));
                                jSONObject3.put("needShareCallBack", bundle.getBoolean("needShareCallBack", false));
                                miniAppCmdInterface.onCmdListener(true, jSONObject3);
                            }
                            return;
                        } catch (JSONException e16) {
                            JSONObject jSONObject4 = new JSONObject();
                            try {
                                jSONObject4.put("retCode", -1);
                                jSONObject4.put("errMsg", HardCodeUtil.qqStr(R.string.o6h));
                            } catch (JSONException e17) {
                                e17.printStackTrace();
                            }
                            miniAppCmdInterface.onCmdListener(false, jSONObject4);
                            QLog.e(MiniAppObserver.TAG, 1, "onGetShareInfo parse json failed", e16);
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetShareInfo get null response");
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetStoreAppList(int i3, boolean z16, Bundle bundle) {
                    super.onGetStoreAppList(i3, z16, bundle);
                    QLog.d(MiniAppObserver.TAG, 2, "onGetStoreAppList() called with: index = [" + i3 + "], isSuccess = [" + z16 + "], bundle = [" + bundle + "]");
                    if (MiniAppCmdUtil.this.listenerMap == null || !MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        return;
                    }
                    MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                    JSONObject jSONObject = new JSONObject();
                    if (z16) {
                        try {
                            jSONObject.put("data", bundle.getString("data", ""));
                            jSONObject.put("dataType", HippyControllerProps.STRING);
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                    }
                    miniAppCmdInterface.onCmdListener(z16, jSONObject);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetSwitchList(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable(MiniAppGetSwitchListServlet.KEY_GET_SWITCH_LIST);
                                long j3 = bundle.getLong("retCode");
                                String string = bundle.getString("errMsg");
                                if (fromServiceMsg != null) {
                                    INTERFACE$StGetSwitchListRsp onResponse = MiniAppGetSwitchListRequest.onResponse(fh.a(fromServiceMsg.getWupBuffer()));
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put(MiniAppGetSwitchListServlet.KEY_GET_SWITCH_LIST, onResponse);
                                    jSONObject.put("retCode", j3);
                                    jSONObject.put("errMsg", string);
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                } else {
                                    QLog.d(MiniAppObserver.TAG, 1, "call getSwitchList FromServiceMsg rsp is null.");
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, new JSONObject());
                                    }
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call onGetSwitchList fail.");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetSwitchList exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetSwitchList can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetTcbTicket(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        JSONObject jSONObject = new JSONObject();
                        if (z16) {
                            try {
                                jSONObject.put("ticket", bundle.getString(MiniAppGetTcbTicketServlet.KEY_TICKET));
                                jSONObject.put(WadlProxyConsts.CREATE_TIME, bundle.getInt(MiniAppGetTcbTicketServlet.KEY_CREATE_TIME));
                                jSONObject.put("period", bundle.getInt(MiniAppGetTcbTicketServlet.KEY_PERIOD));
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    return;
                                }
                                return;
                            } catch (Throwable th5) {
                                QLog.e(MiniAppObserver.TAG, 1, "onGetTcbTicket error.", th5);
                                return;
                            }
                        }
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            long j3 = bundle.getLong("retCode");
                            String string = bundle.getString("errMsg");
                            jSONObject2.put("retCode", j3);
                            jSONObject2.put("errMsg", string);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, jSONObject2);
                                return;
                            }
                            return;
                        } catch (Throwable th6) {
                            QLog.e(MiniAppObserver.TAG, 1, "onGetTcbTicket error.", th6);
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetTcbTicket can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetTeenagerConfig(int i3, boolean z16, Bundle bundle) {
                    super.onGetTeenagerConfig(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        JSONObject jSONObject = new JSONObject();
                        if (z16) {
                            try {
                                String string = bundle.getString(MiniAppGetTeenagerConfigServlet.KEY_APPID_LIST);
                                int i16 = bundle.getInt(MiniAppGetTeenagerConfigServlet.KEY_FREQUENCY_SWITCH, -1);
                                int i17 = bundle.getInt(MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, -1);
                                jSONObject.put(MiniAppGetTeenagerConfigServlet.KEY_APPID_LIST, string);
                                jSONObject.put(MiniAppGetTeenagerConfigServlet.KEY_FREQUENCY_SWITCH, i16);
                                jSONObject.put(MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, i17);
                            } catch (JSONException e16) {
                                QLog.e(MiniAppObserver.TAG, 1, "onGetTeenagerConfig error.", e16);
                            }
                        }
                        if (miniAppCmdInterface != null) {
                            miniAppCmdInterface.onCmdListener(z16, jSONObject);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetTeenagerConfig can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetUserAppInfoFin(int i3, boolean z16, Bundle bundle) {
                    super.onGetUserAppInfoFin(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                QLog.d(MiniAppObserver.TAG, 1, "call onGetUserAppInfoFin success.");
                                JSONObject jSONObject = new JSONObject();
                                int i16 = bundle.getInt(PictureConst.PHOTO_LIKE_NUM, 0);
                                int i17 = bundle.getInt(MiniAppSetUserAppLikeServlet.KEY_DO_LIKE, 0);
                                Serializable serializable = bundle.getSerializable("mini_app_info_data");
                                jSONObject.put("likeNum", i16);
                                jSONObject.put("doLike", i17);
                                jSONObject.put("mini_app_info_data", serializable);
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call onGetUserAppInfoFin fail.");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetUserAppInfoFin exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetUserAppInfoFin can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetUserAppList(int i3, boolean z16, Bundle bundle) {
                    super.onGetUserAppList(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            long j3 = bundle.getLong("retCode", -1L);
                            String string = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.o6l));
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("retCode", j3);
                            jSONObject.put("errMsg", string);
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable("getUserAppList");
                                if (fromServiceMsg != null) {
                                    jSONObject.put("response", GetUserAppListRequest.onResponse(fh.a(fromServiceMsg.getWupBuffer())));
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                } else {
                                    QLog.e(MiniAppObserver.TAG, 1, "call onGetUserAppList FromServiceMsg rsp is null.");
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(false, jSONObject);
                                    }
                                }
                            } else {
                                QLog.e(MiniAppObserver.TAG, 1, "call onGetUserAppList fail. errCode = " + j3 + ", errMsg = " + string);
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, jSONObject);
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetUserAppList exception " + Log.getStackTraceString(e16));
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetUserAppList can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetUserAppListV2(int i3, boolean z16, Bundle bundle) {
                    super.onGetUserAppListV2(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            long j3 = bundle.getLong("retCode", -1L);
                            String string = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.o6m));
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("retCode", j3);
                            jSONObject.put("errMsg", string);
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable(MiniAppGetUserAppListServletV2.KEY_GET_USER_APP_LIST_V2);
                                if (fromServiceMsg != null) {
                                    jSONObject.put("response", GetUserAppListRequestV2.onResponse(fh.a(fromServiceMsg.getWupBuffer())));
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                } else {
                                    QLog.e(MiniAppObserver.TAG, 1, "call onGetUserAppListV2 FromServiceMsg rsp is null.");
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(false, jSONObject);
                                    }
                                }
                            } else {
                                QLog.e(MiniAppObserver.TAG, 1, "call onGetUserAppListV2 fail. errCode = " + j3 + ", errMsg = " + string);
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, jSONObject);
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetUserAppListV2 exception " + Log.getStackTraceString(e16));
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetUserAppListV2 can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetUserAppListV3(int i3, boolean z16, Bundle bundle) {
                    super.onGetUserAppListV3(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            long j3 = bundle.getLong("retCode", -1L);
                            String string = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.o6m));
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("retCode", j3);
                            jSONObject.put("errMsg", string);
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable(MiniAppGetUserAppListServletV3.KEY_GET_USER_APP_LIST_V3);
                                if (fromServiceMsg != null) {
                                    jSONObject.put("response", GetUserAppListRequestV3.onResponse(fh.a(fromServiceMsg.getWupBuffer())));
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                } else {
                                    QLog.e(MiniAppObserver.TAG, 1, "call onGetUserAppListV3 FromServiceMsg rsp is null.");
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(false, jSONObject);
                                    }
                                }
                            } else {
                                QLog.e(MiniAppObserver.TAG, 1, "call onGetUserAppListV3 fail. errCode = " + j3 + ", errMsg = " + string);
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, jSONObject);
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetUserAppListV3 exception " + Log.getStackTraceString(e16));
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetUserAppListV3 can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetUserGroupInfo(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                String string = bundle.getString(MiniAppGetUserGroupInfoServlet.KEY_EXTRA_JSON_DATA);
                                long j3 = bundle.getLong("retCode");
                                String string2 = bundle.getString("errMsg");
                                if (string != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put(MiniAppGetUserGroupInfoServlet.KEY_EXTRA_JSON_DATA, string);
                                    jSONObject.put("retCode", j3);
                                    jSONObject.put("errMsg", string2);
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                } else {
                                    QLog.d(MiniAppObserver.TAG, 1, "call getUserInfo extraJsonData is null.");
                                    if (miniAppCmdInterface != null) {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("retCode", j3);
                                        jSONObject2.put("errMsg", string2);
                                        miniAppCmdInterface.onCmdListener(true, jSONObject2);
                                    }
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call getUserInfo fail.");
                                if (miniAppCmdInterface != null) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    long j16 = bundle.getLong("retCode");
                                    String string3 = bundle.getString("errMsg");
                                    jSONObject3.put("retCode", j16);
                                    jSONObject3.put("errMsg", string3);
                                    miniAppCmdInterface.onCmdListener(false, jSONObject3);
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call getUserInfo exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "getUserInfo can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetUserHealthData(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (z16) {
                                if (bundle != null) {
                                    jSONObject.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, bundle.getString(MiniAppUserHealthDataServlet.KEY_ENCRYPTED_DATA));
                                    jSONObject.put("iv", bundle.get(MiniAppUserHealthDataServlet.KEY_RET_IV));
                                }
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    return;
                                }
                                return;
                            }
                            QLog.d(MiniAppObserver.TAG, 1, "call onGetUserHealthData fail.");
                            if (!TextUtils.isEmpty(bundle.getString("errMsg"))) {
                                jSONObject.put("errMsg", bundle.getString("errMsg"));
                            }
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, jSONObject);
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetUserHealthData exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetUserHealthData can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetUserInfoExtra(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                JSONObject jSONObject = new JSONObject();
                                String obj = bundle.get(MiniAppGetUserInfoExtraServlet.KEY_RET_ENCRYPT_DATA).toString();
                                String obj2 = bundle.get(MiniAppGetUserInfoExtraServlet.KEY_RET_IV).toString();
                                jSONObject.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, obj);
                                jSONObject.put("iv", obj2);
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call onGetUserInfoExtra fail.");
                                if (miniAppCmdInterface != null) {
                                    try {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("retCode", bundle.getLong("retCode", -1L));
                                        jSONObject2.put("errMsg", bundle.getString("errMsg", ""));
                                        miniAppCmdInterface.onCmdListener(false, jSONObject2);
                                    } catch (Exception e16) {
                                        QLog.d(MiniAppObserver.TAG, 1, "call onGetUserInfoExtra exception", e16);
                                    }
                                }
                            }
                            return;
                        } catch (Exception e17) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetUserInfoExtra exception " + e17);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetUserInfoExtra can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetUserInteractiveStorage(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable("getUserInteractiveStorage");
                                long j3 = bundle.getLong("retCode");
                                String string = bundle.getString("errMsg");
                                if (fromServiceMsg != null) {
                                    CloudStorage$StGetUserInteractiveStorageRsp onResponse = GetUserInteractiveStorageRequest.onResponse(fh.a(fromServiceMsg.getWupBuffer()));
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("response", onResponse);
                                    jSONObject.put(QzoneIPCModule.RESULT_CODE, fromServiceMsg.getResultCode());
                                    jSONObject.put("retCode", j3);
                                    jSONObject.put("errMsg", string);
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                } else {
                                    QLog.d(MiniAppObserver.TAG, 1, "call getUserInteractiveStorage FromServiceMsg rsp is null.");
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, new JSONObject());
                                    }
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call getUserInteractiveStorage fail.");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call getUserInteractiveStorage exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "getUserInteractiveStorage can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetUserSetting(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        if (z16) {
                            byte[] byteArray = bundle.getByteArray("originalData");
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("settingItem", bundle.getString("settingItem", ""));
                                jSONObject.put("desc", bundle.getString("desc", ""));
                                jSONObject.put("authState", bundle.getInt("authState", -1));
                                jSONObject.put("originalData", byteArray);
                                jSONObject.put("errMsg", bundle.getString("errMsg", ""));
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    return;
                                }
                                return;
                            } catch (Throwable th5) {
                                QLog.e(MiniAppObserver.TAG, 1, "onGetUserSetting error.", th5);
                                return;
                            }
                        }
                        if (miniAppCmdInterface != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            if (bundle != null) {
                                long j3 = bundle.getLong("retCode");
                                String string = bundle.getString("errMsg");
                                if (MiniAppCmdUtil.RET_CODE_TEMPLATEID_INVAILD == j3) {
                                    j3 = MiniAppCmdUtil.MINI_RET_CODE_TEMPLATEID_INVAILD;
                                } else if (MiniAppCmdUtil.RET_CODE_TEMPLATEID_COUNT_OUT_OF_MAX == j3) {
                                    j3 = MiniAppCmdUtil.MINI_RET_CODE_TEMPLATEID_COUNT_OUT_OF_MAX;
                                } else if (MiniAppCmdUtil.RET_CODE_SUB_SWITCH_OFF == j3) {
                                    j3 = MiniAppCmdUtil.MINI_RET_CODE_SUB_SWITCH_OFF;
                                }
                                try {
                                    jSONObject2 = new JSONObject().put("retCode", j3).put("errMsg", string);
                                } catch (JSONException e16) {
                                    e16.printStackTrace();
                                }
                            }
                            miniAppCmdInterface.onCmdListener(false, jSONObject2);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetUserSetting can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetVipWithoutAdMemberState(int i3, boolean z16, Bundle bundle) {
                    super.onGetVipWithoutAdMemberState(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        JSONObject jSONObject = new JSONObject();
                        if (z16) {
                            FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable(MiniVipWithoutAdServlet.KEY_GET_MEMBER_STATE_RSP_MSG);
                            if (fromServiceMsg == null) {
                                QLog.e(MiniAppObserver.TAG, 1, "onGetVipWithoutAdMemberState error: rsp msg is null");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, jSONObject);
                                    return;
                                }
                                return;
                            }
                            MiniAppAd$StGetMemberStateRsp onResponse = MiniVipWithoutAdRequest.onResponse(fh.a(fromServiceMsg.getWupBuffer()));
                            if (onResponse == null) {
                                QLog.e(MiniAppObserver.TAG, 1, "onGetVipWithoutAdMemberState rsp is null:");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, jSONObject);
                                    return;
                                }
                                return;
                            }
                            try {
                                jSONObject.put(MiniVipWithoutAdServlet.KEY_GET_MEMBER_STATE_RSP, onResponse);
                            } catch (JSONException e16) {
                                QLog.e(MiniAppObserver.TAG, 1, "onGetVipWithoutAdMemberState error:", e16);
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, jSONObject);
                                    return;
                                }
                                return;
                            }
                        }
                        if (miniAppCmdInterface != null) {
                            miniAppCmdInterface.onCmdListener(z16, jSONObject);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetVipWithoutAdMemberState can not found listener: " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetWeixinSDKAppInfoFin(int i3, boolean z16, Bundle bundle) {
                    super.onGetWeixinSDKAppInfoFin(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            long j3 = bundle.getLong("retCode", -1L);
                            String string = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.o6k));
                            if (z16) {
                                byte[] byteArray = bundle.getByteArray("mini_app_info_pb_data");
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("appInfo_pb", byteArray);
                                jSONObject.put("retCode", j3);
                                jSONObject.put("errMsg", string);
                                if (miniAppCmdInterface != null) {
                                    QLog.e(MiniAppObserver.TAG, 1, "  onGetWeixinSDKAppInfoFin . " + i3);
                                    miniAppCmdInterface.onCmdListener(j3 == 0, jSONObject);
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call onGetWeixinSDKAppInfoFin fail.");
                                if (miniAppCmdInterface != null) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("retCode", j3);
                                    jSONObject2.put("errMsg", string);
                                    miniAppCmdInterface.onCmdListener(false, jSONObject2);
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetWeixinSDKAppInfoFin exception ", e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetWeixinSDKAppInfoFin can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetWxAppUrlResponse(int i3, boolean z16, Bundle bundle) {
                    super.onGetWxAppUrlResponse(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            long j3 = bundle.getLong("retCode", -1L);
                            String string = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.o6k));
                            if (z16) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("key_url", bundle.getString("key_url"));
                                if (miniAppCmdInterface != null) {
                                    QLog.e(MiniAppObserver.TAG, 1, "onSetWxAppURLResponse ." + i3);
                                    miniAppCmdInterface.onCmdListener(j3 == 0, jSONObject);
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call onSetWxAppURLResponse fail.");
                                if (miniAppCmdInterface != null) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("retCode", j3);
                                    jSONObject2.put("errMsg", string);
                                    miniAppCmdInterface.onCmdListener(false, jSONObject2);
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onSetWxAppURLResponse exception ", e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onSetWxAppURLResponse can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetuserCloudStorage(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("KVDataList", new JSONArray(bundle.getString("key_reslut_data")));
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(z16, jSONObject);
                                return;
                            }
                            return;
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onGetuserCloudStorage error. ", th5);
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetuserCloudStorage can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGuessYouLike(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            long j3 = bundle.getLong("retCode", -1L);
                            String string = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.o6m));
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("retCode", j3);
                            jSONObject.put("errMsg", string);
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable(MiniAppGuessYouLikeServlet.KEY_SEARCH_GUESS_YOU_LIKE);
                                if (fromServiceMsg != null) {
                                    jSONObject.put(MiniAppGuessYouLikeServlet.KEY_SEARCH_GUESS_YOU_LIKE_RSP, GuessYouLikeRequest.onResponse(fh.a(fromServiceMsg.getWupBuffer())));
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                } else {
                                    QLog.e(MiniAppObserver.TAG, 1, "call onGuessYouLike FromServiceMsg rsp is null.");
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(false, jSONObject);
                                    }
                                }
                            } else {
                                QLog.e(MiniAppObserver.TAG, 1, "call onGuessYouLike fail. errCode = " + j3 + ", errMsg = " + string);
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, jSONObject);
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGuessYouLike exception " + Log.getStackTraceString(e16));
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGuessYouLike can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onLocalSearchDataFin(int i3, boolean z16, Bundle bundle) {
                    super.onLocalSearchDataFin(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable("localSearchData");
                                if (fromServiceMsg != null) {
                                    SEARCH$StLocalSearchDataRsp onResponse = LocalSearchDataRequest.onResponse(fh.a(fromServiceMsg.getWupBuffer()));
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("response", onResponse);
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call onLocalSearchDataFin fail.");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onLocalSearchDataFin exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onLocalSearchDataFin can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onModifyFriendInteractiveStorage(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable("modifyFriendInteractiveStorage");
                                long j3 = bundle.getLong("retCode");
                                String string = bundle.getString("errMsg");
                                if (fromServiceMsg != null) {
                                    CloudStorage$StModifyFriendInteractiveStorageRsp onResponse = ModifyFriendInteractiveStorageReq.onResponse(fh.a(fromServiceMsg.getWupBuffer()));
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("response", onResponse);
                                    jSONObject.put(QzoneIPCModule.RESULT_CODE, fromServiceMsg.getResultCode());
                                    if (onResponse != null) {
                                        jSONObject.put("details", onResponse.details.get());
                                    }
                                    jSONObject.put("retCode", j3);
                                    jSONObject.put("errMsg", string);
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                        return;
                                    }
                                    return;
                                }
                                QLog.d(MiniAppObserver.TAG, 1, "call modifyFriendInteractiveStorage FromServiceMsg rsp is null.");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, new JSONObject());
                                    return;
                                }
                                return;
                            }
                            QLog.d(MiniAppObserver.TAG, 1, "call modifyFriendInteractiveStorage fail.");
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call modifyFriendInteractiveStorage exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "modifyFriendInteractiveStorage can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onOpenChannel(int i3, boolean z16, Bundle bundle) {
                    super.onOpenChannel(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        if (!z16) {
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject();
                            byte[] byteArray = bundle.getByteArray("responsedata");
                            if (byteArray != null) {
                                PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
                                stQWebRsp.mergeFrom(byteArray);
                                jSONObject.put("responsedata", stQWebRsp);
                            }
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(true, jSONObject);
                                return;
                            }
                            return;
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onOpenChannel error.", th5);
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onOpenChannel can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onRealTimeLogReport(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            long j3 = bundle.getLong("retCode", -1L);
                            String string = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.o6m));
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("retCode", j3);
                            jSONObject.put("errMsg", string);
                            if (!z16) {
                                QLog.e(MiniAppObserver.TAG, 1, "call onRealTimeLogReport fail. errCode = " + j3 + ", errMsg = " + string);
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, jSONObject);
                                }
                            } else if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(true, jSONObject);
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onRealTimeLogReport exception " + Log.getStackTraceString(e16));
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onRealTimeLogReport can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onRejectFrequentlyRecommends(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("retCode", bundle.getInt("retCode"));
                            jSONObject.put("errMsg", bundle.getString("key_Msg"));
                            if (z16) {
                                int i16 = bundle.getInt(RejectFrequentlyRecommendsServlet.KEY_STATE, -1);
                                if (i16 != -1) {
                                    jSONObject.put(RejectFrequentlyRecommendsServlet.KEY_STATE, i16);
                                } else {
                                    QLog.d(MiniAppObserver.TAG, 1, "call onRejectFrequentlyRecommends state is null.");
                                }
                            } else {
                                QLog.e(MiniAppObserver.TAG, 1, "onRejectFrequentlyRecommends fail");
                            }
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onRejectFrequentlyRecommends error. ", th5);
                        }
                        if (miniAppCmdInterface != null) {
                            miniAppCmdInterface.onCmdListener(z16, jSONObject);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onRejectFrequentlyRecommends can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onRemoveuserCloudStorage(int i3, boolean z16) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        if (miniAppCmdInterface != null) {
                            miniAppCmdInterface.onCmdListener(z16, new JSONObject());
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onRemoveuserCloudStorage can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onReportLogFileUrlServlet(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                JSONObject jSONObject = new JSONObject();
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call onReportLogFileUrlServlet fail.");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onReportLogFileUrlServlet exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onReportLogFileUrlServlet can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onReportShare(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                JSONObject jSONObject = new JSONObject();
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call onReportShare fail.");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onReportShare exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onReportShare can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onSearchApp(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            long j3 = bundle.getLong("retCode", -1L);
                            String string = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.o6m));
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("retCode", j3);
                            jSONObject.put("errMsg", string);
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable(MiniAppSearchAppServlet.KEY_SEARCH_APP);
                                if (fromServiceMsg != null) {
                                    jSONObject.put(MiniAppSearchAppServlet.KEY_SEARCH_APP_RSP, SearchAppRequest.onResponse(fh.a(fromServiceMsg.getWupBuffer())));
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                } else {
                                    QLog.e(MiniAppObserver.TAG, 1, "call onSearchApp FromServiceMsg rsp is null.");
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(false, jSONObject);
                                    }
                                }
                            } else {
                                QLog.e(MiniAppObserver.TAG, 1, "call onSearchApp fail. errCode = " + j3 + ", errMsg = " + string);
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, jSONObject);
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onSearchApp exception " + Log.getStackTraceString(e16));
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onSearchApp can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onSendArkMsg(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable("sendArkMsg");
                                long j3 = bundle.getLong("retCode");
                                String string = bundle.getString("errMsg");
                                if (fromServiceMsg != null) {
                                    MiniProgramShare$StSendArkMsgRsp onResponse = MiniAppSendArkMsgRequest.onResponse(fh.a(fromServiceMsg.getWupBuffer()));
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("response", onResponse);
                                    jSONObject.put(QzoneIPCModule.RESULT_CODE, fromServiceMsg.getResultCode());
                                    jSONObject.put("retCode", j3);
                                    jSONObject.put("errMsg", string);
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                } else {
                                    QLog.d(MiniAppObserver.TAG, 1, "call sendArkMsg FromServiceMsg rsp is null.");
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, new JSONObject());
                                    }
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call sendArkMsg fail.");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call sendArkMsg exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "sendArkMsg can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onSetAuth(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        if (miniAppCmdInterface != null) {
                            JSONObject jSONObject = new JSONObject();
                            if (bundle != null) {
                                try {
                                    jSONObject.put("retCode", bundle.getLong("retCode"));
                                } catch (JSONException e16) {
                                    e16.printStackTrace();
                                }
                            }
                            miniAppCmdInterface.onCmdListener(z16, jSONObject);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetUserHealthData can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onSetAvatar(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                JSONObject jSONObject = new JSONObject();
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call onGetUserInfoExtra fail.");
                                if (miniAppCmdInterface != null) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    long j3 = bundle.getLong("retCode", -1L);
                                    String string = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.o6n));
                                    jSONObject2.put("retCode", j3);
                                    jSONObject2.put("errMsg", string);
                                    miniAppCmdInterface.onCmdListener(false, jSONObject2);
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetUserInfoExtra exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetUserInfoExtra can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onSetCMShowPetStatus(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("retCode", bundle.getInt("retCode"));
                            jSONObject.put("errMsg", bundle.getString("errMsg"));
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onSetCMShowPetStatus error. ", th5);
                        }
                        if (miniAppCmdInterface != null) {
                            miniAppCmdInterface.onCmdListener(z16, jSONObject);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onSetCMShowPetStatus can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onSetGameBoxOptions(int i3, boolean z16, Bundle bundle) {
                    super.onSetGameBoxOptions(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        if (miniAppCmdInterface == null) {
                            return;
                        }
                        miniAppCmdInterface.onCmdListener(z16, new JSONObject());
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetGameBoxOptions can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onSetTopMiniAppFin(int i3, boolean z16, Bundle bundle) {
                    super.onSetTopMiniAppFin(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                JSONObject jSONObject = new JSONObject();
                                byte[] byteArray = bundle.getByteArray("key_extendinfo");
                                if (byteArray != null) {
                                    COMM.StCommonExt stCommonExt = new COMM.StCommonExt();
                                    stCommonExt.mergeFrom(byteArray);
                                    jSONObject.put("ext", stCommonExt);
                                }
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    return;
                                }
                                return;
                            }
                            QLog.d(MiniAppObserver.TAG, 1, "call onSetTopMiniAppFin fail.");
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onSetTopMiniAppFin exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onSetTopMiniAppFin can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onSetUserAppLikeFin(int i3, boolean z16, Bundle bundle) {
                    super.onSetUserAppLikeFin(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                JSONObject jSONObject = new JSONObject();
                                byte[] byteArray = bundle.getByteArray("key_extendinfo");
                                if (byteArray != null) {
                                    COMM.StCommonExt stCommonExt = new COMM.StCommonExt();
                                    stCommonExt.mergeFrom(byteArray);
                                    jSONObject.put("ext", stCommonExt);
                                }
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    return;
                                }
                                return;
                            }
                            QLog.d(MiniAppObserver.TAG, 1, "call onSetUserAppLikeFin fail.");
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onSetUserAppLikeFin exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onSetUserAppLikeFin can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onSetUserSwitch(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable(MiniAppSetUserSwitchServlet.KEY_SET_USER_SWITCH);
                                long j3 = bundle.getLong("retCode");
                                String string = bundle.getString("errMsg");
                                if (fromServiceMsg != null) {
                                    INTERFACE$StSetUserSwitchRsp onResponse = MiniAppSetUserSwitchRequest.onResponse(fh.a(fromServiceMsg.getWupBuffer()));
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put(MiniAppSetUserSwitchServlet.KEY_SET_USER_SWITCH, onResponse);
                                    jSONObject.put("retCode", j3);
                                    jSONObject.put("errMsg", string);
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    }
                                } else {
                                    QLog.d(MiniAppObserver.TAG, 1, "call setUserSwitch FromServiceMsg rsp is null.");
                                    if (miniAppCmdInterface != null) {
                                        miniAppCmdInterface.onCmdListener(true, new JSONObject());
                                    }
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call onSetUserSwitch fail.");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onSetUserSwitch exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onSetUserSwitch can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onSetWxAppInfoResponse(int i3, boolean z16, Bundle bundle) {
                    super.onSetWxAppInfoResponse(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            long j3 = bundle.getLong("retCode", -1L);
                            String string = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.o6k));
                            if (z16) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("retCode", j3);
                                if (miniAppCmdInterface != null) {
                                    QLog.e(MiniAppObserver.TAG, 1, "onSetWxAppInfoResponse ." + i3);
                                    miniAppCmdInterface.onCmdListener(j3 == 0, jSONObject);
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call onSetWxAppInfoResponse fail.");
                                if (miniAppCmdInterface != null) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("retCode", j3);
                                    jSONObject2.put("errMsg", string);
                                    miniAppCmdInterface.onCmdListener(false, jSONObject2);
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onSetWxAppInfoResponse exception ", e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onSetWxAppInfoResponse can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onSetWxAppUrlResponse(int i3, boolean z16, Bundle bundle) {
                    super.onSetWxAppUrlResponse(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            long j3 = bundle.getLong("retCode", -1L);
                            String string = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.o6k));
                            if (z16) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("retCode", j3);
                                if (miniAppCmdInterface != null) {
                                    QLog.e(MiniAppObserver.TAG, 1, "onSetWxAppURLResponse ." + i3);
                                    miniAppCmdInterface.onCmdListener(j3 == 0, jSONObject);
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call onSetWxAppURLResponse fail.");
                                if (miniAppCmdInterface != null) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("retCode", j3);
                                    jSONObject2.put("errMsg", string);
                                    miniAppCmdInterface.onCmdListener(false, jSONObject2);
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onSetWxAppURLResponse exception ", e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onSetWxAppURLResponse can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onSetuserCloudStorage(int i3, boolean z16) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        if (miniAppCmdInterface != null) {
                            miniAppCmdInterface.onCmdListener(z16, new JSONObject());
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onSetuserCloudStorage can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onTransForOpenIdAndTinyId(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            if (z16) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("openId", bundle.getString("key_open_id"));
                                jSONObject.put("tinyId", bundle.getString("key_tiny_id"));
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                }
                            } else {
                                QLog.d(MiniAppObserver.TAG, 1, "call onTransForOpenIdAndTinyId fail.");
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onTransForOpenIdAndTinyId exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onTransForOpenIdAndTinyId can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onTransForRoomId(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (z16) {
                                jSONObject.put("openId", bundle.getString("key_open_id"));
                                jSONObject.put("tinyId", bundle.getLong("key_tiny_id"));
                                jSONObject.put("roomId", bundle.getLong("key_room_id"));
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    return;
                                }
                                return;
                            }
                            QLog.d(MiniAppObserver.TAG, 1, "call onTransForRoomId fail.");
                            if (!TextUtils.isEmpty(bundle.getString("errMsg"))) {
                                jSONObject.put("errMsg", bundle.getString("errMsg"));
                            }
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, jSONObject);
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onTransForRoomId exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onTransForRoomId can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onUpdateUserSetting(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        if (z16) {
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(true, new JSONObject());
                                return;
                            }
                            return;
                        } else {
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onUpdateUserSetting can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onUseUserAppFin(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (z16) {
                                byte[] byteArray = bundle.getByteArray(MiniAppUseUserAppServlet.KEY_RECOMMEND);
                                INTERFACE$StUseUserAppRsp iNTERFACE$StUseUserAppRsp = new INTERFACE$StUseUserAppRsp();
                                iNTERFACE$StUseUserAppRsp.mergeFrom(byteArray);
                                List<INTERFACE$StModuleInfo> list = iNTERFACE$StUseUserAppRsp.recommendModule.get();
                                JSONArray jSONArray = new JSONArray();
                                Iterator<INTERFACE$StModuleInfo> it = list.iterator();
                                while (it.hasNext()) {
                                    jSONArray.mo162put(MiniAppCmdUtil.this.getSingleModuleJson(bundle, it.next()));
                                }
                                jSONObject.put("data", jSONArray);
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    return;
                                }
                                return;
                            }
                            QLog.d(MiniAppObserver.TAG, 1, "call onUseUserAppFin fail.");
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, jSONObject);
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onUseUserAppFin exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, jSONObject);
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onUseUserAppFin can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onVerifyPlugin(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            if (z16) {
                                jSONObject2.put("list", new JSONArray(bundle.getString(MiniAppVerifyPluginServlet.KEY_PLUGIN_PROFILE)));
                                jSONObject.put("data", jSONObject2);
                                if (miniAppCmdInterface != null) {
                                    miniAppCmdInterface.onCmdListener(true, jSONObject);
                                    return;
                                }
                                return;
                            }
                            QLog.d(MiniAppObserver.TAG, 1, "call onVerifyPlugin fail.");
                            if (!TextUtils.isEmpty(bundle.getString("errMsg"))) {
                                jSONObject.put("errMsg", bundle.getString("errMsg"));
                            }
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, jSONObject);
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onVerifyPlugin exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onVerifyPlugin can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onWxPayCheckUrlResult(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("retCode", bundle.getInt("retCode"));
                            jSONObject.put("errMsg", bundle.getString("errMsg"));
                            if (z16) {
                                jSONObject.put("key_url_valid", bundle.getInt("key_url_valid"));
                            }
                        } catch (Throwable th5) {
                            QLog.e(MiniAppObserver.TAG, 1, "onWxPayCheckUrlResult error. ", th5);
                        }
                        if (miniAppCmdInterface != null) {
                            miniAppCmdInterface.onCmdListener(z16, jSONObject);
                            return;
                        }
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onWxPayCheckUrlResult can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetPhoneNumber(int i3, boolean z16, Bundle bundle) {
                    super.onGetPhoneNumber(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        if (miniAppCmdInterface != null) {
                            if (z16 && bundle != null && bundle.containsKey("data")) {
                                INTERFACE$StGetPhoneNumberRsp iNTERFACE$StGetPhoneNumberRsp = new INTERFACE$StGetPhoneNumberRsp();
                                try {
                                    byte[] byteArray = bundle.getByteArray("data");
                                    if (byteArray != null) {
                                        iNTERFACE$StGetPhoneNumberRsp.mergeFrom(byteArray);
                                        List<INTERFACE$StPhoneNumber> list = iNTERFACE$StGetPhoneNumberRsp.phoneLists.get();
                                        JSONArray jSONArray = new JSONArray();
                                        if (list != null && list.size() > 0) {
                                            for (INTERFACE$StPhoneNumber iNTERFACE$StPhoneNumber : list) {
                                                if (iNTERFACE$StPhoneNumber != null) {
                                                    JSONObject jSONObject = new JSONObject();
                                                    jSONObject.put("phoneType", iNTERFACE$StPhoneNumber.phoneType.get());
                                                    jSONObject.put("purePhoneNumber", iNTERFACE$StPhoneNumber.purePhoneNumber.get());
                                                    jSONObject.put("countryCode", iNTERFACE$StPhoneNumber.countryCode.get());
                                                    jSONObject.put("iv", iNTERFACE$StPhoneNumber.f24964iv.get());
                                                    jSONObject.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, iNTERFACE$StPhoneNumber.encryptedData.get());
                                                    jSONObject.put(MiniConst.MiniAppCmdUtilConst.PHONE_NUMBER_ID, iNTERFACE$StPhoneNumber.phoneNumberID.get());
                                                    jSONArray.mo162put(jSONObject);
                                                }
                                            }
                                        }
                                        miniAppCmdInterface.onCmdListener(true, new JSONObject().put("countryCode", iNTERFACE$StGetPhoneNumberRsp.countryCode.get()).put("purePhoneNumber", iNTERFACE$StGetPhoneNumberRsp.purePhoneNumber.get()).put("iv", iNTERFACE$StGetPhoneNumberRsp.f24960iv.get()).put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, iNTERFACE$StGetPhoneNumberRsp.encryptedData.get()).put("cloudID", "").put("phoneLists", jSONArray).put("errMsg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                                        return;
                                    }
                                    QLog.e(MiniAppObserver.TAG, 2, "onGetPhoneNumber no bytes data found");
                                    return;
                                } catch (Exception e16) {
                                    QLog.e(MiniAppObserver.TAG, 1, "onGetPhoneNumber", e16);
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                    return;
                                }
                            }
                            if (bundle != null) {
                                try {
                                    miniAppCmdInterface.onCmdListener(false, new JSONObject().put("retCode", bundle.getLong("retCode")).put("errMsg", bundle.getString("errMsg")));
                                } catch (JSONException e17) {
                                    e17.printStackTrace();
                                }
                            }
                            QLog.e(MiniAppObserver.TAG, 1, "onGetPhoneNumber no data found");
                            return;
                        }
                        QLog.e(MiniAppObserver.TAG, 2, "onGetPhoneNumber empty listener");
                        return;
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetPhoneNumber no listener for " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetAppInfoByIdServlet(int i3, boolean z16, Bundle bundle) {
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            long j3 = bundle.getLong("retCode", 0L);
                            String string = bundle.getString("errMsg");
                            if (z16) {
                                com.tencent.mobileqq.mini.apkg.MiniAppInfo miniAppInfo = (com.tencent.mobileqq.mini.apkg.MiniAppInfo) bundle.getSerializable("mini_app_info_data");
                                byte[] bArr = (byte[]) bundle.getSerializable("mini_app_info_pb_data");
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("mini_app_info_data", miniAppInfo);
                                jSONObject.put("mini_app_info_pb_data", bArr);
                                jSONObject.put("retCode", j3);
                                jSONObject.put("errMsg", string);
                                if (miniAppCmdInterface != null) {
                                    QLog.e(MiniAppObserver.TAG, 1, "onGetAppInfoByIdServlet . " + i3);
                                    miniAppCmdInterface.onCmdListener(j3 == 0, jSONObject);
                                }
                                if (miniAppInfo != null) {
                                    MiniAppCmdUtil.this.getExtConfigDetail(miniAppInfo.commonExt, miniAppInfo.extConfigInfoList, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.1.2
                                        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                                        public void onCmdListener(boolean z17, JSONObject jSONObject2) {
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            QLog.d(MiniAppObserver.TAG, 1, "call onGetAppInfoByIdServlet fail.");
                            if (miniAppCmdInterface != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("retCode", j3);
                                jSONObject2.put("errMsg", string);
                                miniAppCmdInterface.onCmdListener(false, jSONObject2);
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetAppInfoByIdServlet exception " + e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetAppInfoByIdServlet can not found listener. " + i3);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppObserver
                protected void onGetAppInfoByLinkFin(int i3, boolean z16, Bundle bundle) {
                    super.onGetAppInfoByLinkFin(i3, z16, bundle);
                    if (MiniAppCmdUtil.this.listenerMap != null && MiniAppCmdUtil.this.listenerMap.containsKey(Integer.valueOf(i3))) {
                        MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) MiniAppCmdUtil.this.listenerMap.remove(Integer.valueOf(i3));
                        try {
                            long j3 = bundle.getLong("retCode", -1L);
                            String string = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.o6k));
                            if (z16) {
                                com.tencent.mobileqq.mini.apkg.MiniAppInfo miniAppInfo = (com.tencent.mobileqq.mini.apkg.MiniAppInfo) bundle.getSerializable("appInfo");
                                String string2 = bundle.getString("shareTicket", "");
                                byte[] bArr = (byte[]) bundle.getSerializable("appInfo_pd");
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("appInfo", miniAppInfo);
                                jSONObject.put("shareTicket", string2);
                                jSONObject.put("appInfo_pb", bArr);
                                jSONObject.put("retCode", j3);
                                jSONObject.put("errMsg", string);
                                if (miniAppCmdInterface != null) {
                                    QLog.e(MiniAppObserver.TAG, 1, "  onGetAppInfoByLinkFin . " + i3);
                                    miniAppCmdInterface.onCmdListener(j3 == 0, jSONObject);
                                }
                                if (miniAppInfo != null) {
                                    MiniAppCmdUtil.this.getExtConfigDetail(miniAppInfo.commonExt, miniAppInfo.extConfigInfoList, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.1.1
                                        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                                        public void onCmdListener(boolean z17, JSONObject jSONObject2) {
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            QLog.d(MiniAppObserver.TAG, 1, "call onGetAppInfoByLinkFin fail.");
                            if (miniAppCmdInterface != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("retCode", j3);
                                jSONObject2.put("errMsg", string);
                                miniAppCmdInterface.onCmdListener(false, jSONObject2);
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(MiniAppObserver.TAG, 1, "call onGetAppInfoByLinkFin exception ", e16);
                            if (miniAppCmdInterface != null) {
                                miniAppCmdInterface.onCmdListener(false, new JSONObject());
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(MiniAppObserver.TAG, 1, "onGetAppInfoByLinkFin can not found listener. " + i3);
                }
            };
        }
    }

    public static int getCallbackIndex() {
        return index.getAndIncrement();
    }

    private void getContainerInfoRequest(COMM.StCommonExt stCommonExt, String str, String str2, String str3, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetContainerInfoByIdForSDKServlet.class, miniAppCmdInterface, "GetContainerInfoById");
        newIntent.putExtra("key_app_id", str);
        newIntent.putExtra("key_first_path", str2);
        newIntent.putExtra("key_env_version", str3);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        AppRuntime peekAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        if (peekAppRuntime != null) {
            peekAppRuntime.startServlet(newIntent);
        } else {
            QLog.i(TAG, 1, "runtime is null");
            miniAppCmdInterface.onCmdListener(false, new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentListenerIndex(MiniAppCmdInterface miniAppCmdInterface, String str) {
        int incrementAndGet = index.incrementAndGet();
        ConcurrentHashMap<Integer, MiniAppCmdInterface> concurrentHashMap = this.listenerMap;
        if (concurrentHashMap != null && !concurrentHashMap.containsKey(Integer.valueOf(incrementAndGet)) && miniAppCmdInterface != null) {
            this.listenerMap.put(Integer.valueOf(incrementAndGet), miniAppCmdInterface);
        } else {
            QLog.e(TAG, 1, str + " index error");
        }
        return incrementAndGet;
    }

    public static MiniAppCmdUtil getInstance() {
        if (instance == null) {
            synchronized (MiniAppCmdUtil.class) {
                if (instance == null) {
                    instance = new MiniAppCmdUtil();
                }
            }
        }
        return instance;
    }

    public static int getReqSeqIndex() {
        return index.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject getSingleModuleJson(Bundle bundle, INTERFACE$StModuleInfo iNTERFACE$StModuleInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            INTERFACE$StUserAppInfo iNTERFACE$StUserAppInfo = iNTERFACE$StModuleInfo.jumpMoreApp.get();
            if (iNTERFACE$StUserAppInfo != null && iNTERFACE$StUserAppInfo.appInfo.get() != null) {
                jSONObject.put("moreAppInfo", GsonUtils.obj2Json(com.tencent.mobileqq.mini.apkg.MiniAppInfo.from(iNTERFACE$StUserAppInfo.appInfo.get())));
            }
            jSONObject.put("popupType", iNTERFACE$StModuleInfo.PopupType.get());
            int i3 = iNTERFACE$StModuleInfo.moduleType.get();
            jSONObject.put("moduleType", i3);
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            int size = iNTERFACE$StModuleInfo.userAppList.size();
            for (int i16 = 0; i16 < size; i16++) {
                INTERFACE$StUserAppInfo iNTERFACE$StUserAppInfo2 = iNTERFACE$StModuleInfo.userAppList.get(i16);
                if (iNTERFACE$StUserAppInfo2 != null && iNTERFACE$StUserAppInfo2.appInfo.get() != null) {
                    com.tencent.mobileqq.mini.apkg.MiniAppInfo from = com.tencent.mobileqq.mini.apkg.MiniAppInfo.from(iNTERFACE$StUserAppInfo2.appInfo.get());
                    from.userNum = iNTERFACE$StUserAppInfo2.userNum.get();
                    int i17 = iNTERFACE$StUserAppInfo2.friendNum.get();
                    from.friendNum = i17;
                    if (i17 > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (INTERFACE$UseUserInfo iNTERFACE$UseUserInfo : iNTERFACE$StUserAppInfo2.users.get()) {
                            if (iNTERFACE$UseUserInfo != null) {
                                UseUserInfo useUserInfo = new UseUserInfo();
                                useUserInfo.uin = iNTERFACE$UseUserInfo.uin.get();
                                useUserInfo.avatar = iNTERFACE$UseUserInfo.avatar.get();
                                useUserInfo.nick = iNTERFACE$UseUserInfo.nick.get();
                                arrayList.add(useUserInfo);
                            }
                        }
                        from.users = arrayList;
                    }
                    String obj2Json = GsonUtils.obj2Json(from);
                    jSONArray.mo162put(obj2Json);
                    jSONArray2.mo162put(obj2Json);
                }
            }
            jSONObject.put("appList", jSONArray);
            jSONObject.put("operationAppList", jSONArray2);
            jSONObject.put("backgroundPic", iNTERFACE$StModuleInfo.backgroundPic.get());
            jSONObject.put("jumpLink", iNTERFACE$StModuleInfo.jumpLink.get());
            byte[] byteArray = bundle.getByteArray("key_ext");
            if (byteArray != null) {
                COMM.StCommonExt stCommonExt = new COMM.StCommonExt();
                stCommonExt.mergeFrom(byteArray);
                CommExtInfo commExtInfo = new CommExtInfo();
                HashMap hashMap = new HashMap();
                for (COMM.Entry entry : stCommonExt.mapInfo.get()) {
                    if (entry != null) {
                        hashMap.put(entry.key.get(), entry.value.get());
                    }
                }
                commExtInfo.mapInfo = hashMap;
                commExtInfo.attachInfo = stCommonExt.attachInfo.get();
                jSONObject.put("ext", GsonUtils.obj2Json(commExtInfo));
            }
            INTERFACE$StUsageGuideStyle iNTERFACE$StUsageGuideStyle = iNTERFACE$StModuleInfo.usageGuide.get();
            if (iNTERFACE$StUsageGuideStyle != null && i3 == 4) {
                JSONObject jSONObject2 = new JSONObject();
                INTERFACE$StUsageGuideMedia iNTERFACE$StUsageGuideMedia = iNTERFACE$StUsageGuideStyle.media.get();
                if (iNTERFACE$StUsageGuideMedia != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("mediaType", iNTERFACE$StUsageGuideMedia.mediaType.get());
                    jSONObject3.put("autoSlideInterval", iNTERFACE$StUsageGuideMedia.autoSlideInterval.get());
                    List<String> list = iNTERFACE$StUsageGuideMedia.guideMedias.get();
                    if (list != null) {
                        JSONArray jSONArray3 = new JSONArray();
                        Iterator<String> it = list.iterator();
                        while (it.hasNext()) {
                            jSONArray3.mo162put(it.next());
                        }
                        jSONObject3.put("guideMediaUrls", jSONArray3);
                    }
                    jSONObject2.put(QAdVrReportParams.ParamKey.MEDIA, jSONObject3);
                }
                jSONObject.put("usageGuide", jSONObject2);
                RetainDialogModuleUtil.saveFunctionRetainJson(jSONObject);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, " usageGuideJson:" + jSONObject2 + " moduleType:" + i3);
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getContainerInfoByIdForSDK$0(MiniAppCmdInterface miniAppCmdInterface) {
        miniAppCmdInterface.onCmdListener(false, new JSONObject());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$getContainerInfoByIdForSDK$1(final MiniAppCmdInterface miniAppCmdInterface, COMM.StCommonExt stCommonExt, String str, String str2, String str3) {
        AppRuntime peekAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        if (!peekAppRuntime.isLogin() || !peekAppRuntime.isRunning()) {
            String str4 = TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getContainerInfoByIdForSDK fail, appRuntime state error:");
            sb5.append(!peekAppRuntime.isLogin());
            sb5.append(",");
            sb5.append(!peekAppRuntime.isLogin());
            QLog.e(str4, 1, sb5.toString());
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.reuse.g
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppCmdUtil.lambda$getContainerInfoByIdForSDK$0(MiniAppCmdInterface.this);
                }
            });
        }
        getContainerInfoRequest(stCommonExt, str, str2, str3, miniAppCmdInterface);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$getContainerInfoByIdForSDK$2() {
        AppRuntime peekAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        return Boolean.valueOf(peekAppRuntime != null && peekAppRuntime.isLogin() && peekAppRuntime.isRunning());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getContainerInfoByIdForSDK$3(MiniAppCmdInterface miniAppCmdInterface) {
        miniAppCmdInterface.onCmdListener(false, new JSONObject());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$getContainerInfoByIdForSDK$4(final MiniAppCmdInterface miniAppCmdInterface, Integer num, String str) {
        QLog.e(TAG, 1, "errCode:" + num + ",msg:" + str);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.reuse.j
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppCmdUtil.lambda$getContainerInfoByIdForSDK$3(MiniAppCmdInterface.this);
            }
        });
        return null;
    }

    private void sendCloudRequest(String str, String[] strArr, MiniAppCmdInterface miniAppCmdInterface, String str2) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) CloudStorageServlet.class, miniAppCmdInterface, "sendCloudRequest");
        newIntent.putExtra("key_data", strArr);
        newIntent.putExtra(CloudStorageServlet.REQUEST_TYPE, str2);
        newIntent.putExtra("app_id", str);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    private boolean shouldUpdateExtConfig(String str, String str2) {
        int parseInt;
        int parseInt2;
        if (str.equals(str2)) {
            return false;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        for (int i3 = 0; i3 < split.length; i3++) {
            try {
                if (i3 >= split2.length || (parseInt = Integer.parseInt(split[i3])) > (parseInt2 = Integer.parseInt(split2[i3]))) {
                    return false;
                }
                if (parseInt < parseInt2) {
                    return true;
                }
            } catch (Throwable unused) {
                return true;
            }
        }
        return split2.length > split.length;
    }

    public void OpenChannel(byte[] bArr, MiniAppCmdInterface miniAppCmdInterface) {
        new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppOpenChannelAbstractServlet.class, miniAppCmdInterface, "OpenChannel").putExtra("key_data", bArr);
    }

    public void addPhoneNumber(String str, String str2, String str3, int i3, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppAddPhoneNumberServlet.class, miniAppCmdInterface, "addPhoneNumber");
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra("purePhoneNumber", str2);
        newIntent.putExtra("countryCode", str3);
        newIntent.putExtra(MiniAppAddPhoneNumberServlet.KEY_IS_SAVE, i3);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void addRecentPlay(String str, int i3, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniGameAddRecentPlayServlet.class, miniAppCmdInterface, AddRecentPlayRequest.CMD_STRING);
        newIntent.putExtra("key_app_id", str);
        newIntent.putExtra("key_source", i3);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void batchGetContact(ArrayList<String> arrayList, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppBatchGetContactServlet.class, miniAppCmdInterface, "batchGetContact");
        newIntent.putStringArrayListExtra(MiniAppBatchGetContactServlet.KEY_APP_IDS, arrayList);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void batchGetFollowingCount(ArrayList<String> arrayList, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) FollowServlet.class, miniAppCmdInterface, "batchGetFollowingCount");
        newIntent.putStringArrayListExtra("key_appid_list", arrayList);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void changeShareImageUrl(String str, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppChangeShareImageUrlServlet.class, miniAppCmdInterface, "changeShareImageUrl");
        newIntent.putExtra(MiniAppChangeShareImageUrlServlet.KEY_OLD_IMAGE_URL, str);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void checkBindingState(String str, String str2, int i3, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) CheckBindingStateServlet.class, miniAppCmdInterface, "checkBindingState");
        newIntent.putExtra("key_uid", str2);
        newIntent.putExtra("key_appId", str);
        newIntent.putExtra(CheckBindingStateServlet.KEY_BINDTYPE, i3);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void checkNavigateRight(String str, String str2, COMM.StCommonExt stCommonExt, final MiniAppCmdInterface miniAppCmdInterface) {
        String loginMiniAppForbidToken = MiniAppSecurityUtil.getLoginMiniAppForbidToken(BaseApplicationImpl.getApplication(), MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication()));
        boolean z16 = MiniAppConfProcessor.f(QzoneConfig.SECONDARY_KEY_MINI_APP_USE_HTTPS_SEND_REQUEST, 0) == 0;
        if (!TextUtils.isEmpty(loginMiniAppForbidToken) && z16) {
            QLog.d(TAG, 1, "[miniapp-https-request].checkNavigateRight, send request by https.");
            HttpCmdManager.g().checkNavigateRight(str, str2, loginMiniAppForbidToken, new HttpCmdResult() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.7
                @Override // com.tencent.mobileqq.mini.network.http.HttpCmdResult
                public void onCmdListener(boolean z17, JSONObject jSONObject) {
                    MiniAppCmdInterface miniAppCmdInterface2 = miniAppCmdInterface;
                    if (miniAppCmdInterface2 != null) {
                        miniAppCmdInterface2.onCmdListener(z17, jSONObject);
                    } else {
                        QLog.e(MiniAppCmdUtil.TAG, 1, "checkNavigateRight, listener is null.");
                    }
                }
            });
            return;
        }
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppCheckNavigateRightServlet.class, miniAppCmdInterface, "checkNavigateRight");
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra(MiniAppCheckNavigateRightServlet.KEY_TARGET_APP_ID, str2);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void checkOfferId(String str, String str2, COMM.StCommonExt stCommonExt, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppCheckOfferIdServlet.class, miniAppCmdInterface, "checkOfferId");
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra(MiniAppCheckOfferIdServlet.KEY_OFFER_ID, str2);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void checkSession(String str, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppCheckSessionServlet.class, miniAppCmdInterface, "checkSession");
        try {
            newIntent.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "checkSession ", e16);
        }
        newIntent.putExtra("key_appid", str);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void checkWxPayUrl(String str, String str2, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniWxPayCheckUrlServlet.class, miniAppCmdInterface, "wxPayCheckUrl");
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra("key_url", str2);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void createUpdatableMsg(String str, String str2, int i3, int i16, int i17, String str3, MiniAppCmdInterface miniAppCmdInterface) {
        createUpdatableMsg(str, str2, i3, i16, i17, str3, 0, null, miniAppCmdInterface);
    }

    public void delPhoneNumber(String str, String str2, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppDelPhoneNumberServlet.class, miniAppCmdInterface, "delPhoneNumbers");
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra("purePhoneNumber", str2);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void delUserApp(String str, int i3, int i16, int i17, COMM.StCommonExt stCommonExt, MiniAppCmdInterface miniAppCmdInterface) {
        delUserApp(str, i3, i16, i17, stCommonExt, 0, miniAppCmdInterface);
    }

    public void doGameRaffle(String str, String str2, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) DoGameRaffleServlet.class, miniAppCmdInterface, "doGameRaffle");
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra("key_uin", str2);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getAppInfoById(COMM.StCommonExt stCommonExt, String str, String str2, String str3, MiniAppCmdInterface miniAppCmdInterface) {
        getAppInfoById(stCommonExt, str, str2, str3, null, miniAppCmdInterface);
    }

    public void getAppInfoByIdForSDK(COMM.StCommonExt stCommonExt, String str, String str2, String str3, MiniAppCmdInterface miniAppCmdInterface) {
        getAppInfoByIdForSDK(stCommonExt, str, str2, str3, null, miniAppCmdInterface);
    }

    public void getAppInfoByLink(String str, int i3, final MiniAppCmdInterface miniAppCmdInterface) {
        String loginMiniAppForbidToken = MiniAppSecurityUtil.getLoginMiniAppForbidToken(BaseApplicationImpl.getApplication(), MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication()));
        boolean z16 = MiniAppConfProcessor.f(QzoneConfig.SECONDARY_KEY_MINI_APP_USE_HTTPS_SEND_REQUEST, 0) == 0;
        if (!TextUtils.isEmpty(loginMiniAppForbidToken) && z16) {
            QLog.d(TAG, 1, "getAppInfoByLink, send request by https.");
            HttpCmdManager.g().getAppInfoByLink(str, i3, loginMiniAppForbidToken, new HttpCmdResult() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.3
                @Override // com.tencent.mobileqq.mini.network.http.HttpCmdResult
                public void onCmdListener(boolean z17, JSONObject jSONObject) {
                    MiniAppCmdInterface miniAppCmdInterface2 = miniAppCmdInterface;
                    if (miniAppCmdInterface2 != null) {
                        miniAppCmdInterface2.onCmdListener(z17, jSONObject);
                    } else {
                        QLog.e(MiniAppCmdUtil.TAG, 1, "getAppInfoByLink, listener is null.");
                    }
                }
            });
            return;
        }
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetAppInfoByLinkServlet.class, miniAppCmdInterface, "getAppInfoByLink");
        try {
            newIntent.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getAppInfoByLink ", e16);
        }
        newIntent.putExtra(MiniAppAbstractServlet.KEY_LINK, str);
        newIntent.putExtra(MiniAppAbstractServlet.KEY_LINK_TYPE, i3);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getAppInfoByLinkForSDK(String str, int i3, final MiniAppCmdInterface miniAppCmdInterface) {
        String loginMiniAppForbidToken = MiniAppSecurityUtil.getLoginMiniAppForbidToken(BaseApplicationImpl.getApplication(), MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication()));
        boolean z16 = MiniAppConfProcessor.f(QzoneConfig.SECONDARY_KEY_MINI_APP_USE_HTTPS_SEND_REQUEST, 0) == 0;
        if (!TextUtils.isEmpty(loginMiniAppForbidToken) && z16) {
            QLog.d(TAG, 1, "getAppInfoByLinkForSDK, send request by https.");
            HttpCmdManager.g().getAppInfoByLink(str, i3, loginMiniAppForbidToken, new HttpCmdResult() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.5
                @Override // com.tencent.mobileqq.mini.network.http.HttpCmdResult
                public void onCmdListener(boolean z17, JSONObject jSONObject) {
                    try {
                        jSONObject.put("mini_app_info_data", MiniSdkLauncher.convert((com.tencent.mobileqq.mini.apkg.MiniAppInfo) jSONObject.opt("appInfo")));
                        jSONObject.remove("appInfo");
                        miniAppCmdInterface.onCmdListener(z17, jSONObject);
                    } catch (Exception e16) {
                        QLog.e(MiniAppCmdUtil.TAG, 1, "getAppInfoByLinkForSDK, exception: " + Log.getStackTraceString(e16));
                    }
                }
            });
            return;
        }
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetAppInfoByLinkForSDKServlet.class, miniAppCmdInterface, "getAppInfoByLink");
        try {
            newIntent.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getAppInfoByLinkForSDK ", e16);
        }
        newIntent.putExtra(MiniAppAbstractServlet.KEY_LINK, str);
        newIntent.putExtra(MiniAppAbstractServlet.KEY_LINK_TYPE, i3);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getAuthList(COMM.StCommonExt stCommonExt, String str, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetAuthListServlet.class, miniAppCmdInterface, "getAuthList");
        newIntent.putExtra("key_appid", str);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getBatchQueryAppInfo(COMM.StCommonExt stCommonExt, ArrayList<String> arrayList, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppBatchQueryAppInfoServlet.class, miniAppCmdInterface, "getBatchQueryAppInfo");
        newIntent.putStringArrayListExtra("key_appid_list", arrayList);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getCMShowInfo(String str, String str2, String str3, String str4, String str5, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) GetCMShowInfoServlet.class, miniAppCmdInterface, PluginConst.CMShowJsPluginConst.API_GET_CM_SHOW_INFO);
        newIntent.putExtra(GetCMShowInfoServlet.EXTRA_OPENID, str);
        newIntent.putExtra("appid", str2);
        newIntent.putExtra(GetCMShowInfoServlet.EXTRA_ENGINE_TYPE, str3);
        newIntent.putExtra(GetCMShowInfoServlet.EXTRA_ENGINE_VERSION, str4);
        newIntent.putExtra("avatar_type", str5);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getContainerInfoByIdForSDK(final COMM.StCommonExt stCommonExt, final String str, final String str2, final String str3, final MiniAppCmdInterface miniAppCmdInterface) {
        QLog.i(TAG, 1, "getContainerInfoByIdForSDK \u5f00\u59cb\u8bf7\u6c42");
        new SimpleRequest().logic(new Function0() { // from class: com.tencent.mobileqq.mini.reuse.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit lambda$getContainerInfoByIdForSDK$1;
                lambda$getContainerInfoByIdForSDK$1 = MiniAppCmdUtil.this.lambda$getContainerInfoByIdForSDK$1(miniAppCmdInterface, stCommonExt, str, str2, str3);
                return lambda$getContainerInfoByIdForSDK$1;
            }
        }).condition(new Function0() { // from class: com.tencent.mobileqq.mini.reuse.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Boolean lambda$getContainerInfoByIdForSDK$2;
                lambda$getContainerInfoByIdForSDK$2 = MiniAppCmdUtil.lambda$getContainerInfoByIdForSDK$2();
                return lambda$getContainerInfoByIdForSDK$2;
            }
        }).failedCallBack(new Function2() { // from class: com.tencent.mobileqq.mini.reuse.f
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit lambda$getContainerInfoByIdForSDK$4;
                lambda$getContainerInfoByIdForSDK$4 = MiniAppCmdUtil.lambda$getContainerInfoByIdForSDK$4(MiniAppCmdInterface.this, (Integer) obj, (String) obj2);
                return lambda$getContainerInfoByIdForSDK$4;
            }
        }).request();
    }

    public void getContentAccelerate(String str, String str2, int i3, Map<String, String> map, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppContentAccelerateServlet.class, miniAppCmdInterface, "getAppInfoById");
        newIntent.putExtra("key_app_id", str);
        newIntent.putExtra(MiniAppContentAccelerateServlet.KEY_DATA_URL, str2);
        newIntent.putExtra(MiniAppContentAccelerateServlet.KEY_NEED_CODE, i3);
        newIntent.putExtra(MiniAppContentAccelerateServlet.KEY_REQ_HEADER, (Serializable) map);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getFormId(String str, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetFormIdServlet.class, miniAppCmdInterface, "getFormId");
        newIntent.putExtra("key_appid", str);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getFriendCloudStorage(String str, String[] strArr, MiniAppCmdInterface miniAppCmdInterface) {
        sendCloudRequest(str, strArr, miniAppCmdInterface, CloudStorageServlet.GET_FRIEND_CLOUD_STORAGE);
    }

    public void getGameBoxOptions(String str, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetGameBoxOptionsServlet.class, miniAppCmdInterface, MiniAppGetGameBoxOptionsServlet.CMD_STRING);
        newIntent.putExtra("appId", str);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getGameLaunchConfig(String str, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetLaunchConfigServlet.class, miniAppCmdInterface, MiniAppGetLaunchConfigServlet.CMD_STRING);
        newIntent.putExtra("appId", str);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getGameRaffleMaterial(String str, String str2, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) GetGameRaffleMaterialServlet.class, miniAppCmdInterface, "getGameRaffleMaterial");
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra("key_uin", str2);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getGameTaskTicket(String str, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetGameTaskTicketServlet.class, miniAppCmdInterface, MiniAppGetGameTaskTicketServlet.CMD_STRING);
        newIntent.putExtra("appId", str);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getGroupCloudStorage(String str, String str2, String[] strArr, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) CloudStorageServlet.class, miniAppCmdInterface, "getGroupCloudStorage");
        newIntent.putExtra(CloudStorageServlet.KEY_SHARETICKET, str2);
        newIntent.putExtra("key_data", strArr);
        newIntent.putExtra("app_id", str);
        newIntent.putExtra(CloudStorageServlet.REQUEST_TYPE, CloudStorageServlet.GET_GROUP_CLOUD_STORAGE);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getGroupShareInfo(String str, String str2, COMM.StCommonExt stCommonExt, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetGroupShareInfoServlet.class, miniAppCmdInterface, "getGroupShareInfo");
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra(MiniAppGetGroupShareInfoServlet.KEY_SHARETICKET, str2);
        newIntent.putExtra("key_appid", str);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getGuildJoinUrl(String str, final BunddleListener bunddleListener) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) GetGuildJoinUrlServlet.class, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.reuse.a
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                MiniAppCmdUtil.lambda$getGuildJoinUrl$5(z16, jSONObject);
            }
        }, GetGuildJoinUrlServlet.CMD_NAME);
        newIntent.putExtra("guildId", str);
        newIntent.setObserver(new BusinessObserver() { // from class: com.tencent.mobileqq.mini.reuse.b
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i3, boolean z16, Bundle bundle) {
                MiniAppCmdUtil.BunddleListener.this.onResult(z16, bundle);
            }
        });
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getHotSearchApps(COMM.StCommonExt stCommonExt, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetHotSearchAppsServlet.class, miniAppCmdInterface, "GetHotSearchApps");
        if (stCommonExt != null) {
            newIntent.putExtra("key_hot_search_ext_info", stCommonExt.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getHotSearchAppsV2(COMM.StCommonExt stCommonExt, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetHotSearchAppsV2Servlet.class, miniAppCmdInterface, "GetHotSearchAppsV2");
        if (stCommonExt != null) {
            newIntent.putExtra("key_hot_search_ext_info", stCommonExt.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getKuolieAppList(COMM.StCommonExt stCommonExt, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetKuolieApplistServlet.class, miniAppCmdInterface, "GetExpandAppList");
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getLocalSearchData(COMM.StCommonExt stCommonExt, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppLocalSearchDataServlet.class, miniAppCmdInterface, "getLocalSearchData");
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getLoginCode(String str, final MiniAppCmdInterface miniAppCmdInterface) {
        String loginMiniAppForbidToken = MiniAppSecurityUtil.getLoginMiniAppForbidToken(BaseApplicationImpl.getApplication(), MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication()));
        boolean z16 = MiniAppConfProcessor.f(QzoneConfig.SECONDARY_KEY_MINI_APP_USE_HTTPS_SEND_REQUEST, 0) == 0;
        if (!TextUtils.isEmpty(loginMiniAppForbidToken) && z16) {
            QLog.d(TAG, 1, "getLoginCode, send request by https");
            HttpCmdManager.g().getCode(str, loginMiniAppForbidToken, new HttpCmdResult() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.2
                @Override // com.tencent.mobileqq.mini.network.http.HttpCmdResult
                public void onCmdListener(boolean z17, JSONObject jSONObject) {
                    MiniAppCmdInterface miniAppCmdInterface2 = miniAppCmdInterface;
                    if (miniAppCmdInterface2 != null) {
                        miniAppCmdInterface2.onCmdListener(z17, jSONObject);
                    } else {
                        QLog.e(MiniAppCmdUtil.TAG, 1, "getLoginCode, listener is null.");
                    }
                }
            });
            return;
        }
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetLoginCodeServlet.class, miniAppCmdInterface, "getLoginCode");
        try {
            newIntent.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getLoginCode ", e16);
        }
        newIntent.putExtra("key_appid", str);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getMidasConsumeResult(String str, String str2, int i3, int i16, int i17, int i18, int i19, COMM.StCommonExt stCommonExt, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniMidasConsumeServlet.class, miniAppCmdInterface, "getMidasConsumeResult");
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra("key_prepay_id", str2);
        newIntent.putExtra("key_star_currency", i3);
        newIntent.putExtra(MiniMidasConsumeServlet.KEY_BALANCE_AMOUNT, i16);
        newIntent.putExtra(MiniMidasConsumeServlet.KEY_TOPUP_AMOUNT, i17);
        newIntent.putExtra(MiniMidasConsumeServlet.KEY_PAY_CHANNEL, i18);
        newIntent.putExtra(MiniMidasConsumeServlet.KEY_PAY_ENV, i19);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getMidasQueryResult(String str, String str2, int i3, int i16, COMM.StCommonExt stCommonExt, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniMidasQueryServlet.class, miniAppCmdInterface, "getMidasQueryResult");
        newIntent.putExtra("key_prepay_id", str);
        newIntent.putExtra("key_star_currency", i3);
        newIntent.putExtra("key_appid", str2);
        newIntent.putExtra(MiniMidasQueryServlet.KEY_SET_ENV, i16);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getMiniAppStoreAppList(int i3, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppStoreGetAppListServlet.class, miniAppCmdInterface, "getMiniAppStoreAppList");
        newIntent.putExtra(MiniAppAbstractServlet.KEY_APP_STORE_GET_APP_LIST_TYPE, i3);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getNativeAppInfoForJump(COMM.StCommonExt stCommonExt, String str, String str2, String str3, int i3, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetNativeAppInfoServlet.class, miniAppCmdInterface, "GetNAppForJump");
        newIntent.putExtra("key_app_id", str);
        newIntent.putExtra(MiniAppGetNativeAppInfoServlet.KEY_PACKAGE_NAME, str3);
        newIntent.putExtra(MiniAppGetNativeAppInfoServlet.KEY_NATIVE_APP_ID, str2);
        newIntent.putExtra("key_scene", i3);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getPhoneNumber(String str, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetPhoneNumberServlet.class, miniAppCmdInterface, "getPhoneNumber");
        newIntent.putExtra("key_appid", str);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getPotentialFriendList(COMM.StCommonExt stCommonExt, String str, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) GetPotentialFriendListServlet.class, miniAppCmdInterface, "getPotentialFriendList");
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        newIntent.putExtra("key_appid", str);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getPrivacyInfo(String str, String str2, final MiniAppCmdBundleListener miniAppCmdBundleListener) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetPrivacyDetailServlet.class, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.reuse.h
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                MiniAppCmdUtil.lambda$getPrivacyInfo$7(z16, jSONObject);
            }
        }, MiniAppGetPrivacyDetailServlet.CMD_NAME);
        newIntent.putExtra("app_id", str);
        newIntent.putExtra("event_name", str2);
        newIntent.setObserver(new BusinessObserver() { // from class: com.tencent.mobileqq.mini.reuse.i
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i3, boolean z16, Bundle bundle) {
                MiniAppCmdBundleListener.this.onResult(z16, bundle);
            }
        });
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getReactiveFriendList(COMM.StCommonExt stCommonExt, String str, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) GetReactiveFriendListServlet.class, miniAppCmdInterface, "getReactiveFriendList");
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        newIntent.putExtra("key_appid", str);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getRecommendAppList(COMM.StCommonExt stCommonExt, String str, int i3, long j3, ArrayList<RecommendAppInfo> arrayList, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetRecommendAppListServlet.class, miniAppCmdInterface, "getRecommendAppList");
        newIntent.putExtra("key_app_id", str);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext_info", stCommonExt.toByteArray());
        }
        newIntent.putExtra(MiniAppGetRecommendAppListServlet.KEY_VER_TYPE, i3);
        newIntent.putExtra(MiniAppGetRecommendAppListServlet.KEY_USE_TIME, j3);
        newIntent.putParcelableArrayListExtra("key_old_recommend_list", arrayList);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getRobotUin(String str, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetRobotUinServlet.class, miniAppCmdInterface, "GetRobotUin");
        newIntent.putExtra("key_app_id", str);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getRoleGroupInfo(String str, final MiniAppCmdBundleListener miniAppCmdBundleListener) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetRoleGroupInfoServlet.class, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.reuse.c
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                MiniAppCmdUtil.lambda$getRoleGroupInfo$9(z16, jSONObject);
            }
        }, MiniAppGetRoleGroupInfoServlet.CMD_NAME);
        newIntent.putExtra("app_id", str);
        newIntent.setObserver(new BusinessObserver() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.8
            @Override // mqq.observer.BusinessObserver
            public void onReceive(int i3, boolean z16, Bundle bundle) {
                miniAppCmdBundleListener.onResult(z16, bundle);
            }
        });
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getShareInfo(MiniProgramShare$StAdaptShareInfoReq miniProgramShare$StAdaptShareInfoReq, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetShareInfoServlet.class, miniAppCmdInterface, "getShareInfo");
        if (miniProgramShare$StAdaptShareInfoReq != null) {
            QLog.d(TAG, 4, "getShareInfo origin:" + miniProgramShare$StAdaptShareInfoReq.origin.get() + ", shareType:" + miniProgramShare$StAdaptShareInfoReq.shareType.get());
            newIntent.putExtra("key_data", miniProgramShare$StAdaptShareInfoReq.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getSwitchList(COMM.StCommonExt stCommonExt, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetSwitchListServlet.class, miniAppCmdInterface, MiniAppGetSwitchListServlet.KEY_GET_SWITCH_LIST);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getTcbTicket(String str, COMM.StCommonExt stCommonExt, String str2, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetTcbTicketServlet.class, miniAppCmdInterface, "getTcbTicket");
        newIntent.putExtra("key_app_id", str);
        newIntent.putExtra(MiniAppGetTcbTicketServlet.KEY_ENV_ID, str2);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext_info", stCommonExt.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getTeenagerConfig(String str, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetTeenagerConfigServlet.class, miniAppCmdInterface, "getTeenagerConfig");
        newIntent.putExtra(MiniAppGetTeenagerConfigServlet.KEY_REQUEST_EXT_INFO, str);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getTinyId(String str, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetTinyIdServlet.class, miniAppCmdInterface, "Trans4Tinyid");
        newIntent.putExtra("key_app_id", str);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getUserAppInfo(ArrayList<String> arrayList, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetUserAppInfoServlet.class, miniAppCmdInterface, "userAppInfo");
        newIntent.putStringArrayListExtra(MiniAppGetUserAppInfoServlet.KEY_APPIDS, arrayList);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getUserAppList(long j3, long j16, COMM.StCommonExt stCommonExt, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetUserAppListServlet.class, miniAppCmdInterface, "getUserAppList");
        newIntent.putExtra("key_uin", j3);
        newIntent.putExtra("key_num", j16);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getUserAppListV2(COMM.StCommonExt stCommonExt, GetAppListV2Scene getAppListV2Scene, ArrayList<RecommendAppInfo> arrayList, ArrayList<Integer> arrayList2, ArrayList<Integer> arrayList3, ArrayList<String> arrayList4, int i3, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetUserAppListServletV2.class, miniAppCmdInterface, "getDowloadAppList");
        if (stCommonExt != null) {
            try {
                newIntent.putExtra("key_ext_info", stCommonExt.toByteArray());
            } catch (Exception e16) {
                QLog.e(TAG, 1, "extInfoBytes extInfo error!", e16);
            }
        }
        if (getAppListV2Scene == null) {
            getAppListV2Scene = GetAppListV2Scene.UN_KNOWN;
        }
        QLog.i(TAG, 2, "[getUserAppListV2] scene=" + getAppListV2Scene.name());
        newIntent.putExtra("scene", getAppListV2Scene.ordinal());
        newIntent.putIntegerArrayListExtra("key_module_types", arrayList2);
        newIntent.putParcelableArrayListExtra("key_old_recommend_list", arrayList);
        newIntent.putExtra("key_use_cache", i3);
        newIntent.putIntegerArrayListExtra("key_sub_types", arrayList3);
        newIntent.putStringArrayListExtra("key_item_ids", arrayList4);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getUserAppListV3(COMM.StCommonExt stCommonExt, GetAppListV2Scene getAppListV2Scene, ArrayList<RecommendAppInfo> arrayList, ArrayList<Integer> arrayList2, ArrayList<Integer> arrayList3, ArrayList<String> arrayList4, int i3, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetUserAppListServletV3.class, miniAppCmdInterface, "getDropdownAppList");
        if (stCommonExt != null) {
            try {
                newIntent.putExtra("key_ext_info", stCommonExt.toByteArray());
            } catch (Exception e16) {
                QLog.e(TAG, 1, "extInfoBytes extInfo error!", e16);
            }
        }
        if (getAppListV2Scene == null) {
            getAppListV2Scene = GetAppListV2Scene.UN_KNOWN;
        }
        QLog.i(TAG, 2, "[getUserAppListV3] scene=" + getAppListV2Scene.name());
        newIntent.putExtra("scene", getAppListV2Scene.ordinal());
        newIntent.putIntegerArrayListExtra("key_module_types", arrayList2);
        newIntent.putParcelableArrayListExtra("key_old_recommend_list", arrayList);
        newIntent.putExtra("key_use_cache", i3);
        newIntent.putIntegerArrayListExtra("key_sub_types", arrayList3);
        newIntent.putStringArrayListExtra("key_item_ids", arrayList4);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getUserCloudStorage(String str, String[] strArr, MiniAppCmdInterface miniAppCmdInterface) {
        sendCloudRequest(str, strArr, miniAppCmdInterface, CloudStorageServlet.GET_CLOUD_STORAGE);
    }

    public void getUserGroupInfo(COMM.StCommonExt stCommonExt, String str, String str2, long j3, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetUserGroupInfoServlet.class, miniAppCmdInterface, "getUserGroupInfo");
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra("group_id", str2);
        newIntent.putExtra("group_class", j3);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getUserHealthData(String str, COMM.StCommonExt stCommonExt, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppUserHealthDataServlet.class, miniAppCmdInterface, "getUserHealthData");
        newIntent.putExtra("key_app_id", str);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext_info", stCommonExt.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getUserInfo(String str, boolean z16, String str2, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetProfileServlet.class, miniAppCmdInterface, "getUserInfo");
        try {
            newIntent.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getUserInfo ", e16);
        }
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra(MiniAppAbstractServlet.KEY_WITH_CREDENTIAL, z16);
        newIntent.putExtra(MiniAppAbstractServlet.KEY_LANG, str2);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getUserInfoExtra(String str, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetUserInfoExtraServlet.class, miniAppCmdInterface, GetUserInfoExtraRequest.TAG);
        newIntent.putExtra("key_appid", str);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getUserInfoOpenData(String str, String str2, String[] strArr, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) BatchGetUserInfoServlet.class, miniAppCmdInterface, "batchGetUserInfo");
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra(MiniAppAbstractServlet.KEY_LANG, str2);
        newIntent.putExtra("key_openid", strArr);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getUserInteractiveStorage(COMM.StCommonExt stCommonExt, String str, String[] strArr, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) GetUserInteractiveStorageServlet.class, miniAppCmdInterface, "getUserInteractiveStorage");
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra("key_data", strArr);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getUserSetting(String str, String str2, String str3, ArrayList<String> arrayList, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetUserSettingServlet.class, miniAppCmdInterface, "GetUserSetting");
        newIntent.putExtra(MiniAppGetUserSettingServlet.KEY_APP_ID, str);
        newIntent.putExtra(MiniAppGetUserSettingServlet.KEY_OPEN_ID, str2);
        newIntent.putExtra(MiniAppGetUserSettingServlet.KEY_SETTING_ITEM, str3);
        if (arrayList != null) {
            newIntent.putStringArrayListExtra(MiniAppGetUserSettingServlet.KEY_TEMPLATE_IDS, arrayList);
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getVipWithoutAdMemberState(MiniAppCmdInterface miniAppCmdInterface) {
        BaseApplicationImpl.getApplication().getRuntime().startServlet(new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniVipWithoutAdServlet.class, miniAppCmdInterface, MiniVipWithoutAdServlet.CMD));
    }

    public void getWeixinSDKAppInfo(String str, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) GetWeixinSDKAppInfoServlet.class, miniAppCmdInterface, "getWeixinSDKAppInfo");
        try {
            newIntent.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getAppInfoByLink ", e16);
        }
        newIntent.putExtra(MiniAppAbstractServlet.KEY_CODE, str);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getWxAppUrl(int i3, String str, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) GetWxAppUrlServlet.class, miniAppCmdInterface, GetWxAppUrlServlet.CMD_NAME);
        newIntent.putExtra(MiniAppAbstractServlet.KEY_CODE_TYPE, i3);
        newIntent.putExtra(MiniAppAbstractServlet.KEY_CODE, str);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void guessYouLike(COMM.StCommonExt stCommonExt, int i3, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGuessYouLikeServlet.class, miniAppCmdInterface, "GetGuessYouLike");
        if (stCommonExt != null) {
            newIntent.putExtra(MiniAppGuessYouLikeServlet.KEY_EXT_INFO, stCommonExt.toByteArray());
        }
        newIntent.putExtra(MiniAppGuessYouLikeServlet.KEY_SEARCH_GUESS_YOU_LIKE_COUNT, i3);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void insertBookShelf(String str, String str2, ArrayList<String> arrayList, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) BookShelfInsertServlet.class, miniAppCmdInterface, "InsertBookShelf");
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra("key_category", str2);
        newIntent.putStringArrayListExtra("key_contentIds", arrayList);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void modifyFriendInteractiveStorage(COMM.StCommonExt stCommonExt, String str, String str2, String str3, int i3, String str4, HashMap<String, String> hashMap, boolean z16, CloudStorage$StInteractiveTemplate cloudStorage$StInteractiveTemplate, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) ModifyFriendInteractiveStorageServlet.class, miniAppCmdInterface, "modifyFriendInteractiveStorage");
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        if (cloudStorage$StInteractiveTemplate != null) {
            newIntent.putExtra(ModifyFriendInteractiveStorageServlet.KEY_INTERACTIVE_TEMPLATE, cloudStorage$StInteractiveTemplate.toByteArray());
        }
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra(ModifyFriendInteractiveStorageServlet.KEY_TO_USER, str2);
        newIntent.putExtra(ModifyFriendInteractiveStorageServlet.KEY_SHARE_ID, str3);
        newIntent.putExtra(ModifyFriendInteractiveStorageServlet.KEY_OPNUM, i3);
        newIntent.putExtra(ModifyFriendInteractiveStorageServlet.KEY_OPERATION, str4);
        newIntent.putExtra("key_data", hashMap);
        newIntent.putExtra(ModifyFriendInteractiveStorageServlet.KEY_QUIET, z16);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void performDataReport(byte[] bArr, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppDataReportServlet.class, miniAppCmdInterface, "report");
        newIntent.putExtra("key_data", bArr);
        if (BaseApplicationImpl.getApplication().getRuntime() != null) {
            BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
        } else {
            QLog.e(TAG, 1, "performReport failed: BaseApplicationImpl.getApplication().getRuntime() is null");
        }
    }

    public void performReport(byte[] bArr, MiniAppCmdInterface miniAppCmdInterface, String str) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppDcReportServlet.class, miniAppCmdInterface, "report");
        newIntent.putExtra("key_data", bArr);
        newIntent.putExtra("key_cmd", str);
        if (BaseApplicationImpl.getApplication().getRuntime() != null) {
            BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
        } else {
            QLog.e(TAG, 1, "performReport failed: BaseApplicationImpl.getApplication().getRuntime() is null");
        }
    }

    public void queryBookShelf(String str, ArrayList<String> arrayList, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) BookShelfQueryServlet.class, miniAppCmdInterface, "QueryBookShelf");
        newIntent.putExtra("key_appid", str);
        newIntent.putStringArrayListExtra("key_contentIds", arrayList);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void realTimeLogReport(String str, String str2, String str3, String[] strArr, ArrayList<RealTimeLogItem> arrayList, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppRealTimeLogReportServlet.class, miniAppCmdInterface, HttpGetAppInfoByLinkRequest.CMD_STRING);
        newIntent.putExtra("key_page", str);
        newIntent.putExtra(MiniAppRealTimeLogReportServlet.KEY_JSLIB_VERSION, str2);
        newIntent.putExtra("key_appid", str3);
        newIntent.putExtra(MiniAppRealTimeLogReportServlet.KEY_FILTER_MSG, strArr);
        newIntent.putParcelableArrayListExtra(MiniAppRealTimeLogReportServlet.KEY_LOG_ITEMS, arrayList);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void rejectFrequentlyRecommends(String str, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) RejectFrequentlyRecommendsServlet.class, miniAppCmdInterface, "rejectFrequentlyRecommends");
        newIntent.putExtra("key_appId", str);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void removeUserCloudStorage(String str, String[] strArr, MiniAppCmdInterface miniAppCmdInterface) {
        sendCloudRequest(str, strArr, miniAppCmdInterface, CloudStorageServlet.REMOVE_CLOUD_STORAGE);
    }

    public void reportLogFileUrl(COMM.StCommonExt stCommonExt, String str, String str2, long j3, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppReportLogFileServlet.class, miniAppCmdInterface, "reportLogFileUrl");
        newIntent.putExtra("key_app_id", str);
        newIntent.putExtra(MiniAppReportLogFileServlet.KEY_FILE_URL, str2);
        newIntent.putExtra(MiniAppReportLogFileServlet.KEY_FILE_SIZE, (int) j3);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void reportShare(COMM.StCommonExt stCommonExt, long j3, String str, int i3, int i16, int i17, int i18, String str2, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniReportShareServlet.class, miniAppCmdInterface, "reportLogFileUrl");
        newIntent.putExtra(MiniReportShareServlet.KEY_REPORT_TIME, j3);
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra(MiniReportShareServlet.KEY_APP_TYPE, i3);
        newIntent.putExtra(MiniReportShareServlet.KEY_SHARE_SCENE, i16);
        newIntent.putExtra(MiniReportShareServlet.KEY_SHARE_TYPE, i17);
        newIntent.putExtra(MiniReportShareServlet.KEY_DEST_TYPE, i18);
        newIntent.putExtra(MiniReportShareServlet.KEY_DEST_ID, str2);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void searchApp(COMM.StCommonExt stCommonExt, String str, MiniAppCmdInterface miniAppCmdInterface) {
        searchApp(stCommonExt, str, 1, miniAppCmdInterface);
    }

    public void sendArkMsg(COMM.StCommonExt stCommonExt, String str, String str2, String str3, String str4, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppSendArkMsgServlet.class, miniAppCmdInterface, "sendArkMsg");
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra("key_openid", str2);
        newIntent.putExtra(MiniAppSendArkMsgServlet.KEY_ARK_JSON, str3);
        newIntent.putExtra(MiniAppSendArkMsgServlet.KEY_API_NAME, str4);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void sendRequestByMsf(byte[] bArr, String str, MiniAppProxy.SenderListener senderListener) {
        long longValue;
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGeneralServlet.class, senderListener, "sendRequest");
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        if (!TextUtils.isEmpty(account)) {
            try {
                longValue = Long.valueOf(account).longValue();
            } catch (Exception unused) {
            }
            newIntent.putExtra("key_uin", longValue);
            newIntent.putExtra("key_request_data", bArr);
            newIntent.putExtra(KEY_CMD_STRING, str);
            BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
        }
        longValue = 0;
        newIntent.putExtra("key_uin", longValue);
        newIntent.putExtra("key_request_data", bArr);
        newIntent.putExtra(KEY_CMD_STRING, str);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void setAuth(COMM.StCommonExt stCommonExt, String str, INTERFACE$StUserAuthInfo iNTERFACE$StUserAuthInfo, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppSetAuthsServlet.class, miniAppCmdInterface, "setAuth");
        newIntent.putExtra("key_appid", str);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        if (iNTERFACE$StUserAuthInfo != null) {
            newIntent.putExtra(MiniAppSetAuthsServlet.KEY_AUTH_INFO, iNTERFACE$StUserAuthInfo.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void setAuths(COMM.StCommonExt stCommonExt, String str, ArrayList<INTERFACE$StUserAuthInfo> arrayList, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppSetAuthsServlet.class, miniAppCmdInterface, "setAuths");
        newIntent.putExtra("key_appid", str);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        if (arrayList != null) {
            newIntent.putExtra(MiniAppSetAuthsServlet.KEY_AUTH_LIST_INFO, arrayList);
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void setCMShowPetStatus(int i3, int i16, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) CMShowSetPetStatusServlet.class, miniAppCmdInterface, "setCMShowPetStatus");
        newIntent.putExtra(CMShowSetPetStatusServlet.EXTRA_PET_ID, i3);
        newIntent.putExtra(CMShowSetPetStatusServlet.EXTRA_PET_STATUS, i16);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void setGameBoxOptions(String str, boolean z16, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppSetGameBoxOptionsServlet.class, miniAppCmdInterface, MiniAppSetGameBoxOptionsServlet.CMD_STRING);
        newIntent.putExtra("appId", str);
        newIntent.putExtra(MiniAppSetGameBoxOptionsServlet.KEY_ALLOW_DISPLAY, z16);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void setPersonalizeInfo(String str, String str2, int i3, String str3, String str4, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) PersonalizeSetAvatarServlet.class, miniAppCmdInterface, QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_SETAVATAR);
        newIntent.putExtra("key_app_id", str);
        newIntent.putExtra(PersonalizeSetAvatarServlet.KEY_APP_UIN, str2);
        newIntent.putExtra(PersonalizeSetAvatarServlet.KEY_APP_SET_TYPE, i3);
        newIntent.putExtra(PersonalizeSetAvatarServlet.KEY_APP_ITEMID, str3);
        newIntent.putExtra(PersonalizeSetAvatarServlet.KEY_APP_BUSIINFO, str4);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void setUserAppLike(boolean z16, COMM.StCommonExt stCommonExt, String str, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppSetUserAppLikeServlet.class, miniAppCmdInterface, "userAppLike");
        newIntent.putExtra("key_mini_appid", str);
        newIntent.putExtra(MiniAppSetUserAppLikeServlet.KEY_DO_LIKE, z16 ? 1 : 0);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void setUserAppTop(String str, int i3, int i16, COMM.StCommonExt stCommonExt, MiniAppCmdInterface miniAppCmdInterface) {
        setUserAppTop(str, i3, i16, -1, 0, stCommonExt, miniAppCmdInterface);
    }

    public void setUserCloudStorage(String str, HashMap<String, String> hashMap, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) CloudStorageServlet.class, miniAppCmdInterface, "setUserCloudStorage");
        newIntent.putExtra("key_data", hashMap);
        newIntent.putExtra("app_id", str);
        newIntent.putExtra(CloudStorageServlet.REQUEST_TYPE, CloudStorageServlet.SET_CLOUD_STORAGE);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void setUserSwitch(COMM.StCommonExt stCommonExt, String str, int i3, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppSetUserSwitchServlet.class, miniAppCmdInterface, MiniAppGetSwitchListServlet.KEY_GET_SWITCH_LIST);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        newIntent.putExtra("key", str);
        newIntent.putExtra("value", i3);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void setWxAppInfo(Intent intent, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) SetWxAppInfoServlet.class, miniAppCmdInterface, SetWxAppInfoServlet.CMD_NAME);
        newIntent.putExtras(intent);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void setWxAppUrl(int i3, String str, String str2, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) SetWxAppUrlServlet.class, miniAppCmdInterface, SetWxAppUrlServlet.CMD_NAME);
        newIntent.putExtra(MiniAppAbstractServlet.KEY_CODE_TYPE, i3);
        newIntent.putExtra(MiniAppAbstractServlet.KEY_CODE, str);
        newIntent.putExtra("key_url", str2);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void transForRoomId(String str, String str2, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppTranRoomIdServlet.class, miniAppCmdInterface, "Trans4Roomid");
        newIntent.putExtra("key_app_id", str);
        newIntent.putExtra(MiniAppTranRoomIdServlet.KEY_GROUP_ID, str2);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public boolean updateBaseLib(String str, boolean z16, boolean z17, MiniAppCmdInterface miniAppCmdInterface) {
        QLog.i(TAG, 1, "[MiniEng] doUpdateBaseLib nocheck=" + z16 + ", force=" + z17);
        if (!z16 && !z17) {
            long j3 = StorageUtil.getPreference().getLong("baselib_min_update_time", 0L);
            if (QUA.getQUA3().equals(StorageUtil.getPreference().getString(ApkgConfigManager.KEY_BASELIB_UPDATE_QUA, "")) && System.currentTimeMillis() - j3 <= 0) {
                QLog.i(TAG, 1, "[MiniEng] updateBaseLib \u5728\u65f6\u95f4\u95f4\u9694\u5185\uff0c\u6682\u65f6\u4e0d\u66f4\u65b0");
                return false;
            }
        }
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetNewBaseLibServlet.class, miniAppCmdInterface, "updateBaseLib");
        try {
            newIntent.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
        newIntent.putExtra(MiniAppAbstractServlet.KEY_VERSION, str);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
        return true;
    }

    public boolean updateBaseLibForSDK(String str, boolean z16, boolean z17, MiniAppCmdInterface miniAppCmdInterface) {
        QLog.i(TAG, 1, "[MiniEng] doUpdateBaseLib nocheck=" + z16 + ", force=" + z17);
        if (!z16 && !z17) {
            long j3 = StorageUtil.getPreference().getLong("baselib_min_update_time", 0L);
            if (QUA.getQUA3().equals(StorageUtil.getPreference().getString(ApkgConfigManager.KEY_BASELIB_UPDATE_QUA, "")) && System.currentTimeMillis() - j3 <= 0) {
                QLog.i(TAG, 1, "[MiniEng] updateBaseLib \u5728\u65f6\u95f4\u95f4\u9694\u5185\uff0c\u6682\u65f6\u4e0d\u66f4\u65b0");
                return false;
            }
        }
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetNewBaseLibForSDKServlet.class, miniAppCmdInterface, "updateBaseLib");
        try {
            newIntent.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
        newIntent.putExtra(MiniAppAbstractServlet.KEY_VERSION, str);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
        return true;
    }

    public void updateBookshelfReadtime(String str, String str2, String str3, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) BookShelfUpdateServlet.class, miniAppCmdInterface, "UpdateBookShelfReadTime");
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra("key_category", str2);
        newIntent.putExtra(BookShelfUpdateServlet.KEY_CONTENT_ID, str3);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void updateUserSetting(COMM.StCommonExt stCommonExt, String str, INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppUpdateUserSettingServlet.class, miniAppCmdInterface, "updateUserSetting");
        newIntent.putExtra("key_appid", str);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        if (iNTERFACE$StUserSettingInfo != null) {
            newIntent.putExtra(MiniAppUpdateUserSettingServlet.KEY_SETTING_INFO, iNTERFACE$StUserSettingInfo.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void useUserApp(String str, int i3, int i16, String str2, String str3, COMM.StCommonExt stCommonExt, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppUseUserAppServlet.class, miniAppCmdInterface, "useUserApp");
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra("key_version_type", i3);
        newIntent.putExtra("key_source", i16);
        newIntent.putExtra("key_refer", str2);
        newIntent.putExtra("key_via", str3);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void verifyPlugin(String str, ArrayList<PluginInfo> arrayList, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppVerifyPluginServlet.class, miniAppCmdInterface, c1.NAME);
        newIntent.putExtra("key_app_id", str);
        newIntent.putParcelableArrayListExtra(MiniAppVerifyPluginServlet.KEY_PLUGIN_IDS, arrayList);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void createUpdatableMsg(String str, String str2, int i3, int i16, int i17, String str3, int i18, byte[] bArr, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) CreateUpdatableMsgServlet.class, miniAppCmdInterface, "createUpdatableMsg");
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra(CreateUpdatableMsgServlet.KEY_TEMPLATE_ID, str2);
        newIntent.putExtra("key_from", i3);
        newIntent.putExtra("key_scene", i16);
        newIntent.putExtra(CreateUpdatableMsgServlet.KEY_SUB_SCENE, i17);
        newIntent.putExtra("key_uin", str3);
        newIntent.putExtra(CreateUpdatableMsgServlet.KEY_SERVICE_TYPE, i18);
        newIntent.putExtra(CreateUpdatableMsgServlet.KEY_SIG, bArr);
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void delUserApp(String str, int i3, int i16, int i17, COMM.StCommonExt stCommonExt, int i18, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppDelUserAppServlet.class, miniAppCmdInterface, "delUserApp");
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra("key_version_type", i3);
        newIntent.putExtra(MiniAppDelUserAppServlet.KET_IS_RECOMMEND, i16);
        newIntent.putExtra(MiniAppDelUserAppServlet.KET_SOURCE_TYPE, i17);
        newIntent.putExtra(MiniAppDelUserAppServlet.KET_NOT_DELTOP, i18);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getAppInfoById(COMM.StCommonExt stCommonExt, String str, String str2, String str3, String str4, final MiniAppCmdInterface miniAppCmdInterface) {
        String loginMiniAppForbidToken = MiniAppSecurityUtil.getLoginMiniAppForbidToken(BaseApplicationImpl.getApplication(), MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication()));
        boolean z16 = MiniAppConfProcessor.f(QzoneConfig.SECONDARY_KEY_MINI_APP_USE_HTTPS_SEND_REQUEST, 0) == 0;
        if (!TextUtils.isEmpty(loginMiniAppForbidToken) && z16) {
            QLog.d(TAG, 1, "getAppInfoById, send request by https.");
            HttpCmdManager.g().getAppInfoById(stCommonExt, str, str2, str3, loginMiniAppForbidToken, str4, new HttpCmdResult() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.4
                @Override // com.tencent.mobileqq.mini.network.http.HttpCmdResult
                public void onCmdListener(boolean z17, JSONObject jSONObject) {
                    MiniAppCmdInterface miniAppCmdInterface2 = miniAppCmdInterface;
                    if (miniAppCmdInterface2 != null) {
                        miniAppCmdInterface2.onCmdListener(z17, jSONObject);
                    } else {
                        QLog.e(MiniAppCmdUtil.TAG, 1, "getAppInfoById, listener is null.");
                    }
                }
            });
            return;
        }
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetAppInfoByIdServlet.class, miniAppCmdInterface, "getAppInfoById");
        newIntent.putExtra("key_app_id", str);
        newIntent.putExtra("key_first_path", str2);
        newIntent.putExtra("key_env_version", str3);
        if (str4 != null) {
            newIntent.putExtra("key_from_app_id", str4);
        }
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getAppInfoByIdForSDK(COMM.StCommonExt stCommonExt, String str, String str2, String str3, String str4, final MiniAppCmdInterface miniAppCmdInterface) {
        String loginMiniAppForbidToken = MiniAppSecurityUtil.getLoginMiniAppForbidToken(BaseApplicationImpl.getApplication(), MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication()));
        boolean z16 = MiniAppConfProcessor.f(QzoneConfig.SECONDARY_KEY_MINI_APP_USE_HTTPS_SEND_REQUEST, 0) == 0;
        if (!TextUtils.isEmpty(loginMiniAppForbidToken) && z16) {
            QLog.d(TAG, 1, "getAppInfoByIdForSDK, send request by https.");
            HttpCmdManager.g().getAppInfoById(stCommonExt, str, str2, str3, loginMiniAppForbidToken, str4, new HttpCmdResult() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.6
                @Override // com.tencent.mobileqq.mini.network.http.HttpCmdResult
                public void onCmdListener(boolean z17, JSONObject jSONObject) {
                    try {
                        jSONObject.put("mini_app_info_data", MiniSdkLauncher.convert((com.tencent.mobileqq.mini.apkg.MiniAppInfo) jSONObject.opt("mini_app_info_data")));
                        miniAppCmdInterface.onCmdListener(z17, jSONObject);
                    } catch (Exception e16) {
                        QLog.e(MiniAppCmdUtil.TAG, 1, "getAppInfoByIdForSDK exception: " + Log.getStackTraceString(e16));
                    }
                }
            });
            return;
        }
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetAppInfoByIdForSDKServlet.class, miniAppCmdInterface, "getAppInfoById");
        newIntent.putExtra("key_app_id", str);
        newIntent.putExtra("key_first_path", str2);
        newIntent.putExtra("key_env_version", str3);
        if (str4 != null) {
            newIntent.putExtra("key_from_app_id", str4);
        }
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime.isLogin() && runtime.isRunning()) {
            runtime.startServlet(newIntent);
            return;
        }
        String str5 = TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getAppInfoByIdForSDK fail, appRuntime state error:");
        sb5.append(!runtime.isLogin());
        sb5.append(",");
        sb5.append(!runtime.isLogin());
        QLog.e(str5, 1, sb5.toString());
        miniAppCmdInterface.onCmdListener(false, new JSONObject());
    }

    public void searchApp(COMM.StCommonExt stCommonExt, String str, int i3, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppSearchAppServlet.class, miniAppCmdInterface, "SearchApp");
        if (stCommonExt != null) {
            newIntent.putExtra(MiniAppSearchAppServlet.KEY_EXT_INFO, stCommonExt.toByteArray());
        }
        newIntent.putExtra(MiniAppSearchAppServlet.KEY_WORD, str);
        newIntent.putExtra(MiniAppSearchAppServlet.KEY_FROM, i3);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void setUserAppTop(String str, int i3, int i16, int i17, int i18, COMM.StCommonExt stCommonExt, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppSetUserAppTopServlet.class, miniAppCmdInterface, "userAppTop");
        newIntent.putExtra("key_appid", str);
        newIntent.putExtra(MiniAppSetUserAppTopServlet.KEY_TOP_TYPE, i3);
        newIntent.putExtra("key_version_type", i16);
        newIntent.putExtra(MiniAppSetUserAppTopServlet.KEY_OLD_INDEX, i17);
        newIntent.putExtra(MiniAppSetUserAppTopServlet.KEY_NEW_INDEX, i18);
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        newIntent.putExtra(MiniAppSetUserAppTopServlet.KEY_FROM_NEW_DOWNLOAD, MiniAppConfProcessor.m() ? 1 : 0);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public void getExtConfigDetail(byte[] bArr, ArrayList<ExtConfigInfo> arrayList, MiniAppCmdInterface miniAppCmdInterface) {
        ExtConfigInfo extConfigInfo;
        if (arrayList == null || arrayList.isEmpty() || (extConfigInfo = arrayList.get(0)) == null || extConfigInfo.configVersion == null) {
            return;
        }
        String string = BaseApplicationImpl.getApplication().getSharedPreferences("MiniAppExtConfigDetail", 4).getString("MiniAppExtConfigDetail", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                String optString = new JSONObject(string).optString("configVersion");
                if (!TextUtils.isEmpty(optString)) {
                    if (!shouldUpdateExtConfig(optString, extConfigInfo.configVersion)) {
                        return;
                    }
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getExtConfigDetail parse json error", e16);
            }
        }
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniAppGetExtConfigDetailServlet.class, miniAppCmdInterface, "getExtConfigDetail");
        if (bArr != null) {
            newIntent.putExtra("key_common_ext", bArr);
        }
        newIntent.putParcelableArrayListExtra(MiniAppGetExtConfigDetailServlet.KEY_EXT_CONFIG_INFO, arrayList);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class NewIntent extends mqq.app.NewIntent {
        public NewIntent(Context context, Class<? extends Servlet> cls, MiniAppCmdInterface miniAppCmdInterface, String str) {
            super(context, cls);
            putExtra(MiniAppCmdUtil.KEY_INDEX, MiniAppCmdUtil.this.getCurrentListenerIndex(miniAppCmdInterface, str));
            setObserver(MiniAppCmdUtil.this.cmdObserver);
        }

        public NewIntent(Context context, Class<? extends Servlet> cls, MiniAppProxy.SenderListener senderListener, String str) {
            super(context, cls);
            putExtra(MiniAppCmdUtil.KEY_INDEX, MiniAppCmdUtil.this.getCurrentListenerIndex(senderListener, str));
            setObserver(MiniAppCmdUtil.this.cmdObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentListenerIndex(MiniAppProxy.SenderListener senderListener, String str) {
        int incrementAndGet = index.incrementAndGet();
        ConcurrentHashMap<Integer, MiniAppProxy.SenderListener> concurrentHashMap = this.senderListenerMap;
        if (concurrentHashMap != null && !concurrentHashMap.containsKey(Integer.valueOf(incrementAndGet)) && senderListener != null) {
            this.senderListenerMap.put(Integer.valueOf(incrementAndGet), senderListener);
        } else {
            QLog.e(TAG, 1, str + " index error");
        }
        return incrementAndGet;
    }

    public void getRewardedVideoADInfo(MiniAppAd$StGetAdReq miniAppAd$StGetAdReq, MiniAppCmdInterface miniAppCmdInterface) {
        if (miniAppAd$StGetAdReq == null) {
            return;
        }
        boolean z16 = StudyModeManager.t() || SimpleUIUtil.isNowElderMode();
        QLog.e(TAG, 1, "isSpecialModule= " + z16);
        if (z16) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("retCode", 1010);
                jSONObject.put("errMsg", "\u7279\u6b8a\u6a21\u5f0f\u4e0b\u4e0d\u663e\u793a\u5e7f\u544a");
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "put json error " + e16);
            }
            miniAppCmdInterface.onCmdListener(false, jSONObject);
            return;
        }
        COMM.StCommonExt stCommonExt = miniAppAd$StGetAdReq.extInfo.get();
        MiniAppAd$UserInfo miniAppAd$UserInfo = miniAppAd$StGetAdReq.user_info.get();
        MiniAppAd$PositionInfo miniAppAd$PositionInfo = miniAppAd$StGetAdReq.position_info.get() != null ? miniAppAd$StGetAdReq.position_info.get().get(0) : null;
        MiniAppAd$DeviceInfo miniAppAd$DeviceInfo = miniAppAd$StGetAdReq.device_info.get();
        MiniAppAd$ContextInfo miniAppAd$ContextInfo = miniAppAd$StGetAdReq.context_info.get();
        MiniAppAd$DebugInfo miniAppAd$DebugInfo = miniAppAd$StGetAdReq.debug_info.get();
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), (Class<? extends Servlet>) MiniRewardedVideoAdServlet.class, miniAppCmdInterface, "getRewardedVideoADInfo");
        newIntent.putExtra(MiniRewardedVideoAdServlet.KEY_GDT_COOKIE, miniAppAd$StGetAdReq.gdt_cookie.get());
        newIntent.putExtra(MiniRewardedVideoAdServlet.KEY_SUPPORT_HTTPS, true);
        newIntent.putExtra(MiniRewardedVideoAdServlet.KEY_BUSI_COOKIE, miniAppAd$StGetAdReq.busi_cookie.get());
        newIntent.putExtra("key_appid", miniAppAd$StGetAdReq.appid.get());
        newIntent.putExtra(MiniRewardedVideoAdServlet.KEY_AD_TYPE, miniAppAd$StGetAdReq.ad_type.get());
        if (stCommonExt != null) {
            newIntent.putExtra("key_ext", stCommonExt.toByteArray());
        }
        if (miniAppAd$UserInfo != null) {
            newIntent.putExtra(MiniRewardedVideoAdServlet.KEY_USER_INFO, miniAppAd$UserInfo.toByteArray());
        }
        if (miniAppAd$PositionInfo != null) {
            newIntent.putExtra(MiniRewardedVideoAdServlet.KEY_POSITION_INFO, miniAppAd$PositionInfo.toByteArray());
        }
        if (miniAppAd$DeviceInfo != null) {
            newIntent.putExtra(MiniRewardedVideoAdServlet.KEY_DEVICE_INFO, miniAppAd$DeviceInfo.toByteArray());
        }
        if (miniAppAd$ContextInfo != null) {
            newIntent.putExtra(MiniRewardedVideoAdServlet.KEY_CONTEXT_INFO, miniAppAd$ContextInfo.toByteArray());
        }
        if (miniAppAd$DebugInfo != null) {
            newIntent.putExtra(MiniRewardedVideoAdServlet.KEY_DEBUG_INFO, miniAppAd$DebugInfo.toByteArray());
        }
        newIntent.setObserver(this.cmdObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getGuildJoinUrl$5(boolean z16, JSONObject jSONObject) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getPrivacyInfo$7(boolean z16, JSONObject jSONObject) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getRoleGroupInfo$9(boolean z16, JSONObject jSONObject) {
    }
}

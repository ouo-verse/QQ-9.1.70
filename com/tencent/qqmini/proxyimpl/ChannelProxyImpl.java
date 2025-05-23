package com.tencent.qqmini.proxyimpl;

import NS_COMM.COMM;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StInteractiveTemplate;
import NS_MINI_INTERFACE.INTERFACE$StGetAuthListRsp;
import NS_MINI_INTERFACE.INTERFACE$StJudgeTimingReq;
import NS_MINI_INTERFACE.INTERFACE$StJudgeTimingRsp;
import NS_MINI_INTERFACE.INTERFACE$StReportExecuteReq;
import NS_MINI_INTERFACE.INTERFACE$StReportExecuteRsp;
import NS_MINI_INTERFACE.INTERFACE$StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE$StUserAuthInfo;
import NS_MINI_INTERFACE.INTERFACE$StUserSettingInfo;
import NS_MINI_SHARE.MiniProgramShare$StAdaptShareInfoReq;
import Wallet.FocusMpIdReq;
import Wallet.FocusMpIdRsp;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.util.Log;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityLandscape;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ReportHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.mini.appbrand.ui.MiniAppWebviewFragment;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment;
import com.tencent.mobileqq.mini.mainpage.PhoneNumberManagementFragment;
import com.tencent.mobileqq.mini.manager.MiniTianShuManager;
import com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment;
import com.tencent.mobileqq.mini.report.MiniGetPhoneNumberReporter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.server.MiniAppSSOReqCallback;
import com.tencent.mobileqq.mini.server.MiniAppSSORequestClient;
import com.tencent.mobileqq.mini.server.MiniAppSSOResponse;
import com.tencent.mobileqq.mini.server.request.GameSubscribeRequest;
import com.tencent.mobileqq.mini.server.request.GetLatestUserKeyRequest;
import com.tencent.mobileqq.mini.server.request.JoinGroupByTagsRequest;
import com.tencent.mobileqq.mini.server.request.MiniGameCloseFloatBubbleRequest;
import com.tencent.mobileqq.mini.server.request.MiniGameGetFloatBubbleRequest;
import com.tencent.mobileqq.mini.server.request.QueryMiniGameUserAgreementRequest;
import com.tencent.mobileqq.mini.server.request.SignMiniGameUserAgreementRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeObserver;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.mini.ui.MiniAIOEntryView;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil;
import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.BinaryBitmap;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.MultiFormatReader;
import com.tencent.mobileqq.mini.zxing.PlanarYUVLuminanceSource;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.common.HybridBinarizer;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo;
import com.tencent.mobileqq.minigame.report.MiniGameBeaconReport;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minigame.ui.MiniGameJumperFragment;
import com.tencent.mobileqq.minigame.ui.RedpacketTranslucentBrowserFragment;
import com.tencent.mobileqq.minigame.utils.KuiklyPreloadUtil;
import com.tencent.mobileqq.minigame.va.MiniGameVAMMKVKEY;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.troop.qrcode.api.impl.TroopQRCodeShareApiImpl;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.oskplayer.OskPlayerConfig;
import com.tencent.oskplayer.OskPlayerCore;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.cache.DefaultCacheKeyGenerator;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.util.DefaultLogger;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.auth.SubscribeMessage;
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
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PluginInfo;
import com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem;
import com.tencent.qqmini.sdk.launcher.model.TouchInfo;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.qqmini.sdk.manager.UserAgreementData;
import com.tencent.qqperf.reporter.flow.TrafficFlowReporter;
import com.tencent.qqperf.reporter.flow.b;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.trpcprotocol.minigame.float_bubble_svr.float_bubble_svr.MiniGameFloatBubbleSvrPB$BubbleConfig;
import com.tencent.trpcprotocol.minigame.float_bubble_svr.float_bubble_svr.MiniGameFloatBubbleSvrPB$FloatBubbleInfo;
import com.tencent.trpcprotocol.minigame.float_bubble_svr.float_bubble_svr.MiniGameFloatBubbleSvrPB$GetFloatBubbleRsp;
import com.tencent.trpcprotocol.minigame.float_bubble_svr.float_bubble_svr.MiniGameFloatBubbleSvrPB$TaskInfo;
import com.tencent.trpcprotocol.minigame.sdk_qgroup_svr.sdk_qgroup_svr.JoinGroupRsp;
import com.tencent.trpcprotocol.minigame.terms_of_service.terms_of_service.QueryToSRsp;
import com.tencent.trpcprotocol.minigame.terms_of_service.terms_of_service.ToSLink;
import com.tencent.trpcprotocol.minigame.user_encryption_svr.user_encryption_svr.userEncryptionSvr$GetUserEncryptKeyRsp;
import com.tencent.trpcprotocol.minigame.user_encryption_svr.user_encryption_svr.userEncryptionSvr$KeyInfo;
import com.tencent.ttpic.util.GsonUtils;
import com.tencent.util.URLUtil;
import common.config.service.QzoneConfig;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QZoneShareManager;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0x87a$RspBody;
import tencent.im.oidb.oidb_0x87c$RspBody;

/* loaded from: classes34.dex */
public class ChannelProxyImpl implements ChannelProxy {

    /* renamed from: c, reason: collision with root package name */
    public static ArrayList<TouchInfo> f347287c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public static volatile boolean f347288d = false;

    /* renamed from: e, reason: collision with root package name */
    private static final String f347289e = QzoneConfig.getInstance().getConfig("QZoneSetting", "MiniProgramVideoContentType", "application/octet-stream; charset=utf-8");

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f347290f;

    /* renamed from: a, reason: collision with root package name */
    private volatile FFmpeg f347291a;

    /* renamed from: b, reason: collision with root package name */
    MultiFormatReader f347292b;

    /* loaded from: classes34.dex */
    class a implements SDKInitListener {
        a() {
        }

        @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
        public void onSDKInited(boolean z16) {
            if (!z16) {
                QLog.e("ChannelProxyImpl", 1, "initSDKAsync failed!");
            } else {
                QLog.d("ChannelProxyImpl", 1, "initSDKAsync succeed!");
            }
        }
    }

    /* loaded from: classes34.dex */
    class b implements IMediaPlayerUtil {
        b() {
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayerUtil
        public int getContentFlag(String str) {
            return VideoManager.getInstance().probeContentFlag(str);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayerUtil
        public String getUrl(String str) {
            return OskPlayerCore.getInstance().getUrl(str);
        }
    }

    /* loaded from: classes34.dex */
    class c implements FFmpegExecuteResponseCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ChannelProxy.ICommandListenr f347301a;

        c(ChannelProxy.ICommandListenr iCommandListenr) {
            this.f347301a = iCommandListenr;
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onFailure(String str) {
            ChannelProxy.ICommandListenr iCommandListenr = this.f347301a;
            if (iCommandListenr != null) {
                iCommandListenr.onFailure(str);
            }
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onFinish(boolean z16) {
            ChannelProxy.ICommandListenr iCommandListenr = this.f347301a;
            if (iCommandListenr != null) {
                iCommandListenr.onFinish(z16);
            }
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onProgress(String str) {
            ChannelProxy.ICommandListenr iCommandListenr = this.f347301a;
            if (iCommandListenr != null) {
                iCommandListenr.onProgress(str);
            }
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onStart() {
            ChannelProxy.ICommandListenr iCommandListenr = this.f347301a;
            if (iCommandListenr != null) {
                iCommandListenr.onStart();
            }
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onSuccess(String str) {
            ChannelProxy.ICommandListenr iCommandListenr = this.f347301a;
            if (iCommandListenr != null) {
                iCommandListenr.onSuccess(str);
            }
        }
    }

    /* loaded from: classes34.dex */
    class d implements SDKInitListener {
        d() {
        }

        @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
        public void onSDKInited(boolean z16) {
            if (!z16) {
                QLog.e("ChannelProxyImpl", 1, "initSDKAsync failed!");
            } else {
                QLog.d("ChannelProxyImpl", 1, "initSDKAsync succeed!");
            }
        }
    }

    /* loaded from: classes34.dex */
    class f implements SDKInitListener {
        f() {
        }

        @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
        public void onSDKInited(boolean z16) {
            if (!z16) {
                QLog.e("ChannelProxyImpl", 1, "initSDKAsync failed!");
            } else {
                QLog.d("ChannelProxyImpl", 1, "initSDKAsync succeed!");
            }
        }
    }

    /* loaded from: classes34.dex */
    class g implements MiniAppCmdInterface {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ChannelProxy.AuthListResult f347309a;

        g(ChannelProxy.AuthListResult authListResult) {
            this.f347309a = authListResult;
        }

        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
        public void onCmdListener(boolean z16, JSONObject jSONObject) {
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
                        Iterator<INTERFACE$StUserSettingInfo> it = iNTERFACE$StGetAuthListRsp.settings.get().iterator();
                        while (it.hasNext()) {
                            arrayList2.add(ChannelProxyImpl.this.q(it.next()));
                        }
                        ChannelProxy.AuthListResult authListResult = this.f347309a;
                        if (authListResult != null) {
                            authListResult.onReceiveResult(true, arrayList, arrayList2);
                            return;
                        }
                        return;
                    } catch (InvalidProtocolBufferMicroException e16) {
                        QLog.e("ChannelProxyImpl", 1, "getSetting, InvalidProtocolBufferMicroException:" + e16);
                        e16.printStackTrace();
                    }
                }
            }
            ChannelProxy.AuthListResult authListResult2 = this.f347309a;
            if (authListResult2 != null) {
                authListResult2.onReceiveResult(false, arrayList, arrayList2);
            }
        }
    }

    /* loaded from: classes34.dex */
    class h implements MiniAppSSOCmdHelper.MiniAppCmdCallback<INTERFACE$StJudgeTimingRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347311a;

        h(AsyncResult asyncResult) {
            this.f347311a = asyncResult;
        }

        @Override // com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper.MiniAppCmdCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceived(boolean z16, INTERFACE$StJudgeTimingRsp iNTERFACE$StJudgeTimingRsp) {
            if (this.f347311a != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("response", iNTERFACE$StJudgeTimingRsp);
                } catch (Throwable th5) {
                    QLog.e("ChannelProxyImpl", 1, "tianshuRequestAdv", th5);
                }
                this.f347311a.onReceiveResult(z16, jSONObject);
            }
        }
    }

    /* loaded from: classes34.dex */
    class i implements MiniAppSSOCmdHelper.MiniAppCmdCallback<INTERFACE$StReportExecuteRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347313a;

        i(AsyncResult asyncResult) {
            this.f347313a = asyncResult;
        }

        @Override // com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper.MiniAppCmdCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceived(boolean z16, INTERFACE$StReportExecuteRsp iNTERFACE$StReportExecuteRsp) {
            if (this.f347313a != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("response", iNTERFACE$StReportExecuteRsp);
                } catch (Throwable th5) {
                    QLog.e("ChannelProxyImpl", 1, "tianshuRequestAdv", th5);
                }
                this.f347313a.onReceiveResult(z16, jSONObject);
            }
        }
    }

    /* loaded from: classes34.dex */
    class j extends MiniAppSendSmsCodeObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347315d;

        j(AsyncResult asyncResult) {
            this.f347315d = asyncResult;
        }

        @Override // com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeObserver
        public void onFailedResponse(String str, int i3, String str2) {
            super.onFailedResponse(str, i3, str2);
            QLog.e("ChannelProxyImpl", 1, "send onFailedResponse cmd : " + str + ", code : " + i3 + "; message : " + str2);
            try {
                if (this.f347315d != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("message", str2);
                    jSONObject.put("code", i3);
                    jSONObject.put("cmd", str);
                    this.f347315d.onReceiveResult(false, jSONObject);
                }
            } catch (Throwable th5) {
                QLog.e("ChannelProxyImpl", 1, "onFailedResponse error,", th5);
            }
        }

        @Override // com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeObserver
        public void sendSmsCodeSuccess(oidb_0x87a$RspBody oidb_0x87a_rspbody) {
            super.sendSmsCodeSuccess(oidb_0x87a_rspbody);
            QLog.d("ChannelProxyImpl", 1, "send success");
            try {
                if (oidb_0x87a_rspbody != null) {
                    int i3 = oidb_0x87a_rspbody.uint32_resend_interval.get();
                    if (this.f347315d != null) {
                        JSONObject jSONObject = new JSONObject();
                        if (i3 > 0) {
                            jSONObject.put("intervalTime", i3);
                        }
                        this.f347315d.onReceiveResult(true, jSONObject);
                        return;
                    }
                    return;
                }
                if (this.f347315d != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("message", "\u8bf7\u6c42\u56de\u5305\u5f02\u5e38");
                    this.f347315d.onReceiveResult(false, jSONObject2);
                }
            } catch (Throwable th5) {
                QLog.e("ChannelProxyImpl", 1, "sendSmsCodeSuccess error,", th5);
            }
        }

        @Override // com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeObserver
        public void verifySmsCodeSuccess(oidb_0x87c$RspBody oidb_0x87c_rspbody) {
            super.verifySmsCodeSuccess(oidb_0x87c_rspbody);
        }
    }

    /* loaded from: classes34.dex */
    class k extends MiniAppSendSmsCodeObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347317d;

        k(AsyncResult asyncResult) {
            this.f347317d = asyncResult;
        }

        @Override // com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeObserver
        public void onFailedResponse(String str, int i3, String str2) {
            super.onFailedResponse(str, i3, str2);
            QLog.e("ChannelProxyImpl", 1, "verify onFailedResponse cmd : " + str + ", code : " + i3 + "; message : " + str2);
            try {
                if (this.f347317d != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("message", str2);
                    jSONObject.put("code", i3);
                    jSONObject.put("cmd", str);
                    this.f347317d.onReceiveResult(false, jSONObject);
                }
            } catch (Throwable th5) {
                QLog.e("ChannelProxyImpl", 1, "onFailedResponse error,", th5);
            }
        }

        @Override // com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeObserver
        public void verifySmsCodeSuccess(oidb_0x87c$RspBody oidb_0x87c_rspbody) {
            super.verifySmsCodeSuccess(oidb_0x87c_rspbody);
            QLog.d("ChannelProxyImpl", 1, "verify success");
            try {
                if (this.f347317d != null) {
                    this.f347317d.onReceiveResult(true, new JSONObject());
                }
            } catch (Throwable th5) {
                QLog.e("ChannelProxyImpl", 1, "onFailedResponse error,", th5);
            }
        }
    }

    /* loaded from: classes34.dex */
    class l implements TianShuGetAdvCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347319d;

        l(AsyncResult asyncResult) {
            this.f347319d = asyncResult;
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
            if (this.f347319d != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("response", getAdsRsp);
                } catch (Throwable th5) {
                    QLog.e("ChannelProxyImpl", 1, "tianshuRequestAdv", th5);
                }
                this.f347319d.onReceiveResult(z16, jSONObject);
            }
        }
    }

    /* loaded from: classes34.dex */
    class n implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347324d;

        n(AsyncResult asyncResult) {
            this.f347324d = asyncResult;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            FocusMpIdRsp focusMpIdRsp = (FocusMpIdRsp) bundle.getSerializable("rsp");
            if (focusMpIdRsp != null && focusMpIdRsp.err_code == 0) {
                this.f347324d.onReceiveResult(true, null);
            } else {
                this.f347324d.onReceiveResult(false, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class o implements MiniAppCmdInterface {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347326a;

        o(AsyncResult asyncResult) {
            this.f347326a = asyncResult;
        }

        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
        public void onCmdListener(boolean z16, JSONObject jSONObject) {
            AsyncResult asyncResult = this.f347326a;
            if (asyncResult != null) {
                asyncResult.onReceiveResult(z16, jSONObject);
            }
        }
    }

    static {
        f347290f = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_MEDIA_USE_SUPER_PLAYER, 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(AsyncResult asyncResult, MiniAppSSOResponse miniAppSSOResponse) {
        JSONObject jSONObject = new JSONObject();
        if (miniAppSSOResponse == null) {
            asyncResult.onReceiveResult(false, jSONObject);
            return;
        }
        try {
            jSONObject.put("retCode", miniAppSSOResponse.getRetCode());
            jSONObject.put("errMsg", miniAppSSOResponse.getErrMsg());
            asyncResult.onReceiveResult(miniAppSSOResponse.getRetCode() == 0, jSONObject);
        } catch (JSONException e16) {
            QMLog.e("ChannelProxyImpl", "SignToSRsp: json exception:", e16);
            asyncResult.onReceiveResult(false, jSONObject);
        }
    }

    private TianShuReportData D(TianShuAccess.AdItem adItem, String str, int i3) {
        int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mTraceId = String.valueOf(com.tencent.open.adapter.a.f().l()) + util.base64_pad_url + seconds;
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mItemId = String.valueOf(adItem.iAdId.get());
        tianShuReportData.mItemType = str;
        tianShuReportData.mOperTime = seconds;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = "tianshu.81";
        tianShuReportData.mModuleId = "";
        return tianShuReportData;
    }

    private static MiniAppCmdInterface m(AsyncResult asyncResult) {
        return new o(asyncResult);
    }

    private IMediaPlayer n() {
        if (!PlayerConfig.hasInit()) {
            Context context = AppLoaderFactory.g().getContext();
            if (context != null) {
                PlayerConfig.init(context);
                PlayerConfig.g().setLogger(new v());
            } else {
                throw new RuntimeException("BaseApplicationImpl ctx is null");
            }
        }
        if (!VideoManager.hasInit()) {
            VideoManager.init(AppLoaderFactory.g().getContext());
        }
        r(AppLoaderFactory.g().getContext());
        return new ac();
    }

    private String o(String str) {
        return MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin() + "_" + str + "_" + MiniGameVAMMKVKEY.MINI_GAME_USER_AGREEMENT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UserSettingInfo q(INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo) {
        UserSettingInfo userSettingInfo = new UserSettingInfo();
        userSettingInfo.settingItem = iNTERFACE$StUserSettingInfo.settingItem.get();
        userSettingInfo.authState = iNTERFACE$StUserSettingInfo.authState.get();
        userSettingInfo.desc = iNTERFACE$StUserSettingInfo.desc.get();
        List<INTERFACE$StSubscribeMessage> list = iNTERFACE$StUserSettingInfo.subItems.get();
        if (list != null && list.size() > 0) {
            userSettingInfo.subItems = new ArrayList();
            for (INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage : list) {
                SubscribeMessage subscribeMessage = new SubscribeMessage();
                subscribeMessage.authState = iNTERFACE$StSubscribeMessage.authState.get();
                subscribeMessage.templateId = iNTERFACE$StSubscribeMessage.templateId.get();
                userSettingInfo.subItems.add(subscribeMessage);
            }
        }
        return userSettingInfo;
    }

    public static void r(Context context) {
        if (f347288d) {
            return;
        }
        OskPlayerConfig oskPlayerConfig = new OskPlayerConfig();
        oskPlayerConfig.setEnableHLSCache(true);
        oskPlayerConfig.setDebugVersion(true);
        oskPlayerConfig.setLogger(new DefaultLogger());
        oskPlayerConfig.setCacheKeyGenerator(new DefaultCacheKeyGenerator());
        OskPlayerCore.init(context.getApplicationContext(), oskPlayerConfig);
        List<String> contentTypeList = PlayerConfig.g().getContentTypeList();
        if (contentTypeList != null) {
            try {
                contentTypeList.addAll(Arrays.asList(f347289e.split("|")));
                PlayerConfig.g().setContentTypeList(contentTypeList);
            } catch (Exception e16) {
                QLog.e("ChannelProxyImpl", 1, "initOskOnce contentTypeList.addAll oskPlayerContentTypeStrList get an err!!:" + e16);
            }
        } else {
            QLog.e("ChannelProxyImpl", 1, "getContentTypeList null");
        }
        f347288d = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(AsyncResult asyncResult, MiniAppSSOResponse miniAppSSOResponse) {
        JSONObject jSONObject = new JSONObject();
        if (miniAppSSOResponse == null) {
            asyncResult.onReceiveResult(false, jSONObject);
            return;
        }
        try {
            jSONObject.put("retCode", miniAppSSOResponse.getRetCode());
            jSONObject.put("errMsg", miniAppSSOResponse.getErrMsg());
            asyncResult.onReceiveResult(miniAppSSOResponse.getRetCode() == 0, jSONObject);
        } catch (Exception e16) {
            QMLog.e("ChannelProxyImpl", "closeFloatBubble exception:", e16);
            asyncResult.onReceiveResult(false, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(AsyncResult asyncResult, MiniAppSSOResponse miniAppSSOResponse) {
        JSONObject jSONObject = new JSONObject();
        if (miniAppSSOResponse == null) {
            asyncResult.onReceiveResult(false, jSONObject);
            return;
        }
        try {
            jSONObject.put("retCode", miniAppSSOResponse.getRetCode());
            jSONObject.put("errMsg", miniAppSSOResponse.getErrMsg());
            if (miniAppSSOResponse.isDataValid()) {
                MiniGameFloatBubbleSvrPB$GetFloatBubbleRsp miniGameFloatBubbleSvrPB$GetFloatBubbleRsp = new MiniGameFloatBubbleSvrPB$GetFloatBubbleRsp();
                miniGameFloatBubbleSvrPB$GetFloatBubbleRsp.mergeFrom(miniAppSSOResponse.getData());
                MiniGameFloatBubbleSvrPB$FloatBubbleInfo miniGameFloatBubbleSvrPB$FloatBubbleInfo = miniGameFloatBubbleSvrPB$GetFloatBubbleRsp.bubble_info.get();
                jSONObject.put(AppConstants.Key.COLUMN_IS_VALID, miniGameFloatBubbleSvrPB$FloatBubbleInfo.is_valid.get());
                jSONObject.put(WidgetCacheConstellationData.INTERVAL, miniGameFloatBubbleSvrPB$GetFloatBubbleRsp.interval.get());
                MiniGameFloatBubbleSvrPB$BubbleConfig miniGameFloatBubbleSvrPB$BubbleConfig = miniGameFloatBubbleSvrPB$FloatBubbleInfo.bubble_config.get();
                jSONObject.put("bubbleType", miniGameFloatBubbleSvrPB$BubbleConfig.bubble_type.get());
                jSONObject.put("bigBubbleTitle", miniGameFloatBubbleSvrPB$BubbleConfig.big_bubble_title.get());
                jSONObject.put("bigBubbleSubTitle", miniGameFloatBubbleSvrPB$BubbleConfig.big_bubble_subtitle.get());
                jSONObject.put("smallBubbleTitle", miniGameFloatBubbleSvrPB$BubbleConfig.small_bubble_title.get());
                jSONObject.put("bubbleIcon", miniGameFloatBubbleSvrPB$BubbleConfig.icon.get());
                jSONObject.put("bubbleClickSchema", miniGameFloatBubbleSvrPB$BubbleConfig.schema.get());
                jSONObject.put("closePopupText", miniGameFloatBubbleSvrPB$BubbleConfig.close_popup_text.get());
                MiniGameFloatBubbleSvrPB$TaskInfo miniGameFloatBubbleSvrPB$TaskInfo = miniGameFloatBubbleSvrPB$FloatBubbleInfo.task_info.get();
                jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, miniGameFloatBubbleSvrPB$TaskInfo.task_id.get());
                jSONObject.put("taskType", miniGameFloatBubbleSvrPB$TaskInfo.task_type.get());
                jSONObject.put("isTaskFinish", miniGameFloatBubbleSvrPB$TaskInfo.is_finished.get());
                jSONObject.put("taskProgress", miniGameFloatBubbleSvrPB$TaskInfo.progress.get());
                QLog.d("ChannelProxyImpl", 1, "getFloatBubble data =", jSONObject);
                asyncResult.onReceiveResult(true, jSONObject);
                if (miniGameFloatBubbleSvrPB$FloatBubbleInfo.is_valid.get()) {
                    KuiklyPreloadUtil.preloadAsync(miniGameFloatBubbleSvrPB$BubbleConfig.schema.get());
                }
            } else {
                asyncResult.onReceiveResult(false, jSONObject);
                QLog.e("ChannelProxyImpl", 1, "getFloatBubble data invalid retCode=", Integer.valueOf(miniAppSSOResponse.getRetCode()));
            }
        } catch (Exception e16) {
            asyncResult.onReceiveResult(false, jSONObject);
            QLog.e("ChannelProxyImpl", 1, "getFloatBubble exception:", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(AsyncResult asyncResult, MiniAppSSOResponse miniAppSSOResponse) {
        JSONObject jSONObject = new JSONObject();
        if (miniAppSSOResponse == null) {
            asyncResult.onReceiveResult(false, jSONObject);
            return;
        }
        try {
            jSONObject.put("retCode", miniAppSSOResponse.getRetCode());
            jSONObject.put("errMsg", miniAppSSOResponse.getErrMsg());
            if (miniAppSSOResponse.isDataValid()) {
                userEncryptionSvr$GetUserEncryptKeyRsp userencryptionsvr_getuserencryptkeyrsp = new userEncryptionSvr$GetUserEncryptKeyRsp();
                userencryptionsvr_getuserencryptkeyrsp.mergeFrom(miniAppSSOResponse.getData());
                JSONObject jSONObject2 = new JSONObject();
                List<userEncryptionSvr$KeyInfo> list = userencryptionsvr_getuserencryptkeyrsp.key_info_list.get();
                if (list != null && list.size() > 0) {
                    userEncryptionSvr$KeyInfo userencryptionsvr_keyinfo = list.get(0);
                    jSONObject2.put("iv", userencryptionsvr_keyinfo.f381589iv.get());
                    jSONObject2.put("encryptKey", userencryptionsvr_keyinfo.encrypt_key.get());
                    jSONObject2.put("expireTime", userencryptionsvr_keyinfo.expire_in.get());
                    jSONObject2.put("version", userencryptionsvr_keyinfo.version.get());
                    asyncResult.onReceiveResult(true, jSONObject2);
                } else {
                    asyncResult.onReceiveResult(false, null);
                }
            } else {
                asyncResult.onReceiveResult(false, null);
                QLog.e("ChannelProxyImpl", 1, "getLatestUserKey data invalid!");
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            asyncResult.onReceiveResult(false, null);
            QLog.e("ChannelProxyImpl", 1, "getLatestUserKey err", e16);
        } catch (JSONException e17) {
            asyncResult.onReceiveResult(false, null);
            QLog.e("ChannelProxyImpl", 1, "getLatestUserKey Json err", e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(AsyncResult asyncResult, MiniAppSSOResponse miniAppSSOResponse) {
        JSONObject jSONObject = new JSONObject();
        if (miniAppSSOResponse == null) {
            asyncResult.onReceiveResult(false, jSONObject);
            return;
        }
        try {
            jSONObject.put("retCode", miniAppSSOResponse.getRetCode());
            jSONObject.put("errMsg", miniAppSSOResponse.getErrMsg());
            if (miniAppSSOResponse.isDataValid()) {
                try {
                    JoinGroupRsp joinGroupRsp = new JoinGroupRsp();
                    joinGroupRsp.mergeFrom(miniAppSSOResponse.getData());
                    jSONObject.put("groupList", joinGroupRsp.group_list.get());
                } catch (InvalidProtocolBufferMicroException e16) {
                    QMLog.e("ChannelProxyImpl", "joinGroupByTags: parse pb failed:", e16);
                }
            }
        } catch (JSONException e17) {
            QMLog.e("ChannelProxyImpl", "joinGroupByTags: json exception:", e17);
        }
        asyncResult.onReceiveResult(true, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(AsyncResult asyncResult, MiniAppSSOResponse miniAppSSOResponse) {
        JSONObject jSONObject = new JSONObject();
        if (miniAppSSOResponse == null) {
            asyncResult.onReceiveResult(false, jSONObject);
            return;
        }
        try {
            int retCode = miniAppSSOResponse.getRetCode();
            String errMsg = miniAppSSOResponse.getErrMsg();
            QMLog.d("ChannelProxyImpl", "queryMiniGameUserAgreement retCode:" + retCode + ", errMsg:" + errMsg);
            jSONObject.put("retCode", retCode);
            jSONObject.put("errMsg", errMsg);
            if (miniAppSSOResponse.isDataValid()) {
                try {
                    QueryToSRsp queryToSRsp = new QueryToSRsp();
                    queryToSRsp.mergeFrom(miniAppSSOResponse.getData());
                    jSONObject.put("is_compulsory", queryToSRsp.is_compulsory.get());
                    jSONObject.put("appid", queryToSRsp.tos.get().appid.get());
                    jSONObject.put("version", queryToSRsp.tos.get().version_num.get());
                    jSONObject.put("title", queryToSRsp.tos.get().content.get().title.get());
                    jSONObject.put("text", queryToSRsp.tos.get().content.get().text.get());
                    jSONObject.put("isSigned", queryToSRsp.tos.get().is_signed.get());
                    jSONObject.put("isSubscribe", queryToSRsp.is_subscribe.get());
                    JSONArray jSONArray = new JSONArray();
                    List<ToSLink> list = queryToSRsp.tos.get().content.get().links.get();
                    if (list != null && list.size() > 0) {
                        for (ToSLink toSLink : list) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("linkText", toSLink.link_text.get());
                            jSONObject2.put("url", toSLink.url.get());
                            jSONArray.mo162put(jSONObject2);
                        }
                    }
                    jSONObject.put("links", jSONArray);
                    asyncResult.onReceiveResult(true, jSONObject);
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QMLog.e("ChannelProxyImpl", "QueryToSRsp: parse pb failed:", e16);
                }
            }
        } catch (JSONException e17) {
            QMLog.e("ChannelProxyImpl", "QueryToSRsp: json exception:", e17);
        }
        asyncResult.onReceiveResult(false, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(List list, Context context, ChannelProxy.SetCookieCallback setCookieCallback) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String replace = SwiftBrowserCookieMonster.r(str).replace(" ", "");
            if (!TextUtils.isEmpty(replace)) {
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.setAcceptCookie(true);
                for (String str2 : replace.split(";")) {
                    cookieManager.setCookie(Uri.parse(str).getHost(), str2);
                }
                try {
                    CookieSyncManager.getInstance().sync();
                } catch (Exception unused) {
                }
            }
        }
        if (setCookieCallback != null) {
            setCookieCallback.onFinish();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void addGroupApp(IMiniAppContext iMiniAppContext, AsyncResult asyncResult) {
        QLog.d("ChannelProxyImpl", 1, "addGroupApp");
        try {
            if (iMiniAppContext == null) {
                QLog.e("ChannelProxyImpl", 1, "addGroupApp, miniAppContext=null");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errMsg", "miniAppContext is null");
                asyncResult.onReceiveResult(false, jSONObject);
                return;
            }
            boolean z16 = iMiniAppContext.getMiniAppInfo().launchParam.entryModel != null;
            String str = iMiniAppContext.getMiniAppInfo().appId;
            if (z16) {
                if (!iMiniAppContext.getMiniAppInfo().launchParam.entryModel.isAdmin) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("errMsg", "non-administrators");
                    asyncResult.onReceiveResult(false, jSONObject2);
                    return;
                }
                TroopApplicationListUtil.addMiniAppToTroopApplicationList(String.valueOf(iMiniAppContext.getMiniAppInfo().launchParam.entryModel.uin), str, null, asyncResult);
                return;
            }
            QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_QUERY_USER_TROOP_INFO, new Bundle(), new e(iMiniAppContext, str, asyncResult));
        } catch (Exception e16) {
            QLog.e("ChannelProxyImpl", 1, "addGroupApp, exception: " + Log.getStackTraceString(e16));
            asyncResult.onReceiveResult(false, null);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void addPhoneNumber(String str, String str2, String str3, int i3, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().addPhoneNumber(str, str2, str3, i3, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean addPublicAccount(String str, String str2, AsyncResult asyncResult) {
        ((IQWalletApi) QRoute.api(IQWalletApi.class)).servletSendRequest(new FocusMpIdReq(str, str2), new n(asyncResult));
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void batchGetContact(ArrayList<String> arrayList, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().batchGetContact(arrayList, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void buildCookieForRedirect(final String str) {
        try {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ChannelProxyImpl.19

                /* renamed from: com.tencent.qqmini.proxyimpl.ChannelProxyImpl$19$a */
                /* loaded from: classes34.dex */
                class a implements t43.b {
                    a() {
                    }

                    @Override // t43.b
                    public void a(String str, Bundle bundle, long j3) {
                        QLog.d("ChannelProxyImpl", 1, "onSetCookiesFinished targetUrl:" + str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String f16 = com.tencent.mobileqq.webview.swift.cookie.b.f(str);
                    if (f16 == null || !f16.contains("ptlogin")) {
                        return;
                    }
                    SwiftBrowserCookieMonster.H();
                    SwiftBrowserCookieMonster s16 = SwiftBrowserCookieMonster.s(str);
                    if (s16 != null) {
                        s16.I(str, new a(), null, null);
                    }
                }
            });
        } catch (Throwable th5) {
            QLog.e("ChannelProxyImpl", 1, th5, new Object[0]);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void checkBindingState(String str, String str2, int i3, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().checkBindingState(str, str2, i3, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void checkNavigateRight(String str, String str2, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().checkNavigateRight(str, str2, null, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void checkOfferId(String str, String str2, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().checkOfferId(str, str2, null, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void checkSession(String str, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().checkSession(str, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void checkWxPayUrl(String str, String str2, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().checkWxPayUrl(str, str2, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void clearMiniGameUserAgreementData(String str) {
        QMMKV.fromV2(BaseApplication.getContext(), QMMKVFile.FILE_MINI_GAME).encodeString(o(str), "");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void closeFloatBubble(String str, String str2, final AsyncResult asyncResult) {
        MiniAppSSORequestClient.INSTANCE.sendReq(new MiniGameCloseFloatBubbleRequest(str, str2), new MiniAppSSOReqCallback() { // from class: com.tencent.qqmini.proxyimpl.g
            @Override // com.tencent.mobileqq.mini.server.MiniAppSSOReqCallback
            public final void onResponse(MiniAppSSOResponse miniAppSSOResponse) {
                ChannelProxyImpl.s(AsyncResult.this, miniAppSSOResponse);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void dataReport(byte[] bArr, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().performDataReport(bArr, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void delPhoneNumber(String str, String str2, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().delPhoneNumber(str, str2, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void doGameRaffle(String str, String str2, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().doGameRaffle(str, str2, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void ffmpegExecCommand(String[] strArr, ChannelProxy.ICommandListenr iCommandListenr) {
        try {
            if (this.f347291a == null) {
                this.f347291a = FFmpeg.getInstance(BaseApplicationImpl.getApplication());
            }
            this.f347291a.execute(strArr, new c(iCommandListenr));
        } catch (FFmpegCommandAlreadyRunningException e16) {
            Log.e("ChannelProxyImpl", "run: ", e16);
            if (iCommandListenr != null) {
                iCommandListenr.onFailure("FFmpegCommandAlreadyRunningException");
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getAppInfoById(String str, String str2, String str3, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getAppInfoByIdForSDK(null, str, str2, str3, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getAppInfoByLink(String str, int i3, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getAppInfoByLinkForSDK(str, i3, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getAuthList(String str, ChannelProxy.AuthListResult authListResult) {
        MiniAppCmdUtil.getInstance().getAuthList(null, str, new g(authListResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getAuthListForSubscribe(String str, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getAuthList(null, str, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public JSONArray getChooseMessageTempFilesArray(Intent intent) {
        JSONArray jSONArray = new JSONArray();
        if (intent != null) {
            try {
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("reslut_select_file_info_list");
                if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
                    Iterator it = parcelableArrayListExtra.iterator();
                    while (it.hasNext()) {
                        FileInfo fileInfo = (FileInfo) it.next();
                        if (fileInfo != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("path", fileInfo.k());
                            jSONObject.put("size", fileInfo.l());
                            jSONObject.put("name", fileInfo.j());
                            jSONObject.put("type", p(fileInfo.getType()));
                            jSONObject.put("time", fileInfo.e());
                            jSONArray.mo162put(jSONObject);
                        }
                    }
                    QLog.i("ChannelProxyImpl", 1, "tempFiles : " + jSONArray.toString());
                }
            } catch (Throwable th5) {
                QLog.e("ChannelProxyImpl", 1, "ChooseMessageFile error,", th5);
            }
        }
        return jSONArray;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getContainerInfoById(String str, String str2, String str3, AsyncResult asyncResult) {
        QLog.i("ChannelProxyImpl", 4, "\u83b7\u53d6\u5bb9\u5668\u5316info\uff0cappid=" + str + "; entryPath=" + str2 + "envVersion:" + str3);
        MiniAppCmdUtil.getInstance().getContainerInfoByIdForSDK(null, str, str2, str3, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public String getDeviceInfo() {
        return PlatformInfor.g().getDeviceInfor();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getFloatBubble(String str, final AsyncResult asyncResult) {
        MiniAppSSORequestClient.INSTANCE.sendReq(new MiniGameGetFloatBubbleRequest(str), new MiniAppSSOReqCallback() { // from class: com.tencent.qqmini.proxyimpl.n
            @Override // com.tencent.mobileqq.mini.server.MiniAppSSOReqCallback
            public final void onResponse(MiniAppSSOResponse miniAppSSOResponse) {
                ChannelProxyImpl.t(AsyncResult.this, miniAppSSOResponse);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public IFlutterProxy getFlutterProxy() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getFormId(String str, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getFormId(str, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getFriendCloudStorage(String str, String[] strArr, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getFriendCloudStorage(str, strArr, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getGameFloatEnableConfig(String str, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getGameBoxOptions(str, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getGameLaunchConfig(String str, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getGameLaunchConfig(str, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getGameRaffleMaterial(String str, String str2, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getGameRaffleMaterial(str, str2, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getGameTaskTicket(String str, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getGameTaskTicket(str, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public Drawable getGifDrawable(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = AppLoaderFactory.g().getContext().getFilesDir().getPath() + "/mini/gif/" + str.hashCode();
        if (new File(str2).exists()) {
            final URLDrawable apngDrawable = VasApngUtil.getApngDrawable(str2, str, null, new int[]{32}, "-MINI-APP-", null);
            AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ChannelProxyImpl.17
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Drawable currDrawable = apngDrawable.getCurrDrawable();
                        if (currDrawable == null || !(currDrawable instanceof ApngDrawable) || ((ApngDrawable) currDrawable).getImage() == null) {
                            return;
                        }
                        ApngImage.playByTag(32);
                    } catch (Throwable th5) {
                        QLog.e("ChannelProxyImpl", 1, th5, new Object[0]);
                    }
                }
            }, 500L);
            return apngDrawable;
        }
        MiniappDownloadUtil.getInstance().download(str, str2, false, null, Downloader.DownloadMode.OkHttpMode, null);
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getGroupAppStatus(IMiniAppContext iMiniAppContext, String str, AsyncResult asyncResult) {
        QLog.d("ChannelProxyImpl", 1, "getGroupAppStatus");
        if (iMiniAppContext == null) {
            QLog.e("ChannelProxyImpl", 1, "getGroupAppStatus, miniAppContext=null");
            asyncResult.onReceiveResult(false, null);
            return;
        }
        try {
            String optString = new JSONObject(str).optString("entryDataHash");
            if (!TextUtils.isEmpty(optString) && optString.equals(iMiniAppContext.getMiniAppInfo().launchParam.entryModel.getEntryHash())) {
                if (iMiniAppContext.getMiniAppInfo().launchParam.entryModel.isAdmin) {
                    TroopApplicationListUtil.getGroupAppStatus(String.valueOf(iMiniAppContext.getMiniAppInfo().launchParam.entryModel.uin), iMiniAppContext.getMiniAppInfo().appId, asyncResult);
                } else {
                    QLog.e("ChannelProxyImpl", 1, "you are not group administrator");
                    asyncResult.onReceiveResult(false, null);
                }
            } else {
                QLog.e("ChannelProxyImpl", 1, "entryDataHash is not valid or you are not group administrator");
                asyncResult.onReceiveResult(false, null);
            }
        } catch (Exception e16) {
            QLog.e("ChannelProxyImpl", 1, "getGroupAppStatus, exception: " + Log.getStackTraceString(e16));
            asyncResult.onReceiveResult(false, null);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getGroupCloudStorage(String str, String str2, String[] strArr, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getGroupCloudStorage(str, str2, strArr, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getGroupShareInfo(String str, String str2, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getGroupShareInfo(str, str2, null, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getLatestUserKey(String str, final AsyncResult asyncResult) {
        MiniAppSSORequestClient.INSTANCE.sendReq(new GetLatestUserKeyRequest(str), new MiniAppSSOReqCallback() { // from class: com.tencent.qqmini.proxyimpl.o
            @Override // com.tencent.mobileqq.mini.server.MiniAppSSOReqCallback
            public final void onResponse(MiniAppSSOResponse miniAppSSOResponse) {
                ChannelProxyImpl.u(AsyncResult.this, miniAppSSOResponse);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public IMediaPlayer getMediaPlayer() {
        if (f347290f) {
            if (!QQVideoPlaySDKManager.isSDKReady()) {
                QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getApplication(), new a());
                QLog.d("ChannelProxyImpl", 1, "superplayer not ready !");
                return n();
            }
            QLog.d("ChannelProxyImpl", 1, "superplayer ready !");
            return new ad();
        }
        return n();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public IMediaPlayerUtil getMediaPlayerUtil() {
        return new b();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getMidasConsumeResult(String str, String str2, int i3, int i16, int i17, int i18, int i19, String str3, String str4, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getMidasConsumeResult(str, str2, i3, i16, i17, i18, i19, null, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public MiniAIOEntranceProxy getMiniAIOEntranceView(Context context, String str) {
        MiniAIOEntryView miniAIOEntryView = new MiniAIOEntryView(context, str);
        miniAIOEntryView.setMiniAIOStyle(str);
        return miniAIOEntryView;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getMiniAppStoreAppList(int i3, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getMiniAppStoreAppList(i3, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public Object getMiniGameUserAgreementData(String str) {
        String decodeString = QMMKV.fromV2(BaseApplication.getContext(), QMMKVFile.FILE_MINI_GAME).decodeString(o(str), "");
        if (TextUtils.isEmpty(decodeString)) {
            return null;
        }
        return GsonUtils.json2Obj(decodeString, UserAgreementData.class);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getNativeAppInfoForJump(String str, String str2, String str3, int i3, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getNativeAppInfoForJump(null, str, str2, str3, i3, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getPhoneNumber(String str, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getPhoneNumber(str, m(asyncResult));
        MiniGetPhoneNumberReporter.getInstance().phoneNumberApiInvokeReport();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getPotentialFriendList(COMM.StCommonExt stCommonExt, String str, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getPotentialFriendList(stCommonExt, str, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getRobotUin(String str, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getRobotUin(str, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public int getRunTimeReportRate() {
        return 100;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public long getServerTime() {
        return NetConnInfoCenter.getServerTimeMillis();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getShareInfo(MiniProgramShare$StAdaptShareInfoReq miniProgramShare$StAdaptShareInfoReq, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getShareInfo(miniProgramShare$StAdaptShareInfoReq, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getTcbTicket(String str, String str2, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getTcbTicket(str, null, str2, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public ChannelProxy.SoLoaderOption getTissueSoLoaderOption() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getUserCloudStorage(String str, String[] strArr, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getUserCloudStorage(str, strArr, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getUserGroupInfo(COMM.StCommonExt stCommonExt, String str, String str2, long j3, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getUserGroupInfo(stCommonExt, str, str2, j3, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getUserHealthData(String str, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getUserHealthData(str, null, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getUserInfo(String str, boolean z16, String str2, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getUserInfo(str, z16, str2, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getUserInfoExtra(String str, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getUserInfoExtra(str, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getUserInfoOpenData(String str, String str2, String[] strArr, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getUserInfoOpenData(str, str2, strArr, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getUserInteractiveStorage(COMM.StCommonExt stCommonExt, String str, String[] strArr, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getUserInteractiveStorage(stCommonExt, str, strArr, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getUserSetting(String str, String str2, String str3, ArrayList<String> arrayList, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getUserSetting(str, str2, str3, arrayList, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public String getUserTheme() {
        if (QQTheme.isNowThemeIsNight()) {
            return MiniAppConst.MENU_STYLE_DARK;
        }
        return MiniAppConst.MENU_STYLE_LIGHT;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public AbsVideoPlayer getVideoPlayer() {
        if (!QQVideoPlaySDKManager.isSDKReady()) {
            QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getApplication(), new d());
            QLog.d("ChannelProxyImpl", 1, "superplayer not ready !");
        }
        QLog.d("ChannelProxyImpl", 1, "superplayer ready !");
        return new com.tencent.qqmini.proxyimpl.a();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void insertBookShelf(String str, String str2, ArrayList<String> arrayList, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().insertBookShelf(str, str2, arrayList, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean isGooglePlayVersion() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void joinGroupByTags(String str, String[] strArr, final AsyncResult asyncResult) {
        if (!TextUtils.isEmpty(str) && strArr != null) {
            MiniAppSSORequestClient.INSTANCE.sendReq(new JoinGroupByTagsRequest(str, strArr), new MiniAppSSOReqCallback() { // from class: com.tencent.qqmini.proxyimpl.q
                @Override // com.tencent.mobileqq.mini.server.MiniAppSSOReqCallback
                public final void onResponse(MiniAppSSOResponse miniAppSSOResponse) {
                    ChannelProxyImpl.v(AsyncResult.this, miniAppSSOResponse);
                }
            });
        } else {
            asyncResult.onReceiveResult(false, null);
            QMLog.e("ChannelProxyImpl", "joinGroupByTags: illegal params");
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void judgeTiming(String str, int i3, int i16, int i17, long j3, int i18, int i19, String str2, int i26, String str3, int i27, COMM.StCommonExt stCommonExt, String str4, String str5, AsyncResult asyncResult) {
        INTERFACE$StJudgeTimingReq iNTERFACE$StJudgeTimingReq = new INTERFACE$StJudgeTimingReq();
        iNTERFACE$StJudgeTimingReq.appid.set(str);
        iNTERFACE$StJudgeTimingReq.appType.set(i3);
        iNTERFACE$StJudgeTimingReq.scene.set(i16);
        iNTERFACE$StJudgeTimingReq.factType.set(i17);
        iNTERFACE$StJudgeTimingReq.reportTime.set(j3);
        iNTERFACE$StJudgeTimingReq.totalTime.set(i19);
        iNTERFACE$StJudgeTimingReq.launchId.set(str2);
        iNTERFACE$StJudgeTimingReq.afterCertify.set(i26);
        iNTERFACE$StJudgeTimingReq.via.set(str3);
        iNTERFACE$StJudgeTimingReq.AdsTotalTime.set(i27);
        iNTERFACE$StJudgeTimingReq.sourceID.set(str5);
        iNTERFACE$StJudgeTimingReq.duration.set(i18);
        if (stCommonExt != null) {
            iNTERFACE$StJudgeTimingReq.extInfo.set(stCommonExt);
        }
        if (QLog.isDebugVersion()) {
            StringBuilder sb5 = new StringBuilder();
            if (stCommonExt != null && stCommonExt.mapInfo.get().size() > 0) {
                for (COMM.Entry entry : stCommonExt.mapInfo.get()) {
                    sb5.append(entry.key.get());
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(entry.value.get());
                    sb5.append(";");
                }
            }
            QLog.i("ChannelProxyImpl", 4, "via=" + str3 + "; mapInfo=" + ((Object) sb5));
        }
        MiniAppSSOCmdHelper.sendSSOCmdRequest("LightAppSvc.mini_app_growguard.JudgeTiming", str, iNTERFACE$StJudgeTimingReq, INTERFACE$StJudgeTimingRsp.class, new h(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean jump2PublicAccount(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) ChatActivity.class));
        intent.putExtra("uin", str);
        intent.putExtra("uintype", 1008);
        intent.putExtra("chat_subType", 2);
        intent.putExtra("uinname", str2);
        intent.setFlags(67108864);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void launchAddPhoneNumberFragment(Activity activity, Intent intent, int i3) {
        PublicFragmentActivity.b.d(activity, intent, PublicFragmentActivityForMini.class, AddPhoneNumberFragment.class, i3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void launchPhoneNumberManagementFragment(Activity activity, Intent intent, int i3) {
        PublicFragmentActivity.b.d(activity, intent, PublicFragmentActivityForMini.class, PhoneNumberManagementFragment.class, i3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void login(String str, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getLoginCode(str, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void modifyFriendInteractiveStorage(COMM.StCommonExt stCommonExt, String str, String str2, String str3, int i3, String str4, HashMap<String, String> hashMap, boolean z16, CloudStorage$StInteractiveTemplate cloudStorage$StInteractiveTemplate, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().modifyFriendInteractiveStorage(stCommonExt, str, str2, str3, i3, str4, hashMap, z16, cloudStorage$StInteractiveTemplate, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void onInitFinish() {
        if (!f347290f || QQVideoPlaySDKManager.isSDKReady()) {
            return;
        }
        QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getApplication(), new f());
        QLog.d("ChannelProxyImpl", 1, "superplayer not ready !");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean openGroup(Context context, String str, AsyncResult asyncResult) {
        if (!(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        Bundle bundle = new Bundle();
        bundle.putBoolean("hide_more_button", true);
        intent.putExtras(bundle);
        IActivityResultManager activityResultManager = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
        activityResultManager.addActivityResultListener(new m(activityResultManager, asyncResult));
        activity.startActivityForResult(intent, 9);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean openPermissionSettingsActivity(Context context, String str, String str2) {
        PermissionSettingFragment.launchForResult((Activity) context, str, str2, 5);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean openRobotProfileCard(Context context, String str, String str2) {
        com.tencent.mobileqq.troop.utils.k.o(context, str, str2);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void queryBookShelf(String str, ArrayList<String> arrayList, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().queryBookShelf(str, arrayList, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void queryCurrency(String str, String str2, int i3, int i16, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getMidasQueryResult(str, str2, i3, i16, null, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void queryMiniGameUserAgreement(String str, final AsyncResult asyncResult) {
        MiniAppSSORequestClient.INSTANCE.sendReq(new QueryMiniGameUserAgreementRequest(str), new MiniAppSSOReqCallback() { // from class: com.tencent.qqmini.proxyimpl.p
            @Override // com.tencent.mobileqq.mini.server.MiniAppSSOReqCallback
            public final void onResponse(MiniAppSSOResponse miniAppSSOResponse) {
                ChannelProxyImpl.w(AsyncResult.this, miniAppSSOResponse);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void realTimeLogReport(String str, String str2, String str3, String[] strArr, ArrayList<RealTimeLogItem> arrayList, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().realTimeLogReport(str, str2, str3, strArr, arrayList, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void removeUserCloudStorage(String str, String[] strArr, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().removeUserCloudStorage(str, strArr, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void report(byte[] bArr, String str, String str2, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().performReport(bArr, m(asyncResult), "LightAppSvc." + str + "." + str2);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void reportBeacon(ChannelProxy.BeaconReportCategory beaconReportCategory, String str, Map<String, String> map) {
        if (beaconReportCategory == ChannelProxy.BeaconReportCategory.MINI_GAME) {
            MiniGameBeaconReport.report(str, map);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void reportExecute(String str, int i3, String str2, String str3, AsyncResult asyncResult) {
        INTERFACE$StReportExecuteReq iNTERFACE$StReportExecuteReq = new INTERFACE$StReportExecuteReq();
        iNTERFACE$StReportExecuteReq.appid.set(str);
        iNTERFACE$StReportExecuteReq.execTime.set(i3);
        iNTERFACE$StReportExecuteReq.instrTraceId.set(str2);
        iNTERFACE$StReportExecuteReq.ruleName.set(str3);
        MiniAppSSOCmdHelper.sendSSOCmdRequest("LightAppSvc.mini_app_growguard.ReportExecute", str, iNTERFACE$StReportExecuteReq, INTERFACE$StReportExecuteRsp.class, new i(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void reportShare(COMM.StCommonExt stCommonExt, long j3, String str, int i3, int i16, int i17, int i18, String str2, AsyncResult asyncResult) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        MiniAppCmdUtil.getInstance().reportShare(stCommonExt, j3, str, i3, i16, i17, i18, str2, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void reportTrafficFlow(int i3, String str, String str2, String str3, int i16) {
        boolean isCurrentProcessForeground = Foreground.isCurrentProcessForeground();
        int i17 = !NetworkUtil.isWifiConnected(BaseApplication.getContext()) ? 1 : 0;
        if (i3 == 1) {
            TrafficFlowReporter.r(new b.a().b(4).c(str).d(str2).k(str3).e(String.valueOf(i16)).f(isCurrentProcessForeground ? 1 : 0).g(i17).a());
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void saveMiniGameUserAgreementData(String str, Object obj) {
        if (obj instanceof UserAgreementData) {
            QMMKV.fromV2(BaseApplication.getContext(), QMMKVFile.FILE_MINI_GAME).encodeString(o(str), GsonUtils.obj2Json((UserAgreementData) obj));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void sendSmsCodeRequest(String str, String str2, AsyncResult asyncResult) {
        MiniAppSendSmsCodeServlet.sendSmsCodeRequest(str, str2, new j(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void sendVerifySmsCodeRequest(String str, String str2, String str3, AsyncResult asyncResult) {
        MiniAppSendSmsCodeServlet.sendVerifySmsCodeRequest(str, str2, str3, new k(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void setAuth(String str, UserAuthInfo userAuthInfo, AsyncResult asyncResult) {
        INTERFACE$StUserAuthInfo iNTERFACE$StUserAuthInfo = new INTERFACE$StUserAuthInfo();
        iNTERFACE$StUserAuthInfo.scope.set(userAuthInfo.scope);
        if (!TextUtils.isEmpty(userAuthInfo.desc)) {
            iNTERFACE$StUserAuthInfo.desc.set(userAuthInfo.desc);
        }
        iNTERFACE$StUserAuthInfo.authState.set(userAuthInfo.authState);
        MiniAppCmdUtil.getInstance().setAuth(null, str, iNTERFACE$StUserAuthInfo, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void setPersonalizeInfo(String str, String str2, int i3, String str3, String str4, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().setPersonalizeInfo(str, str2, i3, str3, str4, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void setUserCloudStorage(String str, HashMap<String, String> hashMap, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().setUserCloudStorage(str, hashMap, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean setWebviewCookie(final Context context, final List<String> list, final ChannelProxy.SetCookieCallback setCookieCallback) {
        if (!TextUtils.isEmpty(MiniAppSecurityUtil.getLoginMiniAppForbidToken(BaseApplicationImpl.getApplication(), MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication())))) {
            QLog.e("ChannelProxyImpl", 1, "setCookie: forbidToken non-null");
            return false;
        }
        if (list != null && list.size() != 0) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.m
                @Override // java.lang.Runnable
                public final void run() {
                    ChannelProxyImpl.x(list, context, setCookieCallback);
                }
            }, 16, null, false);
            return true;
        }
        QLog.d("ChannelProxyImpl", 1, "setWebviewCookie: urls size is 0.");
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void signMiniGameUserAgreement(String str, String str2, boolean z16, final AsyncResult asyncResult) {
        MiniAppSSORequestClient.INSTANCE.sendReq(new SignMiniGameUserAgreementRequest(str, str2, true, z16), new MiniAppSSOReqCallback() { // from class: com.tencent.qqmini.proxyimpl.h
            @Override // com.tencent.mobileqq.mini.server.MiniAppSSOReqCallback
            public final void onResponse(MiniAppSSOResponse miniAppSSOResponse) {
                ChannelProxyImpl.C(AsyncResult.this, miniAppSSOResponse);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean startAddFriendActivity(Context context, String str, String str2, String str3) {
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).setsOpenId(str);
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(context, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(context, 3, str2, str, 3024, Integer.parseInt(str), "5010_1".equals(str3) ? str3.getBytes() : null, (String) null, (String) null, (String) null, "", (String) null));
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean startBrowserSupportHeaderActivityForResult(Activity activity, String str, Bundle bundle, int i3) {
        Intent intent = new Intent();
        intent.putExtra("url", str);
        intent.putExtra("big_brother_source_key", "biz_src_miniapp");
        intent.setComponent(new ComponentName(activity, (Class<?>) QQBrowserActivity.class));
        intent.putExtra("fragmentClass", MiniAppWebviewFragment.class);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, i3);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean startChooseMessageFileActivityForResult(Activity activity, int i3, String str, int i16) {
        ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).fileChooseLaunchForResult(activity, i16, i3, new ArrayList<>(Arrays.asList(str)));
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void startDownloadX5(IMiniAppContext iMiniAppContext) {
        X5UpdateGuard.n().x(iMiniAppContext);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean startRedpacketTranslucentBrowserActivityForResult(Activity activity, String str, Bundle bundle, int i3) {
        Intent intent = new Intent(activity, (Class<?>) QQTranslucentBrowserActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("fragmentClass", RedpacketTranslucentBrowserFragment.class);
        boolean z16 = bundle.getBoolean("mini_game_orientation");
        QLog.d("ChannelProxyImpl", 1, "mini_game_orientation =" + z16);
        bundle.putBoolean("isLandScape", z16);
        intent.putExtras(bundle);
        if (activity == null) {
            return false;
        }
        activity.startActivityForResult(intent, i3);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean startTransparentBrowserActivityForResult(Activity activity, String str, Bundle bundle, int i3) {
        Intent intent = new Intent(activity, (Class<?>) QQTranslucentBrowserActivity.class);
        intent.putExtra("url", str);
        bundle.putBoolean(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
        bundle.putBoolean("hide_more_button", true);
        intent.putExtras(bundle);
        if (activity == null) {
            return false;
        }
        activity.startActivityForResult(intent, i3);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void subscribePublicAccount(String str, AsyncResult asyncResult) {
        new GameSubscribeRequest().subscribePARequest(str, asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void syncForceGroundAndRefreshBadge(final Activity activity, final String str, final String str2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ChannelProxyImpl.13
            @Override // java.lang.Runnable
            public void run() {
                Activity activity2 = activity;
                if (activity2 != null && !activity2.isFinishing()) {
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("miniAppID", str);
                        bundle.putString(MiniChatConstants.PARAM_PROC_NAME, str2);
                        bundle.putString(MiniChatConstants.PARAM_PROC_MODULENAME, MiniConst.MiniSDKClientQIPCModuleConst.MODULE_NAME);
                        Activity activity3 = activity;
                        if (activity3 instanceof AppBrandUI) {
                            if (QMLog.isColorLevel()) {
                                QMLog.d("ChannelProxyImpl", "onStart--onProcessForeGround");
                            }
                            ((AppBrandUI) activity).onProcessForeGround(bundle);
                            if (QMLog.isColorLevel()) {
                                QMLog.d("ChannelProxyImpl", "onResume--onRefreshMiniBadge");
                            }
                            ((AppBrandUI) activity).onRefreshMiniBadge(bundle);
                            return;
                        }
                        if (activity3 instanceof GameActivity1) {
                            if (QMLog.isColorLevel()) {
                                QMLog.d("ChannelProxyImpl", "onStart--onProcessForeGround");
                            }
                            ((GameActivity1) activity).onProcessForeGround(bundle);
                            if (QMLog.isColorLevel()) {
                                QMLog.d("ChannelProxyImpl", "onResume--onRefreshMiniBadge");
                            }
                            ((GameActivity1) activity).onRefreshMiniBadge(bundle);
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e("ChannelProxyImpl", 2, "syncForceGroundAndRefreshBadge--miniConfig error");
                        return;
                    }
                    return;
                }
                QMLog.i("ChannelProxyImpl", "activity is null or finishing");
            }
        }, 16, null, true);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean tianshuReport(TianShuAccess.AdItem adItem, String str, int i3) {
        TianShuManager.getInstance().report(D(adItem, str, i3));
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean tianshuRequestAdv(Context context, String str, int i3, int i16, int i17, AsyncResult asyncResult) {
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = i16;
        tianShuAdPosItemData.mNeedCnt = i17;
        tianShuAdPosItemData.mExtraData = new HashMap<>();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put(str);
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.mo162put(String.valueOf(i3));
        try {
            jSONObject.put("Appid", jSONArray);
            jSONObject.put("Refer", jSONArray2);
            tianShuAdPosItemData.mExtraData.put("FilterInfo", jSONObject.toString());
        } catch (JSONException e16) {
            QLog.e("ChannelProxyImpl", 1, "put extra data exception", e16);
        }
        MiniTianShuManager.requestAdv(Collections.singletonList(tianShuAdPosItemData), new l(asyncResult));
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void transForRoomId(String str, String str2, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().transForRoomId(str, str2, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean updateBaseLib(String str, boolean z16, boolean z17, AsyncResult asyncResult) {
        return MiniAppCmdUtil.getInstance().updateBaseLibForSDK(str, z16, z17, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void updateBookshelfReadtime(String str, String str2, String str3, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().updateBookshelfReadtime(str, str2, str3, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void updateTouchInfoList(ArrayList<TouchInfo> arrayList) {
        f347287c = arrayList;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void updateUserSetting(String str, INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().updateUserSetting(null, str, iNTERFACE$StUserSettingInfo, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void uploadUserLog(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("appid", str);
            QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_UPLOAD_USER_LOG, bundle, null);
        } catch (Exception e16) {
            QLog.e("ChannelProxyImpl", 1, e16, new Object[0]);
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void useUserApp(String str, int i3, int i16, String str2, String str3, COMM.StCommonExt stCommonExt, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().useUserApp(str, i3, i16, str2, str3, stCommonExt, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void verifyPlugin(String str, ArrayList<PluginInfo> arrayList, AsyncResult asyncResult) {
        ArrayList<com.tencent.mobileqq.mini.apkg.PluginInfo> arrayList2 = new ArrayList<>();
        Iterator<PluginInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            PluginInfo next = it.next();
            com.tencent.mobileqq.mini.apkg.PluginInfo pluginInfo = new com.tencent.mobileqq.mini.apkg.PluginInfo();
            pluginInfo.setInnerVersion(next.getInnerVersion());
            pluginInfo.setPluginId(next.getPluginId());
            arrayList2.add(pluginInfo);
        }
        MiniAppCmdUtil.getInstance().verifyPlugin(str, arrayList2, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean wnsCgiRequest(JSONObject jSONObject, AsyncResult asyncResult) {
        return MiniAppUtils.performWnsCgiRequest(jSONObject, asyncResult);
    }

    /* loaded from: classes34.dex */
    class e implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IMiniAppContext f347304d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f347305e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347306f;

        e(IMiniAppContext iMiniAppContext, String str, AsyncResult asyncResult) {
            this.f347304d = iMiniAppContext;
            this.f347305e = str;
            this.f347306f = asyncResult;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            Bundle bundle;
            if (eIPCResult != null && (bundle = eIPCResult.data) != null && bundle.getBoolean("hasCreateOrManageTroop")) {
                TroopApplicationListUtil.startTroopActivityAndAddTroopApplication(this.f347304d.getAttachActivity(), this.f347305e, this.f347306f);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errMsg", "not group manager");
                jSONObject.put("errorCode", TroopApplicationListUtil.STATUS_CODE_NOT_GROUP_MANAGER);
                this.f347306f.onReceiveResult(false, jSONObject);
                TroopApplicationListUtil.showToast(TroopApplicationListUtil.STATUS_CODE_NOT_GROUP_MANAGER);
            } catch (Exception e16) {
                QLog.e("ChannelProxyImpl", 1, "addGroupApp, exception: " + Log.getStackTraceString(e16));
            }
        }
    }

    private void F(Activity activity, PublishMoodInfo publishMoodInfo, MiniAppInfo miniAppInfo) {
        String str;
        String str2;
        String str3;
        if (activity != null && publishMoodInfo != null) {
            Bundle bundle = new Bundle();
            bundle.putString("summary", publishMoodInfo.mText);
            bundle.putBoolean("key_need_save_draft", false);
            bundle.putBoolean(QZoneShareManager.QZONE_SHARE_FROM_MINI_APP, true);
            bundle.putStringArrayList("images", publishMoodInfo.mAllImageAndVideo);
            bundle.putSerializable("PeakConstants.selectedMediaInfoHashMap", publishMoodInfo.mMediaInfoHashMap);
            bundle.putString("shareSource", "miniApp");
            if (miniAppInfo != null) {
                str = miniAppInfo.appId;
                String replace = "https://m.q.qq.com/a/p/{appid}".replace("{appid}", str);
                if (!TextUtils.isEmpty(publishMoodInfo.mPath)) {
                    str2 = replace + "?s=" + publishMoodInfo.mPath + "&referer=2100";
                } else {
                    str2 = replace + "?referer=2100";
                }
                if (TextUtils.isEmpty(publishMoodInfo.mFootnote)) {
                    str3 = activity.getResources().getString(R.string.f167402cu);
                } else {
                    str3 = publishMoodInfo.mFootnote;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("icon_url", miniAppInfo.iconUrl);
                    jSONObject.put("title", miniAppInfo.name);
                    jSONObject.put("summary", str3);
                    jSONObject.put("jump_url", str2);
                    jSONObject.put(AppDownloadCallback.BUTTON_TXT, activity.getResources().getString(R.string.f167532d7));
                    jSONObject.put(TroopQRCodeShareApiImpl.TAIL_KEY_RECOM_ID, 2);
                    jSONObject.put("action_type", 2);
                    String jSONObject2 = jSONObject.toString();
                    bundle.putString(QZoneShareManager.QZONE_SHARE_KEY_MINI_APP_TAIL, jSONObject2);
                    QLog.d("ChannelProxyImpl", 1, "publishMood\uff0c comm_recom_bottom\uff1a " + jSONObject2);
                } catch (Exception e16) {
                    QLog.d("ChannelProxyImpl", 1, "publishMood exception: " + Log.getStackTraceString(e16));
                }
            } else {
                str = null;
            }
            bundle.putString("key_mini_appid", str);
            QZoneShareManager.publishToQzoneFromMiniApp(activity, bundle, null, -1);
            return;
        }
        QLog.i("ChannelProxyImpl", 2, "handle moodInfo is null");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getAppInfoById(String str, String str2, String str3, String str4, AsyncResult asyncResult) {
        MiniAppCmdUtil.getInstance().getAppInfoByIdForSDK(null, str, str2, str3, str4, m(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean openQzonePublish(IMiniAppContext iMiniAppContext, Activity activity, String str, MiniAppInfo miniAppInfo) {
        QLog.i("ChannelProxyImpl", 2, "receive openQzonePublish event");
        PublishMoodInfo h16 = SharePlugin.h(E(iMiniAppContext, str));
        if (h16 == null) {
            return true;
        }
        F(activity, h16, miniAppInfo);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public boolean updateEntryList(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("data", str);
            QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_UPDATE_ENTRY_LIST, bundle, null);
        } catch (Exception e16) {
            QLog.e("ChannelProxyImpl", 1, e16, new Object[0]);
            e16.printStackTrace();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A(AsyncMultiObjResult asyncMultiObjResult, boolean z16, DialogInterface dialogInterface, int i3) {
        boolean z17;
        if (asyncMultiObjResult != null) {
            JSONObject jSONObject = new JSONObject();
            if (!z16) {
                try {
                } catch (Exception e16) {
                    QMLog.e("ChannelProxyImpl", "showMiniGameUserAgreementDialog: json exception:", e16);
                }
                if (!((QQCustomDialog) dialogInterface).getCheckBoxState()) {
                    z17 = false;
                    jSONObject.put("isSubscribe", z17);
                    asyncMultiObjResult.onReceiveResult(true, dialogInterface, jSONObject);
                }
            }
            z17 = true;
            jSONObject.put("isSubscribe", z17);
            asyncMultiObjResult.onReceiveResult(true, dialogInterface, jSONObject);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public String decodeQR(byte[] bArr, int i3, int i16, int i17, int i18, int i19, int i26) {
        Result result;
        long nanoTime = System.nanoTime();
        try {
            try {
                if (this.f347292b == null) {
                    this.f347292b = new MultiFormatReader();
                    HashMap hashMap = new HashMap();
                    hashMap.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(BarcodeFormat.CODABAR);
                    arrayList.add(BarcodeFormat.CODE_39);
                    arrayList.add(BarcodeFormat.CODE_93);
                    arrayList.add(BarcodeFormat.CODE_128);
                    arrayList.add(BarcodeFormat.EAN_8);
                    arrayList.add(BarcodeFormat.EAN_13);
                    arrayList.add(BarcodeFormat.ITF);
                    arrayList.add(BarcodeFormat.UPC_A);
                    arrayList.add(BarcodeFormat.UPC_E);
                    arrayList.add(BarcodeFormat.UPC_EAN_EXTENSION);
                    hashMap.put(DecodeHintType.POSSIBLE_FORMATS, arrayList);
                    this.f347292b.setHints(hashMap);
                }
                BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new PlanarYUVLuminanceSource(bArr, i3, i16, i17, i18, i3, i16, false)));
                QLog.d("ChannelProxyImpl", 1, "run: " + binaryBitmap.getWidth() + ":" + binaryBitmap.getHeight());
                result = this.f347292b.decodeWithState(binaryBitmap);
            } catch (Exception e16) {
                QLog.d("ChannelProxyImpl", 1, "run: failed to decode frame", e16);
                this.f347292b.reset();
                result = null;
            }
            if (result == null) {
                return null;
            }
            long nanoTime2 = System.nanoTime();
            String text = result.getText();
            Log.i("ChannelProxyImpl", "Found barcode in " + TimeUnit.NANOSECONDS.toMillis(nanoTime2 - nanoTime) + " ms, " + text + ", " + result.getBarcodeFormat().name());
            return text;
        } finally {
            this.f347292b.reset();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void httpReport(Bundle bundle) {
        ReportHandler reportHandler;
        if (bundle == null || !bundle.containsKey("data")) {
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface) || (reportHandler = (ReportHandler) ((QQAppInterface) runtime).getBusinessHandler(BusinessHandlerFactory.REPORT_HANDLER)) == null) {
            return;
        }
        reportHandler.E2(bundle);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void openSchemeOrUrl(Context context, String str, boolean z16) {
        Class cls;
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("mqqapi://")) {
            if (z16) {
                cls = QPublicTransFragmentActivityLandscape.class;
            } else {
                cls = QPublicTransFragmentActivity.class;
            }
            String name = cls.getName();
            Intent intent = new Intent();
            if (z16 && !str.contains("is_landscape=1")) {
                str = URLUtil.addParameterWithoutEncode(str, KuiklyLaunchParams.PARAM_IS_LANDSCAPE, "1");
            }
            intent.putExtra(ZPlanPublishSource.FROM_SCHEME, str);
            intent.setComponent(new ComponentName("com.tencent.mobileqq", name));
            intent.putExtra("public_fragment_class", MiniGameJumperFragment.class.getName());
            context.startActivity(intent);
            return;
        }
        if (android.webkit.URLUtil.isNetworkUrl(str)) {
            Intent intent2 = new Intent();
            intent2.putExtra("hide_more_button", true);
            intent2.putExtra("hide_operation_bar", true);
            intent2.putExtra("url", str);
            intent2.setComponent(new ComponentName(context, (Class<?>) QQTranslucentBrowserActivity.class));
            intent2.putExtra("fragmentClass", MiniAppWebviewFragment.class);
            context.startActivity(intent2);
            return;
        }
        QLog.w("ChannelProxyImpl", 1, "openSchemeOrUrl url not support:" + str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void reportBeacon(ChannelProxy.BeaconReportCategory beaconReportCategory, String str, Map<String, String> map, boolean z16, boolean z17) {
        if (beaconReportCategory == ChannelProxy.BeaconReportCategory.MINI_GAME) {
            MiniGameBeaconReport.report(str, map, z16, z17);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void showDialog(Activity activity, String str, String str2, String str3, String str4, final AsyncMultiObjResult asyncMultiObjResult) {
        DialogUtil.createCustomDialog(activity, 230, str, str2, str3, str4, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.proxyimpl.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChannelProxyImpl.z(AsyncMultiObjResult.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.proxyimpl.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChannelProxyImpl.y(AsyncMultiObjResult.this, dialogInterface, i3);
            }
        }).show();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void showMiniGameUserAgreementDialog(Activity activity, String str, String str2, SpannableString spannableString, MovementMethod movementMethod, final boolean z16, final AsyncMultiObjResult asyncMultiObjResult) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, str2, spannableString, "\u4e0d\u540c\u610f", "\u540c\u610f", new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.proxyimpl.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChannelProxyImpl.A(AsyncMultiObjResult.this, z16, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.proxyimpl.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AsyncMultiObjResult.this.onReceiveResult(false, dialogInterface, null);
            }
        });
        if (!z16) {
            createCustomDialog.setCheckBox("\u5f00\u542f\u5c0f\u6e38\u620f\u5e73\u53f0\u6d3b\u52a8\u670d\u52a1\u901a\u77e5\u8ba2\u9605", true, null);
        }
        TextView messageTextView = createCustomDialog.getMessageTextView();
        messageTextView.setText(spannableString);
        messageTextView.setClickable(true);
        messageTextView.setTextSize(1, 13.0f);
        messageTextView.setMovementMethod(movementMethod);
        createCustomDialog.show();
    }

    /* loaded from: classes34.dex */
    class m implements IActivityResultListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IActivityResultManager f347321a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347322b;

        m(IActivityResultManager iActivityResultManager, AsyncResult asyncResult) {
            this.f347321a = iActivityResultManager;
            this.f347322b = asyncResult;
        }

        @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
        public boolean doOnActivityResult(int i3, int i16, Intent intent) {
            if (i3 != 9) {
                return false;
            }
            this.f347321a.removeActivityResultListener(this);
            this.f347322b.onReceiveResult(i16 == 0, null);
            return true;
        }
    }

    public static PublishMoodInfo E(IMiniAppContext iMiniAppContext, String str) {
        String str2;
        String str3;
        String str4;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        PublishMoodInfo publishMoodInfo = new PublishMoodInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str5 = "";
            if (!jSONObject.has("text")) {
                str2 = "";
            } else {
                str2 = jSONObject.getString("text");
            }
            publishMoodInfo.mText = str2;
            if (!jSONObject.has("tag")) {
                str3 = "";
            } else {
                str3 = jSONObject.getString("tag");
            }
            publishMoodInfo.mTag = str3;
            if (!jSONObject.has("path")) {
                str4 = "";
            } else {
                str4 = jSONObject.optString("path");
            }
            publishMoodInfo.mPath = str4;
            if (jSONObject.has("footnote")) {
                str5 = jSONObject.optString("footnote");
            }
            publishMoodInfo.mFootnote = str5;
            if (jSONObject.has(QAdVrReportParams.ParamKey.MEDIA) && !TextUtils.isEmpty(jSONObject.getString(QAdVrReportParams.ParamKey.MEDIA))) {
                ArrayList<PublishMoodInfo.MediaInfo> arrayList = new ArrayList<>();
                JSONArray jSONArray = jSONObject.getJSONArray(QAdVrReportParams.ParamKey.MEDIA);
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    if (jSONObject2.has("type") && jSONObject2.has("path")) {
                        String string = jSONObject2.getString("type");
                        String string2 = jSONObject2.getString("path");
                        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                            PublishMoodInfo.MediaInfo mediaInfo = new PublishMoodInfo.MediaInfo();
                            if (iMiniAppContext != null) {
                                mediaInfo.mPath = ((IMiniAppFileManager) iMiniAppContext.getManager(IMiniAppFileManager.class)).getAbsolutePath(string2);
                            }
                            if ("photo".equalsIgnoreCase(string)) {
                                mediaInfo.mType = 1;
                                arrayList.add(mediaInfo);
                            } else if ("video".equalsIgnoreCase(string)) {
                                mediaInfo.mType = 2;
                                arrayList.add(mediaInfo);
                            }
                        }
                        QLog.i("ChannelProxyImpl", 2, "invalid mediaItem, " + jSONObject2);
                    }
                    QLog.i("ChannelProxyImpl", 2, "invalid mediaItem, " + jSONObject2);
                }
                publishMoodInfo.mMediaInfo = arrayList;
            }
        } catch (Exception e16) {
            QLog.i("ChannelProxyImpl", 1, "parseJsonToMoodInfo error " + str, e16);
        }
        return publishMoodInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(AsyncMultiObjResult asyncMultiObjResult, DialogInterface dialogInterface, int i3) {
        if (asyncMultiObjResult != null) {
            asyncMultiObjResult.onReceiveResult(false, dialogInterface, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(AsyncMultiObjResult asyncMultiObjResult, DialogInterface dialogInterface, int i3) {
        if (asyncMultiObjResult != null) {
            asyncMultiObjResult.onReceiveResult(true, dialogInterface, null);
        }
    }

    private String p(int i3) {
        if (i3 == 0) {
            return "image";
        }
        if (i3 != 1 && i3 != 2) {
            return "file";
        }
        return QAdVrReportParams.ParamKey.MEDIA;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void downloadQQBrowser(String str) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getSDKOpenKeyToken(COMM.StCommonExt stCommonExt, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void setUserAppTop(MiniAppInfo miniAppInfo, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getUserAppInfo(COMM.StCommonExt stCommonExt, ArrayList<String> arrayList, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void launchSubMsgPermissionSettingFragment(Activity activity, Intent intent, int i3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getGdtAd(String str, int i3, String str2, String str3, String str4, HashMap<String, String> hashMap, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getGdtAdInfo(String str, int i3, String str2, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void setUserAppLike(boolean z16, COMM.StCommonExt stCommonExt, String str, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void getContentAccelerate(String str, String str2, int i3, Map<String, String> map, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
    public void springHbReport(String str, int i3, int i16, Map<String, String> map, String str2) {
    }
}

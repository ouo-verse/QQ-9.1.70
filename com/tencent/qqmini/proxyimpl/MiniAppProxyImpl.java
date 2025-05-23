package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.image.URLDrawable;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationMiniApp;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationMiniApp;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationMiniApp;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI;
import com.tencent.mobileqq.mini.appbrand.ui.MiniAppWebviewFragment;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.config.united.MiniConfigParser;
import com.tencent.mobileqq.mini.manager.MiniAppDetainManager;
import com.tencent.mobileqq.mini.out.activity.MapActivity;
import com.tencent.mobileqq.mini.report.InnerAppReportDc4239;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdBundleListener;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.servlet.MiniAppGetPrivacyDetailServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetRoleGroupInfoServlet;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil;
import com.tencent.mobileqq.minigame.config.MiniGamePallasConfig;
import com.tencent.mobileqq.minigame.report.MiniGameCrashReporter;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minigame.utils.PathUtil;
import com.tencent.mobileqq.minigame.utils.QQMiniAppUtils;
import com.tencent.mobileqq.minispecial.api.IThirdPartyMiniApi;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.webview.swift.utils.m;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.proxyimpl.ShortcutUtils;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.AppThemeInfo;
import com.tencent.qqmini.sdk.launcher.core.model.PrivacyDetailInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.ui.MoreItem;
import com.tencent.qqmini.sdk.launcher.ui.MoreItemList;
import com.tencent.qqmini.sdk.launcher.ui.OnAppCloseAction;
import com.tencent.qqmini.sdk.launcher.ui.OnMoreItemSelectedListener;
import com.tencent.qqmini.sdk.plugins.ImageJsPlugin;
import com.tencent.qqmini.sdk.plugins.MapJsPlugin;
import com.tencent.qqmini.sdk.utils.DebugHelper;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QUA;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

@ProxyService(proxy = MiniAppProxy.class)
/* loaded from: classes34.dex */
public class MiniAppProxyImpl extends MiniAppProxy {

    /* renamed from: n, reason: collision with root package name */
    private static boolean f347398n;

    /* renamed from: d, reason: collision with root package name */
    private MiniAppConfig f347402d;

    /* renamed from: a, reason: collision with root package name */
    private boolean f347399a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f347400b = 1;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<IMiniAppContext> f347401c = null;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<Integer> f347403e = new ArrayList<Integer>() { // from class: com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.1
        {
            add(1044);
            add(1007);
            add(1008);
            add(2003);
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private Handler f347404f = new Handler(Looper.getMainLooper(), new i());

    /* renamed from: g, reason: collision with root package name */
    private BroadcastReceiver f347405g = null;

    /* renamed from: h, reason: collision with root package name */
    private MiniAppInfo f347406h = null;

    /* renamed from: i, reason: collision with root package name */
    private MiniAppConfig f347407i = null;

    /* renamed from: j, reason: collision with root package name */
    private String f347408j = null;

    /* renamed from: k, reason: collision with root package name */
    private String f347409k = null;

    /* renamed from: l, reason: collision with root package name */
    private String f347410l = null;

    /* renamed from: m, reason: collision with root package name */
    private DownloadListener f347411m = new DownloadListener() { // from class: com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.18
        @Override // com.tencent.open.downloadnew.DownloadListener
        public void installSucceed(String str, String str2) {
            if (MiniAppProxyImpl.this.f347409k == null || MiniAppProxyImpl.this.f347410l == null || !MiniAppProxyImpl.this.f347409k.equals(str) || !MiniAppProxyImpl.this.f347410l.equals(str2)) {
                return;
            }
            QLog.d("MiniAppProxyImpl", 1, "installSucceed: " + str + "; pkgname : " + str2);
            InnerAppReportDc4239.innerAppReport(MiniAppProxyImpl.this.f347407i, null, "launchapp", "installapp", "qqdownload");
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadCancel(DownloadInfo downloadInfo) {
            if (MiniAppProxyImpl.this.f347408j == null || downloadInfo == null || !MiniAppProxyImpl.this.f347408j.equals(downloadInfo.f341186f)) {
                return;
            }
            QLog.d("MiniAppProxyImpl", 1, "onDownloadCancel");
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadError(DownloadInfo downloadInfo, int i3, String str, int i16) {
            if (MiniAppProxyImpl.this.f347408j == null || downloadInfo == null || !MiniAppProxyImpl.this.f347408j.equals(downloadInfo.f341186f)) {
                return;
            }
            QLog.d("MiniAppProxyImpl", 1, "onDownloadError");
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadFinish(DownloadInfo downloadInfo) {
            if (MiniAppProxyImpl.this.f347408j == null || downloadInfo == null || !MiniAppProxyImpl.this.f347408j.equals(downloadInfo.f341186f)) {
                return;
            }
            QLog.d("MiniAppProxyImpl", 1, "onDownloadFinish");
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.18.1
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(BaseApplication.getContext(), "\u4e0b\u8f7d\u5b8c\u6210", 1).show();
                }
            });
            InnerAppReportDc4239.innerAppReport(MiniAppProxyImpl.this.f347407i, null, "launchapp", "downloadappfinish", "qqdownload");
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadPause(DownloadInfo downloadInfo) {
            if (MiniAppProxyImpl.this.f347408j == null || downloadInfo == null || !MiniAppProxyImpl.this.f347408j.equals(downloadInfo.f341186f)) {
                return;
            }
            QLog.d("MiniAppProxyImpl", 1, "onDownloadPause");
            InnerAppReportDc4239.innerAppReport(MiniAppProxyImpl.this.f347407i, null, "launchapp", "downloadapppause", "qqdownload");
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadWait(DownloadInfo downloadInfo) {
            if (MiniAppProxyImpl.this.f347408j == null || downloadInfo == null || !MiniAppProxyImpl.this.f347408j.equals(downloadInfo.f341186f)) {
                return;
            }
            QLog.d("MiniAppProxyImpl", 1, "onDownloadWait");
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadUpdate(List<DownloadInfo> list) {
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void packageReplaced(String str, String str2) {
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void uninstallSucceed(String str, String str2) {
        }
    };

    /* loaded from: classes34.dex */
    class d extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347428a;

        d(AsyncResult asyncResult) {
            this.f347428a = asyncResult;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra(MiniConst.MiniAppProxyImplConst.MINI_APP_SCAN_DATA_RESULT);
            String stringExtra2 = intent.getStringExtra(MiniConst.MiniAppProxyImplConst.MINI_APP_SCAN_RESULT_TYPE);
            QLog.d("MiniAppProxyImpl", 2, "scanResult: " + stringExtra + "----scan_type: " + stringExtra2);
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("result", stringExtra);
                jSONObject2.put("scanType", stringExtra2);
                jSONObject2.put("rawData", com.tencent.open.base.g.d(stringExtra));
                jSONObject2.put("charSet", "utf-8");
                jSONObject.put("detail", jSONObject2);
                jSONObject.put("result", stringExtra);
                jSONObject.put("scanType", stringExtra2);
                jSONObject.put("rawData", com.tencent.open.base.g.d(stringExtra));
                jSONObject.put("charSet", "utf-8");
                this.f347428a.onReceiveResult(true, jSONObject);
                context.unregisterReceiver(MiniAppProxyImpl.this.f347405g);
            } catch (Exception e16) {
                QLog.e("MiniAppProxyImpl", 1, "scan result error." + e16);
            }
            MiniAppProxyImpl.this.f347405g = null;
        }
    }

    /* loaded from: classes34.dex */
    class f extends SosoInterfaceOnLocationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f347432a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f347433b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347434c;

        /* JADX WARN: Removed duplicated region for block: B:16:0x0051 A[Catch: JSONException -> 0x006e, TryCatch #1 {JSONException -> 0x006e, blocks: (B:6:0x000b, B:9:0x001c, B:11:0x0022, B:13:0x0028, B:14:0x003b, B:16:0x0051, B:17:0x0059, B:21:0x0031), top: B:5:0x000b }] */
        @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            if (i3 == 0 && sosoLbsInfo != null) {
                SosoLocation sosoLocation = sosoLbsInfo.mLocation;
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (this.f347432a) {
                        double d16 = sosoLocation.mLat84;
                        if (d16 != 0.0d && sosoLocation.mLon84 != 0.0d) {
                            jSONObject.put("latitude", d16);
                            jSONObject.put("longitude", sosoLocation.mLon84);
                            jSONObject.put("speed", sosoLocation.speed);
                            jSONObject.put("accuracy", sosoLocation.accuracy);
                            if (this.f347433b) {
                                jSONObject.put("altitude", sosoLocation.altitude);
                            }
                            jSONObject.put("verticalAccuracy", 0.0d);
                            jSONObject.put("horizontalAccuracy", sosoLocation.accuracy);
                            this.f347434c.onReceiveResult(true, jSONObject);
                            return;
                        }
                    }
                    jSONObject.put("latitude", sosoLocation.mLat02);
                    jSONObject.put("longitude", sosoLocation.mLon02);
                    jSONObject.put("speed", sosoLocation.speed);
                    jSONObject.put("accuracy", sosoLocation.accuracy);
                    if (this.f347433b) {
                    }
                    jSONObject.put("verticalAccuracy", 0.0d);
                    jSONObject.put("horizontalAccuracy", sosoLocation.accuracy);
                    this.f347434c.onReceiveResult(true, jSONObject);
                    return;
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("MiniAppProxyImpl", 2, e16, new Object[0]);
                    }
                    this.f347434c.onReceiveResult(false, new JSONObject());
                    return;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("errCode", i3);
            } catch (JSONException e17) {
                QLog.e("MiniAppProxyImpl", 1, "getLocationJsonObject exception:", e17);
            }
            this.f347434c.onReceiveResult(false, jSONObject2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(int i3, boolean z16, boolean z17, long j3, boolean z18, boolean z19, String str, boolean z26, boolean z27, AsyncResult asyncResult) {
            super(i3, z16, z17, j3, z18, z19, str);
            this.f347432a = z26;
            this.f347433b = z27;
            this.f347434c = asyncResult;
        }
    }

    /* loaded from: classes34.dex */
    class h implements IActivityResultListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IActivityResultManager f347439a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MiniAppProxy.IAppUpdateListener f347440b;

        h(IActivityResultManager iActivityResultManager, MiniAppProxy.IAppUpdateListener iAppUpdateListener) {
            this.f347439a = iActivityResultManager;
            this.f347440b = iAppUpdateListener;
        }

        @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
        public boolean doOnActivityResult(int i3, int i16, Intent intent) {
            String str;
            this.f347439a.removeActivityResultListener(this);
            if (i3 == 1003) {
                if (i16 == -1 && intent != null) {
                    boolean booleanExtra = intent.getBooleanExtra("getUpgradeInfo", true);
                    if (booleanExtra) {
                        str = "\u6700\u65b0\u7248\u672c\u65e0\u9700\u66f4\u65b0";
                    } else {
                        QLog.d("MiniAppProxyImpl", 1, "getUpgradeInfo: " + booleanExtra);
                        str = "\u83b7\u53d6\u7248\u672c\u4fe1\u606f\u5931\u8d25";
                    }
                    this.f347440b.onGetAppUpdateResult(booleanExtra, str);
                } else {
                    this.f347440b.onGetAppUpdateResult(true, "\u7248\u672c\u8fc7\u4f4e\u9700\u8981\u66f4\u65b0");
                }
            }
            return true;
        }
    }

    /* loaded from: classes34.dex */
    class i implements Handler.Callback {
        i() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            String str;
            if (message != null) {
                IMiniAppContext G = MiniAppProxyImpl.this.G();
                if (G == null) {
                    QLog.e("MiniAppProxyImpl", 1, "handleMessage error, MiniAppContext is null.");
                    return false;
                }
                int i3 = message.what;
                if (i3 == 2) {
                    G.performAction(ActionBridge.ShareActionBridge.obtain(1, null));
                } else if (i3 == 3) {
                    MiniAppInfo miniAppInfo = G.getMiniAppInfo();
                    if (miniAppInfo == null) {
                        return false;
                    }
                    if (DebugUtil.getDebugEnabled(miniAppInfo)) {
                        DebugUtil.setDebugEnabled(miniAppInfo, false);
                    } else {
                        DebugUtil.setDebugEnabled(miniAppInfo, true);
                    }
                    MiniAppProxyImpl.D(G);
                } else if (i3 != 1000) {
                    switch (i3) {
                        case 5:
                            MiniAppProxyImpl.f347398n = ActionBridge.UpdateUIActionBridge.toggleMonitorPanel(G).booleanValue();
                            break;
                        case 6:
                            G.performAction(ActionBridge.ShareActionBridge.obtain(2, null));
                            break;
                        case 7:
                            G.performAction(ActionBridge.ShareActionBridge.obtain(3, null));
                            break;
                        case 8:
                            G.performAction(ActionBridge.ShareActionBridge.obtain(4, null));
                            break;
                        case 9:
                            MiniAppInfo miniAppInfo2 = G.getMiniAppInfo();
                            if (miniAppInfo2 != null) {
                                miniAppInfo2.topType = miniAppInfo2.topType == 0 ? 1 : 0;
                                MiniAppProxyImpl.W(miniAppInfo2);
                                MiniAppProxyImpl miniAppProxyImpl = MiniAppProxyImpl.this;
                                if (miniAppInfo2.topType == 1) {
                                    str = "settop_on";
                                } else {
                                    str = "settop_off";
                                }
                                miniAppProxyImpl.U(G, str);
                                break;
                            } else {
                                return false;
                            }
                        default:
                            switch (i3) {
                                case 11:
                                    Activity attachActivity = G.getAttachActivity();
                                    if (attachActivity != null && G.getMiniAppInfo() != null) {
                                        try {
                                            ShortcutUtils.f(attachActivity, G.getMiniAppInfo());
                                        } catch (Exception e16) {
                                            QLog.e("MiniAppProxyImpl", 1, "addShortcut error", e16);
                                        }
                                        MiniAppProxyImpl.this.U(G, "add_desktop");
                                        break;
                                    }
                                    break;
                                case 12:
                                    aq.n(G, true);
                                    break;
                                case 13:
                                    G.performAction(ActionBridge.ShareActionBridge.obtain(5, message.getData()));
                                    break;
                                case 14:
                                    MiniAppInfo miniAppInfo3 = G.getMiniAppInfo();
                                    if (miniAppInfo3 != null && miniAppInfo3.isEngineTypeMiniApp()) {
                                        PageGestureProxy pageGestureProxy = (PageGestureProxy) AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
                                        if (pageGestureProxy instanceof at) {
                                            MiniAppProxyImpl.this.H(((at) pageGestureProxy).g());
                                            break;
                                        }
                                    } else {
                                        if (!(G.getAttachActivity() instanceof GameActivity1)) {
                                            return false;
                                        }
                                        MiniAppProxyImpl.this.H(((GameActivity1) G.getAttachActivity()).getColorNoteController());
                                        break;
                                    }
                                    break;
                                case 15:
                                    MiniAppInfo miniAppInfo4 = G.getMiniAppInfo();
                                    if (miniAppInfo4 != null && ((IThirdPartyMiniApi) QRoute.api(IThirdPartyMiniApi.class)).isMiniThirdPartyEngine(miniAppInfo4) && (G.getAttachActivity() instanceof GameActivity1)) {
                                        ((GameActivity1) G.getAttachActivity()).restart();
                                        break;
                                    } else {
                                        G.performAction(ActionBridge.RestartActionBridge.obtain());
                                        break;
                                    }
                                    break;
                                case 16:
                                    MiniAppProxyImpl.this.X(G);
                                    break;
                                case 17:
                                    MiniAppProxyImpl.this.A(G);
                                    break;
                                case 18:
                                    G.performAction(ActionBridge.FavoritesActionBridge.obtain(1, null));
                                    break;
                                case 19:
                                    G.performAction(ActionBridge.ExportLogFileBridge.obtain());
                                    break;
                                case 20:
                                    G.performAction(ActionBridge.ShareActionBridge.obtain(8, null));
                                    break;
                                case 21:
                                    G.performAction(ActionBridge.ScreenRecordBridge.obtain(1));
                                    break;
                                case 22:
                                    G.performAction(ActionBridge.ScreenRecordBridge.obtain(2));
                                    break;
                                case 23:
                                    G.performAction(ActionBridge.ScreenRecordBridge.obtain(4));
                                    break;
                                case 24:
                                    Bundle data = message.getData();
                                    if (data != null) {
                                        MiniAppProxyImpl.this.c0(data.getString("miniAppID"));
                                        break;
                                    }
                                    break;
                            }
                    }
                } else {
                    MiniAppProxyImpl.this.B();
                }
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.e("MiniAppProxyImpl", 1, "handleMessage error, msg is null.");
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class j implements Action<Object> {
        j() {
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
        public Object perform(BaseRuntime baseRuntime) {
            AppLoaderFactory.g().getAppBrandProxy().onAppDestroy(baseRuntime.getMiniAppInfo(), null);
            return null;
        }
    }

    /* loaded from: classes34.dex */
    class m implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f347448a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MiniAppProxy.GetStringCallback f347449b;

        m(String str, MiniAppProxy.GetStringCallback getStringCallback) {
            this.f347448a = str;
            this.f347449b = getStringCallback;
        }

        @Override // sd2.a
        public void onFail(String str) {
            QLog.e("MiniAppProxyImpl", 1, "getPskey onFail msg = " + str);
            this.f347449b.onResult(str);
        }

        @Override // sd2.a
        public void onSuccess(Map<String, String> map) {
            String str = map.get(this.f347448a);
            if (TextUtils.isEmpty(str)) {
                QLog.e("MiniAppProxyImpl", 1, "getPskey onSuccess but pskey is null");
                str = "";
            }
            this.f347449b.onResult(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(IMiniAppContext iMiniAppContext) {
        QLog.d("MiniAppProxyImpl", 1, MiniChatConstants.MINI_APP_ADD_TO_CURRENT_TROOP);
        try {
            MiniAppInfo miniAppInfo = iMiniAppContext.getMiniAppInfo();
            TroopApplicationListUtil.addMiniAppToTroopApplicationList(String.valueOf(miniAppInfo.launchParam.entryModel.uin), miniAppInfo.appId, (String) null);
        } catch (Exception e16) {
            QLog.e("MiniAppProxyImpl", 1, "addToCurrentTroop exception: " + Log.getStackTraceString(e16));
        }
    }

    private void C(Activity activity, String str, String str2, String str3, String str4) {
        this.f347408j = str4;
        this.f347409k = str;
        this.f347410l = str2;
        Bundle bundle = new Bundle();
        bundle.putString(com.tencent.open.downloadnew.e.f341493b, str);
        bundle.putString(com.tencent.open.downloadnew.e.f341501j, str4);
        bundle.putString(com.tencent.open.downloadnew.e.f341497f, str2);
        bundle.putInt(com.tencent.open.downloadnew.e.f341502k, 2);
        bundle.putString(com.tencent.open.downloadnew.e.f341500i, "MiniApp");
        bundle.putString(com.tencent.open.downloadnew.e.f341503l, str3);
        bundle.putInt(com.tencent.open.downloadnew.e.J, 1);
        DownloadApi.o(this.f347411m);
        DownloadApi.d(activity, bundle, "biz_src_miniapp", null, 0);
        QQToast.makeText(activity, "\u5f00\u59cb\u4e0b\u8f7d", 1).show();
        InnerAppReportDc4239.innerAppReport(this.f347407i, null, "launchapp", "downloadapp", "qqdownload");
    }

    public static void D(IMiniAppContext iMiniAppContext) {
        iMiniAppContext.performAction(new j());
        E(iMiniAppContext.getAttachActivity());
        SystemMethodProxy.killProcess(Process.myPid());
    }

    private static boolean E(Activity activity) {
        List<ActivityManager.AppTask> appTasks;
        Intent intent;
        Intent intent2;
        Intent intent3;
        Intent intent4;
        try {
            ActivityManager activityManager = (ActivityManager) activity.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager == null || (appTasks = activityManager.getAppTasks()) == null) {
                return false;
            }
            for (ActivityManager.AppTask appTask : appTasks) {
                if (appTask != null && appTask.getTaskInfo() != null) {
                    intent = appTask.getTaskInfo().baseIntent;
                    if (intent != null) {
                        intent2 = appTask.getTaskInfo().baseIntent;
                        if (intent2.getComponent() != null) {
                            QLog.e("miniapp", 1, "will finish and remove task: id=" + appTask.getTaskInfo().id);
                            intent3 = appTask.getTaskInfo().baseIntent;
                            if (!intent3.getComponent().getClassName().equals(activity.getClass().getName())) {
                                intent4 = appTask.getTaskInfo().baseIntent;
                                if (intent4.getComponent().getClassName().equals(activity.getClass().getName())) {
                                }
                            }
                            appTask.finishAndRemoveTask();
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            QLog.e("miniapp", 1, "finishAndRemoveAllTasks exception.");
            return false;
        }
    }

    private int F(IColorNoteController iColorNoteController) {
        if (iColorNoteController.shouldDisplayColorNote()) {
            return iColorNoteController.isColorNoteExist() ? 2 : 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IMiniAppContext G() {
        WeakReference<IMiniAppContext> weakReference = this.f347401c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private boolean I() {
        MiniGamePallasConfig miniGamePallasConfig;
        IMiniAppContext G = G();
        if (!(G instanceof BaseRuntime)) {
            return false;
        }
        BaseRuntime baseRuntime = (BaseRuntime) G;
        if (baseRuntime instanceof GameRuntime) {
            GameRuntime gameRuntime = (GameRuntime) baseRuntime;
            if (gameRuntime.isYunGameRuntime().booleanValue()) {
                return true;
            }
            if (gameRuntime.getEnginePackage() != null && gameRuntime.getEnginePackage().getIsConfigPkg() && (miniGamePallasConfig = (MiniGamePallasConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGamePallasConfig.CONFIG_ID)) != null) {
                boolean enableRecordScreen = miniGamePallasConfig.getEnableRecordScreen();
                QLog.d("MiniAppProxyImpl", 1, "config Pkg enable record screen:" + enableRecordScreen);
                return !enableRecordScreen;
            }
        }
        return false;
    }

    private boolean K() {
        ShareState recordShareState;
        IMiniAppContext G = G();
        return (G instanceof BaseRuntime) && (recordShareState = ((BaseRuntime) G).getRecordShareState()) != null && recordShareState.launchFrom == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N(String str, MiniAppProxy.GetPrivacyInfoListener getPrivacyInfoListener, boolean z16, Bundle bundle) {
        PrivacyDetailInfo privacyDetailInfo = new PrivacyDetailInfo();
        privacyDetailInfo.setId(str);
        privacyDetailInfo.setWebUrl(bundle.getString("url"));
        privacyDetailInfo.setPrivacyTitle(bundle.getString("title"));
        privacyDetailInfo.setPermissionName(bundle.getString(MiniAppGetPrivacyDetailServlet.KEY_AUTHORITY_NAME));
        privacyDetailInfo.setServiceTermsName(bundle.getString(MiniAppGetPrivacyDetailServlet.KEY_SERVICE_TERMS_NAME));
        privacyDetailInfo.setServiceTermsUrl(bundle.getString(MiniAppGetPrivacyDetailServlet.KEY_SERVICE_TERMS_URL));
        boolean z17 = bundle.getBoolean("show");
        QLog.i("MiniAppProxyImpl", 2, "getPrivacyDetail isSuc:" + z16 + ",privacyDetailInfo" + privacyDetailInfo);
        getPrivacyInfoListener.onResult(z16, z17, privacyDetailInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(MiniAppProxy.GetUserRoleGroupListener getUserRoleGroupListener, boolean z16, Bundle bundle) {
        JSONObject jSONObject;
        String string = bundle.getString(MiniAppGetRoleGroupInfoServlet.KEY_ROLEGROUPINFO);
        QLog.i("MiniAppProxyImpl", 2, "getRoleGroupInfoList isSuc:" + z16 + ",getRoleGroupInfoList" + string);
        try {
            if (!z16) {
                jSONObject = new JSONObject();
                jSONObject.put("errCode", bundle.get("retCode"));
                jSONObject.put("errMsg", bundle.get("errMsg"));
            } else {
                jSONObject = new JSONObject(string);
            }
            getUserRoleGroupListener.onResult(z16, jSONObject);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Q(AsyncResult asyncResult, EIPCResult eIPCResult) {
        JSONObject jSONObject = new JSONObject();
        if (eIPCResult != null) {
            try {
                if (eIPCResult.isSuccess()) {
                    jSONObject.put("IsGroupMember", eIPCResult.data.getBoolean("IsGroupMember"));
                    asyncResult.onReceiveResult(true, jSONObject);
                    QLog.i("MiniAppProxyImpl", 1, "IsGroupMember callServer" + jSONObject);
                }
            } catch (JSONException e16) {
                QLog.e("MiniAppProxyImpl", 1, "IsGroupMember callServer callback error!", e16);
                return;
            }
        }
        if (eIPCResult != null) {
            jSONObject.put("errorCode", eIPCResult.data.get("errorCode"));
            jSONObject.put("errorMsg", eIPCResult.data.get("errorMsg"));
            asyncResult.onReceiveResult(false, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(Bundle bundle, final MiniAppInfo miniAppInfo) {
        QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_QUERY_MINI_APP_DATA, bundle, new EIPCResultCallback() { // from class: com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.11
            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
                MiniAppProxyImpl.this.f347404f.removeCallbacksAndMessages(1000);
                if (eIPCResult != null) {
                    QLog.d("MiniAppProxyImpl", 1, "onMoreClick onCallback code : " + eIPCResult.code);
                    if (eIPCResult.code == 0) {
                        Bundle bundle2 = eIPCResult.data;
                        int i3 = bundle2.getInt(MiniChatConstants.MINI_APP_TOP_TYPE);
                        ArrayList<Integer> integerArrayList = bundle2.getIntegerArrayList("backHomeSceneList");
                        if (integerArrayList != null && integerArrayList.size() > 0) {
                            MiniAppProxyImpl.this.f347403e.clear();
                            MiniAppProxyImpl.this.f347403e.addAll(integerArrayList);
                        }
                        MiniAppInfo miniAppInfo2 = miniAppInfo;
                        if (miniAppInfo2 != null) {
                            miniAppInfo2.topType = i3;
                        }
                    }
                }
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniAppProxyImpl.this.B();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(IMiniAppContext iMiniAppContext) {
        this.f347402d = aq.h(iMiniAppContext.getMiniAppInfo());
        QLog.i("MiniAppProxyImpl", 1, "synchConvertSDK2QQConfig");
    }

    private void T(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packageName", str2);
        bundle.putString("appId", str);
        bundle.putString("big_brother_source_key", "biz_src_miniapp");
        if (context instanceof BasePluginActivity) {
            AppClient.l(((BasePluginActivity) context).getOutActivity(), bundle);
            InnerAppReportDc4239.innerAppReport(this.f347407i, null, "launchapp", "downloadapp", "yybdownload");
        } else if (context instanceof Activity) {
            AppClient.l((Activity) context, bundle);
            InnerAppReportDc4239.innerAppReport(this.f347407i, null, "launchapp", "downloadapp", "yybdownload");
        } else {
            QLog.e("MiniAppProxyImpl", 2, "onOpenThridApp mContext \u5fc5\u73b0\u662f\u4e00\u4e2aActivity");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(IMiniAppContext iMiniAppContext, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MiniAppConfig miniAppConfig = this.f347402d;
        if (miniAppConfig == null) {
            miniAppConfig = aq.h(iMiniAppContext.getMiniAppInfo());
        }
        MiniAppConfig miniAppConfig2 = miniAppConfig;
        MiniProgramLpReportDC04239.reportUserClick(miniAppConfig2, MiniProgramLpReportDC04239.getAppType(miniAppConfig2), ActionBridge.PageActionBridge.getPageUrl(iMiniAppContext), "user_click", "more_button", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(IMiniAppContext iMiniAppContext, Bundle bundle) {
        String string;
        MiniAppConfig miniAppConfig = this.f347402d;
        if (miniAppConfig == null) {
            miniAppConfig = aq.h(iMiniAppContext.getMiniAppInfo());
        }
        int i3 = bundle != null ? bundle.getInt("key_mini_app_share_chat_type", -1) : -1;
        if (bundle == null) {
            string = "";
        } else {
            string = bundle.getString("key_mini_app_share_chat_uin");
        }
        MiniAppReportManager.reportMiniGameFastShareClick(miniAppConfig, i3, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(IMiniAppContext iMiniAppContext) {
        if (iMiniAppContext != null && iMiniAppContext.getAttachActivity() != null) {
            QLog.d("MiniAppProxyImpl", 1, "setMiniAppToTroopApplicationList");
            IActivityResultManager activityResultManager = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
            activityResultManager.addActivityResultListener(new k(activityResultManager, iMiniAppContext));
            Intent intent = new Intent(iMiniAppContext.getAttachActivity(), (Class<?>) TroopActivity.class);
            intent.putExtra("onlyOneSegement", true);
            intent.putExtra("_key_mode", 0);
            intent.putExtra(AppConstants.Key.IS_SELECT_TROOP, true);
            intent.putExtra("key_from", 3);
            iMiniAppContext.getAttachActivity().startActivityForResult(intent, 1002);
            return;
        }
        QLog.e("MiniAppProxyImpl", 1, "setMiniAppToTroopApplicationList, miniAppContext is null.");
    }

    private boolean Z(MiniAppInfo miniAppInfo) {
        if (J(miniAppInfo)) {
            return miniAppInfo.launchParam.entryModel.isAdmin;
        }
        return false;
    }

    private boolean a0(MiniAppInfo miniAppInfo) {
        AppMode appMode;
        if (!AppNetConnInfo.isMobileConn()) {
            QLog.i("MiniAppProxyImpl", 1, "shouldShowKingCardTip network type is wifi + " + AppNetConnInfo.isWifiConn());
            return false;
        }
        if (!((miniAppInfo == null || (appMode = miniAppInfo.appMode) == null || !appMode.isWangKa) ? false : true)) {
            QLog.i("MiniAppProxyImpl", 1, "shouldShowKingCardTip\uff0c not wangka app");
            return false;
        }
        int a16 = com.tencent.mobileqq.vip.e.a();
        QLog.i("MiniAppProxyImpl", 1, "shouldShowKingCardTip\uff0c king card status = " + a16);
        return a16 == 1;
    }

    private boolean b0(MiniAppInfo miniAppInfo) {
        if (((IThirdPartyMiniApi) QRoute.api(IThirdPartyMiniApi.class)).isMiniThirdPartyEngine(miniAppInfo)) {
            return false;
        }
        return !J(miniAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MiniAppCmdUtil.getInstance().setGameBoxOptions(str, true, new MiniAppCmdInterface() { // from class: com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.3
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                QLog.i("MiniAppProxyImpl", 1, "enableGameBoxFloat: appId=$appId, result=$isSuccess");
                if (z16) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((IMiniAppService) QRoute.api(IMiniAppService.class)).enableGameBoxView(str);
                        }
                    });
                }
            }
        });
    }

    public void B() {
        boolean z16;
        IMiniAppContext G = G();
        if (G == null) {
            return;
        }
        Activity attachActivity = G.getAttachActivity();
        boolean z17 = attachActivity instanceof GameActivity1;
        if (this.f347399a) {
            return;
        }
        if (K()) {
            d0();
            return;
        }
        ShareState shareState = (ShareState) G.performAction(ActionBridge.GetShareStateActionBridge.obtain());
        if (shareState == null) {
            QLog.e("MiniAppProxyImpl", 1, "doShowShareView shareState is null!");
            return;
        }
        MiniAppInfo miniAppInfo = G.getMiniAppInfo();
        boolean isLimitedAccessApp = miniAppInfo.isLimitedAccessApp();
        boolean z18 = false;
        if (miniAppInfo.isEngineTypeMiniGame()) {
            z16 = shareState.showRestart && QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_capsule_show_restart_btn", 1) == 1;
        } else {
            z16 = shareState.showRestart;
        }
        if (z17) {
            IColorNoteController colorNoteController = ((GameActivity1) attachActivity).getColorNoteController();
            if (!isLimitedAccessApp && colorNoteController != null) {
                this.f347400b = F(colorNoteController);
            } else {
                this.f347400b = 0;
                QLog.w("MiniAppProxyImpl", 1, "do not add colorNote. isLimit=" + isLimitedAccessApp + ", colorNote=" + colorNoteController);
            }
        } else {
            PageGestureProxy pageGestureProxy = (PageGestureProxy) AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
            if (pageGestureProxy instanceof at) {
                IColorNoteController g16 = ((at) pageGestureProxy).g();
                if (!isLimitedAccessApp && g16 != null) {
                    this.f347400b = F(g16);
                }
            }
        }
        Intent intent = new Intent();
        intent.putExtra("miniAppID", miniAppInfo.appId);
        intent.putExtra(MiniChatConstants.MINI_APP_NAME, miniAppInfo.name);
        intent.putExtra(MiniChatConstants.MINI_APP_IS_MINI_GAME, miniAppInfo.isEngineTypeMiniGame());
        intent.putExtra(MiniChatConstants.MINI_APP_SCREEN_RECORD_STATUS, miniAppInfo.recordStatus);
        intent.putExtra(MiniChatConstants.MINI_APP_OPEN_MONITOR, f347398n);
        intent.putExtra(MiniChatConstants.MINI_APP_DEBUG_ENABLE, DebugHelper.d().c(miniAppInfo.appId));
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_DEBUG, shareState.showDebug);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_MONITOR, shareState.showMonitor);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_EXPORT_LOG, z17 && shareState.showDebug);
        intent.putExtra(MiniChatConstants.MINI_APP_MENU_STYLE, AppLoaderFactory.g().getMiniAppEnv().getMenuStyle());
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_QQ, shareState.withShareQQ);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_QZONE, shareState.withShareQzone);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_WECHAT_FRIENDS, shareState.withShareWeChatFriend);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_WECHAT_MOMENT, shareState.withShareWeChatMoment);
        intent.putExtra(MiniChatConstants.MINI_APP_TOP_TYPE, miniAppInfo.topType);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_DETAIL, true);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_SETTING, !((IThirdPartyMiniApi) QRoute.api(IThirdPartyMiniApi.class)).isMiniThirdPartyEngine(miniAppInfo));
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_COMPLAINT, true);
        intent.putExtra(MiniChatConstants.MINI_APP_ADD_SHORTCUT, true);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_BACK_HOME, -1);
        intent.putExtra(MiniChatConstants.KEY_MINI_APP_IS_SPECIAL, miniAppInfo.isSpecialMiniApp());
        intent.putExtra(MiniChatConstants.MINI_APP_DISABLE_ADD_TO_MYAPP, miniAppInfo.appMode.disableAddToMyApp);
        intent.putExtra(MiniChatConstants.MINI_APP_DISABLE_ADD_TO_MYFAVOR, miniAppInfo.appMode.disableAddToMyFavor);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_KINGCARD_TIP, a0(miniAppInfo));
        intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_TYPE, 1);
        intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_NEED_ACTION_SHEET, true);
        intent.putExtra("key_color_note", this.f347400b);
        intent.putExtra(MiniChatConstants.KEY_MINI_APP_IS_GAME, z17);
        intent.putExtra(MiniChatConstants.KEY_MINI_APP_VERSION_TYPE, miniAppInfo.verType);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_FAVORITE, true);
        intent.putExtra(MiniChatConstants.MINI_APP_IS_LIMITED_ACCESS, isLimitedAccessApp);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_RESTART_MINIAPP, z16);
        intent.putExtra(MiniChatConstants.MINI_APP_SET_TO_TROOP, b0(miniAppInfo));
        intent.putExtra(MiniChatConstants.MINI_APP_ADD_TO_CURRENT_TROOP, Z(miniAppInfo));
        intent.putExtra(MiniChatConstants.MINI_APP_DISABLE_RECORD, I());
        MiniAppConfig miniAppConfig = this.f347402d;
        if (miniAppConfig != null) {
            intent.putExtra("key_mini_app_config", miniAppConfig);
            QLog.i("MiniAppProxyImpl", 1, "use preload qqConfig!");
        } else {
            intent.putExtra("key_mini_app_config", aq.h(miniAppInfo));
            QLog.i("MiniAppProxyImpl", 1, "loading qqConfig!");
        }
        if (miniAppInfo.isEngineTypeMiniApp()) {
            intent.putExtra(MiniChatConstants.MINI_APP_BG_TRANSPARENT, true);
        }
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.o()) {
            intent.putExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_DATALINE, true);
        }
        boolean isShowGuildTabCached = ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTabCached();
        boolean z19 = shareState.withShareGuild;
        if (isShowGuildTabCached && z19) {
            z18 = true;
        }
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_GUILD, z18);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_ENABLE_GAME_BOX, shareState.isShowGameBoxFloatEnable);
        IActivityResultManager activityResultManager = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
        activityResultManager.addActivityResultListener(new c(activityResultManager));
        MiniChatActivity.W2(attachActivity, intent, ActivityResultManager.ACTION_REQUEST_PERMISSION);
        QLog.d("MiniAppProxyImpl", 1, "set isMiniMsgTabShow true");
        this.f347399a = true;
        U(G, "open");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean addShortcut(Context context, MiniAppInfo miniAppInfo, AsyncResult asyncResult) {
        ShortcutUtils.g((Activity) context, miniAppInfo, new e(asyncResult));
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean chooseLocation(Context context, AsyncResult asyncResult) {
        IActivityResultManager activityResultManager = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
        activityResultManager.addActivityResultListener(new g(asyncResult, activityResultManager));
        Intent intent = new Intent(context, (Class<?>) MapActivity.class);
        intent.putExtra("key_type", 2);
        ((BaseActivity) context).startActivityForResult(intent, 3);
        return true;
    }

    public void d0() {
        IMiniAppContext G = G();
        if (G == null || this.f347399a) {
            return;
        }
        Activity attachActivity = G.getAttachActivity();
        MiniAppInfo miniAppInfo = G.getMiniAppInfo();
        if (G instanceof BaseRuntime) {
            ShareState recordShareState = ((BaseRuntime) G).getRecordShareState();
            Intent intent = new Intent();
            intent.putExtra("miniAppID", miniAppInfo.appId);
            intent.putExtra(MiniChatConstants.MINI_APP_NAME, miniAppInfo.name);
            intent.putExtra(MiniChatConstants.MINI_APP_ICON_URL, miniAppInfo.iconUrl);
            intent.putExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_QQ, recordShareState.withShareQQ);
            intent.putExtra(MiniChatConstants.MINI_APP_SCREEN_RECORD_SHARE_2_TINY_WORLD, recordShareState.withShareTinyWorld);
            intent.putExtra(MiniChatConstants.MINI_APP_SCREEN_RECORD_SAVE_2_LOCAL, recordShareState.save2Local);
            intent.putExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_QZONE, recordShareState.withShareQzone);
            intent.putExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_WECHAT_FRIENDS, recordShareState.withShareWeChatFriend);
            intent.putExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_WECHAT_MOMENT, recordShareState.withShareWeChatMoment);
            intent.putExtra(MiniChatConstants.MINI_APP_DISABLE_ADD_TO_MYFAVOR, recordShareState.showFavorites);
            intent.putExtra("videoPath", miniAppInfo.recordVideoPath);
            intent.putExtra(MiniChatConstants.MINI_APP_SCREEN_RECORD_LAUNCH_FROM, 2);
            intent.putExtra(MiniChatConstants.MINI_APP_DISABLE_ADD_TO_MYAPP, miniAppInfo.appMode.disableAddToMyApp);
            intent.putExtra(MiniChatConstants.MINI_APP_SHOW_CHAT_NEWS_LIST, false);
            if (miniAppInfo.isEngineTypeMiniApp()) {
                intent.putExtra(MiniChatConstants.MINI_APP_BG_TRANSPARENT, true);
            }
            intent.putExtra(MiniChatConstants.MINI_APP_SHOW_RESTART_MINIAPP, false);
            intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_NEED_ACTION_SHEET, true);
            IActivityResultManager activityResultManager = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
            activityResultManager.addActivityResultListener(new b(activityResultManager));
            MiniChatActivity.W2(attachActivity, intent, 9529);
            recordShareState.launchFrom = 0;
            this.f347399a = true;
            QLog.d("MiniAppProxyImpl", 1, "set isMiniMsgTabShow true");
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean downloadApp(Context context, MiniAppInfo miniAppInfo, String str, String str2, String str3, String str4) {
        this.f347406h = miniAppInfo;
        this.f347407i = aq.h(miniAppInfo);
        if (!TextUtils.isEmpty(str4)) {
            QLog.d("MiniAppProxyImpl", 1, "\u624bQ\u4e0b\u8f7d");
            C((Activity) context, str, str2, str3, str4);
        } else {
            QLog.d("MiniAppProxyImpl", 1, "\u5e94\u7528\u5b9d\u5fae\u4e0b\u8f7d");
            T(context, str, str2);
        }
        return true;
    }

    public void e0(IMiniAppContext iMiniAppContext) {
        int i3;
        String str;
        this.f347404f.sendEmptyMessageDelayed(1000, 500L);
        final MiniAppInfo miniAppInfo = iMiniAppContext.getMiniAppInfo();
        if (miniAppInfo != null) {
            i3 = miniAppInfo.verType;
            str = miniAppInfo.appId;
        } else {
            i3 = 3;
            str = null;
        }
        final Bundle bundle = new Bundle();
        bundle.putString("appid", str);
        bundle.putInt("verType", i3);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ak
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppProxyImpl.this.R(bundle, miniAppInfo);
            }
        }, 128, null, true);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean enterQRCode(Context context, boolean z16, AsyncResult asyncResult) {
        BaseActivity baseActivity = (BaseActivity) context;
        if (!com.tencent.mobileqq.activity.recent.l.g(baseActivity)) {
            asyncResult.onReceiveResult(false, null);
            return true;
        }
        Intent intent = new Intent();
        intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, baseActivity.getString(R.string.button_back));
        intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, baseActivity.getString(R.string.button_back));
        intent.putExtra("start_time", System.currentTimeMillis());
        intent.putExtra("from", "mini_app");
        if (z16) {
            intent.putExtra("hide_album", true);
        }
        intent.setFlags(67108864);
        BroadcastReceiver broadcastReceiver = this.f347405g;
        if (broadcastReceiver != null) {
            try {
                baseActivity.unregisterReceiver(broadcastReceiver);
            } catch (Exception e16) {
                QLog.e("MiniAppProxyImpl", 1, "unregisterReceiver error." + e16);
            }
            this.f347405g = null;
        }
        this.f347405g = new d(asyncResult);
        baseActivity.registerReceiver(this.f347405g, new IntentFilter(MiniConst.MiniAppProxyImplConst.MINI_APP_SCAN_RESULT), "com.tencent.msg.permission.pushnotify", null);
        RouteUtils.startActivity(baseActivity, intent, "/qrscan/scanner");
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void getA2(MiniAppProxy.GetA2InfoCallback getA2InfoCallback) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            QLog.e("MiniAppProxyImpl", 1, "getA2 appRuntime is null!");
        } else {
            getA2(runtime.getAccount(), getA2InfoCallback);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getAccount() {
        return BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getAmsAppId() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getAppId() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getAppName() {
        return "qq";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public AppThemeInfo getAppThemeInfo() {
        return new AppThemeInfo(FontSettingManager.getFontScale(), FontSettingManager.getFontLevel(), ThemeUtil.isNowThemeIsNight(null, false, null));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void getAppUpdate(Activity activity, MiniAppProxy.IAppUpdateListener iAppUpdateListener) {
        IActivityResultManager activityResultManager = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
        activityResultManager.addActivityResultListener(new h(activityResultManager, iAppUpdateListener));
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) UpgradeActivity.class);
        intent.putExtra("activity_type", 4096);
        activity.startActivityForResult(intent, 1003);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getAppVersion() {
        return AppSetting.f99551k + "." + AppSetting.f99542b;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public int getClipboardInterval() {
        cu3.b bVar = QQMiniAppUtils.getConfig().f391863d;
        QLog.e("MiniAppProxyImpl", 2, " getClipboardInterval : " + bVar.f391865b);
        return bVar.f391865b;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public MiniAppProxy.DeviceType getDeviceType() {
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.TABLET) {
            return MiniAppProxy.DeviceType.TABLET;
        }
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.FOLD) {
            return MiniAppProxy.DeviceType.FOLD;
        }
        return MiniAppProxy.DeviceType.PHONE;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public Drawable getDrawable(Context context, String str, int i3, int i16, Drawable drawable) {
        return getDrawable(context, str, i3, i16, drawable, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean getLocation(Context context, String str, boolean z16, AsyncResult asyncResult) {
        ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new f(0, true, true, 5000L, false, false, "miniApp", TextUtils.isEmpty(str) || str.equals(MapJsPlugin.LOCATION_TYPE_84), z16, asyncResult));
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public int getLoginType() {
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void getMiniAppPrivacyInfo(final String str, String str2, final MiniAppProxy.GetPrivacyInfoListener getPrivacyInfoListener) {
        QLog.i("MiniAppProxyImpl", 2, "getMiniAppPrivacyInfo appId = " + str);
        MiniAppCmdUtil.getInstance().getPrivacyInfo(str, str2, new MiniAppCmdBundleListener() { // from class: com.tencent.qqmini.proxyimpl.al
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdBundleListener
            public final void onResult(boolean z16, Bundle bundle) {
                MiniAppProxyImpl.N(str, getPrivacyInfoListener, z16, bundle);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public OnMoreItemSelectedListener getMoreItemSelectedListener() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public ArrayList<MoreItem> getMoreItems(MoreItemList.Builder builder) {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getNickName() {
        return BaseApplicationImpl.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + BaseApplicationImpl.getApplication().getRuntime().getAccount());
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getPayAccessToken() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public int getPayMode() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_pay_by_h5", 0) == 0 ? 2 : 1;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getPayOpenId() {
        return BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getPayOpenKey() {
        return "";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getPlatformId() {
        return MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getPlatformQUA() {
        return QUA.getQUA3();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void getPskey(String str, MiniAppProxy.GetStringCallback getStringCallback) {
        if (BaseApplicationImpl.getApplication().getRuntime() == null) {
            getStringCallback.onResult("");
            return;
        }
        IPskeyManager iPskeyManager = (IPskeyManager) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IPskeyManager.class, "all");
        if (iPskeyManager == null) {
            QLog.e("MiniAppProxyImpl", 2, "pskeyManager is null");
            getStringCallback.onResult("");
        } else {
            iPskeyManager.getPskey(new String[]{str}, new m(str, getStringCallback));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getQImei16() {
        return com.tencent.mobileqq.statistics.o.b();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getQImei36() {
        return com.tencent.mobileqq.statistics.o.c();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public JSONObject getQQMCConfig(String str) {
        MiniConfigParser.Config config = (MiniConfigParser.Config) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(str);
        if (config == null) {
            config = new MiniConfigParser.Config();
        }
        return config.getConfig();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void getRoleGroupInfoList(String str, final MiniAppProxy.GetUserRoleGroupListener getUserRoleGroupListener) {
        QLog.i("MiniAppProxyImpl", 2, "getRoleGroupInfoList appId = " + str);
        MiniAppCmdUtil.getInstance().getRoleGroupInfo(str, new MiniAppCmdBundleListener() { // from class: com.tencent.qqmini.proxyimpl.ai
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdBundleListener
            public final void onResult(boolean z16, Bundle bundle) {
                MiniAppProxyImpl.O(MiniAppProxy.GetUserRoleGroupListener.this, z16, bundle);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getSoPath() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public int getTbsVersion() {
        return QbSdk.getTbsVersion(BaseApplicationImpl.getApplication());
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getUin() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            return "";
        }
        return runtime.getCurrentUin();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean hasTbsInitDone() {
        return com.tencent.mobileqq.webview.swift.utils.m.e();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void initTbs(final MiniAppProxy.InitTbsCallback initTbsCallback) {
        com.tencent.mobileqq.webview.swift.utils.m.h(new m.a() { // from class: com.tencent.qqmini.proxyimpl.am
            @Override // com.tencent.mobileqq.webview.swift.utils.m.a
            public final void a() {
                MiniAppProxyImpl.P(MiniAppProxy.InitTbsCallback.this);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean isDebugVersion() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean isFolderScreenOpenMode(Context context) {
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.FOLD) {
            return HippyUtils.isFolderScreenOpenMode(BaseApplication.getContext());
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean isGrayVersion() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void isGroupMember(String str, String str2, final AsyncResult asyncResult) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Bundle bundle = new Bundle();
            bundle.putString("appId", str);
            bundle.putString("openGid", str2);
            QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_CHECK_IS_GROUP_MEMBER, bundle, new EIPCResultCallback() { // from class: com.tencent.qqmini.proxyimpl.aj
                @Override // eipc.EIPCResultCallback
                public final void onCallback(EIPCResult eIPCResult) {
                    MiniAppProxyImpl.Q(AsyncResult.this, eIPCResult);
                }
            });
            QLog.d("MiniAppProxyImpl", 1, "IsGroupMember appId:" + str + "openGroupId:" + str2);
            return;
        }
        QLog.e("MiniAppProxyImpl", 1, "IsGroupMember appId or openGroupId is empty!");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean isInnerMode() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("miniapp_tencent_video_inner_mode_switch", false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean isPreloadApkgState() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("miniapp_preload_apkg_switch", false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean isPublicVersion() {
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean isShortcutExist(Context context, MiniAppInfo miniAppInfo) {
        return ShortcutUtils.s((Activity) context, miniAppInfo);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean isSplitView(Context context) {
        return w.a(context);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean isUseWebViewTryLockOrRecreateFile() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("miniapp_webivew_use_lock_switch", false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void muteAudioFocus(Context context, boolean z16) {
        QQAudioUtils.i(context, z16);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public OnAppCloseAction onAppClose(MiniAppInfo miniAppInfo, Closeable closeable) {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean onCapsuleButtonMoreClick(IMiniAppContext iMiniAppContext) {
        QLog.d("MiniAppProxyImpl", 1, "onCapsuleButtonMoreClick");
        if (iMiniAppContext == null) {
            QLog.w("MiniAppProxyImpl", 1, "miniRuntime is null, no need to response more button");
            return false;
        }
        this.f347401c = new WeakReference<>(iMiniAppContext);
        Activity attachActivity = iMiniAppContext.getAttachActivity();
        if (attachActivity != null && !attachActivity.isFinishing()) {
            MiniAppInfo miniAppInfo = iMiniAppContext.getMiniAppInfo();
            if (miniAppInfo == null) {
                QLog.w("MiniAppProxyImpl", 1, "MiniAppInfo is null, no need to response more button");
                return false;
            }
            ShareState shareState = (ShareState) iMiniAppContext.performAction(ActionBridge.GetShareStateActionBridge.obtain());
            if (miniAppInfo.verType != 3) {
                shareState.showDebug = true;
                shareState.showMonitor = true;
            }
            if (QzoneConfig.getInstance().getConfig("qqminiapp", WnsConfig.MINI_APP_SHARE_TO_WX_SWITCHER, 1) != 1) {
                shareState.withShareWeChatFriend = false;
                shareState.withShareWeChatMoment = false;
            }
            e0(iMiniAppContext);
            return true;
        }
        QLog.w("MiniAppProxyImpl", 1, "Activity is not exiting, no need to response more button");
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean openImagePreview(Context context, int i3, List<String> list) {
        Intent intent = new Intent(context, (Class<?>) TroopAvatarWallPreviewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("index", i3);
        bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, (ArrayList) list);
        bundle.putBoolean("needBottomBar", false);
        bundle.putBoolean("is_show_action", true);
        bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_IS_NOT_SHOW_INDEX, true);
        bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_NEED_TO_AIO, false);
        bundle.putBoolean("is_from_plugin", true);
        intent.putExtras(bundle);
        intent.addFlags(603979776);
        context.startActivity(intent);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean openLocation(Context context, double d16, double d17, int i3, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) MapActivity.class);
        intent.putExtra("key_type", 1);
        intent.putExtra("latitude", d16);
        intent.putExtra("longitude", d17);
        intent.putExtra("scale", i3);
        intent.putExtra("name", str);
        intent.putExtra("address", str2);
        context.startActivity(intent);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean openSchema(Context context, String str, int i3, ResultReceiver resultReceiver) {
        if (MiniAppLauncher.isMiniAppScheme(str) && i3 != -1) {
            MiniAppLauncher.startMiniApp(context, str, i3, null);
            return true;
        }
        if (context != null) {
            Intent intent = new Intent(context, (Class<?>) AppBrandLaunchUI.class);
            intent.setFlags(402653184);
            intent.putExtra("from", "SchemeJsPlugin");
            intent.putExtra(ZPlanPublishSource.FROM_SCHEME, str);
            intent.putExtra("result_receiver", resultReceiver);
            context.startActivity(intent);
        }
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void sendRequestByMsf(byte[] bArr, String str, MiniAppProxy.SenderListener senderListener) {
        MiniAppCmdUtil.getInstance().sendRequestByMsf(bArr, str, senderListener);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void sendShareInfoToGroup(IMiniAppContext iMiniAppContext, long j3) {
        if (iMiniAppContext != null && 0.0f != ((float) j3)) {
            Bundle bundle = new Bundle();
            bundle.putString("key_mini_app_share_chat_uin", String.valueOf(j3));
            bundle.putInt("key_mini_app_share_chat_type", 1);
            iMiniAppContext.performAction(ActionBridge.ShareActionBridge.obtain(5, bundle));
            if (QLog.isColorLevel()) {
                QLog.i("MiniAppProxyImpl", 1, "sendShareInfoToGroup uin:" + j3);
                return;
            }
            return;
        }
        QLog.e("MiniAppProxyImpl", 1, "sendShareInfoToGroup miniAppContext is null or uin is null!");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean startBrowserActivity(Context context, Intent intent) {
        intent.setComponent(new ComponentName(context, (Class<?>) QQBrowserActivity.class));
        intent.putExtra("fragmentClass", MiniAppWebviewFragment.class);
        context.startActivity(intent);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean verifyFile(int i3, String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class l implements MainTicketCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MiniAppProxy.GetA2InfoCallback f347446a;

        l(MiniAppProxy.GetA2InfoCallback getA2InfoCallback) {
            this.f347446a = getA2InfoCallback;
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int i3, String str) {
            this.f347446a.onFail(i3, str);
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(MainTicketInfo mainTicketInfo) {
            if (mainTicketInfo != null) {
                this.f347446a.onSuccess(mainTicketInfo.getA2(), mainTicketInfo.getD2().toString(), mainTicketInfo.getD2Key().toString());
            } else {
                QLog.e("MiniAppProxyImpl", 1, "getA2 onSuccess MainTicketInfo is null!");
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public Drawable getDrawable(Context context, String str, int i3, int i16, Drawable drawable, boolean z16) {
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mPlayGifImage = true;
            obtain.mUseApngImage = z16;
            obtain.mKeyAddWHSuffix = false;
            obtain.mRequestWidth = i3;
            obtain.mRequestHeight = i16;
            obtain.mFailedDrawable = drawable;
            obtain.mLoadingDrawable = drawable;
            if (PathUtil.isNetworkUrl(str)) {
                try {
                    URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
                    if (drawable2.getStatus() != 1) {
                        drawable2.startDownload();
                    }
                    return drawable2;
                } catch (IllegalStateException e16) {
                    QLog.e("MiniAppProxyImpl", 1, " getDrawable error!", e16);
                    return drawable;
                }
            }
            return URLDrawable.getFileDrawable(str, obtain);
        } catch (NullPointerException e17) {
            QLog.e("MiniAppProxyImpl", 1, " getDrawable = " + e17.getMessage());
            return drawable;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public byte[] getLoginSig() {
        return new byte[0];
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public float getQQDensity(Context context) {
        if (context == null) {
            QLog.d("MiniAppProxyImpl", 1, "default density: 3.0");
            return 3.0f;
        }
        float scale = context.getResources().getDisplayMetrics().density / GlobalDisplayMetricsManager.getScale();
        QLog.d("MiniAppProxyImpl", 1, "getQQDensity: " + scale);
        return scale;
    }

    /* loaded from: classes34.dex */
    class e implements ShortcutUtils.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347430a;

        e(AsyncResult asyncResult) {
            this.f347430a = asyncResult;
        }

        @Override // com.tencent.qqmini.proxyimpl.ShortcutUtils.c
        public void a(int i3, String str) {
            if (i3 == 0) {
                this.f347430a.onReceiveResult(true, null);
            } else {
                this.f347430a.onReceiveResult(false, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(IColorNoteController iColorNoteController) {
        if (iColorNoteController != null) {
            if (!iColorNoteController.isColorNoteExist()) {
                if (iColorNoteController.canAddColorNote()) {
                    iColorNoteController.insertColorNote();
                    return;
                } else {
                    iColorNoteController.onCannotAdd();
                    return;
                }
            }
            if (iColorNoteController.isColorNoteExist()) {
                iColorNoteController.deleteColorNote();
            }
        }
    }

    private boolean J(MiniAppInfo miniAppInfo) {
        LaunchParam launchParam;
        return (miniAppInfo == null || (launchParam = miniAppInfo.launchParam) == null || launchParam.entryModel == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P(MiniAppProxy.InitTbsCallback initTbsCallback) {
        if (initTbsCallback != null) {
            initTbsCallback.onTbsInitFinish();
        }
    }

    public static void W(final MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.e("MiniAppProxyImpl", 1, "sendSetUserAppTopRequest, miniAppInfo = " + miniAppInfo);
                return;
            }
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("appid", miniAppInfo.appId);
        bundle.putInt(MiniChatConstants.MINI_APP_TOP_TYPE, miniAppInfo.topType);
        bundle.putInt("verType", miniAppInfo.verType);
        QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_SYNC_MINI_APP_DATA, bundle, new EIPCResultCallback() { // from class: com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.6
            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
                if (eIPCResult == null || eIPCResult.code != -100) {
                    MiniAppProxyImpl.Y(MiniAppInfo.this);
                } else {
                    AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MiniAppInfo miniAppInfo2 = MiniAppInfo.this;
                            if (miniAppInfo2 != null) {
                                miniAppInfo2.topType = 0;
                            }
                            if (MiniAppConfProcessor.m()) {
                                QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.qqStr(R.string.k7n) + MiniAppConfProcessor.d() + HardCodeUtil.qqStr(R.string.k7m), 0).show();
                                return;
                            }
                            QQToast.makeText(BaseApplicationImpl.getApplication(), "\u6700\u591a\u4ec5\u652f\u6301\u7f6e\u987610\u4e2a\u5c0f\u7a0b\u5e8f", 0).show();
                        }
                    });
                }
            }
        });
    }

    public void L(Context context, String str) {
        if (str != null && !TextUtils.isEmpty(str) && str.length() >= 5) {
            TroopUtils.I(context, com.tencent.mobileqq.troop.utils.aq.b(str, 5), 2);
        } else {
            QLog.e("MiniAppProxyImpl", 1, "uin is null");
        }
    }

    public void M(Context context, String str) {
        if (str != null && !TextUtils.isEmpty(str) && str.length() >= 5) {
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, IPublicAccountDetailActivity.ROUTE_NAME);
            activityURIRequest.extra().putString("uin", str);
            QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
            return;
        }
        QLog.e("MiniAppProxyImpl", 1, "uin is null");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getLocation(Context context) {
        SosoLocation sosoLocation;
        StringBuilder sb5 = new StringBuilder();
        SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("miniapp");
        if (cachedLbsInfo != null && (sosoLocation = cachedLbsInfo.mLocation) != null) {
            sb5.append(String.valueOf(sosoLocation.mLat02));
            sb5.append('*');
            sb5.append(String.valueOf(cachedLbsInfo.mLocation.mLon02));
        }
        return sb5.toString();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void loadImage(Context context, ImageView imageView, String str, int i3, int i16, Drawable drawable, Drawable drawable2) {
        if (imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        QQPicLoader.f201806a.e(Option.obtain().setUrl(str).setTargetView(imageView).setRequestWidth(i3).setRequestHeight(i16).setLoadingDrawable(drawable).setFailDrawable(drawable2), null);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean openChoosePhotoActivity(Context context, int i3, MiniAppProxy.IChoosePhotoListner iChoosePhotoListner) {
        if (context == null) {
            context = BaseApplication.getContext();
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_URI);
        activityURIRequest.extra().putInt(IPhotoLogicFactory.ENTER_FROM, 4);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationMiniApp.H);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, AlbumListCustomizationMiniApp.f184372j);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationMiniApp.H);
        activityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", i3);
        activityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", false);
        activityURIRequest.extra().putInt(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 6);
        activityURIRequest.extra().putString(PeakConstants.DEST_BROADCAST_ACTION_NAME, ImageJsPlugin.ACTION_CHOOSE_IMAGE);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, true);
        QRoute.startUri(activityURIRequest);
        QAlbumUtil.anim((Activity) context, false, true);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void setDrawableCallback(Drawable drawable, MiniAppProxy.IDrawableLoadedCallBack iDrawableLoadedCallBack) {
        if (drawable == null || !(drawable instanceof URLDrawable)) {
            return;
        }
        ((URLDrawable) drawable).setURLDrawableListener(new a(iDrawableLoadedCallBack));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void synchConvertSDK2QQConfig(final IMiniAppContext iMiniAppContext) {
        if (iMiniAppContext != null && iMiniAppContext.getMiniAppInfo() != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ah
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppProxyImpl.this.S(iMiniAppContext);
                }
            }, 64, null, false);
        } else {
            QLog.i("MiniAppProxyImpl", 1, "synchConvertSDK2QQConfig miniAppContext or getMiniAppInfo is null!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class k implements IActivityResultListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IActivityResultManager f347443a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IMiniAppContext f347444b;

        k(IActivityResultManager iActivityResultManager, IMiniAppContext iMiniAppContext) {
            this.f347443a = iActivityResultManager;
            this.f347444b = iMiniAppContext;
        }

        @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
        public boolean doOnActivityResult(int i3, int i16, Intent intent) {
            if (i3 == 1002) {
                this.f347443a.removeActivityResultListener(this);
            }
            if (i3 == 1002 && i16 == -1) {
                String stringExtra = intent.getStringExtra("uin");
                QLog.d("MiniAppProxyImpl", 1, "group uin: " + stringExtra + ", group name: " + intent.getStringExtra("uinname"));
                TroopApplicationListUtil.addMiniAppToTroopApplicationList(stringExtra, this.f347444b.getMiniAppInfo().appId, (String) null);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Y(final MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            QLog.e("MiniAppProxyImpl", 1, "setMiniAppTop, miniAppInfo = null.");
        } else {
            MiniAppCmdUtil.getInstance().setUserAppTop(miniAppInfo.appId, miniAppInfo.topType, miniAppInfo.verType, null, new MiniAppCmdInterface() { // from class: com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.7
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public void onCmdListener(boolean z16, JSONObject jSONObject) {
                    if (z16) {
                        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (MiniAppInfo.this.topType == 1) {
                                    QQToast.makeText(BaseApplicationImpl.getApplication(), R.string.w6t, 0).show();
                                } else {
                                    QQToast.makeText(BaseApplicationImpl.getApplication(), R.string.w6u, 0).show();
                                }
                            }
                        });
                        QLog.d("MiniAppProxyImpl", 2, "sendSetUserAppTopRequest, success to set top");
                    } else {
                        QLog.e("MiniAppProxyImpl", 1, "sendSetUserAppTopRequest, fail to set top");
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void getA2(String str, MiniAppProxy.GetA2InfoCallback getA2InfoCallback) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            QLog.e("MiniAppProxyImpl", 1, "getA2 appRuntime is null!");
            return;
        }
        TicketManager ticketManager = (TicketManager) runtime.getManager(2);
        if (ticketManager == null) {
            QLog.e("MiniAppProxyImpl", 1, "getA2 manager is null!");
        } else if (getA2InfoCallback == null) {
            QLog.e("MiniAppProxyImpl", 1, "getA2 getA2InfoCallback is null!");
        } else {
            ticketManager.getA2(Long.parseLong(str), 16, new l(getA2InfoCallback));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void onAppStateChange(MiniAppInfo miniAppInfo, int i3) {
        MiniGameCrashReporter.onAppStateChange(miniAppInfo == null ? null : miniAppInfo.appId, i3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean onCapsuleButtonCloseClick(IMiniAppContext iMiniAppContext, DialogInterface.OnClickListener onClickListener) {
        if (iMiniAppContext == null) {
            return false;
        }
        Activity attachActivity = iMiniAppContext.getAttachActivity();
        MiniAppInfo miniAppInfo = iMiniAppContext.getMiniAppInfo();
        if (attachActivity == null || miniAppInfo == null) {
            return false;
        }
        String appName = getAppName();
        if ("qq".equalsIgnoreCase(appName) || "qi".equalsIgnoreCase(appName) || "ssq".equalsIgnoreCase(appName)) {
            return MiniAppDetainManager.INSTANCE.handleOnCloseBtnClick(attachActivity, iMiniAppContext, miniAppInfo, onClickListener);
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean openNativePage(Context context, String str, String str2, String str3) {
        if (context == null) {
            return true;
        }
        if (str2 == null || TextUtils.isEmpty(str2) || str2.length() < 5) {
            return false;
        }
        if (str3.equals(VipFunCallConstants.KEY_GROUP)) {
            L(context, str2);
            return true;
        }
        if (!str3.equals(SearchConfig.ENGINE_PUBLIC_ACCOUNT)) {
            return true;
        }
        M(context, str2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class b implements IActivityResultListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IActivityResultManager f347424a;

        b(IActivityResultManager iActivityResultManager) {
            this.f347424a = iActivityResultManager;
        }

        @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
        public boolean doOnActivityResult(int i3, int i16, Intent intent) {
            if (i3 != 9529) {
                return false;
            }
            this.f347424a.removeActivityResultListener(this);
            QLog.d("MiniAppProxyImpl", 1, "set isMiniMsgTabShow false");
            MiniAppProxyImpl.this.f347399a = false;
            IMiniAppContext iMiniAppContext = (IMiniAppContext) MiniAppProxyImpl.this.f347401c.get();
            if (iMiniAppContext != null) {
                iMiniAppContext.performAction(ActionBridge.ScreenRecordBridge.obtain(1001));
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class c implements IActivityResultListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IActivityResultManager f347426a;

        c(IActivityResultManager iActivityResultManager) {
            this.f347426a = iActivityResultManager;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:18:0x01cd  */
        @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean doOnActivityResult(int i3, int i16, Intent intent) {
            String str;
            IMiniAppContext G;
            if (i3 != 9527) {
                return false;
            }
            this.f347426a.removeActivityResultListener(this);
            QLog.d("MiniAppProxyImpl", 1, "set isMiniMsgTabShow false");
            MiniAppProxyImpl.this.f347399a = false;
            if (i16 != -1) {
                QLog.w("MiniAppProxyImpl", 1, "onShareActivityResult, resultCode not Activity.RESULT_OK, but " + i16);
                return true;
            }
            int intExtra = intent.getIntExtra(MiniChatConstants.CLICK_ID, -1);
            if (intExtra != 25) {
                switch (intExtra) {
                    case -1:
                        str = "cancel";
                        break;
                    case 0:
                        str = "cancel_system";
                        break;
                    case 1:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(2);
                        break;
                    case 2:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(3);
                        break;
                    case 3:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(5);
                        break;
                    case 4:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(4);
                        str = "about";
                        break;
                    case 5:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(6);
                        str = "share_QZ";
                        break;
                    case 6:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(7);
                        str = "share_WX";
                        break;
                    case 7:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(8);
                        str = "share_Moments";
                        break;
                    case 8:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(9);
                        break;
                    case 9:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(10);
                        str = "back_home";
                        break;
                    case 10:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(11);
                        break;
                    case 11:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(12);
                        break;
                    case 12:
                        Message message = new Message();
                        message.what = 13;
                        message.setData(intent.getExtras());
                        MiniAppProxyImpl.this.f347404f.sendMessage(message);
                        IMiniAppContext G2 = MiniAppProxyImpl.this.G();
                        if (G2 != null) {
                            MiniAppProxyImpl.this.V(G2, intent.getExtras());
                            break;
                        }
                        break;
                    case 13:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(14);
                        if (MiniAppProxyImpl.this.f347400b == 1) {
                            str = MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_ADD_FOLDER;
                            break;
                        } else {
                            str = MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_REMOVE_FOLDER;
                            break;
                        }
                    case 14:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(15);
                        str = "restart";
                        break;
                    case 15:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(16);
                        str = MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_QUN_SET;
                        break;
                    case 16:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(17);
                        break;
                    case 17:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(18);
                        str = MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_FAV;
                        break;
                    case 18:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(19);
                        break;
                    case 19:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(20);
                        str = MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_SHARE_CHANNEL;
                        break;
                    case 20:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(21);
                        break;
                    case 21:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(22);
                        break;
                    case 22:
                        MiniAppProxyImpl.this.f347404f.sendEmptyMessage(23);
                        break;
                }
                G = MiniAppProxyImpl.this.G();
                if (G != null) {
                    MiniAppProxyImpl.this.U(G, str);
                    ActionBridge.UpdateUIActionBridge.updateRedDot(G);
                }
                return true;
            }
            Message obtain = Message.obtain(MiniAppProxyImpl.this.f347404f, 24);
            obtain.setData(intent.getExtras());
            MiniAppProxyImpl.this.f347404f.sendMessage(obtain);
            str = "";
            G = MiniAppProxyImpl.this.G();
            if (G != null) {
            }
            return true;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void changeNavIcon(ImageView imageView, ImageView imageView2) {
        if (imageView != null) {
            imageView.setImageResource(R.drawable.qui_chevron_left);
        }
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.qui_hometown);
        }
    }

    /* loaded from: classes34.dex */
    class g implements IActivityResultListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347436a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IActivityResultManager f347437b;

        g(AsyncResult asyncResult, IActivityResultManager iActivityResultManager) {
            this.f347436a = asyncResult;
            this.f347437b = iActivityResultManager;
        }

        @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
        public boolean doOnActivityResult(int i3, int i16, Intent intent) {
            QLog.d("MiniAppProxyImpl", 2, "doOnActivityResult requestCode=" + i3 + ",resultCode=" + i16 + ",data=" + intent);
            if (i3 != 3) {
                return false;
            }
            if (i16 == -1 && intent != null) {
                String stringExtra = intent.getStringExtra("name");
                String stringExtra2 = intent.getStringExtra("address");
                double intExtra = intent.getIntExtra("latitude", 0) / 1000000.0d;
                double intExtra2 = intent.getIntExtra("longitude", 0) / 1000000.0d;
                if (QLog.isColorLevel()) {
                    QLog.d("MiniAppProxyImpl", 2, "doOnActivityResult name=" + stringExtra + ",address=" + stringExtra2 + ",latitude=" + intExtra + ",longitude=" + intExtra2);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", stringExtra);
                    jSONObject.put("address", stringExtra2);
                    jSONObject.put("latitude", intExtra);
                    jSONObject.put("longitude", intExtra2);
                    this.f347436a.onReceiveResult(true, jSONObject);
                } catch (JSONException e16) {
                    QLog.e("MiniAppProxyImpl", 1, " error, ", e16);
                    this.f347436a.onReceiveResult(false, new JSONObject());
                }
            }
            this.f347437b.removeActivityResultListener(this);
            return true;
        }
    }

    /* loaded from: classes34.dex */
    class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MiniAppProxy.IDrawableLoadedCallBack f347422d;

        a(MiniAppProxy.IDrawableLoadedCallBack iDrawableLoadedCallBack) {
            this.f347422d = iDrawableLoadedCallBack;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            this.f347422d.onLoadSuccessed(uRLDrawable);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void notifyMiniAppInfo(int i3, MiniAppInfo miniAppInfo) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void sendData(byte[] bArr, MiniAppProxy.SenderListener senderListener) {
    }
}

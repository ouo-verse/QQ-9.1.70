package com.tencent.gamecenter.wadl.api.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.LruCache;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.component.media.MtpConstants;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameDLReportService;
import com.tencent.gamecenter.wadl.api.IQQGameDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGameProviderService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService;
import com.tencent.gamecenter.wadl.api.WadlRequest;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlGameCenterTaskMgr;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.gamecenter.api.IYunGameManagerService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nl0.h;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.qqgame.QQGameCheckDownload$CheckURLResponse;
import tencent.im.qqgame.QQGameCheckDownload$DownloadRemind;
import tencent.im.qqgame.QQGameCheckDownload$InstallTipRsp;
import tencent.im.qqgame.QQGameCheckDownload$ReplacementURL;
import tencent.im.qqgame.QQGameCheckDownload$SsoCheckCustomAPKRsp;
import tencent.im.qqgame.QQGameIntercept$CheckRsp;
import tencent.im.qqgame.QQGameIntercept$Download;
import tencent.im.qqgame.UserGameVersionPB$QueryGameChannelRsp;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QQGameDownloadServiceImpl implements IQQGameDownloadService, h {
    private static final String TAG = "Wadl_QQGameDownloadServiceImpl";
    private CopyOnWriteArrayList<WadlProxyServiceCallBackInterface> callbacks;
    private volatile AtomicBoolean isRelease = new AtomicBoolean(false);
    HashSet<String> cmds = new HashSet<>();
    HashSet<String> cmdTrpcMap = new HashSet<>();
    kl0.b simpleDBHelper = new kl0.b();
    LruCache<String, WadlParams> waitInstallMap = new LruCache<>(6);
    private WadlTrpcListener trpcListener = new a();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements WadlTrpcListener {
        a() {
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            return QQGameDownloadServiceImpl.this.cmdTrpcMap;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00ec A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00ed  */
        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
            boolean z16;
            PBBytesField pBBytesField;
            UserGameVersionPB$QueryGameChannelRsp userGameVersionPB$QueryGameChannelRsp;
            if (!WadlProxyConsts.CMD_CHECK_INSTALL_CHANNEL.equals(str)) {
                return;
            }
            int intExtra = intent.getIntExtra("actionFrom", 0);
            if (intExtra != 4 && intExtra != 5) {
                return;
            }
            String stringExtra = intent.getStringExtra("appid");
            String stringExtra2 = intent.getStringExtra("packageName");
            String stringExtra3 = intent.getStringExtra(WadlProxyConsts.CHANNEL);
            String str2 = "";
            if (j3 == 0 && trpcInovkeRsp != null && (pBBytesField = trpcInovkeRsp.data) != null && pBBytesField.get() != null) {
                try {
                    userGameVersionPB$QueryGameChannelRsp = new UserGameVersionPB$QueryGameChannelRsp();
                    userGameVersionPB$QueryGameChannelRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    z16 = userGameVersionPB$QueryGameChannelRsp.is_gamecenter_channel.get();
                } catch (Throwable th5) {
                    th = th5;
                    z16 = true;
                }
                try {
                    str2 = userGameVersionPB$QueryGameChannelRsp.reason.get();
                } catch (Throwable th6) {
                    th = th6;
                    QLog.e(QQGameDownloadServiceImpl.TAG, 1, "onCheckInstallChannel error:" + th);
                    QLog.d(QQGameDownloadServiceImpl.TAG, 1, "onCheckInstallChannel ret=" + j3 + MttLoader.QQBROWSER_PARAMS_FROME + intExtra + ",appId=" + stringExtra + ",channel=" + stringExtra3 + ",pkgName=" + stringExtra2 + ",isGameCenterChannel=" + z16 + ",reason=" + str2);
                    if (z16) {
                    }
                }
            } else {
                QLog.w(QQGameDownloadServiceImpl.TAG, 1, "onCheckInstallChannel fail, appId=" + stringExtra + ",ret=" + j3);
                z16 = true;
            }
            QLog.d(QQGameDownloadServiceImpl.TAG, 1, "onCheckInstallChannel ret=" + j3 + MttLoader.QQBROWSER_PARAMS_FROME + intExtra + ",appId=" + stringExtra + ",channel=" + stringExtra3 + ",pkgName=" + stringExtra2 + ",isGameCenterChannel=" + z16 + ",reason=" + str2);
            if (z16) {
                return;
            }
            if (intExtra != 5) {
                ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).checkInstallChannel(5, 1, stringExtra, stringExtra2, stringExtra3);
            } else {
                QQGameDownloadServiceImpl.this.doAppSystemReceiver(WadlProxyConsts.REMOTE_CMD_APP_INSTALLED, stringExtra2, null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void filterExpireTask(ArrayList<WadlResult> arrayList) {
        long optLong;
        WadlParams wadlParams;
        int i3;
        QLog.d(TAG, 1, "filterExpireTask...");
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<WadlResult> it = arrayList.iterator();
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(IGameCenterUnitedConfigApi.GAME_INSTALL_CHANNEL_CONFIG, "");
            if (!TextUtils.isEmpty(loadAsString)) {
                try {
                    optLong = new JSONObject(loadAsString).optLong("autoDownloadValidTime") * 1000;
                } catch (JSONException e16) {
                    QLog.e(TAG, 1, "filterExpireTask parse configJsonStr exception", e16);
                }
                while (it.hasNext()) {
                    WadlResult next = it.next();
                    if (next.wadlParams != null) {
                        if (isAutoDownloadTaskExpire(optLong, next)) {
                            it.remove();
                            deleteApkDownload(555, next.wadlParams.appId);
                            ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onFilterExpireTask(next.wadlParams);
                            QLog.w(TAG, 1, "filterExpireTask task expire, appId=" + next.wadlParams.appId + ",task createTime=" + next.createTime);
                        } else if (next.taskStatus == 6) {
                            if (!FileUtils.fileExists(next.downloadFilePath)) {
                                it.remove();
                                deleteApkDownload(444, next.wadlParams.appId);
                                QLog.w(TAG, 1, "filterExpireTask file not exists, appId=" + next.wadlParams.appId + ",filePath=" + next.downloadFilePath);
                            } else {
                                int appVersionCode = GameCenterUtil.getAppVersionCode(next.wadlParams.packageName);
                                if (appVersionCode > 0 && (i3 = (wadlParams = next.wadlParams).versionCode) > 0 && appVersionCode >= i3 && (appVersionCode > i3 || isApkFileExpire(wadlParams.appId, next.downloadFilePath))) {
                                    it.remove();
                                    deleteApkDownload(444, next.wadlParams.appId);
                                    QLog.w(TAG, 1, "filterExpireTask version invalid, installVersion=" + appVersionCode + ",downloadVersion=" + next.wadlParams.versionCode);
                                }
                            }
                        }
                    }
                }
            }
            optLong = 0;
            while (it.hasNext()) {
            }
        }
    }

    private void handleAfterCheckDownload(WadlParams wadlParams) {
        if (TextUtils.isEmpty(wadlParams.appName)) {
            wadlParams.appName = wadlParams.packageName;
        }
        if (!TextUtils.isEmpty(wadlParams.packageName) && !TextUtils.isEmpty(wadlParams.appId)) {
            GameCenterSpUtils.setStringOutAccount(WadlProxyConsts.KEY_PKG_INFO_PRE + wadlParams.packageName, wadlParams.appId);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO, wadlParams);
        sendCommandToService(new WadlRequest(1, WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION, bundle));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d3 A[Catch: all -> 0x0106, TryCatch #1 {all -> 0x0106, blocks: (B:3:0x0008, B:5:0x000c, B:40:0x0042, B:8:0x0050, B:11:0x0089, B:14:0x0094, B:17:0x009f, B:20:0x00a6, B:23:0x00b1, B:26:0x00bc, B:29:0x00c7, B:31:0x00d3, B:32:0x00c5, B:33:0x00ba, B:34:0x00af, B:35:0x00a4, B:36:0x009d, B:37:0x0092, B:38:0x0087, B:44:0x0049, B:45:0x00d8, B:47:0x00dc, B:48:0x00f0), top: B:2:0x0008, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5 A[Catch: all -> 0x0106, TryCatch #1 {all -> 0x0106, blocks: (B:3:0x0008, B:5:0x000c, B:40:0x0042, B:8:0x0050, B:11:0x0089, B:14:0x0094, B:17:0x009f, B:20:0x00a6, B:23:0x00b1, B:26:0x00bc, B:29:0x00c7, B:31:0x00d3, B:32:0x00c5, B:33:0x00ba, B:34:0x00af, B:35:0x00a4, B:36:0x009d, B:37:0x0092, B:38:0x0087, B:44:0x0049, B:45:0x00d8, B:47:0x00dc, B:48:0x00f0), top: B:2:0x0008, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba A[Catch: all -> 0x0106, TryCatch #1 {all -> 0x0106, blocks: (B:3:0x0008, B:5:0x000c, B:40:0x0042, B:8:0x0050, B:11:0x0089, B:14:0x0094, B:17:0x009f, B:20:0x00a6, B:23:0x00b1, B:26:0x00bc, B:29:0x00c7, B:31:0x00d3, B:32:0x00c5, B:33:0x00ba, B:34:0x00af, B:35:0x00a4, B:36:0x009d, B:37:0x0092, B:38:0x0087, B:44:0x0049, B:45:0x00d8, B:47:0x00dc, B:48:0x00f0), top: B:2:0x0008, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00af A[Catch: all -> 0x0106, TryCatch #1 {all -> 0x0106, blocks: (B:3:0x0008, B:5:0x000c, B:40:0x0042, B:8:0x0050, B:11:0x0089, B:14:0x0094, B:17:0x009f, B:20:0x00a6, B:23:0x00b1, B:26:0x00bc, B:29:0x00c7, B:31:0x00d3, B:32:0x00c5, B:33:0x00ba, B:34:0x00af, B:35:0x00a4, B:36:0x009d, B:37:0x0092, B:38:0x0087, B:44:0x0049, B:45:0x00d8, B:47:0x00dc, B:48:0x00f0), top: B:2:0x0008, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4 A[Catch: all -> 0x0106, TryCatch #1 {all -> 0x0106, blocks: (B:3:0x0008, B:5:0x000c, B:40:0x0042, B:8:0x0050, B:11:0x0089, B:14:0x0094, B:17:0x009f, B:20:0x00a6, B:23:0x00b1, B:26:0x00bc, B:29:0x00c7, B:31:0x00d3, B:32:0x00c5, B:33:0x00ba, B:34:0x00af, B:35:0x00a4, B:36:0x009d, B:37:0x0092, B:38:0x0087, B:44:0x0049, B:45:0x00d8, B:47:0x00dc, B:48:0x00f0), top: B:2:0x0008, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009d A[Catch: all -> 0x0106, TryCatch #1 {all -> 0x0106, blocks: (B:3:0x0008, B:5:0x000c, B:40:0x0042, B:8:0x0050, B:11:0x0089, B:14:0x0094, B:17:0x009f, B:20:0x00a6, B:23:0x00b1, B:26:0x00bc, B:29:0x00c7, B:31:0x00d3, B:32:0x00c5, B:33:0x00ba, B:34:0x00af, B:35:0x00a4, B:36:0x009d, B:37:0x0092, B:38:0x0087, B:44:0x0049, B:45:0x00d8, B:47:0x00dc, B:48:0x00f0), top: B:2:0x0008, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0092 A[Catch: all -> 0x0106, TryCatch #1 {all -> 0x0106, blocks: (B:3:0x0008, B:5:0x000c, B:40:0x0042, B:8:0x0050, B:11:0x0089, B:14:0x0094, B:17:0x009f, B:20:0x00a6, B:23:0x00b1, B:26:0x00bc, B:29:0x00c7, B:31:0x00d3, B:32:0x00c5, B:33:0x00ba, B:34:0x00af, B:35:0x00a4, B:36:0x009d, B:37:0x0092, B:38:0x0087, B:44:0x0049, B:45:0x00d8, B:47:0x00dc, B:48:0x00f0), top: B:2:0x0008, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0087 A[Catch: all -> 0x0106, TryCatch #1 {all -> 0x0106, blocks: (B:3:0x0008, B:5:0x000c, B:40:0x0042, B:8:0x0050, B:11:0x0089, B:14:0x0094, B:17:0x009f, B:20:0x00a6, B:23:0x00b1, B:26:0x00bc, B:29:0x00c7, B:31:0x00d3, B:32:0x00c5, B:33:0x00ba, B:34:0x00af, B:35:0x00a4, B:36:0x009d, B:37:0x0092, B:38:0x0087, B:44:0x0049, B:45:0x00d8, B:47:0x00dc, B:48:0x00f0), top: B:2:0x0008, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleCheckDownload(QQGameCheckDownload$CheckURLResponse qQGameCheckDownload$CheckURLResponse, WadlParams wadlParams) {
        int parseInt;
        try {
            QQGameCheckDownload$ReplacementURL qQGameCheckDownload$ReplacementURL = qQGameCheckDownload$CheckURLResponse.replacement_url;
            if (qQGameCheckDownload$ReplacementURL != null) {
                String str = qQGameCheckDownload$ReplacementURL.appid.get();
                String str2 = qQGameCheckDownload$ReplacementURL.channel_id.get();
                String str3 = qQGameCheckDownload$ReplacementURL.legal_url.get();
                String str4 = qQGameCheckDownload$ReplacementURL.pkg_name.get();
                String str5 = qQGameCheckDownload$ReplacementURL.app_name.get();
                String str6 = qQGameCheckDownload$ReplacementURL.app_icon.get();
                String str7 = qQGameCheckDownload$ReplacementURL.version_code.get();
                String str8 = qQGameCheckDownload$ReplacementURL.sign_code.get();
                if (!TextUtils.isEmpty(str7)) {
                    try {
                        parseInt = Integer.parseInt(str7);
                    } catch (NumberFormatException e16) {
                        QLog.e(TAG, 1, "handleCheckDownload versionCode parse exception", e16);
                    }
                    QLog.d(TAG, 1, "handleCheckDownload appid=" + str + ",channelId=" + str2 + ",packageName=" + str4 + ",versionStr=" + str7);
                    if (!TextUtils.isEmpty(str)) {
                        str = wadlParams.appId;
                    }
                    wadlParams.appId = str;
                    if (!TextUtils.isEmpty(str3)) {
                        str3 = wadlParams.apkUrl;
                    }
                    wadlParams.apkUrl = str3;
                    if (!TextUtils.isEmpty(str4)) {
                        str4 = wadlParams.packageName;
                    }
                    wadlParams.packageName = str4;
                    if (parseInt > 0) {
                        parseInt = wadlParams.versionCode;
                    }
                    wadlParams.versionCode = parseInt;
                    if (!TextUtils.isEmpty(str5)) {
                        str5 = wadlParams.appName;
                    }
                    wadlParams.appName = str5;
                    if (!TextUtils.isEmpty(str6)) {
                        str6 = wadlParams.iconUrl;
                    }
                    wadlParams.iconUrl = str6;
                    if (!TextUtils.isEmpty(str2)) {
                        str2 = wadlParams.apkChannel;
                    }
                    wadlParams.apkChannel = str2;
                    wadlParams.apkSign = str8;
                    if (qQGameCheckDownload$ReplacementURL.is_test_version.get()) {
                        wadlParams.setFlags(4096);
                    }
                }
                parseInt = 0;
                QLog.d(TAG, 1, "handleCheckDownload appid=" + str + ",channelId=" + str2 + ",packageName=" + str4 + ",versionStr=" + str7);
                if (!TextUtils.isEmpty(str)) {
                }
                wadlParams.appId = str;
                if (!TextUtils.isEmpty(str3)) {
                }
                wadlParams.apkUrl = str3;
                if (!TextUtils.isEmpty(str4)) {
                }
                wadlParams.packageName = str4;
                if (parseInt > 0) {
                }
                wadlParams.versionCode = parseInt;
                if (!TextUtils.isEmpty(str5)) {
                }
                wadlParams.appName = str5;
                if (!TextUtils.isEmpty(str6)) {
                }
                wadlParams.iconUrl = str6;
                if (!TextUtils.isEmpty(str2)) {
                }
                wadlParams.apkChannel = str2;
                wadlParams.apkSign = str8;
                if (qQGameCheckDownload$ReplacementURL.is_test_version.get()) {
                }
            }
            QQGameCheckDownload$DownloadRemind qQGameCheckDownload$DownloadRemind = qQGameCheckDownload$CheckURLResponse.remind;
            if (qQGameCheckDownload$DownloadRemind != null) {
                wadlParams.wadlParamsExt.f106734e = qQGameCheckDownload$DownloadRemind.exp_key.get();
                wadlParams.wadlParamsExt.f106735f = qQGameCheckDownload$DownloadRemind.text.get();
            }
            QLog.d(TAG, 1, "handleCheckDownload wadlParams=" + wadlParams);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "onCmdRsp checkDownload parse exception", th5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleCheckDownloadV2(QQGameIntercept$Download qQGameIntercept$Download, WadlParams wadlParams) {
        int parseInt;
        String str = qQGameIntercept$Download.app_name.get();
        String str2 = qQGameIntercept$Download.channel_id.get();
        String str3 = qQGameIntercept$Download.app_icon.get();
        String str4 = qQGameIntercept$Download.download_url.get();
        String str5 = qQGameIntercept$Download.appid.get();
        String str6 = qQGameIntercept$Download.pkg_name.get();
        QLog.d(TAG, 1, "handleCheckDownloadV2 appName=" + str + ",channelId=" + str2 + ",appIcon=" + str3 + ",downloadUrl=" + str4 + ",appid=" + str5 + ",packageName=" + str6);
        if (TextUtils.isEmpty(str)) {
            str = wadlParams.appName;
        }
        wadlParams.appName = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = wadlParams.apkChannel;
        }
        wadlParams.apkChannel = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = wadlParams.iconUrl;
        }
        wadlParams.iconUrl = str3;
        if (TextUtils.isEmpty(str4)) {
            str4 = wadlParams.apkUrl;
        }
        wadlParams.apkUrl = str4;
        if (TextUtils.isEmpty(str5)) {
            str5 = wadlParams.appId;
        }
        wadlParams.appId = str5;
        if (TextUtils.isEmpty(str6)) {
            str6 = wadlParams.packageName;
        }
        wadlParams.packageName = str6;
        String str7 = qQGameIntercept$Download.version_code.get();
        if (!TextUtils.isEmpty(str7)) {
            try {
                parseInt = Integer.parseInt(str7);
            } catch (NumberFormatException e16) {
                QLog.e(TAG, 1, "handleCheckDownloadV2 versionCode parse exception", e16);
            }
            if (parseInt <= 0) {
                parseInt = wadlParams.versionCode;
            }
            wadlParams.versionCode = parseInt;
            if (!TextUtils.isEmpty(wadlParams.appName)) {
                wadlParams.appName = wadlParams.packageName;
                return;
            }
            return;
        }
        parseInt = 0;
        if (parseInt <= 0) {
        }
        wadlParams.versionCode = parseInt;
        if (!TextUtils.isEmpty(wadlParams.appName)) {
        }
    }

    private void handleCheckInstallTips(QQGameCheckDownload$InstallTipRsp qQGameCheckDownload$InstallTipRsp) {
        IYunGameManagerService iYunGameManagerService;
        int i3 = qQGameCheckDownload$InstallTipRsp.flag.get();
        QLog.d(TAG, 1, "handleCheckInstallTips reqSsoInstallTip checkFlag=" + i3);
        if (i3 == 0) {
            runWaitInstallTask();
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iYunGameManagerService = (IYunGameManagerService) peekAppRuntime.getRuntimeService(IYunGameManagerService.class, "");
        } else {
            iYunGameManagerService = null;
        }
        if (iYunGameManagerService == null) {
            QLog.e(TAG, 2, "handleCheckInstallTips reqSsoInstallTip, service is null");
            runWaitInstallTask();
            return;
        }
        int yunGameActivityStatus = iYunGameManagerService.getYunGameActivityStatus();
        QLog.d(TAG, 2, "handleCheckInstallTips reqSsoInstallTip gameActivityStatus=" + yunGameActivityStatus);
        if (yunGameActivityStatus == 0) {
            runWaitInstallTask();
        }
    }

    private boolean isAutoDownloadTaskExpire(long j3, WadlResult wadlResult) {
        int i3 = wadlResult.wadlParams.downloadType;
        boolean z16 = false;
        if (i3 != 2 && i3 != 4) {
            return false;
        }
        if (j3 < 1) {
            QLog.w(TAG, 1, "isTaskExpire config invalid, autoDownloadValidTime=" + j3);
            return false;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (wadlResult.createTime + j3 < serverTimeMillis) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "isTaskExpire appId=" + wadlResult.wadlParams.appId + ", createTime=" + wadlResult.createTime + ",autoDownloadValidTime=" + j3 + ",currTime=" + serverTimeMillis + ",isExpire=" + z16);
        }
        return z16;
    }

    private void putWaitInstallJob(WadlParams wadlParams) {
        if (wadlParams != null && !TextUtils.isEmpty(wadlParams.packageName)) {
            QLog.d(TAG, 1, "putWaitInstallJob, packageName=" + wadlParams.packageName);
            synchronized (this.waitInstallMap) {
                this.waitInstallMap.put(wadlParams.packageName, wadlParams);
            }
        }
    }

    private void removeWaitInstallJob(String str) {
        QLog.d(TAG, 1, "removeWaitInstallJob, packageName=" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.waitInstallMap) {
            if (this.waitInstallMap.get(str) != null) {
                this.waitInstallMap.remove(str);
            }
        }
    }

    private void sendInstallCmdToService(WadlParams wadlParams) {
        QLog.d(TAG, 1, "sendInstallCmdToService\uff1a" + wadlParams);
        Bundle bundle = new Bundle();
        bundle.putString("appId", wadlParams.appId);
        bundle.putParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO, wadlParams);
        sendCommandToService(new WadlRequest(1, WadlProxyConsts.REMOTE_CMD_APP_INSTALL_ACTION, bundle));
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void checkYunGameStatus(Bundle bundle) {
        boolean z16;
        if (bundle == null) {
            QLog.d(TAG, 1, "checkYunGameStatus, bundle is null");
            return;
        }
        String string = bundle.getString(WadlProxyConsts.PARAM_WADL_PARAMS_JSON_STR);
        if (TextUtils.isEmpty(string)) {
            QLog.d(TAG, 1, "checkYunGameStatus, wadlPramsJson is null");
            return;
        }
        WadlParams wadlParams = new WadlParams(string);
        QLog.d(TAG, 1, "checkYunGameStatus, packageName=" + wadlParams.packageName + ",appId=" + wadlParams.appId);
        if (!TextUtils.isEmpty(wadlParams.appId) && !TextUtils.isEmpty(wadlParams.packageName)) {
            if (((IQQGameCommApi) QRoute.api(IQQGameCommApi.class)).isExistMiniApp(wadlParams.packageName)) {
                com.tencent.gamecenter.wadl.biz.entity.g gVar = (com.tencent.gamecenter.wadl.biz.entity.g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
                boolean z17 = false;
                if (gVar != null) {
                    z16 = gVar.f106802o;
                } else {
                    z16 = false;
                }
                QLog.d(TAG, 1, "checkYunGameStatus isExistMiniApp miniProviderSwitchOn=" + z16 + ",processId=" + MobileQQ.sProcessId);
                if (z16) {
                    if (MobileQQ.sProcessId == 1) {
                        IQQGameProviderService iQQGameProviderService = (IQQGameProviderService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameProviderService.class, "all");
                        if (iQQGameProviderService != null) {
                            z17 = iQQGameProviderService.notifyInstall(wadlParams.packageName);
                        }
                        QLog.d(TAG, 1, "checkYunGameStatus notifyInstall result=" + z17);
                        return;
                    }
                    return;
                }
            }
            putWaitInstallJob(wadlParams);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO, wadlParams);
            ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).reqSsoInstallTip(wadlParams.appId, bundle2);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void deleteApkDownload(int i3, String str) {
        QLog.d(TAG, 1, "deleteApkDownload from=" + i3 + ",appID=" + str);
        Bundle bundle = new Bundle();
        bundle.putString("appId", str);
        bundle.putInt("actionFrom", i3);
        sendCommandToService(new WadlRequest(1, WadlProxyConsts.REMOTE_CMD_APP_DELETE_ACTION, bundle));
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void doAppSystemReceiver(String str, String str2, Bundle bundle) {
        boolean a16 = this.simpleDBHelper.a(str2);
        QLog.d(TAG, 1, "doAppSystemReceiver cmd=" + str + ",packageName=" + str2 + ",exists=" + a16);
        if (!a16) {
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("packageName", str2);
        sendCommandToService(new WadlRequest(1, str, bundle));
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void downloadApk(WadlParams wadlParams) {
        QLog.d(TAG, 1, "downloadApk wadlParams=" + wadlParams);
        Bundle bundle = new Bundle();
        bundle.putString("appId", wadlParams.appId);
        bundle.putInt("actionFrom", wadlParams.from);
        bundle.putParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO, wadlParams);
        if (wadlParams.actionCode == 13) {
            ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).checkIndependentDownload(wadlParams, bundle);
        } else {
            ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).checkGameDownload(wadlParams, bundle);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void downloadApkByIntercept(String str, String str2, int i3, String str3) {
        QLog.d(TAG, 1, "downloadApkByIntercept downloadUrl=" + str + ",pkgName=" + str2 + ",versionCode=" + i3 + ",md5=" + str3);
        WadlParams wadlParams = new WadlParams();
        wadlParams.setFlags(MtpConstants.TYPE_AINT64);
        wadlParams.via = WadlProxyConsts.VIA_INTERRUPT_BY_JOINT;
        wadlParams.downloadType = 5;
        wadlParams.apkUrl = str;
        wadlParams.packageName = str2;
        wadlParams.versionCode = i3;
        Bundle bundle = new Bundle();
        bundle.putParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO, wadlParams);
        ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).checkDownloadByIntercept(wadlParams, str3, bundle);
    }

    @Override // nl0.h
    public HashSet<String> getFilterCmds() {
        return this.cmds;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public boolean hasUnsentDlCmdWhenProcStartFailed() {
        return g.Z().o0();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void installApkAction(WadlParams wadlParams) {
        QLog.d(TAG, 1, "installApkAction\uff1a" + wadlParams);
        if (wadlParams != null && !TextUtils.isEmpty(wadlParams.packageName)) {
            removeWaitInstallJob(wadlParams.packageName);
            sendInstallCmdToService(wadlParams);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public boolean isApkFileExpire(String str, String str2) {
        boolean z16;
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(IGameCenterUnitedConfigApi.GAME_INSTALL_CHANNEL_CONFIG, "");
        if (!TextUtils.isEmpty(loadAsString) && !TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(loadAsString);
                long lastModified = new File(str2).lastModified();
                long optLong = jSONObject.optLong("taskValidTime") * 1000;
                long currentTimeMillis = System.currentTimeMillis();
                if (lastModified + optLong < currentTimeMillis) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                QLog.d(TAG, 1, "isApkFileExpire fileLastTime=" + lastModified + ",taskValidTime=" + optLong + ",currTime=" + currentTimeMillis + ",isExpire=" + z16);
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "isApkFileExpire exception", e16);
            }
            if (z16) {
                return true;
            }
            return false;
        }
        QLog.w(TAG, 1, "isApkFileExpire jsonStr is empty filePath=" + str2);
        return true;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        QLog.d(TAG, 1, "onCreate appRuntime=" + appRuntime);
        this.cmds.add(WadlProxyConsts.CMD_TRPC_CHECK_DOWNLOAD);
        this.cmds.add(WadlProxyConsts.CMD_TRPC_CHECK_INDEPENDENT_DOWNLOAD);
        this.cmds.add(WadlProxyConsts.CMD_TRPC_CHECK_DOWNLOAD_JOINT);
        this.cmds.add(WadlProxyConsts.CMD_TRPC_CHECK_DOWNLOAD_SSOINSTALLTIP);
        this.cmdTrpcMap.add(WadlProxyConsts.CMD_CHECK_INSTALL_CHANNEL);
        this.callbacks = new CopyOnWriteArrayList<>();
        ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).addListener(this);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.trpcListener);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.i(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.callbacks.clear();
        ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).removeListener(this);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.trpcListener);
        g Z = g.Z();
        if (Z != null) {
            Z.destroy();
        }
        this.isRelease.set(true);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void onInstalledEvent(String str) {
        com.tencent.gamecenter.wadl.biz.entity.a installInfo = GameCenterUtil.getInstallInfo("", str);
        if (installInfo.f106749d) {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).reportInstallAction(installInfo.f106747b, installInfo.f106748c, installInfo.f106751f);
        }
        com.tencent.gamecenter.wadl.biz.entity.f c16 = this.simpleDBHelper.c(str);
        QLog.w(TAG, 1, "onInstalledEvent installInfo=" + installInfo + ",baseTask=" + c16);
        if (c16 != null && installInfo.f106749d) {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).checkInstallChannel(4, 0, c16.appId, str, installInfo.f106748c);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void onQueryCallback(ArrayList<WadlResult> arrayList) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        } else {
            filterExpireTask(arrayList);
        }
        Iterator<WadlProxyServiceCallBackInterface> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().onQueryCallback(arrayList);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[onQueryCallback] size:" + arrayList.size());
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void onQueryCallbackByVia(ArrayList<WadlResult> arrayList) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        } else {
            filterExpireTask(arrayList);
        }
        Iterator<WadlProxyServiceCallBackInterface> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().onQueryCallbackVia(arrayList);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[onQueryCallbackByVia] size:" + arrayList.size());
        }
    }

    @Override // nl0.h
    public void onTrpcRsp(String str, boolean z16, int i3, int i16, Intent intent, Object obj) {
        QLog.d(TAG, 1, "onTrpcRsp cmd=" + str + ",isSucc=" + z16);
        if (this.isRelease.get()) {
            return;
        }
        if (WadlProxyConsts.CMD_TRPC_CHECK_DOWNLOAD.equals(str)) {
            WadlParams wadlParams = (WadlParams) intent.getExtras().getParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO);
            if (wadlParams == null) {
                QLog.w(TAG, 1, "onCmdRsp checkDownload wadlParams is empty");
                return;
            }
            if (z16 && (obj instanceof QQGameCheckDownload$CheckURLResponse)) {
                QQGameCheckDownload$CheckURLResponse qQGameCheckDownload$CheckURLResponse = (QQGameCheckDownload$CheckURLResponse) obj;
                int i17 = qQGameCheckDownload$CheckURLResponse.ret.get();
                if (i17 == 0) {
                    handleCheckDownload(qQGameCheckDownload$CheckURLResponse, wadlParams);
                } else {
                    QLog.w(TAG, 1, "onCmdRsp checkDownload ret=" + i17 + ",msg=" + qQGameCheckDownload$CheckURLResponse.f436032msg.get());
                }
            } else {
                wadlParams.setExtFlags(2);
            }
            handleAfterCheckDownload(wadlParams);
            return;
        }
        if (WadlProxyConsts.CMD_TRPC_CHECK_DOWNLOAD_JOINT.equals(str)) {
            WadlParams wadlParams2 = (WadlParams) intent.getExtras().getParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO);
            if (wadlParams2 == null) {
                return;
            }
            if (z16 && (obj instanceof QQGameIntercept$CheckRsp)) {
                handleCheckDownloadV2(((QQGameIntercept$CheckRsp) obj).download.get(), wadlParams2);
                Bundle bundle = new Bundle();
                bundle.putParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO, wadlParams2);
                bundle.putString("appId", wadlParams2.appId);
                sendCommandToService(new WadlRequest(1, WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION, bundle));
                return;
            }
            QLog.w(TAG, 1, "onCmdRsp checkDownloadByInterrupt fail");
            return;
        }
        if (WadlProxyConsts.CMD_TRPC_CHECK_INDEPENDENT_DOWNLOAD.equals(str)) {
            WadlParams wadlParams3 = (WadlParams) intent.getExtras().getParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO);
            if (wadlParams3 == null) {
                QLog.w(TAG, 1, "onCmdRsp checkIndependentDownload wadlParams is empty");
                return;
            }
            if (z16 && (obj instanceof QQGameCheckDownload$SsoCheckCustomAPKRsp)) {
                QQGameCheckDownload$SsoCheckCustomAPKRsp qQGameCheckDownload$SsoCheckCustomAPKRsp = (QQGameCheckDownload$SsoCheckCustomAPKRsp) obj;
                if (qQGameCheckDownload$SsoCheckCustomAPKRsp.ret.get() != 0) {
                    QLog.w(TAG, 1, "onCmdRsp checkIndependentDownload ret is error,ret:" + qQGameCheckDownload$SsoCheckCustomAPKRsp.ret.get() + ",msg:" + qQGameCheckDownload$SsoCheckCustomAPKRsp.f436033msg.get());
                    return;
                }
            } else {
                wadlParams3.setExtFlags(2);
                QLog.w(TAG, 1, "onCmdRsp checkIndependentDownload fail");
            }
            handleAfterCheckDownload(wadlParams3);
            return;
        }
        if (WadlProxyConsts.CMD_TRPC_CHECK_DOWNLOAD_SSOINSTALLTIP.equals(str)) {
            QLog.d(TAG, 1, "onCmdRsp reqSsoInstallTip isSucc=" + z16 + ",rspObj=" + obj);
            if (z16 && (obj instanceof QQGameCheckDownload$InstallTipRsp)) {
                handleCheckInstallTips((QQGameCheckDownload$InstallTipRsp) obj);
            } else {
                runWaitInstallTask();
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void onWadlTaskStatusChanged(WadlResult wadlResult) {
        if (wadlResult == null) {
            QLog.w(TAG, 1, "onWadlTaskStatusChanged wadlResult is null");
            return;
        }
        Iterator<WadlProxyServiceCallBackInterface> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().onWadlTaskStatusChanged(wadlResult);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void pauseApkDownload(int i3, String str, String str2) {
        QLog.d(TAG, 1, "pauseApkDownload from=" + i3 + ",sceneId=" + str + ",appId=" + str2);
        Bundle bundle = new Bundle();
        bundle.putString("appId", str2);
        bundle.putInt("actionFrom", i3);
        bundle.putString(WadlProxyConsts.SCENE_ID, str);
        sendCommandToService(new WadlRequest(1, WadlProxyConsts.REMOTE_CMD_APP_PAUSE_ACTION, bundle));
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void preLaunchWadlService() {
        g.Z().q3();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void queryAllApkTask(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(WadlProxyConsts.PARAM_IS_PRELOAD, z16);
        if (queryTaskOnCurrentProcess(WadlProxyConsts.REMOTE_CMD_QUERY_TASK, bundle)) {
            return;
        }
        sendCommandToService(new WadlRequest(1, WadlProxyConsts.REMOTE_CMD_QUERY_TASK, bundle));
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void queryApkTaskByApps(ArrayList<String> arrayList) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("queryApkTaskByApps:");
        if (arrayList != null) {
            str = arrayList.toString();
        } else {
            str = GlobalUtil.DEF_STRING;
        }
        sb5.append(str);
        QLog.d(TAG, 1, sb5.toString());
        if (arrayList != null && arrayList.size() >= 1) {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(WadlProxyConsts.PARAM_APPID_LIS, arrayList);
            if (queryTaskOnCurrentProcess(WadlProxyConsts.REMOTE_CMD_APP_QUERY_ID_ACTION, bundle)) {
                return;
            }
            sendCommandToService(new WadlRequest(1, WadlProxyConsts.REMOTE_CMD_APP_QUERY_ID_ACTION, bundle));
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void queryApkTaskByVia(String str) {
        QLog.d(TAG, 1, "queryApkTaskByVia via=" + str);
        Bundle bundle = new Bundle();
        bundle.putString("via", str);
        if (queryTaskOnCurrentProcess(WadlProxyConsts.REMOTE_CMD_APP_QUERY_VIA_ACTION, bundle)) {
            return;
        }
        sendCommandToService(new WadlRequest(1, WadlProxyConsts.REMOTE_CMD_APP_QUERY_VIA_ACTION, bundle));
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public com.tencent.gamecenter.wadl.biz.entity.f queryFullPkgTask(String str) {
        return this.simpleDBHelper.c(str);
    }

    public boolean queryTaskOnCurrentProcess(String str, Bundle bundle) {
        boolean z16;
        boolean z17 = true;
        if (!((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).isSwitchOn(IGameCenterUnitedConfigApi.GAMECENTER_DOWNLOAD_QUERY_ACCELERATE, false)) {
            QLog.i(TAG, 1, "[queryTaskOnCurrentProcess] query accelerate switch off, return.");
            return false;
        }
        if (g.Z().h1()) {
            QLog.i(TAG, 1, "[queryTaskOnCurrentProcess] download process exist, return.");
            return false;
        }
        QLog.i(TAG, 1, "[queryTaskOnCurrentProcess] download process not exist, query on current process.");
        WadlGameCenterTaskMgr wadlGameCenterTaskMgr = WadlGameCenterTaskMgr.getInstance();
        if (WadlProxyConsts.REMOTE_CMD_APP_QUERY_ID_ACTION.equals(str)) {
            ArrayList<WadlResult> queryWadlTask = wadlGameCenterTaskMgr.queryWadlTask(bundle.getStringArrayList(WadlProxyConsts.PARAM_APPID_LIS));
            QLog.d(TAG, 1, "doQueryAction result size:" + queryWadlTask.size());
            onQueryCallback(queryWadlTask);
            z16 = true;
        } else {
            z16 = false;
        }
        if (WadlProxyConsts.REMOTE_CMD_APP_QUERY_VIA_ACTION.equals(str)) {
            ArrayList<WadlResult> queryWadlTaskByVia = wadlGameCenterTaskMgr.queryWadlTaskByVia(bundle.getString("via"));
            QLog.d(TAG, 1, "doQueryActionByVia result size:" + queryWadlTaskByVia.size());
            onQueryCallbackByVia(queryWadlTaskByVia);
            z16 = true;
        }
        if (WadlProxyConsts.REMOTE_CMD_QUERY_TASK.equals(str)) {
            ArrayList<WadlResult> queryAllWadlTask = wadlGameCenterTaskMgr.queryAllWadlTask(false);
            QLog.d(TAG, 1, "doQueryAllTask result size:" + queryAllWadlTask.size());
            onQueryCallback(queryAllWadlTask);
        } else {
            z17 = z16;
        }
        if (z17) {
            g.Z().g4(0);
        }
        return z17;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void registerWadlServiceCallBack(WadlProxyServiceCallBackInterface wadlProxyServiceCallBackInterface) {
        if (!this.isRelease.get() && wadlProxyServiceCallBackInterface != null && !this.callbacks.contains(wadlProxyServiceCallBackInterface)) {
            QLog.d(TAG, 1, "registerWadlServiceCallBack callback=" + wadlProxyServiceCallBackInterface);
            this.callbacks.add(wadlProxyServiceCallBackInterface);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void reportInstallRequest(String str, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putString("appid", str);
        bundle.putBoolean("isForeground", z16);
        sendCommandToService(new WadlRequest(1, WadlProxyConsts.REMOTE_CMD_REPORT_INSTALL_REQUEST, bundle));
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void resumeApkDownload(int i3, String str) {
        resumeApkDownload(i3, 0, str);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void runWaitInstallTask() {
        QLog.d(TAG, 1, "runWaitInstallTask...");
        for (Map.Entry<String, WadlParams> entry : this.waitInstallMap.snapshot().entrySet()) {
            String key = entry.getKey();
            WadlParams value = entry.getValue();
            QLog.d(TAG, 1, "runWaitInstallTask packageName=" + key);
            sendInstallCmdToService(value);
        }
        QLog.d(TAG, 1, "runWaitInstallTask waitInstallMap evictAll...");
        synchronized (this.waitInstallMap) {
            this.waitInstallMap.evictAll();
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void sendCommandToService(WadlRequest wadlRequest) {
        if (!this.isRelease.get() && wadlRequest != null) {
            g Z = g.Z();
            if (Z != null) {
                Z.e3(wadlRequest);
                return;
            }
            return;
        }
        QLog.w(TAG, 1, "sendCommandToService fail, isRelease=" + this.isRelease.get() + ",wadlRequest=" + wadlRequest);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void setSpeedBuffer(int i3) {
        com.tencent.gamecenter.wadl.biz.entity.g gVar = (com.tencent.gamecenter.wadl.biz.entity.g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
        if (gVar != null && gVar.f106800m) {
            Bundle bundle = new Bundle();
            bundle.putInt(WadlProxyConsts.PARAM_SPEED_BUFFER, i3);
            sendCommandToService(new WadlRequest(1, WadlProxyConsts.REMOTE_CMD_SET_SPEED_BUFFER, bundle));
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void syncTaskData(ArrayList<WadlResult> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("query_result", arrayList);
        sendCommandToService(new WadlRequest(1, WadlProxyConsts.REMOTE_CMD_SYNC_TASK_DATA, bundle));
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void unRegisterWadlServiceCallBack(WadlProxyServiceCallBackInterface wadlProxyServiceCallBackInterface) {
        if (wadlProxyServiceCallBackInterface != null && this.callbacks.contains(wadlProxyServiceCallBackInterface)) {
            QLog.d(TAG, 1, "unRegisterWadlServiceCallBack callback=" + wadlProxyServiceCallBackInterface);
            this.callbacks.remove(wadlProxyServiceCallBackInterface);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDownloadService
    public void resumeApkDownload(int i3, int i16, String str) {
        QLog.d(TAG, 1, "resumeApkDownload from=" + i3 + ",actionType=" + i16 + ",appId=" + str);
        Bundle bundle = new Bundle();
        bundle.putString("appId", str);
        bundle.putInt("actionFrom", i3);
        bundle.putInt("actionType", i16);
        sendCommandToService(new WadlRequest(1, WadlProxyConsts.REMOTE_CMD_APP_RESUME_ACTION, bundle));
    }
}

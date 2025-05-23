package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.apkg.DebugInfo;
import com.tencent.mobileqq.mini.apkg.ExtConfigInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.mainpage.MainPageFragment;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PreCacheInfo;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import com.tencent.qqmini.sdk.launcher.model.UserAuthScope;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes34.dex */
public class aq {

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements EIPCResultCallback {
        a() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            QLog.e("MiniSdkUtil", 2, " upload action callback ");
        }
    }

    public static ArrayList<ExtConfigInfo> f(ArrayList<com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo> arrayList) {
        ArrayList<ExtConfigInfo> arrayList2 = new ArrayList<>();
        Iterator<com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(a(it.next()));
        }
        return arrayList2;
    }

    public static boolean j(String str) {
        return MiniConst.MetaRoomConst.META_ROOM_MINI_APP_ID.equals(str);
    }

    public static synchronized boolean k() {
        boolean z16;
        synchronized (aq.class) {
            BaseApplicationImpl application = BaseApplicationImpl.getApplication();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
            sb5.append("_user_sdk_miniapp_");
            z16 = application.getSharedPreferences(sb5.toString(), 4).getInt("miniapp_sdk__downgrade", -1) == 1;
        }
        return z16;
    }

    public static synchronized void m(boolean z16) {
        synchronized (aq.class) {
            QLog.e("MiniSdkUtil", 1, "setMiniAppSdkDowngrade " + z16);
            if (z16) {
                BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_user_sdk_miniapp_", 4).edit().putInt("miniapp_sdk__downgrade", 1).commit();
            } else {
                BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_user_sdk_miniapp_", 4).edit().putInt("miniapp_sdk__downgrade", 0).commit();
            }
        }
    }

    public static boolean l(Context context) {
        try {
            Iterator<ActivityManager.RunningAppProcessInfo> it = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).iterator();
            while (it.hasNext()) {
                String str = it.next().processName;
                if ("com.tencent.mobileqq:mini3".equals(str) || "com.tencent.mobileqq:mini4".equals(str) || "com.tencent.mobileqq:mini5".equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e16) {
            QLog.e("MiniSdkUtil", 1, "getProcessInfos fail ", e16);
            return false;
        }
    }

    public static void n(IMiniAppContext iMiniAppContext, boolean z16) {
        String str;
        QLog.d("MiniSdkUtil", 1, "startReportPage miniAppContext=", iMiniAppContext, ", reportClick=", Boolean.valueOf(z16));
        if (iMiniAppContext == null) {
            return;
        }
        MiniAppInfo miniAppInfo = iMiniAppContext.getMiniAppInfo();
        Activity attachActivity = iMiniAppContext.getAttachActivity();
        if (miniAppInfo == null || attachActivity == null) {
            return;
        }
        try {
            str = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            QLog.e("MiniSdkUtil", 1, "startComplainAndCallback, url = ");
            e16.printStackTrace();
            str = "";
        }
        String str2 = "https://tucao.qq.com/qq_miniprogram/tucao?appid=" + miniAppInfo.appId + "&openid=" + MainPageFragment.getUin() + "&avatar=" + str + HardCodeUtil.qqStr(R.string.k7o);
        Intent intent = new Intent(attachActivity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str2);
        Bundle bundle = new Bundle();
        bundle.putBoolean("hide_more_button", true);
        intent.putExtras(bundle);
        attachActivity.startActivity(intent);
        if (z16) {
            MiniAppConfig h16 = h(miniAppInfo);
            MiniProgramLpReportDC04239.reportUserClick(h16, MiniProgramLpReportDC04239.getAppType(h16), null, "user_click", "more_button", "report");
        }
        QLog.d("MiniSdkUtil", 2, "startReportPage, prepare to upload log ");
        Bundle bundle2 = new Bundle();
        bundle2.putString("appid", miniAppInfo.appId);
        QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_UPLOAD_USER_LOG, bundle2, new a());
    }

    public static boolean i(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            QLog.w("MiniSdkUtil", 1, "judge is meta room but app info is null");
            return false;
        }
        return j(miniAppInfo.appId);
    }

    public static ExtConfigInfo a(com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo extConfigInfo) {
        if (extConfigInfo == null) {
            return null;
        }
        ExtConfigInfo extConfigInfo2 = new ExtConfigInfo();
        extConfigInfo2.configKey = extConfigInfo.configKey;
        extConfigInfo2.configVersion = extConfigInfo.configVersion;
        if (extConfigInfo.userAuthScopes != null) {
            extConfigInfo2.userAuthScopes = new ArrayList<>();
            Iterator<UserAuthScope> it = extConfigInfo.userAuthScopes.iterator();
            while (it.hasNext()) {
                UserAuthScope next = it.next();
                if (next != null) {
                    com.tencent.mobileqq.mini.apkg.UserAuthScope userAuthScope = new com.tencent.mobileqq.mini.apkg.UserAuthScope();
                    extConfigInfo2.userAuthScopes.add(userAuthScope);
                    userAuthScope.scope = next.scope;
                    userAuthScope.authType = next.authType;
                    userAuthScope.desc = next.desc;
                    userAuthScope.settingPageTitle = next.settingPageTitle;
                }
            }
        }
        if (extConfigInfo.apiScopeEntries != null) {
            extConfigInfo2.apiScopeEntries = new ArrayList<>();
            Iterator<ApiScopeEntry> it5 = extConfigInfo.apiScopeEntries.iterator();
            while (it5.hasNext()) {
                ApiScopeEntry next2 = it5.next();
                if (next2 != null) {
                    com.tencent.mobileqq.mini.apkg.ApiScopeEntry apiScopeEntry = new com.tencent.mobileqq.mini.apkg.ApiScopeEntry();
                    extConfigInfo2.apiScopeEntries.add(apiScopeEntry);
                    apiScopeEntry.scope = next2.scope;
                    apiScopeEntry.eventName = next2.eventName;
                    apiScopeEntry.apiName = next2.apiName;
                }
            }
        }
        return extConfigInfo2;
    }

    public static com.tencent.mobileqq.mini.apkg.MiniAppInfo b(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return null;
        }
        com.tencent.mobileqq.mini.apkg.MiniAppInfo miniAppInfo2 = new com.tencent.mobileqq.mini.apkg.MiniAppInfo();
        miniAppInfo2.topType = miniAppInfo.topType;
        miniAppInfo2.extraData = miniAppInfo.extraData;
        miniAppInfo2.recommend = miniAppInfo.recommend;
        miniAppInfo2.isSupportOffline = miniAppInfo.isSupportOffline;
        miniAppInfo2.openId = miniAppInfo.openId;
        miniAppInfo2.tinyId = miniAppInfo.tinyId;
        miniAppInfo2.position = miniAppInfo.position;
        miniAppInfo2.isSupportBlueBar = miniAppInfo.isSupportBlueBar;
        miniAppInfo2.recommendAppIconUrl = miniAppInfo.recommendAppIconUrl;
        miniAppInfo2.extendData = miniAppInfo.extendData;
        miniAppInfo2.clearAuths = miniAppInfo.clearAuths;
        miniAppInfo2.appStoreAnimPicUrl = miniAppInfo.appStoreAnimPicUrl;
        miniAppInfo2.setEngineType(miniAppInfo.getEngineType());
        miniAppInfo2.setReportType(miniAppInfo.getReportType());
        byte[] bArr = miniAppInfo.commonExt;
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            miniAppInfo2.commonExt = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        if (miniAppInfo.motionPics != null) {
            miniAppInfo2.motionPics = new ArrayList<>();
            Iterator<String> it = miniAppInfo.motionPics.iterator();
            while (it.hasNext()) {
                miniAppInfo2.motionPics.add(it.next());
            }
        }
        if (miniAppInfo.extConfigInfoList != null) {
            miniAppInfo2.extConfigInfoList = new ArrayList<>();
            Iterator<com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo> it5 = miniAppInfo.extConfigInfoList.iterator();
            while (it5.hasNext()) {
                miniAppInfo2.extConfigInfoList.add(a(it5.next()));
            }
        }
        if (miniAppInfo.preCacheList != null) {
            miniAppInfo2.preCacheList = new ArrayList<>();
            Iterator<PreCacheInfo> it6 = miniAppInfo.preCacheList.iterator();
            while (it6.hasNext()) {
                PreCacheInfo next = it6.next();
                if (next != null) {
                    miniAppInfo2.preCacheList.add(new com.tencent.mobileqq.mini.apkg.PreCacheInfo(next.getDataUrl, next.preCacheKey, next.expireTime, 0, 0));
                }
            }
        }
        miniAppInfo2.appId = miniAppInfo.appId;
        miniAppInfo2.name = miniAppInfo.name;
        miniAppInfo2.iconUrl = miniAppInfo.iconUrl;
        miniAppInfo2.downloadUrl = miniAppInfo.downloadUrl;
        miniAppInfo2.version = miniAppInfo.version;
        miniAppInfo2.versionId = miniAppInfo.versionId;
        miniAppInfo2.desc = miniAppInfo.desc;
        miniAppInfo2.verType = miniAppInfo.verType;
        miniAppInfo2.timestamp = miniAppInfo.timestamp;
        miniAppInfo2.baselibMiniVersion = miniAppInfo.baselibMiniVersion;
        miniAppInfo2.fileSize = miniAppInfo.fileSize;
        miniAppInfo2.developerDesc = miniAppInfo.developerDesc;
        miniAppInfo2.gameRegistrationNumber = miniAppInfo.gameRegistrationNumber;
        miniAppInfo2.skipDomainCheck = miniAppInfo.skipDomainCheck;
        miniAppInfo2.usrFileSizeLimit = miniAppInfo.usrFileSizeLimit;
        miniAppInfo2.noNeedRealRecommend = miniAppInfo.noNeedRealRecommend;
        miniAppInfo2.versionUpdateTime = miniAppInfo.versionUpdateTime;
        miniAppInfo2.engineType = miniAppInfo.engineType;
        miniAppInfo2.shareId = miniAppInfo.shareId;
        miniAppInfo2.via = miniAppInfo.via;
        if (miniAppInfo.whiteList != null) {
            ArrayList arrayList = new ArrayList();
            miniAppInfo2.whiteList = arrayList;
            arrayList.addAll(miniAppInfo.whiteList);
        }
        if (miniAppInfo.blackList != null) {
            ArrayList arrayList2 = new ArrayList();
            miniAppInfo2.blackList = arrayList2;
            arrayList2.addAll(miniAppInfo.blackList);
        }
        if (miniAppInfo.requestDomainList != null) {
            ArrayList arrayList3 = new ArrayList();
            miniAppInfo2.requestDomainList = arrayList3;
            arrayList3.addAll(miniAppInfo.requestDomainList);
        }
        if (miniAppInfo.socketDomainList != null) {
            ArrayList arrayList4 = new ArrayList();
            miniAppInfo2.socketDomainList = arrayList4;
            arrayList4.addAll(miniAppInfo.socketDomainList);
        }
        if (miniAppInfo.uploadFileDomainList != null) {
            ArrayList arrayList5 = new ArrayList();
            miniAppInfo2.uploadFileDomainList = arrayList5;
            arrayList5.addAll(miniAppInfo.uploadFileDomainList);
        }
        if (miniAppInfo.downloadFileDomainList != null) {
            ArrayList arrayList6 = new ArrayList();
            miniAppInfo2.downloadFileDomainList = arrayList6;
            arrayList6.addAll(miniAppInfo.downloadFileDomainList);
        }
        if (miniAppInfo.businessDomainList != null) {
            ArrayList arrayList7 = new ArrayList();
            miniAppInfo2.businessDomainList = arrayList7;
            arrayList7.addAll(miniAppInfo.businessDomainList);
        }
        List<String> list = miniAppInfo.udpIpList;
        if (list != null) {
            miniAppInfo2.udpIpList.addAll(list);
        }
        if (miniAppInfo.debugInfo != null) {
            DebugInfo debugInfo = new DebugInfo();
            miniAppInfo2.debugInfo = debugInfo;
            com.tencent.qqmini.sdk.launcher.model.DebugInfo debugInfo2 = miniAppInfo.debugInfo;
            debugInfo.roomId = debugInfo2.roomId;
            debugInfo.wsUrl = debugInfo2.wsUrl;
        }
        if (miniAppInfo.subpkgs != null) {
            miniAppInfo2.subpkgs = new ArrayList();
            for (SubPkgInfo subPkgInfo : miniAppInfo.subpkgs) {
                com.tencent.mobileqq.mini.apkg.SubPkgInfo subPkgInfo2 = new com.tencent.mobileqq.mini.apkg.SubPkgInfo();
                subPkgInfo2.downloadUrl = subPkgInfo.downloadUrl;
                subPkgInfo2.fileSize = subPkgInfo.fileSize;
                subPkgInfo2.independent = subPkgInfo.independent;
                subPkgInfo2.subPkgName = subPkgInfo.subPkgName;
                miniAppInfo2.subpkgs.add(subPkgInfo2);
            }
        }
        return miniAppInfo2;
    }

    public static LaunchParam c(com.tencent.qqmini.sdk.launcher.model.LaunchParam launchParam) {
        if (launchParam == null) {
            return null;
        }
        LaunchParam launchParam2 = new LaunchParam();
        launchParam2.scene = launchParam.scene;
        launchParam2.miniAppId = launchParam.miniAppId;
        launchParam2.extraKey = launchParam.extraKey;
        launchParam2.entryPath = launchParam.entryPath;
        launchParam2.navigateExtData = launchParam.navigateExtData;
        launchParam2.fromMiniAppId = launchParam.fromMiniAppId;
        launchParam2.launchClickTimeMillis = launchParam.launchClickTimeMillis;
        launchParam2.tempState = launchParam.tempState;
        launchParam2.timestamp = launchParam.timestamp;
        launchParam2.shareTicket = launchParam.shareTicket;
        launchParam2.envVersion = launchParam.envVersion;
        launchParam2.reportData = launchParam.reportData;
        launchParam2.extendData = launchParam.extendData;
        launchParam2.entryModel = g(launchParam.entryModel);
        launchParam2.fromBackToMiniApp = launchParam.fromBackToMiniApp;
        launchParam2.forceReload = launchParam.forceReload;
        launchParam2.taskType = launchParam.taskType;
        launchParam2.taskAppId = launchParam.taskAppId;
        launchParam2.taskId = launchParam.taskId;
        launchParam2.isCloseGameBox = launchParam.isCloseGameBox;
        return launchParam2;
    }

    public static com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo d(ExtConfigInfo extConfigInfo) {
        if (extConfigInfo == null) {
            return null;
        }
        com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo extConfigInfo2 = new com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo();
        extConfigInfo2.configKey = extConfigInfo.configKey;
        extConfigInfo2.configVersion = extConfigInfo.configVersion;
        if (extConfigInfo.userAuthScopes != null) {
            extConfigInfo2.userAuthScopes = new ArrayList<>();
            Iterator<com.tencent.mobileqq.mini.apkg.UserAuthScope> it = extConfigInfo.userAuthScopes.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.mini.apkg.UserAuthScope next = it.next();
                if (next != null) {
                    UserAuthScope userAuthScope = new UserAuthScope();
                    extConfigInfo2.userAuthScopes.add(userAuthScope);
                    userAuthScope.scope = next.scope;
                    userAuthScope.authType = next.authType;
                    userAuthScope.desc = next.desc;
                    userAuthScope.settingPageTitle = next.settingPageTitle;
                }
            }
        }
        if (extConfigInfo.apiScopeEntries != null) {
            extConfigInfo2.apiScopeEntries = new ArrayList<>();
            Iterator<com.tencent.mobileqq.mini.apkg.ApiScopeEntry> it5 = extConfigInfo.apiScopeEntries.iterator();
            while (it5.hasNext()) {
                com.tencent.mobileqq.mini.apkg.ApiScopeEntry next2 = it5.next();
                if (next2 != null) {
                    ApiScopeEntry apiScopeEntry = new ApiScopeEntry();
                    extConfigInfo2.apiScopeEntries.add(apiScopeEntry);
                    apiScopeEntry.scope = next2.scope;
                    apiScopeEntry.eventName = next2.eventName;
                    apiScopeEntry.apiName = next2.apiName;
                }
            }
        }
        return extConfigInfo2;
    }

    public static MiniAppInfo e(com.tencent.mobileqq.mini.apkg.MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return null;
        }
        MiniAppInfo miniAppInfo2 = new MiniAppInfo();
        miniAppInfo2.topType = miniAppInfo.topType;
        miniAppInfo2.extraData = miniAppInfo.extraData;
        miniAppInfo2.recommend = miniAppInfo.recommend;
        miniAppInfo2.isSupportOffline = miniAppInfo.isSupportOffline;
        miniAppInfo2.openId = miniAppInfo.openId;
        miniAppInfo2.tinyId = miniAppInfo.tinyId;
        miniAppInfo2.position = miniAppInfo.position;
        miniAppInfo2.isSupportBlueBar = miniAppInfo.isSupportBlueBar;
        miniAppInfo2.recommendAppIconUrl = miniAppInfo.recommendAppIconUrl;
        miniAppInfo2.extendData = miniAppInfo.extendData;
        miniAppInfo2.clearAuths = miniAppInfo.clearAuths;
        miniAppInfo2.appStoreAnimPicUrl = miniAppInfo.appStoreAnimPicUrl;
        miniAppInfo2.setEngineType(miniAppInfo.getEngineType());
        miniAppInfo2.setReportType(miniAppInfo.getReportType());
        byte[] bArr = miniAppInfo.commonExt;
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            miniAppInfo2.commonExt = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        if (miniAppInfo.motionPics != null) {
            miniAppInfo2.motionPics = new ArrayList<>();
            Iterator<String> it = miniAppInfo.motionPics.iterator();
            while (it.hasNext()) {
                miniAppInfo2.motionPics.add(it.next());
            }
        }
        if (miniAppInfo.extConfigInfoList != null) {
            miniAppInfo2.extConfigInfoList = new ArrayList<>();
            Iterator<ExtConfigInfo> it5 = miniAppInfo.extConfigInfoList.iterator();
            while (it5.hasNext()) {
                miniAppInfo2.extConfigInfoList.add(d(it5.next()));
            }
        }
        if (miniAppInfo.preCacheList != null) {
            miniAppInfo2.preCacheList = new ArrayList<>();
            Iterator<com.tencent.mobileqq.mini.apkg.PreCacheInfo> it6 = miniAppInfo.preCacheList.iterator();
            while (it6.hasNext()) {
                com.tencent.mobileqq.mini.apkg.PreCacheInfo next = it6.next();
                miniAppInfo2.preCacheList.add(new PreCacheInfo(next.getDataUrl, next.preCacheKey, next.expireTime));
            }
        }
        miniAppInfo2.appId = miniAppInfo.appId;
        miniAppInfo2.name = miniAppInfo.name;
        miniAppInfo2.iconUrl = miniAppInfo.iconUrl;
        miniAppInfo2.downloadUrl = miniAppInfo.downloadUrl;
        miniAppInfo2.version = miniAppInfo.version;
        miniAppInfo2.versionId = miniAppInfo.versionId;
        miniAppInfo2.desc = miniAppInfo.desc;
        miniAppInfo2.verType = miniAppInfo.verType;
        miniAppInfo2.timestamp = miniAppInfo.timestamp;
        miniAppInfo2.baselibMiniVersion = miniAppInfo.baselibMiniVersion;
        miniAppInfo2.fileSize = miniAppInfo.fileSize;
        miniAppInfo2.developerDesc = miniAppInfo.developerDesc;
        miniAppInfo2.gameRegistrationNumber = miniAppInfo.gameRegistrationNumber;
        miniAppInfo2.skipDomainCheck = miniAppInfo.skipDomainCheck;
        miniAppInfo2.usrFileSizeLimit = miniAppInfo.usrFileSizeLimit;
        miniAppInfo2.noNeedRealRecommend = miniAppInfo.noNeedRealRecommend;
        miniAppInfo2.versionUpdateTime = miniAppInfo.versionUpdateTime;
        miniAppInfo2.engineType = miniAppInfo.engineType;
        miniAppInfo2.shareId = miniAppInfo.shareId;
        miniAppInfo2.via = miniAppInfo.via;
        if (miniAppInfo.whiteList != null) {
            ArrayList arrayList = new ArrayList();
            miniAppInfo2.whiteList = arrayList;
            arrayList.addAll(miniAppInfo.whiteList);
        }
        if (miniAppInfo.blackList != null) {
            ArrayList arrayList2 = new ArrayList();
            miniAppInfo2.blackList = arrayList2;
            arrayList2.addAll(miniAppInfo.blackList);
        }
        if (miniAppInfo.requestDomainList != null) {
            ArrayList arrayList3 = new ArrayList();
            miniAppInfo2.requestDomainList = arrayList3;
            arrayList3.addAll(miniAppInfo.requestDomainList);
        }
        if (miniAppInfo.socketDomainList != null) {
            ArrayList arrayList4 = new ArrayList();
            miniAppInfo2.socketDomainList = arrayList4;
            arrayList4.addAll(miniAppInfo.socketDomainList);
        }
        if (miniAppInfo.uploadFileDomainList != null) {
            ArrayList arrayList5 = new ArrayList();
            miniAppInfo2.uploadFileDomainList = arrayList5;
            arrayList5.addAll(miniAppInfo.uploadFileDomainList);
        }
        if (miniAppInfo.downloadFileDomainList != null) {
            ArrayList arrayList6 = new ArrayList();
            miniAppInfo2.downloadFileDomainList = arrayList6;
            arrayList6.addAll(miniAppInfo.downloadFileDomainList);
        }
        if (miniAppInfo.businessDomainList != null) {
            ArrayList arrayList7 = new ArrayList();
            miniAppInfo2.businessDomainList = arrayList7;
            arrayList7.addAll(miniAppInfo.businessDomainList);
        }
        if (miniAppInfo.udpIpList != null) {
            ArrayList arrayList8 = new ArrayList();
            miniAppInfo2.udpIpList = arrayList8;
            arrayList8.addAll(miniAppInfo.udpIpList);
        }
        if (miniAppInfo.debugInfo != null) {
            com.tencent.qqmini.sdk.launcher.model.DebugInfo debugInfo = new com.tencent.qqmini.sdk.launcher.model.DebugInfo();
            miniAppInfo2.debugInfo = debugInfo;
            DebugInfo debugInfo2 = miniAppInfo.debugInfo;
            debugInfo.roomId = debugInfo2.roomId;
            debugInfo.wsUrl = debugInfo2.wsUrl;
        }
        if (miniAppInfo.subpkgs != null) {
            miniAppInfo2.subpkgs = new ArrayList();
            for (com.tencent.mobileqq.mini.apkg.SubPkgInfo subPkgInfo : miniAppInfo.subpkgs) {
                SubPkgInfo subPkgInfo2 = new SubPkgInfo();
                subPkgInfo2.downloadUrl = subPkgInfo.downloadUrl;
                subPkgInfo2.fileSize = subPkgInfo.fileSize;
                subPkgInfo2.independent = subPkgInfo.independent;
                subPkgInfo2.subPkgName = subPkgInfo.subPkgName;
                miniAppInfo2.subpkgs.add(subPkgInfo2);
            }
        }
        return miniAppInfo2;
    }

    public static EntryModel g(com.tencent.qqmini.sdk.launcher.model.EntryModel entryModel) {
        if (entryModel == null) {
            return null;
        }
        EntryModel entryModel2 = new EntryModel(entryModel.type, entryModel.uin, entryModel.name, entryModel.isAdmin);
        entryModel2.reportData = entryModel.reportData;
        entryModel2.dwGroupClassExt = entryModel.dwGroupClassExt;
        return entryModel2;
    }

    public static MiniAppConfig h(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return null;
        }
        MiniAppConfig miniAppConfig = new MiniAppConfig(b(miniAppInfo));
        com.tencent.qqmini.sdk.launcher.model.LaunchParam launchParam = miniAppInfo.launchParam;
        miniAppConfig.entryPath = launchParam.entryPath;
        miniAppConfig.linkType = miniAppInfo.linkType;
        miniAppConfig.link = miniAppInfo.link;
        miniAppConfig.isFromShowInfo = false;
        miniAppConfig.launchParam = c(launchParam);
        if (miniAppInfo.baseLibInfo != null) {
            BaseLibInfo baseLibInfo = miniAppInfo.baseLibInfo;
            miniAppConfig.baseLibInfo = new com.tencent.mobileqq.mini.sdk.BaseLibInfo(baseLibInfo.baseLibUrl, baseLibInfo.baseLibKey, baseLibInfo.baseLibVersion, baseLibInfo.baseLibDesc, baseLibInfo.baseLibType);
        }
        return miniAppConfig;
    }
}

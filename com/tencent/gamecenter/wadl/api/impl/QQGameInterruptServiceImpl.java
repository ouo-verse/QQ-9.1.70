package com.tencent.gamecenter.wadl.api.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameInterruptService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService;
import com.tencent.gamecenter.wadl.biz.entity.ApkInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver;
import com.tencent.gamecenter.wadl.sdk.Agent;
import com.tencent.gamecenter.wadl.sdk.InitParam;
import com.tencent.gamecenter.wadl.sdk.downloader.Downloader;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.k;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.util.AppSetting;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import nl0.h;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.qqgame.QQGameIntercept$GameInfo;
import tencent.im.qqgame.QQGameIntercept$GetLgameFileResponse;
import tencent.im.qqgame.QQGameIntercept$GetLgameInfoResponse;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QQGameInterruptServiceImpl implements IQQGameInterruptService, h {
    private static final String KEY_DOMAIN = "domain";
    private static final String KEY_DOMAINS = "domains";
    private static final String KEY_PATHS = "paths";
    private static byte[] REGEX_CONFIG_LOCK = new byte[0];
    private static final String TAG = "Wadl_QQGameInterruptServiceImpl";
    private List<String> domainRegexList;
    private Downloader downloader;
    private HashMap<String, List<String>> pathRegexMap;
    private long updateConfTime = -1;
    private final int downloaderAppid = 10;
    HashSet<String> filterCmds = new HashSet<>();
    private Pair<String, QQGameIntercept$GameInfo> matchGameInfo = null;
    private CountDownLatch countDownLatch = null;
    DownloaderTaskListener regexTaskListener = new a();

    public QQGameInterruptServiceImpl() {
        QLog.i(TAG, 1, "new instance process=" + MobileQQ.processName);
        this.domainRegexList = new ArrayList();
        this.pathRegexMap = new HashMap<>();
        loadConfigByJointRegex(WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE);
        GameCenterReceiver.registerReceiver();
        InitParam initParam = new InitParam(MobileQQ.sMobileQQ, 10);
        initParam.iThreadPool = new k();
        this.downloader = Agent.getDownloader(initParam);
        this.filterCmds.add(WadlProxyConsts.CMD_TRPC_INTERRUPT_REGEX_FILE);
        this.filterCmds.add(WadlProxyConsts.CMD_TRPC_INTERRUPT_GAME_INFO);
        ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).addListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadConfigByJointRegex(final String str) {
        if (GameCenterUtil.isMainThread()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameInterruptServiceImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    QQGameInterruptServiceImpl.this.loadRegexJointConfig(str);
                }
            }, 64, null, false);
        } else {
            loadRegexJointConfig(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadRegexJointConfig(String str) {
        File configFile = GameCenterUtil.getConfigFile(GameCenterUtil.CONF_FILE_JOINT_REGEX_CONFIG);
        if (!configFile.exists()) {
            QLog.w(TAG, 1, "loadRegexConfig configFile not exists");
            return;
        }
        String readFileContent = FileUtils.readFileContent(configFile);
        QLog.d(TAG, 1, "loadRegexConfig from=" + str + ",content =" + readFileContent);
        synchronized (REGEX_CONFIG_LOCK) {
            this.domainRegexList.clear();
            this.pathRegexMap.clear();
            if (!TextUtils.isEmpty(readFileContent)) {
                try {
                    JSONArray optJSONArray = new JSONObject(readFileContent).optJSONArray(KEY_DOMAINS);
                    if (optJSONArray != null && optJSONArray.length() >= 1) {
                        int length = optJSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                            String string = jSONObject.getString("domain");
                            JSONArray jSONArray = jSONObject.getJSONArray(KEY_PATHS);
                            int length2 = jSONArray.length();
                            ArrayList arrayList = new ArrayList();
                            for (int i16 = 0; i16 < length2; i16++) {
                                arrayList.add(jSONArray.optString(i16, ""));
                            }
                            this.domainRegexList.add(string);
                            this.pathRegexMap.put(string, arrayList);
                        }
                    }
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "loadRegexConfig exception", th5);
                    this.domainRegexList.clear();
                    this.pathRegexMap.clear();
                }
            }
        }
    }

    private void onGetJointGameInfo(String str, int i3, QQGameIntercept$GameInfo qQGameIntercept$GameInfo) {
        if (i3 == 1 && qQGameIntercept$GameInfo != null) {
            QLog.d(TAG, 1, "onGetJointGameInfo srcUrl=" + str + ",match=" + i3 + ",appId=" + qQGameIntercept$GameInfo.appid.get() + ",appName=" + qQGameIntercept$GameInfo.app_name.get() + ",pkgName=" + qQGameIntercept$GameInfo.pkg_name.get() + MttLoader.QQBROWSER_PARAMS_VERSION + qQGameIntercept$GameInfo.version_code.get() + JefsClass.INDEX_URL + qQGameIntercept$GameInfo.download_url.get() + ",jumpType=" + qQGameIntercept$GameInfo.jump_type.get());
            this.matchGameInfo = new Pair<>(str, qQGameIntercept$GameInfo);
            return;
        }
        QLog.d(TAG, 1, "onGetJointGameInfo match=" + i3 + ",gameInfo=" + qQGameIntercept$GameInfo);
    }

    private void onGetJointRegexConfig(int i3, String str) {
        int readFromSpInt = GameCenterSpUtils.readFromSpInt(GameCenterSpUtils.KEY_LAST_GET_REGEX_CONFIG_VERSION);
        GameCenterSpUtils.writeToSpInt(GameCenterSpUtils.KEY_LAST_GET_REGEX_CONFIG_VERSION, i3);
        QLog.d(TAG, 1, "onGetJointRegexConfig currVersion=" + readFromSpInt + ",newVersion=" + i3 + ",fileUrl=" + str);
        if (i3 > readFromSpInt && !TextUtils.isEmpty(str)) {
            try {
                this.downloader.startDownload(this.downloader.genDownloadTask(str, GameCenterUtil.getConfDir().getAbsolutePath(), GameCenterUtil.CONF_FILE_JOINT_REGEX_CONFIG, this.regexTaskListener, null));
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "onGetJointRegexConfig download exception", th5);
            }
        }
    }

    private synchronized void resetCountDownLatch(String str) {
        CountDownLatch countDownLatch = this.countDownLatch;
        if (countDownLatch != null && countDownLatch.getCount() > 0) {
            this.countDownLatch.countDown();
            QLog.d(TAG, 1, "resetCountDownLatch from=" + str);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameInterruptService
    public void checkConfigUpdate() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameInterruptServiceImpl.3
            @Override // java.lang.Runnable
            public void run() {
                long j3;
                if (QQGameInterruptServiceImpl.this.updateConfTime == -1) {
                    QQGameInterruptServiceImpl.this.updateConfTime = GameCenterSpUtils.readFromSpLong(GameCenterSpUtils.KEY_LAST_GET_INTERRUPT_FILE_TIME);
                }
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.gamecenter.wadl.biz.entity.g gVar = (com.tencent.gamecenter.wadl.biz.entity.g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
                if (gVar != null) {
                    j3 = gVar.f106805r;
                } else {
                    j3 = 86400000;
                }
                if (QQGameInterruptServiceImpl.this.updateConfTime + j3 < currentTimeMillis || QQGameInterruptServiceImpl.this.updateConfTime > currentTimeMillis || AppSetting.isDebugVersion()) {
                    QQGameInterruptServiceImpl.this.updateConfTime = currentTimeMillis;
                    GameCenterSpUtils.writeToSpLong(GameCenterSpUtils.KEY_LAST_GET_INTERRUPT_FILE_TIME, QQGameInterruptServiceImpl.this.updateConfTime);
                    int readFromSpInt = GameCenterSpUtils.readFromSpInt(GameCenterSpUtils.KEY_LAST_GET_REGEX_CONFIG_VERSION);
                    QLog.i(QQGameInterruptServiceImpl.TAG, 1, "checkConfigUpdate jointRegexConfigVersion=" + readFromSpInt);
                    ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).requestJointRegexConfig(readFromSpInt);
                    return;
                }
                QLog.d(QQGameInterruptServiceImpl.TAG, 1, "checkConfigUpdate invalid time");
            }
        }, 16, null, false);
    }

    @Override // nl0.h
    public HashSet<String> getFilterCmds() {
        return this.filterCmds;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameInterruptService
    public ApkInfo matchByJointRegex(String str, String str2, String str3) {
        boolean z16;
        long j3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        synchronized (REGEX_CONFIG_LOCK) {
            Iterator<String> it = this.domainRegexList.iterator();
            while (true) {
                z16 = false;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (Pattern.compile(next).matcher(str).find()) {
                    Iterator<String> it5 = this.pathRegexMap.get(next).iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        if (Pattern.compile(it5.next()).matcher(str2).find()) {
                            z16 = true;
                            break;
                        }
                    }
                }
            }
        }
        if (z16) {
            QLog.d(TAG, 1, "matchByJointRegex isMatch url=" + str3);
            resetCountDownLatch("matchByJointRegex");
            this.countDownLatch = new CountDownLatch(1);
            ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).getInterruptGameInfoByUrl(str3);
            com.tencent.gamecenter.wadl.biz.entity.g gVar = (com.tencent.gamecenter.wadl.biz.entity.g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
            try {
                CountDownLatch countDownLatch = this.countDownLatch;
                if (gVar != null) {
                    j3 = gVar.f106804q;
                } else {
                    j3 = 500;
                }
                countDownLatch.await(j3, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e16) {
                QLog.e(TAG, 1, "matchByJointRegex url=" + str3, e16);
            }
            Pair<String, QQGameIntercept$GameInfo> pair = this.matchGameInfo;
            if (pair != null && str3.equals(pair.first)) {
                ApkInfo apkInfo = new ApkInfo(this.matchGameInfo.second.appid.get(), this.matchGameInfo.second.app_name.get(), WadlProxyConsts.APP_CHANNEL_GAMECENTER, this.matchGameInfo.second.pkg_name.get(), this.matchGameInfo.second.download_url.get());
                apkInfo.versionCode = this.matchGameInfo.second.version_code.get();
                apkInfo.jumpType = this.matchGameInfo.second.jump_type.get();
                apkInfo.from = 1;
                return apkInfo;
            }
        }
        return null;
    }

    @Override // nl0.h
    public void onTrpcRsp(String str, boolean z16, int i3, int i16, Intent intent, Object obj) {
        if (!z16) {
            QLog.w(TAG, 1, "onTrpcRsp fail, cmd=" + str);
            return;
        }
        if (WadlProxyConsts.CMD_TRPC_INTERRUPT_REGEX_FILE.equals(str)) {
            if (obj instanceof QQGameIntercept$GetLgameFileResponse) {
                QQGameIntercept$GetLgameFileResponse qQGameIntercept$GetLgameFileResponse = (QQGameIntercept$GetLgameFileResponse) obj;
                onGetJointRegexConfig(qQGameIntercept$GetLgameFileResponse.version.get(), qQGameIntercept$GetLgameFileResponse.file_url.get());
                return;
            }
            return;
        }
        if (WadlProxyConsts.CMD_TRPC_INTERRUPT_GAME_INFO.equals(str)) {
            if (obj instanceof QQGameIntercept$GetLgameInfoResponse) {
                QQGameIntercept$GetLgameInfoResponse qQGameIntercept$GetLgameInfoResponse = (QQGameIntercept$GetLgameInfoResponse) obj;
                onGetJointGameInfo(intent.getExtras().getString(WadlProxyConsts.KEY_JUMP_URL), qQGameIntercept$GetLgameInfoResponse.match.get(), qQGameIntercept$GetLgameInfoResponse.game.get());
            }
            resetCountDownLatch("onTrpcRsp");
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements DownloaderTaskListener {
        a() {
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
        public void onTaskCompletedSubloop(DownloaderTask downloaderTask) {
            QQGameInterruptServiceImpl.this.loadConfigByJointRegex("downloadComplete");
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
        public void onTaskDetectedSubloop(DownloaderTask downloaderTask) {
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
        public void onTaskFailedSubloop(DownloaderTask downloaderTask) {
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
        public void onTaskPausedSubloop(DownloaderTask downloaderTask) {
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
        public void onTaskReceivedSubloop(DownloaderTask downloaderTask) {
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
        public void onTaskStartedSubloop(DownloaderTask downloaderTask) {
        }
    }
}
